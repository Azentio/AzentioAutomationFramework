package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PoReportObj {
	WebDriver driver;
public ACCOUNTSPAYABLE_PoReportObj(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/po-report']")
private WebElement accountsPayable_PoReportTempView;
public WebElement accountsPayablePoReportTempView()
{
	return accountsPayable_PoReportTempView;
}

}
