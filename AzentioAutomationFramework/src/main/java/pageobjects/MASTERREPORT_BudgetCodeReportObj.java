package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MASTERREPORT_BudgetCodeReportObj {
    WebDriver driver;
    public MASTERREPORT_BudgetCodeReportObj(WebDriver driver)

    {
    	this.driver= driver;
    	PageFactory.initElements(driver, this);
    	
    }
    @FindBy(xpath="//ion-label[contains(text(),'Master reports')]")
    private WebElement master_ReportMainMenu;
    public WebElement masterReportMainMenu()
    {
    	return master_ReportMainMenu;
    }
    @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/budget-codes']")
    private WebElement masterBudget_BudgetCodeReport;
    public WebElement masterBudgetReport()
    {
    	return masterBudget_BudgetCodeReport;
    }
    @FindBy(xpath="//ion-col[1]//input")
    private WebElement masterBudget_BudgetType;
    public WebElement masterBudgetBudgetType()
    {
    	return masterBudget_BudgetType;
    }
    @FindBy(xpath="//span[@class='input-calendar']")
    private WebElement masterBudget_Calendar;
    public WebElement masterBudgetInputCalendar()
    {
    	return masterBudget_Calendar;
    }
    @FindBy(xpath="//input[@name='next']")
    private WebElement masterBudget_NextPage;
    public WebElement masterBudgetNextPage()
    {
    	return masterBudget_NextPage;
    }
    @FindBy(xpath="//span[@id='totalPage']")
    private WebElement masterBudget_TotalNoPage;
    public WebElement masterBudgetTotalNoPage()
    {
    	return masterBudget_TotalNoPage; 
    }
    @FindBy(xpath="//button[@aria-label='Next month']")
    private WebElement masterBudget_CalendarNextButton;
    public WebElement masterBudgetCalendarNextButton()
    {
    	return masterBudget_CalendarNextButton; 
    }
    @FindBy(xpath="//a[contains(text(),'View')]")
    private WebElement masterBudget_BudgetCodeViewButton;
    public WebElement masterBudgetBudgetCodeViewButton()
    {
    	return masterBudget_BudgetCodeViewButton;
    }
}
