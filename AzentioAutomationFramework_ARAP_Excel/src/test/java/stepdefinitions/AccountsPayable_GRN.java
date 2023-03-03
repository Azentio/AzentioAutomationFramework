package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.AccountsPayable_GrnObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class AccountsPayable_GRN {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	AccountsPayable_GrnObj accountsPayable_GRNObj = new AccountsPayable_GrnObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	ARAP_GRNCreationPageObject grnObject=new ARAP_GRNCreationPageObject(driver);
	BrowserHelper browserHelper;
	String poNumber;
	String poBusinessPartner;
	ARAP_PoCreationObj poCreationObj=new ARAP_PoCreationObj(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_GoodsReceivedNote_GRN", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	
    @Then("^Click on Good Recived Note GRN Eye buutton$")
    public void click_on_good_recived_notegrn_eye_buutton() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_GoodsReceivedNoteGRNEyeButton(), 15, 1);
	accountsPayable_GRNObj.accountPayable_GoodsReceivedNoteGRNEyeButton().click(); 
    }
    
    @Then("^Click on Good Recived Note GRN Add button$")
    public void click_on_good_recived_note_grn_add_button()  {
    	for(int i=1; i<=20; i++) {
    		try {
    	
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_GoodsReceivedNoteGRN_AddButton(), 15, 1) ;
    accountsPayable_GRNObj.accountPayable_GoodsReceivedNoteGRN_AddButton().click();
    		break;
    		}
    		
    		catch(Exception e) {}}
    }

    @And("^user update the data set ID for GRN$")
    public void user_update_the_data_set_id_for_grn(){
    testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_003_01_D1");  
    }

    @Then("^Fill the form for GRN$")
    public void fill_the_form_for_grn() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_GrnBpName(), 15, 1);
    accountsPayable_GRNObj.accountPayable_GrnBpName().click(); 
	accountsPayable_GRNObj.accountPayable_GrnBpName().sendKeys(testData.get("BPName"));
	accountsPayable_GRNObj.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
	
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountsPayable_Grn_BpBranch(), 15, 1);
    accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().click();
	accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().sendKeys(testData.get("BPBranch"));
	accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().sendKeys(Keys.ENTER);
		
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber(), 15, 1);
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().click(); 
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("InvoiceNumber"));
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().sendKeys(Keys.ENTER);
		
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation(), 15, 1);
    accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().click();
	accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().sendKeys(testData.get("DeliveryLocation"));
	accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
	
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_Grn_SaveButton(), 15, 1);
    accountsPayable_GRNObj.accountPayable_Grn_SaveButton().click();
	
    for(int i=1; i<=20; i++) {
		try {
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.MessageContent());
	String msg1 =accountsPayable_GRNObj.MessageContent().getText();
	System.out.println(msg1);
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
	accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
	break;
		}
		catch(Exception e) {}
	}
	Thread.sleep(2000);
    for(int i=1; i<=20; i++) {
		try {
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.MessageContent());
	String msg2=accountsPayable_GRNObj.MessageContent().getText();
	System.out.println(msg2);
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
	accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
	break;
		}
		catch(Exception e) {}
	}
}
    
    
    @Then("^Search the grn record$")
    public void search_the_grn_record() throws InterruptedException  {
    
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_Grn_InboxSearchIcon());
	accountsPayable_GRNObj.accountPayable_Grn_InboxSearchIcon().click();
		
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_Grn_EventCodeSearch());
	accountsPayable_GRNObj.accountPayable_Grn_EventCodeSearch().sendKeys(testData.get("EventCode"));
	accountsPayable_GRNObj.accountPayable_Grn_EventCodeSearch().sendKeys(Keys.ENTER);
		

    }
    @And("^open the grn record$")
    public void open_the_grn_record() throws Throwable {
    for (int i = 1; i <=199; i++) {
    	try {
      waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_Grn_ActionButton(), 15, 1);
      accountsPayable_GRNObj.accountPayable_Grn_ActionButton().click();
       break;
    		}
    	catch(Exception e) {
    		if (i==199) {
    		Assert.fail(e.getMessage());
    			}
    	}
    	}  
    }
    
    @Then("^Click on Item Details Tab$")
    public void click_on_item_details_tab() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountsPayable_Grn_ItemDetails(), 15, 1);
    accountsPayable_GRNObj.accountsPayable_Grn_ItemDetails().click();
    }


    
    @Then("^Select PO Number$")
    public void select_po_number() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().click();
    
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().sendKeys(testData.get("PoNumber"));
		
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);

	}

    @Then("^Add qty received qty approved$")
    public void add_qty_received_qty_approved() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnQtyReceived());
    accountsPayable_GRNObj.accountPayable_GrnQtyReceived().click();
	accountsPayable_GRNObj.accountPayable_GrnQtyReceived().sendKeys(testData.get("QtyReceived"));
	accountsPayable_GRNObj.accountPayable_GrnQtyReceived().sendKeys(Keys.ENTER);

	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnQtyApproved());
    accountsPayable_GRNObj.accountPayable_GrnQtyApproved().click();
	accountsPayable_GRNObj.accountPayable_GrnQtyApproved().sendKeys(testData.get("QtyApproved"));
	accountsPayable_GRNObj.accountPayable_GrnQtyApproved().sendKeys(Keys.ENTER);
		
    }
    
    @And("^Save the Item Details record$")
    public void save_the_item_details_record() throws InterruptedException {
    	waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_ItemDetailsSaveButton());
    	accountsPayable_GRNObj.accountPayable_GRN_ItemDetailsSaveButton().click();
    	Thread.sleep(2000);
        for(int i=1; i<=20; i++) {
    		try {
    	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.MessageContent());
    	String msg2=accountsPayable_GRNObj.MessageContent().getText();
    	System.out.println(msg2);
    	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
    	accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
    	break;
    		}
    		catch(Exception e) {}
    	}
		   
    }
    
    
    @Then("^store the Reference ID and open the GRN record$")
    public void store_the_reference_id_and_open_the_grn_record() {
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_Grn_FirstReferenceId(), 15, 1);
	String Reference_Id=accountsPayable_GRNObj.accountPayable_Grn_FirstReferenceId().getText();
		
	excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_003_02_D1", "ReferenceID", Reference_Id);
		
	System.out.println("ReferenceID:" +Reference_Id);
		
	for (int i = 1; i <=199; i++) {
		try {
    waithelper.waitForElementToVisibleWithFluentWait(driver, accountsPayable_GRNObj.accountPayable_Grn_ActionButton(), 15, 1);
    accountsPayable_GRNObj.accountPayable_Grn_ActionButton().click();
    break;
		}
	catch(Exception e) {
		if (i==199) {
		Assert.fail(e.getMessage());
			}
		}
		}   
    }  

    @Then("^click submit and enter remark for GRN record$")
    public void click_submit_and_enter_remark_for_grn_record() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_SubmitButton());
    accountsPayable_GRNObj.accountPayable_GRN_SubmitButton().click(); 
    	
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_RemarkField());
    accountsPayable_GRNObj.accountPayable_GRN_RemarkField().click(); 
    accountsPayable_GRNObj.accountPayable_GRN_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
    accountsPayable_GRNObj.accountPayable_GRN_RemarkField().sendKeys(Keys.ENTER);	
    
    
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_Submit());
    accountsPayable_GRNObj.accountPayable_GRN_Submit().click();
    	
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_RecordStatus());
    WebElement recordstatus = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus();
    clicksAndActionHelper.moveToElement(recordstatus);
    	
    String message = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().getText();
    System.out.println(message);
    accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().click();
    String emptystring = "";
	String ar[] = message.split(" ");
	emptystring=ar[ar.length-1];
	String reviewerId=emptystring.replaceAll("[/.]", "");
	System.out.println(reviewerId);
	excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_003_02_D1", "ReviewerID", reviewerId);   
	
    }
   
    @And("^user update the data set ID for GRN Reviewer$")
    public void user_update_the_data_set_id_for_grn_reviewer() {
    testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_003_02_D1");    
    
    }
    
    @And("^User login as a reviewer user Approve Grn against PO$")
    public void user_login_as_a_reviewer_user_approve_grn_against_po()   {
    	login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));   
   
    }
    
		
    @And("^Approve Grn against PO the record by reviewer user$")
    public void approve_grn_against_po_the_record_by_reviewer_user() throws InterruptedException   {
     

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

	
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_Approve_Button());
	accountsPayable_GRNObj.accountPayable_GRN_Approve_Button().click();
	
	for(int i=0; i<=20; i++) {
	try {
	
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_ApproveRemarkByReviewer());
	accountsPayable_GRNObj.accountPayable_GRN_ApproveRemarkByReviewer().click();
//			
//	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_ApproveRemarkByReviewer());
	accountsPayable_GRNObj.accountPayable_GRN_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
			
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_Submit());
	accountsPayable_GRNObj.accountPayable_GRN_Submit().click();
	break;
	}catch(Exception e) {}
	}
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_RecordStatus());
	WebElement recordstatus = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus();
	clicksAndActionHelper.moveToElement(recordstatus);
	String message = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().getText();
	System.out.println(message);
	accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().click();

    }
    

    @And("^Click on claim button in checker for grn record$")
    public void click_on_claim_button_in_checker_for_grn_record() throws InterruptedException   {
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
       
    }
    @Then("^checker should approved the GRN against PO record$")
    public void checker_should_approved_the_grn_against_po_record() throws InterruptedException   {
    	Thread.sleep(2000);
    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
    		for (int i = 1; i <= 35; i++) {
    			try {
//    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
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
    			 
//    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
    			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
    			
    		
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
    		kubschecker.checkerApproveButton().click();
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
    		waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_checker_alert_remarks());
    		accountsPayable_GRNObj.accountPayable_GRN_checker_alert_remarks().sendKeys(testData.get("CheckerAlertRemark"));
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
    		kubschecker.checkersubmitButton().click();
//    		Thread.sleep(2000);
    		
    		waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GRN_RecordStatus());
        	WebElement recordstatus = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus();
        	clicksAndActionHelper.moveToElement(recordstatus);
        	String message = accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().getText();
        	System.out.println(message);
        	accountsPayable_GRNObj.accountPayable_GRN_RecordStatus().click();
    	    
    }


    @Then("^Get the GRN and Txn status by searching the record via business partner$")
    public void get_the_grn_and_txn_status_by_searching_the_record_via_business_partner()  {
    	for (int i = 1; i <= 35; i++) {
			try {
		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_Search());
		accountsPayable_GRNObj.accountPayable_GRN_Search().click();
		break;}
		catch(Exception e) {}}
		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_BusinessPartnerSearch());
		accountsPayable_GRNObj.accountPayable_GRN_BusinessPartnerSearch().sendKeys(testData.get("BPName"));
		
		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_ContractStatus());
		System.out.println("Contract Status - " +accountsPayable_GRNObj.accountPayable_GRN_ContractStatus().getText());
		
		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_TxnStatus());
		System.out.println("Txn Status - " +accountsPayable_GRNObj.accountPayable_GRN_TxnStatus().getText());
       
		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.accountPayable_GRN_GrnNumber());
		String grnReferenceNumber = accountsPayable_GRNObj.accountPayable_GRN_GrnNumber().getText();
		System.out.println("grnReferenceNumber");
		excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_007_01_D2", "GrnReferenceNumber", grnReferenceNumber); 
		
       
    }
   
  //----------------- @TC_003 GRN should be created successfully and displayed-----
    @Then("^Click on the Direction$")
	public void click_on_direction() throws Throwable {
	Thread.sleep(1000);
	waithelper.waitForElementToVisibleWithFluentWait(driver,accountsPayable_GRNObj.DirectionIcon(),15,1);
	accountsPayable_GRNObj.DirectionIcon().click();

	} 
    
    @Then("^Click on Fixed Asset$")
    public void click_on_fixed_asset() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver,accountsPayable_GRNObj.fixedAsset_Button(),15,1);
    accountsPayable_GRNObj.fixedAsset_Button().click();
    }
    @Then("^Click on Asset Creation eye button$")
    public void click_on_asset_creation_eye_button() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver,accountsPayable_GRNObj.fixedAsset_AssetCreation_EyeButton(),15,1);
    accountsPayable_GRNObj.fixedAsset_AssetCreation_EyeButton().click();   
    }

    @And("^user update the data set ID for GRN Fixed Asset$")
    public void user_update_the_data_set_id_for_grn_fixed_asset()  {
    testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_007_01_D2");    
    }

    @Then("^Fill the form and check if GRN is showing or not which we created$")
    public void fill_the_form_and_check_if_grn_is_showing_or_not_which_we_created() throws Throwable {
    for (int i = 1; i <= 35; i++) {
	try {
	waithelper.waitForElementToVisibleWithFluentWait(driver,accountsPayable_GRNObj.fixedAsset_AssetCreation_AddButton(),15,1);
    accountsPayable_GRNObj.fixedAsset_AssetCreation_AddButton().click();
    break;
		}
	catch(Exception e) {}
		}
    waithelper.waitForElementToVisibleWithFluentWait(driver,accountsPayable_GRNObj.fixedAsset_AssetCreation_GRNtextButton(),15,1);
    accountsPayable_GRNObj.fixedAsset_AssetCreation_GRNtextButton().click();
    accountsPayable_GRNObj.fixedAsset_AssetCreation_GRNtextButton().sendKeys(testData.get("GrnReferenceNumber"));
    accountsPayable_GRNObj.fixedAsset_AssetCreation_GRNtextButton().sendKeys(Keys.ENTER);
    }

   	
    //------------------------//
    
    @Then("^update data set id for grn auto populated1$")
    public void update_data_set_id_for_grn_auto_populated1() throws Throwable {
    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_004_TC_04_D1");   
    }
    @Then("^update data set id for grn auto populated2$")
    public void update_data_set_id_for_grn_auto_populated2() throws Throwable {
    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_005_TC_04_D1");   
    }

    @Then("^click on search$")
	public void click_on_search() throws Throwable {
		for(int i=1; i<=20; i++) {
			try{
				waithelper.waitForElementVisible(accountsPayable_GRNObj.accountPayable_grn_Search(), 2000, 100);
				accountsPayable_GRNObj.accountPayable_grn_Search().click();
				break;
			}
			catch(Exception e) {}

		}
	}
    
    @Then("^open the record$")
    public void open_the_record() throws Throwable {
	waithelper.waitForElement(driver, 2000, accountsPayable_GRNObj.accountsPayable_GrnNumber());
	accountsPayable_GRNObj.accountsPayable_GrnNumber().click();   
	accountsPayable_GRNObj.accountsPayable_GrnNumber().sendKeys(testData.get("GrnReferenceNumber"));
	accountsPayable_GRNObj.accountsPayable_GrnNumber().sendKeys(Keys.ENTER);
	
	//
	waithelper.waitForElement(driver, 2000, accountsPayable_GRNObj.accountsPayable_Grn_SelectRecord());
	accountsPayable_GRNObj.accountsPayable_Grn_SelectRecord().click(); 
	
		
    }
	
    @Then("^Click on the item Details tab$")
	public void click_on_the_item_details_tab() throws InterruptedException {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, accountsPayable_GRNObj.Grn_ItemDetails());
		accountsPayable_GRNObj.Grn_ItemDetails().click();

	}
	
	
	 @Then("^Click on Account Payable$")
	 public void click_on_account_payable()  {
     waithelper.waitForElement(driver, 4000, accountsPayable_GRNObj.accountPayableMenu());
     accountsPayable_GRNObj.accountPayableMenu().click();
		
	   }
	 
	 @Then("^Click on Inventory Management$")
	    public void click_on_inventory_management() {
//		waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());
		javascripthelper.JavaScriptHelper(driver);
//		waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());
		javascripthelper.scrollIntoViewAndClick(accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());
//		accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField().click();
	        
	    }
	 @Then("^Click on inventory stock receipt Eye Icon$")
	    public void click_on_inventory_stock_receipt_eye_icon() throws InterruptedException  {
//	    Thread.sleep(2000);
	    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_EyeButton());
	    WebElement EyeIcon = accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_EyeButton();
	    waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_EyeButton());
	  	Assert.assertTrue(accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_EyeButton().isDisplayed());
	  	clicksAndActionHelper.moveToElement(EyeIcon);
	  	accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_EyeButton().click();
	    	
		       
	    }
	 @Then("^Click on inventory stock Add button$")
	    public void click_on_inventory_stock_add_button() throws InterruptedException  {
//	    Thread.sleep(2000);
//	    waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_AddButton());
	    	for(int i=1; i<=20; i++) {
				try{
	    	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_AddButton());
	    accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_AddButton().click();
		     break;
				}
				catch(Exception e) {}}
	       
	    }

	    @Then("^enter GRN reference check details auto populated$")
	    public void enter_grn_reference_check_details_auto_populated() throws InterruptedException {
	        
	     //GRN Number
	 	  waithelper.waitForElement(driver, 3000, accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
	 	 accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_GRNNumber().click();
	 	 accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(testData.get("GrnReferenceNumber"));
	 	 accountsPayable_GRNObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(Keys.ENTER);
	 	 Thread.sleep(2000);
	    
	    }
	    //--------------------//

	    @And("^user update the data set ID for GRN against cancelled PO$")
	    public void user_update_the_data_set_id_for_grn_against_cancelled_po() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_003_002_TC_03_D1");  
	    }
	    
	    @And("^search for cancelled po$")
	    public void search_for_cancelled_po() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	    	poCreationObj.poCreationSearchIcon().click();
	    	Thread.sleep(1000);
	    	//waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
