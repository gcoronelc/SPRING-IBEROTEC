package pe.egcc.ejm04;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String contexto = "/pe/egcc/ejm04/contexto.xml";
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(contexto);
		Ejm04Service bean = beanFactory.getBean(Ejm04Service.class);
		
		System.out.println(bean.sumar(15, 18));
		System.out.println(bean.calcVenta(456.99, 10));
		System.out.println(bean.getVersion());
	}
}
