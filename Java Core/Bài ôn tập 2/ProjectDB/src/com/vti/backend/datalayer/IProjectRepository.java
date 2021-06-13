package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;

public interface IProjectRepository {
	
	public List<Project> getListProjects() throws ClassNotFoundException, SQLException;
	
	public Project getProByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
}
