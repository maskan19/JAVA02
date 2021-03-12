package persing;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PersonSaxTest {

	public static void main(String[] args) {
		// 1. file변수에 xml파일을 넣어놓는다.
		File file = new File("./people2.xml");
		// 2. SAX파싱을 위해 SAXParserFactory 공간을 만들어준다.
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			// 3. SAXparser를 하기 위해 parser객체를 생성해준다.
			SAXParser parser = factory.newSAXParser();
			// 3. DefaultHandler를 상속받은 SaxHandler가 XML 데이터를 파싱하여 saxParser.parse() 메소드에 전달한다.
			PeopleSaxHandler handler = new PeopleSaxHandler();
			parser.parse(file, handler);

			List<Person> list = handler.getPersonList();
			System.out.println("SAX 파싱 시작...!!");
			System.out.println();

			for (Person p : list) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("SAX 파싱 완료...!!");
	}

}

// 4. DefaultHandler로 넘어가서 설명