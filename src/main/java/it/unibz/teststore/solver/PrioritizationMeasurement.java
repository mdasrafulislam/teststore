package it.unibz.teststore.solver;

import it.unibz.teststore.entity.TestInstanceSPResult;
import it.unibz.teststore.utils.TestProcessing;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class PrioritizationMeasurement {

	ArrayList<TestInstanceSPResult> randomList;

	public void Measurement(int buildId, int type) throws Exception {

		if (type == 1)
			randomList = new ProritizationTechnique().NoPrioritization(buildId);
					
		else if (type == 2)
			randomList = new ProritizationTechnique()
					.RandomPrioritization(buildId);
		else if (type == 3)
			randomList = new ProritizationTechnique()
					.WeightbySPRatioPrioritization(buildId);
		else if (type == 4)
			randomList = new ProritizationTechnique()
					.WeightbySPPrioritization(buildId);
		else if (type == 5)
			randomList = new ProritizationTechnique()
					.WeightbyEntropyRationPrioritization(buildId);
		else
			randomList = new ProritizationTechnique()
					.WeightbyEntropyPrioritization(buildId);

		double apfd = 0;
		// System.out.println(randomList.size());

		double timeCount = 0.0, totalTimeCount = 0.0, dTotaltimeCount = 0.0, sumtime = 0.0;
		int totalPassCount = 0, failCount = 0;
		;

		double calculationM1 = 0;

		for (int i = 0; i < randomList.size(); i++) {

			timeCount = 0.0;
			for (int j = i; j < randomList.size(); j++) {
				timeCount += ((randomList.get(j).getAverageTime()) / 1000);
				;
			}

			int flag = 0;
			if (randomList.get(i).getExecutionStatus()) {
				flag = 0;
				totalPassCount += 1;

			} else {
				flag = 1;
				failCount += 1;
				sumtime = ((2 * timeCount) - (randomList.get(i)
						.getAverageTime() / 1000)) * flag;

			}

			// ///////M1-Start
			calculationM1 += (((2 * randomList.size() - (2 * i) + 1)) * flag);

			// ///////M1-End

			totalTimeCount += sumtime;
			dTotaltimeCount += (randomList.get(i).getAverageTime() / 1000);

			// totalPassCount += flag;

			// ///M1-Start

			// ///M1-End
			// System.out.println(((totalTimeCount*0.5)/(dTotaltimeCount*totalPassCount))*100
			// +"    "+dTotaltimeCount
			// +"  "+randomList.get(i).getExecutionStatus()+" "+timeCount);

		}

		System.out.println(randomList.size());
		System.out
				.println("-----------------Mo----------------------------------");

		Double Mo = ((totalTimeCount * 0.5) / (dTotaltimeCount * totalPassCount)) * 100;

		System.out.println("Mo is :" + Mo + "%");
		System.out
				.println("-----------------Mo-----------------------------------");
		System.out
				.println("-----------------M1-----------------------------------");
		Double M1 = ((calculationM1 * 0.5) / (randomList.size() * failCount)) * 100;

		System.out.println("M1 is :" + M1 + "%");
		System.out
				.println("-----------------M1-----------------------------------");

	}

	public void Getaptftime(Long buildId, int type) throws Exception {

		//ArrayList<KeyValue<Double, Double>> resultList = new ArrayList<>();
		/*
		 * ArrayList<TestInstanceSPResult> randomList;
		 * 
		 * if(type==1) randomList= new
		 * PrioritizationAlgorithms().NoPrioritization(buildId); else
		 * if(type==2) randomList= new
		 * PrioritizationAlgorithms().RandomPrioritization(buildId); else
		 * if(type==3) randomList= new
		 * PrioritizationAlgorithms().WeightbySPRatioPrioritization(buildId);
		 * else if(type==4) randomList= new
		 * PrioritizationAlgorithms().WeightbySPPrioritization(buildId); else
		 * if(type==5) randomList= new
		 * PrioritizationAlgorithms().WeightbyEntropyRationPrioritization
		 * (buildId); else randomList= new
		 * PrioritizationAlgorithms().WeightbyEntropyPrioritization(buildId);
		 */
		double timeCount = 0.0, totalTimeCount = 0.0, dTotaltimeCount = 0.0, sumtime = 0.0, failCount = 0.0;
		;

		for (int i = 0; i < randomList.size(); i++) {
			totalTimeCount += randomList.get(i).getAverageTime();
			failCount += randomList.get(i).getExecutionStatus() ? 0.0 : 1.0;
			//resultList.add(new KeyValue(totalTimeCount, failCount));
		}

		System.out.println("Fail Count:" + failCount);
		TestProcessing tp = new TestProcessing();
	//	tp.generateCsvFile(resultList, totalTimeCount, failCount, buildId, type);

		/*
		 * for(KeyValue<Double, Double> keyValue:resultList){
		 * //keyValue.createKeyValue(keyValue.getKey()/totalTimeCount,
		 * keyValue.getValue()/failCount);
		 * 
		 * System.out.println(
		 * keyValue.getKey()/totalTimeCount+","+keyValue.getValue()/failCount);
		 * }
		 */
	}

	public void Getaptfpertest(Long buildId, int type) throws Exception {

		//ArrayList<> resultList=new ArrayList<>();
		//ArrayList<KeyValue<Double, Double>> resultList = new ArrayList<>();
		/*
		 * ArrayList<TestInstanceSPResult> randomList; if(type==1) randomList=
		 * new PrioritizationAlgorithms().NoPrioritization(buildId); else
		 * if(type==2) randomList= new
		 * PrioritizationAlgorithms().RandomPrioritization(buildId); else
		 * if(type==3) randomList= new
		 * PrioritizationAlgorithms().WeightbySPRatioPrioritization(buildId);
		 * else if(type==4) randomList= new
		 * PrioritizationAlgorithms().WeightbySPPrioritization(buildId); else
		 * if(type==5) randomList= new
		 * PrioritizationAlgorithms().WeightbyEntropyRationPrioritization
		 * (buildId); else randomList= new
		 * PrioritizationAlgorithms().WeightbyEntropyPrioritization(buildId);
		 */
		double testCount = 0.0, totalTimeCount = 0.0, dTotaltimeCount = 0.0, sumtime = 0.0, failCount = 0.0;
		
		for (int i = 0; i < randomList.size(); i++) {
			testCount += 1;
			failCount += randomList.get(i).getExecutionStatus() ? 0.0 : 1.0;
		//	resultList.add(new KeyValue(testCount, failCount));
		}

		TestProcessing tp = new TestProcessing();
		//tp.generateCsvFileTime(resultList, testCount, failCount, buildId, type);

	}

}
