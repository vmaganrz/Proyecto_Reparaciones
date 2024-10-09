import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearArticuloXML {
	public static void creacionFicheroXML() throws IOException{
		 File ficheroXML = new File("articulos.dat");   
		   RandomAccessFile file = new RandomAccessFile(ficheroXML, "r");
		   
		   int  numArticulo, numReparacion, posicion=0;
		   Double precio;
		   char descripcion[] = new char[10], aux;
		     
		   DocumentBuilderFactory factory =
		                  DocumentBuilderFactory.newInstance();
		  
		   try{
		     DocumentBuilder builder = factory.newDocumentBuilder();
		     DOMImplementation implementation = builder.getDOMImplementation();
		     Document document = 
		          implementation.createDocument(null, "Articulos", null);
		     document.setXmlVersion("1.0"); 
		   
		     for(;;) {
			 file.seek(posicion); 
			 numArticulo=file.readInt();     	  
		       for (int i = 0; i < descripcion.length; i++) {
		         aux = file.readChar();
		         descripcion[i] = aux;    
		       }   
		       String descripcionArticulo = new String(descripcion);
		       numReparacion = file.readInt();
		  	 precio = file.readDouble();  
			   
			 if(numArticulo>0) { 
			   Element raiz = 
		                   document.createElement("articulo");
		         document.getDocumentElement().appendChild(raiz); 
		        
                     
		         CrearElemento("NumeroArticulo",Integer.toString(numArticulo), raiz, document); 
		         CrearElemento("NumeroReparacion",Integer.toString(numReparacion), raiz, document); 
		         CrearElemento("Precio",Double.toString(precio), raiz,document); 
		         CrearElemento("Descripcion",descripcionArticulo.trim(), raiz, document); 
			 }	
			 posicion= posicion + 36;
			 file.seek(posicion);
			 if (file.getFilePointer() == file.length()) break; 

		     }
				
		     Source source = new DOMSource(document);
		     Result result = 
		            new StreamResult(new java.io.File("Articulos.xml"));        
		     Transformer transformer =
		            TransformerFactory.newInstance().newTransformer();
		     transformer.transform(source, result);
		    
		    }catch(Exception e){ System.err.println("Error: "+e); }
		    
		    file.close();	
		 }
		 
		 static void  CrearElemento(String nombreEtiqueta, String valor,
		                            Element raiz, Document document){
		    Element elem = document.createElement(nombreEtiqueta); 
		    Text text = document.createTextNode(valor); //damos valor
		    raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
		    elem.appendChild(text); //pegamos el valor		 	
	}
	
}
