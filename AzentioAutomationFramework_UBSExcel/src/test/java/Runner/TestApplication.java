package Runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

@CucumberOptions(features = { //"src/test/java/features/FeatureTest.feature",
		 
	    //"src/test/java/features/FixedAsset_AssetAllocationFEATURE.feature",
		//"src/test/java/features/FixedAsset_AssetCreationWithGRN.feature",
		"src/test/java/features/FixedAsset_AssetAmmendmentFEATURE.feature",
	    //"src/test/java/features/FixedAsset_AssetCreationFEATURE.feature",
		//"src/test/java/features/FixedAsset_AssetImpairmentFEATURE.feature",
		//"src/test/java/features/FixedAsset_AssetReturnFEATURE.feature",
	   //"src/test/java/features/FixedAsset_AssetRevaluationFEATURE.feature",
		//"src/test/java/features/FixedAsset_ReportFEATURE.feature",
	 //"src/test/java/features/FixedAsset_AssetTransferFEATURE.feature",
		//"src/test/java/features/FixedAsset_AssetUndertakingFEATURE.feature"		
	   // "src/test/java/features/Test.feature" 
		},

		glue = "stepdefinitions",
		// monochrome=false,
		plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:ReRunScenarios/FailedReRun.txt" }
// dryRun = false
 //, tags = "@KUBS_FAT_UAT_013_009"
)
public class TestApplication extends AbstractTestNGCucumberTests {
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