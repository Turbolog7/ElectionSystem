package com.electionbooth.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;

import com.electionbooth.bean.Admin;
import com.electionbooth.bean.Candidate;

@Repository
public class ElectionDaoImpl implements ElectionDao {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int candidateEntryAdd(Candidate candidate) {
		String sql = "";
		int resultRowsEffected = 0;
		try {
			sql = "insert into candidates(name,description,candidateId) values('" + candidate.getName() + "','"
					+ candidate.getDescription() + "','" + candidate.getCandidateId() + "')";
			resultRowsEffected = template.update(sql);
		} catch (DataAccessException DAEx) {
			DAEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultRowsEffected;
	}

	public List<Candidate> candidateList() {
		String sql = "";
		List<Candidate> candidate = null;
		try {
			sql = "select name,description,candidateId from candidates";
			candidate = template.query(sql, new CandidateMapper());
		} catch (DataAccessException DAEx) {
			DAEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return candidate.size() > 0 ? candidate : null;
	}

	public List<Admin> adminValidation(Admin admin) {
		String sql = "";
		List<Admin> adminlist = null;
		try {
			sql = "select * from Users where userName='" + admin.getUserName() + "' and password ='"
					+ admin.getPassword() + "'";
			adminlist = template.query(sql, new AdminMapper());
		} catch (DataAccessException DAEx) {
			DAEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return adminlist.size() > 0 ? adminlist : null;
	}

	public List<Candidate> electionResult() {
		String sql = "";
		List<Candidate> winnerCandidate = null;
		try {
			sql = "select * from candidates where vote = '(select Max(vote) from candidates)'";
			winnerCandidate = template.query(sql, new VoteMapper());
		} catch (DataAccessException DAEx) {
			DAEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return winnerCandidate.size() > 0 ? winnerCandidate : null;
	}

	public int castVote(int id) {
		int updatedRows = 0;
		String sql = null;
		int votes = 0;
		try {
			sql = "select votes from candidates where candidateId ='" + id + "'";
			List<Candidate> voteList = template.query(sql, new VoteMapper());
			for (Candidate can : voteList) {
				votes = can.getVotes();
			}
			votes = votes + 1;

			sql = "update candidates SET votes ='" + votes + "' where candidateId ='" + id + "'";
			updatedRows = template.update(sql);

		} catch (DataAccessException DAEx) {
			DAEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return updatedRows;
	}

}

class CandidateMapper implements RowMapper<Candidate> {

	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setName(rs.getString("name"));
		candidate.setDescription(rs.getString("description"));
		candidate.setCandidateId(rs.getInt("candidateId"));
		return candidate;
	}
}

class VoteMapper implements RowMapper<Candidate> {

	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidate candidate = new Candidate();
		candidate.setName(rs.getString("name"));
		candidate.setCandidateId(rs.getInt("candidateId"));
		candidate.setVotes(rs.getInt("votes"));
		return candidate;
	}
}

class AdminMapper implements RowMapper<Admin> {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin admin = new Admin();
		admin.setUserName(rs.getString("userName"));
		admin.setPassword(rs.getString("password"));
		return admin;
	}

}