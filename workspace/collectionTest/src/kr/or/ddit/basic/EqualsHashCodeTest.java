package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setId(2);
		p2.setName("일지매");
		
		System.out.println(p1==p2); //false
		
		Person p3 = new Person();
		p3.setId(1);
		p3.setName("홍길동");
		
		System.out.println(p1==p3); //false
		/*주소값으로 비교함*/
		System.out.println(p1.equals(p3)); //false    >equals 재정의 이후 true
		
		Person p4 = p1;
		p4.setId(1);
		p4.setName("홍길동");

		System.out.println(p1.equals(p4)); // true

		Set<Person> testSet = new HashSet<>();
//		testSet.add(p1);
//		testSet.add(p2);

		System.out.println("set의 크기 : " + testSet.size()); // 2
		/* hashcode를 사용해 비교함 */

		System.out.println("p1의 hashcode : " + p1.hashCode());
		System.out.println("p2의 hashcode : " + p2.hashCode());
		System.out.println("p3의 hashcode : " + p3.hashCode());
		System.out.println("p4의 hashcode : " + p4.hashCode());

		// hashcode : 참조값을 사용해 생성 > 참조값이 같으면 같은 코드

		int a = 1;
		String b = "홍길동";

		Person p5 = new Person();
		p5.setId(a);
		p5.setName(b);
		
		Person p6 = p5;
		System.out.println(p6.getId() + p6.getName());
		
		
		p5.setId(3);
		p5.setName("홍길동");
		System.out.println(p5.getId() + p5.getName());
		System.out.println(p6.getId() + p6.getName());
		
		testSet.add(p5);
		testSet.add(p6);
		
		System.out.println("set의 크기 : " + testSet.size());
		
		String a1 = new String("aaaa");
		String a2 = a1;
		a1 = "bbbb";
		/*Heap외에도 저장되는 곳이 있다...*/
		System.out.println(a1 + "," + a2);

		/*
		 * - equals()메서드 > 두 객체의 내용이 같은지 검사하는 메서드
		 * - hashCode()메서드 > 두 객체의 동일성을 검사하는 메서드
		 * 
		 * - HashSet, Hashtable, HashMap과 같은 Hash로 시작하는 컬렉션 객체들은 
		 * 객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출해 비교
		 * 객체가 같은지 여부를 결정하려면 hashCode를 재정의해야한다.
		 * 
		 * - hashCode() 메서드에서 사용하는 '해싱 알고리즘'은 낮은 확률로
		 * 서로 다른 객체들에 대하여 hashcode값이 나타날 수 있다.
		 * 
		 * >> hashcode 동일성과 equals를 동시에 충족해야 같은 객체로 취급
		 */

	}

}


class Person{
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@Override //재정의
//	public boolean equals(Object obj) {
////		return super.equals(obj); //Object에 있는 equals메서드를 실행해라
//		
//		if(obj==null) return false;
//		
//		//같은 유형의 클래스인지 검사
//		if(this.getClass() != obj.getClass()) return false;
//		
//		//참조값이 같은지 검사
//		if(this==obj) {
//			return true;
//		} 
//		
////		매개변수의 값을 현재 객체 유형으로 형변환한다.
//		Person that = (Person)obj;
//		
//		if(this.name==null &&that.name!=null){
//			return false;
//		}
//		
//		if(this.id==that.id && this.name==that.name){
//			return true;
//		}
//		
//		if(this.id==that.id&& this.name.equals(that.name)){
//			return true;
//		}
//		
//		return false;
//		
//
//	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
	
	
	
}