package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.FindBoard;
import find.vo.LostBoard;

@Controller
public class BoardFindController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	// 글 목록 불러오기
	@RequestMapping("/findPage/findPageList")
	public String find(Model model) {
		
		List<FindBoard> find = dao.selectAllFindBoard();
		model.addAttribute("find",find);
		
		return "findPage/findPageList";
	}
	
	// 글 클릭시 상세보기 메서드
		@RequestMapping("/findPage/findPageDetail/{boardNum}")
		public String detail(@PathVariable("boardNum") long boardNum, Model model) {
			FindBoard detail = dao.selectByFindBoardNum(boardNum);
			
			model.addAttribute("detail", detail);
			
			return "findPage/findPageDetail";
		}
		
	// 글 삭제 메서드
	@RequestMapping("/findPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {

		dao.deleteByFindBoardNum(boardNum);
		return "redirect:/findPage/findPageDetail";
		}
		
	// 발견완료/미발견 체크박스 변경 메서드
	@RequestMapping("/findPage/changeMeet/{boardNum}&{meet}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		String board = "findBoard";
		dao.updateMeet(boardNum, meet, board);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "findPage/findPageDetail";
	}
}
