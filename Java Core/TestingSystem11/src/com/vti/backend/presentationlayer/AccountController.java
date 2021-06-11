package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.backend.businesslayer.AccountService;
import com.vti.entity.Account;

public class AccountController {
	private AccountService service;

	public AccountController() throws FileNotFoundException, IOException {
		service = new AccountService();
	}
	
	public ArrayList<Account> getListAccounts() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		return service.getListAccounts();
	}
	
	 
	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return service.getAccByID(id);
	}

	 
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return service.isAccNameExists(name);
	}

	 
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return service.createAccount(acc, depId, posId);
	}

	 
	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.delAccByID(ID);
	}

	 
	public boolean updateFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return service.updateFullName(id, newFullName);
	}
}
