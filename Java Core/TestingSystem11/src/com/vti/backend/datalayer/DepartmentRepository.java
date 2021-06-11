package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vti.entity.Department;
import com.vti.ultis.jdbcUltis;

public class DepartmentRepository {
	private jdbcUltis jdbc;
	
	public DepartmentRepository() throws FileNotFoundException, IOException {
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
}
