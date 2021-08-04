package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.service.LostBoardWriteService;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.QnABoard;

@Controller
public class BoardLostController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	// 게시글 목록 불러오기
	@RequestMapping("/lostPage/lostPageList")
	public String lost(Model model) {
		
		List<LostBoard> losts = dao.selectAllLostBoard();
		model.addAttribute("losts",losts);
		
		return "lostPage/lostPageList";
	}
	
	// 글 클릭시 상세보기 메서드
	@RequestMapping("/lostPage/lostPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
	
	// 글 삭제 메서드
	@RequestMapping("/lostPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {

		dao.deleteByBoardNum(boardNum);
		return "redirect:/lostPage/lostPageList";
	}
	
	// 발견완료/미발견 체크박스 변경 메서드
	@RequestMapping("/lostPage/changeMeet/{boardNum}&{meet}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		
		String board = "lostBoard";
		dao.updateMeet(boardNum, meet, board);
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
}
