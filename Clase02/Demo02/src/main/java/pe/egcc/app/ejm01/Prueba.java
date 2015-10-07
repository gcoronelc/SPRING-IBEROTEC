package pe.egcc.app.ejm01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	public static void main(String[] args) {
		
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext("/pe/egcc/app/ejm01/contexto.xml");
		
		Matematica mate = beanFactory.getBean(Matematica.class);
		
		System.out.println(mate.sumar(12, 15));
		
	}

}
