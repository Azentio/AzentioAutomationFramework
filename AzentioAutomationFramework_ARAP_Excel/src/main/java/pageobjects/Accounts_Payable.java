package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts_Payable {
	WebDriver driver;
	public Accounts_Payable(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//datatable-header-cell[6]/div[1]/ion-input[1]/input[1]")
	private WebElement searchGrn_Status;
	public WebElement searchGrnStatus() {
		return searchGrn_Status;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/133\"]")
	private WebElement grn_EyeIcon;
	public WebElement grnEyeIcon() {
		return grn_EyeIcon;
	}
	
}
