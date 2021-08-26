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
import find.vo.FindBoard;
import find.vo.PageMakerMainBoard;
import find.vo.SearchCriteriaMainBoard;
import find.vo.UploadImgVo;

@Controller
public class BoardFindController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	

	// 게시글 목록 불러오기
	@RequestMapping("/findPage/findPageList")
	public String find(@ModelAttribute("cri") SearchCriteriaMainBoard cri, Model model) {
		
		List<FindBoard> finds = dao.selectAllFindBoard(cri);
		model.addAttribute("finds",finds);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.searchFindCount(cri));
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "findPage/findPageList";
	}
	
	// 글 클릭시 상세보기 메서드
	@RequestMapping("/findPage/findPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		dao.updateFindHit(boardNum);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		String where = "findNum";
		List<UploadImgVo> imgs = dao.selectUploadImgByBoardNum(boardNum, where);
		
		model.addAttribute("detail", detail);
		model.addAttribute("imgs", imgs);
		
		// 댓글 리스트
		String board = "FindComment";
		List<CommentVo> cList = dao.selectAllComment(boardNum, board);
		model.addAttribute("cList", cList);
		
		return "findPage/findPageDetail";
	}
	
	// 댓글 등록
	@ResponseBody
	@RequestMapping(value="/findPage/findPageDetail/writeComment", method=RequestMethod.POST)
	public int writeComment(@RequestParam("writer") String writer,
							@RequestParam("bno") long bNum,
							@RequestParam("text") String content,
							HttpSession session) {
		int result=0;
		
		CommentVo cVo = new CommentVo();
		cVo.setbNum(bNum);
		cVo.setWriter(writer);
		cVo.setContent(content);

		result = dao.insertFindComment(cVo);

		return result;
	}
	
	// 댓글 목록 조회
	@ResponseBody
	@RequestMapping(value="/findPage/findPageDetail/commentList", method=RequestMethod.POST)
	public List<CommentVo> selectAllComment(@RequestParam("bNo") long bNum) {
		String board = "FindComment";
		List<CommentVo> cList = dao.selectAllComment(bNum, board);
		
		return cList;
	}
	
	// 댓글 수정
	@ResponseBody
	@RequestMapping(value="/findPage/findPageDetail/modifyComment", method=RequestMethod.POST)
	public int modifyComment(@RequestParam("cNum") long cNum,
							 @RequestParam("content") String content) {
		int result = 0;
		String board = "findComment";
		result = dao.modifyComment(cNum, content, board);
		return result;
	}
	
	// 댓글 삭제
	@ResponseBody
	@RequestMapping(value="/findPage/findPageDetail/deleteComment")
	public int deleteComment(@RequestParam("cNum") long cNum) {
		int result = 0;
		String board = "findComment";
		result = dao.deleteComment(cNum, board);
		return result;
	}
	
	// 글 삭제 메서드
	@RequestMapping("/findPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum,
						 HttpServletRequest request) {
		// 첨부파일 삭제
		// image = storedFileName = 저장된 이미지 이름			
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
		
		// 게시글 댓글 삭제
		String board = "findComment";
		dao.deleteCommentByBoardNum(boardNum, board);
					
		// 게시글 DB 삭제
		dao.deleteByFindBoardNum(boardNum);
		return "redirect:/findPage/findPageList";
		}
		
	// 발견완료, 미발견 체크박스 변경 메서드
	@RequestMapping("/findPage/changeMeet/{boardNum}&{meet}")
	public String changeMeet(@PathVariable("boardNum") long boardNum,
							 @PathVariable("meet") int meet,
							 Model model){
		String board = "findBoard";
		dao.updateMeet(boardNum, meet, board);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
		return "redirect:/findPage/findPageDetail/"+boardNum;
	}
}
