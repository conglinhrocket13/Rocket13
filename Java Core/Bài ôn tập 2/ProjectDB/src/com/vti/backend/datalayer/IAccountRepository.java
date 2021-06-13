package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;


public interface IAccountRepository {

	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean createManager(Manager acc) throws ClassNotFoundException, SQLException;

	public boolean createEmployee(Employee acc) throws SQLException, ClassNotFoundException;
	
	public Boolean isEmailExists(String email) throws SQLException, ClassNotFoundException;
	
	public List<Manager> getListManagersInProject(int id) throws ClassNotFoundException, SQLException;
	
	public List getProjectAccounts(int id) throws ClassNotFoundException, SQLException;
}
