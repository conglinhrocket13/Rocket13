package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.backend.datalayer.AccountRepository;
import com.vti.entity.Account;

public class AccountService implements IAccountService{
	private AccountRepository repository;

	public AccountService() throws FileNotFoundException, IOException {
		repository = new AccountRepository();
	}
	
	@Override
	public ArrayList<Account> getListAccounts() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return repository.getListAccounts();
	}

	@Override
	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return repository.getAccByID(id);
	}

	@Override
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.isAccNameExists(name);
	}

	@Override
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return repository.createAccount(acc, depId, posId);
	}

	@Override
	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.delAccByID(ID);
	}

	@Override
	public boolean updateFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return repository.updateFullName(id, newFullName);
	}
}
