package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetCreationObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.FIXEDASSETS_AssetUndertakingObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSETS_AssetRevaluationTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSETS_AssetRevaluation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetCreationObj fIXEDASSETS_AssetCreationObj = new FIXEDASSETS_AssetCreationObj(driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	FIXEDASSETS_AssetUndertakingObj fIXEDASSETS_AssetUndertakingObj = new FIXEDASSETS_AssetUndertakingObj(driver);
	FixedAsset_AssetCreationTestDataType assetCreation =jsonReader.getAssetCreationByName("Maker");
	WaitHelper waithelper = new WaitHelper(driver);
	FIXEDASSETS_AssetRevaluationTestDataType fIXEDASSETS_AssetRevaluationTestDataType=jsonReader.getAssetRevaluationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@When("^click on eye button of asset revaluation$")
    public void click_on_eye_button_of_asset_revaluation() {
		//waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton());
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton().click();
    }
	
	@And("^click on add button for asset revaluation$")
	public void click_on_add_button_for_asset_revaluation() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AddButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AddButton().click();
	}
	
	@And("^Fill the required fields for asset revaluation$")
	public void fill_the_required_fields_for_asset_revaluation() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AssetReferenceNumber());
		// fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetRevaluationTestDataType.AssetReferenceNumber);
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AssetReferenceNumber().sendKeys(assetCreation.AssetCode);
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AssetReferenceNumber().sendKeys(Keys.ENTER);
		
		//waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_ItemNumber());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_ItemNumber().click();
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_ItemNumber().sendKeys(Keys.DOWN);
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_ItemNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_Currency());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_Currency().sendKeys(fIXEDASSETS_AssetRevaluationTestDataType.CurrencyForRevaluation);
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_Currency().sendKeys(Keys.ENTER);
		
	}

    @Then("^Save and submit the asset revaluation$")
    public void save_and_submit_the_asset_revaluation() throws InterruptedException, IOException, ParseException{
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SaveButton());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SaveButton().click();
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
//				Assert.assertTrue(referanceID.isDisplayed());
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
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(fIXEDASSETS_AssetRevaluationTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
    	String emptystring = "";
		String ar[] = message.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
    	
    }
    
    @Then("^checker should approved the asset revaluation record$")
    public void checker_should_approved_the_asset_revaluation_record() throws IOException, ParseException, InterruptedException {
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		Thread.sleep(2000);
		while(true)
		{
		try
		{
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		break;
		}
		catch(NoSuchElementException e)
		{
			
		}
		}
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(fIXEDASSETS_AssetRevaluationTestDataType.CheckerRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waithelper.waitForElement(driver, 5000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
    }

}
