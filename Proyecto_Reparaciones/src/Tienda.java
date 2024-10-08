import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tienda {
	public static void main(String[] args) throws IOException {
		  // Crear una lista de artículos
		CreacionFicheros.cargarArticulos();

        // Crear una lista de reparaciones
        CreacionFicheros.cargarReparaciones();
       
        // Crear instancias de las clases de escritura y lectura
        CreacionFicheros escritura = new CreacionFicheros();
        LecturaFicheros lectura = new LecturaFicheros();

        // Escritura de archivos
        escritura.escribirArticulosTexto(CreacionFicheros.cargarArticulos(), "articulos.txt");
        escritura.escribirReparacionesTexto(CreacionFicheros.cargarReparaciones(), "reparaciones.txt");

        // Lectura de archivos
        lectura.leerArticulos("articulos.txt");
        lectura.leerReparaciones("reparaciones.txt");
        
        try {
        	 escritura.EscribirFicheroBinario("articulos.dat"); 
             lectura.LecturaFicheroBinario("articulos.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
   
        
        
	}
}
