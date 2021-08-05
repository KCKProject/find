package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.LostBoard;

@Controller
public class AdminBoardDetailController {

	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/admin/lostBoardDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		
		LostBoard lostBoard = dao.selectByBoardNum(boardNum);
		
		if(lostBoard == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("lostBoard",lostBoard);
		
		return "admin/adminLostBoardDetail";
	}
}
