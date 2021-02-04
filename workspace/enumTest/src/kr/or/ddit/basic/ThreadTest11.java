package kr.or.ddit.basic;

public class ThreadTest11 {

	public static void main(String[] args) {
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"), new DisplayCharacter("강감찬"),
				new DisplayCharacter("일지매") };

		// 배열에 저장된 쓰레드를 실행한다.
		for (DisplayCharacter dc : disChars) {
			dc.start();
		}

		// 모든 쓰레드의 출력이 끝날 때까지 기다린다.
		for (int i = 0; i < disChars.length; i++) {
			try {
				disChars[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("경기 결과");
		System.out.println("순위 : " + DisplayCharacter.setRank);
	}
}

class DisplayCharacter extends Thread {
	public static String setRank = "";
	private String name;

	public DisplayCharacter(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(name + "의 출력 문자 : " + c);
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(name + " 출력 끝");
		// 출력을 끝낸 순서대로 이름을 배치한다.
		DisplayCharacter.setRank += name + "   ";
	}
}