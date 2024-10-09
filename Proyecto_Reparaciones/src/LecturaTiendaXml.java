import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class LecturaTiendaXml {

    // Método para leer y procesar el archivo XML
    public void leerXML(String archivo) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

        try {
            // Crear un DocumentBuilder
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            // Parsear el archivo XML
            Document document = builder.parse(new File(archivo));
            document.getDocumentElement().normalize(); // Normaliza el documento

            // Imprimir el elemento raíz
            System.out.printf("Elemento raíz: %s %n", document.getDocumentElement().getNodeName());

            // Leer artículos
            NodeList articulos = document.getElementsByTagName("articulo");
            System.out.printf("Número de artículos: %d %n", articulos.getLength());

            for (int i = 0; i < articulos.getLength(); i++) {
                Node articulo = articulos.item(i);
                if (articulo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) articulo;
                    System.out.printf("Número de artículo = %s %n",
                            elemento.getElementsByTagName("num_articulo").item(0).getTextContent());
                    System.out.printf("Nombre de artículo = %s %n",
                            elemento.getElementsByTagName("nombre_articulo").item(0).getTextContent());
                }
            }

            // Leer reparaciones
            NodeList reparaciones = document.getElementsByTagName("reparacion");
            System.out.printf("Número de reparaciones: %d %n", reparaciones.getLength());

            for (int i = 0; i < reparaciones.getLength(); i++) {
                Node reparacion = reparaciones.item(i);
                if (reparacion.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) reparacion;
                    System.out.printf("Número de reparación = %s %n",
                            elemento.getElementsByTagName("num_reparacion").item(0).getTextContent());
                    System.out.printf("Número de artículo = %s %n",
                            elemento.getElementsByTagName("num_articulo").item(0).getTextContent());
                    System.out.printf("Precio de reparación = %s %n",
                            elemento.getElementsByTagName("precio_reparacion").item(0).getTextContent());
                    System.out.printf("Descripción = %s %n",
                            elemento.getElementsByTagName("descripcion").item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir cualquier excepción que ocurra
        }
    }
}
