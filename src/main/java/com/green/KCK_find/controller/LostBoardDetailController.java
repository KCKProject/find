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
	
	@RequestMapping("/lostPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {
		System.out.println("넘어온 boardNum : "+boardNum);
//		dao.deleteByBoardNum(boardNum);
//		
//		System.out.println("삭제 완료");
		return "redirect:/lostPage/lostPageList";
	}
	
	@RequestMapping("/lostPage/changeMeet/{boardNum}&{meet}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		System.out.println("넘어온 boardNum : "+boardNum);
		System.out.println("넘어온 meet : "+meet);
		
		dao.updateMeet(boardNum, meet);
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
}
