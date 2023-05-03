package pageobjects.CSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsObject {
WebDriver driver;

public AccountsObject(WebDriver driver) {

	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(xpath="//td[text()='Accounts']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]")
private WebElement accountsFlag;
public WebElement accounts_Flag() {
	return accountsFlag; 
}
@FindBy(xpath="//td[text()='Fixed Maturity Accounts']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]")
private WebElement fixedMaturityAccountFlag;
public WebElement fixedMaturityAccount_Flag() {
	return fixedMaturityAccountFlag;
}
@FindBy(xpath="//td[text()='General Accounts']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]")
private WebElement generalAccountFlag;
public WebElement generalAccount_Flag() {
	return generalAccountFlag;
}
@FindBy(xpath="//td[text()='Closed Dormant Accounts']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]/span[1]/span[1]")
private WebElement closedDormantAccountFlag;
public WebElement closedDormantAccount_Flag() {
	return closedDormantAccountFlag;
}
@FindBy(xpath="//span[text()='Account Query']//parent::a")
private WebElement accountQuery;
public WebElement account_Query() {
	return accountQuery;
}
@FindBy(xpath="//span[text()='DCHEQS']//parent::a")
private WebElement DCHEQS;
public WebElement DCHEQS() {
	return DCHEQS;
}
@FindBy(xpath="//span[text()='Maintenance']//parent::a")
private WebElement fixedMaturityAccountsMaintenance;
public WebElement fixedMaturityAccounts_Maintenance() {
	return fixedMaturityAccountsMaintenance;
}
@FindBy(xpath="//span[text()='Opening']//parent::a")
private WebElement fixedMaturityAccountsOpenings;
public WebElement fixedMaturityAccounts_Openings(){
	return fixedMaturityAccountsOpenings;
	
}
@FindBy(xpath="//input[@id='lookuptxt_cifNo_A001MT']")
private WebElement fixedMaturityAccountsOpeningsCIF;
public WebElement fixedMaturityAccountsOpenings_CIF() {
	return fixedMaturityAccountsOpeningsCIF;
}
@FindBy(xpath = "//td[text()='General Accounts']//ancestor::li//span[text()='Opening']")
private WebElement generalAccounts_Opening;

public WebElement generalAccountsOpening() {
	return generalAccounts_Opening;
}
@FindBy(xpath="//span[@id='spanLookup_glType_A002MT']")
private WebElement generalAccounts_GLtypeSearchButton;
public WebElement generalAccountsGLTypeSearchButton() {
	return generalAccounts_GLtypeSearchButton;
}
@FindBy(xpath = "//td[text()='Closed Dormant Accounts']//ancestor::li//span[text()='Maintenance']")
private WebElement closedDormantAccounts_Maintenance;

public WebElement closedDormantAccountsMaintenance() {
	return closedDormantAccounts_Maintenance;
}
@FindBy(xpath = "//input[@id='lookuptxt_CIF_A002CDAMT']")
private WebElement closedDormantAccount_InputCIFCode;

public WebElement closedDormantAccountInputCIFCode() {
	return closedDormantAccount_InputCIFCode;
}
@FindBy(xpath = "//input[@id='lookuptxt_glType_A001MT']")
private WebElement fom_GlCode;

public WebElement fomGLCode() {
	return fom_GlCode;
}
@FindBy(xpath = "//input[@id='lookuptxt_currencyCode_A002MT']")
private WebElement generalAccounts_CurrencyCode;

public WebElement generalAccountsCurrencyCode() {
	return generalAccounts_CurrencyCode;
}
@FindBy(xpath="//input[@id='lookuptxt_currencyCode_A001MT']")
private WebElement fixedMaturityAccounts_CurrencyCode;

public WebElement fixedMaturityAccountsCurrencyCode() {
	return fixedMaturityAccounts_CurrencyCode;
}
@FindBy(xpath="//input[@id='lookuptxt_glType_A001MT']")
private WebElement fixedMaturityAccounts_GLType;

public WebElement fixedMaturityAccountsGLType() {
	return fixedMaturityAccounts_GLType;
}
@FindBy(xpath="//span[@id='spanLookup_glType_A001MT']")
private WebElement fixedMaturityAccounts_GLType_SearchButton;

public WebElement fixedMaturityAccountsGLTypeSearchButton() {
	return fixedMaturityAccounts_GLType_SearchButton;
}
@FindBy(xpath="//span[@id='spanLookup_currencyCode_A001MT']")
private WebElement fixedMaturityAccounts_CurrencyCode_SearchButton;

public WebElement fixedMaturityAccountsCurrencyCodeSearchButton() {
	return fixedMaturityAccounts_CurrencyCode_SearchButton;
}
@FindBy(xpath="//span[@id='spanLookup_currencyCode_A002MT']")
private WebElement generalAccounts_CurrencyCode_SearchButton;
public WebElement genaralAccountsCurrencyCodeSearchButton() {
	return generalAccounts_CurrencyCode_SearchButton;
}

@FindBy(xpath = "//input[@id='lookuptxt_glType_A002MT']")
private WebElement generalAccounts_GLType;

public WebElement generalAccountsGLType() {
	return generalAccounts_GLType;
}

@FindBy(xpath = "//input[@id='lookuptxt_cifNo_A002MT']")
private WebElement generalAccounts_CIFNo;

public WebElement generalAccountsCIFNo() {
	return generalAccounts_CIFNo;
}

@FindBy(xpath = "//input[@id='lookuptxt_CIF_A002CDAMT']")
private WebElement ClosedDormantAccount_CIFNo;

public WebElement ClosedDormantAccountCIFNo() {
	return ClosedDormantAccount_CIFNo;
}
@FindBy(xpath="//input[@id='accountQueryGrid_Id_A003_gs_GL_CODE']")
private WebElement accountQueryGLCode;
public WebElement accountQuery_GLCode() {
	return accountQueryGLCode;
}
@FindBy(xpath="//input[@id='accountQueryGrid_Id_A003_gs_CIF_SUB_NO']")
private WebElement accountQueryCIFNo;
public WebElement accountQuery_CIFNo() {
	return accountQueryCIFNo;
}
}
