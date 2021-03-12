package kr.or.ddit.basic.json;

public class SampleVO {

	private String id;
	private String pass;
	private int age;

	public SampleVO(String id, String pass, int age) {
		super();
		this.id = id;
		this.pass = pass;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
