package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.PageMakerQnABoard;
import find.vo.QnABoard;
import find.vo.SearchCriteriaQnABoard;

@Controller
public class BoardQnAController {
private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}	
	
	
	
	
	 @RequestMapping("/questionPage/questionPage")
	   public String list(@ModelAttribute("cri") SearchCriteriaQnABoard cri, Model model) {
	      
	      List<QnABoard> questions= dao.selectAllQnABoard(cri);
	      model.addAttribute("questions",questions);
	      
	      PageMakerQnABoard pageMaker = new PageMakerQnABoard();
	      pageMaker.setCri(cri);
	      pageMaker.setTotalCount(dao.qnaCount(cri));
	      model.addAttribute("pageMaker",pageMaker);
	      
	      return "questionPage/questionPage";
	      
	      
	   }
   
}