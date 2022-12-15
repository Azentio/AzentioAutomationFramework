package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsReceivable_UpdateChequeStatusObj {
	WebDriver driver;

	public AccountsReceivable_UpdateChequeStatusObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Update Cheque Status SUBMODULE  //

	// eye button of update cheque status
	@FindBy(xpath = "//div[5]//ion-menu-toggle[7]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_UpdateChequeStatus_EyeButton;

	public WebElement accountsReceivable_UpdateChequeStatus_EyeButton() {
		return accountsReceivable_UpdateChequeStatus_EyeButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountsReceivable_UpdateChequeStatus_Search;

	public WebElement accountsReceivable_UpdateChequeStatus_Search() {
		return accountsReceivable_UpdateChequeStatus_Search;
	}

	// Search by cheque number
	@FindBy(xpath = "//datatable-header-cell[3]/div/ion-input/input")
	private WebElement accountsReceivable_UpdateChequeStatus_ChequeNumber;

	public WebElement accountsReceivable_UpdateChequeStatus_ChequeNumber() {
		return accountsReceivable_UpdateChequeStatus_ChequeNumber;
	}
	
	// Get slip number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div/span")
	private WebElement accountsReceivable_UpdateChequeStatus_SlipNumber;
	
	public WebElement accountsReceivable_UpdateChequeStatus_SlipNumber() {
		return accountsReceivable_UpdateChequeStatus_SlipNumber;
	}
}
