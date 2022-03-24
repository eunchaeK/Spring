package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch2") 	// 지정된 패키지에서 발생한 예외만 처리
//@ControllerAdvice // 모든 패키지에 적용 
public class GlobalCatcher {
	// @ExceptionHandler 해당 컨트롤러 내에서만 가능 ->  @ControllerAdvice 로 모든 컨트롤러에서 사용하도록 함.
	// 각 클래스에 따로 @ExceptionHandler가 있으면 가까운 쪽 핸들러로 처리.
//	@ExceptionHandler(Exception.class)		
//	public String catcher(Exception ex, Model m) {
////		m.addAttribute("ex", ex);
//		return "error";
//	}
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})		// 예외처리 메서드 
	public String catcher2(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
		return "error";
	}
}
