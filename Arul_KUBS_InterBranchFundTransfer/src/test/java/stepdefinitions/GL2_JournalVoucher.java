package stepdefinitions;

import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
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

	
}
