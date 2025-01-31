package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionReadServlet
 */
@WebServlet("/sessionReadServlet.do")
public class SessionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		저장된 Session정보 읽어오기 순서
//		1. Session객체 생성
		HttpSession session = request.getSession();
		
//		2. getAttribute()메서드를 이용해서 저장된 session값을 읽어온다. 
//		형식) session객체.getAttribute("key값");
//		반환되는 값은 Object형이기 때문에 형변환이 필요하다.
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		
		out.print("<h2>저장된 Session데이터 확인하기</h2><br><br>");
		out.print("<hr>");
		out.print("<h3>세션데이터 1개씩 확인하기");
		//세션에 저장된 1개의 세션값 가져오기
		String sessionValue = (String) session.getAttribute("testSession");// 없을 경우 null리턴
		
		if(sessionValue ==null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		} else {
			out.println("testSession의 세션값 : " + sessionValue + "<br><br>");
		}
		
		out.println("<hr>");
		out.println("<h3>전체 세션 데이터 확인하기</h3><ol>");
		
		//세션에 저장된 전체 key값들을 가져온다.
		Enumeration<String> sessionKeys = session.getAttributeNames();
		int cnt = 0;
		while(sessionKeys.hasMoreElements()) {
			cnt++;
			String key = sessionKeys.nextElement();
			out.println("<li>" + key + " : " + session.getAttribute(key) + "</li>");
			
		}
		
		if(cnt==0) {
			out.println("<li> 세션 데이터가 하나도 없습니다.</li>");
		}
		
		out.println("</ol>");		
		out.println("<hr>");		
		
		//세션 ID : 세션을 구분하기 위한 고유한 값
		out.println("세션 ID : " + session.getId() + "<br>");
		
		//세션생성시간 : 1970년 1월 1일부터 경과한 시간(밀리세컨드 범위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
		
		//가장 최근 접근 시간 : 1970년 1월 1일부터 경과한 시간(밀리세컨드 범위)
		out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
		
		//세션 유효시간 : 초단위
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		out.println("<hr>");
		out.println("<a href='" + request.getContextPath() + "/basic/03/sessionTest.jsp'>시작문서로 이동하기</a>");
		out.print("</body></html>");

		//세션 유효 시간 설정 방법
		//방법1)session객체.setMaxInactiveInterval(초단위시간);
		//session.setMaxInactiveInterval(초단위시간);
		//방법2)web.xml에 설정하기
		//<session-config>
		//	<session-timeout>분단위값</session-timeout>
		//</session-config>
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
