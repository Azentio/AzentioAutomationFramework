package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

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
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.AccountingSetup_ChartOfAccountsDefinitionObj;
import pageobjects.ArApObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.GL1Obj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.GL_REPORTS_Obj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.AccountingSetup_ChartOfAccountsDefinitionTestDataType;
import testDataType.ArApTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.GL1TestDataType;
import testDataType.GL1_Accounting_Setup_Data;
import testDataType.GL_ModuleTestData;
import testDataType.InventoryManagementTestDataType;

public class GL1_Accounting_Book_Definition extends BaseClass {

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
	String Book;
	Map<String, String> Getdata = new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();	
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	GL1_Accounting_Setup_Data acc_Setup_Data = jsonConfig.getAccsetupByName("Setup");
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\GLTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"GLTestData","Data Set ID");
	private Map<String, String> testdata;
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	GL_REPORTS_Obj glObj = new GL_REPORTS_Obj(driver);
	GL_ModuleTestData glModuleTestdata = jsonConfig.getGlmoduleTestDataByName("Maker");
	JavascriptHelper javascriptHelper= new JavascriptHelper();
	Map<String,String> mapData= new HashMap<>();
	// G1
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;
	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	KUBS_MakerObj makerobj = new KUBS_MakerObj(driver);
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	JavascriptHelper javascript = new JavascriptHelper();
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	ArApTestDataType arApTestDataType =  jsonReader.getArApByName("Maker");
	ArApObj arAPobj = new ArApObj(driver);
	GL1TestDataType gL1TestDataType =  jsonReader.getGL1ByName("Maker");
	GL1Obj gL1obj = new GL1Obj(driver);
	// Accounting Book Definition
	
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionObj ChartOfAccountsDefinitionObj = new AccountingSetup_ChartOfAccountsDefinitionObj(
			driver);
