package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.GL2_JournalVoucherObj;
import resources.BaseClass;
import testDataType.GL2_JournalVoucherTestDataType;

public class GL2_JournalVoucher extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();

	GL2_JournalVoucherObj gL2_JournalVoucherObj = new GL2_JournalVoucherObj(driver);
	GL2_JournalVoucherTestDataType gL2_JournalVoucherTestDataType = jsonReader.getJournalVoucherByName("Maker");

	@Then("^Click on General Ledger Transaction Field$")
	public void click_on_general_ledger_transaction_field() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction(), 10, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction().click();

	}

	@Then("^Click on Journal Voucher EyeIcon$")
	public void click_on_journal_voucher_eyeicon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton().click();

	}

	@Then("^Click on Journal Voucher AddButton$")
	public void click_on_journal_voucher_addbutton() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton().click();
	}
	@And("^User Select the branch code$")
    public void user_select_the_branch_code() throws Throwable {
		// BranchCode
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode(),
						5, 500);
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().click();
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(gL2_JournalVoucherTestDataType.BranchCode);
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Currency$")
    public void user_select_the_currency() throws Throwable {
    	// Currency
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Currency(), 5,
    					500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(gL2_JournalVoucherTestDataType.Currency);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Journal Voucher$")
    public void user_select_the_journal_voucher() throws Throwable {
    	// JournalType
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType(),
    					5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(gL2_JournalVoucherTestDataType.JournalType);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(Keys.ENTER);
    }

	 @And("^User Select the profit center$")
	    public void user_select_the_profit_center() throws Throwable {
	
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter(),
					5, 500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().sendKeys(gL2_JournalVoucherTestDataType.ProfitCenter);
			for (int i = 0; i <300; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucherTestDataType.ProfitCenter+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==299) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().sendKeys(Keys.ENTER);
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.costOrDeparmentRequiredClose(),
					5, 500);
			gL2_JournalVoucherObj.costOrDeparmentRequiredClose().click();
	    }
	 @And("^User Select cost center or Department$")
	    public void user_select_cost_center_or_department() throws Throwable {
	       try {
	    	   waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter(),
						5, 500);
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().click();
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().sendKeys(gL2_JournalVoucherTestDataType.CostCenter);
				for (int i = 0; i <300; i++) {
					try {
						driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucherTestDataType.CostCenter+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==299) {
							Assert.fail(e.getMessage());
						}
					}
				}
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().sendKeys(Keys.ENTER);
		} catch (Exception e) {
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Department(),
					5, 500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().sendKeys(gL2_JournalVoucherTestDataType.Department);
			for (int i = 0; i <300; i++) {
			 try {
				 driver.findElement(By.xpath("//span[contains(text(),'"+gL2_JournalVoucherTestDataType.Department+"')]")).isDisplayed();
					break;
			} catch (Exception e2) {
				if (i==299) {
					Assert.fail(e.getMessage());
				}
			}
		}
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().sendKeys(Keys.ENTER);
		}   
	    }
	    @And("^User enter the remark for Journal Voucher$")
	    public void user_enter_the_remark_for_journal_voucher() throws Throwable {
	    	// Remark
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Remark(), 5,
					500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(gL2_JournalVoucherTestDataType.Remark);
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(Keys.ENTER);
	    }

	@Then("^Add Debit credit record$")
	public void add_debit_credit_record() throws InterruptedException {
		// DrCr
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click();

		// Select Debit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Debit(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();

		// Glcode
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();
		// Thread.sleep(2000);
		// GlCodeDebit
		//waithelper.waitForElement(driver, 2000, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
		for (int i = 0; i <50; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();
				break;
			} catch (Exception e) {
				if (i==49) {
					Assert.fail(e.getMessage());
				}
			}
		}

		// DebitAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(gL2_JournalVoucherTestDataType.DebitAmount);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);

		// ActionButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();

		// ------Credit--//
		// DrCrSecond
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click();

		// Select Credit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Credit(), 5,
				500);
		for (int i = 0; i <= 150; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();
				break;
			} catch (Exception e) {
				if (i == 150) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// Glcode-Second
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();

		// GlCode-Credit
		// Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit(), 5, 500);
		for (int i = 0; i <200; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

		// CreditAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(gL2_JournalVoucherTestDataType.CreditAmount);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);

		/*
		 * //ActionButton waithelper.waitForElement(driver,
		 * 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond());
		 * gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();
		 */
	}

	@Then("^save the Journal Voucher record$")
	public void save_the_journal_voucher_record() {

		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Save(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Save().click();

	}

	// --------------------KUBS_GL2_UAT_003_002---------------//

	@Then("^Add one Debit multiple credit record$")
	public void add_one_debit_multiple_credit_record() throws InterruptedException {
		// ----------------DebitRecord----------//
		// DrCr
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click();

		// Select Debit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Debit(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();

		// Glcode
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();

		// GlCodeDebit
		waithelper.waitForElement(driver, 2000, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();

		// DebitAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(gL2_JournalVoucherTestDataType.DebitAmount);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);

		// ActionButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();

		// -----------------------------CreditRecordFirst--------------------------//
		// DrCrSecond
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click();

		// Select Credit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Credit(), 10,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();

		// Glcode-Second
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();

		// GlCode-Credit

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();

		// CreditAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount()
				.sendKeys(gL2_JournalVoucherTestDataType.CreditAmountfirst);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);

		// ActionButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();

		// -----------------------------CreditRecordSecond--------------------------//
		// DrCrSecond
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird().click();

		// Select Credit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Credit(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();

		// Glcode-Third
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeThird(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeThird().click();

		// GlCode-CreditSecond

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCreditSecond(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCreditSecond().click();

		// CreditAmountSecond(
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond()
				.sendKeys(gL2_JournalVoucherTestDataType.CreditAmountSecond);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().sendKeys(Keys.ENTER);

	}

}
