package it.unibz.teststore.service;

import java.util.List;

import it.unibz.teststore.entity.Build;
import it.unibz.teststore.repository.BuildRepository;
import it.unibz.teststore.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BuildService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private BuildRepository buildRepository;
	
	public void save(Build build) {
		buildRepository.save(build);
	}
	
	public Build findBuildById(int id) {
		return buildRepository.findOne(id);
	}
	
	public List<Build> findAllBuild() {
		return buildRepository.findAll();
	}
	
	public void delete(Build build){
		buildRepository.delete(build);
	}
	
}
