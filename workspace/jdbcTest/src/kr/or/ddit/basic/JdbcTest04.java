package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

// 문제 ) 사용자로부터 도, 시, 군, 구 중 한가지를 입력받아 DB의 Member테이블에서 
// 회원의 주소에 입력한 값이 포함되는 데이터를 모두 출력하시오.
// 회원ID, 회원이름, 우편번호, 주소1, 주소2
public class JdbcTest04 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "JJS0911", "java");
			String add = JOptionPane.showInputDialog("찾을 주소");

			String sql = "select mem_id, mem_name, mem_zip, mem_add1, mem_add2 from member where mem_add1 like '%"
					+ add + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("=====주소지가 " + add + "인 멤버=====");
			System.out.println("ID\t이름\t우편번호\t주소\t");

			while (rs.next()) {

				System.out.println(rs.getString(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4) + " "
						+ rs.getString(5));
			}

		} catch (Exception e) {
		} finally {
			// 5. 자원반납하기
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e2) {
				}
		}
	}

}
