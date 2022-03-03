package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.INVENTORY_InventoryRequestObj;
import pageobjects.INVENTORY_InventoryStockIssueObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.INVENTORY_InventoryStockIssueTestData;

public class INVENTORY_InventoryStcokIssue extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	INVENTORY_InventoryRequestObj inventoryStockRequestObj=new INVENTORY_InventoryRequestObj(driver);
	INVENTORY_InventoryStockIssueObj inventoryStockIssue = new INVENTORY_InventoryStockIssueObj(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	JsonConfig jsonConfig=new JsonConfig();
	JsonDataReaderWriter jsonData=new JsonDataReaderWriter();
	KUBS_CheckerObj kubsChecker=new KUBS_CheckerObj(driver);
	INVENTORY_InventoryStockIssueTestData inventoryStockIssueTestData=jsonConfig.getInventoryStockIssueUATTestData("Maker");
	KUBS_ReviewerObj reviewerObj=new KUBS_ReviewerObj(driver);
	@Given("^navigate to kubs URL and login as maker credentials$")
	public void navigate_to_kubs_url_and_login_as_maker_credentials() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		javascriptHelper.JavaScriptHelper(driver);
	}

	@Then("^click on second Segment button$")
	public void click_on_second_segment_button() throws Throwable {
		kubsMakerObj.kubsDirectionIcon().click();
	}
	@And("^click on inventory management main menu$")
	public void click_on_inventory_management_main_menu() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsMakerObj.kubsInventoryManagement());
		kubsMakerObj.kubsInventoryManagement().click();
	}

    
    @Then("^click on view button near by inventory request menu$")
    public void click_on_view_button_near_byy_inventory_request_menu() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, inventoryStockRequestObj.inventoryRequestViewIcon());
    	inventoryStockRequestObj.inventoryRequestViewIcon().click();    	
    }

    @Then("^select the perticular inventory record by the help of request reference number$")
    public void select_the_perticular_inventory_record_by_the_help_of_request_reference_number() throws Throwable {
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[2]//ion-button[1]";
    	waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath(before_xpath+inventoryStockIssueTestData.inventoryRequestReferenceNumber+after_xpath)));
    	driver.findElement(By.xpath(before_xpath+inventoryStockIssueTestData.inventoryRequestReferenceNumber+after_xpath)).click();
    }

    @And("^check the inventory requested sucessfully and capture the inventory data$")
    public void check_the_inventory_requested_sucessfully_and_capture_the_inventory_data() throws Throwable {
    	String inventoryBranch=(String) javascriptHelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
    	jsonData.addInventoryRequestedBranch(inventoryBranch);
    	Thread.sleep(1000);
    	String inventoryItem=(String) javascriptHelper.executeScript("return document.getElementsByClassName('datagrid-lov ng-untouched ng-pristine md select-disabled hydrated ion-untouched ion-pristine')[0].textContent");
    	jsonData.addInventoryItem(inventoryItem);
    	
    	
    }
    @When("^user see the inventory request reference number , The inventory was successfully requested$")
    public void user_see_the_inventory_request_reference_number_the_inventory_was_successfully_requested() throws Throwable {
    	String inventoryReqReferenceNumber=(String) javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
    	Assert.assertFalse(inventoryReqReferenceNumber.isBlank());
    }



	
	@Then("^click the eye icon near by inventory stock issue$")
    public void click_the_eye_icon_near_by_inventory_stock_issue() throws Throwable {
    
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.JSEClick(inventoryStockIssue.inventoryStockIssueEyeIcon());
    	
    	}
	@And("^click on Add button$")
    public void click_on_add_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStcokIssueAddButton());
		inventoryStockIssue.inventoryStcokIssueAddButton().click();
    }

	
	@And("^enter inventory item$")
	public void enter_inventory_item() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryInventoryItem());
		//waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryInventoryItem());
		inventoryStockIssue.inventoryInventoryItem().click();
		
		inventoryStockIssue.inventoryInventoryItem().sendKeys(inventoryStockIssueTestData.inventoryItem);
		inventoryStockIssue.inventoryInventoryItem().sendKeys(Keys.ENTER);
	}

	
	@Then("^enter inventory branch$")
	public void enter_inventory_branch() throws Throwable {
		String requestRefNo=jsonData.readInventoryRequestedBranch();
		String[] requestReferenceNo=requestRefNo.split("-");
		inventoryStockIssue.inventoryBranchCode().sendKeys(requestReferenceNo[0]);
		inventoryStockIssue.inventoryBranchCode().sendKeys(Keys.ENTER);
		
	}

	
	
	@And("^enter inventory reference number$")
	public void enter_inventory_reference_number() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.requestReferenceNumber());
		inventoryStockIssue.requestReferenceNumber().click();
		inventoryStockIssue.requestReferenceNumber().sendKeys(inventoryStockIssueTestData.inventoryRequestReferenceNumber);
		inventoryStockIssue.requestReferenceNumber().sendKeys(Keys.ENTER);
	}
	@Then("^Click on Save button$")
	public void click_on_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueSaveButton());
		inventoryStockIssue.inventoryStockIssueSaveButton().click();		
	}

	@Then("^click on notification$")
    public void click_on_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueAlertClose());
    	inventoryStockIssue.inventoryStockIssueAlertClose().click();
		inventoryStockIssue.inventoryStockIssueNotificationIcon().click();
       
    }
	@And("^select the first record in notification$")
    public void select_the_first_record_in_notification() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueFirstReferenceId());
		String firstReferenceID=inventoryStockIssue.inventoryStockIssueFirstReferenceId().getText();
		jsonData.addReferanceData(firstReferenceID);
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueFirstRecord());
		inventoryStockIssue.inventoryStockIssueFirstRecord().click();
		
    }
    @Then("^submit the record$")
    public void submit_the_record() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueSubmitButton());
    	inventoryStockIssue.inventoryStockIssueSubmitButton().click();
    	waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueAlertRemarks());
    	inventoryStockIssue.inventoryStockIssueAlertRemarks().sendKeys("Ok");
    	inventoryStockIssue.inventoryStockIssueAlertSubmitButton().click();
        
    }

    @And("^logout from maker end$")
    public void logout_from_maker_end() throws Throwable {
		waitHelper.waitForElement(driver, 2000,inventoryStockIssue.inventoryStockIssueReviewerID() );
		String reviwerId = inventoryStockIssue.inventoryStockIssueReviewerID().getText();
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		jsonData.addData(revID);

    	waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueAlertClose());
    	inventoryStockIssue.inventoryStockIssueAlertClose().click();
    	inventoryStockIssue.inventoryStockIssueUserName().click();
    	waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueLogoutButton());
    	inventoryStockIssue.inventoryStockIssueLogoutButton().click();
        
    }
    @And("^login with reviewer id$")
    public void login_with_reviewer_id() throws Throwable {
    	kubsLogin.logintoAzentioappReviewer("Reviewer", jsonData.readdata());
    }

    @Then("^click on notification icon in reviewer$")
    public void click_on_notification_icon_in_reviewer() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, reviewerObj.reviewerNotidicationIcon());
    	reviewerObj.reviewerNotidicationIcon().click();
    }
    @And("^select our record$")
    public void select_our_record() throws Throwable {
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + jsonData.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + jsonData.readReferancedata() + after_xpath)).click();
    }
    @Then("^approve the record in reviewer end$")
    public void approve_the_record_in_reviewer_end() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, reviewerObj.reviewerApproveButton());
      reviewerObj.reviewerApproveButton().click();
      waitHelper.waitForElement(driver, 3000, reviewerObj.reviewerAlertRemarks());      
      reviewerObj.reviewerAlertRemarks().click();
      reviewerObj.reviewerAlertRemarks().sendKeys(inventoryStockIssueTestData.ReviewerApproveComments);
      reviewerObj.reviewerAlertSubmitButton().click();
    }
    @And("validate the approval status in reviewer end")
    public void validate_the_approval_status_in_reviewer_end()
    {
    	waitHelper.waitForElement(driver, 3000, reviewerObj.reviewerApprovalStatus());
    String approval_status=reviewerObj.reviewerApprovalStatus().getText();	
    Assert.assertEquals(approval_status, "Record is available in CHECKER's Open Pool with status PENDING");
    }
    @And("^logout from reviewer end$")
    public void logout_from_reviewer_end() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, reviewerObj.reviewerAlertClose());
    	reviewerObj.reviewerAlertClose().click();
    	waitHelper.waitForElement(driver, 3000,reviewerObj.reviewerUserName());
    	reviewerObj.reviewerUserName().click();
    	waitHelper.waitForElement(driver, 3000,reviewerObj.reviewerLogoutButton());
    	reviewerObj.reviewerLogoutButton().click();
    }
    @Then("^login with checker ID$")
    public void login_with_checker_id() throws Throwable {
    	Thread.sleep(1000);
        kubsLogin.loginToAzentioAppAsChecker("Checker");
    }
    @And("^click on Security management menu$")
    public void click_on_security_management_menu() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, kubsChecker.checkerSecurityManagement());
    	kubsChecker.checkerSecurityManagement().click();
    }
    @And("^click on action button near by open pool$")
    public void click_on_action_button_near_by_open_pool() throws Throwable {
    	kubsChecker.checkerActionIcon().click();
    }
    @Then("^clime the Record$")
    public void clime_the_record() throws Throwable {
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javascriptHelper.JSEClick(kubsChecker.checkerActionIcon());
		for (int i = 1; i <= 3; i++) {
			try {

				WebElement climeButton = driver
						.findElement(By.xpath(before_xpath + jsonData.readReferancedata() + after_xpath_claim));
				boolean bool = climeButton.isDisplayed();
				climeButton.click();
				// after clicking on the clime button , clime successful message will came we
				
				Assert.assertTrue(bool);

				break;
			} catch (StaleElementReferenceException staleElementException) {
				System.out.println(staleElementException.getMessage());
			}
		}

    }
    @And("^click on Notification icon in checker stage$")
    public void click_on_notification_icon_in_checker_stage() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, kubsChecker.checkerAlertClose());
    	kubsChecker.checkerAlertClose().click();
        kubsChecker.checkerNotificationIcon().click();
    }
    @Then("^approve the Record$")
    public void approve_the_record() throws Throwable {
    	while(true)
		{
		try
		{
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath(before_xpath + jsonData.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + jsonData.readReferancedata() + after_xpath)).click();
		break;
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		}
		
    	waitHelper.waitForElement(driver, 3000, kubsChecker.checkerApproveButton());
        kubsChecker.checkerApproveButton().click();
        waitHelper.waitForElement(driver, 3000,kubsChecker.checkerRemarks()); 
        kubsChecker.checkerRemarks().click();
        kubsChecker.checkerRemarks().sendKeys(inventoryStockIssueTestData.CheckerApproveComments);
        kubsChecker.checkersubmitButton().click();
    }
    @And("^validate the approval status in checker stage$")
    public void validate_the_approval_status_in_checker_stage() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, kubsChecker.checkerApprovalStatus());
		String approvalStatusForChecker = kubsChecker.checkerApprovalStatus().getText();
		Assert.assertEquals(approvalStatusForChecker, "Record APPROVED Successfully");
    }


    
}
