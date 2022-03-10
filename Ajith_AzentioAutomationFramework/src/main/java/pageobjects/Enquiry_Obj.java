package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enquiry_Obj {
	WebDriver driver;

	public Enquiry_Obj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement inventoryReportIcon;

	public WebElement inventoryReportIcon() {

		return inventoryReportIcon;
	}
	//report sub module
	@FindBy(xpath="//ion-label[text()=' Reports ']")
	private WebElement reportMenu;
	public WebElement reportMenu() {
		return reportMenu;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/contract-report']")
	private WebElement contractReportEditIcon;
	public WebElement contractReportEditIcon() {
		return contractReportEditIcon;
	}
	@FindBy(xpath="(//div/input)[1]")
	private WebElement selectVendorName;
	public WebElement selectVendorName() {
		return selectVendorName;
	}
	@FindBy(xpath="(//div/input)[3]")
	private WebElement selectContractStatus;
	public WebElement selectContractStatus() {
		return selectContractStatus;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	public WebElement calenderInContractReport;
	public WebElement calenderInContractReport() {
		return calenderInContractReport;
	}
	@FindBy(xpath="//a[text()=' View ']")
	public WebElement viewInContractReport;
	public WebElement viewInContractReport() {
		return viewInContractReport;
	}
	@FindBy(xpath="//input[@title='Next page']")
	private WebElement nextPageInContractReport;
	public WebElement nextPageInContractReport() {
		return nextPageInContractReport;
	}
	@FindBy(xpath="(//ul[1]/li[2]/a[1]/i[1])[2]")
	private WebElement previousPageInContractReport;
	public WebElement previousPageInContractReport() {
		return previousPageInContractReport;
	}
	@FindBy(xpath="(//ul[1]/li[9]/a[1]/i[1])[2]")
	private WebElement lastPage;
	public WebElement lastPage() {
		return lastPage;
	}
	//enquiry submodule
	@FindBy(xpath = "//ion-label[contains(text(),'Enquiry')]")
	private WebElement inventory_EnquiryMenu;

	public WebElement inventoryEnquiryMenu() {

		return inventory_EnquiryMenu;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement inventory_FinancialTransactionIcon;

	public WebElement inventoryFinancialTransactionIcon() {

		return inventory_FinancialTransactionIcon;
	}
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_BranchCode;

	public WebElement inventoryBranchCode() {

		return inventory_BranchCode;
	}
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_GlCode;

	public WebElement inventoryGlCode() {

		return inventory_GlCode;
	}
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement inventory_FromDate;

	public WebElement inventoryFromDate() {

		return inventory_FromDate;
	}
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement inventory_ToDate;

	public WebElement inventoryToDate() {

		return inventory_ToDate;
	}
	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement inventory_NextMonth;

	public WebElement inventoryNextMonth() {

		return inventory_NextMonth;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-shape='round']")
	private WebElement inventory_ViewButton;

	public WebElement inventoryViewButton() {

		return inventory_ViewButton;
	}
	@FindBy(xpath="(//a[@aria-label='go to next page'])[2]")
	private WebElement nextPageInListView;
	public WebElement  nextPageInListView() {
		return nextPageInListView;
	}

}
