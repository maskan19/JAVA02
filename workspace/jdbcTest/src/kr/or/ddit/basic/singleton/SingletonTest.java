package kr.or.ddit.basic.singleton;

public class SingletonTest {

	public static void main(String[] args) {

		// MySingleton test1 = new MySingleton();
		// private이므로 외부 명령으로 생성할 수 없음.

		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();

		System.out.println(test2);
		System.out.println(test3);

		System.out.println(test2.equals(test3)); // 같은 내용이다.
		System.out.println(test2 == test3); // 같은 객체이다.

		test2.displayTest();

	}

}
