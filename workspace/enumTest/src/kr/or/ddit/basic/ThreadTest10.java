package kr.or.ddit.basic;

//쓰레드의 상태값을 출력하는 예제
public class ThreadTest10 {

	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		th.start();

	}
}

// 쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread {
	@Override
	public void run() {
		for (long i = 1L; i <= 20_000_000_000L; i++) {
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		for (long i = 1L; i <= 20_000_000_000L; i++) {
		}
	}

}

// 검사 대상 쓰레드의 상태값을 출력하는 쓰레드
class StatePrintThread extends Thread {
	private TargetThread target;

	public StatePrintThread(TargetThread target) {
		this.target = target;
	}

	@Override
	public void run() {
		while (true) {
			Thread.State state = target.getState();
			System.out.println("TargetThread의 상태값 : " + state);

			// 검사 대상 쓰레드가 NEW 상태이면
			if (state == Thread.State.NEW) {
				target.start();
			}

			// 검사 대상 쓰레드가 종료 상태이면
			if (state == Thread.State.TERMINATED) {
				break; // 타겟이 종료되면 출력도 종료되도록
			}
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}