package stepdefinitions;

import java.io.IOException;
import java.util.Properties;
import org.apache.poi.util.SystemOutLogger;
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
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;

public class BUDGET_SupplementaryBudget extends BaseClass {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	DropDownHelper dropDownHelper;
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj=new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_BudgetCreationObj bUDGET_BudgetCreationObj=new BUDGET_BudgetCreationObj(driver);
	KUBS_CheckerObj kubschecker= new KUBS_CheckerObj(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;
	KUBS_Login login;
	ConfigFileReader config = new ConfigFileReader();
	WaitHelper waithelper =new WaitHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonConfig jsonReader=new JsonConfig();
	//Checker//
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JavascriptHelper javascript;
	KUBS_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig=new JsonConfig();
	String user = "Maker";
	
//	@When("^maker click on budget supplementary eye icon$")
//	public void maker_click_on_budget_supplymentary_view_icon()  {
//		kubsMakerObj.budget_SupplementaryBudget_SupplementaryBudgetEyeIcon().click();
//	}
	@And("^click on add button on budget supplementary view page$")
	public void click_on_add_button_on_budget_supplementary_view_page() throws InterruptedException  {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
	}
	
	@Then("^maker should save the changed budget code details$")
	public void maker_should_save_the_changed_budget_code_details()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
	}
	
	@Then("^maker should click on note icon of the changed budget code$")
	public void maker_should_click_on_note_icon_of_the_changed_budget_code()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit().click();
	}
	@And("^maker should submit the record$")
	public void maker_should_submit_the_record()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys("Submitted by maker");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
		
	}
	
	@Given("^reviewer should navigate to the url and login with valid credentials$")
	public void reviewer_should_navigate_to_the_url_and_login_with_valid_credentials()  {
		
	}
	@When("^reviewer should click on notification$")
	public void reviewer_should_click_on_notification()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NotificationButton().click();
		
	}
	
	@Then("^reviewer should approve and submit the record$")
	public void reviewer_should_approve_and_submit_the_record()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApproveByReviewer().click();
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("ReviewerRemark");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkByReviewer().sendKeys(bUDGET_SupplementaryBudgetTestDataType.ReviewerRemark);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByReviewer().click();
	}
	
	//-----------------------TestCase (BP_SB_01_01)----------------------//
	@Then("^verify the respective fields are on screen$")
    public void verify_the_respective_fields_are_on_screen() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyBudgetCodeField());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyBudgetCodeField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyBudgetNameField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyBudgetYearField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyBudgetTypeField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyTotalAmountField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyStatusField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyCreatedByField().isDisplayed());
		javascripthelper.scrollIntoViewAndClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyAuthStatusField());
		Thread.sleep(1000);
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyCreateDateField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyModifiedByField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyModifiedDateField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyAuthorizedByField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyAuthorizedDateField().isDisplayed());
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_VerifyAuthStatusField().isDisplayed());
		System.out.println("All the respective fields are displayed except Branch");
    }
	//--------------------------- TESTCASE (BP_SB_03_03) ----------------------------//	
	@And("^fill the required field for yearly budget type$")
	public void fill_the_required_field_for_yearly_budget_type()  {
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForyearly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForyearly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForyearly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForyearly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetComments);
	}
	
	@Then("^save and submit by maker$")
    public void save_and_submit_by_maker() throws InterruptedException, IOException, ParseException  {
		bUDGET_BudgetCreationObj.budgetCreation_saveButton().click();
    	Thread.sleep(2000);
    	javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
    	System.out.println("Message:" +str);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton().click();
		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId());
    	
    	String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().getText();
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
				waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
				
				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}
		}   
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();   	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
    	javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys(bUDGET_SupplementaryBudgetTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
    	Thread.sleep(2000);
    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click(); 	
    }
    
    @And("^Validate the data submitted by maker is display$")
    public void validate_the_data_submitted_by_maker_is_display() throws InterruptedException, IOException, ParseException {
    	
    	javascripthelper.JavaScriptHelper(driver);
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		Thread.sleep(1000);
    	String expectedbudgetcode = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText").toString();
    	System.out.println(expectedbudgetcode);
    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetCode, expectedbudgetcode); 
    	String expectedbudgettype=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[1].innerText").toString();
    	System.out.println(expectedbudgettype);
    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetType, expectedbudgettype);
    	String expectedbudgetyear=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[2].innerText").toString();
    	System.out.println(expectedbudgetyear);
    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForyearly, expectedbudgetyear);
    	String expectedbudgetbranch=javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[3].innerText").toString();
    	System.out.println(expectedbudgetbranch);
    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForyearly, expectedbudgetbranch);
    	String expectedcurrency = javascripthelper.executeScript("return document.getElementsByClassName('ng-value-label')[4].innerText").toString();
    	System.out.println(expectedcurrency);
    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.CurrencyForyearly, expectedcurrency);
