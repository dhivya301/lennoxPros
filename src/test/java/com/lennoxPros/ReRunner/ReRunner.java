package com.lennoxPros.ReRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="@rerun/failed_scenarios.txt",
		glue={"com.StepsDefinition"},
		plugin={"pretty","html:Reports/Cucumber-html-report.html",
		"json:Reports/Cucumber-html-report/jsonReport.json",
		"com.cucumber.listener.ExtentCucumberFormatter:Reports/ExtentReport.html",
		"rerun:rerun/failed_scenarios.txt"},
		monochrome=true,
		dryRun=false)
public class ReRunner {

}
