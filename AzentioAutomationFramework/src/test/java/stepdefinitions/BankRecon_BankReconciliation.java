package stepdefinitions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.BankRecon_BankReconciliationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_ManualPayoutTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.BankRecon_BankReconciliationTestDataType;

public class BankRecon_BankReconciliation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	BankRecon_BankReconciliationObj bankRecon_BankReconciliationObj = new BankRecon_BankReconciliationObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	BankRecon_BankReconciliationTestDataType BankReconciliationTestDataType=jsonReader.getBankReconciliationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	AlertHelper alertHelper = new AlertHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	
//-------- @KUBS_TAX_UAT_002_001_TC_003------------
	
	@And("^user should navigate to bank recon menu$")
	public void user_should_navigate_to_bank_recon_menu()  {
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankReconciliationMenu());
		bankRecon_BankReconciliationObj.BankReconciliationMenu().click();
	}
    
	@When("^click on eye button of bank reconciliation$")
    public void click_on_eye_button_of_bank_reconciliation() {
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_EyeButton().click();
		
    }
	
	@And("^click on add button for bank reconciliation$")
	public void click_on_add_button_for_bank_reconciliation() {
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AddButton().click();
	}
	
	@And("^Fill the required fields and upload bank statement for bank reconciliation$")
	public void fill_the_required_fields_and_upload_bank_statement_for_bank_reconciliation() throws InterruptedException, IOException {
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(BankReconciliationTestDataType.BankName);
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankName().sendKeys(Keys.ENTER);
		
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().click();
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(BankReconciliationTestDataType.AccountNumber);
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_AccountNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodFrom().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromMonth+" "+BankReconciliationTestDataType.FromYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromMonth+" "+BankReconciliationTestDataType.FromYear+"')]"));
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
				int year=Integer.parseInt(BankReconciliationTestDataType.FromYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.FromYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromYear+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth+" "+BankReconciliationTestDataType.FromYear+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth +" "+BankReconciliationTestDataType.FromDate+", "+BankReconciliationTestDataType.FromYear+"']/span")));	
		WebElement PeriodFromDate=driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.FromFullMonth +" "+BankReconciliationTestDataType.FromDate+", "+BankReconciliationTestDataType.FromYear+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodFromDate);
		
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ReconPeriodTo().click();
		
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToMonth+" "+BankReconciliationTestDataType.ToYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToMonth+" "+BankReconciliationTestDataType.ToYear+"')]"));
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
				int year=Integer.parseInt(BankReconciliationTestDataType.ToYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BankReconciliationTestDataType.ToYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToYear+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth+" "+BankReconciliationTestDataType.ToYear+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth +" "+BankReconciliationTestDataType.ToDate+", "+BankReconciliationTestDataType.ToYear+"']/span")));	
		WebElement PeriodToDate=driver.findElement(By.xpath("//td[@aria-label='"+BankReconciliationTestDataType.ToFullMonth +" "+BankReconciliationTestDataType.ToDate+", "+BankReconciliationTestDataType.ToYear+"']/span"));
		clicksAndActionHelper.doubleClick(PeriodToDate);
		
		waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile());
		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().sendKeys(BankReconciliationTestDataType.FileUpload);
//		bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UploadFile().click();
		
		
		//By using AUTO IT Method