//    	String expectedapportionedamount=bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCurrencyVerify().getText();
//    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('form__field ng-pristine ng-touched ng-valid')[0].value").toString();
//    	String expectedapportionedamount=javascripthelper.executeScript("return document.getElementsByClassName('datatable ng-pristine ng-valid ng-star-inserted ng-touched')[0].value").toString();
//    	System.out.println(expectedapportionedamount);
//    	Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt, expectedapportionedamount); 
    	
    }
    
    @And("^checker user logout$")
    public void checker_user_logout() throws InterruptedException  {
    	Thread.sleep(1000);
    	bUDGET_SupplementaryBudgetObj.budget_ProfileName().click();    	
     	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_Logout());
    	bUDGET_SupplementaryBudgetObj.budget_Logout().click();
    }
    @And("^claimed status$")
    public void claimed_status() throws InterruptedException  {
    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
    }
    
  //--------------------------- TESTCASE (BP_SB_03_04) ----------------------------//

    @Then("^checker should approve the record$")
    public void checker_should_approve_the_record() throws IOException, ParseException  {
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CheckerRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
    }

    @Then("^the record gets added into the system$")
    public void the_record_gets_added_into_the_system() throws InterruptedException {
    	
    }

    @And("^system should show the prompt message for verification$")
    public void system_should_show_the_prompt_message_for_verification() throws InterruptedException  {
    	Thread.sleep(1000);
    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
    }
 
  //--------------------------- TESTCASE (BP_SB_06_05) ----------------------------//
    
    @Then("^checker should return the record$")
    public void checker_should_return_the_record() throws IOException, ParseException {
    	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerReturnButton());
    	kubschecker.checkerReturnButton().click();
    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CheckerReturnRemark);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
    }
    @And("^verify record is returned$")
    public void verify_record_is_returned() throws IOException, ParseException  {
    	
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
				
				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}		
		}
    	System.out.println("The record is returned from checker");
    }
    
//--------------------------------maker common--------------------------------//

	@Given("^maker should navigate to the url and login with valid credentials$")
    public void maker_should_navigate_to_the_url_and_login_with_valid_credentials() throws InterruptedException  {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }
	@And("^maker should navigate to the budget module$")
	public void maker_should_navigate_to_the_budget_module() throws InterruptedException  {
		 waithelper = new WaitHelper(driver);
		 bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
		 Thread.sleep(2000);
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon().click();
		
				 
	}
@And("^maker click on budget field$")
	    public void maker_click_on_budget_field()   {
	        
		 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
	    }
	@When("^maker click on budget supplementary eye icon$")
	public void maker_click_on_budget_supplymentary_eye_icon()  {
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();
		
	}
//	@And("^click on add button on budget supplementary view page$")
//	public void click_on_add_button_on_budget_supplementary_view_page() throws InterruptedException  {
//		Thread.sleep(2000);
//    	waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
//    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
//
//	}
	@Then("^maker should fill the required field$")
	public void maker_should_fill_the_required_field()  {
		//budget code
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCode);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
		 //budget year
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYear);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
		 //budget  branch
		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchName);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
		//currency
		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.Currency);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);

		
		//Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ExistingAmount().isDisplayed());
		//bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetComments");
		//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetComments);
		
		waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();
	}
