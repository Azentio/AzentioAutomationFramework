package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_StockConfirm_GL {

	WebDriver driver;

	public INVENTORY_StockConfirm_GL(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement inventory_ReportIcon;

	public WebElement inventoryReportIcon() {

		return inventory_ReportIcon;
	}

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
	
}
