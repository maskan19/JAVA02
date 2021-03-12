package xmltest;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

	public static void main(String[] args) {
		//문서 빌더를 만들수있는 팩토리 클래스
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			// 문서를 객체로 반환
			DocumentBuilder builder = factory.newDocumentBuilder();
			//파싱하려는 파일이 문서 객체로 반환
			Document doc = builder.parse("people.xml");
			//태그 이름으로 getElementsByTagName에 문자열 태그 이름을 가져올수 있다.
			//노드리스트를 반환하고 그값을 personList담는다.
			NodeList personList = doc.getElementsByTagName("person");
			
			//personList길이만큼 for문을 돌려서 personList안에있는 수만큼 반복
			for(int i=0; i<personList.getLength(); i++){
				//p에 저장되고
				Node p = personList.item(i);
				
				//p.getNodeType()과(personList) Node.ELEMENT_NODE(people.xml)이 같으면
				if(p.getNodeType()==Node.ELEMENT_NODE){
					// Element는 person속성을 빼내서 저장한다.
					//person에 담는다.
					Element person = (Element) p;
					
					//그리고 id가 people.xml의 속성 id이므로 가져올수가 있다.
					//id가 이름과 일치하는 값을 반환시킨다. 여기서는 lastname을 가져온다.
					String id = person.getAttribute("id");
					//그리고 lastname에 자식노들을 가져온다.
					NodeList nameList = person.getChildNodes();
					
					//nameList길이만큼 for문을 돌려서 nameList안에있는 수만큼 반복
					for(int j =0; j<nameList.getLength(); j++){
						//j에 저장후
						Node n = nameList.item(j);
						
						//n안에있는 값이 people.xml안에있는 값과 같다면
						if(n.getNodeType()==Node.ELEMENT_NODE){
							//name에 저장
							Element name = (Element) n;
							//출력 name.getTagName(): 는 <lastname> 부분
							//name.getTextContent()는 Smith 부분
							System.out.println("Person " + id+ ":" + name.getTagName() + "=" + name.getTextContent());
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
