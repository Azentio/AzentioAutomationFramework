package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.BankRecon_ReconcilliationObj;
import resources.BaseClass;
import resources.ExcelData;


public class BankRecon_Reconcilliation_CorrectTxtFile extends BaseClass{
	WebDriver driver = BaseClass.driver;
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	BankRecon_ReconcilliationObj bankRecon_ReconcilliationObj = new BankRecon_ReconcilliationObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	AlertHelper alertHelper = new AlertHelper(driver);
	BrowserHelper browserHelper;
	ExcelData excelData = new ExcelData(System.getProperty("user.dir") + "\\Test-data\\KUBS_BankRecon_TestData.xlsx",
			"BankReconciliationTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
	@Then("^Click on Bank Reconcilliation$")
    public void click_on_bank_reconcilliation() throws Throwable {
	javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_Field());
	waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_Field());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_Field().click();
        
    }
	
	@Then("^click on Bank Reconcilliation format eye button$")
    public void click_on_bank_reconcilliation_format_eye_button() throws Throwable {
	javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_EyeButton());
	waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_EyeButton());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_EyeButton().click();   
    }
    
    @Then("^Select Bank Name and Account Number$")
    public void select_bank_name_and_account_number() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().click();
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(testData.get("BankName"));
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_BankName().sendKeys(Keys.ENTER);
    
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().click();
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber());
    Double d = Double.valueOf(testData.get("AccountNumber"));
    String accountNumber =String.format("%.0f", d);
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(accountNumber);
    String beforexpath1 = "//div[text()='";
	String afterxpath1 = "']";
	for (int i = 0; i <= 35; i++) {
		try {
			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)));
			driver.findElement(By.xpath(beforexpath1+accountNumber+afterxpath1)).isDisplayed();
			break;
		} catch (Exception e) {
			if(i==35) {
				Assert.fail(e.getMessage());	
				}
			// TODO: handle exception
		}
	}
//    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(testData.get("AccountNumber"));
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_AccountNumber().sendKeys(Keys.ENTER);
    
    }
    @Then("^Select Recon period from$")
    public void select_recon_period_from() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarDate().click();
	while (true) {
		try {

			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath("//span[text()='" + testData.get("FromMonth") + " " + testData.get("FromYear") + " ']")));
			WebElement monthAndYear = driver
					.findElement(By.xpath("//span[text()='" + testData.get("FromMonth") + " " + testData.get("FromYear") + " ']"));
			break;

		}

		catch (NoSuchElementException nosuchElement) {
			bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
		}
	}
	WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FromFullMonth") + " " + testData.get("FromDate")
			+ ", " + testData.get("FromYear") + "']/span"));
	clicksAndActionHelper.doubleClick(FinalDay);
}
    
    @Then("^Select Recon period to$")
    public void select_recon_period_to() throws Throwable {
    //Thread.sleep(1000);
	waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate());
	bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_CalendarAsOnDate().click();
	while (true) {
		try {

			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath("//span[text()='" + testData.get("ToMonth") + " " + testData.get("ToYear") + " ']")));
			WebElement monthAndYear = driver
					.findElement(By.xpath("//span[text()='" + testData.get("ToMonth") + " " + testData.get("ToYear") + " ']"));
			break;
		}

		catch (NoSuchElementException nosuchElement) {
			bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_NextMonth().click();
		}
	}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2); 
		 //Thread.sleep(2000); 
		//// waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
		// bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(testData.get("BankName").ChooseFile);
    }

    
    @Then("^upload the file$")
    public void upload_the_file() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(testData.get("UploadTextFile"));
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ValidationMessage());
    String toastmessage=bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ValidationMessage().getText();
	System.out.println(toastmessage);
	Assert.assertEquals("File validated successfully", toastmessage);
    //Thread.sleep(2000);      
    }

    @Then("^Click on Process button$")
    public void click_on_process_button() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_ProcessButton());
    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_ProcessButton().click();
    //Thread.sleep(2000);
    alertHelper.AcceptAlert();
    //Thread.sleep(2000);
    
    }
    
//    @Then("^verify matched record$")
//    public void verify_matched_record() throws Throwable {
//        
//    }
    
//    @Then("^verify unmatch record$")
//    public void verify_unmatch_record() throws Throwable {
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedDataTab().click();
//    //Thread.sleep(2000); 
//    //suggested record
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
//    
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_SuggestedRecord().isDisplayed();
//    //Thread.sleep(1000);
//    javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
//    //Thread.sleep(1000);
//    
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedSuggestedRec().click();
//    
//    //Transposition
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_UnmatchedTranspositionRec().click();
//    
//    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord());
//    bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TranspositionRecord().isDisplayed();
//    //Thread.sleep(1000);
//    //javascripthelper.JavaScriptHelper(driver);
//   // javascripthelper.scrollIntoView(bankRecon_ReconcilliationObj.bankRecon_BankReconciliation_TotalBankRec());
//    ////Thread.sleep(1000);
//    
//    
//    }
    
    @Then("^upload the file data does not match$")
    public void upload_the_file_data_does_not_match() throws Throwable {
    	 //Thread.sleep(1000); 
    	    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile());
    	    bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ChooseFile().sendKeys(testData.get("UploadTextFile"));
    	   
    	    waithelper.waitForElementwithFluentwait(driver, bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ValidationMessage());
    	    String toastmessage=bankRecon_ReconcilliationObj.bankRecon_Reconcilliation_ValidationMessage().getText();
    		System.out.println(toastmessage);
    		Assert.assertEquals("Account no in uploaded file is not matching with account no selected on screen", toastmessage);
    	    //Thread.sleep(1500);
			/*
			 * javascripthelper.JavaScriptHelper(driver); String script =
			 * "return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-top-right toast-container']\")"
			 * ; // document.querySelector('ion-toast').shadowRoot.querySelector(
			 * "div[class='toast-message']") String str =
			 * javascripthelper.executeScript(script).toString(); System.out.println(str);
			 */
    }
    
}
