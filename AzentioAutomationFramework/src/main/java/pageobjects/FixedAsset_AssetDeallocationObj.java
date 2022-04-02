package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetDeallocationObj {
	WebDriver driver;

	public FixedAsset_AssetDeallocationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//Direction
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAsset_AssetDeallocation_DirectionIcon;
	public WebElement fixedAsset_AssetDeallocation_DirectionIcon() {
			return fixedAsset_AssetDeallocation_DirectionIcon;
	}
	
	//Fixed assets
	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixedAsset_AssetDeallocation_FixedAssetsField;
	public WebElement fixedAsset_AssetDeallocation_FixedAssetsField() {
			return fixedAsset_AssetDeallocation_FixedAssetsField;
		}

	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/120']")
	private WebElement fixedAsset_AssetDeallocation_EyeIcon;
	public WebElement fixedAsset_AssetDeallocation_EyeIcon() {
		return fixedAsset_AssetDeallocation_EyeIcon;
	}
	
	
	//AssetReferenceNumber
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetDeallocation_AssetReferenceNumber;
	public WebElement fixedAsset_AssetDeallocation_AssetReferenceNumber() {
		return fixedAsset_AssetDeallocation_AssetReferenceNumber;
	}
	//ItemNumber
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetDeallocation_ItemNumber;
	public WebElement fixedAsset_AssetDeallocation_ItemNumber() {
		return fixedAsset_AssetDeallocation_ItemNumber;
	}
	// Asset Reference number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/span")
	private WebElement fixedAsset_AssetReference;

	public WebElement fixedAsset_AssetReference() {
	return fixedAsset_AssetReference;
		
	}
	//Impairement EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/129']")
	private WebElement fixedAsset_AssetImpairement_EyeIcon;
	public WebElement fixedAsset_AssetImpairement_EyeIcon() {
		return fixedAsset_AssetImpairement_EyeIcon;
	}
	

	//AssetReferenceNumber  AssetImpairement
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetImpairement_AssetReferenceNumber;
	public WebElement fixedAsset_AssetImpairement_AssetReferenceNumber() {
		return fixedAsset_AssetImpairement_AssetReferenceNumber;
		}	
	
	//Transaction Type 
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[3]/ion-item[1]/ion-select[1]")
	private WebElement fixedAsset_AssetImpairement_TransactionType;
	public WebElement fixedAsset_AssetImpairement_TransactionType() {
		return fixedAsset_AssetImpairement_TransactionType;
		}	
	
	//Impairement
	@FindBy(xpath = "//ion-radio-group[1]/ion-item[1]/ion-radio[1]")
	private WebElement fixedAsset_AssetImpairement_Impairement;
	public WebElement fixedAsset_AssetImpairement_Impairement() {
		return fixedAsset_AssetImpairement_Impairement;
			}	
	
	//Impairement item number
	@FindBy(xpath = "//ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetImpairement_ItemNumber;
	public WebElement fixedAsset_AssetImpairement_ItemNumber() {
		return fixedAsset_AssetImpairement_ItemNumber;
	}
	
	//----REVALUED------//
	
	//RevaluedAsset_EyeIcon
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/137']")
		private WebElement fixedAsset_RevaluedAsset_EyeIcon;
		public WebElement fixedAsset_RevaluedAsset_EyeIcon() {
			return fixedAsset_RevaluedAsset_EyeIcon;
		}
		
		//AssetReferenceNumber  RevaluedAsset
		@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement fixedAsset_RevaluedAsset_AssetReferenceNumber;
		public WebElement fixedAsset_RevaluedAsset_AssetReferenceNumber() {
			return fixedAsset_RevaluedAsset_AssetReferenceNumber;
			}
		
		//RevaluedAsset item number
		@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_RevaluedAsset_ItemNumber;
		public WebElement fixedAsset_RevaluedAsset_ItemNumber() {
			return fixedAsset_RevaluedAsset_ItemNumber;
		}
		
//------Amended Asset-----//
	
		// AmendedAsset_EyeIcon
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/128']")
		private WebElement fixedAsset_AmendedAsset_EyeIcon;

		public WebElement fixedAsset_AmendedAsset_EyeIcon() {
			return fixedAsset_AmendedAsset_EyeIcon;
		}

		// AssetReferenceNumber AmendedAsset
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AmendedAsset_AssetReferenceNumber;

		public WebElement fixedAsset_AmendedAsset_AssetReferenceNumber() {
			return fixedAsset_AmendedAsset_AssetReferenceNumber;
		}

		// AmendedAsset item number
		@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AmendedAsset_ItemNumber;

		public WebElement fixedAsset_AmendedAsset_ItemNumber() {
			return fixedAsset_AmendedAsset_ItemNumber;
		}

		// AmendedAsset Modification type
		@FindBy(xpath = "//ion-row[1]/ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AmendedAsset_ModificationType;

		public WebElement fixedAsset_AmendedAsset_ModificationType() {
			return fixedAsset_AmendedAsset_ModificationType;
		}
		
		
//------AssetReplacement-----//
	
		// AssetReplacement_EyeIcon
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
		private WebElement fixedAsset_AssetReplacement_EyeIcon;

		public WebElement fixedAsset_AssetReplacement_EyeIcon() {
			return fixedAsset_AssetReplacement_EyeIcon;
		}

		// AssetReferenceNumber AssetReplacement
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetReplacement_AssetReferenceNumber;

		public WebElement fixedAsset_AssetReplacement_AssetReferenceNumber() {
			return fixedAsset_AssetReplacement_AssetReferenceNumber;
		}

		// AssetReplacement item number
		@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetReplacement_ItemNumber;

		public WebElement fixedAsset_AssetReplacement_ItemNumber() {
			return fixedAsset_AssetReplacement_ItemNumber;
		}

		// NewItemNumber
		@FindBy(xpath = "//ion-row[1]/ion-col[8]/ion-item[1]/ion-input[1]/input[1]")
		private WebElement fixedAsset_AssetReplacement_NewItemNumber;

		public WebElement fixedAsset_AssetReplacement_NewItemNumber() {
			return fixedAsset_AssetReplacement_NewItemNumber;
		}
		
		//Allocation
		//Allocation AssetRefferenceNumber
		
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber;

		public WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber() {
			return fixedAsset_AssetAllocation_AssetRefferenceNumber;
		}
		
		//Allocation Item Number
		
		@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetAllocation_ItemNumber;

		public WebElement fixedAsset_AssetAllocation_ItemNumber() {
			return fixedAsset_AssetAllocation_ItemNumber;
		}
		
		//EmployeeID
		
		@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetAllocation_EmployeeID;

		public WebElement fixedAsset_AssetAllocation_EmployeeID() {
			return fixedAsset_AssetAllocation_EmployeeID;
		}	

		
		//NewItemDiscription
		@FindBy(xpath = "//ion-row[1]/ion-col[9]/ion-item[1]/ion-input[1]/input[1]")
		private WebElement fixedAsset_AssetReplacement_NewItemDiscription;

		public WebElement fixedAsset_AssetReplacement_NewItemDiscription() {
			return fixedAsset_AssetReplacement_NewItemDiscription;
		}
		
		// ------transferred Asset-----//

		// transferredAsset_EyeIcon
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/114']")
		private WebElement fixedAsset_transferredAsset_EyeIcon;

		public WebElement fixedAsset_transferredAsset_EyeIcon() {
			return fixedAsset_transferredAsset_EyeIcon;
		}

		// AssetReferenceNumber transferredASSET
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_transferredAsset_AssetReferenceNumber;

		public WebElement fixedAsset_transferredAsset_AssetReferenceNumber() {
			return fixedAsset_transferredAsset_AssetReferenceNumber;
		}

		//transferredAsset NewBranch
		@FindBy(xpath = "//ion-row[2]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_transferredAsset_NewBranch;

		public WebElement fixedAsset_AmendedAsset_NewBranch() {
			return fixedAsset_transferredAsset_NewBranch;
		}

		
	}
