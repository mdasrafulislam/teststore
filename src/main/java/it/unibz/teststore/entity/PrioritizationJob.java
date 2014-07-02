package it.unibz.teststore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class PrioritizationJob {
	
	@Id
	@GeneratedValue
	private Integer id;

	private Integer projectId;
	
	private Integer buildId;
	
	@Size(min =1)
	private String name;
	
	@Size(min =1)
	private double maxTime;
		
	@OneToOne
	private Technique technique;
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId() {
	    return id;
	}
	
	public void setProjectId(Integer projectId){
		this.projectId=projectId;
	}
	
	public Integer getProjectId() {
	    return projectId;
	}
	
	public void setBuildId(Integer buildId){
		this.buildId=buildId;
	}
	
	public Integer getBuildId() {
	    return buildId;
	}
	
	public String getName() {
		  return name;
	}

	public void setName(String name) {
		  this.name = name;
	}
	
	public double getMaxTime() {
		  return maxTime;
	}
	
	public void setMaxTime(double maxTime) {
		  this.maxTime = maxTime;
	}
	
	public void setTechnique(Technique technique){
		this.technique = technique;
	}
	
	public Technique getTechnique(){
		return technique;
	}
	
}
