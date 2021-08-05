package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.CriteriaMainBoard;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.PageMakerMainBoard;

@Controller
public class BoardFindController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	public int findCount() {
		return dao.findCount();
	}

	// 글 목록 불러오기
	@RequestMapping("/findPage/findPageList")
	public String find(@ModelAttribute("cri") CriteriaMainBoard cri, Model model) {
		
		List<FindBoard> find = dao.selectAllFindBoard(cri);
		model.addAttribute("find",find);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(findCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "findPage/findPageList";
	}
	
	// 글 클릭시 상세보기 메서드
		@RequestMapping("/findPage/findPageDetail/{boardNum}")
		public String detail(@PathVariable("boardNum") long boardNum, Model model) {
			dao.updateFindHit(boardNum);
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
