package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArAp_Cancellation_of_vendorObj {
	WebDriver driver;
	public ArAp_Cancellation_of_vendorObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//ion-segment/ion-segment-button[2]")
	private WebElement optionicon;
	@FindBy(xpath="//ion-label[contains(text(),'Accounts payable')]")
	private WebElement accountspayable;
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/130']")
	private WebElement apContracteyeicon;
	@FindBy(xpath="//ion-icon[@aria-label='search']")
	private WebElement apcontractserachicon;
	@FindBy(xpath="//ion-input[@ng-reflect-placeholder='Search Contract Status']/input")
	private WebElement searchcontractstatus;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[8]/div[1]/ion-input[1]/input[1]")
	private WebElement contracteyeicon;
	@FindBy(xpath="//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement buisnessPartnerNameinContract;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[7]/div[1]/ion-input[1]/input[1]")
	private WebElement conbpname;
	@FindBy(xpath="//ion-input[@xpath=\"1\"]")
	private WebElement contractname;
	@FindBy(xpath="//div[@aria-haspopup='listbox']")
	private WebElement contractstatus;
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/134']")
	private WebElement vendorpoeyeicon;
	@FindBy(xpath="//ion-icon[@aria-label='search']")
	private WebElement vendorposearch;
	@FindBy(xpath="//ion-input[@ng-reflect-placeholder='Search Business Partner']/input")
	private WebElement vendorposearchbpname;
	@FindBy(xpath="(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])[2]")
	private WebElement clickEyeiconInListView;
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement pocontracteyeicon;
	@FindBy(xpath="//ng-select[@ng-reflect-model='89001']")
	private WebElement pobpname;
	@FindBy(xpath="//ng-select[@ng-reflect-model=\"35668\"]")
	private WebElement postatus;
	
	public WebElement getBuisnessPartnerNameinContract() {
		return buisnessPartnerNameinContract;
	}
	public WebElement getClickEyeiconInListView() {
		return clickEyeiconInListView;
	}
	public WebElement getOptionicon() {
		return optionicon;
	}
	public WebElement getConbpname() {
		return conbpname;
	}
	public WebElement getContractstatus() {
		return contractstatus;
	}
	public WebElement getVendorpoeyeicon() {
		return vendorpoeyeicon;
	}
	public WebElement getVendorposearch() {
		return vendorposearch;
	}
	public WebElement getVendorposearchbpname() {
		return vendorposearchbpname;
	}
	public WebElement getPocontracteyeicon() {
		return pocontracteyeicon;
	}
	public WebElement getPobpname() {
		return pobpname;
	}
	public WebElement getPostatus() {
		return postatus;
	}
	public WebElement getAccountspayable() {
		return accountspayable;
	}
	public WebElement getApeyeicon() {
		return apContracteyeicon;
	}
	public WebElement getApserachicon() {
		return apcontractserachicon;
	}
	public WebElement getSearchcontractstatus() {
		return searchcontractstatus;
	}
	public WebElement getContracteyeicon() {
		return contracteyeicon;
	}
	public WebElement getBpname() {
		return conbpname;
	}
	public WebElement getContractname() {
		return contractname;
	}
	

}
