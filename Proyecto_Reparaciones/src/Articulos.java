import java.util.*;

public class Articulos {
	String nombreArticulo;
	int numArticulo;
	
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
		return "Articulos [nombreArticulo=" + nombreArticulo + ", numArticulo=" + numArticulo + "]";
	}
	
	
}
