package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankRecon_ReconFormatObj {
	WebDriver driver;

	public BankRecon_ReconFormatObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//ion-segment/ion-segment-button[1]")
	private WebElement bankRecon_ReconFormat_DirectionLeft;
	public WebElement bankRecon_ReconFormat_DirectionLeft() {
		return bankRecon_ReconFormat_DirectionLeft;
	}
	
	
	@FindBy(xpath = "//ion-label[text()=' Bank recon ']")
	private WebElement bankRecon_ReconFormatField;
	public WebElement bankRecon_ReconFormatField() {
		return bankRecon_ReconFormatField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/245']")
	private WebElement bankRecon_ReconFormat_EyeButton;

	public WebElement bankRecon_ReconFormat_EyeButton() {
		return bankRecon_ReconFormat_EyeButton;

	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[2]")
	private WebElement bankRecon_ReconFormat_FirstRecord;
	public WebElement bankRecon_ReconFormat_FirstRecord() {
		return bankRecon_ReconFormat_FirstRecord;

	}

	@FindBy(xpath = "//ion-row[1]/ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement bankRecon_ReconFormat_FormatStatus;
	public WebElement bankRecon_ReconFormat_FormatStatus() {
		return bankRecon_ReconFormat_FormatStatus;

	}
	@FindBy(xpath="//li[8]/a/i")
	private WebElement bankRecon_ReconFormat_Next;
	public WebElement bankRecon_ReconFormat_Next()
	{
		return bankRecon_ReconFormat_Next;
	}
	
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_BankName;

	public WebElement bankRecon_ReconFormat_BankName() {
		return bankRecon_ReconFormat_BankName;
	}

	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement bankRecon_ReconFormat_BankName1;

	public WebElement bankRecon_ReconFormat_BankName1() {
		return bankRecon_ReconFormat_BankName1;
	}
	
	// ApplicableAccountType
	@FindBy(xpath = "//fieldset[1]/ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_ApplicableAccountType;

	public WebElement bankRecon_ReconFormat_ApplicableAccountType() {
		return bankRecon_ReconFormat_ApplicableAccountType;
	}

	// UploadFileExtension
	@FindBy(xpath = "//ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_UploadFileExtension;

	public WebElement bankRecon_ReconFormat_UploadFileExtension() {
		return bankRecon_ReconFormat_UploadFileExtension;
	}
	
	// Seprator
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_Seprator;

	public WebElement bankRecon_ReconFormat_Seprator() {
		return bankRecon_ReconFormat_Seprator;
	}

	// AllowUnadjusted
	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_AllowUnadjusted;

	public WebElement bankRecon_ReconFormat_AllowUnadjusted() {
		return bankRecon_ReconFormat_AllowUnadjusted;
	}

	// EffectiveDate 
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement bankRecon_ReconFormat_EffectiveDate;

	public WebElement bankRecon_ReconFormat_EffectiveDate() {
		return bankRecon_ReconFormat_EffectiveDate;
	}
	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement ARAP_NextMonth;

	public WebElement ARAPNextMonth() {

		return ARAP_NextMonth;
	}
	// EffectiveDateYearDrag
	@FindBy(xpath = "//button[contains(text(),'2032')]")
	private WebElement bankRecon_ReconFormat_YearDrag;

	public WebElement bankRecon_ReconFormat_YearDrag() {
		return bankRecon_ReconFormat_YearDrag;
	}

	// EffectiveDateYearDrop
	@FindBy(xpath = "//button[contains(text(),'2023')]")
	private WebElement bankRecon_ReconFormat_YearDrop;

	public WebElement bankRecon_ReconFormat_YearDrop() {
		return bankRecon_ReconFormat_YearDrop;
	}
	
	// WebElement posave = waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave());
	// clicksAndActionHelper.clickOnElement(posave);

	// EffectiveDateDoneButton
	@FindBy(xpath = "//button[contains(text(),'Done')]")
	private WebElement bankRecon_ReconFormat_EffectiveDateDoneButton;

	public WebElement bankRecon_ReconFormat_EffectiveDateDoneButton() {
		return bankRecon_ReconFormat_EffectiveDateDoneButton;
	}

	// AllowValueDate
	@FindBy(xpath = "//ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_ReconFormat_AllowValueDate;

	public WebElement bankRecon_ReconFormat_AllowValueDate() {
		return bankRecon_ReconFormat_AllowValueDate;
	}

	// SummaryLineToBeSkipped
	@FindBy(xpath = "//fieldset[1]/ion-row[1]/ion-col[10]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bankRecon_ReconFormat_SummaryLineToBeSkipped;

	public WebElement bankRecon_ReconFormat_SummaryLineToBeSkipped() {
		return bankRecon_ReconFormat_SummaryLineToBeSkipped;
	}

	// FileNamePrefix
	@FindBy(xpath = "//form[1]/ion-grid[1]/fieldset[1]/ion-row[1]/ion-col[11]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bankRecon_ReconFormat_FileNamePrefix;

	public WebElement bankRecon_ReconFormat_FileNamePrefix() {
		return bankRecon_ReconFormat_FileNamePrefix;
	}
	
	//PlaceHolder 
	@FindBy(xpath = "//ion-content[1]/ion-infinite-scroll[1]/form[1]/ion-grid[2]/fieldset[1]/legend[1]/ion-button[1]")
	private WebElement bankRecon_ReconFormat_PlaceHolder;

	public WebElement bankRecon_ReconFormat_PlaceHolder() {
		return bankRecon_ReconFormat_PlaceHolder;
	}

	// PlaceHolderInFile
	@FindBy(xpath = "//datatable-body-cell/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement bankRecon_ReconFormat_PlaceHolderInFile;

	public WebElement bankRecon_ReconFormat_PlaceHolderInFile() {
		return bankRecon_ReconFormat_PlaceHolderInFile;
	}

	// PlaceHolderInFile_AccountNo_RadioButton
	@FindBy(xpath = "//ion-list[1]/ion-radio-group[1]/ion-item[1]/ion-radio[1]")
	private WebElement bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton;

	public WebElement bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton() {
		return bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton;
	}

	
	//Row 
	@FindBy(xpath = "//datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/input[1]")
	private WebElement bankRecon_ReconFormat_Row_TextBox;

	public WebElement bankRecon_ReconFormat_Row_TextBox() {
		return bankRecon_ReconFormat_Row_TextBox;
	}

	//Column
	@FindBy(xpath = "//datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/input[1]")
	private WebElement bankRecon_ReconFormat_Column_TextBox;

	public WebElement bankRecon_ReconFormat_Column_TextBox() {
		return bankRecon_ReconFormat_Column_TextBox;
	}

	// Length_TextBox
	@FindBy(xpath = "//datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]/input[1]")
	private WebElement bankRecon_ReconFormat_Length_TextBox;

	public WebElement bankRecon_ReconFormat_Length_TextBox() {
		return bankRecon_ReconFormat_Length_TextBox;
	}

	// StartingPosition_TextBox
	@FindBy(xpath = "//datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]/input[1]")
	private WebElement bankRecon_ReconFormat_StartingPosition_TextBox;

	public WebElement bankRecon_ReconFormat_StartingPosition_TextBox() {
		return bankRecon_ReconFormat_StartingPosition_TextBox;
	}

	// Action_AddButton
	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-button[1]")
	private WebElement bankRecon_ReconFormat_Action_AddButton;

	public WebElement bankRecon_ReconFormat_Action_AddButton() {
		return bankRecon_ReconFormat_Action_AddButton;
	}

	// PlaceHolderInFile second
	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement bankRecon_ReconFormat_PlaceHolderInFilesecond;

	public WebElement bankRecon_ReconFormat_PlaceHolderInFilesecond() {
		return bankRecon_ReconFormat_PlaceHolderInFilesecond;
	}

	// PlaceHolderInFile_AsOnDate_RadioButton
	@FindBy(xpath = "//ion-list[1]/ion-radio-group[1]/ion-item[2]/ion-radio[1]")
	private WebElement bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton;

	public WebElement bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton() {
	return bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton;
	}
	//AsOnDateRow 
		@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_AsOnDateRow_TextBox;

		public WebElement bankRecon_ReconFormat_AsOnDateRow_TextBox() {
			return bankRecon_ReconFormat_AsOnDateRow_TextBox;
		}

		//AsOnDateColumn
		@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_AsOnDateColumn_TextBox;

		public WebElement bankRecon_ReconFormat_AsOnDateColumn_TextBox() {
			return bankRecon_ReconFormat_AsOnDateColumn_TextBox;
		}

		// AsOnDateLength_TextBox
		@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_AsOnDateLength_TextBox;

		public WebElement bankRecon_ReconFormat_AsOnDateLength_TextBox() {
			return bankRecon_ReconFormat_AsOnDateLength_TextBox;
		}

		// AsOnDateStartingPosition_TextBox
		@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox;

		public WebElement bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox() {
			return bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox;
		}

		// AsOnDateAction_AddButton
		@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]/ion-button[1]")
		private WebElement bankRecon_AsOnDateReconFormat_Action_AddButton;

		public WebElement bankRecon_AsOnDateReconFormat_Action_AddButton() {
			return bankRecon_AsOnDateReconFormat_Action_AddButton;
		}
		
		
		// PlaceHolderInFile Third
		@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/app-kub-lov[1]/ion-select[1]")
		private WebElement bankRecon_ReconFormat_PlaceHolderInFileThird;

		public WebElement bankRecon_ReconFormat_PlaceHolderInFileThird() {
			return bankRecon_ReconFormat_PlaceHolderInFileThird;
			
		}
		// PlaceHolderInFile_ClosingBalance_RadioButton
		@FindBy(xpath = "//ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[3]/ion-radio[1]")
		private WebElement bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton;

		public WebElement bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton() {
			return bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton;
		}

		// ClosingBalanceRow
		@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_ClosingBalanceRow_TextBox;

		public WebElement bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox() {
			return bankRecon_ReconFormat_ClosingBalanceRow_TextBox;
		}

		// ClosingBalanceColumn
		@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_ClosingBalanceColumn_TextBox;

		public WebElement bankRecon_ReconFormat_ClosingBalanceColumn_TextBox() {
			return bankRecon_ReconFormat_ClosingBalanceColumn_TextBox;
		}

		// ClosingBalanceLength_TextBox
		@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_ClosingBalanceLength_TextBox;

		public WebElement bankRecon_ReconFormat_ClosingBalanceLength_TextBox() {
			return bankRecon_ReconFormat_ClosingBalanceLength_TextBox;
		}

		// ClosingBalanceStartingPosition_TextBox
		@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]/input[1]")
		private WebElement bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox;

		public WebElement bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox() {
			return bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox;
		}
				

		
		//File Name
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_FileName;

		public WebElement bankRecon_ReconFormat_FileName() {
			return bankRecon_ReconFormat_FileName;
		}
			

		//SystemDataPoint
		@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_SystemDataPoint;

		public WebElement bankRecon_ReconFormat_SystemDataPoint() {
			return bankRecon_ReconFormat_SystemDataPoint;
		}

		// DataType
		@FindBy(xpath = "//ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_DataType;

		public WebElement bankRecon_ReconFormat_DataType() {
			return bankRecon_ReconFormat_DataType;
		}

		
		// DateFormate
		@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_DateFormate;

		public WebElement bankRecon_ReconFormat_DateFormate() {
			return bankRecon_ReconFormat_DateFormate;
		}
		//FixedLength
		@FindBy(xpath = "//input[@class='native-input sc-ion-input-md'][@name='fixedLength']")
		private WebElement bankRecon_ReconFormat_FixedLength;

		public WebElement bankRecon_ReconFormat_FixedLength() {
			return bankRecon_ReconFormat_FixedLength;
		}
			
		// BlankSpacePadding

		@FindBy(xpath = "//ion-row[1]/ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_BlankSpacePadding;

		public WebElement bankRecon_ReconFormat_BlankSpacePadding() {
			return bankRecon_ReconFormat_BlankSpacePadding;
		}
		
		// BlankSpacePadding

		@FindBy(xpath = "//ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_BlankSpacePaddingNum;

		public WebElement bankRecon_ReconFormat_BlankSpacePaddingNum() {
			return bankRecon_ReconFormat_BlankSpacePaddingNum;
		}

		//Position
		
		@FindBy(xpath = "//input[@name='columnPosition']")
		private WebElement bankRecon_ReconFormat_Position;

		public WebElement bankRecon_ReconFormat_Position() {
			return bankRecon_ReconFormat_Position;
		}
		//MatchCondition
		
		@FindBy(xpath = "//ion-row[1]/ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_MatchCondition;

		public WebElement bankRecon_ReconFormat_MatchCondition() {
			return bankRecon_ReconFormat_MatchCondition;
		}
		@FindBy(xpath = "//ion-row[1]/ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_MatchConditionNum;

		public WebElement bankRecon_ReconFormat_MatchConditionNum() {
			return bankRecon_ReconFormat_MatchConditionNum;
		}
		//Transposition Condition
		@FindBy(xpath = "//ng-dropdown-panel[@id='ac122f62ab8f']")
		private WebElement bankRecon_ReconFormat_TranspositionCondition;

		public WebElement bankRecon_ReconFormat_TranspositionCondition() {
			return bankRecon_ReconFormat_TranspositionCondition;
		}
		//BackButton
		@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[1]/ion-back-button[1]")
		private WebElement bankRecon_ReconFormat_BackButton;

		public WebElement bankRecon_ReconFormat_BackButton() {
			return bankRecon_ReconFormat_BackButton;
		}
		
		//soundex
		@FindBy(xpath = "//ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement bankRecon_ReconFormat_Soundex;

		public WebElement bankRecon_ReconFormat_Soundex() {
			return bankRecon_ReconFormat_Soundex;
		}
		
}
