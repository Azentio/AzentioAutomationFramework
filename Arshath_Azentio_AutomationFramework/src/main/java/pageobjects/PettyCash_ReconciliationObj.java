package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PettyCash_ReconciliationObj {
	WebDriver driver;

	public PettyCash_ReconciliationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// Reconciliation SUBMODULE  //
	
	@FindBy(xpath="//ion-label[contains(text(),'Petty cash')]")
	private WebElement PettyCash_Reconciliation_PettyCashMenu;
	public WebElement PettyCash_Reconciliation_PettyCashMenu()
	{
		return PettyCash_Reconciliation_PettyCashMenu;
		
	}
	
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement PettyCash_Reconciliation_DirctionIcon;

	public WebElement  PettyCash_Reconciliation_DirctionIcon() {
		return PettyCash_Reconciliation_DirctionIcon;
	}
	
	//Eye button of reconciliation
	@FindBy(xpath = "//div[8]/ion-menu-toggle[4]/ion-item/ion-buttons/ion-button[2]")
	private WebElement PettyCash_Reconciliation_EyeButton;

	public WebElement PettyCash_Reconciliation_EyeButton() {
		return PettyCash_Reconciliation_EyeButton;

	}
	
	// First eye button [contract Account code]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement PettyCash_Reconciliation_FirstRecordEyeButton;

	public WebElement PettyCash_Reconciliation_FirstRecordEyeButton() {
		return PettyCash_Reconciliation_FirstRecordEyeButton;
	}
	
	//physical cash in hand
	@FindBy(xpath="//ion-row[1]/ion-col[1]/ion-item/input")
	private WebElement PettyCash_Reconciliation_PhysicalCashInHand;
	public WebElement PettyCash_Reconciliation_PhysicalCashInHand()
	{
		return PettyCash_Reconciliation_PhysicalCashInHand;
		
	}
	
	//currency
	@FindBy(xpath="//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement PettyCash_Reconciliation_Currency;
	public WebElement PettyCash_Reconciliation_Currency()
	{
		return PettyCash_Reconciliation_Currency;
	}
	
	// Save button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement PettyCash_Reconciliation_SaveButton;
	
	public WebElement PettyCash_Reconciliation_SaveButton() {
		return PettyCash_Reconciliation_SaveButton;
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ARAP_Notification_Close;

	public WebElement ARAP_Notification_Close() {

		return ARAP_Notification_Close;
	}
	//reconciliation approval record status
	@FindBy(xpath = "//body/div/div/div/div[2]")
	private WebElement PettyCash_Reconciliation_ApprovalRecordStatus;
	
	public WebElement PettyCash_Reconciliation_ApprovalRecordStatus() {
		return PettyCash_Reconciliation_ApprovalRecordStatus;
	}
	
	//-----------------PETTY CASH REPORTS------------------//
	
//	Reports icon
	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement Reports_PettyCash_ReportIcon;

	public WebElement Reports_PettyCash_ReportIcon() {
		return Reports_PettyCash_ReportIcon;
	}
	
//	Reports Date
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement Reports_PettyCash_Calendar1;
	public WebElement Reports_PettyCash_Calendar1()
	{
		return Reports_PettyCash_Calendar1;
		
	}
	
//	Reports View Button
	@FindBy(xpath="//ion-button[contains(text(),'View')]")
	private WebElement Reports_PettyCash_ViewButton;
	public WebElement Reports_PettyCash_ViewButton()
	{
		return Reports_PettyCash_ViewButton;
		
	}
	
//	Fund requisition Temp View
	@FindBy(xpath="//div[1]//ion-menu-toggle[22]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Reports_PettyCash_FundRequisitionTempView; 
	public WebElement Reports_PettyCash_FundRequisitionTempView()
	{
		return Reports_PettyCash_FundRequisitionTempView;
		
	}
	
//	Petty cash receipt Temp View
	@FindBy(xpath="//div[1]//ion-menu-toggle[23]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Reports_PettyCash_PettyCashReceiptTempView; 
	public WebElement Reports_PettyCash_PettyCashReceiptTempView()
	{
		return Reports_PettyCash_PettyCashReceiptTempView;
		
	}
	
//	Petty cash register Temp View
	@FindBy(xpath="//div[1]//ion-menu-toggle[25]//ion-item//ion-buttons//ion-button[1]")
	private WebElement Reports_PettyCash_PettyCashRegisterTempView; 
	public WebElement Reports_PettyCash_PettyCashRegisterTempView()
	{
		return Reports_PettyCash_PettyCashRegisterTempView;
		
	}
	
//	ReportMenu
	
	@FindBy(xpath="//ion-label[contains(text(),'Reports')]")
	private WebElement Reports_PettyCash_ReportsMenu;
	public WebElement Reports_PettyCash_ReportsMenu()
	{
		return Reports_PettyCash_ReportsMenu;
		
	}
	
	
	//FUND REQUISITION ALL REPORTS DISPLAYED
	@FindBy(xpath = "//td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")

	private WebElement Reports_PettyCash_FundRequisitionReport;

	public WebElement Reports_PettyCash_FundRequisitionReport() {
		return Reports_PettyCash_FundRequisitionReport;
	}
	
	//PETTY CASH RECEIPT ALL REPORTS DISPLAYED
	@FindBy(xpath = "//td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	
	private WebElement Reports_PettyCash_PettyCashReceiptReport;
	
	public WebElement Reports_PettyCash_PettyCashReceiptReport() {
		return Reports_PettyCash_PettyCashReceiptReport;
	}
	
	//PETTY CASH REGISTER ALL REPORTS DISPLAYED
	@FindBy(xpath = "//td[2]/div/div/div[1]/table/tbody/tr[2]/td/div[1]")
	
	private WebElement Reports_PettyCash_PettyCashRegisterReport;
	
	public WebElement Reports_PettyCash_PettyCashRegisterReport() {
		return Reports_PettyCash_PettyCashRegisterReport;
	}
	
}
