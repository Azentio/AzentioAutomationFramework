package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PayementSettlementObj {
	WebDriver driver;
  public ACCOUNTSPAYABLE_PayementSettlementObj(WebDriver driver)
  {
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
  }
  @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/195']")
  private WebElement accountsPayable_paymentSettlementViewIcon;
  public WebElement accountsPayablePayementSettlementViewIcon()
  {
	  return accountsPayable_paymentSettlementViewIcon;
  }
  @FindBy(xpath="//ion-col[2]//input")
  private WebElement accountsPayable_paymentSettlementPaymentOption;
  public WebElement accountsPayablePayementSettlementPaymentOption()
  {
	  return accountsPayable_paymentSettlementPaymentOption;
  }
  @FindBy(xpath="(//i[@class='datatable-icon-right'])[2]")
  private WebElement accountsPayable_paymentSettlementNextRecord;
  public WebElement accountsPayablePayementSettlementNextRecord()
  {
	  return accountsPayable_paymentSettlementNextRecord;
  }
  @FindBy(xpath="(//li[@class='disabled']/a/i)[1]")
  private WebElement accountsPayable_paymentSettlementDisabledNext;
  public WebElement accountsPayablePayementSettlementdisabledNext()
  {
	  return accountsPayable_paymentSettlementDisabledNext;
  } 
  @FindBy(xpath="//ion-col[3]//input")
  private WebElement accountsPayable_paymentSettlementBpName;
  public WebElement accountsPayablePayementSettlementBpNAme()
  {
	  return accountsPayable_paymentSettlementBpName;
  } 
  @FindBy(xpath="(//span[@class='input-calendar'])[2]")
  private WebElement accountsPayable_paymentSettlementValueDate;
  public WebElement accountsPayablePayementSettlementValueDate()
  {
	  return accountsPayable_paymentSettlementValueDate;
  } 
  @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-checkbox[1]")
  private WebElement first_record;
  public WebElement firstRecord()
  {
	  return first_record;
  }
  @FindBy(xpath="//ion-col[9]//input")
  private WebElement accountsPayable_Description;
  public WebElement accountsPayableDescription()
  {
	  return accountsPayable_Description;
  }
  @FindBy(xpath="//span[contains(text(),'Yes')]")
  private WebElement accountsPayable_alertYes;
  public WebElement accountsPayableAlertYes()
  {
	  return accountsPayable_alertYes;
  }
  @FindBy(xpath="(//ion-toolbar[1]//ion-buttons[2])[3]")
  private WebElement accountsPayable_saveButton;
  public WebElement accountsPayableSaveButton()
  {
	  return accountsPayable_saveButton;
  }
  @FindBy(xpath="//ion-col[6]//input")
  private WebElement accountsPayable_adjustedAmmount;
  public WebElement accountsPayableAdjustedAmmount()
  {
	  return accountsPayable_adjustedAmmount;
  } 
  @FindBy(xpath="//ion-col[7]//input")
  private WebElement accountsPayable_tdsAmmount;
  public WebElement accountsPayableTDSAmmount()
  {
	  return accountsPayable_tdsAmmount;
  }
  @FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
  private WebElement accountsPayable_ApprovedSettlementReferenceNumber;
  public WebElement accountsPayableApprovedSettlementRefNo()
  {
	  return accountsPayable_ApprovedSettlementReferenceNumber;
  }
}
