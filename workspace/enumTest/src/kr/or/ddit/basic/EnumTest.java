package kr.or.ddit.basic;

import java.io.ObjectInputStream.GetField;

/*
 * - enum(열거형) : 서로 관련있는 상수들의 집합을 나타낸다.
 * 클래스처럼 보이게 하는 상수
 * 열거형은 클래스처럼 독립된 java파일에 만들 수 있고, 
 * 하나의 java파일에 클래스와 함께 만들 수 있고,
 * 클래스 내부에 내부 클래스처럼 만들 수 있다.
 * 
 * - 열거형의 속성 및 메서드
 * 1) name() : 열거형 상수의 이름을 문자열로 반환한다.
 * 2) ordinal() : 열거형 상수가 정의된 순서값(index값)을 반환한다.(0부터 시작)
 * 3) valueOf("열거형 상수명") : 지정된 열거형에서 '열거형 상수명'과 일치하는 열거형 상수를 반환한다.
 * 4) 열거형 이름.상수명> valueOf()메서드와 기능이 같다.
 * 
 * - 열거형 선언하기
 * 방법1)
 * enum 열거형 이름 {상수명1, 상수명2, ...}
 * 
 * 방법2) : 각각의 상수에 임의의 값을 설정할 수 있는 열거형 만들기
 * enum 열거형 이름{상수형1(값,...), 상수형 2(값,...);}
 * 
 * 값들이 저장될 변수 선언
 * private 자료형 이름 변수명1;
 * private 자료형 이름 변수명2;
 * 
 * 열거형의 생성자를 만든다.
 * 열거형의 생성자는 '열거형 상수'에 '값들'을 세팅하는 역할을 수행한다.
 * (열거형 생성자는 묵시적으로 private이다.)
 * 
 *'변수명'의 개수는 '값들'의 개수와 같고, 
 * 각각의 '값들'의 선언된 변수와 자료형이 같아야 한다. 
 * private 열거형 이름(자료형이름 변수명, ...){
 *  위에 선언된 변수들을 초기화 하는 작업을 수행한다.
 * }
 * 
 * 구성된 '값들'을 외부에서 불러올 수 있도록 getter 메서드를 작성한다.
 * 
 * 
 */

public class EnumTest {

	// 방법1로 열거형 선언하기
	public enum Color {
		RED, GREEN, BLUE
	}

	public enum Count {
		ONE, TWO, THREE
	}
	//방법2로 열거형 선언하기
	public enum Season{
		봄("3월부터 5월까지",3), 
		여름("6월부터 8월까지",6),
		가을("9월부터 11월까지",9),
		겨울("12월부터 2월까지",12);
		
		private String span;
		private int startMonth;
		
		Season(String span, int startMonth){
//			생략해도 private Season(String span, int startMonth){}와 동일
			this.span = span;
			this.startMonth = startMonth;
		}

		public String getSpan() {
			return span;
		}

		public int getStartMonth() {
			return startMonth;
		}

		//getter 메서드만 생성
	
		
	}

	public static void main(String[] args) {

		System.out.println("Red = " + ConstTest.RED);
		System.out.println("Three = " + ConstTest.THREE);

		if (ConstTest.RED == ConstTest.ONE) {
			System.out.println("...");
		} else {
			System.out.println("???");
		}
		
		Color myCol = Color.valueOf("GREEN"); //Color.GREEN과 동일
		Count myCnt = Count.ONE; //Count.valueOf("ONE")과 동일
		
		System.out.println("myCol : " + myCol.name());
		System.out.println("myCnt : " + myCnt.name());
		
		System.out.println("myCol ordinal : " + myCol.ordinal()); //1 인덱스값
		System.out.println("myCnt ordinal : " + myCnt.ordinal()); //0
		
//		if(myCol ==myCnt){ //다른 형의 열거형이므로 비교 불가능
//			
//		}
		
		if(myCol == Color.GREEN){
			System.out.println("같다.");
		}else{
			System.out.println("같지 않다");
		}
		
		switch(myCnt){
		case ONE : 
			System.out.println("상수 ONE");
			break;
		case TWO : 
			System.out.println("상수 TWO");
			break;
		case THREE : 
			System.out.println("상수 THREE");
			break;
		}
		System.out.println("---------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name()); //봄
		System.out.println("ordinal : " + ss.ordinal()); //0
		System.out.println("span : " + ss.span);
		System.out.println("startMonth : " + ss.getStartMonth());

		//열거형명.values()메서드 : 모든 상수들을 배열로 가져온다.
		for(Season time : Season.values()){
			System.out.println(time.name() + "==" + time + //name == 변수 자체 
					" : " + time.getSpan() + time.getStartMonth());
		}
		System.out.println();
		
		for(Color col : Color.values()){
			System.out.println(col + " ==> " + col.ordinal());
		}
		
		
	}

}
