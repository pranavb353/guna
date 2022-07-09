package com.reports;

import java.io.File;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Lenovo
 * @Description To generate the JVM report
 * @CreationDate 24/06/2022
 */

public class Reporting {

	/**
	 * 
	 * @param jsonFile
	 * @Description Used to generate JVM report
	 * @CreationDate 24/06/2022
	 * 
	 */

	public static void generateJVMreport(String jsonfile) {
		File file = new File(System.getProperty("user.dir") + "\\target");
		Configuration config = new Configuration(file, "Adactin Automation");
		config.addClassifications("OS", "Win11");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("OS", "Win11");
		config.addClassifications("Version", "103");
		config.addClassifications("Sprint", "33");

		java.util.List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, config);
		builder.generateReports();

	}

}
