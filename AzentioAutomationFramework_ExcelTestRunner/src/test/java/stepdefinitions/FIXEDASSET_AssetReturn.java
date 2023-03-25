package stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.FIXEDASSET_AssetAmmendentObj;
import pageobjects.FIXEDASSET_AssetReturnObj;
import pageobjects.FIXEDASSET_AssetRevalueationObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FIXED_ASSET_AssetDeAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FIXEDASSET_AssetReturnTestData;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSET_AssetReturn extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	FIXEDASSET_AssetReturnObj assetReturnObj = new FIXEDASSET_AssetReturnObj(driver);
	FIXEDASSET_AssetAmendmentData assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonConfig.getAssetCreationByName("Maker");
	String RefNo;
	String referance_id;
	String reviwerId;
	JavascriptHelper javascriptHelper=new JavascriptHelper();

	Map<String,String> assetReferenceNo=new HashMap<String,String>();
	FIXEDASSET_AssetReturnTestData assetReturnTestData=jsonConfig.getFixedAssetReturnTestDataByUserName("Maker");
	FIXEDASSET_fixedAssetObj fixedAssetObj=new FIXEDASSET_fixedAssetObj(driver);
	FIXEDASSET_AssetRevalueationObj assetRevaluvationObj=new FIXEDASSET_AssetRevalueationObj(driver);
	FIXEDASSET_AssetAmmendentObj assetAmmendmentObj=new FIXEDASSET_AssetAmmendentObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj=new FIXEDASSETS_AssetImpairementObj(driver);
	FIXED_ASSET_AssetDeAllocationObj fixedAsset_AssetDeallocationObj = new FIXED_ASSET_AssetDeAllocationObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	@Given("^Navigate the Azentio url$")
	public void navigate_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
		Thread.sleep(1000);
	}

    @Then("^Click Second Segmant Icon$")
    public void click_second_segmant_icon() throws Throwable {
    	//-----------CLICK ON SEGMANT ICON------------//
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixedTransfericon());
    	assetReturnObj.fixedTransfericon().click();
    }

    @And("^Click main module fixed Asset Module$")
    public void click_main_module_fixed_asset_module() throws Throwable {
        //-----------CLICK ON FIXED ASSET MODULE---------//
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_FixedAssets());
    	assetReturnObj.fixed_FixedAssets().click();
    }
    
    @Then("^Asset Replacement Store the Referance No$")
    public void asset_replacement_store_the_referance_no() throws Throwable {
        //----------ASSET REPLACEMENT REF NO------------//
    	javaScriptHelper.JavaScriptHelper(driver);
    	javaScriptHelper.scrollIntoView(assetReturnObj.fixed_AssetReplacementEye());
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetReplacementEye());
    	assetReturnObj.fixed_AssetReplacementEye().click();
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetTableRef());
    	RefNo = assetReturnObj.fixed_AssetTableRef().getText();
    	System.out.println(RefNo);
    }

    @Then("^Asset Return Click on Eye Icon$")
    public void asset_return_click_on_eye_icon() throws Throwable {
    	//-----------CLICK ON EYE ICON---------------//
    	javaScriptHelper.JavaScriptHelper(driver);
    	javaScriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnEyeButton());
    	//waitHelper.waitForElement(driver, 2000, assetReturnObj.fixedAssetAssetReturnEyeButton());
    	for (int i = 0; i <30; i++) {
			try {
				assetReturnObj.fixedAssetAssetReturnEyeButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
    }

    @And("^Asset Return Add Icon button$")
    public void asset_return_add_icon_button() throws Throwable {
    	//------------CLICK ON ADD ICON-------------//
    	//waitHelper.waitForElement(driver, 2000, assetReturnObj.fixedAssetReturnAdd());
    	for (int i = 0; i <30; i++) {
			try {
				assetReturnObj.fixedAssetReturnAdd().click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
    }
	

	@Then("^Give Asset Replacement Referance Number$")
	public void give_asset_replacement_referance_number() throws Throwable {
		// -----------GIVE ASSET REF NO----------------//
		waitHelper.waitForElement(driver, 2000, assetReturnObj.assetReturnAssetReferenceNumber());
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(RefNo);
		Thread.sleep(1500);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

    @And("^Select Asset Return Item Number$")
    public void select_asset_return_item_number() throws Throwable {
       //-----------ASSET ITEM NUMBER----------//
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.assetReturnAssetItemNo());
    	assetReturnObj.assetReturnAssetItemNo().click();
    	Thread.sleep(1000);
    	assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.DOWN);
    	assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.ENTER);
    }
    
    @Then("^Click on save button in asset Return$")
    public void click_on_save_button_in_asset_return() throws Throwable {
        //-----------SAVE RECORD-----------//
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixetReturnSaveButton());
    	assetReturnObj.fixetReturnSaveButton().click();
    }

    @And("^Click on Maker Notification icon button$")
    public void click_on_maker_notification_icon_button() throws Throwable {		
		// ------------Maker Notification icon---------//
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_MakerNotification());
		assetReturnObj.fixed_MakerNotification().click();
    }
    
    @Then("^Click on Action icon$")
    public void click_on_action_icon() throws Throwable {
		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_ReferanceId());
		String Referance_id = assetReturnObj.fixed_ReferanceId().getText();
		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_ActionButton());
		assetReturnObj.fixed_ActionButton().click();
    }

    @And("^Approve the Asset Return Record$")
    public void approve_the_asset_return_record() throws Throwable {
		// ---------------SUBMIT RECORD--------------//
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_Submit());
		assetReturnObj.fixed_Submit().click();
		Thread.sleep(2000);
    }
    
    @Then("^Enter Remark and click submit button$")
    public void enter_remark_and_click_submit_button() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		assetAmendmentData = jsonConfig.getAssetAmendmentByName("Asset");
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_Remark());
		assetReturnObj.fixed_Remark().click();
		waitHelper.waitForElement(driver, 5000, assetReturnObj.fixed_Remark());
		assetReturnObj.fixed_Remark().sendKeys(assetAmendmentData.Remark);
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_RemarkSubmit());
		assetReturnObj.fixed_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_ReviewerId());
		reviwerId = assetReturnObj.fixed_ReviewerId().getText();
		String ReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(ReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(ReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		readerData.addData(filanReviewerID);
		System.out.println(reviwerId);
    }
    
    // REVIEWER
    
    @Given("^Launch the Azentio URL as Reviewer$")
    public void launch_the_azentio_url_as_reviewer() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer(readerData.readdata());
    }

    @And("^Reviewer Notification icon button$")
    public void reviewer_notification_icon_button() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		
    	//waitHelper.waitForElementToVisibleWithFluentWait(driver,reviewerObj.reviewerNotidicationIcon(),30, 2);
    	for (int i = 0; i <30; i++) {
			try {
				javascriptHelper.JSEClick(reviewerObj.reviewerNotidicationIcon());
				break;
			} catch (Exception e) {
				
			}
		}	    
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
    }
    
    @Then("^Click ACtion submitted record from maker$")
    public void click_action_submitted_record_from_maker() throws Throwable {
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

    @And("^Click Approve button from Reviewer End$")
    public void click_approve_button_from_reviewer_end() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
    }
    
    @Then("^Enter remark then submit Record$")
    public void enter_remark_then_submit_record() throws Throwable {
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

    // CHECKER
    
    @Given("^Launch the Azentio Checker URL$")
    public void launch_the_azentio_checker_url() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker();
    }

    @Then("^Main module Security management$")
    public void main_module_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
    }

    @And("^Sub module open pool Edit icon$")
    public void sub_module_open_pool_edit_icon() throws Throwable {
		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
    }
    
    @Then("^Claim the record in checker$")
    public void claim_the_record_in_checker() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + readerData.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
    }

    @And("^Click Checker Notification icon button$")
    public void click_checker_notification_icon_button() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
    }
    
    @Then("^Action Icon from claim record$")
    public void action_icon_from_claim_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
