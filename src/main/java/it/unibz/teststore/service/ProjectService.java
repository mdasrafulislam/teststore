package it.unibz.teststore.service;

import java.util.List;

import javax.transaction.Transactional;

import it.unibz.teststore.entity.Project;
import it.unibz.teststore.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	public void save(Project project) {
		projectRepository.save(project);
	}
	
	public Project findProjectById(int id) {
		return projectRepository.findOne(id);
	}
	
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}
	
	
	public void delete(int id){
		projectRepository.delete(id);
	}

}
