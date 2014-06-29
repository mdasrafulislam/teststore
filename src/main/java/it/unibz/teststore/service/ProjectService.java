package it.unibz.teststore.service;

import it.unibz.teststore.entity.Blog;
import it.unibz.teststore.entity.Project;
import it.unibz.teststore.entity.User;
import it.unibz.teststore.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public void save(Project project) {
		projectRepository.save(project);
	}

}
