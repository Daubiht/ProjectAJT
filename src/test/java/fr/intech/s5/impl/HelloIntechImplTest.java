package fr.intech.s5.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.intech.s5.service.HelloIntech;

public class HelloIntechImplTest {
	
	ApplicationContext context;
	
	HelloIntech hello;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("app-context.xml");
		hello = (HelloIntech) context.getBean("hello");
	}
	
	@Test
	public void testSayHello() {
		String sHello = hello.sayHello("Martin");
		assertEquals("Hello Martin", sHello);
	}

}
