package com.adactin.stepdefenition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.adactin.constants.Constants;
import com.adactin.utilities.Utilities;
import com.adactin.webdrivermanager.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class CommonStepdefenition {


	private static final Logger LOGGER = LogManager.getLogger(CommonStepdefenition.class);
	private Scenario scenario;

	@Before
	public void BeforeScenario(Scenario scenario) {	

		try {
			
			LOGGER.info("-------------------Execution Starting--------------------");
			LOGGER.info("Starting "+" scenario");
			this.scenario = scenario;
			LOGGER.info(scenario.getName());
			

			if(DriverManager.getDriver()==null) {
				
				LOGGER.info("Loading properties");
				Utilities.getInstance().loadproperties();

				LOGGER.info("opening "+Constants.BrowserName+" Browser");

				DriverManager.LaunchBrowser();
				Utilities.getInstance().initWebElemts();

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	




}
