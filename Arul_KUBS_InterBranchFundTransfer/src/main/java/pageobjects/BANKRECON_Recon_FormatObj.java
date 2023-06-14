package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BANKRECON_Recon_FormatObj {
	WebDriver driver;
	public BANKRECON_Recon_FormatObj(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/243']")
	private WebElement ReconFormat_TempView;
	public WebElement ReconFormatTempView()
	{
		return ReconFormat_TempView;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button")
	private WebElement BankRecon_TempViewFirstRecord;
	public WebElement BankReconTempViewFirstRecord()
	{
		return BankRecon_TempViewFirstRecord;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Data Matching Rule')]")
	private WebElement BankRecon_DatataMatchingRule;
	public WebElement BankRecon_DataMatchingRule()
	{
		return BankRecon_DatataMatchingRule;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement BankRecon_DatamatchingAddbutton;
	public WebElement BankReconDataMatchingAddButton()
	{
		return BankRecon_DatamatchingAddbutton;
	}
	@FindBy(xpath="//ion-col[2]//input")
	private WebElement BankRecon_DatatMatching_FieldName;
	public WebElement BankReconDatataMatchingFieldName()
	{
		return BankRecon_DatatMatching_FieldName;
	}
	@FindBy(xpath="//ion-col[3]//input")
    private WebElement BankRecon_DataMatching_SystemDataPoint;
	public WebElement BankReconDataMatchingSystemDataPoint()
	{
		return BankRecon_DataMatching_SystemDataPoint;
	}
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement BankRecon_DataMatching_DataType;
	public WebElement BankReconDataMatchingDataType()
	{
		return BankRecon_DataMatching_DataType;
	}
	@FindBy(xpath="//ion-col[8]//input")
	private WebElement BankRecon_DataMatching_Position;
	public WebElement BankReconDataMatchingPosition()
	{
		return BankRecon_DataMatching_Position;
	}
	@FindBy(xpath="//ion-col[9]//input")
	private WebElement BankRecon_DataMatching_SoundexMatch;
	public WebElement BankReconDataMatchingSoundexMatch()
	{
		return BankRecon_DataMatching_SoundexMatch;
	}
	@FindBy(xpath="//ion-col[11]//input")
	private WebElement BankRecon_DataMatching_MatchConditition;
	public WebElement BankReconDataMatchingMatchCondition()
	{
		return BankRecon_DataMatching_MatchConditition;
	}
	@FindBy(xpath="//ion-button[contains(text(),'Format Preview')]")
	private WebElement BankRecon_DataMatching_FormatPreviewButton;
	public WebElement BankRecobDataMatchingFormatPreviewButton()
	{
		return BankRecon_DataMatching_FormatPreviewButton;
	}
	@FindBy(xpath="//ion-icon[@title='Enable Search']")
	private WebElement BankRecon_DataMatching_FormatPreviewEnableSearch;
	public WebElement BankReconDataNatchingFormatPreviewEnableSearch()
	{
		return BankRecon_DataMatching_FormatPreviewEnableSearch;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/245']")
	private WebElement bankRecon_BankReconeyeIcon;
	public WebElement bankReconEyeIcon()
	{
		return bankRecon_BankReconeyeIcon; 
	}
	@FindBy(xpath="//input[@placeholder='Search Bank Name']")
	private WebElement bankRecon_SearchBankName;
	public WebElement bankReconSearchBankName()
	{
		return bankRecon_SearchBankName; 
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement bankRecon_ApprovedBAnkFirstRecord;
	public WebElement bankReconApprovedBankFirstRecord()
	{
	return bankRecon_ApprovedBAnkFirstRecord;	
	}
	@FindBy(xpath="//ion-label[contains(text(),'Data Matching Rule')]")
	private WebElement bankRecon_DataMatchingRuleTab;
	public WebElement bankReconDataMatchingRuleTab()
	{
	 return bankRecon_DataMatchingRuleTab;	
	}
	@FindBy(xpath="//datatable-row-wrapper[4]//datatable-body-cell[1]//ion-buttons[1]//ion-button[1]")
	private WebElement bankRecon_DepositeRecord;
	public WebElement bankReconDeppositeRecord()
	{
		return bankRecon_DepositeRecord;
	}
	@FindBy(xpath="//ion-col[11]//div//div//span[2]")
	private WebElement bankRecon_ConditionName;
	public WebElement bankReconConditionName()
	{
		return bankRecon_ConditionName;
	}
}
