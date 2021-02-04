package kr.or.ddit.basic;

//은행의 입출금을 쓰레드로 처리하는 예제
//synchronized를 이용한 동기화

public class ThreadTest17 {

	private int balance;

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금 메서드

	public synchronized void deposit(int money) {
		balance += money;
	}

	// 출금하는 메서드(출금 성공 : true, 출금 실패 : false 반환)
	public synchronized boolean withdraw(int money) {
		if (balance >= money) {
			for (int i = 1; i <= 10000000; i++) {
			} // 시간 지연용

			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance);
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		final ThreadTest17 acount = new ThreadTest17();
		acount.setBalance(10000); // 잔액 만원

		// 익명구현체로 쓰레드 구현(1.8은 final없이 사용 가능)
		Runnable test = new Runnable() {

			@Override
			public void run() {
				// 6000원 출금하기
				boolean result = acount.withdraw(6000);
				System.out.println("쓰레드 안에서 result = " + result
						+ ", balance = " + acount.getBalance());

			}
		};

		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
		
		
		
	}

}
