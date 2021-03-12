package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "JJS0911", "java");
			System.out.println("계좌정보 추가하기");
			System.out.println("계좌 번호 : ");
			String bankNo = scan.next();

			System.out.println("은행명 : ");
			String bankName = scan.next();

			System.out.println("예금주명 : ");
			String userName = scan.next();

			// //Statement객체 이용
			// String sql =
			// "insert into bankinfo(bank_no, bank_name, bank_user, bank_date) "
			// + "values('" + bankNo +"','" + bankName + "','" + userName +
			// "', sysdate)";
			//
			// System.out.println(sql);
			//
			// stmt = conn.createStatement();
			// //SQL문이 select문일 때 실행은 executeQuery()메서드를 사용하고
			// //SQL문이 insert, update, delete등과 같이 select문이 아닐 경우에는
			// executeUpdate()메서드를 사용하여 실행한다.
			// //executeUpdate()메서드의 반환값은 작업에 성공한 레코드 수 이다.
			//
			// int cnt = stmt.executeUpdate(sql);
			// System.out.println("반환값" + cnt);

			// PreparedStatement객체 이용하기

			// SQL문을 작성할 때 SQL문에 데이터가 들어갈 자리는 물음표로 표시해서 작성한다.
			String sql = "insert into bankinfo(bank_no, bank_name, bank_user, bank_date) values(?,?,?,sysdate)";

			// PreparedStatement객체 생성하기 : 실행할 SQL문을 인수값으로 지정하여 생성한다. string이 이미
			// 설정되어있어서 속도가 빠름
			pstmt = conn.prepareStatement(sql); // 만들때 sql이 이미 들어감

			// SQL문의 물음표 자리에 들어갈 데이터를 세팅한다.
			// 형식 )pstmt.set자료형이름(물음표번호, 데이터);
			// 물음표 번호는 1부터 시작

			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, userName);

			// 데이터 세팅이 완료되면 SQL문을 실행한다.
			int cnt = pstmt.executeUpdate(); // ()안에 sql이 들어가지 않음.

		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
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
