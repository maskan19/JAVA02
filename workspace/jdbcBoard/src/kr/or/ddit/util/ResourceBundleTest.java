package kr.or.ddit.util;

import java.util.ResourceBundle;

//ResourceBundle 객체 : 파일의 확장자가 properties인 파일의 내용을 읽어와
//key값과 value값을 분리하여 분리된 정보를 갖고 있는 객체
//
//읽어올 파일의 확장자는 반드시 properties여야하고
//파일의 내용은 key값=value값'형태로 되어 있어야 한다.

public class ResourceBundleTest {

	public static void main(String[] args) {
		// ResourceBundle객체를 이용하여 파일 내용 읽어오기

		// ResourceBundle객체 생성하기
		// 파일은 항상 properties여야하므로 파일명만 기입
		ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
		ResourceBundle bundle2 = ResourceBundle.getBundle("kr/or/ddit/util/dbinfo2");

		// 읽어온 파일 내용 출력하기
		System.out.println("driver" + bundle.getString("driver"));
		System.out.println("url : " + bundle.getString("url"));
		System.out.println("user : " + bundle.getString("user"));
		System.out.println("pass : " + bundle.getString("pass"));

	}
}
