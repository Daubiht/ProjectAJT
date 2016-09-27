package fr.intech.s5.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.intech.s5.service.Greetings;
import fr.intech.s5.service.HelloIntech;

public class GreetingsImplTest {

	ApplicationContext context;
	Greetings greetings;
	
	@Before
	public void before() {
		//context = new ClassPathXmlApplicationContext("app-context.xml");
		//greetings =(Greetings) context.getBean("Greetings");	
	}
	
	@Test
	public void testSayGreetings() {
		String sHello = greetings.meetSomeone("Martin");
		assertEquals("Hello Martin", sHello);
	}
}