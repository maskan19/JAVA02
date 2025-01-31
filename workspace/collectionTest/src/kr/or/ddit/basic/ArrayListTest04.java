package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//	문제1) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
//	(단, 각 별명의 길이는 모두 다르게 입력한다.)
//	문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있을 경우를 처리하시오. 

public class ArrayListTest04 {

	public static void main(String[] args) {

		List<String> aliases = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			System.out.println("별명" + i + " 입력 :");
			Scanner s = new Scanner(System.in);
			String alias = s.nextLine();
			aliases.add(alias);
		}

		String longest = "";
		for (int i = 0; i < aliases.size(); i++) {
			if (aliases.get(i).length() > longest.length()) {
				longest = aliases.get(i);
			} else if (aliases.get(i).length() == longest.length()) {
				for (int a = 0; a < aliases.get(i).length(); a++) {
					if (aliases.get(i).charAt(a) < longest.charAt(a)) {
						longest = aliases.get(i);
						break;
					}
				}
			}
		}

		// 사전식으로 가장 먼저 나오는 별명
		System.out.println("제일 긴 별명 : " + longest);

		int maxlength = aliases.get(0).length();
		List<String> longali = new ArrayList<>();
		for (int i = 1; i < aliases.size(); i++) {
			if (aliases.get(i).length() > maxlength) {
				maxlength = aliases.get(i).length();
			}
		}
		for (int i = 0; i < aliases.size(); i++) {
			if (aliases.get(i).length() == maxlength) {
				longali.add(aliases.get(i));
			}
		}
		System.out.println(longali);
		Collections.sort(longali);
		System.out.println(longali);

		////////////////////////////////////////////////////////////////////

		aliases = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			System.out.println("별명" + i + " 입력 :");
			Scanner s = new Scanner(System.in);
			String alias = s.nextLine();
			aliases.add(alias);
		}

		int maxLength = aliases.get(0).length(); // 별명의 길이가 저장될 변수로 초기화

		for (int i = 1; i < aliases.size(); i++) {
			if (aliases.get(i).length() > maxLength) {
				maxLength = aliases.get(i).length();
			}
		}
		System.out.println("제일 긴 별명들 : ");
		for (int i = 0; i < aliases.size(); i++) {
			if (aliases.get(i).length() == maxLength) {
				System.out.println(aliases.get(i));
			}
		} // 길이가 같은 별명 모두 출력

	}
}
