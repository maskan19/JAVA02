package kr.or.ddit.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 서블릿 필터
 * 1. 사용 목적
 * - 클라이언트의 요청을 수행하기 전에 작업을 가로채 필요한 작업을 수행할 수 있다.
 * - 클라이언트에 대한 응답 정보를 제공하기 전에 응답 정보에 필요한 작업을 수행할 수 있다.
 * 
 * 2. 사용 예
 * - 인증 작업용 필터
 * - 데이터 압축용 필터
 * - 인코딩 용 필터
 * - 로킹 작업용 필터
 * - 이미지 변환 작업용 필터 등
 */

//필터 class는 javax.servlet.Filter인터페이스를 구현해서 작성해야한다.
//작성된 필터는 web.xml에 등록해서 작동
public class FilterTest01 implements Filter {

	//1. 필터 초기화 작업
	//웹 서버가 실행될 떄 필터들을 한번만 생성하고 자동으로 호출되는 메서드(주로 초기화 작업을 수행한다.)
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init() 호출 1번 필터");
	}
	//2. 필터에서 실제 처리할 내용을 기술하는 메서드
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// chain.doFilter()메서드 앞쪽에 구현하는 내용은 요청에 관련된 작업을 구현한다.
		System.out.println("doFilter 호출 전 1번 필터");
		
		chain.doFilter(request, response);//** 다음 Filter로 chaining하는 메서드
		// chain.doFilter()메서드 뒤쪽에 구현하는 내용은 응답에 관련된 작업을 구현한다.
		System.out.println("doFilter 호출 후 1번 필터");
		
		
	}
	//3. 필터 객체가 삭제될 때 자동으로 호출되는 메서드
	// 주로 자원 해제(반납) 기능을 구현한다.
	@Override
	public void destroy() {
		System.out.println("destroy() 호출 1번 필터");
	}
	
}
