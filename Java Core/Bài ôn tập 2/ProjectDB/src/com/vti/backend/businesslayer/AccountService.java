package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.ultis.ScannerUltis;

public class AccountService implements IAccountService {
	private AccountRepository repository;

	
	public AccountService() throws FileNotFoundException, IOException {
		repository = new AccountRepository();
	}
	
	@Override
	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException {
			
		return repository.Login(email, password);
	}

	@Override
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException {
		return repository.isEmailExists(email);
	}

	@Override
	public boolean createManager(Manager acc) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.createManager(acc);
	}

	@Override
	public boolean createEmployee(Employee acc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.createEmployee(acc);
	}

	@Override
	public List<Manager> getListManagersInProject(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.getListManagersInProject(id);
	}

	@Override
	public List getProjectAccounts(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.getProjectAccounts(id);
	}

}
