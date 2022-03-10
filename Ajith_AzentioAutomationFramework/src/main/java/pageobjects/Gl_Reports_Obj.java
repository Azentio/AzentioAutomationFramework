package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gl_Reports_Obj {
	WebDriver driver;
	public Gl_Reports_Obj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//account payable
	@FindBy(xpath="//ion-label[contains(text(),'Accounts payable')]")
	private WebElement accountspayable;
	public WebElement accountPayable() {
		return accountspayable;
	}
	@FindBy(xpath="//div[3]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[2]")
	private WebElement manualPayoutEyeIcon;
	public WebElement manualPayoutEyeIcon() {
		return manualPayoutEyeIcon;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement manualPayoutAddIcon;
	public WebElement manualPayoutAddIcon(){
		return manualPayoutAddIcon;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectEntityBranch;
	public WebElement manualPayoutSelectEntityBranch() {
		return manualPayoutSelectEntityBranch;
	}
	@FindBy(xpath="//ion-col[4]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBp;
	public WebElement manualPayoutSelectBp() {
		return manualPayoutSelectBp;
	}
	@FindBy(xpath="//ion-col[5]/app-kub-lov/span/ng-select/div/div/div/input")
	public WebElement manualPayoutSelectBeneficiaryName;
	public WebElement manualPayoutSelectBeneficiaryName() {
		return manualPayoutSelectBeneficiaryName;
	}
	@FindBy(xpath="//ion-col[11]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectCurrency;
	public WebElement  manualPayoutSelectCurrency() {
		return manualPayoutSelectCurrency;
	}
	@FindBy(xpath="//ion-col[14]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBank;
	public WebElement manualPayoutSelectBank() {
		return manualPayoutSelectBank;
	}
	@FindBy(xpath="//ion-col[15]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBankAccountNumber;
	public WebElement manualPayoutSelectBankAccountNumber() {
		return manualPayoutSelectBankAccountNumber;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement manualPayoutCalender;
	public WebElement manualPayoutCalender() {
		return manualPayoutCalender;
	}
	// reoort
	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement ReportIcon;

	public WebElement ReportIcon() {

		return ReportIcon;
	}
	@FindBy(xpath="//ion-label[text()=' Financial reporting ']")
	private WebElement financialReporting;
	public WebElement financialReporting() {
		return financialReporting; 
	}
	@FindBy(xpath ="//ion-button[@ng-reflect-router-link=\"tabs/entities/gl-balances-repo\"]")
	private WebElement FinancialTransactionIcon;

	public WebElement FinancialTransactionIcon() {

		return FinancialTransactionIcon;
	}
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement glBalanceReportSelectBranch;
	public  WebElement glBalanceReportSelectBranch() {
		return glBalanceReportSelectBranch;
	}
	@FindBy(xpath="//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	public WebElement glBalanceReportSelectGlcode;
	public WebElement glBalanceReportSelectGlcode() {
		return glBalanceReportSelectGlcode;
	}
	@FindBy(xpath="//ion-col[5]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement glBalanceReportSelectCurrency;
	public WebElement glBalanceReportCurrency() {
		return glBalanceReportSelectCurrency;
	}
	@FindBy(xpath="//ion-segment/ion-segment-button[2]")
	private WebElement optionicon;
	public WebElement directionIcon() {
		return optionicon;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-shape='round']")
	private WebElement Gl_ViewButton;

	public WebElement glViewButton() {

		return Gl_ViewButton;
	}
	

}
