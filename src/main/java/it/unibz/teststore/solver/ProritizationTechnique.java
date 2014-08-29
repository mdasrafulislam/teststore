package it.unibz.teststore.solver;

import it.unibz.teststore.entity.TestCase;
import it.unibz.teststore.entity.TestInstanceSPResult;
import it.unibz.teststore.utils.TestProcessing;

import java.util.ArrayList;
import java.util.Collections;

public class ProritizationTechnique {
	
	public ArrayList<TestInstanceSPResult> NoPrioritization(int buildId)
			throws Exception {
		ArrayList<TestInstanceSPResult> testList = new TestProcessing()
				.getTestCaseMatrix(buildId);
		return testList;
	}

	public ArrayList<TestInstanceSPResult> RandomPrioritization(int buildId)
			throws Exception {
		ArrayList<TestInstanceSPResult> randomList = new TestProcessing()
				.getTestCaseMatrix(buildId);
		Collections.shuffle(randomList);
		return randomList;
	}

	public ArrayList<TestInstanceSPResult> WeightbySPRatioPrioritization(
			int buildId) throws Exception {

		ArrayList<TestInstanceSPResult> testList = new TestProcessing()
				.getTestCaseMatrix(buildId);

		ArrayList<TestInstanceSPResult> newList = new ArrayList<TestInstanceSPResult>();

		Double time = 0.0;
		for (TestInstanceSPResult listSPresult : testList) {

			Double ratio = listSPresult.getSelectionProbability()
					/ (listSPresult.getAverageTime() / 1000);
			TestInstanceSPResult testInstanceSPResult = new TestInstanceSPResult();
			testInstanceSPResult.setTestId(listSPresult.getTestId());
			testInstanceSPResult.setSelectionProbability(ratio);
			testInstanceSPResult.setAverageTime(listSPresult.getAverageTime());
			testInstanceSPResult.setExecutionStatus(listSPresult
					.getExecutionStatus());
			newList.add(testInstanceSPResult);
			// System.out.println(listSPresult.getTestId()+" "+listSPresult.getSelectionProbability()+" "
			// +listSPresult.getAverageTime()+" "+ratio
			// +" "+listSPresult.getExecutionStatus());
		}

		Collections.sort(newList, new TestInstanceSPResult.OrderBySP());

		// ArrayList<TestInstanceSPResult> testnewList= new
		// ArrayList<TestInstanceSPResult>();

		/*
		 * for(TestInstanceSPResult resultSP:newList){
		 * 
		 * TestInstanceSPResult testInstanceSPResult = new
		 * TestInstanceSPResult();
		 * testInstanceSPResult.setTestId(resultSP.getTestId());
		 * testInstanceSPResult
		 * .setSelectionProbability(resultSP.getSelectionProbability());
		 * testInstanceSPResult.setAverageTime(resultSP.getAverageTime());
		 * testInstanceSPResult
		 * .setExecutionStatus(resultSP.getExecutionStatus());
		 * testnewList.add(testInstanceSPResult);
		 * 
		 * System.out.println(resultSP.getTestId()+" "+resultSP.
		 * getSelectionProbability()+" "
		 * +resultSP.getAverageTime()+" "+resultSP.getExecutionStatus()); }
		 */
		return newList;

	}

	public ArrayList<TestInstanceSPResult> WeightbySPPrioritization(int buildId)
			throws Exception {

		ArrayList<TestInstanceSPResult> testList = new TestProcessing()
				.getTestCaseMatrix(buildId);

		/*
		 * for( TestInstanceSPResult listSPresult:testList){
		 * 
		 * Double ratio = listSPresult.getSelectionProbability()/
		 * (listSPresult.getAverageTime()/1000); TestInstanceSPResult
		 * testInstanceSPResult = new TestInstanceSPResult();
		 * testInstanceSPResult.setTestId(listSPresult.getTestId());
		 * testInstanceSPResult.setSelectionProbability(ratio);
		 * testInstanceSPResult.setAverageTime(listSPresult.getAverageTime());
		 * testInstanceSPResult
		 * .setExecutionStatus(listSPresult.getExecutionStatus());
		 * newList.add(testInstanceSPResult); }
		 */

		Collections.sort(testList, new TestInstanceSPResult.OrderBySP());

		/*
		 * \ for(TestInstanceSPResult resultSP:testList){
		 * 
		 * TestInstanceSPResult testInstanceSPResult = new
		 * TestInstanceSPResult();
		 * testInstanceSPResult.setTestId(resultSP.getTestId());
		 * testInstanceSPResult
		 * .setSelectionProbability(resultSP.getSelectionProbability());
		 * testInstanceSPResult.setAverageTime(resultSP.getAverageTime());
		 * testInstanceSPResult
		 * .setExecutionStatus(resultSP.getExecutionStatus());
		 * 
		 * //newList.add(testInstanceSPResult);
		 * 
		 * System.out.println(resultSP.getTestId()+" "+resultSP.
		 * getSelectionProbability()+" "
		 * +resultSP.getAverageTime()+" "+resultSP.getExecutionStatus()); }
		 */
		return testList;
	}

