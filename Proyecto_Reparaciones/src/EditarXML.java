import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EditarXML {

    private final String rutaXML;

    public EditarXML(String rutaXML) {
        this.rutaXML = rutaXML;
    }

    // HACER QUE SE JUNTE CON LA OTRA ARRAY YA QUE NO LA RECONOCE, CONTINUAR CRUD
    public void crearArticulo(Articulos articulo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear nuevo elemento artículo
            Element nuevoArticulo = document.createElement("articulo");
            Element numArticulo = document.createElement("num_articulo");
            numArticulo.setTextContent(String.valueOf(articulo.getNumArticulo()));
            Element nombreArticulo = document.createElement("nombre_articulo");
            nombreArticulo.setTextContent(articulo.getNombreArticulo());
            nuevoArticulo.appendChild(numArticulo);
            nuevoArticulo.appendChild(nombreArticulo);
            document.getDocumentElement().appendChild(nuevoArticulo);

            // Guardar cambios
            guardarCambios(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void guardarCambios(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(rutaXML));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}