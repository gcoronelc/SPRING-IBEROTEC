package pe.egcc.ejm01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	public static void main(String[] args) {
		
		String contexto = "/pe/egcc/ejm01/contexto.xml";
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(contexto);
		
		// MateService mateService = (MateService) beanFactory.getBean("objeto");
		// MateService mateService = beanFactory.getBean("objeto",MateService.class);
		MateService mateService = beanFactory.getBean(MateService.class);
		
		System.out.println(mateService.sumar(15, 18));
	}
}
