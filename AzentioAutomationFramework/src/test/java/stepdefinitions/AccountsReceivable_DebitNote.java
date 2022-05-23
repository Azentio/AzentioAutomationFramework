package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
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
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.AccountsReceivable_DebitNoteTestDataType;
import testDataType.AccountsReceivable_ReceiptsReversalsTestDataType;

public class AccountsReceivable_DebitNote {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	AccountsReceivable_ReceiptsReversalsTestDataType ReceiptsReversalsTestDataType=jsonReader.getReceiptsReversalsdata("Maker");
	AccountsReceivable_DebitNoteTestDataType DebitNoteTestDataType=jsonReader.getDebitNotedata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
//	@And("^user should navigate to accounts receivable menu$")
//	public void user_should_navigate_to_accounts_receivable_menu() throws InterruptedException {
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
//		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu());
//		accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu().click();
//	}
	
	@When("^click on eye button of receivable debit note$")
	public void click_on_eye_button_of_receivable_debit_note() throws InterruptedException {
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_EyeButton());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_EyeButton().click();

	}

//	@And("^click on add button for cancel receipt$")
//	public void click_on_add_button_for_cancel_receipt() {
//		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_AddButton());
//		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_AddButton().click();
//	}

	@And("^Fill the required fields in debit note screen$")
	public void fill_the_required_fields_in_debit_note_screen() throws InterruptedException{
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys(DebitNoteTestDataType.ReceivableName);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(DebitNoteTestDataType.BPName);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(Keys.ENTER);
		
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().click();
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().sendKeys(DebitNoteTestDataType.InvoiceNumber);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount());
		clicksAndActionHelper.doubleClick(accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount());
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount().sendKeys(DebitNoteTestDataType.DebitNoteAmount);
		
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_CostCenter().click();
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_CostCenter());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_CostCenter().sendKeys(DebitNoteTestDataType.CostCenter);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_CostCenter().sendKeys(Keys.ENTER);
		
