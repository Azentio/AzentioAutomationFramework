package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class Budget_BusgetTransfer_BP_BT_UAT_006_001 {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper;
	JavascriptHelper javahelper = new JavascriptHelper();
	BUDGET_BudgetTransferObj budgetTransferObj;
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	KUBS_Login login;
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00071\\Downloads\\KUBSTestDataDesign.xlsx","BudgetTransferTestData","Data Set ID");
	Map<String, String> budget;


    @When("^User login to maker$")
    public void user_login_to_maker() throws InterruptedException  {
    	login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppByMaker();
    }

    @Then("^click on configuration$")
    public void click_on_configuration()   {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

    }

    @And("^click on finance$")
    public void click_on_finance()  {
      
    }

    @Then("^click on direction button$")
    public void click_on_direction_button()   {
      
    }
    @And("^Budget button$")
    public void budget_button()   {
    	waithelper = new WaitHelper(driver);
		budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

    }
    @Then("^Click on budget transfer eye button$")
    public void click_on_budget_transfer_eye_button() throws Throwable {
    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_EyeButton());
		budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
    }

    @Then("^click on add buttion$")
    public void click_on_add_buttion()   {
    	waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_AddButton());
		budgetTransferObj.budget_BudgetTransfer_AddButton().click();
    }

    @Then("^fill the form$")
    public void fill_the_form() throws Throwable {
    	dropDownHelper = new DropDownHelper(driver);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budget.get("BudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budget.get("BudgetYear"));
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
		budgetTransferObj.budget_BudgetTransfer_Branch().click();

		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budget.get("Branch"));
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
				.sendKeys(budget.get("TransferToBudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budget.get("Currency"));
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budget.get("ApportionedAmountA"));
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
		budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budget.get("ApportionedAmountB"));
		

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
		budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();


    }
    @And("^save the form$")
    public void save_the_form() throws Throwable {

		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
		budgetTransferObj.budget_BudgetTransfer_SaveButton().click();

    }
    @Then("^form should get save$")
    public void form_should_get_save() throws Throwable {
        
    }
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
    WaitHelper waitHelper=new WaitHelper(driver);
    ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
    JavascriptHelper javascriptHelper =new JavascriptHelper();
    KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
    KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
    
    
    @Then("^choose first record in the notification record in budgetTransfer$")
	public void choose_first_record_in_the_notification_record_in_arap_budgettransfer() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				1);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_BP_UAT_006_001_01_D1","Reference ID",referenceID);
		budget = excelData.getTestdata("KUBS_BP_UAT_006_001_01_D1");
		
		budgetCreationObj.budgetCreationFirstRecord().click();

	}
    @Then("^choose first record in the notification record in budgetTransfer1$")
	public void choose_first_record_in_the_notification_record_in_arap_budgettransfer1() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				1);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		//jsonReaderWriter.addReferanceData(referenceID);
		excelData.updateTestData("KUBS_BP_UAT_006_004_01_D1","Reference ID",referenceID);
		budget = excelData.getTestdata("KUBS_BP_UAT_006_004_01_D1");
		
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

    
    @Then("^enter remark in confirmation alert in budgetTransfer$")
	public void enter_remark_in_confirmation_alert_in_budgettransfer() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				500);
		for (int i = 0; i <= 50; i++) {
			try {
				clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());

				clickAndActions.clickUsingActionClass(budgetCreationObj.budgetCreation_AlertRemarks(),
						budgetCreationObj.budgetCreation_AlertRemarks());
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budget.get("remark"));

	}
    @And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in budgetTransfer$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_budgettransfer()
			throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		excelData.updateTestData("KUBS_BP_UAT_006_001_01_D11","Reviewer ID",revID);
		budget = excelData.getTestdata("KUBS_BP_UAT_006_001_01_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}
    @And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage in budgetTransfer1$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage_in_budgettransfer1()
			throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		excelData.updateTestData("KUBS_BP_UAT_006_004_01_D1","Reviewer ID",revID);
		budget = excelData.getTestdata("KUBS_BP_UAT_006_004_01_D1");
		
		//jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}


    
    @Then("^click on submit button in alert in budgetTransfer$")
	public void click_on_submit_button_in_alert_in_budgettransfer() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
			for (int i = 0; i <= 50; i++) {
				try {
					clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AlertRemarks());
					clickAndActions.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
					budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budget.get("remark"));
					budgetCreationObj.budgetCreation_AlertsubmitButton().click();
					break;
				} catch (Exception e) {
					if (i == 50) {
						Assert.fail(e.getMessage());
					}
				}
			}
		}
	}

    @And("^select our record in notification records using reference ID in budgetTransfer$")
	public void select_our_record_in_notification_records_using_reference_id_in_budgettransfer() throws Throwable {
		//KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
		/*
		 * After click on the notification icon lot of records will shown there, We have
		 * to select our record by the help of reference ID which is captured in maker
		 * stage
		 *
		 * before_xpath and after_xpath string variable are used to customize the xpath
		 * as per our reference ID
		 */
		// Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerNotidicationIcon(), 60,
						500);
				kubsReviewerObj.reviewerNotidicationIcon().click();
				waitHelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)));
				javascriptHelper.JSEClick(driver
						.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)));
				// driver.findElement(By.xpath(before_xpath +
				// jsonReaderWriter.readReferancedata() + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
    
    @And("^enter the remark in alert2$")
	public void enter_the_remark_in_alert2() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(budget.get("approvalCommentsFromReviewer"));
	}
	@Then("^click on submit in alert2$")
	public void click_on_submit_in_alert2() throws Throwable {
		while (true) {

			try {
				waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
				kubsReviewerObj.reviewerAlertSubmitButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				kubsReviewerObj.reviewerAlertRemarks().click();
				kubsReviewerObj.reviewerAlertRemarks()
						.sendKeys(budget.get("approvalCommentsFromReviewer"));
			}
		}
	}
	
	@And("^select our record and clime using reference ID in budgetTransfer$")
	public void select_our_budget_record_and_clime_using_reference_id_in_budgettransfer() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 0; i <= 200; i++) {
			try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//				80, 500);
				WebElement climeButton = driver
						.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath_claim));

				boolean bool = climeButton.isDisplayed();
				clickAndActions.clickOnElement(climeButton);

				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^select our record in notification records by the help of reference ID in budgetTransfer$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id_in_budgettransfer() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
