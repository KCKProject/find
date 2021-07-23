package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LostBoardList {
	
	@RequestMapping("/lostPage/lostPage")
	public String list() {
		return "member/memberList";
	}
}
