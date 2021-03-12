package kr.or.ddit.basic;

public class ThreadTest08 {
	
	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
		
		th1.setPriority(1);
		th2.setPriority(9);
		
		System.out.println("th1의 우선 순위 : " + th1.getPriority());
		System.out.println("th2의 우선 순위 : " + th2.getPriority());
		th1.start();
		th2.start();
		
	}
}


class UpperThread extends Thread {
	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c);

			for (long i = 1; i <= 200000000; i++) {
			}
		}

	}

}

class LowerThread extends Thread {
	@Override
	public void run() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.println(c);
			
			for (long i = 1; i <= 200000000; i++) {
			}
		}
		
	}
	
}