package kr.or.ddit.basic;
//jdbcTest 프로젝트에 있는 'JdbcTest06.java'의 처리방법을 ibatis로 변경

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapUtil;

//쿼리문이 저장될 xml문서 이름은 'jdbc06.xml'로 한다.

public class JdbcTest06ToIbatis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SqlMapClient smc = null;
		try {
//			Charset charset = Charset.forName("UTF-8");
//			Resources.setCharset(charset);
//
//			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
//
//			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//
//			rd.close(); //finally로 잡는 편
			smc = SqlMapUtil.getSqlMapClient();

			String lprodGu = "";
			while (true) {
				System.out.println("추가할 분류번호(P)");
				lprodGu = sc.next();

				int cnt = (int) smc.queryForObject("jdbclprod.getLprod", lprodGu);
				if (cnt == 0)
					break;
				else
					System.out.println("이미 존재하는 분류번호 입니다.");
			}

			int max = (int) smc.queryForObject("jdbclprod.getmaxId");
			System.out.println("lprod_nm 입력 : ");
			String lprodNm = sc.next();

			LprodVO lvo = new LprodVO();
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_id(max);
			lvo.setLprod_nm(lprodNm);

			Object obj = smc.insert("jdbclprod.insertLprod", lvo);
			if (obj == null) {
				System.out.println("insert 작업 성공");

			} else {
				System.out.println("insert 작업 실패");
			}
			System.out.println("insert 작업 끝");
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (IOException e) {
//		} finally {
//			if(rd!=null) try {
//				rd.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}
	}

}
