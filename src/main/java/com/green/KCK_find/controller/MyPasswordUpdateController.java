package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.service.MemberAuthService;
import find.utils.SHA256Util;
import find.validator.MyPasswordCommandValidator;
import find.vo.MemberAuthInfo;
import find.vo.MyPasswordUpdateCommand;

@Controller
//@RequestMapping("/myPage/myPasswordUpdate/{memberAuthInfo.getMemberNumber}")
public class MyPasswordUpdateController {
	
	@Autowired
	private MemberAuthService memberAuthService;
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
//	public void setMemberAuthService(MemberAuthService memberAuthService) {
//		this.memberAuthService = memberAuthService;
//	}
	

	@RequestMapping(value="/myPage/myPasswordUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.GET)
	public String modify(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyPasswordUpdateCommand myPasswordUpdateCommand) {
		MemberAuthInfo myPasswordUpdate = dao.selectByMemberNumber1(memberNumber);
		model.addAttribute("myPasswordUpdate",myPasswordUpdate);
				
		return "/myPage/myPasswordUpdate";
	}
	
	@RequestMapping(value="/myPage/myPasswordUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.POST)
	public String myPasswordUpdate(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyPasswordUpdateCommand myPasswordUpdateCommand, HttpSession session, HttpServletRequest req, HttpServletResponse response, Errors errors) {
		
		new MyPasswordCommandValidator().validate(myPasswordUpdateCommand,errors);
		if(errors.hasErrors()) {
			return "myPage/myPasswordUpdate";
		}
		try {
			String newPwd = myPasswordUpdateCommand.getUserPasswordNew();
			myPasswordUpdateCommand.setUserPasswordNew(SHA256Util.SHA256Encrypt(newPwd));
			MemberAuthInfo myPasswordUpdate = new MemberAuthInfo(myPasswordUpdateCommand.getUserId(),myPasswordUpdateCommand.getUserPasswordNew());
			dao.myPasswordUpdate(memberNumber, myPasswordUpdate);
		}
		catch(Exception e) {
			return "myPage/myPasswordUpdate";
		}
		
		
//		MemberAuthInfo i = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
//		i.setUserPassword(myPasswordUpdateCommand.getUserPasswordNewConfirm());
//		session.setAttribute("memberAuthInfo",i);
		
		return "redirect:/myPage/myPage/"+memberNumber;
	}
}
