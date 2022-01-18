package stepdefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelReader;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;

public class BUDGET_BudgetTransfer {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	// ExcelReader reader = new ExcelReader(System.getProperty("user.dir") +
	// "\\Test-data\\TestData.xlsx");
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_BudgetTransferTestDataType budgetTransferData = jsonReader.getBudgetTransferdata("Maker");
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementarybudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj=new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_BudgetTransferObj budgetTransferobj = new BUDGET_BudgetTransferObj(driver);
	KUBS_Login login;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_ReviewerObj reviewer = new KUBS_ReviewerObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	BrowserHelper browserHelper;
	String referance_id;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	JsonDataReaderWriter reader;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	String reviewerId;
	//------TESTCASE (BP_BT_01_01)----------//
	@Then("^verify the respective fields are on transfer budget screen$")
    public void verify_the_respective_fields_are_on_transfer_budget_screen()  {
		
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetCodeField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetNameField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetYearField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetTransferFromField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetTransferToField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyBudgetTransferAmountField().isDisplayed());
		Assert.assertTrue(budgetTransferobj.budget_BudgetTransfer_VerifyStatusField().isDisplayed());
		System.out.println("Most of the respective fields are not displayed in this sub module");
    }
	/*------------------TEST CASE BP_BT_05_03---------------*/

	@And("^click on the eye icon of budget transfer sub menu$")
	public void click_on_the_eye_icon_of_budget_transfer_sub_menu() {
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_EyeButton());
		budgetTransferobj.budget_BudgetTransfer_EyeButton().click();
	}

	@Then("^click on add button to create record$")
	public void click_on_add_button_to_create_record() throws InterruptedException {
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_AddButton());
		budgetTransferobj.budget_BudgetTransfer_AddButton().click();
	}

	@And("^fill the required field$")
	public void fill_the_required_field() {
		budgetTransferData = jsonReader.getBudgetTransferdata("Maker");

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferData.BudgetCode);
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferData.BudgetYear);
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Branch());
		budgetTransferobj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferData.Branch);
		budgetTransferobj.budget_BudgetTransfer_Branch().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode()
				.sendKeys(budgetTransferData.TransferToBudgetCode);
		budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferobj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferData.Currency);
		budgetTransferobj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferobj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferData.ApportionedAmountA);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferobj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferData.ApportionedAmountB);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Comment());
		budgetTransferobj.budget_BudgetTransfer_Comment().sendKeys(budgetTransferData.Comment);
	}

	@Then("^save and submit by maker to transfer$")
	public void save_and_submit_by_maker_to_transfer() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_SaveButton());
		budgetTransferobj.budget_BudgetTransfer_SaveButton().click();

		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_NotificationButton());
		budgetTransferobj.budget_BudgetTransfer_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, budgetTransferobj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferobj.budget_BudgetTransfer_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,budgetTransferobj.maker_notification_next_button());
				
				budgetTransferobj.maker_notification_next_button().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_SubmitButton());
		budgetTransferobj.budget_BudgetTransfer_SubmitButton().click();

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_RemarkField());
		javascripthelper.JSEClick(budgetTransferobj.budget_BudgetTransfer_RemarkField());
		budgetTransferobj.budget_BudgetTransfer_RemarkField().sendKeys(budgetTransferData.RemarkByMaker);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Submit());
		budgetTransferobj.budget_BudgetTransfer_Submit().click();
		Thread.sleep(2000);
    	WebElement recordstatus = budgetTransferobj.budget_BudgetTransfer_RecordStatus();
    	
		clicksAndActionHelper.moveToElement(recordstatus);
    	String message = budgetTransferobj.budget_BudgetTransfer_RecordStatus().getText();
    	System.out.println(message);
    	budgetTransferobj.budget_BudgetTransfer_RecordStatus().click();
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

	@And("^maker user should logout and login as checker1 user$")
	public void maker_user_should_logout_and_login_as_checker1_user() throws Throwable {
		waithelper.waitForElement(driver, 2000, budgetTransferobj.budget_ProfileName());
		budgetTransferobj.budget_ProfileName().click();
		
		waithelper.waitForElement(driver, 2000, budgetTransferobj.budget_Logout());
		budgetTransferobj.budget_Logout().click();
		login.logintoAzentioappReviewer("reviewer",  reviewerId);
	}
	 @And("^validate the data submitted by maker to checker1$")
	    public void validate_the_data_submitted_by_maker_to_checker1() throws InterruptedException, IOException, ParseException {
	    	
	    	javascripthelper.JavaScriptHelper(driver);
	    	Thread.sleep(2000);
	    	
	    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
			driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
			Thread.sleep(2000);
			
	    	String expectedbudgetcode = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText").toString();
	    	System.out.println(expectedbudgetcode);
	    	Assert.assertEquals(budgetTransferData.BudgetCode, expectedbudgetcode);
	    	String expectedbudgettype=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[1].innerText").toString();
	    	System.out.println(expectedbudgettype);
	    	Assert.assertEquals(budgetTransferData.BudgetType, expectedbudgettype);
	    	String expectedbudgetyear=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[2].innerText").toString();
	    	System.out.println(expectedbudgetyear);
	    	Assert.assertEquals(budgetTransferData.BudgetYear, expectedbudgetyear);
	    	String expectedbudgetbranch=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[3].innerText").toString();
	    	System.out.println(expectedbudgetbranch);
	    	Assert.assertEquals(budgetTransferData.Branch, expectedbudgetbranch);
	    	String expectedTransfertobudgetcode=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[4].innerText").toString();
	    	System.out.println(expectedbudgetbranch);
	    	Assert.assertEquals(budgetTransferData.TransferToBudgetCode, expectedTransfertobudgetcode);
	    	String expectedcurrency = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[5].innerText").toString();
	    	System.out.println(expectedcurrency);
	    	Assert.assertEquals(budgetTransferData.Currency, expectedcurrency);
//	    	String expectedapportionedamount=bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCurrencyVerify().getText();
//	    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-touched ng-valid')[0].value").toString();
//	    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('datatable ng-pristine ng-valid ng-star-inserted ng-touched')[0].value").toString();
//	    	System.out.println(expectedapportionedamount);
//	    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt, expectedapportionedamount);
//	    	   	
	    }
	@And("^approve the record by reviewer$")
	public void approve_the_record_by_reviewer() throws InterruptedException {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys(budgetTransferData.RemarkByMaker);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(2000);
 	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
 	clicksAndActionHelper.moveToElement(recordstatus);
 	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
 	System.out.println(message);
 	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
	}
	@And("^reviewer user logout$")
    public void reviewer_user_logout() throws InterruptedException  {
		Thread.sleep(5000);
		budgetTransferobj.budget_ProfileName().click();    	
     	waithelper.waitForElement(driver, 2000, budgetTransferobj.budget_Logout());
     	budgetTransferobj.budget_Logout().click();
    }
	@Then("^checker2 should return the record$")
    public void checker_should_return_the_record() throws IOException, ParseException {
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerReturnButton());
    	kubschecker.checkerReturnButton().click();
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(budgetTransferData.ReturnedByChecker);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
        
    }
	 @Then("^reviewer should return the record$")
	    public void reviewer_should_return_the_record() throws Throwable {
		 waithelper.waitForElement(driver, 2000, kubschecker.checkerReturnButton());
	    	kubschecker.checkerReturnButton().click();
	    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
			kubschecker.checkerRemarks().sendKeys(budgetTransferData.ReturnedByReviewer);
			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
			kubschecker.checkersubmitButton().click();
	    }
	@Then("^Click  on reject button$")
    public void click_on_reject_button() throws Throwable {
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
		kubschecker.checkerRejectButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(budgetTransferData.RejectedByChecker);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();  
    }
	@And("^validate the data sent by checker1 submitted by maker$")
    public void validate_the_data_sent_by_checker1_submitted_by_maker() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		Thread.sleep(1000);
    	String expectedbudgetcode = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText").toString();
    	System.out.println(expectedbudgetcode);
    	Assert.assertEquals(budgetTransferData.BudgetCode, expectedbudgetcode); 
    	String expectedbudgettype=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[1].innerText").toString();
    	System.out.println(expectedbudgettype);
    	Assert.assertEquals(budgetTransferData.BudgetType, expectedbudgettype);
    	String expectedbudgetyear=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[2].innerText").toString();
    	System.out.println(expectedbudgetyear);
    	Assert.assertEquals(budgetTransferData.BudgetYear, expectedbudgetyear);
    	String expectedbudgetbranch=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[3].innerText").toString();
    	System.out.println(expectedbudgetbranch);
    	Assert.assertEquals(budgetTransferData.Branch, expectedbudgetbranch);
    	String expectedTransfertobudgetcode=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[4].innerText").toString();
    	System.out.println(expectedbudgetbranch);
    	Assert.assertEquals(budgetTransferData.TransferToBudgetCode, expectedTransfertobudgetcode);
    	String expectedcurrency = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[5].innerText").toString();
    	System.out.println(expectedcurrency);
    	Assert.assertEquals(budgetTransferData.Currency, expectedcurrency);
