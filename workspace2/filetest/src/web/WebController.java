package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TestController와 유사
		/*
		 * URL > Http://서버이름 또는 IP주소:포트번호/컨텍스트이름/폴더명/문서명
		 * 		 Http://localhost:80/servletTest/member/memberList.ddit
		 * URI > /servletTest/member/memberList.ddit
		 * ContextPath > /servletTest
		 * 
		 * 원하는 요청 URI > /member/memberList.ddit
		 */
		
		// 1. 사용자의 요청 정보 가져오기
		String uri = req.getRequestURI();// 요청 URI
		// 원하는 요청 URI
		uri = uri.substring(req.getContextPath().length()); // /servletTest 이후의 문자열 (ContextPath를 제외한 문자열)

		String viewPage = null;
		IAction action = null;

		action = URIActionMapper.getAction(uri);
		if (action == null) {// 실행할 uri가 없으면 404에러 처리
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {//실행 : 작업처리후 view페이지를 받음
			viewPage = action.process(req, resp);
			System.out.println(viewPage);
			if(viewPage!=null) { 
				if(action.isRedirect()) {
					resp.sendRedirect(req.getContextPath() + viewPage);
				}else {
					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp" + viewPage);
					rd.forward(req, resp);
				}
			}
		}

	}

}
