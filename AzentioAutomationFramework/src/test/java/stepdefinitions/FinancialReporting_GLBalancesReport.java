package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class FinancialReporting_GLBalancesReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	FinancialReporting_GLBalancesReportTestDataType GLBalancesReportTestDataType=jsonReader.getGLBalancesReportdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@And("^user should navigate to financial reporting menu$")
	public void user_should_navigate_to_financial_reporting_menu()  {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReportingMenu());
		financialReporting_GLBalancesReportObj.FinancialReportingMenu().click();
	}
	
	@Then("^click on temp grid button of GL Balances report$")
    public void click_on_temp_grid_button_of_gl_balances_report()  {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_TempGridButton());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_TempGridButton().click();
    }
	
	@And("^fill the required field of GL Balances report$")
	public void fill_the_required_field_of_gl_balances_report() {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(GLBalancesReportTestDataType.BranchCode);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(Keys.DOWN);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(Keys.ENTER);
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(GLBalancesReportTestDataType.GLCode);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate().click();
		
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLMonth+" "+GLBalancesReportTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLMonth+" "+GLBalancesReportTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+GLBalancesReportTestDataType.GLFullMonth+" "+GLBalancesReportTestDataType.GLDate+", "+GLBalancesReportTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    	
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesToDate());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesToDate().click();
    	
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLToMonth+" "+GLBalancesReportTestDataType.GLToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLToMonth+" "+GLBalancesReportTestDataType.GLToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+GLBalancesReportTestDataType.GLFullToMonth+" "+GLBalancesReportTestDataType.GLToDate+", "+GLBalancesReportTestDataType.GLToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
		
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency());
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().sendKeys(GLBalancesReportTestDataType.Currency);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().sendKeys(Keys.ENTER);
	}
	

    @Then("^click on view button to view the report for any period$")
    public void click_on_view_button_to_view_the_report_for_any_period() throws InterruptedException {
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton().click();
    	Thread.sleep(3000);
    	browserHelper.switchToParentWithChildClose();
    	
    }
    
    //------------------GL Monthly balances Report
    
    @Then("^click on temp grid button of GL monthly balances report$")
    public void click_on_temp_grid_button_of_gl_monthly_balances_report()  {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLMonthlyBalancesReport_TempGridButton());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLMonthlyBalancesReport_TempGridButton().click();
    }
    
    @And("^fill the required field of GL monthly balances report$")
    public void fill_the_required_field_of_gl_monthly_balances_report() {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(GLBalancesReportTestDataType.BranchCodeForMonthlyBalancesReport);
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(GLBalancesReportTestDataType.GLCodeForMonthlyBalancesReport);
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate().click();
    	
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLMonthForMonthlyBalancesReport+" "+GLBalancesReportTestDataType.GLYearForMonthlyBalancesReport+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+GLBalancesReportTestDataType.GLMonthForMonthlyBalancesReport+" "+GLBalancesReportTestDataType.GLYearForMonthlyBalancesReport+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+GLBalancesReportTestDataType.GLFullMonthForMonthlyBalancesReport+" "+GLBalancesReportTestDataType.GLDateForMonthlyBalancesReport+", "+GLBalancesReportTestDataType.GLYearForMonthlyBalancesReport+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    	
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly().sendKeys(GLBalancesReportTestDataType.Currency);
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly().sendKeys(Keys.ENTER);
    }

    @Then("^click on view button to view the report for monthly period$")
    public void click_on_view_button_to_view_the_report_for_monthly_period() throws InterruptedException {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton());
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton().click();
    	Thread.sleep(3000);
    	browserHelper.switchToParentWithChildClose();
       
    }

}
