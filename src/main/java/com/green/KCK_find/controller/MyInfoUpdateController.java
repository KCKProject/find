package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.Member;
import find.vo.MemberAuthInfo;
import find.vo.MemberUpdateCommand;
import find.vo.MyInfoUpdateCommand;

@Controller
public class MyInfoUpdateController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value="/myPage/myInfoUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.GET)
	public String modify1(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyInfoUpdateCommand myInfoUpdateCommand) {
		
		MemberAuthInfo myInfoUpdate = dao.selectByMemberNumber1(memberNumber);
		if(myInfoUpdate == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("myInfoUpdate",myInfoUpdate);
		
		return "/myPage/myInfoUpdate";
	}
	
	@RequestMapping(value="/myPage/myInfoUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.POST)
	public String myInfoUpdate(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, MyInfoUpdateCommand myInfoUpdateCommand) {
				
		MemberAuthInfo myInfoUpdate = new MemberAuthInfo(
				myInfoUpdateCommand.getUserName(), myInfoUpdateCommand.getPhone(), myInfoUpdateCommand.getEmail());
		
		dao.myInfoUpdate(memberNumber, myInfoUpdate);
		return "redirect:/myPage/myInfoUpdate";
	}

}
