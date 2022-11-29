package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSET_AssetAmendmentObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FixedAssetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSET_AssetAmendment extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String AssetCreation;
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetAmendmentObj assetAmendmentObj = new FIXEDASSET_AssetAmendmentObj(driver);
	FIXEDASSET_AssetAmendmentData assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig.getAssetCreationByName("Maker");
	Map<String,String> testData= new HashMap<>();
	@Given("^Lauch The Azentio Url$")
	public void lauch_the_azentio_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
		Thread.sleep(1000);
	}

	@Then("^Click Second Segment Icon$")
	public void click_second_segment_icon() throws Throwable {

		// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixedTransfericon());
		assetAmendmentObj.fixedTransfericon().click();
	}

	@And("^Click on fixed Asset Module$")
	public void click_on_fixed_asset_module() throws Throwable {

		// ----------TO CLICK THE FIXED ASSET MODULE---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_FixedAssets());
		assetAmendmentObj.fixed_FixedAssets().click();
	}

	@Then("^click on Asset creation Eye icon$")
	public void click_on_asset_creation_eye_icon() throws Throwable {
		// ----------TO CLICK THE FIXED ASSETCREATION---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetCreataionEye());
		assetAmendmentObj.fixed_AssetCreataionEye().click();
	}

	@And("^Click to view First record and store RefNo$")
	public void click_to_view_first_record_and_store_refno() throws Throwable {
		// ----------TO CLICK THE FIXED ASSETCREATION---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetTableRef());
		AssetCreation = assetAmendmentObj.fixed_AssetTableRef().getText();
		System.out.println(AssetCreation);
	}
	@And("^get the approved asset reference number to do the asset ammendment$")
    public void get_the_approved_asset_reference_number_to_do_the_asset_ammendment() throws Throwable {
     waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetApprovedReferenceNumber(), 3000, 300);
     
    }
//document.getElementsByClassName('native-input sc-ion-input-md')[4].value
	@Then("^Click on Asset Ammendent submodule Eye Icon$")
	public void click_on_asset_ammendent_submodule_eye_icon() throws Throwable {

		// ----------TO CLICK AMMENDMENT EYE ICON------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(assetAmendmentObj.fixed_AssetAmmendmentEye());
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetAmmendmentEye());
		assetAmendmentObj.fixed_AssetAmmendmentEye().click();
	}

	@And("^Click on Add Icon$")
	public void click_on_add_icon() throws Throwable {

		// ----------TO CLICK ADD ICON--------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixedAssetAmmendmentAdd());
		assetAmendmentObj.fixedAssetAmmendmentAdd().click();
	}

	@Then("^Enter Asset Referance Number$")
	public void enter_asset_referance_number() throws Throwable {

		// ---------ENTER THE REQUEST REFERANCE NUMBER---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetReferenceNumber());
	//	assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(AssetCreation);
		assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetAmendmentObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Enter Asset Item Number$")
	public void enter_asset_item_number() throws Throwable {

		// ----------ENTER ASSET ITEM NUMBER-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetItemCode());
		assetAmendmentObj.fixed_AssetItemCode().click();
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
		assetAmendmentObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	}

	@Then("^Choose Modification Type Which we need$")
	public void choose_modification_type_which_we_need() throws Throwable {

		// -----------CHOOSE THE MODIFICATION TYPE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ModificationType());
		assetAmendmentObj.fixed_ModificationType().click();
		assetAmendmentObj.fixed_ModificationType().sendKeys(assetAmendmentData.modificationType2);
		assetAmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
	}

	@And("^Click on calender Icon$")
	public void click_on_calender_icon() throws Throwable {

		// ------------CLICK ON CALENDER ICON------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetCalenderDate());
		assetAmendmentObj.fixed_AssetCalenderDate().click();
	}

	@And("^Choose a current date in calender$")
	public void choose_a_current_date_in_calender() throws Throwable {
		waitHelper.waitForElement(driver,2000,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")) );
    	driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
		.click();
waitHelper.waitForElement(driver,2000 , driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Year  + "']")));
driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Year  + "']")).click();
driver.findElement(By.xpath("//span[text()='" + assetAmendmentData.Month + "']")).click();
//tbody/tr[5]/td[@aria-label='April 30, 2022']
waitHelper.waitForElement(driver, 2000,
		driver.findElement(By.xpath("//td[@aria-label='"+assetAmendmentData.FullMonth+" "+assetAmendmentData.Day+", "+assetAmendmentData.Year+"']")));
