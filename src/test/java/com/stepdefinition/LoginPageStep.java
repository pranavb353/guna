package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author Lenovo
 * @Dedcription To perform Login
 * @CreationDate 24/06/2022
 */

public class LoginPageStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @Description Used to reach hotel page
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Given("User is on the Adactin Home Page")
	public void userIsOnTheAdactinHomePage() throws FileNotFoundException, IOException {
		
	}
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @Description Used to perform login
	 * @CreationDate 24/06/2022
	 * 
	 */

	@When("User Should Perform Login {string},{string}")
	public void userShouldPerformLogin(String UserName, String Password) {
		pom.getLoginPage().login(UserName, Password);

	}
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @Description Used to perform login using enter key
	 * @CreationDate 24/06/2022
	 * 
	 */

	@When("User Should Perform Login {string},{string} With Help of ENTER key")
	public void userShouldPerformLoginWithHelpOfENTERKey(String UserName, String Password) throws AWTException {
		pom.getLoginPage().loginWithEnter(UserName, Password);

	}
	
	/**
	 * 
	 * @param invalidMessage
	 * @Description Used to verify the login error message
	 * @CraetionDate 24/06/2022
	 * 
	 */
	
	@Then("User Should Verify Login Error Message Contains After Login \"Invalid Login details or Your Password might have expired.")
	public void userShouldVerifyLoginErrorMessageContainsAfterLoginInvalidLoginDetailsOrYourPasswordMightHaveExpired() {
		Assert.assertTrue("Invalid Login Details or Your Password Might Have Expired",pom.getLoginPage().invalid());
	}
	

}
