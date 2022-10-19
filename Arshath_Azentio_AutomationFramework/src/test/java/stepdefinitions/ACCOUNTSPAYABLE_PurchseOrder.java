package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import resources.BaseClass;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;

public class ACCOUNTSPAYABLE_PurchseOrder extends BaseClass {
	
	WebDriver driver =BaseClass.driver; 
    JsonConfig jsonConfig = new JsonConfig();
    ACCOUTSAPAYBLE_AutoPayoutTestDataType autoPayoutTestData= jsonConfig.getAccountsPayableAutoPayoutTestDataByName("Maker");
	WaitHelper waitHelper= new WaitHelper(driver);
    JavascriptHelper javascriptHelper= new JavascriptHelper();
    BUDGET_SupplementaryBudgetObj  supplimentoryBudgetObj = new  BUDGET_SupplementaryBudgetObj(driver);
    ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj=new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
    Map<String,String> testData= new HashMap<>();
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
    ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj = new  ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver); 
	@Then("^check the budget utilazation amount of budet code which we create the expense code$")
    public void check_the_budget_utilazation_amount_of_budet_code_which_we_create_the_expense_code() throws Throwable {
     waitHelper.waitForElementVisible(supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 3000, 300);
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();	
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys("BUD174786");	
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys("2023-2024");
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
     
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys("Azentio Main");
     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
     
     javascriptHelper.JavaScriptHelper(driver);
     String utilizationAmount  =(String) javascriptHelper.executeScript("return document.getElementById('utilizedAmt').value");
     System.out.println("Amount utilization is "+utilizationAmount);
     
     testData.put("UtilizationAmount", utilizationAmount);
    }
	
	@And("^add item details for the contract give budgetcode maped expense code$")
    public void add_item_details_for_the_contract_give_budgetcode_maped_expense_code() throws Throwable {
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
        vendorContractObj.vendorContractHSNCode().sendKeys(autoPayoutTestData.budgetMapedHSNCode);
        vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);
        
        vendorContractObj.vendorContractExpenceCode().click();
        vendorContractObj.vendorContractExpenceCode().sendKeys(autoPayoutTestData.budgetMapedExpensecode);
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
	@Then("^check the budget utilazation amount of budet code which we create the expense code after creating po$")
    public void check_the_budget_utilazation_amount_of_budet_code_which_we_create_the_expense_code_after_creating_po() throws Throwable {
	     waitHelper.waitForElementVisible(supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 3000, 300);
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();	
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys("BUD174786");	
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys("2023-2024");
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	     
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys("Azentio Main");
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	     
	     Thread.sleep(1000);
	     javascriptHelper.JavaScriptHelper(driver);
	     
	     String utilizationAmountwithPo  =(String) javascriptHelper.executeScript("return document.getElementById('utilizedAmt').value");
	     System.out.println("Amount utilization is "+utilizationAmountwithPo);
	     
	     testData.put("UtilizationAmountwithPo", utilizationAmountwithPo);     
    }
	@Then("^get the approved Po number which is created newly$")
    public void get_the_approved_po_number_which_is_created_newly() throws Throwable {
		waitHelper.waitForElementVisible(poCreationObj.poCreationApprovedPoNumber(), 3000, 300);
		String poNumber = poCreationObj.poCreationApprovedPoNumber().getText();
		testData.put("ApprovedPoNumber", poNumber);
		System.out.println("Approved PoNumber is "+testData.get("ApprovedPoNumber"));
		String ApprovedBpName = poCreationObj.poCreationApprovedBpNAme().getText();
        testData.put("approvedBpName", ApprovedBpName);
        System.out.println("Approved BpName is "+ testData.get("approvedBpName"));
	}
	@Then("^enter business partner name and po number for cancellation$")
    public void enter_business_partner_name_and_po_number_for_cancellation() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
     waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 3000, 300);
     arapAdjustment.adjustmentBpName().click();
     arapAdjustment.adjustmentBpName().sendKeys(testData.get("approvedBpName"));
     arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
     
     arapAdjustment.adjustmentadjustmentType().click();
     arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.DOWN);
     arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);

     arapAdjustment.adjustmentItemType().click();
     arapAdjustment.adjustmentItemType().sendKeys("Purchase Order");
     arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
     
     arapAdjustment.adjustmentAdjustmentReference().click();
     Thread.sleep(1000);
     arapAdjustment.adjustmentAdjustmentReference().sendKeys(testData.get("ApprovedPoNumber"));
     arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.DOWN);
     arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.ENTER);
     Thread.sleep(1000);
     
     String CancelledPo_amount = javascriptHelper.executeScript("return document.getElementById('cancelledAmt').value").toString();
     testData.put("CancelledPoAmount", CancelledPo_amount);
     System.out.println("Cancelled Po Amount:"+testData.get("CancelledPoAmount"));
     arapAdjustment.adjustementSaveButton().click();
     
	}
	
	@Then("^check the budget utilazation amount of budet code which we create the expense code after cancelling the po$")
    public void check_the_budget_utilazation_amount_of_budet_code_which_we_create_the_expense_code_after_cancelling_the_po() throws Throwable {
		waitHelper.waitForElementVisible(supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 3000, 300);
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();	
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys("BUD174786");	
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys("2023-2024");
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	     
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys("Azentio Main");
	     supplimentoryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	     Thread.sleep(1000);
	     javascriptHelper.JavaScriptHelper(driver);
	     String cancellingPoAmount  =(String) javascriptHelper.executeScript("return document.getElementById('utilizedAmt').value");
	     System.out.println("Amount utilization is "+cancellingPoAmount);
	     
	     testData.put("cancellingPoAmount", cancellingPoAmount);
	     
    }
	@Then("^verify budget code budget utilization amount is re-instated after cancelling the po$")
    public void verify_budget_code_budget_utilization_amount_is_reinstated_after_cancelling_the_po() throws Throwable {
		String utilizationAmountAfterCancellingPo  =(String) javascriptHelper.executeScript("return document.getElementById('utilizedAmt').value");
	//     System.out.println("Amount utilization is "+utilizationAmountAfterCancellingPo);
	     
	     testData.put("utilizationAmountAfterCancellingPo", utilizationAmountAfterCancellingPo);
		//UtilizationAmountwithPo
	//	System.out.println("Utilization amount with Po : "+testData.get("UtilizationAmountwithPo"));
		String[] splitUtilizationAmount = testData.get("UtilizationAmountwithPo").split("[.]");
		int spliAmount=Integer.parseInt(splitUtilizationAmount[0].replace(",", ""));
		String[]  splittedUtilizationAmt= testData.get("CancelledPoAmount").split("[.]");
		int spliUtilAmt=Integer.parseInt(splittedUtilizationAmt[0].replace(",", ""));
	//	System.out.println("Utilization amount is : "+testData.get("utilizationAmountAfterCancellingPo"));
		
		String[] spliUtilAmtAfterCancellingPo = testData.get("utilizationAmountAfterCancellingPo").split("[.]");
		int finalUtilAmt=Integer.parseInt(spliUtilAmtAfterCancellingPo[0].replace(",", ""));
		int finalUtilAmtAfterCancellingPo=spliAmount-spliUtilAmt;
		System.out.println("Calculation amount is"+spliAmount+"  "+spliUtilAmt);
//		System.out.println("Final Utilization amount : "+finalUtilAmtAfterCancellingPo);
		
		System.out.println("Budget Utilization amount before cancelling the po : "+spliAmount);
		System.out.println("Budget Utilization amount after cancelling the po : "+finalUtilAmt);
		System.out.println("Cancelled Po Amount : "+spliUtilAmt);
		
		Assert.assertEquals(finalUtilAmt, finalUtilAmtAfterCancellingPo);
		
		
		
		
		
		//Assert.assertEquals( testData.get("UtilizationAmount"),testData.get("utilizationAmountAfterCancellingPo"));
    }
}
