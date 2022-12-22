package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_AutoPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ARAP_ConfigurationObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InvoiceBookingObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;

public class ACCOUNTSPAYABLE_AutoPayout extends BaseClass {
	WebDriver driver=BaseClass.driver;
	WaitHelper waitHelper=new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj=new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj=new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj=new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ARAP_GRNCreationPageObject grnObject=new ARAP_GRNCreationPageObject(driver);
	Map<String,String> autoPayout=new HashMap<>();
	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj=new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	JsonConfig jsonConfig =new JsonConfig();
	ACCOUNTSPAYABLE_PaymentSettlementTestDataType CreditNoteTestData=jsonConfig.getPayementSettlementTestDataByName("Maker");
	JavascriptHelper javascriptHelper =new JavascriptHelper();
    ACCOUNTSPAYABLE_AutoPayoutObj accoutsPayableAutoPayoutObj=new ACCOUNTSPAYABLE_AutoPayoutObj(driver);
    INVENTORY_EnquiryGlObject inventoryEnquiryGlObj=new INVENTORY_EnquiryGlObject(driver);
    ACCOUTSAPAYBLE_AutoPayoutTestDataType autoPayoutTestData= jsonConfig.getAccountsPayableAutoPayoutTestDataByName("Maker");
    BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
    ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
    KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
    KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
    ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
    
    ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","ARAP2TestData","Data Set ID");
	Map<String, String> arap;
    
    
    
           /********************   VENDOR CONTRACT ****************************/
    
    
    
