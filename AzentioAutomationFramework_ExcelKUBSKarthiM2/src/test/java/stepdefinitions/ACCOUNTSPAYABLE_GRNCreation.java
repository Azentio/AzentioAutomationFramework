package stepdefinitions;



import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.Account_Receivable;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_MakerObj;
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
    	clickAndActions.doubleClick(grnObject.accountPayable_GrnSaveButton());
    	grnObject.grnTempView().click();
    	waitHelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 1000,100);
    	grnObject.grnTempViewFirstRecord().click();
    	
    	
     
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
		excelData.updateTestData("KUBS_AR/AP_UAT_003_007_TC_05_D1","Reference ID",referenceID);
		arap = excelData.getTestdata("KUBS_AR/AP_UAT_003_007_TC_05_D1");
		clickAndActions.moveToElement(grnObject.grnFirstRecord());
		clickAndActions.clickOnElement(grnObject.grnFirstRecord());
		//.click();
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
						.sendKeys(arap.get("remark"));
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

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + arap.get("MonthYear") + "')]")));
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
		paymentSettlementObj.accountsPayableDescription().sendKeys(arap.get("remark"));

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
		crediteNoteObj.accountsReceivableDescription().sendKeys(arap.get("remark"));
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
		arap.put("buisnessPartnerName", buisnessPartnerName);
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
		arap.put("creditnotenumber", creditnotenumber);
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
		invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(arap.get("remark"));
		break;
			}
			catch(ElementNotInteractableException e)
			{
				
			}
			}
		
		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(),2000,100);
	
		invoiceBookingObj.alertSubmitButton().click();
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
    
    /***********  KUBS_AR_AP_UAT_001_004_TC_01  *****************************/
}
