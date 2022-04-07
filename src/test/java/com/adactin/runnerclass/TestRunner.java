package com.adactin.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Search_Hotel_To_Accept_Valid_CheckOut_Date.feature"},
				glue= {"com.adactin.stepdefenition"},
				monochrome = true,
				dryRun = false,
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"html:target/cucumber-report/htmlreports.html"}
				)
public class TestRunner {

}
