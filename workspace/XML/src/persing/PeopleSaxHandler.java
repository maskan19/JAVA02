package persing;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PeopleSaxHandler extends DefaultHandler{
	//DefaultHandler를 상속받은 SaxHandler가 XML 데이터를 파싱하여 saxParser.parse() 메소드에 전달한다.
	
	//파싱한 사람객체를 넣을 리스트
	private List<Person> personList;
	
	//파싱한 사람 객체
	private Person person;
	
	//character 메소드에서 저장할 문자열 변수
	private String str;
	
	public PeopleSaxHandler() {
		personList = new ArrayList<>();
	}
	
	public void startElement(String uri, String localName, String name, Attributes att) {
		//시작 태그를 만났을 때 발생하는 이벤트
		if(name.equals("person")) {
			person = new Person();
			personList.add(person);
		}
	}
	public void endElement(String uri, String localName, String name) {
		//끝 태그를 만났을 때,
		if(name.equals("age")) {
			person.setAge(Integer.parseInt(str));
		}else if(name.equals("name")) {
			person.setName(str);
		}else if(name.equals("gender")) {
			person.setGender(str);
		}else if(name.equals("dept")) {
			person.setDept(str);
		}
	}
	public void characters(char[] ch, int start, int length) {
		//태그와 태그 사이의 내용을 처리
		str = new String(ch,start,length);
	}
    public List<Person> getPersonList(){
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList=personList;
	}
}

// 핸들러 파일 중요한점
// SAX 파싱은 태그를 만나면 이벤트를 발생한다.

// getPersonList를 통해 SAXPerser에 파싱 데이터를 전달
