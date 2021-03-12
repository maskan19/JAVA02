package kr.or.ddit.basic.singleton;
/*
 * Singleton패턴 : 객체가 1개만 만들어지게 하는 방법
 * 외부에서 new 명령을 사용하지 못하게 한다.
 * Singleton 클래스를 작성하는 방법(필수 구성 요소)
 * 1. 자기 자신 class의 참조값이 저장될 변수를 private static으로 선언한다.
 * 
 * 2. 생성자의 접근 제한자를 private로 한다.
 * 
 * 3. 자기 자신 class의 인스턴스를 생성하고, 반환하는 메서드를 public static으로 작성한다.
 * 이 메서드의 이름은 'getInstance()'로 한다.
 * 
 */
//싱글톤 특징
//메모리를 절약할 수 있다.
//데이터를 공유할 때 사용한다.

public class MySingleton {
	// 1번
	private static MySingleton single;

	// 2번
	private MySingleton() {
		System.out.println("생성자 입니다.");
	}
	
	// 3번
	public static MySingleton getInstance() {
		if (single == null)
			single = new MySingleton();
		return single;
	}

	public void displayTest() {
		System.out.println("싱글톤 클래스의 메서드 호출입니다.");
	}

}