//		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description());
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description().sendKeys(DebitNoteTestDataType.DebitNotesDescription);
	}
	
	@Then("^save and submit the record of receivable debit note$")
	public void save_and_submit_the_record_of_receivable_debit_note() throws IOException, ParseException, InterruptedException{
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_SaveButton());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_SaveButton().click();
		
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(DebitNoteTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	String emptystring = "";
		String ar[] = message.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
		
	}

	@Then("^checker should approved the record of receivable debit note$")
	public void checker_should_approved_the_record_of_receivable_debit_note() throws IOException, ParseException, InterruptedException {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(DebitNoteTestDataType.RemarkByChecker);
		waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		
		waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}
	
	@When("^click on eye button of payment settlement against bill$")
	public void click_on_eye_button_of_payment_settlement_against_bill() throws Throwable {
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_EyeButton());
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_EyeButton().click();
	}

	@And("^click on add button for payment settlement against bill$")
	public void click_on_add_button_for_payment_settlement_against_bill() throws Throwable {
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_AddButton());
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_AddButton().click();
	}

	@And("^Fill the required fields to adjust against bill$")
	public void fill_the_required_fields_to_adjust_against_bill() throws Throwable {
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_PaymentOption());
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_PaymentOption().sendKeys(DebitNoteTestDataType.PaymentOption);
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_PaymentOption().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPNamePaymentSettlement());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPNamePaymentSettlement().sendKeys(DebitNoteTestDataType.BPName);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPNamePaymentSettlement().sendKeys(Keys.ENTER);
		
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_ValueDateCalendar().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + DebitNoteTestDataType.ValueMonth + " "
						+ DebitNoteTestDataType.ValueYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + DebitNoteTestDataType.ValueMonth + " " + DebitNoteTestDataType.ValueYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
			}
		}
		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + DebitNoteTestDataType.ValueFullMonth + " "
				+ DebitNoteTestDataType.ValueDate + ", " + DebitNoteTestDataType.ValueYear + "']/span"));
		clicksAndActionHelper.doubleClick(ValueDate);
		
		javascripthelper.scrollIntoViewAndClick(accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_Footer());
		
		while (true) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//div[contains(text(),'"+ DebitNoteTestDataType.InvoiceNumber +"')]")));
				driver.findElement(By.xpath("//div[contains(text(),'"+ DebitNoteTestDataType.InvoiceNumber +"')]"));
				break;
				
			}

			catch (NoSuchElementException nosuchElement) {
					try {
							accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_DisabledNextButton().isEnabled();
							System.out.println("Element is not available");
							break;
							
					}

					catch (NoSuchElementException nosuchElement1) {
						waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton());
						accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton().click();
					}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//div[contains(text(),'"+DebitNoteTestDataType.InvoiceNumber+"')]/../../datatable-body-cell[1]/div/ion-checkbox")));
		driver.findElement(By.xpath("//div[contains(text(),'"+DebitNoteTestDataType.InvoiceNumber+"')]/../../datatable-body-cell[1]/div/ion-checkbox")).click();
		
		Thread.sleep(1000);
		javascripthelper.scrollToElemet(accountsReceivable_DebitNoteObj.accountsReceivable_PaymentSettlement_Description());
		accountsReceivable_DebitNoteObj.accountsReceivable_PaymentSettlement_Description().sendKeys(DebitNoteTestDataType.Description);
		
		
	}

	@Then("^Save and submit the payment settlement$")
	public void save_and_submit_the_payment_settlement() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_SaveButton());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_SaveButton().click();
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_ConfirmYes());
		accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_ConfirmYes().click();
		
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(DebitNoteTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	String emptystring = "";
		String ar[] = message.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
	}
	
	@Then("^checker should approved the payment settlement against bill$")
	public void checker_should_approved_the_payment_settlement_against_bill() throws InterruptedException, IOException, ParseException  {
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(DebitNoteTestDataType.RemarkByChecker);
		waithelper.waitForElement(driver, 4000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		
		waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}
	 
	@Then("^get the receivable debit number to verify$")
    public void get_the_receivable_debit_number_to_verify() throws IOException {
		waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_LatestDebitNumber());
		String latestDebitNumber = accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_LatestDebitNumber().getText();
		System.out.println(latestDebitNumber);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(latestDebitNumber);
    }
	
	@Then("^click on eye button of appropriation to verify$")
    public void click_on_eye_button_of_appropriation_to_verify() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		javascripthelper.scrollIntoView(accountsReceivable_DebitNoteObj.accountsReceivable_Appropriation_EyeButton());
		accountsReceivable_DebitNoteObj.accountsReceivable_Appropriation_EyeButton().click();
    }
	
	@Then("^Verify the receivable adjusted against bill is not available for appropriation$")
	public void verify_the_receivable_adjusted_against_bill_is_not_available_for_appropriation() throws InterruptedException, IOException, ParseException{
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		javascripthelper.scrollIntoView(accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_Footer());
		
		while (true) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//div[contains(text(),'" + jsonWriter.readdata() + "')]")));
				boolean debitnotenumber = driver.findElement(By.xpath("//div[contains(text(),'"+jsonWriter.readdata()+"')]")).isDisplayed();
				System.out.println("Receivables once adjusted against Bill is available for appropriation on Receipt appropriation screen");
				if(debitnotenumber==true)
				{
					Assert.fail();
				}
				break;
				
			}

			catch (NoSuchElementException nosuchElement) {
					try {
							accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_DisabledNextButton().isEnabled();
							System.out.println("Receivables once adjusted against Bill is not available for appropriation on Receipt appropriation screen");
							break;
							
					}

					catch (NoSuchElementException nosuchElement1) {
						waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton());
						accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton().click();
					}
			}
		}
		//Below code also works
//		for (int i = 0; i <= 20; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//div[contains(text(),'" + jsonWriter.readdata() + "')]")));
//				boolean debitnotenumber = driver.findElement(By.xpath("//div[contains(text(),'"+jsonWriter.readdata()+"')]")).isDisplayed();
//				System.out.println("Receivables once adjusted against Bill is available for appropriation on Receipt appropriation screen");
//				if(debitnotenumber==true)
//				{
//					Assert.fail();
//				}
//				break;
//
//			}
//
//			catch (NoSuchElementException nosuchElement) {
//
//				waithelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton());
//				accountsReceivable_DebitNoteObj.accountPayable_PaymentSettlement_NextButton().click();
//			}
//			if(i==20)
//			System.out.println("Receivables once adjusted against Bill is not available for appropriation on Receipt appropriation screen");
//		}
	}
	 
}