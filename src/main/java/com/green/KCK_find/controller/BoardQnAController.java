package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.CriteriaQnABoard;
import find.vo.PageMakerQnABoard;
import find.vo.QnABoard;

@Controller
public class BoardQnAController {
private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}	
	
	public int memberCount() {
		return dao.qnaCount();
	}
	
	
	 @RequestMapping("/questionPage/questionPage")
	   public String list(@ModelAttribute("cri") CriteriaQnABoard cri, Model model) {
	      
	      List<QnABoard> questions= dao.selectAllQnABoard(cri);
	      model.addAttribute("questions",questions);
	      
	      PageMakerQnABoard pageMaker = new PageMakerQnABoard();
	      pageMaker.setCri(cri);
	      pageMaker.setTotalCount(memberCount());
	      model.addAttribute("pageMaker",pageMaker);
	      
	      return "questionPage/questionPage";
	      
	      
	   }
   
}