package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_SupplementaryBudgetObj {
	WebDriver driver;

	public BUDGET_SupplementaryBudgetObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//---------------------------------Maker------------------------------------------------//
	
	//Select existing budget code
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement budget_SupplementaryBudget_BudgetCode;
	public WebElement budget_SupplementaryBudget_BudgetCode()
	{
		return budget_SupplementaryBudget_BudgetCode;
	}
	
	//Select budget year
	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement budget_SupplementaryBudget_BudgetYear;
	public WebElement budget_SupplementaryBudget_BudgetYear()
	{
		return budget_SupplementaryBudget_BudgetYear;
	}
	
	//Select branch name
	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement budget_SupplementaryBudget_BudgetBranch;
	public WebElement budget_SupplementaryBudget_BudgetBranch()
	{
		return budget_SupplementaryBudget_BudgetBranch;
	}
	
	//to verify existing amount will show when valid branch selected.
	@FindBy(xpath="//input[@id='2021-2022']")
	private WebElement budget_SupplementaryBudget_ExistingAmount;
	public WebElement budget_SupplementaryBudget_ExistingAmount()
	{
		return budget_SupplementaryBudget_ExistingAmount;
	}
	
	//currency dropdown
	@FindBy(xpath="(//span[@class='ng-arrow-wrapper'])[5]")
	private WebElement budget_SupplementaryBudget_CurrencyDropdown;
	public WebElement budget_SupplementaryBudget_CurrencyDropdown()
	{
		return budget_SupplementaryBudget_CurrencyDropdown;
	}
	
	
	//Select Currency
	@FindBy(xpath="(//span[@class='ng-option-label ng-star-inserted'])[2]")
	private WebElement budget_SupplementaryBudget_Currency;
	public WebElement budget_SupplementaryBudget_Currency()
	{
		return budget_SupplementaryBudget_Currency;
	}
	
	//giving comments
	@FindBy(xpath="(//input[@class='native-input sc-ion-input-md'])[4]")
	private WebElement budget_SupplementaryBudget_Comments;
	public WebElement budget_SupplementaryBudget_Comments()
	{
		return budget_SupplementaryBudget_Comments;
	}
	
	//Enter supplymentary_apportion_amount
	@FindBy(xpath="//input[@class='datatable ng-valid ng-dirty ng-touched']")
	private WebElement budget_SupplementaryBudget_SupplementaryApportionAmount;
	public WebElement budget_SupplementaryBudget_SupplementaryApportionAmount()
	{
		return budget_SupplementaryBudget_SupplementaryApportionAmount;
	}
	
	//Click on new amount
	@FindBy(xpath="//input[@class='datatable ng-pristine ng-valid ng-touched']")
	private WebElement budget_SupplementaryBudget_NewAmount;
	public WebElement budget_SupplementaryBudget_NewAmount()
	{
		return budget_SupplementaryBudget_NewAmount;
	}
	
	//Save supplementary budget
	@FindBy(xpath="//ion-icon[@name='save']")
	private WebElement budget_SupplementaryBudget_SupplementaryBudgetSave;
	public WebElement budget_SupplementaryBudget_SupplementaryBudgetSave()
	{
		return budget_SupplementaryBudget_SupplementaryBudgetSave;
	}
	
	//Supplementary Budget action edit
	@FindBy(xpath="//span[contains(text(),' AR12345 ')]/../../../datatable-body-cell/div/ion-buttons/ion-button")
	private WebElement budget_SupplementaryBudget_SupplementaryBudgetEdit;
	public WebElement budget_SupplementaryBudget_SupplementaryBudgetEdit()
	{
		return budget_SupplementaryBudget_SupplementaryBudgetEdit;
	}
	
	//Submit
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	private WebElement budget_SupplementaryBudget_SubmitButton;
	public WebElement budget_SupplementaryBudget_SubmitButton()
	{
		return budget_SupplementaryBudget_SubmitButton;
	}
	
	//Remark field
	@FindBy(xpath="//textarea[@class='native-textarea sc-ion-textarea-ios']")
	private WebElement budget_SupplementaryBudget_RemarkField;
	public WebElement budget_SupplementaryBudget_RemarkField()
	{
		return budget_SupplementaryBudget_RemarkField;
	}
	
	//Submit by maker
	@FindBy(xpath="//ion-button[contains(text(),'Submit')]")
	private WebElement budget_SupplementaryBudget_SubmitByMaker;
	public WebElement budget_SupplementaryBudget_SubmitByMaker()
	{
		return budget_SupplementaryBudget_SubmitByMaker;
	}
	
//-------------------------------------------Reviewer---------------------------------------------//
	
	//notification in reviewer
	@FindBy(xpath="//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement budget_SupplementaryBudget_NotificationButton;
	public WebElement budget_SupplementaryBudget_NotificationButton()
	{
		return budget_SupplementaryBudget_NotificationButton;
	}
	
//	//edit for approval reject and return page
//	@FindBy(xpath="")
//	//@FindBy(xpath="(//ion-icon[@name='pencil'])[1]")
//	private WebElement budget_SupplementaryBudget_EditbudgetByReviewer;
//	public WebElement budget_SupplementaryBudget_EditbudgetByReviewer()
//	{
//		return budget_SupplementaryBudget_EditbudgetByReviewer;
//	}
//	
	//approve
	@FindBy(xpath="//span[contains(text(),'Approve')]")
	private WebElement budget_SupplementaryBudget_ApproveByReviewer;
	public WebElement budget_SupplementaryBudget_ApproveByReviewer()
	{
		return budget_SupplementaryBudget_ApproveByReviewer;
	}
	
	//remark by reviewer
	@FindBy(xpath="//textarea[@class='native-textarea sc-ion-textarea-ios']")
	private WebElement budget_SupplementaryBudget_RemarkByReviewer;
	public WebElement budget_SupplementaryBudget_RemarkByReviewer()
	{
		return budget_SupplementaryBudget_RemarkByReviewer;
	}
	
	//submit by reviewer
	@FindBy(xpath="//ion-button[contains(text(),'Submit')]")
	private WebElement budget_SupplementaryBudget_SubmitByReviewer;
	public WebElement budget_SupplementaryBudget_SubmitByReviewer()
	{
		return budget_SupplementaryBudget_SubmitByReviewer;
	}
}
