package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BankRecon_ReconFormatObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BankRecon_ReconFormatTestDataType;

public class BankRecon_ReconFormat  extends BaseClass{
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BankRecon_ReconFormatObj bankRecon_ReconFormatObj = new BankRecon_ReconFormatObj(driver);
	BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType = jsonReader.getBankReconByName("Maker");
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	Map<String, String> bankReconTestData;	
	String path = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBankRecon = new ExcelData(path,"BankRecon","DataSet ID");
	 	}
