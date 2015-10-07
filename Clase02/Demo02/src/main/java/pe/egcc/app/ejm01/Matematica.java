package pe.egcc.app.ejm01;

import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
//@Controller
@Named
public class Matematica {

	public int sumar(int n1, int n2){
		return (n1 + n2);
	}
}
