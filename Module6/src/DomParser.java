import java.io.File;
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
	
		try {
			File xmlFile = new File("C:/CodeRepository/Module6/src/student.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			Document doc = dbBuilder.parse(xmlFile);
			System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
			NodeList list = doc.getElementsByTagName("student");
			for (int i = 0; i < list.getLength(); i++) {
				Node n = list.item(i);
				System.out.println("Current Element :" + n.getNodeName());
				if(n.getNodeType() == Node.ELEMENT_NODE){
					Element ele = (Element) n;
					System.out.println("Student id: " + ele.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("Student Name: " + ele.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Student std: " + ele.getElementsByTagName("std").item(0).getTextContent());
					System.out.println("Student gender: " + ele.getElementsByTagName("gender").item(0).getTextContent());
					System.out.println("Student marks: " + ele.getElementsByTagName("marks").item(0).getTextContent());
					System.out.println("Student address: " + ele.getElementsByTagName("address").item(0).getTextContent());
				}
				System.out.println("-------------------------------------------------------");
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
