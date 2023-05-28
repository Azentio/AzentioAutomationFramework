package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class KUBS_ReviewerUserSteps extends BaseClass {

	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";

	Map<String, String> reviewerTestData = new HashMap<>();
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper cliksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> dataSetID = new HashMap<>();
	ExcelData excelDataAssetImpairementExecution = new ExcelData(excelPath, "AssetImpairement_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataAssetRevaluationExecution = new ExcelData(excelPath, "AssetRevaluation_ExecutionTrack",
			"TestCaseID");
	ExcelData excelDataFOrTransferExecution = new ExcelData(excelPath, "AssetTransfer_ExecutionTracker", "TestCaseID");
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCategory", "DataSet ID");
	ExcelData exceldatforAssetCodeConfig = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	ExcelData exceldatforAssetGLConfig = new ExcelData(excelPath, "FixedAsset_GLConfig", "DataSet ID");
	ExcelData excelDataForSerialNumberSetUp = new ExcelData(excelPath, "FixedAsset_SerialNumberConfig", "DataSet ID");
	ExcelData excelDataForAssetCreation = new ExcelData(excelPath, "FixedAsset_AssetCreation", "DataSet ID");
	ExcelData excelDataForAssetSale = new ExcelData(excelPath, "FixedAsset_AssetSale", "DataSet ID");
	ExcelData excelDataForAssetAllocation = new ExcelData(excelPath, "FixedAsset_AssetAllocation", "DataSet ID");
	ExcelData excelDataForAssetDeAllocation = new ExcelData(excelPath, "FixedAsset_AssetDeAllocation", "DataSet ID");
	ExcelData excelDataForAssetReturn = new ExcelData(excelPath, "FixedAsset_AssetReturn", "DataSet ID");
	ExcelData excelDataForAssetImpairment = new ExcelData(excelPath, "FixedAsset_AssetImpairement", "DataSet ID");
	ExcelData excelDataForAssetrevaluation = new ExcelData(excelPath, "FixedAsset_AssetReValuation", "DataSet ID");
	ExcelData excelDataForAssetAmmendment = new ExcelData(excelPath, "FixedAsset_AssetAmmendment", "DataSet ID");
	ExcelData excelDataForAssetReplacement = new ExcelData(excelPath, "FixedAsset_AssetReplacement", "DataSet ID");
	ExcelData excelDataForAssetTransfer = new ExcelData(excelPath, "FixedAsset_AssetTransfer", "DataSet ID");
	ExcelData excelDataForAssetWriteOff = new ExcelData(excelPath, "FixedAsset_WriteOff", "DataSet ID");
	ExcelData excelDataForBudgetConfig = new ExcelData(excelPath, "BudgetConfiguration", "DataSet ID");
	ExcelData excelDataForBudgetReqAndAllocation = new ExcelData(excelPath, "BudgetReqAndAllocation", "DataSet ID");
	ExcelData excelDataForBusinessPartner = new ExcelData(excelPath, "BusinessPartnerTestData", "Data Set ID");
	ExcelData excelDataForInvoiceBooking = new ExcelData(excelPath, "BillBookingTestData", "Data Set ID");
	ExcelData excelDataForGRN = new ExcelData(excelPath, "GRNTestData", "Data Set ID");
	ExcelData excelDataAssetUndertakingExecution = new ExcelData(excelPath, "AssetUndertaking_ExecTracker",
			"TestCaseID");
	ExcelData excelDataAssetAllocDeAllocExecution = new ExcelData(excelPath, "AssetAllocDeAlloc_ExeTracker",
			"TestCaseID");
	ExcelData excelDataAssetReturnExecution = new ExcelData(excelPath, "AssetReturn_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetAmendmentExecution = new ExcelData(excelPath, "AssetAmendment_EXecutionTrack", "TestCaseID");
	ExcelData excelDataAssetWriteOffExecution = new ExcelData(excelPath, "WriteOff_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetCreationExecution = new ExcelData(excelPath, "AssetCreation_ExecutionTrack", "TestCaseID");
	ExcelData excelDataAssetConfigExecution = new ExcelData(excelPath, "AssetConfig_ExecutionTrack", "TestCaseID");
	@Given("^navigate to kubs Url to approve the GRN record in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_grn_record_in_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetConfigExecution.getTestdata("KUBS_FAT_UAT_001_004_02");
		reviewerTestData = excelDataForGRN.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the invoice against po record in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_invoice_against_po_record_in_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetConfigExecution.getTestdata("KUBS_FAT_UAT_001_005_02");
		reviewerTestData = excelDataForInvoiceBooking.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the business partner setup record$")
	public void navigate_to_kubs_url_to_approve_the_business_partner_setup_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetConfigExecution.getTestdata("KUBS_FAT_UAT_001_02");
		reviewerTestData = excelDataForBusinessPartner.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget record$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the monthly budget record$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_002_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the monthly budget record for validate the budget amount fields for current financial budget$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record_for_validate_the_budget_amount_fields_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D4");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the monthly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the quarterly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the half yearly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget record for prerequisite of updating the budget before HO approval$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_record_for_prerequisite_of_updating_the_budget_before_ho_approval()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D2");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the monthly budget record for budget allocation field validation$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record_for_budget_allocation_field_validation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D4");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the quarterly budget record$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_003_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the quarterly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D5");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the quarterly budget record to validate the budget amount field in budget allocation screen$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field_in_budget_allocation_screen()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D5");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the half yearly budget record$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_004_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the half yearly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D6");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the half yearly budget record for validate the budget amount field in budget request and allocation screen$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record_for_validate_the_budget_amount_field_in_budget_request_and_allocation_screen()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D6");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget for current financial budget$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_current_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D2");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget for currently monthly budget and budget amount field valiadation and creation$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_currently_monthly_budget_and_budget_amount_field_valiadation_and_creation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget for currently qarterly budget and budget amount field valiadation and creation$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_currently_qarterly_budget_and_budget_amount_field_valiadation_and_creation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget for currently half yearly budget and budget amount field valiadation and creation$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_currently_half_yearly_budget_and_budget_amount_field_valiadation_and_creation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to uls URL to approve the half yearly budget for current fiancial budget in reviewer stage$")
	public void navigate_to_uls_url_to_approve_the_half_yearly_budget_for_current_fiancial_budget_in_reviewer_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget for future financial budget$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_future_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D3");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the budget allocation record for current financial budget$")
	public void navigate_to_kubs_url_to_approve_the_budget_allocation_record_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_005_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the budget allocation record for future financial budget$")
	public void navigate_to_kubs_url_to_approve_the_budget_allocation_record_for_future_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_006_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the budget allocation record which is updated before HO approval$")
	public void navigate_to_kubs_url_to_approve_the_budget_allocation_record_which_is_updated_before_ho_approval()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_001_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_008_001_02");
		reviewerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_008_001_02_WriteOff");
		reviewerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for prerequiste of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_prerequiste_of_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_008_001_02_Revaluation");
		reviewerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_008_001_02_Return");
		reviewerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_011_02");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_011_02_WriteOff");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_011_02_Revaluatio");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the asset life changes ammendment asset$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_asset_life_changes_ammendment_asset()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_011_02_02");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the ammendment asset which have less that asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_ammendment_asset_which_have_less_that_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_011_03_02");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the ammendment asset which have greater than asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_ammendment_asset_which_have_greater_than_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_011_04_02");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D5");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for asset retur prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_asset_retur_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_011_02_AssetReturn");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in a reviewer for pre requsite of assset impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_a_reviewer_for_pre_requsite_of_assset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_011_02_Impairment");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_012_02_WriteOff");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for the prerequisite of asset transfer undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_the_prerequisite_of_asset_transfer_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_012_02_AssetTransfer");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_002_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_003_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already Impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_04_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_003_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_05_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset replacement$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_replacement()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_009_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_006_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset sale maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_sale_maker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_007_02");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset return maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_return_maker_stage()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_012_008_02");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for prerequsite of asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_prerequsite_of_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D4");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_012_02_AssetReturn");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in a reviewer for impairment asset prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_a_reviewer_for_impairment_asset_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_012_02_AssetImpairment");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_001_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_009_001_02_WriteOff");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_001_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already revlaued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_revlaued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_003_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_004_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already replaced$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_replaced()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_006_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_007_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_008_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_010_009_02");
		reviewerTestData = excelDataForAssetWriteOff.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_prerequisite_of_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_009_001_02_AssetTransfer");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_009_001_02_Revaluation");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequsite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_the_prerequsite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_009_001_02_AsetReturn");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_002_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_003_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_004_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_005_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already replaced in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_replaced_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_006_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already return in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_return_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_007_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already Sale in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_sale_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_008_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already Transfered in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_transfered_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_009_009_02");
		reviewerTestData = excelDataForAssetImpairment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_002_02");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs url to approve the asset category record for asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_impairment() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_002_02");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_allocation() throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_002_02Allocation");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_revaluation() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_002_02_ReValuation");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_002_002_02_Transfer");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset amendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_amendment() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution.getTestdata("KUBS_FAT_UAT_002_002_02_Return");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs url to approve the asset category record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_002_02_Return");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_003_02");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_003_02_Return");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_allocation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_003_02Allocation");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution.getTestdata("KUBS_FAT_UAT_002_003_02_AssetAmmendment");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_003_02_ReValuation");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset transfer and undetaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_transfer_and_undetaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_002_003_02_Transfer");
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record to do impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_to_do_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_003_02");
		System.out.println("Data Set ID "+dataSetID.get("Data Set ID"));
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_004_02");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_002_004_02_AssetAmmendment");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_004_02_ReValuation");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_002_004_02_Transfer");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_allocation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_004_02Allocation");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record to do asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_004_02");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_004_02_Return");
		reviewerTestData = exceldatforAssetGLConfig.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_005_02");
		reviewerTestData =excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_002_005_02_AssetAmmendment");
		reviewerTestData =excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_allocation()
			throws Throwable {
	
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_005_02Allocation");
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}
	

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_005_02_ReValuation");
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_002_005_02_Transfer");
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_005_02_Return");
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record to do asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_005_02");
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with minimum details as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_minimum_details_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_006_02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with GRN number$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_grn_number() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_008_02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_002_007_02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_002_007_02_AssetTransfer1");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for pre requisite of asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_pre_requisite_of_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAmendmentExecution .getTestdata("KUBS_FAT_UAT_002_007_02_AssetAmmendment02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_002_007_02_AssetRevaluation02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
	
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_005_002_Revaluation");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_001_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_005_001_02_WriteOff");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_005_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 for prerequisite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_for_prerequisite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_005_005_02_Return");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_002_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_006_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_003_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_007_02");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_005_003_Revaluation");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 for prerequisite of asset writeOff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_002_002_02_Return");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_001_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_005_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 for prerequisite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_for_prerequisite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_005_005_03_Return");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_002_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));

		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_006_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_003_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_which_is_already_revalued()
			throws Throwable {

		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_005_007_03");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_005_004_Revaluation");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_001_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 for prerequisite for prerequisite of asset writeOff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_for_prerequisite_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_005_001_04_WriteOff");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_005_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 for prerequisite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_for_prerequisite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_005_005_04_Return");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_002_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_006_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataFOrTransferExecution.getTestdata("KUBS_FAT_UAT_005_003_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetUndertakingExecution.getTestdata("KUBS_FAT_UAT_005_007_04");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_asset_allocation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_002_007_02Allocation02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer to do impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_reviewer_to_do_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_002_007_01_Impairment01");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in a reviewer for asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_a_reviewer_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_002_007_02_Return02");
		reviewerTestData = excelDataForAssetCreation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_001_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already revalued in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_revalued_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_002_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already undertaken in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_undertaken_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_007_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already impaired in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_impaired_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_004_01_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already repalced in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_repalced_in_reviewer()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_005_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already Deallocated in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_deallocated_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_006_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is done at asset ammendment in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_done_at_asset_ammendment_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_007_003_02");
		reviewerTestData = excelDataForAssetReturn.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_001_02");
		reviewerTestData =excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset writeoff prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_writeoff_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_006_001_02_writeOff");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset deallocation writeoff prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_deallocation_writeoff_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_006_001_01_WriteOff02");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset revaluation rerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_revaluation_rerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_006_001_02_Revaluation");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_004_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer which is already used$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_which_is_already_used()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_006_001_02_Return");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_to_make_the_asset_impaired_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_006_001_02_Impairment");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation which is impaired asset as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_which_is_impaired_asset_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation which is already used as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_which_is_already_used_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset sale record which is sold at high price as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_which_is_sold_at_high_price_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_004_001_02");
		reviewerTestData = excelDataForAssetSale.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset sale record which is sold at low price as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_which_is_sold_at_low_price_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetCreationExecution.getTestdata("KUBS_FAT_UAT_004_003_02");
		reviewerTestData = excelDataForAssetSale.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));	
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_005_02Prereq");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation in reviewer for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_in_reviewer_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetWriteOffExecution.getTestdata("KUBS_FAT_UAT_006_005_02");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation as a reviewer in asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_as_a_reviewer_in_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetReturnExecution.getTestdata("KUBS_FAT_UAT_006_005_02_Return");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@And("^navigate to kubs Url to approve the fixed asset de Allocation in reviewer for asset revaluation prerequisite$")
	public void navigate_to_kubs_Url_to_approve_the_fixed_asset_de_Allocation_in_reviewer_for_asset_revaluation_prerequisite()
			throws Throwable {
		//
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetRevaluationExecution.getTestdata("KUBS_FAT_UAT_006_005_02_Revaluation");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation for asset impairmemnt in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_for_asset_impairmemnt_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID = excelDataAssetImpairementExecution.getTestdata("KUBS_FAT_UAT_006_005_02_Impairment");
		reviewerTestData = excelData.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record as a reviewer for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_as_a_reviewer_for_deallocation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02__AssetReplacementForDealloaction");
		reviewerTestData = excelDataForAssetReplacement.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation from asset replacement data as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_replacement_data_as_a_reviewer()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02_AssetReplacementAllocation");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the asset replacement record to de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_asset_replacement_record_to_de_allocation_as_a_reviewer()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment as a reviewer for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_as_a_reviewer_for_deallocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_011_02_Allocation");
		reviewerTestData = excelDataForAssetAmmendment.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation from asset ammenment data as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_ammenment_data_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_002_02");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the asset ammenment record to de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_asset_ammenment_record_to_de_allocation_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_011_02");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 prerequest for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_prerequest_for_deallocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02_AssetTranferCreation");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 prerequest for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_prerequest_for_deallocation()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_03_assetTransferCreation");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 prerequest for deallocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_prerequest_for_deallocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_04_AssetTranferCreation");
		reviewerTestData = excelDataForAssetTransfer.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation from asset transfer data as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_transfer_data_as_a_reviewer()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02_AssetTransferAllocation");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the asset transfer record to de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_asset_transfer_record_to_de_allocation_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_012_02.1_AssetTransferDeAllocation");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset sale record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_as_a_reviewer() throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_004_001_02AssetSaleCreation");
		reviewerTestData = excelDataForAssetSale.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
		
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation from asset sale data as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_sale_data_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D8");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the asset sale record to de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_asset_sale_record_to_de_allocation_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D8");
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer() throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_004_02_PreReq");
		reviewerTestData = excelDataForAssetrevaluation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation from asset revaluation data as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_from_asset_revaluation_data_as_a_reviewer()
			throws Throwable {
		
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_004_02");
		reviewerTestData = excelDataForAssetAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the asset revaluation record to de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_asset_revaluation_record_to_de_allocation_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		dataSetID=excelDataAssetAllocDeAllocExecution.getTestdata("KUBS_FAT_UAT_006_010_02");
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata(dataSetID.get("Data Set ID"));
		kubsLogin.logintoAzentioappReviewer("Reviewer", reviewerTestData.get("Reviewer ID"));
	}

	@And("^click on notification in reviewer stage$")
	public void click_on_notification_in_reviewer_stage() throws Throwable {

		for (int i = 0; i <= 100; i++) {
			try {
				kubsCommonObj.kubsNotificationIcon().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^select the record in notification$")
	public void select_the_record_in_notification() throws Throwable {
		String xpath = "//span[text()='" + reviewerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 200; i++) {
			try {
				if (i > 100 && i < 200) {
					cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
					cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
					cliksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
					cliksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
					break;
				}
				cliksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				cliksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;

			} catch (Exception e) {

				if (i == 200) {
					Assert.fail(e.getMessage());
				}

			}
		}
	}

	@And("^click on approve button in reviewer stage$")
	public void click_on_approve_button_in_reviewer_stage() throws Throwable {

		// waitHelper.waitForElementToVisibleWithFluentWait(driver,
		// kubsCommonObj.kubsApproveButton(), 20, 1);
		String xpath = "//span[text()='" + reviewerTestData.get("Reference ID")
				+ "']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//ion-button";
		for (int i = 0; i <= 500; i++) {
			try {
				kubsCommonObj.kubsApproveButton().click();
				break;
			} catch (Exception e) {
				if (i > 300 && i < 500) {
					cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
					cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
					cliksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
					cliksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				}

				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the alert remark in reviewer stage$")
	public void enter_the_alert_remark_in_reviewer_stage() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 500; i++) {
			try {
				javascriptHelper.JSEClick(kubsCommonObj.kubsAlertRemark());
				cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
				kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("ReviewerAlertRemark"));
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		System.out.println("alert remark got entered");
	}

	@And("^change the record trasfered as yes in stage 2$")
	public void change_the_record_trasfered_as_yes_in_stage_2() throws Throwable {
		String xpath = "//div[text()=' " + reviewerTestData.get("AssetItemNumber")
				+ " ']//ancestor::datatable-body-cell//following-sibling::datatable-body-cell//ion-select";
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(driver.findElement(By.xpath(xpath)));
				cliksAndActionsHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsTransferRadioButton(), 20, 1);
		cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsTransferRadioButton());
		cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsTransferRadioButton());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsTransferOkButton(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				kubsCommonObj.kubsTransferOkButton().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^save the transfer record in stage2$")
	public void save_the_transfer_record_in_stage2() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsSaveButton());
		cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsSaveButton());
	}

	@And("^enter the alert remark in stage one$")
	public void enter_the_alert_remark_in_stage_one() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonObj.kubsAlertRemark().click();
				kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("FirstApproval"));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on submit in reviewer alert pop up$")
	public void click_on_submit_in_reviewer_alert_pop_up() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		try {
			kubsCommonObj.kubsAlertSubmit().click();
		} catch (Exception e) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
			kubsCommonObj.kubsAlertRemark().click();
			kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("ReviewerAlertRemark"));
			kubsCommonObj.kubsAlertSubmit().click();
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 20, 1);
		cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsToastAlert());

	}

	@And("^verify record got approved in stage3$")
	public void verify_record_got_approved_in_stage3() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(), "Record approved successfully");
	}

	@Then("^verify record got approved in reviewer stage$")
	public void verify_record_got_approved_in_reviewer_stage() throws Throwable {
		for (int i = 0; i <= 1000; i++) {
			try {
				Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
						"Record is available in CHECKER's Open Pool with status PENDING");
				break;
			} catch (Exception e) {
				if (i == 1000) {
					Assert.fail(e.getMessage());
				}
			} catch (AssertionError e1) {
				if (i == 1000) {
					Assert.fail(e1.getMessage());
				}
			}
		}
		for (int i = 0; i <= 500; i++) {
			try {
				kubsCommonObj.kubsAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@Then("^verify record got approved in stage one$")
	public void verify_record_got_approved_in_stage_one() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Record is available in CHECKER's Open Pool with status PENDING");
	}

	@And("^get the stage 2 user id and store the transfer undertaking excel database for the prerequisite of asset revaluation$")
	public void get_the_stage_2_user_id_and_store_the_transfer_undertaking_excel_database_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		String alertPopup = kubsCommonObj.kubsToastAlert().getText();
		String finalAlertPopup = alertPopup.substring(80).replace(".", "").trim();

		excelDataForAssetTransfer.updateTestData(reviewerTestData.get("DataSet ID"), "Reviewer ID2", finalAlertPopup);
	}

	@And("^submit the transfer record in stage 2$")
	public void submit_the_transfer_record_in_stage_2() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsSubmitButton());
		cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsSubmitButton());
	}

	@And("^enter the alert remark in stage 2$")
	public void enter_the_alert_remark_in_stage_2() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());

				kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("SecondApproval"));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^store the stage 3 user id in transfer undertaking excel database$")
	public void store_the_stage_3_user_id_in_transfer_undertaking_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		String alertPopup = kubsCommonObj.kubsToastAlert().getText();
		String finalStage2Message = alertPopup.substring(80).replace(".", "").trim();
		excelDataForAssetTransfer.updateTestData(reviewerTestData.get("DataSet ID"), "Reviewer ID3",
				finalStage2Message);
	}

	@And("^enter the alert remark in stage3$")
	public void enter_the_alert_remark_in_stage3() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
				cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());

				kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("SecondApproval"));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^verify user profile got logout$")
	public void verify_user_profile_got_logout() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsLogoutVerification(), 10, 1);
		for (int i = 0; i <= 500; i++) {
			try {
				kubsCommonObj.kubsLogoutVerification().isDisplayed();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
	}

	@And("^click on user profile in reviewer$")
	public void click_on_user_profile_in_reviewer() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300; i++) {
			try {
				javascriptHelper.JSEClick(kubsCommonObj.kubsUserProfileButton());
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on user profile in maker$")
	public void click_on_user_profile_in_maker() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300; i++) {
			try {
				javascriptHelper.JSEClick(kubsCommonObj.kubsUserProfileButton());

				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on user profile icon$")
	public void click_on_user_profile_icon() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300; i++) {
			try {
				javascriptHelper.JSEClick(kubsCommonObj.kubsUserProfileButton());

				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on logout button$")
	public void click_on_logout_button() throws Throwable {

		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsLogoutButton(), 20, 1);
		javascriptHelper.JSEClick(kubsCommonObj.kubsLogoutButton());
	}

	@And("^close the toast alert$")
	public void close_the_toast_alert() throws Throwable {
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertClose());
				cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertClose());
				// kubsCommonObj.kubsAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on user profile in checker$")
	public void click_on_user_profile_in_checker() throws Throwable {
		for (int i = 0; i <= 400; i++) {
			try {
				kubsCommonObj.kubsUserProfileButton().click();
				break;
			} catch (Exception e) {
				if (i == 400) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
}
