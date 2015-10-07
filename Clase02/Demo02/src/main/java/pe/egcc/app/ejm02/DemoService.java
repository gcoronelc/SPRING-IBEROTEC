package pe.egcc.app.ejm02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	@Autowired
	private Matematica mate;
	
	private Venta venta;
	
	@Autowired
	public DemoService(Venta venta) {
		this.venta = venta;
	}
	
	public int sumar(int n1, int n2){
		return mate.sumar(n1, n2);
	}
	
	public double calVenta(double precio, int cant){
		return venta.procesar(precio, cant);
	}

}
