package stepdefinitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.JsonConfig;
import helper.AlertHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BANKRECON_BankReconcilationObj;
import pageobjects.BANKRECON_Recon_FormatObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.BANKRECON_BankReconTestData;

public class BANKRECON_BankReconcilation extends BaseClass {
	WebDriver driver = BaseClass.driver;

	BANKRECON_BankReconcilationObj bankReconObj = new BANKRECON_BankReconcilationObj(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	AlertHelper alertHelper = new AlertHelper(driver);
	Map<String, String> testData = new HashMap<>();
	JsonConfig jsonConfig = new JsonConfig();
	BANKRECON_BankReconTestData bankReconTestData = jsonConfig.getBankReconTestData("Maker");
	List listData= new ArrayList<>();
    
	@And("^click on Bank Recon module$")
	public void click_on_bank_recon_module() throws Throwable {
		waitHelper.waitForElementVisible(kubsMakerObj.kubsDirBankRecon(), 3000, 300);
		kubsMakerObj.kubsDirBankRecon().click();
	}

	@And("^click on view button near by Bank Reconcilation sub module$")
	public void click_on_view_button_near_by_bank_reconcilation_sub_module() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankReconEyeIcon(), 3000, 300);
		bankReconObj.BANKRECONBankReconEyeIcon().click();
	}

	@And("^enter the bank name and account number$")
	public void enter_the_bank_name_and_account_number() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
		bankReconObj.BANKRECONBankName().click();
		bankReconObj.BANKRECONBankName().sendKeys("Bank of baroda");
		bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);

		bankReconObj.BANKRECONBAnkAccountNumber().click();
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
		bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
	}

	// KUBS_TAX_UAT_07_001

	@And("^Give the recon period from date which is already processed$")
	public void give_the_recon_period_from_date_which_is_already_processed() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.ExistPeriodFromMonth.substring(0, 3)
								+ " " + bankReconTestData.ExistPeriodYear + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='"
				+ bankReconTestData.ExistPeriodFromMonth + " " + bankReconTestData.ExistPeriodFromDay + ", "
				+ bankReconTestData.ExistPeriodYear + "']//span")));

	}

	@Then("^verify system throw the validation message or not$")
	public void verify_system_throw_the_validation_message_or_not() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECOnToastAlert(), 3000, 300);
		String toast_Alert = bankReconObj.BANKRECOnToastAlert().getText();
		System.out.println("Alert message is : " + toast_Alert);
		Assert.assertEquals("Recon From date must be +1 day of previous processed bank recon to date.", toast_Alert);
	}

	// KUBS_TAX_UAT_07_002

	@And("^Give the recon period from date to upload the already existiong file$")
	public void give_the_recon_period_from_date_to_upload_the_already_existiong_file() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(By
						.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonthInvalidFile.substring(0, 3)
								+ " " + bankReconTestData.PeriodFromYearInvalidFile + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='"
				+ bankReconTestData.PeriodFromMonthInvalidFile + " " + bankReconTestData.PeriodFromdateInvalidFile
				+ ", " + bankReconTestData.PeriodFromYearInvalidFile + "']//span")));
	}

	@And("^Give the recon period to date to upload the already existiong file$")
	public void give_the_recon_period_to_date_to_upload_the_already_existiong_file() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonthInvalidFile.substring(0, 3)
								+ " " + bankReconTestData.PeriodToYearInvalidFile + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='"
				+ bankReconTestData.PeriodToMonthInvalidFile + " " + bankReconTestData.PeriodToDateInvalidFile + ", "
				+ bankReconTestData.PeriodToYearInvalidFile + "']//span")));
	}

	@And("^upload the already processed file$")
	public void upload_the_already_processed_file() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
	}

	@Then("^verify system should through the validation message for uploded file$")
	public void verify_system_should_through_the_validation_message_for_uploded_file() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECOnToastAlert(), 3000, 300);
		String toast_Alert = bankReconObj.BANKRECOnToastAlert().getText();

		Assert.assertEquals("File name must be unique", toast_Alert);
	}

	@And("^Give the recon period from date$")
	public void give_the_recon_period_from_date() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(By.xpath("//span[contains(text(),'Mar 2023')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='March 1, 2023']//span")));

	}

	@And("^Give the recon period to date$")
	public void give_the_recon_period_to_date() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(By.xpath("//span[contains(text(),'Mar 2023')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath("//td[@aria-label='March 2, 2023']//span")));
	}

	@And("^Give the recon period from date to verify the bank statement tab$")
	public void give_the_recon_period_from_date_to_verify_the_bank_statement_tab() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonth2.substring(0, 3) + " "
								+ bankReconTestData.PeriodFromYear2 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodFromMonth2 + " "
						+ bankReconTestData.PeriodFromdate2 + ", " + bankReconTestData.PeriodFromYear2 + "']//span")));
	}

	@And("^Give the recon period to date to verify the bank statement tab$")
	public void give_the_recon_period_to_date_to_verify_the_bank_statement_tab() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonth2.substring(0, 3) + " "
								+ bankReconTestData.PeriodToYear2 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodToMonth2 + " "
						+ bankReconTestData.PeriodToDate2 + ", " + bankReconTestData.PeriodToYear2 + "']//span")));
	}

	@And("^upload te file to verify the bank statement$")
	public void upload_te_file_to_verify_the_bank_statement() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
	}

	@Then("^Upload our file$")
	public void upload_our_file() throws Throwable {
		Thread.sleep(2000);
		
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
	}

	@And("^check the file is validated  successfully or not$")
	public void check_the_file_is_validated_successfully_or_not() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECOnToastAlert(), 3000, 300);
		Assert.assertEquals("File validated successfully", bankReconObj.BANKRECOnToastAlert().getText());
		System.out.println(bankReconObj.BANKRECOnToastAlert().getText());
		System.out.println("File Validation successfully");
	}

	@And("^save the bank recon record$")
	public void save_the_bank_recon_record() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankReconSaveButton(), 3000, 300);
		bankReconObj.BANKRECONBankReconSaveButton().click();

	}

	@And("^Process that file$")
	public void process_that_file() throws Throwable {

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

	@And("^goto unmatched Tab$")
	public void goto_unmatched_tab() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
		bankReconObj.BANKRECON_UnmatchedData().click();

	}

	@And("^unmatch that record and try to save that record$")
	public void unmatch_that_record_and_try_to_save_that_record() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(bankReconObj.MatcedTabFirstGridInput(), 3000, 300);
		bankReconObj.MatcedTabFirstGridInput().click();
		for (int i = 1; i <= 10; i++) {

			try {
				javascriptHelper.scrollIntoViewAndClick(driver.findElement(
						By.xpath("//ion-grid[2]//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//input")));
			} catch (NoSuchElementException e) {
				break;
			}
		}
		bankReconObj.matchTabMatchButton().click();
		// ion-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//input

	}

	@Then("^verify validation message is comming or not$")
	public void verify_validation_message_is_comming_or_not() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		String AlertMessage = javascriptHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText")
				.toString();
		System.out.println("String is : " + AlertMessage);

		Assert.assertEquals("Please select proper records Bank side for manual match!!!", AlertMessage);

	}

	@And("^match that receipt reference number in unmatched tab$")
	public void match_that_receipt_reference_number_in_unmatched_tab() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		javascriptHelper.scrollToElemetAndClick(bankReconObj.unmatchedTabBankStatementCheckBox());
