package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_AccountsPayableReportObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_AccountsPayableReportObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement accountsPayableReport_BpName;
	public WebElement accountspayableReportBpName()
	{
		return accountsPayableReport_BpName;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement accountsPayableReport_DateAsOn;
	public WebElement accountsPayableDateAsOn()
	{
		return accountsPayableReport_DateAsOn;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsPayableReport_PayableStatus;
	public WebElement accountsPayablePayableStatus()
	{
		return accountsPayableReport_PayableStatus;
	}
	@FindBy(xpath="//tbody/tr[2]/td[7]/input[1]")
	private WebElement accountsPayableReport_NextRecord;
	public WebElement accountsPayableReportNextRecord()
	{
		return accountsPayableReport_NextRecord;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='tabs/entities/account-payable-']")
	private WebElement accountsPayableReport_TempView;
	public WebElement accountsPayableReportTempView()
	{
		return accountsPayableReport_TempView;
	}
	

}
