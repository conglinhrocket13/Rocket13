package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.ultis.ScannerUltis;

public class CandidateService implements ICandidateService {
	private CandidateRepository repository;

	
	public CandidateService() throws FileNotFoundException, IOException {
		repository = new CandidateRepository();
	}
	
	@Override
	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException {
		
		
		
		return repository.Login(email, password);
	}

	@Override
	public boolean createExperience(ExperienceCandidate Exp) throws ClassNotFoundException, SQLException {
			
		return repository.createExperience(Exp);
	}

	@Override
	public boolean createFresher(FresherCandidate Fresh) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.createFresher(Fresh);
	}

	@Override
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
		Boolean check = repository.isEmailExists(email);
		if(check) {
			return true;
		}else {
			return false;
		}
	}

}
