package kr.or.ddit.basic.okCommand;

//호출자 역할의 클래스
public class OkCommand {

	private ICommand command;

	public OkCommand(ICommand command) {
		this.command = command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void run() {
		command.execute();
	}

}
