package com.invoices.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		Application obj = new Application();
		obj.run();
	}

	private void run() {

	//	String[] springConfig = { "META-INF/spring/module-context.xml" };
		String[] springConfig = { "META-INF/spring/launch-context.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	
		System.out.println(context.getApplicationName());

	}
}