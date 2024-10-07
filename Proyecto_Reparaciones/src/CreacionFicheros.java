import java.io.*;
import java.util.Iterator;
public class CreacionFicheros {
	public static void EscribirFicheroTexto() {
		
	}
	
	public static void EscribirFicheroBinario() throws IOException {
		File ficheroBinario = new File("ReparacionesBinario.dat");
		FileOutputStream escrituraBinaria = new FileOutputStream(ficheroBinario,true);
		FileInputStream lecturaBinaria = new FileInputStream(ficheroBinario);
		int i;
		
		for (i = 0; i < 100; i++) {
			escrituraBinaria.write(i);
			escrituraBinaria.close();
		}
		
		while ((i = lecturaBinaria.read()) != -1) {
			System.out.println(i);
			lecturaBinaria.close();
		}
	}
}
