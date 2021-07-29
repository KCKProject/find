package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FindBoardList {

	@RequestMapping(value = "/findPage/findPageList", method = RequestMethod.GET)
	public String list() {
		return "findPage/findPageList";
	}
}
