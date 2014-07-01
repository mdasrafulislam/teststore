package it.unibz.teststore.controller;

import it.unibz.teststore.entity.Project;
import it.unibz.teststore.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProjectController {
	
	
	@Autowired
	private ProjectService projectService;
	
	
	@ModelAttribute("project")
	public Project construct(){
		return new Project();
	}
	
	
	@RequestMapping("/project")
	public String project() {
		return "project";
	}
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	public String saveProject(@ModelAttribute("project") Project project){
		projectService.save(project);		
		return "project";
	}

}
