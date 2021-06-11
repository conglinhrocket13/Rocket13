package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.entity.Account;

public interface IAccountRepository {
	
	public ArrayList<Account> getListAccounts() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException; 
	
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException;
	
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException;
	
	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException;
	
	public boolean updateFullName(int id, String newFullName) throws ClassNotFoundException, SQLException;
}
