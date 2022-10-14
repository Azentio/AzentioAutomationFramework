package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetCategoryObj {
	WebDriver driver;

	public FixedAsset_AssetCategoryObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[1]")
	private WebElement fixedAsset_AssetCategory_DirectionIcon;
	public WebElement fixedAsset_AssetCategory_DirectionIcon() {
		return fixedAsset_AssetCategory_DirectionIcon;
	}

	//Fixed Assets Configuration
	@FindBy(xpath = "//ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[6]/ion-icon[1]")
	private WebElement fixedAsset_AssetCategory_FixedAssetsConfiguration;
	public WebElement fixedAsset_AssetCategory_FixedAssetsConfiguration() {
		return fixedAsset_AssetCategory_FixedAssetsConfiguration;
	}
	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/58']")
	private WebElement fixedAsset_AssetCategory_EyeIcon;
	public WebElement fixedAsset_AssetCategory_EyeIcon() {
		return fixedAsset_AssetCategory_EyeIcon;
	}
		
	//Add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAsset_AssetCategory_AddButton;
	public WebElement fixedAsset_AssetCategory_AddButton() {
		 return fixedAsset_AssetCategory_AddButton;
	}
	
	
	//Asset Category Input Field
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCategory_AssetCategoryInputField;
	public WebElement fixedAsset_AssetCategory_AssetCategoryInputField() {
			return fixedAsset_AssetCategory_AssetCategoryInputField;
	}
	//Asset Sub  Category
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCategory_AssetSubCategory;
    public WebElement fixedAsset_AssetCategory_AssetSubCategory() {
		 return fixedAsset_AssetCategory_AssetSubCategory;
	}
  
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement fixedAsset_AssetCategory_AlertClose;
    public WebElement fixedAsset_AssetCategory_AlertClose() {
		 return fixedAsset_AssetCategory_AlertClose;
	}
    //Asset Item Category
  	@FindBy(xpath = "//ion-col[3]/ion-item[1]/ion-input[1]/input")
  	private WebElement fixedAsset_AssetCategory_AssetItemCategory;
    public WebElement fixedAsset_AssetCategory_AssetItemCategory() {
  		 return fixedAsset_AssetCategory_AssetItemCategory;
  	}
    
    //Asset Description
  	@FindBy(xpath = "//ion-col[4]/ion-item[1]/ion-input[1]/input")
  	private WebElement fixedAsset_AssetCategory_AssetDescription;
    public WebElement fixedAsset_AssetCategory_AssetDescription() {
  		 return fixedAsset_AssetCategory_AssetDescription;
  	}
   //Save button
  	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
  	private WebElement fixedAsset_AssetCategory_Save;
    public WebElement fixedAsset_AssetCategory_Save() {
  		 return fixedAsset_AssetCategory_Save;
  	}

	//Notification
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")	
	private WebElement fixedAsset_AssetCategory_Notification;
	public WebElement fixedAsset_AssetCategory_Notification() {
			return fixedAsset_AssetCategory_Notification;
	}
	
	//reference id
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")	
	private WebElement fixedAsset_AssetCategory_ReferenceId;
	public WebElement fixedAsset_AssetCategory_ReferenceId() {
	    return fixedAsset_AssetCategory_ReferenceId;
	}
	
	//Pencil Icon
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")	
	private WebElement fixedAsset_AssetCategory_PencilIcon;
	public WebElement fixedAsset_AssetCategory_PencilIcon() {
		return fixedAsset_AssetCategory_PencilIcon;
	}
	//Notification NextButton
	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement fixedAsset_AssetCategory_NotificationNext_Button;
	public WebElement fixedAsset_AssetCategory_NotificationNext_Button() {
		return fixedAsset_AssetCategory_NotificationNext_Button;
	}
	
	//Vaildation Msg
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement fixedAsset_AssetCategory_VaildationMsg;
	public WebElement fixedAsset_AssetCategory_VaildationMsg() {
		
		return fixedAsset_AssetCategory_VaildationMsg;
	}
	
    
    
}
