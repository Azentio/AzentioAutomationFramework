package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.FinancialReporting_TrialBalanceReportObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.FinancialReporting_TrialBalanceReportTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class FinancialReporting_TrialBalanceReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_TrialBalanceReportObj financialReporting_TrialBalanceReportObj = new FinancialReporting_TrialBalanceReportObj(driver);
	FinancialReporting_TrialBalanceReportTestDataType TrialBalanceReportTestDataType=jsonReader.getTrialBalanceReportdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@Then("^click on temp grid button of Trial Balance report$")
    public void click_on_temp_grid_button_of_Trial_balance_report()  {
		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton().click();
    }
	
	@And("^fill the required field of Trial Balance report$")
	public void fill_the_required_field_of_Trial_balance_report() {
		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode().sendKeys(TrialBalanceReportTestDataType.BranchCode);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();
		
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialMonth+" "+TrialBalanceReportTestDataType.TrialYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialMonth+" "+TrialBalanceReportTestDataType.TrialYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+TrialBalanceReportTestDataType.TrialFullMonth+" "+TrialBalanceReportTestDataType.TrialDate+", "+TrialBalanceReportTestDataType.TrialYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    	
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();
    	
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialToMonth+" "+TrialBalanceReportTestDataType.TrialToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialToMonth+" "+TrialBalanceReportTestDataType.TrialToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+TrialBalanceReportTestDataType.TrialFullToMonth+" "+TrialBalanceReportTestDataType.TrialToDate+", "+TrialBalanceReportTestDataType.TrialToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
		
		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(TrialBalanceReportTestDataType.Currency);
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(Keys.ENTER);
	}
	

    @Then("^click on view button to view the report for any period$")
    public void click_on_view_button_to_view_the_report_for_any_period() {
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
    	
    }
    
    //------------------Trial balance Report Summary
    
    @Then("^click on temp grid button of GL monthly balances report$")
    public void click_on_temp_grid_button_of_gl_monthly_balances_report()  {
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton().click();
    }
    
    @And("^fill the required field of GL monthly balances report$")
    public void fill_the_required_field_of_gl_monthly_balances_report() {
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode().sendKeys(TrialBalanceReportTestDataType.BranchCodeForTrialBalancesSummary);
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();
    	
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialMonthForTrialBalancesSummary+" "+TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+TrialBalanceReportTestDataType.TrialMonthForTrialBalancesSummary+" "+TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+TrialBalanceReportTestDataType.TrialFullMonthForTrialBalancesSummary+" "+TrialBalanceReportTestDataType.TrialDateForTrialBalancesSummary+", "+TrialBalanceReportTestDataType.TrialYearForTrialBalancesSummary+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary().sendKeys(TrialBalanceReportTestDataType.Currency);
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary().sendKeys(Keys.ENTER);
    }

    @Then("^click on view button to view the report for monthly period$")
    public void click_on_view_button_to_view_the_report_for_monthly_period() {
    	waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
    	financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
       
    }

}
