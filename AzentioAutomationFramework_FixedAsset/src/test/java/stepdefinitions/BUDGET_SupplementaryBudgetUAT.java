package stepdefinitions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
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
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import utilities.ExtentTestManager;

public class BUDGET_SupplementaryBudgetUAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javahelper = new JavascriptHelper();
	AzentioLogin login = new AzentioLogin(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	// Checker//
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	JavascriptHelper javascript;
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	String referance_id;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig = new JsonConfig();
	ConfigFileReader config = new ConfigFileReader();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	String user = "Maker";
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	String path = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBudgetSupplementary = new ExcelData(path,"BudgetSupplimentory","DataSet ID");
	Map<String, String> budgetSupplementaryTestData;
//	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);

	// ----------------------------------------SupplementaryBudget_KUBS_BP_UAT_005_004---------------------------------------------//
	// ----------------------------------------------Budget Record
	@And("^User Update test data id to verify budget supplementary approved record$")
    public void user_update_test_data_id_to_verify_budget_supplementary_approved_record() throws Throwable {
		budgetSupplementaryTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_004_04_D1");
    }
	@And("^User Update test data id to verify budget supplementary record$")
	public void user_update_test_data_id_to_verify_budget_supplementary_record() throws Throwable {
		budgetSupplementaryTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_006_04_D1");
	}
	@And("^User Update test data id to verify budget supplementary Rejected record$")
    public void user_update_test_data_id_to_verify_budget_supplementary_rejected_record() throws Throwable {
		budgetSupplementaryTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_005_04_D1");
    }

	@And("^User update test data id to do Budget supplementary for yearly4 budget code$")
    public void user_update_test_data_id_to_do_budget_supplementary_for_yearly4_budget_code() throws Throwable {
		budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_004_01_D1");
    }
	@And("^User Update test data id to store new Amount for Verification$")
    public void user_update_test_data_id_to_store_new_amount_for_verification() throws Throwable {
		budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_004_04_D1");
    }

    @And("^User Update test data id to store new Amount for Verification rejected$")
    public void user_update_test_data_id_to_store_new_amount_for_verification_rejected() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_005_04_D1");
    }
    @And("^User Update test data id to store new Amount for Verification rejected HO$")
    public void user_update_test_data_id_to_store_new_amount_for_verification_rejected_ho() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_006_04_D1");
    }

    @And("^User update test data id to do More amount of Budget supplementary for yearly budget code$")
    public void user_update_test_data_id_to_do_more_amount_of_budget_supplementary_for_yearly_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_002_D1");
    }
    @And("^User Update Test data id to Modify Budget Supplimentary for Yearly Budget Code$")
    public void user_update_test_data_id_to_modify_budget_supplimentary_for_yearly_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_003_D1");
    }
    @And("^User update test data id to do Budget supplementary Rejection for yearly4 budget code$")
    public void user_update_test_data_id_to_do_budget_supplementary_rejection_for_yearly4_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_005_01_D1");
    }
    @And("^User update test data id to Reject Budget supplementary  for yearly4 budget code$")
    public void user_update_test_data_id_to_reject_budget_supplementary_for_yearly4_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_006_01_D1");
    }
    @And("^User update test data id to store reviewver id for budget supplementary yearly4 budget code$")
    public void user_update_test_data_id_to_store_reviewver_id_for_budget_supplementary_yearly4_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_005_02_D1");
    }
    @And("^User update test data id to store reviewver id for budget supplementary yearly budget code$")
    public void user_update_test_data_id_to_store_reviewver_id_for_budget_supplementary_yearly_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_004_02_D1");
    }
    @And("^User update test data id to store reviewver id for HO budget supplementary yearly budget code$")
    public void user_update_test_data_id_to_store_reviewver_id_for_ho_budget_supplementary_yearly_budget_code() throws Throwable {
    	budgetSupplementaryTestData=excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_006_02_D1");
    }
	@Given("^maker should navigate to the url and login with valid credentials UAT$")
	public void maker_should_navigate_to_the_url_and_login_with_valid_credentials_UAT() throws InterruptedException {
		login = new AzentioLogin(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@And("^maker should navigate to the budget module UAT$")
	public void maker_should_navigate_to_the_budget_module_UAT() throws InterruptedException {
		waithelper = new WaitHelper(driver);
		bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(kubsMakerObj.kubsToolIcon());
		clicksAndActionHelper.doubleClick(kubsMakerObj.kubsToolIcon());

		
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon(), 60, 500);
		clicksAndActionHelper.moveToElement(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		clicksAndActionHelper.doubleClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
	}

	@And("^maker click on budget field UAT$")
	public void maker_click_on_budget_field_UAT() {
//		waithelper.waitForElementVisible(kubsMakerObj.kubsBudget(), 3000, 300);
//		kubsMakerObj.kubsBudget().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField(), 120, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
	}

	@When("^maker click on budget supplementary eye icon UAT$")
	public void maker_click_on_budget_supplymentary_eye_icon_UAT() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();

	}
	@Then("^click on the search button budget supplementary approved record$")
    public void click_on_the_search_button_budget_supplementary_approved_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementarySearchIconInApprovedListView(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementarySearchIconInApprovedListView().click();
    }
	@And("^User Search the Budget Code to verify Budget Supplementary$")
    public void user_search_the_budget_code_to_verify_budget_supplementary() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(budgetSupplementaryTestData.get("BudgetCodeCreated"));
		
    }
	@And("^User Click First view icon of Budget Supplementary record$")
    public void user_click_first_view_icon_of_budget_supplementary_record() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstEyeIconApprovedRecord(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_BudgetTransfer_SupplementaryFirstEyeIconApprovedRecord().click();
    }

	@And("^User Verify Budget Supplementary Amount is Not Reflected$")
	public void user_verify_budget_supplementary_amount_is_not_reflected() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		String SupplementaryAmount = (String) javascripthelper.executeScript("return document.getElementsByTagName('input')[12].value");
		System.out.println(SupplementaryAmount);
		String NewAmount = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_StoreNewAmount().getAttribute("ng-reflect-selected-value");
		System.out.println(NewAmount);
		Assert.assertFalse(NewAmount.equalsIgnoreCase(budgetSupplementaryTestData.get("NewAmount")));
	}
	@And("^User Verify Budget Supplementary Amount is Reflected$")
    public void user_verify_budget_supplementary_amount_is_reflected() throws Throwable {
		String NewAmount = null;
		for (int i = 0; i <200; i++) {
			try {
				 NewAmount =  bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_StoreNewAmount().getAttribute("ng-reflect-selected-value");
				 break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail("New Amount Values not Stored");
				}
			}
		}
		Assert.assertTrue(NewAmount.split("[.]")[0].equalsIgnoreCase(budgetSupplementaryTestData.get("NewAmount")));
    }

	@And("^click on add button on budget supplementary view page UAT$")
	public void click_on_add_button_on_budget_supplementary_view_page_UAT() throws InterruptedException {

for(int i=0;i<=10;i++)
{
	try
	{
	waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 6, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
	break;
	}
	catch(Exception e)
	{
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton(), 6, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();	
	}
	}
	}
	 @And("^User Select the Budget code to do supplementary of Yearly budget code$")
	    public void user_select_the_budget_code_to_do_supplementary_of_yearly_budget_code() throws Throwable {
		// budget code
			
				bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode()
					.sendKeys(budgetSupplementaryTestData.get("BudgetCodeCreated"));
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ENTER);
	    }

	    @And("^User Select the Budget Year to do supplementary of Yearly budget code$")
	    public void user_select_the_budget_year_to_do_supplementary_of_yearly_budget_code() throws Throwable {
	    	// budget year
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear()
					.sendKeys(budgetSupplementaryTestData.get("BudgetYear"));
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ENTER);
	    }

	    @And("^User Select the Budget Branch to do supplementary of Yearly budget code$")
	    public void user_select_the_budget_branch_to_do_supplementary_of_yearly_budget_code() throws Throwable {
	    	// budget branch
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch()
					.sendKeys(budgetSupplementaryTestData.get("Branch"));
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);
	    }

	    @And("^User Select the Currency Type to do supplementary of Yearly budget code$")
	    public void user_select_the_currency_type_to_do_supplementary_of_yearly_budget_code() throws Throwable {
	    	// currency
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency()
					.sendKeys(budgetSupplementaryTestData.get("Currency"));
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.DOWN, Keys.ENTER);
			
	    }

	    @And("^User Enter Supplementary Appropriation Amount$")
	    public void user_enter_supplementary_appropriation_amount() throws Throwable {
	    	// Supplementary apportion amount
			bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount()
					.sendKeys(budgetSupplementaryTestData.get("Suplementary Appropriation"));
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);
	    }

	    @And("^User Enter New Amount for supplementary$")
	    public void user_enter_new_amount_for_supplementary() throws Throwable {
	    	// New amount
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();
	    }

	    @And("^User Store New Amount for Verification$")
	    public void user_store_new_amount_for_verification() throws Throwable {
	    	waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_StoreNewAmount(), 60, 500);
			String NewAmount = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_StoreNewAmount().getAttribute("ng-reflect-selected-value");
			System.out.println(NewAmount);
			excelDataForBudgetSupplementary.updateTestData(budgetSupplementaryTestData.get("DataSet ID"),"NewAmount",
					NewAmount);
	    }
	    @And("^User Modify Supplementary Appropriation Amount$")
	    public void user_modify_supplementary_appropriation_amount() throws Throwable {
	    	// Modify Supplementary apportion amount
	    				bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
	    				waithelper.waitForElementToVisibleWithFluentWait(driver,
	    						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount(), 60, 500);
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().click();
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().clear();
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount()
	    						.sendKeys(bUDGET_SupplementaryBudgetTestDataType.SupplymentaryApportionAmtA);
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(Keys.ENTER);
	    }

	    @And("^User Modify New Amount for supplementary$")
	    public void user_modify_new_amount_for_supplementary() throws Throwable {
	    	// New amount
	    				waithelper.waitForElementToVisibleWithFluentWait(driver,
	    						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount(), 60, 500);
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();
	    }

	    @And("^User Click save button for Modified Supplementary Records$")
	    public void user_click_save_button_for_modified_supplementary_records() throws Throwable {
	    	// save button
	    				waithelper.waitForElementToVisibleWithFluentWait(driver,
	    						bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave(), 60, 500);
	    				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();

	    				for (int i = 0; i <= 30; i++) {
	    					javascripthelper.JavaScriptHelper(driver);
	    					try {
	    						String str = javascripthelper.executeScript(
	    								"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
	    								.toString();
	    						System.out.println("Message:" + str);
	    						break;
	    					} catch (JavascriptException e) {
	    						if (i == 30) {
	    							e.printStackTrace();
	    						}
	    					}
	    				}
	    }


	    @And("^User Click save button for Supplementary Records$")
	    public void user_click_save_button_for_supplementary_records() throws Throwable {
	    	// save button
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();

			for (int i = 0; i <= 30; i++) {
				javascripthelper.JavaScriptHelper(driver);
				try {
					String str = javascripthelper.executeScript(
							"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
							.toString();
					System.out.println("Message:" + str);
					break;
				} catch (JavascriptException e) {
					if (i == 30) {
						e.printStackTrace();
					}
				}
			}
	    }
	    @And("^User Click Maker Notification$")
	    public void user_click_maker_notification() throws Throwable {
	    	// Notification
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();
	    }
	    @And("^search the budget Supplementary record name$")
	    public void search_the_budget_supplementary_record_name() throws Throwable {
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.eventCode(), 30, 500);
			budgetCreationObj.eventCode().click();
			budgetCreationObj.eventCode().sendKeys(budgetSupplementaryTestData.get("BudgetTransferEventCode"));
	    }

	    @And("^User store reference id for budget supplementary record$")
	    public void user_store_reference_id_for_budget_supplementary_record() throws Throwable {
	    	// Reference
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId(), 60, 500);
			String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
			excelDataForBudgetSupplementary.updateTestData(budgetSupplementaryTestData.get("DataSet ID"),"Reference ID",
					id);
			//jsonWriter.addReferanceData(id);
			System.out.println("Reference ID:" + id);
	    }

	    @And("^User Click action for budget supplementary record$")
	    public void user_click_action_for_budget_supplementary_record() throws Throwable {
			//bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().click();

			// Action-Pencil
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(before_xpath + budgetSupplementaryTestData.get("Reference ID") + after_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			

	    }

	    @And("^User Click the Submit button for budget supplementary record$")
	    public void user_click_the_submit_button_for_budget_supplementary_record() throws Throwable {
	    	// Submit button
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
	    }

	    @And("^User Enter remark for budget supplementary record$")
	    public void user_enter_remark_for_budget_supplementary_record() throws Throwable {
	    	// Remark
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField(), 60, 500);
			javahelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
			//bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys(budgetSupplementaryTestData.get("Remarks"));

			// Remark Submit

			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker(), 60, 500);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();

	    }
	    

	    @And("^User Store reviewver id to submit budget supplementary record in reviewver$")
	    public void user_store_reviewver_id_to_submit_budget_supplementary_record_in_reviewver() throws Throwable {
	    	// REVIEWER
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus(), 60, 500);
			WebElement recordstatus = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus();

			clicksAndActionHelper.moveToElement(recordstatus);
			String message = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().getText();
			System.out.println(message);
			bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RecordStatus().click();
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
			jsonWriter = new JsonDataReaderWriter();
			excelDataForBudgetSupplementary.updateTestData(budgetSupplementaryTestData.get("DataSet ID"),"Reviewer ID", reviewerId);
			//jsonWriter.addData(reviewerId);
	    }
	    
	// -----------SupplementaryBudget_KUBS_BP_UAT_005_004-------------------------------//

	@Then("^user login to checker1 UAT$")
	public void user_login_to_checker1_UAT() throws IOException, ParseException {
		reader = new JsonDataReaderWriter();
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", reader.readdata());
	}

	@And("^click on notification icon UAT$")
	public void click_on_notification_icon_UAT() {
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();
		ExtentTestManager.getTest().info("User clicks on notification icon");
	}

	@And("^click on action button button of the record which we want to approve UAT$")
	public void click_on_action_button_button_of_the_record_which_we_want_to_approve_UAT()
			throws InterruptedException, IOException, ParseException {
		browserHelper = new BrowserHelper(driver);
		javascript = new JavascriptHelper();

		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	@Then("^user approve the record UAT$")
	public void user_approve_the_record_UAT() {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		ExtentTestManager.getTest().info("User Click Approve button");
	}

	@And("^user write the remark & submit the record UAT$")
	public void user_write_the_remark_submit_the_record_UAT() throws InterruptedException {
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		ExtentTestManager.getTest().info("User write remark");

		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		ExtentTestManager.getTest().info("User click on submit button");

	}

	@Then("^User should login to checker2 UAT$")
	public void user_should_login_to_checker2_UAT() throws InterruptedException {
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");
	}

	@Then("^click on open pool UAT$")
	public void click_on_open_pool_UAT() {
		waithelper = new WaitHelper(driver);
		kubschecker = new Azentio_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

	}

	@And("^Verify for claming the record UAT$")
	public void verify_for_claming_the_record_UAT() throws IOException, Throwable {
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();

		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		for (int i = 0; i <= 30; i++) {
			try {
				waithelper.waitForElement(driver, 5000,
						driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
				break;
			} catch (NoSuchElementException e) {

			}
		}
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^User should click on notification icon on reviewer2 home page UAT$")
	public void user_should_click_on_notification_icon_on_reviewer2_home_page_UAT() throws InterruptedException {
		javascript = new JavascriptHelper();

		waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());

		kubschecker.checkerNotificationIcon().click();
	}

	@Then("^Claim and approve the record UAT$")
	public void claim_and_approve_the_record_UAT() throws InterruptedException, IOException, ParseException {

		for (int i = 1; i <= 35; i++) {
			try {
//				waithelper.waitForElement(driver, 3000,
//						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();

				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		waithelper.waitForElement(driver, 4000, kubschecker.checkerRejectButton());

		Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerReturnButton());
		Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

		// Approve
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		kubschecker.checkerApproveButton().click();

		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("OK");

		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();

	}

	// -----------SupplementaryBudget_KUBS_BP_UAT_005_005-------------------------------//

	@Then("^Claim and reject the record UAT$")
	public void claim_and_reject_the_record_UAT() throws InterruptedException, IOException, ParseException {

//		for (int i = 1; i <= 35; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000,
//						driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
//				WebElement referanceID = driver
//						.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
//				referanceID.click();
//				
//
//				Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
//				
//				kubschecker.checker_notification_next_button().click();
//			}
//    }

//		javascripthelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//				String before_xpath = "//span[contains(text(),'";
//				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
//				// waitHelper.waitForElement(driver, 1000, driver
//				// .findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() +
//				// after_xpath)));
//				// driver.findElement(By.xpath(before_xpath +
//				// jsonReaderWriter.readReferancedata() + after_xpath)).click();
//				javascripthelper.JSEClick(driver
//						.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)));
//				break;
//			} catch (Exception exception) {
//				System.out.println(exception.getMessage());
//
//			}
//		}
		// Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

		// Reject

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerRejectButton(), 60, 500);
		kubschecker.checkerRejectButton().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerRemarks(), 60, 500);
		kubschecker.checkerRemarks().click();
		kubschecker.checkerRemarks().sendKeys("OK");

		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkersubmitButton(), 60, 500);
		kubschecker.checkersubmitButton().click();

	}

	// -----------------SupplementaryBudget_KUBS_BP_UAT_005_003-------------------//
	@Then("^Select the Supplementary record from notification$")
	public void select_the_supplementary_record_from_notification()
			throws InterruptedException, IOException, ParseException {

		// Notification
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryNotification().click();

		// Reference
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId());
		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.maker_notification_next_button());

				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}

		}
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryFirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 1000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	}

	// ---------------SupplementaryBudget_KUBS_BP_UAT_005_007------------------------//
	@Then("^Click on Report field$")
	public void click_on_report_field() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.report_Field());
		bUDGET_SupplementaryBudgetObj.report_Field().click();
	}

	@Then("^click on supplementary budget Report$")
	public void click_on_supplementary_budget_report() throws InterruptedException {

		javascripthelper.JavaScriptHelper(driver);
		
		javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report());
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report(), 5, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Report().click();
	}

	@Then("^Select the date$")
	public void select_the_date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/uuuu");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MMMM/uuuu");
		LocalDate localDate = LocalDate.now();
		//System.out.println(dtf.format(localDate));
		String Date = dtf.format(localDate);
		String Date1 = dtf1.format(localDate);
		String[] DateSplit = Date.split("[/]");
		String[] DateSplit1 = Date1.split("[/]");
		Integer DateNum = Integer.valueOf(DateSplit[0]);
		String Month = DateSplit[1];
		String FullMonth = DateSplit1[1];
		Integer yearNum = Integer.valueOf(DateSplit[2]);
		//System.out.println("Date :"+DateNum +"Month :"+Month +"  "+ FullMonth+"Year :"+yearNum);
		
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		
		// select Transaction from date
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate(), 60, 500);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CalendarFromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + Month
										+ " " + yearNum + "')]")),
						60, 500);
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + Month + " "
								+ yearNum + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NextMonth().click();
			}
		}
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + FullMonth + " "
						+ DateNum + ", "
						+ yearNum + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button of report$")
	public void click_on_view_button_of_report() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ViewReport().click();

	}

	@Then("^verify the Supplementary Budget report$")
	public void verify_the_supplementary_budget_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
//	    	
//	    	javascripthelper.JavaScriptHelper(driver);
//	        javascripthelper.scrollIntoView(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
//	        waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear());
//	        bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ReportYear().click();

		browserHelper.switchToParentWithChildClose();
	}

}
