package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSRECEIVABLE_AccountsReceivableReportObj {
	WebDriver driver;
	public ACCOUNTSRECEIVABLE_AccountsReceivableReportObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/account-receiva']")
	private WebElement accountsReceivable_AccountsReceivableReportTemp;
	public WebElement accountsReceivableReportTempView()
	{
		return accountsReceivable_AccountsReceivableReportTemp;
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement accountsReceivableReport_BusinessPartnerName;
	public WebElement accountsReceivableReportBusinessPartnerName()
	{
		return accountsReceivableReport_BusinessPartnerName;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsReceivableReport_PayableStatus;
	public WebElement accountsReceivableReportPayableStatus()
	{
		return accountsReceivableReport_PayableStatus;
	}
	@FindBy(xpath="//tbody/tr[2]/td[7]/input[1]")
	private WebElement accountsReceivableReport_NextRecord;
	public WebElement accountsReceivableReportNextRecord()
	{
		return accountsReceivableReport_NextRecord;
	}

}
