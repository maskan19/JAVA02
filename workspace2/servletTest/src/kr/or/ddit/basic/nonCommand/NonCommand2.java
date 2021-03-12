package kr.or.ddit.basic.nonCommand;

public class NonCommand2 {

	private Lamp lamp;
	private Heater heater;
	private String mode; //실행할 대상을 지정하는 값이 저장될 변수
	
	public NonCommand2(Lamp lamp, Heater heater) {
		super();
		this.lamp = lamp;
		this.heater = heater;
	}
	
	//실행할 대상을 지정하는 값을 설정하는 메서드
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public void run() {
		switch(mode) {
		case "LAMP" : 
			lamp.turnOn();
			break;
		case "HEATER" : 
			heater.powerOn();
			break;
			
		}
	}
	
}
