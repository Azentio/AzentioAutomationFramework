package stepdefinitions;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPayable_InvoiceBookingObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountPayable_InvoiceBookingTestDataType;

public class AccountPayable_InvoiceBooking extends BaseClass {
	

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
		
		AzentioLogin login;
		AccountPayable_InvoiceBookingObj accountPayable_InvoiceBookingObj = new AccountPayable_InvoiceBookingObj(driver);

		AccountPayable_InvoiceBookingTestDataType accountPayable_InvoiceBookingTestDataType = new AccountPayable_InvoiceBookingTestDataType();

		JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
		JsonDataReaderWriter reader = new JsonDataReaderWriter();
		ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	
	@When("^click on eye button of invoice booking$")
	public void click_on_eye_button_of_invoice_booking() {
	waithelper.waitForElement(driver, 3000,accountPayable_InvoiceBookingObj.accountsPayable_InvoiceBooking_EyeButton());
	accountPayable_InvoiceBookingObj.accountsPayable_InvoiceBooking_EyeButton().click();

	}
	
	@Then("^Get the tax details and check$")
    public void get_the_tax_details_and_check() throws InterruptedException  {
    javascripthelper.JavaScriptHelper(driver);
    accountPayable_InvoiceBookingTestDataType = jsonReader.getInvoiceBookingByName("Maker");
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch().sendKeys(accountPayable_InvoiceBookingTestDataType .InvoiceNumber);
    waithelper.waitForElement(driver, 2000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton().click();
    waithelper.waitForElement(driver, 3000, accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
    Thread.sleep(2000);
    javascripthelper.scrollIntoViewAndClick(accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
    Thread.sleep(2000);
    accountPayable_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();
   
    double taxSGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[24].value").toString());
    int invoiceamountSGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByTagName('input')[25].value").toString());
    double taxamountSGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[26].value").toString());
   
    double taxCGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[29].value").toString());
    int invoiceamountCGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByTagName('input')[30].value").toString());
    double taxamountCGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByTagName('input')[31].value").toString());
     
//     double taxamtSGST = Double.valueOf((taxSGST)/100 * invoiceamountSGST);
//     double taxamtCGST = Double.valueOf((taxCGST)/100 * invoiceamountCGST);
//      double taxamt = Double.valueOf(Double.parseDouble(taxSGST)/100 * Integer.parseInt(invoiceamountSGST));
//     System.out.println("Calculated SGST tax amount is : " +taxamtSGST);
//     System.out.println("Calculated CGST tax amount is : " +taxamtCGST);
    if(Double.valueOf((taxSGST)/100 * invoiceamountSGST).equals(taxamountSGST))
    {
    System.out.println("SGST Tax details should be correctly displayed");
    }else System.out.println("Tax details should not be correctly displayed");
   
    if(Double.valueOf((taxCGST)/100 * invoiceamountCGST).equals(taxamountCGST))
    {
    System.out.println("CGST Tax details should be correctly displayed");
    }else System.out.println("Tax details should not be correctly displayed");
    }
   
	
	
	
	
	
	
	
	
	
	

}
