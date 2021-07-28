package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.LostBoard;

@Controller
public class LostBoardDetailController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/lostPage/lostPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
}
