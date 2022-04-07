package com.adactin.stepdefenition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.adactin.constants.Constants;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.utilities.Utilities;
import com.adactin.webdrivermanager.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyUserLogin_StepDef {

	WebDriver driver = DriverManager.getDriver();
	public static final Logger LOGGER = LogManager.getLogger(VerifyUserLogin_StepDef.class);


	@Given("the user opens the adactin site")
	public void the_user_opens_the_adactin_site() {

		driver.get(Constants.AppUrl);
	}

	@When("the user enters the username")
	public void the_user_enters_the_username() {

		try {
			LoginPage.getInstance().userName(Constants.UserName);
			LOGGER.info("the_user_enters_the_username");
		}catch(Exception e) {
			LOGGER.error("the_user_could_not_enter_the_username");
			LOGGER.error(e);
			Utilities.getInstance().takeScreenshot();

		}

	}


	@When("the user enters the password")
	public void the_user_enters_the_password() {

		try {
			LoginPage.getInstance().password(Constants.Password);
			LOGGER.info("the_user_enters_the_password");
		}catch(Exception e) {
			LOGGER.error("the_user_could_not_enter_the_password");
			Utilities.getInstance().takeScreenshot();

		}
	}

	@When("the user clicks the submit button")
	public void the_user_clicks_the_submit_button() {

		try {
			LoginPage.getInstance().clickLogin();
			LOGGER.info("the_user_clicks_the_submit_button");
		}catch(Exception e) {
			LOGGER.error("the_user_could_not_click_the_login_button");
			Utilities.getInstance().takeScreenshot();

		}

	}

	@Then("the user should be logged in and will able to see his username")
	public void the_user_should_be_logged_in_and_will_able_to_see_his_username() {

		try {
			String userName = SearchHotelPage.getInstance().getUserName();
			if(userName.contains(Constants.UserName)){
				System.out.println("User Successfully Logged In");
				LOGGER.info("the_user_is_able_to_see_UserName");
				LOGGER.info("ADCTN-1 Test case executed succesfully");
			}
			else {
				System.out.println("Expected is '"+Constants.UserName+"' but obtained is '"+ userName+"'");
				Utilities.getInstance().takeScreenshot();
			}

		} catch (Exception e) {
			LOGGER.error("the_user_is_unable_to_see_UserName");
			Utilities.getInstance().takeScreenshot();

		}
	}


}
