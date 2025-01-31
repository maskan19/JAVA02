package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 작성하고, 
 * Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * (Map의 구조는 key 값으로 '이름'을 사용하고 
 * value값으로는 'Phone클래스의 인스턴스'를 사용한다.
 * 
 * 아래 메뉴의 내용을 프로그램하시오
 * 
 * 실행 예시 )
 * ----------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호 입력>> 1
 * 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름 >> 홍길동
 * 전화번호 >> 
 * 주소 >> 대전시 중고 대흥동
 * 
 * '홍길동' 전화번호 등록 완료 !!
 * 
 * ----------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호 입력>> 1
 * 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름 >> 홍길동
 * 
 * '홍길동'은 이미 등록된 사람입니다.
 * 
 * ----------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제 (이름)
 * 4. 전화번호 검색 (이름)
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ----------------------
 * 번호 입력>> 5
 * 
 * ----------------------
 * 번호	 이름 	전화번호			 주소
 * ----------------------
 *  1  홍길동   010-1111-1111 대전시 중구 대흥동
 *  	:
 *  ---------------------
 *  
 * 
 */
public class PhoneBookTest {
	static HashMap<String, Phone> phonebookMap = new HashMap<>();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		// PhoneBookTest pt = new PhoneBookTest();

		while (true) {
			System.out.println("" + "----------------------\n"
					+ "다음 메뉴를 선택하세요.\n" + "\n" + "1. 전화번호 등록\n"
					+ "2. 전화번호 수정\n" + "3. 전화번호 삭제\n" + "4. 전화번호 검색\n"
					+ "5. 전화번호 전체 출력\n" + "0. 프로그램 종료\n"
					+ "----------------------\n" + "번호 입력>> ");
			String input = s.nextLine();
			switch (input) {
			case "1":
				insert();
				break;
			case "2":
				update();
				break;
			case "3":
				delete();
				break;
			case "4":
				search();
				break;
			case "5":
				list();
				break;
			case "0":
				System.exit(0);
			}

		}

	}

	static void insert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.nextLine();
		if (phonebookMap.containsKey(name)) {
			System.out.println("이미 등록된 번호입니다.");
		} else {
			System.out.println("전화번호 >> ");
			String tel = s.nextLine();
			System.out.println("주소 >> ");
			String addr = s.nextLine();

			phonebookMap.put(name, new Phone(name, tel, addr));
			System.out.println(name.toString() + "전화번호 등록 완료 !!");
		}
	}

	static void update() {
		System.out.println("변경할 전화번호 정보를 입력하세요.");
		System.out.println("변경할 이름 >> ");
		String name = s.nextLine();
		System.out.println("전화번호 >> ");
		String tel = s.nextLine();
		System.out.println("주소 >> ");
		String addr = s.nextLine();

		phonebookMap.put(name, new Phone(name, tel, addr));
		System.out.println(name + "전화번호 변경 완료 !!");
	}

	static void delete() {
		System.out.println("삭제할 이름를 입력하세요.");
		System.out.println("이름 >> ");
		String name = s.nextLine();
		if (phonebookMap.remove(name) != null) {
			phonebookMap.remove(name);
			System.out.println(name + "이 삭제되었습니다.");
		} else
			System.out.println("이름이 존재하지 않습니다.");
	}

	static void search() {
		System.out.println("전화번호 찾을 이름을 입력하세요.");
		System.out.println("검색할 이름 >> ");
		String name = s.nextLine();
		int i = 1;
		if (phonebookMap.containsKey(name) == true) {
			System.out.println("----------------------\n"
					+ "번호	 이름 	전화번호			 주소\n" + "----------------------");
			for (Phone ph : phonebookMap.values()) {
				System.out.println(" " + i + " " + ph.name + " " + ph.tel + " "
						+ ph.addr);
				i++;
			}
		} else
			System.out.println("등록된 이름이 없습니다.");

	}

	static void list() {

		int i = 1;
		if (phonebookMap.size() != 0) {
			System.out.println("----------------------\n"
					+ "번호\t 이름\t    전화번호\t주소\n" + "----------------------");
			for (Phone ph : phonebookMap.values()) {
				System.out.println(" " + i + "\t" + ph.name + "\t" + ph.tel
						+ "\t" + ph.addr);
				i++;
			}
		} else
			System.out.println("저장된 전화번호가 없습니다.");
	}
}

class Phone {
	String name;
	String addr;
	String tel;

	public Phone(String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}

}
