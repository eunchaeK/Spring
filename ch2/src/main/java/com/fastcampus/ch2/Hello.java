package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {
	int iv = 10;
	private static int cv = 20;
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	private void main() {
		System.out.println("Hello-private");
	}
	
	private static void main2() {
		System.out.println("cv: " + cv);
		//System.out.println("iv: " + iv);
	}
}
