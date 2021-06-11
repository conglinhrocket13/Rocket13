package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.ultis.jdbcUltis;

public class CandidateRepository implements ICandidateRepository{
	private jdbcUltis jdbc;
	
	
	public CandidateRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	
	@Override
	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Candidate WHERE Email LIKE ? AND `Password` LIKE ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, email);
		preStatement.setNString(2, password);
		ResultSet result = preStatement.executeQuery();
		
		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	@Override
	public boolean createExperience(ExperienceCandidate Exp) throws ClassNotFoundException, SQLException {
		String sql = ("INSERT INTO Candidate(FirstName, LastName, Phone, Email, `Password`, ExpInYear, ProSkill, `Type`)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, 'Experienced')");
		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, Exp.getFirstName());
		preStatement.setNString(2, Exp.getLastName());
		preStatement.setNString(3, Exp.getPhone());
		preStatement.setNString(4, Exp.getEmail());
		preStatement.setNString(5, Exp.getPassword());
		preStatement.setFloat(6, Exp.getExpInYear());
		preStatement.setNString(7, Exp.getProSkill());
		
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	@Override
	public boolean createFresher(FresherCandidate Fresh)
			throws SQLException, ClassNotFoundException {
		String sql = ("INSERT INTO Candidate(FirstName, LastName, Phone, Email, `Password`, GraduationRank, `Type`)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?, 'Fresher')");
		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, Fresh.getFirstName());
		preStatement.setNString(2, Fresh.getLastName());
		preStatement.setNString(3, Fresh.getPhone());
		preStatement.setNString(4, Fresh.getEmail());
		preStatement.setNString(5, Fresh.getPassword());
		preStatement.setNString(6, Fresh.getGraduationRank());
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	@Override
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Candidate WHERE Email = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, email);
		ResultSet result = preStatement.executeQuery();

		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	

}
