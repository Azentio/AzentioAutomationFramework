package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_AutoPayoutObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_AutoPayoutObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/223']")
	private WebElement accoutsPayable_payoutTempView;
	public WebElement accounPayablePayoutTempView()
	{
		return accoutsPayable_payoutTempView;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement accoutsPayable_payoutPayoutDate;
	public WebElement accounPayablePayoutPayoutDate()
	{
		return accoutsPayable_payoutPayoutDate;
	}
	@FindBy(xpath="//page-auto-payout-processing-update[1]//ion-col[14]//input")
	private WebElement accountsPayable_PaymentBank;
	public WebElement accoutspYablePaymentBank()
	{
		return accountsPayable_PaymentBank;
	}
	@FindBy(xpath="//page-auto-payout-processing-update[1]//ion-col[15]//input")
	private WebElement accountsPayable_PaymentBankAccount;
	public WebElement accoutspYablePaymentBankAccount()
	{
		return accountsPayable_PaymentBankAccount;
	}
	@FindBy(xpath="//ion-textarea[@name='remarks']//textarea")
	private WebElement accountsPayable_PaymentRemarks;
	public WebElement accoutspYablePaymentRemarks()
	{
		return accountsPayable_PaymentRemarks;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button")
	private WebElement accountsPayable_PaymentTempViewFirstRecord;
	public WebElement accoutspYablePaymenTempViewFirstRecord()
	{
		return accountsPayable_PaymentTempViewFirstRecord;
	}
	@FindBy(xpath="//page-auto-payout-processing-update[1]//ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement accountsPayable_PaymentSaveButton;
	public WebElement accoutspYablePaymentSaveButton()
	{
		return accountsPayable_PaymentSaveButton;
	}
	@FindBy(xpath="//span[contains(text(),'Initiate')]")
	private WebElement accountsPayable_PaymentInitiateButton;
	public WebElement accoutspYablePaymentInitiateButtonButton()
	{
		return accountsPayable_PaymentInitiateButton;
	}
}