driver.findElement(By.xpath("//td[@aria-label='"+assetAmendmentData.FullMonth+" "+assetAmendmentData.Day+", "+assetAmendmentData.Year+"']")).click();
    

	/*	// -------------CHOOSE DATE---------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ assetAmendmentData.Month + " " + assetAmendmentData.Year + "')]")));
				driver.findElement(By.xpath(
						"//span[contains(text(),'" + assetAmendmentData.Month + " " + assetAmendmentData.Year + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				assetAmendmentObj.fixed_CalenderNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.FullMonth + " "
						+ assetAmendmentData.Day + ", " + assetAmendmentData.Year + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.FullMonth + " "
				+ assetAmendmentData.Day + ", " + assetAmendmentData.Year + "']/span"));
		
		clickAndActionHelper.doubleClick(Click);
		clickAndActionHelper.clickOnElement(Click);
		*/
	}

	@Then("^Save the Asset Record$")
	public void save_the_asset_record() throws Throwable {
		//-----------------SAVE THE RECORD---------------//

		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().isDisplayed();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.AssetAmendment_Save());
		assetAmendmentObj.AssetAmendment_Save().click();
	}

	@And("^Click on Maker Notification$")
	public void click_on_maker_notification() throws Throwable {
		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_MakerNotification());
		assetAmendmentObj.fixed_MakerNotification().click();
	}

	@Then("^Select Saved record and click on action icon$")
	public void select_saved_record_and_click_on_action_icon() throws Throwable {
		// -----------Submit Icon-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ReferanceId());
		String Referance_id = assetAmendmentObj.fixed_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ActionButton());
		assetAmendmentObj.fixed_ActionButton().click();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_Submit());
		assetAmendmentObj.fixed_Submit().click();
		Thread.sleep(2000);
	}

	@And("^Submit the Asset record to Reviewer$")
	public void submit_the_asset_record_to_reviewer() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_Remark());
		assetAmendmentObj.fixed_Remark().click();
		waitHelper.waitForElement(driver, 5000, assetAmendmentObj.fixed_Remark());
		assetAmendmentObj.fixed_Remark().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_RemarkSubmit());
		assetAmendmentObj.fixed_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ReviewerId());
		reviwerId = assetAmendmentObj.fixed_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER STAGE

	@Given("^Launch the Azentio Reviewer Page$")
	public void launch_the_azentio_reviewer_page() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer( readerData.readdata());
	}

	@And("^Click the Reviewer Notification icon$")
	public void click_the_reviewer_notification_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotificationIcon());
		reviewerObj.reviewerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@Then("^Click the submitted record from maker$")
	public void click_the_submitted_record_from_maker() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + readerData.readReferancedata() + aftr_xpath)).click();
		javaScriptHelper.JSEClick(reviewerObj.reviewer_action_button());
		//reviewerObj.reviewer_action_button().click();		
	}

	@And("^Click the Approve icon from Reviewer End$")
	public void click_the_approve_icon_from_reviewer_end() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@Then("^Enter the remark and submit the Record$")
	public void enter_the_remark_and_submit_the_record() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER STAGE
	@Given("^Launch the Azentio Checker page$")
	public void launch_the_azentio_checker_page() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker();
	}

	@Then("^Click the Security management module$")
	public void click_the_security_management_module() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
	}

	@And("^Click the open pool Edit icon$")
	public void click_the_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@Then("^Claim the record Approved from Reviewer$")
	public void claim_the_record_approved_from_reviewer() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@And("^Click the Checker Notification icon$")
	public void click_the_checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@Then("^Click the Action Icon from claimed record$")
	public void click_the_action_icon_from_claimed_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
	//	waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
	//			+ readerData.readReferancedata()
	//			+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		for (int i = 0; i < 9; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
				break;
			} catch (NoSuchElementException e) {
				
			}
			catch (StaleElementReferenceException e) {
				
			}
			
		}
		
		
	}

	@And("^Click on Approve icon$")
	public void click_on_approve_icon() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@Then("^Submit the Record from Checker End$")
	public void submit_the_record_from_checker_end() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	// span[contains(text(),'LAND-BUILDING-Building-01_BR0003_2')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]

	@And("^Click the search icon$")
	public void click_the_search_icon() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetSearch());
		assetAmendmentObj.fixed_AssetSearch().click();
	}

	@Then("^Enter the Asset Referance No$")
	public void enter_the_asset_referance_no() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetSearchCode());
		assetAmendmentObj.fixed_AssetSearchCode().click();
		assetAmendmentObj.fixed_AssetSearchCode().sendKeys(AssetCreation);
	}

	@When("^capture the Asset Grid view$")
	public void capture_the_asset_grid_view() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr + AssetCreation + aftr)));
		driver.findElement(By.xpath(befr + AssetCreation + aftr)).click();
	}

	// **************************@KUBS_FAT_UAT_011_002***********************//
	
    @Then("^Choose Modification Type Which need$")
    public void choose_modification_type_which_need() throws Throwable {
    	
		// -----------CHOOSE THE MODIFICATION TYPE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_ModificationType());
		assetAmendmentObj.fixed_ModificationType().click();
		assetAmendmentObj.fixed_ModificationType().sendKeys(assetAmendmentData.modificationType1);
		assetAmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
    }

//	@And("^Enter Asset Life Value$")
//	public void enter_asset_life_value() throws Throwable {
//
//		// ----------------ENTER ASSET VALUE----------------//
//		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
//		assetAmendmentObj.fixed_AssetLife().click();
//		assetAmendmentObj.fixed_AssetLife().clear();
//		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLife);
//	}
	
	// ********************@KUBS_FAT_UAT_011_003***********************//
	
    @And("^Enter Asset Life lesser than Value$")
    public void enter_asset_life_lesser_than_value() throws Throwable {
		// ----------------ENTER ASSET LESSER THAN VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
		assetAmendmentObj.fixed_AssetLife().click();
		assetAmendmentObj.fixed_AssetLife().clear();
		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLifelesser);    	
    }

    
    //*********************@KUBS_FAT_UAT_011_004********************//
    
    @And("^Enter Asset Life greater than Value$")
    public void enter_asset_life_greater_than_value() throws Throwable {
		// ----------------ENTER ASSET GREATER THAN VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmendmentObj.fixed_AssetLife());
		assetAmendmentObj.fixed_AssetLife().click();
		assetAmendmentObj.fixed_AssetLife().clear();
		assetAmendmentObj.fixed_AssetLife().sendKeys(assetAmendmentData.assetLifegreater);
    }
}
