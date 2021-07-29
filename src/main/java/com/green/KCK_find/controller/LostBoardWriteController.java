package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.LostBoard;

@Controller
@RequestMapping("/lostPage/lostPageWrite")
public class LostBoardWriteController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model, LostBoard lostBoard) {
		model.addAttribute("lostBoard",new LostBoard());
		return "lostPage/lostPageWrite";
	}
}
