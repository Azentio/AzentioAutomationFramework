package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.BankRecon_ReconcilliationObj;
import resources.BaseClass;
import testDataType.BankRecon_ReconFormatTestDataType;


public class BankRecon_Reconcilliation_CorrectTxtFile extends BaseClass{
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BankRecon_ReconcilliationObj bankRecon_ReconcilliationObj = new BankRecon_ReconcilliationObj(driver);
	BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType = jsonReader.getBankReconByName("Maker");
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	AlertHelper alertHelper = new AlertHelper(driver);
	BrowserHelper browserHelper;
	
	
	
	@Then("^Click on Bank Reconcilliation$")
    public void click_on_bank_reconcilliation() throws Throwable {
	waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_Field());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_Field().click();
        
    }

    @Then("^click on Bank Reconcilliation format eye button$")
    public void click_on_bank_reconcilliation_format_eye_button() throws Throwable {
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_EyeButton());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_EyeButton().click();   
    }
    
    @Then("^Select Bank Name and Account Number$")
    public void select_bank_name_and_account_number() throws Throwable {
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().click();
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(bankRecon_ReconFormatTestDataType.BankNameRecon);
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(Keys.ENTER);
    
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().click();
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(bankRecon_ReconFormatTestDataType.AccountNumberRecon);
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(Keys.ENTER);
    
    }
    @Then("^Select Recon period from$")
    public void select_recon_period_from() throws Throwable {
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate().click();
	
	javascripthelper.JavaScriptHelper(driver);
	while(true)
    {
	try
	{
		
	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bankRecon_ReconFormatTestDataType.ReconPeriodFromMonth+" "+bankRecon_ReconFormatTestDataType.ReconYear+"')]")));
	WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+bankRecon_ReconFormatTestDataType.ReconPeriodFromMonth+" "+bankRecon_ReconFormatTestDataType.ReconYear+"')]"));
	break;
		
	}
		
    catch(NoSuchElementException nosuchElement)
	{
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
	}
	}
	WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+bankRecon_ReconFormatTestDataType.ReconPeriodFromFullMonth+" "+bankRecon_ReconFormatTestDataType.ReconPeriodFromDay+", "+bankRecon_ReconFormatTestDataType.ReconYear+"']/span"));
	clicksAndActionHelper.doubleClick(FinalDay);   
    }
    
    @Then("^Select Recon period to$")
    public void select_recon_period_to() throws Throwable {
    Thread.sleep(1000);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate().click();

	
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bankRecon_ReconFormatTestDataType.ReconPeriodToMonth+" "+bankRecon_ReconFormatTestDataType.ReconYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+bankRecon_ReconFormatTestDataType.ReconPeriodToMonth+" "+bankRecon_ReconFormatTestDataType.ReconYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+bankRecon_ReconFormatTestDataType.ReconPeriodToFullMonth+" "+bankRecon_ReconFormatTestDataType.ReconPeriodToDate+", "+bankRecon_ReconFormatTestDataType.ReconYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2); 
		 Thread.sleep(2000); 
		//// waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
		// bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(bankRecon_ReconFormatTestDataType.ChooseFile);
    }

    
    @Then("^upload the file$")
    public void upload_the_file() throws Throwable {
    
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
  
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(bankRecon_ReconFormatTestDataType.ChooseFile);
    Thread.sleep(2000);      
    }

    @Then("^Click on Process button$")
    public void click_on_process_button() throws Throwable {
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_ProcessButton());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_ProcessButton().click();
    Thread.sleep(2000);
    alertHelper.AcceptAlert();
    Thread.sleep(2000);
    
    }
    
    @Then("^verify matched record$")
    public void verify_matched_record() throws Throwable {
        
    }
    @Then("^verify unmatch record$")
    public void verify_unmatch_record() throws Throwable {
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab().click();
    Thread.sleep(2000); 
    //suggested record
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
    
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord().isDisplayed();
    Thread.sleep(1000);
    javascripthelper.JavaScriptHelper(driver);
    javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
    Thread.sleep(1000);
    
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
    
    //Transposition
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec().click();
    
    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord().isDisplayed();
    Thread.sleep(1000);
    //javascripthelper.JavaScriptHelper(driver);
   // javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
    //Thread.sleep(1000);
    
    
    }
    
    @Then("^upload the file data does not match$")
    public void upload_the_file_data_does_not_match() throws Throwable {
    	 Thread.sleep(1000); 
    	    waithelper.waitForElement(driver, 3000, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
    	  
    	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(bankRecon_ReconFormatTestDataType.ChooseFileMismatch);
    	    Thread.sleep(1500);
			/*
			 * javascripthelper.JavaScriptHelper(driver); String script =
			 * "return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-top-right toast-container']\")"
			 * ; // document.querySelector('ion-toast').shadowRoot.querySelector(
			 * "div[class='toast-message']") String str =
			 * javascripthelper.executeScript(script).toString(); System.out.println(str);
			 */
    }
    
		
}
