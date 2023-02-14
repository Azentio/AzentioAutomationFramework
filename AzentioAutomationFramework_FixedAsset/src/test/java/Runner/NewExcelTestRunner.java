package Runner;

import java.util.ArrayList;
import java.util.LinkedList;
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

					"src/test/java/features/BugetAndPlanningDefinition_UATFEATURE.feature",
					"src\\test\\java\\features\\BudgetAndPlanning_UATBudgetCreation.feature",
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
//		List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
		List<String> testCaseTagsfromExcel1 = new LinkedList<String>();
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_PreReq01");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_PreReq02");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_PreReq03");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_PreReq04");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_01");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_02");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_03");
		testCaseTagsfromExcel1.add("KUBS_UAT_KUBS_BP_UAT_003_004_04");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_003_01");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_003_02");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_003_03");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_003_04");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_004_01");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_004_02");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_004_03");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_001_004_04");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_005_006_01");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_005_006_02");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_005_006_03");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_005_006_04");
//		testCaseTagsfromExcel1.add("KUBS_BP_UAT_005_007");
		NewExcelTestRunner newExcelTestRunner= new NewExcelTestRunner();
		newExcelTestRunner.excelTestArea(testCaseTagsfromExcel1);
	//	newExcelTestRunner.runTestCaseFeatureFileWise(null);
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Test Execution Ended");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