//	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
//	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountingSetup_ChartOfAccountsDefinitionTestDataType ChartOfAccountsDefinitionTestDataType = jsonReader
			.getChartOfAccountsDefinitiondata("Maker");

	// ******************************@KUBS_GL_UAT_001_001*************************//

	@Given("^Navigate to Azentio Kubs$")
	public void navigate_to_azentio_kubs() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
		
	}

	@And("^Click on Accounting Setup module$")
	public void click_on_accounting_setup_module() throws Throwable {
		// ----------ACCOUNTING SETUP---------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.accounting_setup(), 60, 500);
		accSetupObj.accounting_setup().click();
		
	}

	@Then("^Click sub module Accounting book definition$")
	public void click_sub_module_accounting_book_definition() throws Throwable {
		// ----------ACCOUNTING SUB MODULE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Eye(), 60, 500);
		accSetupObj.Accounting_book_definition_Eye().click();
	}

	@And("^Click on Add icon$")
	public void click_on_add_icon() throws Throwable {
		// ---------ADD ICON---------//
		for (int i = 0; i <30; i++) {
			try {
				accSetupObj.Accounting_book_definition_Add().click();
				break;
			} catch (Exception e) {
			
			}
		}
		
	}
	@And("^User Update the data set id for Base Template$")
    public void user_update_the_data_set_id_for_base_template() throws Throwable {
        testdata = excelData.getTestdata("KUBS_GL_UAT_001_001_1_D1");
    }
	@And("^User Update the data set id for verify Base Template book created$")
    public void user_update_the_data_set_id_for_verify_base_template_book_created() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_001_001_4_D1");
    }
	@And("^User Update the data set id for Base Template Accounting Book Reviewer submit$")
    public void user_update_the_data_set_id_for_base_template_accounting_book_reviewer_submit() throws Throwable {
		 testdata = excelData.getTestdata("KUBS_GL_UAT_001_001_2_D1");
    }
	@And("^User Update the data set id for Custom Template Accounting Book Reviewer submit$")
    public void user_update_the_data_set_id_for_custom_template_accounting_book_reviewer_submit() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_001_2_D1");
    }
	@And("^User Update the data set id for Modified Accounting Book Reviewer submit$")
    public void user_update_the_data_set_id_for_modified_accounting_book_reviewer_submit() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_004_2_D1");
    }
	@And("^User update the test data set id for Delete the accounting book reviewer$")
    public void user_update_the_test_data_set_id_for_delete_the_accounting_book_reviewer() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_006_2_D1");
    }
	@And("^User update the test data set id for verify accounting book is deactivated$")
    public void user_update_the_test_data_set_id_for_verify_accounting_book_is_deactivated() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_006_4_D1");
    }
	@And("^User update the test data set id for Delete the accounting book$")
    public void user_update_the_test_data_set_id_for_delete_the_accounting_book() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_006_1_D1");
    }
	@And("^User update the test data set id for Deactivate the accounting book$")
    public void user_update_the_test_data_set_id_for_deactivate_the_accounting_book() throws Throwable {
		testdata = excelData.getTestdata("KUBS_GL_UAT_002_008_1_D1");
    }

    @And("^User update test data set id for Deactive accounting book record in reviewer or Checker$")
    public void user_update_test_data_set_id_for_deactive_accounting_book_record_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_002_008_2_D1");
    }
    @And("^User Update the test data set id for approve category record Assets in Reviewer or Checker$")
    public void user_update_the_test_data_set_id_for_approve_category_record_assets_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_001_2_D1");
    }
    @And("^User update test data set id for verify the deactivated accounting book$")
    public void user_update_test_data_set_id_for_verify_the_deactivated_accounting_book() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_002_008_4_D1");
    }
    @And("^User Update the test data set id to Verify the created category in Maker$")
    public void user_update_the_test_data_set_id_to_verify_the_created_category_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_001_4_D1");
    }
    @And("^User Update the test data set id for category record Assets$")
    public void user_update_the_test_data_set_id_for_category_record_assets() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_001_1_D1");
    }
    @And("^User update the test data set id for category record Liability$")
    public void user_update_the_test_data_set_id_for_category_record_liability() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_002_1_D1");
    }
    @And("^User update the test data set id for category record Income$")
    public void user_update_the_test_data_set_id_for_category_record_income() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_003_1_D1");
    }
    @And("^User update the test data set id for category record Expenditure$")
    public void user_update_the_test_data_set_id_for_category_record_expenditure() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_004_1_D1");
    }
    @When("^User Update the Test data Set id for COA Parent GL$")
    public void user_update_the_test_data_set_id_for_coa_parent_gl() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_001_1_D1");
    }
    @And("^User Update the test data set id for Creation of Leaf GL$")
    public void user_update_the_test_data_set_id_for_creation_of_leaf_gl() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_002_1_D1");
    }
    @And("^User Update the test data set id for Node GL records$")
    public void user_update_the_test_data_set_id_for_node_gl_records() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_003_1_D1");
    }
    @And("^User Update the test data set id for Created COA Selected branch$")
    public void user_update_the_test_data_set_id_for_created_coa_selected_branch() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_004_1_D1");
    }
    @And("^User update the test data set id to Modify the Chart of Account record$")
    public void user_update_the_test_data_set_id_to_modify_the_chart_of_account_record() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_005_1_D1");
    }

    @And("^User update the test data set id for Change Chart of Account Active to De active$")
    public void user_update_the_test_data_set_id_for_change_chart_of_account_active_to_de_active() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_008_1_D1");
    }

    @And("^User Test data set for category already created and trying to create same accounting book$")
    public void user_test_data_set_for_category_already_created_and_trying_to_create_same_accounting_book() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_005_D1");
    }
    @And("^User update the test data set for Category record Liability In Reviewer or Checker$")
    public void user_update_the_test_data_set_for_category_record_liability_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_002_2_D1");
    }
    @And("^User update the test data set for Category record Income In Reviewer or Checker$")
    public void user_update_the_test_data_set_for_category_record_income_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_003_2_D1");
    }
    @And("^User update the test data set for Category record Expenditure In Reviewer or Checker$")
    public void user_update_the_test_data_set_for_category_record_expenditure_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_004_2_D1");
    }
    @When("^User Update the Test data set id for COA Parent GL in Reviewer or Checker$")
    public void user_update_the_test_data_set_id_for_coa_parent_gl_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_001_2_D1");
    }
    @And("^User Update the test data set for approve the COA record for Leaf GL in Reviewer or Checker$")
    public void user_update_the_test_data_set_for_approve_the_coa_record_for_leaf_gl_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_002_2_D1");
    }
    @And("^User Update the test data set id for Approve Node GL Records in reviewer or Checker$")
    public void user_update_the_test_data_set_id_for_approve_node_gl_records_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_003_2_D1");
    }
    @And("^User Update the test data set id for approve created coa selected branch in Reviewer or Checker$")
    public void user_update_the_test_data_set_id_for_approve_created_coa_selected_branch_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_004_2_D1");
    }
    @And("^User Update the test data id to Approve the Modified Chart of Account COA in reviewer or Checker$")
    public void user_update_the_test_data_id_to_approve_the_modified_chart_of_account_coa_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_005_2_D1");
    }
    @And("^User update test data set id to Approve the deactivated COA record in Reviewer or Checker$")
    public void user_update_test_data_set_id_to_approve_the_deactivated_coa_record_in_reviewer_or_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_008_2_D1");
    }
    
    @And("^User Update the test data set id to Verify the created category Liability in Maker$")
    public void user_update_the_test_data_set_id_to_verify_the_created_category_liability_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_002_4_D1");
    }
    @And("^User Update the test data set id to Verify the created category Income in Maker$")
    public void user_update_the_test_data_set_id_to_verify_the_created_category_income_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_003_4_D1");
    }
    @And("^User Update the test data set id to Verify the created category Expenditure in Maker$")
    public void user_update_the_test_data_set_id_to_verify_the_created_category_expenditure_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_003_004_4_D1");
    }
    @When("^User Update the test data set id for verify created COA Parent GL$")
    public void user_update_the_test_data_set_id_for_verify_created_coa_parent_gl() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_001_4_D1");
    }
    @And("^User Update the test data set id for Verify the approved the COA record of Leaf GL in Maker$")
    public void user_update_the_test_data_set_id_for_verify_the_approved_the_coa_record_of_leaf_gl_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_002_4_D1");
    }
    @And("^User Update the test data set id to Verify the approved Node GL records in Maker$")
    public void user_update_the_test_data_set_id_to_verify_the_approved_node_gl_records_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_003_4_D1");
    }
    @And("^User update the test data set id for verify created coa$")
    public void user_update_the_test_data_set_id_for_verify_created_coa() throws Throwable {
    	 
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_004_4_D1");
    	
    }
    @And("^User update the test data set id for verify Modified coa$")
    public void user_update_the_test_data_set_id_for_verify_modified_coa() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_005_4_D1");
    }
    @And("^User Update test data set id to Verify the deactivated COA record in Checker$")
    public void user_update_test_data_set_id_to_verify_the_deactivated_coa_record_in_checker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_005_008_4_D1");
    }

	@Then("^Choose the Template Type of Base Template$")
	public void choose_the_template_type_of_base_template() throws Throwable {
		// --------TEMPLATE TYPE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Templatetype(), 60, 500);
		accSetupObj.Accounting_book_definition_Templatetype().click();
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(testdata.get("Template Type"));
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(Keys.ENTER);
	}

	@And("^Enter Book Name$")
	public void enter_book_name() throws Throwable {
		// ------BOOK NAME-------//
		Random random = new Random();
	    int RanNo1 = random.nextInt(700-10)+10;
	    int RanNo2 = random.nextInt(90-1)+10;
	    String bookName =testdata.get("Book Name")+RanNo2+RanNo1;
	    excelData.updateTestData("KUBS_GL_UAT_001_001_4_D1", "Book NameCreated", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_002_006_1_D1", "Book NameCreated", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_002_006_4_D1", "Book NameCreated", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_003_001_1_D1", "Accounting BookName", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_003_002_1_D1", "Accounting BookName", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_003_003_1_D1", "Accounting BookName", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_003_004_1_D1", "Accounting BookName", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_003_005_D1", "Accounting BookName", bookName);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(bookName);
	}
	@And("^Enter Book Name for custom template record$")
    public void enter_book_name_for_custom_template_record() throws Throwable {
		Random random = new Random();
	    int RanNo1 = random.nextInt(700-10)+10;
	    int RanNo2 = random.nextInt(90-1)+10;
	    String bookName =testdata.get("Book Name")+RanNo2+RanNo1;
	    excelData.updateTestData("KUBS_GL_UAT_002_001_4_D1", "Book NameCreated", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_002_002_D1", "Book NameCreated", bookName);
	    excelData.updateTestData("KUBS_GL_UAT_002_008_1_D1", "Book NameCreated", bookName);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(bookName);
    }

	@Then("^Select system date as Effective date$")
	public void select_system_date_as_effective_date() throws Throwable {
		// ------EFFECTIVE DATE------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_Date(), 60, 500);
		accSetupObj.Accounting_book_definition_Date().click();
		
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")), 60, 500);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//span[text()='" + testdata.get("Year") + "']")), 60, 500);
		driver.findElement(By.xpath("//span[text()='" + testdata.get("Year") + "']")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//span[text()='" + testdata.get("Month") + "']")), 60, 500);
		driver.findElement(By.xpath("//span[text()='" + testdata.get("Month") + "']")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("(//span[text()='" + testdata.get("Date") + "'])[1]")), 60, 500);
		clickAndActionHelper.doubleClick(driver.findElement(By.xpath("(//span[text()='" + testdata.get("Date") + "'])[1]")));
		//driver.findElement(By.xpath("(//span[text()='" + testdata.get("Date") + "'])[1]")).click();
	}

	@And("^Choose the Book Type what you Need$")
	public void choose_the_book_type_what_you_need() throws Throwable {
		//------Book type-----------//
		//waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_BookType(), 30, 2);
		for (int i = 0; i <30; i++) {
			try {
				accSetupObj.Accounting_book_definition_BookType().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
		accSetupObj.Accounting_book_definition_BookType().sendKeys(testdata.get("Book Type"));
		accSetupObj.Accounting_book_definition_BookType().sendKeys(Keys.ENTER);
	}
	@Then("^Enter the Remark for custom template$")
    public void enter_the_remark_for_custom_template() throws Throwable {
		//--------REMARK------------//
				waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Remarks(), 60, 500);
				accSetupObj.Accounting_book_definition_Remarks().click();
				accSetupObj.Accounting_book_definition_Remarks().sendKeys(testdata.get("Remarks"));
    }
	@Then("^Enter the Remark for already created record$")
    public void enter_the_remark_for_already_created_record() throws Throwable {
		//--------REMARK------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Remarks(), 60, 500);
		accSetupObj.Accounting_book_definition_Remarks().click();
		accSetupObj.Accounting_book_definition_Remarks().sendKeys(testdata.get("Remarks"));
    }

    @And("^Choose the Book Type what you Need for custom template$")
    public void choose_the_book_type_what_you_need_for_custom_template() throws Throwable {
    	//------Book type-----------//
		//waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_BookType(), 30, 2);
		for (int i = 0; i <30; i++) {
			try {
				accSetupObj.Accounting_book_definition_BookType().click();
				break;
			} catch (Exception e) {
				
			}
		}
		
		accSetupObj.Accounting_book_definition_BookType().sendKeys(testdata.get("Book Type"));
		accSetupObj.Accounting_book_definition_BookType().sendKeys(Keys.ENTER);
    }

	@Then("^Enter the Remark$")
	public void enter_the_remark() throws Throwable {
		//--------REMARK------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Remarks(), 60, 500);
		accSetupObj.Accounting_book_definition_Remarks().click();
		accSetupObj.Accounting_book_definition_Remarks().sendKeys(testdata.get("Remarks"));
	}

	@And("^Save the Record$")
	public void save_the_record() throws Throwable {
		//---------SAVE THE RECORD------//
		//waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Save(), 60, 500);
		for (int i = 0; i <200; i++) {
			try {
				accSetupObj.Accounting_book_definition_Save().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
		
	}
	@Given("^Navigate as a Reviewer for GL$")
    public void navigate_as_a_reviewer_for_gl() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
				kubsLogin = new KUBS_Login(driver);
				driver.get(configFileReader.getApplicationUrl());
				kubsLogin.logintoAzentioappReviewer(testdata.get("Reviewer ID"));
				//Thread.sleep(1000);
    }
	
	@And("^Store the Referance Id and Open the Record for Base Template Accounting Book$")
    public void store_the_referance_id_and_open_the_record_for_base_template_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accountingbook_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.Accountingbook_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_001_001_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccBook_ActionButton(), 30, 2);
		accSetupObj.GLAccBook_ActionButton().click();
    }
	@Then("^Click submit button and Enter Remark submit it for custom template$")
    public void click_submit_button_and_enter_remark_submit_it_for_custom_template() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		
		for (int i = 0; i <200; i++) {
			try {
				
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_002_001_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }

    @And("^Store the Referance Id and Open the Record for custom template$")
    public void store_the_referance_id_and_open_the_record_for_custom_template() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accountingbook_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.Accountingbook_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_002_001_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccBook_ActionButton(), 30, 2);
		accSetupObj.GLAccBook_ActionButton().click();
    }
	 @Then("^Click submit button and Enter Remark submit it for Gl Record$")
	    public void click_submit_button_and_enter_remark_submit_it_for_gl_record() throws Throwable {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
			arapObj.ARAP_Submit().click();
			waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
			arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
			//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
			
			for (int i = 0; i <200; i++) {
				try {
					
					arapObj.ARAP_RemarkSubmit().click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			waitHelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30, 2);
			reviwerId = arapObj.ARAP_ReviewerId().getText();
			String trimmdReviewerID = reviwerId.substring(85);
			StringBuffer sb = new StringBuffer(trimmdReviewerID);
			StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
			String finalReviewerID = bufferedString.toString();
			excelData.updateTestData("KUBS_GL_UAT_001_001_2_D1","Reviewer ID", finalReviewerID);
			System.out.println(reviwerId);
	    }
	 @And("^Click First record Action icon for accounting book$")
	    public void click_first_record_action_icon_for_accounting_book() throws Throwable {
		 
			String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testdata.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			
	    }
	 @And("^Click First record Action icon for GL$")
	    public void click_first_record_action_icon_for_gl() throws Throwable {
		 String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testdata.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
	 @And("^Click First record Action icon for custom template accounting book$")
	    public void click_first_record_action_icon_for_custom_template_accounting_book() throws Throwable {
			String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testdata.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			
	    }
	 @And("^Click First record Action icon for modified Accounting book$")
	    public void click_first_record_action_icon_for_modified_accounting_book() throws Throwable {
	    	// -----------REVIEWER ACTION-------------//
	    			javaScriptHelper.JavaScriptHelper(driver);
	    			String befr_xpath = "//span[contains(text(),'";
	    			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
	    			for (int i = 0; i <200; i++) {
	    				try {
	    					driver.findElement(By.xpath(befr_xpath +testdata.get("Reference ID")+ aftr_xpath)).click();
	    					break;
	    				} catch (Exception e) {
	    					if (i==199) {
	    						Assert.fail(e.getMessage());
	    					}
	    				}
	    			}
	    }
	 @And("^Click First record Action icon for deactivated Accounting book$")
	    public void click_first_record_action_icon_for_deactivated_accounting_book() throws Throwable {
		// -----------REVIEWER ACTION-------------//
			javaScriptHelper.JavaScriptHelper(driver);
			String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testdata.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
	 @And("^Claim the Record in Checker for GL$")
	    public void claim_the_record_in_checker_for_GLk() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
			String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			for (int i = 0; i <200; i++) {
				try {
					
					driver.findElement(By.xpath(before_xpath +testdata.get("Reference ID")+ after_xpath_claim)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.checker_alert_close(),30, 2);
			clickAndActionHelper.moveToElement(checkerObj.checker_alert_close());
			clickAndActionHelper.clickOnElement(checkerObj.checker_alert_close());
			
	    }
	 @And("^Click the  Action Icon for accounting book record$")
	    public void click_the_action_icon_for_accounting_book_record() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		 for (int i = 0; i < 200; i++) {
				try {
					clickAndActionHelper.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
				    clickAndActionHelper.clickOnElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
					break;

				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
	 @And("^Click First record Action icon for category records$")
	    public void click_first_record_action_icon_for_category_records() throws Throwable {
		 for (int i = 0; i < 200; i++) {
				try {
					clickAndActionHelper.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
				    clickAndActionHelper.clickOnElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
					break;

				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}

	    }
	 @And("^Click on First Action button for COA records$")
	    public void click_on_first_action_button_for_coa_records() throws Throwable {
		 for (int i = 0; i < 200; i++) {
				try {
					clickAndActionHelper.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
				    clickAndActionHelper.clickOnElement(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Reference ID")+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
					break;

				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
    @And("^System should Generate unique code$")
    public void system_should_generate_unique_code() throws Throwable {
       //---------validate the unique code------------//
    	for (int i = 0; i <200; i++) {
		try {	
		
    	javaScriptHelper.JavaScriptHelper(driver);
    	String uniquecode = (String) javaScriptHelper.executeScript("return document.getElementsByName('matCode')[1].value");
    	System.out.println("System Generated unique code: " +uniquecode);
    	break;
    }
		catch(JavascriptException e) {
			if (i==199) {
				e.getMessage();
			}
		}
    	}
    }
    @And("^User verify the created accounting book in maker view$")
    public void user_verify_the_created_accounting_book_in_maker_view() throws Throwable {
        String xpath ="//span[contains(text(),'"+testdata.get("Book NameCreated")+"')]";
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail("Approved Accounting book record is not displayed in Maker List View");
				}
			}
		}
    }
    //*****************************@KUBS_GL_UAT_002_004_4************************//
    @And("^User verify the Modified accounting book in maker view$")
    public void user_verify_the_modified_accounting_book_in_maker_view() throws Throwable {
    	String xpath ="//span[contains(text(),'"+testdata.get("Modified Book Name")+"')]";
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail("Approved Accounting book record is not displayed in Maker List View");
				}
			}
		}
    }

   
	// ******************************@KUBS_GL_UAT_002_001*************************//	

    @And("^Enter Another Book Name$")
    public void enter_another_book_name() throws Throwable {
		// ------BOOK NAME-------//
//    	Random random = new Random();
//    	int r = random.nextInt(100-50)+50;
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(testdata.get("Book NameCreated"));
    }
    @And("^User Update the data set id for Custom Template$")
    public void user_update_the_data_set_id_for_custom_template() throws Throwable {
        testdata = excelData.getTestdata("KUBS_GL_UAT_002_001_1_D1");
    }
    @And("^User Update the data set id for Custom Template verified in maker$")
    public void user_update_the_data_set_id_for_custom_template_verified_in_maker() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_002_001_4_D1");
    }
    @And("^User Update the data set id for Modified accounting book$")
    public void user_update_the_data_set_id_for_modified_accounting_book() throws Throwable {
    	testdata = excelData.getTestdata("KUBS_GL_UAT_002_004_4_D1");
    }
    
    @Then("^Choose the Template Type of Custom Template$")
    public void choose_the_template_type_of_custom_template() throws Throwable {
		// --------TEMPLATE TYPE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_Templatetype(), 60, 500);
		accSetupObj.Accounting_book_definition_Templatetype().click();
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(testdata.get("Template Type"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("Template Type")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(Keys.ENTER);
    }
    @And("^User update the test data set id for accounting book already created$")
    public void user_update_the_test_data_set_id_for_accounting_book_already_created() throws Throwable {
         testdata = excelData.getTestdata("KUBS_GL_UAT_002_002_D1");
    }
    
	// ******************************@KUBS_GL_UAT_002_002*************************//
	
    @Then("^Validate the Message we get$")
    public void validate_the_message_we_get() throws Throwable {
        //--------VALIDATE THE MESSAGE-----------//    	
    	javaScriptHelper.JavaScriptHelper(driver);
    	WebElement getMsg = (WebElement) javaScriptHelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
    	System.out.println("System Not Allow to create same Book Name : " +getMsg.getText());
    	Assert.assertEquals("BookName already exists!!!",getMsg.getText());
    }
	
    
	// ******************************@KUBS_GL_UAT_002_004*************************//
	
	@Then("^Click on Table Row First Edit Icons$")
	public void click_on_table_row_first_edit_icon() throws Throwable {
		// -----------TABLE ROW FIRST EDIT ICON--------------------//
		//waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_TableEdit(), 60, 500);
		for (int i = 0; i <200; i++) {
			try {
				accSetupObj.Accounting_book_definition_TableEdit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
	}
	@And("^User update the test data set id for modify accounting book$")
    public void user_update_the_test_data_set_id_for_modify_accounting_book() throws Throwable {
        testdata = excelData.getTestdata("KUBS_GL_UAT_002_004_1_D1");
    }
    @And("^Enter Modify Book Name$")
    public void enter_modify_book_name() throws Throwable {
		// ------BOOK NAME-------//
    	Random r = new Random();
    	int add1 = r.nextInt(9000-5)+50;
    	int add2 = r.nextInt(100-1)+1;
    	int add3 = r.nextInt(10-1)+1;
    	String ModifybookName =testdata.get("Modify Book Name")+add2+add1+add3;
    	System.out.println(ModifybookName);
    	excelData.updateTestData("KUBS_GL_UAT_002_004_4_D1","Modified Book Name",ModifybookName);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 30, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().clear();
		Thread.sleep(1000);
		accSetupObj.Accounting_book_definition_BookName().sendKeys(ModifybookName);
		
    }
    @And("^Store the Referance Id and Open the Record for Modify accounting book$")
    public void store_the_referance_id_and_open_the_record_for_modify_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accountingbook_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.Accountingbook_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_002_004_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccBook_ActionButton(), 30, 2);
		accSetupObj.GLAccBook_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for delete accounting book$")
    public void store_the_referance_id_and_open_the_record_for_delete_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accountingbook_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.Accountingbook_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_002_006_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccBook_ActionButton(), 30, 2);
		accSetupObj.GLAccBook_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Deactivate the accounting book$")
    public void store_the_referance_id_and_open_the_record_for_deactivate_the_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accountingbook_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.Accountingbook_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_002_008_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccBook_ActionButton(), 30, 2);
		accSetupObj.GLAccBook_ActionButton().click();
    }

    @And("^Store the Referance Id and Open the Record for category record Assets$")
    public void store_the_referance_id_and_open_the_record_for_category_record_assets() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.AccountingCategory_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.AccountingCategory_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_003_001_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccCategory_ActionButton(), 30, 2);
		accSetupObj.GLAccCategory_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Category record Liability$")
    public void store_the_referance_id_and_open_the_record_for_category_record_liability() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.AccountingCategory_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.AccountingCategory_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_003_002_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccCategory_ActionButton(), 30, 2);
		accSetupObj.GLAccCategory_ActionButton().click();
    
    }
    @And("^Store the Referance Id and Open the Record for Category record Income$")
    public void store_the_referance_id_and_open_the_record_for_category_record_income() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.AccountingCategory_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.AccountingCategory_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_003_003_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccCategory_ActionButton(), 30, 2);
		accSetupObj.GLAccCategory_ActionButton().click();
    }
    
    @And("^Store the Referance Id and Open the Record for Category record Expenditure$")
    public void store_the_referance_id_and_open_the_record_for_category_record_expenditure() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.AccountingCategory_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.AccountingCategory_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_003_004_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLAccCategory_ActionButton(), 30, 2);
		accSetupObj.GLAccCategory_ActionButton().click();
    }
   
    @And("^Store the Referance Id and Open the Record for Parent GL$")
    public void store_the_referance_id_and_open_the_record_for_parent_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_001_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(), 30, 2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Leaf GL$")
    public void store_the_referance_id_and_open_the_record_for_leaf_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_002_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(), 30, 2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Node GL$")
    public void store_the_referance_id_and_open_the_record_for_node_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(),30,2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_003_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(),30,2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Selected branch coa creation$")
    public void store_the_referance_id_and_open_the_record_for_selected_branch_coa_creation() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(),30,2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_004_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(),30,2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for Modified COA record$")
    public void store_the_referance_id_and_open_the_record_for_modified_coa_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(),30, 2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_005_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(),30, 2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    @And("^Store the Referance Id and Open the Record for deactivated COA record$")
    public void store_the_referance_id_and_open_the_record_for_deactivated_coa_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.glCoa_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.glCoa_ReferanceId().getText();
		excelData.updateTestData("KUBS_GL_UAT_005_008_2_D1","Reference ID", Referance_id);
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GLCoa_ActionButton(), 30, 2);
		accSetupObj.GLCoa_ActionButton().click();
    }
    
    @Then("^Click submit button and Enter Remark submit it for Parent GL$")
    public void click_submit_button_and_enter_remark_submit_it_for_parent_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30,2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_001_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Leaf GL$")
    public void click_submit_button_and_enter_remark_submit_it_for_leaf_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_002_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Node GL$")
    public void click_submit_button_and_enter_remark_submit_it_for_node_gl() throws Throwable {
    	//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
    	for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_Submit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_003_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Created COA Selected branch$")
    public void click_submit_button_and_enter_remark_submit_it_for_created_coa_selected_branch() throws Throwable {
 
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_Submit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_004_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Modified COA record$")
    public void click_submit_button_and_enter_remark_submit_it_for_modified_coa_record() throws Throwable {
    	for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_Submit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_005_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for deactivated COA record$")
    public void click_submit_button_and_enter_remark_submit_it_for_deactivated_coa_record() throws Throwable {
    	for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_Submit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_008_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Save the Record and submit the created record of COA$")
    public void save_the_record_and_submit_the_created_record_of_coa() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_005_004_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }

    

    @Then("^Click submit button and Enter Remark submit it for modified accounting book$")
    public void click_submit_button_and_enter_remark_submit_it_for_modified_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElement(driver, 3000, arapObj.ARAP_ReviewerId());waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_002_004_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for delete accounting book$")
    public void click_submit_button_and_enter_remark_submit_it_for_delete_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_002_006_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Deactivate the accounting book$")
    public void click_submit_button_and_enter_remark_submit_it_for_deactivate_the_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_002_008_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for category record Assets$")
    public void click_submit_button_and_enter_remark_submit_it_for_category_record_assets() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_003_001_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Category Record Liability$")
    public void click_submit_button_and_enter_remark_submit_it_for_category_record_liability() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_003_002_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Category Record Income$")
    public void click_submit_button_and_enter_remark_submit_it_for_category_record_income() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_003_003_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @Then("^Click submit button and Enter Remark submit it for Category Record Expenditure$")
    public void click_submit_button_and_enter_remark_submit_it_for_category_record_expenditure() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		for (int i = 0; i <200; i++) {
			try {
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(),30, 2);
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData("KUBS_GL_UAT_003_004_2_D1","Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
    @And("^Give the Remark and Submit it for Modified accounting book$")
    public void give_the_remark_and_submit_it_for_modified_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkersubmitButton(),30, 2);
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for delete accounting book$")
    public void give_remark_and_submit_for_delete_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkersubmitButton(),30, 2);
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for deactivate the accounting book$")
    public void give_remark_and_submit_for_deactivate_the_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkersubmitButton(),30, 2);
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for accounting base template reviewer$")
    public void give_remark_and_submit_for_accounting_base_template_reviewer() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		for (int i = 0; i <200; i++) {
			try {
				checkerObj.checkersubmitButton().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for GL$")
    public void give_remark_and_submit_for_gl() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		for (int i = 0; i <200; i++) {
			try {
				checkerObj.checkersubmitButton().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for category records$")
    public void give_remark_and_submit_for_category_records() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.checkersubmitButton(),30, 2);
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    @And("^Give Remark and Submit for COA records$")
    public void give_remark_and_submit_for_coa_records() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
		checkerObj.checkerRemarks().sendKeys(testdata.get("Remarks"));
		//waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		for (int i = 0; i <200; i++) {
			try {
				checkerObj.checkersubmitButton().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		waitHelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
    }
    
    
	// ******************************@KUBS_GL_UAT_003_003*************************//	
	
    @Then("^click sub module Accounting Category$")
    public void click_sub_module_accounting_category() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.accountingCategoryEyeicon(), 60, 500);
    	accSetupObj.accountingCategoryEyeicon().click();
    }
   
    @And("^enter the category code as Income$")
    public void enter_the_category_code_as_income() throws Throwable {
    	Random ran = new Random();
    	int rand1= ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(30-1)+10;
    	int rand3 = ran.nextInt(20-1)+10;
        String category =testdata.get("Category Code")+rand1+rand2+rand3;
        excelData.updateTestData("KUBS_GL_UAT_003_003_4_D1","Accounting Category Created", category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode(), 20, 500);
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(category);
    }
    @And("^enter the accounting category as Expenditure$")
    public void enter_the_accounting_category_as_expenditure() throws Throwable {
    	Random ran = new Random();
    	int rand1 = ran.nextInt(500-10)+10;
    	int rand2 = ran.nextInt(20-1)+10;
    	int rand3 = ran.nextInt(20-1)+10;
    	String category = testdata.get("AccoutingCategory")+rand1+rand2;
    	excelData.updateTestData("KUBS_GL_UAT_003_004_4_D1","Accounting Category Created", category);
        excelData.updateTestData("KUBS_GL_UAT_005_001_1_D1","Accounting Category Created", category);
        excelData.updateTestData("KUBS_GL_UAT_005_002_1_D1","Accounting Category Created", category);
        excelData.updateTestData("KUBS_GL_UAT_005_003_1_D1","Accounting Category Created", category);
        excelData.updateTestData("KUBS_GL_UAT_005_004_1_D1","Accounting Category Created", category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	String Cat = glObj.enterAccountingCategory().getText();
    	System.out.println("Accountingg Category"+Cat);
    	mapData.put("Category", Cat);
    }
    
    
    @And("^enter the accounting category$")
    public void enter_the_accounting_category() throws Throwable {
    	Random rand = new Random();
    	int randm = rand.nextInt(100-50)+50;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterAccountingCategory(), 60, 500);
        accSetupObj.enterAccountingCategory().click();
        accSetupObj.enterAccountingCategory().sendKeys(acc_Setup_Data.CategoryCode+randm);
    }
    
    @And("^select Gl code generation$")
    public void select_gl_code_generation() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.selectGlCodeGeneration(), 60, 500);    	
        accSetupObj.selectGlCodeGeneration().sendKeys(acc_Setup_Data.GlGeneration);
        accSetupObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }
	
	
    
	// ******************************@KUBS_GL_UAT_003_004*************************//	

    @When("^Give the type as Base Template$")
    public void give_the_type_as_base_template() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_Templatesearch(), 60, 500);
    	accSetupObj.Accounting_book_definition_Templatesearch().click();
    	accSetupObj.Accounting_book_definition_Templatesearch().sendKeys(acc_Setup_Data.Template);
    }
    
    @And("^Get the Account Book Name$")
    public void get_the_account_book_name() throws Throwable {
    	Book = accSetupObj.Accounting_book_definition_GetAccBook().getText();
    	System.out.println(Book);
    }
    
    @And("^enter the category code as Expenditure$")
    public void enter_the_category_code_as_expenditure() throws Throwable {
    	Random ran = new Random();
    	int rand1= ran.nextInt(50-1)+10;
    	int rand2 = ran.nextInt(3-1)+10;
    	int rand3 = ran.nextInt(5-1)+10;
        String category =testdata.get("Category Code")+rand1+rand2+rand3;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode(), 20, 500);
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(category);
    }
	
    @And("^select the accounting book for Expenditure$")
    public void select_the_accounting_book_for_expenditure() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.selectAccountingBook(), 60, 500);
        accSetupObj.selectAccountingBook().click();
        accSetupObj.selectAccountingBook().sendKeys(Book);
        accSetupObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }

   
    
    @When("^user click the Accounting setups$")
    public void user_click_the_accounting_setups() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,kubsMakerObj.kubsAccountingSetup(), 20, 500);
		kubsMakerObj.kubsAccountingSetup().click();
    }

    @And("^click accounting category eye icon$")
    public void click_accounting_category_eye_icon() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.accountingCategoryEyeicon(), 20, 500);
    	glObj.accountingCategoryEyeicon().click();    	
    }

    @And("^click add icon in Gl$")
    public void click_add_icon_in_gl() throws Throwable {
    	for (int i = 0; i <200; i++) {
			try {
				glObj.addIcon().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	
    }

    @And("^enter the category code$")
    public void enter_the_category_code() throws Throwable {
    	Random ran = new Random();
    	int rand1 = ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(500-1)+10;
    	int rand3 = ran.nextInt(50-1)+11;
    	String categoryCode =testdata.get("Category Code")+rand1+rand2+rand3;
    	excelData.updateTestData("KUBS_GL_UAT_003_001_4_D1","Accounting Category Created", categoryCode);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode(), 20, 500);
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(categoryCode);
    }

    @And("^select the accounting book$")
    public void select_the_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectAccountingBook(), 20, 500);
    	glObj.selectAccountingBook().click();
    	glObj.selectAccountingBook().sendKeys(testdata.get("Accounting BookName"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("Accounting BookName")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	glObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }

    @And("^enter the accounting categorys$")
    public void enter_the_accounting_categorys() throws Throwable {
    	Random ran = new Random();
    	int rand1 = ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(500-1)+10;
    	int rand3 = ran.nextInt(50-1)+11; 
    	String categoryCode =testdata.get("Category Code")+rand1+rand2+rand3;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(categoryCode);
    }

    @And("^select Gl code generations$")
    public void select_gl_code_generations() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectGlCodeGeneration(), 20, 500);
    	glObj.selectGlCodeGeneration().click();
    	glObj.selectGlCodeGeneration().sendKeys(testdata.get("GLCode Configuration"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("GLCode Configuration")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	glObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }
    @And("^select Gl code generation for Liability category record$")
    public void select_gl_code_generation_for_liability_category_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectGlCodeGeneration(), 20, 500);
    	glObj.selectGlCodeGeneration().click();
    	glObj.selectGlCodeGeneration().sendKeys(testdata.get("GLCode Configuration"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("GLCode Configuration")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	glObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }
    @And("^select Gl code generation for Income Category record$")
    public void select_gl_code_generation_for_income_category_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectGlCodeGeneration(), 20, 500);
    	glObj.selectGlCodeGeneration().click();
    	glObj.selectGlCodeGeneration().sendKeys(testdata.get("GLCode Configuration"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("GLCode Configuration")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	glObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }
    @And("^select Gl code generation for Expenditure Category record$")
    public void select_gl_code_generation_for_expenditure_category_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectGlCodeGeneration(), 20, 500);
    	glObj.selectGlCodeGeneration().click();
    	glObj.selectGlCodeGeneration().sendKeys(testdata.get("GLCode Configuration"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//span[text()='"+testdata.get("GLCode Configuration")+"']")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    	glObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }

    @And("^click on save the accounting record$")
    public void click_on_save_the_accounting_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.saveButton(), 20, 500);
    	glObj.saveButton().click();
    	for (int i = 0; i < 50; i++) {			
    		try {
    			//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Notification_Close(), 60, 2);
    			arapObj.ARAP_Notification_Close().click();
    			break;
    		} 

    		catch (Exception e) {
    			if (i==50) {
    				Assert.fail(e.getMessage());
    			}
    		}
    		}
    }
    @Then("^verify the accounting category created$")
    public void verify_the_accounting_category_created() throws Throwable {
     for (int i = 0; i <200; i++) {
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" +testdata.get("Accounting Category Created").toUpperCase()+ "')]")).isDisplayed());
			break;
		} catch (NoSuchElementException e) {
			if (i==199) {
				Assert.fail(e.getMessage());
			}
		}
	}
    }
    
    @And("^enter the category code as Liability$")
    public void enter_the_category_code_as_liability() throws Throwable {
    	Random ran = new Random();
    	int rand1= ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(30-1)+10;
    	int rand3 = ran.nextInt(20-1)+10;
        String category =testdata.get("Category Code")+rand1+rand2+rand3;
        excelData.updateTestData("KUBS_GL_UAT_003_002_4_D1","Accounting Category Created", category);
        excelData.updateTestData("KUBS_GL_UAT_003_005_D1","Accounting Category Created", category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode(), 20, 500);
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(category);
    }

    @And("^enter the accounting category as Liability$")
    public void enter_the_accounting_category_as_liability() throws Throwable {
    	Random ran = new Random();
    	int rand1 = ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(20-1)+10;
        String category =testdata.get("Category Code")+rand1+rand2;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	String Cat = glObj.enterAccountingCategory().getText();
    	System.out.println("Accountingg Category"+Cat);
    	mapData.put("Category", Cat);
    	
    }
    @And("^enter the accounting category as Income$")
    public void enter_the_accounting_category_as_income() throws Throwable {
    	Random ran = new Random();
    	int rand1 = ran.nextInt(5000-10)+10;
    	int rand2 = ran.nextInt(20-1)+10;
        String category =testdata.get("Category Code")+rand1+rand2;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(category);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterAccountingCategory(), 20, 500);
    	String Cat = glObj.enterAccountingCategory().getText();
    	System.out.println("Accountingg Category"+Cat);
    	mapData.put("Category", Cat);
    }
    @When("^capture the code and category$")
    public void capture_the_code_and_category() throws Throwable {
    	String Cat = glObj.enterAccountingCategory1().getText();
    	System.out.println("Accounting Category" +Cat);
    	mapData.put("Category", Cat);
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode1(), 20, 500);
    	String code = glObj.enterCategoryCode1().getText();
    	//System.out.println("Accounting Category code" +code);
    	mapData.put("Code", code);
    }
    @Then("^verify the accounting category created for liability$")
    public void verify_the_accounting_category_created_for_liability() throws Throwable {
    	for (int i = 0; i <200; i++) {
    		try {
    			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" +testdata.get("Accounting Category Created").toUpperCase()+ "')]")).isDisplayed());
    			break;
    		} catch (NoSuchElementException e) {
    			if (i==199) {
    				Assert.fail(e.getMessage());
    			}
    		}
    	}
    }
   
    @Then("^verify the accounting category created for Income$")
    public void verify_the_accounting_category_created_for_income() throws Throwable {
    	for (int i = 0; i <200; i++) {
    		try {
    			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" +testdata.get("Accounting Category Created").toUpperCase()+ "')]")).isDisplayed());
    			break;
    		} catch (NoSuchElementException e) {
    			if (i==199) {
    				Assert.fail(e.getMessage());
    			}
    		}
    	}
    }
    @Then("^verify the accounting category created for Expenditure$")
    public void verify_the_accounting_category_created_for_expenditure() throws Throwable {
    	for (int i = 0; i <200; i++) {
    		try {
    			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'" +testdata.get("Accounting Category Created").toUpperCase()+ "')]")).isDisplayed());
    			break;
    		} catch (NoSuchElementException e) {
    			if (i==199) {
    				Assert.fail(e.getMessage());
    			}
    		}
    	}
    }
    @And("^Enter the old accounting category as Liability$")
    public void enter_the_old_accounting_category_as_liability() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.enterCategoryCode(), 20, 500);
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(testdata.get("Accounting Category Created"));
    }
    
    @And("^Enter the old accounting book$")
    public void enter_the_old_accounting_book() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectAccountingBook(), 20, 500);
    	glObj.selectAccountingBook().click();
    	glObj.selectAccountingBook().sendKeys(testdata.get("Accounting BookName"));
    	glObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }
    
    @Then("^verify the system should through the validation message for the existing code$")
    public void verify_the_system_should_through_the_validation_message_for_the_existing_code() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.existingRecordToastMessage(), 20, 500);
    	glObj.existingRecordToastMessage().getText();
    	Assert.assertEquals(glObj.existingRecordToastMessage().getText(), "Category Code already exists!!!");
    }
    /** **/
    @And("^click the accounting book eye icon$")
    public void click_the_accounting_book_eye_icon() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.accountingBookDefinitionEyeIcon(), 20, 500);
    	glObj.accountingBookDefinitionEyeIcon().click();
    }
    
    @And("^click the first edit eye icon in list view$")
    public void click_the_first_edit_eye_icon_in_list_view() throws Throwable {
    javascriptHelper.JavaScriptHelper(driver);
    javascriptHelper.scrollIntoViewAndClick(glObj.clickFirstEditIconInListView());
    	
    }
    @And("^search the created Accounting book$")
    public void search_the_created_accounting_book() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
      	//waitHelper.waitForElementwithFluentwait(driver,glObj.searchStatus(), 20, 500);
        	javascriptHelper.scrollIntoView(glObj.searchAccountingBookName());    	
        	glObj.searchAccountingBookName().click();  	
        	glObj.searchAccountingBookName().sendKeys(testdata.get("Book NameCreated"));
        	
        	while(true)
        	{
        		try
        		{
        			javascriptHelper.JSEClick(glObj.AccountingSetUpActiveBookRecord());
        		//	glObj.AccountingSetUpActiveBookRecord().click();
        			break;
        		}
        		catch(NoSuchElementException e)
        		{
        			glObj.nextPageInListView().click();
        		}
        		}
    }
    @And("^search the created Accounting book for De Active accounting book$")
    public void search_the_created_accounting_book_for_de_active_accounting_book() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
      	//waitHelper.waitForElementwithFluentwait(driver,glObj.searchStatus(), 20, 500);
        	javascriptHelper.scrollIntoView(glObj.searchAccountingBookName());    	
        	glObj.searchAccountingBookName().click();  	
        	glObj.searchAccountingBookName().sendKeys(testdata.get("Book NameCreated"));
        	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.clickFirstEditIconInListView(),30, 2);
        	glObj.clickFirstEditIconInListView().click();
        	
    }
    @And("^User Search the deactivated Book name$")
    public void user_search_the_deactivated_book_name() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
      	//waitHelper.waitForElementwithFluentwait(driver,glObj.searchStatus(), 20, 500);
        	javascriptHelper.scrollIntoView(glObj.searchAccountingBookName());    	
        	glObj.searchAccountingBookName().click();  	
        	glObj.searchAccountingBookName().sendKeys(testdata.get("Book NameCreated"));
        	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.clickFirstEditIconInListView(),30, 2);
        	glObj.clickFirstEditIconInListView().click();
        	
        		
        		
    }
    @And("^Click the status and select deactivate$")
    public void click_the_status_and_select_deactivate() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.selectStatus(), 20, 500);
    	glObj.selectStatus().click();
    	glObj.selectStatus().sendKeys(testdata.get("Status InActive"));
    	glObj.selectStatus().sendKeys(Keys.ENTER);
    }
    @Then("^save the Accounting book record$")
    public void save_the_accounting_book_record() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.saveButton(), 20, 500);
    	glObj.saveButton().click();
    	for (int i = 0; i < 50; i++) {			
    		try {
    			//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Notification_Close(), 60, 2);
    			clickAndActionHelper.clickOnElement(arapObj.ARAP_Notification_Close());
    			arapObj.ARAP_Notification_Close().click();
    			break;
    		} 

    		catch (Exception e) {
    			if (i==50) {
    				Assert.fail(e.getMessage());
    			}
    		}
    		}
    }
    @Then("^verify the bill is inactive or not$")
    public void verify_the_bill_is_inactive_or_not() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	glObj.accountingBookDefenitionSearchBookName().click();
    	glObj.accountingBookDefenitionSearchBookName().sendKeys(testdata.get("Book NameCreated"));
    	javascriptHelper.scrollIntoView(glObj.getAccountingBookNameStatus());
    	System.out.println(glObj.getAccountingBookNameStatus().getText());   	
    	Assert.assertEquals(glObj.getAccountingBookNameStatus().getText(),"In-Active");
    	
    }
    @And("^User Close the Workflow iniatiated Pop up in GL$")
    public void user_close_the_workflow_iniatiated_pop_up_in_gl() throws Throwable {
    	//waitHelper.waitForElementToVisibleWithFluentWait(driver,glObj.GL_SuccessMessageClose(),30, 2);
    	for (int i = 0; i <200; i++) {
    		try {
        		clickAndActionHelper.moveToElement(glObj.GL_SuccessMessageClose());
                glObj.GL_SuccessMessageClose().click();
                break;
    		} catch (Exception e) {
    			if (i==199) {
					
				}
    		}
		}
    	
    	
            	
    }
    // g1 stepdefinition
  //----------------KUBS_GL_UAT_005_003---------------
	
  	 @Then("^click on accounting setup$")
  	    public void click_on_accounting_setup() throws Throwable {
  			waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.accountingSetup_Button(), 60, 500);
  			gL1obj.accountingSetup_Button().click();
  			
  	    }

  	    @Then("^Click on Chart of account definition$")
  	    public void click_on_chart_of_account_definition() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.chartOfAccountsDefination_Button(), 60, 500);
  			gL1obj.chartOfAccountsDefination_Button().click();
  			
  	    }

  	    @Then("^Click on COA add button$")
  	    public void click_on_coa_add_button() throws Throwable {
  	    	//waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.chartOfAccountsDefination_AddButton(), 60, 500);
  	    	for (int i = 0; i <200; i++) {
				try {
					gL1obj.chartOfAccountsDefination_AddButton().click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
  			 
  	    }

  	    @And("^User Select Accounting Category$")
  	    public void user_select_accounting_category() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.accountingCategory_textBox(), 60, 500);
  			gL1obj.accountingCategory_textBox().click(); 
  			gL1obj.accountingCategory_textBox().sendKeys(testdata.get("Accounting Category Created"));
  			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Accounting Category Created")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail(e.getMessage());
					}
				}
			}
  			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
  	    }

  	    @And("^User enter the coa name$")
  	    public void user_enter_the_coa_name() throws Throwable {
  	    	Random random = new Random();
  	    	int random1 = random.nextInt(500-1)+10;
  	    	int random2 = random.nextInt(50-1)+1;
  	    	int random3 = random.nextInt(15-1)+1;
  	    	String coaName= testdata.get("COA Name")+random1+random2+random3;
  	    	excelData.updateTestData("KUBS_GL_UAT_005_001_4_D1","COA Name Created", coaName);
  	    	excelData.updateTestData("KUBS_GL_UAT_005_002_1_D1","COA Name Created", coaName);
  	    	excelData.updateTestData("KUBS_GL_UAT_005_002_1_D1","Parent GL", coaName);
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.cOAname_textBox(), 60, 500);
  			gL1obj.cOAname_textBox().click(); 
  			gL1obj.cOAname_textBox().sendKeys(testdata.get("COA Name")+random1+random2+random3);
  			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
  			
  	    }

  	    @And("^User select the parent GL$")
  	    public void user_select_the_parent_gl() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.parentGL_textBox(), 60, 500);
  			gL1obj.parentGL_textBox().click(); 
  			gL1obj.parentGL_textBox().sendKeys(Keys.DOWN);
  			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
  	    }

  	    @And("^User select the GL type$")
  	    public void user_select_the_gl_type() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.gLType_textBox(), 60, 500);
  			gL1obj.gLType_textBox().click(); 
  			gL1obj.gLType_textBox().sendKeys(testdata.get("GL Type"));
  			System.out.println(testdata.get("GL Type"));
  			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("GL Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail(e.getMessage());
					}
				}
			}
  			gL1obj.gLType_textBox().sendKeys(Keys.DOWN);
  			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
  	    }

  	    @And("^User enter description in COA definition$")
  	    public void user_enter_description_in_coa_definition() throws Throwable {
  	    	Random random = new Random();
  	    	int random1 = random.nextInt(700-1)+10;
  	    	int random2 = random.nextInt(70-1)+1;
  	    	int random3 = random.nextInt(35-1)+1;
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.decriptionOfGL_textBox(), 60, 500);
  			gL1obj.decriptionOfGL_textBox().click(); 
  			gL1obj.decriptionOfGL_textBox().sendKeys(testdata.get("Description")+random1+random2+random3);
  			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
  	    }

  	    @And("^User Select the balance type$")
  	    public void user_select_the_balance_type() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.balanceType_Textbox(), 60, 500);
  			gL1obj.balanceType_Textbox().click(); 
  			gL1obj.balanceType_Textbox().sendKeys(testdata.get("Balance Type"));
  			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
  	    }
  	  @And("^User Select Accounting Category for Leaf GL$")
      public void user_select_accounting_category_for_leaf_gl() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.accountingCategory_textBox(), 60, 500);
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(testdata.get("Accounting Category Created"));
			for (int i = 0; i <30; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Accounting Category Created")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==29) {
					Assert.fail(e.getMessage());
				}
			}
		}
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User enter the coa name for Leaf GL$")
      public void user_enter_the_coa_name_for_leaf_gl() throws Throwable {
    	    Random random = new Random();
	    	int random1 = random.nextInt(500-1)+10;
	    	int random2 = random.nextInt(50-1)+1;
	    	int random3 = random.nextInt(15-1)+1;
	    	String coaName= testdata.get("COA Name")+random1+random2+random3;
	    	excelData.updateTestData("KUBS_GL_UAT_005_002_4_D1","COA Name Created", coaName);
	    	excelData.updateTestData("KUBS_GL_UAT_005_003_1_D1","Parent GL", coaName);
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.cOAname_textBox(), 60, 500);
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(testdata.get("COA Name")+random1+random2+random3);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User select the parent GL for Leaf GL$")
      public void user_select_the_parent_gl_for_leaf_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.parentGL_textBox(), 60, 500);
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(testdata.get("Parent GL"));
			String parentGL = "//ng-dropdown-panel//span[contains(text(),'"+testdata.get("Parent GL")+"')]";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(parentGL)).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
		
			gL1obj.parentGL_textBox().sendKeys(Keys.DOWN);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
			
      }

      @And("^User select the GL type as Sub GL$")
      public void user_select_the_gl_type_as_sub_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.gLType_textBox(), 60, 500);
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(testdata.get("GL Type"));
			System.out.println(testdata.get("GL Type"));
			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("GL Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL1obj.gLType_textBox().sendKeys(Keys.DOWN);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User Select the balance type for Leaf GL$")
      public void user_select_the_balance_type_for_leaf_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.balanceType_Textbox(), 60, 500);
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(testdata.get("Balance Type"));
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
      }

      @And("^User enter description in COA definition for Leaf GL$")
      public void user_enter_description_in_coa_definition_for_leaf_gl() throws Throwable {
    	    Random random = new Random();
	    	int random1 = random.nextInt(700-1)+10;
	    	int random2 = random.nextInt(70-1)+1;
	    	int random3 = random.nextInt(35-1)+1;
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.decriptionOfGL_textBox(), 60, 500);
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(testdata.get("Description")+random1+random2+random3);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);

      }
      @And("^User Select Accounting Category for Node GL$")
      public void user_select_accounting_category_for_node_gl() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.accountingCategory_textBox(), 60, 500);
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(testdata.get("Accounting Category Created"));
			for (int i = 0; i <30; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Accounting Category Created")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==29) {
					Assert.fail(e.getMessage());
				}
			}
		}
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User Select Accounting Category for Selected branch coa creation$")
      public void user_select_accounting_category_for_selected_branch_coa_creation() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.accountingCategory_textBox(), 60, 500);
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(testdata.get("Accounting Category Created"));
			for (int i = 0; i <30; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Accounting Category Created")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==29) {
					Assert.fail(e.getMessage());
				}
			}
		}
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User enter the coa name for Node GL$")
      public void user_enter_the_coa_name_for_node_gl() throws Throwable {
    	    Random random = new Random();
	    	int random1 = random.nextInt(500-1)+10;
	    	int random2 = random.nextInt(50-1)+1;
	    	int random3 = random.nextInt(15-1)+1;
	    	String coaName= testdata.get("COA Name")+random1+random2+random3;
	    	excelData.updateTestData("KUBS_GL_UAT_005_003_4_D1","COA Name Created", coaName);
	    	excelData.updateTestData("KUBS_GL_UAT_005_004_1_D1","Parent GL", coaName);
	    	excelData.updateTestData("KUBS_GL_UAT_005_008_1_D1","COA Name Created", coaName);
	    	excelData.updateTestData("KUBS_GL_UAT_005_008_4_D1","COA Name Created", coaName);
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.cOAname_textBox(), 60, 500);
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(testdata.get("COA Name")+random1+random2+random3);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User enter the coa name for Selected branch coa creation$")
      public void user_enter_the_coa_name_for_selected_branch_coa_creation() throws Throwable {
    	  Random random = new Random();
	    	int random1 = random.nextInt(500-1)+10;
	    	int random2 = random.nextInt(50-1)+1;
	    	int random3 = random.nextInt(15-1)+1;
	    	String coaName= testdata.get("COA Name")+random1+random2+random3;
	    	excelData.updateTestData("KUBS_GL_UAT_005_004_4_D1","COA Name Created", coaName);
	    	excelData.updateTestData("KUBS_GL_UAT_005_005_1_D1","Search COA", coaName);
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.cOAname_textBox(), 60, 500);
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(testdata.get("COA Name")+random1+random2+random3);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User select the parent GL for Node GL$")
      public void user_select_the_parent_gl_for_node_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.parentGL_textBox(), 60, 500);
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(testdata.get("Parent GL"));
			String parentGL = "//ng-dropdown-panel//span[contains(text(),'"+testdata.get("Parent GL")+"')]";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(parentGL)).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL1obj.parentGL_textBox().sendKeys(Keys.DOWN);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User select the parent GL for selected branch coa creation$")
      public void user_select_the_parent_gl_for_selected_branch_coa_creation() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.parentGL_textBox(), 60, 500);
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(testdata.get("Parent GL"));
			String parentGL = "//ng-dropdown-panel//span[contains(text(),'"+testdata.get("Parent GL")+"')]";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(parentGL)).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL1obj.parentGL_textBox().sendKeys(Keys.DOWN);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
      }

      @And("^User select the GL type as Sub GL for Leaf GL$")
      public void user_select_the_gl_type_as_sub_gl_for_leaf_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.gLType_textBox(), 60, 500);
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(testdata.get("GL Type"));
			System.out.println(testdata.get("GL Type"));
			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("GL Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL1obj.gLType_textBox().sendKeys(Keys.DOWN);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User select the GL type as Main GL for Selected branch coa creation$")
      public void user_select_the_gl_type_as_main_gl_for_selected_branch_coa_creation() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.gLType_textBox(), 60, 500);
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(testdata.get("GL Type"));
			System.out.println(testdata.get("GL Type"));
			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("GL Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL1obj.gLType_textBox().sendKeys(Keys.DOWN);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User Select the balance type for Node GL$")
      public void user_select_the_balance_type_for_node_gl() throws Throwable {
    	    waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.balanceType_Textbox(), 60, 500);
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(testdata.get("Balance Type"));
			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Balance Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					
				}
			}
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
      }
      @And("^User Select the balance type for Selected branch coa creation$")
      public void user_select_the_balance_type_for_selected_branch_coa_creation() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.balanceType_Textbox(), 60, 500);
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(testdata.get("Balance Type"));
			for (int i = 0; i <30; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Balance Type")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					
				}
			}
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
      }

      @And("^User enter description in COA definition for Node GL$")
      public void user_enter_description_in_coa_definition_for_node_gl() throws Throwable {
    	    Random random = new Random();
	    	int random1 = random.nextInt(700-1)+10;
	    	int random2 = random.nextInt(70-1)+1;
	    	int random3 = random.nextInt(35-1)+1;
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.decriptionOfGL_textBox(), 60, 500);
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(testdata.get("Description")+random1+random2+random3);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User enter description in COA definition for Selected branch coa creation$")
      public void user_enter_description_in_coa_definition_for_selected_branch_coa_creation() throws Throwable {
    	    Random random = new Random();
	    	int random1 = random.nextInt(700-1)+10;
	    	int random2 = random.nextInt(70-1)+1;
	    	int random3 = random.nextInt(35-1)+1;
	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.decriptionOfGL_textBox(), 60, 500);
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(testdata.get("Description")+random1+random2+random3);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
      }
      @And("^User select the branch specific$")
      public void user_select_the_branch_specific() throws Throwable {
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.branchSpecific_Box(), 30,2);
    	  gL1obj.branchSpecific_Box().click();
    	  waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.branchSpecific_YesRadioBox(), 30,2);
    	  gL1obj.branchSpecific_YesRadioBox().click();
      }
  	    
 
  	    
  	    @Then("^Click on Save buttonT$")
  	    public void click_on_save_buttonT() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.saveButtonForGeneralLedger(), 60, 500);
  			gL1obj.saveButtonForGeneralLedger().click(); 
  	    }
  	    
  	    
  	 //------------ KUBS_GL_UAT_005_004----------------  
  	    
  	    
  	    @Then("^Click on add button of branch$")
  	    public void click_on_add_button_of_branch() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.branch_AddButton(), 60, 500);
  			gL1obj.branch_AddButton().click(); 
  	    }

  	    @Then("^Fill the form for which branch we need to save$")
  	    public void fill_the_form_for_which_branch_we_need_to_save() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.branch_TextBox(), 60, 500);
  			gL1obj.branch_TextBox().click(); 
  			gL1obj.branch_TextBox().sendKeys(gL1TestDataType.branch);
  			gL1obj.branch_TextBox().sendKeys(Keys.ENTER);
  			
  			
  			waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.department_TextBox(), 60, 500);
  			gL1obj.department_TextBox().click(); 
  			gL1obj.department_TextBox().sendKeys(gL1TestDataType.department);
  			gL1obj.department_TextBox().sendKeys(Keys.ENTER);
  			
  			
  			waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.costCentre_TextBox(), 60, 500);
  			gL1obj.costCentre_TextBox().click(); 
  			gL1obj.costCentre_TextBox().sendKeys(gL1TestDataType.costCentre);
  			gL1obj.costCentre_TextBox().sendKeys(Keys.ENTER);
  			
  	    }
  	    

  	    @Then("^Click on save button for saving branch$")
  	    public void click_on_save_button_for_saving_branch() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.branch_SaveButton(), 60, 500);
  			gL1obj.branch_SaveButton().click(); 
  	    }

  	    @Then("^Click on save of General Ledger$")
  	    public void click_on_save_of_general_ledger() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.gLbranch_SaveButton(), 60, 500);
  			gL1obj.gLbranch_SaveButton().click();
  	    } 
  	    
  	  //---------------KUBS_GL_UAT_005_009---------------  
  	    

  	    @Then("^Click on search button to search COA$")
  	    public void click_on_search_button_to_search_coa() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.search_Button(), 60, 500);
  			gL1obj.search_Button().click(); 
  			
  			waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.cOANameSearch_Textbox(), 60, 500);
  			gL1obj.cOANameSearch_Textbox().click(); 
  			gL1obj.cOANameSearch_Textbox().sendKeys(gL1TestDataType.COAnameToinactive);
  			gL1obj.cOANameSearch_Textbox().sendKeys(Keys.ENTER);
  			
  	    }

  	    @Then("^Click on Edit button to edit COA record$")
  	    public void click_on_edit_button_to_edit_coa_record() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.editAction_Button(), 60, 500);
  			gL1obj.editAction_Button().click();
  	    }

  	    @Then("^Click on status to make it inactive$")
  	    public void click_on_status_to_make_it_inactive() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.statusOfCOA_Textbox(), 60, 500);
  			gL1obj.statusOfCOA_Textbox().click(); 
  			gL1obj.statusOfCOA_Textbox().sendKeys(gL1TestDataType.statusofCOA);
  			gL1obj.statusOfCOA_Textbox().sendKeys(Keys.ENTER);
  			
  	    }

  	    @Then("^Click on save button to save record$")
  	    public void click_on_save_button_to_save_record() throws Throwable {
  	    	waithelper.waitForElementToVisibleWithFluentWait(driver, gL1obj.saveCOA_Button(), 60, 500);
  			gL1obj.saveCOA_Button().click();  
  	    }

  	    @Then("^Validation message should pop up$")
  	    public void validation_message_should_pop_up() throws Throwable {
//  	       System.out.println("Can not deactivate as COA is currently used");
  	    	String Msg = gL1obj.budget_creation_Getalert().getText();
  	    	System.out.println(Msg);
  	    	Assert.assertEquals(Msg, "There are already active transcation for the COA, cannot be modified");
  	    } 
  	    
