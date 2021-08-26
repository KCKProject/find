package com.green.KCK_find.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.Member;

@Controller
public class MemberInformationFindController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="/enter/memberInformationFindByPassword", method=RequestMethod.GET)
	public String memberInformationFindByPassword(HttpSession session,HttpServletRequest req) {
		session.invalidate();
		
		return "enter/memberInformationFindByPassword";
	}
	
	//아이디 찾기
	@RequestMapping(value="/enter/memberInformationFindById", method=RequestMethod.GET)
	public String memberInformationFindById(Member member, Model model) {
		
		return "enter/memberInformationFindById";
	}
	
	@RequestMapping(value="/enter/memberInformationFindById", method=RequestMethod.POST)
	public String memberInformationFindById2(Member member, Model model, Errors errors) {
		
		if(errors.hasErrors()) {
			return "enter/memberInformationFindById";
		}
		try {
			List<Member> members= dao.selectMember(member);
			model.addAttribute("members",members);
			return "enter/memberInformationFindByIdFind";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "enter/memberInformationFindById";
		}
				

		
		
		
	}
	
}

