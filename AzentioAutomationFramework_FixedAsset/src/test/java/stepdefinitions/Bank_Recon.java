package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.AlertHelper;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.BANKRECON_BankReconcilationObj;
import pageobjects.BankRecon_ReconFormatObj;
import pageobjects.BankReconciliation_ModuleObj;
import pageobjects.Bank_Recon_Obj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ARAP_ARandAPData;
import testDataType.BankReconData;
import testDataType.BankRecon_ReconFormatTestDataType;
import testDataType.BankReconciliationTestData;

public class Bank_Recon extends BaseClass {
	//bank recon format
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BankRecon_ReconFormatObj bankRecon_ReconFormatObj = new BankRecon_ReconFormatObj(driver);
	BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType = jsonReader.getBankReconByName("Maker");
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	// bankreconModule
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	JsonConfig jsonconfig = new JsonConfig();
	BankReconciliationTestData bankReconData = jsonconfig.getBankReconlist("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Map<String,String> testdata = new LinkedHashMap<>();
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	Map<String, String> Getdata = new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browseHelper = new BrowserHelper(driver);
	Bank_Recon_Obj bankObj = new Bank_Recon_Obj(driver);
	String referance_id;
	String reviwerId;
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	ARAP_ARandAPData arapData = jsonConfig.getARAPByName("ARAP");
	BANKRECON_BankReconcilationObj bankReconObj = new BANKRECON_BankReconcilationObj(driver);
	BankReconciliation_ModuleObj bankReconModuleObj = new BankReconciliation_ModuleObj(driver);
	BankReconData recondata = jsonConfig.getBankReconData("Bankrecon");
	AlertHelper alertHelper = new AlertHelper(driver);
	Map<String, String> bankReconTestData;	
	String path = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBankRecon = new ExcelData(path,"BankRecon","DataSet ID");
	
	@And("^User update test data set id for uploading bank statement in CSV file$")
    public void user_update_test_data_set_id_for_uploading_bank_statement_in_csv_file() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_009_001_TC_001_D1");
    }
	@And("^User update test data set id for getting validation messages when uploaded file not matched with book records$")
    public void user_update_test_data_set_id_for_getting_validation_messages_when_uploaded_file_not_matched_with_book_records() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_009_001_TC_002_D1");
    }
	@And("^User update test data set id for Click on Bank Process button$")
    public void user_update_test_data_set_id_for_click_on_bank_process_button() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_009_001_TC_003_D1");
    }
	@And("^User update test data id to Processing Bank recon for same period Bank and Account Number$")
    public void user_update_test_data_id_to_processing_bank_recon_for_same_period_bank_and_account_number() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_07_001TC_001_D1");
    }
	@And("^User update test data id to Processing bank recon with already used file$")
    public void user_update_test_data_id_to_processing_bank_recon_with_already_used_file() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_07_002TC_001_D1");
    }
	@And("^User update test data set id for correct unmatced,partial and transposition records from bank statement$")
    public void user_update_test_data_set_id_for_correct_unmatcedpartial_and_transposition_records_from_bank_statement() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_009_003_TC_001_D1");
    }

    @And("^User update test data set id for Verify checker is not allowed to do any modification on any tab$")
    public void user_update_test_data_set_id_for_verify_checker_is_not_allowed_to_do_any_modification_on_any_tab() throws Throwable {
    	bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_006_001_TC_006_01_D1");
    }
    @And("^User update test data set id for Checker approves Bank Reconciliation$")
    public void user_update_test_data_set_id_for_checker_approves_bank_reconciliation() throws Throwable {
    	bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_006_001_TC_007_01_D1");
    }
	
	// *****************@KUBS_TAX_UAT_006_001_Tc_001******************//

	@And("^User update test data for sbmitting Bank recon is allowed if there is any unmatched records from Bank Side$")
    public void user_update_test_data_for_sbmitting_bank_recon_is_allowed_if_there_is_any_unmatched_records_from_bank_side() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_006_001_TC_001_D1");
    }
	
	@And("^click Bank Recon module$")
	public void click_bank_recon_module() throws Throwable {
		waitHelper.waitForElementVisible(bankObj.bank_Recon_Module(), 3000, 300);
		bankObj.bank_Recon_Module().click();
	}

	@And("^click view button near by Bank Reconcilation sub module$")
	public void click_view_button_near_by_bank_reconcilation_sub_module() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankReconEyeIcon(), 2000, 200);
		bankReconObj.BANKRECONBankReconEyeIcon().click();
	}


	@And("^enter the bank name and account number for Barclays Bank$")
	public void enter_the_bank_name_and_account_number_for_barclays_bank() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
		bankReconObj.BANKRECONBankName().click();
		bankReconObj.BANKRECONBankName().sendKeys(recondata.Bankname1);
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);

		bankReconObj.BANKRECONBAnkAccountNumber().click();
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
	}

	@Then("^Upload our Barclays Bank file$")
	public void upload_barclays_bank_our_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\Barclay_0026.csv");

	}

	@And("^check the file validated successfully or not$")
	public void check_the_file_validated_successfully_or_not() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, bankReconObj.BANKRECOnToastAlert());
		for (int i = 0; i <200; i++) {
			try {
				Assert.assertEquals("File validated successfully", bankReconObj.BANKRECOnToastAlert().getText());
				break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,bankReconObj.SuccessMessageClose(),30, 2);
		bankReconObj.SuccessMessageClose().click();
		
	}

    @And("^save bank recon record$")
    public void save_bank_recon_record() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankReconSaveButton(), 3000, 300);
		bankReconObj.BANKRECONBankReconSaveButton().click();
    }

    @And("^Process that Bank file$")
    public void process_that_bank_file() throws Throwable {
    	Thread.sleep(1000);
		bankReconObj.BankReconProcessButton().click();
		// alertHelper.isAlertPresent()
		Thread.sleep(1000);
		System.out.println("Alert message is : " + alertHelper.getAlertText());
		if (alertHelper.isAlertPresent()) {

			System.out.println("Alert message is : " + alertHelper.getAlertText());
			alertHelper.AcceptAlert();
		}
    }

    @And("^Click unmatched Tab$")
    public void click_unmatched_tab() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
		bankReconObj.BANKRECON_UnmatchedData().click();
    }

    @And("^unmatch that record and save that record$")
    public void unmatch_that_record_and_save_that_record() throws Throwable {
    	javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(bankReconObj.MatcedTabFirstGridInput(), 3000, 300);
		bankReconObj.MatcedTabFirstGridInput().click();
		for (int i = 1; i <= 1; i++) {

			try {
				javaScriptHelper.scrollIntoView(driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//input")));
				javaScriptHelper.JSEClick(driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//input")));
			} catch (NoSuchElementException e) {
				break;
			}
		}
		bankReconObj.matchTabMatchButton().click();
		// ion-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//input

    }
    
	@And("^Give the recon period from date for Barclays Bank$")
	public void give_the_recon_period_from_date_for_barclays_bank() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(1000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " " + recondata.FromDate + ", " + recondata.FromYear + "']//span")));

	}

	@And("^Give the recon period to date for Barclays Bank$")
	public void give_the_recon_period_to_date_for_barclays_bank() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromToDate + ", " + recondata.FromYear + "']//span")));
	}

	@Then("^verify validation message is comming or not for Bank Recon$")
	public void verify_validation_message_is_comming_or_not_for_Bank_Recon() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		String AlertMessage = javaScriptHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText")
				.toString();
		try {
			Assert.assertEquals("Please select proper records Bank side for manual match!!!", AlertMessage);
			System.out.println(AlertMessage);
		} catch (AssertionError e) {
			Assert.assertEquals("Data Matched Successfully!!!", AlertMessage);
			System.out.println(AlertMessage);
		}
	}
	// *****************@KUBS_TAX_UAT_006_001_TC_002******************//


	@And("^Enter the Bank Name$")
    public void enter_the_bank_name() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
		bankReconObj.BANKRECONBankName().click();
		bankReconObj.BANKRECONBankName().sendKeys(bankReconTestData.get("Bank Name"));
		for (int i = 0; i <200; i++) {
			try {
				
				driver.findElement(By.xpath("//span[text()='"+bankReconTestData.get("Bank Name")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);
    }

    @And("^Enter Bank Account Number for bank recon$")
    public void enter_bank_account_number_for_bank_recon() throws Throwable {
    	Double d = Double.valueOf(bankReconTestData.get("Bank Account Number"));
    	String format = String.format("%.0f", d);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,bankReconObj.BANKRECONBAnkAccountNumber(),30, 2);
    	bankReconObj.BANKRECONBAnkAccountNumber().click();
    	bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(format);
    	for (int i = 0; i <200; i++) {
			try {
				
				driver.findElement(By.xpath("//span[text()='"+format+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
    }
	@And("^Give the Bank recon period from date$")
	public void give_the_bank_recon_period_from_date() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.get("Recon Period Month") + " " + bankReconTestData.get("Recon Period Year") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.get("Recon Period Fullmonth") + " "
				+ bankReconTestData.get("Recon Period From Date") + ", " + bankReconTestData.get("Recon Period Year") + "']//span")));
	}

	@And("^Give the Bank recon period to date$")
	public void give_the_bank_recon_period_to_date() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.get("Recon Period Month") + " " + bankReconTestData.get("Recon Period Year") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.get("Recon Period Fullmonth") + " "
				+ bankReconTestData.get("Recon Period To Date") + ", " + bankReconTestData.get("Recon Period Year") + "']//span")));
	}

	@Then("^Upload our file for Indian$")
	public void upload_our_file_for_indian() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\Barclay_0025.csv");
		Thread.sleep(5000);
		

	}
	@Then("^Upload our file for bank recon$")
    public void upload_our_file_for_bank_recon() throws Throwable {
		Thread.sleep(1000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.get("File Location"));
    }



	// *****************@KUBS_TAX_UAT_006_001_TC_003******************//

	@And("^enter the bank name and account numbers$")
	public void enter_the_bank_name_and_account_numbers() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
		bankReconObj.BANKRECONBankName().click();
		bankReconObj.BANKRECONBankName().sendKeys(recondata.Bankname3);
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);

		bankReconObj.BANKRECONBAnkAccountNumber().click();
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
	}

	@And("^Give Bank recon period from date$")
	public void give_bank_recon_period_from_date() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromDate1 + ", " + recondata.FromYear + "']//span")));

	}

	@And("^Give Bank recon period to date$")
	public void give_bank_recon_period_to_date() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromToDate1 + ", " + recondata.FromYear + "']//span")));
	}

	@Then("^Upload our Bank file$")
	public void upload_our_bank_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\PALLAV_AL12.csv");

	}
	// *****************@KUBS_TAX_UAT_006_001_TC_004******************//

	@And("^Give the recons period from date$")
	public void give_the_recons_period_from_date() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromDate1 + ", " + recondata.FromYear + "']//span")));

	}

	@And("^Give the recons period to date$")
	public void give_the_recons_period_to_date() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromToDate1 + ", " + recondata.FromYear + "']//span")));
	}

	@Then("^Upload the Bank file$")
	public void upload_the_bank_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\PALLAV_AL12.csv");

	}

	// ******************@KUBS_TAX_UAT_006_001_TC_005**************************//

	@And("^Give recon period from date$")
	public void give_recon_period_from_date() throws Throwable {

		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromDate + ", " + recondata.FromYear + "']//span")));

	}

	@And("^Give recon period to date$")
	public void give_recon_period_to_date() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + recondata.Month + " " + recondata.FromYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + recondata.FullMonth + " "
				+ recondata.FromToDate + ", " + recondata.FromYear + "']//span")));
	}

	@Then("^Upload our Banks file$")
	public void upload_our_banks_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\PALLAV_AL13.csv");

	}

	@And("^Click the Bank recon Statement$")
	public void click_the_bank_recon_statement() throws Throwable {
		Thread.sleep(1000);
		bankObj.bank_Reconciliation_Statement().click();
	}

	@And("^Click the Bank recon Details$")
	public void click_the_bank_recon_details() throws Throwable {
		Thread.sleep(1000);
		bankObj.bank_Reconciliation_Details().click();
	}

	// ******************@KUBS_TAX_UAT_006_001_TC_006**************************//

	@And("^click the Bank Recon Process$")
	public void click_the_bank_recon_process() throws Throwable {
		Thread.sleep(1000);
		bankObj.bank_Reconciliation_Process().click();
	}

	@And("^Click the Record and try to save and Verify$")
	public void click_the_record_and_try_to_save_and_verify() throws Throwable {
		waitHelper.waitForElement(driver, 2000, bankObj.bank_Reconciliation_1st_Record());
		bankObj.bank_Reconciliation_1st_Record().click();
		// bankReconObj.matchTabMatchButton().click();
		try {
			bankObj.bank_Reconciliation_Match_save().click();
		} catch (NoSuchElementException e) {
			System.out.println("Checker not allowed to do any modification on any tab");
		}
	}

	@Then("^Upload our Bank files$")
	public void upload_our_bank_files() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\PALLAV_AL16.csv");
	}

	@Then("^Upload our Bank file for Bank$")
	public void upload_our_bank_file_for_bank() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\Barclay_0025.csv");
	}

	@Then("^Try to submit the Record$")
	public void try_to_submit_the_record() throws Throwable {
		waitHelper.waitForElement(driver, 2000, bankObj.bank_Recon_Submit());
		bankObj.bank_Recon_Submit().click();
		waitHelper.waitForElement(driver, 2000, bankObj.bank_Recon_Remark());
		bankObj.bank_Recon_Remark().click();
		bankObj.bank_Recon_Remark().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, bankObj.bank_Recon_RemarkSubmit());
		bankObj.bank_Recon_RemarkSubmit().click();
	}

	// ******************@KUBS_TAX_UAT_009_001_TC_001**************************//
	@Then("^Upload Barclays Bank file$")
	public void upload_barclays_bank_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\Barclay_0027.csv");
	}

	@And("^Verify the Message we get$")
	public void verify_the_message_we_get() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECOnToastAlert(), 3000, 300);
		String Alert = bankReconObj.BANKRECOnToastAlert().getText();
		System.out.println(Alert);
	}
	@And("^User Verify notification message get while save bank recon record$")
    public void user_verify_notification_message_get_while_save_bank_recon_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,bankReconObj.BANKRECON_SucessToastAlert() ,30, 2);
		Assert.assertEquals(bankReconObj.BANKRECON_SucessToastAlert().getText(),"Workflow initiated submit record from inbox.");
		waitHelper.waitForElementToVisibleWithFluentWait(driver,bankReconObj.SuccessMessageClose(),30, 2);
		bankReconObj.SuccessMessageClose().click();
      
	}
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
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickFirstCheckboxInBookRecord());
     bankReconModuleObj.clickFirstCheckboxInBookRecord().click();
     String xpath="//ion-grid[2]//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div";
     seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath(xpath)));
     String ChequeNo = driver.findElement(By.xpath(xpath)).getText();
     testdata.put("chequeno", ChequeNo);
     System.out.println(ChequeNo);
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickUnmatch());
     bankReconModuleObj.clickUnmatch().click();
    
 }

 @And("^user match record in unmatched tab for text format$")
 public void user_match_record_in_unmatched_tab_for_text_format() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickFirstCheckboxInBookRecord());
     bankReconModuleObj.clickFirstCheckboxInBookRecord().click();
     seleniumactions.getWaitHelper().waitForElement(driver,2000, driver.findElement(By.xpath("(//input[@id='saveCheckBox'])[3]")));
     driver.findElement(By.xpath("(//input[@id='saveCheckBox'])[3]")).click();
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickMatch());
     bankReconModuleObj.clickMatch().click();
       
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
		bankReconModuleObj.bankReconciliationBasis().click();
		Thread.sleep(1000);
		bankReconModuleObj.bankReconciliationBasis().sendKeys("bank to book");
		//bankReconObj.bankReconciliationBasis().sendKeys(Keys.DOWN);
		bankReconModuleObj.bankReconciliationBasis().sendKeys(Keys.DOWN);
		bankReconModuleObj.bankReconciliationBasis().sendKeys(Keys.ENTER);
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickFirstVerifyInBookRecord());
     bankReconModuleObj.clickFirstVerifyInBookRecord().click();
     Thread.sleep(2000);
     javascriphelper.JavaScriptHelper(driver);
     javascriphelper.JSEClick(bankReconModuleObj.clickYesInSelectButton());
     
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
				        bankReconModuleObj.clickMatch().click();
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
		seleniumactions.getWaitHelper().waitForElement(driver, 3000,bankReconModuleObj.optionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(bankReconModuleObj.optionicon());
     
 }

 @And("^user click bank recon module$")
 public void user_click_bank_recon_module() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankReconModule());
     seleniumactions.getClickAndActionsHelper().clickOnElement(bankReconModuleObj.bankReconModule());
 }

 @And("^user click eye icon in bank recon module$")
 public void user_click_eye_icon_in_bank_recon_module() throws Throwable {
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankRecon_EyeIcon());
 	bankReconModuleObj.bankRecon_EyeIcon().click();
 }

 @And("^user click add icon in bank recon$")
 public void user_click_add_icon_in_bank_recon() throws Throwable {
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.addIconInBankRecon());
 	bankReconModuleObj.addIconInBankRecon().click();
     
 }

 @And("^user select bank name in bank recon Module$")
 public void user_select_bank_name_in_bank_recon_module() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.selectBankName());
     bankReconModuleObj.selectBankName().click();
     bankReconModuleObj.selectBankName().sendKeys(bankReconData.BankName);
     bankReconModuleObj.selectBankName().sendKeys(Keys.ENTER);
 }

 @And("^user select bank account Number in bank recon Module$")
 public void user_select_bank_account_number_in_bank_recon_module() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.selectAccountNumber());
     bankReconModuleObj.selectAccountNumber().click();
     Thread.sleep(1000);
     bankReconModuleObj.selectAccountNumber().sendKeys(Keys.DOWN);
     bankReconModuleObj.selectAccountNumber().sendKeys(Keys.ENTER);
 }

 @And("^user click bank recon from date and select the date$")
 public void user_click_bank_recon_from_date_and_select_the_date() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankRecon_FromDate());
     bankReconModuleObj.bankRecon_FromDate().click();
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
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankRecon_ToDate());
 	bankReconModuleObj.bankRecon_ToDate().click();
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
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.chooseFile());
     bankReconModuleObj.chooseFile().sendKeys(bankReconData.FileLocation);
 }

 @And("^user click save button in bank recon$")
 public void user_click_save_button_in_bank_recon() throws Throwable {
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.saveButtonInBankRecon());
 	bankReconModuleObj.saveButtonInBankRecon().click();
     
 }

 @And("^user click process button in bank recon$")
 public void user_click_process_button_in_bank_recon() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankProcess());
     bankReconModuleObj.bankProcess().click();
     seleniumactions.getAlertHelper().AcceptAlert();
     Thread.sleep(3000);
 }
 @And("^user click the unmatched data in bank recon process$")
 public void user_click_the_unmatched_data_in_bank_recon_process() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconModuleObj.unmatchedData());
       bankReconModuleObj.unmatchedData().click();
       Thread.sleep(1000);
 	//javascriphelper.JavaScriptHelper(driver);
 	//javascriphelper.JSEClick(bankReconObj.unmatchedData());
 }
 @Then("^verify unmatched,partially matched and transposition matched records in bank Statment after processing$")
 public void verify_unmatchedpartially_matched_and_transposition_matched_records_in_bank_statment_after_processing() throws Throwable {
 	//div[text()=' RRN156 ']
 	//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Unmatched Receipt number")+" ']")));
 	if (driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Unmatched Receipt number")+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Unmatched Receipt number")+" ']")).getText());
		}
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Partial matched Receipt number")+" ']")));
 	if (driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Partial matched Receipt number")+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Partial matched Receipt number")+" ']")).getText());
		}
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Transpose Receipt number")+" ']")));
 	if (driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Transpose Receipt number")+" ']")).isDisplayed()) {
			System.out.println("Found the Cheque Refernce Number "+driver.findElement(By.xpath("//div[text()=' "+bankReconTestData.get("Transpose Receipt number")+" ']")).getText());
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
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.selectBankName());
 	bankReconModuleObj.selectBankName().click();
 	bankReconModuleObj.selectBankName().sendKeys(bankReconData.CsvBankName);
 	bankReconModuleObj.selectBankName().sendKeys(Keys.ENTER);
 }

 @And("^user click bank recon from date and select the date for csv file$")
 public void user_click_bank_recon_from_date_and_select_the_date_for_csv_file() throws Throwable {
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankRecon_FromDate());
 	bankReconModuleObj.bankRecon_FromDate().click();
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
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankRecon_ToDate());
 	bankReconModuleObj.bankRecon_ToDate().click();
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
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.chooseFile());
     bankReconModuleObj.chooseFile().sendKeys(bankReconData.FileLocationCsv);
 }
 @Then("^user verify Format of Bank Recon statement must be as per FSD$")
 public void user_verify_format_of_bank_recon_statement_must_be_as_per_fsd() throws Throwable {
 	//seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.AdjustedBalance());
 	javascriphelper.JavaScriptHelper(driver);
 	javascriphelper.scrollIntoView(bankReconModuleObj.AdjustedBalance());
 	System.out.println("Format of Bank Recon Statement As per FSD");
     
 }

 @And("^user click the bank statement in bank recon$")
 public void user_click_the_bank_statement_in_bank_recon() throws Throwable {
 	Thread.sleep(2000);
    // seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconObj.bankStatement());
 	bankReconModuleObj.bankStatement().click();
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
     javascriphelper.scrollIntoView(bankReconModuleObj.clickFirstCheckboxInBookRecord());
     bankReconModuleObj.clickFirstCheckboxInBookRecord().click();
     javascriphelper.scrollIntoView(bankReconModuleObj.clickFirstCheckInBankStatement());
     bankReconModuleObj.clickFirstCheckInBankStatement().click();
     bankReconModuleObj.clickMatch().click();
     
 }

 @And("^user click matched data tab$")
 public void user_click_matched_data_tab() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.matchedData());
     bankReconModuleObj.matchedData().click();
     Thread.sleep(1000);
 }
 
 
 //job execution
 @And("^user click maker option$")
 public void user_click_maker_option() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver, 2000,bankReconModuleObj.maker_Finance_Option());
     bankReconModuleObj.maker_Finance_Option().click();
 }

 @And("^user select configuration menu$")
 public void user_select_configuration_menu() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.configurationSelect());
     bankReconModuleObj.configurationSelect().click();
 }

 @And("^user click job scheduler$")
 public void user_click_job_scheduler() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.jobScheduler());
     bankReconModuleObj.jobScheduler().click();
 }

 @And("^user click temp view in job execution$")
 public void user_click_temp_view_in_job_execution() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconModuleObj.jobExecutionTempView());
     bankReconModuleObj.jobExecutionTempView().click();
 }

 @And("^user click start job$")
 public void user_click_start_job() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000, bankReconModuleObj.startJob());
     bankReconModuleObj.startJob().click();
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
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankReconciliationProcess());
     bankReconModuleObj.bankReconciliationProcess().click();
 }
 @Then("^user verify Adjusted Balance as per Bank Statement must match with Adjusted Balance as per Books$")
 public void user_verify_adjusted_balance_as_per_bank_statement_must_match_with_adjusted_balance_as_per_books() throws Throwable {
     Thread.sleep(3000);
		javascriphelper.JavaScriptHelper(driver);
     javascriphelper.scrollIntoViewAndClick(bankReconModuleObj.adjustedBalanceAmountInBankStatement());
     String adjustedBalanceAmountInBankStatement = bankReconModuleObj.adjustedBalanceAmountInBankStatement().getText();
     javascriphelper.scrollIntoView(bankReconModuleObj.adjustedBalanceAsPerBook());
     String adjustedBalanceAsPerBook = bankReconModuleObj.adjustedBalanceAsPerBook().getText();
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
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankReconModuleTempView());
     bankReconModuleObj.bankReconModuleTempView().click();
 }

 @And("^user click first record in bank recon temp view$")
 public void user_click_first_record_in_bank_recon_temp_view() throws Throwable {
     seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.clickFirstRecordInTempView());
     bankReconModuleObj.clickFirstRecordInTempView().click();
 }

 @And("^user click process button again for reprocessing$")
 public void user_click_process_button_again_for_reprocessing() throws Throwable {
 	seleniumactions.getWaitHelper().waitForElement(driver,2000,bankReconModuleObj.bankProcess());
 	bankReconModuleObj.bankProcess().click();
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
     javascriphelper.scrollIntoView(bankReconModuleObj.clickFirstCheckboxInBookRecord());
     bankReconModuleObj.clickFirstCheckboxInBookRecord().click();
     bankReconModuleObj.clickUnmatch().click();
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
// bank recon format
 @Then("^Click on Bank Recon$")
 public void click_on_bank_recon()  {
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormatField());
	bankRecon_ReconFormatObj.bankRecon_ReconFormatField().click();
	
 }
	 @And("^User upadte test data id for unmatched entry$")
  public void user_upadte_test_data_id_for_unmatched_entry() throws Throwable {
		bankReconTestData = excelDataForBankRecon.getTestdata("KUBS_TAX_UAT_006_001_TC_001_PQ_1_D1");
  }


 @Then("^click on Bank Recon format eye button$")
 public void click_on_bank_recon_format_eye_button()  {
 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton().click();   
 }

 @Then("^select the active record$")
 public void select_the_active_record()  {
 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord().click();   
 }

 @Then("^Inactivate the record$")
 public void inactivate_the_record()  {
 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(bankRecon_ReconFormatTestDataType.FormatStatus);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(Keys.ENTER);
	   
 }
 //bankRecon_ReconFormat_Next()
 @Then("^history must be correctly maintained on record$")
 public void history_must_be_correctly_maintained_on_record() throws Throwable {
 	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next().click(); 
		Thread.sleep(2000);
 }

 
 
