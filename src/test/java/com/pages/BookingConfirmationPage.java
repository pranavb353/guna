package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Lenovo
 * @Description To confirm booking in Adactin Hotel
 * @CreationDate 24/06/2022
 */

public class BookingConfirmationPage extends BaseClass {
	
	/**
	 * @Description Used to Initialize driver
	 * @CreatedDate 24/06/2022 
	 */
	
	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement getAttributeValue;

	@FindBy(xpath = "//td[text()='Booking Confirmation']")
	private WebElement verifyBookingConfirmation;
	
	public WebElement getGetAttributeValue() {
		return getAttributeValue;
	}

	public WebElement getVerifyBookingConfirmation() {
		return verifyBookingConfirmation;
	}
	
	/**
	 * 
	 * @return String
	 * @Description Used to get order id
	 * @CreationDate 24/06/2022
	 * 
	 */

	public String getOrderId() {
		System.out.println("balajiii");
		System.out.println("natappan");
		String orderID = getAttribute(getOrderId());
		System.out.println("shiva");
		System.out.println("shiva");
		System.out.println("shiva");
		System.out.println("shiva");
		System.out.println(" balaji");
		return orderID;

	}

}
