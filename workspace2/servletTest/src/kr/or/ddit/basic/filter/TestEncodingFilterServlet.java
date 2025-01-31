package kr.or.ddit.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestEncodingFilter
 */
@WebServlet("/testEncodingFilterServlet.do")
public class TestEncodingFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); 필터에서 실행
		String userName = request.getParameter("username");
		System.out.println("userName = " + userName);
//		response.setCharacterEncoding("utf-8"); 필터에서 실행
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.print("<html><head><metat charset='utf-8'></head>");
		out.print("<body>");
		out.print("<h2>당신의 이름은 "  + userName);
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
