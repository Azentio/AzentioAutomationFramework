package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_ManualPayoutObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_ManualPayoutObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/222']")
private WebElement accountsPayable_ManualPayoutViewButton;
public WebElement accountsPayable_ManualPayoutViewButton()
{
	return accountsPayable_ManualPayoutViewButton;
}
@FindBy(xpath="//input[@placeholder='Search Payout Status']")
private WebElement accountsPayable_PayoutStatus;
public WebElement accountsPayablePayoutStatus()
{
	return accountsPayable_PayoutStatus;
}
@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[8]//span")
private WebElement approved_PayoutReferenceNumber;
public WebElement approvedManualPayoutReferenceNumber()
{
	return approved_PayoutReferenceNumber;
}
@FindBy(xpath="//input[@placeholder='Search Payout Number']")
private WebElement accountsPayable_SearchApprovedPayoutNumber;
public WebElement accountsPayableSearchApprovvedPayoutNumber()
{
	return accountsPayable_SearchApprovedPayoutNumber;
}
@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
private WebElement accountsPayable_ApprovedBpName;
public WebElement accountsPayableApprovedBpName()
{
	return accountsPayable_ApprovedBpName;
}
@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
private WebElement accountsPayable_PayoutRecord;
public WebElement accountsPayablePayoutRecord()
{
	return accountsPayable_PayoutRecord;
}
@FindBy(xpath="//page-manual-payout-processing-update//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
private WebElement accountsPayable_GetAdvanceReferenceNumber;
public WebElement accountsPayableGetAdvanceReferenceNumber()
{
	return accountsPayable_GetAdvanceReferenceNumber;
}
@FindBy(xpath="//input[@placeholder='Search Payment Mode']")
private WebElement accountsPayable_ManualPayoutSearchPaymentMode;
public WebElement accountsPayableManualPayoutSearchPaymentMode()
{
	return accountsPayable_ManualPayoutSearchPaymentMode;
}
@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[7]//span")
private WebElement accountsPayable_ManualPayoutPayoutDate;
public WebElement accountsPayableManualPayoutPayoutDate()
{
	return accountsPayable_ManualPayoutPayoutDate;
}
@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[2]//span[1]")
private WebElement accountsPayable_ManualPayotBranchName;
public WebElement accountsPayableManualPayoutBranchName()
{
	return accountsPayable_ManualPayotBranchName;
}
}