//	@Then("^maker should save the changed budget code details$")
//	public void maker_should_save_the_changed_budget_code_details()  {
//		waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave());
//		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
//	}

	//--------------------------------------COMMON CHECKER------------------------//
    
  	
    

	 @Then("^Navigate  to URL and login to Checker1$")
	    public void navigate_to_url_and_login_to_checker1() throws Throwable {
		  login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.loginToAzentioAppAsChecker("Checker");
	    }

	    @When("^Click  on the Security management$")
	    public void click_on_security_management() throws Throwable {
	    	waithelper = new WaitHelper(driver);
			kubschecker = new KUBS_CheckerObj(driver);
			waithelper.waitForElement(driver,3000, kubschecker.checkerSecurityManagement());
	    	kubschecker.checkerSecurityManagement().click();
	    }

	    @Then("^Click  on open pool & click clam button$")
	    public void click_on_open_pool_click_clam_button() throws Throwable {
	    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
	    	
	    	kubschecker.checkerActionIcon().click();
	    	Thread.sleep(1000);
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
			waithelper.waitForElement(driver,3000,kubschecker.checkerAlertClose());
			kubschecker.checkerAlertClose().click();
	    }

	    @Then("^Click  on the Notification$")
	    public void click_on_the_notification() throws Throwable {
	    	javascript=new JavascriptHelper();
	    	Thread.sleep(1000);
			waithelper.waitForElement(driver,4000,kubschecker.checkerNotificationIcon());
			
			kubschecker.checkerNotificationIcon().click();
			Thread.sleep(1000);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000,
							driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
					referanceID.click();
					

					Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
					
					kubschecker.checker_notification_next_button().click();
				}
				}
			//action pencil
			String before_xpath="//span[contains(text(),'";
			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
			}

	
		//----------------------------------------SupplementaryBudget_BP_SB_03_05---------------------------------------------//
		//------------------------------------------APPROVED Status-----------------------------------------------------------//

	 @And("^click search icon and  fill the required field$")
	    public void click_search_icon_and_fill_the_required_field()  {
		 //search icon
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();

		 //Budget code	
		 bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeA);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
		 //budget name
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetNameA);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(Keys.ENTER);
		 //budget budget year
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearA);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(Keys.ENTER);
		 //budget Type
		/* waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetTypeA);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(Keys.ENTER);*/
		 //total amount
		 /*waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().click();
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.TotalAmountM);
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(Keys.ENTER);*/
		 //Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ExistingAmount().isDisplayed());
	}
		
	 @Then("^select the record check Approved auth status of the record$")
	    public void select_the_record_check_approved_auth_status_of_the_record() throws InterruptedException {
		 //select the record
		 Thread.sleep(2000);
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());

		 //validate auth status
		 Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed());
		 String authStatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchAuthStatus().getText();
		 System.out.println(authStatus);
	    Assert.assertEquals(bUDGET_SupplementaryBudgetTestDataType.AuthStatusA, authStatus);
	    }
	//----------------------------------------SupplementaryBudget_BP_SB_06_04---------------------------------------------//
	//--------------------------------------------Returned Status---------------------------------------------------------//
	 
	@And("^navigate to search icon and  fill the required field$")
	    public void navigate_to_search_icon_and_fill_the_required_field()  {
		    //search icon
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();

			 //Budget code	
			 bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
			 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeA);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
			 //budget name
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetNameA);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(Keys.ENTER);
			 //budget budget year
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearA);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(Keys.ENTER);
			 //budget Type
			/* waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType());
		 	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetTypeM);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(Keys.ENTER);
			 //total amount
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.TotalAmountM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(Keys.ENTER);	*/
		
	}
	 @Then("^select the record check Returned auth status of the record$")
	    public void select_the_record_check_returned_auth_status_of_the_record() {
		 //select the record
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());
		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().click();
		 //validate auth status
		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());
		 String authStatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchAuthStatus().getText();
		 System.out.println(authStatus);
		 Assert.assertNotSame(bUDGET_SupplementaryBudgetTestDataType.AuthStatusB, authStatus);
	      
	    }
	    
