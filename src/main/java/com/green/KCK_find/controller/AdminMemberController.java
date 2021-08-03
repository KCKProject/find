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

@Controller
public class AdminMemberController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	public int memberCount() {
		return dao.memberCount();
	}

	@RequestMapping(value = "/admin/adminMember", method= RequestMethod.GET)
	public String list(@ModelAttribute("cri") Criteria cri, Model model) {
	
		List<Member> members= dao.selectAll(cri);
		model.addAttribute("members",members);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberCount());
		model.addAttribute("pageMaker",pageMaker);
		
		return "admin/adminMember";
	}
	
}
