package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

@CucumberOptions(features = "src/test/java/features", 
                 glue = "stepdefinitions",
		         //monochrome=false, //to make steps in color
		         plugin = { "pretty",
				            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				            "rerun:ReRunScenarios/FailedReRun.txt"}, 
				//dryRun = false //to check compilation errors
//				 tags="@KUBS_INV_MGMT_UAT_001_002"
//		         tags = "@KUBS_FAT_UAT_005_006"
//		         tags = "@KUBS_FAT_UAT_004_001"
//		         tags = "@KUBS_FAT_UAT_005_Creation"
//		         tags = "@KUBS_BP_UAT_006_002"
		         tags = "@KUBS_AR/AP_UAT_001_001_TC_009"
				 

)
public class TestApplication extends AbstractTestNGCucumberTests {
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
	@BeforeSuite
	public void beforeExecution() {
		System.out.println("*** Test Execution started ***");
	}

	@AfterSuite
	public void afterExecution() {
		System.out.println("*** Test Execution Finished ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
}
