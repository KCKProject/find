package com.green.KCK_find.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import find.dao.FindDao;
import find.vo.CommentVo;
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
	public String lost(@ModelAttribute("cri") CriteriaMainBoard cri, Model model, HttpServletRequest request) {
		
		List<LostBoard> losts = dao.selectAllLostBoard(cri);
		model.addAttribute("losts",losts);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(lostCount());
		
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
		
		// 댓글 리스트
		String board = "LostComment";
		List<CommentVo> cList = dao.selectAllComment(boardNum, board);
		model.addAttribute("cList", cList);
		
		return "lostPage/lostPageDetail";
	}
	
	// 댓글 등록
	@ResponseBody
	@RequestMapping(value="/lostPage/lostPageDetail/writeComment", method=RequestMethod.POST)
	public int writeComment(@RequestParam("writer") String writer,
							@RequestParam("bno") long bNum,
							@RequestParam("text") String content,
							HttpSession session) {
		int result=0;
		
		CommentVo cVo = new CommentVo();
		cVo.setbNum(bNum);
		cVo.setWriter(writer);
		cVo.setContent(content);

		result = dao.insertLostComment(cVo);

		return result;
	}
	
	// 댓글 목록 조회
	@ResponseBody
	@RequestMapping(value="/lostPage/lostPageDetail/commentList", method=RequestMethod.POST)
	public List<CommentVo> selectAllComment(@RequestParam("bNo") long bNum) {
		String board = "Lostcomment";
		List<CommentVo> cList = dao.selectAllComment(bNum, board);
		
		return cList;
	}
	
	// 댓글 수정
	@ResponseBody
	@RequestMapping(value="/lostPage/lostPageDetail/modifyComment", method=RequestMethod.POST)
	public int modifyComment(@RequestParam("cNum") long cNum,
							 @RequestParam("content") String content) {
		int result = 0;
		String board = "LostComment";
		result = dao.modifyComment(cNum, content, board);
		return result;
	}
	
	// 댓글 삭제
	@ResponseBody
	@RequestMapping(value="/lostPage/lostPageDetail/deleteComment")
	public int deleteComment(@RequestParam("cNum") long cNum) {
		int result = 0;
		String board = "LostComment";
		result = dao.deleteComment(cNum, board);
		return result;
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
			if(file.exists()) {
				file.delete();
			}
		
		// 게시글 댓글 삭제
		String board = "lostComment";
		dao.deleteCommentByBoardNum(boardNum, board);
		
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
