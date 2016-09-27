package fr.intech.s5.service;

import org.springframework.beans.factory.annotation.Autowired;

public class GreetingsImpl implements Greetings {

	@Autowired
	private HelloIntech hello;
	
	/**
	 * Constructeur
	*/
		public GreetingsImpl() {
	}
	
	/**
	* Constructeur
	* @param hello
	*/
	public GreetingsImpl(HelloIntech hello) {			
		this.hello = hello;
	}

	
	@Override
	public String meetSomeone(String pName) {
		return hello.sayHello(pName);
	}
	
	public void setHello(HelloIntech pHello) {
        hello = pHello;
	}

}