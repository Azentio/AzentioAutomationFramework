package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.core.cli.Main;
import tests.ExcelTest;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class NewExcelTestRunner {
	public void excelTestArea(List<String> listOfTags)
	{
		List<String[]> listOfArguments = new ArrayList<>();
		for (String tags : listOfTags) {
			String[] parameter = {

					"src/test/java/features/BudgetAndPlanning_UATRequestAndAllocation.feature",

					"--glue", "stepdefinitions",

					"--plugin", "pretty", 
					"--plugin","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"--plugin",
					"rerun:ReRunScenarios/FailedReRun.txt", 
					"--tags", "@" + tags
					};
			listOfArguments.add(parameter);
			
		}
		CucumberRunner.run(listOfArguments);
		
		
		
//		for (String[] strings : listOfArguments) {
//			cucumberRunner.run(strings);
//			//System.out.println("Exit Status is "+exitStatus);
//		}
		
		
	}
	public void runTestCaseFeatureFileWise(String tags)
	{
		
			String[] parameter = {

					"src/test/java/features/Test1.feature",

					"--glue", "stepdefinitions",

					"--plugin", "pretty", 
					"--plugin","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"--plugin",
					"rerun:ReRunScenarios/FailedReRun.txt", 
					//"--tags", "@" + tags
					};
	Main.run(parameter)	;	
		}
	
	
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Test Execution Started");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Test()
	public void test() {
		String path = System.getProperty("user.dir") +"\\Test-data\\KUBSTestData.xlsx";
		ExcelTest excelTest = new ExcelTest(path, "TestExecution", "Sequence");
		List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
		NewExcelTestRunner newExcelTestRunner= new NewExcelTestRunner();
		newExcelTestRunner.excelTestArea(testCaseTagsfromExcel);
	//	newExcelTestRunner.runTestCaseFeatureFileWise(null);
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Test Execution Ended");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
