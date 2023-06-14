package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_PoCreationObj {
	WebDriver driver;
	public ARAP_PoCreationObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/134']")
	private WebElement poCreation_viewButton;
	public WebElement poCreationViewButton()
	{
		return poCreation_viewButton;
	}
	@FindBy(xpath="//ion-icon[@title='Enable Search']")
	private WebElement poCreation_searchIcon;
	public WebElement poCreationSearchIcon()
	{
		return poCreation_searchIcon;
	}
	@FindBy(xpath="//input[@placeholder='Search PO Status']")
	private WebElement poStatus;
	public WebElement poStatus()
	{
		return poStatus;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row//datatable-body-cell[3]//span")
	private WebElement Po_PoNumber;
	public WebElement poPoNumber()
	{
		return Po_PoNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row//datatable-body-cell[7]//span")
	private WebElement  po_BusinessPartner;
	public WebElement poBusinessPartner()
	{
		return po_BusinessPartner;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement approved_PoNumber;
	public WebElement approvedPoNumber()
	{
		return approved_PoNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[7]//span")
	private WebElement approved_BpName;
	public WebElement approvedBpName()
	{
		return approved_BpName;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement approvedPo_PoType;
	public WebElement approvedPoType()
	{
		return approvedPo_PoType;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement approvedPo_ContractNumber;
	public WebElement approvedPoContractNumber()
	{
		return approvedPo_ContractNumber;
	}
	
	

}
