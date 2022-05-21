package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArAp_BalanceSheetReportObj {
	

	WebDriver driver;

	public ArAp_BalanceSheetReportObj(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	// Report Button
	@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/ion-segment[1]/ion-segment-button[3]")
	private WebElement arAp_BalanceSheetReport_ReportButton;

	public WebElement arAp_BalanceSheetReport_ReportButton() {
		return arAp_BalanceSheetReport_ReportButton;
	}
	
	// Financial reporting Button
	@FindBy(xpath = "//ion-label[contains(text(),'Financial reporting')]")
	private WebElement arAp_BalanceSheetReport_FinancialReport;

	public WebElement arAp_BalanceSheetReport_FinancialReport() {
		return arAp_BalanceSheetReport_FinancialReport;
	}
	
	// balanceSheetReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[6]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement arAp_BalanceSheetReport_BalanceSheetReport;

	public WebElement arAp_BalanceSheetReport_BalanceSheetReport() {
		return arAp_BalanceSheetReport_BalanceSheetReport;
	}
	//BranchTextbox
	@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement arAp_BalanceSheetReport_BranchTextbox;

	public WebElement arAp_BalanceSheetReport_BranchTextbox() {
		return arAp_BalanceSheetReport_BranchTextbox;
	}		

	//ReportType
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement arAp_BalanceSheetReport_ReportType;

	public WebElement arAp_BalanceSheetReport_ReportType() {
	return arAp_BalanceSheetReport_ReportType;
	}	
	//Calendar Button
	@FindBy(xpath = "//span[@class='input-calendar']")
	private WebElement arAp_BalanceSheetReport_CalendarButton;

	public WebElement arAp_BalanceSheetReport_CalendarButton() {
		return arAp_BalanceSheetReport_CalendarButton;
	}
	//NextMonth
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement arAp_BalanceSheetReport_NextMonth;
	public WebElement arAp_BalanceSheetReport_NextMonth()
	{
		return arAp_BalanceSheetReport_NextMonth;
	}
	//View Button
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement arAp_BalanceSheetReport_ViewButton;

	public WebElement arAp_BalanceSheetReport_ViewButton() {
		return arAp_BalanceSheetReport_ViewButton;
	}
	//ReportNext
	@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]")
	private WebElement arAp_BalanceSheetReport_ReportNext;

	public WebElement arAp_BalanceSheetReport_ReportNext() {
		return arAp_BalanceSheetReport_ReportNext;
	}
	
	// Reports
	@FindBy(xpath = "//ion-label[contains(text(),' Reports ')]")
	private WebElement arAp_Reports;

	public WebElement arAp_Reports() {
		return arAp_Reports;
	}
	
	// Account Receivable Report edit Button
	@FindBy(xpath = "//ion-list[1]/div[1]/ion-menu-toggle[2]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement arAp_AccountReceivableReport_AccountReceivableReport;

	public WebElement arAp_AccountReceivableReport_AccountReceivableReport() {
		return arAp_AccountReceivableReport_AccountReceivableReport;
	}
	
	// Vendor Employee Name
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement arAp_AccountReceivableReport_VendorEmployeeName;

	public WebElement arAp_AccountReceivableReport_VendorEmployeeName() {
		return arAp_AccountReceivableReport_VendorEmployeeName;
	}

	// Receivable Status
	@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement arAp_AccountReceivableReport_ReceivableStatus;

	public WebElement arAp_AccountReceivableReport_ReceivableStatus() {
		return arAp_AccountReceivableReport_ReceivableStatus;
	}

}
