package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountReceivable_AccountReceivableAdvancesObj;
import pageobjects.ArApObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;

public class AccountReceivable_AdvanceAgainstPO extends BaseClass { 
		WebDriver driver = BaseClass.driver;

		//ConfigFileReader configFileReader = new ConfigFileReader();
		ConfigFileReader config=new ConfigFileReader();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
		KUBS_Login login = new KUBS_Login(driver);
		KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
		WaitHelper waithelper = new WaitHelper(driver) ;
		BrowserHelper browserHelper;
		// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper(driver);
		ArApObj arAPobj = new ArApObj(driver);	
		AccountReceivable_AccountReceivableAdvancesObj accountReceivable_AccountReceivableAdvancesObj = new AccountReceivable_AccountReceivableAdvancesObj(driver);
		ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","AdvanceToEmployees", "DataSet ID");
		Map<String, String> testData = new HashMap<>();
		

	   @And("^user update the data set ID for Advance against PO$")
	   public void user_update_the_data_set_id_for_advance_against_po() throws Throwable {
		   testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_004_TC_01_01_D2");   
	   }	

	    @Then("^Fill the form for Account Recivable Advance against PO$")
	    public void fill_the_form_for_account_recivable_advance_against_po() throws InterruptedException {
//	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch());
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().click();
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().sendKeys(testData.get("EntityBranch"));
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EntityBranch().sendKeys(Keys.ENTER);
//	    	
	    	//ReceivableName
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(testData.get("ReceivableName"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(Keys.ARROW_DOWN);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(Keys.ENTER);
	    	
	    	//EmployeeName
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(testData.get("EmployeeName"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(Keys.ARROW_DOWN);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(Keys.ENTER);
	    	
	    	
	    	
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().click();
	    	Thread.sleep(1000);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(testData.get("PO_Number"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(Keys.ENTER);
	    	
	    	
	    	
	    	//PaymentMode
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(testData.get("PaymentMode"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(Keys.ENTER);
	    	
	    	//Amount
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(testData.get("Amount"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(Keys.ENTER);
	    	
	    	//Currency
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(testData.get("Currency"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(Keys.ENTER);
	    	
	    	
//	    	//CostCenter
//	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter());
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().click();
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().sendKeys(testData.get("CostCenter"));
//	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_CostCenter().sendKeys(Keys.ENTER);
//	    	
	    	
	    	//Description
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().sendKeys(testData.get("Description"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Description().sendKeys(Keys.ENTER);
	    	
	    }
	    
	    
	    @Then("^Search Advance against PO record in List$")
	    public void search_advance_against_po_record_in_list()   {
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.InboxSearchIcon());
	    	accountReceivable_AccountReceivableAdvancesObj.InboxSearchIcon().click();
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.EventCodeSearch());
	    	accountReceivable_AccountReceivableAdvancesObj.EventCodeSearch().sendKeys(testData.get("EventCode"));
	    	accountReceivable_AccountReceivableAdvancesObj.EventCodeSearch().sendKeys(Keys.ENTER);    
	    }

	    @Then("^store the Reference ID and open the Advance against PO record$")
	    public void store_the_reference_id_and_open_the_advance_against_po_record()   {
	    	waithelper.waitForElement(driver, 2000, accountReceivable_AccountReceivableAdvancesObj.FirstReferenceId());
			String Reference_Id=accountReceivable_AccountReceivableAdvancesObj.FirstReferenceId().getText();
			
			excelData.updateTestData("KUBS_AR/AP_UAT_002_004_TC_01_02_D2", "ReferenceID", Reference_Id);
			
			System.out.println("ReferenceID:" +Reference_Id);
			
			for (int i = 1; i <=199; i++) {
				try {
	    	waithelper.waitForElement(driver, 2000, accountReceivable_AccountReceivableAdvancesObj.ActionButton());
	    	accountReceivable_AccountReceivableAdvancesObj.ActionButton().click();
			 
	    	break;
				}
				catch(Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
				}  
	    }

	    @Then("^click submit and enter remark for Advance against PO$")
	    public void click_submit_and_enter_remark_for_advance_against_po()   {
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.SubmitButton());
	    	accountReceivable_AccountReceivableAdvancesObj.SubmitButton().click(); 
	    	
//	    	waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.accountPayable_VendorContracts_RemarkField());
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.RemarkField());
	    	accountReceivable_AccountReceivableAdvancesObj.RemarkField().click();
	    	accountReceivable_AccountReceivableAdvancesObj.RemarkField().sendKeys(testData.get("MakerAlertRemark"));
			
//	    	waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.accountPayable_VendorContracts_Submit());
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.Submit());
	    	accountReceivable_AccountReceivableAdvancesObj.Submit().click();
	    	
//	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 2000, accountReceivable_AccountReceivableAdvancesObj.RecordStatus());
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.RecordStatus());
	    	WebElement recordstatus = accountReceivable_AccountReceivableAdvancesObj.RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	
	    	String message = accountReceivable_AccountReceivableAdvancesObj.RecordStatus().getText();
	    	System.out.println(message);
	    	accountReceivable_AccountReceivableAdvancesObj.RecordStatus().click();
	    	String emptystring = "";
			String ar[] = message.split(" ");
			emptystring=ar[ar.length-1];
			String reviewerId=emptystring.replaceAll("[/.]", "");
			System.out.println(reviewerId);
//			jsonWriter=new JsonDataReaderWriter();
//			jsonWriter.addData(reviewerId);
			excelData.updateTestData("KUBS_AR/AP_UAT_002_004_TC_01_02_D2", "ReviewerID", reviewerId);   
		   
	    }
	    
	    @And("^user update the data set ID for Advance against PO Reviewer$")
	    public void user_update_the_data_set_id_for_advance_against_po_reviewer()   {
	    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_004_TC_01_02_D2");  
	    }
	    @And("^User login as a reviewer user Approve Advance against PO$")
	    public void user_login_as_a_reviewer_user_approve_advance_against_po()   {
	    	login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));   
	    }
	    
	    @And("^approve Advance against PO record by reviewer user$")
	    public void approve_advance_against_po_record_by_reviewer_user() throws InterruptedException   {
	    	browserHelper = new BrowserHelper(driver);
	    	String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
	    	Thread.sleep(1000);
	    	for (int i = 1; i < 35; i++) {
	    		
	    		try {
	    			waithelper.waitForElement(driver, 3000, driver.findElement(
	    					By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
	    			WebElement referanceID = driver.findElement(
	    					By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
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
	    			driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
	    	driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

	    	
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.Approve_Button());
	    	accountReceivable_AccountReceivableAdvancesObj.Approve_Button().click();
	    	
	    	for(int i=0; i<=20; i++) {
	    	try {
	    	
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.ApproveRemarkByReviewer());
	    	accountReceivable_AccountReceivableAdvancesObj.ApproveRemarkByReviewer().click();
//	    			
//	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.accountPayable_GRN_ApproveRemarkByReviewer());
	    	accountReceivable_AccountReceivableAdvancesObj.ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
	    			
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.Submit());
	    	accountReceivable_AccountReceivableAdvancesObj.Submit().click();
	    	break;
	    	}catch(Exception e) {}
	    	}
	    	waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.RecordStatus());
	    	WebElement recordstatus = accountReceivable_AccountReceivableAdvancesObj.RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	String message = accountReceivable_AccountReceivableAdvancesObj.RecordStatus().getText();
	    	System.out.println(message);
	    	accountReceivable_AccountReceivableAdvancesObj.RecordStatus().click();
	   
	       
	    }
	    @And("^Click on claim button in checker for Advance against PO$")
	    public void click_on_claim_button_in_checker_for_advance_against_po() throws InterruptedException  {
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	       
	    }


	    @Then("^checker should approved the Advance against PO record$")
	    public void checker_should_approved_the_advance_against_po_record() throws InterruptedException {
	    	Thread.sleep(2000);
	    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    		for (int i = 1; i <= 35; i++) {
	    			try {
//	    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
	    			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
	    			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
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
	    			 
//	    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
	    			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
	    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
	    			
	    		
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
	    		kubschecker.checkerApproveButton().click();
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
	    		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
	    		kubschecker.checkersubmitButton().click();
//	    		Thread.sleep(2000);
	    		
	    		waithelper.waitForElementwithFluentwait(driver, accountReceivable_AccountReceivableAdvancesObj.RecordStatus());
	        	WebElement recordstatus = accountReceivable_AccountReceivableAdvancesObj.RecordStatus();
	        	clicksAndActionHelper.moveToElement(recordstatus);
	        	String message = accountReceivable_AccountReceivableAdvancesObj.RecordStatus().getText();
	        	System.out.println(message);
	        	accountReceivable_AccountReceivableAdvancesObj.RecordStatus().click();
	    	      
	    }
	    @Then("^Get the Advance against PO Txn status by searching the record via business partner$")
	    public void get_the_advance_against_po_txn_status_by_searching_the_record_via_business_partner() throws Throwable {
	    	for (int i = 1; i <= 35; i++) {
				try {
			waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.Search_Icon());
			accountReceivable_AccountReceivableAdvancesObj.Search_Icon().click();
			break;}
			catch(Exception e) {}}
			waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.BusinessPartnerSearch());
			accountReceivable_AccountReceivableAdvancesObj.BusinessPartnerSearch().sendKeys(testData.get("EmployeeName"));
			
			waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.AdvanceToEmployee_Record_Status());
			System.out.println("Contract Status - " +accountReceivable_AccountReceivableAdvancesObj.AdvanceToEmployee_Record_Status().getText());
			
			waithelper.waitForElement(driver, 3000, accountReceivable_AccountReceivableAdvancesObj.TxnStatus());
			System.out.println("Txn Status - " +accountReceivable_AccountReceivableAdvancesObj.TxnStatus().getText());
	     
	    }
	    
	    //---------------------------------KUBS_AR/AP_UAT_002_004_TC_03_01_D3--------------------------------//
	    
	    @And("^user update the data set ID for Advance against PO with amount greater than PO amount$")
	    public void user_update_the_data_set_id_for_advance_against_po_with_amount_greater_than_po_amount()  {
			   testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_004_TC_03_01_D3");   
 
	    }

	    @Then("^Fill the form for Account Recivable with amount greater than PO amount$")
	    public void fill_the_form_for_account_recivable_with_amount_greater_than_po_amount() throws Throwable {
	    	
	    	//ReceivableName
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(testData.get("ReceivableName"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(Keys.ARROW_DOWN);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_ReceivableName().sendKeys(Keys.ENTER);
	    	
	    	//EmployeeName
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(testData.get("EmployeeName"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(Keys.ARROW_DOWN);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_EmployeeName().sendKeys(Keys.ENTER);
	    	
	    	
	    	
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().click();
	    	Thread.sleep(1000);
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(testData.get("PO_Number"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceviableAdvances_PONumber_TextBox().sendKeys(Keys.ENTER);
	    	
	    	
	    	
	    	//PaymentMode
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(testData.get("PaymentMode"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_PaymentMode().sendKeys(Keys.ENTER);
	    	
	    	//Currency
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(testData.get("Currency"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Currency().sendKeys(Keys.ENTER);
	    	
	    	
	    	//Amount
	    	waithelper.waitForElement(driver, 2000,accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount());
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().click();
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(testData.get("Amount"));
	    	accountReceivable_AccountReceivableAdvancesObj.accountReceivable_AccountReceivableAdvances_Amount().sendKeys(Keys.ENTER);
	    	
	    	String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
			//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
		    for(int i=0;i<=30;i++)
		    {
		    	try
		    	{
		    		WebElement successMsg1 = (WebElement) javascripthelper.executeScript(
							"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");

					String successmsg1 = successMsg1.getText();
					System.out.println(successmsg1);
		    	break;
		    	}
		    	catch(JavascriptException e)
		    	{
		    		
		    	}
		    	catch(NullPointerException e2)
		    	{
		    		
		    	}
		    	}
		    }
	    
	    }
	    
		

