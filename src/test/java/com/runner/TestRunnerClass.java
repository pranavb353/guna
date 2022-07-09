package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE, strict = true, dryRun = false, plugin = { "pretty",
		"json:target\\cucumber.json" }, monochrome = true, tags = {
				"@CancelBooking" }, features = "src\\test\\resources", glue = "com.stepdefinition")

/**
 * 
 * @author Lenovo
 * @Description To run the complete project
 * @CraetionDate 24/06/2022
 */
public class TestRunnerClass extends BaseClass {

	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description Used to run generated the JVM Report
	 * @CreationDate 24/06/2022
	 * 
	 */
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJVMreport(System.getProperty("user.dir") + "\\target\\cucumber.json");

	}

}
