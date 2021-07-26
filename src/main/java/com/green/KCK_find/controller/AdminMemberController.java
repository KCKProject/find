package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.vo.Member;

@Controller
public class AdminMemberController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/admin/adminMember")
	public String list(Model model) {
	
		List<Member> members= dao.selectAll();
		model.addAttribute("members",members);
		
		return "admin/adminMember";
	}
}