//	    	clicksAndActionHelper.moveToElement(poCreationObj.poStatus());
//	    	javascripthelper.scrollIntoView(poCreationObj.poStatus());
//	    	poCreationObj.poStatus().click();
	    	
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoView(poCreationObj.poStatus());
			poCreationObj.poStatus().click();
			poCreationObj.poStatus().sendKeys(testData.get("PoStatus"));
	        poNumber=poCreationObj.poPoNumber().getText();
	       poBusinessPartner= poCreationObj.poBusinessPartner().getText();
	       System.out.println(poNumber+" "+poBusinessPartner+" ");
	       

	    }

	    @And("^check GRN can be created for that perticular po$")
	    public void check_grn_can_be_created_for_that_perticular_po() throws Throwable {
	    	waithelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 1000, 100);
	    	System.out.println("Business Partner is"+poBusinessPartner);
	    	grnObject.accountPayable_GrnBpName().click();
	    	grnObject.accountPayable_GrnBpName().sendKeys(poBusinessPartner);
	    	Thread.sleep(2000);
	    	//grnObject.accountPayable_GRN_BPBranch().click();
		grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
		waithelper.waitForElementVisible(grnObject.accountPayable_GRN_BPBranch(), 2000, 100);
		grnObject.accountPayable_GRN_BPBranch().click();
	    	grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
	    	grnObject.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("InvoiceNo"));
	    	grnObject.accountPayable_GrnDeliveryLocation().click();
	    	//grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.DOWN);
	    	grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
	    	//waitHelper.waitForElementVisible(grnObject.accountPayable_GrnSaveButton(), 1000, 100);
	    	Thread.sleep(2000);
	    	//grnObject.accountPayable_GrnSaveButton().click();
	    	clicksAndActionHelper.doubleClick(grnObject.accountPayable_GrnSaveButton());
	    	grnObject.grnTempView().click();
	    	waithelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 1000,100);
	    	grnObject.grnTempViewFirstRecord().click();
	    	
	    	
	     
	    }
	    @And("^click notification button$")
		public void click_notification_button() throws Throwable {
			// After save our budget record we have to click on notification to submit our
			// record for approvals
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
					100);
			budgetCreationObj.budgetCreationNotificationIcon().click();
//			Thread.sleep(1000);

		}
	    @Then("^choose first record in the notification record$")
		public void choose_first_record_in_the_notification_record() throws Throwable {
			/*
			 * After click on notification we can see the record which we saved now and we
			 * have to select that along with the records reference ID We have to store the
			 * reference ID into the JSon file so that we can call the data in reviewer and
			 * checker stage
			 */
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
					500);
			String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
			/*
			 * addReferanceData(referenceID) This method is a predefined method to store the
			 * reference ID into the Json file
			 */
			
			budgetCreationObj.budgetCreationFirstRecord().click();

		}
	    
	    @Then("^go to Item details and enter po number$")
	    public void go_to_item_details_and_enter_po_number() throws Throwable {
	    	Thread.sleep(1000);
	    	waithelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
	    	grnObject.inventoryManagament_GRNItemDetails().click();
	    	waithelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
	    	grnObject.accountPayable_GrnPONumber().click();
	    	grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
	    	boolean result=grnObject.poNoSuctDataFromDropdown().isDisplayed();
	    	Assert.assertTrue(result);
	    }
}
