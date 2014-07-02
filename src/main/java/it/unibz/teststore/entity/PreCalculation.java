package it.unibz.teststore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PreCalculation {
	
	@Id
	@GeneratedValue
	private Integer id;

	private Integer testId;
		
	private double probability;
	
	private boolean lastObservation;
	
	private double avgTime;
	
	private Integer countExecution;
	
	private double selectionProbability;
	
	private double entropy;
	
	//count if not executed in a build. 
	//if execute in current build then value 0 otherwise increment by 1
	private Integer executionCount; 
    private Integer age;
    		
	@OneToOne
	private Technique technique;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public boolean isLastObservation() {
		return lastObservation;
	}

	public void setLastObservation(boolean lastObservation) {
		this.lastObservation = lastObservation;
	}

	public double getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(double avgTime) {
		this.avgTime = avgTime;
	}

	public Integer getCountExecution() {
		return countExecution;
	}

	public void setCountExecution(Integer countExecution) {
		this.countExecution = countExecution;
	}

	public double getSelectionProbability() {
		return selectionProbability;
	}

	public void setSelectionProbability(double selectionProbability) {
		this.selectionProbability = selectionProbability;
	}

	public double getEntropy() {
		return entropy;
	}

	public void setEntropy(double entropy) {
		this.entropy = entropy;
	}

	public Integer getExecutionCount() {
		return executionCount;
	}

	public void setExecutionCount(Integer executionCount) {
		this.executionCount = executionCount;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Technique getTechnique() {
		return technique;
	}

	public void setTechnique(Technique technique) {
		this.technique = technique;
	}
}
