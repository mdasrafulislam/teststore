package it.unibz.teststore.repository;

import java.util.List;

import it.unibz.teststore.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{ 
	
	List<Project> findAll();
}
