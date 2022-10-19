package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_InventoryRequestObj {
	WebDriver driver;
	public INVENTORY_InventoryRequestObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/2'])[2]")
	private WebElement inventory_request_view_icon;
	public WebElement inventoryRequestViewIcon()
	{
	    return inventory_request_view_icon;	
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div[1]//ion-button[1]")
	private WebElement inventory_request_requested_inventory;
	public WebElement inventoryRequestRequestedInventory()
	{
		return inventory_request_requested_inventory;
		
	}
	@FindBy(xpath="//ion-select-option[@id='ion-selopt-25']")
	private WebElement inventory_request_inventory_item;
	public WebElement inventoryRequestInventoryItem()
	{
		return inventory_request_inventory_item;
	}

}
