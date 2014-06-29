package it.unibz.teststore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name = "id")
	private Project project;
		
	public Integer getId() {
	    return id;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project= project;
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
