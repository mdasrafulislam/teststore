package it.unibz.teststore.utils;

import it.unibz.teststore.entity.Build;
import it.unibz.teststore.entity.History;
import it.unibz.teststore.entity.Project;
import it.unibz.teststore.entity.TestCase;
import it.unibz.teststore.service.HistoryService;
import it.unibz.teststore.service.ProjectService;
import it.unibz.teststore.service.TestCaseService;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void LoadData(String path, int buildNo,int pId) throws DOMException,
			Exception {

		File file = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		NodeList nodeList = document.getElementsByTagName("childReport");

		int count = 0;

		for (int i = 0; i < nodeList.getLength(); i++) {

			org.w3c.dom.Node node = nodeList.item(i);
			NodeList nlist = node.getChildNodes();

			org.w3c.dom.Node nodeq = nlist.item(1);
			NodeList results = nodeq.getChildNodes();

			for (int x = 5; x < results.getLength(); x++) {

				org.w3c.dom.Node suit = results.item(x);
				NodeList suitlist = suit.getChildNodes();

				for (int y = 0; y < suitlist.getLength() - 2; y++) {

					org.w3c.dom.Node casea = suitlist.item(y);
					NodeList caseList = casea.getChildNodes();

					
					org.w3c.dom.Node age = caseList.item(0);
					org.w3c.dom.Node classname = caseList.item(1);
					org.w3c.dom.Node duration = caseList.item(2);
					org.w3c.dom.Node failedSince = caseList.item(3);

					org.w3c.dom.Node testcasename = caseList.item(4);
					org.w3c.dom.Node is_skipped = caseList.item(5);
					org.w3c.dom.Node status = caseList.item(6);

					// System.out.println(casevalue.getTextContent());

					// FAILED
					// This test failed, just like its previous run.
					// FIXED
					// This test has been failing, but now it runs OK.
					// PASSED
					// This test runs OK, just like its previous run.
					// REGRESSION
					// This test has been running OK, but now it failed.
					// SKIPPED
					// This test was skipped due to configuration or the failure
					// or skipping of a method that it depends on.

					// System.out.println(testcasename.getTextContent());

					TestCaseService testCaseService = new TestCaseService();
					TestCase testCase = testCaseService.insertIfNotExists(testcasename.getTextContent(),
							classname.getTextContent());
							

					// break;
					int durationMilSec = (int) (Double.parseDouble(duration.getNodeValue()) * 1000);

					int testStatus = 0;
					if (status.getTextContent().toString().equals("PASSED"))
						testStatus = 1;
					else if (status.getTextContent().toString()
							.equals("REGRESSION"))
						testStatus = 2;
					else if (status.getTextContent().toString().equals("FIXED"))
						testStatus = 3;
					else if (status.getTextContent().toString()
							.equals("SKIPPED"))
						testStatus = 4;
					else
						testStatus = 5;
					
					Build build = new Build();
					
					Project project = new ProjectService().findProjectById(pId);
					build.setProject(project);
					build.setNumber(buildNo);
					build.setBuildTime(new Date());
					
					History history = new History();

					HistoryService historyService = new HistoryService();
					
					history.setTestCase(testCase);
					history.setAge(Integer.parseInt(age.getTextContent()));
				    history.setDuration(durationMilSec);
				    history.setFailedSince(Integer.parseInt(failedSince.getTextContent()));
				    history.setIsSkipped(Boolean.valueOf(is_skipped.getTextContent()));
				    history.setStatus(testStatus);
				    
				    historyService.save(history);
					count = count + 1;
					
				}
			}

		}

	}

	public static void LoadDataSecondFormat(String path, int buildNo,int pId)
			throws DOMException, Exception {

		File file = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(file);

		NodeList nodeList = document.getElementsByTagName("suite");

		int count = 0;

		for (int i = 0; i < nodeList.getLength(); i++) {

			org.w3c.dom.Node node = nodeList.item(i);// suite elements
			NodeList nlist = node.getChildNodes();

			String age = null;
			String className = null;
			String duration = null;
			String faileddSince = null;
			String testName = null, is_skipped = null, status = null;

			for (int y = 0; y < nlist.getLength() - 5; y++) {

				org.w3c.dom.Node casea = nlist.item(y);
				NodeList caseList = casea.getChildNodes();

				for (int k = 0; k < caseList.getLength(); k++) {
					if (caseList.item(k).getNodeName() == "age")
						age = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "className")
						className = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "duration")
						duration = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "failedSince")
						faileddSince = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "name")
						testName = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "skipped")
						is_skipped = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "status")
						status = caseList.item(k).getTextContent();
				}

				TestCaseService testCaseService = new TestCaseService();
				TestCase testCase = testCaseService.insertIfNotExists(testName,className);
						

				int durationMilSec = (int) (Double.parseDouble(duration) * 1000);

				int testStatus = 0;
				if (status.equals("PASSED"))
					testStatus = 1;
				else if (status.toString().equals("REGRESSION"))
					testStatus = 2;
				else if (status.toString().equals("FIXED"))
					testStatus = 3;
				else if (status.toString().equals("SKIPPED"))
					testStatus = 4;
				else
					testStatus = 5;

				Build build = new Build();
				
				Project project = new ProjectService().findProjectById(pId);
				build.setProject(project);
				build.setNumber(buildNo);
				build.setBuildTime(new Date());
				
				History history = new History();

				HistoryService historyService = new HistoryService();
				
				history.setTestCase(testCase);
				history.setAge(Integer.parseInt(age));
			    history.setDuration(durationMilSec);
			    history.setFailedSince(Integer.parseInt(faileddSince));
			    history.setIsSkipped(Boolean.valueOf(is_skipped));
			    history.setStatus(testStatus);
			    
			    historyService.save(history);

				count = count + 1;
			}

		}
		
	}

	public static void LoadDatafromWebApi(int ProjectId,int buildNo) throws DOMException,
			Exception {
		
		
		Project project = new ProjectService().findProjectById(ProjectId);
		
		String urlAddress = project.getUrl()
				+ buildNo + "/testReport/api/xml";

		URL urlurl = new URL(urlAddress);
		InputStream stream = urlurl.openStream();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(stream);

		NodeList nodeList = document.getElementsByTagName("suite");

		int count = 0;

		for (int i = 0; i < nodeList.getLength(); i++) {

			org.w3c.dom.Node node = nodeList.item(i);// suite elements
			NodeList nlist = node.getChildNodes();

			String age = null;
			String className = null;
			String duration = null;
			String faileddSince = null;
			String testName = null, is_skipped = null, status = null;


			for (int y = 0; y < nlist.getLength() - 5; y++) {

				org.w3c.dom.Node casea = nlist.item(y);
				NodeList caseList = casea.getChildNodes();

				for (int k = 0; k < caseList.getLength(); k++) {
					if (caseList.item(k).getNodeName() == "age")
						age = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "className")
						className = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "duration")
						duration = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "failedSince")
						faileddSince = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "name")
						testName = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "skipped")
						is_skipped = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "status")
						status = caseList.item(k).getTextContent();
				}

				TestCaseService testCaseService = new TestCaseService();
				TestCase testCase = testCaseService.insertIfNotExists(testName,className);
						

				int durationMilSec = (int) (Double.parseDouble(duration) * 1000);

				int testStatus = 0;
				if (status.equals("PASSED"))
					testStatus = 1;
				else if (status.toString().equals("REGRESSION"))
					testStatus = 2;
				else if (status.toString().equals("FIXED"))
					testStatus = 3;
				else if (status.toString().equals("SKIPPED"))
					testStatus = 4;
				else
					testStatus = 5;

				Build build = new Build();
							
				build.setProject(project);
				build.setNumber(buildNo);
				build.setBuildTime(new Date());
				
				History history = new History();

				HistoryService historyService = new HistoryService();
				
				history.setTestCase(testCase);
				history.setAge(Integer.parseInt(age));
			    history.setDuration(durationMilSec);
			    history.setFailedSince(Integer.parseInt(faileddSince));
			    history.setIsSkipped(Boolean.valueOf(is_skipped));
			    history.setStatus(testStatus);
			    
			    historyService.save(history);

				count = count + 1;
				

			}

		}
	}

}