//----------------------------------------SupplementaryBudget_BP_SB_12_01---------------------------------------------//
		//--------------------------------------------Search Record---------------------------------------------------------//
	                                                  
	    @And("^maker navigate to search icon and  fill the required field$")
	    public void maker_navigate_to_search_icon_and_fill_the_required_field()  {
	    	 //search icon
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();

			 //Budget code	
			 bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
			 waithelper.waitForElement(driver, 5000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
			 //budget name
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetNameM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetName().sendKeys(Keys.ENTER);
			 //budget budget year
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetYear().sendKeys(Keys.ENTER);
			 //budget Type
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetTypeM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetType().sendKeys(Keys.ENTER);
			 //total amount
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount());
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().click();
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.TotalAmountM);
			 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchTotalAmount().sendKeys(Keys.ENTER);	
	       
	    }

	    @Then("^maker select the record$")
	    public void maker_select_the_record_check_returned_auth_status_of_the_record() {
	    	 //select the record
			 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());
			// bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed();
	       Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed());
	    }   
	    
	  //----------------------------------------SupplementaryBudget_BP_SB_08_01---------------------------------------------//
	  //--------------------------------------------Monthly Option---------------------------------------------------------//
	    
	    
	    @Then("^fill the required data$")
	    public void fill_the_required_data() {
	    
	        //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	        //budget year
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  	    //budget  branch
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	  		

	  		
	  		//Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ExistingAmount().isDisplayed());
	  		//bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetComments");
	  		//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetComments);
	  	
	  	}
	    @Then("^validate monthly supplementary apportion field$")
	    public void validate_monthly_supplementary_apportion_field()  {
	    	//Monthly option available
	    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidateMonthlyJan());
	  		String text = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidateMonthlyJan().getText();
	  		System.out.println(text);
	  		//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidateMonthlyJan().click();
	  	
	    	
	    	
	    	//waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidateMonthlyFeb());
	    	//Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidateMonthlyFeb().isDisplayed());
	    	
	    	
	    	
	    }
	    
	    
	  //----------------------------------------SupplementaryBudget_BP_SB_08_02---------------------------------------------//
	//--------------------------------------------Monthly Budget record submit ---------------------------------------------------------//
	   
		


	    @Then("^fill required data$")
	    public void fill_required_data()  {
	    	 //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	  //budget year
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  	//budget  branch
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	  		//currency
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyMon);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);

	      
	    }
	    @Then("^fill apportion amount$")
	    public void fill_apportion_amount() throws InterruptedException  {
	    	 //Supplementary apportion amount
	    	 bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	    	 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApportionJan());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApportionJan().click();
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApportionJan().sendKeys(bUDGET_SupplementaryBudgetTestDataType.SupplymentaryApportionAmtA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApportionJan().sendKeys(Keys.ENTER);
	    	 
	  		 // New amount
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewApportionJan().click();
	    	 
	    	 
	    	 //save button
	    	 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
	    	 Thread.sleep(2000);
	         javascripthelper.JavaScriptHelper(driver);
	         String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	         System.out.println("Message:" +str);
	    	 
	     	
	     	
	        
	    }
	    @Then("^validate maker can save request for the monthly budget$")
	    public void validate_maker_can_save_request_for_the_monthly_budget() throws IOException, ParseException   {
	   

			//Notification
			waithelper.waitForElement(driver,2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();
			
			//Reference
			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId());
	    	String id = bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().getText();
	    	jsonWriter.addReferanceData(id);
	    	System.out.println("Reference ID:" +id);
	    	for (int i = 1; i <= 35; i++) {
				try {
			    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
					referanceID.click();
			    	System.out.println(referanceID);
			    	//Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) 
				{
					waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
					
					bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
				}
			 
	    	waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
			
			bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
	    	}
			bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().click();	    	
	    	
	
			 String before_xpath="//span[contains(text(),'";
			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();

// Pencil
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryPencil());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryPencil().click();
			
			//Action Button
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetAction());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetAction().click();
			
			//Action edit
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit().click();
			
			
			// Submit button
			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
		
			//Remark
			javascripthelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
			javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys(bUDGET_SupplementaryBudgetTestDataType.MakerRemarkY);
		    
		
		    //Remark Submit
			waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
	    }
	    
	    //----------------------------------------SupplementaryBudget_BP_SB_08_03---------------------------------------------//
		//----------------------------Monthly Budget record for past year validation msg ------------------------------------//
	  
	

	    @Then("^fill required data for record$")
	    public void fill_required_data_for_record()  {
	    	 //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	 
	  	//budget  branch
	  		/* waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);*/
	  		//currency
	  		/* waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
	  	 	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);*/


	    }

	    @And("^enter past year$")
	    public void enter_past_year() throws InterruptedException {
	    	 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	    	 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  		Thread.sleep(2000);
	  		//WebElement toast = driver.findElement(By.xpath("//body/div/div/div/div[1]"));
	  		WebElement toast = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg();

	  		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.maker_VaildationMsg());
	  		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().isDisplayed());
	  		clicksAndActionHelper.moveToElement(toast);
	    	String message = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().getText();
	    	System.out.println(message);
	    	
	    	

	  		
	  		//Actions a = new Actions(driver);
	  		///a.moveToElement(toast).pause(3000).build().perform();
	  		//String msg=toast.getText();
	  		//System.out.println(msg);
	  
	    }
	    //----------------------------------------SupplementaryBudget_BP_SB_08_04---------------------------------------------//
		//-------------------------------Monthly Budget record for Lapsed period validation msg----------------------------//
	
	   

	    @Then("^fill required data for the record$")
	    public void fill_required_data_for_the_record()  {
	    	 //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	  		 //budget year
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  

	    }
	    @And("^enter Lapsed period$")
	    public void enter_lapsed_period()  {
	    	
	    	 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearM);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  		 
	  		WebElement toast = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg();

	  		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.maker_VaildationMsg());
	  		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().isDisplayed());
	  		clicksAndActionHelper.moveToElement(toast);
	    	String message = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().getText();
	    	System.out.println(message);
	  
	    }
	 
	    
	  //----------------------------------------SupplementaryBudget_BP_SB_11_01---------------------------------------------//
	  	//----------------------------------------------Annually Budget Option----------------------------------------------//
	 

	    @Then("^fill the input fields$")
	    public void fill_the_input_fields()  {
	    	 //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	  //budget year
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  	//budget  branch
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	  		//currency
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
	  	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);

	    }

	    @Then("^validate yearly supplementary apportion field$")
	    public void validate_yearly_supplementary_apportion_field()   {
	    	 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidatYearly());
	  		String text = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ValidatYearly().getText();
	  		System.out.println("Annual Option Avaialble on screen to raise Annual supplementary record: "+text);

	   
	    }
	    
	   
