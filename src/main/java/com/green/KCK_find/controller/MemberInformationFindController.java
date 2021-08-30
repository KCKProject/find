package com.green.KCK_find.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.utils.SHA256Util;
import find.validator.MemberInfoFindById;
import find.validator.MemberInfoFindByPassword;
import find.validator.MemberInfoFindByPasswordChange;
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
	public String memberInformationFindByPassword(Member member) {
		return "enter/memberInformationFindByPassword";
	}
	@RequestMapping(value="/enter/memberInformationFindByPassword", method=RequestMethod.POST)
	public String memberInformationFindByPassword2(Member member, Model model, Errors errors) {
		new MemberInfoFindByPassword().validate(member, errors);
		
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
	
	@RequestMapping(value="/enter/memberInformationFindByPasswordChanges/{userId}", method=RequestMethod.GET)
	public String memberInformationFindByPassword1(@PathVariable("userId") String userid, Member member, Model model) {
		List<Member> members = dao.selectByUserId2(userid);
		model.addAttribute("members",members);
		System.out.println("넘겨주는 값  : "+members.get(0).getUserPassword());
		return "enter/memberInformationFindByPasswordChanges";
	}
	
	@RequestMapping(value="/enter/memberInformationFindByPasswordChanges/{userId}", method=RequestMethod.POST )
	public String myPasswordUpdate(Member member, MyPasswordUpdateCommand myPasswordUpdateCommand, Errors errors, Model model) {
		new MemberInfoFindByPasswordChange().validate(member,errors);
		System.out.println(member.getUserPasswordNewConfirm());
		
		if(errors.hasErrors()) {
			return "enter/memberInformationFindByPasswordChanges";
		}
		try {
			String salt = SHA256Util.getSalt();
			myPasswordUpdateCommand.setSalt(salt);
			String newPwd = myPasswordUpdateCommand.getUserPasswordNew();
			myPasswordUpdateCommand.setUserPasswordNew(SHA256Util.SHA256Encrypt(newPwd,salt));
			MemberAuthInfo myPasswordUpdate = new MemberAuthInfo(myPasswordUpdateCommand.getUserId(),myPasswordUpdateCommand.getUserPasswordNew());
			dao.myPasswordUpdate(myPasswordUpdate, salt);
		}
		catch(Exception e) {
			return "enter/memberInformationFindByPasswordChanges/"+member.getUserId();
		}
		return "redirect:/enter/login";
	}
	//아이디 찾기
	@RequestMapping(value="/enter/memberInformationFindById", method=RequestMethod.GET)
	public String memberInformationFindById(Member member, Model model) {
		
		return "enter/memberInformationFindById";
	}
	
	@RequestMapping(value="/enter/memberInformationFindById", method=RequestMethod.POST)
	public String memberInformationFindById2(Member member, Model model, Errors errors) {
		
		new MemberInfoFindById().validate(member, errors);
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

