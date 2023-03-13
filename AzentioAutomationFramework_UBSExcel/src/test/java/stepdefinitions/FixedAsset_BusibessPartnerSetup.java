package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.KUBS_CommonWebElements;
import resources.BaseClass;
import resources.ExcelData;

public class FixedAsset_BusibessPartnerSetup extends BaseClass {
	WebDriver driver = BaseClass.driver;
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj businessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(
			driver);

	WaitHelper waitHelper = new WaitHelper(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "BusinessPartnerTestData", "Data Set ID");
	ExcelData excelVendorContract = new ExcelData(path, "ContractTestData", "Data Set ID");
	KUBS_CommonWebElements kubsCommonObj = new KUBS_CommonWebElements(driver);
	Map<String, String> busniessPartnerTestData = new HashMap<>();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);

	@And("^click on business partner setup main menu$")
	public void click_on_business_partner_setup_main_menu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu(), 20, 1);
		businessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu().click();
	}

	@And("^click on business partner view icon$")
	public void click_on_business_partner_view_icon() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_EyeButton(), 20, 1);
		businessPartnerObj.businessPartner_EyeButton().click();
	}

	@And("^get the test data for creating the business partner record$")
	public void get_the_test_data_for_creating_the_business_partner_record() throws Throwable {
		busniessPartnerTestData = excelData.getTestdata("KUBS_FAT_UAT_001_01_D1");
	}

	@And("^click on add button in businesspartner setup$")
	public void click_on_add_button_in_businesspartner_setup() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_AddButton(), 20, 1);
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the business partner type$")
	public void enter_the_business_partner_type() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BPType(), 20, 1);
		businessPartnerObj.businessPartner_BPType().sendKeys(busniessPartnerTestData.get("BP_Type"));
		Thread.sleep(500);
		businessPartnerObj.businessPartner_BPType().sendKeys(Keys.ENTER);
	}

	@And("^enter the business partner sub type$")
	public void enter_the_business_partner_sub_type() throws Throwable {
		businessPartnerObj.businessPartner_BPSubType().click();

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BPSubType(), 20, 1);
		businessPartnerObj.businessPartner_BPSubType().sendKeys(busniessPartnerTestData.get("BP_SubType"));
		Thread.sleep(500);
		businessPartnerObj.businessPartner_BPSubType().sendKeys(Keys.ENTER);
	}

	@And("^enter the reference type in business partner setup$")
	public void enter_the_reference_type_in_business_partner_setup() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ReferenceType(), 20,
				1);
		businessPartnerObj.businessPartner_ReferenceType().sendKeys(busniessPartnerTestData.get("ReferenceType"));
		Thread.sleep(500);
		businessPartnerObj.businessPartner_ReferenceType().sendKeys(Keys.ENTER);
	}

	@And("^enter the reference code no in business partner setup$")
	public void enter_the_reference_code_no_in_business_partner_setup() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		String referenceCode=busniessPartnerTestData.get("ReferenceCodeNumber")+randomNum;
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartner_ReferenceCodeNumber(), 20, 1);
		businessPartnerObj.businessPartner_ReferenceCodeNumber()
				.sendKeys(referenceCode);
	}

	@And("^save the business partner record$")
	public void save_the_business_partner_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^click on individual tab$")
	public void click_on_individual_tab() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_IndividualDetails().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^enter the birth date in individual tab$")
	public void enter_the_birth_date_in_individual_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BirthDateCalender(),
				20, 1);
		businessPartnerObj.businessPartner_BirthDateCalender().click();

		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();

		driver.findElement(By.xpath("//span[text()='" + busniessPartnerTestData.get("BirthYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + busniessPartnerTestData.get("BirthMonth") + "']")).click();
		for (int i = 0; i <= 500; i++) {
			try {
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath("//td[@aria-label='"
						+ busniessPartnerTestData.get("BirthFullMonth") + " " + busniessPartnerTestData.get("BirthDate")
						+ ", " + busniessPartnerTestData.get("BirthYear") + "']")));
				clicksAndActionsHelper.clickOnElement(driver.findElement(By.xpath("//td[@aria-label='"
						+ busniessPartnerTestData.get("BirthFullMonth") + " " + busniessPartnerTestData.get("BirthDate")
						+ ", " + busniessPartnerTestData.get("BirthYear") + "']")));

				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the gender in individual tab$")
	public void enter_the_gender_in_individual_tab() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Gender(), 20, 1);
		businessPartnerObj.businessPartner_Gender().sendKeys(busniessPartnerTestData.get("Gender"));
		businessPartnerObj.businessPartner_Gender().sendKeys(Keys.DOWN, Keys.ENTER);
	}

	@And("^enter the first name in individual tab$")
	public void enter_the_first_name_in_individual_tab() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		String firstName = busniessPartnerTestData.get("FirstName") + randomNum;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_FirstName(), 20, 1);
		businessPartnerObj.businessPartner_FirstName().sendKeys(firstName);
		String finalBpName = firstName + busniessPartnerTestData.get("MiddleName");
		excelData.updateTestData(busniessPartnerTestData.get("Data Set ID"), "UpdatedBpName", finalBpName);
	}

	@And("^enter the middle name in individual tab$")
	public void enter_the_middle_name_in_individual_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_MiddleName(), 20,
				1);
		businessPartnerObj.businessPartner_MiddleName().sendKeys(busniessPartnerTestData.get("MiddleName"));
	}

	@And("^enter last name in individual tab$")
	public void enter_last_name_in_individual_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_LastName(), 20, 1);
		businessPartnerObj.businessPartner_LastName().sendKeys(busniessPartnerTestData.get("LastName"));
	}

	@And("^enter the black listed in individual tab$")
	public void enter_the_black_listed_in_individual_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Blacklisted(), 20,
				1);
		businessPartnerObj.businessPartner_Blacklisted().sendKeys(busniessPartnerTestData.get("Blacklisted"));
		businessPartnerObj.businessPartner_Blacklisted().sendKeys(Keys.ENTER);
	}

	@And("^enter the KYC status in individual tab$")
	public void enter_the_kyc_status_in_individual_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_KYC_Status(), 20,
				1);
		businessPartnerObj.businessPartner_KYC_Status().sendKeys(busniessPartnerTestData.get("KYC_Status"));
		businessPartnerObj.businessPartner_KYC_Status().sendKeys(Keys.ENTER);
	}

	@And("^save the individual record$")
	public void save_the_individual_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartner_IndividualSaveButton(), 20, 1);
		businessPartnerObj.businessPartner_IndividualSaveButton().click();
	}
	@And("^click on add button in corporate section$")
    public void click_on_add_button_in_corporate_section() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
	@And("^enter bp name in corporate section$")
	public void enter_bp_name_in_corporate_section() throws Throwable {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		int randomNum2 = random.nextInt(2000 - 1000) + 1000;
		int randomNum3 = random.nextInt(3000 - 2000) + 2000;
		String bpName=busniessPartnerTestData.get("BPName")+randomNum+randomNum2+randomNum3;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerCorporateBpName(),
				20, 1);
		businessPartnerObj.businessPartnerCorporateBpName().click();
		businessPartnerObj.businessPartnerCorporateBpName().sendKeys(bpName);
		excelData.updateTestData(busniessPartnerTestData.get("Data Set ID"), "UpdateBPName", bpName);
	}

	@And("^enter the registeration number in corporate section$")
	public void enter_the_registeration_number_in_corporate_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerCorporateRegistratonNumber(), 20, 1);
		businessPartnerObj.businessPartnerCorporateRegistratonNumber().click();
		businessPartnerObj.businessPartnerCorporateRegistratonNumber()
				.sendKeys(busniessPartnerTestData.get("RegisterationNumber"));
	}

	@And("^enter the country of registeration$")
	public void enter_the_country_of_registeration() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerCorporateCountryofRegistration(), 20, 1);
		businessPartnerObj.businessPartnerCorporateCountryofRegistration()
				.sendKeys(busniessPartnerTestData.get("CountryOfRegisteration"));
		businessPartnerObj.businessPartnerCorporateCountryofRegistration().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartnerCorporateCountryofRegistration().sendKeys(Keys.ENTER);
	}

	@And("^enter the industry in coporate section$")
	public void enter_the_industry_in_coporate_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerCorporateIndustry(),
				20, 1);
		businessPartnerObj.businessPartnerCorporateIndustry().sendKeys(busniessPartnerTestData.get("Industry"));
		businessPartnerObj.businessPartnerCorporateIndustry().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartnerCorporateIndustry().sendKeys(Keys.ENTER);
	}

	@And("^save the corporate section$")
	public void save_the_corporate_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_SaveButton(), 20,
				1);
		businessPartnerObj.businessPartner_SaveButton().click();
	}

	@And("^enter the complaince in corporate section$")
	public void enter_the_complaince_in_corporate_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerCorporateKYCCompliance(), 20, 1);
		businessPartnerObj.businessPartnerCorporateKYCCompliance()
				.sendKeys(busniessPartnerTestData.get("KYCComplaince"));
		businessPartnerObj.businessPartnerCorporateKYCCompliance().sendKeys(Keys.ENTER);
	}

	@And("^enter the blackisted option in corporate section$")
	public void enter_the_blackisted_option_in_corporate_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerCorporateBlackListed(), 20, 1);
		businessPartnerObj.businessPartnerCorporateBlackListed().sendKeys(busniessPartnerTestData.get("BlackListed"));
		businessPartnerObj.businessPartnerCorporateBlackListed().sendKeys(Keys.ENTER);
	}

	@And("^click on branch tab$")
	public void click_on_branch_tab() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartnerBranchSection().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@And("^click on add button in branch$")
    public void click_on_add_button_in_branch() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }

	@And("^enter the brance code in branch section$")
	public void enter_the_brance_code_in_branch_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerBranchBranchCode(), 20,
				1);
		businessPartnerObj.businessPartnerBranchBranchCode().click();
		businessPartnerObj.businessPartnerBranchBranchCode().sendKeys(busniessPartnerTestData.get("BranchCode"));
	}

	@And("^enter the branch type in branch section$")
	public void enter_the_branch_type_in_branch_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerBranchBranchType(),
				20, 1);
		businessPartnerObj.businessPartnerBranchBranchType().sendKeys(busniessPartnerTestData.get("BranchType"));
		businessPartnerObj.businessPartnerBranchBranchType().sendKeys(Keys.ENTER);
	}

	@And("^enter the branch name in branch section$")
	public void enter_the_branch_name_in_branch_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerBranchBranchName(),
				20, 1);
		businessPartnerObj.businessPartnerBranchBranchName().click();
		businessPartnerObj.businessPartnerBranchBranchName().sendKeys(busniessPartnerTestData.get("BranchName"));
	}

	@And("^enter the parent branch in branch section$")
	public void enter_the_parent_branch_in_branch_section() throws Throwable {

	}

	@And("^enter the GSTN in branch section$")
	public void enter_the_gstn_in_branch_section() throws Throwable {

	}

	@And("^enter the phone number in branch section$")
	public void enter_the_phone_number_in_branch_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerBranchPhoneNo(), 20,
				1);
		businessPartnerObj.businessPartnerBranchPhoneNo().click();
		double phoneNo=Double.valueOf(busniessPartnerTestData.get("PhoneNo"));
				
		
		businessPartnerObj.businessPartnerBranchPhoneNo().sendKeys(String.format("%.0f", phoneNo));
	}

	@And("^enter the email in branch section$")
	public void enter_the_email_in_branch_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerBranchEmail(), 20,
				1);
		businessPartnerObj.businessPartnerBranchEmail().click();
		businessPartnerObj.businessPartnerBranchEmail().sendKeys(busniessPartnerTestData.get("Email"));
	}

	@And("^enter the remark in branch section$")
	public void enter_the_remark_in_branch_section() throws Throwable {

	}

	@And("^save the branch section details$")
	public void save_the_branch_section_details() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_SaveButton(), 20,
				1);
		businessPartnerObj.businessPartner_SaveButton().click();
	}

	@And("^click on identification tab$")
	public void click_on_identification_tab() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartnerIdentificationSection().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on add button in identification section$")
	public void click_on_add_button_in_identification_section() throws Throwable {

		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the id type in identification section$")
	public void enter_the_id_type_in_identification_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ID_Type(), 20, 1);
		businessPartnerObj.businessPartner_ID_Type().sendKeys(busniessPartnerTestData.get("ID_Type"));
		businessPartnerObj.businessPartner_ID_Type().sendKeys(Keys.ENTER);
	}

	@And("^enter the id number in identification section$")
	public void enter_the_id_number_in_identification_section() throws Throwable {
		double idNumber = Double.valueOf(busniessPartnerTestData.get("ID_Number"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ID_Number(), 20, 1);
		businessPartnerObj.businessPartner_ID_Number().sendKeys(String.format("%.0f", idNumber));

	}

	@And("^save the identification details$")
	public void save_the_identification_details() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_SaveButton(), 20,
				1);
		businessPartnerObj.businessPartner_SaveButton().click();
	}

	@And("^click on bank account tab$")
	public void click_on_bank_account_tab() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartnerBankAccountSection().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on add button in bank account section$")
	public void click_on_add_button_in_bank_account_section() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the bank name in bank account section$")
	public void enter_the_bank_name_in_bank_account_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BankName(), 20, 1);
		businessPartnerObj.businessPartner_BankName().sendKeys(busniessPartnerTestData.get("BankName"));
		businessPartnerObj.businessPartner_BankName().sendKeys(Keys.ENTER);
	}

	@And("^enter the branch name of bank in bank acoount section$")
	public void enter_the_branch_name_of_bank_in_bank_acoount_section() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BranchName(), 20,
				1);
		businessPartnerObj.businessPartner_BranchName().click();
		businessPartnerObj.businessPartner_BranchName().sendKeys(busniessPartnerTestData.get("BranchName"));
		businessPartnerObj.businessPartner_BranchName().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_BranchName().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_BranchName().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_BranchName().sendKeys(Keys.ENTER);
	}

	@And("^enter the account type in bank ccount section$")
	public void enter_the_account_type_in_bank_ccount_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_AccountType(), 20,
				1);
		businessPartnerObj.businessPartner_AccountType().sendKeys(busniessPartnerTestData.get("AccountType"));
		businessPartnerObj.businessPartner_AccountType().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_AccountType().sendKeys(Keys.ENTER);
	}

	@And("^enter the account no in bank account section$")
	public void enter_the_account_no_in_bank_account_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_AccountNumber(), 20,
				1);
		businessPartnerObj.businessPartner_AccountNumber().sendKeys(busniessPartnerTestData.get("AccountNumber"));
	}

	@And("^enter the account currency in bank account section$")
	public void enter_the_account_currency_in_bank_account_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_AccountCurrency(),
				20, 1);
		businessPartnerObj.businessPartner_AccountCurrency().sendKeys(busniessPartnerTestData.get("AccountCurrency"));
		businessPartnerObj.businessPartner_AccountCurrency().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_AccountCurrency().sendKeys(Keys.ENTER);
	}

	@And("^enter the payment account indicator in bank account section$")
	public void enter_the_payment_account_indicator_in_bank_account_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerPaymentAccountIndicator(), 20, 1);
		businessPartnerObj.businessPartnerPaymentAccountIndicator()
				.sendKeys(busniessPartnerTestData.get("PaymentAccountIndicator"));
		businessPartnerObj.businessPartnerPaymentAccountIndicator().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartnerPaymentAccountIndicator().sendKeys(Keys.ENTER);
	}

	@And("^enter the account status in bank coount section$")
	public void enter_the_account_status_in_bank_coount_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_AccountStatus(), 20,
				1);
		businessPartnerObj.businessPartner_AccountStatus().sendKeys(busniessPartnerTestData.get("AccountStatus"));
		businessPartnerObj.businessPartner_AccountStatus().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_AccountStatus().sendKeys(Keys.ENTER);
	}

	@And("^enter the remark in bank acount section$")
	public void enter_the_remark_in_bank_acount_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_BankAccountRemark(),
				20, 1);
		businessPartnerObj.businessPartner_BankAccountRemark()
				.sendKeys(busniessPartnerTestData.get("BankDetailRemark"));
	}

	@And("^save the bank account details$")
	public void save_the_bank_account_details() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_SaveButton(), 20,
				1);
		businessPartnerObj.businessPartner_SaveButton().click();
	}

	@And("^click on HSN SAC Code mapping section$")
	public void click_on_hsn_sac_code_mapping_section() throws Throwable {
		for (int i = 0; i <= 500; i++) {
			try {

				businessPartnerObj.businessPartnerHSNSACCodeMappingSection().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on add button in HSN SAC Code mapping$")
	public void click_on_add_button_in_hsn_sac_code_mapping() throws Throwable {
		for (int i = 0; i <= 600; i++) {
			try {
				businessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^enter the HSN SAC Code in code mapping section$")
	public void enter_the_hsn_sac_code_in_code_mapping_section() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_HSN_Code(), 20, 1);

		businessPartnerObj.businessPartner_HSN_Code().click();
		businessPartnerObj.businessPartner_HSN_Code().sendKeys(busniessPartnerTestData.get("HSN_Code"));
		businessPartnerObj.businessPartner_HSN_Code().sendKeys(Keys.DOWN);
		businessPartnerObj.businessPartner_HSN_Code().sendKeys(Keys.ENTER);

	}

	@And("^enter the remark in HSN Code mapping section$")
	public void enter_the_remark_in_hsn_code_mapping_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_HSN_CodeRemark(),
				20, 1);
		businessPartnerObj.businessPartner_HSN_CodeRemark().sendKeys(busniessPartnerTestData.get("HSN_CodeRemark"));
	}

	@And("^save the HSN record in business partner setup$")
	public void save_the_hsn_record_in_business_partner_setup() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_SaveButton(), 20,
				1);
		businessPartnerObj.businessPartner_SaveButton().click();
	}

	@And("^select the recently saved branch record$")
	public void select_the_recently_saved_branch_record() throws Throwable {
waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.branchSavedRecord(), 20, 1);
businessPartnerObj.branchSavedRecord().click();
	}

	@And("^click on address section$")
	public void click_on_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_Address().click();
	}

	@And("^enter the address type in address section$")
	public void enter_the_address_type_in_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_AddressType().click();
		businessPartnerObj.businessPartner_AddressType().sendKeys(busniessPartnerTestData.get("AddressType"));
		businessPartnerObj.businessPartner_AddressType().sendKeys(Keys.ENTER);
	}

	@And("^check the correspondence address$")
	public void check_the_correspondence_address() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_CorrenspondenceAddress().click();
	}

	@And("^enter the address line one in address section$")
	public void enter_the_address_line_one_in_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_AddressLine1().sendKeys(busniessPartnerTestData.get("AddressLine1"));
	}

	@And("^enter the address line two in address section$")
	public void enter_the_address_line_two_in_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_AddressLine2().sendKeys(busniessPartnerTestData.get("AddressLine2"));
	}

	@And("^enter the address line three in address section$")
	public void enter_the_address_line_three_in_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Address(), 20, 1);
		businessPartnerObj.businessPartner_AddressLine3().sendKeys(busniessPartnerTestData.get("AddressLine3"));
	}

	@And("^enter the country in address section$")
	public void enter_the_country_in_address_section() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Country(), 20, 1);
		businessPartnerObj.businessPartner_Country().click();
		businessPartnerObj.businessPartner_Country().sendKeys(busniessPartnerTestData.get("Country"));
		businessPartnerObj.businessPartner_Country().sendKeys(Keys.ENTER);
	}

	@And("^enter the state in address section$")
	public void enter_the_state_in_address_section() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_State(), 20, 1);
		businessPartnerObj.businessPartner_State().click();
		businessPartnerObj.businessPartner_State().sendKeys(busniessPartnerTestData.get("State"));
		Thread.sleep(500);
		businessPartnerObj.businessPartner_State().sendKeys(Keys.ENTER);
	}

	@And("^enter the city in address section$")
	public void enter_the_city_in_address_section() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_City(), 20, 1);
		businessPartnerObj.businessPartner_City().click();
		businessPartnerObj.businessPartner_City().sendKeys(busniessPartnerTestData.get("City"));
		Thread.sleep(500);
		businessPartnerObj.businessPartner_City().sendKeys(Keys.DOWN, Keys.ENTER);
	}

	@And("^enter the zip code in address section$")
	public void enter_the_zip_code_in_address_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ZipCode(), 20, 1);
		businessPartnerObj.businessPartner_ZipCode().sendKeys(busniessPartnerTestData.get("Zipcode"));

	}

	@And("^save the address details data$")
	public void save_the_address_details_data() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^enter the contact type in contact section$")
	public void enter_the_contact_type_in_contact_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Contact(), 20, 1);
		businessPartnerObj.businessPartner_Contact().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ContactType(), 20,
				1);
		businessPartnerObj.businessPartner_ContactType().sendKeys(busniessPartnerTestData.get("ContactType"));
		businessPartnerObj.businessPartner_ContactType().sendKeys(Keys.ENTER);
	}

	@And("^enter the contact persion in contact sectiobn$")
	public void enter_the_contact_persion_in_contact_sectiobn() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_ContactPerson(), 20,
				1);
		businessPartnerObj.businessPartner_ContactPerson().sendKeys(busniessPartnerTestData.get("ContactPerson"));

	}

	@And("^check the communication tab$")
	public void check_the_communication_tab() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartner_CommunicationContact(), 20, 1);
		businessPartnerObj.businessPartner_CommunicationContact().click();
	}

	@And("^enter the designation in contact section$")
	public void enter_the_designation_in_contact_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Designation(), 20,
				1);
		businessPartnerObj.businessPartner_Designation().sendKeys(busniessPartnerTestData.get("Designation"));
		businessPartnerObj.businessPartner_Designation().sendKeys(Keys.ENTER);
	}

	@And("^enter the mobile one in contact section$")
	public void enter_the_mobile_one_in_contact_section() throws Throwable {
		double mobileNo = Double.valueOf(busniessPartnerTestData.get("Mobile1"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Mobile1(), 20, 1);
		businessPartnerObj.businessPartner_Mobile1().sendKeys(String.format("%.0f", mobileNo));

	}

	@And("^enter the mobile two in contac section$")
	public void enter_the_mobile_two_in_contac_section() throws Throwable {

	}

	@And("^enter the phone one in contact section$")
	public void enter_the_phone_one_in_contact_section() throws Throwable {
		double phoneNo = Double.valueOf(busniessPartnerTestData.get("Phone1"));
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Phone1(), 20, 1);
		businessPartnerObj.businessPartner_Phone1().sendKeys(String.format("%.0f", phoneNo));
	}

	@And("^enter the phone two in contact section'$")
	public void enter_the_phone_two_in_contact_section() throws Throwable {

	}

	@And("^enter the emil one in contact section A$")
	public void enter_the_emil_one_in_contact_section_a() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartner_Email1(), 20, 1);
		businessPartnerObj.businessPartner_Email1().sendKeys(busniessPartnerTestData.get("Email1"));
	}

	@And("^enter the email two in contact section$")
	public void enter_the_email_two_in_contact_section() throws Throwable {

	}

	@And("^save the contact details section$")
	public void save_the_contact_details_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSaveButton(), 20, 1);
		kubsCommonObj.kubsSaveButton().click();
	}

	@And("^search the business partner module code in maker notification search$")
	public void search_the_business_partner_module_code_in_maker_notification_search() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSearchEventCode(), 20, 1);
		kubsCommonObj.kubsSearchEventCode().click();
		kubsCommonObj.kubsSearchEventCode().sendKeys(busniessPartnerTestData.get("ModuleCode").trim());
	}

	@And("^store the record reference number of business partner record in excel database$")
	public void store_the_record_reference_number_of_business_partner_record_in_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, businessPartnerObj.businessPartnerSetupReferenceNo(),
				20, 1);
		String referenceNo = businessPartnerObj.businessPartnerSetupReferenceNo().getText();
		excelData.updateTestData(busniessPartnerTestData.get("Data Set ID"), "Reference ID", referenceNo);
	}

	@And("^select the business partner record in maker notification$")
	public void select_the_business_partner_record_in_maker_notification() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				businessPartnerObj.businessPartnerSetupNotificationRecord(), 20, 1);
		businessPartnerObj.businessPartnerSetupNotificationRecord().click();

	}

	@And("^click on submit in business partner$")
	public void click_on_submit_in_business_partner() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsSubmitButton(), 20, 1);
		kubsCommonObj.kubsSubmitButton().click();
	}

	@And("^enter the alert remark in business partner record$")
	public void enter_the_alert_remark_in_business_partner_record() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertRemark(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertRemark());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertRemark());
		kubsCommonObj.kubsAlertRemark().sendKeys(busniessPartnerTestData.get("RemarkByMaker"));

	}

	@And("^click on alert submit in business partner$")
	public void click_on_alert_submit_in_business_partner() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertSubmit(), 20, 1);
		clicksAndActionsHelper.moveToElement(kubsCommonObj.kubsAlertSubmit());
		clicksAndActionsHelper.clickOnElement(kubsCommonObj.kubsAlertSubmit());
	}

	@Then("^store the reviewer ID in business partner excel database$")
	public void store_the_reviewer_id_in_business_partner_excel_database() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsToastAlert(), 60, 1);
		String reviewerID = kubsCommonObj.kubsToastAlert().getText().substring(85).replace(".", "");
		excelData.updateTestData(busniessPartnerTestData.get("Data Set ID"), "Reviewer ID", reviewerID);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCommonObj.kubsAlertClose(), 60, 1);
		kubsCommonObj.kubsAlertClose().click();
	}

	@Then("^verify approved business partner should reflect in maker list view$")
    public void verify_approved_business_partner_should_reflect_in_maker_list_view() throws Throwable {
       String xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span[contains(text(),'"+busniessPartnerTestData.get("UpdateBPName")+"')]";
       for(int i=0;i<=500;i++)
       {
    	   try
    	   {
    		   boolean bpStatus = driver.findElement(By.xpath(xpath)).isDisplayed();
    		   Assert.assertTrue(bpStatus);
    		   break;
    	   }
    	   catch(Exception e)
    	   {
    		   if(i==500)
    		   {
    			   Assert.fail(e.getMessage());
    		   }
    	   }
       }
       excelVendorContract.updateTestData("KUBS_FAT_UAT_001_002_01_D1", "BP_Name", busniessPartnerTestData.get("UpdateBPName"));
    }
}
