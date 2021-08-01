package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import find.service.SignUpService;*/

@Controller
public class ServicePageController {

	@RequestMapping("/servicePage/servicePage")
	public String servicePage(HttpSession session,HttpServletRequest req) {
		session.invalidate();
		
		return "servicePage/servicePage";
	}
	
}

