package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMemberService;
import service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class MemberListAction implements IAction {
	// false면 forward, true면 redirect
	// TestController의 if문 역할

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제 처리할 내용은 이곳에 기술하고 처리가 끝난 후에 보여줄 View페이지를 반환하면 된다.
		IMemberService service = MemberServiceImpl.getInstance();
		List<MemberVO> memList = service.getAllMember();
		System.out.println(memList.size());
		request.setAttribute("memList", memList);
		
		return "/memberList.jsp";
	}

}
