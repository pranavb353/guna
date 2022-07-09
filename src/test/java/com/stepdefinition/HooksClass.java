package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * @author Lenovo
 * @Description To create before and after scenario for test cases
 * @CreationDate 24/06/2022
 */

public class HooksClass extends BaseClass {
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description Used to run the scenario before all test cases
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		loadUrl(getPropertyFileValue("url"));
		maximize();
		implicitWaits(30);

	}
	
	/**
	 * 
	 * @param scenario
	 * @Description Used to run the scenario after all test cases
	 * @CreationDate 24/06/2022
	 * 
	 */

	@After
	public void afterScenario(Scenario scenario) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshotAs, "Every Scenario");
		closeAllWindow();

	}


}
