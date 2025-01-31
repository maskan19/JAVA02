package kr.or.ddit.mvc.controller;

import java.util.Scanner;

import kr.or.ddit.mvc.service.BoardServiceImpl;
import kr.or.ddit.mvc.vo.BoardVO;

/*

 -------------------------------------------------------------
 No	        제 목            작성자 	조회수   
 -------------------------------------------------------------
 4         네번째 게시글        홍길동            0
 3         세번째 게시글        일지매            0
 2         두번째 게시글        홍길동            0
 1         첫번째 게시글        성춘향            0
 -------------------------------------------------------------
 메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝
 작업선택 >>
 */
public class BoardController {

	Scanner s = new Scanner(System.in);
	BoardServiceImpl service = new BoardServiceImpl();

	public static void main(String[] args) {
		// Controller는 Service 객체를 사용하기 떄문에Service변수가 필요하다.
		BoardController bc = new BoardController();

		while(true){
		bc.list();
		}
	}

	void menu() {
		while (true) {
			System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
			String input = s.nextLine();
			switch (input) {
			case "1":
				create();
				break;
			case "2":
				read();
				break;
			case "3":
				search();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}

		}

	}
	
	void postmenu(int boardNo) {
		postmenu : while (true) {
			System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
			String input = s.nextLine();
			switch (input) {
			case "1":
				update(boardNo);
				break postmenu;
			case "2":
				delete(boardNo);
				break postmenu;
			case "3":
				list();
				break postmenu;
			default:
				System.out.println("다시 입력해주세요.");
			}
			
		}
		
	}

	private void search() {
		System.out
				.println("검색 작업\n--------------------------------------------");
		System.out.println("- 검색할 제목 입력 :");
		String board_title = s.nextLine();
		if (service.getBoardSearch(board_title) == null /* 오류가 난 경우 */
				|| service.getBoardSearch(board_title).size() == 0 /*
																	 * 데이터가 없는
																	 * 경우
																	 */) {
			System.out.println("등록된 게시글이 없습니다.");
		} else {

			System.out
					.println("-------------------------------------------------------------");
			System.out.println(" No	        제 목            작성자 	조회수   ");
			System.out
					.println("-------------------------------------------------------------");

			for (BoardVO mem : service.getBoardSearch(board_title)) {
				System.out.print(mem.getBoard_no() + "\t"
						+ mem.getBoard_title() + "\t" + mem.getBoard_writer()
						+ "\t" + mem.getBoard_cnt() + "\n");
			}
			System.out.println("-------------------------------------------------------------");
menu();
		}
		list();
	}

	private void create() {
		System.out.println("새글 작성하기\n-----------------------------------");

		System.out.println("- 제  목 : ");
		String board_title = s.nextLine();
		System.out.println("- 작성자 : ");
		String board_writer = s.nextLine();
		System.out.println("- 내  용 : ");
		String board_content = s.nextLine();

		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_writer(board_writer);
		boardVo.setBoard_content(board_content);
		System.out.println();

		int cnt = service.insertBoard(board_title, board_writer, board_content);

		if (cnt == 1)
			System.out.println("새글이 정상적으로 추가되었습니다.");
		else
			System.out.println("새글 추가에 실패했습니다.");
	}

	private void list() {
		if (service.getAllBoard() == null /* 오류가 난 경우 */
				|| service.getAllBoard().size()==0) {
			System.out.println("등록된 게시글이 없습니다.");
		} else {

			System.out
					.println("-------------------------------------------------------------");
			System.out.println(" No	        제 목            작성자 	조회수   ");
			System.out
					.println("-------------------------------------------------------------");

			for (BoardVO mem : service.getAllBoard()) {
				System.out.print(mem.getBoard_no() + "\t"
						+ mem.getBoard_title() + "\t" + mem.getBoard_writer()
						+ "\t" + mem.getBoard_cnt() + "\n");
			}
			System.out.println("-------------------------------------------------------------");
		}
		menu();
	}

	private void read() {
		System.out.println("보기를 원하는 게시물 번호 입력 >>");
		int boardNo = Integer.parseInt(s.nextLine());
		BoardVO bv = service.read(boardNo);		
		if (bv == null /* 오류가 난 경우 */
				|| bv.getBoard_no()!=boardNo){
			System.out.println("찾는 게시글이 없습니다.");
		} else {

			System.out
					.println(boardNo
							+ "번글 내용\n------------------------------------------------------------");

			System.out.println("- 제  목 : "
					+ bv.getBoard_title());
			System.out.println("- 작성자 : "
					+ bv.getBoard_writer());
			System.out.println("- 내  용 : "
					+ bv.getBoard_content());
			System.out.println("- 작성일 : "
					+ bv.getBoard_date());
			System.out.println("- 조회수 : "
					+ bv.getBoard_cnt());
			System.out
					.println("-------------------------------------------------------------");
			postmenu(boardNo);
		}
	}

	private void update(int boardNo) {
		System.out.println("수정 작업하기\n-----------------------------------");

		System.out.print("- 제  목 : ");
		String board_title = s.nextLine();
		System.out.print("- 내  용 : ");
		String board_content = s.nextLine();

		int cnt = service.updateBoard(board_title, board_content, boardNo);

		if (cnt == 1)
			System.out.println(boardNo + "번 글이 수정되었습니다.");
		else
			System.out.println(boardNo + "번 글 수정에 실패했습니다.");

	}

	private void delete(int boardNo) {

		int cnt = service.deleteBoard(boardNo);
		if (cnt == 1)
			System.out.println(boardNo+"번 글이 정상적으로 삭제되었습니다.");
		else
			System.out.println(boardNo + "번글은 존재하지 않는 게시글입니다.");
	}

}
