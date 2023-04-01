package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BANKRECON_BankReconcilationObj {
	WebDriver driver;
	public BANKRECON_BankReconcilationObj(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/9']")
	private WebElement BANKRECON_BankReconEyeIcon;
	public WebElement BANKRECONBankReconEyeIcon()
	{
		return BANKRECON_BankReconEyeIcon;
	}
	
	@FindBy(xpath="//ion-col[2]//input")
	private WebElement BANKRECON_BankName;
	public WebElement BANKRECONBankName()
	{
		return BANKRECON_BankName;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement BANKRECON_BankAccountNumber;
	public WebElement BANKRECONBAnkAccountNumber()
	{
		return BANKRECON_BankAccountNumber;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement BANKRECON_BAnkReconFromDate;
	public WebElement BANKRECON_PeriodFromDate()
	{
		return BANKRECON_BAnkReconFromDate;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
    private WebElement BANKRECON_BankReconPeriodToDate;
	public WebElement BANKRECON_BankReconPeriodToDate()
	{
		return BANKRECON_BankReconPeriodToDate;
	}
	@FindBy(xpath="//button[@aria-label='Next month']")
	private WebElement Calendar_NextMonth;
	public WebElement calendarNextMonthButton()
	{
		return Calendar_NextMonth;
	}
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement BANKRECON_BankReconUploadFileButton;
	public WebElement BANKRECON_BankReconUploadFileButton()
	{
		return BANKRECON_BankReconUploadFileButton;
	}
	@FindBy(xpath="//page-bank-recon-details-update//ion-toolbar//ion-buttons[2]//ion-button[1]")
	private WebElement BANKRECON_BankReconSaveButton;
	public WebElement BANKRECONBankReconSaveButton()
	{
		return BANKRECON_BankReconSaveButton;
	}
	@FindBy(xpath="//page-bank-recon-details-update//ion-toolbar//ion-buttons[2]//ion-button[2]")
	private WebElement BANKRECON_BankReconProcessButoon;
	public WebElement BankReconProcessButton()
	{
		return BANKRECON_BankReconProcessButoon;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Unmatched Data')]")
	private WebElement BANKRECON_UnmatchedData;
	public WebElement BANKRECON_UnmatchedData()
	{
		return BANKRECON_UnmatchedData;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Bank Reconciliation Statement ')]")
	private WebElement BANKRECON_BankReconStatementTab;
	public WebElement BANKRECONBankReconStatementTab()
	{
		return BANKRECON_BankReconStatementTab;
	}
	   @FindBy(xpath = "//body/div/div/div/div[1]")
		private WebElement BANKRECON_ToastAlert;

		public WebElement BANKRECOnToastAlert() {
			return BANKRECON_ToastAlert;
		}
		
		@FindBy(xpath = "//div[@role='alert']")
		private WebElement BANKRECON_SucessToastAlert;

		public WebElement BANKRECON_SucessToastAlert() {
			return BANKRECON_SucessToastAlert;
		}
		// success message close
		@FindBy(xpath = "//div[@id='toast-container']//button[@aria-label='Close']")
		private WebElement SuccessMessageClose;

		public WebElement SuccessMessageClose() {
			return SuccessMessageClose;
		}
		@FindBy(xpath="//ion-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//input")
		private WebElement MatchedTab_FirstGrid_Input;
		public WebElement MatcedTabFirstGridInput()
		{
			return MatchedTab_FirstGrid_Input;
		}
		
		@FindBy(xpath="//ion-button[contains(text(),' Match ')]")
		private WebElement MatchTab_MatchButton;
		public WebElement matchTabMatchButton()
		{
			return MatchTab_MatchButton;
		}
	@FindBy(xpath="//ion-grid[2]//datatable-body-cell[1]//input")
	private WebElement UnmatchedTab_BankStatementCheckBox;
	public WebElement unmatchedTabBankStatementCheckBox()
	{
		return UnmatchedTab_BankStatementCheckBox;
	}
	@FindBy(xpath="//ion-grid[2]//datatable-body-cell[8]//div")
	private WebElement UnmatchedTab_BankStatementDeppositeAmount;
	public WebElement unmatchedTabBankStatementDepositeAmount()
	{
		return UnmatchedTab_BankStatementDeppositeAmount;
	}
    @FindBy(xpath="//ion-row[2]//ion-col[1]//ion-grid//ion-col[3]//ion-label")
    private WebElement reconcilationStatement_AsPerBankAmount;
    public WebElement reconcilationStatementAsPerBankAmount()
    {
    	return reconcilationStatement_AsPerBankAmount;
    }
    @FindBy(xpath="//b[contains(text(),'Adjusted Balance as per Book')]//ancestor::ion-col/following-sibling::ion-col[2]//ion-label")
    private WebElement reconcilationStateent_AsPerBookAmount;
    public WebElement reconcilationStatementAsperBookStatement()
    {
    	return reconcilationStateent_AsPerBookAmount;
    }
    @FindBy(xpath="//ion-label[contains(text(),'Bank Reconciliation Process')]")
    private WebElement reconcilationStatement_BankReconcilationProcess;
    public WebElement reconcilationStatementBankReconcilationProcess()
    {
    	return reconcilationStatement_BankReconcilationProcess;
    }
    @FindBy(xpath="//page-book-recon-data-match-update//ion-toolbar//ion-buttons[2]//ion-button[1]")
    private WebElement reconcilation_MatchButton;
    public WebElement reconcilationMatchButton()
    {
    	return reconcilation_MatchButton;
    }
    @FindBy(xpath="//page-book-recon-data-match-update//ion-toolbar//ion-buttons[2]//ion-button[2]")
    private WebElement reconcilation_MatchSaveButton;
    public WebElement reconcilationMatchSaveButton()
    {
    	return reconcilation_MatchSaveButton;
    }
    @FindBy(xpath="//ion-label[contains(text(),'Matched Data')]")
    private WebElement bankRecon_MatchedData;
    public WebElement bankReconMatchedData()
    {
    	return bankRecon_MatchedData;
    }
    @FindBy(xpath="//ion-col[2]//input")
    private WebElement bankReconcilation_Basis;
    public WebElement bankReconcilationBasis()
    {
    	return bankReconcilation_Basis;
    }
    @FindBy(xpath="//ion-item[2]//ion-radio")
    private WebElement bankReconTransactin_Yes;
    public WebElement bankReconTransactionYes()
    {
    	return bankReconTransactin_Yes;
    }
    @FindBy(xpath="//ion-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[7]//div")
    private WebElement bankRecon_Grid1Amount;
    public WebElement bankRecoGridOneAmount()
    {
    	return bankRecon_Grid1Amount;
    }
    @FindBy(xpath="//ion-grid[2]//datatable-row-wrapper[1]//datatable-body-cell[8]//div")
    private WebElement bankRecon_GridViewtwoAmount;
    public WebElement bankReconGridViewTwoAmount()
    {
    	return bankRecon_GridViewtwoAmount;
    }
    @FindBy(xpath="//page-bank-recon-data-match-update//ion-toolbar//ion-button[2]")
    private WebElement bankRecon_MatchedTabSaveButton;
    public WebElement bankReconMatchecTabSaveButton()
    {
    	return bankRecon_MatchedTabSaveButton;
    }
 
    @FindBy(xpath="//ion-label[text()=' Bank Reconciliation Process ']/parent::ion-tab-button")
    private WebElement  BankReconciliationProcessTab ;
    public WebElement BankReconciliationProcessTab()
    {
    	return BankReconciliationProcessTab;
    }
    @FindBy(xpath="//ion-label[text()=' Bank Reconciliation Details ']/parent::ion-tab-button")
    private WebElement  BankReconciliationProcessDetailsTab ;
    public WebElement BankReconciliationProcessDetailsTab()
    {
    	return BankReconciliationProcessDetailsTab;
    }
	
}
