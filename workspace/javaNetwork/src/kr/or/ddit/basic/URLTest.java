package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) throws MalformedURLException {
		//URL클래스 : 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 다루는 클래스 
		//http://ddit.or.kr:80/index.html?ttt=123
		
		URL url = new URL("http", "ddit.or.kr", 80, "index.html?ttt=123");
		
		
	}

}
