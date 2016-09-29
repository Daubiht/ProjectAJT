package fr.intech.s5.tp.banque.web;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "WEB-INF/index.jsp";
	}

	
}