//bankReconObj.unmatchedTabBankStatementCheckBox().click();
		testData.put("DepositeAmount", bankReconObj.unmatchedTabBankStatementDepositeAmount().getText());
		System.out.println("Deposite amount is " + testData.get("DepositeAmount"));
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//ion-grid[1]//datatable-row-wrapper[" + i + "]//datatable-body-cell[7]//div")));
				String amount = driver
						.findElement(By
								.xpath("//ion-grid[1]//datatable-row-wrapper[" + i + "]//datatable-body-cell[7]//div"))
						.getText();

				System.out.println("Amount is " + amount);
				if (amount.equals(testData.get("DepositeAmount"))) {
					System.out.println("Inside the if condition");
					clicksAndActionsHelper.clickOnElement(driver.findElement(By
							.xpath("//ion-grid[1]//datatable-row-wrapper[" + i + "]//datatable-body-cell[1]//input")));

//					driver.findElement(
//							By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input"))
//							.click();				
					javascriptHelper.scrollToElemet(driver.findElement(By.xpath(
							"//ion-grid[1]//datatable-row-wrapper[" + i + "]//datatable-body-cell[10]//ion-select")));
//					driver.findElement(By.xpath(
//							"//ion-grid[1]//datatable-row-wrapper[" + i + "]//datatable-body-cell[10]//ion-select"))
//							.click();
					
					// driver.findElement(By.xpath("//ion-radio-group//ion-item[2]//ion-radio")).click();
					// clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath("//ion-item[2]//ion-radio")));
					//javascriptHelper.JSEClick(driver.findElement(By.xpath("//ion-item[2]//ion-radio")));
					break;
				}

			} catch (NoSuchElementException e) {
				break;
			}

		}
		Thread.sleep(2000);
		bankReconObj.reconcilationMatchButton().click();
		bankReconObj.reconcilationMatchSaveButton().click();

	}

	@And("^goto bank statement tab and validate theat amount should be tally$")
	public void goto_bank_statement_tab_and_validate_theat_amount_should_be_tally() throws Throwable {
		Thread.sleep(3000);
		waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankReconStatementTab(), 3000, 300);
		bankReconObj.BANKRECONBankReconStatementTab().click();

		waitHelper.waitForElementVisible(bankReconObj.reconcilationStatementAsPerBankAmount(), 3000, 300);
		System.out.println("Asper Bank Amount is " + bankReconObj.reconcilationStatementAsPerBankAmount().getText()
				+ " As Per Book Amount is " + bankReconObj.reconcilationStatementAsperBookStatement().getText());