//    	String expectedapportionedamount=bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCurrencyVerify().getText();
//    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-touched ng-valid')[0].value").toString();
//    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('datatable ng-pristine ng-valid ng-star-inserted ng-touched')[0].value").toString();
//    	System.out.println(expectedapportionedamount);
//    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt, expectedapportionedamount);
//    	   	
    }
	
	@Then("^save and approve by maker to transfer$")
	public void save_and_approve_by_maker_to_transfer() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_SaveButton());
		budgetTransferobj.budget_BudgetTransfer_SaveButton().click();

		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_NotificationButton());
		budgetTransferobj.budget_BudgetTransfer_NotificationButton().click();
		
		waithelper.waitForElement(driver, 2000, budgetTransferobj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferobj.budget_BudgetTransfer_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,budgetTransferobj.maker_notification_next_button());
				
				budgetTransferobj.maker_notification_next_button().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_RemarkField());
		javascripthelper.JSEClick(budgetTransferobj.budget_BudgetTransfer_RemarkField());
		budgetTransferobj.budget_BudgetTransfer_RemarkField().sendKeys(budgetTransferData.ApproveByMaker);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Submit());
		budgetTransferobj.budget_BudgetTransfer_Submit().click();
		Thread.sleep(2000);
    	WebElement recordstatus = budgetTransferobj.budget_BudgetTransfer_RecordStatus();
    	
		clicksAndActionHelper.moveToElement(recordstatus);
    	String message = budgetTransferobj.budget_BudgetTransfer_RecordStatus().getText();
    	System.out.println(message);
    	budgetTransferobj.budget_BudgetTransfer_RecordStatus().click();
	}
	@And("^fill the required field for supplementary budget type$")
	public void fill_the_required_field_for_supplementary_budget_type()  {
		budgetTransferData = jsonReader.getBudgetTransferdata("Maker");

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budgetTransferData.BudgetCode);
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budgetTransferData.BudgetYear);
		budgetTransferobj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Branch());
		budgetTransferobj.budget_BudgetTransfer_Branch().sendKeys(budgetTransferData.Branch);
		budgetTransferobj.budget_BudgetTransfer_Branch().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode().click();
		
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferobj.budget_BudgetTransfer_CurrencyChange().sendKeys(budgetTransferData.Currency);
		budgetTransferobj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferobj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferData.ApportionedAmountA);
		
		waithelper.waitForElement(driver, 3000, budgetTransferobj.budget_BudgetTransfer_Comment());
		budgetTransferobj.budget_BudgetTransfer_Comment().sendKeys(budgetTransferData.Comment);
	}
	
}
