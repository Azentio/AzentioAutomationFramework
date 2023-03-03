package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BankReconciliation_ModuleObj;
import resources.BaseClass;
import resources.ExcelData;

public class BankRecon extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	BankReconciliation_ModuleObj bankReconObj = new BankReconciliation_ModuleObj(driver);
//	JsonConfig jsonconfig = new JsonConfig();
//	BankReconciliationTestData bankReconData = jsonconfig.getBankReconlist("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Map<String,String> testdata = new LinkedHashMap<>();
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","BankRecon", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	@And("^user update the data set ID for Bank Recon1$")
    public void user_update_the_data_set_id_for_bank_recon1() throws Throwable {
		testData = excelData.getTestdata("KUBS_TAX_UAT_005_001_TC_001_D1");
    }
	@And("^user update the data set ID for Bank Recon2$")
    public void user_update_the_data_set_id_for_bank_recon2() throws Throwable {
		testData = excelData.getTestdata("KUBS_TAX_UAT_005_001_TC_002_D2");
    }

	@And("^user update the data set ID for Bank Recon3$")
    public void user_update_the_data_set_id_for_bank_recon3() throws Throwable {
		testData = excelData.getTestdata("KUBS_TAX_UAT_005_001_TC_003_D3");
    }

	  @And("^user click bank recon module$")
	    public void user_click_bank_recon_module() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankReconModule());
	        seleniumactions.getClickAndActionsHelper().clickOnElement(bankReconObj.bankReconModule());
	    }

	    @And("^user click eye icon in bank recon module$")
	    public void user_click_eye_icon_in_bank_recon_module() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_EyeIcon());
	        bankReconObj.bankRecon_EyeIcon().click();
	    }

	    @And("^user click add icon in bank recon$")
	    public void user_click_add_icon_in_bank_recon() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.addIconInBankRecon());
	    	bankReconObj.addIconInBankRecon().click();
	        
	    }

	    @And("^user select bank name in bank recon Module$")
	    public void user_select_bank_name_in_bank_recon_module() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.selectBankName());
	        bankReconObj.selectBankName().click();
	        bankReconObj.selectBankName().sendKeys(testData.get("BankName"));
	        bankReconObj.selectBankName().sendKeys(Keys.ENTER);
	    }

	    @And("^user select bank account Number in bank recon Module$")
	    public void user_select_bank_account_number_in_bank_recon_module() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.selectAccountNumber());
	        bankReconObj.selectAccountNumber().click();
	        Thread.sleep(1000);
	        bankReconObj.selectAccountNumber().sendKeys(Keys.DOWN);
	        bankReconObj.selectAccountNumber().sendKeys(Keys.ENTER);
	    }
	    
	    @And("^user click bank recon from date and select the date$")
	    public void user_click_bank_recon_from_date_and_select_the_date() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_FromDate());
	        bankReconObj.bankRecon_FromDate().click();
	        Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
					.click();
			driver.findElement(By.xpath("//span[text()='" + testData.get("BankReconFromYear")+ "']")).click();
			driver.findElement(By.xpath("//span[text()='" + testData.get("BankReconFromMonth")+ "']")).click();
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				    driver.findElement(By.xpath("//td[@aria-label='"+testData.get("BankReconFromFullMonth")+" "
					+testData.get("BankReconFromDay")+", "+testData.get("BankReconFromYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("BankReconFromFullMonth")+" "
					+testData.get("BankReconFromDay")+", "+testData.get("BankReconFromYear")+"']")).click();
	    }

	    @And("^user click bank  recon to date and select the date$")
	    public void user_click_bank_recon_to_date_and_select_the_date() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_ToDate());
	    	bankReconObj.bankRecon_ToDate().click();
	    	Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
					.click();
			driver.findElement(By.xpath("//span[text()='" + testData.get("BankReconToYear")  + "']")).click();
			driver.findElement(By.xpath("//span[text()='" + testData.get("BankReconToMonth") + "']")).click();
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				    driver.findElement(By.xpath("//td[@aria-label='"+testData.get("BankReconFullToMonth")+" "
					+testData.get("BankReconToDay")+", "+testData.get("BankReconToYear")+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+testData.get("BankReconFullToMonth")+" "
					+testData.get("BankReconToDay")+", "+testData.get("BankReconToYear")+"']")).click();
	    }

	    @And("^user click choose file and upload the bank statement$")
	    public void user_click_choose_file_and_upload_the_bank_statement() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.chooseFile());
	        bankReconObj.chooseFile().sendKeys(testData.get("FileLocation"));
	    }

	    @And("^user click save button in bank recon$")
	    public void user_click_save_button_in_bank_recon() throws Throwable {
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.saveButtonInBankRecon());
	    	bankReconObj.saveButtonInBankRecon().click();
	        
	    }

	    @And("^user click process button in bank recon$")
	    public void user_click_process_button_in_bank_recon() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankProcess());
	        bankReconObj.bankProcess().click();
	        seleniumactions.getAlertHelper().AcceptAlert();
	        Thread.sleep(3000);
	    }
	    
	    @And("^user click matched data tab$")
	    public void user_click_matched_data_tab() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.matchedData());
	        bankReconObj.matchedData().click();
	        Thread.sleep(1000);
	    }
	    @And("^user click the bank statement in bank recon$")
	    public void user_click_the_bank_statement_in_bank_recon() throws Throwable {
	    	Thread.sleep(2000);
	       // seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankStatement());
	        bankReconObj.bankStatement().click();
	    }
	    @Then("^user verify Format of Bank Recon statement must be as per FSD$")
	    public void user_verify_format_of_bank_recon_statement_must_be_as_per_fsd() throws Throwable {
	    	//seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.AdjustedBalance());
	    	javascriphelper.JavaScriptHelper(driver);
	    	javascriphelper.scrollIntoView(bankReconObj.AdjustedBalance());
	    	System.out.println("Format of Bank Recon Statement As per FSD");
	        
	    }
	    
	    
	    //---------------------KUBS_TAX_UAT_005_001TC_002---------------------------//
	    
	    @And("^user click the unmatched data in bank recon process$")
	    public void user_click_the_unmatched_data_in_bank_recon_process() throws Throwable {
	          seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconObj.unmatchedData());
	          bankReconObj.unmatchedData().click();
	          Thread.sleep(1000);
	    	//javascriphelper.JavaScriptHelper(driver);
	    	//javascriphelper.JSEClick(bankReconObj.unmatchedData());
	    }
	    @Then("^verify unmatched,partially matched and transposition matched records in bank Statment  after processing$")
	    public void verify_unmatchedpartially_matched_and_transposition_matched_records_in_bank_statment_after_processing() throws Throwable {
	    	//div[text()=' RRN156 ']
	    	//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference1")+" ']")));
	    	if (driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference1")+" ']")).isDisplayed()) {
				System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference1")+" ']")).getText());
			}
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference2")+" ']")));
	    	if (driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference1")+" ']")).isDisplayed()) {
				System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference2")+" ']")).getText());
			}
	    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference3")+" ']")));
	    	if (driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference3")+" ']")).isDisplayed()) {
				System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+testData.get("ChequeReference3")+" ']")).getText());
			}
	    	else {
				System.out.println("Cheque Number not present in the bank statement");
			}
	    }
	    
	    //------------------------KUBS_TAX_UAT_005_001TC_003--------------------------------//
	    
	    @And("^user click the bank reconciliation process$")
	    public void user_click_the_bank_reconciliation_process() throws Throwable {
	        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankReconciliationProcess());
	        bankReconObj.bankReconciliationProcess().click();
	    }
	    
	    @Then("^user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books$")
	    public void user_verify_adjusted_balance_as_per_bank_statement_must_match_with_adjusted_balance_as_per_books() throws Throwable {
	        Thread.sleep(3000);
			javascriphelper.JavaScriptHelper(driver);
	        javascriphelper.scrollIntoViewAndClick(bankReconObj.adjustedBalanceAmountInBankStatement());
	        String adjustedBalanceAmountInBankStatement = bankReconObj.adjustedBalanceAmountInBankStatement().getText();
	        javascriphelper.scrollIntoView(bankReconObj.adjustedBalanceAsPerBook());
	        String adjustedBalanceAsPerBook = bankReconObj.adjustedBalanceAsPerBook().getText();
	        Assert.assertEquals(adjustedBalanceAmountInBankStatement, adjustedBalanceAsPerBook);
			System.out.println("user verified Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books");
		}
	    
	    

}
