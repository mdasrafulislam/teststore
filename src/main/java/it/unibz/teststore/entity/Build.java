package it.unibz.teststore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Build {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min =1)
	private Integer number;
	
	@Size(min =1)
	private Date buildTime;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToMany
	@JoinColumn(name = "build_id")
	private List<TestCase>  testCases;
	
			
	public Integer getId() {
	    return id;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project= project;
	}
	
	public void setTestCases(List<TestCase> testCases){
		this.testCases =testCases;
	}
	
	public List<TestCase> getTestCases(){
		return testCases;
	}
		
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}
	 
	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	
	
}
