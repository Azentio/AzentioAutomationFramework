package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSETS_AssetSaleObj {
	WebDriver driver;

	public FIXEDASSETS_AssetSaleObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	ASSET SALE SUBMODULE  //

	// Direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAssets_AssetSale_DirectionButton;

	public WebElement fixedAssets_AssetSale_DirectionButton() {
		return fixedAssets_AssetSale_DirectionButton;
	}

	// Fixed Asset menu
	@FindBy(xpath = "//ion-label[text()=' Fixed assets ']/preceding-sibling::ion-icon")
	private WebElement fixedAssets_Menu;

	public WebElement fixedAssets_Menu() {
		return fixedAssets_Menu;
	}

	// eye button of Asset Sale
	@FindBy(xpath = "//div[6]//ion-menu-toggle[4]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetSale_EyeButton;

	public WebElement fixedAssets_AssetSale_EyeButton() {
		return fixedAssets_AssetSale_EyeButton;
	}
	
	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetSale_AddButton;

	public WebElement fixedAssets_AssetSale_AddButton() {
		return fixedAssets_AssetSale_AddButton;
	}
	
	// Asset Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetSale_AssetReferenceNumber;
	
	public WebElement fixedAssets_AssetSale_AssetReferenceNumber() {
		return fixedAssets_AssetSale_AssetReferenceNumber;
	}
	
	// Item Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetSale_ItemNumber;
	
	public WebElement fixedAssets_AssetSale_ItemNumber() {
		return fixedAssets_AssetSale_ItemNumber;
	}
	
	// Sale Value
	@FindBy(xpath = "//ion-col[11]/ion-item/input")
	private WebElement fixedAssets_AssetSale_SaleValue;
	
	public WebElement fixedAssets_AssetSale_SaleValue() {
		return fixedAssets_AssetSale_SaleValue;
	}
	
	// Book Value
	@FindBy(xpath = "//ion-col[9]/ion-item/input")
	private WebElement fixedAssets_AssetSale_BookValue;
	
	public WebElement fixedAssets_AssetSale_BookValue() {
		return fixedAssets_AssetSale_BookValue;
	}
	
	// Profit on sale GL
	@FindBy(xpath = "//ion-col[13]/ion-item/input")
	private WebElement fixedAssets_AssetSale_ProfitOnSaleGL;
	
	public WebElement fixedAssets_AssetSale_ProfitOnSaleGL() {
		return fixedAssets_AssetSale_ProfitOnSaleGL;
	}
	
	// Loss on sale GL
	@FindBy(xpath = "//ion-col[14]/ion-item/input")
	private WebElement fixedAssets_AssetSale_LossOnSaleGL;
	
	public WebElement fixedAssets_AssetSale_LossOnSaleGL() {
		return fixedAssets_AssetSale_LossOnSaleGL;
	}
	
	// Currency
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[12]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement fixedAssets_AssetSale_Currency;
	
	public WebElement fixedAssets_AssetSale_Currency() {
		return fixedAssets_AssetSale_Currency;
	}
	
	// Actionable By
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[15]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetSale_ActionableBy;
	
	public WebElement fixedAssets_AssetSale_ActionableBy() {
		return fixedAssets_AssetSale_ActionableBy;
	}
	
//	// Username
//	@FindBy(xpath = "//ion-col[16]/app-kub-display-field/ion-item/ion-input/input")
//	private WebElement fixedAssets_AssetSale_Username;
//	
//	public WebElement fixedAssets_AssetSale_Username() {
//		return fixedAssets_AssetSale_Username;
//	}
	
	//Remark
	@FindBy(xpath = "//ion-col[17]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetSale_Remark;
	
	public WebElement fixedAssets_AssetSale_Remark() {
		return fixedAssets_AssetSale_Remark;
	}
	
	// Save
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetSale_Save;
	
	public WebElement fixedAssets_AssetSale_Save() {
		return fixedAssets_AssetSale_Save;
	}

	//Notification Button
	@FindBy(xpath = "//ion-buttons[2]/ion-button[2]")
	private WebElement  fixedAssets_AssetSale_NotificationButton;
	
	public WebElement fixedAssets_AssetSale_NotificationButton() {
		return fixedAssets_AssetSale_NotificationButton;
	}

	// FirstReferenceID
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
	private WebElement fixedAssets_AssetSale_FirstReferenceId;

	public WebElement fixedAssets_AssetSale_FirstReferenceId() {
		return fixedAssets_AssetSale_FirstReferenceId;
	}

	// Maker Notification NextButton
	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement fixedAssets_AssetSale_NotificationNextButton;

	public WebElement fixedAssets_AssetSale_NotificationNextButton() {
		return fixedAssets_AssetSale_NotificationNextButton;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement fixedAssets_AssetSale_SubmitButton;

	public WebElement fixedAssets_AssetSale_SubmitButton() {
		return fixedAssets_AssetSale_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement fixedAssets_AssetSale_RemarkField;

	public WebElement fixedAssets_AssetSale_RemarkField() {
		return fixedAssets_AssetSale_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement fixedAssets_AssetSale_Submit;

	public WebElement fixedAssets_AssetSale_Submit() {
		return fixedAssets_AssetSale_Submit;
	}

	// record status
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement fixedAssets_AssetSale_RecordStatus;

	public WebElement fixedAssets_AssetSale_RecordStatus() {
		return fixedAssets_AssetSale_RecordStatus;
	}
	
	// First eye button [To view Earned Profit]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement fixedAssets_AssetSale_ViewEarnedProfitEyeButton;
	
	public WebElement fixedAssets_AssetSale_ViewEarnedProfitEyeButton() {
		return fixedAssets_AssetSale_ViewEarnedProfitEyeButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
