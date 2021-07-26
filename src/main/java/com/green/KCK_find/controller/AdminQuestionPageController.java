package com.green.KCK_find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminQuestionPageController {

	@RequestMapping("/admin/adminQuestionPage")
	public String list() {
		return "/admin/adminQuestionPage";
	}
}
