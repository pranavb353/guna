package com.stepdefinition;

import org.junit.Assert;

import com.pageobjectmanager.PageObjectManager;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Lenovo
 * @Description To search hotel
 * @CreationDate 24/06/2022
 */

public class SearchHotelStep {
	
	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @param location
	 * @param hotelName
	 * @param roomType
	 * @param roomNo
	 * @param checkIndate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @param childPerRoom
	 * @Description Used to search hotel using uplisted parameters
	 * @CreationDate 24/06/2022
	 */

	@Then("User Should Fill & Submit All Feilds In Search Hotel Page {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldFillSubmitAllFeildsInSearchHotelPageAnd(String location, String hotels, String roomType, String roomNo, String checkIndate, String checkOutDate, String adultPerRoom, String childPerRoom) {
	pom.getSearchhotelPage().searchHotel(location, hotels, roomType, roomNo, checkIndate, checkOutDate, adultPerRoom, childPerRoom);
	}
	
	/**
	 * 
	 * @param selectHotel
	 * @Description Used to verify after search hotel
	 * @CreationDate 24/036/2022
	 * 
	 */

	@Then("User Should Verify Message After Search {string}")
	public void userShouldVerifyMessageAfterSearch(String string) {
		Assert.assertEquals("Select Hotel", string);
	}
	
	/**
	 * 
	 * @param location
	 * @param roomNo
	 * @param checkIndate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @Description Used to search hotel with mandatory fields
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Fill & Submit Only Mandatory Feilds In Search Hotel Page {string},{string},{string},{string} and {string}")
	public void userShouldFillSubmitOnlyMandatoryFeildsInSearchHotelPageAnd(String location, String roomNo, String checkIndate, String checkOutDate, String adultPerRoom) {
	pom.getSearchhotelPage().searchHotel(location, roomNo, checkIndate, checkOutDate, adultPerRoom);
	}
	
	/**
	 * 
	 * @param checkOutDate
	 * @param checkInDate
	 * @Description Used to verify invalid checkin and checkout date error message
	 * @creationDate 24/06/2022
	 * 
	 */

	@Then("User Should Verify Invalid Date Error Message After Search {string},{string}")
	public void userShouldVerifyInvalidDateErrorMessageAfterSearch(String string, String string2) {
		Assert.assertEquals("Check-In Date shall be before than Check-Out Date", string);
		Assert.assertEquals("Check-Out Date shall be after than Check-In Date", string2);
	}
	
	/**
	 * @Description Used to search hotel without filling any field
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Submit Search Hotel Page Without Filling Any Details")
	public void userShouldSubmitSearchHotelPageWithoutFillingAnyDetails() {
	pom.getSearchhotelPage().searchHotel();
	}
	
	/**
	 * 
	 * @param location
	 * @Description Used to verify location error message
	 * @CreationDate 24/06/2022
	 * 
	 */

	@Then("User Should Verify Error Message After Search {string}")
	public void userShouldVerifyErrorMessageAfterSearch(String string) {
		Assert.assertEquals("Please Select a Location", string);
	  
	}

}


