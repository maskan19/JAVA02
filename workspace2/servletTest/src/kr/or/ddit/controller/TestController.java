package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class TestController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * URL > Http://서버이름 또는 IP주소:포트번호/컨텍스트이름/폴더명/문서명
		 * 		 Http://localhost:80/servletTest/member/memberList.ddit
		 * URI > /servletTest/member/memberList.ddit
		 * ContextPath > /servletTest
		 * 
		 * 원하는 요청 URI > /member/memberList.ddit
		 */
		
		//1. 사용자의 요청 정보 가져오기
		String uri = req.getRequestURI();//요청 URI
		//원하는 요청 URI
		uri = uri.substring(req.getContextPath().length()); //  /servletTest 이후의 문자열 (ContextPath를 제외한 문자열)
		System.out.println("uri = " + uri);
		String viewPage = "";//view페이지가 저장될 변수
		if(uri == null) {
			
		}else if("/member/memberList.ddit".equals(uri)) {
			//회원 전체 리스트
//			System.out.println("회원 목록 출력하기");
			
			//회원 관리용 Service객체 생성
			IMemberService service = MemberServiceImpl.getInstance();
			//회원 전체 목록 가져오기
			List<MemberVO> memList = service.getAllMember();
			//가져온 전체 목록을 request객체에 저장한다.
			req.setAttribute("memList",memList);
			//출력할 view페이지를 정한다.
			viewPage = "/member/memberList.jsp";
					
		}else if("/member/memberView.ddit".equals(uri)) {
			//회원 상세 정보 보기
			System.out.println("회원 상세 보기");
		}else if("...".equals(uri)) {
			
		}else {
			
		}
		
		//설정한 view페이지로 포워딩한다.
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view" + viewPage);
		// rd = /WEB-INF/view/member/memberList.jsp
		rd.forward(req, resp);
		
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
