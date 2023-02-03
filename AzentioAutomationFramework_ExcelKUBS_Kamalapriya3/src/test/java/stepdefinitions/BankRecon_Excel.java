package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BANKRECON_BankReconcilationObj;
import pageobjects.BankReconciliation_ModuleObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BankReconciliationTestData;

public class BankRecon_Excel {
	public class Bank_ReconModule extends BaseClass {
		WebDriver driver = BaseClass.driver;
		Selenium_Actions seleniumactions = new Selenium_Actions(driver);
		AzentioLogin login;
		ConfigFileReader configreader = new ConfigFileReader();
		BankReconciliation_ModuleObj bankReconObj = new BankReconciliation_ModuleObj(driver);
		BANKRECON_BankReconcilationObj bankReconObject = new BANKRECON_BankReconcilationObj(driver);
		WaitHelper waitHelper = new WaitHelper(driver);
		ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
		JsonConfig jsonconfig = new JsonConfig();
		BankReconciliationTestData bankReconData = jsonconfig.getBankReconlist("Maker");
		JavascriptHelper javascriphelper = new JavascriptHelper();
		//Map<String,String> testdata = new LinkedHashMap<>();
		ExcelData excelData = new ExcelData(System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx","BankRecon","DataSet ID");
		Map<String, String> testData = new HashMap<>();
		
		@And("^user select bank name in bank recon Module for csv files$")
	    public void user_select_bank_name_in_bank_recon_module_for_csv_files() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.selectBankName());
	        bankReconObj.selectBankName().click();
	        bankReconObj.selectBankName().sendKeys(testData.get("CsvBankName"));
	        bankReconObj.selectBankName().sendKeys(Keys.ENTER);
	    }
		  @And("^user click bank recon from date and select the date for csv files$")
		    public void user_click_bank_recon_from_date_and_select_the_date_for_csv_files() throws Throwable {
		    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_FromDate());
		        bankReconObj.bankRecon_FromDate().click();
		        Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
						.click();
				driver.findElement(By.xpath("//span[text()='" + testData.get("CsvBankReconFromYear")  + "']")).click();
				driver.findElement(By.xpath("//span[text()='" + testData.get("CsvBankReconFromMonth") + "']")).click();
				seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					    driver.findElement(By.xpath("//td[@aria-label='"+testData.get("CsvBankReconFromFullMonth")+" "
						+bankReconData.CsvBankReconFromDay+", "+testData.get("CsvBankReconFromYear")+"']")));
						driver.findElement(By.xpath("//td[@aria-label='"+testData.get("CsvBankReconFromFullMonth")+" "
						+bankReconData.CsvBankReconFromDay+", "+testData.get("CsvBankReconFromYear")+"']")).click();
		    }
		  @And("^user click bank recon to date and select the date for csv files$")
		    public void user_click_bank_recon_to_date_and_select_the_date_for_csv_files() throws Throwable {
		    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_ToDate());
		        bankReconObj.bankRecon_ToDate().click();
		        Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
						.click();
				driver.findElement(By.xpath("//span[text()='" + testData.get("CsvBankReconToYear")  + "']")).click();
				driver.findElement(By.xpath("//span[text()='" + testData.get("CsvBankReconToMonth") + "']")).click();
				seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					    driver.findElement(By.xpath("//td[@aria-label='"+testData.get("CsvBankReconFullToMonth")+" "
						+testData.get("CsvBankReconToDay")+", "+testData.get("CsvBankReconToYear")+"']")));
						driver.findElement(By.xpath("//td[@aria-label='"+testData.get("CsvBankReconFullToMonth")+" "
						+testData.get("CsvBankReconToDay")+", "+testData.get("CsvBankReconToYear")+"']")).click();
		        
		    }
		  @And("^user click choose file and upload the bank statements for csv$")
		    public void user_click_choose_file_and_upload_the_bank_statements_for_csv() throws Throwable {
		        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.chooseFile());
		        bankReconObj.chooseFile().sendKeys(testData.get("FileLocationCsv"));
		    }
		  @And("^user match the records in unmached tabs$")
		    public void user_match_the_records_in_unmached_tabs() throws Throwable {
		    	String xpath="//ion-grid[1]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
		        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
		        String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
		        //testdata.put("chequeno", ChequeNo);
		        excelData.updateTestData("KUBS_TAX_UAT_003_001TC_001_D1", "ChequeNo", ChequeNo);
		        System.out.println(ChequeNo);
		        String unmatchedCheque = driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[6]/div")).getText();
		        //testdata.put("unmatchedcheque", unmatchedCheque);
		        excelData.updateTestData("KUBS_TAX_UAT_003_001TC_001_D1", "unmatchedcheque", unmatchedCheque);

		        System.out.println(unmatchedCheque);
		        javascriphelper.JavaScriptHelper(driver);
		       // javascriphelper.scrollIntoView(bankReconObj.clickFirstVerifyInBookRecord());
		       // bankReconObj.clickFirstVerifyInBookRecord().click();
		       // bankReconObj.clickYesInSelectButton().click();
		     //   driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[8]/div")).click();
		        javascriphelper.scrollIntoView(bankReconObj.clickFirstCheckboxInBookRecord());
		        bankReconObj.clickFirstCheckboxInBookRecord().click();
		        javascriphelper.scrollIntoView(bankReconObj.clickFirstCheckInBankStatement());
		        bankReconObj.clickFirstCheckInBankStatement().click();
		        bankReconObj.clickMatch().click();
		        
		    }
		  @And("^user unmatch the matched records in matched tabs$")
		    public void user_unmatch_the_matched_records_in_matched_tabs() throws Throwable {
		    	String xpath="//ion-grid[2]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div";
		        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
		        String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
		        //testdata.put("chequeno", ChequeNo);
		        excelData.updateTestData("KUBS_TAX_UAT_003_001TC_001_D1", "ChequeNo", ChequeNo);
		        System.out.println(ChequeNo);
		        javascriphelper.JavaScriptHelper(driver);
		       // javascriphelper.scrollIntoView(bankReconObj.clickFirstVerifyInBookRecord());
		       // bankReconObj.clickFirstVerifyInBookRecord().click();
		       // bankReconObj.clickYesInSelectButton().click();
		     //   driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[8]/div")).click();
		        javascriphelper.scrollIntoView(bankReconObj.clickFirstCheckboxInBookRecord());
		        bankReconObj.clickFirstCheckboxInBookRecord().click();
		        bankReconObj.clickUnmatch().click();
		    }
		  @Then("^user verify System must unmatch a matched record and now the both the records to be displayed on Unmatched Tab under Unmatched transactions from Bank statement and Books$")
		    public void user_verify_system_must_unmatch_a_matched_record_and_now_the_both_the_records_to_be_displayed_on_unmatched_tab_under_unmatched_transactions_from_bank_statement_and_books() throws Throwable {
				String xpath="//div[contains(text(),'"+testData.get("ChequeNo")+"')]";
		        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
		        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
		    }
		  @Then("^user verify Same records should not be displayed in Matched Tabs$")
		    public void user_verify_same_records_should_not_be_displayed_in_matched_tabs() throws Throwable {
				Thread.sleep(3000);
				String xpath="//div[contains(text(),'"+testData.get("unmatchedcheque")+"')]";
		    	//Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		    	try {
		    		driver.findElement(By.xpath(xpath)).isDisplayed();
					
				} catch (NoSuchElementException e) {
					System.out.println("User verified unmatched entry from bank side is not displyed in matched tab ");
				}
		    }
		  @And("^enter bank name and account number for text files$")
		    public void enter_bank_name_and_account_number_for_text_files() throws Throwable {
		    	waitHelper.waitForElementVisible(bankReconObject.BANKRECONBankName(), 3000, 300);
		    	bankReconObject.BANKRECONBankName().click();    	
		    	bankReconObject.BANKRECONBankName().sendKeys(testData.get("TextBankName"));    	
		    	bankReconObject.BANKRECONBankName().sendKeys(Keys.ENTER);
		    	bankReconObject.BANKRECONBAnkAccountNumber().click();
		    	Thread.sleep(1000);
		    	bankReconObject.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		    	bankReconObject.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
		    	
		    }
		  @And("^give the recon period from date for text files$")
		    public void give_the_recon_period_from_date_for_text_files() throws Throwable {
			  bankReconObject.BANKRECON_PeriodFromDate().click();
				while (true) {
					try {

						driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PeriodTextFromMonth1").substring(0, 3) + " "
										+ testData.get("PeriodTextFromYear1") + "')]"));
						break;
					} catch (NoSuchElementException e) {
						bankReconObject.calendarNextMonthButton().click();
					}
				}
				Thread.sleep(2000);
				clicksAndActionsHelper
						.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PeriodTextFromMonth1") + " "
								+ testData.get("PeriodTextFromdate1") + ", " + testData.get("PeriodTextFromYear1") + "']//span")));
		    }

		    @And("^give the recon period to date for text files$")
		    public void give_the_recon_period_to_date_for_text_files() throws Throwable {
		    	bankReconObject.BANKRECON_BankReconPeriodToDate().click();
				while (true) {
					try {

						driver.findElement(
								By.xpath("//span[contains(text(),'" + testData.get("PeriodTextToMonth1").substring(0, 3) + " "
										+ testData.get("PeriodTextToYear1") + "')]"));
						break;
					} catch (NoSuchElementException e) {
						bankReconObject.calendarNextMonthButton().click();
					}
				}
				Thread.sleep(2000);
				clicksAndActionsHelper
						.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + testData.get("PeriodTextToMonth1") + " "
								+ testData.get("PeriodTextToDate1") + ", " + testData.get("PeriodTextToYear1") + "']//span")));     
		    }   
	
	
	 @Then("^upload the text file for process$")
	    public void upload_the_text_file_for_process() throws Throwable {
	    	Thread.sleep(2000);
	    	//bankReconObject.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.textFilePath); 
	    }
	 @And("^give the recon period from date for text file for bank to book basis$")
	    public void give_the_recon_period_from_date_for_text_file_for_bank_to_book_basis() throws Throwable {
		 bankReconObject.BANKRECON_PeriodFromDate().click();
			while (true) {
				try {

//					driver.findElement(
//							By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth2.substring(0, 3) + " "
//									+ bankReconTestData.PeriodTextFromYear2 + "')]"));
					break;
				} catch (NoSuchElementException e) {
					bankReconObject.calendarNextMonthButton().click();
				}
			}
			Thread.sleep(2000);
//			clicksAndActionsHelper
//					.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth2 + " "
//							+ bankReconTestData.PeriodTextFromdate2 + ", " + bankReconTestData.PeriodTextFromYear2 + "']//span")));
	    }

	    @And("^give the recon period to date for text file for bank to book basiss$")
	    public void give_the_recon_period_to_date_for_text_file_for_bank_to_book_basis() throws Throwable {
	    	bankReconObject.BANKRECON_BankReconPeriodToDate().click();
			while (true) {
				try {

//					driver.findElement(
//							By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth2.substring(0, 3) + " "
//									+ bankReconTestData.PeriodTextToYear2 + "')]"));
					break;
				} catch (NoSuchElementException e) {
					bankReconObject.calendarNextMonthButton().click();
				}
			}
			Thread.sleep(2000);
//			clicksAndActionsHelper
//					.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth2 + " "
//							+ bankReconTestData.PeriodTextToDate2 + ", " + bankReconTestData.PeriodTextToYear2 + "']//span")));     
	    }
	   
}
}
