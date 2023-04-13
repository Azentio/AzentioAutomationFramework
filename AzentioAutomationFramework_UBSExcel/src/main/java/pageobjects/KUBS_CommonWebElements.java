package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KUBS_CommonWebElements {
	WebDriver driver;

	public KUBS_CommonWebElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Submit']//ancestor::ion-button")
	private WebElement kubs_SubmitButton;

	public WebElement kubsSubmitButton() {
		return kubs_SubmitButton;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Please enter remark')]//following-sibling::ion-textarea//textarea")
	private WebElement kubs_AlertRemark;

	public WebElement kubsAlertRemark() {
		return kubs_AlertRemark;
	}

	@FindBy(xpath = "//ion-button[text()='Submit']")
	private WebElement kubs_AlertSubmit;

	public WebElement kubsAlertSubmit() {
		return kubs_AlertSubmit;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[1]")
	private WebElement kubs_ToastAlert;

	public WebElement kubsToastAlert() {
		return kubs_ToastAlert;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement kubs_AlertClose;

	public WebElement kubsAlertClose() {
		return kubs_AlertClose;
	}

	@FindBy(xpath = "//ion-button[@routerlink='/inbox']")
	private WebElement kubs_NotificationIcon;

	public WebElement kubsNotificationIcon() {
		return kubs_NotificationIcon;
	}

	@FindBy(xpath = "//span[text()='Approve']//ancestor::ion-button")
	private WebElement kubs_ApproveButton;

	public WebElement kubsApproveButton() {
		return kubs_ApproveButton;
	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='save']//ancestor::ion-button")
	private WebElement kubs_SaveButton;

	public WebElement kubsSaveButton() {
		return kubs_SaveButton;
	}

	@FindBy(xpath = "//ion-segment//ion-segment-button[1]")
	private WebElement kubs_ConfigurationSection;

	public WebElement kubsConfigurationSection() {
		return kubs_ConfigurationSection;
	}

	@FindBy(xpath = "//ion-segment//ion-segment-button[2]")
	private WebElement kubs_TransactionSection;

	public WebElement kubsTransactionSection() {
		return kubs_TransactionSection;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-item[1]/ion-icon[1]")
	private WebElement kubs_ListViewSerachIcon;

	public WebElement kubsListViewSearchIcon() {
		return kubs_ListViewSerachIcon;
	}

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	private WebElement kubs_CalendarMonthAndYear;

	public WebElement kubsMonthAndYear() {
		return kubs_CalendarMonthAndYear;
	}

	@FindBy(xpath = "//app-inbox//ion-icon[@name='search']")
	private WebElement kubsNotification_SearchButton;

	public WebElement kubsNotificationSearchButton() {
		return kubsNotification_SearchButton;
	}

	@FindBy(xpath = "//input[@placeholder='Search eventCode']")
	private WebElement kubsSearch_EventCode;

	public WebElement kubsSearchEventCode() {
		return kubsSearch_EventCode;
	}

	@FindBy(xpath = "//ion-icon[@name='search']")
	private WebElement kubs_ListViewSearchButton;

	public WebElement kubsListViewSearchButton() {
		return kubs_ListViewSearchButton;
	}

	@FindBy(xpath = "//div[contains(text(),'YES')]//ancestor::button")

	private WebElement kubs_TransferRadioButton;

	public WebElement kubsTransferRadioButton() {
		return kubs_TransferRadioButton;
	}
	@FindBy(xpath = "//span[contains(text(),'OK')]//parent::button")
	private WebElement kubs_TransferOkButton;

	public WebElement kubsTransferOkButton() {
		return kubs_TransferOkButton;
	}
	@FindBy(xpath="//ng-dropdown-panel//div[text()='No items found']")
	private WebElement kubs_DropdownNoItemFound;
	public WebElement kubsDropdownNoItemFound()
	{
		return kubs_DropdownNoItemFound;
	}
	@FindBy(xpath="//ion-toolbar//ion-button[4]")
	private WebElement kubs_UserProfileButton;
	public WebElement kubsUserProfileButton()
	{
		return kubs_UserProfileButton;
	}
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement kubs_LogoutButton;
	public WebElement kubsLogoutButton()
	{
		return kubs_LogoutButton;
	}
	@FindBy(xpath="//p[text()='User ID']")
	private WebElement kubs_LogoutVerification;
	public WebElement kubsLogoutVerification()
	{
		return kubs_LogoutVerification;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Transaction reports')]")
	private WebElement kubs_TransactionReportMainModule;
	public WebElement kubs_TransactionReportMainModule()
	{
		return kubs_TransactionReportMainModule;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset impairement loss booking report ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_ImapirementReportTempView;
	public WebElement kubsImapirementReportTempView()
	{
		return kubs_ImapirementReportTempView;
	}
	@FindBy(xpath="//a[contains(text(),'View')]")
	private WebElement kubs_ReportViewButton;
	public WebElement kubsReportViewButton()
	{
		return kubs_ReportViewButton;
	}
	@FindBy(xpath="//button[@aria-label='Choose month and year']")
	private WebElement kubs_calendarMonthYearOption;

	public WebElement kubsCalendarMonthYearOption() {
		return kubs_calendarMonthYearOption;
	}
	@FindBy(xpath="//ion-toolbar//ion-buttons//span[1]")
	private WebElement kUBS_SystemDate;

	public WebElement kUBSSystemDate() {
		return kUBS_SystemDate;
	}
	@FindBy(xpath="(//ion-label[contains(text(),' Reports ')])[1]")
	private WebElement kubs_ReportsMainModule;

	public WebElement kubsReportsMainModule() {
		return kubs_ReportsMainModule;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Contract report ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_ContractReportTempView;

	public WebElement kubsContractReportTempView() {
		return kubs_ContractReportTempView;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset creation item ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_AssetCreationItemReport;

	public WebElement kubsAssetCreationItemReport() {
		return kubs_AssetCreationItemReport;
	}
	@FindBy(xpath="//input[@title='Next page']")
	private WebElement kubs_ReportNextButton;

	public WebElement kubsReportNextButton() {
		return kubs_ReportNextButton;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset codes report ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_AssetCodeReportTempView;

	public WebElement kubsAssetCodeReportTempView() {
		return kubs_AssetCodeReportTempView;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset gl report ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_AssetGlReportTempView;

	public WebElement kubsAssetGlReportTempView() {
		return kubs_AssetGlReportTempView;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement kubs_AssetGlAsOnDate;

	public WebElement kubs_AssetGlAsOnDate() {
		return kubs_AssetGlAsOnDate;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset creation common ')]//ancestor::ion-item//ion-button")
	private WebElement kubs_AssetAssetCreationCommonReportTempView;

	public WebElement kubsAssetAssetCreationCommonReportTempView() {
		return kubs_AssetAssetCreationCommonReportTempView;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset sale ')]//parent::ion-item//ion-button")
	private WebElement kubs_AssetSaleReportTempView;

	public WebElement kubsAssetSaleReportTempView() {
		return kubs_AssetSaleReportTempView;
	}
	@FindBy(xpath="//div[contains(text(),'No items found')]")
	private WebElement kubs_DropdownNoItemFoundOption;

	public WebElement kubsDropdownNoItemFoundOption() {
		return kubs_DropdownNoItemFoundOption;
	}
	@FindBy(xpath="(//ng-dropdown-panel//div[2]//span[1])[1]")
	private WebElement kubs_DropdownnElementValidation;

	public WebElement kubsDropdownnElementValidation() {
		return kubs_DropdownnElementValidation;
	}
	
}
