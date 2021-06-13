package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.ProjectService;
import com.vti.entity.Project;

public class ProjectController {
	
	private ProjectService service;

	public ProjectController() throws FileNotFoundException, IOException {
		service = new ProjectService();
	};
	
	public List<Project> getListProjects() throws ClassNotFoundException, SQLException {
		
		return service.getListProjects();
	}
	
	public Project getProByID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException{
		
		return service.getProByID(id);
	}
}
