package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//ctrl+shif+o 자동 import
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse resp)throws IOException {
		int idx1 = (int)(Math.random()*6)+1;
		int idx2 = (int)(Math.random()*6)+1;
		
		
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice" + idx1 + ".jpg'>");
		out.println("<img src='resources/img/dice" + idx2 + ".jpg'>");
		out.println("</body>");
		out.println("</html>");
	}
}
