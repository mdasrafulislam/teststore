package it.unibz.teststore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class TestCase {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Size(min =1)
	private String className;
	
	@Size(min =1)
	private String testName;
	
	@ManyToOne
	@JoinColumn
	private Project project;
	
	@OneToMany
	private List<History> histories;
		
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId() {
	    return id;
	}
	
	public Project getProject() {
		return project;
	}

	public void setHisoty(List<History> histories) {
		this.histories= histories;
	}
	
	public List<History> getHistory() {
		return histories;
	}

	public void setProject(Project project) {
		this.project= project;
	}
	
	public String getClassName() {
		  return className;
	}

	public void setClassName(String className) {
		  this.className = className;
	}
	
	public String getTestName() {
		  return testName;
	}

	public void setTestName(String testName) {
		  this.testName = testName;
	}
}
