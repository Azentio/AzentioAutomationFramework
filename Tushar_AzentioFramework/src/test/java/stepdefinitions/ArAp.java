package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ArApObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ArApTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.InventoryManagementTestDataType;

public class ArAp {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	ArApTestDataType arApTestDataType = new ArApTestDataType();
	ArApObj arAPobj = new ArApObj(driver);
	
	//-----------------TC_007 Verify Approved GRN Reference is available on Fixed Asset creation-------
	  @Then("^Click on Report button$")
	    public void click_on_repoet_button() throws Throwable {
		  waithelper.waitForElement(driver, 2000,  arAPobj.report_button());
		  arAPobj.report_button().click();
	    }

	    @Then("^Click on Finincial Reporting tab$")
	    public void click_on_finincial_reporting_tab() throws Throwable {
	    	  waithelper.waitForElement(driver, 2000,arAPobj.financial_Reporting());
	    	arAPobj.financial_Reporting().click();
	    }

	    @Then("^Click on Balance Sheet Report edit button$")
	    public void click_on_balance_sheet_report_edit_button() throws Throwable {
	    	  waithelper.waitForElement(driver, 2000,arAPobj.balanceSheetReport_button());
		    	arAPobj.balanceSheetReport_button().click();
	    }

	    @Then("^Fill branch details for report$")
	    public void fill_branch_details_for_report() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	waithelper.waitForElement(driver, 2000,arAPobj.balanceSheetReport_branch_textbox());
	    	arAPobj.balanceSheetReport_branch_textbox().click();
	    	arAPobj.balanceSheetReport_branch_textbox().sendKeys(arApTestDataType.BranchCode);
	    	arAPobj.balanceSheetReport_branch_textbox().sendKeys(Keys.ENTER);
	    	//Thread.sleep(6000);
	    }

	    @Then("^Select date in calendar$")
	    public void select_date_in_calendar() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.calendar_button());
	    	arAPobj.calendar_button().click();
	    	javascripthelper.JavaScriptHelper(driver);
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAssetObj.inventoryNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAssetTestDataType.GlFullToMonth+" "+fixedAssetTestDataType.GlToDate+", "+fixedAssetTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
		
	    	
	    }

	    @Then("^Click on View button$")
	    public void click_on_view_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.view_button());
	    	arAPobj.view_button().click();
	    }
	
	
	//----------------- @TC_003 GRN should be created successfully and displayed-----
	    @Then("^Click on Asset Creation eye button$")
	    public void click_on_asset_creation_eye_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.fixedAsset_AssetCreation_EyeButton());
	    	arAPobj.fixedAsset_AssetCreation_EyeButton().click();   
	    }

	    @Then("^Fill the form and check if GRN is showing or not which we created$")
	    public void fill_the_form_and_check_if_grn_is_showing_or_not_which_we_created() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.fixedAsset_AssetCreation_AddButton());
	    	arAPobj.fixedAsset_AssetCreation_AddButton().click();
	    	
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	waithelper.waitForElement(driver, 2000,arAPobj.fixedAsset_AssetCreation_GRNtextButton());
	    	arAPobj.fixedAsset_AssetCreation_GRNtextButton().click();
	    	arAPobj.fixedAsset_AssetCreation_GRNtextButton().sendKeys(arApTestDataType.GRNreferenceNumber);
	    	arAPobj.fixedAsset_AssetCreation_GRNtextButton().sendKeys(Keys.ENTER);
	    }

	
	//------------------@KUBS_AR/AP_UAT_002_004	@TC_01 Create Advance against PO------------------------
	
	    @Then("^Click on Account Recivable button$")
	    public void click_on_account_recivable_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceivable_Button());
	    	arAPobj.accountReceivable_Button().click();
	    }

	    @Then("^Click on Account Recivable Advances eye button$")
	    public void click_on_account_recivable_advances_eye_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceivableAdvances_EyeButton());
	    	arAPobj.accountReceivableAdvances_EyeButton().click();
	    }

	    @Then("^Click to add record in Account Recivable$")
	    public void click_to_add_record_in_account_recivable() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceivableAdvances_AddButton());
	    	arAPobj.accountReceivableAdvances_AddButton().click();  
	    }

	    @Then("^Fill the form for Account Recivable$")
	    public void fill_the_form_for_account_recivable() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_Entity_Branch_Textbox());
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().click();
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().sendKeys(arApTestDataType.EntityBranch);
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_ReceivableName_TextBox());
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().click();
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(arApTestDataType.ReceivableName);
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_BusinessPatner_TextBox());
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().click();
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(arApTestDataType.BusinessPatner);
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_PONumber_TextBox());
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().click();
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().sendKeys(arApTestDataType.PONumber);
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_paymentMode_TextBox());
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().click();
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(arApTestDataType.PaymentMode);
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.amount_TextBox());
	    	arAPobj.amount_TextBox().click();
	    	arAPobj.amount_TextBox().sendKeys(arApTestDataType.Amount);
	    	arAPobj.amount_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_currency_TextBox());
	    	arAPobj.accountReceviableAdvances_currency_TextBox().click();
	    	arAPobj.accountReceviableAdvances_currency_TextBox().sendKeys(arApTestDataType.Currency);
	    	arAPobj.accountReceviableAdvances_currency_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_description_TextBox());
	    	arAPobj.accountReceviableAdvances_description_TextBox().click();
	    	arAPobj.accountReceviableAdvances_description_TextBox().sendKeys(arApTestDataType.Description);
	    	arAPobj.accountReceviableAdvances_description_TextBox().sendKeys(Keys.ENTER);
	    	
	    }

	    @Then("^Click on save button to save the Record for Account Recivable$")
	    public void click_on_save_button_to_save_the_record_for_account_recivable() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_Save_Button());
	    	arAPobj.accountReceviableAdvances_Save_Button().click();
	    	Thread.sleep(3000);
	    }
	
