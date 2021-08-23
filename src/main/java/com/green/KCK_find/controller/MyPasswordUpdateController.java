package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;

@Controller
public class MyPasswordUpdateController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/myPage/myPasswordUpdate/{memberAuthInfo.getMemberNumber}", method=RequestMethod.GET)
	public String myPasswordUpdate(@PathVariable("memberAuthInfo.getMemberNumber") long memberNumber , Model model) {
//		List<MyPageLostPostCommand> lostPosts = dao.userLostPost(memberNumber);
//		model.addAttribute("lostPosts",lostPosts);
//		

		
		return "myPage/myPasswordUpdate";
	}

}
