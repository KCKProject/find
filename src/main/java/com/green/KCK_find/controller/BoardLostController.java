package com.green.KCK_find.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.CriteriaMainBoard;
import find.vo.LostBoard;
import find.vo.PageMakerMainBoard;

@Controller
public class BoardLostController {

	
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	public int lostCount() {
		return dao.lostCount();
	}
	
	// 게시글 목록 불러오기
	@RequestMapping("/lostPage/lostPageList")
	public String lost(@ModelAttribute("cri") CriteriaMainBoard cri, Model model/* HttpServletRequest request */) {
		
		//test code
//	    String uploadPath=request.getSession().getServletContext().getRealPath("/resources/img/");
//	    System.out.println(uploadPath +"현 경로");
//		
		
		List<LostBoard> losts = dao.selectAllLostBoard(cri);
		model.addAttribute("losts",losts);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(lostCount());
		ResponseEntity<byte[]> imgUrl = dao.disPlay(detail, request);
		
		model.addAttribute("imgUrl", imgUrl);
		model.addAttribute("pageMaker",pageMaker);
		
		return "lostPage/lostPageList";
	}
	
	// 글 클릭시 상세보기 메서드
	@RequestMapping("/lostPage/lostPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		System.out.println("도착");
		dao.updateLostHit(boardNum);
		System.out.println("완성");
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
	
	// 글 삭제 메서드
	@RequestMapping("/lostPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum) {

		dao.deleteByLostBoardNum(boardNum);
		return "redirect:/lostPage/lostPageList";
	}
	
	// 발견완료/미발견 체크박스 변경 메서드
	@RequestMapping("/lostPage/changeMeet/{boardNum}&{meet}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model) throws Exception{
		
		String board = "lostBoard";
		dao.updateMeet(boardNum, meet, board);
		LostBoard detail = dao.selectByBoardNum(boardNum);
		
		model.addAttribute("detail", detail);
		return "lostPage/lostPageDetail";
	}
	

//	@RequestMapping("/lostPage/lostPagePhotoList/{boardNum}")
//	public ResponseEntity<byte[]> displayFile(long boardNum, HttpServletRequest request) throws Exception{
//		
//		System.out.println("boardNum : "+boardNum);
//	    return lostBoardWriteService.disPlay(boardNum, request);
//	}

}
