package stepdefinitions;

import java.util.HashMap;
import java.util.List;
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
import tests.ExcelTest;

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
	ExcelData excelDataForBudgetReqAllocation = new ExcelData(excelPath, "BudgetReqAndAllocation", "DataSet ID");
	ExcelData excelDataForBudgetSupplementary = new ExcelData(excelPath,"BudgetSupplimentory","DataSet ID");
	ExcelData excelDataForBudgetReqAndAllocation = new ExcelData(excelPath, "BudgetReqAndAllocation", "DataSet ID");
	ExcelData testExecution = new ExcelData(excelPath,"TestExecution","TestCaseID");
	Map<String, String> testExecutionData;
	ExcelTest excelTest = new ExcelTest(excelPath, "TestExecution", "TestCaseID");
	List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
	@Given("^navigate to kubs url to approve the yearly budget record$")
    public void navigate_to_kubs_url_to_approve_the_yearly_budget_record() throws Throwable {
		if (testCaseTagsfromExcel.contains("KUBS_BP_UAT_001_001_01")) {
			testExecutionData = testExecution.getTestdata("KUBS_BP_UAT_001_001_01");
			Map<String, String> testdata = excelDataForBudgetConfig.getTestdata(testExecutionData.get("Data Set ID"));
			driver.get(configFileReader.getApplicationUrl());
			reviewerTestData = excelDataForBudgetConfig.getTestdata(testdata.get("UpdateDatasetid-1"));
			kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
		}
		
    }
	@Given("^navigate to kubs url to approve the Montly budget request and allocation record$")
    public void navigate_to_kubs_url_to_approve_the_montly_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_UAT_KUBS_BP_UAT_004_002_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the Quartely budget request and allocation record$")
    public void navigate_to_kubs_url_to_approve_the_quartely_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_002_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }

	@Given("^navigate to kubs url to approve the Halfyearly budget request and allocation record$")
	public void navigate_to_kubs_url_to_approve_the_halfyearly_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_003_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the yearly budget request and allocation record$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_004_02_D1");
		System.out.println(reviewerTestData.get("Reviewer ID"));
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the yearly1 budget request and allocation record$")
    public void navigate_to_kubs_url_to_approve_the_yearly1_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_006_05_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly4 budget request and allocation record$")
    public void navigate_to_kubs_url_to_approve_the_yearly4_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_001_05_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the Budget Supplementary record for Yearly Budget Code$")
    public void navigate_to_kubs_url_to_approve_the_budget_supplementary_record_for_yearly_budget_code() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_004_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the Budget Supplementary record in Reviewver for Yearly Budget Code$")
    public void navigate_to_kubs_url_to_approve_the_budget_supplementary_record_in_reviewver_for_yearly_budget_code() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_005_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the HO Budget Supplementary record in Reviewver for Yearly Budget Code$")
    public void navigate_to_kubs_url_to_approve_the_ho_budget_supplementary_record_in_reviewver_for_yearly_budget_code() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_006_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly1 budget definition$")
	public void navigate_to_kubs_url_to_approve_the_yearly1_budget_definition() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_006_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the yearly2 budget definition$")
    public void navigate_to_kubs_url_to_approve_the_yearly2_budget_definition() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_007_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly3 budget defenition record$")
    public void navigate_to_kubs_url_to_approve_the_yearly3_budget_defenition_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_005_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly3 budget request and allocation record$")
    public void navigate_to_kubs_url_to_approve_the_yearly3_budget_request_and_allocation_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAllocation.getTestdata("KUBS_BP_UAT_002_005_05_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly4 budget definition record$")
    public void navigate_to_kubs_url_to_approve_the_yearly4_budget_definition_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetSupplementary.getTestdata("KUBS_BP_UAT_005_001_02_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly budget for future financial budget$")
	public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_future_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D3");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the budget allocation record for future financial budget$")
	public void navigate_to_kubs_url_to_approve_the_budget_allocation_record_for_future_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_006_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	
	@Given("^navigate to kubs url to approve the monthly budget record$")
    public void navigate_to_kubs_url_to_approve_the_monthly_budget_record() throws Throwable {
		testExecutionData = testExecution.getTestdata("KUBS_BP_UAT_001_002_01");
		Map<String, String> testdata = excelDataForBudgetConfig.getTestdata(testExecutionData.get("Data Set ID"));
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata(testdata.get("UpdateDatasetid-1"));
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the quarterly budget record$")
    public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the half yearly budget record$")
    public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_004_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs url to approve the yearly budget for current financial budget$")
    public void navigate_to_kubs_url_to_approve_the_yearly_budget_for_current_financial_budget() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
    }
	@Given("^navigate to kubs Url to approve the fixed asset Replacement record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for prerequiste of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_prerequiste_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the monthly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the quarterly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the quarterly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_quarterly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_004_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Replacement record in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_replacement_record_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_008_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the monthly budget record for validate the budget amount fields for current financial budget$")
	public void navigate_to_kubs_url_to_approve_the_monthly_budget_record_for_validate_the_budget_amount_fields_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D4");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs Url to approve the fixed asset Ammendment as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_prerequisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the asset life changes ammendment asset$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_asset_life_changes_ammendment_asset()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_02_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the ammendment asset which have less that asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_ammendment_asset_which_have_less_that_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_03_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer to approve the ammendment asset which have greater than asset life which earlier exist$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_to_approve_the_ammendment_asset_which_have_greater_than_asset_life_which_earlier_exist()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_04_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in reviewer for asset retur prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_reviewer_for_asset_retur_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Ammendment in a reviewer for pre requsite of assset impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_ammendment_in_a_reviewer_for_pre_requsite_of_assset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_011_01_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for the prerequisite of asset transfer undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_the_prerequisite_of_asset_transfer_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D10");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_02_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_03_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already Impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_04_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_05_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset replacement$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_replacement()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_09_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_06_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the half yearly budget record which is validation the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record_which_is_validation_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_003_005_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset sale maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_sale_maker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_07_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the half yearly budget record to validate the budget amount field$")
	public void navigate_to_kubs_url_to_approve_the_half_yearly_budget_record_to_validate_the_budget_amount_field()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetConfig.getTestdata("KUBS_BP_UAT_001_001_D6");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer which is already done on asset return maker stage$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_which_is_already_done_on_asset_return_maker_stage()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_08_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for prerequsite of asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_prerequsite_of_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Revaluation record in a reviewer for impairment asset prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_revaluation_record_in_a_reviewer_for_impairment_asset_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetrevaluation.getTestdata("KUBS_FAT_UAT_012_01_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset write off$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_prerequisite_of_asset_write_off()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_001_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already revlaued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_revlaued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_004_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already replaced$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_replaced()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_006_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_007_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_008_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset write off record in reviewer which is already undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_write_off_record_in_reviewer_which_is_already_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetWriteOff.getTestdata("KUBS_FAT_UAT_010_009_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for prerequisite of asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_prerequisite_of_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_the_prerequisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record in reviewer for the prerequsite of asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_in_reviewer_for_the_prerequsite_of_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_001_01_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_002_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already de allocated$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_de_allocated()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_003_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_004_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_005_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already replaced in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_replaced_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_006_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already return in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_return_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_007_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already Sale in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_sale_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_008_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset impairment record which is already Transfered in maker end$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_impairment_record_which_is_already_transfered_in_maker_end()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetImpairment.getTestdata("KUBS_FAT_UAT_009_009_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_impairment() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_allocation() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_revaluation() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D7");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset amendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_amendment() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset category record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_category_record_for_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelData.getTestdata("KUBS_FAT_UAT_002_002_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record for asset transfer and undetaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_for_asset_transfer_and_undetaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D7");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset code configuration record to do impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_code_configuration_record_to_do_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetCodeConfig.getTestdata("KUBS_FAT_UAT_002_003_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D7");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record to do asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the asset GL configuration record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_asset_gl_configuration_record_for_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = exceldatforAssetGLConfig.getTestdata("KUBS_FAT_UAT_002_004_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));

	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset transfer and undertaking$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_transfer_and_undertaking()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D7");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record for asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset serial number setup record to do asset impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_serial_number_setup_record_to_do_asset_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForSerialNumberSetUp.getTestdata("KUBS_FAT_UAT_002_005_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs url to approve the fixed asset creation record with minimum details as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_minimum_details_as_a_reviewer()
			throws Throwable {

		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_006_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset transfer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_asset_transfer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D7");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for pre requisite of asset ammendment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_pre_requisite_of_asset_ammendment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D5");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D6");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));

	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D9");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_005_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}
	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 for prerequisite of asset return$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_for_prerequisite_of_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D8");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
    }

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_006_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage1 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage1_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage1 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage1_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_007_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID1"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 for prerequisite of asset writeOff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D9");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_005_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}
	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 for prerequisite of asset return$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_for_prerequisite_of_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D8");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
    }

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_006_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage2 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage2_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage2 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage2_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_007_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID2"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 for the pre requisite of asset revaluation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_for_the_pre_requisite_of_asset_revaluation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 for prerequisite for prerequisite of asset writeOff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_for_prerequisite_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D9");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_005_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}
	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 for prerequisite of asset return$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_for_prerequisite_of_asset_return() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_001_D8");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
    }
	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 which is already impaired$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_which_is_already_impaired()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_006_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer record in stage3 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_record_in_stage3_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset transfer undertaking record in stage3 which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_transfer_undertaking_record_in_stage3_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_005_007_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID3"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in reviewer for asset allocation$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_reviewer_for_asset_allocation()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details as a reviewer to do impairment$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_as_a_reviewer_to_do_impairment()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset creation record with full details in a reviewer for asset return$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_creation_record_with_full_details_in_a_reviewer_for_asset_return()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetCreation.getTestdata("KUBS_FAT_UAT_002_007_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_001_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already revalued in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_revalued_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_002_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs Url to approve the fixed asset return record which is already undertaken in reviewer$")
    public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_undertaken_in_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_007_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
    }

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already impaired in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_impaired_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_004_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already repalced in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_repalced_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_005_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is already Deallocated in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_already_deallocated_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_006_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset return record which is done at asset ammendment in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_return_record_which_is_done_at_asset_ammendment_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_007_003_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_001_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset writeoff prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_writeoff_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset deallocation writeoff prerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_deallocation_writeoff_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D12");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset revaluation rerequisite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_revaluation_rerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D4");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer which is already revalued$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_which_is_already_revalued()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_004_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer which is already used$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_which_is_already_used()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation in reviewer for asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_in_reviewer_for_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation to make the asset impaired in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_to_make_the_asset_impaired_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D2");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation which is impaired asset as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_which_is_impaired_asset_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_003_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset Allocation which is already used as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_allocation_which_is_already_used_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UAT_006_002_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset sale record which is sold at high price as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_which_is_sold_at_high_price_as_a_reviewer()
			throws Throwable {

		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetSale.getTestdata("KUBS_FAT_UAT_004_001_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset sale record which is sold at low price as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_sale_record_which_is_sold_at_low_price_as_a_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetSale.getTestdata("KUBS_FAT_UAT_004_003_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation as a reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_as_a_reviewer() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D1");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation in reviewer for prerequisite of asset writeoff$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_in_reviewer_for_prerequisite_of_asset_writeoff()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D11");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation as a reviewer in asset return prerequsite$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_as_a_reviewer_in_asset_return_prerequsite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D3");
		kubsLogin.logintoAzentioappReviewer( reviewerTestData.get("Reviewer ID"));
	}

	@And("^navigate to kubs Url to approve the fixed asset de Allocation in reviewer for asset revaluation prerequisite$")
	public void navigate_to_kubs_Url_to_approve_the_fixed_asset_de_Allocation_in_reviewer_for_asset_revaluation_prerequisite()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D4");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@Given("^navigate to kubs Url to approve the fixed asset de Allocation for asset impairmemnt in reviewer$")
	public void navigate_to_kubs_url_to_approve_the_fixed_asset_de_allocation_for_asset_impairmemnt_in_reviewer()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForAssetDeAllocation.getTestdata("KUBS_FAT_UAT_006_005_01_D2");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}
	@Given("^navigate to kubs url to approve the budget allocation record for current financial budget$")
	public void navigate_to_kubs_url_to_approve_the_budget_allocation_record_for_current_financial_budget()
			throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		reviewerTestData = excelDataForBudgetReqAndAllocation.getTestdata("KUBS_B&P_UAT_001_005_D1");
		kubsLogin.logintoAzentioappReviewer(reviewerTestData.get("Reviewer ID"));
	}

	@And("^click on notification in reviewer stage$")
	public void click_on_notification_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,kubsCommonObj.kubsNotificationIcon(), 20, 1);
		for (int i = 0; i <= 100; i++) {
			try {
				cliksAndActionsHelper.moveToElement(kubsCommonObj.kubsNotificationIcon());
				cliksAndActionsHelper.clickOnElement(kubsCommonObj.kubsNotificationIcon());
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsApproveButton(), 20, 1);
		kubsCommonObj.kubsApproveButton().click();
	}

	@And("^enter the alert remark in reviewer stage$")
	public void enter_the_alert_remark_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		for (int i = 0; i <= 50; i++) {
			try {
				kubsCommonObj.kubsAlertRemark().click();
				kubsCommonObj.kubsAlertRemark().sendKeys(reviewerTestData.get("ReviewerAlertRemark"));
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
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
	}
	 @And("^verify record got approved in stage3$")
	    public void verify_record_got_approved_in_stage3() throws Throwable {
		 waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
			Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(), "Record approved successfully");
	    }

	@Then("^verify record got approved in reviewer stage$")
	public void verify_record_got_approved_in_reviewer_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		Assert.assertEquals(kubsCommonObj.kubsToastAlert().getText(),
				"Record is available in CHECKER's Open Pool with status PENDING");
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver,kubsCommonObj.kubsLogoutVerification(),30, 2);
		kubsCommonObj.kubsLogoutVerification().isDisplayed();
				
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
