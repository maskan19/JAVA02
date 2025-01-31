package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램

		// Thread를 사용하는 방법

		// 방법 1
		// Thread클래스를 상속한 class를 작성 > class의 인스턴스 생성 >
		// 인스턴스의 start()메서드를 호출

		MyThread1 th1 = new MyThread1();
		th1.start();

		// 방법2
		// Runnable 인터페이스를 구현한 class를 작성> class의 인스턴스 생성>
		// 인스턴스를 Thread객체의 인스턴스를 생성할 때 생성자에 '인자값'으로 넣어서 생성
		// 생성된 Thread의 인스턴스의 start()메서드 호출

		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();

		// 방법3
		// 익명의 구현체를 이용하는 방법
		Runnable r3 = new Runnable() {
			//인터페이스는 메서드가 구현되어있지 않음
			
			@Override
			public void run() {
				for(int i = 1; i<=200; i++){
					System.out.print("@"+i);
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Thread th3 = new Thread(r3);
		th3.start();
		//System.out.println("메인메서드");
		
		
		

	}

}

// 방법1

class MyThread1 extends Thread {

	@Override
	public void run() {
		// super.run();
		// run() 메서드 안에 이 Thread가 처리할 내용을 기술한다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("*"+i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}// run()메서드의 실행이 끝나면 Thread도 종료
}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.print("$"+i);
//			try {
//				Thread.sleep(100);
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}
		}
	}
}
