import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.HashMap;

public class CrearArticuloXML {
	public static void creacionFicheroXML() throws IOException{
		 File ficheroXML = new File("articulos.dat");   
		   RandomAccessFile file = new RandomAccessFile(ficheroXML, "r");
		   
		   int  nºArticulo, nºReparacion, posicion=0;
		   Double precio;
		   char descripcion[] = new char[10], aux;
		     
		   DocumentBuilderFactory factory =
		                  DocumentBuilderFactory.newInstance();
		  
		   try{
		     DocumentBuilder builder = factory.newDocumentBuilder();
		     DOMImplementation implementation = builder.getDOMImplementation();
		     Document document = 
		          implementation.createDocument(null, "Articulos ", null);
		     document.setXmlVersion("1.0"); 
		   
		     for(;;) {
			 file.seek(posicion); 
			 nºArticulo=file.readInt();     	  
		       for (int i = 0; i < descripcion.length; i++) {
		         aux = file.readChar();
		         descripcion[i] = aux;    
		       }   
		       String descripcionArticulo = new String(descripcion);
		       nºReparacion = file.readInt();
		  	 precio = file.readDouble();  
			   
			 if(nºArticulo>0) { 
			   Element raiz = 
		                   document.createElement("empleado");
		         document.getDocumentElement().appendChild(raiz); 
		        
                     
		         CrearElemento("Nº Articulo",Integer.toString(nºArticulo), raiz, document); 
		         CrearElemento("Nº Reparacion",Integer.toString(nºReparacion), raiz, document); 
		         CrearElemento("Precio",Double.toString(precio), raiz,document); 
		         CrearElemento("Descripcion",descripcionArticulo.trim(), raiz, document); 
			 }	
			 posicion= posicion + 36;
			 if (file.getFilePointer() == file.length()) break; 

		     }
				
		     Source source = new DOMSource(document);
		     Result result = 
		            new StreamResult(new java.io.File("Empleados.xml"));        
		     Transformer transformer =
		            TransformerFactory.newInstance().newTransformer();
		     transformer.transform(source, result);
		    
		    }catch(Exception e){ System.err.println("Error: "+e); }
		    
		    file.close();	
		 }
		 
		 static void  CrearElemento(String datoEmple, String valor,
		                            Element raiz, Document document){
		    Element elem = document.createElement(datoEmple); 
		    Text text = document.createTextNode(valor); //damos valor
		    raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
		    elem.appendChild(text); //pegamos el valor		 	
	}
	
}
