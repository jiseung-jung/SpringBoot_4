package com.jiseung.sb4.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/**")
public class RestController {

	@GetMapping("member/{name}/{num}")
	public void test(@PathVariable String name, @PathVariable int num){
		
		System.out.println(name);
		System.out.println(num);
		
	}
	
}