//		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
//				+ readerData.readReferancedata()
//				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
    	String before_xpath="//span[contains(text(),'";
		String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath(before_xpath +readerData.readReferancedata() +after_xpath)).click();
				break;
			} catch (Exception e) {
				
			}
		}
    	
//	for (int i = 0; i <30; i++) {
//		try {
//			driver.findElement(By.xpath("//span[contains(text(),'"+readerData.readReferancedata()
//			+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//			.click();
//			break;
//			
//		} catch (NoSuchElementException e) {
//			
//		}
	}
		

    @And("^Click Approve icon button$")
    public void click_approve_icon_button() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
    }
    
    @Then("^Submit the Record from Checker$")
    public void submit_the_record_from_checker() throws Throwable {
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


    @And("^Mouse click on search icon$")
    public void mouse_click_on_search_icon() throws Throwable {
		// ----------CLICK THE SEARCH ICON----------//
		//waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetSearch());
    	for (int i = 0; i <30; i++) {
			try {
				assetReturnObj.fixed_AssetSearch().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
    }
    
    @Then("^Enter Asset Referance No in that field$")
    public void enter_asset_referance_no_in_that_field() throws Throwable {
		// -------------ENTER SEARCHCODE-----------//
		waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetSearchCode());
		assetReturnObj.fixed_AssetSearchCode().click();
		assetReturnObj.fixed_AssetSearchCode().sendKeys(RefNo);
    }

    @When("^capture the Asset Grid view list$")
    public void capture_the_asset_grid_view_list() throws Throwable {
		// ------------CAPTURE THE ASSET------------//
		String befr = "//span[contains(text(),'";
		String aftr = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button[1]";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr + RefNo + aftr)));
		driver.findElement(By.xpath(befr + RefNo + aftr)).click();
    }
	
	
	//***************@KUBS_FAT_UAT_007_007****************//
    
    @Then("^Asset Undertaken Store the Referance No$")
    public void asset_undertaken_store_the_referance_no() throws Throwable {
        //----------ASSET REPLACEMENT REF NO------------//
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetUndertakenEye());
    	assetReturnObj.fixed_AssetUndertakenEye().click();
    	waitHelper.waitForElement(driver, 2000, assetReturnObj.fixed_AssetTableRef());
    	RefNo = assetReturnObj.fixed_AssetTableRef().getText();
    	System.out.println(RefNo);
    }
	
	
	
	
	
	
	
	
	// *********************@KUBS_FAT_UAT_007_008*********************//

	@Then("^click Third Segment button$")
	public void click_third_segment_button() throws Throwable {
		// -----------CLICK ON REPORT ICON----------------//
		waitHelper.waitForElement(driver, 3000, assetReturnObj.fixesAsset_ReportIcon());
		assetReturnObj.fixesAsset_ReportIcon().click();
		waitHelper.waitForElement(driver, 3000, assetReturnObj.fixesAsset_ReportIcon());
		Assert.assertTrue(assetReturnObj.fixesAsset_ReportIcon().isDisplayed());
	}

	@And("^Click on Enquiry main module$")
	public void click_on_enquiry_main_module() throws Throwable {
		// ------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElement(driver, 3000, assetReturnObj.fixesAsset_EnquiryMenu());
		assetReturnObj.fixesAsset_EnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, assetReturnObj.fixesAsset_EnquiryMenu());
		Assert.assertTrue(assetReturnObj.fixesAsset_EnquiryMenu().isDisplayed());
	}

	@Then("^Click on Financial sub module Edit icon$")
	public void click_on_financial_sub_module_edit_icon() throws Throwable {
		// -----------CLICK ON FINANCIAL EDIT------------//
		assetReturnObj.fixesAsset_FinancialTransactionIcon().click();
	}

	@And("^Click Branch code Dropdown$")
	public void click_branch_code_dropdown() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		assetReturnObj.fixedAsset_BranchCode().sendKeys(assetAmendmentData.branchCode);
		assetReturnObj.fixedAsset_BranchCode().sendKeys(Keys.ENTER);
	}

	@Then("^Select GL code as Fixed asset$")
	public void select_gl_code_as_fixed_asset() throws Throwable {
		// -----------CLICK ON GL CODE--------------//
		assetReturnObj.fixedAsset_GlCode().sendKeys(assetAmendmentData.gLCode1);
		assetReturnObj.fixedAsset_GlCode().sendKeys(Keys.ENTER);
	}

	@And("^Choose calender From date$")
	public void choose_calender_from_date() throws Throwable {
		// -----------CLICK ON CALANDER--------------//
		assetReturnObj.fixedAsset_FromDate().click();

		// ----------CLICK ON FROM DATE--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ assetAmendmentData.GlMonth + " " + assetAmendmentData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ assetAmendmentData.GlMonth + " " + assetAmendmentData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				assetReturnObj.fixedAsset_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.GlFullMonth + " "
				+ assetAmendmentData.GlDay + ", " + assetAmendmentData.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@Then("^Choose Calender To date$")
	public void choose_calender_to_date() throws Throwable {
		// ----------CLICK ON TRANSACTION TO DATE--------//
		waitHelper.waitForElement(driver, 3000, assetReturnObj.fixedAsset_ToDate());
		assetReturnObj.fixedAsset_ToDate().click();

		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ assetAmendmentData.GlToMonth + " " + assetAmendmentData.GlYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ assetAmendmentData.GlToMonth + " " + assetAmendmentData.GlYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				assetReturnObj.fixedAsset_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + assetAmendmentData.GlFullToMonth + " "
				+ assetAmendmentData.GlToDate + ", " + assetAmendmentData.GlYear + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click on View and See the record$")
	public void click_on_view_and_see_the_record() throws Throwable {
		// ----------CLICK ON VIEW BUTTON----------//
		assetReturnObj.fixedAsset_ViewButton().click();
	}

	// ******************@KUBS_FAT_UAT_007_009*********************//

	@Then("^Select GL code as Fixed asset code$")
	public void select_gl_code_as_fixed_asset_code() throws Throwable {
		// -----------CLICK ON GL CODE--------------//
		assetReturnObj.fixedAsset_GlCode().sendKeys(assetAmendmentData.gLCode2);
		assetReturnObj.fixedAsset_GlCode().sendKeys(Keys.ENTER);
	}
	
	
	public String revaluedAssetReferenceNo; 
	@And("^click on view button nearby asset return module$")
    public void click_on_view_button_nearby_asset_return_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		//waitHelper.waitForElementVisible(AssetReturnObj.fixedAssetAssetReturnViewButton(), 2000, 100);
		for (int i = 0; i <30; i++) {
			try {
				javascriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnViewButton());
				assetReturnObj.fixedAssetAssetReturnViewButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
    }
	@Then("^goto ammendent asset module$")
    public void goto_ammendent_asset_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		//waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetAssetAmmendent(),1000, 100);
		for (int i = 0; i <30; i++) {
			try {
				javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetAmmendent());
				fixedAssetObj.fixedAssetAssetAmmendent().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
		
    }
	@Then("^Enter Asset Referance Number in ammendent asset$")
    public void enter_asset_referance_number_in_ammendent_asset() throws Throwable {
		// ---------ENTER THE REQUEST REFERANCE NUMBER---------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetReferenceNumber());
		//assetAmmendmentObj.fixed_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFAmmendentAsset);
		assetAmmendmentObj.fixed_AssetReferenceNumber().click();
		Thread.sleep(1500);
		assetAmmendmentObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		assetAmmendmentObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }
	
	

//	@And("^Enter Asset Item Number$")
//	public void enter_asset_item_number() throws Throwable {
//
//		// ----------ENTER ASSET ITEM NUMBER-----------//
//		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetItemCode());
//		assetAmmendmentObj.fixed_AssetItemCode().click();
//		assetAmmendmentObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
//		assetAmmendmentObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
//	}

//    @Then("^Choose Modification Type Which need$")
//    public void choose_modification_type_which_need() throws Throwable {
//    	
//		// -----------CHOOSE THE MODIFICATION TYPE-----------//
//		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_ModificationType());
//		assetAmmendmentObj.fixed_ModificationType().click();
//		assetAmmendmentObj.fixed_ModificationType().sendKeys(assetReturnTestData.assetLife);
//		assetAmmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
//    }

	@And("^Enter Asset Life Value$")
	public void enter_asset_life_value() throws Throwable {

		// ----------------ENTER ASSET VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetLife());
		assetAmmendmentObj.fixed_AssetLife().click();
		assetAmmendmentObj.fixed_AssetLife().clear();
		assetAmmendmentObj.fixed_AssetLife().sendKeys(assetReturnTestData.assetLifeValue);
		String ammendentAssetReferenceNo = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
		 System.out.println(ammendentAssetReferenceNo);
		 assetReferenceNo.put("AssetReferenceNumber", ammendentAssetReferenceNo);
		 System.out.println(assetReferenceNo.get("AssetReferenceNumber"));
	}
//	@Then("^Save the Asset Record$")
//	public void save_the_asset_record() throws Throwable {
//		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.AssetAmendment_Save());
//		assetAmmendmentObj.AssetAmendment_Save().isDisplayed();
//		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.AssetAmendment_Save());
//		assetAmmendmentObj.AssetAmendment_Save().click();
//	}
	

	
	@And("^choose asset reference number$")
    public void choose_asset_reference_number() throws Throwable {
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		Thread.sleep(1500);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
		String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
		assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
    }
	@Then("^Select Asset Reference Number for asset return$")
    public void select_asset_reference_number_for_asset_return() throws Throwable {
		Thread.sleep(1000);
	   	waitHelper.waitForElementToVisibleWithFluentWait(driver,assetReturnObj.fixedAsset_AssetReference(),60,5);
	   	String AssetReferenceNumber = assetReturnObj.fixedAsset_AssetReference().getText();
	   	assetReferenceNo.put("AssetReferenceNumberCreated",AssetReferenceNumber );
	    Thread.sleep(1000);
    }
	 @Then("^Give AssetReferance Number$")
	 public void give_asset_Referance_Number() throws Throwable {

	 // -----------ENTER ASSET REF NO---------------//
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
	 //assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFRevaluedAsset);
	 assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
	 Thread.sleep(1500);
	 assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetGetReferenceNumber());
	 revaluedAssetReferenceNo = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
	 System.out.println(revaluedAssetReferenceNo);
	 assetReferenceNo.put("AssetReferenceNumber", revaluedAssetReferenceNo);
	 }

//	 @And("^Select Asset Item Number$")
//	 public void select_asset_Item_Num() throws Throwable {
//
//	 // --------------ASSET ITEM NUMBER---------------//
//	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetItemCode());
//	 assetRevaluvationObj.fixed_AssetItemCode().click();
//	 assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
//	 assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
//	 }

	 @Then("^Alter the Book Value$")
	 public void alter_the_book_Value() throws Throwable {

	 // --------------ALTER THE BOOK VALUE---------------//
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
	 assetRevaluvationObj.fixed_AssetBookValue().clear();
	 assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetReturnTestData.bookValue);

	 }