//		Thread.sleep(7000);
//		Runtime.getRuntime().exec("C://Users/inindc00091/Desktop/IDFC_REC_A11.exe"+" "+"C:\\Users\\inindc00091\\Downloads\\IDFC_REC_A11.txt");
//		Thread.sleep(1000);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

    @Then("^Save and click on process$")
    public void save_and_click_on_process() throws InterruptedException {
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SaveButton().click();
    	
    	Thread.sleep(2000);
    	javascripthelper.JavaScriptHelper(driver);
    	String toastmessage = javascripthelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
    	System.out.println(toastmessage);
    	
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_ProcessButton().click();
//    	alertHelper.getAlert();
//    	Thread.sleep(1000);
    	alertHelper.isAlertPresent();
    	String alertText = alertHelper.getAlertText();
    	alertHelper.AcceptAlert();
    }
    
    @Then("^verify the bank reconciliation process tab is enabled$")
    public void verify_the_bank_reconciliation_process_tab_is_enabled() throws InterruptedException  {
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliatioDetails());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliatioDetails().click();
    	
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationProcessTab());
    	boolean bankreconprocess = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconciliationProcessTab().isEnabled();
    	System.out.println("Bank Reconciliation Process Tab is Enabled : "+bankreconprocess);
    }
    
    @Then("^Verify all the matched entries are displayed under the matched tab for book to bank$")
    public void verify_all_the_matched_entries_are_displayed_under_the_matched_tab_for_book_to_bank() throws InterruptedException {
    	
    	

		javascripthelper.JavaScriptHelper(driver);
		String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
		System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
		
    	waithelper.waitForElement(driver, 4000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	String total = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount().getText();
    	
    	String matchedCount = "";
		String ar[] = total.split(" ");
		matchedCount=ar[0];
		int matchedDataCount = Integer.parseInt(matchedCount);
		if(matchedDataCount==0)
		{
			System.out.println("No Matched Data Display");
		}else{
			System.out.println("Total "+matchedDataCount+" Matched Data Display");
		}
		
		waithelper.waitForElement(driver, 4000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
		boolean tab = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().getText().equals(BankReconciliationTestDataType.MatchedTab);
		System.out.println("All the matched records are under Matched Tab - "+tab);
		
    }
    
    @Then("^Verify all the matched entries are displayed under the matched tab for bank to book$")
    public void verify_all_the_matched_entries_are_displayed_under_the_matched_tab_for_bank_to_book() throws InterruptedException {
    	
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().click();
    	
//    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisClose().click();
//    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisDropDown());
//    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisDropDown().click();
//    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 5000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().click();
    	Thread.sleep(1000);
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys("Bank to Book");
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_BankReconBasisField().sendKeys(Keys.DOWN,Keys.ENTER);
    	Thread.sleep(1000);
    	
    	javascripthelper.JavaScriptHelper(driver);
    	String bankReconBasis = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label ng-star-inserted')[0].innerText").toString();
    	System.out.println("Bank Reconciliation Basis is - "+bankReconBasis);
    	
    	
    	waithelper.waitForElement(driver, 4000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount());
    	String total = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataCount().getText();
    	
    	String matchedCount = "";
    	String ar[] = total.split(" ");
    	matchedCount=ar[0];
    	int matchedDataCount = Integer.parseInt(matchedCount);
    	if(matchedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+matchedDataCount+" Matched Data Display");
    	}
    	
    	waithelper.waitForElement(driver, 4000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab());
    	boolean tab = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_MatchedDataTab().getText().equals(BankReconciliationTestDataType.MatchedTab);
    	System.out.println("All the matched records are under Matched Tab - "+tab);
    }
    
    @Then("^Verify the Unmatch Record Tab must display all the entries for unmatched records from Book$")
    public void verify_the_unmatch_record_tab_must_display_all_the_entries_for_unmatched_records_from_book() throws Throwable {
        
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedDataTab().click();
    	
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch().click();
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
//    	javascripthelper.scrollToElemetAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
    	javascripthelper.scrollIntoViewAndClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
    	
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Unmatched");
    	Thread.sleep(2000);
    	String unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String unmatchedCount = "";
    	String ar[] = unmatched.split(" ");
    	unmatchedCount=ar[0];
    	int unmatchedDataCount = Integer.parseInt(unmatchedCount);
    	if(unmatchedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+unmatchedDataCount+" Unmatched Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Suggested");
    	Thread.sleep(2000);
    	String suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String suggestedCount = "";
    	String ar1[] = suggested.split(" ");
    	suggestedCount=ar1[0];
    	int suggestedDataCount = Integer.parseInt(suggestedCount);
    	if(suggestedDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+suggestedDataCount+" Suggested Data Display");
    	}
    	
    	clicksAndActionHelper.doubleClick(bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordsFromBookSearch());
    	waithelper.waitForElement(driver, 3000, bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook());
    	bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_StatusSearchFromBook().sendKeys("Transposition");
    	
    	Thread.sleep(2000);
    	String transpostion = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_RecordCountFromBook().getText();
    	String transpositionCount = "";
    	String ar2[] = transpostion.split(" ");
    	transpositionCount=ar2[0];
    	int transpositionDataCount = Integer.parseInt(transpositionCount);
    	if(transpositionDataCount==0)
    	{
    		System.out.println("No Matched Data Display");
    	}else{
    		System.out.println("Total "+transpositionDataCount+" Transposition Data Display");
    	}
    	
//    	boolean unmatched = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_UnmatchedRecord().isDisplayed();
//    	System.out.println("Unmatched records entries are present - "+unmatched);
//    	boolean suggested = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_SuggestedRecord().isDisplayed();
//    	System.out.println("Suggested records entries are present - "+suggested);
//    	boolean transposition = bankRecon_BankReconciliationObj.BankRecon_BankReconciliation_TranspositionRecord().isDisplayed();
//    	System.out.println("Transposition records entries are present - "+transposition);
    	
    	
    }
	
}