package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobjects.CommonElements.CSMCommonWebElements;
import resources.BaseClass;

public class LoginTest extends BaseClass {
	WebDriver driver = BaseClass.driver;

	CSMLogin csmLogin = new CSMLogin(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	CSMCommonWebElements csmCommonWebElements = new CSMCommonWebElements(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Given("^navigate to CSM application and login with valid credentials$")
	public void navigate_to_csm_application_and_login_with_valid_credentials() throws Throwable {
		
		driver.get(configFileReader.getCSMApplicationUrl());
		csmLogin.loginIntoCSMApplication();
	}

	@Given("^navigate to CSM param application and login with valid credentials$")
	public void navigate_to_csm_param_application_and_login_with_valid_credentials() throws Throwable {
		driver.get(configFileReader.getCSMparamsUrl());
		csmLogin.loginIntoCSMParamApplication();
	}

	@Given("^navigate to CSM sads application and login with valid credentials$")
	public void navigate_to_csm_sads_application_and_login_with_valid_credentials() throws Throwable {
		driver.get(configFileReader.getSADSApplicationUrl());
		csmLogin.loginIntoSadsApplication();
	}

	@And("^logout from the application$")
	public void logout_from_the_application() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, csmCommonWebElements.csmLogoutButton());
		clicksAndActionHelper.moveToElement(csmCommonWebElements.csmLogoutButton());
		clicksAndActionHelper.clickOnElement(csmCommonWebElements.csmLogoutButton());
		waitHelper.waitForElementwithFluentwait(driver, csmCommonWebElements.csmUserName());
		Assert.assertTrue(csmCommonWebElements.csmUserName().isDisplayed());
	}

}
