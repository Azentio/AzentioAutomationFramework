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
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class KUBS_ChekcerSteps extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCategory", "DataSet ID");
	ExcelData excelDataForAssetCodeConfig = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	ExcelData excelDataForAssetGlConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Map<String, String> checkerTestData = new HashMap<>();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData excelDataForSerialNumberSetUp = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	@Given("^Navigate to KUBS url and login with checker for approve asset category record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D1");
	}
	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record$")
    public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D1");
    }
	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record$")
    public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");   
    }
	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record$")
    public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D1"); 
    }
	@And("^click on security management tool$")
	public void click_on_security_management_tool() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerSecurityManagement(), 20, 1);
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^click on temp view near by open pool$")
	public void click_on_temp_view_near_by_open_pool() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.kubsCheckerOpenPoolTemp(), 20, 1);
		checkerObj.kubsCheckerOpenPoolTemp().click();
	}

	@And("^clime the record by the help of Record reference ID$")
	public void clime_the_record_by_the_help_of_record_reference_id() throws Throwable {
		String xpath = "//span[text()='" + checkerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button";
		for (int i = 0; i <= 50; i++) {
			try {
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify record got climed in checker$")
	public void verify_record_got_climed_in_checker() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Claimed Successfully!!! Approve record from inbox");
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertClose(), 20, 1);
		kubsCommonObj.kubsAlertClose().click();
	}

	@And("^click on notification in checker stage$")
	public void click_on_notification_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationIcon(), 20, 1);
		kubsCommonObj.kubsNotificationIcon().click();
	}

	@And("^select the record in notification in checker stage$")
	public void select_the_record_in_notification_in_checker_stage() throws Throwable {
		String xpath = "//span[text()='" + checkerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on approve button in checker$")
	public void click_on_approve_button_in_checker() throws Throwable {
waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 20, 1);
kubsCommonObj.kubsApproveButton().click();

	}

	@And("^give approve alert remark in checker stage$")
	public void give_approve_alert_remark_in_checker_stage() throws Throwable {
waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
kubsCommonObj.kubsAlertRemark().click();
kubsCommonObj.kubsAlertRemark().sendKeys(checkerTestData.get("CheckerAlertRemark"));
	}

	@And("^click on submit button in checker stage$")
	public void click_on_submit_button_in_checker_stage() throws Throwable {
waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
kubsCommonObj.kubsAlertSubmit().click();
	}

	@Then("^verify record got approved in checker stage$")
	public void verify_record_got_approved_in_checker_stage() throws Throwable {
waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(), "Record approved successfully");
	}

}
