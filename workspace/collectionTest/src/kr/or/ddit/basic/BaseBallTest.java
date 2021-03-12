package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//문제 Set과 List를 이용하여 숫자 야구게임 프로그램을 작성하시오. 컴퓨터의 숫자는 난수를 이용하여 구한다.

public class BaseBallTest {

	public static void main(String[] args) {
		HashSet<Integer> ran3 = new HashSet<>();
		while(ran3.size()<3){
			ran3.add((int)(Math.random()*9 +1));
		}
		List<Integer> baseball = new ArrayList<>();
		for(int num : ran3){
			baseball.add(num);
		}
		Collections.shuffle(baseball);
		System.out.println(baseball);
		Scanner s = new Scanner(System.in);
		
		int strike = 0;
		int ball = 0;
		int out = 0;
		while (strike < 3) {
			strike = 0;
			ball = 0;
			out = 0;
			System.out.print("입력 : ");
			String input = s.nextLine();
			for (int i = 0; i < input.length(); i++) {
				if (Character.getNumericValue(input.charAt(i)) == baseball
						.get(i)) {
					strike++;
				} else {
					for (int j = 0; j < input.length(); j++) {
						if (Character.getNumericValue(input.charAt(i)) == baseball
								.get(j)) {
							ball++;
						}
					}
				}
			}
			out = 3 - strike - ball;
			System.out.println(strike + "S " + ball + "B " + out + "O");
		}
		System.out.println("홈런");

	}

}
