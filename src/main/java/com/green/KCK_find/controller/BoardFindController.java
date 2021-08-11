package com.green.KCK_find.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.vo.CriteriaMainBoard;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.PageMakerMainBoard;
import find.vo.WriteReviewDto;

@Controller
public class BoardFindController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	public int findCount() {
		return dao.findCount();
	}

	// 湲� 紐⑸줉 遺덈윭�삤湲�
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
	
	// 湲� �겢由��떆 �긽�꽭蹂닿린 硫붿꽌�뱶
	@RequestMapping("/findPage/findPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		dao.updateFindHit(boardNum);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);

		model.addAttribute("detail", detail);
		
		return "findPage/findPageDetail";
	}
	
	// 湲� �궘�젣 硫붿꽌�뱶
	@RequestMapping("/findPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {

		dao.deleteByFindBoardNum(boardNum);
		return "redirect:/findPage/findPageDetail";
		}
		
	// 諛쒓껄�셿猷�/誘몃컻寃� 泥댄겕諛뺤뒪 蹂�寃� 硫붿꽌�뱶
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
