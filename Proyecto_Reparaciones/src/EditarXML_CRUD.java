import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EditarXML_CRUD {
	public static void borrar() throws Exception{
		 DocumentBuilderFactory documentBuilderf = DocumentBuilderFactory.newInstance();
	        documentBuilderf.setValidating(false);
	        DocumentBuilder documentBuilder = documentBuilderf.newDocumentBuilder();
	         
	        Document document = documentBuilder.parse(new FileInputStream(new File("tienda.xml")));
	         
	        Element elemento = (Element) document.getElementsByTagName("articulo").item(1);
	 
	        elemento.getParentNode().removeChild(elemento);
	         
	        document.normalize();
	         
	        prettyPrint(document);
	         
	    }
	     
    public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }
	
}