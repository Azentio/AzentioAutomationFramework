package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PaymentFileDownloadObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_PaymentFileDownloadObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-list[1]/div[3]/ion-menu-toggle[9]/ion-item[1]//ion-button[1]")
	private WebElement paymentFileDownload_TempViewButton;
	public WebElement paymentFileDownloadVTempiewButton()
	{
		return paymentFileDownload_TempViewButton;
	}
	@FindBy(xpath="//page-payment-file-update[1]//ion-col[1]//input[1]")
	private WebElement paymentFileDownload_BranchName;
	public WebElement paymentFileDownloadBranchName()
	{
		return paymentFileDownload_BranchName;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement paymentFileDownload_Calendar;
	public WebElement PaymentFileDownloadCalendarButton()
	{
		return paymentFileDownload_Calendar;
	}
	@FindBy(xpath="//button[@aria-label='Choose month and year']")
	private WebElement paymentFileDownload_ChooseMonthAndYear;
	public WebElement paymentFileDownloadChooseMonthAndYear()
	{
		return paymentFileDownload_ChooseMonthAndYear;
	}
	@FindBy(xpath="//ion-button[contains(text(),'Go')]")
	private WebElement pamentFileDownload_GoButton;
	public WebElement PaymentFileDownloadGoButton()
	{
		return pamentFileDownload_GoButton;
	}
    @FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[7]//ion-button[1]")
    private WebElement paymentFileDownload_DownloadButton;
    public WebElement paymentFileDownloadDownloadButton()
    {
    	return paymentFileDownload_DownloadButton;
    }
}