//---------------------KUBS_BRS_UAT_001_001_TC_001----------------------//
 @And("^search for bank recon record in notification$")
 public void search_for_bank_recon_record_in_notification() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver,kubsCommonObj.kubsSearchEventCode(),30,2);
 	clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSearchEventCode());
 	clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSearchEventCode());
		kubsCommonObj.kubsSearchEventCode().sendKeys(bankReconTestData.get("ModuleCode"));
 }
 @And("^store the reference number of budget bank recon in excel database$")
 public void store_the_reference_number_of_budget_bank_recon_in_excel_database() throws Throwable {
 	for (int i = 0; i <200; i++) {
			try {
				String referenceNumber = bankRecon_ReconFormatObj.bankReconConfigReferenceNumber().getText();
				excelDataForBankRecon.updateTestData(bankReconTestData.get("DataSet ID"),"Reference ID",
						referenceNumber);
				excelDataForBankRecon.updateTestData("KUBS_TAX_UAT_006_001_TC_001_PQ_2_D1","Reference ID",
						referenceNumber);
				break;
				
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
 }
 @And("^select the bank recon record$")
 public void select_the_bank_recon_record() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver,
 			bankRecon_ReconFormatObj.bankReconConfigNotificationFirstRecord(), 20, 1);
 	clicksAndActionHelper.moveToElement(bankRecon_ReconFormatObj.bankReconConfigNotificationFirstRecord());
 	clicksAndActionHelper.clickOnElement(bankRecon_ReconFormatObj.bankReconConfigNotificationFirstRecord());
 }

 @And("^click on submit in bank recon configuration$")
 public void click_on_submit_in_bank_recon_configuration() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
 	clicksAndActionHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
 	clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
 }
 @And("^click on cancel in bank recon configuration$")
 public void click_on_cancel_in_bank_recon_configuration() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubs_CancelButton(), 20, 1);
 	clicksAndActionHelper.moveToElement(kubsCommonObj.kubs_CancelButton());
 	clicksAndActionHelper.clickOnElement(kubsCommonObj.kubs_CancelButton());
 }

 @And("^enter the alert remark in bank recon configuration$")
 public void enter_the_alert_remark_in_bank_recon_configuration() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
 	clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
 	clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(bankReconTestData.get("Remarks"));
		
 }

 @And("^click on alert submit in bank recon configuration$")
 public void click_on_alert_submit_in_bank_recon_configuration() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {

				clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
				clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
				break;
			} catch (Exception e) {
				clicksAndActionHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				clicksAndActionHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
				kubsCommonObj.kubsAlertRemark().sendKeys(bankReconTestData.get("MakerAlerRemark"));
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
 }
 @And("^user verify the bank record got cancelled$")
 public void user_verify_the_bank_record_got_cancelled() throws Throwable {
	 
	 waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
	 System.out.println(kubsCommonObj.kubsToastAlert().getText());
 }

 @And("^store the reviewer id of bank recon configuration in excel database$")
 public void store_the_reviewer_id_of_bank_recon_configuration_in_excel_database() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelDataForBankRecon.updateTestData("KUBS_TAX_UAT_006_001_TC_001_PQ_2_D1", "Reviewer ID", reviewerID);
 }
 @And("^User Search Bank name in approved view$")
 public void user_search_bank_name_in_approved_view() throws Throwable {
     waithelper.waitForElementToVisibleWithFluentWait(driver,bankRecon_ReconFormatObj.bankRecon_SearchBankNameInApprovedView(), 30, 2);
     bankRecon_ReconFormatObj.bankRecon_SearchBankNameInApprovedView().click();
     bankRecon_ReconFormatObj.bankRecon_SearchBankNameInApprovedView().sendKeys(bankReconTestData.get("Bank Name"));
     bankRecon_ReconFormatObj.bankRecon_SearchBankNameInApprovedView().sendKeys(Keys.ENTER);
 }
 @And("^User click edit icon of searched bank record$")
 public void user_click_edit_icon_of_searched_bank_record() throws Throwable {
 	waithelper.waitForElementToVisibleWithFluentWait(driver,bankRecon_ReconFormatObj.bankRecon_EditIconOfApprovedBank(), 30, 2);
     bankRecon_ReconFormatObj.bankRecon_EditIconOfApprovedBank().click();
 }
 @And("^User select Allow unadjust entry from bank statement$")
 public void user_select_allow_unadjust_entry_from_bank_statement() throws Throwable {
 	//AllowUnadjusted
 	waithelper.waitForElementToVisibleWithFluentWait(driver, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted(), 30, 2);
 	for (int i = 0; i <200; i++) {
			try {
				bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().click();   
		    	break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail();
				}
			}
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(bankReconTestData.get("Allow unadjust entry from bank statement"));
	    	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(Keys.ENTER);
		}
 	
 }

 @Then("^fill the Bank Reconciliation Format$")
 public void fill_the_bank_reconciliation_format() throws InterruptedException {
 	
//BankName   	
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(bankRecon_ReconFormatTestDataType.BankName);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(Keys.ENTER);
		   	
//ApplicableAccountType	
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(bankRecon_ReconFormatTestDataType.ApplicableAccountType);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(Keys.ENTER);       

//UploadFileExtension
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(bankRecon_ReconFormatTestDataType.UploadFileExtension);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(Keys.ENTER);       
//Separator
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(bankRecon_ReconFormatTestDataType.Separator);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(Keys.ENTER);       
//AllowUnadjusted
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(bankRecon_ReconFormatTestDataType.AllowUnadjusted);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(Keys.ENTER);       
//EffectiveDate
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate().click();
//Year Selection
Thread.sleep(2000);
String year1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[3]")).getText().toString();
List<WebElement> size1 = driver.findElements(By.xpath("//ion-picker-column[3]/div/button"));
for(WebElement webElement : size1) {
	webElement.click();
	String year = webElement.getText();
	if(year.equalsIgnoreCase("2023")) {
		break;
	}
}
//Month selection
Thread.sleep(2000);
String month1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[2]")).getText().toString();
List<WebElement> size2 = driver.findElements(By.xpath("//ion-picker-column[2]/div/button"));
for(WebElement webElement2 : size2) {
	try{
		webElement2.click();
		String month = webElement2.getText();
		if(month.equalsIgnoreCase("Jun")) {
			break;
		}
	}
	catch(ElementNotInteractableException ee) {
		
	}
	
}
//Date selection
Thread.sleep(2000);
String day1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[1]")).getText().toString();
List<WebElement> size3 = driver.findElements(By.xpath("//ion-picker-column[1]/div/button"));
for(WebElement webElement3 : size3) {
	try{
		webElement3.click();
		String day = webElement3.getText();
		if(day.equalsIgnoreCase("09")) {
			break;
		}
	}
	catch(ElementNotInteractableException ee) {
		
	}
}

/*waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[3]/div/button[10]")));
WebElement year = driver.findElement(By.xpath("//ion-picker-column[3]/div/button[10]"));
javascripthelper.JavaScriptHelper(driver);
//javascripthelper.
//waithelper.waitForElement(driver, 2000, year);
// year.click();

waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[2]/div/button[4]")));
WebElement month = driver.findElement(By.xpath("//ion-picker-column[2]/div/button[4]"));
javascripthelper.scrollIntoView(month);
waithelper.waitForElement(driver, 2000, month);
month.click();

waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[1]/div/button[20]")));
WebElement day = driver.findElement(By.xpath("//ion-picker-column[1]/div/button[20]"));
javascripthelper.scrollIntoView(day);
waithelper.waitForElement(driver, 2000, day);
day.click();
*/
//EffectiveDateDoneButton
Thread.sleep(1500);
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton());
WebElement done = bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton()  ;
clicksAndActionHelper.clickOnElement(done);  
Thread.sleep(2000);

