package com.electionbooth.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.electionbooth.bean.Admin;
import com.electionbooth.bean.Candidate;
import com.electionbooth.service.DAOService;

@Controller
public class LoginController {

	private ElectionService electionService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("admin", new Admin());
		return model;
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute("adminLoginData") Admin admin) {
		ModelAndView model = null;
		String message = null;
		try {
			List<Admin> adminCredentials = electionService.adminValidation(admin);
			List<Candidate> candidateData = electionService.candidateList();
			if (admin != null) {
				model = new ModelAndView("/view/AdminView");
				model.addObject("admin", adminCredentials);
				model.addObject("candidate", candidateData);
				model.addObject("message",message);
			}
		} catch (Exception ex) {
			model = new ModelAndView("/view/error");
			model.addObject("errorMessage", ex.getMessage());
			ex.printStackTrace();
		}
		return model;
	}
}