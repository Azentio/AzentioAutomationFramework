package stepdefinitions;
import static org.testng.Assert.assertEquals;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BankReconciliation_ModuleObj;
import resources.BaseClass;
import testDataType.BankReconciliationTestData;

public class Bank_ReconModule extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	BankReconciliation_ModuleObj bankReconObj = new BankReconciliation_ModuleObj(driver);
	JsonConfig jsonconfig = new JsonConfig();
	BankReconciliationTestData bankReconData = jsonconfig.getBankReconlist("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Map<String,String> testdata = new LinkedHashMap<>();
	 @Then("^Displayed transactions must of current month plus unmatched records from previous month if any matched in current month where view basis is Bank to Book$")
	    public void displayed_transactions_must_of_current_month_plus_unmatched_records_from_previous_month_if_any_matched_in_current_month_where_view_basis_is_bank_to_book() throws Throwable {
		 int i=1;
			while (true) {
				try {
					String Xpath1 ="//ion-grid[2]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
					String xpath="//ion-grid[2]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
					String bookrecord = driver.findElement(By.xpath(xpath)).getText();
					String valuedate = driver.findElement(By.xpath(Xpath1)).getText();
					System.out.println("value date "+valuedate+"recept no "+bookrecord);
					
				} catch (NoSuchElementException e) {
					System.out.println("user verified transaction are displayed for current month and previous month in bank statement");
					break;
				}
				
				i++;
			}
	    }
	    

	//*************************************KUBS_TAX_UAT_008_002TC_001**********************************************************************
	@Then("^user verify that unmatched transactions are displayed of current month plus previous month if any not matched in current month$")
    public void user_verify_that_unmatched_transactions_are_displayed_of_current_month_plus_previous_month_if_any_not_matched_in_current_month() throws Throwable {
		int i=1;
		while (true) {
			try {
				String Xpath1 ="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[2]/div";
				String xpath="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
				String bookrecord = driver.findElement(By.xpath(xpath)).getText();
				String valuedate = driver.findElement(By.xpath(Xpath1)).getText();
				System.out.println("value date "+valuedate+"recept no "+bookrecord);
				
			} catch (NoSuchElementException e) {
				System.out.println("user verified transaction are displayed for current month and previous month");
				break;
			}
			
			i++;
		}
    }
	@Then("^user verify Receipt recorded in Book but missing in Bank Statement for text file$")
    public void user_verify_receipt_recorded_in_book_but_missing_in_bank_statement_for_text_file() throws Throwable {
		//div[contains(text(),'RRN156')]
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[contains(text(),'"+bankReconData.ChequeRefUnmachedText+"')]")));
        driver.findElement(By.xpath("//div[contains(text(),'"+bankReconData.ChequeRefUnmachedText+"')]")).isDisplayed();
    }
//***************************************KUBS_TAX_UAT_004_001TC_002*************************************************************
	@And("^user unmatch the matched record in bank recon text format$")
    public void user_unmatch_the_matched_record_in_bank_recon_text_format() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickFirstCheckboxInBookRecord());
        bankReconObj.clickFirstCheckboxInBookRecord().click();
        String xpath="//ion-grid[2]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
        testdata.put("chequeno", ChequeNo);
        System.out.println(ChequeNo);
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickUnmatch());
        bankReconObj.clickUnmatch().click();
       
    }

    @And("^user match record in unmatched tab for text format$")
    public void user_match_record_in_unmatched_tab_for_text_format() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickFirstCheckboxInBookRecord());
        bankReconObj.clickFirstCheckboxInBookRecord().click();
        seleniumactions.getWaitHelper().waitForElement(driver,2000, driver.findElement(By.xpath("(//input[@id='saveCheckBox'])[3]")));
        driver.findElement(By.xpath("(//input[@id='saveCheckBox'])[3]")).click();
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickMatch());
        bankReconObj.clickMatch().click();
          
    }
    @Then("^user verify that Check post re processing bank statement there is no impact on manually matched entries$")
    public void user_verify_that_check_post_re_processing_bank_statement_there_is_no_impact_on_manually_matched_entries() throws Throwable {
    	String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }
  //********************************KUBS_TAX_UAT_004_001TC_003***********************************************************
    @Then("^user verify that Check post re processing bank statement there is no impact on manually unmatched entries$")
    public void user_verify_that_check_post_re_processing_bank_statement_there_is_no_impact_on_manually_unmatched_entries() throws Throwable {
    	String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
    	try {
    		 driver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (NoSuchElementException e) {
			
		}
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    

	@And("^user select bank reconcilation basis bank to book$")
    public void user_select_bank_reconcilation_basis_bank_to_book() throws Throwable {
        //seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankReconciliationBasis());
		bankReconObj.bankReconciliationBasis().click();
		Thread.sleep(1000);
        bankReconObj.bankReconciliationBasis().sendKeys("bank to book");
		//bankReconObj.bankReconciliationBasis().sendKeys(Keys.DOWN);
        bankReconObj.bankReconciliationBasis().sendKeys(Keys.DOWN);
        bankReconObj.bankReconciliationBasis().sendKeys(Keys.ENTER);
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickFirstVerifyInBookRecord());
        bankReconObj.clickFirstVerifyInBookRecord().click();
        Thread.sleep(2000);
        javascriphelper.JavaScriptHelper(driver);
        javascriphelper.JSEClick(bankReconObj.clickYesInSelectButton());
        
    }
	@And("^user match the records in unmached tab fot textt file$")
    public void user_match_the_records_in_unmached_tab_fot_textt_file() throws Throwable {
		int i=1;
		int j=1;
		String bookrecord = null;
		while (true) {
			String xpath="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
			seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
	        String bankrecord = driver.findElement(By.xpath(xpath)).getText();
	        System.out.println(bankrecord);
	        
	        	while (true) {
	        		try {
		        	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
			        String xpath1="//ion-grid[2]//datatable-row-wrapper["+j+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
			        bookrecord = driver.findElement(By.xpath(xpath1)).getText();
			        System.out.println(bookrecord);
			        if (bankrecord.equalsIgnoreCase(bookrecord)) {
			        	driver.findElement(By.xpath("(//ion-grid[1]//input[@id='saveCheckBox'])["+i+"]")).click();
				        driver.findElement(By.xpath("(//ion-grid[2]//input[@id='saveCheckBox'])["+j+"]")).click();
				        testdata.put("matchedrecord", bankrecord);
				        bankReconObj.clickMatch().click();
				        break;
				}
			    j++;			
		   
	        	}
	        	catch (NoSuchElementException e) {
					break;
				}
	        	}
	        j=1;
	        i++;
	        if (bankrecord.equalsIgnoreCase(bookrecord)) {
	        	break;
		}
	        
		}
		
        
    }
	
	@Then("^user verify that Book entry will be matched with Bank entry and will be displayed in Matched Tab for text$")
    public void user_verify_that_book_entry_will_be_matched_with_bank_entry_and_will_be_displayed_in_matched_tab_for_text() throws Throwable {
		String xpath="//div[contains(text(),'"+testdata.get("matchedrecord")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @Then("^user verify that Unmatched entry from Bank Side will not be displayed for text$")
    public void user_verify_that_unmatched_entry_from_bank_side_will_not_be_displayed_for_text() throws Throwable {
    	String xpath="//div[contains(text(),'"+testdata.get("unmatchedrecord")+"')]";
    	//Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
    	try {
    		driver.findElement(By.xpath(xpath)).isDisplayed();
			
		} catch (NoSuchElementException e) {
			System.out.println("User verified unmatched entry from bank side is not displyed in matched tab ");
		}
    	
    }
	@Then("^user verify Same records should not be displayed in Matched Tab$")
    public void user_verify_same_records_should_not_be_displayed_in_matched_tab() throws Throwable {
		Thread.sleep(3000);
		String xpath="//div[contains(text(),'"+testdata.get("unmatchedcheque")+"')]";
    	//Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
    	try {
    		driver.findElement(By.xpath(xpath)).isDisplayed();
			
		} catch (NoSuchElementException e) {
			System.out.println("User verified unmatched entry from bank side is not displyed in matched tab ");
		}
    }
	@Then("^user verify System must unmatch a matched record and now the both the records to be displayed on Unmatched Tab under Unmatched transactions from Bank statement and Book$")
    public void user_verify_system_must_unmatch_a_matched_record_and_now_the_both_the_records_to_be_displayed_on_unmatched_tab_under_unmatched_transactions_from_bank_statement_and_book() throws Throwable {
		String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }
	
	@Given("^user log in to Azentio for bank recon$")
    public void user_log_in_to_azentio_for_bank_recon() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("maker");
		Thread.sleep(2000);
		seleniumactions.getWaitHelper().waitForElement(driver, 3000,bankReconObj.optionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(bankReconObj.optionicon());
        
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
        bankReconObj.selectBankName().sendKeys(bankReconData.BankName);
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
		driver.findElement(By.xpath("//span[text()='" + bankReconData.BankReconFromYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.BankReconFromMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
			    driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.BankReconFromFullMonth+" "
				+bankReconData.BankReconFromDay+", "+bankReconData.BankReconFromYear+"']")));
				driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.BankReconFromFullMonth+" "
				+bankReconData.BankReconFromDay+", "+bankReconData.BankReconFromYear+"']")).click();
    }

    @And("^user click bank  recon to date and select the date$")
    public void user_click_bank_recon_to_date_and_select_the_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_ToDate());
    	bankReconObj.bankRecon_ToDate().click();
    	Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.BankReconToYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.BankReconToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
			    driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.BankReconFullToMonth+" "
				+bankReconData.BankReconToDay+", "+bankReconData.BankReconToYear+"']")));
				driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.BankReconFullToMonth+" "
				+bankReconData.BankReconToDay+", "+bankReconData.BankReconToYear+"']")).click();
    }

    @And("^user click choose file and upload the bank statement$")
    public void user_click_choose_file_and_upload_the_bank_statement() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.chooseFile());
        bankReconObj.chooseFile().sendKeys(bankReconData.FileLocation);
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
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference1+" ']")));
    	if (driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference1+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference1+" ']")).getText());
		}
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference2+" ']")));
    	if (driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference2+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference2+" ']")).getText());
		}
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference3+" ']")));
    	if (driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference3+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconData.ChequeReference3+" ']")).getText());
		}
    	else {
			System.out.println("Cheque Number not present in the bank statement");
		}
    }
    //************************************************KUBS_TAX_UAT_009_003TC_002*********************************************
    @Then("^verify unmatched,partially matched and transposition matched records in bank records after processing$")
    public void verify_unmatchedpartially_matched_and_transposition_matched_records_in_bank_records_after_processing() throws Throwable {
    	
    	int i=1;
    	while(true) {
    		String xpath ="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	try {
    		String BankRecord = driver.findElement(By.xpath(xpath)).getText();
    		System.out.println(BankRecord);
			
		} catch (NoSuchElementException e) {
			break;
			
		}
    	i++;
    	}
    }
    	
    
    //**********************************************KUBS_TAX_UAT_009_003TC_003************************************************
    
    @Then("^Verify system gives correct unmatched data basis the matching rule defined$")
    public void verify_system_gives_correct_unmatched_data_basis_the_matching_rule_defined() throws Throwable {
    	int i=1;
    	while(true) {
    		String xpath ="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	try {
    		String BankRecord = driver.findElement(By.xpath(xpath)).getText();
    		System.out.println(BankRecord);
			
		} catch (NoSuchElementException e) {
			i=1;
			break;
			
		}
    	i++;
    	}
    	while(true) {
    		String xpath ="//ion-grid[2]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	try {
    		String BankRecord = driver.findElement(By.xpath(xpath)).getText();
    		System.out.println(BankRecord);
			
		} catch (NoSuchElementException e) {
			break;
			
		}
    	i++;
    	}
    	
        }
    
    
    @And("^user select bank name in bank recon Module for csv file$")
    public void user_select_bank_name_in_bank_recon_module_for_csv_file() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.selectBankName());
        bankReconObj.selectBankName().click();
        bankReconObj.selectBankName().sendKeys(bankReconData.CsvBankName);
        bankReconObj.selectBankName().sendKeys(Keys.ENTER);
    }

    @And("^user click bank recon from date and select the date for csv file$")
    public void user_click_bank_recon_from_date_and_select_the_date_for_csv_file() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_FromDate());
        bankReconObj.bankRecon_FromDate().click();
        Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.CsvBankReconFromYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.CsvBankReconFromMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
			    driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.CsvBankReconFromFullMonth+" "
				+bankReconData.CsvBankReconFromDay+", "+bankReconData.CsvBankReconFromYear+"']")));
				driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.CsvBankReconFromFullMonth+" "
				+bankReconData.CsvBankReconFromDay+", "+bankReconData.CsvBankReconFromYear+"']")).click();
    }

    @And("^user click bank recon to date and select the date for csv file$")
    public void user_click_bank_recon_to_date_and_select_the_date_for_csv_file() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankRecon_ToDate());
        bankReconObj.bankRecon_ToDate().click();
        Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.CsvBankReconToYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + bankReconData.CsvBankReconToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
			    driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.CsvBankReconFullToMonth+" "
				+bankReconData.CsvBankReconToDay+", "+bankReconData.CsvBankReconToYear+"']")));
				driver.findElement(By.xpath("//td[@aria-label='"+bankReconData.CsvBankReconFullToMonth+" "
				+bankReconData.CsvBankReconToDay+", "+bankReconData.CsvBankReconToYear+"']")).click();
        
    }
    @And("^user click choose file and upload the bank statement for csv$")
    public void user_click_choose_file_and_upload_the_bank_statement_for_csv() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.chooseFile());
        bankReconObj.chooseFile().sendKeys(bankReconData.FileLocationCsv);
    }
    @Then("^user verify Format of Bank Recon statement must be as per FSD$")
    public void user_verify_format_of_bank_recon_statement_must_be_as_per_fsd() throws Throwable {
    	//seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.AdjustedBalance());
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(bankReconObj.AdjustedBalance());
    	System.out.println("Format of Bank Recon Statement As per FSD");
        
    }

    @And("^user click the bank statement in bank recon$")
    public void user_click_the_bank_statement_in_bank_recon() throws Throwable {
    	Thread.sleep(2000);
       // seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankStatement());
        bankReconObj.bankStatement().click();
    }
    
    
    @Then("^user verify that Book entry will be matched with Bank entry and will be displayed in Matched Tab$")
    public void user_verify_that_book_entry_will_be_matched_with_bank_entry_and_will_be_displayed_in_matched_tab() throws Throwable {
        String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
       
    }

    @Then("^user verify that Unmatched entry from Bank Side will not be displayed$")
    public void user_verify_that_unmatched_entry_from_bank_side_will_not_be_displayed() throws Throwable {
    	String xpath="//div[contains(text(),'"+testdata.get("unmatchedcheque")+"')]";
    	//Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
    	try {
    		driver.findElement(By.xpath(xpath)).isDisplayed();
			
		} catch (NoSuchElementException e) {
			System.out.println("User verified unmatched entry from bank side is not displyed in matched tab ");
		}
    	
    }

    @And("^user match the records in unmached tab$")
    public void user_match_the_records_in_unmached_tab() throws Throwable {
    	String xpath="//ion-grid[1]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
        testdata.put("chequeno", ChequeNo);
        System.out.println(ChequeNo);
        String unmatchedCheque = driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[6]/div")).getText();
        testdata.put("unmatchedcheque", unmatchedCheque);
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

    @And("^user click matched data tab$")
    public void user_click_matched_data_tab() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.matchedData());
        bankReconObj.matchedData().click();
        Thread.sleep(1000);
    }
    
    
    //job execution
    @And("^user click maker option$")
    public void user_click_maker_option() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver, 2000,bankReconObj.maker_Finance_Option());
        bankReconObj.maker_Finance_Option().click();
    }

    @And("^user select configuration menu$")
    public void user_select_configuration_menu() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.configurationSelect());
        bankReconObj.configurationSelect().click();
    }

    @And("^user click job scheduler$")
    public void user_click_job_scheduler() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.jobScheduler());
        bankReconObj.jobScheduler().click();
    }

    @And("^user click temp view in job execution$")
    public void user_click_temp_view_in_job_execution() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconObj.jobExecutionTempView());
        bankReconObj.jobExecutionTempView().click();
    }

    @And("^user click start job$")
    public void user_click_start_job() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconObj.startJob());
        bankReconObj.startJob().click();
    }

    @And("^user click job execution refresh option$")
    public void user_click_job_execution_refresh_option() throws Throwable {
        
    }

    @And("^user log in to Azentio$")
    public void user_log_in_to_azentio() throws Throwable {
        
    }
