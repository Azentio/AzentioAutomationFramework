package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSETS_AssetUndertakingObj {
	WebDriver driver;

	public FIXEDASSETS_AssetUndertakingObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	ASSET UNDERTAKING SUBMODULE  //

//	--------------------------A-S-S-E-T--T-R-A-N-S-F-E-R-----------------------------------//
	// Direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAssets_AssetUndertaking_DirectionButton;

	public WebElement fixedAssets_AssetUndertaking_DirectionButton() {
		return fixedAssets_AssetUndertaking_DirectionButton;
	}

	// Fixed Asset menu
	@FindBy(xpath = "//ion-label[text()=' Fixed assets ']")
	private WebElement fixedAssets_AssetTransfer_Menu;

	public WebElement fixedAssets_AssetTransfer_Menu() {
		return fixedAssets_AssetTransfer_Menu;
	}

	// eye button of Asset Transfer
	@FindBy(xpath = "//div[6]//ion-menu-toggle[2]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetTransfer_EyeButton;

	public WebElement fixedAssets_AssetTransfer_EyeButton() {
		return fixedAssets_AssetTransfer_EyeButton;
	}

	// eye button of first record of Asset Transfer
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement fixedAssets_AssetTransfer_FirstViewButton;

	public WebElement fixedAssets_AssetTransfer_FirstViewButton() {
		return fixedAssets_AssetTransfer_FirstViewButton;
	}

	// eye button of Asset undertaking
	@FindBy(xpath = "//div[6]//ion-menu-toggle[3]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetUndertaking_EyeButton;

	public WebElement fixedAssets_AssetUndertaking_EyeButton() {
		return fixedAssets_AssetUndertaking_EyeButton;
	}

	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetTransfer_AddButton;

	public WebElement fixedAssets_AssetTransfer_AddButton() {
		return fixedAssets_AssetTransfer_AddButton;
	}

	// Asset Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetTransfer_AssetReferenceNumber;

	public WebElement fixedAssets_AssetTransfer_AssetReferenceNumber() {
		return fixedAssets_AssetTransfer_AssetReferenceNumber;
	}

	// New Branch
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetTransfer_NewBranch;

	public WebElement fixedAssets_AssetTransfer_NewBranch() {
		return fixedAssets_AssetTransfer_NewBranch;
	}

	// Transferred to the Branch
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement fixedAssets_AssetTransfer_ViewTransferredBranch;

	public WebElement fixedAssets_AssetTransfer_ViewTransferredBranch() {
		return fixedAssets_AssetTransfer_ViewTransferredBranch;
	}

	@FindBy(xpath = "//ion-label[text()=' YES ']//following-sibling::ion-radio")
	private WebElement AssetTransfer_TransferYes;

	public WebElement AssetTransferTransferYes() {
		return AssetTransfer_TransferYes;
	}

	@FindBy(xpath = "//form//datatable-footer//a[@aria-label='go to next page']//i")
	private WebElement asset_ItemListNextButton;

	public WebElement assetItemListNextButton() {
		return asset_ItemListNextButton;
	}

	// Transfer
	@FindBy(xpath = "//datatable-body-cell/div/app-kub-lov/ion-select")
	private WebElement fixedAssets_AssetTransfer_Transfer;

	public WebElement fixedAssets_AssetTransfer_Transfer() {
		return fixedAssets_AssetTransfer_Transfer;
	}

	// Transfer Select Yes/No
	@FindBy(xpath = "//ion-item[2]/ion-radio")
	private WebElement fixedAssets_AssetTransfer_TransferYes;

	public WebElement fixedAssets_AssetTransfer_TransferYes() {
		return fixedAssets_AssetTransfer_TransferYes;
	}

	// Save Button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetTransfer_SaveButton;

	public WebElement fixedAssets_AssetTransfer_SaveButton() {
		return fixedAssets_AssetTransfer_SaveButton;
	}

	// Item Received
	@FindBy(xpath = "//datatable-body-cell/div/app-kub-lov/ion-select")
	private WebElement fixedAssets_AssetTransfer_Received;

	public WebElement fixedAssets_AssetTransfer_Received() {
		return fixedAssets_AssetTransfer_Received;
	}

	// Item Received Select Yes/No
	@FindBy(xpath = "//ion-item[2]/ion-radio")
	private WebElement fixedAssets_AssetTransfer_ReceivedYes;

	public WebElement fixedAssets_AssetTransfer_ReceivedYes() {
		return fixedAssets_AssetTransfer_ReceivedYes;
	}

	// First View Button to see record
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement fixedAssets_AssetUndertaking_FirstViewButton;

	public WebElement fixedAssets_AssetUndertaking_FirstViewButton() {
		return fixedAssets_AssetUndertaking_FirstViewButton;
	}

	// Transferred Branch
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[6]/div[1]")
	private WebElement fixedAssets_AssetUndertaking_TransferredBranch;

	public WebElement fixedAssets_AssetUndertaking_TransferredBranch() {
		return fixedAssets_AssetUndertaking_TransferredBranch;
	}

//	--------------------------A-S-S-E-T--I-M-P-A-I-R-E-M-E-N-T-----------------------------------//

	// eye button of Asset impairement
	@FindBy(xpath = "//div[6]//ion-menu-toggle[9]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetImpairement_EyeButton;

	public WebElement fixedAssets_AssetImpairement_EyeButton() {
		return fixedAssets_AssetImpairement_EyeButton;
	}

	// bank recon Asset impairement
	@FindBy(xpath = "//ion-label[contains(text(),' Bank recon ')]")
	private WebElement fixedAssets_AssetImpairement_BankRecon;

	public WebElement fixedAssets_AssetImpairement_BankRecon() {
		return fixedAssets_AssetImpairement_BankRecon;
	}

	// add button of Asset impairement
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetImpairement_AddButton;

	public WebElement fixedAssets_AssetImpairement_AddButton() {
		return fixedAssets_AssetImpairement_AddButton;
	}

	// Asset Reference Number of Asset impairement
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetImpairement_AssetReferenceNumber;

	public WebElement fixedAssets_AssetImpairement_AssetReferenceNumber() {
		return fixedAssets_AssetImpairement_AssetReferenceNumber;
	}

	// Transaction Type of Asset impairement
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/ion-item/ion-select")
	private WebElement fixedAssets_AssetImpairement_TransactionType;

	public WebElement fixedAssets_AssetImpairement_TransactionType() {
		return fixedAssets_AssetImpairement_TransactionType;
	}

	// Transaction Type- impairement
	@FindBy(xpath = "//ion-item[1]/ion-radio")
	private WebElement fixedAssets_AssetImpairement_TransactionTypeImpairement;

	public WebElement fixedAssets_AssetImpairement_TransactionTypeImpairement() {
		return fixedAssets_AssetImpairement_TransactionTypeImpairement;
	}

	// Item no. of Asset impairement
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetImpairement_ItemNumber;

	public WebElement fixedAssets_AssetImpairement_ItemNumber() {
		return fixedAssets_AssetImpairement_ItemNumber;
	}

	// Currency of Asset impairement
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[11]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetImpairement_Currency;

	public WebElement fixedAssets_AssetImpairement_Currency() {
		return fixedAssets_AssetImpairement_Currency;
	}

	// Save of Asset impairement
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetImpairement_Save;

	public WebElement fixedAssets_AssetImpairement_Save() {
		return fixedAssets_AssetImpairement_Save;
	}

//	--------------------------A-S-S-E-T--R-E-V-A-L-U-A-T-I-O-N-----------------------------------//

	// eye button of revaluation
	@FindBy(xpath = "//div[6]//ion-menu-toggle[11]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetRevaluation_EyeButton;

	public WebElement fixedAssets_AssetRevaluation_EyeButton() {
		return fixedAssets_AssetRevaluation_EyeButton;
	}

	// add button of revaluation
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetRevaluation_AddButton;

	public WebElement fixedAssets_AssetRevaluation_AddButton() {
		return fixedAssets_AssetRevaluation_AddButton;
	}

	// Asset Reference Number of revaluation
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetRevaluation_AssetReferenceNumber;

	public WebElement fixedAssets_AssetRevaluation_AssetReferenceNumber() {
		return fixedAssets_AssetRevaluation_AssetReferenceNumber;
	}

	// Item no. of revaluation
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetRevaluation_ItemNumber;

	public WebElement fixedAssets_AssetRevaluation_ItemNumber() {
		return fixedAssets_AssetRevaluation_ItemNumber;
	}

	// Currency of revaluation
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[8]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement fixedAssets_AssetRevaluation_Currency;

	public WebElement fixedAssets_AssetRevaluation_Currency() {
		return fixedAssets_AssetRevaluation_Currency;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='FIXED_ASSET_TRANSFER']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetTransfer_ReferenceNumber;

	public WebElement assetTransferReferenceNumber() {
		return assetTransfer_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='FIXED_ASSET_TRANSFER']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetTransfer_NotificationFirstRecord;

	public WebElement assetTransferNotificationFirstRecord() {
		return assetTransfer_NotificationFirstRecord;
	}

	@FindBy(xpath = "//input[@placeholder='Search Refernce No']")
	private WebElement assetUndertaking_SearchAssetReferenceNumber;

	public WebElement assetUndertakingSearchAssetReferenceNumber() {
		return assetUndertaking_SearchAssetReferenceNumber;
	}

}
