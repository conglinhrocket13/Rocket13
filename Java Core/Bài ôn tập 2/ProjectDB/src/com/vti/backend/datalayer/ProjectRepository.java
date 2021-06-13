package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Project;
import com.vti.ultis.jdbcUltis;

public class ProjectRepository implements IProjectRepository {
	
	jdbcUltis jdbc;
	
	
	
	public ProjectRepository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	@Override
	public List<Project> getListProjects() throws ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM Project ORDER BY ProID";
		ResultSet resultSet = jdbc.executeQuery(sql);
		ArrayList<Project> listProject = new ArrayList<Project>();
		while (resultSet.next()) {
			
			int id = resultSet.getInt(1);
			String name = resultSet.getNString(2);
			int size = resultSet.getInt(3);
			
			Project project = new Project(id,name,size);
			listProject.add(project);
		}
		return listProject;
			
	}
	
	@Override
	public Project getProByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM Project WHERE ProID = ?";
		PreparedStatement preStatement = jdbc.createPrepareStatement(sql);
		preStatement.setInt(1, id);
		ResultSet resultSet = preStatement.executeQuery();
		if (resultSet.next()) {
			int Proid = resultSet.getInt(1);
			String name = resultSet.getNString(2);
			int size = resultSet.getInt(3);
			
			Project project = new Project(Proid,name,size);

			return project;
		} else {
			jdbc.disConnection();
			return null;
		}
	}
}
