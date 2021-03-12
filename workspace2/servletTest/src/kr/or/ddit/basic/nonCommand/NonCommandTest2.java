package kr.or.ddit.basic.nonCommand;

public class NonCommandTest2 {

	public static void main(String[] args) {
		Lamp lamp = new Lamp();
		Heater heater = new Heater();
		
		NonCommand2 test = new NonCommand2(lamp, heater);
		test.setMode("LAMP");
		test.run();
		test.setMode("HEATER");
		test.run();
		
	}
	
}
