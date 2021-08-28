package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.exception.IdPasswordNotMatchingException;
import find.service.MemberAuthService;
import find.utils.SHA256Util;
import find.validator.MemberLoginCommandVaildator;
import find.vo.MemberAuthInfo;
import find.vo.MemberLoginCommand;

@Controller
@RequestMapping("/enter/login")
public class LoginController {
		private FindDao dao;
		
		public void setDao(FindDao dao) {
			this.dao = dao;
		}	
	
	
		@Autowired
		private MemberAuthService memberAuthService;
		
		public void setMemberAuthService(MemberAuthService memberAuthService) {
			this.memberAuthService = memberAuthService;
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String form(MemberLoginCommand memberLoginCommand) {

			return "enter/login";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String submit(MemberLoginCommand memberLoginCommand, Errors errors, HttpSession session, HttpServletRequest req, HttpServletResponse response) throws Exception {	
			new MemberLoginCommandVaildator().validate(memberLoginCommand, errors);
			
			if(errors.hasErrors()) {
				return "enter/login";
			}
			try {				
				String pwd = memberLoginCommand.getUserPassword();
				memberLoginCommand.setUserPassword(SHA256Util.SHA256Encrypt(pwd)); 
				MemberAuthInfo memberAuthInfo = memberAuthService.authenticate(memberLoginCommand.getUserId(), memberLoginCommand.getUserPassword());
				session = req.getSession();
				session.setAttribute("memberAuthInfo", memberAuthInfo);
				
				return "redirect:/";
			}catch(IdPasswordNotMatchingException e) {
				errors.reject("idPasswordNotMatching");
				return "enter/login";
			}
		}
}
