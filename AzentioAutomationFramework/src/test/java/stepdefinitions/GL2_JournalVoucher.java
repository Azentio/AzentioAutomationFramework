package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.GL2_JournalVoucherObj;
import resources.BaseClass;
import testDataType.GL2_JournalVoucherTestDataType;

public class GL2_JournalVoucher extends BaseClass { 
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
		
	GL2_JournalVoucherObj gL2_JournalVoucherObj = new GL2_JournalVoucherObj(driver);
	GL2_JournalVoucherTestDataType gL2_JournalVoucherTestDataType = jsonReader.getJournalVoucherByName("Maker");
	 

	 @Then("^Click on General Ledger Transaction Field$")
	 public void click_on_general_ledger_transaction_field()  {
	 waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction());
	 gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction().click();
  
 }

	@Then("^Click on Journal Voucher EyeIcon$")
	public void click_on_journal_voucher_eyeicon() throws InterruptedException  {
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton());
	gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton().click();
	Thread.sleep(2000);        
 }

	@Then("^Click on Journal Voucher AddButton$")
	public void click_on_journal_voucher_addbutton()  {
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton());
	gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton().click();        
 }

	@Then("^Fill the Mandatory fields of Journal Voucher$")
	public void fill_the_mandatory_fields_of_journal_voucher()  {
	//BranchCode
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode());
	gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().click(); 
	gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(gL2_JournalVoucherTestDataType.BranchCode);
	gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(Keys.ENTER);
	
	//Currency
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Currency());
	gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().click(); 
	gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(gL2_JournalVoucherTestDataType.Currency);
	gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(Keys.ENTER);
	
	//JournalType
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType());
	gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().click(); 
	gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(gL2_JournalVoucherTestDataType.JournalType);
	gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(Keys.ENTER);
	
	//Remark
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Remark());
	gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().click(); 
	gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(gL2_JournalVoucherTestDataType.Remark);
	gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(Keys.ENTER);
		
	       
 }

	@Then("^Add Debit credit record$")
	public void add_debit_credit_record() throws InterruptedException  {
	//DrCr	
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr());
	gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click(); 
	
	//Select Debit
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Debit());
	gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();
	
	//Glcode
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode());
	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();
	
	//GlCodeDebit
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();
	
	//DebitAmount
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount());
	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(gL2_JournalVoucherTestDataType.DebitAmount);
	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);
	
	//ActionButton
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton());
	gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();
	
	//------Credit--//
	//DrCrSecond	
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond());
	gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click(); 
		
	//Select Credit
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
	gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();
		
	//Glcode-Second
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond());
	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();
		
	//GlCode-Credit
	Thread.sleep(1000);
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit());
	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();
		
	//CreditAmount
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount());
	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(gL2_JournalVoucherTestDataType.CreditAmount);
	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);
		
	/*//ActionButton
	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond());
 	gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();
	*/
 }

	@Then("^save the Journal Voucher record$")
    public void save_the_journal_voucher_record()  {

	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Save());
	gL2_JournalVoucherObj.gL2_JournalVoucher_Save().click();
		   
    }
	
	//--------------------KUBS_GL2_UAT_003_002---------------//
	

    @Then("^Add one Debit multiple credit record$")
    public void add_one_debit_multiple_credit_record() throws InterruptedException  {
    	//----------------DebitRecord----------//
    	//DrCr	
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click(); 
    	
    	//Select Debit
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Debit());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();
    	
    	//Glcode
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();
    	
    	//GlCodeDebit
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();
    	
    	//DebitAmount
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(gL2_JournalVoucherTestDataType.DebitAmount);
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);
    	
    	//ActionButton
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();
    	
    	//-----------------------------CreditRecordFirst--------------------------//
    	//DrCrSecond	
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click(); 
    		
    	//Select Credit
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();
    		
    	//Glcode-Second
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();
    		
    	//GlCode-Credit
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();
    		
    	//CreditAmount
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(gL2_JournalVoucherTestDataType.CreditAmountfirst);
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);
    		
    	//ActionButton
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond());
     	gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();
    	
    	//-----------------------------CreditRecordSecond--------------------------//
     	//DrCrSecond	
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird().click(); 
    		
    	//Select Credit
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();
    		
    	//Glcode-Third
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeThird());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeThird().click();
    		
    	//GlCode-CreditSecond
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCreditSecond());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCreditSecond().click();
    		
    	//CreditAmountSecond(
    	waithelper.waitForElement(driver, 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond());
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().click();
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().sendKeys(gL2_JournalVoucherTestDataType.CreditAmountSecond);
    	gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().sendKeys(Keys.ENTER);
    	
    }
	        

}
