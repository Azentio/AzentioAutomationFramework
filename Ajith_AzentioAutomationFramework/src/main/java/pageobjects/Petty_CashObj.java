package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Petty_CashObj {
		 WebDriver driver;
		public Petty_CashObj(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	@FindBy(xpath="//ion-label[contains(text(),'Petty cash')]")
	private WebElement pettyCashModule;
	public WebElement pettyCashModule() {
		return pettyCashModule;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/15']")
	private WebElement fundRequestEyeIcon;
	public WebElement fundRequestEyeIcon() {
		return fundRequestEyeIcon;
	}
	@FindBy(xpath="//ion-col[5]/ion-item")
	private WebElement enterRequestAmout;
	public WebElement enterRequestAmout() {
		return enterRequestAmout;
	}
}

