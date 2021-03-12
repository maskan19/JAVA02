package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

/*
 - 회원을 관리하는 프로그램을 작성하시오.
 (오라클 DB의 MYMEMBER 테이블 이용)

 - 아래 메뉴의 기능을 모두 구현하시오(CRUD 구현하기 연습)
 create read update delete

 - 작업선택 - 
 1. 자료추가
 2. 자료 삭제
 3. 자료 수정
 4. 전체 자료 출력
 0. 작업 끝
 ------------
 작업선택>>

 */
public class MemberController {

	Scanner s = new Scanner(System.in);
	MemberServiceImpl service = MemberServiceImpl.getInstance();

	public static void main(String[] args) {
		// Controller는 Service 객체를 사용하기 떄문에Service변수가 필요하다.
		MemberController mc = new MemberController();

		mc.start();
	}

	void start() {
		while (true) {
			System.out.println(" - 작업선택 - ");
			System.out.println(" 1. 자료추가");
			System.out.println(" 2. 자료 삭제");
			System.out.println(" 3. 자료 수정");
			System.out.println(" 4. 전체 자료 출력");
			System.out.println(" 5. 선택 수정");
			System.out.println(" 0. 작업 끝");
			System.out.println(" ------------");
			System.out.print(" 작업선택>>");
			String input = s.next();
			switch (input) {

			case "1":
				create();
				break;
			case "2":
				delete();
				break;
			case "3":
				update();
				break;
			case "4":
				read();
				break;
			case "5":
				updatePart();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}

		}
	}

	private void updatePart() {
		String mem_id = "";
		do {
			System.out.println("수정할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		String sql = "Update mymember Set ";
		System.out.println("수정할 항목을 고르세요.");
		System.out.println("1. 회원 이름");
		System.out.println("2. 회원 전화번호");
		System.out.println("3. 회원 주소");
		String input = s.next();
		String q = "";
		String updateField = "";
		switch (input) {
		case "1":
			updateField = "mem_name";
			q = "회원 이름을";
			break;
		case "2":
			updateField = "mem_tel";
			q = "회원 전화번호를";
			break;
		case "3":
			updateField = "mem_addr";
			q = "회원 주소를";
			break;
		}
		//
		// if (input.equals("1")) {
		// updateField = "mem_name";
		// q = "회원 이름을";
		// }
		// if (input.equals("2")) {
		// updateField = "mem_tel";
		// q = "회원 전화번호를";
		// }
		// if (input.equals("3")) {
		// updateField = "mem_addr";
		// q = "회원 주소를";
		// }
		
		System.out.println("수정할 " + q + "입력하세요");
		s.nextLine();
		String ins = s.nextLine();

		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("memid", mem_id);
		paramMap.put("field", updateField);
		paramMap.put("data", ins);

		int cnt = service.updatePartMember(paramMap);

		if (cnt == 1)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.out.println("수정에 실패했습니다.");
	}

	private void create() {
		String mem_id = "";
		do {
			System.out.println("추가할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (service.getMemberCount(mem_id) > 0)
				System.out.println("이미 존재하는 회원입니다.");
		} while (service.getMemberCount(mem_id) != 0);

		System.out.println("추가할 회원 이름을  입력하세요");
		String mem_name = s.next();
		System.out.println("추가할 회원 전화번호를  입력하세요");
		String mem_tel = s.next();
		s.nextLine();
		System.out.println("추가할 회원 주소를  입력하세요");
		String mem_addr = s.nextLine();

		MemberVO memVo = new MemberVO();
		memVo.setMem_id(mem_id);
		memVo.setMem_name(mem_name);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_addr(mem_addr);

		int cnt = service.insertMember(memVo);

		if (cnt == 1)
			System.out.println("정상적으로 추가되었습니다.");
		else
			System.out.println("추가에 실패했습니다.");
	}

	private void read() {
		if (service.getAllMember() == null /* 오류가 난 경우 */
				| service.getAllMember().size() == 0 /* 데이터가 없는 경우 */) {
			System.out.println("등록된 회원이 없습니다.");
		} else {

			System.out.println("===============전체 멤버 목록=============");
			System.out.println("ID\tNAME\tTEL\t\tADDRESS");

			for (MemberVO mem : service.getAllMember()) {
				System.out.print(mem.getMem_id() + "\t" + mem.getMem_name()
						+ "\t" + mem.getMem_tel() + "\t" + mem.getMem_addr()
						+ "\n");
			}
			System.out.println("======================================");

		}
	}

	private void update() {
		String mem_id = "";
		do {
			System.out.println("수정할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		System.out.println("수정할 회원 이름을  입력하세요");
		String mem_name = s.next();
		System.out.println("수정할 회원 전화번호를  입력하세요");
		String mem_tel = s.next();
		System.out.println("수정할 회원 주소를  입력하세요");
		String mem_addr = s.next();

		MemberVO mem = new MemberVO();
		mem.setMem_id(mem_id);
		mem.setMem_name(mem_name);
		mem.setMem_tel(mem_tel);
		mem.setMem_addr(mem_addr);

		int cnt = service.updateMember(mem);

		if (cnt == 1)
			System.out.println("정상적으로 수정되었습니다.");
		else
			System.out.println("수정에 실패했습니다.");

	}

	private void delete() {
		String mem_id = "";
		do {
			System.out.println("삭제할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (service.getMemberCount(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (service.getMemberCount(mem_id) != 1);

		int cnt = service.deleteMember(mem_id);
		if (cnt == 1)
			System.out.println("정상적으로 삭제되었습니다.");
		else
			System.out.println("삭제에 실패했습니다.");
	}

}