//----------------------------------------SupplementaryBudget_BP_SB_11_02---------------------------------------------//
	  	//----------------------------------------------Annually Budget Record----------------------------------------------//
	    @Then("^fill apportion amount and save the record$")
	    public void fill_apportion_amount_and_save_the_record() throws InterruptedException  {
	    	 //Supplementary apportion amount
	    	 bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	    	 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.SupplymentaryApportionAmtA);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);
	    	 
	  		 // New amount
	  		 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();
	    	 
	    	 
	    	 //save button
	    	 waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave());
	    	 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
	    	 Thread.sleep(2000);
	         javascripthelper.JavaScriptHelper(driver);
	         String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
	         System.out.println("Message:" +str);
	        
	    }
	    @Then("^validate maker can save request for the Annually budget$")
	    public void validate_maker_can_save_request_for_the_annually_budget() throws IOException, ParseException, InterruptedException   {
	   

			// Notification
			waithelper.waitForElement(driver,2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();
		
			//Reference
			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId());
	    	String id = bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().getText();
	    	jsonWriter.addReferanceData(id);
	    	System.out.println("Reference ID:" +id);
	    	for (int i = 1; i <= 35; i++) {
				try {
			    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
					referanceID.click();
			    	System.out.println(referanceID);
			    	//Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) 
				{
					waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
					
					bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
				}
			 
	    	waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
			
			bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
	    	}
			bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().click();	    	
	    	
			 //pencil 
			 String before_xpath="//span[contains(text(),'";
			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			  
			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
			
			// Pencil
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryPencil());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryPencil().click();
			
			//Action Button
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetAction());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetAction().click();
			
			//Action edit
			//waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit());
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit().click();
			
			
			// Submit button
			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
		
			//Remark
			javascripthelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 3000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
			javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys(bUDGET_SupplementaryBudgetTestDataType.MakerRemarkY);
		    
		
		    //Remark Submit
			waithelper.waitForElement(driver, 2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
			Thread.sleep(3000);
	        
	    }
	    	
	    
	    //----------------------------------------SupplementaryBudget_BP_SB_11_03---------------------------------------------//
	  	//-----------------------------Annually Budget Record for past Validation msg-------------------------------------//

	    @Then("^FillS the Input fields$")
	    public void fillS_the_input_fields()   {
	    	//budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCode);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	  		 
	    }
	  	    @Then("^validate maker cannot raise budget for past year$")
	  	    public void validate_maker_cannot_raise_budget_for_past_year()  {
	  	    //budget year
		  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYear);
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
		  		WebElement toast = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg();

		  		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.maker_VaildationMsg());
		  		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().isDisplayed());
		  		clicksAndActionHelper.moveToElement(toast);
		    	String message = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().getText();
		    	System.out.println(message);
	  	    }
	  		
	   
	   
	    
	   
	  //----------------------------------------SupplementaryBudget_BP_SB_11_04---------------------------------------------//
	  	//-----------------------------Annually Budget Record for Lapsed period Validation msg-------------------------------------//
	   

	    @Then("^FillS the Input fieldss$")
	    public void fillS_the_input_fieldss() throws InterruptedException  {
	   	 //budget code
	  		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCode);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	  //budget year
	  		 waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYear);
	  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	  
	  		WebElement toast = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg();

	  		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.maker_VaildationMsg());
	  		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().isDisplayed());
	  		clicksAndActionHelper.moveToElement(toast);
	    	String message = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().getText();
	    	System.out.println(message);
	   
	   
	    }

