package com.green.KCK_find.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.LostBoard;

@Controller
public class MainController {
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	public int lostCount() {
		return dao.lostCount();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		List<LostBoard> losts = dao.selectMainLostBoard();
		List<LostBoard> reviews = dao.selectMainReviewBoard();
		
		model.addAttribute("losts",losts);	
		model.addAttribute("reviews", reviews);
		
		return "main";
	}
	
}