	public ArrayList<TestInstanceSPResult> WeightbyEntropyPrioritization(
			int buildId) throws Exception {

		ArrayList<TestInstanceSPResult> testList = new TestProcessing()
				.getTestCaseMatrix(buildId);

		// ArrayList<TestInstanceSPResult> newList= new
		// ArrayList<TestInstanceSPResult>();

		Collections.sort(testList, new TestInstanceSPResult.OrderByEntropy());

		/*
		 * for(TestInstanceSPResult resultSP:testList){
		 * 
		 * TestInstanceSPResult testInstanceSPResult = new
		 * TestInstanceSPResult();
		 * testInstanceSPResult.setTestId(resultSP.getTestId());
		 * testInstanceSPResult
		 * .setSelectionProbability(resultSP.getSelectionProbability());
		 * testInstanceSPResult.setAverageTime(resultSP.getAverageTime());
		 * testInstanceSPResult.setEntropy(resultSP.getEntropy());
		 * testInstanceSPResult.setWeightedTime(resultSP.getWeightedTime());
		 * testInstanceSPResult
		 * .setExecutionStatus(resultSP.getExecutionStatus());
		 * 
		 * newList.add(testInstanceSPResult);
		 * 
		 * // System.out.println(resultSP.getTestId()+" "+resultSP.
		 * getSelectionProbability()+" "
		 * +resultSP.getAverageTime()+" "+resultSP.getExecutionStatus()); }
		 */
		return testList;
	}

	public ArrayList<TestInstanceSPResult> WeightbyEntropyRationPrioritization(
			int buildId) throws Exception {

		ArrayList<TestInstanceSPResult> testList = new TestProcessing()
				.getTestCaseMatrix(buildId);

		ArrayList<TestInstanceSPResult> newList = new ArrayList<TestInstanceSPResult>();

		Double time = 0.0;

		for (TestInstanceSPResult listSPresult : testList) {

			Double ratio = listSPresult.getEntropy()
					/ (listSPresult.getWeightedTime() / 1000);
			TestInstanceSPResult testInstanceSPResult = new TestInstanceSPResult();
			testInstanceSPResult.setTestId(listSPresult.getTestId());
			testInstanceSPResult.setSelectionProbability(ratio);
			testInstanceSPResult.setAverageTime(listSPresult.getAverageTime());
			testInstanceSPResult.setEntropy(ratio);
			testInstanceSPResult
					.setWeightedTime(listSPresult.getWeightedTime());
			testInstanceSPResult.setExecutionStatus(listSPresult
					.getExecutionStatus());
			newList.add(testInstanceSPResult);
		}

		Collections
				.sort(newList, new TestInstanceSPResult.OrderByEntropyDesc());

		/*
		 * for(TestInstanceSPResult resultSP:testList){
		 * 
		 * TestInstanceSPResult testInstanceSPResult = new
		 * TestInstanceSPResult();
		 * testInstanceSPResult.setTestId(resultSP.getTestId());
		 * testInstanceSPResult
		 * .setSelectionProbability(resultSP.getSelectionProbability());
		 * testInstanceSPResult.setAverageTime(resultSP.getAverageTime());
		 * testInstanceSPResult.setEntropy(resultSP.getEntropy());
		 * testInstanceSPResult.setWeightedTime(resultSP.getWeightedTime());
		 * testInstanceSPResult
		 * .setExecutionStatus(resultSP.getExecutionStatus());
		 * newList.add(testInstanceSPResult);
		 * 
		 * // System.out.println(resultSP.getTestId()+" "+resultSP.
		 * getSelectionProbability()+" "
		 * +resultSP.getAverageTime()+" "+resultSP.getExecutionStatus()); }
		 */
		return newList;
	}
	
	

}


