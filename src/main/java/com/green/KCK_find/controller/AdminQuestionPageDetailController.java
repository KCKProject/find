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
	// 글삭제
	@RequestMapping("/admin/questionDelete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {
			dao.deleteByQnABoardNum(boardNum);
		return "redirect:/admin/adminQuestionPage";
		}
	// 공개 비공개
	@RequestMapping("/admin/changeOpen/{boardNum}&{open}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("open") int open,
							 Model model){
		String board = "QnABoard";
		dao.updateOpen(boardNum, open, board);
		QnABoard detail = dao.selectByQuestionBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "redirect:/admin/adminQuestionPage";
	}
	
}