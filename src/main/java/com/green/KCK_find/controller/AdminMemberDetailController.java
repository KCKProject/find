package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.exception.MemberNotFoundException;
import find.vo.Member;
import find.vo.MemberUpdateCommand;


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
	
	// 회원정보 수정
		@RequestMapping(value="/admin/memberUpdate/{memberNumber}", method=RequestMethod.GET)
		public String modify(@PathVariable("memberNumber") long memberNumber, Model model, MemberUpdateCommand memberUpdateCommand) {
			
			Member member = dao.selectByMemberNumber(memberNumber);
			if(member == null) {
				throw new MemberNotFoundException();
			}
			model.addAttribute("member",member);
			
			return "admin/adminMemberUpdate";
		}
		@RequestMapping(value="/admin/memberUpdate/{memberNumber}", method=RequestMethod.POST)
		public String memberUpdate(@PathVariable("memberNumber") long memberNumber, MemberUpdateCommand memberUpdateCommand) {
					
			Member updatemember = new Member(
					memberUpdateCommand.getUserName(),memberUpdateCommand.getPhone(),memberUpdateCommand.getEmail());
			
			dao.updateByMember(memberNumber, updatemember);
			return "redirect:/admin/adminMember";
		}
	
}