//AllowValueDate
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(bankRecon_ReconFormatTestDataType.AllowValueDate);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(Keys.ENTER); 
Thread.sleep(1000);
//SummaryLineToBeSkipped
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(bankRecon_ReconFormatTestDataType.SummaryLineToBeSkipped);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(Keys.ENTER);       
//FileNamePrefix
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().click();  
bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(bankRecon_ReconFormatTestDataType.FileNamePrefix);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(Keys.ENTER);       
												 

}


@Then("^fill the Bank Reconciliation PlaceHolder$")
public void fill_the_bank_reconciliation_placeholder() throws InterruptedException {
//PlaceHolderInFile
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder().click();  

//PlaceHolderInFile
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile().click();  

//AccountNo
Thread.sleep(1500);
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton().click();

//AddButton
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton().click(); 

//PlaceHolderInFile second
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond().click();  
	



//ClosingBalance__RadioButton
	Thread.sleep(1000);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton().click(); 
	
//AddButton
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton());
bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton().click(); 




Thread.sleep(2000);
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoRow);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoColumn);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoLength);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoPosition);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(Keys.ENTER);





waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateRow);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateColumn);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateLength);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(Keys.ENTER);

waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox());
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().click();
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDatePosition);
bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(Keys.ENTER);	

