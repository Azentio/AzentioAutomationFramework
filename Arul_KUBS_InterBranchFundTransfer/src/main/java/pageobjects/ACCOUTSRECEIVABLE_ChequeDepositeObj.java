package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUTSRECEIVABLE_ChequeDepositeObj {
	WebDriver driver;
	public ACCOUTSRECEIVABLE_ChequeDepositeObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/203']")
	private WebElement accountsReceivable_ChecqueDeposite;
	public WebElement AccountsReceivableChecqueDeposite()
	{
		return accountsReceivable_ChecqueDeposite;
	}
	
	@FindBy(xpath="//page-banking-cheque-clearing-update[1]//ion-col[4]//input")
	private WebElement accountsReceivable_BankAccount;
	public WebElement AccountsReceivableBankAccount()
	{
		return accountsReceivable_BankAccount;
	}
	
	@FindBy(xpath="//ion-row[2]//ion-button")
	private WebElement accountsReceivable_GenerateDepositeBill;
	public WebElement AccountsReceivableGenerateDepositeBill()
	{
		return accountsReceivable_GenerateDepositeBill;
	}
	
	@FindBy(xpath="//ion-col[3]//span[@class='input-calendar']")
	private WebElement accountsPayable_DepositeDate;
	public WebElement accountsPayableDepositeDate()
	{
		return accountsPayable_DepositeDate;
	}
	
	@FindBy(xpath="//button[@aria-label='Next month']")
	private WebElement accountsPayable_DepositeNextMonth;
	public WebElement accountsPayableDepositeNextMonth()
	{
		return accountsPayable_DepositeNextMonth;
	}
	@FindBy(xpath="//form[2]//a[@aria-label='go to next page']")
	private WebElement accountsPayable_DepositeNextPage;
	public WebElement accountsPayableDepositeNextPage()
	{
		return accountsPayable_DepositeNextPage;
	}
}
