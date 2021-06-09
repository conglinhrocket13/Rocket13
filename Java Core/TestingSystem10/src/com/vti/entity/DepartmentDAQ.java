package com.vti.entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.ultis.jdbcUltis;

public class DepartmentDAQ {
	private jdbcUltis jdbc;
	
	public DepartmentDAQ() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public ArrayList<Department> getListDepartment() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM Department ORDER BY DepartmentID";
		ResultSet resultSet = jdbc.executeQuery(sql);

		ArrayList<Department> listDep = new ArrayList<Department>();
		while (resultSet.next()) {
			Department dep = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			listDep.add(dep);
		}
		jdbc.disConnection();
		return listDep;
	}

	public Department getDepByID(int id) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
		PreparedStatement preStt = jdbc.createPrepareStatement(sql);
		preStt.setInt(1, id);
		ResultSet result = preStt.executeQuery();
		if (result.next()) {
			Department dep = new Department(result.getInt("DepartmentID"), result.getNString("DepartmentName"));
			return dep;
		} else {
			jdbc.disConnection();
			return null;
		}

	}
	
	public Boolean isDepNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
		PreparedStatement preStt = jdbc.createPrepareStatement(sql);
		preStt.setNString(1, name);
		ResultSet result = preStt.executeQuery();

		if (result.next()) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean CreateDep(String name) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Department (DepartmentName) VALUES (?);";
		PreparedStatement preStt = jdbc.createPrepareStatement(sql);
		preStt.setNString(1, name);
		int result = preStt.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}

	}

	public boolean UpdateDepName(int id, String newName) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(id);
		if (depID == null) {
			return false;
		} else {

			String sql = "UPDATE Department SET DepartmentName = ? WHERE (DepartmentID = ?);";
			PreparedStatement preStt = jdbc.createPrepareStatement(sql);
			preStt.setNString(1, newName);
			preStt.setInt(2, id);
			int result = preStt.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}

	}

	public boolean delDepByID(int id) throws ClassNotFoundException, SQLException {
		Department depID = getDepByID(id);
		if (depID == null) {
			return false;
		} else {
			String sql = "DELETE FROM department WHERE (DepartmentID = ?);";
			PreparedStatement preStt = jdbc.createPrepareStatement(sql);
			preStt.setInt(1, id);
			int result = preStt.executeUpdate();
			if (result == 1) {
				jdbc.disConnection();
				return true;
			} else {
				jdbc.disConnection();
				return false;
			}

		}

	}
}
