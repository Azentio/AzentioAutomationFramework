package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_SettlementObj {
	WebDriver driver;
	public Payment_SettlementObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[3]//ion-menu-toggle[5]//ion-item//ion-buttons//ion-button[2]")
	private WebElement paymentSettlementEyeIcon;
    @FindBy(xpath="//ion-fab-button[@id='addBtn']")
    private WebElement paymentSettlementAddIcon;
    @FindBy(xpath="//datatable-header-cell[8]/div[1]/ion-input[1]/input[1]")
    private WebElement transactionStatus;
    @FindBy(xpath="//datatable-header-cell[4]/div[1]/ion-input[1]/input[1]")
    private WebElement transactionNumber;
    @FindBy(xpath="//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
    private WebElement paymentOptions;
    @FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
    private WebElement selectBuisnessPartner;
    @FindBy(xpath="//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
    private WebElement getBuisnessPartnerName;
    @FindBy(xpath="(//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]/span[1])[2]")
    private WebElement getActiveBillBuisnessPartner;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")
    private WebElement billListViewCheckBox;
    @FindBy(xpath="//datatable-row-wrapper[2]/datatable-body-row/div/datatable-body-cell/div/ion-checkbox")
    private WebElement billListViewCheckBox2;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div/datatable-body-cell[15]/div")
    private WebElement getNetPayableAmountinBillList;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div/datatable-body-cell[12]/div")
    private WebElement getNetAdjustedAmountList2;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div/datatable-body-cell[13]/div")
    private WebElement tdspercentfromList2;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div/datatable-body-cell[14]/div")
    private WebElement tdsvaluefromlist2;
    @FindBy(xpath="(//datatable-pager/ul/li[8]/a)[2]")
    private WebElement nextPageInListView;
    @FindBy(xpath="(//span[@class='input-calendar'])[2]")
    private WebElement calenderInPaymentSettlement;
    // change daily date in xpath
    @FindBy(xpath="//span[text()='10']")
    private WebElement date;
    @FindBy(xpath="//ion-col[9]/ion-item/ion-input/input[@name='paymentDesc']")
    private WebElement description;
    @FindBy(xpath="(//ion-toolbar[1]//ion-buttons[2])[3]")
    private WebElement savebutton;
    @FindBy(xpath="(//span[@class='alert-button-inner sc-ion-alert-md'])[2]")
    private WebElement clickYespopup;
    @FindBy(xpath="(//span[@class='alert-button-inner sc-ion-alert-md'])[1]")
    private WebElement clickNopopup;
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
    private WebElement clickFirstPaymentInListView;
    
	public WebElement getGetBuisnessPartnerName() {
		return getBuisnessPartnerName;
	}
	public WebElement getTransactionNumber() {
		return transactionNumber;
	}
	public WebElement getTransactionStatus() {
		return transactionStatus;
	}
	public WebElement getNextPageInListView() {
		return nextPageInListView;
	}
	public WebElement getGetNetAdjustedAmountList2() {
		return getNetAdjustedAmountList2;
	}
	public WebElement getTdspercentfromList2() {
		return tdspercentfromList2;
	}
	public WebElement getTdsvaluefromlist2() {
		return tdsvaluefromlist2;
	}
	public WebElement getBillListViewCheckBox2() {
		return billListViewCheckBox2;
	}
	public WebElement getClickFirstPaymentInListView() {
		return clickFirstPaymentInListView;
	}
	public WebElement getClickYespopup() {
		return clickYespopup;
	}
	public WebElement getClickNopopup() {
		return clickNopopup;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getDate() {
		return date;
	}
	public WebElement getCalenderInPaymentSettlement() {
		return calenderInPaymentSettlement;
	}
	public WebElement getGetNetPayableAmountinBillList() {
		return getNetPayableAmountinBillList;
	}
	public WebElement getBillListViewCheckBox() {
		return billListViewCheckBox;
	}
	public WebElement getGetActiveBillBuisnessPartner() {
		return getActiveBillBuisnessPartner;
	}
	public WebElement getPaymentSettlementEyeIcon() {
		return paymentSettlementEyeIcon;
	}
	public WebElement getPaymentSettlementAddIcon() {
		return paymentSettlementAddIcon;
	}
	public WebElement getPaymentOptions() {
		return paymentOptions;
	}
	public WebElement getSelectBuisnessPartner() {
		return selectBuisnessPartner;
	}
	  @FindBy(xpath="(//ion-toolbar[1]//ion-buttons[2])[3]")
	  private WebElement accountsPayable_saveButton;
	  public WebElement accountsPayableSaveButton()
	  {
		  return accountsPayable_saveButton;
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
	  @FindBy(xpath="//ion-col[3]//input")
	  private WebElement accountsPayable_paymentSettlementBpName;
	  public WebElement accountsPayablePayementSettlementBpNAme()
	  {
		  return accountsPayable_paymentSettlementBpName;
	  }
	  @FindBy(xpath="(//i[@class='datatable-icon-right'])[1]")
	  private WebElement accountsPayable_paymentSettlementNextRecord;
	  public WebElement accountsPayablePayementSettlementNextRecord()
	  {
		  return accountsPayable_paymentSettlementNextRecord;
	  }
	  @FindBy(xpath="//input[@placeholder='Search Txn Status']")
	  private WebElement paymentSettlement_SearchTXNNumber;
	  public WebElement paymentSettlementSearchTXNNumber()
	  {
		  return paymentSettlement_SearchTXNNumber;
	  }
	  @FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	  private WebElement accountsPayable_ApprovedSettlementReferenceNumber;
	  public WebElement accountsPayableApprovedSettlementRefNo()
	  {
		  return accountsPayable_ApprovedSettlementReferenceNumber;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
