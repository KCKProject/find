package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLogOutController {

	@RequestMapping("/admin/logout")
	public String logout(HttpSession session1,HttpServletRequest req) {
		session1.invalidate();
		
		return "redirect:/admin";
	}
}
