package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	
//	@ExceptionHandler(Exception.class)		// 예외처리 메서드 
//	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "error";
//	}
//	
//	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})		// 예외처리 메서드 
//	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "error";
//	}
	
	@RequestMapping("/ex3")
	public String main() throws Exception{
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception{
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
	
}//end class
