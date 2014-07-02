package it.unibz.teststore.service;

import java.util.List;

import it.unibz.teststore.entity.Technique;
import it.unibz.teststore.repository.TechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TechniqueService {
	
	@Autowired
	private TechniqueRepository techniqueRepository;
	
	public void save(Technique technique) {
		techniqueRepository.save(technique);
	}
	
	public Technique findBuildById(int id) {
		return techniqueRepository.findOne(id);
	}
	
	public List<Technique> findAllBuild() {
		return techniqueRepository.findAll();
	}
	
	public void delete(Technique testCase){
		techniqueRepository.delete(testCase);
	}

}
