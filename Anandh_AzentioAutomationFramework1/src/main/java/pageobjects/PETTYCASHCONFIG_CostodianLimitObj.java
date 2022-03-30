package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PETTYCASHCONFIG_CostodianLimitObj {
	WebDriver driver;
	public PETTYCASHCONFIG_CostodianLimitObj(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/38']")
	private WebElement PettyCashConfig_CostodianLimitviewButton;
	public WebElement pettyCashConfigCostodianLimitViewButton()
	{
		return PettyCashConfig_CostodianLimitviewButton; 
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement costodianLimit_UserName;
	public WebElement costodianLimitUserName()
	{
		return costodianLimit_UserName;
	}
	@FindBy(xpath="//input[@id='maxLimit']")
	private WebElement costodianLimit_MaxLimit;
	public WebElement costodianLimitMaxLimit()
	{
		return costodianLimit_MaxLimit;
	}
	@FindBy(xpath="//input[@id='floatLimit']")
	private WebElement costodianLimit_ReplenishLimit;
	public WebElement costodianLimitReplenishLimit()
	{
		return costodianLimit_ReplenishLimit;
	}
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement constodianLimit_CurrencyType;
	public WebElement costodianLimitCurrencyLimit()
	{
		return constodianLimit_CurrencyType;
	}
	@FindBy(xpath="//page-user-limit-update//ion-toolbar//ion-buttons[2]//ion-button")
	private WebElement costodianLimit_SaveButton;
	public WebElement costodianLimitSaveButton()
	{
		return costodianLimit_SaveButton;
	}
	

}
