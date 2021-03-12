package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.action.MemberListAction;
import kr.or.ddit.web.IAction;

public class TestController2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * MemberListAction을 사용한 경우
		 */

		// 1. 사용자의 요청 정보 가져오기
		String uri = req.getRequestURI();// 요청 URI
		// 원하는 요청 URI
		uri = uri.substring(req.getContextPath().length()); // /servletTest 이후의 문자열 (ContextPath를 제외한 문자열)
		System.out.println("uri = " + uri);
		String viewPage = "";// view페이지가 저장될 변수

		IAction action = null;

		if (uri == null) {

		} else if ("/member/memberList.ddit".equals(uri)) {
			action = new MemberListAction();
			viewPage = action.process(req, resp);

		} else if ("/member/memberView.ddit".equals(uri)) {
			// 회원 상세 정보 보기
			System.out.println("회원 상세 보기");
		} else if ("...".equals(uri)) {

		} else {

		}
		
		//redirect와 forward를 구분
		if (action.isRedirect()) {
			//리다이렉트 한다.
			resp.sendRedirect(req.getContextPath() + viewPage);
		} else {
			// 설정한 view페이지로 포워딩한다.
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view" + viewPage);
			// rd = /WEB-INF/view/member/memberList.jsp
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
