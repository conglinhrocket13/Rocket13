package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Manager.ProSkill;
import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

public class AccountRepository implements IAccountRepository{
	private jdbcUltis jdbc;
	
	
	public AccountRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	
	@Override
	public boolean Login(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Account WHERE Email LIKE ? AND `Password` LIKE ?";
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
	public boolean createManager(Manager acc) throws ClassNotFoundException, SQLException {
		String sql = ("INSERT INTO Account(FullName, Email, `Password`, ExpInYear, ProSkill, `Type`)"
				+ "VALUES ( ?, ?, ?, ?, ?, 'Manager')");
		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, acc.getFullName());
		preStatement.setNString(2, acc.getEmail());
		preStatement.setNString(3, acc.getPassword());
		preStatement.setInt(4, acc.getExpInYear());
		preStatement.setNString(5, acc.getProSkill().toString());
		
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
	public boolean createEmployee(Employee acc)
			throws SQLException, ClassNotFoundException {
		String sql = ("INSERT INTO `account` ( FullName, Email, `Password`, `Type`)"
				+ "VALUES 	(?, ?, ?, 'Employee')");
		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, acc.getFullName());
		preStatement.setNString(2, acc.getEmail());
		preStatement.setNString(3, acc.getPassword());
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
		String sql = "SELECT * FROM Account WHERE Email = ?";
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
	
	@Override
	public List<Manager> getListManagersInProject(int id) throws ClassNotFoundException, SQLException{
		String sql ="SELECT a.* FROM `account` a JOIN projectaccount p ON a.AccID = p.AccID WHERE ProID = ? AND `Type` LIKE 'Manager'";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		ArrayList listAcc = new ArrayList();
		while (resultSet.next()) {
			
			int accid = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String email = resultSet.getString(3);
			String password = resultSet.getString(4);
			int ExpInYear = resultSet.getInt(5);
			String Proskill = resultSet.getString(6);

			Manager a = new Manager();
			ProSkill skill = a.DataBaseProskill(Proskill);
			Manager acc = new Manager(accid, name, email, password, ExpInYear, skill);
			listAcc.add(acc);
		}
		return listAcc;
	}
	
	@Override
	public List getProjectAccounts(int id) throws ClassNotFoundException, SQLException {
		String sql ="SELECT a.* FROM `account` a JOIN projectaccount p ON a.AccID = p.AccID WHERE ProID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		ArrayList listAcc = new ArrayList();
		while (resultSet.next()) {
			
			int accid = resultSet.getInt(1);
			String name = resultSet.getString(2);
			String email = resultSet.getString(3);
			String password = resultSet.getString(4);
			int ExpInYear = resultSet.getInt(5);
			String Proskill = resultSet.getString(6);
			
			if(Proskill != null) {
				Manager a = new Manager();
				ProSkill skill = a.DataBaseProskill(Proskill);
				Manager acc = new Manager(accid, name, email, password, ExpInYear, skill);
				listAcc.add(acc);
			}else {
				Employee acc = new Employee(accid, name, email, password);	
				listAcc.add(acc);
						
			}
		}
		return listAcc;
		
	}

}