//------------------------@KUBS_AR/AP_UAT_002_004 @TC_03	Verify creating advane against PO with amount greater than PO amount is not allowed---
	    
	    
	    
	    @Then("^Fill the form for Account Recivable with amount greater than PO amount$")
	    public void fill_the_form_for_account_recivable_with_amount_greater_than_po_amount() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_Entity_Branch_Textbox());
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().click();
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().sendKeys(arApTestDataType.EntityBranch);
	    	arAPobj.accountReceviableAdvances_Entity_Branch_Textbox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_ReceivableName_TextBox());
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().click();
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(arApTestDataType.ReceivableName);
	    	arAPobj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_BusinessPatner_TextBox());
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().click();
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(arApTestDataType.BusinessPatner);
	    	arAPobj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_PONumber_TextBox());
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().click();
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().sendKeys(arApTestDataType.PONumber);
	    	arAPobj.accountReceviableAdvances_PONumber_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceviableAdvances_paymentMode_TextBox());
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().click();
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(arApTestDataType.PaymentMode);
	    	arAPobj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.amount_TextBox());
	    	arAPobj.amount_TextBox().click();
	    	arAPobj.amount_TextBox().sendKeys(arApTestDataType.ExcessiveAmount);
	    	arAPobj.amount_TextBox().sendKeys(Keys.ENTER);
	    }
	
	//--------@KUBS_AR/AP_UAT_007_001-----------------
	    @Then("^Click on Auto Payout edit grid$")
	    public void click_on_auto_payout_edit_grid() throws Throwable {
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	        javascripthelper.scrollIntoView(arAPobj.accountPayable_AutoPayoutEditButton());
	        
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountPayable_AutoPayoutEditButton());
	    	arAPobj.accountPayable_AutoPayoutEditButton().click();  
	    }

	    @Then("^Click on action button of record which we need to verify for details$")
	    public void click_on_action_button_of_record_which_we_need_to_verify_for_details() throws Throwable {
	        
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountPayable_AutoPayout_ActionButton());
	    	arAPobj.accountPayable_AutoPayout_ActionButton().click(); 	
	    	Thread.sleep(5000);
	    	Assert.assertTrue(arAPobj.accountPayable_AutoPayout_BeneficiaryName().isDisplayed());
	    	Assert.assertTrue(arAPobj.accountPayable_AutoPayout_AccountNumber().isDisplayed());
	    	Assert.assertTrue(arAPobj.accountPayable_AutoPayout_PaymentMode().isDisplayed());
	    	
	    }
