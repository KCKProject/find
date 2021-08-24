package com.green.KCK_find.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import find.dao.FindDao;
import find.service.LostBoardWriteService;
import find.validator.BoardLostCommandValidator;
import find.vo.CommentVo;
import find.vo.LostBoard;
import find.vo.LostBoardWriteCommand;
import find.vo.MemberAuthInfo;
import find.vo.WriteReviewDtoLost;

@Controller
public class BoardLostWriteController {

	private LostBoardWriteService lostBoardWriteService;
	
	public void setLostBoardWriteService(LostBoardWriteService lostBoardWriteService) {
		this.lostBoardWriteService = lostBoardWriteService;
	}
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value="/lostPage/lostPageWrite", method=RequestMethod.GET)
	public String write(LostBoardWriteCommand lostBoardWriteCommand) {
		
		return "lostPage/lostPageWrite";
	}

	// 글 등록
//	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		@RequestMapping(value="/lostPage/lostPageWrite", method=RequestMethod.POST)
		public String regist(LostBoardWriteCommand lostBoardWriteCommand, HttpSession session,
				MultipartHttpServletRequest request, Errors errors) throws IOException {

			new BoardLostCommandValidator().validate(lostBoardWriteCommand, errors);
			if(errors.hasErrors()) {
				return "lostPage/lostPageWrite";
			}
			try {
				lostBoardWriteService.boardRegist(lostBoardWriteCommand, session, request);			
				return "redirect:/lostPage/lostPageList";
			}catch(Exception e) {
				e.printStackTrace();
				return "lostPage/lostPageWrite";
			}
		}
	
	// 글 수정
		@RequestMapping(value="/lostPage/lostPageWrite/modify/{boardNum}", method=RequestMethod.GET)
		public String lostModify(@PathVariable("boardNum") long boardNum, Model model, 
				LostBoardWriteCommand lostBoardWriteCommand) {
			LostBoard detail = dao.selectByBoardNum(boardNum);
			model.addAttribute("detail", detail);
			
			return "lostPage/lostPageModify";
		}
			
		@RequestMapping(value="/lostPage/lostPageWrite/modify/{boardNum}", method=RequestMethod.POST)
		public String lostModifyRegist(@PathVariable("boardNum") long boardNum,
				LostBoardWriteCommand lc, HttpSession session, MultipartHttpServletRequest request, Errors errors) throws IOException{

			new BoardLostCommandValidator().validate(lc, errors);
			MemberAuthInfo member = (MemberAuthInfo)session.getAttribute("memberAuthInfo");
			LostBoard detail = dao.selectByBoardNum(boardNum);
			if(errors.hasErrors()) {
				return "lostPage/lostPageModify";
			}
			try {
				lostBoardWriteService.modifyLost(lc, detail, member, request);		
			}catch(Exception e) {
				e.printStackTrace();
				return "lostPage/lostPageModify";
			}
			return "redirect:/lostPage/lostPageDetail/"+boardNum;
		}
	
	// 후기 추가
		@RequestMapping(value="/lostPage/lostPageWrite/review", method=RequestMethod.POST)
		public String writeReview(WriteReviewDtoLost dto, HttpSession session) throws IOException {
			MemberAuthInfo member = (MemberAuthInfo) session.getAttribute("memberAuthInfo");
			System.out.println(dto.getReview());
			lostBoardWriteService.writeReview(dto.getReview(), dto.getBoardNum());
	
			return "redirect:/lostPage/lostPageDetail/" + dto.getBoardNum();
		}
		
		/*
		 * // 댓글 등록
		 * 
		 * @RequestMapping(value="/lostPage/writeComment", method=RequestMethod.POST)
		 * 
		 * @ResponseBody public String writeComment(CommentVo cVo, HttpSession session)
		 * { MemberAuthInfo user =
		 * (MemberAuthInfo)session.getAttribute("memberAuthInfo"); String userId =
		 * user.getUserId(); String comment = cVo.getContent();
		 * System.out.println("userId : "+userId);
		 * System.out.println("comment : "+comment); System.out.println("댓글 등록 구현");
		 * 
		 * return "lostPage/lostPageList"; }
		 */
}
