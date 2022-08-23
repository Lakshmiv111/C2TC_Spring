package com.cg.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {

	public static void main(String[] args) {
		
		ApplicationContext c = new ClassPathXmlApplicationContext("beans.xml");
		
		student s1 = c.getBean("s1",student.class);
		s1.cheating();
		
		Student1 s2 = c.getBean("s2",Student1.class);
		s2.startcheating();
		
		Student2 s3 =  c.getBean("s3",Student2.class);
		s3.cheating1();
	}

}
