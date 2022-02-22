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
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSETS_AssetCreationTestDataType;

public class FIXEDASSETS_AssetCreation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetCreationObj fIXEDASSETS_AssetCreationObj = new FIXEDASSETS_AssetCreationObj(driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	FIXEDASSETS_AssetCreationTestDataType fIXEDASSETS_AssetCreationTestDataType=jsonReader.getAssetCreationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@When("^click on eye button of asset creation$")
    public void click_on_eye_button_of_asset_creation() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_EyeButton());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_EyeButton().click();
    }
	
	@And("^click on add button to create asset record$")
	public void click_on_add_button_to_create_asset_record() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AddButton());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AddButton().click();
	}
	
	@And("^Fill the required fields to create asset$")
	public void fill_the_required_fields_to_create_asset() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BranchCode());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(fIXEDASSETS_AssetCreationTestDataType.BranchCode);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetCode());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(fIXEDASSETS_AssetCreationTestDataType.AssetCode);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(Keys.ENTER);
		
//		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber());
//		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.GRN_ReferenceNumber);
//		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.BillReferenceNumber);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.ExternalReferenceNumber);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(fIXEDASSETS_AssetCreationTestDataType.AssetLifeUnit);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(Keys.ENTER);
	}

    @Then("^Save and submit the asset creation record$")
    public void save_and_submit_the_asset_creation_record() throws InterruptedException, IOException, ParseException{
    	
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
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AddButton());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AddButton().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetItemNumber());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetItemNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.AssetItemNumber);
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetItemDescription());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetItemDescription().sendKeys(fIXEDASSETS_AssetCreationTestDataType.AssetItemDescription);
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetCapitalizationDate());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetCapitalizationDate().click();
    	
    	javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + fIXEDASSETS_AssetCreationTestDataType.CapitalizationMonth + " "
						+ fIXEDASSETS_AssetCreationTestDataType.CapitalizationYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + fIXEDASSETS_AssetCreationTestDataType.CapitalizationMonth + " " + fIXEDASSETS_AssetCreationTestDataType.CapitalizationYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_ClickOnNextMonth().click();
			}
		}
		 WebElement CapitalizationDate = driver.findElement(By.xpath("//td[@aria-label='" + fIXEDASSETS_AssetCreationTestDataType.CapitalizationFullMonth + " "
				+ fIXEDASSETS_AssetCreationTestDataType.CapitalizationDate + ", " + fIXEDASSETS_AssetCreationTestDataType.CapitalizationYear + "']/span"));
		clicksAndActionHelper.doubleClick(CapitalizationDate);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue().click();
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue().sendKeys(Keys.NUMPAD0);
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue().sendKeys(fIXEDASSETS_AssetCreationTestDataType.AssetValue);
//		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetValue().sendKeys(Keys.chord(fIXEDASSETS_AssetCreationTestDataType.AssetValue));
		Thread.sleep(1000);
    	if(fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SalvagePercentage().isEnabled())
    	{
    		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SalvagePercentage());
    		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SalvagePercentage().sendKeys(fIXEDASSETS_AssetCreationTestDataType.SalvagePercentage);
    	}else {
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SalvageValue());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_SalvageValue().sendKeys(fIXEDASSETS_AssetCreationTestDataType.SalvageValue);
    	}
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems_SaveButton());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems_SaveButton().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetContractLinkage());
    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_AssetContractLinkage().click();
    	
//    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_PO_ReferenceNumber());
//    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_PO_ReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.PO_Creation);
//    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_PO_ReferenceNumber().sendKeys(Keys.ENTER);
    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems_SaveButton());
//    	fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems_SaveButton().click();
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(fIXEDASSETS_AssetCreationTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
    	String t = "";
		String ar[] = message.split(" ");
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
    	
    }
    
    @Then("^checker should approved the asset creation record$")
    public void checker_should_approved_the_asset_creation_record() throws IOException, ParseException, InterruptedException {
//    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
//    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(fIXEDASSETS_AssetCreationTestDataType.CheckerRemark);
		waithelper.waitForElement(driver, 3000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waithelper.waitForElement(driver, 5000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
    }
    
    @Then("^click on first eye button to get the Asset Reference Number$")
    public void click_on_first_eye_button_to_get_the_Asset_Reference_Number() throws InterruptedException {
    	javascripthelper.JavaScriptHelper(driver);
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_CreatedRecordEyeButton());
		fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_CreatedRecordEyeButton().click();
		Thread.sleep(2000);
		String assetrefno = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[4].value").toString();
    	System.out.println("Asset Reference Number is : " +assetrefno);
    }

}
