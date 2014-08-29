package it.unibz.teststore.entity;


public class TestInstanceResult {
	
	public TestInstanceResult(){
		
	}
	
	public TestInstanceResult(Long testId,Double entropy,Double weightedAge,Double averageTime){
		this.testId = testId;
		this.entropy = entropy;
		this.weightedAge = weightedAge;
		this.averageTime = averageTime;
	}
	
	
	private Long testId;
	private Double entropy;
	private Double weightedAge;
	private Double averageTime;
	
	public void setTestId(Long testId){
		this.testId= testId;
	}
	
	public Long getTestId(){
		return testId;
	}
	
	public void setEntropy(Double entropy){
		this.entropy= entropy;
	}
	
	public Double getEntropy(){
		return entropy;
	}
	
	public void setWeightedAge(Double weightedAge){
		this.weightedAge= weightedAge;
	}
	
	public Double getWeightedAge(){
		return weightedAge;
	}
	
	public void setAverageTime(Double averageTime){
		this.averageTime= averageTime;
	}
	
	public Double getAverageTime(){
		return averageTime;
	}
}
