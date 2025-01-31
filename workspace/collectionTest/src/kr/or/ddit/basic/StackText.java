package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackText {

	public static void main(String[] args) {

		Browser b = new Browser();
		b.goURL("1. 네이버");
		b.history();
		b.goURL("2. 야후");
		b.history();
		b.goURL("3. 구글");
		b.history();
		b.goURL("4. 다음");
		b.history();
		b.goBack();
		b.history();
		b.goBack();
		b.history();
		b.goForward();
		b.history();
		
	}

}

class Browser {
	private LinkedList<String> back;
	private LinkedList<String> forward;
	private String currentURL;

	public Browser() {

		back = new LinkedList<>();
		forward = new LinkedList<>();
		currentURL = "";
	}

	// 사이트를 방문하는 메서드 : 매개변수에 방문할 url 저장
	public void goURL(String url) {
		System.out.println(url + "사이트로 접속합니다.");
		if (currentURL != null && !"".equals(currentURL)) {
			back.push(currentURL);
		}
		currentURL = url;
	}

	public void goBack() {
		// isEmpty() > List가 비어있으면 true
		if (!back.isEmpty()) {
			forward.push(currentURL);
			// 현재 url을 forward스택에 추가하고
			currentURL = back.pop();
			// back스택에서 꺼내온 값을 현재 URL로 한다.
		}
	}

	public void goForward() {
		if (!forward.isEmpty()) {
			back.push(currentURL);
			//현재 url을 back에 추가
			currentURL = forward.pop();
			//forward에서 꺼내온 값을 현재 URL로 한다. 
		}
	}
	
	public void history(){
		System.out.println();
		System.out.println("---------------");
		System.out.println("방문기록");
		System.out.println("---------------");
		System.out.println("back>" + back);
		System.out.println("now>" + currentURL);
		System.out.println("forward>" + forward);
	}

}