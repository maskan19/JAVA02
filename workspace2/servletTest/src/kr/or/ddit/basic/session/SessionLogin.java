package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");

//		Session 저장하는 순서
//		1. Session객체 생성하기
//		형식1) request객체.getSession(); 또는 request객체.getSession(true);
//		현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성해서 반환한다.
//		형식2) request객체.getSession(false);
//		현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 null을 반환한다.
		HttpSession session = request.getSession();

//		2. setAttribute()메서드로 Session값을 저장한다.
//		형식)session객체.setAttribute("key값", session값);
//		"key값"은 문자열, session값은 모든 종류의 데이터를 모두 사용할 수 있다.

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 로그인 성공 여부 검사하기(성공 id: test, password: 1234)
		if (id != null && pass != null) {// 해당 변수의 null값 여부 검사
			if (id.equals("admin") && pass.equals("1234")) {
				// 로그인 성공시 sessionLogin.jsp로 이동
				session.setAttribute("ID", id);
				session.setAttribute("PASS", pass);
				response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
			} else {
				// 로그인 실패시 sessionLogin.jsp
				response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
