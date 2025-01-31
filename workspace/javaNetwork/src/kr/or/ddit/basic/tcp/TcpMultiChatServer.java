package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {

	// 접속한 클라이언트 정보를 저장할 Map객체 변수 선언
	// key값 : 접속자 이름, value값 : 접속한 socket 객체
	private Map<String, Socket> clientMap;

	public TcpMultiChatServer() {
		// Map객체를 동기화 처리
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}

	// 서버 프로그램의 시작 메서드
	public void serverStart() {

		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			System.out.println();
			while (true) {
				socket = server.accept();// 클라이언트의 접속을 기다린다.
				System.out.println("[" + socket.getInetAddress() + " : "
						+ socket.getPort() + "] 에서 접속했습니다.");
				// 데이터를 받아서 전체에게 전송하는 쓰레드
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(server!=null)
			try {
				server.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}

	// clientMap에 저장된 모든 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		// clientMap의 데이터 개수만큼 반복
		for (String name : clientMap.keySet()) {
			try {
				DataOutputStream dos = new DataOutputStream(clientMap.get(name)
						.getOutputStream());
				dos.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// 서버에서 클라이언트로 메시지를 전송하는 Thread를 inner Class로 작성한다.
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;

		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 수신용 스트림 객체 생성
				dis = new DataInputStream(socket.getInputStream());
				// 송신용 스트림 객체 생성
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// 생성자

		@Override
		public void run() {
			String name = "";
			try {
				while (true) {
					// 클라이언트의 이름 중복 여부를 feedback한다.
					name = dis.readUTF(); // 클라이언트가 보낸 이름 받기
					if (clientMap.containsKey(name)) {
						dos.writeUTF("이름 중복");
					} else {
						dos.writeUTF("OK");
						break;

					}

				}
				// 대화명을 받아서 전체 클라이언트에게 대화방 참여 메시지를 전송한다.
				sendToAll("[" + name + "]님이 들어 오셨습니다.");

				// 대화명과 클라이언트와 연결된 Socket을 Map에 추가한다.
				clientMap.put(name, socket);

				System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");
				System.out.println();

				// 하나의 클라이언트가 보내온 메시지를 받아서 전체 클라이언트들에게 보낸다.
				while (dis != null) {
					sendToAll(dis.readUTF());
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally절이 실행된다는 것은 클라이언트가
				// 접속을 종료했다는 의미가 된다.
				sendToAll("[" + name + "]님이 접속을 종료 했습니다.");

				// 사용자 목록(Map)에서 삭제한다.
				clientMap.remove(name);

				System.out.println("[" + socket.getInetAddress() + " : "
						+ socket.getPort() + "]에서 접속을 종료했습니다.");

				System.out.println("현재 서버 접속자 수 : " + clientMap.size() + "명");
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {

		new TcpMultiChatServer().serverStart();
	}

}
