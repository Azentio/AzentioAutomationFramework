package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;

public class KUBS_reviewer extends BaseClass {
	WebDriver driver=BaseClass.driver;
	KUBS_Login login;
	ConfigFileReader config=new ConfigFileReader();
	KUBS_ReviewerObj reviewer;
	WaitHelper waithelper;
	BrowserHelper browserHelper;
	String referance_id;
	JsonDataReaderWriter reader;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig=new JsonConfig();
	
	 @Given("^Navigate to Url and login as a reviewer$")
	    public void navigate_to_url_and_login_as_a_reviewer() throws Throwable {
		  reader=new JsonDataReaderWriter();
			login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	    }

	    @Then("^Click on Notification button$")
	    public void click_on_notification_button() throws Throwable {
	    	waithelper=new WaitHelper(driver);
	    	reviewer=new KUBS_ReviewerObj(driver);
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	    	reviewer.reviewerNotidicationIcon().click();
	      
	    }

	    @Then("^Click on action button$")
	    public void click_on_action_button() throws IOException{

	    }

	    @And("^Find the budget code which submitted from maker$")
	    public void find_the_budget_code_which_submitted_from_maker() throws Throwable {
	    	browserHelper = new BrowserHelper(driver);
	    	budgetdata=jsonconfig.getBudgetdataByName("Maker");
			String before_xpath = "//datatable-row-wrapper[";
			String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
			String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
			//reviewer = new KUBS_ReviewerObj(driver);
			//reviewer.reviewerNotidicationIcon().click();
			for (int i = 1; i < 10; i++) {
				waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
				referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				
				waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
						+ after_xpath_for_action)));
				driver.findElement(By.xpath(before_xpath + i
						+ after_xpath_for_action)).click();
				//waithelper.waitForElement(driver, 2000, reviewer.reviewerGetBudgetCode());
				//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//ion-grid")));
				//String text=driver.getPageSource();
				//System.out.println("Text from grid : "+text);
				//String budgetcode = reviewer.reviewerGetBudgetCode().getAttribute("class");
				//System.out.println("Data from json"+budgetdata.BudgetCode);
				//System.out.println("data from form"+budgetcode);
				//if (budgetcode.equalsIgnoreCase(budgetdata.BudgetCode)) {
					reader.addReferanceData(referance_id);
					waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
					reviewer.reviewerApproveButton().click();
					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
					reviewer.reviewerAlertRemarks().sendKeys("ok");
					waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
					reviewer.reviewerAlertSubmitButton().click();
					break;
				//} else {
					//browserHelper.goBack();
					//referance_id = "";
				//}
			}
	        
	    }

	    @And("^Approve the record$")
	    public void approve_the_record() throws Throwable {
	       
	    }
}
