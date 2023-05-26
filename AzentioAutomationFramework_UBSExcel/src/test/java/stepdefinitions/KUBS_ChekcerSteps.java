package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class KUBS_ChekcerSteps extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCategory", "DataSet ID");
	ExcelData excelDataForAssetCodeConfig = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	ExcelData excelDataForAssetGlConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Map<String, String> checkerTestData = new HashMap<>();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	ExcelData excelDataAssetImpairementExecution = new ExcelData(excelPath, "AssetImpairement_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataAssetRevaluationExecution = new ExcelData(excelPath, "AssetRevaluation_ExecutionTrack",
			"TestCaseID");
	
	ExcelData excelDataForSerialNumberSetUp = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	ExcelData excelDataForAssetCreation = new ExcelData(excelPath, "FixedAsset_AssetCreation", "DataSet ID");
	ExcelData excelDataForAssetSale = new ExcelData(excelPath, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(excelPath, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetDeAllocation = new ExcelData(excelPath, "FixedAsset_AssetDeAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(excelPath, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImapirment = new ExcelData(excelPath, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetRevaluation = new ExcelData(excelPath, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetAmmendment = new ExcelData(excelPath, "FixedAsset_AssetAmmendment", "DataSet ID");
	ExcelData excelDataForAssetReplacement = new ExcelData(excelPath, "FixedAsset_AssetReplacement", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(excelPath, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataForBudgetDefenition = new ExcelData(excelPath, "BudgetConfiguration", "DataSet ID");
	ExcelData excelDataForBudgetReqAndAllocation = new ExcelData(excelPath, "BudgetReqAndAllocation", "DataSet ID");
	ExcelData excelDataForBusinessPartner = new ExcelData(excelPath, "BusinessPartnerTestData", "Data Set ID");
	ExcelData excelDataForInvoiceBooking = new ExcelData(excelPath, "BillBookingTestData", "Data Set ID");
	ExcelData excelDataForGRN = new ExcelData(excelPath, "GRNTestData", "Data Set ID");
	Map<String,String> dataSetID= new HashMap<>();
	ExcelData excelDataForTransferExecution = new ExcelData(excelPath, "AssetTransfer_ExecutionTracker", "TestCaseID");

	@Given("^navigate to kubs url to approve the GRN record in checker$")
	public void navigate_to_kubs_url_to_approve_the_grn_record_in_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForGRN.getTestdata("KUBS_FAT_UAT_001_004_02_D1");
	}

	@Given("^navigate to kubs url to approve the the invoice against po record in checker$")
	public void navigate_to_kubs_url_to_approve_the_the_invoice_against_po_record_in_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForInvoiceBooking.getTestdata("KUBS_FAT_UAT_001_005_01_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the business partner setup record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_business_partner_setup_record()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBusinessPartner.getTestdata("KUBS_FAT_UAT_001_01_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the quarterly budget record to validate the budget amount field in budget allocation screen$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field_in_budget_allocation_screen()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D5");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the yearly budget record for prerequisite of updating budget before HO Approval$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_yearly_budget_record_for_prerequisite_of_updating_budget_before_ho_approval()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D2");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the monthly budget record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_monthly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_002_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the monthly budget record for validate the budget amount fields for current financial budget$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_monthly_budget_record_for_validate_the_budget_amount_fields_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the yearly budget record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_yearly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the monthly budget allocation field validation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_monthly_budget_allocation_field_validation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the quarterly budget record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_quarterly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_003_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the quarterly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D5");
	}

//	@Given("^navigate to kubs url to approve the quarterly budget record to validate the budget amount field in budget allocation screen$")
//    public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field_in_budget_allocation_screen() throws Throwable {
//		driver.get(configFileReader.getApplicationUrl());
//		kubsLogin.loginToAzentioAppAsChecker("Checker");
//		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D5");;
//    }
	@Given("^Navigate to KUBS url and login with checker for approve the half yearly budget record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_half_yearly_budget_record()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_004_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the half yearly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_half_yearly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D6");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the half yearly budget to validate the budget amount field in budget request and allocation screen$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_half_yearly_budget_to_validate_the_budget_amount_field_in_budget_request_and_allocation_screen()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D6");
	}

	@Given("^Navigate to KUBS url and login with checker for current financial budget$")
	public void navigate_to_kubs_url_and_login_with_checker_for_current_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D2");
	}

	@Given("^Navigate to KUBS url and login with checker for currently monthly budget and budget amount field valiadation and creation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_currently_monthly_budget_and_budget_amount_field_valiadation_and_creation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for currently qarterly budget and budget amount field valiadation and creation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_currently_qarterly_budget_and_budget_amount_field_valiadation_and_creation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget request and allocation record for monthly field validation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_request_and_allocation_record_for_monthly_field_validation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget request and allocation record for quarterly field validation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_request_and_allocation_record_for_quarterly_field_validation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget request and allocation record for half yearly field validation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_request_and_allocation_record_for_half_yearly_field_validation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
	}

	@Given("^navigate to uls URL to approve the half yearly budget for current fiancial budget in checker stage$")
	public void navigate_to_uls_url_to_approve_the_half_yearly_budget_for_current_fiancial_budget_in_checker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for future financial budget$")
	public void navigate_to_kubs_url_and_login_with_checker_for_future_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetDefenition.getTestdata("KUBS_BP_UAT_001_001_D3");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget allocation record for current financial budget$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_allocation_record_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_005_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget allocation record for future financial budget$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_allocation_record_for_future_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_006_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the budget allocation record which is updated before HO approval$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_budget_allocation_record_which_is_updated_before_ho_approval()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_001_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset replacement record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset replacement record in checker for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_checker_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset replacement record in checker for prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_checker_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_008_001_03_Revaluation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset replacement record in checker for asset retrurn prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_checker_for_asset_retrurn_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D3");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record in checker for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_in_checker_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record in checker for prerequisite for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_in_checker_for_prerequisite_for_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_011_03_Revaluation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in checker to approve the asset life changes ammendment asset$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_checker_to_approve_the_asset_life_changes_ammendment_asset()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_02_D1");
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in checker to approve the ammendment asset which have less that asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_checker_to_approve_the_ammendment_asset_which_have_less_that_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_03_D1");
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in checker to approve the ammendment asset which have Greater than asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_checker_to_approve_the_ammendment_asset_which_have_greater_than_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_04_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record in checker for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_in_checker_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D5");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record in checker for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_in_checker_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D4");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record in a checker for prerequsite of asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_in_a_checker_for_prerequsite_of_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_011_03_Impairment");
		checkerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata("KUBS_FAT_UAT_012_01_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker for the prerequisite of asset transfer undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_for_the_prerequisite_of_asset_transfer_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_012_03_AssetTransfer");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_002_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already Revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_003_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already Impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata("KUBS_FAT_UAT_012_04_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already done on asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_done_on_asset_ammendment()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_005_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already done on asset replacement$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_done_on_asset_replacement()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_009_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already done on asset undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_done_on_asset_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_006_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already done on asset sale maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_done_on_asset_sale_maker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_007_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker which is already done on asset return maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_which_is_already_done_on_asset_return_maker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_008_03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker for prerequisite for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_for_prerequisite_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata("KUBS_FAT_UAT_012_01_D4");
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata("KUBS_FAT_UAT_012_01_D3");
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in a checker for asset impairment prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_a_checker_for_asset_impairment_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_012_03_AssetImpairment");
		checkerTestData = excelDataForAssetRevaluation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_001_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record in checker for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_checker_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetImapirment.getTestdata("KUBS_FAT_UAT_009_001_01_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_001_D1");

	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_003_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_004_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already replaced$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_replaced()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_006_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_007_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_008_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset write off record in checker which is already undertaken$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_checker_which_is_already_undertaken()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_009_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record in checker for prerequisite of asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_checker_for_prerequisite_of_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_009_001_03_AssetTransfer");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record in checker for the prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_checker_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_009_001_03_Revaluation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record in checker for the prerequsite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_checker_for_the_prerequsite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetImapirment.getTestdata("KUBS_FAT_UAT_009_001_01_D2");
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_002_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_003_04");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_004_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_005_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already replaced in maker end to approve in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_replaced_in_maker_end_to_approve_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_006_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already Return in maker end to approve in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_return_in_maker_end_to_approve_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_007_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already Sale in maker end to approve in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_sale_in_maker_end_to_approve_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_008_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset impairment record which is already Transfered in maker end to approve in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_transfered_in_maker_end_to_approve_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_009_03");
		checkerTestData = excelDataForAssetImapirment.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset return$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D3");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset allocation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset ammendment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D5");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset revaluation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_002_03_ReValuation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset tranfer and undertaking$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_tranfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_002_002_03_Transfer");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Then("^log in to the Checker Account$")
	public void log_in_to_the_checker_account() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset category record for asset impairment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_category_record_for_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_002_03");
		checkerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record for asset ammendment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D5");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record for asset allocation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record for asset revaluation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_003_03_ReValuation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record for asset transfer and undetaking$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_for_asset_transfer_and_undetaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_002_003_03_Transfer");
		
		checkerTestData = excelDataForAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record to di impairment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_to_di_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_003_03");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset code configuration record for asset return$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_code_configuration_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D3");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record for asset ammendment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata("KUBS_FAT_UAT_002_004_D5");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record for asset allocation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata("KUBS_FAT_UAT_002_004_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record for asset revaluation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_004_03_ReValuation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_for_asset_transfer_and_undertaking()
			throws Throwable {

		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_002_004_03_Transfer");
		checkerTestData = excelDataForAssetGlConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record for asset return$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetGlConfig.getTestdata("KUBS_FAT_UAT_002_004_D3");
	}

	@Given("^Navigate to KUBS url and login with checker for approve asset gl configuration record to do asset impairment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_asset_gl_configuration_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_004_03");
		checkerTestData = excelDataForAssetGlConfig.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D1");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset ammendment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D5");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset allocation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D4");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset revaluation$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_005_03_ReValuation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_002_005_03_Transfer");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record for asset return$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D3");
	}

	@Given("^Navigate to KUBS url and login with checker for approve the asset serial number setup record to do asset impairment$")
	public void navigate_to_kubs_url_and_login_with_checker_for_approve_the_asset_serial_number_setup_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_005_03");
		checkerTestData =excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with minimum details as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_minimum_details_as_a_checker()
			throws Throwable {

		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_006_D1");
	}
	@Given("^navigate to kubs url to approve the fixed asset creation record with GRN number as a checker$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_grn_number_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D8");
    }

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details in checker for asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_checker_for_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataForTransferExecution.getTestdata("KUBS_FAT_UAT_002_007_03_AssetTransfer1");
		checkerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details in checker for asset ammendment prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_checker_for_asset_ammendment_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D5");
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details in checker fo the pre requiste of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_checker_fo_the_pre_requiste_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_007_03_AssetRevaluation03");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details as a checker for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_checker_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D4");
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details as a checker to do impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_checker_to_do_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_007_01_Impairment03");
		checkerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with full details in a checker for asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_a_checker_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D3");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_001_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker for prerequisite of asset deallocation writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_for_prerequisite_of_asset_deallocation_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D12");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker for asset revaluation prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_for_asset_revaluation_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_006_001_03_Revaluation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));	
	
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_004_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker which is already used$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_which_is_already_used()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record in checker for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_in_checker_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D3");
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_to_make_the_asset_impaired_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_006_001_03_Impairment");
		checkerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record which is  impaired asset as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_which_is_impaired_asset_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation record which is already used asset as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_record_which_is_already_used_asset_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset sale record whcih is sold at high price as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_whcih_is_sold_at_high_price_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetSale.getTestdata("KUBS_FAT_UAT_004_001_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset sale record whcih is sold at low price as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_whcih_is_sold_at_low_price_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset de allocation record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset de allocation record as a checker for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_record_as_a_checker_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D11");
	}

	@Given("^navigate to kubs url to approve the fixed asset de allocation record in checker for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_record_in_checker_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D3");
	}

	@Given("^navigate to kubs url to approve the fixed asset de allocation record in checker for the prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_record_in_checker_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_006_005_03_Revaluation");
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation for asset impairmemnt in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_for_asset_impairmemnt_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		dataSetID=excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_006_005_03_Impairment");
		checkerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset return record$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_001_01_D1");

	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is already revalued in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_revalued_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_002_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is already undertaken in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_undertaken_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_007_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is already impaired in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_impaired_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_004_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is already replaced in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_replaced_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_005_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is already deallocated in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_deallocated_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_006_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset return record which is done on asset ammendment in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_done_on_asset_ammendment_in_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_003_01_D1");
	}

	@Given("^navigate to kubs url to approve the fixed asset replacement record as a checker for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_as_a_checker_for_deallocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D6");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation from asset replacement record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_replacement_record_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D5");
	}

	@Given("^navigate to kubs url to approve the asset replacement record to de allocation as a checker$")
	public void navigate_to_kubs_url_to_approve_the_asset_replacement_record_to_de_allocation_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D5");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation from asset ammenment record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_ammenment_record_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D6");
	}

	@Given("^navigate to kubs url to approve the fixed asset ammendment record as a checker for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_record_as_a_checker_for_deallocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D7");
	}

	@Given("^navigate to kubs url to approve the asset ammenment record to de allocation as a checker$")
	public void navigate_to_kubs_url_to_approve_the_asset_ammenment_record_to_de_allocation_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D6");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation from asset transfer record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_transfer_record_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D7");
	}

	@Given("^navigate to kubs url to approve the asset transfer record to de allocation as a checker$")
	public void navigate_to_kubs_url_to_approve_the_asset_transfer_record_to_de_allocation_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D7");
	}

	@Given("^navigate to kubs url to approve the fixed asset sale record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D4");
	}

	@Given("^navigate to kubs url to approve the fixed asset allocation from asset sale record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_sale_record_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D8");
	}

	@Given("^navigate to kubs url to approve the asset sale record to de allocation as a checker$")
	public void navigate_to_kubs_url_to_approve_the_asset_sale_record_to_de_allocation_as_a_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D8");
	}

	@Given("^navigate to kubs url to approve the fixed asset revaluation record in checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_checker() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetRevaluation.getTestdata("KUBS_FAT_UAT_012_01_D5");

	}

	@Given("^navigate to kubs url to approve the fixed asset allocation from asset revalauation record as a checker$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_revalauation_record_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D9");
	}

	@Given("^navigate to kubs url to approve the asset revaluation record to de allocation as a checker$")
	public void navigate_to_kubs_url_to_approve_the_asset_revaluation_record_to_de_allocation_as_a_checker()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		checkerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D9");
	}

	@And("^click on security management tool$")
	public void click_on_security_management_tool() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerSecurityManagement(), 60, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionsHelper.moveToElement(checkerObj.checkerSecurityManagement());
				clicksAndActionsHelper.clickOnElement(checkerObj.checkerSecurityManagement());

				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on temp view near by open pool$")
	public void click_on_temp_view_near_by_open_pool() throws Throwable {
		// waitHelper.waitForElementToVisibleWithFluentWait(driver,
		// checkerObj.kubsCheckerOpenPoolTemp(), 30, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				clicksAndActionsHelper.moveToElement(checkerObj.kubsCheckerOpenPoolTemp());
				clicksAndActionsHelper.clickOnElement(checkerObj.kubsCheckerOpenPoolTemp());
				break;
			} catch (Exception e) {
				if (i > 1 && i < 99) {
					clicksAndActionsHelper.moveToElement(checkerObj.checkerSecurityManagement());
					clicksAndActionsHelper.clickOnElement(checkerObj.checkerSecurityManagement());
				} else if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^clime the record by the help of Record reference ID$")
	public void clime_the_record_by_the_help_of_record_reference_id() throws Throwable {
		String xpath = "//span[text()='" + checkerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button";
		for (int i = 0; i <= 200; i++) {
			try {
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i > 145 && i < 150) {
					waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerNotificationIcon(), 20,
							1);
					clicksAndActionsHelper.moveToElement(checkerObj.checkerNotificationIcon());
					clicksAndActionsHelper.clickOnElement(checkerObj.checkerNotificationIcon());
					waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.kubsCheckerOpenPoolTemp(), 20,
							1);
					clicksAndActionsHelper.moveToElement(checkerObj.kubsCheckerOpenPoolTemp());
					clicksAndActionsHelper.clickOnElement(checkerObj.kubsCheckerOpenPoolTemp());
				}
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify record got climed in checker$")
	public void verify_record_got_climed_in_checker() throws Throwable {
		for (int i = 0; i <= 1000; i++) {
			try {
				clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsToastAlert());
				Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
						"Claimed Successfully!!! Approve record from inbox");
				break;
			} catch (Exception e) {
				if (i == 1000) {
					Assert.fail(e.getMessage());
				} 
				
			}
			catch(AssertionError e1)
			{
				if (i == 1000) {
					Assert.fail(e1.getMessage());
				} 
			}
		}
		for (int i = 0; i <= 1000; i++) {
			try {
				clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertClose());
				kubsCommonObj.kubsAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 1000) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on notification in checker stage$")
	public void click_on_notification_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsNotificationIcon(), 20, 1);
		kubsCommonObj.kubsNotificationIcon().click();
	}

	@And("^select the record in notification in checker stage$")
	public void select_the_record_in_notification_in_checker_stage() throws Throwable {
		String xpath = "//span[text()='" + checkerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 500; i++) {
			try {
				if (i > 200 && i < 400) {
					kubsCommonObj.kubsNotificationIcon().click();
					clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
					clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
					break;
				}
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on approve button in checker$")
	public void click_on_approve_button_in_checker() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 20, 1);
		kubsCommonObj.kubsApproveButton().click();

	}

	@And("^give approve alert remark in checker stage$")
	public void give_approve_alert_remark_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionsHelper.clickUsingActionClass(kubsCommonObj.kubsAlertRemark(), kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(checkerTestData.get("CheckerAlertRemark"));
	}

	@And("^click on submit button in checker stage$")
	public void click_on_submit_button_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		kubsCommonObj.kubsAlertSubmit().click();
	}

	@Then("^verify record got approved in checker stage$")
	public void verify_record_got_approved_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsToastAlert());
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(), "Record approved successfully");
		// waitHelper.waitForElementToVisibleWithFluentWait(driver,
		// kubsCommonObj.kubsAlertClose(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				kubsCommonObj.kubsAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

}
