package pe.egcc.app.ejm03;

import org.springframework.stereotype.Repository;

@Repository
public class MateImpl1 implements IMatematica{

	@Override
	public int sumar(int n1, int n2){
		return (n1 + n2);
	}

}
