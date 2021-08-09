package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.service.QnAWriteService;
import find.vo.QnAWriteCommand;

@Controller
@RequestMapping("/admin/questionPageWrite")
public class AdminQnAWriteController {

	
	private QnAWriteService qnAWriteService;
	
	public void setQnAWriteService(QnAWriteService qnAWriteService) {
		this.qnAWriteService = qnAWriteService;
	}
	
	// 글작성
		@RequestMapping(method=RequestMethod.GET)
		public String qnAWrite(QnAWriteCommand qnAWriteCommand) {
			
			return "admin/questionPageWrite";
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String qnARegist(QnAWriteCommand qnAWriteCommand) {
			qnAWriteService.qnAWrite(qnAWriteCommand);
			return "redirect:/admin/adminQuestionPage";
		}
}
