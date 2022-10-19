package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bank_Recon_Obj {
	WebDriver driver;

	public Bank_Recon_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Bank recon')]")
	private WebElement bank_Recon_Module;

	public WebElement bank_Recon_Module() {
		return bank_Recon_Module;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/245']")
	private WebElement bank_Recon_Eye;

	public WebElement bank_Recon_Eye() {
		return bank_Recon_Eye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/243']")
	private WebElement bank_Recon_Edit;

	public WebElement bank_Recon_Edit() {
		return bank_Recon_Edit;
	}
		
	@FindBy(xpath = "(//ion-icon[@ng-reflect-name='add'])[2]")
	private WebElement bank_Recon_Add;

	public WebElement bank_Recon_Add() {
		return bank_Recon_Add;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement bank_Recon_DataMatchingRule_Add;

	public WebElement bank_Recon_DataMatchingRule_Add() {
		return bank_Recon_DataMatchingRule_Add;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_BankName;

	public WebElement bank_Recon_BankName() {
		return bank_Recon_BankName;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_Applicable_AccType;

	public WebElement bank_Recon_Applicable_AccType() {
		return bank_Recon_Applicable_AccType;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_Upload_FileExtension;

	public WebElement bank_Recon_Upload_FileExtension() {
		return bank_Recon_Upload_FileExtension;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_Seperator;

	public WebElement bank_Recon_Seperator() {
		return bank_Recon_Seperator;
	}

	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_allowUnadjEntry;

	public WebElement bank_Recon_allowUnadjEntry() {
		return bank_Recon_allowUnadjEntry;
	}

	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_valueDateUpto;

	public WebElement bank_Recon_valueDateUpto() {
		return bank_Recon_valueDateUpto;
	}

	@FindBy(xpath = "//ion-datetime[@id='field_transationDate']")
	private WebElement bank_Recon_EffectiveDate;

	public WebElement bank_Recon_EffectiveDate() {
		return bank_Recon_EffectiveDate;
	}
	// button[text()='04']

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement bank_Recon_EffectiveDate_Cancel;

	public WebElement bank_Recon_EffectiveDate_Cancel() {
		return bank_Recon_EffectiveDate_Cancel;
	}

	@FindBy(xpath = "//button[text()='Done']")
	private WebElement bank_Recon_EffectiveDate_Done;

	public WebElement bank_Recon_EffectiveDate_Done() {
		return bank_Recon_EffectiveDate_Done;
	}

	@FindBy(xpath = "//ion-col[10]/ion-item[1]//ion-input[1]/input[1]")
	private WebElement bank_Recon_SummeryLines;

	public WebElement bank_Recon_SummeryLines() {
		return bank_Recon_SummeryLines;
	}

	@FindBy(xpath = "//ion-col[11]/ion-item[1]//ion-input[1]/input[1]")
	private WebElement bank_Recon_FileNamePrefix;

	public WebElement bank_Recon_FileNamePrefix() {
		return bank_Recon_FileNamePrefix;
	}

	@FindBy(xpath = "(//fieldset[@id='brh']//ion-button[1])[1]")
	private WebElement bank_Recon_PlaceHolder_Add;

	public WebElement bank_Recon_PlaceHolder_Add() {
		return bank_Recon_PlaceHolder_Add;
	}

	@FindBy(xpath = "(//datatable-row-wrapper//datatable-body-cell[2]//ion-select)[1]")
	private WebElement bank_Recon_PlaceHolder_DrpDown1;

	public WebElement bank_Recon_PlaceHolder_DrpDown1() {
		return bank_Recon_PlaceHolder_DrpDown1;
	}

	@FindBy(xpath = "(//datatable-row-wrapper//datatable-body-cell[2]//ion-select)[2]")
	private WebElement bank_Recon_PlaceHolder_DrpDown2;

	public WebElement bank_Recon_PlaceHolder_DrpDown2() {
		return bank_Recon_PlaceHolder_DrpDown2;
	}

	@FindBy(xpath = "(//datatable-row-wrapper//datatable-body-cell[2]//ion-select)[3]")
	private WebElement bank_Recon_PlaceHolder_DrpDown3;

	public WebElement bank_Recon_PlaceHolder_DrpDown3() {
		return bank_Recon_PlaceHolder_DrpDown3;
	}

	@FindBy(xpath = "//input[@formcontrolname='rowNumber']")
	private WebElement bank_Recon_PlaceHolder_RowNumber;

	public WebElement bank_Recon_PlaceHolder_RowNumber() {
		return bank_Recon_PlaceHolder_RowNumber;
	}

	@FindBy(xpath = "//input[@formcontrolname='columnNumber']")
	private WebElement bank_Recon_PlaceHolder_columnNumber;

	public WebElement bank_Recon_PlaceHolder_columnNumber() {
		return bank_Recon_PlaceHolder_columnNumber;
	}

	@FindBy(xpath = "//input[@formcontrolname='length']")
	private WebElement bank_Recon_PlaceHolder_length;

	public WebElement bank_Recon_PlaceHolder_length() {
		return bank_Recon_PlaceHolder_length;
	}

	@FindBy(xpath = "//input[@formcontrolname='startingPosition']")
	private WebElement bank_Recon_PlaceHolder_startingPosition;

	public WebElement bank_Recon_PlaceHolder_startingPosition() {
		return bank_Recon_PlaceHolder_startingPosition;
	}

	@FindBy(xpath = "//datatable-body-cell[7]/div[1]/ion-button[1]")
	private WebElement bank_Recon_PlaceHolder_ExtraAdd;

	public WebElement bank_Recon_PlaceHolder_ExtraAdd() {
		return bank_Recon_PlaceHolder_ExtraAdd;
	}

	@FindBy(xpath = "//ion-radio-group//ion-item[1]//ion-radio")
	private WebElement bank_Recon_PlaceHolder_AccNo;

	public WebElement bank_Recon_PlaceHolder_AccNo() {
		return bank_Recon_PlaceHolder_AccNo;
	}

	@FindBy(xpath = "//ion-radio-group//ion-item[2]//ion-radio")
	private WebElement bank_Recon_PlaceHolder_AsOnDate;

	public WebElement bank_Recon_PlaceHolder_AsOnDate() {
		return bank_Recon_PlaceHolder_AsOnDate;
	}

	@FindBy(xpath = "//ion-radio-group//ion-item[3]//ion-radio")
	private WebElement bank_Recon_PlaceHolder_ClosingDate;

	public WebElement bank_Recon_PlaceHolder_ClosingDate() {
		return bank_Recon_PlaceHolder_ClosingDate;
	}

	@FindBy(xpath = "(//input[@formcontrolname='rowNumber'])[2]")
	private WebElement bank_Recon_PlaceHolder_RowNumber2;

	public WebElement bank_Recon_PlaceHolder_RowNumber2() {
		return bank_Recon_PlaceHolder_RowNumber2;
	}

	@FindBy(xpath = "(//input[@formcontrolname='columnNumber'])[2]")
	private WebElement bank_Recon_PlaceHolder_columnNumber2;

	public WebElement bank_Recon_PlaceHolder_columnNumber2() {
		return bank_Recon_PlaceHolder_columnNumber2;
	}

	@FindBy(xpath = "(//input[@formcontrolname='length'])[2]")
	private WebElement bank_Recon_PlaceHolder_length2;

	public WebElement bank_Recon_PlaceHolder_length2() {
		return bank_Recon_PlaceHolder_length2;
	}

	@FindBy(xpath = "(//input[@formcontrolname='startingPosition'])[2]")
	private WebElement bank_Recon_PlaceHolder_startingPosition2;

	public WebElement bank_Recon_PlaceHolder_startingPosition2() {
		return bank_Recon_PlaceHolder_startingPosition2;
	}

	@FindBy(xpath = "(//datatable-body-cell[7]/div[1]/ion-button[1])[2]")
	private WebElement bank_Recon_PlaceHolder_ExtraAdd2;

	public WebElement bank_Recon_PlaceHolder_ExtraAdd2() {
		return bank_Recon_PlaceHolder_ExtraAdd2;
	}

	@FindBy(xpath = "(//input[@formcontrolname='rowNumber'])[3]")
	private WebElement bank_Recon_PlaceHolder_RowNumber3;

	public WebElement bank_Recon_PlaceHolder_RowNumber3() {
		return bank_Recon_PlaceHolder_RowNumber3;
	}

	@FindBy(xpath = "(//input[@formcontrolname='columnNumber'])[3]")
	private WebElement bank_Recon_PlaceHolder_columnNumber3;

	public WebElement bank_Recon_PlaceHolder_columnNumber3() {
		return bank_Recon_PlaceHolder_columnNumber3;
	}

	@FindBy(xpath = "(//input[@formcontrolname='length'])[3]")
	private WebElement bank_Recon_PlaceHolder_length3;

	public WebElement bank_Recon_PlaceHolder_length3() {
		return bank_Recon_PlaceHolder_length3;
	}

	@FindBy(xpath = "(//input[@formcontrolname='startingPosition'])[3]")
	private WebElement bank_Recon_PlaceHolder_startingPosition3;

	public WebElement bank_Recon_PlaceHolder_startingPosition3() {
		return bank_Recon_PlaceHolder_startingPosition3;
	}

	@FindBy(xpath = "(//datatable-body-cell[7]/div[1]/ion-button[1])[3]")
	private WebElement bank_Recon_PlaceHolder_ExtraAdd3;

	public WebElement bank_Recon_PlaceHolder_ExtraAdd3() {
		return bank_Recon_PlaceHolder_ExtraAdd3;
	}

	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2])[3]")
	private WebElement bank_Recon_Save;

	public WebElement bank_Recon_Save() {
		return bank_Recon_Save;
	}

	// Data Matching Rule

	@FindBy(xpath = "//ion-label[contains(text(),'Data Matching Rule')]")
	private WebElement bank_Recon_DataMatchingRule;

	public WebElement bank_Recon_DataMatchingRule() {
		return bank_Recon_DataMatchingRule;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_FieldName;

	public WebElement bank_Recon_FieldName() {
		return bank_Recon_FieldName;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_SystemDataPoint;

	public WebElement bank_Recon_SystemDataPoint() {
		return bank_Recon_SystemDataPoint;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_DataType;

	public WebElement bank_Recon_DataType() {
		return bank_Recon_DataType;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_DateType;

	public WebElement bank_Recon_DateType() {
		return bank_Recon_DateType;
	}

	@FindBy(xpath = "//ion-col[6]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bank_Recon_FixedLenth;

	public WebElement bank_Recon_FixedLenth() {
		return bank_Recon_FixedLenth;
	}

	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_BlankSpacePadding;

	public WebElement bank_Recon_BlankSpacePadding() {
		return bank_Recon_BlankSpacePadding;
	}

	@FindBy(xpath = "//ion-col[7]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bank_Recon_DefaultValue;

	public WebElement bank_Recon_DefaultValue() {
		return bank_Recon_DefaultValue;
	}

	@FindBy(xpath = "//ion-col[9]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bank_Recon_Position;

	public WebElement bank_Recon_Position() {
		return bank_Recon_Position;
	}

	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_SoundexMatch;

	public WebElement bank_Recon_SoundexMatch() {
		return bank_Recon_SoundexMatch;
	}

	@FindBy(xpath = "//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_MatchCondition;

	public WebElement bank_Recon_MatchCondition() {
		return bank_Recon_MatchCondition;
	}

	@FindBy(xpath = "//ion-col[12]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_SuggestCondition;

	public WebElement bank_Recon_SuggestCondition() {
		return bank_Recon_SuggestCondition;
	}

	@FindBy(xpath = "//ion-col[13]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bank_Recon_TranspostionCondition;

	public WebElement bank_Recon_TranspostionCondition() {
		return bank_Recon_TranspostionCondition;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-buttons[1]/ion-button[1]")
	private WebElement bank_Table_Edit;

	public WebElement bank_Table_Edit() {
		return bank_Table_Edit;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Format Master')]")
	private WebElement bank_Format_Data;

	public WebElement bank_Format_Data() {
		return bank_Format_Data;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement bank_Recon_Submit;

	public WebElement bank_Recon_Submit() {
		return bank_Recon_Submit;
	}

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement bank_Recon_Remark;

	public WebElement bank_Recon_Remark() {

		return bank_Recon_Remark;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement bank_Recon_RemarkSubmit;

	public WebElement bank_Recon_RemarkSubmit() {

		return bank_Recon_RemarkSubmit;
	}
	@FindBy(xpath = "//ion-label[contains(text(),'Bank Reconciliation Details')]")
	private WebElement bank_Reconciliation_Details;

	public WebElement bank_Reconciliation_Details() {
		return bank_Reconciliation_Details;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Bank Reconciliation Statement')]")
	private WebElement bank_Reconciliation_Statement;

	public WebElement bank_Reconciliation_Statement() {
		return bank_Reconciliation_Statement;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Bank Reconciliation Process')]")
	private WebElement bank_Reconciliation_Process;

	public WebElement bank_Reconciliation_Process() {
		return bank_Reconciliation_Process;
	}

	@FindBy(xpath = "(//ion-button[2])[49]")
	private WebElement bank_Reconciliation_Match_save;

	public WebElement bank_Reconciliation_Match_save() {
		return bank_Reconciliation_Match_save;
	}
	//ion-grid[2]//datatable-row-wrapper[1]//datatable-body-cell[1]//input
	@FindBy(xpath = "(//input[@id=\"saveCheckBox\"])[1]")
	private WebElement bank_Reconciliation_1st_Record;

	public WebElement bank_Reconciliation_1st_Record() {
		return bank_Reconciliation_1st_Record;
	}
	
	@FindBy(xpath = "ion-grid[2]//datatable-row-wrapper[1]//datatable-body-cell[1]//input")
	private WebElement bank_Reconciliation_2st_Record;

	public WebElement bank_Reconciliation_2st_Record() {
		return bank_Reconciliation_2st_Record;
	}
}
