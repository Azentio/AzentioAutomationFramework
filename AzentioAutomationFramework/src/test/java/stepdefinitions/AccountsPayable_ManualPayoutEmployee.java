package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import bsh.ParseException;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountsPayable_ManualPayoutEmployeeObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountsPayable_ManualPayoutEmployeeTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;


public class AccountsPayable_ManualPayoutEmployee  extends BaseClass { 
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	
	
	AccountsPayable_ManualPayoutEmployeeObj accountsPayable_ManualPayoutEmployeeObj = new AccountsPayable_ManualPayoutEmployeeObj(driver);
	AccountsPayable_ManualPayoutEmployeeTestDataType accountsPayable_ManualPayoutEmployeeTestDataType=jsonReader.getManualPayoutByName("Maker");

	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	BUDGET_BudgetCreationTestDataType budgetdata;
	
	

    @When("^click on eye button of manual payout$")
    public void click_on_eye_button_of_manual_payoutg() throws InterruptedException {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton());
    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton());
    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton().click();
    }

//    @And("^click on add button for manual payout$")
//    public void click_on_add_button_for_manual_payout() {
//    	waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_AddButton());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_AddButton().click();
//    }

    @And("^Fill the required fields for manual payout$")
    public void fill_the_required_fields_for_manual_payout() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		//EntityBranch
		waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.EntityBranch);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch().sendKeys(Keys.ENTER);
		
		//BP_Name
		waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.BP_Name);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name().sendKeys(Keys.ENTER);
		
		//BeneficiaryName
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().click();
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName());
		Thread.sleep(2000);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.BeneficiaryName);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(Keys.ENTER);
	
		//Currency
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.Currency);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency().sendKeys(Keys.ENTER);
		
		//PaymentBank
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.PaymentBank);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank().sendKeys(Keys.ENTER);
		
		//BankAccountNumber
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().click();
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.BankAccountNumber);
		Thread.sleep(2000);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(Keys.ENTER);
		
		//PaymentMode
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.PaymentMode);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode().sendKeys(Keys.ENTER);
		
		//ReferenceNumber
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.ReferenceNumber);
		
		//ChequeNumber
		waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.ChequeNumber);
		
		javascripthelper.scrollIntoViewAndClick(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Footer());
		
		//Remarks
		waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark());
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().click();
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.Remarks);
		
		//SelectPaymentTxnNumber
		Thread.sleep(5000);
		accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SelectPaymentTxnNumber().click();
		
    }
 /*
  *    @And("^Submit the Selected record of Manual payout$")
  
    public void submit_the_selected_record_of_manual_payout() throws Throwable {
    // Submit button
    waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitButton());
    accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitButton().click();
    		 
		
    //Remark
    javascripthelper.JavaScriptHelper(driver);
    waithelper.waitForElement(driver, 3000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker());
    javascripthelper.JSEClick(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker());
    accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker().sendKeys("OK");
    	
	//Remark Submit
	
	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitByMaker());
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitByMaker().click();
	Thread.sleep(2000);
	
	// REVIEWER
			Thread.sleep(2000);
			WebElement recordstatus = accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus();

			clicksAndActionHelper.moveToElement(recordstatus);
			String message = accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus().getText();
			System.out.println(message);
			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus().click();
			String t = "";
			String ar[] = message.split(" ");
			Thread.sleep(2000);
			for (int i = ar.length - 1; i >= 0; i--) {
				t = ar[ar.length - 1];
			}
			String reviewerId = "";
			for (int i = 0; i < t.length() - 1; i++) {
				if (t.charAt(i) == '.') {
				} else {
					reviewerId = reviewerId + t.charAt(i);
				}
			}
			System.out.println(reviewerId);
			jsonWriter = new JsonDataReaderWriter();
			jsonWriter.addData(reviewerId);
	
}*/
 
 


    
//    @Then("^Get the payout status$")
//    public void get_the_payout_status()  {
//    	
//    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Search());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Search().click();
//    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BusinessPartnerSearch());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BusinessPartnerSearch().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.BP_Name);
//    	System.out.println("Payout Status is - " +accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PayoutStatus().getText());
//       
//    }
   /* @Then("^click on the Notification select the record and reviewer Approve$")
    * 
   
    public void click_on_the_notification_select_the_record_and_reviewer_approve() throws Throwable {
    
  //notification
	waithelper = new WaitHelper(driver);
	reviewer = new Azentio_ReviewerObj(driver);
	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	reviewer.reviewerNotidicationIcon().click();
	
	
	//select the record
	browserHelper = new BrowserHelper(driver);
	budgetdata =  jsonReader.getBudgetdataByName("Maker");
	javascripthelper = new JavascriptHelper();
	Thread.sleep(1000);
	for (int i = 1; i <= 35; i++) {
		try {
			waithelper.waitForElement(driver, 3000, driver.findElement(
					By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
			WebElement referanceID = driver.findElement(
					By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
			referanceID.click();
			Assert.assertTrue(referanceID.isDisplayed());
			break;
		} catch (NoSuchElementException e) {
			waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

			kubschecker.checker_notification_next_button().click();
		}
	}
	String before_xpath = "//span[contains(text(),'";
	String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

	waithelper.waitForElement(driver, 5000,
			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
	driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	// Approve
	waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
	reviewer.reviewerApproveButton().click();
	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReviewerRemark() );
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReviewerRemark().sendKeys("ok");
	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
	reviewer.reviewerAlertSubmitButton().click();
	Thread.sleep(3000);

    }
    @And("^select the record and Approve remark by checker$")
    public void select_the_record_and_approve_remark_by_checker() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException  {
    Thread.sleep(1000);
	for (int i = 1; i <= 35; i++) {
		try {
		waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
		WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
		referanceID.click();
		Assert.assertTrue(referanceID.isDisplayed());
		break;
		} catch (NoSuchElementException e) {
			waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
			kubschecker.checker_notification_next_button().click();
			}
    }
		String before_xpath="//span[contains(text(),'";
		String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		 
		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
		
		
		//Approve
    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
    	kubschecker.checkerApproveButton().click();
    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark());
    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().sendKeys("OK");
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(6000);
	} */
}
