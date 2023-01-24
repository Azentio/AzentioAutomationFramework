package stepdefinitions;

import java.lang.management.OperatingSystemMXBean;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.BANKRECON_BankReconcilationObj;
import pageobjects.Bank_Recon_Obj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ARAP_ARandAPData;
import testDataType.BankReconData;

public class Bank_Recon extends BaseClass {

	WebDriver driver = BaseClass.driver;
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
	BankReconData recondata = jsonConfig.getBankReconData("Bankrecon");
	AlertHelper alertHelper = new AlertHelper(driver);
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","BankReconTestData","Data Set ID");
	Map<String, String> bankrecon;

	// *****************@KUBS_TAX_UAT_006_001_Tc_001******************//

	
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
		Thread.sleep(2000);
		bankReconObj.BANKRECONBankName().sendKeys(bankrecon.get("Bankname1"));
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);

		bankReconObj.BANKRECONBAnkAccountNumber().click();
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
	}

	@Then("^Upload our Barclays Bank file$")
	public void upload_barclays_bank_our_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\ININDC00071\\Music\\HdfcBank_0024.csv");

	}

	@And("^check the file validated  successfully or not$")
	public void check_the_file_validated_successfully_or_not() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECOnToastAlert(), 3000, 300);
		Assert.assertEquals("File validated successfully", bankReconObj.BANKRECOnToastAlert().getText());
		System.out.println(bankReconObj.BANKRECOnToastAlert().getText());
		System.out.println("File Validation successfully");
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
						By.xpath("//span[contains(text(),'" + bankrecon.get("Month") + " " + bankrecon.get("FromYear") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(1000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankrecon.get("FullMonth") + " " + bankrecon.get("FromDate") + ", " + bankrecon.get("FromYear") + "']//span")));

	}

	@And("^Give the recon period to date for Barclays Bank$")
	public void give_the_recon_period_to_date_for_barclays_bank() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankrecon.get("Month") + " " + bankrecon.get("FromYear") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankrecon.get("FullMonth") + " "
				+ bankrecon.get("FromToDate") + ", " + bankrecon.get("FromYear") + "']//span")));
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


	@And("^enter the Indian bank name and Indian account number$")
	public void enter_the_indian_bank_name_and_indian_account_number() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
		bankReconObj.BANKRECONBankName().click();
		bankReconObj.BANKRECONBankName().sendKeys(recondata.Bankname1);
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);

		bankReconObj.BANKRECONBAnkAccountNumber().click();
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
	}

	@And("^Give the Bank recon period from date$")
	public void give_the_bank_recon_period_from_date() throws Throwable {
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

	@And("^Give the Bank recon period to date$")
	public void give_the_bank_recon_period_to_date() throws Throwable {
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

	@Then("^Upload our file for Indian$")
	public void upload_our_file_for_indian() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00075\\Music\\Barclay_0025.csv");
		Thread.sleep(5000);

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
	
	@And("^User get the test data for bankrecon testcase006001001$")
    public void user_get_the_test_data_for_bankrecon_testcase006001001() throws Throwable {
		bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_001_D1");
    }

    @And("^User get the test data for bankrecon testcase006001002$")
    public void user_get_the_test_data_for_bankrecon_testcase006001002() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_002_D1");
    }

    @And("^User get the test data for bankrecon testcase006001003$")
    public void user_get_the_test_data_for_bankrecon_testcase006001003() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_003_D1");
    }

    @And("^User get the test data for bankrecon testcase006001004$")
    public void user_get_the_test_data_for_bankrecon_testcase006001004() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_004_D1");
    }

    @And("^User get the test data for bankrecon testcase006001005$")
    public void user_get_the_test_data_for_bankrecon_testcase006001005() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_005_D1");
    }

    @And("^User get the test data for bankrecon testcase006001006$")
    public void user_get_the_test_data_for_bankrecon_testcase006001006() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_005_D1");
    }

    @And("^User get the test data for bankrecon testcase006001007$")
    public void user_get_the_test_data_for_bankrecon_testcase006001007() throws Throwable {
    	bankrecon = excelData.getTestdata("KUBS_TAX_UAT_006_001_TC_007_D1");
    }


}
