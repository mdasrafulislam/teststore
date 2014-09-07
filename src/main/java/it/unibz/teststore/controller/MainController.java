package it.unibz.teststore.controller;

import it.unibz.teststore.solver.PrioritizationMeasurement;
import it.unibz.teststore.utils.XMLParsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainController {
	
	
	
	
	public static void LoadData() throws Exception{
		 	 
		  int buildId=58;
		  int pId=1;
		  XMLParsing xmlParser =new XMLParsing();
		  xmlParser.LoadDatafromWebApi(pId, buildId);
    } 

	public static void Measurement() {
		PrioritizationMeasurement pm = new PrioritizationMeasurement();
		try {
			 pm.Measurement(49, 6);
			 pm.Getaptftime(58L,1);
			 pm.Getaptfpertest(58L,1);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readCSV() {

		// String csvFile = "D:\\zoo\\data.csv";
		// String csvFile = "D:\\zoo\\zoo_80_1_2_3_4.csv";
		String csvFile = "D:\\zoo\\maven_58_1_2_5_6.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] testCode = line.split(cvsSplitBy);

				System.out.println("[" + testCode[0] + "," + testCode[1] + ","
						+ testCode[2] + "," + testCode[3] + "," + testCode[4]
						+ "],");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");

	}

}
