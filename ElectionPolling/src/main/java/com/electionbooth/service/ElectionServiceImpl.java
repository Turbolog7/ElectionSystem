package com.electionbooth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electionbooth.DAO.ElectionDao;
import com.electionbooth.bean.Admin;
import com.electionbooth.bean.Candidate;

@Service
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionDao electionDao;

	public int candidateEntryAdd(Candidate candidate) {
		return electionDao.candidateEntryAdd(candidate);
	}

	public List<Candidate> candidateList() {
		return electionDao.candidateList();
	}

	public List<Admin> adminValidation(Admin admin) {
		return electionDao.adminValidation(admin);
	}

	public List<Candidate> electionResult() {
		return electionDao.electionResult();
	}

	public int castVote(int id) {
		return electionDao.castVote(id);
	}

}
