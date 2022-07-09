package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Lenovo
 * @Description To cancel booking in Adactin Hotel
 * @CreationDate 23/06/2022
 */

public class CancelBookingPage extends BaseClass {
	
	/**
	 * @Description Used to Initialize driver
	 * @CreatedDate 24/06/2022 
	 */

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement clickItinarary;

	@FindBy(xpath="//input[@type='button'][1]")
	private WebElement clickOrderId;

	@FindBy(id = "order_id_text")
	private WebElement clickSearchBox;

	@FindBy(id = "search_hotel_id")
	private WebElement clickGoButton;

	@FindBy(name = "ids[]")
	private WebElement selectId;

	@FindBy(name = "cancelall")
	private WebElement clickCancel;

	public WebElement getClickItinarary() {
		return clickItinarary;
	}

	public WebElement getClickOrderId() {
		return clickOrderId;
	}

	public WebElement getClickSearchBox() {
		return clickSearchBox;
	}

	public WebElement getClickGoButton() {
		return clickGoButton;
	}

	public WebElement getSelectId() {
		return selectId;
	}

	public WebElement getClickCancel() {
		return clickCancel;
	}
	
	/**
	 * @Description used to cancel the generated order id
	 * @CreationDate 23/06/2022
	 */

	public void cancelOrderId() {
		clickButton(getClickItinarary());
		clickButton(getClickOrderId());
		simpleAlerts();

	}
	
	/**
	 * 
	 * @param orderId
	 * @Description Used to cancel the existing order id
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void cancelOrderId(String orderId) {
		clickButton(getClickItinarary());
		sendText(clickSearchBox, orderId);
		clickButton(getClickGoButton());
		clickButton(getSelectId());
		clickButton(getClickCancel());
		simpleAlerts();
		System.out.println("Deleted Successfully" );

	}
}
