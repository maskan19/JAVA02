package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {

	public static void main(String[] args) {

		ArrayList<Member> memList = new ArrayList<>();

		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(10, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));

		System.out.println("정렬 전");
		for (Member mem : memList) {
			System.out.println(mem);
		}

		// Collections.sort(memList); //내부정렬 기준이 없어서 sort할 수 없음
		Collections.sort(memList);// compareTo()를 재정의해서 사용할 수 있음

		System.out.println("정렬 후");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		
		//회원번호의 내림차순으로 정렬하기(외부정렬 기준으로)
		System.out.println("정렬 후");
		Collections.sort(memList, new SortNumDesc());// 콤마 이후가 정렬 기준
		for (Member mem : memList) {
			System.out.println(mem);
		}
	}

}

// Member클래스의 회원이름의 오름차순 정렬이 되도록하는 내부 정렬 기준 구현하기
// > Comparable 인터페이스를 구현한다.

class Member implements Comparable<Member> {
	// Comparable implement해서 compareTo()를 재정의해야 정렬기준을 만들 수 있다
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	private int num;
	private String name;
	private String tel;

	@Override
	public int compareTo(Member mem) { // 현재 데이터를 파라미터 데이터와 비교
		// 회원 이름의 오름차순 정렬 기준 만들기
		
		return this.name.compareTo(mem.getName());
		// 내림차순일 경우
		// return this.name.compareTo(mem.getName()) * -1; //*-1 여부로 내림차순<>오름차순
		
		// 회원 번호 오름차순 정렬 기준 만들기
		
//		if(this.num>mem.getNum()){
//			return +1;
//		}else if(this.num<mem.getNum()){
//			return -1;
//		}else{
//			return 0;
//		}

	}

}

// 회원 번호의 내림차순 정렬이 되도록하는 외부 정렬 기준 클래스 작성하기

class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member mem1, Member mem2) {
		// 회원 번호 오름차순 정렬 기준 만들기
		
//		if (mem1.getNum() > mem2.getNum()) {
//			return -1; // 바꿀 필요가 없다
//		} else if (mem1.getNum() < mem2.getNum()) {
//			return 1; // 바꿔라
//		} else {
//			return 0;
//		}
		
		//Wrapper 클래스를 이용하는 방법 1
		//Wrapper 클래스는 정수 객체
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		//Wrapper 클래스를 이용하는 방법 2
		return Integer.compare(mem1.getNum(), mem2.getNum());
	}
	
}
