package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Lenovo
 * @Description To cancel the order id
 * @CreationDate 24/06/2022
 */
public class CancelBookingStep {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Descrption Used to cancel the generated order id
	 * @CreationDate 24/06/2022
	 */

	@Then("User Should Cancel The Order Id")
	public void userShouldCancelTheOrderId() {
		pom.getCancelBookingPage().cancelOrderId();

	}

	/**
	 * 
	 * @param orderId
	 * @Description Used to cancel the existing order id
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Verify Message After Cancelling {string}")
	public void userShouldVerifyMessageAfterCancelling(String string) {
		Assert.assertEquals("The booking has been cancelled.", string);
	}

	/**
	 * 
	 * @param ordedredCancelled
	 * @Description Used the cancellation message after canceling order id
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Cancel The Previously Booked Order Id {string}")
	public void userShouldCancelThePreviouslyBookedOrderId(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);

	}

}
