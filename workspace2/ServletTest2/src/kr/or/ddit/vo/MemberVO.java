package kr.or.ddit.vo;

/*
 * DB테이블에 있는 컬럼을 기준으로 데이터를 객체화 할 클래스.
 * DB테이블의 '컬럼명'이 이 클래스의 '멤버변수'가 된다.
 * 
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 */

public class MemberVO {
	private int mem_totalrpt;
	private String mem_disdate;
	private int mem_dismember;
	private int mem_mile;
	private String mem_gen;
	private int mem_bir;
	private int mem_grade;
	private String mem_icon;
	private String mem_name;
	private String mem_ali;
	private String joindate;
	private String mem_pass;
	private String mem_id;
	
	public int getMem_totalrpt() {
		return mem_totalrpt;
	}
	public void setMem_totalrpt(int mem_totalrpt) {
		this.mem_totalrpt = mem_totalrpt;
	}
	public String getMem_disdate() {
		return mem_disdate;
	}
	public void setMem_disdate(String mem_disdate) {
		this.mem_disdate = mem_disdate;
	}
	public int getMem_dismember() {
		return mem_dismember;
	}
	public void setMem_dismember(int mem_dismember) {
		this.mem_dismember = mem_dismember;
	}
	public int getMem_mile() {
		return mem_mile;
	}
	public void setMem_mile(int mem_mile) {
		this.mem_mile = mem_mile;
	}
	public String getMem_gen() {
		return mem_gen;
	}
	public void setMem_gen(String mem_gen) {
		this.mem_gen = mem_gen;
	}
	public int getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(int mem_bir) {
		this.mem_bir = mem_bir;
	}
	public int getMem_grade() {
		return mem_grade;
	}
	public void setMem_grade(int mem_grade) {
		this.mem_grade = mem_grade;
	}
	public String getMem_icon() {
		return mem_icon;
	}
	public void setMem_icon(String mem_icon) {
		this.mem_icon = mem_icon;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_ali() {
		return mem_ali;
	}
	public void setMem_ali(String mem_ali) {
		this.mem_ali = mem_ali;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
