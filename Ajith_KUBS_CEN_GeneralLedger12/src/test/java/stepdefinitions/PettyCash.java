package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ArApObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.GL1Obj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.PettyCashObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ArApTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.GL1TestDataType;
import testDataType.InventoryManagementTestDataType;
import testDataType.PettyCashTestDataType;

public class PettyCash {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	
	KUBS_ReviewerObj reviewer = new KUBS_ReviewerObj(driver);;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	ArApTestDataType arApTestDataType =  jsonReader.getArApByName("Maker");
	ArApObj arAPobj = new ArApObj(driver);
	GL1TestDataType gL1TestDataType =  jsonReader.getGL1ByName("Maker");
	GL1Obj gL1obj = new GL1Obj(driver);
	PettyCashObj pettyCashobj = new PettyCashObj(driver);
	PettyCashTestDataType pettyCashTestDataType =  jsonReader.getPettyCashByName("Maker");
	//-------------------------KUBS_PC_UAT_004_001----------------
	

    @Then("^Click on Petty Cash button$")
    public void click_on_petty_cash_button() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.pettyCash_Button(), 20, 500);
    	pettyCashobj.pettyCash_Button().click();
    }

    @Then("^Click on Fund Request eye button$")
    public void click_on_fund_request_eye_button() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.fundRequest_EyeButton(), 20, 500);
    	pettyCashobj.fundRequest_EyeButton().click();
    }

    @Then("^Click on Add button to request fund$")
    public void click_on_add_button_to_request_fund() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.fundRequest_AddButton(), 20, 500);
    	pettyCashobj.fundRequest_AddButton().click();
    }

    @Then("^Click on Request Amount Text Box and entre amount$")
    public void click_on_request_amount_text_box_and_entre_amount() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.requestAmount_TextBox(), 20, 500);
    	pettyCashobj.requestAmount_TextBox().click(); 
    	pettyCashobj.requestAmount_TextBox().sendKeys(pettyCashTestDataType.RequestAmount);
    	pettyCashobj.requestAmount_TextBox().sendKeys(Keys.ENTER);
    }

    @Then("^Click on Save button for saving record$")
    public void click_on_save_button_for_saving_record() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.pettyCashFundRequest_SaveButton(), 20, 500);
    	pettyCashobj.pettyCashFundRequest_SaveButton().click();
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.ARAP_Notification_Close(), 60, 2);
    	pettyCashobj.ARAP_Notification_Close().click();
    }
	
	
    @Then("^Click on Approve button in reviewer stage$")
    public void click_on_approve_button_in_reviewer_stage() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver, pettyCashobj.ReviewerPettyCash_ApproveButton(), 20, 500);
    	pettyCashobj.ReviewerPettyCash_ApproveButton().click();
    	waithelper.waitForElementToVisibleWithFluentWait(driver, reviewer.reviewerAlertRemarks(), 20, 500);
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		waithelper.waitForElementToVisibleWithFluentWait(driver, reviewer.reviewerAlertSubmitButton(), 20, 500);
		reviewer.reviewerAlertSubmitButton().click();
		
    }
	
	//----------KUBS_PC_UAT_004_002-------
    
    
    @Then("^choose from date in calender for petty cash$")
    public void choose_from_date_in_calender_for_petty_cash() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"/+ pettyCashTestDataType.GlMonth + " " + pettyCashTestDataType.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ pettyCashTestDataType.GlMonth + " " + pettyCashTestDataType.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + pettyCashTestDataType.GlFullMonth + " "
				+ pettyCashTestDataType.GlDay + ", " + pettyCashTestDataType.GlYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
    
    
    
    @Then("^choose the To date in calender for petty cash$")
    public void choose_the_to_date_in_calender_for_petty_cash() throws Throwable {
    	while (true) {
			try {

				//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"/+ pettyCashTestDataType.GlToMonth + " " + pettyCashTestDataType.GlToYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ pettyCashTestDataType.GlToMonth + " " + pettyCashTestDataType.GlToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
    	waithelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//td[@aria-label='" + pettyCashTestDataType.GlFullToMonth
				+ " " + pettyCashTestDataType.GlToDate + ", " + pettyCashTestDataType.GlToYear + "']/span")),20, 500);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + pettyCashTestDataType.GlFullToMonth
				+ " " + pettyCashTestDataType.GlToDate + ", " + pettyCashTestDataType.GlToYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
       
     
    
    @Then("^validate voucher number for petty cash$")
    public void validate_voucher_number_for_petty_cash() throws Throwable {
    	
	    while(true) {
	    	try{

	//waithelper.waitForElementwithFluentwait(driver,driver.findElement(By.xpath("//span[contains(text(),'"+pettyCashTestDataType.Voucher+"')]")));


	WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+pettyCashTestDataType.Voucher+"')]"));
	break;


	}


	catch(NoSuchElementException nosuchElement)

	{
		javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());
    	

		inventoryManagamentObj.inventory_Next().click();

	}


	 }

	System.out.println("Record is present in the list");

	  

	 }
    
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

