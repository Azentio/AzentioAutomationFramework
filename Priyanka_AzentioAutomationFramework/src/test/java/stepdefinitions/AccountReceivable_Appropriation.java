package stepdefinitions;



import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.AccountReceivable_AppropriationObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountReceivable_AppropriationTestDataType;


public class AccountReceivable_Appropriation extends BaseClass { 
		WebDriver driver = BaseClass.driver;
		JsonConfig jsonReader = new JsonConfig();
		ConfigFileReader configFileReader = new ConfigFileReader();
		ConfigFileReader config=new ConfigFileReader();
		DropDownHelper dropDownHelper;
		WaitHelper waithelper = new WaitHelper(driver) ;
		// maker//
		JavascriptHelper javascripthelper = new JavascriptHelper();
	
			
		AccountReceivable_AppropriationObj accountReceivable_AppropriationObj = new AccountReceivable_AppropriationObj(driver);

		AccountReceivable_AppropriationTestDataType accountReceivable_AppropriationTestDataType = new AccountReceivable_AppropriationTestDataType();

				
	
	

    @Then("^Click on Account Recivable Appropriation eye button$")
    public void click_on_account_recivable_appropriation_eye_button()  {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(accountReceivable_AppropriationObj.accountReceivable_Appropriation_EyeButton());
    	waithelper.waitForElement(driver, 2000,accountReceivable_AppropriationObj.accountReceivable_Appropriation_EyeButton());
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_EyeButton().click();
    
       
    }

    @Then("^Check receipt is available for Appropriation$")
    public void check_receipt_is_available_for_appropriation() throws InterruptedException{
    	accountReceivable_AppropriationTestDataType = jsonReader.getAppropriationByName("Maker");
    	//EntityBranch
    	waithelper.waitForElement(driver, 2000,accountReceivable_AppropriationObj.accountReceivable_Appropriation_EntityBranch());
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_EntityBranch().click();
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_EntityBranch().sendKeys(accountReceivable_AppropriationTestDataType.EntityBranch);
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_EntityBranch().sendKeys(Keys.ENTER);
    	
    	//ReceiptReferenceNumber
    	waithelper.waitForElement(driver, 2000,accountReceivable_AppropriationObj.accountReceivable_Appropriation_ReceiptReferenceNumber());
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_ReceiptReferenceNumber().click();
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_ReceiptReferenceNumber().sendKeys(accountReceivable_AppropriationTestDataType.ReceiptReferenceNumber);
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_ReceiptReferenceNumber().sendKeys(Keys.ENTER);
    	
    	
    }

    @Then("^enter App Amount check the calculation for Outstanding amount for Receivable$")
    public void enter_app_amount_check_the_calculation_for_outstanding_amount_for_receivable() throws InterruptedException  {
    	accountReceivable_AppropriationTestDataType = jsonReader.getAppropriationByName("Maker");
    	
    	String outstandingAmt = accountReceivable_AppropriationObj.accountReceivable_Appropriation_OutstandingAmt().getText();
    	System.out.println(outstandingAmt);
    	//AppropriationAmount
    	waithelper.waitForElement(driver, 2000,accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationAmount());
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationAmount().click();
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationAmount().sendKeys(accountReceivable_AppropriationTestDataType.AppropriationAmount);
    	accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationAmount().sendKeys(Keys.ENTER);
    	Thread.sleep(2000);

    	
   }
    @Then("^Click on Appropriation Save button$")
    public void click_on_appropriation_save_button() throws InterruptedException  {
        

	waithelper.waitForElement(driver, 2000,accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationSave() );
	accountReceivable_AppropriationObj.accountReceivable_Appropriation_AppropriationSave().click();
	Thread.sleep(2000);
    javascripthelper.JavaScriptHelper(driver);
    String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
    System.out.println("Message:" +str);

    }
}