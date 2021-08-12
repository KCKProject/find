package com.green.KCK_find.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.service.FindBoardWriteService;
import find.service.LostBoardWriteService;
import find.vo.FindBoardWriteCommand;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.WriteReviewDto;

@Controller
@RequestMapping("/findPage/findPageWrite")
public class BoardFindWriteController {

	private FindBoardWriteService findBoardWriterservice;

	public void setFindBoardWriteService(FindBoardWriteService findBoardWriterservice) {
		this.findBoardWriterservice = findBoardWriterservice;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String write(FindBoardWriteCommand findBoardWriteCommand) {
		
		return "findPage/findPageWrite";
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String regist(LostBoardWriteCommand lostBoardWriteCommand, HttpSession session, MultipartHttpServletRequest request) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
		System.out.println("�꽆�뼱�삩 session id : "+member.getUserId());
	
		findBoardWriterservice.boardRegist();			
		return "redirect:/lostPage/lostPageList";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/review")
	public String writeReview(WriteReviewDto dto, HttpSession session) throws IOException {
		MemberAuthInfo member = (MemberAuthInfo) session.getAttribute("memberAuthInfo");
		System.out.println(dto.getReview());
		findBoardWriterservice.writeReview(dto.getReview(), dto.getBoardNum());
		
		return "redirect:/findPage/findPageDetail/" + dto.getBoardNum();
	}
}
