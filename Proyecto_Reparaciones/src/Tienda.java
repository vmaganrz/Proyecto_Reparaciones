import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tienda {
	public static void main(String[] args) throws IOException {
		  // Crear una lista de artículos
        ArrayList<Articulos> listaArticulos = new ArrayList<>();
        listaArticulos.add(new Articulos(1, "Ordenador"));
        listaArticulos.add(new Articulos(2, "Teléfono"));

        // Crear una lista de reparaciones
        ArrayList<Reparaciones> listaReparaciones = new ArrayList<>();
        listaReparaciones.add(new Reparaciones(1, 1, 100, "Cambio de pantalla"));
        listaReparaciones.add(new Reparaciones(2, 2, 50, "Reparación de batería"));

        // Crear instancias de las clases de escritura y lectura
        CreacionFicheros escritura = new CreacionFicheros();
        LecturaFicheros lectura = new LecturaFicheros();

        // Escritura de archivos
        escritura.escribirArticulosTexto(listaArticulos, "articulos.txt");
        escritura.escribirReparacionesTexto(listaReparaciones, "reparaciones.txt");

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
