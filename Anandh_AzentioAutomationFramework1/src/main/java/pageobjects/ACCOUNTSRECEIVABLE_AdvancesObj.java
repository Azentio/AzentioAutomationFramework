package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSRECEIVABLE_AdvancesObj {
	WebDriver driver;
      public ACCOUNTSRECEIVABLE_AdvancesObj(WebDriver driver)
      {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
      }
	
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/190']")
	private WebElement accountsreceivable_advancesViewIcon;
	public WebElement accountsreceivableAdvancesViewIcon()
	{
		return accountsreceivable_advancesViewIcon;
	}
	@FindBy(xpath="//input[@placeholder='Search ADV Status']")
	private WebElement accountsreceivable_advStatusSearch;
	public WebElement accountsreceivableAdvancesADVStatusSearch()
	{
		return accountsreceivable_advStatusSearch;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement accountsreceivable_advancesADVNumber;
	public WebElement accountsreceivableAdvancesADVNumber()
	{
		return accountsreceivable_advancesADVNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement accountsreceivable_advancesPoNumber;
	public WebElement accountsreceivableAdvancesPoNumber()
	{
		return accountsreceivable_advancesPoNumber;
	}
	@FindBy(xpath="//ion-row[1]//ion-col[2]//input")
	private WebElement accountsreceivable_advanceReceivableName;
	public WebElement accountsreceivableAdvancesReceivableName()
	{
		return accountsreceivable_advanceReceivableName;
	}
	@FindBy(xpath="//ion-row[1]//ion-col[3]//input")
	private WebElement accountsreceivable_advanceBpNAme;
	public WebElement accountsreceivableAdvancesBpName()
	{
		return accountsreceivable_advanceBpNAme;
	}
	@FindBy(xpath="//input[@placeholder='Search Receivable Name']")
	  private WebElement accountsReceivable_receivableName;
	  public WebElement accountsReceivablereceivableName()
	  {
		  return accountsReceivable_receivableName;
	  }
	  @FindBy(xpath="//ion-row[1]/ion-col[2]//input")
	  private WebElement accountsReceivable_receivableNameInput;
	  public WebElement accountsReceivablereceivableNameInput()
	  {
		  return accountsReceivable_receivableNameInput;
	  }
	  @FindBy(xpath="//ion-row[1]//ion-col[3]//input")
	  private WebElement accountsReceivable_businessPartnerEmployeeName;
	  public WebElement accountsReceivablereceivablebusinessPartnerEmployeeName()
	  {
		  return accountsReceivable_businessPartnerEmployeeName;
	  }
	  @FindBy(xpath="//ion-row[3]//ion-col[1]//input")
	  private WebElement accountsReceivable_paymentMode;
	  public WebElement accountsReceivablereceivablePaymentMode()
	  {
		  return accountsReceivable_paymentMode;
	  }
	  @FindBy(xpath="//ion-row[3]//ion-col[2]//input")
	  private WebElement accountsReceivable_Ammount;
	  public WebElement accountsReceivableAmmount()
	  {
		  return accountsReceivable_Ammount;
	  }
	  @FindBy(xpath="//ion-row[3]//ion-col[3]//input")
	  private WebElement accountsReceivable_currencyType;
	  public WebElement accountsReceivableCurrencyType()
	  {
		  return accountsReceivable_currencyType;
	  }
	  @FindBy(xpath="//ion-row[3]//ion-col[5]//input")
	  private WebElement accountsReceivable_Description;
	  public WebElement accountsReceivableDescription()
	  {
		  return accountsReceivable_Description;
	  }
	  @FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	  private WebElement accountsReceivable_ApprovedFirstRecord;
	  public WebElement accountsReceivableApprovedFirstRecord()
	  {
		return accountsReceivable_ApprovedFirstRecord;
	  }
}
