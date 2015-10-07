package pe.egcc.app.ejm02;

import org.springframework.stereotype.Repository;

@Repository
public class Venta {
	
	public double procesar(double precio, int cant){
		return (precio * cant);
	}

}
