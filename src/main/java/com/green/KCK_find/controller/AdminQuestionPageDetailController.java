package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.QnABoard;
import find.vo.QnAWriteCommand;


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
	
	// 글 수정 
	@RequestMapping(value="/admin/qnaModify/{boardNum}", method=RequestMethod.GET)
	public String modify(@PathVariable("boardNum") long boardNum, Model model, QnAWriteCommand qnAWriteCommand) {
		
		QnABoard qnABoard = dao.selectByQuestionBoardNum(boardNum);
		model.addAttribute("qnABoard",qnABoard);
		
		return "admin/adminQuestionUpdate";
	}
	@RequestMapping(value="/admin/qnaModify/{boardNum}", method=RequestMethod.POST)
	public String qnAUpdate(@PathVariable("boardNum") long boardNum, QnAWriteCommand qnAWriteCommand) {
				
		QnABoard updateQnA = new QnABoard(
				qnAWriteCommand.getTitle(),qnAWriteCommand.getWriter(),qnAWriteCommand.getContents(),
				qnAWriteCommand.getOpen());
		
		dao.updateByQnABoardNum(boardNum, updateQnA);
		return "redirect:/admin/adminQuestionPage";
	}
	
}