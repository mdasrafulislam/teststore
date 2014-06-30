package it.unibz.teststore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	@Column(name = "id")
	private Integer id;

	@Size(min =1)
	@Column(name = "build_number")
	private Integer buildNumber;
	
	@Size(min =1)
	@Column(name = "build_time")
	private Date buildTime;
	
	@ManyToOne
	@JoinColumn
	private Project project;
	
	@OneToMany
	@JoinColumn
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
		
	public void setNumber(Integer buildNumber) {
		this.buildNumber = buildNumber;
	}

	public Integer getNumber() {
		return buildNumber;
	}
	 
	public Date getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
}
