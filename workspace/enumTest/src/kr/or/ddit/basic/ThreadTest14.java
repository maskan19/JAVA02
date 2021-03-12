package kr.or.ddit.basic;
/*
 * Thread 의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
 * 이때 사용하던 자원을 정리하지 못하고 바로 종료되어 나중에 
 * 실행되는 프로그램에 영향을 줄 수 있다.
 */
public class ThreadTest14 {


	public static void main(String[] args) {
		ThreadStopTest1 th1 = new ThreadStopTest1();
		th1.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		th1.setStop(true);
//		th1.stop();
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		th2.interrupt();
		
		
	}
	
	
}

class ThreadStopTest1 extends Thread {
	
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행중");
		}
		System.out.println("자원정리");
		System.out.println("쓰레드 종료");
	}
}

class ThreadStopTest2 extends Thread{
	@Override
	public void run() {
//		
//		try {
//			while(true){
//				System.out.println("ThreadStopTest2 실행중");
//				//일시 정지 상태에서 interrupt()메서드가 실행되면
//				//InterruptedException이 발생한다.
//				Thread.sleep(1);
//			}
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//		}
		
		//방법2
		while(true){
			System.out.println("Thread 실행중");
			
			//interrupt() 메서드가 호출되었는지 검사한다.
			//검사방법1)Thread의 인스턴스 메서드인 isInterrupted()를 이용한다. 
			// 이 메서드는 interrupt()메서드가 호출되면 true를 반환한다.
//			
//			if(this.isInterrupted()==true){
//				break;
//			}
//			검사방법 2) Thread의 정적 메서드(static메서드)인 interrupte()메서드를 이용한다. 
//			이 메서드도 interrupt()메서드가 호출되면  true반환
			if(Thread.interrupted()==true){
				break;
			}
			
			
		}
		
		
		
		
		System.out.println("자원 정리");
		System.out.println("쓰레드 종료");
	}
	
}