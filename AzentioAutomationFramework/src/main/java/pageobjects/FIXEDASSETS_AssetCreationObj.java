package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSETS_AssetCreationObj {
	WebDriver driver;

	public FIXEDASSETS_AssetCreationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	ASSET CREATION SUBMODULE  //

//	--------------------------A-S-S-E-T--C-R-E-A-T-I-O-N-----------------------------------//
	// Direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAssets_AssetCreation_DirectionButton;

	public WebElement fixedAssets_AssetCreation_DirectionButton() {
		return fixedAssets_AssetCreation_DirectionButton;
	}

	// Fixed Asset menu
	@FindBy(xpath = "//ion-label[text()=' Fixed assets ']")
	private WebElement fixedAssets_AssetCreation_Menu;

	public WebElement fixedAssets_AssetCreation_Menu() {
		return fixedAssets_AssetCreation_Menu;
	}

	// eye button of Asset Creation
	@FindBy(xpath = "//div[6]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetCreation_EyeButton;

	public WebElement fixedAssets_AssetCreation_EyeButton() {
		return fixedAssets_AssetCreation_EyeButton;
	}
	
//	// eye button of first record of Asset Transfer
//	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
//	private WebElement fixedAssets_AssetTransfer_FirstViewButton;
//	
//	public WebElement fixedAssets_AssetTransfer_FirstViewButton() {
//		return fixedAssets_AssetTransfer_FirstViewButton;
//	}
//	
//	// eye button of Asset undertaking
//	@FindBy(xpath = "//div[6]//ion-menu-toggle[3]//ion-item//ion-buttons//ion-button[2]")
//	private WebElement fixedAssets_AssetUndertaking_EyeButton;
//	
//	public WebElement fixedAssets_AssetUndertaking_EyeButton() {
//		return fixedAssets_AssetUndertaking_EyeButton;
//	}
	
	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetCreation_AddButton;

	public WebElement fixedAssets_AssetCreation_AddButton() {
		return fixedAssets_AssetCreation_AddButton;
	}
	
	// branch code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_BranchCode;
	
	public WebElement fixedAssets_AssetCreation_BranchCode() {
		return fixedAssets_AssetCreation_BranchCode;
	}
	
	// Asset code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_AssetCode;
	
	public WebElement fixedAssets_AssetCreation_AssetCode() {
		return fixedAssets_AssetCreation_AssetCode;
	}
	
	// GRN ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[8]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_GRN_ReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_GRN_ReferenceNumber() {
		return fixedAssets_AssetCreation_GRN_ReferenceNumber;
	}
	
	// Bill ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[10]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_BillReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_BillReferenceNumber() {
		return fixedAssets_AssetCreation_BillReferenceNumber;
	}
	
	// asset life unit
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[13]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement fixedAssets_AssetCreation_AssetLifeUnit;
	
	public WebElement fixedAssets_AssetCreation_AssetLifeUnit() {
		return fixedAssets_AssetCreation_AssetLifeUnit;
	}
	
	//  External ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[11]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_ExternalReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_ExternalReferenceNumber() {
		return fixedAssets_AssetCreation_ExternalReferenceNumber;
	}
	
	//  fixed asset items
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement fixedAssets_AssetCreation_FixedAssetItems;
	
	public WebElement fixedAssets_AssetCreation_FixedAssetItems() {
		return fixedAssets_AssetCreation_FixedAssetItems;
	}
	
	// Asset item number
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[1]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetItemNumber;
	
	public WebElement fixedAssets_AssetCreation_AssetItemNumber() {
		return fixedAssets_AssetCreation_AssetItemNumber;
	}
	
	// asset items description
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetItemDescription;
	
	public WebElement fixedAssets_AssetCreation_AssetItemDescription() {
		return fixedAssets_AssetCreation_AssetItemDescription;
	}
	
	// asset capitalization date
	@FindBy(xpath = "//ion-row[3]/ion-col[1]/app-kub-date-time/ion-item/div/span")
	private WebElement fixedAssets_AssetCreation_AssetCapitalizationDate;
	
	public WebElement fixedAssets_AssetCreation_AssetCapitalizationDate() {
		return fixedAssets_AssetCreation_AssetCapitalizationDate;
	}
	

	//Click on next month 
	@FindBy(xpath = "//owl-date-time-calendar/div/button[2]")
	private WebElement  fixedAssets_AssetCreation_ClickOnNextMonth;
	
	public WebElement fixedAssets_AssetCreation_ClickOnNextMonth() {
		return fixedAssets_AssetCreation_ClickOnNextMonth;
	}
	
	// Salvage Value
	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[3]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_SalvageValue;
	
	public WebElement fixedAssets_AssetCreation_SalvageValue() {
		return fixedAssets_AssetCreation_SalvageValue;
	}
	
	// HSN Code
	@FindBy(xpath = "//ion-row[3]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_HSNcode;
	
	public WebElement fixedAssets_AssetCreation_HSNcode() {
		return fixedAssets_AssetCreation_HSNcode;
	}
	
	// Input tax credit value
//	@FindBy(xpath = "//ion-row[6]/ion-col[1]/ion-item/ion-input/input")
//	@FindBy(xpath = "//ion-row[6]/ion-col[1]")
	@FindBy(xpath = "//input[@name='inputTaxCreditVal']")
	private WebElement fixedAssets_AssetCreation_InputTaxCreditValue;
	
	public WebElement fixedAssets_AssetCreation_InputTaxCreditValue() {
		return fixedAssets_AssetCreation_InputTaxCreditValue;
	}
	
	//  asset Value
	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[1]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetValue;
	
	public WebElement fixedAssets_AssetCreation_AssetValue() {
		return fixedAssets_AssetCreation_AssetValue;
	}
	
	//  Salvage percentage
//	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[2]/ion-item/ion-input/input")
	@FindBy(xpath = "//input[@name='salvagePct']")
	private WebElement fixedAssets_AssetCreation_SalvagePercentage;
	
	public WebElement fixedAssets_AssetCreation_SalvagePercentage() {
		return fixedAssets_AssetCreation_SalvagePercentage;
	}
	
	//  Asset Life
	@FindBy(xpath = "//ion-grid[1]/ion-row[5]/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetLife;
	
	public WebElement fixedAssets_AssetCreation_AssetLife() {
		return fixedAssets_AssetCreation_AssetLife;
	}
	
	//  Asset Contract Linkage
	@FindBy(xpath = "//span[3]/ion-tab-button/ion-label")
	private WebElement fixedAssets_AssetCreation_AssetContractLinkage;
	
	public WebElement fixedAssets_AssetCreation_AssetContractLinkage() {
		return fixedAssets_AssetCreation_AssetContractLinkage;
	}
	
	//  PO Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_PO_ReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_PO_ReferenceNumber() {
		return fixedAssets_AssetCreation_PO_ReferenceNumber;
	}
	
	//  Contract Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_ContractReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_ContractReferenceNumber() {
		return fixedAssets_AssetCreation_ContractReferenceNumber;
	}

	//Save Button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetCreation_SaveButton;
	
	public WebElement fixedAssets_AssetCreation_SaveButton() {
		return fixedAssets_AssetCreation_SaveButton;
	}
	
	//Submit Button
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement fixedAssets_AssetCreation_SubmitbuttonInContractLinkage;
	
	public WebElement fixedAssets_AssetCreation_SubmitbuttonInContractLinkage() {
		return fixedAssets_AssetCreation_SubmitbuttonInContractLinkage;
	}
	
	
	//Save fixed assed item Button
	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[1]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetCreation_FixedAssetItems_SaveButton;
	
	public WebElement fixedAssets_AssetCreation_FixedAssetItems_SaveButton() {
		return fixedAssets_AssetCreation_FixedAssetItems_SaveButton;
	}
	

	// First eye button [To get Asset Reference Number ]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement fixedAssets_AssetCreation_CreatedRecordEyeButton;
	
	public WebElement fixedAssets_AssetCreation_CreatedRecordEyeButton() {
		return fixedAssets_AssetCreation_CreatedRecordEyeButton;
	}
	
	
	
}
