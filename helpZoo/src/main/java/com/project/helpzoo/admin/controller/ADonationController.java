package com.project.helpzoo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.helpzoo.admin.model.service.ADonationService;

@Controller
@RequestMapping("/admin/donation/*")
public class ADonationController {
	
	@Autowired
	private ADonationService adonationService;
	
	@RequestMapping("main")
	public ModelAndView donationList(ModelAndView mv) {
		return mv;
	}

}
