package com.fastcampus.ch2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		// 로그인 안 되어있으면 로그인창으로 이동 
		if(!loginCheck(request)) 
			// URI: 프로젝트 + 파일경로 , URL: 전체 경로 
			return "redirect:/login/login?toURL=" + request.getRequestURL();
		
		return "boardList";	// 로그인 상태면, 게시판 화면으로 이동 
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1. 세션을 얻어서
		HttpSession session = request.getSession();
		
		// 2. 세션에 id가 있는지 확인, 있으면 true 반환 
		return session.getAttribute("id") != null;
	}
}
