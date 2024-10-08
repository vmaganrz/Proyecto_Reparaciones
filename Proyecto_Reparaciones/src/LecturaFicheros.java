import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LecturaFicheros {
	// Método para leer artículos desde un archivo de texto
    public void leerArticulos(String rutaArchivo) throws IOException {
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            System.out.println("\nArtículos leídos del archivo:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            try { 
            	reader.close();
            }catch (IOException e) {
                System.err.println("Ocurrió un cerrar al leer el archivo: " + e.getMessage());
            }
        }catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
         
 
    }

    // Método para leer reparaciones desde un archivo de texto
    public void leerReparaciones(String rutaArchivo) throws IOException {
        try {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        System.out.println("\nReparaciones leídas del archivo:");
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
        try {
        	reader.close();
        }catch(IOException e){
        	System.err.println("Ocurrió un cerrar al leer el archivo: " + e.getMessage());
        }
        
        }catch(IOException e){
        	  System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }
	

	public static void LecturaFicheroBinario(String fich)  throws IOException {
		File fichero = new File(fich);
		DataInputStream dataIS = new
		           		DataInputStream(new FileInputStream(fichero));

	   int n;
	   String e;

	   try {
	    while (true) {
	        n = dataIS.readInt(); 
	        e = dataIS.readUTF(); 
	        System.out.println("ID: " + n + ", Tipo: " + e);        
	    }
	    }catch (EOFException eo) {
	    	System.out.println("Fin");
	    }
		
	   dataIS.close();  
	}	
}
