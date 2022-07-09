package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Lenovo
 * @Description To select hotel
 * @CreationDate 24/06/2022
 */

public class SelectHotelStep {
	PageObjectManager pom = new PageObjectManager();

	/**
	 * @Description Used to click continue for selecting hotel
	 * @CreationDate 24/06/2022
	 */

	@Then("User Should Select Hotel")
	public void userShouldSelectHotel() {
		pom.getSelectPage().selectHotel();
	}

	/**
	 * 
	 * @param bookAHotel
	 * @Description Used to verify after selecting hotel
	 * @CreationDate 248/068/2022
	 * 
	 */

	@Then("User Should Verify Message After Select {string}")
	public void userShouldVerifyMessageAfterSelect(String string) {
		Assert.assertEquals("Book A Hotel", string);

	}

	/**
	 * @Description Used to click continue without selecting hotel
	 * @CreationDate 24/06/2022
	 */

	@Then("User Should Continue To Book Hotel Page Without Selecting Hotel")
	public void userShouldContinueToBookHotelPageWithoutSelectingHotel() {
		pom.getSelectPage().selectContinue();

	}

	/**
	 * 
	 * @param selectAHotel
	 * @Description Used to verify the Please select a hotel error message
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Verify Error Message After Not Selecting Hotel {string}")
	public void userShouldVerifyErrorMessageAfterNotSelectingHotel(String string) {
		Assert.assertEquals("Please Select a Hotel", string);

	}
}
