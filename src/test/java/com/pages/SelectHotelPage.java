package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Lenovo
 * @Description To select hotel on Adactin hotel
 * @CreationDate 24/06/2022
 */

public class SelectHotelPage extends BaseClass {
	
	/**
	 * @Description Used to Initialize driver
	 * @CreatedDate 24/06/2022 
	 */
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement selectHotel;

	@FindBy(id = "continue")
	private WebElement selectContinue;

	@FindBy(xpath = "//td[@class='login_title'])[2]")
	private WebElement verifyBookAHotel;

	
	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getSelectContinue() {
		return selectContinue;
	}

	public WebElement getVerifyBookAHotel() {
		return verifyBookAHotel;
	}
	
	/**
	 * @Description Used to continue booking by selecting hotel
	 * @CreationDate 24/06/2022
	 * 
	 */

	public void selectHotel() {
		clickButton(getSelectHotel());
		clickButton(getSelectContinue());

	}
	
	/**
	 * @Description Used to continue booking without selecting hotel
	 * @CreationDate 24/06/2022
	 * 
	 */

	public void selectContinue() {
		clickButton(getSelectContinue());

	}

}
