package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLEREPORT_PayoutReportObj {
	WebDriver driver;
	
	public ACCOUNTSPAYABLEREPORT_PayoutReportObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/payout-report']")
	private WebElement accountsPayable_PayoutRemportTempView;
	public WebElement accountsPayablePayoutReportTempView()
	{
		return accountsPayable_PayoutRemportTempView;
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement accountsPayable_PayoutBusinessPartnerName;
	public WebElement accountsPayablePayoutBusinessPartnerName()
	{
		return accountsPayable_PayoutBusinessPartnerName;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsPayable_PayoutStatus;
	public WebElement accountsPayablePayoutStatus()
	{
		return accountsPayable_PayoutStatus;
	}
	@FindBy(xpath="//tbody/tr[2]/td[7]/input[1]")
	private WebElement accountsPayableReport_NextRecord;
	public WebElement accountsPayableReportNextRecord()
	{
		return accountsPayableReport_NextRecord;
	}

}
