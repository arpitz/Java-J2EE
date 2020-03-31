import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo extends DefaultHandler {
	public void startDocument(){
		System.out.println("Document starts here ..");
	}
	
	public void startElement(String uri,String localName,String qName,Attributes attrs)
    {
      System.out.print("<"+qName + ">");
    }
    
    public void characters(char ch[],int start,int len)
    {
        System.out.print(new String(ch,start,len));
    }
    public void endElement(String uri,String localName,String qName)
    {
      System.out.println("</"+qName+ ">");
    }
    
     public void endDocument()
    {
        System.out.println("Document ends here");
    } 


	public static void main(String[] args) {
		try {
			SAXParser sp = SAXParserFactory.newInstance().newSAXParser();
			sp.parse(new FileInputStream("C:/CodeRepository/Module6/src/student.xml"), new SAXParserDemo());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
