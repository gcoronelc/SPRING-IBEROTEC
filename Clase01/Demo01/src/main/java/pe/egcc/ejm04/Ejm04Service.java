package pe.egcc.ejm04;

public class Ejm04Service {
	
	private Mate mate;
	private Venta venta;
	private int version;
	
	public Ejm04Service(Mate mate, Venta venta, int version) {
		super();
		this.mate = mate;
		this.venta = venta;
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
