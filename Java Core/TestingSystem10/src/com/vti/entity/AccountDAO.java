package com.vti.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.vti.ultis.ScannerUltis;
import com.vti.ultis.jdbcUltis;

public class AccountDAO {
	private jdbcUltis jdbc;

	public AccountDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public ArrayList<Account> getListAccount() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account ORDER BY AccountID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		ArrayList<Account> listAcc = new ArrayList<Account>();
		while (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUsername(resultSet.getString(3));
			acc.setFullname(resultSet.getString(4));

			DepartmentDAO depDao = new DepartmentDAO();
			Department dep = depDao.getDepByID(resultSet.getInt(5));
			acc.setDepartment(dep);
			
			PositionDAO posDao = new PositionDAO();
			Position pos = posDao.getPosByID(resultSet.getInt(6));
			acc.setPosition(pos);

			LocalDate lcd = resultSet.getDate(7).toLocalDate();
			acc.setCreateDate(lcd);

			listAcc.add(acc);
		}
		return listAcc;
	}
	
	public Account getAccByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Account WHERE AccountID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			Account acc = new Account();
			acc.setId(resultSet.getInt(1));
			acc.setEmail(resultSet.getString(2));
			acc.setUsername(resultSet.getString(3));
			acc.setFullname(resultSet.getString(4));
			DepartmentDAO depDao = new DepartmentDAO();
			Department dep = depDao.getDepByID(resultSet.getInt(5));
			acc.setDepartment(dep);
			PositionDAO posDao = new PositionDAO();
			acc.setPosition(posDao.getPosByID(resultSet.getInt(6)));
			LocalDate lcd = Date.valueOf(resultSet.getDate(7).toString()).toLocalDate();
			acc.setCreateDate(lcd);

			return acc;
		} else {
			jdbc.disConnection();
			return null;
		}
	}
	
	public Boolean isAccNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Account WHERE UserName = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, name);
		ResultSet result = preStatement.executeQuery();

		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO account (Email, UserName, FullName, DepartmentID, PositionID, CreateDate) VALUES (?, ?, ?,?,?,now());";

		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setNString(1, acc.getEmail());
		preStatement.setNString(2, acc.getUsername());
		preStatement.setNString(3, acc.getFullname());
		preStatement.setInt(4, depId);
		preStatement.setInt(5, posId);
		
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean delAccByID(int ID) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Account WHERE (AccountID = ?);";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, ID);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
	
	public boolean updateFullName(int id, String newFullName) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE account SET FullName = ? WHERE AccountID = ?;";		
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setString(1, newFullName);
		preStatement.setInt(2, id);
		int result = preStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	
	}

}
