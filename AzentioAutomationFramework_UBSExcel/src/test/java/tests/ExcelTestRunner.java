package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.core.cli.Main;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
public class ExcelTestRunner extends AbstractTestNGCucumberTests {

	public void testRunner(List<String> listOfTags) {
		

		// Main.run(parameter, Thread.currentThread().getContextClassLoader());

	}

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Execution Started");
	}

	@Test(dataProvider="tags-provider")
	public void test(String tags) {
		String[] parameter = {

				"src/test/java/features/BudgetAndPlanning_Temp.feature",

				"--glue", "stepdefinitions",

				"--plugin", "pretty", 
				"--plugin","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
				"--plugin",
				"rerun:ReRunScenarios/FailedReRun.txt", "--tags", "@" + tags };
		Main.run(parameter, CucumberOptions.class.getClassLoader());
	}
@DataProvider(name="tags-provider")
	public Object[] dataProvider()
	{
		ExcelTestRunner excetTest = new ExcelTestRunner();
		List<String> list = new ArrayList<>();
		list.add("KUBS_BP_UAT_001_002_01");
		list.add("KUBS_BP_UAT_001_002_02");
		Object[] array = list.toArray();
	return array;
	}
@AfterTest
public void afterTest()
{
	System.out.println("*** Test Execution Endded ***");
	ExtentTestManager.endTest();
	ExtentManager.getInstance().flush();
}
	@AfterSuite
	public void afterSuite() {
		System.out.println("Execution Endded");

	}

}
