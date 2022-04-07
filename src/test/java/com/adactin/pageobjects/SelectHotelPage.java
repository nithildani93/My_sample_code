package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactin.utilities.Utilities;

public class SelectHotelPage {
	
	public static SelectHotelPage getInstance;
	
	private SelectHotelPage() {
		
	}
	
	public static SelectHotelPage getInstance() {
		
		if(getInstance == null) {
			getInstance = new SelectHotelPage();
		}
		
		return getInstance;
		
	}
	
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement pageTitle;
	
	@FindBy(xpath="//td/input[contains(@id,'hotel_name_')]")
	private WebElement hotelName;
	
	@FindBy(xpath="//td/input[contains(@id,'dep_date')]")
	private WebElement checkOutDate;
	
	
	public String getPageTitle() {
		Utilities.getInstance().highlightElement(pageTitle);
		return pageTitle.getText();
	}
		
	public String getHotelName() {
		Utilities.getInstance().highlightElement(hotelName);
		return hotelName.getAttribute("value");
	}
	
	public String getCheckOutDate() {
		Utilities.getInstance().highlightElement(hotelName);
		return checkOutDate.getAttribute("value");
		
	}
	
}
