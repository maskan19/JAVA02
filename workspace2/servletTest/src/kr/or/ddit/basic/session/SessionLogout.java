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
 * Servlet implementation class SessionLogoutServlet
 */
@WebServlet("/sessionLogout.do")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session삭제하기
		// 1. Session객체 생성
		HttpSession session = request.getSession();

		// 2. removeAttribute()메서드로 Session값 삭제하기
		// 형식)session객체.removeAttribute("key값");
		// 세션 자체는 삭제되지 않고, 지정한 'key값'과 짝이되는 세션값만 삭제된다.
//		session.removeAttribute("age");
//		session.removeAttribute("userName");
//		session.removeAttribute("testSession");

		// 3. invalidate()메서드로 Session삭제하기
		// 형식)session객체.invalidate();
		// 세션 자체가 삭제된다.
		session.invalidate();


		response.sendRedirect(request.getContextPath() + "/basic/03/sessionLogin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
