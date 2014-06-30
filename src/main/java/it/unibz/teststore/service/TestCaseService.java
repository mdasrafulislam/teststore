package it.unibz.teststore.service;

import it.unibz.teststore.entity.TestCase;
import it.unibz.teststore.repository.TestCaseRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TestCaseService {
		
	@Autowired
	private TestCaseRepository testCaseRepository;
	
	public void save( TestCase testCase) {
		testCaseRepository.save(testCase);
	}
	
	public TestCase findBuildById(int id) {
		return testCaseRepository.findOne(id);
	}
	
	public List<TestCase> findAllBuild() {
		return testCaseRepository.findAll();
	}
	
	public void delete(TestCase testCase){
		testCaseRepository.delete(testCase);
	}
}
