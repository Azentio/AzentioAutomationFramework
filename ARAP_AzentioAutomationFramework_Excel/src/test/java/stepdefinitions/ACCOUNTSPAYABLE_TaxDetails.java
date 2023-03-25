package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ACCOUNTSPAYABLE_TaxDetails {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","ARAP_InvoiceBoooking", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	@And("^user update the data set ID for invoice booking Tax Details$")
	  public void user_update_the_data_set_id_for_invoice_booking_tax_details() {
	  testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_010_01_D2");   
	  }
	@Then("^Get the tax details and check$")
	public void get_the_tax_details_and_check() throws InterruptedException {
		waithelper.waitForElement(driver, 3000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
		waithelper.waitForElement(driver, 3000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_InvoiceNumberSearch().sendKeys(testData.get("InvoiceNumber"));
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_FirstEyeButton().click();
		waithelper.waitForElement(driver, 3000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
		Thread.sleep(2000);
		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetails());
		Thread.sleep(2000);
//	    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();

		// CODES FOR SGST AND CGST

		/*
		 * double taxSGST = Double.parseDouble(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[24].value").
		 * toString()); int invoiceamountSGST = Integer.parseInt(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[25].value").
		 * toString()); double taxamountSGST = Double.parseDouble(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[26].value").
		 * toString());
		 * 
		 * double taxCGST = Double.parseDouble(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[29].value").
		 * toString()); int invoiceamountCGST = Integer.parseInt(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[30].value").
		 * toString()); double taxamountCGST = Double.parseDouble(javascripthelper.
		 * executeScript("return document.getElementsByTagName('input')[31].value").
		 * toString());
		 */

		double taxIGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[2].value").toString());
		int invoiceamountIGST = Integer.parseInt(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[3].value").toString());
		double taxamountIGST = Double.parseDouble(javascripthelper.executeScript("return document.getElementsByClassName('form-control')[4].value").toString());

//	    	double taxamtSGST = Double.valueOf((taxSGST)/100 * invoiceamountSGST);
//	    	double taxamtCGST = Double.valueOf((taxCGST)/100 * invoiceamountCGST);
		// double taxamt = Double.valueOf(Double.parseDouble(taxSGST)/100 *
		// Integer.parseInt(invoiceamountSGST));
//	    	System.out.println("Calculated SGST tax amount is : " +taxamtSGST);
//	    	System.out.println("Calculated CGST tax amount is : " +taxamtCGST);

		// CODES FOR SGST AND CGST

		/*
		 * if(Double.valueOf((taxSGST)/100 * invoiceamountSGST).equals(taxamountSGST)) {
		 * System.out.println("SGST Tax details are correctly displayed"); }else
		 * System.out.println("Tax details are not correctly displayed");
		 * 
		 * if(Double.valueOf((taxCGST)/100 * invoiceamountCGST).equals(taxamountCGST)) {
		 * System.out.println("CGST Tax details are correctly displayed"); }else
		 * System.out.println("Tax details are not correctly displayed");
		 */

		if (Double.valueOf((taxIGST) / 100 * invoiceamountIGST).equals(taxamountIGST)) {
			System.out.println("IGST Tax details are correctly displayed");
		} else {
			System.out.println("Tax details are not correctly displayed");
		}

		waithelper.waitForElement(driver, 3000,aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton());
		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_TaxDetailsCloseButton().click();

	}
	
	}
