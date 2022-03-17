package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {
	//https://beausty23.tistory.com/3
	
	//http://localhost:8090/ch2/getYoilMVC?year=2022&month=3&day=17
	@RequestMapping("/getYoilMVC")
	public ModelAndView main(int year, int month, int day) throws IOException{
		ModelAndView mav = new ModelAndView();
		
		// 1. 유효성 검사
//		if(!isValid(year,month,day)) {
//			return "yoilError";
//		}
		
		// 2. 요일 계산
		char yoil = getYoil(year, month, day);
		
		// 3. 결과를 model에 저장 
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("day",day);
		mav.addObject("yoil",yoil);
		
		// 4. 결과를 보여줄 view 지정 
		mav.setViewName("yoil");
		
		return mav;
//		return "yoil";	// /WEB-INF/views/yoil.jsp
		
	
	}

	//현재 클래스에서만 사용하므로 접근제어자 private
	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); //1: 일요일, 2: 월요일
		return " 일월화수목금토".charAt(dayOfweek);
	}
}
