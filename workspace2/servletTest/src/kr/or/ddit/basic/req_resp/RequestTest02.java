package kr.or.ddit.basic.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String oop = request.getParameter("oop");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>계산결과</title></head>");
		out.println("<body>");

		out.println("<h2>계산결과</h2>");
		out.print("<hr>");
		double result = 0;
		switch(oop) {
		case "+" :
			result = num1+num2;
			break;
		case "-" :
			result = num1-num2;
			break;
		case "*" :
			result = num1*num2;
			break;
		case "/" :
			result = Math.round((double)num1/num2 *1000)/1000.0;
			break;
		case "%" :
			result = num1%num2;
			break;
		}
		out.println(num1  + oop + num2 + " = "+ result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
