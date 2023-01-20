package stepdefinitions;



import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.Account_Receivable;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ARAP_GRNCreationTestDataType;

public class ACCOUNTSPAYABLE_GRNCreation extends BaseClass {
	WebDriver driver=BaseClass.driver;
	ARAP_GRNCreationPageObject grnObject=new ARAP_GRNCreationPageObject(driver);
	ARAP_PoCreationObj poCreationObj=new ARAP_PoCreationObj(driver);
	KUBS_MakerObj makerObj=new 	KUBS_MakerObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	String poNumber;
	String poBusinessPartner;
	JsonConfig jsonConfig=new JsonConfig();
	ClicksAndActionsHelper clickAndActions =new ClicksAndActionsHelper(driver);
	INVENTORY_EnquiryGlObject glObj=new INVENTORY_EnquiryGlObject(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	ARAP_GRNCreationTestDataType grnTestData=jsonConfig.getARAPGRNTestDataByName("Maker");
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	ARAP_AdjustmentsObj arapAdjustment =new ARAP_AdjustmentsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj=new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_PaymentSettlementTestDataType CreditNoteTestData=jsonConfig.getPayementSettlementTestDataByName("Maker");
	Map<String,String> settlementTestData=new HashMap<>();
	Map<String,String> testData=new HashMap<>();
	//INVENTORY_EnquiryGlObject enquiryAccountingObj=new INVENTORY_EnquiryGlObject(driver);
	   ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","ARAP2TestData","Data Set ID");
		Map<String, String> arap;
    @And("^click on accounts Payable module$")
    public void click_on_accounts_payable_module() throws Throwable {
    	Thread.sleep(1000);
    	makerObj.kubsDirectionIcon().click();
    	waitHelper.waitForElementVisible(makerObj.kubsAccountsPayable(), 1000, 100);
    	makerObj.kubsAccountsPayable().click();
    }
    @Then("^click on po creation module$")
    public void click_on_po_creation_module() throws Throwable {
    	//grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton().click();
    	poCreationObj.poCreationViewButton().click();
    
    }

    @Then("^go to GRN module$")
    public void go_to_grn_module() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton(), 1000, 100);
    	grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton().click();

    }

    @And("^search for cancelled po$")
    public void search_for_cancelled_po() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	poCreationObj.poCreationSearchIcon().click();
    	Thread.sleep(1000);
    	//waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
    	javascriptHelper.scrollIntoView(poCreationObj.poStatus());
    	poCreationObj.poStatus().click();
    	poCreationObj.poStatus().sendKeys(grnTestData.poStatus);
        poNumber=poCreationObj.poPoNumber().getText();
       poBusinessPartner= poCreationObj.poBusinessPartner().getText();
       System.out.println(poNumber+" "+poBusinessPartner+" ");
       

    }

    @And("^check GRN can be created for that perticular po$")
    public void check_grn_can_be_created_for_that_perticular_po() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 1000, 100);
    	System.out.println("Business Partner is"+poBusinessPartner);
    	grnObject.accountPayable_GrnBpName().click();
    	grnObject.accountPayable_GrnBpName().sendKeys(poBusinessPartner);
    	//grnObject.accountPayable_GRN_BPBranch().click();
	grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
	waitHelper.waitForElementVisible(grnObject.accountPayable_GRN_BPBranch(), 2000, 100);
	grnObject.accountPayable_GRN_BPBranch().click();
    	grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
    	grnObject.accountPayable_GrnInvoiceNumber().sendKeys(grnTestData.InvoiceNo);
    	grnObject.accountPayable_GrnDeliveryLocation().click();
    	//grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.DOWN);
    	grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
    	//waitHelper.waitForElementVisible(grnObject.accountPayable_GrnSaveButton(), 1000, 100);
    	Thread.sleep(2000);
    	//grnObject.accountPayable_GrnSaveButton().click();
    	clickAndActions.doubleClick(grnObject.accountPayable_GrnSaveButton());
    	grnObject.grnTempView().click();
    	waitHelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 1000,100);
    	grnObject.grnTempViewFirstRecord().click();
    	
    	
     
    }
    @And("^check GRN can be created for that perticular po in arap$")
    public void check_grn_can_be_created_for_that_perticular_po_in_arap() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 1000, 100);
    	System.out.println("Business Partner is"+poBusinessPartner);
    	grnObject.accountPayable_GrnBpName().click();
    	grnObject.accountPayable_GrnBpName().sendKeys(poBusinessPartner);
    	//grnObject.accountPayable_GRN_BPBranch().click();
	grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
	waitHelper.waitForElementVisible(grnObject.accountPayable_GRN_BPBranch(), 2000, 100);
	grnObject.accountPayable_GRN_BPBranch().click();
    	grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
    	grnObject.accountPayable_GrnInvoiceNumber().sendKeys(arap.get("InvoiceNo"));
    	grnObject.accountPayable_GrnDeliveryLocation().click();
    	//grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.DOWN);
    	grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
    	//waitHelper.waitForElementVisible(grnObject.accountPayable_GrnSaveButton(), 1000, 100);
    	Thread.sleep(2000);
    	//grnObject.accountPayable_GrnSaveButton().click();
    	for(int i=0; i<20; i++) {
    		try {
    			clickAndActions.doubleClick(grnObject.accountPayable_GrnSaveButton());
    	    	grnObject.grnTempView().click();
    	    	//waitHelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 1000,100);
    	    	grnObject.grnTempViewFirstRecord().click();
    	    	break;
			} catch (Exception e) {
				if(i==20) {
					Assert.fail(e.getMessage());
				}
				
			}
    	}
    	
    	
    	
     
    }
    @Then("^go to Item details and enter po number$")
    public void go_to_item_details_and_enter_po_number() throws Throwable {
    	Thread.sleep(1000);
    	waitHelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
    	grnObject.inventoryManagament_GRNItemDetails().click();
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
    	grnObject.accountPayable_GrnPONumber().click();
    	grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
    	boolean result=grnObject.poNoSuctDataFromDropdown().isDisplayed();
    	Assert.assertTrue(result);
    }
    @Then("^go to Item details and enter po number for approval$")
    public void go_to_item_details_and_enter_po_number_for_approval() throws Throwable {
    	waitHelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
    	grnObject.inventoryManagament_GRNItemDetails().click();
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
    	grnObject.accountPayable_GrnPONumber().click();
    	grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
    	grnObject.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    	
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
    				driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")).sendKeys(grnTestData.ItemQuantity);
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
    	//javascriptHelper.JavaScriptHelper(driver);
    	//Thread.sleep(1000);
    	//grnObject.ItemDetailsSaveButton().click();
    	//clickAndActions.doubleClick(grnObject.ItemDetailsSaveButton());
    	clickAndActions.clickOnElement(grnObject.ItemDetailsSaveButton());
    	//Thread.sleep(2000);
    	
    	
			
    }
    @Then("^go to Item details and enter po number for approval in arap$")
    public void go_to_item_details_and_enter_po_number_for_approval_in_arap() throws Throwable {
    	waitHelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
    	grnObject.inventoryManagament_GRNItemDetails().click();
    	waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
    	grnObject.accountPayable_GrnPONumber().click();
    	grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
    	grnObject.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    	
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
    				driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")).sendKeys(arap.get("ItemQuantity"));
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
    	//javascriptHelper.JavaScriptHelper(driver);
    	//Thread.sleep(1000);
    	//grnObject.ItemDetailsSaveButton().click();
    	//clickAndActions.doubleClick(grnObject.ItemDetailsSaveButton());
    	clickAndActions.clickOnElement(grnObject.ItemDetailsSaveButton());
    	//Thread.sleep(2000);
    	
    	
			
    }
    @Then("^choose first record in the notification record in GRN stage$")
    public void choose_first_record_in_the_notification_record_in_grn_stage() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, grnObject.grnFirstReferenceId());
		String referenceID = grnObject.grnFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		clickAndActions.moveToElement(grnObject.grnFirstRecord());
		clickAndActions.clickOnElement(grnObject.grnFirstRecord());
		//.click();
    }
    @Then("^choose first record in the notification record in GRN stage in arap$")
    public void choose_first_record_in_the_notification_record_in_grn_stage_in_arap() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, grnObject.grnFirstReferenceId());
		String referenceID = grnObject.grnFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_03_01_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_03_01_D1");
		
		clickAndActions.moveToElement(grnObject.grnFirstRecord());
		clickAndActions.clickOnElement(grnObject.grnFirstRecord());
		//.click();
    }
    @Then("^choose first record in the notification record in GRN stage in arap0401$")
    public void choose_first_record_in_the_notification_record_in_grn_stage_in_arap0401() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, grnObject.grnFirstReferenceId());
		String referenceID = grnObject.grnFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1");
		
		clickAndActions.moveToElement(grnObject.grnFirstRecord());
		clickAndActions.clickOnElement(grnObject.grnFirstRecord());
		//.click();
    }
    @And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0501$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_arap0501()
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1","Reviewer ID",revID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

    KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
    @And("^select our record in notification records using reference ID in arap0402$")
	public void select_our_record_in_notification_records_using_reference_id_in_arap0402() throws Throwable {
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

    @Then("^click on the submit button which is appeared in alert box in arap$")
	public void click_on_the_submit_button_which_is_appeared_in_alert_box_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
				// clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
				// invoiceBookingObj.AlertRemark().click();
				Thread.sleep(1000);
				invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker()
						.sendKeys(arap.get("Remark"));
				break;
			} catch (ElementNotInteractableException e) {

			}
		}

		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(), 2000, 100);

		invoiceBookingObj.alertSubmitButton().click();

	}
    @And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0601$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_arap0601()
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1","Reviewer ID",revID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
	@Then("^click on submit button in alert in arap0602$")
	public void click_on_submit_button_in_alert_in_arap0602() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActions.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(arap.get("approvalCommentsFromReviewer"));
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
	@Then("^click on submit button in alert in arap0603$")
	public void click_on_submit_button_in_alert_in_arap0603() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActions.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(arap.get("approvalCommentsFromChecker"));
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

    @Then("^click on the submit button which is appeared in alert box in arap0503$")
  	public void click_on_the_submit_button_which_is_appeared_in_alert_box_in_arap0503() throws Throwable {
  		javascriptHelper.JavaScriptHelper(driver);
  		Thread.sleep(1000);
  		while (true) {
  			try {
  				javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
  				// clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
  				// invoiceBookingObj.AlertRemark().click();
  				Thread.sleep(1000);
  				invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker()
  						.sendKeys(arap.get("approvalCommentsFromChecker"));
  				break;
  			} catch (ElementNotInteractableException e) {

  			}
  		}

  		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(), 2000, 100);

  		invoiceBookingObj.alertSubmitButton().click();

  	}
    @Then("^click on the submit button which is appeared in alert box in arap0502$")
  	public void click_on_the_submit_button_which_is_appeared_in_alert_box_in_arap0502() throws Throwable {
  		javascriptHelper.JavaScriptHelper(driver);
  		Thread.sleep(1000);
  		while (true) {
  			try {
  				javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
  				// clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
  				// invoiceBookingObj.AlertRemark().click();
  				Thread.sleep(1000);
  				invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker()
  						.sendKeys(arap.get("approvalCommentsFromReviewer"));
  				break;
  			} catch (ElementNotInteractableException e) {

  			}
  		}

  		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(), 2000, 100);

  		invoiceBookingObj.alertSubmitButton().click();

  	}
    ACCOUNTRECEIVABLE_CreditNoteObj crediteNoteObj = new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
    ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
    INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
    
    @And("^fill the calender details and description in arap$")
	public void fill_the_calender_details_and_save_the_record_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementValueDate());
		paymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
		while (true) {
			try {

				//waitHelper.waitForElement(driver, 3000, driver.findElement(
						//By.xpath("//span[contains(text(),'" + arap.get("MonthYear") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + arap.get("MonthYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + arap.get("FullMonth")
				+ " " + arap.get("Day") + ", " + arap.get("Year") + "']/span"));
		ClicksAndActionsHelper clicksAndActions = new ClicksAndActionsHelper(driver);
		clicksAndActions.doubleClick(FinalDay);
		clicksAndActions.doubleClick(paymentSettlementObj.accountsPayableDescription());
		paymentSettlementObj.accountsPayableDescription().sendKeys(arap.get("Remark"));

	}
    
    @And("^fill the mendatory field for settle the payment in arap0601$")
    public void fill_the_mendatory_field_for_settle_the_payment_in_arap0601() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(arap.get("PaymentOption"));
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(arap.get("BusinessPartnerName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//div[contains(text(),'ADV_36_2422022')]
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(1000);
		if(i==20)
		{
			System.out.println("Data not available");
			System.out.println("Approved record we search "+arap.get("approvedInvoiceNumber"));
			Assert.fail("Data not available");
		}
		try
		{
			
		//waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+arap.get("approvedInvoiceNumber")+"')]")), 2000, 100);
		javascriptHelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'"+arap.get("approvedInvoiceNumber")+"')]")));
		boolean finalStatus=driver.findElement(By.xpath("//div[contains(text(),'"+arap.get("approvedInvoiceNumber")+"')]")).isDisplayed();
		Assert.assertTrue(finalStatus);
		//waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+arap.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")), 5000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'"+arap.get("approvedInvoiceNumber")+"')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")).click();
		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
			paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
		}
     
    }
    }
    KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
    @And("^select our record and clime using reference ID in arap0403$")
	public void select_our_budget_record_and_clime_using_reference_id_in_arap0403() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		javascriptHelper.JavaScriptHelper(driver);
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
    @Then("^select our record in notification records by the help of reference ID in arap0403$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id_in_arap0403() throws Throwable {
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
    @And("^get the approved invoice from table0601$")
    public void get_the_approved_invoice_from_table0601() throws Throwable {
    	waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(), 2000, 100);
    	String approvedInvoiceNumber=invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
    	excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1","approvedInvoiceNumber",approvedInvoiceNumber);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1");
    	
    	//autoPayout.put("approvedInvoiceNumber", approvedInvoiceNumber);
    }
	@Then("^choose first record in the notification record in arap0601$")
	public void choose_first_record_in_the_notification_record_in_arap0601() throws Throwable {
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_06_01_D1");
		
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
	@And("^select the approved record from invoice bill booking0501$")
	public void select_the_approved_record_from_invoice_bill_booking0501() throws Throwable {
		// waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(),
		// 2000, 100);
		Thread.sleep(1000);
		String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		String approvedBpName = invoiceBookingObj.billBookingApprovedBpName().getText();
		
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1","approvedInvoiceNumber",approvedInvoiceNumber);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1");
		
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1","approvedBpName",approvedBpName);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1");
		
		//invoiceBookingTestData.put("approvedInvoiceNumber", approvedInvoiceNumber);
		//invoiceBookingTestData.put("approvedBpName", approvedBpName);

	}
	  BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	@Then("^choose first record in the notification record in arap0501$")
	public void choose_first_record_in_the_notification_record_in_arap0501() throws Throwable {
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_05_01_D1");
		
		budgetCreationObj.budgetCreationFirstRecord().click();

	}




    @And("^Fill the form for credit note in arap$")
	public void fill_the_form_for_credit_note_in_arap() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivableReceivableName(), 2000, 100);
		crediteNoteObj.accountsReceivableReceivableName().click();
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableReceivableName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableBpName().click();
		crediteNoteObj.accountsReceivableBpName().sendKeys(arap.get("approvedBpName"));
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableBpName().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableInvoiceNumber().click();// approvedInvoiceNumber
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(arap.get("approvedInvoiceNumber"));
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.DOWN);
		crediteNoteObj.accountsReceivableInvoiceNumber().sendKeys(Keys.ENTER);
		crediteNoteObj.accountsReceivableCreditAmmount().click();
		crediteNoteObj.accountsReceivableCreditAmmount().sendKeys(arap.get("CreditAmount"));
		String creditAmmount = arap.get("CreditAmount");
		String finalCreditValue = creditAmmount.substring(0, creditAmmount.length() - 2);
		arap.put("finalCreditValue", finalCreditValue);
		Thread.sleep(1000);

		crediteNoteObj.accountsReceivableDescription().click();
		crediteNoteObj.accountsReceivableDescription().sendKeys(arap.get("Remark"));
		waitHelper.waitForElementVisible(crediteNoteObj.accountsReceivablleSaveButton(), 2000, 100);
		ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
		clickAndActionHelper.doubleClick(crediteNoteObj.accountsReceivablleSaveButton());
		//crediteNoteObj.accountsReceivablleSaveButton().click();

	}
    
    Selenium_Actions seleniumactions = new Selenium_Actions(driver);
    Account_Receivable account_Receivable = new Account_Receivable(driver);
    
    @And("^search the Active credit note and click the first list in arap$")
    public void search_the_active_credit_note_and_click_the_first_list_in_arap() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_Status());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_Status());
		account_Receivable.accountsReceivable_CreditNote_Status().sendKeys(arap.get("contractstatusactive"));
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				account_Receivable.accountsReceivable_CreditNote_StatusHead());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(account_Receivable.accountsReceivable_CreditNote_StatusHead());
    }
    
    ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
    
    @Then("^Give The Business Partner according to creditnote in arap$")
    public void give_the_business_partner_according_to_creditnote_in_arap() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapObj.adjustmentBpName());
		arapObj.adjustmentBpName().click();
		arapObj.adjustmentBpName().sendKeys(arap.get("buisnessPartnerName"));
		arapObj.adjustmentBpName().sendKeys(Keys.ENTER);
    }
    @Then("^Give the credit note number in Adjustment Item Type in arap$")
    public void give_the_credit_note_number_in_adjustment_item_type_in_arap() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(arap.get("creditnotenumber"));
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);
    }
    JavascriptHelper javascriphelper = new JavascriptHelper();
    @And("^get buisness partner name , get credit note number and get credit note date in arap$")
    public void get_buisness_partner_name_get_credit_note_number_and_get_credit_note_date_in_arap() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 4000,
				account_Receivable.creditNote_Buisness_Partner());
		String buisnessPartnerName = account_Receivable.creditNote_Buisness_Partner()
				.getText();
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_06_04_D1","buisnessPartnerName",buisnessPartnerName);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_06_04_D1");
		//arap.put("buisnessPartnerName", buisnessPartnerName);
		javascriphelper.JavaScriptHelper(driver);
		String contractenddate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
		System.out.println(contractenddate);
		String year = contractenddate.substring(7,11);
		arap.put("year1", year);
		String month = contractenddate.substring(3, 6);
		arap.put("month1", month);
		switch (month) {
		case "Dec":
			arap.put("fullmonth","December");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jan":
			arap.put("fullmonth","January");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Feb":
			arap.put("fullmonth","Febuary");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Mar":
			arap.put("fullmonth","March");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Apr":
			arap.put("fullmonth","April");
			System.out.println(arap.get("fullmonth"));
			break;
		case "May":
			arap.put("fullmonth","May");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jun":
			arap.put("fullmonth","June");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Jul":
			arap.put("fullmonth","July");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Aug":
			arap.put("fullmonth","August");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Sep":
			arap.put("fullmonth","September");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Oct":
			arap.put("fullmonth","October");
			System.out.println(arap.get("fullmonth"));
			break;
		case "Nov":
			arap.put("fullmonth","November");
			System.out.println(arap.get("fullmonth"));
			break;
		}
		
		 if (Integer.parseInt(contractenddate.substring(0, 2))>9) {
			String day = contractenddate.substring(0,2);
			System.out.println(day);
			arap.put("day", day);
		}
		else{
			String day = contractenddate.substring(1, 2);
			arap.put("day", day);
			System.out.println(day);
		}
		String creditnotenumber = (String) javascriphelper.executeScript("return document.getElementsByName('creditnoteNo')[1].value");
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_06_04_D1","creditnotenumber",creditnotenumber);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_06_04_D1");
		
		//arap.put("creditnotenumber", creditnotenumber);
		System.out.println(creditnotenumber);
		System.out.println(arap.get("creditnotenumber"));
		
    }


    @Then("^enter remark in confirmation alert in grn$")
    public void enter_remark_in_confirmation_alert_in_grn() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while(true)
		{
			try
			{
		javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
	//clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
		//invoiceBookingObj.AlertRemark().click();
		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(CreditNoteTestData.Remark);
		break;
			}
			catch(ElementNotInteractableException e)
			{
				
			}
			}
		
		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,100);
	
		invoiceBookingObj.alertSubmitButton().click();
    }
    @Then("^enter remark in confirmation alert in grn in arap$")
    public void enter_remark_in_confirmation_alert_in_grn_in_arap() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while(true)
		{
			try
			{
		javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
	//clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
		//invoiceBookingObj.AlertRemark().click();
		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(arap.get("approvalCommentsFromReviewer"));
		break;
			}
			catch(ElementNotInteractableException e)
			{
				
			}
			}
		
		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,100);
	
		invoiceBookingObj.alertSubmitButton().click();
    }
    @Then("^enter remark in confirmation alert in grn in arap0301$")
    public void enter_remark_in_confirmation_alert_in_grn_in_arap0301() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while(true)
		{
			try
			{
		javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
	//clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
		//invoiceBookingObj.AlertRemark().click();
		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(arap.get("Remark"));
		break;
			}
			catch(ElementNotInteractableException e)
			{
				
			}
			}
		
		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,100);
	
		invoiceBookingObj.alertSubmitButton().click();
    }
    @Then("^enter remark in confirmation alert in grn in arap0303$")
    public void enter_remark_in_confirmation_alert_in_grn_in_arap0303() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while(true)
		{
			try
			{
		javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
	//clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
		//invoiceBookingObj.AlertRemark().click();
		Thread.sleep(1000);
		invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(arap.get("approvalCommentsFromChecker"));
		break;
			}
			catch(ElementNotInteractableException e)
			{
				
			}
			}
		
		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,100);
	
		invoiceBookingObj.alertSubmitButton().click();
    }
    @And("^login with reviewer credentials2$")
	public void login_with_reviewer_credentials2() throws Throwable {
		ConfigFileReader configreader = new ConfigFileReader();
		driver.get(configreader.getApplicationUrl());
		
		KUBS_Login kubsLogin = new KUBS_Login(driver);

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, arap.get("Reviewer ID"));

	}
    @And("^select our record and clime using reference ID in arap0303$")
	public void select_our_budget_record_and_clime_using_reference_id_in_arap0303() throws Throwable {
		//KUBS_checker kubsCheckerObj = new KUBS_checker();
    	 KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
    	/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		javascriptHelper.JavaScriptHelper(driver);
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
    @Then("^select our record in notification records by the help of reference ID in arap0303$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id_in_arap0303() throws Throwable {
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


    @And("^select our record in notification records using reference ID in arap0302$")
	public void select_our_record_in_notification_records_using_reference_id_in_arap0302() throws Throwable {
		KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
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

    @Then("^choose the record$")
    public void choose_the_record() throws Throwable {

    }
    
    @And("^search for approved po$")
    public void search_for_approved_po() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	poCreationObj.poCreationSearchIcon().click();
    	Thread.sleep(1000);
    	//waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
    	javascriptHelper.scrollIntoView(poCreationObj.poStatus());
    	poCreationObj.poStatus().sendKeys(grnTestData.ApprovedPo);
        poNumber=poCreationObj.poPoNumber().getText();
       poBusinessPartner= poCreationObj.poBusinessPartner().getText();
       System.out.println(poNumber+" "+poBusinessPartner+" ");
       settlementTestData.put("poNumber", poNumber);
       settlementTestData.put("poBusinessPartner", poBusinessPartner);
       System.out.println("Po Number"+settlementTestData.get("poNumber"));
       System.out.println("Po Number"+settlementTestData.get("poBusinessPartner"));
    }
    
    @And("^search for approved po in arap$")
    public void search_for_approved_po_in_arap() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	poCreationObj.poCreationSearchIcon().click();
    	Thread.sleep(1000);
    	//waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
    	javascriptHelper.scrollIntoView(poCreationObj.poStatus());
    	poCreationObj.poStatus().sendKeys(arap.get("ApprovedPo"));
        poNumber=poCreationObj.poPoNumber().getText();
       poBusinessPartner= poCreationObj.poBusinessPartner().getText();
       System.out.println(poNumber+" "+poBusinessPartner+" ");
       arap.put("poNumber", poNumber);
       arap.put("poBusinessPartner", poBusinessPartner);
       System.out.println("Po Number"+arap.get("poNumber"));
       System.out.println("Po Number"+arap.get("poBusinessPartner"));
    }
    
    @And("^goto arap adjustment main module$")
    public void goto_arap_adjustment_main_module() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
    	makerObj.kubsDirectionIcon().click();
    }
    @Then("^go to ar ap adjustment module$")
    public void go_to_ar_ap_adjustment_module() throws Throwable {
    	Thread.sleep(2000);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.kubsToolIcon(), 5, 500);
    	makerObj.kubsToolIcon().click();
    	waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
    	makerObj.kubsDirectionIcon().click();
    	makerObj.kubsAdjustmentsArAp().click();
    	waitHelper.waitForElementVisible(arapAdjustment.adjustmentViewButton(), 1000, 100);
    	arapAdjustment.adjustmentViewButton().click();
    }
    @Then("^validate the po is not available for adjustment$")
    public void validate_the_po_is_not_available_for_adjustment() throws Throwable {
    	waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 2000, 100);
    	arapAdjustment.adjustmentBpName().click();
    	arapAdjustment.adjustmentBpName().sendKeys(settlementTestData.get("poBusinessPartner"));
    	arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
    	//Thread.sleep(2000);
    	arapAdjustment.adjustmentadjustmentType().click();
    	arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);
    	arapAdjustment.adjustmentItemType().click();
    	arapAdjustment.adjustmentItemType().sendKeys("Purchase Order");
    	arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
    	arapAdjustment.adjustmentAdjustmentReference().click();
    	arapAdjustment.adjustmentAdjustmentReference().sendKeys(settlementTestData.get("poNumber"));
    	waitHelper.waitForElementVisible(arapAdjustment.adjustmentAdjustmentReferenceNodata(), 2000, 100);
    	boolean result=arapAdjustment.adjustmentAdjustmentReferenceNodata().isDisplayed();
    	Assert.assertTrue(result);
    	
    }
    
    @And("^search the Ar cancelled advance in the adjustment screen$")
    public void search_the_ar_cancelled_advance_in_the_adjustment_screen() throws Throwable {
        javascriptHelper.JavaScriptHelper(driver);
        waitHelper.waitForElementVisible(arapAdjustment.adjustementSearchARAdvance(), 2000, 100);
        arapAdjustment.adjustementSearchARAdvance().click();
        arapAdjustment.adjustementSearchARAdvance().sendKeys(CreditNoteTestData.AdjustementItemType);      
        waitHelper.waitForElementVisible(arapAdjustment.adjustementCancelledAdvanceFirstRecord(), 2000, 100);
        arapAdjustment.adjustementCancelledAdvanceFirstRecord().click();
        Thread.sleep(1000);
        
    }

    @And("^select one record$")
    public void select_one_record() throws Throwable {
    	String adjstmentNumber= javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[16].value").toString();
        settlementTestData.put("adjustmentNumber", adjstmentNumber);
        System.out.println("Adjustment Reference number"+settlementTestData.get("adjustmentNumber"));
    }
    @Then("^adjustment reference number not availabe in the GL  record$")
    public void adjustment_reference_number_not_availabe_in_the_gl_record() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);

    	for(int i=0;i<299;i++)
    	{
    		try
    		{
    			waitHelper.waitForElementVisible(driver.findElement(By.xpath("//span[contains(text(),'"+settlementTestData.get("adjustmentNumber")+"')]")), 2000, 100);
    			boolean result=driver.findElement(By.xpath("//span[contains(text(),'"+settlementTestData.get("adjustmentNumber")+"')]")).isDisplayed();
    			if(result==true)
    	    	{
    	    		Assert.fail("Data is available ,Hence Expected result is not matched");
    	    	}
    			break;
    	
    		}
    		catch(NoSuchElementException e)
    		{
    			javascriptHelper.scrollIntoView(glObj.nextRecord());
    			glObj.nextRecord().click();
    		}
    	}
    }
    
