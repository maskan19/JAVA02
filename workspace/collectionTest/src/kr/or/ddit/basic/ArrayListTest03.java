package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//	문제1) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
//	(단, 각 별명의 길이는 모두 다르게 입력한다.)
//	문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있을 경우를 처리하시오. 

public class ArrayListTest03 {

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
			}
		}
		System.out.println("제일 긴 별명 : " + longest);

		// //////////////////////////////////////////////////////////////////

		aliases = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			System.out.print("별명" + i + " 입력 : ");
			Scanner s = new Scanner(System.in);
			String alias = s.next(); /* s.next() : 띄어쓰기를 허용하지 않음 */
			aliases.add(alias);
		}

		longest = aliases.get(0); /* List의 첫 데이터가 제일 길다로 초기화 */
		for (int i = 1; i < aliases.size(); i++) {
			if (aliases.get(i).length() > longest.length()) {
				longest = aliases.get(i);
			}
		}

		System.out.println("제일 긴 별명 : " + longest);

		/*또는*/
		
		int maxIndex = 0; // 별명의 길이가 제일 긴 데이터의 인덱스

		for (int i = 1; i < aliases.size(); i++) {
			if (aliases.get(i).length() > aliases.get(maxIndex).length()) {
				maxIndex = i;
			}
		}

		System.out.println("제일 긴 별명 : " + aliases.get(maxIndex));

	}
}
