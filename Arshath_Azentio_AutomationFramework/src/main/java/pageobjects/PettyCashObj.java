package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PettyCashObj {
	 
	WebDriver driver;

	public PettyCashObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pettyCash button
	
	@FindBy(xpath = "//ion-label[contains(text(),'Petty cash')]")
	private WebElement pettyCash_Button;

	public WebElement pettyCash_Button() {
		return pettyCash_Button;
	}
	@FindBy(xpath = "//ion-list[1]/div[8]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement fundRequest_EyeButton;

	public WebElement fundRequest_EyeButton() {
		return fundRequest_EyeButton;
	}
	@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement fundRequest_AddButton;

	public WebElement fundRequest_AddButton() {
		return fundRequest_AddButton;
	}
	@FindBy(xpath = "//input[@id='requestAmt']")
	private WebElement requestAmount_TextBox;

	public WebElement requestAmount_TextBox() {
		return requestAmount_TextBox;
	}
	@FindBy(xpath = "//page-petty-cash-fund-req-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement pettyCashFundRequest_SaveButton;

	public WebElement pettyCashFundRequest_SaveButton() {
		return pettyCashFundRequest_SaveButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Approve')]")
	private WebElement ReviewerPettyCash_ApproveButton;

	public WebElement ReviewerPettyCash_ApproveButton() {
		return ReviewerPettyCash_ApproveButton;
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ARAP_Notification_Close;

	public WebElement ARAP_Notification_Close() {

		return ARAP_Notification_Close;
	}
	
	
	
	
	
	
	
	
	
}