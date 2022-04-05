package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ar_Ap_AdjustmentObj {
	WebDriver driver;
	public Ar_Ap_AdjustmentObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//ion-label[text()=' Adjustments ( AR and AP) ']")
	private WebElement ClickArApAdjustmentModule;
	public WebElement ClickArApAdjustmentModule() {
		return ClickArApAdjustmentModule;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/196']")
	private WebElement adjustment_view_button;
	public WebElement adjustmentViewButton()
	{
		return adjustment_view_button;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement arApAddIcon;
	public WebElement arApAddIcon() {
		return arApAddIcon;
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

}