//----------------------------------------SupplementaryBudget_BP_SB_06_03---------------------------------------------//
	  	//-----------------------------Checker Return the supplementary budget record -------------------------------------//
	   

	    			 @And("^Verify the record is Return$")
	    	    public void verify_the_record_is_Return()  {
	    		//validate buttons	
	    			waithelper.waitForElement(driver,4000,kubschecker.checkerRejectButton());
	    	    	Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
	    	    	waithelper.waitForElement(driver,4000,kubschecker.checkerReturnButton());
	    	    	Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
	    	    	
	    	  //return
	    		
	    			kubschecker.checkerReturnButton().click();
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    			kubschecker.checkerRemarks().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CheckerReturnRemark);
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    			kubschecker.checkersubmitButton().click();

	    	   
	    	    }
	    	//----------------------------------------SupplementaryBudget_BP_SB_03_01---------------------------------------------//
		  	//-----------------------------Checker Approve the supplementary budget record -------------------------------------//
	    	@And("^Verify the record is Approved$")
    	    public void verify_the_record_is_Approved()  {
    		//validate buttons	
    	    	waithelper.waitForElement(driver,4000,kubschecker.checkerApproveButton());
    	    	Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());
    	  //Approve
    			
    			kubschecker.checkerReturnButton().click();
    			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
    			kubschecker.checkerRemarks().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CheckerRemark);
    			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
    			kubschecker.checkersubmitButton().click();
    			
	    	}
	    	
	    	//-----------------------------------Tushar-----------------------------------//
	    	//--------------------------------------------------------------------------//
	    	//--------------------------------------------------------------------------//
	    			
	    	    
	    	//----------Budget_BudgetSupplementary_BP_SB_03_02--------------//
	    	 
	      
	        @And("^Find the budget code which is submitted from maker$")
	        public void find_the_budget_code_which_is_submitted_from_maker() throws Throwable  {
	        	browserHelper = new BrowserHelper(driver);
	        	 
	        }
	        
	        @Then("^Click on action Button$")
	        public void click_on_action_button() throws Throwable, Throwable    {
	           
	       
	      //span[contains(text(),'390')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button
//	        String before_xpath="//span[contains(text(),'";
//	    String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//	     
//	    waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
//	    driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	        }
	    @And("^Verify the record is generated by opening the record$")
	        public void verify_the_record_is_generated_by_opening_the_record()   {
	    		waithelper.waitForElement(driver,4000,kubschecker.checkerRejectButton());
	    	
	        	Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
	        	waithelper.waitForElement(driver,4000,kubschecker.checkerReturnButton());
	        	Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
	        	waithelper.waitForElement(driver,4000,kubschecker.checkerApproveButton());
	    		
	        	Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());
	       
	        }

	        
	        //-----------Budget_BudgetSupplementary_BP_SB_04_01-----------//
	       

	    	    @Then("^Click  on action button of record user want to reject$")
	    	    public void click_on_action_button_of_record_user_want_to_reject() throws Throwable {
	    	 //   	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
	    	//		driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	    	   String before_xpath="//span[contains(text(),'";
//	    	    	   String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//	    	    	    
//	    	    	   waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
//	    	    	   driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();	
	    	    }

	    	    @Then("^Click  on the reject button$")
	    	    public void click_on_the_reject_button() throws Throwable {
	    	    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
	    			kubschecker.checkerRejectButton().click();
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    			kubschecker.checkerRemarks().sendKeys("ok");
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    			kubschecker.checkersubmitButton().click();
	    			waithelper.waitForElement(driver,3000,kubschecker.checker_right_corner_reject_toast());
	    	    	Assert.assertTrue(kubschecker.checker_right_corner_reject_toast().isDisplayed());
	    	        
	    	    }
	    	  //-----------Budget_BudgetSupplementary_BP_SB_04_04-----------//
	    	    
	    	    
	    	    @Then("^Click on action  button of record user want to reject the record.$")
	    	    public void click_on_action_button_of_record_user_want_to_reject_the_record() throws Throwable {
	    	    //	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
	    		//	driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	    	   String before_xpath="//span[contains(text(),'";
//	    	    	   String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//	    	    	    
//	    	    	   waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
//	    	    	   driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();	
	    	    }

	    	    @Then("^Click on reject the button.$")
	    	    public void click_on_reject_the_button() throws Throwable {
	    	    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
	    			kubschecker.checkerRejectButton().click();
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    			kubschecker.checkerRemarks().sendKeys("ok");
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    			kubschecker.checkersubmitButton().click();
	    			Thread.sleep(2000);
	    			
	    			
	    			//this code approve the record we need code for rejection
	    			waithelper.waitForElement(driver,3000,kubschecker.checker_right_corner_reject_toast());
	    	    	Assert.assertTrue(kubschecker.checker_right_corner_reject_toast().isDisplayed());
	    	        
	    	    }
	    	    //-----------Budget_BudgetSupplementary_BP_SB_06_01-----------//
	    	    @Then("^Click  on action  button of record user want to approv or reject$")
	    	    public void click_on_action_button_of_record_user_want_to_approvreject() throws Throwable {
	    	    	//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
	    		//	driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	    	   String before_xpath="//span[contains(text(),'";
//	    	    	   String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//	    	    	    
//	    	    	   waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
//	    	    	   driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	    	    	   waithelper.waitForElement(driver,2000,kubschecker.checkerRejectButton());
	    	    		
	    	       		Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
	    	       		waithelper.waitForElement(driver, 2000,kubschecker.checkerReturnButton());
	    	       		Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
	    	       		waithelper.waitForElement(driver, 2000,kubschecker.checkerApproveButton());
	    	       		Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());
	    	         
	    	    }

