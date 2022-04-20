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
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSETS_AssetSaleTestDataType;

public class FIXEDASSETS_AssetSale {
	
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	FIXEDASSETS_AssetSaleTestDataType fIXEDASSETS_AssetSaleTestDataType=jsonReader.getAssetSaledata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@And("^user should navigate to fixed asset menu$")
	public void user_should_navigate_to_fixed_asset_menu() {
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_DirectionButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_DirectionButton().click();
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_Menu());
		fIXEDASSETS_AssetSaleObj.fixedAssets_Menu().click();
	}
	
	@When("^click on eye button of asset sale$")
    public void click_on_eye_button_of_asset_sale() {
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_EyeButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_EyeButton().click();
    }

	@And("^click on add button to create sale asset record$")
	public void click_on_add_button_to_create_sale_asset_record()  {
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AddButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AddButton().click();
	}
	
	@And("^Fill the required fields to sale asset in profit$")
	public void fill_the_required_fields_to_sale_asset_in_profit() throws InterruptedException  {
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.AssetReferenceNumberForProfit);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(Keys.ENTER);
		
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ItemNumber);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(fIXEDASSETS_AssetSaleTestDataType.SaleValue);

		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Currency);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ActionableBy);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Remark);
	}
	
	@And("^Fill the required fields to sale asset in loss$")
	public void fill_the_required_fields_to_sale_asset_in_loss() throws InterruptedException  {
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.AssetReferenceNumberForLoss);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_AssetReferenceNumber().sendKeys(Keys.ENTER);
		
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().click();
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ItemNumberForLoss);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ItemNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().sendKeys(fIXEDASSETS_AssetSaleTestDataType.SaleValue);
		
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Currency);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Currency().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(fIXEDASSETS_AssetSaleTestDataType.ActionableBy);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ActionableBy().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Remark().sendKeys(fIXEDASSETS_AssetSaleTestDataType.Remark);
	}
	
    @Then("^Save and submit the asset sale record$")
    public void save_and_submit_the_asset_sale_record() throws IOException, ParseException, InterruptedException {
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Save().click();
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
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(fIXEDASSETS_AssetSaleTestDataType.RemarkByMaker);
    	
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
    
    @Then("^checker should approved the asset sale$")
    public void checker_should_approved_the_asset_sale() throws InterruptedException, IOException, ParseException{
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(fIXEDASSETS_AssetSaleTestDataType.CheckerRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
       
    }

    @Then("^click on first eye button to get the profit earned$")
    public void click_on_first_eye_button_to_get_the_profit_earned() throws InterruptedException {
javascripthelper.JavaScriptHelper(driver);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();
    	
		String bv = javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value").toString();
		Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
		System.out.println("Book value is: " +bookvalue);
    	
		String sv = javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value").toString();
		Double salevalue = Double.parseDouble(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " +salevalue);
		
		String  pft= javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[2].value").toString();
		Double profit = Double.parseDouble(pft.replaceAll("[^0-9/.]", ""));
		
		profit=salevalue-bookvalue;
		System.out.println("Profit earned is : "+profit);
		
//    	String loss = javascripthelper.executeScript("return document.getElementsByTagName('input')[17].value").toString();
//    	System.out.println("Loss accrued is: " +loss);
    	
    }
    @Then("^click on first eye button to get the loss earned$")
    public void click_on_first_eye_button_to_get_the_loss_earned() throws InterruptedException {
    	javascripthelper.JavaScriptHelper(driver);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ViewEarnedProfitEyeButton().click();
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_BookValue().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SaleValue().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_ProfitOnSaleGL().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_LossOnSaleGL().click();
    	
    	String bv = javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[0].value").toString();
    	Double bookvalue = Double.valueOf(bv.replaceAll("[^0-9/.]", ""));
    	System.out.println("Book value is: " +bookvalue);
    	
		String sv = javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-valid ng-touched')[1].value").toString();
		Double salevalue = Double.valueOf(sv.replaceAll("[^0-9/.]", ""));
		System.out.println("Sale value is: " +salevalue);
		
		String loss1 = javascripthelper.executeScript("return document.getElementsByTagName('input')[17].value").toString();
		Double loss = Double.valueOf(loss1.replaceAll("[^0-9/.]", ""));
		
		loss=bookvalue-salevalue;
		System.out.println("Loss accrued is: " +loss);
				
    }



}
