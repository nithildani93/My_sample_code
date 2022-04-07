package com.adactin.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactin.constants.Constants;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;
import com.adactin.webdrivermanager.DriverManager;

public class Utilities {

	private static Utilities getInstance;
	
	private static final Logger LOGGER = LogManager.getLogger(Utilities.class);
	
	
	private Utilities() {

	}

	public static Utilities getInstance() {

		if(getInstance==null) {
			getInstance = new Utilities();
		}

		return getInstance;
	}


	public void loadproperties() {

		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}
		catch (IOException e) { 
			e.printStackTrace();
		}



		Constants.BrowserName = properties.getProperty("BrowserName");
		Constants.AppUrl = properties.getProperty("Url");
		Constants.UserName = properties.getProperty("UserName");
		Constants.Password = properties.getProperty("Password");


	}


	public void initWebElemts() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SearchHotelPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SelectHotelPage.getInstance());
	}


	public void takeScreenshot() {
		try {
			File Screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot, new File("Screenshot.png"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 2px solid red');", element);
	}

	public void Dropdown(WebElement element,String value, String method) {
		Select dropdown = new Select(element);

		switch (method) {
		case "index":
			dropdown.selectByIndex(Integer.parseInt(value));
			break;

		case "value":
			dropdown.selectByValue(value);
			break;
			
		case "text":
			dropdown.selectByVisibleText(value);
			break;

		default:
			LOGGER.info("Input selection can be done using value, index and text methods only");
			break;
		}
	}
	
	
	public String getCurrentDate() {
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date date1 = new Date();
		String date = dateformat.format(date1);
		return date;
	}

}
