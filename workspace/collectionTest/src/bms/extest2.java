package bms;

import java.util.Arrays;
import java.util.Scanner;

public class extest2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		문제1.
//
//		arr배열의 모든값을 더하는 프로그램을 작성하세요
//		int[] arr ={10,20,30,40,50}

		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		System.out.println("문제1 : " + sum);

//		문제2 
//
//		5명의 이름을 입력받아 배열에 저장하는 프로그램을 작성하세요.

		String[] names = new String[5];
		for (int i = 1; i < 6; i++) {
			System.out.print("이름" + i + "입력 : ");
			String name = sc.nextLine();
			names[i - 1] = name;
		}
		System.out.println("문제2 : " + Arrays.toString(names));
		
//		문제3
//
//		int[] score = { 79, 88.91,33,100,55,95}
//		score배열의 최대값, 최소값구하기 
		int[] score = { 79, (int) 88.91, 33, 100, 55, 95 };
		int max = score[0];
		int min = score[0];
		for (int i = 1; i < score.length; i++) {
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("문제3\n최대값 : " + max + " / 최소값 : " + min);

//		문제4
//
//		2차원 배열 arr2에 담긴 모든값의 총합과 평균을 구하는 프로그램을 작성하세요
//
//		int[][] arr2 = {
//		    {5,5,5,5,5},
//		    {10,10,10,10,10},
//		    {20,20,20,20,20},
//		    {30,30,30,30,30}
//		 };
		sum = 0;
		int avg = 0;
		int[][] arr2 = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 },
				{ 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		for (int j = 0; j < arr2.length; j++) {
			for (int i : arr2[j]) {
				sum += i;
			}
		}
		avg = sum / (arr2.length * arr2[0].length);
		System.out.println("문제4\n총합 : " + sum + " / 평균 : " + avg);

//		문제5
//
//		int[] answer= {};
//		int[] counter = new int[4];
//
//		answer 배열의 각 숫자의 갯수를 세어 count배열에 넣고   ?
//		count배열의 각숫자만큼씩 *를 출력한다   ?

		int[] answer = { 1, 3, 2, 4, 1, 2, 1, 3, 2 };
		int[] counter = new int[4];
		System.out.println("문제5 : ");
		for (int i = 0; i < counter.length; i++) {
			counter[i] = 0;
			for (int count : answer) {
				if (count == i + 1) {
					counter[i]++;
					System.out.print("*");
				}
			}
			System.out.println();
		}

//		문제6
//
//		String menu[] ={ "아메리카노 3000원", "카푸치노 4000원", "카페라떼 3500원"}
//		menu배열에서 메뉴이름과 가격중 메뉴이름을 추출하는 프로그램을 작성하세요.
		String menu[] ={ "아메리카노 3000원", "카푸치노 4000원", "카페라떼 3500원"};
		System.out.print("문제6 : ");
		for(int i = 0; i<menu.length; i++){
			String[] menuName = menu[i].split(" "); 
			System.out.print(menuName[0]+"\t");
		}
		System.out.println();

//		문제7.
//		 
//		String str="i Love Java";
//		str변수에서 Java의 위치를 찾아 출력하는 프로그램을 작성하세요,
		String str="i Love Java";
		System.out.println("문제7 : " + str.indexOf("Java"));

//		문제8
//
//		String  s="java.lang.Object"
//		s변수에서 lang문자열을 추출하는 프로그램을 작성하세요 
		String s ="java.lang.Object";
		System.out.println("문제8 : " + s.substring(5, 9));

//		문제9
//
//		String animals = "dog,cat,bear";
//		animals변수에서 ,를 기준으로  문자열을  분리해서  3개의 단어로 각각 출력하는
//		 프로그램을 작성하세요
		String animals = "dog,cat,bear";
		String[] animal =  animals.split(",");
		System.out.println("문제9 : " + Arrays.toString(animal));

//		 문제 10
//		String str="java,lang,Object"
//		str문자열에서 ,를 .으로 바꾸어 출력하는 프로그램을 작성하세요.
		str = "java,lang,Object";
		str = str.replaceAll(",", ".");
		System.out.println("문제10 : " + str);
		
	}

}
