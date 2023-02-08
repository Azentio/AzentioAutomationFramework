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

	@FindBy(xpath = "//textarea")
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

	@FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement kubs_AlertClose;

	public WebElement kubsAlertClose() {
		return kubs_AlertClose;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
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

	@FindBy(xpath = "//app-inbox[1]//ion-toolbar[1]/ion-buttons[2]//ion-icon")
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

	@FindBy(xpath = "//ion-label[text()=' YES ']//following-sibling::ion-radio")

	private WebElement kubs_TransferRadioButton;

	public WebElement kubsTransferRadioButton() {
		return kubs_TransferRadioButton;
	}
	@FindBy(xpath="//ng-dropdown-panel//div[text()='No items found']")
	private WebElement kubs_DropdownNoItemFound;
	public WebElement kubsDropdownNoItemFound()
	{
		return kubs_DropdownNoItemFound;
	}
	@FindBy(xpath="//button[@aria-label='Choose month and year']")
	private WebElement kubs_calendarMonthYearOption;

	public WebElement kubsCalendarMonthYearOption() {
		return kubs_calendarMonthYearOption;
	}
}
