package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_StockReturnFromBranch {

	WebDriver driver;

	public INVENTORY_StockReturnFromBranch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/12']")
	private WebElement stock_return_from_branch_eye_icon;

	public WebElement stcokReturnFromBranchEyeIcon() {
		return stock_return_from_branch_eye_icon;

	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']")
	private WebElement stock_return_from_branch_add_icon;

	public WebElement stockReturnFromBranchAddIcon() {
		return stock_return_from_branch_add_icon;
	}

	@FindBy(xpath = "//ion-col[1]//input")
	private WebElement stock_return_from_branch_request_reference_number;

	public WebElement stcokReturnFromBranchRequest_ReferenceNumber() {
		return stock_return_from_branch_request_reference_number;

	}
}
