package com.green.KCK_find.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.validator.MyPasswordCommandValidator;
import find.vo.Member;
import find.vo.MemberAuthInfo;
import find.vo.MyPasswordUpdateCommand;

@Controller
public class MemberInformationFindController {
	
	private FindDao dao;

	public void setDao(FindDao dao) {
		this.dao = dao;
	}
	
	// 비밀번호 찾기
	@RequestMapping(value="/enter/memberInformationFindByPassword", method=RequestMethod.GET)
	public String memberInformationFindByPassword(Member member, Model model) {
		return "enter/memberInformationFindByPassword";
	}
	@RequestMapping(value="/enter/memberInformationFindByPassword", method=RequestMethod.POST)
	public String memberInformationFindByPassword2(Member member, Model model, Errors errors) {
		if(errors.hasErrors()) {
			return "enter/memberInformationFindByPassword";
		}
		try {
			List<Member> members= dao.selectMemberForPwd(member);
			model.addAttribute("members",members);
			return "enter/memberInformationFindByPasswordChange";
		}
		catch(Exception e) {
			return "enter/memberInformationFindByPassword";
		}
					
	}
	@RequestMapping(value="/enter/memberInformationFindByPasswordChange", method=RequestMethod.POST)
	public String myPasswordUpdate(Member member, MyPasswordUpdateCommand myPasswordUpdateCommand, Errors errors, Model model) {
		new MyPasswordCommandValidator().validate(myPasswordUpdateCommand,errors);
		
		if(errors.hasErrors()) {
			return "enter/memberInformationFindByPasswordChange";
		}
		try {
			System.out.println("진행3");
			MemberAuthInfo myPasswordUpdate = new MemberAuthInfo(myPasswordUpdateCommand.getUserId(),myPasswordUpdateCommand.getUserPasswordNew());
			dao.myPasswordUpdate(member.getUserId(), myPasswordUpdate);
		}
		catch(Exception e) {
			return "enter/memberInformationFindByPasswordChange";
		}
		
		return "enter/login";
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

