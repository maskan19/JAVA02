package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
/*
 *  문제) 컴퓨터와 가위바위 보를 진행하는 프로그램을 작성하시오.
 *  	컴퓨터의 가위 바위 보는 난수를 이용해서 정하고,
 *  	사용자는 showInputDialog()메소드를 이용해서 입력 받는다.
 *  
 *  	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 *  	5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 *  
 *   	5초안에 입력이 완료되면 승패를 구해서 출력한다.
 *   
 *   	1) 5초 안에 입력을 못했을 경우 실행 예시
 *   		--결과--
 *   		시간 초과로 당신이 졌습니다.
 *   
 *   	2) 5초 안에 입력 했을 경우 실행 예시
 *   		--결과--
 *   		컴퓨터 : 가위
 *   		사용자 : 바위
 *   		결과 : 당신이 이겼습니다.
 */
	
	
	public static void main(String[] args) {
		RSP rsp = new RSP();
		timer ct = new timer();
		rsp.start();
		ct.start();
		

	}

}

class timer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트다운 시작");
		for(int i = 5; i>0; i--){
			if(RSP.inputCheck == true){
				return;
			}
			System.out.println(i + "초 경과");
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
		System.out.println("--결과--");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
	
}

class RSP extends Thread{
	public static boolean inputCheck = false;
	@Override
	public void run() {
		String[] rsp = {"가위", "바위", "보"};
		int ans = JOptionPane.showOptionDialog(null, "가위 바위 보 !!", "5초 내로 입력하시오", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, rsp, null);
		inputCheck = true;
		int comans = (int)(Math.random()*3);
		System.out.println("--결과--");
		System.out.println("사용자 : " + rsp[ans]);
		System.out.println("컴퓨터 : " + rsp[comans]);
		if(ans+1 >2){
			ans = ans-3;
		}
		if(ans+1 == comans){
			System.out.println("결   과 : 당신이 졌습니다.");
		} else if(ans == comans){
			System.out.println("결   과 : 무승부입니다.");
		} else System.out.println("결   과 : 당신이 이겼습니다.");
		
	}
	
}

