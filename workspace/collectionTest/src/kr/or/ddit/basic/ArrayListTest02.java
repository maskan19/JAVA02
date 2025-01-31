package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest02 {

	// 문제 ) 5명의 사람 이름을 입력받아서 ArrayList에 저장한 수 이들 중 '김'씨 성을 가진 사람을 모두 출력하시오.
	// (입력은 Scanner 객체를 이용한다.)
	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		System.out.println("김씨 판별기");

		for (int i = 1; i <= 5; i++) {
			System.out.println("이름" + i + "입력 : ");
			String name = s.nextLine();
			names.add(name);
		}

		System.out.println("----판별완료----");
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).substring(0, 1).equals("김")) {
				System.out.println(names.get(i));
			}
		}

		// ////////////////////////////////////////

		ArrayList<String> nameList = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			System.out.println("이름" + i + "입력 : ");
			String name = s.nextLine();
			names.add(name);
		}

		System.out.println("----판별완료----");
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).charAt(0) == '김') {
				System.out.println(names.get(i));
			}
			if (names.get(i).indexOf("김") == 0) { // ✔remark
				System.out.println(names.get(i));
			}
			if (names.get(i).startsWith("김")) { // ✔remark
				System.out.println(names.get(i));
			}
		}
	}
}
