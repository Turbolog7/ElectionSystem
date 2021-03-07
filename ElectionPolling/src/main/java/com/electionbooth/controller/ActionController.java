package com.electionbooth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.electionbooth.bean.Candidate;
import com.electionbooth.service.DAOService;

@Controller
@RequestMapping(value = "/electionCommission", method = { RequestMethod.GET, RequestMethod.POST })
public class ActionController {

	@Autowired
	private ElectionService electionservice;

	@RequestMapping(value = "/addCandidate", method = RequestMethod.GET)
	public ModelAndView candidateEntry() {
		ModelAndView model = new ModelAndView("/view/candidateForm");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("candidateData") Candidate candidate) {
		ModelAndView model = null;
		String message = null;
		try {
			if (candidate != null) {
				int result = electionservice.candidateEntryAdd(candidate);
				if (result > 0) {
					model = new ModelAndView("redirect:/view/AdminView");
					message = "data saved successfully!!";
					model.addObject("message", message);
				} else {
					message = "data not saved correctly! please try again!!";
					model = new ModelAndView("redirect:/view/AdminView");
					model.addObject("message", message);
				}
			}

		} catch (Exception ex) {
			model = new ModelAndView("/errorPage");
			model.addObject("errorMessage", ex.getMessage());
			ex.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/viewCandidates", method = RequestMethod.GET)
	public ModelAndView VoterView() {

		ModelAndView model = null;
		try {
			List<Candidate> candidateData = electionservice.candidateList();
			if (!candidateData.isEmpty()) {
				model = new ModelAndView("/view/GuestView");
				model.addObject("candidateData", candidateData);
			} else {
				String message = "No voter's have been registered yet for Election's";
				model = new ModelAndView("/view/GuestView");
				model.addObject("message", message);
				model.addObject("candidateData", candidateData);
			}
		} catch (Exception ex) {
			model = new ModelAndView("/errorPage");
			model.addObject("errorMessage", ex.getMessage());
			ex.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/electionResult", method = RequestMethod.GET)
	public ModelAndView results() {
		ModelAndView model = null;
		try {
			List<Candidate> winnerCandidate = electionservice.electionResult();
			if (!winnerCandidate.isEmpty()) {
				model = new ModelAndView("/view/ElectionResult");
				model.addObject("result", winnerCandidate);
			} else {
				String message = "Voting still in progress! Result will be declared once voting is done";
				model = new ModelAndView("/view/ElectionResult");
				model.addObject("message", message);
			}
		} catch (Exception ex) {
			model = new ModelAndView("/errorPage");
			model.addObject("errorMessage", ex.getMessage());
			ex.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/vote/{id}", method = RequestMethod.POST)
	public ModelAndView voting(@RequestParam("id") int id) {
		ModelAndView model = null;
		String message = null;
		try {
			int voteCasted = electionservice.castVote(id);
			if (voteCasted > 0) {
				model = new ModelAndView("/view/GuestView");
				message = "vote casted successfully";
				model.addObject("message", message);
			} else {
				model = new ModelAndView("/view/GuestView");
				message = "vote was not casted! please try again";
				model.addObject("message", message);
			}
		} catch (Exception ex) {
			model = new ModelAndView("/errorPage");
			model.addObject("errorMessage", ex.getMessage());
			ex.printStackTrace();
		}
		return model;
	}
}
