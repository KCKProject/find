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
import find.vo.MemberAuthInfo;
import find.vo.PageMakerMainBoard;
import find.vo.SearchCriteriaMainBoard;

@Controller
public class BoardFindController {

	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	public int findCount() {
		return dao.findCount();
	}

	// 글 목록 불러오기
	@RequestMapping("/findPage/findPageList")
	public String find(@ModelAttribute("cri") SearchCriteriaMainBoard cri, Model model) {
		
		List<FindBoard> finds = dao.selectAllFindBoard(cri);
		model.addAttribute("finds",finds);
		
		PageMakerMainBoard pageMaker = new PageMakerMainBoard();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(findCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "findPage/findPageList";
	}
	
	// 글 클릭시 상세보기 메서드
	@RequestMapping("/findPage/findPageDetail/{boardNum}")
	public String detail(@PathVariable("boardNum") long boardNum, Model model) {
		dao.updateFindHit(boardNum);
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		model.addAttribute("detail", detail);
		
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
	
	// 글 삭제 메서드
	@RequestMapping("/findPage/delete/{boardNum}")
	public String delete(@PathVariable("boardNum") long boardNum,
						 HttpServletRequest request) {
		// 첨부파일 삭제
		// image = storedFileName = 저장된 이미지 이름
		FindBoard detail = dao.selectByFindBoardNum(boardNum);
		String image = detail.getStoredFileName();
		String path = request.getSession().getServletContext().getRealPath("resources/imgUpload");
		File file = new File(path,image);
		File thumb = new File(path,"s_"+image);
			if(file.exists()) {
				file.delete();
				thumb.delete();
			}
	
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
		
		return "findPage/findPageDetail";
	}
}