//		Assert.assertEquals(bankReconObj.reconcilationStatementAsPerBankAmount().getText(),
//				bankReconObj.reconcilationStatementAsperBookStatement().getText());
	}

	@And("^goto matched tab and check the receipt reference number comes under matched tab$")
	public void goto_matched_tab_and_check_the_receipt_reference_number_comes_under_matched_tab() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
		bankReconObj.bankReconMatchedData().click();
		Thread.sleep(2000);

	}

	// KUBS_TAX_UAT_009_002_TC_001
	@And("^Give the recon period from date to verify the mach tab for Book to bank basis$")
	public void give_the_recon_period_from_date_to_verify_the_mach_tab_for_book_to_bank_basis() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonth3.substring(0, 3) + " "
								+ bankReconTestData.PeriodFromYear3 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodFromMonth3 + " "
						+ bankReconTestData.PeriodFromdate3 + ", " + bankReconTestData.PeriodFromYear3 + "']//span")));

	}

	@And("^Give the recon period to date to verify the mach tab for Book to bank basis$")
	public void give_the_recon_period_to_date_to_verify_the_mach_tab_for_book_to_bank_basis() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonth3.substring(0, 3) + " "
								+ bankReconTestData.PeriodToYear3 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodToMonth3 + " "
						+ bankReconTestData.PeriodToDate3 + ", " + bankReconTestData.PeriodToYear3 + "']//span")));
	}

	@And("^upload the file to verify the book to bank type$")
	public void upload_the_file_to_verify_the_book_to_bank_type() throws Throwable {

		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);

	}

	@And("^choose the book to bank in type and verify matched data is comming under the matched tab$")
	public void choose_the_book_to_bank_in_type_and_verify_matched_data_is_comming_under_the_matched_tab() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
		bankReconObj.bankReconMatchedData().click();
		waitHelper.waitForElementVisible(bankReconObj.bankReconcilationBasis(), 3000, 300);
		bankReconObj.bankReconcilationBasis().click();
		bankReconObj.bankReconcilationBasis().sendKeys(Keys.DOWN);
		bankReconObj.bankReconcilationBasis().sendKeys(Keys.ENTER);
	}

	@And("^match the book record into bank record$")
	public void match_the_book_record_into_bank_record() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
