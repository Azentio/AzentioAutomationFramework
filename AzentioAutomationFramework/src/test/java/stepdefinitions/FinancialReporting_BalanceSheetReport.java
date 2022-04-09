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
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FinancialReporting_BalanceSheetReportTestDataType;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class FinancialReporting_BalanceSheetReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	FinancialReporting_BalanceSheetReportTestDataType BalanceSheetReportTestDataType=jsonReader.getBalanceSheetReportdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	
	@Then("^click on temp grid button of Balance sheet report$")
    public void click_on_temp_grid_button_of_balance_sheet_report()  {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton().click();
    }
	
	@And("^fill the required field of Balance sheet report$")
	public void fill_the_required_field_of_balance_sheet_report() {
		
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(BalanceSheetReportTestDataType.Branch);
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(BalanceSheetReportTestDataType.BalanceSheetYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
					clicksAndActionHelper.doubleClick(Year);
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetYear+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth +" "+BalanceSheetReportTestDataType.BalanceSheetDate+", "+BalanceSheetReportTestDataType.BalanceSheetYear+"']/span")));	
		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth +" "+BalanceSheetReportTestDataType.BalanceSheetDate+", "+BalanceSheetReportTestDataType.BalanceSheetYear+"']/span"));
		clicksAndActionHelper.doubleClick(BirthDate);
		
	}

    @Then("^click on view button to view the balance sheet report$")
    public void click_on_view_button_to_view_the_balance_sheet_report()  {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView());
    	financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView().click();
    	
    }
    
    @Then("^Verify balance sheet should updated correctly$")
    public void Verify_balance_sheet_should_updated_correctly() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData()); 
    	String receivableAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData().getText();
    	System.out.println("Trade Receivables Advances to Employee - "+ receivableAmount);
    	browserHelper.switchToParentWithChildClose();
    }
    
    @Then("^Verify balance sheet should updated correctly post approval through online mode$")
    public void Verify_balance_sheet_should_updated_correctly_post_approval_through_online_mode() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()); 
    	String receiptAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
    	System.out.println("Receivables Cash Equivalents - "+ receiptAmount);
    	browserHelper.switchToParentWithChildClose();
    }
    
    @Then("^Verify balance sheet should updated correctly post cheque is cleared$")
    public void Verify_balance_sheet_should_updated_correctly_post_cheque_is_cleared() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()); 
    	String chequeAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
    	System.out.println("Receivables Cash Equivalents - "+ chequeAmount);
    	browserHelper.switchToParentWithChildClose();
    }

}
