package com.green.KCK_find.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.service.FindBoardWriteService;
import find.validator.BoardFindCommandValidator;
import find.vo.FindBoard;
import find.vo.FindBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.WriteReviewDto;

@Controller
@RequestMapping("/findPage/findPageWrite")
public class BoardFindWriteController {

	private FindBoardWriteService findBoardWriteService;

	public void setFindBoardWriteService(FindBoardWriteService findBoardWriteService) {
		this.findBoardWriteService = findBoardWriteService;
	}
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String write(FindBoardWriteCommand findBoardWriteCommand) {
		
		return "findPage/findPageWrite";
	}
	
	// 글 등록
		@RequestMapping(method=RequestMethod.POST)
		public String regist(FindBoardWriteCommand findBoardWriteCommand, HttpSession session, MultipartHttpServletRequest request, Errors errors) throws IOException {

			new BoardFindCommandValidator().validate(findBoardWriteCommand, errors);
			if(errors.hasErrors()) {
				return "findPage/findPageWrite";
			}
			try {
				findBoardWriteService.boardRegist(findBoardWriteCommand, session, request);			
				return "redirect:/findPage/findPageList";
			}catch(Exception e) {
				return "findPate/findPageWrite";
			}
		}
	
	// 글 수정
		@RequestMapping(value="/modify/{boardNum}", method=RequestMethod.GET)
		public String findModify(@PathVariable("boardNum") long boardNum, Model model, 
				FindBoardWriteCommand fc) {
			FindBoard detail = dao.selectByFindBoardNum(boardNum);
			model.addAttribute("detail", detail);
			
			return "findPage/findPageModify";
		}
			
		@RequestMapping(value="/modify/{boardNum}", method=RequestMethod.POST)
		public String findModifyRegist(@PathVariable("boardNum") long boardNum,
				FindBoardWriteCommand fc, HttpSession session, MultipartHttpServletRequest request, Errors errors) throws IOException{
			
			new BoardFindCommandValidator().validate(fc, errors);
			MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
			FindBoard detail = dao.selectByFindBoardNum(boardNum);
			if(errors.hasErrors()) {
				return "findPage/findPageModify";
			}
			try {
				findBoardWriteService.modifyFind(fc, detail, member, request);
			}catch(Exception e) {
				return "findPate/findPageModify";
			}
			return "redirect:/findPage/findPageDetail/"+boardNum;
		}
			
	// 후기 추가
		@RequestMapping(method=RequestMethod.POST, value = "/review")
		public String writeReview(WriteReviewDto dto, HttpSession session) throws IOException {
//			MemberAuthInfo member = (MemberAuthInfo) session.getAttribute("memberAuthInfo");
			System.out.println(dto.getReview());
			findBoardWriteService.writeReview(dto.getReview(), dto.getBoardNum());
			
			return "redirect:/findPage/findPageDetail/" + dto.getBoardNum();
		}
}
