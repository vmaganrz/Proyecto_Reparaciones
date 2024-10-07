import java.util.*;

public class Articulos {
	String nombreArticulo;
	int numArticulo;
	ArrayList<Articulos> listaArticulos = new ArrayList<>();
	
	public Articulos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Articulos(int numArticulo , String nombreArticulo) {
		super();
		this.numArticulo = numArticulo;
		this.nombreArticulo = nombreArticulo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}


	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}


	public int getNumArticulo() {
		return numArticulo;
	}
	
	public void setNumArticulo(int numArticulo) {
		this.numArticulo = numArticulo;
	}
	
	@Override
	public String toString() {
		return "Articulos [numArticulo=" + numArticulo + "]";
	}
	
	public void añadirArticulos() {
		listaArticulos.add(new Articulos(1,"Ordenador"));
		listaArticulos.add(new Articulos(2,"Telefono"));
		listaArticulos.add(new Articulos(3,"Television"));
		listaArticulos.add(new Articulos(4,"Reloj"));
	}
	
	public void mostarArticulos() {
		for (Articulos articulo : listaArticulos) {
			articulo.toString();
		}
	}
}