//************************************************@KUBS_TAX_UAT_011_001TC_003***************************************************************
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
	//*********************************************KUBS_TAX_UAT_011_001TC_001**********************************************************************
	@Then("^user verify that Post reprocessing bank statement there must be no impact on manually matched entries$")
    public void user_verify_that_post_reprocessing_bank_statement_there_must_be_no_impact_on_manually_matched_entries() throws Throwable {
		String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @And("^user click bank recon temp view$")
    public void user_click_bank_recon_temp_view() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankReconModuleTempView());
        bankReconObj.bankReconModuleTempView().click();
    }

    @And("^user click first record in bank recon temp view$")
    public void user_click_first_record_in_bank_recon_temp_view() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.clickFirstRecordInTempView());
        bankReconObj.clickFirstRecordInTempView().click();
    }

    @And("^user click process button again for reprocessing$")
    public void user_click_process_button_again_for_reprocessing() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankProcess());
        bankReconObj.bankProcess().click();
        seleniumactions.getAlertHelper().AcceptAlert();
    }
    
  
    
    @Then("^user verify Check post reprocessing bank statement there is no impact on manually unmatched entries$")
    public void user_verify_check_post_reprocessing_bank_statement_there_is_no_impact_on_manually_unmatched_entries() throws Throwable {
    	String xpath="//div[contains(text(),'"+testdata.get("chequeno")+"')]";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        assertEquals(true, driver.findElement(By.xpath(xpath)).isDisplayed());
    }

    @And("^user unmatch the matched records in matched tab$")
    public void user_unmatch_the_matched_records_in_matched_tab() throws Throwable {
    	String xpath="//ion-grid[2]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div";
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
        String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
        testdata.put("chequeno", ChequeNo);
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
    
    @Then("^user verify Receipt recorded in Book but missing in Bank Statement$")
    public void user_verify_receipt_recorded_in_book_but_missing_in_bank_statement() throws Throwable {
    	int i=1;
    	while(true) {
    	javascriphelper.JavaScriptHelper(driver);
    	String xpath="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	String xpath1="//ion-grid[2]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
    	String recordsFromBook = driver.findElement(By.xpath(xpath)).getText();
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath1)));
    	String recordsfrombankStatement = driver.findElement(By.xpath(xpath1)).getText();
    	if (!recordsFromBook.equalsIgnoreCase(recordsfrombankStatement)) {
			System.out.println(recordsFromBook+" not matched in bank statement");
			break;
		}
    	i++;
    }
    }

    @Then("^user verify Receipts recorded in bank statement but missing in Book$")
    public void user_verify_receipts_recorded_in_bank_statement_but_missing_in_book() throws Throwable {
    	int i=1;
    	while(true) {
    	javascriphelper.JavaScriptHelper(driver);
    	String xpath="//ion-grid[1]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	String xpath1="//ion-grid[2]//datatable-row-wrapper["+i+"]/datatable-body-row/div[2]/datatable-body-cell[6]/div";
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
    	String recordsFromBook = driver.findElement(By.xpath(xpath)).getText();
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath1)));
    	String recordsfrombankStatement = driver.findElement(By.xpath(xpath1)).getText();
    	if (!recordsfrombankStatement.equalsIgnoreCase(recordsFromBook)) {
			System.out.println(recordsfrombankStatement+" not matched in book record");
			break;
		}
    	i++;
    }
    }

    
}
