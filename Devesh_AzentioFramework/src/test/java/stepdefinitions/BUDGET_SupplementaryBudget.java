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
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_SupplementarybudgetTestDataType;

public class BUDGET_SupplementaryBudget extends BaseClass {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	DropDownHelper dropDownHelper;
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj=new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_BudgetCreationObj bUDGET_BudgetCreationObj=new BUDGET_BudgetCreationObj(driver);
	KUBS_CheckerObj kubschecker= new KUBS_CheckerObj(driver);
	KUBS_MakerObj kubsMakerObj;
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;
	KUBS_Login login;
	ConfigFileReader config = new ConfigFileReader();
	WaitHelper waithelper =new WaitHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonConfig jsonReader=new JsonConfig();
	
	@When("^maker click on budget supplementary eye icon$")
	public void maker_click_on_budget_supplymentary_view_icon()  {
		kubsMakerObj.budget_SupplementaryBudget_SupplementaryBudgetEyeIcon().click();
	}
	@And("^click on add button on budget supplementary view page$")
	public void click_on_add_button_on_budget_supplementary_view_page()  {
		kubsMakerObj.budget_SupplementaryBudget_SupplementaryBudgetAddButton().click();
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
    
  //--------------------------- TESTCASE (BP_SB_09_01) ----------------------------//
    
    @Given("^navigate to kubs url and login as maker user$")
    public void navigate_to_kubs_url_and_login_as_maker_user() throws InterruptedException {
    	login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
    }

    @Then("^select budget menu$")
    public void select_budget_menu()  {
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
    	Thread.sleep(1000);
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































