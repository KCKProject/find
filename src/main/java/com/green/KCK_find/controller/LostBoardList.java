package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.LostBoard;

@Controller
public class LostBoardList {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/lostPage/lostPageList")
	public String list(Model model) {
		
		List<LostBoard> losts = dao.selectAllLostBoard();
		model.addAttribute("losts",losts);
		
		return "lostPage/lostPageList";
	}
}
