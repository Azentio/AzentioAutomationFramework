package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_BusinessPartnerConfigurationObj {
	WebDriver driver;

	public ARAP_BusinessPartnerConfigurationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/146']")
	private WebElement businessPartner_config_eyeIcon;

	public WebElement businessPartnerConfigEyeIcon() {
		return businessPartner_config_eyeIcon;
	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement businessPartner_addbutton;

	public WebElement businessPartnetAddButton() {
		return businessPartner_addbutton;
	}

	@FindBy(xpath = "//ion-col[3]//input")
	private WebElement businessPartnerConfig_BpType;

	public WebElement businessPartnerConfigBpType() {
		return businessPartnerConfig_BpType;
	}
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement businessPartnerConfig_BpSubType;
	public WebElement businessPartnetConfigBpSubType()
	{
		return businessPartnerConfig_BpSubType;
	}
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement businessPartnerConfig_ReferenceType;
	public WebElement businessPartnetConfigReferenceType()
	{
		return businessPartnerConfig_ReferenceType;
	}
	@FindBy(xpath="//ion-col[6]//input")
	private WebElement businessPartnerConfig_ReferenceNumber;
	public WebElement businessPartnerConfigReferenceNumber()
	{
		return businessPartnerConfig_ReferenceNumber;
	}
	@FindBy(xpath="(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement businessPartnerConfig_saveButton;
	public WebElement businessPartnerConfigSaveButton()
	{
		return businessPartnerConfig_saveButton;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement businessPartnerConfig_BpName;
	public WebElement businessPartnerConfigBpName()
	{
		return businessPartnerConfig_BpName;
	}
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement businessPartner_RegisterNumber;
	public WebElement businessPartnerRegisterNumber()
	{
		return businessPartner_RegisterNumber;
	}
	@FindBy(xpath="//ion-col[7]//input")
	private WebElement businessPartner_countryRegion;
	public WebElement businessPartnerCountryRegion()
	{
		return businessPartner_countryRegion;
	}
	@FindBy(xpath="//ion-col[11]//input")
    private WebElement businessPartner_industry;
	public WebElement businessPartnerIndustry()
	{
		return businessPartner_industry;
	}
	@FindBy(xpath="//ion-col[14]//input")
	private WebElement businessPartner_KYC;
	public WebElement businessPartnerKYC()
	{
		return businessPartner_KYC;
		
		
	}
	@FindBy(xpath="//ion-col[15]//input")
	private WebElement businessPartner_BlackList;
	public WebElement businessPartnerBlackList()
	{
		return businessPartner_BlackList;
	}
	@FindBy(xpath="//ion-tab-bar/span[3]")
	private WebElement businessPartnerConfig_BranchTab;
	public WebElement businessPartnerConfigBranchTab()
	{
		return businessPartnerConfig_BranchTab;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[3]//input")
	private WebElement businessPartner_Branch_BranchCode;
	public WebElement buinessPartnerBranchBranchCode()
	{
		return businessPartner_Branch_BranchCode;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[4]//input")
	private WebElement businessPartner_BrachType;
	public WebElement businessPartnerBranchBranchType()
	{
		return businessPartner_BrachType;
		
	}
	@FindBy(xpath="//ion-row[2]/ion-col[1]//input")
	private WebElement businessPartner_branch_branchName;
	public WebElement businessPartnerBranchBranchName()
	{
		return businessPartner_branch_branchName;
	}
	@FindBy(xpath="//ion-row[3]/ion-col[4]//input")
	private WebElement businessPartner_branch_phoneNumber;
	public WebElement businessPartnerBranchPhoneNumber()
	{
		return businessPartner_branch_phoneNumber;
	}
	@FindBy(xpath="//ion-row[3]/ion-col[5]//input")
	private WebElement businessPartner_branch_email;
	public WebElement businessPartnerBranchEmail()
	{
		return businessPartner_branch_email;
	}
	@FindBy(xpath="//ion-tab-bar/span[4]")
	private WebElement businessPartner_identificationTab;
	public WebElement businessPartner_IdentificationBar()
	{
		return businessPartner_identificationTab;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[2]//input")
	private WebElement businessPartner_Identification_Idtype;
	public WebElement businessPartnerIdentificationIDType()
	{
		return businessPartner_Identification_Idtype;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[3]//input")
	private WebElement businessPartner_Identification_IDNumber;
	public WebElement businessPartnerIdentificationIDNumber()
	{
		return businessPartner_Identification_IDNumber;
	}
	@FindBy(xpath="//ion-tab-bar/span[5]")
	private WebElement businessPartner_BankAccount;
	public WebElement businessPartnerBankAccount()
	{
		return businessPartner_BankAccount;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[3]//input")
	private WebElement businessPartner_BankName;
	public WebElement businessPartnerBankName()
	{
		return businessPartner_BankName;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[4]//input")
	private WebElement businessPartner_BankAccount_BranchName;
	public WebElement businessPartnerBankAccountBranchName()
	{
		return businessPartner_BankAccount_BranchName;
	}
	@FindBy(xpath="//ion-row[2]/ion-col[1]//input")
	private WebElement businessPartner_BankAccount_AccountType;
	public WebElement businessPartnerBankAccountAccountType()
	{
		return businessPartner_BankAccount_AccountType;
	}
	@FindBy(xpath="//ion-row[2]/ion-col[2]//input")
	private WebElement businessPartner_BankAccount_AccountNo;
	public WebElement businessPartnerBankAccountAccountNo()
	{
	 return businessPartner_BankAccount_AccountNo;
	}
	/*@FindBy(xpath="//ion-row[2]/ion-col[3]//input")
	private WebElement businessPartner_BankAccount_*/
}
