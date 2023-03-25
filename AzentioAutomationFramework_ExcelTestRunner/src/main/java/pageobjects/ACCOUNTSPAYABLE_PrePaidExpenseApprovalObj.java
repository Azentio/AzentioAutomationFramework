package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PrePaidExpenseApprovalObj {
	WebDriver driver;
	public ACCOUNTSPAYABLE_PrePaidExpenseApprovalObj(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/256']")
	private WebElement PrepaidExpense_TempView;
	public WebElement prpaidExopenseTempView()
	{
		return PrepaidExpense_TempView;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button")
	private WebElement prepaidExpense_FirstRecord;
	public WebElement prePaidExpenseFirstRecord()
	{
		return prepaidExpense_FirstRecord;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement prepaidExpese_Transactiondate;
	public WebElement prepaidExpenseTransactionDate()
	{
		return prepaidExpese_Transactiondate;
	}
	@FindBy(xpath="//datatable-body-cell/div[1]/input[1]")
	private WebElement prepaidExpenseDuration_Months;
	public WebElement prepaidExpenseDurationMonths()
	{
		return prepaidExpenseDuration_Months;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Prepaid Information')]")
	private WebElement prepaidExpense_PrepaidInformation;
	public WebElement prepaidExpensePrepiaidInformation()
	{
		return prepaidExpense_PrepaidInformation;
	}
	@FindBy(xpath="//ion-label[contains(text(),'AP Invoice Against Expense')]")
	private WebElement prepaidExpense_Prepaidinformation;
	public WebElement prepaidExpensePrePaidInformation()
	{
		return prepaidExpense_Prepaidinformation;
	}
	
	

}
