package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import resources.BaseClass;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;

public class ACCOUNSPAYABLE_ManualPayout extends BaseClass {
	WebDriver driver=BaseClass.driver;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj=new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	WaitHelper waitHelper= new WaitHelper(driver);
	Map<String,String> payoutData= new HashMap<>();
	JavascriptHelper javascrtiptHelper= new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUTSAPAYBLE_AutoPayoutTestDataType ManualPayoutData=jsonConfig.getAccountsPayableAutoPayoutTestDataByName("Maker");
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj= new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
		


	
}
