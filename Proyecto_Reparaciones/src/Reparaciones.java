public class Reparaciones {
	int numReparacion;
	int numArticulo;
	int precioRepariones;
	String descripcion;
	
	public Reparaciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reparaciones(int numReparacion, int numArticulo, int precioRepariones, String descripcion) {
		super();
		this.numReparacion = numReparacion;
		this.numArticulo = numArticulo;
		this.precioRepariones = precioRepariones;
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
		return precioRepariones;
	}
	
	public void setPrecioRepariones(int precioRepariones) {
		this.precioRepariones = precioRepariones;
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
				+ precioRepariones + "€" + ", descripcion=" + descripcion + "]";
	}
	
	
}
