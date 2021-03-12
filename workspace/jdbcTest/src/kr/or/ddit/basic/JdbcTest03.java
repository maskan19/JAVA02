package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//문제2) lprod_id값을 2개 입력 받아 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.

public class JdbcTest03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "JJS0911", "java");
			String min = JOptionPane.showInputDialog("LPROD ID의 최소값");
			String max = JOptionPane.showInputDialog("LPROD ID의 최대값");

			String sql = "select * from lprod where lprod_id >= " + min
					+ " and lprod_id <= " + max;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out
					.println("Lprod_id가 " + min + "보다 크고 " + max + "보다 작은 항목");

			while (rs.next()) {
				System.out.println("Lprod_id : " + rs.getInt(1));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString(3));
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
