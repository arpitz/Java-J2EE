import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class XMLGeneratorDemo {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element rootele = doc.createElement("employees");
		Element empele = doc.createElement("employee");
		Element idele = doc.createElement("emp_id");
		Element nameele = doc.createElement("name");
		Element deptele = doc.createElement("dept");
	
		Text t1 = doc.createTextNode("1");
		Text t2 = doc.createTextNode("Mark");
		Text t3 = doc.createTextNode("Development");
		
		idele.appendChild(t1);
		nameele.appendChild(t2);
		deptele.appendChild(t3);
		
		empele.appendChild(idele);
		empele.appendChild(nameele);
		empele.appendChild(deptele);
		rootele.appendChild(empele);
		
		doc.appendChild(rootele);
		
		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("C:/CodeRepository/Module6/src/employees.xml")));
		System.out.println("Employees xml file generated ..");
	}

}
