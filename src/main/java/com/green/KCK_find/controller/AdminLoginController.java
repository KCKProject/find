package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.validator.AdminLoginCommandVaildator;
import spring.exception.IdPasswordNotMatchingException;
import spring.service.AdminAuthService;
import spring.vo.AdminAuthInfo;
import spring.vo.AdminLoginCommand;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	private AdminAuthService adminAuthService;
	
	public void setAdminAuthService(AdminAuthService adminAuthService) {
		this.adminAuthService = adminAuthService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form(AdminLoginCommand adminLoginCommand) {
		return "admin/adminLogin";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(AdminLoginCommand adminLoginCommand, Errors errors, HttpSession session, HttpServletRequest req, HttpServletResponse response) {	
		new AdminLoginCommandVaildator().validate(adminLoginCommand, errors);
		
		if(errors.hasErrors()) {
			return "admin/adminLogin";
		}
		try {
			AdminAuthInfo adminAuthInfo = adminAuthService.authenticate(adminLoginCommand.getAdminId(), adminLoginCommand.getAdminPassword());
			HttpSession session1 = req.getSession();
			session1.setAttribute("adminAuthInfo", adminAuthInfo);
			
			return "admin/adminMain";
		}
		catch(IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "admin/adminLogin";
		}
	}
}
