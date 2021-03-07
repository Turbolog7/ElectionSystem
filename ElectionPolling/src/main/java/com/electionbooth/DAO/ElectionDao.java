package com.electionbooth.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.electionbooth.bean.Admin;
import com.electionbooth.bean.Candidate;

@Repository
public interface ElectionDao {

	public int candidateEntryAdd(Candidate candidate);

	public List<Candidate> candidateList();

	public List<Admin> adminValidation(Admin admin);

	public List<Candidate> electionResult();

	public int castVote(int id);

}
