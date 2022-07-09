package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 *@author Lenovo
 *@Description To find the locator for login page and generate getters
 *@CreationDate 23/06/2022
 */

public class LoginPage extends BaseClass {
	
	/**
	 * @Description Used to Initialize driver
	 * @CreatedDate 24/06/2022 
	 */

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//b[contains(text(),'Invalid ')]")
	private WebElement invalidLogin;



	public WebElement getTextUserName() {
		return txtUserName;
	}

	public WebElement getTextPassword() {
		return txtPassword;
	}

	public WebElement getbtnLogin() {
		return btnLogin;
	}

	public WebElement getInvalidLogin() {
		return invalidLogin;
	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @Description Used to perform login
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void login(String userName, String password) {
		sendText(getTextUserName(), userName);
		sendText(getTextPassword(), password);
		clickButton(getbtnLogin());

	}
	/**
	 * 
	 * @param userName
	 * @param password
	 * @throws AWTException
	 * @Description Used to perform login using enter key
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void loginWithEnter(String userName, String password) throws AWTException {
		sendText(getTextUserName(), userName);
		sendText(getTextPassword(), password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	/**
	 * @Description Used to perform login without any credentials
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void login() {
		clickButton(getbtnLogin());
	}
	
	/**
	 * 
	 * @return boolean
	 * @Description Used to get the invalid login message
	 * @CreationDate 23/06/2022
	 * 
	 */
	
	public boolean invalid() {
		boolean contains = getText1(getInvalidLogin()).contains("Invalid Login details or Your Password might have expired.");
		return contains;

	}

}
