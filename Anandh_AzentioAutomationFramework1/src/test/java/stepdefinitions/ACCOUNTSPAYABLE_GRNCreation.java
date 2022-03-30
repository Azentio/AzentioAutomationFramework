package stepdefinitions;



import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
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
    @And("^click on accounts Payable module$")
    public void click_on_accounts_payable_module() throws Throwable {
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
    }
    @And("^goto arap adjustment main module$")
    public void goto_arap_adjustment_main_module() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
    	makerObj.kubsDirectionIcon().click();
    }
    @Then("^go to ar ap adjustment module$")
    public void go_to_ar_ap_adjustment_module() throws Throwable {
    	
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
