package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLE_AccountsPayableReportObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSRECEIVABLE_AccountsReceivableReportObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSRECEIVALE_ReceivableReport extends BaseClass {
	WebDriver driver=BaseClass.driver;
	KUBS_MakerObj makerObj=new KUBS_MakerObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj creditNoteObj=new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSRECEIVABLE_AccountsReceivableReportObj accountsReceivableReportObj=new ACCOUNTSRECEIVABLE_AccountsReceivableReportObj(driver);
	Map<String,String> testData=new HashMap<>();
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj =new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	JsonConfig jsonConfig=new JsonConfig();
	BrowserHelper browserHelper=new BrowserHelper(driver);
	JavascriptHelper javascriptHelper= new JavascriptHelper();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData= jsonConfig.getAccountsPayableContractReportTestDataByName("Maker");
        
    
}
