import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.HashMap;

public class CrearArticuloXML {
	public static void creacionFicheroXML() {
		CreacionFicheros.cargarArticulos();
		CreacionFicheros.cargarReparaciones();
		HashMap<Articulos, Reparaciones> link = new HashMap<Articulos, Reparaciones>(); 
		// Hacer a partir del try del CrearEmpleadoXML
	}
	
}