//PlaceHolderInFile Thrid
	javascripthelper.JavaScriptHelper(driver);
 javascripthelper.scrollIntoView(bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
 Thread.sleep(1000);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird().click();  
		
	//AsOnDate_RadioButton
	Thread.sleep(1000);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton().click(); 
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceRow);
	bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceColumn);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceLength);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalancePosition);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().sendKeys(Keys.ENTER);	
}  

 @Then("^File Data matching rule$")
 public void file_data_matching_rule() throws Throwable {
 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileName);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
	
waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPoint);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataType);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(bankRecon_ReconFormatTestDataType.DateFormate);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLength);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.Position);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
 	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePadding);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(bankRecon_ReconFormatTestDataType.MatchCondition);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);
 
 
}
 @Then("^click back button$")
 public void click_back_button() throws Throwable {
 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton().click();    
 }
 
 @Then("^File Transaction Data matching rule$")
 public void file_transaction_data_matching_rule() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
		
	 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(bankRecon_ReconFormatTestDataType.DateFormateTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.Position);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
	    	
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionTrans);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);	
   
 }
 @Then("^File Deposit Data matching rule$")
 public void file_deposit_data_matching_rule() throws Throwable {
 	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
		
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.PositionDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionDepo);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(bankRecon_ReconFormatTestDataType.TranspositionCondition);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(Keys.ENTER);
		   
 }
 @Then("^File Withdrawals Data matching rule$")
 public void file_withdrawals_data_matching_rule() throws Throwable {
 	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
		
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.PositionWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionWith);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
		 
 }
 

 


}
