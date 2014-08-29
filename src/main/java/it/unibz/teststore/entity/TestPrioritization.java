package it.unibz.teststore.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TestPrioritization {
private static final long serialVersionUID = 1L;
	
	public TestPrioritization() {
	
	}
	
	public TestPrioritization(Long testId,Long pId,Double probability,Boolean lastObservation,Double avgTime,Long totalExecution,Double selectionProbability) {
		this.testId= testId;
		this.pId = pId;
		this.probability = probability;
		this.lastObservation= lastObservation;
		this.avgTime= avgTime;
		this.totalExecution=totalExecution;
		this.selectionProbability = selectionProbability;
		
	}
		
	@Id
	@GeneratedValue(generator = "prioritization_id_seq", strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long Id;
	
	@Column(name = "test_id", nullable = false)
	private Long testId;
	
	@Column(name = "p_id", nullable = false)
	private Long pId;
	
	@Column(name = "probability", nullable = false)
	private Double probability;
	
	@Column(name = "last_observation", nullable = false)
	private Boolean lastObservation;
	
	@Column(name = "avg_time", nullable = false)
	private Double avgTime;
	
	@Column(name = "count_execution", nullable = false)
	private Long totalExecution;
	
	@Column(name = "selection_probability", nullable = false)
	private Double selectionProbability;
	
	
	public Long getId() {
		return Id;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long gettestId() {
		return testId;
	}
	
	public void setPriortizationId(Long pId) {
		this.pId = pId;
	}

	public Long getPriortizationId() {
		return pId;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public Double getProbability() {
		return probability;
	}
		
	public void setLastObservation(Boolean lastObservation) {
		this.lastObservation = lastObservation;
	}
	
	public Boolean getLastObservation() {
		return lastObservation;
	}

	public Double getAvgTime() {
		return avgTime;
	}
	
	public void setAvgTime(Double avgTime) {
		this.avgTime = avgTime;
	}

		
	public void setTotalExecution(Long totalExecution) {
		this.totalExecution = totalExecution;
	}

	public Long getTotalExecution() {
		return totalExecution;
	}
	
	public Double getSelectionProbability() {
		return selectionProbability;
	}
	
	public void setSelectionProbability(Double selectionProbability) {
		this.selectionProbability = selectionProbability;
	}

}
