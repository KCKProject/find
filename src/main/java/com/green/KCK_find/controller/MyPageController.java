package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.vo.LostBoardWriteCommand;

@Controller
public class MyPageController {
	
	@RequestMapping(value = "/myPage/myPage", method=RequestMethod.GET)
	public String myPage() {
	
		return "myPage/myPage";
	}
	
	
}

