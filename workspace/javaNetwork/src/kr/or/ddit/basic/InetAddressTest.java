package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		
		//www.naver.com의 IP정보 가져오기
		//throws 설정
		
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		
		System.out.println("HostName : " + naverIp.getHostName()); //
		System.out.println("HostAddress : " + naverIp.getHostAddress());
		
		//자신의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("localName : " + localIp.getHostName()); //
		System.out.println("localAddress : " + localIp.getHostAddress()); //
		
		InetAddress[] addrs = InetAddress.getAllByName("www.naver.com");
		for(InetAddress addrIp : addrs){
			System.out.println(addrIp.toString());
		}

	}

}
