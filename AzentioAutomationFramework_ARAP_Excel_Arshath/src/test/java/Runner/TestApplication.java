package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

@CucumberOptions(features = "src/test/java/features/",
                 glue = "stepdefinitions",
		         //monochrome=false, //to make steps in color
		         plugin = { "pretty",
				            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				            "rerun:ReRunScenarios/FailedReRun.txt"}
///ArAp1.feature			dryRun = true //to check compilation errors
					,  tags="@KUBS_AR_AP_UAT_008_001_TC_02_3"


)
public class TestApplication extends AbstractTestNGCucumberTests {

//	  @Override
//	  
//	  @DataProvider(parallel = true) public Object[][] scenarios() { return
//	  super.scenarios(); }
	 
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



