package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.adactin.utilities.Utilities;

public class SearchHotelPage {

	private static SearchHotelPage SearchHotelPageInstance;

	private SearchHotelPage() {}

	public static SearchHotelPage getInstance() {

		if(SearchHotelPageInstance == null) {
			SearchHotelPageInstance = new SearchHotelPage();
		}

		return SearchHotelPageInstance;

	}

	@FindBy(name="username_show")
	private WebElement userNameShow;

	@FindBy(name="location")
	private WebElement LocationDropdown;

	@FindBy(id="hotels")
	private WebElement hotelsDropdown;

	@FindBy(id="room_type")
	private WebElement roomtypeDropdown;

	@FindBy(id="room_nos")
	private WebElement room_nosDropdown;

	@FindBy(id="datepick_in")
	private WebElement datepickin;

	@FindBy(id="datepick_out")
	private WebElement datepickout;

	@FindBy(id="adult_room")
	private WebElement adultroomDropdown;

	@FindBy(id="child_room")
	private WebElement childroomDropdown;

	@FindBy(id="Submit")
	private WebElement searchtbutton;


	public String getUserName() {
		try {
			Utilities.getInstance().highlightElement(userNameShow);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userNameShow.getAttribute("value");
	}

	public void LocationDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(LocationDropdown);
			Utilities.getInstance().Dropdown(LocationDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public void HotelsDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(hotelsDropdown);
			Utilities.getInstance().Dropdown(hotelsDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public void roomtypeDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(roomtypeDropdown);
			Utilities.getInstance().Dropdown(roomtypeDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public void room_nosDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(room_nosDropdown);
			Utilities.getInstance().Dropdown(room_nosDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public void adultroomDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(adultroomDropdown);
			Utilities.getInstance().Dropdown(adultroomDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void childroomDropdown(String value, String method) {

		try {
			Utilities.getInstance().highlightElement(childroomDropdown);
			Utilities.getInstance().Dropdown(childroomDropdown, value, method);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void datepickin(String datein) {
		datepickin.clear();
		datepickin.sendKeys(datein);
	}
	
	public void datepickout(String dateout) {
		datepickout.clear();
		datepickout.sendKeys(dateout);
	}
	
	public void clickSearchButton() {
		searchtbutton.click();
	}
	

}
