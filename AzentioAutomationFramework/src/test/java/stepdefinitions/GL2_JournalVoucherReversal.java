package stepdefinitions;

import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.GL2_JournalVoucherReversalObj;
import resources.BaseClass;

public class GL2_JournalVoucherReversal extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();

	GL2_JournalVoucherReversalObj gL2_JournalVoucherReversalObj = new GL2_JournalVoucherReversalObj(driver);

	@Then("^Click on Journal Voucher Reversal EyeIcon$")
	public void click_on_journal_voucher_reversal_eyeicon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_EyeButton(), 5, 500);
		gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_EyeButton().click();
		// Thread.sleep(2000);

	}

	@Then("^Click on Journal Voucher Reversal Pencil Icon$")
	public void click_on_journal_voucher_reversal_pencil_icon() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_PencilIcon(), 5, 500);
		gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_PencilIcon().click();

	}

}
