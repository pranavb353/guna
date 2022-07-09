package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Lenovo
 * @Description To search hotel 
 * @CreationDate 23/06/2022
 */

public class SearchHotelPage extends BaseClass {
	
	/**
	 * @Description Used to Initialize driver
	 * @CreatedDate 24/06/2022 
	 */
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement searchLocation;

	@FindBy(id = "hotels")
	private WebElement searchHotel;

	@FindBy(id = "room_type")
	private WebElement searchRoomType;

	@FindBy(xpath = "//input[@id='datepick_in']")
	private WebElement searchCheckInDate;

	@FindBy(xpath = "//input[@id='datepick_out']")
	private WebElement searchCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement searchAdultRoom;

	@FindBy(id = "child_room")
	private WebElement searchChildRoom;

	@FindBy(id = "Submit")
	private WebElement searchSubmit;

	@FindBy(xpath = "//td[@class='login_title'])[2]")
	private WebElement verifySelectHotel;

	
	public WebElement getSearchLocation() {
		return searchLocation;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}

	public WebElement getSearchRoomType() {
		return searchRoomType;
	}

	public WebElement getSearchCheckInDate() {
		return searchCheckInDate;
	}

	public WebElement getSearchCheckOutDate() {
		return searchCheckOutDate;
	}

	public WebElement getSearchAdultRoom() {
		return searchAdultRoom;
	}

	public WebElement getSearchChildRoom() {
		return searchChildRoom;
	}

	public WebElement getSearchSubmit() {
		return searchSubmit;
	}

	public WebElement getVerifySelectHotel() {
		return verifySelectHotel;
	}
	
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
	 * @Description Used to search hotel with all credentials
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void searchHotel(String location, String hotelName, String roomType, String numOfRooms, String checkIndate,
			String checkOutDate, String adultPerRoom, String childPerRoom) {
		sendText(getSearchLocation(), location);
		sendText(getSearchHotel(), hotelName);
		sendText(getSearchRoomType(), roomType);
		clearText(getSearchCheckInDate());
		clearText(getSearchCheckOutDate());
		sendText(getSearchCheckInDate(), checkIndate);
		sendText(getSearchCheckOutDate(), checkOutDate);
		sendText(getSearchAdultRoom(), adultPerRoom);
		sendText(getSearchChildRoom(), childPerRoom);
		clickButton(getSearchSubmit());

	}
	
	/**
	 * 
	 * @param location
	 * @param roomNo
	 * @param checkIndate
	 * @param checkOutDate
	 * @param adultPerRoom
	 * @Description Used to search hotel using mandatory fields 
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void searchHotel(String location, String numOfRooms, String checkIndate, String checkOutDate,
			String adultPerRoom) {
		sendText(getSearchLocation(), location);
		clearText(getSearchCheckInDate());
		clearText(getSearchCheckOutDate());
		sendText(getSearchCheckInDate(), checkIndate);
		sendText(getSearchCheckOutDate(), checkOutDate);
		sendText(getSearchAdultRoom(), adultPerRoom);
		clickButton(getSearchSubmit());
	}
	
	/**
	 * @Description Used to search hotel without giving filling any field
	 * @CreationDate 23/06/2022
	 * 
	 */

	public void searchHotel() {
		clickButton(getSearchSubmit());
	}

}