//-----------Budget_BudgetSupplementary_BP_SB_06_06-----------//
	    	    @Then("^Click  on  action  button of record user want to Return$")
	    	    public void click_on_action_button_of_record_user_want_to_return() throws Throwable {
	    	    	//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
	    			//driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//	    	    	  String before_xpath="//span[contains(text(),'";
//	    	    	   String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//	    	    	    
//	    	    	   waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
//	    	    	   driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	    			waithelper.waitForElement(driver,4000,kubschecker.checkerReturnButton());
	    			kubschecker.checkerReturnButton().click();
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    			kubschecker.checkerRemarks().sendKeys("ok");
	    			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    			kubschecker.checkersubmitButton().click();
	    	    }

	    	    @Then("^Capture  the popup that shows in right corner$")
	    	    public void capture_the_popup_that_shows_in_right_corner() throws Throwable {
	    	    	waithelper.waitForElement(driver,3000,kubschecker.checker_right_corner_green_toast());
	    	    	Assert.assertTrue(kubschecker.checker_right_corner_green_toast().isDisplayed());
	    	    }
	    	    //--------------Auto Auth---------------------//
	    	    //--------SupplementaryBudget_BP_SB_01_03------//
	    	    
	    	    
	    	    @And("^enter invalid year$")
	    	    public void enter_invalid_year() 
	    	    {
	    	    
	    	    waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearM);
		  		 bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
		  		 
		  		WebElement toast = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg();

		  		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.maker_VaildationMsg());
		  		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().isDisplayed());
		  		clicksAndActionHelper.moveToElement(toast);
		    	String message = bUDGET_SupplementaryBudgetObj.maker_VaildationMsg().getText();
		    	System.out.println(message);
	    	    }
	    	 // ------Auto auth new tushar-----------BP_SB_01_04--------------
	    		@Then("^aprove the record$")
	    		public void aprove_the_record() throws Throwable {
	    			

	    			// Notification
	    			waithelper.waitForElement(driver,2000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();
	    		
	    			//Reference
	    			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId());
	    	    	String id = bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().getText();
	    	    	jsonWriter.addReferanceData(id);
	    	    	System.out.println("Reference ID:" +id);
	    	    	for (int i = 1; i <= 35; i++) {
	    				try {
	    			    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
	    					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
	    					referanceID.click();
	    			    	System.out.println(referanceID);
	    			    	//Assert.assertTrue(referanceID.isDisplayed());
	    					break;
	    				} catch (NoSuchElementException e) 
	    				{
	    					waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
	    					
	    					bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
	    				}
	    			 
	    	    	waithelper.waitForElement(driver,4000,bUDGET_SupplementaryBudgetObj.maker_notification_next_button());
	    			
	    			bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
	    	    	}
	    			bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstReferenceId().click();	    	
	    	    	
	    			 //pencil 
	    			 String before_xpath="//span[contains(text(),'";
	    			 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
	    			  
	    			 waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
	    			 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
	    			 
	    			 //approve
	    			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.maker_Approve_button());
	    			bUDGET_SupplementaryBudgetObj.maker_Approve_button().click();
	    			//Remark text
	    			waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
	    			javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField()
	    					.sendKeys(bUDGET_SupplementaryBudgetTestDataType.RemarkByMaker);
	    			Thread.sleep(2000);
	    			//remark submit
	    			waithelper.waitForElement(driver, 2000,
	    					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
	    			Thread.sleep(2000);
	    		}

	    		// --------------------Budget_BudgetSupplementary_BP_SB_01_02-------------
	    		@Then("^Search the created record$")
	    		public void search_the_created_record() throws Throwable {
	    			Thread.sleep(2000);
	    			waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();
	    			// search icon
	    			waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();
	    			Thread.sleep(2000);
	    			// Budget code
	    			bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	    			waithelper.waitForElement(driver, 5000,bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeA);
	    			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
	    			// select the record
	    			waithelper.waitForElement(driver, 3000,
	    					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());
	    			// bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed();
	    			Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed());
	    		}


  //--------------------------- TESTCASE (BP_SB_09_01) ----------------------------//
    
    @Given("^navigate to kubs url and login as maker user$")
    public void navigate_to_kubs_url_and_login_as_maker_user() throws InterruptedException {
    	login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }

    @Then("^select budget menu$")
    public void select_budget_menu() throws InterruptedException  {
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon().click();
    	
    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
    }
    
    @And("^click on the eye icon of supplementary budget sub menu$")
    public void click_on_the_eye_icon_of_supplementary_budget_sub_menu()  {
    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();
    	
    }

    @Then("^click on add button$")
    public void click_on_add_button() throws InterruptedException  {
    	Thread.sleep(2000);
    	//waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
    }

    @And("^fill the required field for quarterly budget type$")
    public void fill_the_required_field_for_quarterly_budget_type()  {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    }

    @Then("^verify quarterly option is available on screen$")
    public void verify_quarterly_option_is_available_on_screen() {
    	
        for(int i=1;i<5;i++)
        {
        	String beforexpath="//ion-row//datatable-row-wrapper[";
        	String afterxpath="]//datatable-body-row//div[2]//datatable-body-cell[1]//div";
        	boolean result=driver.findElement(By.xpath(beforexpath + i + afterxpath)).isDisplayed();
        	if(result==true&&i==1)
        	{
        		System.out.println("Quarter1 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==2)
        	{
        		System.out.println("Quarter2 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==3)
        	{
        		System.out.println("Quarter3 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==4)
        	{
        		System.out.println("Quarter4 period is displayed on screen:" + result);
        	}
        }
        for(int i=1;i<5;i++)
        {
        	String beforexpath="//ion-row//datatable-row-wrapper[";
        	String afterxpath="]//datatable-body-row//div[2]//datatable-body-cell[3]//div";
        	boolean result=driver.findElement(By.xpath(beforexpath + i + afterxpath)).isDisplayed();
        	if(result==true&&i==1)
        	{
        		System.out.println("Apportioned amount field for Quarter1 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==2)
        	{
        		System.out.println("Apportioned amount field for Quarter2 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==3)
        	{
        		System.out.println("Apportioned amount field for Quarter3 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==4)
        	{
        		System.out.println("Apportioned amount field for Quarter4 period is displayed on screen:" + result);
        	}
        }
    }
    @And("^maker user should logout$")
    public void maker_user_should_logout() throws InterruptedException {
    	
    	waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_ProfileName());
    	bUDGET_SupplementaryBudgetObj.budget_ProfileName().click();
    	
     	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_Logout());
    	bUDGET_SupplementaryBudgetObj.budget_Logout().click();
    }
    
  //--------------------------- TESTCASE (BP_SB_09_02) ----------------------------//

    @And("^fill the required fields for quarterly budget type$")
    public void fill_the_required_fields_for_quarterly_budget_type()  {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_QuarterlyApportionedAmountQ3());
    	bUDGET_SupplementaryBudgetObj.budget_QuarterlyApportionedAmountQ3().click();
    	bUDGET_SupplementaryBudgetObj.budget_QuarterlyApportionedAmountQ3().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetQuarter3Amount);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_NewQuarter3Amount());
    	bUDGET_SupplementaryBudgetObj.budget_NewQuarter3Amount().click();
    }
    
    @Then("^save the record and submit to verify$")
    public void save_the_record_and_submit_to_verify() throws InterruptedException  {
    	bUDGET_BudgetCreationObj.budgetCreation_saveButton().click();
    	Thread.sleep(2000);
    	javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
    	System.out.println("Message:" +str);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton().click();
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId());
    	String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().getText();
    	
    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton().click();
    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
    	javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys(bUDGET_SupplementaryBudgetTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
    	Thread.sleep(2000);
    	WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
    	System.out.println(message);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
    }
    
  //--------------------------- TESTCASE (BP_SB_09_03) ----------------------------//

    @And("^fill the required fields for Quarterly type budget for past month$")
    public void fill_the_required_fields_for_quarterly_type_budget_for_past_month()  {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForQuarterlyPast);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);	
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_QuarterlyApportionedAmountQ3());
    	bUDGET_SupplementaryBudgetObj.budget_QuarterlyApportionedAmountQ3().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetQuarter3Amount);
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_NewQuarter3Amount());
    	bUDGET_SupplementaryBudgetObj.budget_NewQuarter3Amount().click();
    }
    
    @Then("^Save the record to verify it$")
    public void save_the_record_to_verify_it() throws InterruptedException  {
    	Thread.sleep(3000);
    	bUDGET_BudgetCreationObj.budgetCreation_saveButton().click();
    }

    @And("^system should display validation message$")
    public void system_should_display_validation_message() throws InterruptedException {
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth());
    	WebElement validationmesssage = bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth();
    	clicksAndActionHelper.moveToElement(validationmesssage);
    	String message = bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth().getText();
    	System.out.println("Validation Message for past months:" + message);
    	bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth().click();        
    }
    
  //--------------------------- TESTCASE (BP_SB_09_04) ----------------------------//

    @And("^fill the required fields for Quarterly type budget for lapsed period$")
    public void fill_the_required_fields_for_quarterly_type_budget_for_lapsed_period()  {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForQuarterly);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForQuarterlyPast);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    }
    
    @Then("^system should display validation message for lapsed period$")
    public void system_should_display_validation_message_for_lapsed_period()  {
    	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth());
    	WebElement validationmesssage = bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth();
    	clicksAndActionHelper.moveToElement(validationmesssage);
    	String message = bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth().getText();
    	System.out.println("Validation Message for lapsed period:" + message);
    	bUDGET_SupplementaryBudgetObj.budget_ValidationMessageForPastMonth().click();
    }

    //--------------  TESTCASE BP_SB_10_01  --------------//

    @And("^fill the required field for Biannually budget type$")
    public void fill_the_required_field_for_biannually_budget_type()  {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCommentsForBiannuallyy);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForBiannuallyy);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    }
    
    @Then("^verify Biannually option is available on screen$")
    public void verify_biannually_option_is_available_on_screen()  {
    	for(int i=1;i<3;i++)
        {
        	String beforexpath="//ion-row//datatable-row-wrapper[";
        	String afterxpath="]//datatable-body-row//div[2]//datatable-body-cell[1]//div";
        	boolean result=driver.findElement(By.xpath(beforexpath + i + afterxpath)).isDisplayed();
        	if(result==true&&i==1)
        	{
        		System.out.println("HalfYear1 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==2)
        	{
        		System.out.println("HalfYear2 period is displayed on screen:" + result);
        	}
        }
        for(int i=1;i<3;i++)
        {
        	String beforexpath="//ion-row//datatable-row-wrapper[";
        	String afterxpath="]//datatable-body-row//div[2]//datatable-body-cell[4]//div";
        	boolean result=driver.findElement(By.xpath(beforexpath + i + afterxpath)).isDisplayed();
        	if(result==true&&i==1)
        	{
        		System.out.println("Apportioned amount field for HalfYear1 period is displayed on screen:" + result);
        	}
        	if(result==true&&i==2)
        	{
        		System.out.println("Apportioned amount field for HalfYear2 period is displayed on screen:" + result);
        	}
        } 
    }

    //--------------  TESTCASE BP_SB_10_02  --------------//
    
    @And("^fill the required fields for Biannually budget type$")
    public void fill_the_required_fields_for_biannually_budget_type() throws InterruptedException {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForBiannuallyy);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_ApportionedAmountForHalfYear1());
    	bUDGET_SupplementaryBudgetObj.budget_ApportionedAmountForHalfYear1().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetAmountFor1stHalfyear);
    	//bUDGET_SupplementaryBudgetObj.budget_NewAmountForHalfYear1().click();
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCommentsForBiannuallyy);
    	//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	//Thread.sleep(3000);
    }
    
    //------------------------TestCase BP_SB_10_04--------------------------//
    @And("^fill the required fields for biannually type budget for lapsed period$")
    public void fill_the_required_fields_for_biannually_type_budget_for_lapsed_period() {
    	bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("Maker");
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForBiannually);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForBiannuallyPast);
    	bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
       
    }
}
