package pageobjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Petty_Cash_Obj {

	WebDriver driver;
	
	public  Petty_Cash_Obj(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	// Petty_Cash_Expense Code Limit
	@FindBy(xpath ="//ion-label[contains(text(),'Petty cash configuration')]")
	private WebElement Petty_Cash_Configuration;
	public WebElement Petty_Cash_Configuration() 
	{
		return Petty_Cash_Configuration;
	}
	
	@FindBy(xpath ="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/238']")
	private WebElement Petty_Cash_Expense_code_limit ;
	public WebElement Petty_Cash_Expense_code_limit() 
	{
		return Petty_Cash_Expense_code_limit;
	}
	
	@FindBy(xpath="(//ion-icon[@ng-reflect-name='add'])[1]")
	private WebElement Petty_Cash_Add;
	public WebElement Petty_Cash_Add() {
		return Petty_Cash_Add;
	}
	
	@FindBy(xpath="//ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement Petty_Cash_ExpenseCode;
	public WebElement Petty_Cash_ExpenseCode() {
		return Petty_Cash_ExpenseCode;
	}
	
	@FindBy(xpath="//ion-col[2]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement Petty_Cash_ExpenseName;
	public WebElement Petty_Cash_ExpenseName() {
		return Petty_Cash_ExpenseName;
	}
	
	@FindBy(xpath="//ion-col[5]/ion-item[1]/input[@id='maxLimit']")
	private WebElement Petty_Cash_Max_Limit;
	public WebElement Petty_Cash_Max_Limit() {
		return Petty_Cash_Max_Limit;
	}
	
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement Petty_Cash_Expense_Gl;
	public WebElement Petty_Cash_Expense_Gl() {
		return Petty_Cash_Expense_Gl;
	}	
	
	@FindBy(xpath="//ion-col[6]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement Petty_Cash_Expense_Currency;
	public WebElement Petty_Cash_Expense_Currency() {
		return Petty_Cash_Expense_Currency;
	}
	
	@FindBy(xpath="(//ion-header[1]/ion-toolbar[1]/ion-buttons[2])[3]")
	private WebElement Petty_Cash_Expense_Save;
	public WebElement Petty_Cash_Expense_Save() {
		return Petty_Cash_Expense_Save;
	}
	
	
	// Employee Limit
	
	@FindBy(xpath="//ion-col[1]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement Petty_Cash_Employee;
	public WebElement Petty_Cash_Employee() {
		return Petty_Cash_Employee;
	}
	
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement Petty_Cash_Employee_Currancy;
	public WebElement Petty_Cash_Employee_Currancy() {
		return Petty_Cash_Employee_Currancy;
	}
	
	@FindBy(xpath="//ion-col[2]/ion-item[1]/input[@id='maxAdvanceLimit']")
	private WebElement Petty_Cash_Max_AdvanceLimit;
	public WebElement Petty_Cash_Max_AdvanceLimit() {
		return Petty_Cash_Max_AdvanceLimit;
	}
	
	
	
	
	
	
}
