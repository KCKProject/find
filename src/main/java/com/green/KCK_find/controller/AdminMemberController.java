package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.Criteria;
import find.vo.Member;
import find.vo.PageMaker;
import find.vo.SearchCriteria;

@Controller
public class AdminMemberController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	
	public int searchMemberCount(SearchCriteria scri) {
		return dao.searchMemberCount(scri);
	}

	@RequestMapping(value = "/admin/adminMember", method= RequestMethod.GET)
	public String list(@ModelAttribute("scri") SearchCriteria cri, Model model) {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(searchMemberCount(cri));
		model.addAttribute("pageMaker",pageMaker);
		
		List<Member> members= dao.searchSelectAll(cri);
		model.addAttribute("members",members);
		
		return "admin/adminMember";
	}
	
//	@RequestMapping(value = "/searchMember", method= RequestMethod.GET)
//	public String listsearch(@ModelAttribute("scri") SearchCriteria scri, Model model) {
//	
//		List<Member> members= dao.searchSelectAll(scri);
//		model.addAttribute("members",members);
//		
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(scri);
//		pageMaker.setTotalCount(memberCount());
//		model.addAttribute("pageMaker",pageMaker);
//		
//		return "admin/adminMember";
//	}
	
}
