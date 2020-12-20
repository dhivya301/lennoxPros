package com.lennoxPros.TestRunner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", 
				glue = "{steps}",

				plugin = { "pretty", "html:Reports/Cucumber-html-report.html",
				"json:Reports/Cucumber-html-report/jsonReport.json",
				"com.cucumber.listener.ExtentCucumberFormatter:Reports/ExtentReport.html",
				"rerun:rerun/failed_scenarios.txt" }, monochrome = true, dryRun = false)
public class TestRunner {
	@AfterClass
	public static void extendReport() throws IOException {

		Reporter.loadXMLConfig(new File("C:\\Users\\hp\\eclipse-workspace\\Assessment\\extend-config.xml"));
		Reporter.setSystemInfo("User Name", "HP");
		Reporter.setSystemInfo("Application Name", "Test App ");
		Reporter.setSystemInfo("Operating System Type", "windows");
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		Reporter.addScreenCaptureFromPath(".\\Screenshot\\images.jpeg");
	
	}
}
