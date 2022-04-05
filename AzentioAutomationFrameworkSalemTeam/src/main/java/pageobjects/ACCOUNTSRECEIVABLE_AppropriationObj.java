package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSRECEIVABLE_AppropriationObj {
	WebDriver driver;
	
	public ACCOUNTSRECEIVABLE_AppropriationObj(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/200']")
	private WebElement accountsReceivable_viewButton;
	public WebElement accountsPayableViewButton()
	{
		return accountsReceivable_viewButton;
	}
	@FindBy(xpath="//ul[1]/li[8]/a[1]")
	private WebElement accountsReceivable_nextButton;
	public WebElement accontsReceivableNextButton()
	{
		return accountsReceivable_nextButton;
	}

}