/***********  KUBS_AR_AP_UAT_001_004_TC_01  *****************************/
   
    @And("^search and get the active GRN code$")
    public void search_and_get_the_active_grn_code() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.grnSearchGRNStatus(), 2000, 200);
    	grnObject.grnSearchGRNStatus().click();
    	grnObject.grnSearchGRNStatus().sendKeys(grnTestData.GRNStatus);
    	String aprovedGRNNumber=grnObject.getApprovedGRNNumber().getText();
    	System.out.println("Approved GRN number"+aprovedGRNNumber);
    	testData.put("approvedGRNNumber", aprovedGRNNumber);
    	
    }
    @And("^verify the accounting entries of GRn is appeared in the accounting entry screen$")
    public void verify_the_accounting_entries_of_grn_is_appeared_in_the_accounting_entry_screen() throws Throwable {
    	Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		//boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for(int i=0;i<299;i++)
    	{
    		try
    		{
    			waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testData.get("approvedGRNNumber")+"')]")), 2000, 100);
    			driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"+testData.get("approvedGRNNumber")+"')]")).isDisplayed();
			break;
    		} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				
				javascriptHelper.scrollIntoView(glObj.nextRecord());

				glObj.nextRecord().click();
				}
			
			
		if(i==299)
		{
			Assert.fail("InvoiceNumber not availabe : "+testData.get("approvedGRNNumber"));
		}
		}
		
    
	for(int j=0;j<2;j++)
	{
		try
		{
			String creditAmount=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("approvedGRNNumber")+"')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[5]//span[contains(text(),'Credit')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[1]//span")).getText();
		    String debitNote=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("approvedGRNNumber")+"')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[5]//span[contains(text(),'Debit')]/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[1]//span")).getText();
		System.out.println("Credit amount is "+creditAmount);
		System.out.println("Credit amount is "+debitNote);
		break;
		}
		catch(NoSuchElementException e2)
		{
			javascriptHelper.scrollIntoView(glObj.nextRecord());

			glObj.nextRecord().click();	
		}
	}
    }
    
    @And("^fill the invoice booking record in arap0401$")
    public void fill_the_invoice_booking_record_in_arap0401() throws Throwable {
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
	     invoiceBookingObj.billBookingPoBpName().sendKeys(arap.get("BusinessPartnerName"));
	     invoiceBookingObj.billBookingPoBpName().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.invoiceBollSuplierNAme().click();
	     invoiceBookingObj.invoiceBollSuplierNAme().sendKeys(arap.get("SuplierReferenceNumber")+random);
	     
	     invoiceBookingObj.billBookingPoFlatDiscount().click();
	     invoiceBookingObj.billBookingPoFlatDiscount().sendKeys(arap.get("FlatDiscount"));
	     /*
	     invoiceBookingObj.billBookingExpenceDiscountType().click();
	     invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.billBookingExpenceDiscountPercent().click();
	     invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys("2");
	     
	     */
	     invoiceBookingObj.billBookingPoPaymentMode().click();
	     invoiceBookingObj.billBookingPoPaymentMode().sendKeys(arap.get("PaymentMode"));
	     invoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.ENTER);
	     
	     invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
    }
    @And("^get the approved po number from approved record0401$")
    public void get_the_approved_po_number_from_approved_record0401() throws Throwable {
    	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj=new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
    	waitHelper.waitForElementVisible(poCreationObj.poCreationApprovedPoNumber(), 2000, 100);
    	String poNumber=poCreationObj.poCreationApprovedPoNumber().getText();
    	
    	excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1","poNumber",poNumber);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1");
    	
    	
    	//arap.put("poNumber",poNumber);
    }
    @And("^fill The invoice againse po record in arap0401$")
    public void fill_the_invoice_againse_po_record_in_arap() throws Throwable {
    	
    	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj=new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    	while(true)
    	{
    	try
    	{
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(arap.get("poNumber"));
    	invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
    	{
    	//waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
    	//waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSelectGRNRecord(), 2000, 100);
    	invoiceBookingObj.invoiceBookingSelectGRNRecord().click();
    	//waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBooingOkButton(), 2000, 100);
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
    @And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in arap0401$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_arap0401()
			throws Throwable {
    	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1","Reviewer ID",revID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
    
    @And("^User get the test data for the cancelling credit note test case0401$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0401() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_01_D1");
    }

    @And("^User get the test data for the cancelling credit note test case0402$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0402() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_02_D1");
    }

    @And("^User get the test data for the cancelling credit note test case0403$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0403() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_04_03_D1");
    }


    
    @And("^User get the test data for the cancelling credit note test case0301$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0301() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_03_01_D1");
    }
    @And("^User get the test data for the cancelling credit note test case0302$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0302() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_03_02_D1");
    }

    @And("^User get the test data for the cancelling credit note test case0303$")
    public void user_get_the_test_data_for_the_cancelling_credit_note_test_case0303() throws Throwable {
    	arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_03_03_D1");
    }
    
    
    /***********  KUBS_AR_AP_UAT_001_004_TC_01  *****************************/
}
