
public class Articulos {
	int numArticulo;
	String DniPropietario;
	
	public Articulos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Articulos(int numArticulo, String dniPropietario) {
		super();
		this.numArticulo = numArticulo;
		DniPropietario = dniPropietario;
	}
	
	public int getNumArticulo() {
		return numArticulo;
	}
	
	public void setNumArticulo(int numArticulo) {
		this.numArticulo = numArticulo;
	}
	
	public String getDniPropietario() {
		return DniPropietario;
	}
	
	public void setDniPropietario(String dniPropietario) {
		DniPropietario = dniPropietario;
	}
	
	@Override
	public String toString() {
		return "Articulos [numArticulo=" + numArticulo + ", DniPropietario=" + DniPropietario + "]";
	}
	
	
}
