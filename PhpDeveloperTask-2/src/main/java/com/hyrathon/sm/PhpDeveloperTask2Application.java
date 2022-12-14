package com.hyrathon.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

/*Spring Boot auto configuration, 
It is a combination of three annotations @EnableAutoConfiguration,
@ComponentScan, and @Configuration.@EnableAutoConfiguration: 
enables the auto-configuration feature of Spring Boot.
@ComponentScan:enables @Component scan on the package to discover and 
register components as beans in Spring’s application Context.
@Configuration: allows to register extra beans in the context 
or imports additional configuration classes.*/

public class PhpDeveloperTask2Application {

	public static void main(String[] args) {
		SpringApplication.run(PhpDeveloperTask2Application.class, args);
	}

}
/*
 Whenever we create a SpringBootApplication by default one class is getting created
 that class is called as Main class or Start Class.
 From This main class or start class only we should run the application.
 */