	@And("^goto vendor contract module$")
    public void goto_vendor_contract_module() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractEyeIcon(), 2000, 100);
		vendorContractObj.vendorContractEyeIcon().click();
	}
    @Then("^fill all the mendatory fields for creating vendor$")
    public void fill_all_the_mendatory_fields_for_creating_vendor() throws Throwable {
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractExpenceType(), 2000, 100);
        vendorContractObj.vendorContractExpenceType().click();
        vendorContractObj.vendorContractExpenceType().sendKeys(arap.get("ContractType"));
        vendorContractObj.vendorContractExpenceType().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractBpName().click();
        vendorContractObj.vendorContractBpName().sendKeys(arap.get("BusinessPartnerName"));
        vendorContractObj.vendorContractBpName().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractContractName().click();
        vendorContractObj.vendorContractContractName().sendKeys(arap.get("ContractName"));
       
        vendorContractObj.vendorContractOtherDetails().click();
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractAutoGenerateInvoice(), 2000, 100);
        vendorContractObj.vendorContractAutoGenerateInvoice().click();
        vendorContractObj.vendorContractAutoGenerateInvoice().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractCreditPeriod().click();
        vendorContractObj.vendorContractCreditPeriod().sendKeys(arap.get("CreditPeriod"));
        
        vendorContractObj.vendorContractLatePaymentAmount().click();
        vendorContractObj.vendorContractLatePaymentAmount().sendKeys(arap.get("PaymentAmmount"));
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractSaveButton(), 2000, 100);
        vendorContractObj.vendorContractSaveButton().click();
         
    }
    @And("^add item details for the contract$")
    public void add_item_details_for_the_contract() throws Throwable {
    	waitHelper.waitForElementVisible(vendorContractObj.vendorContractTempView(), 2000, 100);
        vendorContractObj.vendorContractTempView().click();
        waitHelper.waitForElementVisible(vendorContractObj.firstTempRecord(),2000,100);
        vendorContractObj.firstTempRecord().click();
        
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractItemDetails(), 2000, 100);
        vendorContractObj.vendorContractItemDetails().click();
        
        for(int i=0; i<20; i++) {
        	try {
        		 waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
        	        vendorContractObj.vendorContractAddButton().click();
        	        break;
			} catch (Exception e) {
				
			}
        }
       
        
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractHSNCode(), 2000, 100);
        vendorContractObj.vendorContractHSNCode().click();
        vendorContractObj.vendorContractHSNCode().sendKeys(arap.get("HSNCode"));
        vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);
        
        Thread.sleep(2000);
        vendorContractObj.vendorContractExpenceCode().click();
        vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.DOWN);
        vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractCostCenter().click();
        vendorContractObj.vendorContractCostCenter().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractQuantity().click();
        vendorContractObj.vendorContractQuantity().sendKeys(arap.get("VendorContractQuantity"));
        
        vendorContractObj.vendorContractUnit().click();
        vendorContractObj.vendorContractUnit().sendKeys(Keys.ENTER);
        vendorContractObj.vendorContractRatePerUnit().click();
        vendorContractObj.vendorContractRatePerUnit().sendKeys(arap.get("RatePerUnit"));
        
        for(int i=0; i<20; i++) {
        	try {
        		vendorContractObj.itemDetailsSaveButton().click();
        		break;
			} catch (Exception e) {
				
			}
        }
        
        
    }

    @And("^add the payment term for the contract$")
    public void add_the_payment_term_for_the_contract() throws Throwable {
    	while(true)
    	{
    		try
    		{
    	 vendorContractObj.vendorContractPaymentTerm().click();
         waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
         vendorContractObj.vendorContractAddButton().click();
         waitHelper.waitForElementVisible(vendorContractObj.paymentTermPaymentTerm(), 2000, 100);
         vendorContractObj.paymentTermPaymentTerm().click();
         vendorContractObj.paymentTermPaymentTerm().sendKeys(arap.get("PaymentTerm"));
         vendorContractObj.paymentTermPaymentTermPercentage().click();
         vendorContractObj.paymentTermPaymentTermPercentage().sendKeys(arap.get("PaymentTermPercentage"));
         vendorContractObj.paymentTermPaymentTermType().click();
         vendorContractObj.paymentTermPaymentTermType().sendKeys(Keys.ENTER);
         vendorContractObj.paymentTermPaymentTermSaveButton().click();
         break;
    		}
    		catch(StaleElementReferenceException e)
    		{
    			
    		}
    	}
    }

    @And("^add the benificiory details and select auto payout as yes$")
    public void add_the_benificiory_details_and_select_auto_payout_as_yes() throws Throwable {
    	while(true)
    	{
    		try
    		{
    	waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetails(), 2000, 100);
    	 vendorContractObj.vendorContractBenificioryDetails().click();
    	 break;
    		}
    		catch(StaleElementReferenceException e)
    		{
    			
    		}
    	}//waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
         //vendorContractObj.vendorContractAddButton().click();
         waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetailsPaymentMode(), 2000, 100);
         vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(arap.get("PaymentMode"));
         vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(Keys.ENTER);
         
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().click();
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.DOWN);
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.ENTER);
         vendorContractObj.vendorContractBenificioryDetailsSaveButton().click();
    }
	@Then("^choose first record in the notification record in arap$")
	public void choose_first_record_in_the_notification_record_in_arap() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				1);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_AR/AP_UAT_003_001_TC_03_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_001_TC_03_D1");
		
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	@Then("^enter remark in confirmation alert in arap$")
	public void enter_remark_in_confirmation_alert_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				500);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());

				clickAndActions.clickUsingActionClass(budgetCreationObj.budgetCreation_AlertRemarks(),
						budgetCreationObj.budgetCreation_AlertRemarks());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(arap.get("remark"));

	}
	@Then("^click on submit button in alert in arap$")
	public void click_on_submit_button_in_alert_in_arap() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActions.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(arap.get("remark"));
					budgetCreationObj.budgetCreation_AlertsubmitButton().click();
					break;
				} catch (Exception e) {
					if (i == 50) {
						Assert.fail(e.getMessage());
					}
				}
			}
		}
	}
	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_arap()
			throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		excelData.updateTestData("KUBS_AR/AP_UAT_003_001_TC_03_D1","Reviewer ID",revID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_001_TC_03_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
	@And("^login with reviewer credentials1$")
	public void login_with_reviewer_credentials1() throws Throwable {
		KUBS_Login kubsLogin = new KUBS_Login(driver);

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, arap.get("Reviewer ID"));

	}
	
	
	
	@And("^select our record in notification records using reference ID in arap$")
	public void select_our_record_in_notification_records_using_reference_id_in_arap() throws Throwable {
		//KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
		/*
		 * After click on the notification icon lot of records will shown there, We have
		 * to select our record by the help of reference ID which is captured in maker
		 * stage
		 *
		 * before_xpath and after_xpath string variable are used to customize the xpath
		 * as per our reference ID
		 */
		// Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerNotidicationIcon(), 60,
						500);
				kubsReviewerObj.reviewerNotidicationIcon().click();
				waitHelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath)));
				javascriptHelper.JSEClick(driver
						.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath)));
				// driver.findElement(By.xpath(before_xpath +
				// jsonReaderWriter.readReferancedata() + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@And("^enter the remark in alert1$")
	public void enter_the_remark_in_alert1() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(arap.get("approvalCommentsFromReviewer"));
	}
	@Then("^click on submit in alert1$")
	public void click_on_submit_in_alert1() throws Throwable {
		while (true) {

			try {
				waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
				kubsReviewerObj.reviewerAlertSubmitButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				kubsReviewerObj.reviewerAlertRemarks().click();
				kubsReviewerObj.reviewerAlertRemarks()
						.sendKeys(arap.get("approvalCommentsFromReviewer"));
			}
		}
	}
	@And("^select our record and clime using reference ID in arap$")
	public void select_our_budget_record_and_clime_using_reference_id_in_arap() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 0; i <= 200; i++) {
			try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//				80, 500);
				WebElement climeButton = driver
						.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath_claim));

				boolean bool = climeButton.isDisplayed();
				clickAndActions.clickOnElement(climeButton);

				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@Then("^select our record in notification records by the help of reference ID in arap$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id_in_arap() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
//				waitHelper.waitForElementToVisibleWithFluentWait(driver,
//						driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)),
//						100, 500);
				clickAndActions.moveToElement(driver
						.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath)));
				clickAndActions.clickOnElement(driver
						.findElement(By.xpath(before_xpath +arap.get("Reference ID")+ after_xpath)));
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@Then("^give alert remark in arap$")
	public void give_alert_remark_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
				kubsCheckerObj.checkerRemarks().sendKeys(arap.get("approvalCommentsFromChecker"));
				break;
			} catch (Exception e) {
				if (i == 50) {
					if (i == 50) {
						Assert.fail(e.getMessage());
					}
				}
			}
		}
	}
	@Then("^click on submit button on alert in arap$")
	public void click_on_submit_button_on_alert_in_arap() throws Throwable {

		try {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
			kubsCheckerObj.checkersubmitButton().click();
		} catch (Exception e) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
			clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
			kubsCheckerObj.checkerRemarks().sendKeys(arap.get("approvalCommentsFromChecker"));
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
			kubsCheckerObj.checkersubmitButton().click();
		}

	}
	
	
	
	
	
	
	

    @And("^get the contract number$")
    public void get_the_contract_number() throws Throwable {
      waitHelper.waitForElementVisible(vendorContractObj.vendorContractApprovedContractNumber(), 2000, 100);
      String approvedContractNumber=vendorContractObj.vendorContractApprovedContractNumber().getText();
      autoPayout.put("approvedContractNumber", approvedContractNumber);
    }
 
    
    /********************   PO CREATION ****************************/
    
    @And("^goto po creation module$")
    public void goto_po_creation_module() throws Throwable {
        waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton(), 2000, 100);
        poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();
    }
    
    @And("^fill the mendatory fields for po creation$")
    public void fill_the_mendatory_fields_for_po_creation() throws Throwable {
       waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_BPName(), 2000, 100);
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(arap.get("BusinessPartnerName"));
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.DOWN);
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
       
       poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
       
       poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(arap.get("ContractName"));
       poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);
       
      /* 
       poCreationObj.accountsPayable_VendorPurchaseOrder_POType().click()3
       poCreationObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys("Purchace Contract3");
       Thread.sleep(1000);
       poCreationObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(Keys.ENTER);
       */
     //div[contains(text(),'Agency-8-41-28022022')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox   
       Thread.sleep(1000);
    waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedContractNumber")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox")), 2000, 100);
    driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedContractNumber")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox")).click();
    driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedContractNumber")+"')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input")).click();
    driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedContractNumber")+"')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input")).sendKeys("1");
    while(true)
    {
    try
    {
    //Thread.sleep(1000);
    waitHelper.waitForElementVisible(poCreationObj.vendorContractPoItemSave(), 2000,100);
    poCreationObj.pocontractPoQuantity().click();
    poCreationObj.vendorContractPoItemSave().click();
    break;
    }
    catch(ElementClickInterceptedException e)
    {
    	
    }
    }
    
    waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType(), 2000, 100);
    poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().click();
    //poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.DOWN);
    poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.ENTER);
    //waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter(), 2000, 100);
    while(true)
    {
    	try
    	{
    poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().click();
    poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().sendKeys(Keys.ENTER);
    	break;
    	}
    	catch(NoSuchElementException e)
    	{
    		
    	}
    	}
    
    poCreationObj.accountsPayable_VendorPurchaseOrder_Save().click();
    }
    
    @And("^save the po creation record$")
    public void save_the_po_creation_record() throws Throwable {
    	poCreationObj.poCreationTempView().click();
    	waitHelper.waitForElementVisible(poCreationObj.tempViewFirstRecord(), 2000, 100);
    	poCreationObj.tempViewFirstRecord().click();
    }
    @And("^save the item details for pocreation$")
    public void save_the_item_details_for_pocreation() throws Throwable {
    	poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetails().click();
    	waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord(), 2000, 100);
    	poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord().click();
    	waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation(), 2000, 100);
    	poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
    	poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(Keys.ENTER);
    	poCreationObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
    	poCreationObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(Keys.ENTER);
    	while(true)
    	{
    	try
    	{
    	poCreationObj.accountsPayable_VendorPurchaseOrder_PoItemSave().click();
    	break;
    	}
    	catch(NoSuchElementException e)
    	{
    		
    	}
    	}
    	waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
    	poCreationObj.checkerAlertClose().click();
    	}
    JavascriptHelper javascriphelper = new JavascriptHelper();
    Selenium_Actions seleniumactions = new Selenium_Actions(driver);
    
    @And("^search PO status as Active1$")
	public void search_PO_status_as_Active() throws Throwable {
    	//JavascriptHelper javascriphelper = new JavascriptHelper();
		//seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getPostatus());
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(cancellationofcontract.getSearchVendorPoStatus());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchVendorPoStatus());
		cancellationofcontract.getSearchVendorPoStatus()
				.sendKeys(arap.get("contractstatusactive"));
	}
    
    @And("^click the eye icon in list based on contractname in arap$")
    public void click_the_eye_icon_in_list_based_on_contractname_in_arap() throws Throwable {
    	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
		//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/span[1]
		String contractName = null;
		String beforexpath="//datatable-row-wrapper[";
    	String afterxpath ="]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/span[1]";
    	for (int j = 1; j <44; j++) {
    		for (int i = 1; i < 9; i++) {
        		// select active bill with expense as contract type
        		seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(beforexpath+i+afterxpath)));
        		contractName = driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
    			System.out.println(contractName);
    			if (contractName.equalsIgnoreCase(arap.get("ContractName"))) {
    				//seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])["+i+"]")));
    				driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])["+i+"]")).click();
    				break;
    			}		
    			
		}
    		if (contractName.equalsIgnoreCase(arap.get("ContractName"))) {
				break;
			}
    		seleniumactions.getWaitHelper().waitForElement(driver,2000,invoiceBookingObj.nextPageInListView());
			invoiceBookingObj.nextPageInListView().click();
    		
    	
		}
    }
    Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	@And("^select bp name according to bp we get in contract$")
	public void select_bp_name_according_to_bp_we_get_in_contratc() throws Throwable {
		
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentBpName());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentBpName());
		arapAdjustment.adjustmentBpName().sendKeys(arap.get("buisnessPartnerNameinCancelledContract"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
	}
	
	@And("^select adjustment item type as contract in arap$")
	public void select_adjustment_item_type_as_contract_in_arap() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentItemType());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentItemType());
		arapAdjustment.adjustmentItemType().sendKeys(arap.get("Cancellationtype"));
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
	}
	
	@And("^select adjustment reference as we get in contract account code in arap$")
	public void select_adjustment_reference_as_we_get_in_contract_account_code_in_arap() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapAdjustment.adjustmentAdjustmentReference());
		seleniumactions.getClickAndActionsHelper().clickOnElement(arapAdjustment.adjustmentAdjustmentReference());
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(arap.get("contractacccountcode"));
	}
	@And("^login with reviewer credential$")
	public void login_with_reviewer_credentials() throws Throwable {
		
		KUBS_Login kubsLogin = new KUBS_Login(driver);

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, arap.get("Reviewer ID"));

	}



    @And("^save the benificiery details for po creation$")
    public void save_the_benificiery_details_for_po_creation() throws Throwable {
    	
    	
        
    }
    /*
    @And("^fill the mendatory field for GRN$")
    public void fill_the_mendatory_field_for_grn() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 2000, 100);
    	grnObject.accountPayable_GrnBpName().click();
    	grnObject.accountPayable_GrnBpName().sendKeys(autoPayoutTestData.BusinessPartnerName);
    	grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
    	
    	grnObject.accountPayable_GRN_BPBranch().click();
    	grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
    	
    	grnObject.accountPayable_GrnInvoiceNumber().click();
    	grnObject.accountPayable_GrnInvoiceNumber().sendKeys("452103745");
    	grnObject.accountPayable_GrnDeliveryLocation().click();
    	grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
    	
    	
    	
    }*/

    /********************   GRN ****************************/    
    @And("^save the GRN record$")
    public void save_the_grn_record() throws Throwable {
    	clickAndActionHelper.doubleClick(grnObject.accountPayable_GrnSaveButton());
    	grnObject.grnTempView().click();
    	waitHelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 2000, 100);
    	grnObject.grnTempViewFirstRecord().click();
    }
    @And("^go to invoice bill booking module$")
    public void go_to_invoice_bill_booking_module() throws Throwable {
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
    }
 /*   @And("^add item details for grn$")
    public void add_item_details_for_grn() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.inventoryManagament_GRNItemDetails(), 2000, 100);
    	grnObject.inventoryManagament_GRNItemDetails().click();
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 2000, 100);
    	grnObject.accountPayable_GrnPONumber().click();
    	grnObject.accountPayable_GrnPONumber().sendKeys("");
    	for(int row=1;row<5;row++)
    	{
    		//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]/input[1]
    		
    		for(int col=7;col<=8;col++)
    		{
    			try
        		{
    				//waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")), 5000, 100);
    				boolean status=driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")).isDisplayed();
    				driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")).click();
    				driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")).sendKeys("1");
    				if(status==false)
    				{
    					break;
    				}
    			}
    			catch(NoSuchElementException e)
        		{
        			e.getMessage();
        		    break;
        		}
    			
    		}
    	}
    }*/

    @And("^save and submit the record$")
    public void save_and_submit_the_record() throws Throwable {
     //   throw new PendingException();
    }
    /******************** ARAp config *****************************/
    ARAP_ConfigurationObj arapConfigObj = new ARAP_ConfigurationObj(driver);
    @And("^click on view button near by arap configuration$")
    public void click_on_view_button_near_by_arap_configuration() throws Throwable {
    	arapConfigObj.ARAPConfigurationViewButton().click();
    }

    @And("^select the arap configuration record$")
    public void select_the_arap_configuration_record() throws Throwable {
    	arapConfigObj.arapARAPRecord().click();
    }

    @And("^give auto payout as yes$")
    public void give_auto_payout_as_yes() throws Throwable {
    	arapConfigObj.arapAutoPayoutInput().click();
    	arapConfigObj.arapAutoPayoutInput().sendKeys("Yes");
    	arapConfigObj.arapAutoPayoutInput().sendKeys(Keys.ENTER);
    }

    @And("^save the configuration record$")
    public void save_the_configuration_record() throws Throwable {
    	arapConfigObj.arapConfigurationSaveButton().click();
    }
    /********************   INVOICE BILL BOOKING  ****************************/    
    @And("^fill the invoice booking record$")
    public void fill_the_invoice_booking_record() throws Throwable {
    	Random ran = new Random();
    	int random = ran.nextInt(1000-500)+500;
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.DOWN);
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);
	     
	     /*
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.DOWN);
	     invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(Keys.ENTER);
	     */
	     invoiceBookingObj.billBookingPoBpName().click();
	     invoiceBookingObj.billBookingPoBpName().sendKeys(autoPayoutTestData.BusinessPartnerName);
	     invoiceBookingObj.billBookingPoBpName().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.invoiceBollSuplierNAme().click();
	     invoiceBookingObj.invoiceBollSuplierNAme().sendKeys(autoPayoutTestData.SuplierReferenceNumber+random);
	     
	     invoiceBookingObj.billBookingPoFlatDiscount().click();
	     invoiceBookingObj.billBookingPoFlatDiscount().sendKeys(autoPayoutTestData.FlatDiscount);
	     /*
	     invoiceBookingObj.billBookingExpenceDiscountType().click();
	     invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.billBookingExpenceDiscountPercent().click();
	     invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys("2");
	     
	     */
	     invoiceBookingObj.billBookingPoPaymentMode().click();
	     invoiceBookingObj.billBookingPoPaymentMode().sendKeys(autoPayoutTestData.PaymentMode);
	     invoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
    }
    @And("^get the approved po number from approved record$")
    public void get_the_approved_po_number_from_approved_record() throws Throwable {
    	waitHelper.waitForElementVisible(poCreationObj.poCreationApprovedPoNumber(), 2000, 100);
    	String poNumber=poCreationObj.poCreationApprovedPoNumber().getText();
    	autoPayout.put("poNumber",poNumber);
    }
    
    @And("^fill The invoice againse po record$")
    public void fill_the_invoice_againse_po_record() throws Throwable {
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	while(true)
    	{
    	try
    	{
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(autoPayout.get("poNumber"));
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
    	{
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
    	waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSelectGRNRecord(), 2000, 100);
    	invoiceBookingObj.invoiceBookingSelectGRNRecord().click();
    	waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBooingOkButton(), 2000, 100);
    	invoiceBookingObj.invoiceBooingOkButton().click();
    	break;
    	}
    	}
    	catch(StaleElementReferenceException e)
    	{
    		
    	}
    	}
    	invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
    	waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
    	poCreationObj.checkerAlertClose().click();
    	}
    	
    
    @And("^get the approved invoice from table$")
    public void get_the_approved_invoice_from_table() throws Throwable {
    	waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(), 2000, 100);
    	String approvedInvoiceNumber=invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
    	autoPayout.put("approvedInvoiceNumber", approvedInvoiceNumber);
    }
    /********************  PAYMENT SETTLEMENT ****************************/
    
    @And("^fill the mendatory field for settle the payment$")
    public void fill_the_mendatory_field_for_settle_the_payment() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(CreditNoteTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(CreditNoteTestData.BusinessPartnerName);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//div[contains(text(),'ADV_36_2422022')]
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(1000);
		if(i==20)
		{
			System.out.println("Data not available");
			System.out.println("Approved record we search "+autoPayout.get("approvedInvoiceNumber"));
			Assert.fail("Data not available");
		}
		try
		{
			
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")), 2000, 100);
		javascriptHelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")));
		boolean finalStatus=driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")).isDisplayed();
		Assert.assertTrue(finalStatus);
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")), 5000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")).click();
		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
			paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
		}
     
    }
    }
    @Then("^verify the invoice number is not availabe in the list view$")
    public void verify_the_invoice_number_is_not_availabe_in_the_list_view() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(CreditNoteTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(CreditNoteTestData.BusinessPartnerName);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//div[contains(text(),'ADV_36_2422022')]
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(1000);
		if(i==20)
		{
			System.out.println("Data not available");
			System.out.println("Approved record we search "+autoPayout.get("approvedInvoiceNumber"));
			Assert.fail("Data not available");
		}
		try
		{
			
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")), 2000, 100);
		javascriptHelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")));
		boolean finalStatus=driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")).isDisplayed();
		Assert.assertTrue(finalStatus);
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")), 5000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")).click();
		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
			paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
		}
     
    }
    }
    @And("^validate the invoice number is not available for payment settlement$")
    public void validate_the_invoice_number_is_not_available_for_payment_settlement() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(CreditNoteTestData.PaymentOption);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(CreditNoteTestData.BusinessPartnerName);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//div[contains(text(),'ADV_36_2422022')]
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(1000);
		if(i==20)
		{
			System.out.println("Data not available");
			System.out.println("Approved record we search "+autoPayout.get("approvedInvoiceNumber"));
			Assert.fail("Data not available");
		}
		try
		{
			
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")), 2000, 100);
		javascriptHelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")));
		boolean finalStatus=driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")).isDisplayed();
		Assert.assertTrue(finalStatus);
		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")), 5000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")).click();
		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
			paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
		}
     
    }
    }
    
    /********************   AUTO PAYOUT ****************************/    

    @And("^go to auto payout module$")
    public void go_to_auto_payout_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accounPayablePayoutTempView());
    	accoutsPayableAutoPayoutObj.accounPayablePayoutTempView().click();
    	
    }
    @And("^select the record from temp view$")
    public void select_the_record_from_temp_view() throws Throwable {
      waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord(), 2000, 100);
      accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord().click();
      
    }

    @And("^fill the valued date$")
    public void fill_the_valued_date() throws Throwable {
    	waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accounPayablePayoutPayoutDate(), 2000, 100);
    	accoutsPayableAutoPayoutObj.accounPayablePayoutPayoutDate().click();
    	while(true)
        {
		try
		{
		
			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+CreditNoteTestData.MonthYear+"')]")));
			driver.findElement(By.xpath("//span[contains(text(),'"+CreditNoteTestData.MonthYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			try
			{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
			catch(ElementClickInterceptedException e)
			{
				
			}
			}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+CreditNoteTestData.FullMonth+" "+CreditNoteTestData.Day+", "+CreditNoteTestData.Year+"']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
    	
        
    }
    @Then("^save the auto payout record$")
    public void save_the_auto_payout_record() throws Throwable {
    	String invoiceNumber=autoPayout.get("approvedInvoiceNumber");
    	javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//span[contains(text(),'"+invoiceNumber+"')]")));
    	//waitHelper.waitForElementVisible(driver.findElement(By.xpath("//span[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")), 2000, 100);
    	boolean result=driver.findElement(By.xpath("//span[contains(text(),'"+invoiceNumber+"')]")).isDisplayed();
    	Assert.assertTrue(result);
    	//driver.findElement(By.xpath("//span[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]"));
    	waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymentSaveButton(), 2000, 100);
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentSaveButton().click();
    	Thread.sleep(1000);
        
    }
    @And("^fill the mendatory fields for auto payout record$")
    public void fill_the_mendatory_fields_for_auto_payout_record() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().click();
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().sendKeys(Keys.DOWN);
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().sendKeys(Keys.ENTER);
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().click();
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().sendKeys(Keys.DOWN);
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().sendKeys(Keys.ENTER);
    	javascriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks());
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks().click();
    	accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks().sendKeys(autoPayoutTestData.Remark);
    }

    @And("^select the record from temp view and initiate$")
    public void select_the_record_from_temp_view_and_initiate() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accounPayablePayoutTempView());
    	accoutsPayableAutoPayoutObj.accounPayablePayoutTempView().click();
    	waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord(), 2000, 100);
        accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord().click();
        
        waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymentInitiateButtonButton(), 2000, 100);
        accoutsPayableAutoPayoutObj.accoutspYablePaymentInitiateButtonButton().click();
        waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
        poCreationObj.checkerAlertClose().click();
    }
    @And("^User get the test data for the po contract cancellation test case00300103$")
    public void user_get_the_test_data_for_the_po_contract_cancellation_test_case00300103() throws Throwable {
        arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_001_TC_03_D1");
    }
}
