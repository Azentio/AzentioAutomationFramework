package Runner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

@CucumberOptions(features = "src/test/java/features/KUBS_FixedAssetFeature.feature",
                 glue = "stepdefinitions",
                 //monochrome=false,
                 plugin = { "pretty",
                            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                            "rerun:ReRunScenarios/FailedReRun.txt"}
                //dryRun = false                                             
                 // , tags="@KUBS_FAT_UAT_002_005_04"
                        
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