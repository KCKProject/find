package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import find.service.SignUpService;
import find.validator.SignUpCommandValidator;
import find.vo.SignUpCommand;

@Controller
//@RequestMapping("/enter/signUp")
public class SignUpController {

	private SignUpService signUpService;

	public void setSignUpService(SignUpService signUpService) {
		this.signUpService = signUpService;
	}

	@RequestMapping(value="/enter/signUp", method = RequestMethod.GET)
	public String handlerStep2Get(Model model, SignUpCommand signUpCommand) {
		model.addAttribute("signUpCommand",new SignUpCommand());
		return "enter/signUp";
	}
	
	@RequestMapping(value="/enter/signUp", method=RequestMethod.POST)
	public String handlerStep(@ModelAttribute("signUpCommand") SignUpCommand suCommand, Errors errors) {
		
		new SignUpCommandValidator().validate(suCommand,errors);
		if(errors.hasErrors()) {
			return "enter/signUp";
		}
		try {
			signUpService.regist(suCommand);
			return "redirect:/";
		}catch(Exception e) {
			return "enter/signUp";
		}		
	}
	
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/enter/signUpIdChk", method=RequestMethod.GET)
	public int idChk(@RequestParam("userId") String userId) {
		int result = 0;
		result = signUpService.signUpIdChk(userId);
		return result;
	}
}
