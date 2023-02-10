package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_AdjustmentsObj {
	WebDriver driver;
	public ARAP_AdjustmentsObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/196']")
	private WebElement adjustment_view_button;
	public WebElement adjustmentViewButton()
	{
		return adjustment_view_button;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[2]//input")
	private WebElement adjustment_BpName;
	public WebElement adjustmentBpName()
	{
		return adjustment_BpName;
	}
	@FindBy(xpath="//ion-col[6]//input")
	private WebElement adjustment_adjustmentType;
	public WebElement adjustmentadjustmentType()
	{
		return adjustment_adjustmentType;
	}
	@FindBy(xpath="//ion-col[7]//input")
	private WebElement adjustment_itemType;
	public WebElement adjustmentItemType()
	{
		return adjustment_itemType;
	}
	@FindBy(xpath="//ion-col[8]//input")
	private WebElement adjustment_adjustmentReference;
	public WebElement adjustmentAdjustmentReference()
	{
		return adjustment_adjustmentReference;
	}
	@FindBy(xpath="//ng-dropdown-panel[1]/div[1]/div[2]/div[7]/span[1]")
	private WebElement adjustment_dropdownPurchaseOrder;
	public WebElement adjustmentDropdownPurchaseOrder()
	{
		return adjustment_dropdownPurchaseOrder;
	}
	@FindBy(xpath="(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement adjustment_AdjustmentSaveButton;
	public WebElement adjustmentSaveButton()
	{
		return adjustment_AdjustmentSaveButton;
	}
	
	@FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement adjustment_AlertClose;

	public WebElement adjustment_AlertClose() {
		return adjustment_AlertClose;
	}
	@FindBy(xpath="//div[contains(text(),'No items found')]")
	private WebElement adjustment_AdjustmentReference;
	public WebElement adjustmentAdjustmentReferenceNodata()
	{
		return adjustment_AdjustmentReference;
	}
	@FindBy(xpath="//input[@placeholder='Search Adjustment Item Type']")
	private WebElement adjustement_SearchARAdvance;
	public WebElement adjustementSearchARAdvance()
	{
		return adjustement_SearchARAdvance;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement adjustement_CancelledAdvanceFirstRecord;
	public WebElement adjustementCancelledAdvanceFirstRecord()
	{
		return adjustement_CancelledAdvanceFirstRecord;
	}



}
