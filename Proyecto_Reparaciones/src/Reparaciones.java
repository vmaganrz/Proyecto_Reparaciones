public class Reparaciones {
	int numReparacion;
	int numArticulo;
	int precioReparaciones;
	String descripcion;
	
	public Reparaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reparaciones(int numReparacion, int numArticulo, int precioReparaciones, String descripcion) {
		super();
		this.numReparacion = numReparacion;
		this.numArticulo = numArticulo;
		this.precioReparaciones = precioReparaciones;
		this.descripcion = descripcion;
	}
	
	public int getNumReparacion() {
		return numReparacion;
	}
	
	public void setNumReparacion(int numReparacion) {
		this.numReparacion = numReparacion;
	}
	
	public int getNumArticulo() {
		return numArticulo;
	}
	
	public void setNumArticulo(int numArticulo) {
		this.numArticulo = numArticulo;
	}
	
	public int getPrecioRepariones() {
		return precioReparaciones;
	}
	
	public void setPrecioRepariones(int precioRepariones) {
		this.precioReparaciones = precioRepariones;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Reparaciones [numReparacion=" + numReparacion + ", numArticulo=" + numArticulo + ", precioRepariones="
				+ precioReparaciones + "€" + ", descripcion=" + descripcion + "]";
	}
	
	
}
