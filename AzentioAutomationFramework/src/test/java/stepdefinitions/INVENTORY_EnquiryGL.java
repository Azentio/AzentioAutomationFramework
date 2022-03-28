package stepdefinitions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import pageobjects.INVENTORY_EnquiryGLObj;
import resources.BaseClass;
import testDataType.INVENTORY_EnquiryGLTestDataType;

public class INVENTORY_EnquiryGL extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	
	AzentioLogin kubsLogin =new AzentioLogin(driver);
	
	JsonConfig jsonConfig=new JsonConfig();
	INVENTORY_EnquiryGLObj iNVENTORY_EnquiryGLObj=new INVENTORY_EnquiryGLObj(driver);
	INVENTORY_EnquiryGLTestDataType iNVENTORY_EnquiryGLTestDataType = new INVENTORY_EnquiryGLTestDataType();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	

	 @Then("^click on report segment button$")
	    public void click_on_report_segment_button() throws Throwable {
		 Thread.sleep(2000);
		 waithelper.waitForElement(driver, 3000, iNVENTORY_EnquiryGLObj.inventory_ReportIcon());
		 iNVENTORY_EnquiryGLObj.inventory_ReportIcon().click();
		 waithelper.waitForElement(driver, 3000, iNVENTORY_EnquiryGLObj.inventory_EnquiryMenu());
		 Assert.assertTrue(iNVENTORY_EnquiryGLObj.inventory_EnquiryMenu().isDisplayed());
		
	}

	 @And("^click on enquiry menu$")
	    public void click_on_enquiry_menu()  {
		 waithelper.waitForElement(driver, 3000, iNVENTORY_EnquiryGLObj.inventory_EnquiryMenu());
		 iNVENTORY_EnquiryGLObj.inventory_EnquiryMenu().click();
		
	}

	 @Then("^click on edit icon of fiancial transaction menu$")
	    public void click_on_edit_icon_of_fiancial_transaction_menu()  {
		 waithelper.waitForElement(driver, 3000, iNVENTORY_EnquiryGLObj.inventory_FinancialTransactionField());
		 Assert.assertTrue(iNVENTORY_EnquiryGLObj.inventory_FinancialTransactionField().isDisplayed());
		
		iNVENTORY_EnquiryGLObj.inventory_FinancialTransactionField().click();

	}

	@And("^fill the mandtory field$")
    public void fill_the_mandtory_field()  {
		iNVENTORY_EnquiryGLTestDataType = jsonReader.getInventoryEnquiryGLByName("Maker");
		iNVENTORY_EnquiryGLObj.inventory_BranchCode().sendKeys(iNVENTORY_EnquiryGLTestDataType.BranchCode);
		iNVENTORY_EnquiryGLObj.inventory_BranchCode().sendKeys(Keys.ENTER);
	
		
		iNVENTORY_EnquiryGLObj.inventory_GlCode().sendKeys(iNVENTORY_EnquiryGLTestDataType.GLCode);
		iNVENTORY_EnquiryGLObj.inventory_GlCode().sendKeys(Keys.ENTER);
	
		iNVENTORY_EnquiryGLObj.inventory_FromDate().click();

	
		
		javascripthelper.JavaScriptHelper(driver);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+iNVENTORY_EnquiryGLTestDataType.GLMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+iNVENTORY_EnquiryGLTestDataType.GLMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			iNVENTORY_EnquiryGLObj.inventory_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+iNVENTORY_EnquiryGLTestDataType.GLFullMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLDay+", "+iNVENTORY_EnquiryGLTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	

	
		waithelper.waitForElement(driver, 3000, iNVENTORY_EnquiryGLObj.inventory_ToDate());
		iNVENTORY_EnquiryGLObj.inventory_ToDate().click();
	
	
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+iNVENTORY_EnquiryGLTestDataType.GLToMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+iNVENTORY_EnquiryGLTestDataType.GLToMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			iNVENTORY_EnquiryGLObj.inventory_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+iNVENTORY_EnquiryGLTestDataType.GLFullToMonth+" "+iNVENTORY_EnquiryGLTestDataType.GLToDate+", "+iNVENTORY_EnquiryGLTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

	@And("^click view button$")
	public void click_view_button() {
		iNVENTORY_EnquiryGLObj.inventory_ViewButton().click();

	}
}
