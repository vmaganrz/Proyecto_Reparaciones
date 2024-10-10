import java.io.IOException;

public class Tienda {
    public static void main(String[] args) throws Exception {
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
        System.out.println("Escritura DE FICHERO XML:");
        
        /*
        CrearArticuloXML escrituraXML = new CrearArticuloXML();
        escrituraXML.creacionFicheroXML();
        
        SOLUCIONAR ERROR
        
        */

        System.out.println("\nLECTURA DE FICHERO XML:");

        LecturaTiendaXml lecturaXML = new LecturaTiendaXml();
        lecturaXML.leerXML("tienda.xml");
        EditarXML_CRUD crud = new EditarXML_CRUD();
        System.out.println("Articulo encontrado: ");
        crud.buscar(1);
        /*

        System.out.println("\nElemento creado");
        crud.crear();// Crear un articulo de personas
        System.out.println("\nElemento borrardo");
        crud.borrar();// Borrar segunto articulo
        System.out.println("\nElemento editado");
        crud.editar(); // Añadir atributo a el primer articulo*/
    }
}
