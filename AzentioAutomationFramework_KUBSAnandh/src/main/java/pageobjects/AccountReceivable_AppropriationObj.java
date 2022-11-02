package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountReceivable_AppropriationObj {


	WebDriver driver;

	public AccountReceivable_AppropriationObj(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	
	//Account Receivable Button
	@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
	private WebElement accountReceivable_Appropriation_AccountReceivableButton;

	public WebElement accountReceivable_Appropriation_AccountReceivableButton() {
		return accountReceivable_Appropriation_AccountReceivableButton;
	}
	//Account Receivable Appropriation Eye Button
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/200']")
	private WebElement accountReceivable_Appropriation_EyeButton;

	public WebElement accountReceivable_Appropriation_EyeButton() {
		return accountReceivable_Appropriation_EyeButton;
	}

	//Account Receivable Add Button
	@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement accountReceivable_Appropriation_AddButton;

	public WebElement accountReceivable_Appropriation_AddButton() {
		return accountReceivable_Appropriation_AddButton;
	}
	//Entity Branch
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input")
	private WebElement accountReceivable_Appropriation_EntityBranch;

	public WebElement accountReceivable_Appropriation_EntityBranch() {
		return accountReceivable_Appropriation_EntityBranch;
	}
	//ReceiptReferenceNumber
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountReceivable_Appropriation_ReceiptReferenceNumber;

	public WebElement accountReceivable_Appropriation_ReceiptReferenceNumber() {
		return accountReceivable_Appropriation_ReceiptReferenceNumber;
	}
	
	
	//AppropriationAmount
	@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]/input")
	private WebElement accountReceivable_Appropriation_AppropriationAmount;

	public WebElement accountReceivable_Appropriation_AppropriationAmount() {
		return accountReceivable_Appropriation_AppropriationAmount;
	}
	
	// ReceivableAmt
	@FindBy(xpath = "//div[contains(text(),'2974732.8')]")
	private WebElement accountReceivable_Appropriation_ReceivableAmt;

	public WebElement accountReceivable_Appropriation_ReceivableAmt() {
		return accountReceivable_Appropriation_ReceivableAmt;
	}

	// OutstandingAmt
	@FindBy(xpath = "//div[contains(text(),'2962732.8')]")
	private WebElement accountReceivable_Appropriation_OutstandingAmt;

	public WebElement accountReceivable_Appropriation_OutstandingAmt() {
		return accountReceivable_Appropriation_OutstandingAmt;
	}

	// finalOutstandingAmt
	@FindBy(xpath = "//div[contains(text(),'2961232.8')]")
	private WebElement accountReceivable_Appropriation_finalOutstandingAmt;

	public WebElement accountReceivable_Appropriation_finalOutstandingAmt() {
		return accountReceivable_Appropriation_finalOutstandingAmt;
	}
	
	// Appropriation Save
	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountReceivable_Appropriation_AppropriationSave;

	public WebElement accountReceivable_Appropriation_AppropriationSave() {
		return accountReceivable_Appropriation_AppropriationSave;
	}
}
