package com.green.KCK_find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.service.MemberAuthService;
import find.vo.MemberAuthInfo;
import find.vo.MemberLoginCommand;
import find.vo.MyInfoUpdateCommand;

@Controller
public class MyInfoUpdateController {
	
	@Autowired
	private MemberAuthService memberAuthService;
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value="/myPage/myInfoUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.GET)
	public String modify1(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, Model model, MyInfoUpdateCommand myInfoUpdateCommand) {
		
		MemberAuthInfo myInfoUpdate = dao.selectByMemberNumber1(memberNumber);
//		if(myInfoUpdate == null) {
//			throw new MemberNotFoundException();
//		}
		model.addAttribute("myInfoUpdate",myInfoUpdate);
		
		return "/myPage/myInfoUpdate";
	}
	
	@RequestMapping(value="/myPage/myInfoUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.POST)
	public String myInfoUpdate(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber, MyInfoUpdateCommand myInfoUpdateCommand, HttpSession session, HttpServletRequest req, HttpServletResponse response) {
		
		System.out.println("넘어온 값 : "+myInfoUpdateCommand.getEmail());
		MemberAuthInfo myInfoUpdate = new MemberAuthInfo(
				myInfoUpdateCommand.getUserName(), myInfoUpdateCommand.getPhone(), myInfoUpdateCommand.getEmail());
		
		dao.myInfoUpdate(memberNumber, myInfoUpdate);
		
		MemberAuthInfo i = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		i.setEmail(myInfoUpdateCommand.getEmail());
		i.setPhone(myInfoUpdateCommand.getPhone());
		i.setUserName(myInfoUpdateCommand.getUserName());
		
		session.setAttribute("memberAuthInfo",i);
			
//		return "myPage/myPage" + i.getUserId();
		return "redirect:/myPage/myInfoUpdate/"+memberNumber;
	}

}
