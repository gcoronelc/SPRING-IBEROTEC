package pe.egcc.ejm02;

public class Ejm02Service {
	
	private Mate mate;
	private Venta venta;
	private int version;
	
	public void setMate(Mate mate) {
		this.mate = mate;
	}
	
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getVersion() {
		return version;
	}
	
	public int sumar(int n1, int n2){
		return mate.sumar(n1, n2);
	}
	
	public double calcVenta(double precio, int cant){
		return venta.calular(precio, cant);
	}
	

}
