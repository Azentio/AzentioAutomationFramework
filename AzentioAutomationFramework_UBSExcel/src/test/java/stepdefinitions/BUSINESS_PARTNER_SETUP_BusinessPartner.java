package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType;

public class BUSINESS_PARTNER_SETUP_BusinessPartner {

	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(
			driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(path, "BusinessPartnerTestData", "Data Set ID");
	Map<String, String> testData;

	@And("^user should navigate to business partner setup menu$")
	public void user_should_navigate_to_business_partner_setup_menu() {
		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu().click();
	}

	@When("^click on eye button of business partner$")
	public void click_on_eye_button_of_business_partner() {
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_EyeButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_EyeButton().click();
		;
	}

	@And("^click on add button of business partner$")
	public void click_on_add_button_of_business_partner() {
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
		;

	}

	@And("^Fill the required fields to create a vendor$")
	public void fill_the_required_fields_to_create_a_vendor() throws InterruptedException {
		Random random = new Random();
		int randomNum = random.nextInt(1000 - 1) + 1;
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType().sendKeys(testData.get("BP_Type"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType().sendKeys(Keys.ENTER);

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().click();
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().sendKeys(testData.get("BP_SubType"));

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType()
				.sendKeys(testData.get("ReferenceType"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumber());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumber()
				.sendKeys(testData.get("ReferenceCodeNumber"));

		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();

		javascripthelper.JavaScriptHelper(driver);
//		String str = javascripthelper.executeScript(
//				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//				.toString();
//		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BirthDateCalender());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BirthDateCalender().click();

		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("BirthYear") + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testData.get("BirthMonth") + "']")).click();
		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("BirthFullMonth") + " "
						+ testData.get("BirthDate") + ", " + testData.get("BirthYear") + "']")));
		driver.findElement(By.xpath("//td[@aria-label='" + testData.get("BirthFullMonth") + " "
				+ testData.get("BirthDate") + ", " + testData.get("BirthYear") + "']")).click();
		javascripthelper.JavaScriptHelper(driver);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender().sendKeys(testData.get("Gender"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender().sendKeys(Keys.DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_FirstName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_FirstName()
				.sendKeys(testData.get("FirstName") + randomNum);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_MiddleName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_MiddleName().sendKeys("MiddleName");

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_LastName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_LastName().sendKeys(testData.get("LastName"));

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession().sendKeys(testData.get("Profession"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted().sendKeys(testData.get("Blacklisted"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status().sendKeys(testData.get("KYC_Status"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Remark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Remark().sendKeys(testData.get("Remarks"));

		waithelper.waitForElement(driver, 3000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualSaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualSaveButton().click();

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();

		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type().sendKeys(testData.get("ID_Type"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type().sendKeys(Keys.ENTER);
		double idNumber = Double.valueOf(testData.get("ID_Number"));
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Number());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Number().sendKeys(String.format("%.0f", idNumber));

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();

		for (int i = 0; i <= 500; i++) {
			try {
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountDetails().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 500; i++) {
			try {
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName().sendKeys(testData.get("BankName"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName().sendKeys(Keys.ENTER);

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().sendKeys(testData.get("BranchName"));

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType().sendKeys(testData.get("AccountType"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountNumber());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountNumber()
				.sendKeys(testData.get("AccountNumber"));

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency()
				.sendKeys(testData.get("AccountCurrency"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator()
				.sendKeys(testData.get("PaymentAccountIndicator"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus()
				.sendKeys(testData.get("AccountStatus"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountRemark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountRemark()
				.sendKeys(testData.get("BankDetailRemark"));

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();

		for (int i = 0; i <= 500; i++) {
			try {

				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CodeMappingDetails().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <= 600; i++) {
			try {
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
				break;
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().sendKeys(testData.get("HSN_Code"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_CodeRemark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_CodeRemark()
				.sendKeys(testData.get("HSN_CodeRemark"));

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();

		for (int i = 0; i <= 500; i++) {
			try {
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualDetails().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Address());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Address().click();
		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().click();
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().sendKeys(testData.get("AddressType"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CorrenspondenceAddress());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CorrenspondenceAddress().click();

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine1().sendKeys(testData.get("AddressLine1"));

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine2());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine2().sendKeys(testData.get("AddressLine2"));

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine3());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine3().sendKeys(testData.get("AddressLine3"));

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().sendKeys(testData.get("Country"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().sendKeys(Keys.ENTER);

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().sendKeys(testData.get("State"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().sendKeys(Keys.ENTER);

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().sendKeys(testData.get("City"));

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ZipCode());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ZipCode().sendKeys(testData.get("Zipcode"));

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_PreviousButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_PreviousButton().click();

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Contact());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Contact().click();

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType().sendKeys(testData.get("ContactType"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactPerson());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactPerson()
				.sendKeys(testData.get("ContactPerson"));

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CommunicationContact());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CommunicationContact().click();

		waithelper.waitForElement(driver, 2000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation().sendKeys(testData.get("Designation"));
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation().sendKeys(Keys.ENTER);
		double mobileNo = Double.valueOf(testData.get("Mobile1"));
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile1().sendKeys(String.format("%.0f", mobileNo));

//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile2();

		double phoneNo = Double.valueOf(testData.get("Phone1"));
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone1().sendKeys(String.format("%.0f", phoneNo));

//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone2();

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email1().sendKeys(testData.get("Email1"));

//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email2();

		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());

		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		for (int i = 0; i <= 500; i++) {
			try {
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BusinessPartnerDetails().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@Then("^Save and submit the record to create vendor$")
	public void save_and_submit_the_record_to_create_vendor() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();

		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId());
		String id = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId().getText();

		excelData.updateTestData("KUBS_FAT_UAT_001_01_D1", "Reference ID", id);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_01_D1");
		// jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
				System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000,
						fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton());
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + jsonWriter.readReferancedata() + after_xpath)).click();

		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();

		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
		javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(testData.get("RemarkByMaker"));

		waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();

		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
		WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);

		String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
		System.out.println(message);
		fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
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
		// jsonWriter=new JsonDataReaderWriter();
		// jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_FAT_UAT_001_01_D1", "Reviewer ID", reviewerId);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_01_D1");
	}

	@Then("^click on search button$")
	public void click_on_search_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Search(), 60, 1);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Search().click();
	}

	@Then("^search bp details by reference code number$")
	public void search_bp_details_by_reference_code_number() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumberSearch(), 20, 1);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumberSearch()
				.sendKeys(testData.get("ReferenceCodeNumber"));

	}

	@And("^bp details should display on business partner list view$")
	public void bp_details_should_display_on_business_partner_list_view() {
		waithelper.waitForElement(driver, 3000,
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails());
//    	boolean vendorDetails = bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails().isDisplayed();
		boolean vendorDetails = bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails()
				.equals(testData.get("ReferenceCodeNumber"));
		System.out.println("Vendor details is displayed in BP Details list view - " + vendorDetails);
	}

	@And("^approve the record by the reviewer user1$")
	public void approve_the_record_by_the_reviewer_user1() throws InterruptedException, IOException {
		browserHelper = new BrowserHelper(driver);
		String before_xpath = "//datatable-row-wrapper[";
		String after_xpath = "]/datatable-body-row/div/datatable-body-cell[2]";
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";

		for (int i = 1; i < 10; i++) {
			// waithelper.waitForElement(driver, 10000,
			// driver.findElement(By.xpath(before_xpath + i + after_xpath)));
			for (int j = 0; j < 30; j++) {
				try {
					String referance_id = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
					break;
				} catch (Exception e) {

				}
			}

			waithelper.waitForElement(driver, 10000,
					driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)));
			driver.findElement(By.xpath(before_xpath + i + after_xpath_for_action)).click();

			// reader.addReferanceData(referance_id);

			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark());
			aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_ApprovedByReviewerRemark()
					.sendKeys(testData.get("ApprovedByReviewer"));
			waithelper.waitForElement(driver, 4000,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				(2000);
//				waithelper.waitForElement(driver, 10000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			waithelper.waitForElementwithFluentwait(driver,
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			clicksAndActionHelper.moveToElement(recordstatus);
			String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			System.out.println(message);
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			break;
		}
	}

	@And("^User should go to the kubs url and login as a reviewer user1$")
	public void user_should_go_to_the_kubs_url_and_login_as_a_reviewer_user()
			throws IOException, ParseException, InterruptedException {

		// testData = excelData.getTestdata("KUBS_FAT_UAT_001_002_01_D1");
		// reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));

	}

	@Then("^checker should approved the contract record1$")
	public void checker_should_approved_the_contract_record() throws IOException, ParseException, InterruptedException {
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));

		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"
				+ testData.get("Reference ID")
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID")
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
//		(2000);
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata()
//		+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//		driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
//		.click();

//		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerRemark"));
//		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}

	@And("^Get the test data for the business partner test case01$")
	public void get_the_test_data_for_the_business_partner_test_case01() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_01_D1");
	}

	@And("^Get the test data for the business partner test case04$")
	public void get_the_test_data_for_the_business_partner_test_case04() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_04_D1");
	}

	@And("^Get the test data for the business partner test case02$")
	public void get_the_test_data_for_the_business_partner_test_case02() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_02_D1");
	}

	@And("^Get the test data for the business partner test case03$")
	public void get_the_test_data_for_the_business_partner_test_case03() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_03_D1");
	}

}
