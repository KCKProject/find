package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.QnABoard;


@Controller
public class AdminQuestionPageDetailController {

	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/admin/questionDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		
		QnABoard qnABoard = dao.selectByQuestionBoardNum(boardNum);
		
		if(qnABoard == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("qnABoard",qnABoard);
		
		return "admin/adminQuestionDetail";
	}
	
}