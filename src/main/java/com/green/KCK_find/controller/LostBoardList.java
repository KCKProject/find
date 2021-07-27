package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;

@Controller
public class LostBoardList {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/lostPage/lostPage")
	public String list(Model model) {
		
		return "lostPage/lostPage";
	}
}
