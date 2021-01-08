package kr.or.ddit.basic;


class NonGenericClass {
	private Object value;
	public int kor;

	public void setKor(int kor){
		
		if(kor<0||kor>100){
			this.kor = 0;
		}else{
			this.kor = kor;
		}
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	
	
	
	
//	--제네릭 타입 글자로 많이 사용되는 것 --
//	T : Type
//	K : Key
//	V : Value
//	E : Element(자료구조에 들어가는 것들을 주로 나타낸다.)
	
}

class MyGeneric<T> {
	private T value;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

public class GenericTest {

	public static void main(String[] args) {

		NonGenericClass ng1 = new NonGenericClass();
		ng1.setValue("가나다라");

		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		// String rtnNg1 = ng1.getValue(); //Object로 처리했기 때문에 컴파일 에러
		String rtnNg1 = (String) ng1.getValue();
		int rtnNg2 = (int) ng2.getValue();
		System.out.println("문자열 반환값 : " + rtnNg1);
		System.out.println("숫자열 반환값 : " + rtnNg2);

		// String rtnNg3 = (String)ng2.getValue();
		// java.lang.Integer cannot be cast to java.lang.String

		// System.out.println("숫자열 반환값 : " + rtnNg3);
		String rtnNg4 = ng2.getValue().toString();
		System.out.println("숫자열 반환값 : " + rtnNg4);

		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();

		mg1.setValue("우리나라");
		mg2.setValue(500);

		String rtnMg1 = mg1.getValue();
		int rtnMg2 = mg2.getValue();

		// mg1.setValue(200);
		// mg2.setValue("가나다라");

		System.out.println("문자열 반환값 : " + rtnMg1);
		System.out.println("숫자 반환값 : " + rtnMg2);
		
		
	}

}
