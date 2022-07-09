package com.stepdefinition;

import java.util.List;

import java.util.Map;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Lenovo
 * @Description To book a hotel
 * @CreationDate 24/06/2022
 */

public class BookingHotelStep {

	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @Description Used to book a hotel and to save the generated order id
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Book Hotel {string},{string},{string} and Save Generated Order ID")
	public void userShouldBookHotelAndSaveGeneratedOrderID(String firstname, String lastname, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> cd = dataTable.asMaps(String.class,String.class);
		String ccNum =cd.get(2).get("CreditCardNo");
		String ccTYpe=cd.get(2).get("CreditCardType");
		String expMonth =cd.get(2).get("Month");
		String expYear =cd.get(2).get("Year");
		String ccvNo =cd.get(2).get("CCVNo");
	
		pom.getBookingPage().bookHotel(firstname, lastname, address, ccNum, ccTYpe, expMonth, expYear, ccvNo);
	}
	
	/**
	 * 
	 * @param bookingConfirmation
	 * @Description Used to verify after booking a hotel
	 * @CreationDate 24/06/2022
	 * 
	 */
	
	@Then("User Should Verify Message After Booking {string}")
	public void userShouldVerifyMessageAfterBooking(String string) {
		Assert.assertEquals("Booking Confirmation", string);

	}
	
	/**
	 * @Description Used to book a hotel without filling any field
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Book Hotel Without Filling All Mandatory Feilds")
	public void userShouldBookHotelWithoutFillingAllMandatoryFeilds() {

	}
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param cardNo
	 * @param cardType
	 * @param expMonth
	 * @param expYear
	 * @Description Used to verify the personal booking error message after booking a hotel
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Verify All Error Message After Booking {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyAllErrorMessageAfterBookingAnd(String string, String string2, String string3,
			String string4, String string5, String string6, String string7) {
		pom.getBookingPage().bookHotel();
		Assert.assertEquals("Please Enter your First Name", string);
		Assert.assertEquals("Please Enter you Last Name", string2);
		Assert.assertEquals("Please Enter your Address", string3);
		Assert.assertEquals("Please Enter your 16 Digit Credit Card Number", string4);
		Assert.assertEquals("Please Select your Credit Card Type", string5);
		Assert.assertEquals("Please Select your Credit Card Expiry Month", string6);
		Assert.assertEquals("Please Enter your Credit Card CVV Number", string7);

	}

}
