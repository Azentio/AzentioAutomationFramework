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

	// Fields - Objects
	@FindBy(xpath = "//label[@for='col0']")
	private WebElement budget_code_field;

	public WebElement budget_requestAndAllocation_budget_code_field() {
		return budget_code_field;
	}
	
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']")
	private WebElement requestAndAllocation_Budget_Search;

	public WebElement requestAndAllocation_Budget_Search() {

		return requestAndAllocation_Budget_Search;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement requestAndAllocation_Budget_TableEye;

	public WebElement requestAndAllocation_Budget_TableEye() {

		return requestAndAllocation_Budget_TableEye;
	}
	
	@FindBy(xpath = "//label[@for='col1']")
	private WebElement budget_Name_field;

	public WebElement budget_requestAndAllocation_budget_Name_field() {
		return budget_Name_field;
	}

	@FindBy(xpath = "//label[@for='col2']")
	private WebElement budget_Year_field;

	public WebElement budget_requestAndAllocation_budget_Year_field() {
		return budget_Year_field;
	}

	@FindBy(xpath = "//label[@for='col3']")
	private WebElement budget_Type_field;

	public WebElement budget_requestAndAllocation_budget_Type_field() {
		return budget_Type_field;
	}

	@FindBy(xpath = "//label[@for='col4']")
	private WebElement budget_Transfer_Amount_field;

	public WebElement budget_requestAndAllocation_budget_Transfer_Amount_field() {
		return budget_Transfer_Amount_field;
	}

	@FindBy(xpath = "//label[@for='col5']")
	private WebElement budget_Status_field;

	public WebElement budget_requestAndAllocation_budget_Status_field() {
		return budget_Status_field;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement maker_notification_icon;

	public WebElement makerNotificationIcon() {
		return maker_notification_icon;
	}

	// MAIN - OBJECTS
	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement requestAndAllocation_FinanceOption;

	public WebElement budget_requestAndAllocation_FinanceOption() {
		return requestAndAllocation_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement requestAndAllocation_DirctionIcon;

	public WebElement budget_requestAndAllocation_DirctionIcon() {
		return requestAndAllocation_DirctionIcon;
	}

	@FindBy(xpath = "//ion-label[text()=' Budget ']")
	private WebElement requestAndAllocation_BudgetField;

	public WebElement budget_requestAndAllocation_BudgetField() {
		return requestAndAllocation_BudgetField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/37']")
	private WebElement requestAndAllocation_BudgetEditIcon;

	public WebElement budget_requestAndAllocation_BudgetEditIcon() {
		return requestAndAllocation_BudgetEditIcon;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/131']")
	private WebElement requestAndAllocation_BudgetEyeIcon;

	public WebElement budget_requestAndAllocation_BudgetEyeIcon() {
		return requestAndAllocation_BudgetEyeIcon;
	}

	@FindBy(xpath = "//ion-buttons[2]/ion-item/ion-icon[@ng-reflect-name='search']")
	private WebElement requestAndAllocation_BudgetsearchIcon;

	public WebElement budget_requestAndAllocation_BudgetSearchIcon() {
		return requestAndAllocation_BudgetsearchIcon;
	}

	@FindBy(xpath = "//span[contains(text(),'TEST01')]")
	private WebElement requestAndAllocation_searchcode;

	public WebElement budget_requestAndAllocation_searchcode() {
		return requestAndAllocation_searchcode;
	}

	@FindBy(xpath = "//ion-input[@id='col0']/input")
	private WebElement requestAndAllocation_Budgetcodesearch;

	public WebElement budget_requestAndAllocation_Budgetcodesearch() {
		return requestAndAllocation_Budgetcodesearch;
	}

	@FindBy(xpath = "//ion-icon[@name='add']")
	private WebElement requestAndAllocation_Addicon;

	public WebElement budget_requestAndAllocation_Addicon() {
		return requestAndAllocation_Addicon;
	}

// SUB MAIN - OBJECTS

	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement requestAndAllocation_Budgetcode;

	public WebElement budget_requestAndAllocation_Budgetcode() {
		return requestAndAllocation_Budgetcode;
	}

	@FindBy(xpath = "//ion-content[1]/form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[3]/ion-item[1]")
	private WebElement requestAndAllocation_Budgetname;

	public WebElement budget_requestAndAllocation_Budgetname() {
		return requestAndAllocation_Budgetname;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/span[2]")
	private WebElement requestAndAllocation_Budgettype;

	public WebElement budget_requestAndAllocation_Budgettype() {
		return requestAndAllocation_Budgettype;
	}

	@FindBy(xpath = "//select[@ng-reflect-name='budgetYear']")
	private WebElement requestAndAllocation_Budgetyear;

	public WebElement budget_requestAndAllocation_Budgetyear() {
		return requestAndAllocation_Budgetyear;
	}

	@FindBy(xpath = "//option[@class='ng-star-inserted'][1]")
	private WebElement requestAndAllocation_Budgetyear1;

	public WebElement budget_requestAndAllocation_Budgetyear1() {
		return requestAndAllocation_Budgetyear1;
	}

	@FindBy(xpath = "//option[@class='ng-star-inserted'][2]")
	private WebElement requestAndAllocation_Budgetyear2;

	public WebElement budget_requestAndAllocation_Budgetyear2() {
		return requestAndAllocation_Budgetyear2;
	}

	@FindBy(xpath = "//ion-col[6]//ion-select[@ng-reflect-name='branch']")
	private WebElement requestAndAllocation_Budgetbranch;

	public WebElement budget_requestAndAllocation_Budgetbranch() {
		return requestAndAllocation_Budgetbranch;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[1]")
	private WebElement requestAndAllocation_branch_type1;

	public WebElement requestAndAllocation_branch_type1() {
		return requestAndAllocation_branch_type1;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[2]")
	private WebElement requestAndAllocation_branch_type2;

	public WebElement requestAndAllocation_branch_type2() {
		return requestAndAllocation_branch_type2;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[3]")
	private WebElement requestAndAllocation_branch_type3;

	public WebElement requestAndAllocation_branch_type3() {
		return requestAndAllocation_branch_type3;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[4]")
	private WebElement requestAndAllocation_branch_type4;

	public WebElement requestAndAllocation_branch_type4() {
		return requestAndAllocation_branch_type4;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[5]")
	private WebElement requestAndAllocation_branch_type;

	public WebElement requestAndAllocation_branch_type() {
		return requestAndAllocation_branch_type;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[6]")
	private WebElement requestAndAllocation_branch_type6;

	public WebElement requestAndAllocation_branch_type6() {
		return requestAndAllocation_branch_type6;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[7]")
	private WebElement requestAndAllocation_branch_type7;

	public WebElement requestAndAllocation_branch_type7() {
		return requestAndAllocation_branch_type7;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[8]") // ion-alert[1]/div/div[3]/button[4] -- //
// //ion-alert[1]/div/div[3]/button[5]
	private WebElement requestAndAllocation_branch_type8;

	public WebElement requestAndAllocation_branch_type8() {
		return requestAndAllocation_branch_type8;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[9]") // ion-alert[1]/div/div[3]/button[4] -- //
// //ion-alert[1]/div/div[3]/button[5]
	private WebElement requestAndAllocation_branch_type9;

	public WebElement requestAndAllocation_branch_type9() {
		return requestAndAllocation_branch_type9;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[10]") // ion-alert[1]/div/div[3]/button[4] -- //
// //ion-alert[1]/div/div[3]/button[5]
	private WebElement requestAndAllocation_branch_type10;

	public WebElement requestAndAllocation_branch_type10() {
		return requestAndAllocation_branch_type10;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[3]/button[11]") // ion-alert[1]/div/div[3]/button[4] -- //
// //ion-alert[1]/div/div[3]/button[5]
	private WebElement requestAndAllocation_branch_type11;

	public WebElement requestAndAllocation_branch_type11() {
		return requestAndAllocation_branch_type11;
	}

	@FindBy(xpath = "//ion-alert[1]/div/div[4]/button[2]")
	private WebElement requestAndAllocation_branchOK;

	public WebElement budget_requestAndAllocation_branchOK() {
		return requestAndAllocation_branchOK;
	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement requestAndAllocation_branchcancel;

	public WebElement budget_requestAndAllocation_branchcancel() {
		return requestAndAllocation_branchcancel;
	}

	@FindBy(xpath = "//input[@id='trxAmt']")
	private WebElement requestAndAllocation_Budgetamount;

	public WebElement budget_requestAndAllocation_Budgetamount() {
		return requestAndAllocation_Budgetamount;
	}

	@FindBy(xpath = "//ion-col[8]//ng-select/div/div/div[3]/input")
	private WebElement requestAndAllocation_Amountcurruncy;

	public WebElement budget_requestAndAllocation_Amountcurruncy() {
		return requestAndAllocation_Amountcurruncy;
	}

	@FindBy(xpath = "//ng-dropdown-panel//div[@id='a31d40b554bb-1']")
	private WebElement requestAndAllocation_Amountrup;

	public WebElement budget_requestAndAllocation_Amountrup() {
		return requestAndAllocation_Amountrup;
	}

	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement requestAndAllocation_AllowSave;

	public WebElement budget_requestAndAllocation_AllowSave() {
		return requestAndAllocation_AllowSave;
	}

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement requestAndAllocation_Alertremark;

	public WebElement requestAndAllocation_Alertremark() {
		return requestAndAllocation_Alertremark;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement requestAndAllocation_Alertsubmit;

	public WebElement requestAndAllocation_Alertsubmit() {
		return requestAndAllocation_Alertsubmit;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement requestAndAllocation_reviewer_id;

	public WebElement requestAndAllocation_reviewer_id() {
		return requestAndAllocation_reviewer_id;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement requestAndAllocation_notificationClose;

	public WebElement requestAndAllocation_notificationClose() {
		return requestAndAllocation_notificationClose;
	}

	@FindBy(xpath = "//ion-button/ion-icon[@name='person-circle']")
	private WebElement requestAndAllocation_MakerLogo;

	public WebElement requestAndAllocation_MakerLogo() {

		return requestAndAllocation_MakerLogo;
	}

	@FindBy(xpath = "//ion-content[1]/div[1]/ion-list[1]/ion-item[3]/ion-icon[1]")
	private WebElement requestAndAllocation_MakerLogout;

	public WebElement requestAndAllocation_MakerLogout() {

		return requestAndAllocation_MakerLogout;
	}

	// Budget Type Yearly
	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_Budgetyearly;

	public WebElement budget_requestAndAllocation_Budgetyearly() {
		return requestAndAllocation_Budgetyearly;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_Budgetremark;

	public WebElement budget_requestAndAllocation_Budgetremark() {
		return requestAndAllocation_Budgetremark;
	}

	// After save goto Table
	@FindBy(xpath = "//span[contains(text(),'newone')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")
	private WebElement requestAndAllocation_Budgetaction;

	public WebElement budget_requestAndAllocation_Budgetaction() {
		return requestAndAllocation_Budgetaction;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement maker_Referance_id;

	public WebElement maker_Referance_id() {
		return maker_Referance_id;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement maker_Action_icon;

	public WebElement maker_Action_icon() {
		return maker_Action_icon;
	}

	@FindBy(xpath = "//span[contains(text(),'ViewSummary')]")
	private WebElement requestAndAllocation_viewsummary;

	public WebElement budget_requestAndAllocation_viewsummary() {
		return requestAndAllocation_viewsummary;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement requestAndAllocation_BudgetSubmit;

	public WebElement budget_requestAndAllocation_BudgetSubmit() {
		return requestAndAllocation_BudgetSubmit;
	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement requestAndAllocation_Cancel;

	public WebElement budget_requestAndAllocation_Cancel() {
		return requestAndAllocation_Cancel;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar/ion-buttons[2]/ion-button[1]/ion-icon")
	private WebElement requestAndAllocation_Budgetsave;

	public WebElement budget_requestAndAllocation_Budgetsave() {
		return requestAndAllocation_Budgetsave;
	}

	// Half Yearly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_BudgetHy1;

	public WebElement budget_requestAndAllocation_BudgetHy1() {
		return requestAndAllocation_BudgetHy1;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[2]")
	private WebElement  budget_requestAndAllocation_TableEdit;

	public WebElement  budget_requestAndAllocation_TableEdit() {
		return budget_requestAndAllocation_TableEdit;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_BudgetHy2;

	public WebElement budget_requestAndAllocation_BudgetHy2() {
		return requestAndAllocation_BudgetHy2;
	}

	// Halfyear Remark
	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_BudgetHyremark1;

	public WebElement budget_requestAndAllocation_BudgetHyremark1() {
		return requestAndAllocation_BudgetHyremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_BudgetHyremark2;

	public WebElement budget_requestAndAllocation_BudgetHyremark2() {
		return requestAndAllocation_BudgetHyremark2;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[5]/div[1]")
	private WebElement requestAndAllocation_GetBudgettype;

	public WebElement requestAndAllocation_GetBudgettype() {

		return requestAndAllocation_GetBudgettype;
	}
	
	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/ion-input[1]/input[1]")
	private WebElement requestAndAllocation_BudgetHytype;

	public WebElement requestAndAllocation_BudgetHytype() {

		return requestAndAllocation_BudgetHytype;
	}
	// Quaterly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_BudgetQuaterly0;

	public WebElement budget_requestAndAllocation_BudgetQuaterly0() {
		return requestAndAllocation_BudgetQuaterly0;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_BudgetQuaterly1;

	public WebElement budget_requestAndAllocation_BudgetQuaterly1() {
		return requestAndAllocation_BudgetQuaterly1;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='2']/input")
	private WebElement requestAndAllocation_BudgetQuaterly2;

	public WebElement budget_requestAndAllocation_BudgetQuaterly2() {
		return requestAndAllocation_BudgetQuaterly2;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='3']/input")
	private WebElement requestAndAllocation_BudgetQuaterly3;

	public WebElement budget_requestAndAllocation_BudgetQuaterly3() {
		return requestAndAllocation_BudgetQuaterly3;
	}

	// Quarterly Remark

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark0;

	public WebElement budget_requestAndAllocation_BudgetQuaterlyremark0() {
		return requestAndAllocation_BudgetQuaterlyremark0;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark1;

	public WebElement budget_requestAndAllocation_BudgetQuaterlyremark1() {
		return requestAndAllocation_BudgetQuaterlyremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='2']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark2;

	public WebElement budget_requestAndAllocation_BudgetQuaterlyremark2() {
		return requestAndAllocation_BudgetQuaterlyremark2;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='3']")
	private WebElement requestAndAllocation_BudgetQuaterlyremark3;

	public WebElement budget_requestAndAllocation_BudgetQuaterlyremark3() {
		return requestAndAllocation_BudgetQuaterlyremark3;
	}
	// Monthly

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='0']/input")
	private WebElement requestAndAllocation_Budgetmonth1;

	public WebElement budget_requestAndAllocation_Budgetmonth1() {
		return requestAndAllocation_Budgetmonth1;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='1']/input")
	private WebElement requestAndAllocation_Budgetmonth2;

	public WebElement budget_requestAndAllocation_Budgetmonth2() {
		return requestAndAllocation_Budgetmonth2;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='2']/input")
	private WebElement requestAndAllocation_Budgetmonth3;

	public WebElement budget_requestAndAllocation_Budgetmonth3() {
		return requestAndAllocation_Budgetmonth3;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='3']/input")
	private WebElement requestAndAllocation_Budgetmonth4;

	public WebElement budget_requestAndAllocation_Budgetmonth4() {
		return requestAndAllocation_Budgetmonth4;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='4']/input")
	private WebElement requestAndAllocation_Budgetmonth5;

	public WebElement budget_requestAndAllocation_Budgetmonth5() {
		return requestAndAllocation_Budgetmonth5;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='5']/input")
	private WebElement requestAndAllocation_Budgetmonth6;

	public WebElement budget_requestAndAllocation_Budgetmonth6() {
		return requestAndAllocation_Budgetmonth6;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='6']/input")
	private WebElement requestAndAllocation_Budgetmonth7;

	public WebElement budget_requestAndAllocation_Budgetmonth7() {
		return requestAndAllocation_Budgetmonth7;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='7']/input")
	private WebElement requestAndAllocation_Budgetmonth8;

	public WebElement budget_requestAndAllocation_Budgetmonth8() {
		return requestAndAllocation_Budgetmonth8;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='8']/input")
	private WebElement requestAndAllocation_Budgetmonth9;

	public WebElement budget_requestAndAllocation_Budgetmonth9() {
		return requestAndAllocation_Budgetmonth9;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='9']/input")
	private WebElement requestAndAllocation_Budgetmonth10;

	public WebElement budget_requestAndAllocation_Budgetmonth10() {
		return requestAndAllocation_Budgetmonth10;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='10']/input")
	private WebElement requestAndAllocation_Budgetmonth11;

	public WebElement budget_requestAndAllocation_Budgetmonth11() {
		return requestAndAllocation_Budgetmonth11;
	}

	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-currency[@id='11']/input")
	private WebElement requestAndAllocation_Budgetmonth12;

	public WebElement budget_requestAndAllocation_Budgetmonth12() {
		return requestAndAllocation_Budgetmonth12;
	}

	// Monthly Remark

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='0']")
	private WebElement requestAndAllocation_Budgetmonthremark1;

	public WebElement budget_requestAndAllocation_Budgetmonthremark1() {
		return requestAndAllocation_Budgetmonthremark1;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='1']")
	private WebElement requestAndAllocation_Budgetmonthremark2;

	public WebElement budget_requestAndAllocation_Budgetmonthremark2() {
		return requestAndAllocation_Budgetmonthremark2;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='2']")
	private WebElement requestAndAllocation_Budgetmonthremark3;

	public WebElement budget_requestAndAllocation_Budgetmonthremark3() {
		return requestAndAllocation_Budgetmonthremark3;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='3']")
	private WebElement requestAndAllocation_Budgetmonthremark4;

	public WebElement budget_requestAndAllocation_Budgetmonthremark4() {
		return requestAndAllocation_Budgetmonthremark4;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='4']")
	private WebElement requestAndAllocation_Budgetmonthremark5;

	public WebElement budget_requestAndAllocation_Budgetmonthremark5() {
		return requestAndAllocation_Budgetmonthremark5;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='5']")
	private WebElement requestAndAllocation_Budgetmonthremark6;

	public WebElement budget_requestAndAllocation_Budgetmonthremark6() {
		return requestAndAllocation_Budgetmonthremark6;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='6']")
	private WebElement requestAndAllocation_Budgetmonthremark7;

	public WebElement budget_requestAndAllocation_Budgetmonthremark7() {
		return requestAndAllocation_Budgetmonthremark7;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='7']")
	private WebElement requestAndAllocation_Budgetmonthremark8;

	public WebElement budget_requestAndAllocation_Budgetmonthremark8() {
		return requestAndAllocation_Budgetmonthremark8;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='8']")
	private WebElement requestAndAllocation_Budgetmonthremark9;

	public WebElement budget_requestAndAllocation_Budgetmonthremark9() {
		return requestAndAllocation_Budgetmonthremark9;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='9']")
	private WebElement requestAndAllocation_Budgetmonthremark10;

	public WebElement budget_requestAndAllocation_Budgetmonthremark10() {
		return requestAndAllocation_Budgetmonthremark10;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='10']")
	private WebElement requestAndAllocation_Budgetmonthremark11;

	public WebElement budget_requestAndAllocation_Budgetmonthremark11() {
		return requestAndAllocation_Budgetmonthremark11;
	}

	@FindBy(xpath = "//datatable-body-cell[3]/div/input[@id='11']")
	private WebElement requestAndAllocation_Budgetmonthremark12;

	public WebElement budget_requestAndAllocation_Budgetmonthremark12() {
		return requestAndAllocation_Budgetmonthremark12;
	}

	// TOTAST - CONTAINER
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement Popup_status;

	public WebElement Popup_status() {
		return Popup_status;
	}

	// CAPTURE THE MONTH

	@FindBy(xpath = "//div[contains(text(),'April')]")
	private WebElement month_April;

	public WebElement april_Month() {
		return month_April;
	}

	@FindBy(xpath = "//div[contains(text(),'May')]")
	private WebElement month_May;

	public WebElement may_Month() {
		return month_May;
	}

	@FindBy(xpath = "//div[contains(text(),'June')]")
	private WebElement month_June;

	public WebElement june_Month() {
		return month_June;
	}

	@FindBy(xpath = "//div[contains(text(),'July')]")
	private WebElement month_July;

	public WebElement july_Month() {
		return month_July;
	}

	@FindBy(xpath = "//div[contains(text(),'August')]")
	private WebElement month_August;

	public WebElement august_Month() {
		return month_August;
	}

	@FindBy(xpath = "//div[contains(text(),'September')]")
	private WebElement month_September;

	public WebElement september_Month() {
		return month_September;
	}

	@FindBy(xpath = "//div[contains(text(),'October')]")
	private WebElement month_October;

	public WebElement october_Month() {
		return month_October;
	}

	@FindBy(xpath = "//div[contains(text(),'November')]")
	private WebElement month_November;

	public WebElement november_Month() {
		return month_November;
	}

	@FindBy(xpath = "//div[contains(text(),'December')]")
	private WebElement month_December;

	public WebElement december_Month() {
		return month_December;
	}

	@FindBy(xpath = "//div[contains(text(),'January')]")
	private WebElement month_January;

	public WebElement january_Month() {
		return month_January;
	}

	@FindBy(xpath = "//div[contains(text(),'February')]")
	private WebElement month_February;

	public WebElement february_Month() {
		return month_February;
	}

	@FindBy(xpath = "//div[contains(text(),'March')]")
	private WebElement month_March;

	public WebElement march_Month() {
		return month_March;
	}
	
	// Reports
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='tabs/entities/budget-creation-']")
	private WebElement Reports_Bud_Creation;
	public WebElement Reports_Bud_Creation() {
		return Reports_Bud_Creation;
	}
	
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement Reports_Bud_Creation_BudType;

	public WebElement Reports_Bud_Creation_BudType() {

		return Reports_Bud_Creation_BudType;
	}

	@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]")
	private WebElement  Reports_Bud_Creation_Nextbtn;

	public WebElement Reports_Bud_Creation_Nextbtn() {

		return Reports_Bud_Creation_Nextbtn;
	}
	
	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement Reports_Bud_Creation_ReportIcon;

	public WebElement Reports_Bud_Creation_ReportIcon() {

		return Reports_Bud_Creation_ReportIcon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Enquiry')]")
	private WebElement Reports_Bud_Creation_EnquiryMenu;

	public WebElement Reports_Bud_Creation_EnquiryMenu() {

		return Reports_Bud_Creation_EnquiryMenu;
	}
	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement Reports_Bud_Creation_ViewButton;

	public WebElement Reports_Bud_Creation_ViewButton() {

		return Reports_Bud_Creation_ViewButton;
	}
	@FindBy(xpath = "//ion-label[contains(text(),'Reports')]")
	private WebElement Reports_Bud_Creation_ReportModule;

	public WebElement Reports_Bud_Creation_ReportModule() {

		return Reports_Bud_Creation_ReportModule;
	}
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement ARAP_Report_Module_Date;

	public WebElement ARAP_Report_Module_Date() {

		return ARAP_Report_Module_Date;
	}
	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement ARAP_NextMonth;

	public WebElement ARAPNextMonth() {

		return ARAP_NextMonth;
	}
}
