package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_AutoPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.INVENTORY_EnquiryGlObject;
import resources.BaseClass;
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
	@And("^goto vendor contract module$")
    public void goto_vendor_contract_module() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractEyeIcon(), 2000, 100);
		vendorContractObj.vendorContractEyeIcon().click();
	}
    @Then("^fill all the mendatory fields for creating vendor$")
    public void fill_all_the_mendatory_fields_for_creating_vendor() throws Throwable {
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractExpenceType(), 2000, 100);
        vendorContractObj.vendorContractExpenceType().click();
        vendorContractObj.vendorContractExpenceType().sendKeys(autoPayoutTestData.ContractType);
        vendorContractObj.vendorContractExpenceType().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractBpName().click();
        vendorContractObj.vendorContractBpName().sendKeys(autoPayoutTestData.BusinessPartnerName);
        vendorContractObj.vendorContractBpName().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractContractName().click();
        vendorContractObj.vendorContractContractName().sendKeys(autoPayoutTestData.ContractName);
       
        vendorContractObj.vendorContractOtherDetails().click();
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractAutoGenerateInvoice(), 2000, 100);
        vendorContractObj.vendorContractAutoGenerateInvoice().click();
        vendorContractObj.vendorContractAutoGenerateInvoice().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractCreditPeriod().click();
        vendorContractObj.vendorContractCreditPeriod().sendKeys(autoPayoutTestData.CreditPeriod);
        
        vendorContractObj.vendorContractLatePaymentAmount().click();
        vendorContractObj.vendorContractLatePaymentAmount().sendKeys(autoPayoutTestData.PaymentAmmount);
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
        
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
        vendorContractObj.vendorContractAddButton().click();
        
        waitHelper.waitForElementVisible(vendorContractObj.vendorContractHSNCode(), 2000, 100);
        vendorContractObj.vendorContractHSNCode().click();
        vendorContractObj.vendorContractHSNCode().sendKeys(autoPayoutTestData.HSNCode);
        vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractExpenceCode().click();
        vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.DOWN);
        vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractCostCenter().click();
        vendorContractObj.vendorContractCostCenter().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractQuantity().click();
        vendorContractObj.vendorContractQuantity().sendKeys(autoPayoutTestData.VendorContractQuantity);
        
        vendorContractObj.vendorContractUnit().click();
        vendorContractObj.vendorContractUnit().sendKeys(Keys.ENTER);
        vendorContractObj.vendorContractRatePerUnit().click();
        vendorContractObj.vendorContractRatePerUnit().sendKeys(autoPayoutTestData.RatePerUnit);
        
        vendorContractObj.itemDetailsSaveButton().click();
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
         vendorContractObj.paymentTermPaymentTerm().sendKeys("Advance");
         vendorContractObj.paymentTermPaymentTermPercentage().click();
         vendorContractObj.paymentTermPaymentTermPercentage().sendKeys(autoPayoutTestData.PaymentTermPercentage);
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
    	waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetails(), 2000, 100);
    	 vendorContractObj.vendorContractBenificioryDetails().click();
         //waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
         //vendorContractObj.vendorContractAddButton().click();
         waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetailsPaymentMode(), 2000, 100);
         vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(autoPayoutTestData.PaymentMode);
         vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(Keys.ENTER);
         
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().click();
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.DOWN);
         vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.ENTER);
         vendorContractObj.vendorContractBenificioryDetailsSaveButton().click();
    }
    
    @And("^get the contract number$")
    public void get_the_contract_number() throws Throwable {
      waitHelper.waitForElementVisible(vendorContractObj.vendorContractApprovedContractNumber(), 2000, 100);
      String approvedContractNumber=vendorContractObj.vendorContractApprovedContractNumber().getText();
      autoPayout.put("approvedContractNumber", approvedContractNumber);
    }
    
    @And("^goto po creation module$")
    public void goto_po_creation_module() throws Throwable {
        waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton(), 2000, 100);
        poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();
    }
    
    @And("^fill the mendatory fields for po creation$")
    public void fill_the_mendatory_fields_for_po_creation() throws Throwable {
       waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_BPName(), 2000, 100);
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(autoPayoutTestData.BusinessPartnerName);
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.DOWN);
       poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
       
       poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
       
       poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().click();
       poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(autoPayoutTestData.ContractName);
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
    driver.findElement(By.xpath("//div[contains(text(),'"+autoPayout.get("approvedContractNumber")+"')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input")).sendKeys("100");
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

    @And("^save the benificiery details for po creation$")
    public void save_the_benificiery_details_for_po_creation() throws Throwable {
    	
    	
        
    }
    
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
    	
    	
    	
    }

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
    @And("^add item details for grn$")
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
    }

    @And("^save and submit the record$")
    public void save_and_submit_the_record() throws Throwable {
     //   throw new PendingException();
    }
    
    @And("^fill the invoice booking record$")
    public void fill_the_invoice_booking_record() throws Throwable {
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
	     invoiceBookingObj.invoiceBollSuplierNAme().sendKeys(autoPayoutTestData.SuplierReferenceNumber);
	     
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
    	waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 2000, 100);
    	invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
    	waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSelectGRNRecord(), 2000, 100);
    	invoiceBookingObj.invoiceBookingSelectGRNRecord().click();
    	waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBooingOkButton(), 2000, 100);
    	invoiceBookingObj.invoiceBooingOkButton().click();
    	break;
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
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+CreditNoteTestData.MonthYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
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
}
