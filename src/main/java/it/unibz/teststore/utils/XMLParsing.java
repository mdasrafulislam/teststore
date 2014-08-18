package it.unibz.teststore.utils;


import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void LoadData(String path, Long buildId) throws DOMException,
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
/*
					TestCaseService testCaseService = new TestCaseService();
					TestCase testCase = testCaseService.insertIfNotExists(testcasename.g
							classname.getLocalName());
							

					// break;
					int durationMilSec = (int) (Double.parseDouble(duration
							.getTextContent()) * 1000);

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

					TestInstanceOperation tio = new TestInstanceOperation();
					tio.insert(buildId, testInfo.getId(),
							Integer.parseInt(age.getTextContent()),
							Integer.parseInt(failedSince.getTextContent()),
							testStatus, durationMilSec,
							Boolean.valueOf(is_skipped.getTextContent()));

					count = count + 1;
					*/
				}
			}

		}

	}

	public static void LoadDataSecondFormat(String path, Long buildId)
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
			String testName = null, skipped = null, status = null;

			for (int y = 0; y < nlist.getLength() - 5; y++) {

				org.w3c.dom.Node casea = nlist.item(y);
				NodeList caseList = casea.getChildNodes();
/*
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
						skipped = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "status")
						status = caseList.item(k).getTextContent();
				}

				TestInfoOperation testInfoOperation = new TestInfoOperation();
				TestInfo testInfo = testInfoOperation.insertIfNotExists(
						testName, className);

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

				TestInstanceOperation tio = new TestInstanceOperation();
				tio.insert(buildId, testInfo.getId(), Integer.parseInt(age),
						Integer.parseInt(faileddSince), testStatus,
						durationMilSec, Boolean.valueOf(skipped));

				count = count + 1;

				// System.out.println(testInfo.getId()) ;

				// System.out.println(count+" "+testInfo.getId()+" "+className
				// +" "+testName +" " +duration) ;
				// System.out.println(count+" "+className +" "+testName +" "
				// +duration) ;
			}

		}
		System.out.println(count);
	}

	public static void LoadDatafromWebApi(Long buildId) throws DOMException,
			Exception {

		String urlAddress = "https://builds.apache.org/job/ZooKeeper-trunk-ibm6/"
				+ buildId + "/testReport/api/xml";

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
			String testName = null, skipped = null, status = null;

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
						skipped = caseList.item(k).getTextContent();
					else if (caseList.item(k).getNodeName() == "status")
						status = caseList.item(k).getTextContent();
				}

				// TestInfoOperation testInfoOperation = new
				// TestInfoOperation();
				// TestInfo testInfo=
				// testInfoOperation.insertIfNotExists(testName, className);

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

				/*
				 * TestInstanceOperation tio= new TestInstanceOperation();
				 * tio.insert(buildId,testInfo.getId(),Integer.parseInt(age),
				 * Integer.parseInt(faileddSince), testStatus, durationMilSec,
				 * Boolean.valueOf(skipped));
				 */
				count = count + 1;

			}

		}
		System.out.println(count);

	}

}
