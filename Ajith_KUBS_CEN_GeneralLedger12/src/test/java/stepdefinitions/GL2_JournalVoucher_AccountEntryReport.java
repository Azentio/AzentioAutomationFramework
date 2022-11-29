package stepdefinitions;

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
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.GL2_JournalVoucher_AccountEntryReportObj;
import resources.BaseClass;
import testDataType.GL2_JournalVoucher_AccountEntryReportTestDataType;

public class GL2_JournalVoucher_AccountEntryReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	GL2_JournalVoucher_AccountEntryReportObj gL2_JournalVoucher_AccountEntryReportObj = new GL2_JournalVoucher_AccountEntryReportObj(
			driver);
	GL2_JournalVoucher_AccountEntryReportTestDataType gL2_JournalVoucher_AccountEntryReportTestDataType = jsonReader
			.getJournalVoucherReportByName("Maker");;
	JavascriptHelper javascripthelper = new JavascriptHelper();

	// -------------------------------@KUBS_GL2_UAT_003_003
	// JournalVoucher----------------------------------------//

	@And("^fill the mandtory field for Journal vourcher$")
	public void fill_the_mandtory_field_for_journal_vourcher() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode(),30, 2);
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode()
				.sendKeys(gL2_JournalVoucher_AccountEntryReportTestDataType.BranchCode);
		for (int i = 0; i <50; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucher_AccountEntryReportTestDataType.BranchCode+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==49) {
					Assert.fail(e.getMessage());
				}
			}
		}
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode()
				.sendKeys(Keys.ENTER);
		
//		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_GlCode()
//				.sendKeys(gL2_JournalVoucher_AccountEntryReportTestDataType.GLCode);
//		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_GlCode().sendKeys(Keys.ENTER);
	}

	@Then("^select Transaction from date Journal vourcher$")
	public void select_transaction_from_date_journal_vourcher() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_FromDate(), 5, 500);
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_FromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLMonth + " "
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]")),
								5, 500);
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLMonth
								+ " " + gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLFullMonth + " "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLDay + ", "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);

	}

	@Then("^select Transaction to date Journal vourcher$")
	public void select_transaction_to_date_journal_vourcher() throws InterruptedException {
//		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ToDate(), 5, 500);
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ToDate().click();

		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLToMonth + " "
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]")),
								5, 500);
				WebElement monthAndYear = driver.findElement(By
						.xpath("//span[contains(text(),'" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLToMonth
								+ " " + gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth(), 5, 500);
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLFullToMonth + " "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLToDate + ", "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

	@And("^click on view button for record$")
	public void click_on_view_button_for_record() throws InterruptedException {
		for (int i = 0; i <= 15; i++) {
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ViewButton(), 5,
						500);
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ViewButton().click();
				break;

			} catch (ElementClickInterceptedException e) {
				if (i == 15) {
					e.printStackTrace();
				}
			}
		}
//		Thread.sleep(2000);

	}
	@And("^Select the Transaction Ref no for journal Voucher$")
    public void select_the_transaction_ref_no_for_journal_voucher() throws Throwable {
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher);
		for (int i = 0; i <50; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher+"')]")).isDisplayed();
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.DOWN);
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
    }
	@And("^Select the Transaction Ref no for Reversal journal Voucher$")
    public void select_the_transaction_ref_no_for_reversal_journal_voucher() throws Throwable {
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse);
		for (int i = 0; i <50; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse+"')]")).isDisplayed();
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.DOWN);
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    }

	@Then("^validate Journal vourcher number$")
	public void validate_journal_vourcher_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
//		javascripthelper
//				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		while (true) {
			try {
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher + "')]"));
				Assert.assertTrue(VoucherNum.isDisplayed());
				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");
	}

//-------------------------------@KUBS_GL2_UAT_003_005 Reversal----------------------------------------//

	@Then("^validate Journal vourcher Reversal number$")
	public void validate_journal_vourcher_Reversal_number() throws InterruptedException {

//		javascripthelper.JavaScriptHelper(driver);
//		Thread.sleep(500);
//		javascripthelper
//				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());

//		Thread.sleep(2000);
		while (true) {
			try {
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse + "')]"));
				Assert.assertTrue(VoucherNum.isDisplayed());
				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");
	}

	// -------------------------------@KUBS_GL2_UAT_008_002 all the details
	// JournalVoucher----------------------------------------//

	@Then("^validate all the details for Journal vourcher$")
	public void validate_all_the_details_for_journal_vourcher() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper
				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher + "')]")),
						5, 500);
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher + "')]"));

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher1 + "')]")),
						5, 500);
				WebElement VoucherNum1 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher1 + "')]"));

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher2 + "')]")),
						5, 500);
				WebElement VoucherNum2 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher2 + "')]"));

				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");

	}

	// -------------------------------@KUBS_GL2_UAT_008_003 all the details for JV
	// reversal----------------------------------------//

	@Then("^validate all the details for JV reversal$")
	public void validate_all_the_details_for_jv_reversal() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper
				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse + "')]")),
								5, 500);
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse + "')]"));

				waithelper
				.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse1 + "')]")),
						5, 500);
				WebElement VoucherNum1 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse1 + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");

	}

}
