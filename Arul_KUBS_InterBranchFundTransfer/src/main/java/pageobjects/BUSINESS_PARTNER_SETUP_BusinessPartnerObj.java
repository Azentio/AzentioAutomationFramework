package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUSINESS_PARTNER_SETUP_BusinessPartnerObj {
	WebDriver driver;

	public BUSINESS_PARTNER_SETUP_BusinessPartnerObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Business Partner Setup //
	
	//Business Partner Setup menu
	@FindBy(xpath = "//ion-label[text()=' Business partner setup ']")
	private WebElement bUSINESS_PARTNER_SETUP_BusinessPartner_Menu;

	public WebElement bUSINESS_PARTNER_SETUP_BusinessPartner_Menu() {
		return bUSINESS_PARTNER_SETUP_BusinessPartner_Menu;
	}

	// eye button of Business partner
	@FindBy(xpath = "//div[1]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement businessPartner_EyeButton;

	public WebElement businessPartner_EyeButton() {
		return businessPartner_EyeButton;
	}

	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement businessPartner_AddButton;

	public WebElement businessPartner_AddButton() {
		return businessPartner_AddButton;
	}
	
	// BP Type
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_BPType;
	
	public WebElement businessPartner_BPType() {
		return businessPartner_BPType;
	}
	
	// BP Sub Type
	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_BPSubType;
	
	public WebElement businessPartner_BPSubType() {
		return businessPartner_BPSubType;
	}
	
	// Reference Type
	@FindBy(xpath = "//ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_ReferenceType;
	
	public WebElement businessPartner_ReferenceType() {
		return businessPartner_ReferenceType;
	}
	
	// Reference code no 
	@FindBy(xpath = "//ion-col[6]/ion-item/ion-input/input")
	private WebElement businessPartner_ReferenceCodeNumber;
	
	public WebElement businessPartner_ReferenceCodeNumber() {
		return businessPartner_ReferenceCodeNumber;
	}
	
	// Save Button 
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement businessPartner_SaveButton;
	
	public WebElement businessPartner_SaveButton() {
		return businessPartner_SaveButton;
	}
	
	// Save Button 
	@FindBy(xpath = "//page-business-partner-individual-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement businessPartner_IndividualSaveButton;
	
	public WebElement businessPartner_IndividualSaveButton() {
		return businessPartner_IndividualSaveButton;
	}
	
	// Gender 
	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_Gender;
	
	public WebElement businessPartner_Gender() {
		return businessPartner_Gender;
	}
	
	// BirthDate calender
	@FindBy(xpath = "//ion-col[3]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement businessPartner_BirthDateCalender;
	
	public WebElement businessPartner_BirthDateCalender() {
		return businessPartner_BirthDateCalender;
	}
	
	// BirthDate calender
	@FindBy(xpath = "//div/div/button")
	private WebElement businessPartner_SelectDate;
	
	public WebElement businessPartner_SelectDate() {
		return businessPartner_SelectDate;
	}
	

	//Click on next month 
	@FindBy(xpath = "//owl-date-time-calendar/div/button[2]")
	private WebElement  businessPartner_ClickOnNextMonth;
	
	public WebElement businessPartner_ClickOnNextMonth() {
		return businessPartner_ClickOnNextMonth;
	}
	
	//Click on previous month 
	@FindBy(xpath = "//button[@aria-label='Previous month']")
	private WebElement  businessPartner_ClickOnPreviousMonth;
	
	public WebElement businessPartner_ClickOnPreviousMonth() {
		return businessPartner_ClickOnPreviousMonth;
	}
	
	//Click on previous year 
	@FindBy(xpath = "//owl-date-time-multi-year-view/button[1]")
	private WebElement  businessPartner_ClickOnPreviousYear;
	
	public WebElement businessPartner_ClickOnPreviousYear() {
		return businessPartner_ClickOnPreviousYear;
	}
	
	//Click on next year 
	@FindBy(xpath = "//owl-date-time-multi-year-view/button[2]")
	private WebElement  businessPartner_ClickOnNextYear;
	
	public WebElement businessPartner_ClickOnNextYear() {
		return businessPartner_ClickOnNextYear;
	}
	
	//head year 
	@FindBy(xpath = "//tr/th")
	private WebElement  businessPartner_HeadYear;
	
	public WebElement businessPartner_HeadYear() {
		return businessPartner_HeadYear;
	}
	
	// FirstName
	@FindBy(xpath = "//ion-row[2]/ion-col[1]/ion-item/ion-input/input")
	private WebElement businessPartner_FirstName;
	
	public WebElement businessPartner_FirstName() {
		return businessPartner_FirstName;
	}
	
	// MiddleName
	@FindBy(xpath = "//ion-row[2]/ion-col[3]/ion-item/ion-input/input")
	private WebElement businessPartner_MiddleName;
	
	public WebElement businessPartner_MiddleName() {
		return businessPartner_MiddleName;
	}
	
	// LastName
	@FindBy(xpath = "//ion-row[2]/ion-col[5]/ion-item/ion-input/input")
	private WebElement businessPartner_LastName;
	
	public WebElement businessPartner_LastName() {
		return businessPartner_LastName;
	}
	
	// Profession
	@FindBy(xpath = "//ion-row[3]/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_Profession;
	
	public WebElement businessPartner_Profession() {
		return businessPartner_Profession;
	}
	
	// Blacklisted
	@FindBy(xpath = "//ion-row[3]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_Blacklisted;
	
	public WebElement businessPartner_Blacklisted() {
		return businessPartner_Blacklisted;
	}
	
	// KYC Status
	@FindBy(xpath = "//ion-row[3]/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_KYC_Status;
	
	public WebElement businessPartner_KYC_Status() {
		return businessPartner_KYC_Status;
	}
	
	// Remark
	@FindBy(xpath = "//ion-row[4]/ion-col[1]/ion-item/ion-input/input")
	private WebElement businessPartner_Remark;
	
	public WebElement businessPartner_Remark() {
		return businessPartner_Remark;
	}
	
	// ID Type
	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_ID_Type;
	
	public WebElement businessPartner_ID_Type() {
		return businessPartner_ID_Type;
	}
	
	// ID Number
	@FindBy(xpath = "//ion-row/ion-col[3]/ion-item/ion-input/input")
	private WebElement businessPartner_ID_Number;
	
	public WebElement businessPartner_ID_Number() {
		return businessPartner_ID_Number;
	}
	
	// BankAccount Details
	@FindBy(xpath = "//span[4]/ion-tab-button/ion-label")
	private WebElement businessPartner_BankAccountDetails;
	
	public WebElement businessPartner_BankAccountDetails() {
		return businessPartner_BankAccountDetails;
	}
	
	// Bank Name
	@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_BankName;
	
	public WebElement businessPartner_BankName() {
		return businessPartner_BankName;
	}
	
	// Branch Name
	@FindBy(xpath = "//ion-row[1]/ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_BranchName;
	
	public WebElement businessPartner_BranchName() {
		return businessPartner_BranchName;
	}
	
	// Account Type
	@FindBy(xpath = "//ion-row[2]/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_AccountType;
	
	public WebElement businessPartner_AccountType() {
		return businessPartner_AccountType;
	}
	
	// Account Number
	@FindBy(xpath = "//ion-row[2]/ion-col[2]/ion-item/ion-input/input")
	private WebElement businessPartner_AccountNumber;
	
	public WebElement businessPartner_AccountNumber() {
		return businessPartner_AccountNumber;
	}
	
	// Account Currency
	@FindBy(xpath = "//ion-row[2]/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_AccountCurrency;
	
	public WebElement businessPartner_AccountCurrency() {
		return businessPartner_AccountCurrency;
	}
	
	// Payment Account Indicator
	@FindBy(xpath = "//ion-row[3]/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartnerPaymentAccountIndicator;
	
	public WebElement businessPartnerPaymentAccountIndicator() {
		return businessPartnerPaymentAccountIndicator;
	}
	
	// Account Status
	@FindBy(xpath = "//ion-row[3]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_AccountStatus;
	
	public WebElement businessPartner_AccountStatus() {
		return businessPartner_AccountStatus;
	}
	
	// Bank Account Remark
	@FindBy(xpath = "//ion-row[5]/ion-col[1]/ion-item/ion-input/input")
	private WebElement businessPartner_BankAccountRemark;
	
	public WebElement businessPartner_BankAccountRemark() {
		return businessPartner_BankAccountRemark;
	}
	
	//HSN/SAC CodeMapping Details
	@FindBy(xpath = "//span[5]/ion-tab-button/ion-label")
	private WebElement businessPartner_CodeMappingDetails;

	public WebElement businessPartner_CodeMappingDetails() {
		return businessPartner_CodeMappingDetails;
	}
	
	//HSN Code
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_HSN_Code;
	
	public WebElement businessPartner_HSN_Code() {
		return businessPartner_HSN_Code;
	}
	
	//HSN Code Remark
	@FindBy(xpath = "//textarea")
	private WebElement businessPartner_HSN_CodeRemark;
	
	public WebElement businessPartner_HSN_CodeRemark() {
		return businessPartner_HSN_CodeRemark;
	}
	
	//Business partner Details
	@FindBy(xpath = "//span[1]/ion-tab-button/ion-label")
	private WebElement businessPartner_BusinessPartnerDetails;
	
	public WebElement businessPartner_BusinessPartnerDetails() {
		return businessPartner_BusinessPartnerDetails;
	}
	
	//Individual Details
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement businessPartner_IndividualDetails;
	
	public WebElement businessPartner_IndividualDetails() {
		return businessPartner_IndividualDetails;
	}
	
	//Address
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement businessPartner_Address;
	
	public WebElement businessPartner_Address() {
		return businessPartner_Address;
	}
	
	//Address Type
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_AddressType;
	
	public WebElement businessPartner_AddressType() {
		return businessPartner_AddressType;
	}
	
	// Correnspondence Address 
	@FindBy(xpath = "//ion-col[3]/ion-item/ion-checkbox")
	private WebElement businessPartner_CorrenspondenceAddress;
	
	public WebElement businessPartner_CorrenspondenceAddress() {
		return businessPartner_CorrenspondenceAddress;
	}
	
	// Address Line1
	@FindBy(xpath = "//ion-row[1]/ion-col[4]/ion-item/ion-input/input")
	private WebElement businessPartner_AddressLine1;
	
	public WebElement businessPartner_AddressLine1() {
		return businessPartner_AddressLine1;
	}
	
	// Address Line2
	@FindBy(xpath = "//ion-row[1]/ion-col[6]/ion-item/ion-input/input")
	private WebElement businessPartner_AddressLine2;
	
	public WebElement businessPartner_AddressLine2() {
		return businessPartner_AddressLine2;
	}
	
	// Address Line3
	@FindBy(xpath = "//ion-row[1]/ion-col[8]/ion-item/ion-input/input")
	private WebElement businessPartner_AddressLine3;
	
	public WebElement businessPartner_AddressLine3() {
		return businessPartner_AddressLine3;
	}
	
	// Country
	@FindBy(xpath = "//ion-row[1]/ion-col[10]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_Country;
	
	public WebElement businessPartner_Country() {
		return businessPartner_Country;
	}
	
	// State
	@FindBy(xpath = "//ion-row[1]/ion-col[11]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_State;
	
	public WebElement businessPartner_State() {
		return businessPartner_State;
	}
	
	// City
	@FindBy(xpath = "//ion-row[1]/ion-col[12]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_City;
	
	public WebElement businessPartner_City() {
		return businessPartner_City;
	}
	
	// Zipcode
	@FindBy(xpath = "//ion-row[1]/ion-col[13]/ion-item/ion-input/input")
	private WebElement businessPartner_ZipCode;
	
	public WebElement businessPartner_ZipCode() {
		return businessPartner_ZipCode;
	}
	
	// previous button in individual
	@FindBy(xpath = "//ion-toolbar/ion-buttons[1]/ion-button[1]")
	private WebElement businessPartner_PreviousButton;
	
	public WebElement businessPartner_PreviousButton() {
		return businessPartner_PreviousButton;
	}
	
	//Contact
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[2])[2]")
	private WebElement businessPartner_Contact;
	
	public WebElement businessPartner_Contact() {
		return businessPartner_Contact;
	}
	
	//Contact Type
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_ContactType;
	
	public WebElement businessPartner_ContactType() {
		return businessPartner_ContactType;
	}
	
	//Contact Person
	@FindBy(xpath = "//ion-row[1]/ion-col[3]/ion-item/ion-input/input")
	private WebElement businessPartner_ContactPerson;
	
	public WebElement businessPartner_ContactPerson() {
		return businessPartner_ContactPerson;
	}
	
	// Communication Contact
	@FindBy(xpath = "//ion-col[5]/ion-item/ion-checkbox")
	private WebElement businessPartner_CommunicationContact;
	
	public WebElement businessPartner_CommunicationContact() {
		return businessPartner_CommunicationContact;
	}
	
	// Designation
	@FindBy(xpath = "//ion-row[1]/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement businessPartner_Designation;
	
	public WebElement businessPartner_Designation() {
		return businessPartner_Designation;
	}
	
	// Mobile1
	@FindBy(xpath = "//ion-row[1]/ion-col[7]/ion-item/ion-input/input")
	private WebElement businessPartner_Mobile1;
	
	public WebElement businessPartner_Mobile1() {
		return businessPartner_Mobile1;
	}
	
	// Mobile2
	@FindBy(xpath = "//ion-row[1]/ion-col[8]/ion-item/ion-input/input")
	private WebElement businessPartner_Mobile2;
	
	public WebElement businessPartner_Mobile2() {
		return businessPartner_Mobile2;
	}
	
	// Phone1
	@FindBy(xpath = "//ion-row[1]/ion-col[9]/ion-item/ion-input/input")
	private WebElement businessPartner_Phone1;
	
	public WebElement businessPartner_Phone1() {
		return businessPartner_Phone1;
	}
	
	// Phone2
	@FindBy(xpath = "//ion-row[1]/ion-col[10]/ion-item/ion-input/input")
	private WebElement businessPartner_Phone2;
	
	public WebElement businessPartner_Phone2() {
		return businessPartner_Phone2;
	}
	
	// Email1
	@FindBy(xpath = "//ion-row[1]/ion-col[11]/ion-item/ion-input/input")
	private WebElement businessPartner_Email1;
	
	public WebElement businessPartner_Email1() {
		return businessPartner_Email1;
	}
	
	// Email2
	@FindBy(xpath = "//ion-row[1]/ion-col[12]/ion-item/ion-input/input")
	private WebElement businessPartner_Email2;
	
	public WebElement businessPartner_Email2() {
		return businessPartner_Email2;
	}
	

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement businessPartner_RemarkField;

	public WebElement businessPartner_RemarkField() {
		return businessPartner_RemarkField;
	}
	
	// Search icon
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-item[1]/ion-icon[1]")
	private WebElement businessPartner_Search;

	public WebElement businessPartner_Search() {
		return businessPartner_Search;
	}

	// Search new vendor details by reference code number
	@FindBy(xpath = "//datatable-header-cell[6]/div/ion-input/input")
	private WebElement businessPartner_ReferenceCodeNumberSearch;

	public WebElement businessPartner_ReferenceCodeNumberSearch() {
		return businessPartner_ReferenceCodeNumberSearch;
	}

	// vendor details
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/span")
	private WebElement businessPartner_VendorDetails;

	public WebElement businessPartner_VendorDetails() {
		return businessPartner_VendorDetails;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
