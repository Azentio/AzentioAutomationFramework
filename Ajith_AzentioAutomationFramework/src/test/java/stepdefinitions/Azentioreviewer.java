package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;

public class Azentioreviewer extends BaseClass {
	WebDriver driver=BaseClass.driver;
	AzentioLogin login;
	ConfigFileReader config=new ConfigFileReader();
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);
	WaitHelper waithelper;
	BrowserHelper browserHelper;
	String referance_id;
	JsonDataReaderWriter reader;
	JavascriptHelper javascriptHelper;
	WaitHelper waitHelper = new WaitHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonConfig jsonconfig=new JsonConfig();
	
	 @Given("^Navigate to Url and login as a reviewer$")
	    public void navigate_to_url_and_login_as_a_reviewer() throws Throwable {
		  reader=new JsonDataReaderWriter();
			login = new AzentioLogin(driver);
			driver.get(config.getApplicationUrl());
			 login.logintoAzentioappReviewer("Reviewer", reader.readdata());
			 Thread.sleep(1000);
	    }

	    @Then("^Click on Notification button$")
	    public void click_on_notification_button() throws Throwable {
	    	waitHelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	    	reviewer.reviewerNotidicationIcon().click();
			waitHelper.waitForElement(driver, 2000, reviewer.Ar_Ap_reviewer_id());
			javascriptHelper.JavaScriptHelper(driver);
			referance_id = reviewer.Ar_Ap_reviewer_id().getText();
			System.out.println("Referance_id:" + referance_id);
			Assert.assertTrue(reviewer.Ar_Ap_reviewer_id().isDisplayed());
	    	waithelper=new WaitHelper(driver);
	    	reviewer=new Azentio_ReviewerObj(driver);
	    	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	    	reviewer.reviewerNotidicationIcon().click();
	      
	    }
        
	    @Then("^Click on action button$")
	    public void click_on_action_button() throws IOException, ParseException{
	    	javascriptHelper.JavaScriptHelper(driver);
			String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			//waitHelper.waitForElement(driver, 2000,
			//		driver.findElement(By.xpath(befr_xpath + jsonWriter.readReferancedata() + aftr_xpath)));
			driver.findElement(By.xpath(befr_xpath + jsonWriter.readReferancedata() + aftr_xpath)).click();
			
	    }
		@Then("^Approve the record in Reviewer$")
		public void approve_the_record_in_reviewer() throws Throwable {
			// -----------------REVIEWER APPROVE---------------------//
			jsonWriter.addReferanceData(referance_id);
			waitHelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
			reviewer.reviewerApproveButton().click();
		}

		@And("^Give Remark and Submit$")
		public void give_remark_and_submit() throws Throwable {
			// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
			waitHelper.waitForElement(driver, 5000, reviewer.reviewerAlertRemarks());
			reviewer.reviewerAlertRemarks().sendKeys("ok");
			waitHelper.waitForElement(driver, 5000, reviewer.reviewerAlertSubmitButton());
			javascriptHelper.JSEClick(reviewer.reviewerAlertSubmitButton());
			waitHelper.waitForElement(driver, 3000, reviewer.approvalStatus());
			String Notification = reviewer.approvalStatus().getText();
			System.out.println("Reviewer Notification: " + Notification);
			Assert.assertTrue(reviewer.approvalStatus().isDisplayed());
		}

	    @And("^Find the budget code which submitted from maker$")
	    public void find_the_budget_code_which_submitted_from_maker() throws Throwable {
	    	browserHelper = new BrowserHelper(driver);
	    	//budgetdata=jsonconfig.getBudgetdataByName("Maker");
			String before_xpath = "//datatable-row-wrapper[";
			String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
			String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
			//reviewer = new Azentio_ReviewerObj(driver);
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
