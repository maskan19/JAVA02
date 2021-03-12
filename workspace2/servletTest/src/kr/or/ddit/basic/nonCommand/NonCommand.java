package kr.or.ddit.basic.nonCommand;

public class NonCommand {

//	private Lamp lamp;
//	public NonCommand(Lamp lamp) {
//		this.lamp = lamp;
//	}
//	
//	public void run() {
//		lamp.turnOn();
//	}
	
	//램프를 켜는 기능의 호출자를 히터를 켜는 호출자로 변경하기
	private Heater heater;
	public NonCommand(Heater heater) {
		this.heater = heater;
	}
	
	public void run() {
		heater.powerOn();
	}
	
}
