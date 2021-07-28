package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.LostBoard;

@Controller
public class AdminBoardController {
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/admin/adminBoard", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<LostBoard> losts = dao.selectAllLostBoard();
		model.addAttribute("losts",losts);
		
		return "admin/adminBoard";
	}
}
