package com.electionbooth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.electionbooth.bean.Admin;
import com.electionbooth.bean.Candidate;

@Service
public interface ElectionService {

	public int candidateEntryAdd(Candidate candidate);

	public List<Candidate> candidateList();

	public List<Admin> adminValidation(Admin admin);

	public List<Candidate> electionResult();

	public int castVote(int id);
}