//		waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
//		bankReconObj.BANKRECON_UnmatchedData().click();
		for(int i=1;i<=10;i++)
		{
			try
			{
				javascriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")));
		//driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
			
			}
			catch(NoSuchElementException e)
			{
			break;	
			}
		}
		
		for(int i=1;i<=10;i++)
		{
			try
			{
				javascriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")));
			
			}
			catch(NoSuchElementException e)
			{
			break;	
			}
		}
		for(int i=1;i<=10;i++)
		{
			int j=0;
			try
			{
		javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//div")));
		String receiptReferenceNumber = driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//div")).getText();
		listData.add(j, receiptReferenceNumber);
			j++;
			}
			catch(NoSuchElementException e)
			{
				break;
			}
			}
		bankReconObj.reconcilationMatchButton().click();
		bankReconObj.reconcilationMatchSaveButton().click();
	}
	@And("^match the book record into bank record and verify the transaction as yes$")
    public void match_the_book_record_into_bank_record_and_verify_the_transaction_as_yes() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
//		waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
//		bankReconObj.BANKRECON_UnmatchedData().click();
		for(int i=1;i<=10;i++)
		{
			try
			{
				javascriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")));
		        
			    javascriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//ion-select")));
			    //bankReconObj.bankReconTransactionYes().click();
			    
			    //clicksAndActionsHelper.doubleClick(bankReconObj.bankReconTransactionYes()); 
			    javascriptHelper.JSEClick(bankReconObj.bankReconTransactionYes());
			}
			
			
			catch(NoSuchElementException e)
			{
			break;	
			}
		}
		Thread.sleep(2000);
		for(int i=1;i<=10;i++)
		{
			try
			{
				javascriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")));
			
			}
			catch(NoSuchElementException e)
			{
			break;	
			}
		}
		for(int i=1;i<=10;i++)
		{
			int j=0;
			try
			{
		javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//div")));
		String receiptReferenceNumber = driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[6]//div")).getText();
		listData.add(j, receiptReferenceNumber);
			j++;
			}
			catch(NoSuchElementException e)
			{
				break;
			}
			}
		bankReconObj.reconcilationMatchButton().click();
		bankReconObj.reconcilationMatchSaveButton().click();
    }
	@And("^goto bank statement tab and verify the amount was tally or not$")
	public void goto_bank_statement_tab_and_verify_the_amount_was_tally_or_not() throws Throwable {

	}
	@And("^get the recipt reference number in grid view of uploded file$")
    public void get_the_recipt_reference_number_in_grid_view_of_uploded_file() throws Throwable {
   
    }

	@And("^goto match tab and verify record was displayed under the match tab$")
	public void goto_match_tab_and_verify_record_was_displayed_under_the_match_tab() throws Throwable {
		 for(int i=1;i<=10;i++)
		    {
		    	try
		    	{
		    	driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
		    	}
		    	catch(NoSuchElementException e)
		    	{
		    		break;
		    	}
		    }
		    for(int i=1;i<=listData.size();i++)
		    {
		    
		    	int  j=0;
		    	
		        driver.findElement(By.xpath("//div[contains(text(),'"+listData.get(j)+"')]")).isDisplayed();	
		        
		    
		        System.out.println(listData.get(j)+" Element visible successfully ");
		    j++;
		    }
		    Thread.sleep(2000);
	}

	// KUBS_TAX_UAT_009_002_TC_002
	@And("^upload the file to verify the book to bank type for verify the matchTab$")
	public void upload_the_file_to_verify_the_book_to_bank_type_for_verify_the_matchtab() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
	}

	// KUBS_TAX_UAT_009_002_TC_003
	@And("^Give the recon period from date for multiple data file in Book to bank basis$")
	public void give_the_recon_period_from_date_for_multiple_data_file_in_book_to_bank_basis() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonth4.substring(0, 3) + " "
								+ bankReconTestData.PeriodFromYear4 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodFromMonth4 + " "
						+ bankReconTestData.PeriodFromdate4 + ", " + bankReconTestData.PeriodFromYear4 + "']//span")));
	}

	@And("^Give the recon period to date for multiple data file in Book to bank basis$")
	public void give_the_recon_period_to_date_for_multiple_data_file_in_book_to_bank_basis() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonth4.substring(0, 3) + " "
								+ bankReconTestData.PeriodToYear4 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodToMonth4 + " "
						+ bankReconTestData.PeriodToDate4 + ", " + bankReconTestData.PeriodToYear4 + "']//span")));
	}

	@And("^upload the file for multiple data file in Book to bank basis$")
	public void upload_the_file_for_multiple_data_file_in_book_to_bank_basis() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
	}

	@And("^match all the book and bank record$")
	public void match_all_the_book_and_bank_record() throws Throwable {

	}

	// KUBS_TAX_UAT_009_002_TC_004l
	@And("^Give the recon period from date to verify the mach tab for Bank to book basis$")
	public void give_the_recon_period_from_date_to_verify_the_mach_tab_for_bank_to_book_basis() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonth5.substring(0, 3) + " "
								+ bankReconTestData.PeriodFromYear5 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodFromMonth5 + " "
						+ bankReconTestData.PeriodFromdate5 + ", " + bankReconTestData.PeriodFromYear5 + "']//span")));
	}

	@And("^Give the recon period to date to verify the mach tab for Bank to book basis$")
	public void give_the_recon_period_to_date_to_verify_the_mach_tab_for_bank_to_book_basis() throws Throwable {
		bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonth5.substring(0, 3) + " "
								+ bankReconTestData.PeriodToYear4 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodToMonth5 + " "
						+ bankReconTestData.PeriodToDate5 + ", " + bankReconTestData.PeriodToYear5 + "']//span")));
	}

	@And("^upload the file to verify the Bank to book type for verify the matchTab$")
	public void upload_the_file_to_verify_the_bank_to_book_type_for_verify_the_matchtab() throws Throwable {
		Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00076\\Downloads\\BOB_1_15.csv");
	}
	
	@And("^choose the bank to book in type and verify matched data is comming under the matched tab$")
    public void choose_the_bank_to_book_in_type_and_verify_matched_data_is_comming_under_the_matched_tab() throws Throwable {
		waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
		bankReconObj.bankReconMatchedData().click();
	
		waitHelper.waitForElementVisible(bankReconObj.bankReconcilationBasis(), 3000, 300);
		bankReconObj.bankReconcilationBasis().click();
		bankReconObj.bankReconcilationBasis().sendKeys("Bank to Book");
		bankReconObj.bankReconcilationBasis().sendKeys(Keys.ENTER);
    }
	
	@And("^Give the recon period from date to verify uploded file data is desplayed under the matched tab$")
    public void give_the_recon_period_from_date_to_verify_uploded_file_data_is_desplayed_under_the_matched_tab() throws Throwable {
		bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodFromMonth6.substring(0, 3) + " "
								+ bankReconTestData.PeriodFromYear6 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodFromMonth6 + " "
						+ bankReconTestData.PeriodFromdate6 + ", " + bankReconTestData.PeriodFromYear6 + "']//span")));
    }

    @And("^Give the recon period to date to verify uploded file data is desplayed under the matched tab$")
    public void give_the_recon_period_to_date_to_verify_uploded_file_data_is_desplayed_under_the_matched_tab() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodToMonth6.substring(0, 3) + " "
								+ bankReconTestData.PeriodToYear6 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodToMonth6 + " "
						+ bankReconTestData.PeriodToDate6 + ", " + bankReconTestData.PeriodToYear6 + "']//span")));
    }

    @And("^upload the file for bank to book basis and verify the data in match tab$")
    public void upload_the_file_for_bank_to_book_basis_and_verify_the_data_in_match_tab() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
    }
    @And("^upload the file for bank to book basis and verify the data in match tab with multiple recipt numbers$")
    public void upload_the_file_for_bank_to_book_basis_and_verify_the_data_in_match_tab_with_multiple_recipt_numbers() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath);
    }
    
    
    //Bank Recon format
    
    BANKRECON_Recon_FormatObj bankReconFormatObj = new BANKRECON_Recon_FormatObj(driver);
    @And("^click on bank recon configuration module$")
    public void click_on_bank_recon_configuration_module() throws Throwable {
    waitHelper.waitForElementVisible(kubsMakerObj.kubsBankRecon(), 3000, 300);
    kubsMakerObj.kubsBankRecon().click();
    }

    @And("^click on bank recon format module$")
    public void click_on_bank_recon_format_module() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconFormatObj.bankReconEyeIcon(), 3000, 300);
    	bankReconFormatObj.bankReconEyeIcon().click();
    }

    @And("^get our bank record$")
    public void get_our_bank_record() throws Throwable {
waitHelper.waitForElementVisible(bankReconFormatObj.bankReconSearchBankName(), 3000, 300);
bankReconFormatObj.bankReconSearchBankName().click();
bankReconFormatObj.bankReconSearchBankName().sendKeys("Bank Of Baroda");
waitHelper.waitForElementVisible(bankReconFormatObj.bankReconApprovedBankFirstRecord(), 3000, 300);
bankReconFormatObj.bankReconApprovedBankFirstRecord().click();
    }

    @And("^click on matching rule tab$")
    public void click_on_matching_rule_tab() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconFormatObj.bankReconDataMatchingRuleTab(), 3000, 300);
    	bankReconFormatObj.bankReconDataMatchingRuleTab().click();
    }

    @And("^get the suggested condition of any one field$")
    public void get_the_suggested_condition_of_any_one_field() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconFormatObj.bankReconDeppositeRecord(), 3000, 300);
    	bankReconFormatObj.bankReconDeppositeRecord().click();
    	waitHelper.waitForElementVisible(bankReconFormatObj.bankReconConditionName(), 3000, 300);    	
    	testData.put("ConditionName", bankReconFormatObj.bankReconConditionName().getText());
    	System.out.println("Condition Name is : "+testData.get("ConditionName"));
    			
    }
    
    @And("^upload the file to verify system show the matched condition as per the configuation$")
    public void upload_the_file_to_verify_system_show_the_matched_condition_as_per_the_configuation() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.csvFilePath); 
    }
    @And("^verify system should show the data as per the match condition$")
    public void verify_system_should_show_the_data_as_per_the_match_condition() throws Throwable {
    	//bankReconObj.bankRecoGridOneAmount().getText();
    	waitHelper.waitForElementVisible(bankReconObj.bankRecoGridOneAmount(), 3000, 300);
    	testData.put("GridOneAmount",bankReconObj.bankRecoGridOneAmount().getText());
    	waitHelper.waitForElementVisible(bankReconObj.bankReconGridViewTwoAmount(), 3000, 300);
    	testData.put("GridTwoAmount", bankReconObj.bankReconGridViewTwoAmount().getText());
    	if(testData.get("ConditionName").equalsIgnoreCase("Fully Matched"))
    	{
    		Assert.assertEquals(testData.get("GridOneAmount"), testData.get("GridTwoAmount"));
    	}
    }
    
    //Text File
    
    @And("^enter bank name and account number for text file$")
    public void enter_bank_name_and_account_number_for_text_file() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.BANKRECONBankName(), 3000, 300);
    	bankReconObj.BANKRECONBankName().click();    	
    	bankReconObj.BANKRECONBankName().sendKeys("MIB");    	
    	bankReconObj.BANKRECONBankName().sendKeys(Keys.ENTER);
    	bankReconObj.BANKRECONBAnkAccountNumber().click();
    	Thread.sleep(1000);
    	bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.DOWN);
    	bankReconObj.BANKRECONBAnkAccountNumber().sendKeys(Keys.ENTER);
    	
    }
    @Then("^upload the text file for process$")
    public void upload_the_text_file_for_process() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.textFilePath); 
    }
    @And("^give the recon period from date for text file$")
    public void give_the_recon_period_from_date_for_text_file() throws Throwable {
    	bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth1.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextFromYear1 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth1 + " "
						+ bankReconTestData.PeriodTextFromdate1 + ", " + bankReconTestData.PeriodTextFromYear1 + "']//span")));
    }

    @And("^give the recon period to date for text file$")
    public void give_the_recon_period_to_date_for_text_file() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth1.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextToYear1 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth1 + " "
						+ bankReconTestData.PeriodTextToDate1 + ", " + bankReconTestData.PeriodTextToYear1 + "']//span")));     
    }    
    @And("^choose book to bank as reconcilation basis$")
    public void choose_book_to_bank_as_reconcilation_basis() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
    	bankReconObj.BANKRECON_UnmatchedData().click();
    	waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
    	Thread.sleep(2000);
    	bankReconObj.bankReconMatchedData().click();
    	waitHelper.waitForElementVisible(bankReconObj.bankReconcilationBasis(), 3000, 300);
    	
    	bankReconObj.bankReconcilationBasis().click();
    	bankReconObj.bankReconcilationBasis().sendKeys("Book to Bank");
    	bankReconObj.bankReconcilationBasis().sendKeys(Keys.DOWN);
    	bankReconObj.bankReconcilationBasis().sendKeys(Keys.ENTER);
    }
    @And("^try to match the unmatched recipt and verify shstem should through the validation message$")
    public void try_to_match_the_unmatched_recipt_and_verify_shstem_should_through_the_validation_message() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    for(int i=1;i<=10;i++)
    {
    	
    try
    {
    	driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
    }
    catch(NoSuchElementException e)
    {
    	break;
    }
    }

    
    for(int i=1;i<=10;i++)
    {
    	
    try
    {
    	driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
    }
    catch(NoSuchElementException e)
    {
    	break;
    }
    }
    waitHelper.waitForElementVisible(bankReconObj.matchTabMatchButton(), 3000, 300);
    bankReconObj.matchTabMatchButton().click();
	Thread.sleep(1000);
	String AlertMessage = javascriptHelper.executeScript(
			"return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText")
			.toString();
	System.out.println("String is : " + AlertMessage);
}
    @And("^give the recon period from date for text file for bank to book basis$")
    public void give_the_recon_period_from_date_for_text_file_for_bank_to_book_basis() throws Throwable {
    	bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth2.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextFromYear2 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth2 + " "
						+ bankReconTestData.PeriodTextFromdate2 + ", " + bankReconTestData.PeriodTextFromYear2 + "']//span")));
    }

    @And("^give the recon period to date for text file for bank to book basis$")
    public void give_the_recon_period_to_date_for_text_file_for_bank_to_book_basis() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth2.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextToYear2 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth2 + " "
						+ bankReconTestData.PeriodTextToDate2 + ", " + bankReconTestData.PeriodTextToYear2 + "']//span")));     
    }
    @Then("^upload the text file in the basis of bank to book for process$")
    public void upload_the_text_file_in_the_basis_of_bank_to_book_for_process() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys("C:\\Users\\inindc00076\\Downloads\\MIB_1.txt");  
    }
    @And("^choose bank to book as reconcilation basis$")
    public void choose_bank_to_book_as_reconcilation_basis() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.BANKRECON_UnmatchedData(), 3000, 300);
    	bankReconObj.BANKRECON_UnmatchedData().click();
    	waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
    	bankReconObj.bankReconMatchedData().click();
    	waitHelper.waitForElementVisible(bankReconObj.bankReconcilationBasis(), 3000, 300);
    	bankReconObj.bankReconcilationBasis().click();
    	bankReconObj.bankReconcilationBasis().sendKeys("Bank to Book");
    	bankReconObj.bankReconcilationBasis().sendKeys(Keys.DOWN);
    	bankReconObj.bankReconcilationBasis().sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
    	bankReconObj.bankReconMatchecTabSaveButton().click();
    }


    @And("^give the recon period from date for text file for book to bank basis$")
    public void give_the_recon_period_from_date_for_text_file_for_book_to_bank_basis() throws Throwable {
    	bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth3.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextFromYear3 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth3 + " "
						+ bankReconTestData.PeriodTextFromdate3 + ", " + bankReconTestData.PeriodTextFromYear3 + "']//span")));
    }

    @And("^give the recon period to date for text file for book to bank basis$")
    public void give_the_recon_period_to_date_for_text_file_for_book_to_bank_basis() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth3.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextToYear3 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth3 + " "
						+ bankReconTestData.PeriodTextToDate3 + ", " + bankReconTestData.PeriodTextToYear3 + "']//span")));     	
    }
    @Then("^upload the text file in the basis of book to bank for process$")
    public void upload_the_text_file_in_the_basis_of_book_to_bank_for_process() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.textFilePath); 
    }
    @And("^try to match the unmatched recipt and verify system allow to match the record$")
    public void try_to_match_the_unmatched_recipt_and_verify_system_allow_to_match_the_record() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
        for(int i=1;i<=10;i++)
        {
        	
        try
        {
        	driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
        }
        catch(NoSuchElementException e)
        {
        	break;
        }
        }

        
        for(int i=1;i<=10;i++)
        {
        	
        try
        {
        	driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
        }
        catch(NoSuchElementException e)
        {
        	break;
        }
    }
    
}
    @And("^match the book record into bank record for text file$")
    public void match_the_book_record_into_bank_record_for_text_file() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
        for(int i=1;i<=10;i++)
        {
        	
        try
        {
        	driver.findElement(By.xpath("//ion-grid[1]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
        }
        catch(NoSuchElementException e)
        {
        	break;
        }
        }

        
        for(int i=1;i<=10;i++)
        {
        	
        try
        {
        	driver.findElement(By.xpath("//ion-grid[2]//datatable-row-wrapper["+i+"]//datatable-body-cell[1]//input")).click();
        }
        catch(NoSuchElementException e)
        {
        	break;
        }

    }
        bankReconObj.reconcilationMatchButton().click();
Thread.sleep(1000);
        String alertMessage = javascriptHelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText").toString();
    Assert.assertEquals(alertMessage, "Data Matched Successfully!!!");
        bankReconObj.reconcilationMatchSaveButton().click();
    }
    @Then("^click on match tab$")
    public void click_on_match_tab() throws Throwable {
    	waitHelper.waitForElementVisible(bankReconObj.bankReconMatchedData(), 3000, 300);
    	  bankReconObj.bankReconMatchedData().click();  
    }
    
    @And("^give the recon period from date for text file for banktobook basis$")
    public void give_the_recon_period_from_date_for_text_file_for_banktobook_basis() throws Throwable {
    	bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth4.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextFromYear4 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth4 + " "
						+ bankReconTestData.PeriodTextFromdate4 + ", " + bankReconTestData.PeriodTextFromYear4 + "']//span")));
    }

    @And("^give the recon period to date for text file for banktobook basis$")
    public void give_the_recon_period_to_date_for_text_file_for_banktobook_basis() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth4.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextToYear4 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth4 + " "
						+ bankReconTestData.PeriodTextToDate4 + ", " + bankReconTestData.PeriodTextToYear4 + "']//span")));
    }
    @Then("^upload the text file in the basis of banktobook for process$")
    public void upload_the_text_file_in_the_basis_of_banktobook_for_process() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.textFilePath); 
    }
    
    @Then("^upload the textfile$")
    public void upload_the_textfile() throws Throwable {
    	Thread.sleep(2000);
		bankReconObj.BANKRECON_BankReconUploadFileButton().sendKeys(bankReconTestData.textFilePath); 
    }

    @Then("^system should through the validation for match those record$")
    public void system_should_through_the_validation_for_match_those_record() throws Throwable {
javascriptHelper.JavaScriptHelper(driver);
Thread.sleep(1000);
String alertMessage = javascriptHelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerText").toString();
    Assert.assertEquals(alertMessage,"Please select proper records Bank side for manual match!!!" );
    }

    @And("^give the recon period from date for textfile$")
    public void give_the_recon_period_from_date_for_textfile() throws Throwable {
    	bankReconObj.BANKRECON_PeriodFromDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextFromMonth5.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextFromYear5 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextFromMonth5 + " "
						+ bankReconTestData.PeriodTextFromdate5 + ", " + bankReconTestData.PeriodTextFromYear5 + "']//span")));
    }

    @And("^give the recon period to date for textfile$")
    public void give_the_recon_period_to_date_for_textfile() throws Throwable {
    	bankReconObj.BANKRECON_BankReconPeriodToDate().click();
		while (true) {
			try {

				driver.findElement(
						By.xpath("//span[contains(text(),'" + bankReconTestData.PeriodTextToMonth5.substring(0, 3) + " "
								+ bankReconTestData.PeriodTextToYear5 + "')]"));
				break;
			} catch (NoSuchElementException e) {
				bankReconObj.calendarNextMonthButton().click();
			}
		}
		Thread.sleep(2000);
		clicksAndActionsHelper
				.doubleClick(driver.findElement(By.xpath("//td[@aria-label='" + bankReconTestData.PeriodTextToMonth5 + " "
						+ bankReconTestData.PeriodTextToDate5 + ", " + bankReconTestData.PeriodTextToYear5 + "']//span")));    
    }
}