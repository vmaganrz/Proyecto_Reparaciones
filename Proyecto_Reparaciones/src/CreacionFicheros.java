import java.io.*;
import java.util.*;
public class CreacionFicheros {
	    // Escritura de Articulos en archivo de texto
	 public static void escribirArticulosTexto(ArrayList<Articulos> listaArticulos, String ruta) throws IOException {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
	        for (Articulos articulo : listaArticulos) {
	            writer.write(articulo.toString());
	            writer.newLine();  
	        }
	        writer.close();
	        System.out.println("Archivo de artículos guardado en texto correctamente.");
	    }

	    // Escritura de Reparaciones en archivo de texto
	    public static void escribirReparacionesTexto(ArrayList<Reparaciones> listaReparaciones, String ruta) throws IOException {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
	        for (Reparaciones reparacion : listaReparaciones) {
	            writer.write(reparacion.toString());
	            writer.newLine();  // Salto de línea
	        }
	        writer.close();
	        System.out.println("Archivo de reparaciones guardado en texto correctamente.");
	    }

	
	public static void EscribirFicheroBinario(String fich) throws IOException {
		
		ArrayList<Articulos> listaArticulos = new ArrayList<>();
	        listaArticulos.add(new Articulos(1, "Ordenador"));
	        listaArticulos.add(new Articulos(2, "Teléfono"));
	        listaArticulos.add(new Articulos(3, "Televisión"));
	        listaArticulos.add(new Articulos(4, "Reloj"));

	
		
		File fichero = new File(fich);
		DataOutputStream dataOS = new 
				DataOutputStream(new FileOutputStream(fichero));
		
		 
		 for (Articulos articulo : listaArticulos) {
			 dataOS.writeInt(articulo.getNumArticulo()); 
		     dataOS.writeUTF(articulo.getNombreArticulo());  
		 }
		 
		 dataOS.close(); 
		
	}
	
}
	
	

	

