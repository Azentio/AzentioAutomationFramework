package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetAmendmentObj {
	WebDriver driver;

	public FIXEDASSET_AssetAmendmentObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement fixed_FinanceOption;

	public WebElement fixedFinanceOption() {

		return fixed_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixed_Transfericon;

	public WebElement fixedTransfericon() {

		return fixed_Transfericon;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement fixed_Popup;

	public WebElement fixed_Popup() {

		return fixed_Popup;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixed_Fixedassets;

	public WebElement fixed_FixedAssets() {

		return fixed_Fixedassets;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/128']")
	private WebElement fixed_AssetAmmendmentEye;

	public WebElement fixed_AssetAmmendmentEye() {

		return fixed_AssetAmmendmentEye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/127']")
	private WebElement fixed_AssetAmmendmentEdit;

	public WebElement fixed_AssetAmmendmentEdit() {

		return fixed_AssetAmmendmentEdit;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement fixed_AssetAmmendmentAdd;

	public WebElement fixedAssetAmmendmentAdd() {

		return fixed_AssetAmmendmentAdd;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetReferenceNumber;

	public WebElement fixed_AssetReferenceNumber() {

		return fixed_AssetReferenceNumber;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetItemCode;

	public WebElement fixed_AssetItemCode() {

		return fixed_AssetItemCode;
	}

	@FindBy(xpath = "//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_ModificationType;

	public WebElement fixed_ModificationType() {

		return fixed_ModificationType;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement fixed_AssetCalenderDate;

	public WebElement fixed_AssetCalenderDate() {

		return fixed_AssetCalenderDate;
	}
	
	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement fixed_CalenderNextMonth;

	public WebElement fixed_CalenderNextMonth() {

		return fixed_CalenderNextMonth;
	}
	
	@FindBy(xpath = "//ion-input[1]/input[@name='newAssetLife']")
	private WebElement fixed_AssetLife;

	public WebElement fixed_AssetLife() {

		return fixed_AssetLife;
	}
	
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]") 
	private WebElement fixed_Save;

	public WebElement AssetAmendment_Save() {

		return fixed_Save;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']") 
	private WebElement fixed_MakerNotification;

	public WebElement fixed_MakerNotification() {

		return fixed_MakerNotification;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span") 
	private WebElement fixed_ReferanceId;

	public WebElement fixed_ReferanceId() {

		return fixed_ReferanceId;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button") 
	private WebElement fixed_ActionButton;

	public WebElement fixed_ActionButton() {

		return fixed_ActionButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]") 
	private WebElement fixed_Submit;

	public WebElement fixed_Submit() {

		return fixed_Submit;
	}
	
	@FindBy(xpath = "//textarea[@name='remarks']") 
	private WebElement fixed_Remark;

	public WebElement fixed_Remark() {

		return fixed_Remark;
	}
	
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]") 
	private WebElement fixed_RemarkSubmit;

	public WebElement fixed_RemarkSubmit() {

		return fixed_RemarkSubmit;
	}
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
	private WebElement fixed_ReviewerId;

	public WebElement fixed_ReviewerId() {

		return fixed_ReviewerId;
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']") 
	private WebElement fixed_Notification_Close;

	public WebElement fixed_Notification_Close() {

		return fixed_Notification_Close;
	}
	
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']") 
	private WebElement fixed_AssetSearch;

	public WebElement fixed_AssetSearch() {

		return fixed_AssetSearch;
	}
	
	@FindBy(xpath = "//ion-input/input[@name='col3']") 
	private WebElement fixed_AssetSearchCode;

	public WebElement fixed_AssetSearchCode() {

		return fixed_AssetSearchCode;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/98']") 
	private WebElement fixed_AssetCreataionEye;

	public WebElement fixed_AssetCreataionEye() {

		return fixed_AssetCreataionEye;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]") 
	private WebElement fixed_AssetTableEye;

	public WebElement fixed_AssetTableEye() {

		return fixed_AssetTableEye;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[6]//span") 
	private WebElement fixed_AssetTableRef;

	public WebElement fixed_AssetTableRef() {

		return fixed_AssetTableRef;
	}
	@FindBy(xpath = "//div[@id='toast-container']//div[@role='alert']")
	private WebElement fixedAsset_AssetReturn_WorkflowInitiated;
    public WebElement fixedAsset_AssetReturn_WorkflowInitiated() {
		 return fixedAsset_AssetReturn_WorkflowInitiated;
	}
    @FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement fixedAsset_AssetReturn_AlertClose;
    public WebElement fixedAsset_AssetReturn_AlertClose() {
		 return fixedAsset_AssetReturn_AlertClose;
	}	
	
	
}