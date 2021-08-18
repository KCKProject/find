package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.Criteria;
import find.vo.PageMaker;
import find.vo.QnABoard;
import find.vo.SearchCriteria;


@Controller
public class AdminQuestionPageController {
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	public int memberCount() {
		return dao.qnaAllCount();
	}
	
	

	@RequestMapping("/admin/adminQuestionPage")
	public String list(@ModelAttribute("scri") SearchCriteria cri, Model model) {
		
		List<QnABoard> questions= dao.selectAllQnABoard(cri);
		model.addAttribute("questions",questions);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "admin/adminQuestionPage";
	}
	
	
	
}
