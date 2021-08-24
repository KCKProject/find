package com.green.KCK_find.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.LostBoard;
import find.vo.PageMakerMainBoard;
import find.vo.SearchCriteriaMainBoard;

@Controller
public class BoardLostController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	
	// 게시글 목록 불러오기
	@RequestMapping("/lostPage/lostPageList")
	public String lost(@ModelAttribute("cri") SearchCriteriaMainBoard cri, Model model, HttpServletRequest request) {
		
		List<LostBoard> losts = dao.selectAllLostBoard(cri);
		model.addAttribute("losts",losts);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.searchLostCount(cri));
		
//		ResponseEntity<byte[]> imgUrl = dao.disPlay(request);
//		
//		model.addAttribute("imgUrl", imgUrl);
		model.addAttribute("pageMaker",pageMaker);
		
		return "lostPage/lostPageList";
	}
	
	// 글 클릭시 상세보기 메서드
	@RequestMapping("/lostPage/lostPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		dao.updateLostHit(boardNum);
		LostBoard detail = dao.selectByBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "lostPage/lostPageDetail";
	}
	
	// 글 삭제 메서드
		@RequestMapping("/lostPage/delete/{boardNum}")
		public String delete(@PathVariable("boardNum") long boardNum,
							 HttpServletRequest request) {
			// 첨부파일 삭제
			// image = storedFileName = 저장된 이미지 이름
			LostBoard detail = dao.selectByBoardNum(boardNum);
			String image = detail.getStoredFileName();
			String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
			File file = new File(path,image);
			File thumb = new File(path,"s_"+image);
				if(file.exists()) {
					file.delete();
					thumb.delete();
				}
				
			System.out.println("게시물도 잘 삭제됐는지 추후에 확인 필요");
			
			// 게시글 DB 삭제
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
}
