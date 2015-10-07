package pe.egcc.ejm05;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String contexto = "/pe/egcc/ejm05/contexto.xml";
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(contexto);
		Ejm05Service bean = beanFactory.getBean(Ejm05Service.class);
		
		bean.mostarDatos();
	}
}
