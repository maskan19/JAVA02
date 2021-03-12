package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//문제1) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.

public class JdbcTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "JJS0911", "java");
			String input = JOptionPane.showInputDialog("LPROD ID");

			String sql = "select * from lprod where lprod_id>" + input;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("Lprod_id가 " + input + "보다 큰 항목");
			while (rs.next()) {
				System.out.println("Lprod_id : " + rs.getInt(1));
				System.out.println("Lprod_gu : " + rs.getString(2));
				System.out.println("Lprod_nm : " + rs.getString(3));
			}

		} catch (Exception e) {
		} finally {
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