//	 @Then("^save the Revaluation record$")
//	 public void save_the_Revaluation_record() throws Throwable {
//
//	 // -----------------SAVE THE RECORD---------------//
//	 waitHelper.waitForElement(driver, 3000, assetRevaluvationObj.AssetRevaluvation_Save());
//	 assetRevaluvationObj.AssetRevaluvation_Save().click();
//	 }

	
	
   /* @And("^check if the reference number is availabe in list$")
    public void check_if_the_reference_number_is_availabe_in_list() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(assetReturnTestData.ReferenceNoOFRevaluedAsset);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + assetReturnTestData.ReferenceNoOFRevaluedAsset + "')]")).isDisplayed();
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    }
*/
	 @And("^choose asset reference number of revalued asset$")
	    public void choose_asset_reference_number_of_revalued_asset() throws Throwable {
		 assetReturnObj.assetReturnAssetReferenceNumber().click();
			//assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFRevaluedAsset);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
			Thread.sleep(1500);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
			String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
			assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number of ammendent asset$")
	    public void choose_asset_reference_number_of_ammendent_asset() throws Throwable {
	    	 assetReturnObj.assetReturnAssetReferenceNumber().click();
				//assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFAmmendentAsset);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
				Thread.sleep(1500);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
				String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
				assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number in asset impaired module$")
	    public void choose_asset_reference_number_in_asset_impaired_module() throws Throwable {
	    	assetImpairementObj.fixedAssetReferenceNumber().click();
	    	//assetImpairementObj.fixedAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFImpairedAsset);
	    	assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
	    	Thread.sleep(1500);
	    	assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.DOWN);
			assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	    }
	    @And("^choose asset reference number of impaired asset$")
	    public void choose_asset_reference_number_of_impaired_asset() throws Throwable {
	    	 assetReturnObj.assetReturnAssetReferenceNumber().click();
			//	assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFImpairedAsset);
	    	 fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
				Thread.sleep(1500);
	    	 assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
				String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
				assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number of de allocated asset$")
	    public void choose_asset_reference_number_of_de_allocated_asset() throws Throwable {
	    	assetReturnObj.assetReturnAssetReferenceNumber().click();
			//assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFDeallocationAsset);
	    	Thread.sleep(1500);
	    	assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
			String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
			assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	@And("^choose item number for the asset$")
    public void choose_item_number_for_the_asset() throws Throwable {
		assetReturnObj.assetReturnAssetItemNo().click();
		Thread.sleep(1500);
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.ENTER);
    }

    @Then("^Click on fixed asset deallocaion  Direction icon$")
    public void click_on_fixed_asset_deallocaion_direction_icon_AssetReturn() throws InterruptedException  {
    //Direction	
    	Thread.sleep(2000);
    waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon().click();
    	
       
    }

    @Then("^Click on Fixed assets field$")
    public void click_on_fixed_assets_field() {
    //Fixed Assets
    waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField().click();
        	
         
      
    }

//    @Then("^Click on asset deallocaion Eye button$")
//    public void click_on_asset_deallocaion_eye_button(){
//    //Eye
//   WebElement eye = waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
//   clicksAndActionHelper.moveToElement(eye);
//   fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
//       
//        
//    }

    @Then("^Fill the asset de Allocaion Mandatory fields$")
    public void fill_the_asset_deallocaion_mandatory_fields() throws InterruptedException  {
     	
    	
    	//AssetReferenceNumber
        waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
      //  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFDeallocationAsset);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
        
        
        //ItemNumber
        waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        String getDeallocationRefNo=fixedAsset_AssetDeallocationObj.getReferenceNumberOfDeAllocation().getText();
        assetReferenceNo.put("AssetReferenceNumber",getDeallocationRefNo );
        System.out.println(assetReferenceNo.get("AssetReferenceNumber"));
        Thread.sleep(2000);
       
    }
    @Then("^Click on Fixed Asset Save button for de allocation$")
    public void click_on_fixed_asset_save_button_Deallocation() throws Throwable {
    	waitHelper.waitForElementVisible(fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton(), 1000, 100);
    	fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton().click();
    }
	@Then("^click on Save after fill all the asset$")
    public void click_on_save_after_fill_all_the_asset() throws Throwable {
		
		//System.out.println("The asset reference number is"+assetReferenceNo.get("AssetReferenceNumber"));
		//waitHelper.waitForElementVisible(assetReturnObj.fixetReturnSaveButton(), 1000, 100);
		for (int i = 0; i <30; i++) {
			try {
				assetReturnObj.fixetReturnSaveButton().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
		
    	
		
		
    }
	@Then("^check the approved record is displayed in de allocation list view$")
    public void check_the_approved_record_is_displayed_in_de_allocation_list_view() throws Throwable {
		 System.out.println(assetReferenceNo.get("AssetReferenceNumberCreated"));

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					List<WebElement> deallocationrecords = driver.findElements(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumberCreated") + afterXpath));
					for (WebElement webElement : deallocationrecords) {
						webElement.isDisplayed();
					}	
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					assetReturnObj.fixedAssetNextButton().click();
				}
			}
    }
	 @Then("^check the approved record is displayed in list view of returned asset$")
	    public void check_the_approved_record_is_displayed_in_list_view_od_returned_asset() throws Throwable {
		 //System.out.println(fixedAsset_AssetCreationTestDataType.AssetCode);

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					List<WebElement> records = driver.findElements(By.xpath(beforeXpath+fixedAsset_AssetCreationTestDataType.AssetCode+afterXpath));
					for (WebElement webElement : records) {
						webElement.isDisplayed();
					}	
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					//assetReturnObj.fixedAssetNextButton().click();
				}
			}

	    }
	    @Then("^check the approved record is displayed in revalued asset$")
	    public void check_the_approved_record_is_displayed_in_revalued_asset() throws Throwable {
	    	//System.out.println(assetReferenceNo.get("AssetReferenceNumber"));
	    	
	    	//System.out.println(assetReferenceNo.get("AssetReferenceNumberCreated"));
			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					List<WebElement> records = driver.findElements(By.xpath(beforeXpath + fixedAsset_AssetCreationTestDataType.AssetCode + afterXpath));
					for (WebElement webElement : records) {
						webElement.isDisplayed();
					}		
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					//assetReturnObj.fixedAssetNextButton().click();
				}
			}
	    }
	    @Then("^check the approved record is displayed in ammendent asset$")
	    public void check_the_approved_record_is_displayed_in_ammendent_asset() throws Throwable {
	    	System.out.println(fixedAsset_AssetCreationTestDataType.AssetCode);

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					List<WebElement> records = driver.findElements(By.xpath(beforeXpath+fixedAsset_AssetCreationTestDataType.AssetCode+afterXpath));
					for (WebElement webElement : records) {
						webElement.isDisplayed();
					}		
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					//assetReturnObj.fixedAssetNextButton().click();
				}
			}
	    }
}
