package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.Member;

@Controller
public class AdminMemberDetailController {

	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/admin/detail/{memberNumber}")
	public String detail(@PathVariable("memberNumber") long id, Model model) {
		
		Member member = dao.selectByMemberNumber(id);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member",member);
		
		return "admin/adminMemberDetail";
	}
	
}
