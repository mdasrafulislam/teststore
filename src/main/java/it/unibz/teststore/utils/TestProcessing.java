package it.unibz.teststore.utils;
import it.unibz.teststore.entity.History;
import it.unibz.teststore.entity.TestInstanceResult;
import it.unibz.teststore.entity.TestInstanceSPResult;
import it.unibz.teststore.service.HistoryService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.xml.crypto.dsig.keyinfo.KeyValue;


public class TestProcessing {

	public TestInstanceResult getTestCaseResult(int testId, int buildId)
			throws Exception {
        
		TestInstanceResult tir = new TestInstanceResult();
		return tir;
	}

	public ArrayList<TestInstanceSPResult> getTestCaseMatrix(int buildId)
			throws Exception {

	
		ArrayList<TestInstanceSPResult> testInstanceSPResultList = new ArrayList<TestInstanceSPResult>();
		return testInstanceSPResultList;
	}

	public void generateCsvFile(double totalTimeCount, double failCount, Long buildId, int type) {

		FileWriter writer = null;
		// String sfileNameZoo="zoo_te_"+buildId+"_"+type+".csv";
		String sfileNameMaven = "maven_te_" + buildId + "_" + type + ".csv";

		File file = new File("D:\\zoo\\" + sfileNameMaven);

		try {
			if (!file.exists())
				file.createNewFile();

			writer = new FileWriter(file);

			writer.append("Time");
			writer.append(',');
			writer.append("Fail");
			writer.append('\n');



			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateCsvFileTime(
			
			double totalTestCount, double failCount, Long buildId, int type) {

		FileWriter writer = null;
		// String sfileNameZoo="zoo_te_"+buildId+"_"+type+".csv";
		String sfileNameMaven = "maven_te_" + buildId + "_" + type + ".csv";

		File file = new File("D:\\zoo\\" + sfileNameMaven);

		try {
			if (!file.exists())
				file.createNewFile();

			writer = new FileWriter(file);

			writer.append("Test");
			writer.append(',');
			writer.append("Fail");
			writer.append('\n');




			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
