package it.unibz.teststore.service;

import it.unibz.teststore.entity.TestCase;
import it.unibz.teststore.repository.TestCaseRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class TestCaseService {
		
	@Autowired
	private TestCaseRepository testCaseRepository;
	
	public TestCase save( TestCase testCase) {
		testCaseRepository.save(testCase);
		return testCase;
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
	

	public TestCase SelectByClassByTestCase(String testName, String className) {
			
      TestCase testCase = new TestCase();
      return testCase;
	}
	
	public TestCase insertIfNotExists(String testName, String testClass) throws Exception {
		TestCase testCase = SelectByClassByTestCase(testName, testClass);
		if (testCase == null) {
			testCase = save(testCase);
		}
		return testCase;
	}
}
