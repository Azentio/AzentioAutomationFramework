package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_BudgetTransferObj {
	WebDriver driver;

	public BUDGET_BudgetTransferObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/224']")
	private WebElement budget_BudgetTransfer_EyeButton;

	public WebElement budget_BudgetTransfer_EyeButton() {
		return budget_BudgetTransfer_EyeButton;

	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']")
	private WebElement budget_BudgetTransfer_AddButton;

	public WebElement budget_BudgetTransfer_AddButton() {
		return budget_BudgetTransfer_AddButton;

	}

	@FindBy(xpath = "//input[@autocomplete='aa0150548686'] ")
	private WebElement budget_BudgetTransfer_BudgetCodeDropDown;

	public WebElement budget_BudgetTransfer_BudgetCodeDropDown() {
		return budget_BudgetTransfer_BudgetCodeDropDown;

	}

	@FindBy(xpath = "//input[@autocomplete='afee39f55b46'] ")
	private WebElement budget_BudgetTransfer_BudgetYearDropdown;

	public WebElement budget_BudgetTransfer_BudgetYearDropdown() {
		return budget_BudgetTransfer_BudgetYearDropdown;

	}

	@FindBy(xpath = "//input[@autocomplete='ab8339d8a9a3'] ")
	private WebElement budget_BudgetTransfer_Branch;

	public WebElement budget_BudgetTransfer_Branch() {
		return budget_BudgetTransfer_Branch;

	}

	@FindBy(xpath = "//input[@autocomplete='a573dc6c9804'] ")
	private WebElement budget_BudgetTransfer_TransferToBudgetCode;

	public WebElement budget_BudgetTransfer_TransferToBudgetCode() {
		return budget_BudgetTransfer_TransferToBudgetCode;

	}

	@FindBy(xpath = "//input[@id='totalBudgetAmount']")
	private WebElement budget_BudgetTransfer_TotalBudgetAmount;

	public WebElement budget_BudgetTransfer_TotalBudgetAmount() {
		return budget_BudgetTransfer_TotalBudgetAmount;

	}

	@FindBy(xpath = "//input[@id='trxAmt']")
	private WebElement budget_BudgetTransfer_TransferAmount;

	public WebElement budget_BudgetTransfer_TransferAmount() {
		return budget_BudgetTransfer_TransferAmount;

	}

	@FindBy(xpath = "//input[@autocomplete=\"adfd9fb7b543\"] ")
	private WebElement budget_BudgetTransfer_CurrencyChange;

	public WebElement budget_BudgetTransfer_CurrencyChange() {
		return budget_BudgetTransfer_CurrencyChange;

	}

	@FindBy(xpath = "//input[@class='datatable ng-valid ng-star-inserted ng-dirty ng-touched']")
	private WebElement budget_BudgetTransfer_ApportionedAmountA;

	public WebElement budget_BudgetTransfer_ApportionedAmountA() {
		return budget_BudgetTransfer_ApportionedAmountA;

	}

	@FindBy(xpath = "(//input[@class='datatable ng-untouched ng-pristine ng-valid ng-star-inserted'])[1]")
	private WebElement budget_BudgetTransfer_fromNewAmountA;

	public WebElement budget_BudgetTransfer_fromNewAmountA() {
		return budget_BudgetTransfer_fromNewAmountA;

	}

	@FindBy(xpath = "(//input[@class='datatable ng-valid ng-star-inserted ng-dirty ng-touched'])[2]")
	private WebElement budget_BudgetTransfer_ApportionedAmountB;

	public WebElement budget_BudgetTransfer_ApportionedAmountB() {
		return budget_BudgetTransfer_ApportionedAmountB;

	}

	@FindBy(xpath = "(//input[@class='datatable ng-untouched ng-pristine ng-valid ng-star-inserted'])[2]")
	private WebElement budget_BudgetTransfer_NewAmountB;

	public WebElement budget_BudgetTransfer_NewAmountB() {
		return budget_BudgetTransfer_NewAmountB;

	}

	@FindBy(xpath = "//ion-button[@class=\"ng-star-inserted ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated\"]")
	private WebElement budget_BudgetTransfer_SaveButton;

	public WebElement budget_BudgetTransfer_SaveButton() {
		return budget_BudgetTransfer_SaveButton;

	}

}



