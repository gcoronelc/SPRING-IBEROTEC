package pe.egcc.app.ejm03;

import javax.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	@Autowired
	@Resource(name="mateImpl2")
	private IMatematica mate;
	
	public int sumar(int n1, int n2){
		return mate.sumar(n1, n2);
	}

}