// Accounting Setup ChartOfAccounts
  	  @Then("^search COA name to modify the coa$")
  	public void search_coa_name_to_modify_the_coa() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
  				.sendKeys(testdata.get("Search COA"));
  	}

  	@Then("^search COA name to modify the coa1$")
  	public void search_coa_name_to_modify_the_coa1() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
  				.sendKeys(testdata.get("COA Name Created"));
  	}

  	@Then("^search used COA code for which GL entries are passed$")
  	public void search_used_COA_code_for_which_GL_entries_are_passed() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.LeafCOA_CodeSearch);
  	}

  	@Then("^search used parent COA code for which GL entries are passed$")
  	public void search_used_parent_COA_code_for_which_GL_entries_are_passed() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.ParentCOA_CodeSearch);
  	}

  	@Then("^click on pencil button to modify the COA$")
  	public void click_on_pencil_button_to_modify_the_coa() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_FirstPencilButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_FirstPencilButton().click();
  	}

    @And("^Modify the COA Name$")
    public void modify_the_coa_name() throws Throwable {
    	Random ran = new Random();
  		int random1 = ran.nextInt(500 - 100) + 10;
  		int random2 = ran.nextInt(90 - 10) + 1;
  		String modifiedName = testdata.get("COA Name") + random1+random2;
  		excelData.updateTestData("KUBS_GL_UAT_005_005_4_D1","COA Name Created", modifiedName);
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().click();
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().clear();
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField()
  				.sendKeys(modifiedName);
    }

    @And("^Modify the GL Type$")
    public void modify_the_gl_type() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype()
  				.sendKeys(testdata.get("GL Type"));
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype().sendKeys(Keys.ENTER);
 
    }

    @And("^Modify the Balance Type$")
    public void modify_the_balance_type() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType()
  				.sendKeys(testdata.get("Balance Type"));
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(Keys.ENTER);
    }

    @And("^Modify the Description$")
    public void modify_the_description() throws Throwable {
    	Random ran = new Random();
  		int random1 = ran.nextInt(500 - 100) + 10;
  		int random2 = ran.nextInt(90 - 10) + 1;
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().click();
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().clear();
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description()
  				.sendKeys(testdata.get("Description")+ random2+random1);
    }


  	@Then("^Inactive the active Chart of account$")
  	public void inactive_the_active_chart_of_account() {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField()
  				.sendKeys(testdata.get("Status InActive"));
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.ENTER);
  	}
  	@And("^Save the Record for COA creation$")
    public void save_the_record_for_coa_creation() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();
    }

    @Then("^Save the Record and submit the created record of COA For Leaf GL$")
    public void save_the_record_and_submit_the_created_record_of_coa_for_leaf_gl() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();
  		waithelper.waitForElementToVisibleWithFluentWait(driver,glObj.GL_SuccessMessageClose(),30, 2);
  		glObj.GL_SuccessMessageClose().click();
  		for (int i = 0; i <50; i++) {
			try {
				clickAndActionHelper.moveToElement(glObj.GL_SuccessMessageClose());
		  		glObj.GL_SuccessMessageClose().click();
		  		break;
			} catch (Exception e) {
				
			}
		}
  		
  		for (int i = 0; i < 60; i++) {

  			try {
  				javascripthelper.JavaScriptHelper(driver);
  				String str = javascripthelper.executeScript(
  						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
  						.toString();
  				System.out.println("Message:" + str);
  				break;
  			} catch (JavascriptException e) {
  				
  			}
  		}
  		for (int i = 0; i <50; i++) {
			try {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
				break;
			} catch (Exception e) {
				if (i==49) {
					Assert.fail(e.getMessage());
				}
			}
		}
  		

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId(), 60, 500);
  		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
  		//jsonWriter.addReferanceData(id);
  		excelData.updateTestData("KUBS_GL_UAT_005_002_2_D1","Reference ID",id);
  		System.out.println("Reference ID:" + id);
  		String before_xpath = "//span[contains(text(),'";
  		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
  		testdata = excelData.getTestdata("KUBS_GL_UAT_005_002_2_D1");
  		for (int i = 0; i <50; i++) {
  			try {
  				driver.findElement(By.xpath(before_xpath+testdata.get("Reference ID")+after_xpath)).click();
  				break;
  			} catch (Exception e) {
  				if (i==49) {
  					Assert.fail(e.getMessage());
  				}
  			}
  		}
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton(), 60, 500);
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1(), 60, 500);
  		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1());
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField1()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.RemarkByMaker);

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//      	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//      	clicksAndActionHelper.moveToElement(recordstatus);

  		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
  		System.out.println(message);
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
  		String emptystring = "";
  		String ar[] = message.split(" ");
  		emptystring = ar[ar.length - 1];
  		String reviewerId = emptystring.replaceAll("[/.]", "");
  		System.out.println(reviewerId);
  		jsonWriter = new JsonDataReaderWriter();
  		jsonWriter.addData(reviewerId);
  		excelData.updateTestData("KUBS_GL_UAT_005_002_2_D1","Reviewer ID", reviewerId);

    }

  	@Then("^Save and submit the modified record of COA$")
  	public void save_and_submit_the_modified_record_of_coa() throws IOException, ParseException, InterruptedException {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

  		javascripthelper.JavaScriptHelper(driver);
  		String str = javascripthelper.executeScript(
  				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
  				.toString();
  		System.out.println("Message:" + str);

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton(), 60, 500);
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId(), 60, 500);
  		String id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
  		jsonWriter.addReferanceData(id);
  		System.out.println("Reference ID:" + id);
  		for (int i = 1; i <= 35; i++) {
  			try {
  				// waithelper.waitForElementwithFluentwait(driver,
  				// driver.findElement(By.xpath("//span[contains(text(),'"
  				// +jsonWriter.readReferancedata()+ "')]")));
  				WebElement referanceID = driver
  						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
  				waithelper.waitForElementToVisibleWithFluentWait(driver, referanceID, 60, 500);
  				referanceID.click();
  				System.out.println(referanceID);
//  				Assert.assertTrue(referanceID.isDisplayed());
  				break;
  			} catch (NoSuchElementException e) {
  				// waithelper.waitForElementwithFluentwait(driver,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
  			}
  		}
  		String before_xpath = "//span[contains(text(),'";
  		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)), 60, 500);
  		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton(), 60, 500);
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField(), 60, 500);
  		javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.RemarkByMaker);

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RemarkSubmit().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//      	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//      	clicksAndActionHelper.moveToElement(recordstatus);

  		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
  		System.out.println(message);
