package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.service.MemberAuthService;
import find.vo.MemberAuthInfo;
import find.vo.MyPasswordUpdateCommand;

@Controller
@RequestMapping("/myPage/myPasswordUpdate/{memberAuthInfo.getMemberNumber}")
public class MyPasswordUpdateController {
	
	private MemberAuthService memberAuthService;
	
	public void setMemberAuthService(MemberAuthService memberAuthService) {
		this.memberAuthService = memberAuthService;
	}
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public String modify(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyPasswordUpdateCommand myPasswordUpdateCommand) {
		MemberAuthInfo myPasswordUpdate = dao.selectByMemberNumber1(memberNumber);
		model.addAttribute("myPasswordUpdate",myPasswordUpdate);
				
		return "/myPage/myPasswordUpdate";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String myPasswordUpdate(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyPasswordUpdateCommand myPasswordUpdateCommand, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		MemberAuthInfo myPasswordUpdate = new MemberAuthInfo(
				myPasswordUpdateCommand.getUserId(), myPasswordUpdateCommand.getUserPasswordNew(), myPasswordUpdateCommand.getUserPasswordNewConfirm());
		
		dao.myPasswordUpdate(memberNumber, myPasswordUpdate);
		
		MemberAuthInfo i = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		i.setUserPassword(myPasswordUpdateCommand.getUserPasswordNewConfirm());
		
		session.setAttribute("memberAuthInfo",i);
		
		return "myPage/myPasswordUpdate";
	}

}
