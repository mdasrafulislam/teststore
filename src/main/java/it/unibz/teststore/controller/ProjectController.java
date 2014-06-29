package it.unibz.teststore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProjectController {
	
	@RequestMapping("/project")
	public String index() {
		return "index";
	}

}
