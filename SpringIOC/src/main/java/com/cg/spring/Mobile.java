package com.cg.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		
		ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
		
		Sim a = c.getBean("sim",Sim.class);
		a.calling();
		a.data();
		
//		Jio j = (Jio)c.getBean("jio");
//		j.calling();
//		j.data();
//		
//		Vi v = c.getBean("vi",Vi.class);
//		v.calling();
//		v.data();

	}
}
