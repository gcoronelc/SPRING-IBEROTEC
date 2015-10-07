package pe.egcc.app.ejm02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	public static void main(String[] args) {
		
		BeanFactory beanFactory;
		beanFactory = new ClassPathXmlApplicationContext("/pe/egcc/app/ejm02/contexto.xml");
		
		DemoService bean = beanFactory.getBean(DemoService.class);
		
		System.out.println(bean.sumar(12, 15));
		System.out.println(bean.calVenta(550.5, 10));
		
	}

}
