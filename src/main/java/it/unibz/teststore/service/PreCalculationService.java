package it.unibz.teststore.service;

import java.util.List;

import it.unibz.teststore.entity.PreCalculation;
import it.unibz.teststore.repository.PreCalcuationRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PreCalculationService {
	
	@Autowired
	private PreCalcuationRepository  preCalculationRepository;
	
	public void save(PreCalculation preCalcuation) {
		preCalculationRepository.save(preCalcuation);
	}
	
	public PreCalculation findBuildById(int id) {
		return preCalculationRepository.findOne(id);
	}
	
	public List<PreCalculation> findAllBuild() {
		return preCalculationRepository.findAll();
	}
	
	public void delete(PreCalculation preCalcuation){
		preCalculationRepository.delete(preCalcuation);
	}
}
