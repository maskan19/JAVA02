package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMemberService;
import service.MemberServiceImpl;
import vo.MemberVO;
import web.IAction;

public class MemberInsertAction implements IAction {

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true; //아래의 process()메서드의 반환값이 요청 uri일 경우에 true를 반환하여 redirect하도록 한다.
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_pass = request.getParameter("mem_pass");
		String mem_icon = request.getParameter("mem_icon");
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(mem_id);
		memVo.setMem_name(mem_name);
		memVo.setMem_pass(mem_pass);
		memVo.setMem_icon(mem_icon);
		
		IMemberService service = MemberServiceImpl.getInstance();
		service.insertMember(memVo);
		
		return "/memberList.jsp";
	}

}
