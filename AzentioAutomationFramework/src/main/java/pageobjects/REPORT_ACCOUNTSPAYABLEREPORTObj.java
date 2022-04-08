package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class REPORT_ACCOUNTSPAYABLEREPORTObj {
	WebDriver driver;
	public REPORT_ACCOUNTSPAYABLEREPORTObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='tabs/entities/account-payable-']")
	private WebElement accountsPayable_TempView;
	public WebElement accountsPayableTempView()
	{
		return accountsPayable_TempView;
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement accountsPayableReport_BpName;
	public WebElement accountsPayableReportBpName()
	{
		return accountsPayableReport_BpName;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement accountsPayableReport_DateAsOn;
	public WebElement accountsPayableReportDateAsOn()
	{
		return accountsPayableReport_DateAsOn;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsPayablePayableStatus;
	public WebElement accountsPayablePayableStatu()
	{
		return accountsPayablePayableStatus;
	}
	@FindBy(xpath="//a[contains(text(),'View')]")
	private WebElement accountsPayableReport_ViewButton;
	public WebElement accountsPayableReportViewButton()
	{
		return accountsPayableReport_ViewButton;
	}

}
