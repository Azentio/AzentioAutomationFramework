package stepdefinitions;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Petty_CashObj;
import resources.BaseClass;

public class Petty_Cash_Module {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	JsonConfig jsonconfig = new JsonConfig();
	Petty_CashObj pettyCashObj = new  Petty_CashObj(driver);
	
	@And("^click the Petty Cash Module$")
    public void click_the_petty_cash_module() throws Throwable {
        pettyCashObj.pettyCashModule().click();
    }

    @And("^click Fund request Eye icon In Petty cash Modle$")
    public void click_fund_request_eye_icon_in_petty_cash_modle() throws Throwable {
        pettyCashObj.fundRequestEyeIcon().click();
    }
    
    @And("^Enter the request amount$")
    public void enter_the_request_amount() throws Throwable {
        pettyCashObj.enterRequestAmout().click();
        pettyCashObj.enterRequestAmout().sendKeys("5000");
    }
    @Then("^Verify New Req should be created in the Fund Req list view with Unique Ref number$")
    public void verify_new_req_should_be_created_in_the_fund_req_list_view_with_unique_ref_number() throws Throwable {
        
    }
}
