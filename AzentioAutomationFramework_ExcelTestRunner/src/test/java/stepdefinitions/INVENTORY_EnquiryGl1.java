package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.INVENTORY_EnquiryGlObject;
import resources.BaseClass;
import testDataType.INVENTORY_EnquiryGlTestData;

public class INVENTORY_EnquiryGl1 extends BaseClass {
	WebDriver driver=BaseClass.driver;
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj=new INVENTORY_EnquiryGlObject(driver);
	KUBS_Login kubsLogin =new KUBS_Login(driver);
	ConfigFileReader configFileReader=new ConfigFileReader();
	JsonConfig jsonConfig=new JsonConfig();
	INVENTORY_EnquiryGlTestData inventoryEnquiryGlTestData=jsonConfig.getInventoryGlUATTestData("Maker");
	WaitHelper waitHelper=new WaitHelper(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	@Given("^navigate to kubs URL and login as maker$")
	public void navigate_to_kubs_url_and_login_as_maker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
	}

	/*@Then("^click on report segment button$")
	public void click_on_report_segment_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryEnquiryGlObj.inventoryReportIcon());
		inventoryEnquiryGlObj.inventoryReportIcon().click();
		waitHelper.waitForElement(driver, 3000, inventoryEnquiryGlObj.inventoryEnquiryMenu());
		Assert.assertTrue(inventoryEnquiryGlObj.inventoryEnquiryMenu().isDisplayed());
		
	}

	@And("^click on equiry menu$")
	public void click_on_equiry_menu() throws Throwable {
		waitHelper.waitForElement(driver, 3000,inventoryEnquiryGlObj.inventoryEnquiryMenu());

		inventoryEnquiryGlObj.inventoryEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, inventoryEnquiryGlObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryEnquiryGlObj.inventoryFinancialTransactionIcon().isDisplayed());
		
	}*/

	@Then("^click on edit icon near by fiancial transaction menu$")
	public void click_on_edit_icon_near_by_fiancial_transaction_menu() throws Throwable {
		inventoryEnquiryGlObj.inventoryFinancialTransactionIcon().click();

	}

	

	@And("^choose Gl code$")
	public void choose_gl_code() throws Throwable {
		for (int i = 0; i <200; i++) {
			try {
				inventoryEnquiryGlObj.inventoryGlCode().sendKeys(inventoryEnquiryGlTestData.gLCode);
				inventoryEnquiryGlObj.inventoryGlCode().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
	}

	@And("^click on transaction from date calender icon$")
	public void click_on_transaction_from_date_calender_icon() throws Throwable {
		for (int i = 0; i <200; i++) {
			try {
				inventoryEnquiryGlObj.inventoryFromDate().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

	}

	

	@And("^click on the transaction to date calender icon$")
	public void click_on_the_transaction_to_date_calender_icon() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, inventoryEnquiryGlObj.inventoryToDate(),30, 2);
		clickAndActionHelper.doubleClick(inventoryEnquiryGlObj.inventoryToDate());
		//.click();
	
	}

	
	/*@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		
		inventoryEnquiryGlObj.inventoryViewButton().click();
        Thread.sleep(1000);
		
	}*/

}
