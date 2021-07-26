package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.exception.AlreadyExistionMemberException;
import find.service.SignUpService;
import find.validator.SignUpCommandValidator;
import find.vo.SignUpCommand;

@Controller
@RequestMapping("/enter/signUp")
public class SignUpController {

	private SignUpService signUpService;

	public void setSignUpService(SignUpService signUpService) {
		this.signUpService = signUpService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String handlerStep2Get(Model model, SignUpCommand signUpCommand) {
		model.addAttribute("signUpCommand",new SignUpCommand());
		return "enter/signUp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String handlerStep(@ModelAttribute("signUpCommand") SignUpCommand suCommand, Errors errors) {
		
		new SignUpCommandValidator().validate(suCommand,errors);
		if(errors.hasErrors()) {
			return "enter/signUp";
		}
		try {
			signUpService.regist(suCommand);
			return "redirect:/main";
		}catch(AlreadyExistionMemberException e) {
			System.out.println("중복 에러 발생");
			errors.rejectValue("email", "duplicate"); //이메일이 중복이 됩니다.
			return "enter/signUp";
		}	
		
	}
}
