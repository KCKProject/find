package com.green.KCK_find.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.service.LostBoardWriteService;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;

@Controller
public class BoardLostWriteController {

	private LostBoardWriteService lostBoardWriteService;
	
	public void setLostBoardWriteService(LostBoardWriteService lostBoardWriteService) {
		this.lostBoardWriteService = lostBoardWriteService;
	}
	
	@RequestMapping(value="/lostPage/lostPageWrite", method=RequestMethod.GET)
	public String write(LostBoardWriteCommand lostBoardWriteCommand) {
		
		return "lostPage/lostPageWrite";
	}
	
//	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@RequestMapping(value="/lostPage/lostPageWrite", method=RequestMethod.POST)
	public String regist(LostBoardWriteCommand lostBoardWriteCommand, HttpSession session, MultipartHttpServletRequest request) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("넘어온 session id : "+member.getUserId());
	
		lostBoardWriteService.boardRegist(lostBoardWriteCommand, session, request);			
		return "redirect:/lostPage/lostPageList";
	}
	
	// 글 수정
	@RequestMapping(value="/lostPage/lostPageModify", method=RequestMethod.POST)
	public String regist(LostBoard lostBoard, HttpSession session) {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("넘어온 lostBoard : "+lostBoard.getAnimal());
		System.out.println("넘어온 session id : "+member.getUserId());
	
		return "redirect:/lostPage/lostPageList";
	}
	
	
	
}
