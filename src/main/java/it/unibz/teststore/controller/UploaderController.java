package it.unibz.teststore.controller;

import it.unibz.teststore.service.ProjectService;
import it.unibz.teststore.utils.XMLParsing;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import org.w3c.dom.DOMException;

@Controller
public class UploaderController {
	
	@Autowired
	private ProjectService projectService;
	
		
	@RequestMapping("/uploader")
	public String construct(){
		return "uploader";
	}
	
	
	@RequestMapping("/uploadbuild")
	@ResponseBody
	public String UploadBuild(@RequestParam String projectId,String buildNo) throws DOMException, Exception {
		XMLParsing.LoadDatafromWebApi(Integer.getInteger(projectId), Integer.getInteger(buildNo));
		return "uploader";
	}

	
	

}
