package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.MyPageFindPostCommand;
import find.vo.MyPageLostPostCommand;

@Controller
public class MyPageController {
	

	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/myPage/myPage/{memberAuthInfo.getUserId}", method=RequestMethod.GET)
	public String myPageLostPosts(@PathVariable("memberAuthInfo.getUserId") String id, Model model) {
		List<MyPageLostPostCommand> lostPosts = dao.userLostPost(id);
		model.addAttribute("lostPosts",lostPosts);
		
		/////////////////////////////////////////////////////////////////
		
		List<MyPageFindPostCommand> findPosts = dao.userFindPost(id);		
		model.addAttribute("findPosts",findPosts);		
		
		return "myPage/myPage";
	}
	

	
	
}