//				waitHelper.waitForElementToVisibleWithFluentWait(driver,
//						driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)),
//						100, 500);
				clickAndActions.moveToElement(driver
						.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)));
				clickAndActions.clickOnElement(driver
						.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)));
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	
	
	@Then("^click on the submit button which is appeared in alert box in budgetTransfer$")
	public void click_on_the_submit_button_which_is_appeared_in_alert_box_in_budgettransfer() throws Throwable {
		ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj=new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
		javascriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				javascriptHelper.JSEClick(invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
				// clicksAndActions.doubleClick(invoiceBookingObj.AlertRemark());
				// invoiceBookingObj.AlertRemark().click();
				Thread.sleep(1000);
				invoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker()
						.sendKeys(budget.get("remark"));
				break;
			} catch (ElementNotInteractableException e) {

			}
		}

		waitHelper.waitForElementVisible(invoiceBookingObj.alertSubmitButton(), 2000, 100);

		invoiceBookingObj.alertSubmitButton().click();

	}
	JavascriptHelper javascripthelper = new JavascriptHelper();
	
	@Then("^Maker fill the details and save in budgetTransfer$")
	public void maker_fill_the_details_and_save_budgettransfer() throws InterruptedException {
		// Budget code
		budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown());
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budget.get("BudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);

		// Year
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown());
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budget.get("BudgetYear"));
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);

		// Branch
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_Branch());
		budgetTransferObj.budget_BudgetTransfer_Branch().click();
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budget.get("Branch"));
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

		// Transfer to Budget code
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode());
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
				.sendKeys(budget.get("TransferToBudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);

		// Currency
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_CurrencyChange());
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budget.get("Currency"));
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

		// Apportioned Amount A
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA()
				.sendKeys(budget.get("ApportionedAmountA"));

		// New Amount A
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
		budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

		// Apportioned Amount B
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB()
				.sendKeys(budget.get("ApportionedAmountB"));

		// New Amount B
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
		budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();

		// Save
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
		budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

	}
	
	@Then("^Maker modify the amount in budgetTransfer$")
	public void maker_modify_the_amount_in_budgettransfer() throws Throwable {
		// Reference
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
		
		excelData.updateTestData("KUBS_BP_UAT_006_004_01_D1","Reference ID",id);
		budget = excelData.getTestdata("KUBS_BP_UAT_006_004_01_D1");
		//jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		
		
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + budget.get("Reference ID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" +budget.get("Reference ID")+ "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

				budgetTransferObj.maker_notification_next_button().click();
			}

			waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

			budgetTransferObj.maker_notification_next_button().click();
		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)));
		driver.findElement(By.xpath(before_xpath +budget.get("Reference ID")+ after_xpath)).click();

		Thread.sleep(2000);

		// Apportioned Amount A
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA()
				.sendKeys(budget.get("ApportionedAmountA1"));

		// New Amount A
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_fromNewAmountA());
		budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

		// Apportioned Amount B
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB());
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountB()
				.sendKeys(budget.get("ApportionedAmountB1"));

		// New Amount B
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_NewAmountB());
		budgetTransferObj.budget_BudgetTransfer_NewAmountB().click();

		// Save
		waithelper.waitForElement(driver, 3000, budgetTransferObj.budget_BudgetTransfer_SaveButton());
		budgetTransferObj.budget_BudgetTransfer_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
	}
	
	@Then("^fill the form and enter excessive budget amount to transfer in budgetTransfer$")
    public void fill_the_form_and_enter_excessive_budget_amount_to_transfer_in_budgettransfer() throws InterruptedException   {
    	dropDownHelper = new DropDownHelper(driver);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver, budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(budget.get("BudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().click();
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(budget.get("BudgetYear"));
		budgetTransferObj.budget_BudgetTransfer_BudgetYearDropdown().sendKeys(Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_Branch(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_Branch().click();

		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(budget.get("Branch"));
		budgetTransferObj.budget_BudgetTransfer_Branch().sendKeys(Keys.DOWN, Keys.ENTER);

		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().click();
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode()
				.sendKeys(budget.get("TransferToBudgetCode"));
		budgetTransferObj.budget_BudgetTransfer_TransferToBudgetCode().sendKeys(Keys.DOWN, Keys.ENTER);
		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_CurrencyChange(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().click();
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(budget.get("Currency"));
		budgetTransferObj.budget_BudgetTransfer_CurrencyChange().sendKeys(Keys.DOWN, Keys.ENTER);

		//budgetTransferTestDataType = jsonReader.getBudgetTransferdata("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().click();
		budgetTransferObj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budget.get("ApportionedAmountA"));
		waithelper.waitForElementToVisibleWithFluentWait(driver,budgetTransferObj.budget_BudgetTransfer_fromNewAmountA(), 70, 500);
		budgetTransferObj.budget_BudgetTransfer_fromNewAmountA().click();

	
	/*	public class ShadowDom extends BaseClass{
		WebDriver driver=BaseClass.driver;
		JavascriptHelper javascripthelper=new JavascriptHelper();
		WaitHelper waithelper=new WaitHelper(driver);
		WebElement element;
	
		
		BUDGET_BudgetTransferObj budgetTransfer=new BUDGET_BudgetTransferObj(driver);
		element=(WebElement)javascripthelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")")
		String str=element.getText();
		System.out.println("String message is :"+str")
		}*/
		

		String script ="return document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")";
		//document.querySelector('ion-toast').shadowRoot.querySelector("div[class='toast-message']")
	    for(int i=0;i<=30;i++)
	    {
			javahelper.JavaScriptHelper(driver);
	    	try
	    	{
	    		WebElement successMsg1 = (WebElement) javahelper.executeScript(
						"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");

				String successmsg1 = successMsg1.getText();
				System.out.println(successmsg1);
	    	break;
	    	}
	    	catch(JavascriptException e)
	    	{
	    		
	    	}
	    	catch(NullPointerException e2)
	    	{
	    		
	    	}
	    	}
	    }






    

    
}
