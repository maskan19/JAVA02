package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 LPROD테이블에 새로운 데이터를 추가하시오

 조건) lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
 lprod_id는 현재의 lprod_id중 제일 큰 값보다 1큰 값으로 한다.
 입력받은 lprod_gu가 이미 등록되어있으면 다시 입력받아서 처리한다.
 */

public class JdbcTest06 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Connection cn = null;
		PreparedStatement ps = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			cn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "JJS0911", "java");
			
			cn = DBUtil.getConnection();
			
			
			System.out.println("추가할 분류번호(P)");
			String lprod_gu = s.next();
			System.out.println("추가할 분류명");
			String lprod_nm = s.next();
			while (true) {
				String sql = "insert into lprod select (select max(lprod_id)+1 as max from lprod), ?, ? from dual "
						+ "WHERE NOT EXISTS ( SELECT lprod_id FROM lprod WHERE lprod_gu = ?)";
				ps = cn.prepareStatement(sql);
				ps.setString(1, lprod_gu);
				ps.setString(2, lprod_nm);
				ps.setString(3, lprod_gu);
				int cnt = ps.executeUpdate();
				if (cnt > 0) break;
				else System.out.println("다시 입력하세요");
				System.out.println("추가할 분류번호(P)");
				lprod_gu = s.next();
			}
		} catch (SQLException e) {
			System.out.println("ex");
			e.printStackTrace();
		} finally {
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

		System.out.println("추가되었습니다.");

	}
}
