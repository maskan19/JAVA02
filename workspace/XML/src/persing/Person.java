package persing;

public class Person {
	private String name;
	private int age;
	private String gender;
	private String dept;
	
	//생성자
	public Person() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age + "\n성별 : " + gender + "\n부서 : " + dept + "\n";
	}
}
