package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

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
public class JdbcTest07 {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		PreparedStatement ps = null;
		Connection cn = DBUtil3.getConnection();
		JdbcTest07 jt = new JdbcTest07();

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
				jt.create();
				break;
			case "2":
				jt.delete();
				break;
			case "3":
				jt.update();
				break;
			case "4":
				jt.read();
				break;
			case "5":
				jt.update2();
				break;
			case "0":
				System.exit(0);
				break;
			}

		}
	}

	private void update2() {
		Connection cn = null;
		PreparedStatement ps = null;
		String mem_id = "";
		do {
			System.out.println("수정할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (isThere(mem_id) != 1)
				System.out.println("존재하지 않는 회원 id입니다.");
		} while (isThere(mem_id) != 1);
		
		String sql = "Update mymember Set ";
		System.out.println("수정할 항목을 고르세요.");
		System.out.println("1. 회원 이름");
		System.out.println("2. 회원 전화번호");
		System.out.println("3. 회원 주소");
		String input = s.next();
		String q = "";
		if (input.equals("1")) {
			sql += "mem_name = ?";
			q = "회원 이름을";
		}
		if (input.equals("2")) {
			sql += "mem_tel = ?";
			q = "회원 전화번호를";
		}
		if (input.equals("3")) {
			sql += "mem_addr = ?";
			q = "회원 주소를";
		}
		sql += "  where mem_id = ?";
		System.out.println("수정할 " + q + "입력하세요");
		String a = s.next();

		try {
			cn = DBUtil.getConnection();
			ps = cn.prepareStatement(sql);

			ps.setString(1, a);
			ps.setString(2, mem_id);
			int cnt = ps.executeUpdate();

			if (cnt == 1)
				System.out.println("정상적으로 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
	}

	private void create() {
		Connection cn = null;
		PreparedStatement ps = null;
		String mem_id = "";
		do {
			System.out.println("추가할 회원 아이디를 입력하세요");
			mem_id = s.next();
			if (isThere(mem_id) > 0)
				System.out.println("이미 존재하는 회원입니다.");
		} while (isThere(mem_id) != 0);

		System.out.println("추가할 회원 이름을  입력하세요");
		String mem_name = s.next();
		System.out.println("추가할 회원 전화번호를  입력하세요");
		String mem_tel = s.next();
		s.nextLine();
		System.out.println("추가할 회원 주소를  입력하세요");
		String mem_addr = s.nextLine();

		try {
			String sql = "insert into mymember values (?,?,?,?)";
			cn = DBUtil.getConnection();
			ps = cn.prepareStatement(sql);
			ps.setString(1, mem_id);
			ps.setString(2, mem_name);
			ps.setString(3, mem_tel);
			ps.setString(4, mem_addr);
			int cnt = ps.executeUpdate();

			if (cnt == 1)
				System.out.println("정상적으로 추가되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			;
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
			;
		}
	}

	private void read() {
		Connection cn =null;
		ResultSet rs = null;
		Statement st = null;
		try {
			String sql = "select * from mymember";
			cn = DBUtil2.getConnection();
			st = cn.createStatement();
			rs = st.executeQuery(sql);

			System.out.println("전체 멤버 목록");
			System.out.println("ID\tNAME\tTEL\t\tADDRESS");
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
	}

	private void update() {
		Connection cn = null;
		PreparedStatement ps = null;
		try {
			String sql = "Update mymember Set mem_name = ?, mem_tel = ?, mem_addr = ?   where mem_id = ?";
			cn = DBUtil.getConnection();
			ps = cn.prepareStatement(sql);
			String mem_id = "";
			do {
				System.out.println("수정할 회원 아이디를 입력하세요");
				mem_id = s.next();
				if (isThere(mem_id) != 1)
					System.out.println("존재하지 않는 회원 id입니다.");
			} while (isThere(mem_id) != 1);

			System.out.println("수정할 회원 이름을  입력하세요");
			String mem_name = s.next();
			System.out.println("수정할 회원 전화번호를  입력하세요");
			String mem_tel = s.next();
			System.out.println("수정할 회원 주소를  입력하세요");
			String mem_addr = s.next();

			ps.setString(1, mem_name);
			ps.setString(2, mem_tel);
			ps.setString(3, mem_addr);
			ps.setString(4, mem_id);
			int cnt = ps.executeUpdate();

			if (cnt == 1)
				System.out.println("정상적으로 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e) {
				}
		}
	}

	private void delete() {
		try {
			String sql = "Delete From mymember Where mem_id = ?";
			Connection cn = DBUtil.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			String mem_id = "";
			do {
				System.out.println("삭제할 회원 아이디를 입력하세요");
				mem_id = s.next();
				if (isThere(mem_id) != 1)
					System.out.println("존재하지 않는 회원 id입니다.");
			} while (isThere(mem_id) != 1);

			ps.setString(1, mem_id);
			int cnt = ps.executeUpdate();
			if (cnt == 1)
				System.out.println("정상적으로 수정되었습니다.");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private int isThere(String id) {
//		ResultSet rs = null;
//		Statement st = null;
//		String sql = "select mem_id from mymember where mem_id = '" + id
//				+ "'";
//		boolean check = 0;
//		try {
//			Connection cn = DBUtil.getConnection();
//			st = cn.createStatement();
//			rs = st.executeQuery(sql);
//			check = rs.next();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (rs != null)
//				try {
//					rs.close();
//				} catch (SQLException e2) {
//				}
//		}
//		return check;
//	}
		// //////////////////////////////////////////////
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			cn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("cnt");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e2) {
				}
			if (cn != null)
				try {
					cn.close();
				} catch (SQLException e2) {
				}
		}
		return count;
	}

}
