package it.unibz.teststore.service;

import java.util.List;

import it.unibz.teststore.entity.PrioritizationJob;
import it.unibz.teststore.repository.PrioritizationJobRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PrioritizationJobService {
	
	@Autowired
	private PrioritizationJobRepository  prioritizationJobRepository;
	
	public void save(PrioritizationJob prioritizationJob) {
		prioritizationJobRepository.save(prioritizationJob);
	}
	
	public PrioritizationJob findBuildById(int id) {
		return prioritizationJobRepository.findOne(id);
	}
	
	public List<PrioritizationJob> findAllBuild() {
		return prioritizationJobRepository.findAll();
	}
	
	public void delete(PrioritizationJob prioritizationJob){
		prioritizationJobRepository.delete(prioritizationJob);
	}

}
