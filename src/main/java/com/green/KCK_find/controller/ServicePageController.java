package com.green.KCK_find.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import find.dao.FindDao;
import find.vo.ServiceCommentDto;


@Controller
public class ServicePageController {
	
	private FindDao dao;
	
	public void setDao(FindDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/servicePage/servicePage")
	public String servicePage(HttpSession session,HttpServletRequest req) {
		session.invalidate();
		
		return "servicePage/servicePage";
	}
	
//	@RequestMapping(value="/servicePage/servicePage", method=RequestMethod.POST)
//	public String serviceComment(ServiceCommentDto dto, HttpSession session) throws IOException {
//		System.out.println(dto.getContent());
//		
//		ServiceCommentDto newComment = new ServiceCommentDto(dto.getWriteDate(), dto.getContent());
//		
//		dao.addServiceComment(newComment);
//		
//		return "servicePage/servicePage";
//	}
	
}

