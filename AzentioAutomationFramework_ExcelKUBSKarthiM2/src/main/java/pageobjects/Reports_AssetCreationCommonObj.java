package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reports_AssetCreationCommonObj {
	WebDriver driver;

	public Reports_AssetCreationCommonObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// Asset Creation Common SUBMODULE  //
	
	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement Report_AssetCreationCommon_ReportIcon;

	public WebElement Report_AssetCreationCommon_ReportIcon() {
		return Report_AssetCreationCommon_ReportIcon;
	}
	
	@FindBy(xpath="//ion-label[contains(text(),'Reports')]")
	private WebElement Report_AssetCreationCommon_ReportsMenu;
	public WebElement Report_AssetCreationCommon_ReportsMenu()
	{
		return Report_AssetCreationCommon_ReportsMenu;
		
	}
	
	@FindBy(xpath="//ion-label[contains(text(),'Financial reporting')]")
	private WebElement Report_AssetCreationCommon_FinancialReportingMenu;
	public WebElement Report_AssetCreationCommon_FinancialReportingMenu()
	{
		return Report_AssetCreationCommon_FinancialReportingMenu;
		
	}
	
	@FindBy(xpath="//div[1]//ion-menu-toggle[9]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Report_AssetCreationCommon_AssetCreationCommonTempView; 
	public WebElement Report_AssetCreationCommon_AssetCreationCommonTempView()
	{
		return Report_AssetCreationCommon_AssetCreationCommonTempView;
		
	}
	
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='tabs/entities/asset-creation-i']")
	private WebElement Report_AssetCreationCommon_AssetCreationItemTempView; 
	public WebElement Report_AssetCreationCommon_AssetCreationItemTempView()
	{
		return Report_AssetCreationCommon_AssetCreationItemTempView;
		
	}
	
	@FindBy(xpath="//div[1]//ion-menu-toggle[6]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Report_AssetCreationCommon_AssetContractTempView; 
	public WebElement Report_AssetCreationCommon_AssetContractTempView()
	{
		return Report_AssetCreationCommon_AssetContractTempView;
		
	}
	
	@FindBy(xpath="//div[1]//ion-menu-toggle[10]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Report_AssetCreationCommon_AssetTransferTempView; 
	public WebElement Report_AssetCreationCommon_AssetTransferTempView()
	{
		return Report_AssetCreationCommon_AssetTransferTempView;
		
	}
	
	@FindBy(xpath="//div[1]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Report_AssetCreationCommon_DepreciationTempView; 
	public WebElement Report_AssetCreationCommon_DepreciationTempView()
	{
		return Report_AssetCreationCommon_DepreciationTempView;
		
	}
	
	@FindBy(xpath="//div[1]//ion-menu-toggle[27]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Report_AccountPayableReport_AccountPayableReportTempView;
	public WebElement Report_AccountPayableReport_AccountPayableReportTempView()
	{
		return Report_AccountPayableReport_AccountPayableReportTempView;
		
	}
	
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_AssetCreationCommon_AssetLifeUnit;
	public WebElement Report_AssetCreationCommon_AssetLifeUnit()
	{
		return Report_AssetCreationCommon_AssetLifeUnit;
		
	}
	
//	asset contract -contract ref no.
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_AssetContract_ContractReferenceNumber;
	public WebElement Report_AssetContract_ContractReferenceNumber()
	{
		return Report_AssetContract_ContractReferenceNumber;
		
	}
	
	
//	asset transfer- asset code
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_AssetTransfer_AssetCode;
	public WebElement Report_AssetTransfer_AssetCode()
	{
		return Report_AssetTransfer_AssetCode;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement Report_AssetCreationCommon_Date;
	public WebElement Report_AssetCreationCommon_Date()
	{
		return Report_AssetCreationCommon_Date;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement Report_AssetCreationItem_AssetCapitalizationDate;
	public WebElement Report_AssetCreationItem_AssetCapitalizationDate()
	{
		return Report_AssetCreationItem_AssetCapitalizationDate;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement Report_AssetCreationItem_AssetCreationAsOnDate;
	public WebElement Report_AssetCreationItem_AssetCreationAsOnDate()
	{
		return Report_AssetCreationItem_AssetCreationAsOnDate;
		
	}
	
//	Asset contract - asset contract date
	@FindBy(xpath="//ion-col[2]/app-kub-date-time/ion-item/div/span/ion-icon")
	private WebElement Report_AssetContract_AssetContractDate;
	public WebElement Report_AssetContract_AssetContractDate()
	{
		return Report_AssetContract_AssetContractDate;
		
	}
	
//	asset transfer- Asset transfer date
	@FindBy(xpath="//ion-col[2]/app-kub-date-time/ion-item/div/span/ion-icon")
	private WebElement Report_AssetTransfer_AssetTransferDate;
	public WebElement Report_AssetTransfer_AssetTransferDate()
	{
		return Report_AssetTransfer_AssetTransferDate;
		
	}
	
	@FindBy(xpath="//owl-date-time-calendar/div/button[2]")
	private WebElement Report_AssetCreationCommon_NextMonth;
	public WebElement Report_AssetCreationCommon_NextMonth()
	{
		return Report_AssetCreationCommon_NextMonth;
	}
	
	@FindBy(xpath="//ion-buttons/ion-button/a")
	private WebElement Report_AssetCreationCommon_ViewButton;
	public WebElement Report_AssetCreationCommon_ViewButton()
	{
		return Report_AssetCreationCommon_ViewButton;
	}	
	
	@FindBy(xpath="//li[8]/a/i")
	private WebElement Report_AssetCreationCommon_NextPage;
	public WebElement Report_AssetCreationCommon_NextPage()
	{
		return Report_AssetCreationCommon_NextPage;
	}
	
//	depreciation branch
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_Depreciation_Branch;
	public WebElement Report_Depreciation_Branch()
	{
		return Report_Depreciation_Branch;
	}	
	
//	depreciation period
	@FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_Depreciation_DepreciationPeriod;
	public WebElement Report_Depreciation_DepreciationPeriod()
	{
		return Report_Depreciation_DepreciationPeriod;
	}	
	
//	depreciation report
//	@FindBy(xpath="//table[@id='layout']/tbody/tr[4]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	@FindBy(xpath="//td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	
	private WebElement Report_Depreciation_DepreciationReport;
	public WebElement Report_Depreciation_DepreciationReport()
	{
		return Report_Depreciation_DepreciationReport;
	}	
	
//	Asset contract - asset contract report
	@FindBy(xpath="//table[@id='layout']/tbody/tr[4]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	private WebElement Report_AssetContract_AssetContractReport;
	public WebElement Report_AssetContract_AssetContractReport()
	{
		return Report_AssetContract_AssetContractReport;
	}
	
//	asset transfer- - asset transfer report
	@FindBy(xpath="//table[@id='layout']/tbody/tr[4]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	private WebElement Report_AssetTransfer_AssetTransferReport;
	public WebElement Report_AssetTransfer_AssetTransferReport()
	{
		return Report_AssetTransfer_AssetTransferReport;
	}	
	
//	account payable report - vendor name
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_AccountPayableReport_VendorName;
	public WebElement Report_AccountPayableReport_VendorName()
	{
		return Report_AccountPayableReport_VendorName;
	}	
	
//	account payable report - Payable Status
	@FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement Report_AccountPayableReport_PayableStatus;
	public WebElement Report_AccountPayableReport_PayableStatus()
	{
		return Report_AccountPayableReport_PayableStatus;
	}	
	
//	account payable report - next page button in report
//	@FindBy(xpath="//td[7]/input")
	@FindBy(xpath="//tbody/tr[2]/td[7]/input[1]")
	private WebElement Report_AccountPayableReport_NextPage;
	public WebElement Report_AccountPayableReport_NextPage()
	{
		return Report_AccountPayableReport_NextPage;
	}	
	
	@FindBy(xpath = "//div[5]//ion-menu-toggle[3]//ion-item//ion-buttons//ion-button[1]")

	private WebElement Report_AssetCodeReport_TempView;

	public WebElement Report_AssetCodeReport_TempView()

	{

		return Report_AssetCodeReport_TempView;

	}

	@FindBy(xpath = "//div[5]//ion-menu-toggle[4]//ion-item//ion-buttons//ion-button[1]")

	private WebElement Report_AssetCategoryReport_TempView;

	public WebElement Report_AssetCategoryReport_TempView()

	{

		return Report_AssetCategoryReport_TempView;

	}

	@FindBy(xpath = "//div[5]//ion-menu-toggle[9]//ion-item//ion-buttons//ion-button[1]")

	private WebElement Report_AssetLimitConfiguration_TempView;

	public WebElement Report_AssetLimitConfiguration_TempView()

	{

		return Report_AssetLimitConfiguration_TempView;

	}

	@FindBy(xpath = "//div[5]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[1]")

	private WebElement Report_AssetSerialNumber_TempView;

	public WebElement Report_AssetSerialNumber_TempView()

	{

		return Report_AssetSerialNumber_TempView;

	}
	@FindBy(xpath="//ion-menu/ion-content/custom-side-menu/ion-list/ion-item[6]/ion-icon[1]")
	private WebElement FixedAssertConfigButton;

	public WebElement FixedAssertConfigButton()

	{

		return FixedAssertConfigButton;

	}
	@FindBy(xpath="//ion-menu/ion-content/custom-side-menu/ion-list/div[6]/ion-menu-toggle[5]/ion-item/ion-buttons/ion-button[2]")
	private WebElement AssertSerialNumberSetup;

	public WebElement AssertSerialNumberSetup()

	{

		return AssertSerialNumberSetup;

	}
	@FindBy(xpath="//div[1]/ngx-datatable[1]/div[1]/datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/span[1]")
	private WebElement AssertReport_AssertCode;

	public WebElement AssertReport_AssertCode()

	{

		return AssertReport_AssertCode;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Master reports')]")

	private WebElement Report_MasterReportsMenu;

	public WebElement Report_MasterReportsMenu()

	{

		return Report_MasterReportsMenu;

	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")

	private WebElement Report_MasterReports_DepreciationMethod;

	public WebElement Report_MasterReports_DepreciationMethod()

	{

		return Report_MasterReports_DepreciationMethod;

	}

//   Start serial number 

	@FindBy(xpath = "//ion-col[2]/ion-item[1]/ion-input[1]/input[1]")

	private WebElement Report_AssetLimit_StartSerialNumber;

	public WebElement Report_AssetLimit_StartSerialNumber()

	{

		return Report_AssetLimit_StartSerialNumber;

	} 

//	Asset codes report 

	@FindBy(xpath = "//td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")

	private WebElement Report_AssetCodesReport;

	public WebElement Report_AssetCodesReport()

	{

		return Report_AssetCodesReport;

	} 

 

 
}
