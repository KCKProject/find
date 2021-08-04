package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.QnABoard;

@Controller
public class BoardQnAController {
private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}	
	
	 @RequestMapping("/questionPage/questionPage")
	   public String list(Model model) {
	      
	      List<QnABoard> questions= dao.selectAllQnABoard();
	      model.addAttribute("questions",questions);
	      
	      return "questionPage/questionPage";
	   }
   
}