package it.unibz.teststore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;


@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5,message = "Please insert a project name!")
    private String name;
	
	@Size(min =10, message = "Pleasse insert a url address!")
	@URL(message = "Insert a valid url address!")
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

	public void setBuilds(List<Build> builds) {
		this.builds = builds;
	}

}
