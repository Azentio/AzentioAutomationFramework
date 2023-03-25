package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.FixedAsset_AssetCreationObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FixedAsset_AssetCreation extends BaseClass {
	
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
//	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = new FixedAsset_AssetCreationTestDataType();
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");

	
	@Then("^Fill Form asset Creation$")
	public void fill_form_asset_Creation() throws InterruptedException  {
		fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.BranchCode);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.BillReferenceNo);
		Thread.sleep(900);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);
		
	}

	
		 
	    @Then("^fill the asset item details asset Creation$")
	    public void fill_the_asset_item_details_asset_Creation() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    
	    //changes
	    @Then("^fill the asset item details asset Creation impaired$")
	    public void fill_the_asset_item_details_asset_Creation_impaired() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	Random random = new Random();
	    	int randomNumber=random.nextInt(5000-999)+5000;
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumberimpaired+randomNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    @Then("^fill the asset item details asset Creation revalued$")
	    public void fill_the_asset_item_details_asset_Creation_revalued() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	Random random = new Random();
	    	int randomNumber=random.nextInt(5000-999)+5000;
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumberRevalued+randomNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    @Then("^fill the asset item details asset Creation replaced$")
	    public void fill_the_asset_item_details_asset_Creation_replaced() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	Random random = new Random();
	    	int randomNumber=random.nextInt(5000-999)+5000;
	    waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumberReplaced+randomNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    @Then("^fill the asset item details asset Creation amended$")
	    public void fill_the_asset_item_details_asset_Creation_amended() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	Random random = new Random();
	    	int randomNumber=random.nextInt(5000-999)+5000;
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumberamended+randomNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    

	    
	    @Then("^click on report icon$")
	    public void click_on_report_icon() throws InterruptedException {
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
	    }

	    @When("^click on eye button of asset creation$")
	    public void click_on_eye_button_of_asset_creation() {
			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton());
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton().click();
	    }
		
		@And("^click on add button to create asset record$")
		public void click_on_add_button_to_create_asset_record() {
			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton());
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton().click();
		}
		
		 @And("^Fill the required fields to create asset against GRN Ref number$")
			public void fill_the_required_fields_to_create_asset_against_GRN_Ref_number() {
			 	
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(fixedAsset_AssetCreationTestDataType.BranchCode);
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(Keys.ENTER);
				
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(Keys.ENTER);
				
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.GRN_ReferenceNumber);
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(Keys.ENTER);
				
//				waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber());
//				fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.BillReferenceNumber);
//				fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(Keys.ENTER);
				
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.ExternalReferenceNumber);
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(Keys.ENTER);
				
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(fixedAsset_AssetCreationTestDataType.AssetLifeUnit);
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(Keys.ENTER);
			}
		 
		 @Then("^Save the asset creation record against GRN Ref number$")
		    public void save_the_asset_creation_record_against_GRN_Ref_number() throws InterruptedException, IOException, ParseException{
		    	
		    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton());
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton().click();
		    	
		    }
		 
		 @And("^navigate to fixed asset items tab to add item details$")
		    public void navigate_to_fixed_asset_items_tab_to_add_item_details() throws InterruptedException, IOException, ParseException{
		    	
		    	Thread.sleep(2000);
		    	javascripthelper.JavaScriptHelper(driver);
				String str = javascripthelper.executeScript(
						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
						.toString();
				System.out.println("Message:" + str);
		    	
		    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
		    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		    	
		    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId());
		    	String id=fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId().getText();
		    	jsonWriter.addReferanceData(id);
				System.out.println("Reference ID:" +id);
		    	for (int i = 1; i <= 35; i++) {
					try {
				    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
						waithelper.waitForElement(driver, i, referanceID);
						referanceID.click();
				    	System.out.println(referanceID);
//						Assert.assertTrue(referanceID.isDisplayed());
						break;
					} catch (NoSuchElementException e) {
						waithelper.waitForElement(driver,4000,fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton());
						fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton().click();
					}
				}
		    	String before_xpath="//span[contains(text(),'";
		    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
		    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
		    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
		    	
		    	Thread.sleep(1000);
		    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems());
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems().click();
		    	
		    }
		 
		 @Then("^Fill the hsn code and verify the total tax amount is auto populated$")
		    public void Fill_the_hsn_code_and_verify_the_total_tax_amount_is_auto_populated() throws InterruptedException, IOException, ParseException{
		    	
		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_InputTaxCreditValue());
		    	boolean enabled=fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_InputTaxCreditValue().isEnabled();
		    	System.out.println("The input tax credit value field is enabled - " +enabled);
		    	
		    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode());
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode().sendKeys(fixedAsset_AssetCreationTestDataType.HSNcode);
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode().sendKeys(Keys.ENTER);
		    	Thread.sleep(1000);
		    	String inputTaxCreditValue = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[10].value").toString();
		    	System.out.println("Auto populated input tax credit value is - " +inputTaxCreditValue);
		    }
	    
	    

}