package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@InitBinder		// 이 Controller 내에서만 사용 가능 -> 전역 사용 시 WebBindingInitializer 사용
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
//		System.out.println("ConversionService=" + conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));		// Date로 변환할 때 형식 지정 
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));	//hobby라는 필드 변환에만 사용 
//		binder.setValidator(new UserValidator());	// UserValidator를 WebDataBinder의 로컬 validator로 등록 
//		binder.addValidators(new UserValidator());	// UserValidator를 WebDataBinder의 로컬 validator로 등록 
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList=" + validatorList);
	}
	
	
	@RequestMapping(value = "/register/add", method={RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";	// WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value = "/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")	// 4.3부터
	public String save(@Valid User user, BindingResult result, Model m) throws Exception{	//BindingResult 위치 조심! 바인딩할 객체 바로 뒤에 위치.
		System.out.println("result=" + result);
		System.out.println("user=" + user);
		
		// 수동 검증 - Validator를 직젖ㅂ 생성하고, validate()를 직접 호출 
//		UserValidator userValidator = new UserValidator();
//		userValidator.validate(user, result);		// BindingResult는 Errors의 자손 
		
		// User객체를 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여준다 
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		// 1. 유효성 검사
//		if(!isValid(user)){
//			String msg= URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
//			m.addAttribute("msg", msg);
//			
//			return "forward:/register/add";	//URL재작성(rewriting)
////			return "redirect:/register/add";	//URL재작성(rewriting)
////			return "redirect:/register/add?msg="+msg;	//URL재작성(rewriting)
//		}
		
		m.addAttribute("user", user);
		
		// 2. DB에 신규회원 정보를 저장 
		
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
