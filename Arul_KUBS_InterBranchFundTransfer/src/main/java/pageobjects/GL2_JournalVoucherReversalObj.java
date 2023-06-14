package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL2_JournalVoucherReversalObj {
	WebDriver driver;

	public GL2_JournalVoucherReversalObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//EyeButton
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/7']")
	private WebElement gL2_JournalVoucherReversal_EyeButton;

	public WebElement gL2_JournalVoucherReversal_EyeButton() {
		return gL2_JournalVoucherReversal_EyeButton;

	}
	
	//PencilIcon first record
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[2]")
	private WebElement gL2_JournalVoucherReversal_PencilIcon;

	public WebElement gL2_JournalVoucherReversal_PencilIcon() {
		return gL2_JournalVoucherReversal_PencilIcon;

	}
	// Search Reversed JV yes
	@FindBy(xpath = "//label[text()=' JV Reversed ']//parent::div//child::input")
	private WebElement gL2_JVReversedStatus;

	public WebElement gL2_JVReversedStatus() {
		return gL2_JVReversedStatus;

	}
	
	
	
	
	

}
