package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	// iBatis를 이용하여 DB자료를 처리하는 방법 및 순서

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. iBatis의 환경 설정 파일(sqlMapConfig.xml)을 읽어와서 실행하기
		try {
			// 1-1. 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			// 1-2. 환경 설정 파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");

			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경 설정을 진행한 후
			// SQL문을 호출해서 실행할 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();

			// ---------------------준비작업--------------------------

//			// 2. 실행할 SQL문에 맞는 문장을 찾아서 호출하여 실행한다.
//
//			// 2-1. insert작업
//			System.out.println("insert작업 시작");
//			System.out.println("lprod_id 입력 : ");
//			int lprodId = sc.nextInt();
//			System.out.println("lprod_gu 입력 : ");
//			String lprodGu = sc.next();
//			System.out.println("lprod_nm 입력 : ");
//			String lprodNm = sc.next();
//
//			LprodVO lvo = new LprodVO();
//			lvo.setLprod_gu(lprodGu);
//			lvo.setLprod_id(lprodId);
//			lvo.setLprod_nm(lprodNm);
//
//			// sqlMapClient 객체 변수를 이용하여 처리할 쿼리문을 호출하여 수행한다.
//			// 형식) smc.insert("namespace값.id속성값", 파라미터 클래스);
//			// 반환값) insert 성공 > null, insert 실패 > 오류 객체
//			Object obj = smc.insert("lprod.insertLprod", lvo);
//			if (obj == null) {
//				System.out.println("insert 작업 성공");
//
//			} else {
//				System.out.println("insert 작업 실패");
//			}
//			System.out.println("insert 작업 끝");
//
//			// 2-2. update작업
//			System.out.println("update작업 시작");
//			System.out.println("수정할 lprod_gu 입력 : ");
//			String lprodGu = sc.next();
//			lprodGu = (lprodGu + "   ").substring(0, 4); // CHAR(4)이므로 공백을 포함할 수 있음
//
//			System.out.println("수정할 lprod_id 입력 : ");
//			int lprodId = sc.nextInt();
//
//			System.out.println("수정할 lprod_nm 입력 : ");
//			String lprodNm = sc.next();
//
//			LprodVO lvo2 = new LprodVO();
//			lvo2.setLprod_gu(lprodGu);
//			lvo2.setLprod_id(lprodId);
//			lvo2.setLprod_nm(lprodNm);
//			// 형식) smc.update("namespace값.id속성값", 파라미터 클래스);
//			// 반환값) 성공한 레코드수
//			int cnt = smc.update("lprod.updateLprod", lvo2);
//			if (cnt > 0) {
//				System.out.println("update 작업 성공");
//			} else {
//				System.out.println("update 작업 실패");
//			}
//			System.out.println("update 작업 끝");
//
//			// 2-3. delete 작업
//			System.out.println("delete 작업 시작");
//			System.out.println("삭제할 lprod_gu 입력: ");
//			String lprodGu = sc.next();
//			lprodGu = (lprodGu + "    ").substring(0, 4);
//			// 형식) smc.delete("namespace값.id속성값", 파라미터 클래스);
//			// 반환값) 작업에 성공한 레코드 수
//			int cnt = smc.delete("lprod.deleteLprod", lprodGu);
//			if (cnt > 0) {
//				System.out.println("update 작업 성공");
//			} else {
//				System.out.println("update 작업 실패");
//			}
//			System.out.println("delete 작업 끝");
//
//			// 2-4 select 작업
//			// 1) select 결과가 여러개인 경우
//			System.out.println("select 작업 시작");
//
//			// 응답 결과가 여러개일 경우에는 queryForList()메서드를 사용한다.
//			// queryForList()메서드는 resultClass에서 지정한 클래스에 담은 후 List에 추가한다.
//
//			// 형식)smc.quertForList("namespace값.id속성값", 파라미터)
//			List<LprodVO> lprodList = smc.queryForList("lprod.getAllprod");
//			for (LprodVO lvo : lprodList) {
//				System.out.println("ID: " + lvo.getLprod_id());
//				System.out.println("GU: " + lvo.getLprod_gu());
//				System.out.println("NM: " + lvo.getLprod_nm());
//				System.out.println("--------------------------");
//			}
//			System.out.println("select 출력 완료");

			// 2) select 결과가 한개인 경우
			System.out.println("select 작업 시작");
			System.out.println("검색할 lprod_gu 입력 : ");
			String lprodGu = sc.next();
			lprodGu = (lprodGu + "   ").substring(0, 4);

			// select한 결과가 1개의 레코드일 경우에는 queryForObject()메서드를 사용한다.
			// 형식) smc.queryForObject("namespace값.id속성값", 파라미터)
			LprodVO lprodVo = (LprodVO) smc.queryForObject("lprod.getLprod", lprodGu);
			// Object클래스 이므로 형변환 필요

			if (lprodVo == null) {
				System.out.println("검색 결과 : 데이터 없음");
				return;//메소드를 종료하고 호출 장소로 귀환
			}
			System.out.println("검색결과 : ");
			System.out.println("ID: " + lprodVo.getLprod_id());
			System.out.println("GU: " + lprodVo.getLprod_gu());
			System.out.println("NM: " + lprodVo.getLprod_nm());
			System.out.println("select 출력 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
