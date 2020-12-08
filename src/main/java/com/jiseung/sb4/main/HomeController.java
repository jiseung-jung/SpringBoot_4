package com.jiseung.sb4.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home() throws Exception{
		System.out.println("Home Controller");
		return "index";
	}
}
