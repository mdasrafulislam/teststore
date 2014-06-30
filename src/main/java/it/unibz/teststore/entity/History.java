package it.unibz.teststore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class History {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private TestCase testCase;
	
	@ManyToOne(targetEntity = Build.class)
	@JoinColumn
	private List<Build> builds;
	
    private Integer duration;
    
    private Integer age;

    private Integer failedSince;
    
    private Integer status;
    
    private boolean isSkipped;
    
    
    public void setId(Long id){
		this.id=id;
	}
	
	public Long getId() {
	    return id;
	}
	
	public void setTestCase(TestCase testCase){
		this.testCase=testCase;
	}
	
	public TestCase getTestCase(){
		return testCase;
	}
	
	public List<Build> getBuilds() {
		return builds;
	}

	public void setRoles(List<Build> builds) {
		this.builds = builds;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	
	public void setFailedSince(int failedSince) {
		this.failedSince = failedSince;
	}

	public int getFailedSince() {
		return failedSince;
	}
		
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setIsSkipped(boolean isSkipped) {
		this.isSkipped = isSkipped;
	}

	public boolean getIsSkipped() {
		return isSkipped;
	}
	
    public void setStatus(Integer status){
    	this.status= status;
    }
     
    public Integer getStatus(){
    	return status;
    }
 }