//      	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
  		String emptystring = "";
  		String ar[] = message.split(" ");
  		emptystring = ar[ar.length - 1];
  		String reviewerId = emptystring.replaceAll("[/.]", "");
  		System.out.println(reviewerId);
  		jsonWriter = new JsonDataReaderWriter();
  		jsonWriter.addData(reviewerId);
  	}

  	@Then("^checker should approved the COA record$")
  	public void checker_should_approved_the_coa_record() throws IOException, ParseException, InterruptedException {

////  		waithelper.waitForElementwithFluentwait(driver,  driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
////  		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
//
//  		waithelper.waitForElementToVisibleWithFluentWait(driver,
//  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton(), 60, 500);
//  		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//  		for (int i = 0; i < 30; i++) {
//  			try {
//  				driver.findElement(By.xpath("//span[contains(text(),'" + testdata.get("Reference ID")
//  						+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//  						.click();
//  				break;
//  			} catch (NoSuchElementException e) {
//
//  			}
//  		}
  		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerApproveButton(), 60, 500);
  		kubschecker.checkerApproveButton().click();
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark(), 60, 500);
  		aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.ApprovedByChecker);
  		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkersubmitButton(), 60, 500);
  		kubschecker.checkersubmitButton().click();
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus(), 60, 500);
//      	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
//      	clicksAndActionHelper.moveToElement(recordstatus);
  		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
  		System.out.println(message);
  		// aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
  	}
  	@Then("^User Verify Approved COA record for Parent GL in Maker$")
    public void user_verify_approved_coa_record_for_parent_gl_in_maker() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("COA Name Created")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
  	@Then("^User Verify Approved COA record for Leaf GL in Maker$")
    public void user_verify_approved_coa_record_for_leaf_gl_in_maker() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("COA Name Created")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
  	@Then("^User Verify Approved COA record for Node GL in Maker$")
    public void user_verify_approved_coa_record_for_node_gl_in_maker() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("COA Name Created")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
  	@Then("^User Verify Approved COA record in Maker for selected branch$")
    public void user_verify_approved_coa_record_in_maker_for_selected_branch() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("COA Name Created")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
  	@Then("^User Verify Approved and Modified COA record in Maker$")
    public void user_verify_approved_and_modified_coa_record_in_maker() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("COA Name Created")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
  	@And("^Verify the deactivated COA record shows In active in List view$")
    public void verify_the_deactivated_coa_record_shows_in_active_in_list_view() throws Throwable {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,gL1obj.generalLedgerView(),30, 2);
  		gL1obj.generalLedgerView().isDisplayed();
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Verify Status")+"')]")).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }

  	@Then("^modify the COA details for which GL entries are passed$")
  	public void modify_the_coa_details_for_which_GL_entries_are_passed() {
  		Random ran = new Random();
  		int rand = ran.nextInt(500 - 100) + 100;
//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(ChartOfAccountsDefinitionTestDataType.AccountingCategory);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_AccountingCategory().sendKeys(Keys.ENTER);

//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().click();
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().clear();
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameField().sendKeys(ChartOfAccountsDefinitionTestDataType.COA_Name);

//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode().sendKeys(ChartOfAccountsDefinitionTestDataType.ExternalMappingCode);
//      	
//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(ChartOfAccountsDefinitionTestDataType.ParentGL);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_ParentGL().sendKeys(Keys.ENTER);

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.GL_TypeModifiedForUsedCOA);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_GLtype().sendKeys(Keys.ENTER);
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description().clear();
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_Description()
  				.sendKeys(ChartOfAccountsDefinitionTestDataType.Description + rand);

