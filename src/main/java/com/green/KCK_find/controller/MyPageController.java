package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	@RequestMapping("/myPage/myPage")
	public String myPage(HttpSession session,HttpServletRequest req) {
		session.invalidate();
		
		return "myPage/myPage";
	}
	
	
}
