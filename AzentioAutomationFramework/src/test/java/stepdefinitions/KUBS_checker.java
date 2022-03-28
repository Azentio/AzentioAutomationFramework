package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;

public class KUBS_checker extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_CheckerObj kubschecker;
	WaitHelper waithelper;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JavascriptHelper javascript;

	@Given("^Navigate to Url and login as a Checker$")
	public void navigate_to_url_and_login_as_a_checker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");

	}

	@Then("^Click the Notification icon$")
	public void click_the_notification_icon() throws Throwable {
		waithelper = new WaitHelper(driver);
		kubschecker = new KUBS_CheckerObj(driver);
		//waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		//kubschecker.checkerNotificationIcon().click();

	}

	@And("^Click on security management$")
	public void click_on_security_management() throws Throwable {
		waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
    	kubschecker.checkerSecurityManagement().click();
    	
	}

	@Then("^Click on open pool$")
    public void click_on_open_pool() throws Throwable {
    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
    	kubschecker.checkerActionIcon().click();
      
    }

	@And("^Click on claim button$")
	public void click_on_claim_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
    	

	}

	@Then("^click on notification$")
	public void click_on_notification() throws Throwable {
		javascript=new JavascriptHelper();
		
		waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
		
		kubschecker.checkerNotificationIcon().click();

	}

	@Then("^approve the records$")
	public void approve_the_records() throws Throwable {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		//waithelper.waitForElement(driver,3000,kubschecker.checkersubmitButton());
        //kubschecker.checkersubmitButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
        
	}


}
