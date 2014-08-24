package it.unibz.teststore.controller;

import javax.validation.Valid;

import it.unibz.teststore.entity.Project;
import it.unibz.teststore.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProjectController {
	
	
	@Autowired
	private ProjectService projectService;
	

	@RequestMapping
	public String projects(Model model) {
		model.addAttribute("projects", projectService.findAllProject());
		return "project";
	}
		
	@ModelAttribute("project")
	public Project construct(){
		return new Project();
	}
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute("project") Project project, BindingResult result){
		if (result.hasErrors()) {
			return "project";
		}
		projectService.save(project);		
	    return "redirect:/project.html?success=true";
	}
	
	@RequestMapping("/project/remove/{id}")
	public String removeUser(@PathVariable int id) {
        projectService.delete(id);
		return "redirect:/project.html?delete=true";
	}
}
