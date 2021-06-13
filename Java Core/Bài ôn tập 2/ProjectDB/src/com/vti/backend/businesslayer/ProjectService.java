package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.ProjectRepository;
import com.vti.entity.Project;

public class ProjectService implements IProjectService{
	private ProjectRepository repository;
	
	
	
	public ProjectService() throws FileNotFoundException, IOException {
		repository = new ProjectRepository();
	}



	@Override
	public List<Project> getListProjects() throws ClassNotFoundException, SQLException {
		
		return repository.getListProjects();
	}
	
	@Override
	public Project getProByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		
		return repository.getProByID(id);
	}
}
