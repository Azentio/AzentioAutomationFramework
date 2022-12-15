package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PaymentFileUploadObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_PaymentFileUploadObj(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/226']")
	private WebElement accountsPayable_PaymentFileUploadViewButton;
	public WebElement accountsPayablePaymentFileUploadViewButton()
	{
		return accountsPayable_PaymentFileUploadViewButton;
	}
	@FindBy(xpath="//ion-input[@type='file']")
	private WebElement accountsPayable_ChooseFile;
	public WebElement accountsPayableChooseFile()
	{
		return accountsPayable_ChooseFile;
	}
	@FindBy(xpath="//ion-button[contains(text(),'Upload')]")
	private WebElement accountsPayable_UploadButton;
	public WebElement accountsPayableUploadButton()
	{
		return accountsPayable_UploadButton;
	}
	@FindBy(xpath="//page-upload-payment-hdr-update//ion-toolbar//ion-buttons[2]//ion-button")
	private WebElement accountsPayable_PaymentUploadSaveButton;
	public WebElement accountsPayablePaymentUploadSaveButton()
	{
		return accountsPayable_PaymentUploadSaveButton;
	}
}
