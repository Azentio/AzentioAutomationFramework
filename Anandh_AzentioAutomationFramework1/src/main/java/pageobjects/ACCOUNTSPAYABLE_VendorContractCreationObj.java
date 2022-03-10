package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_VendorContractCreationObj {
WebDriver driver;

	public ACCOUNTSPAYABLE_VendorContractCreationObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/130']")
	private WebElement VendorContract_eyeIcon;
	public WebElement vendorContractEyeIcon()
	{
		return VendorContract_eyeIcon;		
	}
	@FindBy(xpath="(//ion-col[3]//input)[1]")
	private WebElement vendorContract_expenceType;
	public WebElement vendorContractExpenceType()
	{
		return vendorContract_expenceType;
	}
	@FindBy(xpath="(//ion-col[4]//input)[1]")
	private WebElement vendorContract_BpName;
	public WebElement vendorContractBpName()
	{
		return vendorContract_BpName;
	}
	@FindBy(xpath="//page-contract-creation-update[1]/ion-content[1]/form[1]/ion-grid[1]/fieldset[1]/ion-row[1]/ion-col[7]/ion-item[1]//input[1]")
	private WebElement vendorContract_ContractName;
	public WebElement vendorContractContractName()
	{
		return vendorContract_ContractName;
	}
	@FindBy(xpath="//page-contract-creation-update[1]/ion-content[1]/form[1]/ion-grid[2]/fieldset[1]/legend[1]/ion-button[1]")
	private WebElement vendorContract_OtherDetails;
	public WebElement vendorContractOtherDetails()
	{
		return vendorContract_OtherDetails;
	}
	@FindBy(xpath="//page-contract-creation-update[1]//ion-grid[2]//ion-row[1]/ion-col[3]//ng-select[1]//input")
	private WebElement vendorContract_autoGenerateInvoice;
	public WebElement vendorContractAutoGenerateInvoice()
	{
		return vendorContract_autoGenerateInvoice;
	}
	@FindBy(xpath="//page-contract-creation-update[1]//ion-grid[2]//ion-row[1]/ion-col[4]//input")
	private WebElement vendorContract_creditPeriod;
	public WebElement vendorContractCreditPeriod()
	{
		return vendorContract_creditPeriod;
	}
	
	@FindBy(xpath="//page-contract-creation-update[1]//ion-grid[2]//ion-row[1]/ion-col[5]//input")
	private WebElement vendorContract_latePaymentAmount;
	public WebElement vendorContractLatePaymentAmount()
	{
		return vendorContract_latePaymentAmount;
	}
	@FindBy(xpath="//page-contract-creation-update[1]//ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement vendorContract_SaveButton;
	public WebElement vendorContractSaveButton()
	{
		return vendorContract_SaveButton;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/44']")
	private WebElement vendorContractTempView;
	public WebElement vendorContractTempView()
	{
		return vendorContractTempView;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button")
	private WebElement vendorContractFirstTemprecord;
	public WebElement firstTempRecord()
	{
		return vendorContractFirstTemprecord;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Item Details')]")
	private WebElement vendorContract_ItemDetails;
	public WebElement vendorContractItemDetails()
	{
		return vendorContract_ItemDetails;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement vendorContract_AddButton;
	public WebElement vendorContractAddButton()
	{
		return vendorContract_AddButton;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[3]//input")
	private WebElement vendorContract_HSNcode;
	public WebElement vendorContractHSNCode()
	{
		return vendorContract_HSNcode;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[4]//input")
	private WebElement vendorContract_Expencecode;
	public WebElement vendorContractExpenceCode()
	{
		return vendorContract_Expencecode;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[5]//input")
	private WebElement vendorContract_CostCenter;
	public WebElement vendorContractCostCenter()
	{
		return vendorContract_CostCenter;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[6]//input")
	private WebElement vendorContract_Quantity;
	public WebElement vendorContractQuantity()
	{
		return vendorContract_Quantity;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[7]//input")
	private WebElement vendorContract_Unit;
	public WebElement vendorContractUnit()
	{
		return vendorContract_Unit;
	}
	@FindBy(xpath="//page-contract-item-details-update[1]//ion-col[8]//input")
	private WebElement vendorContract_RatePerUnit;
	public WebElement vendorContractRatePerUnit()
	{
		return vendorContract_RatePerUnit;
	}
	@FindBy(xpath="//page-contract-item-details-update//ion-toolbar[1]//ion-buttons[1]/ion-button[1]")
	private WebElement ItemDetailsSavebutton;
	public WebElement itemDetailsSaveButton()
	{
		return ItemDetailsSavebutton;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Payment Terms')]")
	private WebElement vendorContract_PaymentTerm;
	public WebElement vendorContractPaymentTerm()
	{
		return vendorContract_PaymentTerm;
	}
	@FindBy(xpath="//page-payment-terms-update//ion-col[2]//input")
	private WebElement paymentTerm_paymentTerm;
	public WebElement paymentTermPaymentTerm()
	{
		return paymentTerm_paymentTerm;
	}
	@FindBy(xpath="//page-payment-terms-update//ion-col[3]//input")
	private WebElement paymentTerm_paymentTermPercentage;
	public WebElement paymentTermPaymentTermPercentage()
	{
		return paymentTerm_paymentTermPercentage;
	}
	@FindBy(xpath="//page-payment-terms-update//ion-col[4]//input")
	private WebElement paymentTerm_paymentTermType;
	public WebElement paymentTermPaymentTermType()
	{
		return paymentTerm_paymentTermType;
	}
	@FindBy(xpath="//page-payment-terms-update//ion-toolbar[1]//ion-buttons[1]/ion-button[1]")
	private WebElement paymentTerm_paymentTermSaveButton;
	public WebElement paymentTermPaymentTermSaveButton()
	{
		return paymentTerm_paymentTermSaveButton;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Beneficiary Details')]")
	private WebElement vendorContract_BenificioryDetails;
	public WebElement vendorContractBenificioryDetails()
	{
		return vendorContract_BenificioryDetails;
	}
	@FindBy(xpath="//page-beneficiary-details-update//ion-col[2]//input")
	private WebElement vendorContract_BenificioryDetailsPaymentMode;
	public WebElement vendorContractBenificioryDetailsPaymentMode()
	{
		return vendorContract_BenificioryDetailsPaymentMode;
	}
	@FindBy(xpath="//page-beneficiary-details-update//ion-col[6]//input")
	private WebElement vendorContract_BenificioryDetailsAutoPayout;
	public WebElement vendorContractBenificioryDetailsAutoPayout()
	{
		return vendorContract_BenificioryDetailsAutoPayout;
	}
	
	@FindBy(xpath="//page-beneficiary-details-update//ion-toolbar[1]//ion-buttons[1]/ion-button[1]")
	private WebElement vendorContract_BenificioryDetailsSaveButton;
	public WebElement vendorContractBenificioryDetailsSaveButton()
	{
		return vendorContract_BenificioryDetailsSaveButton;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement vendorContract_ApprovedContractNumber;
	public WebElement vendorContractApprovedContractNumber()
	{
		return vendorContract_ApprovedContractNumber;
	}
	@FindBy(xpath="//input[@placeholder='Search Contract Status']")
	private WebElement vendorContract_SearchContractStatus;
	public WebElement vendorContractSearchContractStatus()
	{
		return vendorContract_SearchContractStatus;
	}
	
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement vendorContract_ApprovedBpName;
	public WebElement vendorContractApprovedBpName()
	{
		return vendorContract_ApprovedBpName;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement vendorContract_approvedViewButton;
	public WebElement vendorContractApprovedViewButton()
	{
		return vendorContract_approvedViewButton;
	}
}
