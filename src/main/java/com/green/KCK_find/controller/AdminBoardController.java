package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.Criteria;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.PageMaker;

@Controller
public class AdminBoardController {
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	public int lostCount() {
		return dao.lostCount();
	}
	
	public int findCount() {
		return dao.findCount();
	}

	@RequestMapping(value = "/admin/adminBoard", method = RequestMethod.GET)
	public String lostlist(@ModelAttribute("cri") Criteria cri, Model model) {
		
		List<LostBoard> losts = dao.selectAllLostBoard(cri);
		model.addAttribute("losts",losts);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(lostCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "admin/adminBoard";
	}
	
	
	@RequestMapping(value = "/admin/adminFindBoard", method = RequestMethod.GET)
	public String findlist(@ModelAttribute("cri") Criteria cri, Model model) {
		
		List<FindBoard> finds = dao.selectAllFindBoard(cri);
		model.addAttribute("finds",finds);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(findCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "admin/adminBoard";
	}
}
