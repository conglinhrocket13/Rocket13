package com.vti.backend.datalayer;

import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;

public interface ICandidateRepository {

	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean createExperience(ExperienceCandidate Exp) throws ClassNotFoundException, SQLException;

	public boolean createFresher(FresherCandidate Fresh) throws SQLException, ClassNotFoundException;
	
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException;
}
