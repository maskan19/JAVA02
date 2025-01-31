package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//수신용 송신용 패킷 객체 변수 선언
		DatagramPacket inpacket, outpacket;
		
		//수신받을 데이터가 저장될 byte형 배열 선언
		byte[] bMsg = new byte[512];

		try {
			//포트 번호를 지정하지 않고 Socket객체 생성(클라이언트용
			DatagramSocket socket = new DatagramSocket();
			
			//접속할 곳(서버)의 주소 생성
			InetAddress address =  InetAddress.getByName("localhost");
//			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			while(true){
				//전송할 메시지 입력
				System.out.println("보낼 메시지 입력 : ");
				String msg = scan.nextLine();
				

				byte[] sendMsg = msg.getBytes();
				//전송할 패킷 객체 생성
				outpacket = new DatagramPacket(sendMsg, sendMsg.length, address, 8888);
				//전송하기
				socket.send(outpacket);
				
				if("/end".equals(msg)){
					break;
				}
				
				//수신용 패킷 객체 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				//수신하기
				socket.receive(inpacket);
				System.out.println("서버의 응답 데이터 : " + new String(bMsg, 0, inpacket.getLength()));
				System.out.println();
				
			}
			System.out.println("통신 끝");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
