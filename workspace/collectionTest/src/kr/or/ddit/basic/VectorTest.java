package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체 생성 - old version
		Vector v1 = new Vector<>();

		System.out.println("처음 크기 : " + v1.size());

		// 데이터 추가 : add(추가할 데이터)
		// 반환값 : 추가 성공시 true, 실패시 false
		v1.add("aaa"); // 객체형 데이터만 저장할 수 있음
		v1.add(new Integer(111));
		v1.add(333); // 오토박싱 : 기본 자료형을 랩퍼 클래스형으로 자동 변환
					 // 오토언박싱 : 랩퍼 클래스형을 기본 자료형으로 자동 변환
		v1.add('a');
		v1.add(true);
		boolean check = v1.add(3.14);
		System.out.println("현재크기  : " + v1.size());
		System.out.println("반환값 : " + check);

		// 데이터 추가 : addElement(추가할 데이터)
		// 이전 버전의 프로그래멩서도 사용 가능 하도록 하기 위해 남아 있는 메서드
		v1.addElement("DDD");
		System.out.println("v1 > " + v1.toString());
		System.out.println("v1 > " + v1);// 생략 가능

		// 데이터 추가 : add(index, 추가할 데이터)
		// index번째에 '추가할 데이터'를 끼워 넣는다.
		// 반환값은 없다.
		v1.add(1, "KKK");
		System.out.println("v1 > " + v1);

		// 데이터 수정 : set(index, 새로운 데이터)
		// index번쨰의 데이터를 '새로운 데이터'로 덮어쓴다.
		// 반환값 : 원래의 데이터
		String temp = (String) v1.set(1, "zzz");// 가져올 당시에는 Object형인데 temp가
												// String객체> 형변환을 해주어야함
		System.out.println("v1 > " + v1);
		System.out.println("반환값 " + v1);

		// 데이터 꺼내오기 : get(index)
		// index번째의 데이터를 반환한다.
		int data = (int) v1.get(2);
		System.out.println("2번째 자료 : " + data);

		// 데이터 삭제 : remove(index)
		// index번째의 데이터를 삭제한다.
		// 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("v1 > " + v1);
		temp = (String) v1.remove(0);
		System.out.println("삭제된 데이터 " + temp);
		System.out.println("v1 > " + v1);

		// 데이터 삭제 : remove(삭제할 데이터)
		// '삭제할 데이터'를 찾아서 삭제한다.
		// '삭제할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// 반환값 : 삭제 성공시 true, 실패시 false
		v1.remove("DDD");
		System.out.println("삭제후 v1 = " + v1);

		// v1.remove(111); //데이터 111 삭제가 아니라 111인덱스 자료를 삭제하는 것으로 인식
		v1.remove(new Integer(111));
		System.out.println("삭제후 v1 = " + v1);

		// v1.remove('a'); // 문자 a가 아니라 숫자 97을 의미함
		v1.remove(new Character('a'));
		System.out.println("삭제후 v1 = " + v1);

		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제후 v1 = " + v1);

		// //////////////////////////////////////////////////////////////////////////////////

		// 제네릭 타입(Generic Type) 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 말한다.
		// 객체를 선언할 때 괄호 (<>) 안에 그 클래스 내부에서 사용할 데이터의 타입을 정해주는 것을 말한다.
		// 이렇게 선언하게 되면 그 데이터 타입 이외의 다른 데이터를 저장할 수 없게 된다.
		// 이 때 제네릭으로 선언될 수 있는 데이터 타입은 '클래스 형 ' 이어야한다.
		// 예를 들어 int 는 Integer, boolean은 Boolean, char는 Character등으로 대체해서 사용해야
		// 한다.
		// 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 떄 형변환이 필요 없다.

		Vector<String> v2 = new Vector<String>();
		Vector<String> v3 = new Vector<>(); // 생략이 가능하다.
		Vector<Integer> v5 = new Vector<>();
		// Vector<int> v5 = new Vector <>(); 제네릭 타입은 반드시 '클래스형'으로 지정해야 한다.

		v2.add("안녕하세요");
		// v2.add(123); //오류 : 다른 종류의 데이터를 저장할 수 없다.

		String temp2 = v2.get(0); // 형변환이 필요 없다.
		System.out.println("temp2 = " + temp2);

		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();

		// 전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("v1의 개수 : " + v1.size());
		System.out.println("clear 후 v1 = " + v1);

		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");

		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("EEEE");

		System.out.println("v2 = " + v2);
		System.out.println("v4 = " + v4);

		// 데이터 삭제 : removeAll(Collection 객체)
		// Collection객체가 가지고 있는 데이터를 모두 삭제한다.
		// 반환값 : 삭제 성공 (true), 삭제 실패(false)
		v2.removeAll(v4);
		System.out.println(v2);

		System.out.println("------------------------");

		v2.clear();

		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");

		// Vector에 저장된 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : " + v2.get(i));
		}
		System.out.println();

		// 향상된 for문
		// 형식)
		// for(자료형 명 변수명 : 배열이나 List 또는 Set형 객체 변수){
		// 처리할 내용들;
		// :
		// }
		for (String str : v2) {
			System.out.println(str);
		}

	}

}
