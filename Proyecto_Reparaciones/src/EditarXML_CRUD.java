import java.io.*; 
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class EditarXML_CRUD {
	
	public static void crear() throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc = db.parse(new FileInputStream(new File("tienda.xml")));
		
	    Element elementoRaiz = doc.getDocumentElement();
	    Element nuevoArticulo = doc.createElement("Personas");

	    Element numArticulo= doc.createElement("Nombre");
	    numArticulo.setTextContent("Gonzalo");
	    nuevoArticulo.appendChild(numArticulo);

	    Element nomArticulo = doc.createElement("num_articulo");
	    nomArticulo.setTextContent("3");
	    nuevoArticulo.appendChild(nomArticulo);

	    elementoRaiz.appendChild(nuevoArticulo);

	    imprimirXML(doc);
	}
	
	public static void editar() throws Exception{
        DocumentBuilderFactory documentBuilderf = DocumentBuilderFactory.newInstance();
        documentBuilderf.setValidating(false);
        DocumentBuilder documentBuilder = documentBuilderf.newDocumentBuilder();
         
        Document document = documentBuilder.parse(new FileInputStream(new File("tienda.xml")));
         
        Element elemento = (Element) document.getElementsByTagName("articulo").item(2);
 
        elemento.setAttribute("persona", "gonzalo");
         
        imprimirXML(document);
         
	}
	
	public static void borrar() throws Exception{
		DocumentBuilderFactory documentBuilderf = DocumentBuilderFactory.newInstance();
        documentBuilderf.setValidating(false);
        DocumentBuilder documentBuilder = documentBuilderf.newDocumentBuilder();
         
        Document document = documentBuilder.parse(new FileInputStream(new File("tienda.xml")));
         
        Element elemento = (Element) document.getElementsByTagName("articulo").item(1);
 
        elemento.getParentNode().removeChild(elemento);
         
        document.normalize();
         
        imprimirXML(document);
	         
    }
	
	public static void buscar(int numArticulo) throws Exception {
		 DocumentBuilderFactory documentBuilderf = DocumentBuilderFactory.newInstance();
	     documentBuilderf.setValidating(false);
	     DocumentBuilder documentBuilder = documentBuilderf.newDocumentBuilder();
	     Document doc = documentBuilder.parse(new FileInputStream(new File("tienda.xml")));
	     NodeList articulo = doc.getElementsByTagName("articulo");      

		    //recorrer la lista  
		    for (int i = 0; i < articulo.getLength(); i ++) {
			Element arti = (Element)articulo.item(i); 
			if (arti.getElementsByTagName("num_articulo").item(0).getTextContent().equals(String.valueOf(numArticulo))) {
				Articulos objetoLlamado = new Articulos();
				objetoLlamado.setNombreArticulo(arti.getElementsByTagName("nombre_articulo").item(0).getTextContent());
				objetoLlamado.setNumArticulo(Integer.valueOf(arti.getElementsByTagName("num_articulo").item(0).getTextContent()));
				System.out.println(objetoLlamado);
			}
		    }
	}
	
    public static final void imprimirXML(Document xml) throws Exception {
        Transformer transformador = TransformerFactory.newInstance().newTransformer();
        transformador.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformador.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        transformador.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }
	
}