package kr.or.ddit.basic.req_resp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Request객체 관련 예제
@WebServlet("/RequestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// POST방식으로 받은 데이터의 인코딩방식 설정
		request.setCharacterEncoding("utf-8");

		// getParameter("파라미터 명"): 해당 파라미터에 설정된 name속성값을 가져온다.
		// 가져온 값의 자료형은 무조건 'String'형이다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");

		// getParameterValues("파라미터명"): 파라미터명이 같은 것이 여러개 있을 경우에 사용
		// 가져온 값의 자료형은 무조건 'String[]'형이다.
		// getParameterValues()를 이용해서 hobby로 설정된 checkbox의 값들을 모두 읽어오기
		String[] hobby = request.getParameterValues("hobby");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");

		out.println("<h2>request 테스트 결과 -1</h2>");
		out.println("<hr>");
		out.println("<table border = '1'>");
		out.println("<tr><td>이름</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>직업</td>");
		out.println("<td>" + job + "</td></tr>");
		out.println("<tr><td>취미</td><td>");
		for (String a : hobby) {
			out.println(a + "<br>");
		}
		out.println("</td><tr>");
		out.println("</table>");
		out.println("<hr>");
		out.println("<h2>request 테스트 결과 -2</h2>");
		out.println("<ul>");
		out.println("<li>클라이언트 IP주소: " + request.getRemoteAddr() + "</li>");
		out.println("<li>요청메서드 : " + request.getMethod() + "</li>");
		out.println("<li>ContextPath : " + request.getContextPath() + "</li>");
		out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
		out.println("<li>URL 정보" + request.getRequestURL() + "</li>");
		out.println("<li>URI 정보" + request.getRequestURI() + "</li>");
		out.println("</ol>");
		out.println("<hr>");

		// getParameterNames() 전송된 모든 파라미터명을 Enumeration<String>객체에 담아서 반환한다.
		Enumeration<String> params = request.getParameterNames();
		out.println("<h2> request 테스트 결과- getParameterNames()메서드</h2>");
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			out.println(name + "<br>");
		}
		out.println("<hr>");

		// getParameterMap():전송된 모든 파라미터를 Map객체에 담아서 반환한다.
		// 이 Map객체의 Key값 :'파라미터명' 자료형은 'String',
		// value값은 파라미터에 저장된 '값'의 자료형은 'String[]'이다.
		out.println("<h2>request 테스트 결과 getParameterMap()</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>파라미터 name</td>");
		out.println("<td>파라미터 value</td></tr>");

		Map<String, String[]> paramMap = request.getParameterMap();
		Iterator<String> it = paramMap.keySet().iterator();
		while (it.hasNext()) {
			String paramName = it.next();
			out.println("<tr><td>" + paramName + "</td>");
			out.println("<td>");

			// 파라미터 값 구하기
			String[] paramValue = paramMap.get(paramName);
			if (paramValue == null || paramValue.length == 0) {
				continue;
			} else if (paramValue.length == 1) {
				// 파라미터가 배열이 아닌 경우
				out.println(paramValue[0]);
			} else {
				for (String value : paramValue) {
					out.println(value + "<br>");
				}
			}
			out.println("</td></tr>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
