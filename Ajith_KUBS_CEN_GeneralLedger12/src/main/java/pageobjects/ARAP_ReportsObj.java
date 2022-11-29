package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_ReportsObj {
	WebDriver driver;

	public ARAP_ReportsObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement ARAP_ReportIcon;

	public WebElement ARAP_ReportIcon() {

		return ARAP_ReportIcon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Reports')]")
	private WebElement ARAP_ReportModule;

	public WebElement ARAP_ReportModule() {

		return ARAP_ReportModule;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/grn-report']")
	private WebElement ARAP_Report_GRNModule_Edit;

	public WebElement ARAP_Report_GRNModule_Edit() {

		return ARAP_Report_GRNModule_Edit;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/po-report']")
	private WebElement ARAP_Report_PoModule_Edit;

	public WebElement ARAP_Report_PoModule_Edit() {

		return ARAP_Report_PoModule_Edit;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/account-receiva']")
	private WebElement ARAP_Report_Acc_Rec_Module_Edit;

	public WebElement ARAP_Report_Acc_Rec_Module_Edit() {

		return ARAP_Report_Acc_Rec_Module_Edit;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='tabs/entities/account-payable-']")
	private WebElement ARAP_Report_Acc_pay_Module_Edit;

	public WebElement ARAP_Report_Acc_pay_Module_Edit() {

		return ARAP_Report_Acc_pay_Module_Edit;
	}
	
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement ARAP_Report_Module_VendorName;

	public WebElement ARAP_Report_Module_VendorName() {

		return ARAP_Report_Module_VendorName;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement ARAP_Report_Module_Date;

	public WebElement ARAP_Report_Module_Date() {

		return ARAP_Report_Module_Date;
	}


	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement ARAP_Report_Module_NextMonth;

	public WebElement ARAP_Report_Module_NextMonth() {

		return ARAP_Report_Module_NextMonth;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement ARAP_Report_Status;

	public WebElement ARAP_Report_Status() {

		return ARAP_Report_Status;
	}

	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement ARAP_Report_ViewButton;

	public WebElement ARAP_Report_ViewButton() {

		return ARAP_Report_ViewButton;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[4]/div[1]")
	private WebElement ARAP_GRN_GetBpName;

	public WebElement ARAP_Report_GetBpName() {

		return ARAP_GRN_GetBpName;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[3]/div[1]")
	private WebElement ARAP_GRN_GetGrnNo;

	public WebElement ARAP_GRN_GetGrnNo() {

		return ARAP_GRN_GetGrnNo;
	}
	
	@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]")
	private WebElement ARAP_Report_Nextbtn;

	public WebElement ARAP_Report_Nextbtn() {

		return ARAP_Report_Nextbtn;
	}
	
	// Financial reporting
	
	
	@FindBy(xpath = "//ion-label[contains(text(),'Financial reporting')]")
	private WebElement ARAP_Report_Financialreporting;

	public WebElement ARAP_Report_Financialreporting() {

		return ARAP_Report_Financialreporting;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='tabs/entities/balance-sheet-re']")
	private WebElement ARAP_Report_Balancesheet_Edit;

	public WebElement ARAP_Report_Balancesheet_Edit() {

		return ARAP_Report_Balancesheet_Edit;
	}
	
	
	
	
	
	
	

}
