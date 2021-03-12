package kr.or.ddit.mvc.vo;

import java.sql.Date;

/*
 * DB테이블에 있는 컬럼을 기준으로 데이터를 객체화 할 클래스.
 * DB테이블의 '컬럼명'이 이 클래스의 '멤버변수'가 된다.
 * 
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 */

public class BoardVO {
	private int board_no =0;
	private String board_title="";
	private String board_writer="";
	private Date board_date = new Date(1);
	private int board_cnt=0;
	private String board_content="";
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	//만약 생성자를 만들었을 때는 반드시 기본 생성자도 같이 만들어준다.
//	public MemberVO(){
//		
//	};
//	public MemberVO(String mem_id, String mem_name, String mem_tel,
//			String mem_addr) {
//		super();
//		this.mem_id = mem_id;
//		this.mem_name = mem_name;
//		this.mem_tel = mem_tel;
//		this.mem_addr = mem_addr;
//	}
	
	

}
