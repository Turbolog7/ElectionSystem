package com.electionbooth.bean;

public class Candidate {
	private String name;
	private String description;
	private int candidateId;
	private int votes;

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Candidate() {
		super();
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", description=" + description + ", candidateId=" + candidateId + ", votes="
				+ votes + "]";
	}
}
