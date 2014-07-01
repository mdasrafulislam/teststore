package it.unibz.teststore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;


@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(max=255, message = "Project name must be less than 50 character!")
    private String name;
	
	@Size(min = 1, message = "Invalid url address!")
	private String url;
	
	@OneToMany
	@JoinTable
	private List<Build> builds;
	
	public Integer getId() {
	    return id;
	  }
	 
	public String getName() {
		  return name;
	}

	public void setName(String name) {
		  this.name = name;
	}

	public String getUrl() {
		  return url;
	}

	public void setUrl(String url) {
		  this.url = url;
	}
	
	public List<Build> getBuilds() {
		return builds;
	}

	public void setRoles(List<Build> builds) {
		this.builds = builds;
	}

}
