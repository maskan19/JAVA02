package kr.or.ddit.basic;

public class ThreadTest09 {

	public static void main(String[] args) {
		AutoSaveThread auto = new AutoSaveThread();
		
		auto.setDaemon(true);
		
		auto.start();
		
		try {
			for(int i = 1; i<=20; i++){
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("main쓰레드 종료");
	}
}


//자동 저장하는 쓰레드(3초에 한번씩 자동 저장하는 쓰레드)
class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("작업내용을 저장합니다.");
	}
	
	@Override
	public void run() {
		while(true){
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		save();
	}
	}
}