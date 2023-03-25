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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.FIXEDASSETS_AssetUndertakingObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSETS_AssetSaleTestDataType;
import testDataType.FIXEDASSETS_AssetUndertakingTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSETS_AssetUndertaking {
	WebDriver driver = BaseClass.driver;
//	KUBS_Login login = new KUBS_Login(driver);
	AzentioLogin login = new AzentioLogin(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	FIXEDASSETS_AssetUndertakingObj fIXEDASSETS_AssetUndertakingObj = new FIXEDASSETS_AssetUndertakingObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	FIXEDASSETS_AssetUndertakingTestDataType fIXEDASSETS_AssetUndertakingTestDataType=jsonReader.getAssetUndertakingdata("Maker");
	FixedAsset_AssetCreationTestDataType assetCreation =jsonReader.getAssetCreationByName("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	
	@And("^user should navigate to fixed assets menu$")
	public void user_should_navigate_to_fixed_assets_menu() throws InterruptedException  {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_DirectionButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_DirectionButton().click();
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Menu());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Menu().click();
	}
	
	@When("^click on eye button of asset transfer$")
    public void click_on_eye_button_of_asset_transfer()  {
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_EyeButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_EyeButton().click();
    }

    @And("^click on add button for asset transfer$")
    public void click_on_add_button_for_asset_transfer()  {
    	
    	//waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AddButton());
    	for (int i = 0; i <30; i++) {
			try {
				fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AddButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
    }

    @And("^Fill the required fields for asset transfer$")
    public void fill_the_required_fields_for_asset_transfer()  {
    	
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber());
    //	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.AssetReferenceNumberForTransfer);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(assetCreation.AssetCode);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.NewBranch);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer().click();
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes().click();
    }
    
    @And("^Fill the required fields for asset undertaking$")
    public void fill_the_required_fields_for_asset_undertaking()  {
    	
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber());
    //	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.AssetReferenceNumberUndertaking);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(assetCreation.AssetCode);
    	
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.NewBranch);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer().click();
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes().click();
    }
    
    @And("^Fill the required fields for impaired asset transfer$")
    public void fill_the_required_fields_for_impaired_asset_transfer()  {
    	
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.AssetReferenceNumberImpairedForTransfer);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.NewBranch);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer().click();
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes().click();
    }
    
    @And("^Fill the required fields for revalued asset transfer$")
    public void fill_the_required_fields_for_revalued_asset_transfer()  {
    	
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber());
    //	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.AssetReferenceNumberRevaluedForTransfer);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(assetCreation.AssetCode);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_AssetReferenceNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.NewBranch);
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_NewBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Transfer().click();
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_TransferYes().click();
    }
    
    @Then("^Save and submit the asset transfer$")
    public void save_and_submit_the_asset_transfer() throws IOException, ParseException, InterruptedException  {
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_SaveButton().click();
    	Thread.sleep(2000);
    	javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
    	
    	//waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
		for (int i = 0; i <30; i++) {
			try {
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
    	
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
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 5000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
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
    
    @Given("^User should go to the kubs url and login as a maker user for FAUM$")
    public void user_should_go_to_the_kubs_url_and_login_as_a_maker_user_for_faum() throws InterruptedException {
    	login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker2("Checker");
    }
    
    @And("^Maker user should received the transferred asset$")
    public void maker_user_should_received_the_transferred_asset() throws IOException, ParseException, InterruptedException  {
//    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Received());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_Received().click();
		
		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_ReceivedYes());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_ReceivedYes().click();
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_SaveButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_SaveButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
		.click();
		
    }
    
    @Then("^maker user should submit in undertaking$")
    public void maker_user_should_submit_in_undertaking() throws InterruptedException, IOException  {
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
		
		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 5000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
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
    
    @And("^approve the record by the final checker user$")
	public void approve_the_record_by_the_final_checker_user() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		
		for (int i = 1; i < 10; i++) {
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			
			waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i
					+ after_xpath_for_action)).click();
			
				//reader.addReferanceData(referance_id);
				
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark().sendKeys(fIXEDASSETS_AssetUndertakingTestDataType.CheckerRemark);
				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
				Thread.sleep(2000);
				waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		    	clicksAndActionHelper.moveToElement(recordstatus);
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
				break;
		}
	}
    
    @When("^click on eye button of asset undertaking$")
    public void click_on_eye_button_of_asset_Undertaking()  {
		
		waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_EyeButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_EyeButton().click();
    }
    
    @Then("^click on first view button to see the Transferred to Branch$")
    public void click_on_first_view_button_to_see_the_transferred_to_branch()  {
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_FirstViewButton());
    	fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_FirstViewButton().click();
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_TransferredBranch());
    	String transferToBranch	=fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetUndertaking_TransferredBranch().getText();
    	System.err.println(transferToBranch);
    	System.out.println("Transfer To Branch - " +transferToBranch);
    }
    
    @Then("^click on first view icon to see the transferred$")
    public void click_on_first_view_icon_to_see_the_transferred() {
    	for (int i = 0; i <30; i++) {
			try {
				fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_FirstViewButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_ViewTransferredBranch());
    	String transferredBranch = fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetTransfer_ViewTransferredBranch().getText();
    	System.out.println("Transferred to Branch: "+transferredBranch);
    	
    }
    
    
    
    
    
    
    
    
    
    
    

}
