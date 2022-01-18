package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_RequestAndAllocationObj {

	WebDriver driver;

	public BUDGET_RequestAndAllocationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement requestAndAllocation_FinanceOption;

	public WebElement budget_requestAndAllocation_FinanceOption() {
		return requestAndAllocation_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement requestAndAllocation_DirctionIcon;

	public WebElement  budget_requestAndAllocation_DirctionIcon() {
		return requestAndAllocation_DirctionIcon;
	}

	@FindBy(xpath = "//ion-label[text()=' Budget ']")
	private WebElement requestAndAllocation_BudgetField;

	public WebElement  budget_requestAndAllocation_BudgetField() {
		return requestAndAllocation_BudgetField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/37']")
	private WebElement requestAndAllocation_BudgetEditIcon;

	public WebElement  budget_requestAndAllocation_BudgetEditIcon() {
		return requestAndAllocation_BudgetEditIcon;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/131']")
	private WebElement requestAndAllocation_BudgetEyeIcon;

	public WebElement  budget_requestAndAllocation_BudgetEyeIcon() {
		return requestAndAllocation_BudgetEyeIcon;
	}

	@FindBy(xpath = "//ion-icon[@name='add']")
	private WebElement requestAndAllocation_Addicon;

	public WebElement  budget_requestAndAllocation_Addicon() {
		return requestAndAllocation_Addicon;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement requestAndAllocation_Budgetcode;

	public WebElement  budget_requestAndAllocation_Budgetcode() {
		return requestAndAllocation_Budgetcode;
	}
	// ng-select[@class='ng-select ng-select-single ng-select-searchable
	// ng-select-clearable ng-select-bottom ng-touched ng-dirty ng-valid']

	@FindBy(xpath = "//ion-content[1]/form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[3]/ion-item[1]")
	private WebElement requestAndAllocation_Budgetname;

	public WebElement  budget_requestAndAllocation_Budgetname() {
		return requestAndAllocation_Budgetname;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/span[2]")
	private WebElement requestAndAllocation_Budgettype;

	public WebElement  budget_requestAndAllocation_Budgettype() {
		return requestAndAllocation_Budgettype;
	}

	@FindBy(xpath = "//select[@ng-reflect-name='budgetYear']")
	private WebElement requestAndAllocation_Budgetyear;

	public WebElement  budget_requestAndAllocation_Budgetyear() {
		return requestAndAllocation_Budgetyear;
	}

	@FindBy(xpath = "//ion-col[6]//ion-select[@ng-reflect-name='branch']")
	private WebElement requestAndAllocation_Budgetbranch;

	public WebElement  budget_requestAndAllocation_Budgetbranch() {
		return requestAndAllocation_Budgetbranch;
	} 

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[3]")
	private WebElement requestAndAllocation_branch_co;

	public WebElement  requestAndAllocation_branch_co() {
		return requestAndAllocation_branch_co;
	}
	@FindBy(xpath = "//ion-alert[1]/div/div[4]/button[2]")
	private WebElement requestAndAllocation_branchOK;

	public WebElement  budget_requestAndAllocation_branchOK() {
		return requestAndAllocation_branchOK;
	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement requestAndAllocation_branchcancel;

	public WebElement  budget_requestAndAllocation_branchcancel() {
		return requestAndAllocation_branchcancel;
	}

	@FindBy(xpath = "//input[@id='trxAmt']")
	private WebElement requestAndAllocation_Budgetamount;

	public WebElement  budget_requestAndAllocation_Budgetamount() {
		return requestAndAllocation_Budgetamount;
	}

	@FindBy(xpath = "//ion-col[8]/app-kub-lov/span/ng-select/div/div/div[2]")
	private WebElement requestAndAllocation_Amountcurruncy;

	public WebElement  budget_requestAndAllocation_Amountcurruncy() {
		return requestAndAllocation_Amountcurruncy;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar/ion-buttons[2]/ion-button[1]/ion-icon")
	private WebElement requestAndAllocation_AllowSave;

	public WebElement  budget_requestAndAllocation_AllowSave() {
		return requestAndAllocation_AllowSave;
	}

	// Budget Type Yearly
	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input") 
	private WebElement requestAndAllocation_Budgetyearly;

	public WebElement  budget_requestAndAllocation_Budgetyearly() {
		return requestAndAllocation_Budgetyearly;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_Budgetremark;

	public WebElement  budget_requestAndAllocation_Budgetremark() {
		return requestAndAllocation_Budgetremark;
	}

	@FindBy(xpath = "//span[contains(text(),'newone')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")
	private WebElement requestAndAllocation_Budgetaction;

	public WebElement  budget_requestAndAllocation_Budgetaction() {
		return requestAndAllocation_Budgetaction;
	}

	@FindBy(xpath = "//span[contains(text(),'ViewSummary')]")
	private WebElement requestAndAllocation_viewsummary;

	public WebElement  budget_requestAndAllocation_viewsummary() {
		return requestAndAllocation_viewsummary;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement requestAndAllocation_BudgetSubmit;

	public WebElement  budget_requestAndAllocation_BudgetSubmit() {
		return requestAndAllocation_BudgetSubmit;
	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement requestAndAllocation_Cancel;

	public WebElement  budget_requestAndAllocation_Cancel() {
		return requestAndAllocation_Cancel;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar/ion-buttons[2]/ion-button[1]/ion-icon")
	private WebElement requestAndAllocation_Budgetsave;

	public WebElement  budget_requestAndAllocation_Budgetsave() {
		return requestAndAllocation_Budgetsave;
	}

	// Halfyearly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_BudgetHy1;

	public WebElement  budget_requestAndAllocation_BudgetHy1() {
		return requestAndAllocation_BudgetHy1;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_BudgetHy2;

	public WebElement  budget_requestAndAllocation_BudgetHy2() {
		return requestAndAllocation_BudgetHy2;
	}

	// Halfyear Remark
	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_BudgetHyremark1;

	public WebElement  budget_requestAndAllocation_BudgetHyremark1() {
		return requestAndAllocation_BudgetHyremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_BudgetHyremark2;

	public WebElement  budget_requestAndAllocation_BudgetHyremark2() {
		return requestAndAllocation_BudgetHyremark2;
	}

	// Quaterly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_BudgetQuaterly0;

	public WebElement  budget_requestAndAllocation_BudgetQuaterly0() {
		return requestAndAllocation_BudgetQuaterly0;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_BudgetQuaterly1;

	public WebElement  budget_requestAndAllocation_BudgetQuaterly1() {
		return requestAndAllocation_BudgetQuaterly1;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='2']/input")
	private WebElement requestAndAllocation_BudgetQuaterly2;

	public WebElement  budget_requestAndAllocation_BudgetQuaterly2() {
		return requestAndAllocation_BudgetQuaterly2;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='3']/input")
	private WebElement requestAndAllocation_BudgetQuaterly3;

	public WebElement  budget_requestAndAllocation_BudgetQuaterly3() {
		return requestAndAllocation_BudgetQuaterly3;
	}

	// Quar Remark

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark0;

	public WebElement  budget_requestAndAllocation_BudgetQuaterlyremark0() {
		return requestAndAllocation_BudgetQuaterlyremark0;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark1;

	public WebElement  budget_requestAndAllocation_BudgetQuaterlyremark1() {
		return requestAndAllocation_BudgetQuaterlyremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='2']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark2;

	public WebElement  budget_requestAndAllocation_BudgetQuaterlyremark2() {
		return requestAndAllocation_BudgetQuaterlyremark2;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='3']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark3;

	public WebElement  budget_requestAndAllocation_BudgetQuaterlyremark3() {
		return requestAndAllocation_BudgetQuaterlyremark3;
	}
	// Monthly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_Budgetmonth1;

	public WebElement  budget_requestAndAllocation_Budgetmonth1() {
		return requestAndAllocation_Budgetmonth1;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_Budgetmonth2;

	public WebElement  budget_requestAndAllocation_Budgetmonth2() {
		return requestAndAllocation_Budgetmonth2;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='2']/input")
	private WebElement requestAndAllocation_Budgetmonth3;

	public WebElement  budget_requestAndAllocation_Budgetmonth3() {
		return requestAndAllocation_Budgetmonth3;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='3']/input")
	private WebElement requestAndAllocation_Budgetmonth4;

	public WebElement  budget_requestAndAllocation_Budgetmonth4() {
		return requestAndAllocation_Budgetmonth4;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='4']/input")
	private WebElement requestAndAllocation_Budgetmonth5;

	public WebElement  budget_requestAndAllocation_Budgetmonth5() {
		return requestAndAllocation_Budgetmonth5;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='5']/input")
	private WebElement requestAndAllocation_Budgetmonth6;

	public WebElement  budget_requestAndAllocation_Budgetmonth6() {
		return requestAndAllocation_Budgetmonth6;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='6']/input")
	private WebElement requestAndAllocation_Budgetmonth7;

	public WebElement  budget_requestAndAllocation_Budgetmonth7() {
		return requestAndAllocation_Budgetmonth7;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='7']/input")
	private WebElement requestAndAllocation_Budgetmonth8;

	public WebElement  budget_requestAndAllocation_Budgetmonth8() {
		return requestAndAllocation_Budgetmonth8;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='8']/input")
	private WebElement requestAndAllocation_Budgetmonth9;

	public WebElement  budget_requestAndAllocation_Budgetmonth9() {
		return requestAndAllocation_Budgetmonth9;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='9']/input")
	private WebElement requestAndAllocation_Budgetmonth10;

	public WebElement  budget_requestAndAllocation_Budgetmonth10() {
		return requestAndAllocation_Budgetmonth10;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='10']/input")
	private WebElement requestAndAllocation_Budgetmonth11;

	public WebElement  budget_requestAndAllocation_Budgetmonth11() {
		return requestAndAllocation_Budgetmonth11;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='11']/input")
	private WebElement requestAndAllocation_Budgetmonth12;

	public WebElement  budget_requestAndAllocation_Budgetmonth12() {
		return requestAndAllocation_Budgetmonth12;
	}

	// Monthly Remark

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_Budgetmonthremark1;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark1() {
		return requestAndAllocation_Budgetmonthremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_Budgetmonthremark2;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark2() {
		return requestAndAllocation_Budgetmonthremark2;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='2']")
	private WebElement requestAndAllocation_Budgetmonthremark3;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark3() {
		return requestAndAllocation_Budgetmonthremark3;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='3']")
	private WebElement requestAndAllocation_Budgetmonthremark4;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark4() {
		return requestAndAllocation_Budgetmonthremark4;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='4']")
	private WebElement requestAndAllocation_Budgetmonthremark5;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark5() {
		return requestAndAllocation_Budgetmonthremark5;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='5']")
	private WebElement requestAndAllocation_Budgetmonthremark6;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark6() {
		return requestAndAllocation_Budgetmonthremark6;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='6']")
	private WebElement requestAndAllocation_Budgetmonthremark7;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark7() {
		return requestAndAllocation_Budgetmonthremark7;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='7']")
	private WebElement requestAndAllocation_Budgetmonthremark8;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark8() {
		return requestAndAllocation_Budgetmonthremark8;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='8']")
	private WebElement requestAndAllocation_Budgetmonthremark9;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark9() {
		return requestAndAllocation_Budgetmonthremark9;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='9']")
	private WebElement requestAndAllocation_Budgetmonthremark10;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark10() {
		return requestAndAllocation_Budgetmonthremark10;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='10']")
	private WebElement requestAndAllocation_Budgetmonthremark11;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark11() {
		return requestAndAllocation_Budgetmonthremark11;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='11']")
	private WebElement requestAndAllocation_Budgetmonthremark12;

	public WebElement  budget_requestAndAllocation_Budgetmonthremark12() {
		return requestAndAllocation_Budgetmonthremark12;
	}

}
