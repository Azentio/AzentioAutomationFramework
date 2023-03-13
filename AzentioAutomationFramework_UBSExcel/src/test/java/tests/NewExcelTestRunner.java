package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.core.cli.Main;
import io.cucumber.testng.CucumberOptions;
import utilities.CucumberRunner;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class NewExcelTestRunner {
CucumberRunner cucumberRunner= new CucumberRunner();
	public void excelTestArea(List<String> listOfTags)
	{
		List<String[]> listOfArguments = new ArrayList<>();
		for (String tags : listOfTags) {
			String[] parameter = {

					"src/test/java/features/FixedAsset_AssetAllocationFEATURE.feature",

					"--glue", "stepdefinitions",

					"--plugin", "pretty", 
					"--plugin","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"--plugin",
					"rerun:ReRunScenarios/FailedReRun.txt", 
					"--tags", "@" + tags
					};
			listOfArguments.add(parameter);
			
		}
		cucumberRunner.run(listOfArguments);		
		
	}
	public void runTestCaseFeatureFileWise(String tags)
	{
		
			String[] parameter = {

					"src/test/java/features/FixedAsset_AssetAllocationFEATURE.feature",

					"--glue", "stepdefinitions",

					"--plugin", "pretty", 
					"--plugin","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
					"--plugin",
					"rerun:ReRunScenarios/FailedReRun.txt", 
					//"--tags", "@" + tags
					};
	Main.run(parameter);	
		}
	
	
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Test Started");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Test()
	public void test() {
//		List<String> listOfTags= new ArrayList<>();
//		listOfTags.add("KUBS_FAT_UAT_002_007_01Allocation01");
//		listOfTags.add("KUBS_FAT_UAT_002_007_02Allocation02");
//		listOfTags.add("KUBS_FAT_UAT_002_007_03Allocation03");
//		listOfTags.add("KUBS_FAT_UAT_002_007_04Allocation04");
//		listOfTags.add("KUBS_UAT_KUBS_BP_UAT_003_005_01");
//		listOfTags.add("KUBS_UAT_KUBS_BP_UAT_003_005_02");
//		listOfTags.add("KUBS_UAT_KUBS_BP_UAT_003_005_03");
//		listOfTags.add("KUBS_UAT_KUBS_BP_UAT_003_005_04");
//		System.out.println(listOfTags.size());
		NewExcelTestRunner newExcelTestRunner= new NewExcelTestRunner();
		//newExcelTestRunner.excelTestArea(listOfTags);
		newExcelTestRunner.runTestCaseFeatureFileWise(null);
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Test Endded");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
