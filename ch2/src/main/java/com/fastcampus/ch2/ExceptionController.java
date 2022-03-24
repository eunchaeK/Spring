package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)					// 예외처리 메서드 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	// 200 -> 500
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() in ExceptionController");
		m.addAttribute("ex", ex);	//main() 메서드와 다른 모델 객체 
		return "error";
	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})		// 예외처리 메서드 
	public String catcher2(Exception ex, Model m) {
		System.out.println("m="+m);
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main() throws Exception{
		throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2(Model m) throws Exception{
		m.addAttribute("msg", "msg from ExceptionController.main()");
		throw new FileNotFoundException("예외가 발생했습니다.");
	}
	
	
}//end class
