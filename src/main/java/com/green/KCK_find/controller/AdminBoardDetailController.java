package com.green.KCK_find.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.FindBoard;
import find.vo.LostBoard;
import find.vo.UploadImgVo;

@Controller
public class AdminBoardDetailController {

	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/admin/lostBoardDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		
		LostBoard lostBoard = dao.selectByBoardNum(boardNum);
		
		if(lostBoard == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("lostBoard",lostBoard);
		
		return "admin/adminLostBoardDetail";
	}
	
	@RequestMapping("/admin/findBoardDetail/{boardNum}")
	public String detail2(@PathVariable("boardNum") long boardNum, Model model) {
		
		FindBoard findBoard = dao.selectByFindBoardNum(boardNum);
		
		if(findBoard == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("findBoard",findBoard);
		
		return "admin/adminFindBoardDetail";
	}
	
	// 공개 비공개
	@RequestMapping("/admin/changeFindMeet/{boardNum}&{meet}")
	public String changeFindMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		String board = "findBoard";
		dao.updateMeet(boardNum, meet, board);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "redirect:/admin/adminFindBoard";
	}
	
	@RequestMapping("/admin/changeLostMeet/{boardNum}&{meet}")
	public String changeLostMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		String board = "lostBoard";
		dao.updateMeet(boardNum, meet, board);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "redirect:/admin/adminBoard";
	}
	
	// 삭제
	@RequestMapping("/admin/lostBoardDelete/{boardNum}")
	public String deleteLost(@PathVariable("boardNum") long boardNum, HttpServletRequest request) {
		// 첨부파일 삭제
		System.out.println("boardNum : "+boardNum);
		String where = "lostNum";
		List<UploadImgVo> imgs = dao.selectUploadImgByBoardNum(boardNum, where);

		for(UploadImgVo i : imgs) {
			String image = i.getStoredFileName();
			String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
			File file = new File(path,image);
				if(file.exists()) {
					file.delete();
				}
		}
		dao.deleteImgByBoardNum(boardNum,where);
		
		String board = "lostComment";		
		dao.deleteCommentByBoardNum(boardNum, board);
		
		dao.deleteByLostBoardNum(boardNum);
		
		return "redirect:/admin/adminBoard";
	}
	
	@RequestMapping("/admin/findBoardDelete/{boardNum}")
	public String deleteFind(@PathVariable("boardNum") long boardNum, HttpServletRequest request) {
		System.out.println("boardNum : "+boardNum);
		String where = "findNum";
		List<UploadImgVo> imgs = dao.selectUploadImgByBoardNum(boardNum, where);

		for(UploadImgVo i : imgs) {
			String image = i.getStoredFileName();
			String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
			File file = new File(path,image);
				if(file.exists()) {
					file.delete();
				}
		}
		dao.deleteImgByBoardNum(boardNum,where);
		String board = "findComment";
		dao.deleteCommentByBoardNum(boardNum, board);
		
		dao.deleteByFindBoardNum(boardNum);
			
		return "redirect:/admin/adminFindBoard";
	}
}