//----------------@KUBS_AR/AP_UAT_011_001--------------
	    @Then("^Click on Accounts Recivable$")
	    public void click_on_accounts_recivable() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountReceivable_Button());
	    	arAPobj.accountReceivable_Button().click(); 
	    }

	    @Then("^Click on  Receipts reversals eye button$")
	    public void click_on_receipts_reversals_eye_button() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	        javascripthelper.scrollIntoView(arAPobj.accountsReceivable_ReceiptsReversals_EyeButton());
	    
	        waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EyeButton());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EyeButton().click();
	    }

	    @Then("^Click on add button of  Receipts reversals$")
	    public void click_on_add_button_of_receipts_reversals() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_AddButton());
	    	arAPobj.accountsReceivable_ReceiptsReversals_AddButton().click();
	    }

	    @Then("^Fill all the details of  Receipts reversals formm$")
	    public void fill_all_the_details_of_receipts_reversals_formm() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(arApTestDataType.EntityBranchforReversal);
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(Keys.ENTER);	  
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(arApTestDataType.RecieptReferenceNumber);
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(arApTestDataType.CancellationRemark);
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(Keys.ENTER);
	    	
	    }

	    @Then("^Click on save button of  Receipts reversals form$")
	    public void click_on_save_button_of_receipts_reversals_form() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_SaveButton());
	    	arAPobj.accountsReceivable_ReceiptsReversals_SaveButton().click();
	    	Thread.sleep(3000);
	    }

	    @Then("^Click on Edit Grid of Receipts reversals$")
	    public void click_on_edit_grid_of_receipts_reversals() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EditGrid());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EditGrid().click();
	    }

	    @Then("^Open first record from Edit Grid of Receipts reversals$")
	    public void open_first_record_from_edit_grid_of_receipts_reversals() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord().click();
	    	Thread.sleep(2000);
	    }

	    @Then("^Click on initiate$")
	    public void click_on_initiate() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord_initiateButton());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord_initiateButton().click(); 
	    	Thread.sleep(2000);
	    	waithelper.waitForElement(driver, 2000,arAPobj.ToastMessageClosebutton());
	    	arAPobj.ToastMessageClosebutton().click(); 
	    	
	    	
	    }
	//---------------KUBS_AR/AP_UAT_011_001_TC_02----------
	    @Then("^Fill all the details of  Receipts reversals form$")
	    public void fill_all_the_details_of_receipts_reversals_form() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(arApTestDataType.EntityBranchforReversal);
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(Keys.ENTER);	  
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(arApTestDataType.RecieptReferenceNumberForWire);
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(arApTestDataType.CancellationRemark);
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(Keys.ENTER);
	    	
	    }
	//---------------------------@KUBS_AR/AP_UAT_011_002_TC_01--------
	    @Then("^Click on receipt appropriation Reversal$")
	    public void click_on_receipt_appropriation_reversal() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	        javascripthelper.scrollIntoView(arAPobj.appropriation_Reversals_EyeButton());
	    
	    	waithelper.waitForElement(driver, 2000,arAPobj.appropriation_Reversals_EyeButton());
	    	arAPobj.appropriation_Reversals_EyeButton().click();  
	    }

	    @Then("^Click on add button of receipt appropriation$")
	    public void click_on_add_button_of_receipt_appropriation() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_AddButton());
	    	arAPobj.accountsReceivable_ReceiptsReversals_AddButton().click();  
	    }

	    @Then("^Fill all the details of receipt appropriation$")
	    public void fill_all_the_details_of_receipt_appropriation() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(arApTestDataType.EntityBranchforApportion);
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(Keys.ENTER);	  
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(arApTestDataType.RecieptReferenceNumberforApportion);
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(arApTestDataType.CancellationRemarkforApportion);
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(Keys.ENTER);
	    	
	    }

	    @Then("^Click on save button of receipt appropriation$")
	    public void click_on_save_button_of_receipt_appropriation() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.appropriation_Reversals_SaveButton());
	    	arAPobj.appropriation_Reversals_SaveButton().click();
	    	Thread.sleep(3000);  
	    }
	    //------------------KUBS_AR/AP_UAT_011_002_TC_02-----------
	    @Then("^Fill all the details of receipt appropriation for online mode$")
	    public void fill_all_the_details_of_receipt_appropriation_for_online_mode() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(arApTestDataType.EntityBranchforApportion);
	    	arAPobj.accountsReceivable_ReceiptsReversals_EntityBranchTextBox().sendKeys(Keys.ENTER);	  
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(arApTestDataType.RecieptReferenceNumberforApportionWire);
	    	arAPobj.accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox());
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().click();
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(arApTestDataType.CancellationRemarkforApportion);
	    	arAPobj.accountsReceivable_ReceiptsReversals_CancellationRemarktextBox().sendKeys(Keys.ENTER);
	     
	    }
	    
	//--------------KUBS_AR/AP_UAT_013_001_TC_04------------
	    
	    
	    
	    @Then("^Add Excessive PO qty received qty approved$")
	    public void add_excessive_po_qty_received_qty_approved() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
	    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayable_GrnQtyReceived());
			inventoryManagamentObj.accountPayable_GrnQtyReceived().click();
			inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(arApTestDataType.GRNQtyReceivedExcessive);
			inventoryManagamentObj.accountPayable_GrnQtyReceived().sendKeys(Keys.ENTER);
			Thread.sleep(1000);
	    	
	    	
	    	
	    	
	    	
	    	
	    	 javahelper.JavaScriptHelper(driver);
	 		String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
	 		//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
	 		String str = javahelper.executeScript(script).toString();
	 		System.out.println(str);  
	    }
	   
	    
	//-----------------KUBS_AR/AP_UAT_010_005_TC_03---------------
	    
	    @Then("^Click on Appropriation eye button$")
	    public void click_on_appropriation_eye_button() throws Throwable {
	    	javascripthelper.JavaScriptHelper(driver);
	        javascripthelper.scrollIntoView(arAPobj.appropriation_Eye_Button());
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.appropriation_Eye_Button());
	    	arAPobj.appropriation_Eye_Button().click();  
	    }

	    @Then("^Click on add button of  Appropriation$")
	    public void click_on_add_button_of_appropriation() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.appropriation_Add_Button());
	    	arAPobj.appropriation_Add_Button().click();
	    }

	    @Then("^Verify Credit Not record is available or not$")
	    public void verify_credit_not_record_is_available_or_not() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	// div[contains(text(),'ADV_10_21122021')]
			Thread.sleep(1000);
			javascripthelper.JavaScriptHelper(driver);
			// javascriptHelper.scrollDownByPixel();
			for (int i = 0; i <= 9; i++) {
				try {
					waithelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+arApTestDataType.CreditNoteInInvoiceReferenceNumber+"')]")),
							1000, 100);
					boolean status = driver.findElement(By.xpath("//div[contains(text(),'"+arApTestDataType.CreditNoteInInvoiceReferenceNumber+"')]")).isDisplayed();
					// Assert.assertFalse(result);

				} catch (NoSuchElementException e) {
					// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
					// 1000, 100);
					
					
					javascripthelper.JavaScriptHelper(driver);
			        javascripthelper.scrollIntoView(arAPobj.apportion_NextRecord());
					arAPobj.apportion_NextRecord().click();

				}
				if (i == 9) {
					System.out.println("This is the end of the table invoice number is not availabe ");
					break;

				}
			}
	    	


			}
	    	
	//--------------------KUBS_AR/AP_UAT_001_001_TC_005------------------
	    @Then("^Click on Report Tab$")
	    public void click_on_report_tab() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_Button());
	    	arAPobj.report_Report_Button().click();  
	    }

	    @Then("^Click on GRN Edit button$")
	    public void click_on_grn_edit_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_EditButton());
	    	arAPobj.report_Report_GRNReport_EditButton().click();   
	    }

	    @Then("^Select Vendor or Employee name$")
	    public void select_vendor_or_employee_name() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_VendorEmployeeName());
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().click();
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().sendKeys(arApTestDataType.VendorORemployeeeName);
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().sendKeys(Keys.ENTER);
			
	    }

	    @Then("^Select Date$")
	    public void select_date() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.calendar_button());
	    	arAPobj.calendar_button().click();
	    	javascripthelper.JavaScriptHelper(driver);
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	fixedAssetTestDataType= jsonReader.getFixedAssetByName("Maker");
	    	
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetTestDataType.GlToMonth+" "+fixedAssetTestDataType.GlYear+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAssetObj.inventoryNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAssetTestDataType.GlFullToMonth+" "+fixedAssetTestDataType.GlToDate+", "+fixedAssetTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
		
	    	 
	    }

	    @Then("^Select GRN Status$")
	    public void select_grn_status() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_GRNStatus());
	    	arAPobj.report_Report_GRNReport_GRNStatus().click();
	    	arAPobj.report_Report_GRNReport_GRNStatus().sendKeys(arApTestDataType.GRNStatus);
	    	arAPobj.report_Report_GRNReport_GRNStatus().sendKeys(Keys.ENTER);
	    	Thread.sleep(10000);
	    }

	    	
	  //-----------------------KUBS_AR/AP_UAT_010_002_TC_04--------

	    @Then("^Verify record is available in the sheet or not$")
	    public void verify_record_is_available_in_the_sheet_or_not() throws Throwable {
	    	arApTestDataType= jsonReader.getArApByName("Maker");
	    	// div[contains(text(),'DEP-RR12345-20220303')]
			Thread.sleep(1000);
			javascripthelper.JavaScriptHelper(driver);
			// javascriptHelper.scrollDownByPixel();
			for (int i = 0; i <= 60; i++) {
				try {
					waithelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'"+arApTestDataType.ClearedChequeReferenceNumber+"')]")),
							1000, 100);
					boolean status = driver.findElement(By.xpath("//div[contains(text(),'"+arApTestDataType.ClearedChequeReferenceNumber+"')]")).isDisplayed();
					// Assert.assertFalse(result);
					break;

				} catch (NoSuchElementException e) {
				 
					Thread.sleep(1000);
			    	javascripthelper.JavaScriptHelper(driver);
				 
			        javascripthelper.scrollIntoView(arAPobj.apportion_NextRecord());
			        waithelper.waitForElement(driver, 2000,arAPobj.apportion_NextRecord());
			    	arAPobj.apportion_NextRecord().click();

				}
				if (i == 60) {
					System.out.println("This is cleared cheque ");
					break;

				}
			}
	    }
	    	
	    	
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

