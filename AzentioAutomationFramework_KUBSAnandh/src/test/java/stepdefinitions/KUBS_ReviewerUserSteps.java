package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class KUBS_ReviewerUserSteps extends BaseClass {

	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	
	Map<String, String> reviewerTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper cliksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_Login kubsLogin= new KUBS_Login(driver);
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCategory", "DataSet ID");
	ExcelData exceldatforAssetCodeConfig = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	ExcelData exceldatforAssetGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	ExcelData excelDataForSerialNumberSetUp = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	@Given("^navigate to kubs url to approve the asset category record$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the asset code configuration record$")
    public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the asset GL configuration record$")
    public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));   
    }
	@Given("^navigate to kubs url to approve the fixed asset serial number setup record$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
		}
	@And("^click on notification in reviewer stage$")
	public void click_on_notification_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationIcon(), 20, 1);
		kubsCommonObj.kubsNotificationIcon().click();
	}

	@And("^select the record in notification$")
	public void select_the_record_in_notification() throws Throwable {
		String xpath = "//span[text()='" + reviewerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				cliksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}

			}
		}
	}

	@And("^click on approve button in reviewer stage$")
	public void click_on_approve_button_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 20, 1);
		kubsCommonObj.kubsApproveButton().click();
	}

	@And("^enter the alert remark in reviewer stage$")
	public void enter_the_alert_remark_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		kubsCommonObj.kubsAlertRemark().click();
		kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("ReviewerAlertRemark"));
	}

	@And("^click on submit in reviewer alert pop up$")
	public void click_on_submit_in_reviewer_alert_pop_up() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		kubsCommonObj.kubsAlertSubmit().click();
	}

	@Then("^verify record got approved in reviewer stage$")
	public void verify_record_got_approved_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Record is available in CHECKER's Open Pool with status PENDING");
	}
}
