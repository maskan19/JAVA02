package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	// 클라이언트 시작 메소드
	public void clientStart() {

		Socket socket = null;
		try {
			String serverIp = "192.168.0.118";
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다");
			System.out.println();
			
			//메시지 전송용 쓰레드 생성
			 ClientSender sender = new ClientSender(socket);
			 
			 //메시지 수신용 쓰레드 생성
			 ClientReceiver receiver = new ClientReceiver(socket);
			 
			 sender.start();
			 receiver.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// clientStart()메소드 끝....

	// -------------------------------------------------------
	// 메시지 전송용 쓰레드
	class ClientSender extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		private String name;
		private Scanner scan;

		// 생성자
		public ClientSender(Socket socket) {
			this.socket = socket;
			scan = new Scanner(System.in);

			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				if (dos != null) {
					// 처음 클라이언트 프로그램이 시작하면 자신의 대화명을 입력해서 서버로 전송하고, 대화명 중복 여부를
					// feedback받는다.
					System.out.println("대화명 : ");
					String name = scan.nextLine();
					while (true) {
						dos.writeUTF(name);// 대화명 전송
						// 대화명 중복 여부
						String feedBack = dis.readUTF();
						if ("이름 중복".equals(feedBack)) {// 대화명이 중복될 때
							System.out.println(name + "은 중복된 닉네임입니다.");
							System.out.println("다른 이름을 입력하세요");
							System.out.println("대화명 : ");
							name = scan.nextLine();

						} else {
							this.name = name;
							System.out.println("대화방에 입장했습니다.");
							break;
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		@Override
		public void run() {
			try {
				while (dos != null) {
					dos.writeUTF("[" + name + "]" + scan.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// -------------------------------------------------------
	// 메시지 수신용 쓰레드
	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;

		// 생성자
		public ClientReceiver(Socket socket) {

			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		@Override
		public void run() {
			try {
				while (dis != null) {
					System.out.println(dis.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	// -------------------------------------------------------
	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}

}