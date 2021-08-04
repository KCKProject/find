package com.green.KCK_find.controller;

import java.lang.reflect.Parameter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.service.LostBoardWriteService;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;

@Controller
@RequestMapping("/lostPage/lostPageWrite")
public class BoardLostWriteController {

	private LostBoardWriteService lostBoardWriteService;
	
	public void setlostBoardWriteService(LostBoardWriteService lostBoardWriteService) {
		this.lostBoardWriteService = lostBoardWriteService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String write(LostBoardWriteCommand lostBoardWriteCommand) {
		
		return "lostPage/lostPageWrite";
	}
	
	@RequestMapping(method=RequestMethod.POST)
		public String regist(@ModelAttribute("lostBoardWriteCommand") LostBoardWriteCommand lostBoardWriteCommand,
					          HttpSession session, MultipartHttpServletRequest request) {
			MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
			System.out.println("session id의 값 : "+member.getUserId());
		
			lostBoardWriteService.boardRegist(lostBoardWriteCommand, session, request);			
			return "redirect:/lostPage/lostPageList";
		}
}
