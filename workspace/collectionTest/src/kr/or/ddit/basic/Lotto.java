package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Lotto {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			System.out.print("==========================\n"
					+ "       Lotto 프로그램\n--------------------------\n"
					+ "1. Lotto 구입\n2. 프로그램 종료\n"
					+ "==========================\n메뉴선택 : ");
			String choose = s.next();
			switch (choose) {
			case "1":
				get();
				break;
			case "2":
				System.exit(0);
			}
		}
	}

	static void get() {
		System.out.print("Lotto 구입 시작\n(1000원에 로또번호 하나입니다.)\n금액입력 : ");
		int input = Integer.parseInt(s.next());
		if (input / 1000 > 100) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		} else if (input / 1000 < 1) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		} else
			System.out.println("행운의 로또번호는 아래와 같습니다.");

//		List<List<Integer>> lotto = new ArrayList<>();
//		for (int i = 0; i < input / 1000; i++) {
//			List<Integer> temp = new ArrayList<>(lottery());
//			Collections.sort(temp);
//			lotto.add(temp);
//		}
//		
//		int n = 1;
//		for (List<Integer> i : lotto) {
//			System.out.println("로또번호" + n + " : " + i);
//			n++;
//		}
		
		int n = 1;
		for (int i = 0; i < input / 1000; i++) {
			List<Integer> temp = new ArrayList<>(lottery());
			Collections.sort(temp);
			System.out.print("로또번호" + n + " : ");
			int index = 0;
			for(int j : temp){
				if(index>0){System.out.print(", ");
				}
				System.out.print(j);
				index++;
			}
			System.out.println();
			n++;
		}
		
		
		
		System.out.println("받은 금액은 " + input + "원이고 거스름돈은 " + input % 1000
				+ "원입니다.");
	}

	static HashSet<Integer> lottery() {
		HashSet<Integer> lottery = new HashSet<>();
		while(lottery.size()<6){
			lottery.add((int) (Math.random() * 45) + 1);
		}
		return lottery;
	}

}