//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(ChartOfAccountsDefinitionTestDataType.BalanceType);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_BalanceType().sendKeys(Keys.ENTER);
//      	
//      	waithelper.waitForElementwithFluentwait(driver,  ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField());
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(ChartOfAccountsDefinitionTestDataType.Status);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_StatusField().sendKeys(Keys.ENTER);

  	}

  	@Then("^Save and check the modified record of used leaf COA$")
  	public void save_and_check_the_modified_record_of_used_leaf_coa()
  			throws IOException, ParseException, InterruptedException {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus(), 60, 500);
//      	WebElement recordstatus = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus();
//      	clicksAndActionHelper.moveToElement(recordstatus);

  		String message = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus()
  				.getText();
  		System.out.println("Accounting Scheme - " + message);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus().click();
  	}

  	@Then("^Save and check the modified record of used parent COA$")
  	public void save_and_check_the_modified_record_of_used_parent_coa()
  			throws IOException, ParseException, InterruptedException {
  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton(), 60, 500);
  		ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_SaveButton().click();

  		waithelper.waitForElementToVisibleWithFluentWait(driver,
  				ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus(), 60, 500);
//      	WebElement recordstatus = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus();
//      	clicksAndActionHelper.moveToElement(recordstatus);

  		String message = ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus()
  				.getText();
  		System.out.println("Accounting Scheme - " + message);
//      	ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_RecordStatus().click();
  	}

	
}
