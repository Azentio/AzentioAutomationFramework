package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utilities.CucumberRunner;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class TestRunner {
	public void testRunner(List<String> listOfTags) {
		CucumberRunner cucumberRunner= new CucumberRunner();
for (String tags : listOfTags) {
	String[] parameter = {

			"src/test/java/features/Test1.feature",

			"--glue", "stepdefinitions",

			"--plugin", "pretty", "--plugin",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "--plugin",
			"rerun:ReRunScenarios/FailedReRun.txt", "--tags", "@" + tags };
	//cucumberRunner.run2(parameter);

}
}
		

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Execution Started");
	}

	@Test()
	public void test() {
		ExcelTestRunner excetTest = new ExcelTestRunner();
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		TestRunner testRunner= new TestRunner();
		testRunner.testRunner(list);
	}

	

	@AfterTest
	public void afterTest() {
		System.out.println("*** Test Execution Endded ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Execution Endded");

	}
}
