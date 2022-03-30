package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL_Accounting_Setup_Obj {
	WebDriver driver;
	public GL_Accounting_Setup_Obj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Accounting book definition
	@FindBy(xpath="//ion-label[contains(text(),'Accounting setup')]")
	private WebElement accounting_setup;
	public WebElement accounting_setup() {
		return accounting_setup;
	}
	
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/135']")
	private WebElement  Accounting_book_definition_Eye;
	public WebElement  Accounting_book_definition_Eye() {
		return Accounting_book_definition_Eye;
	}
	
	@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement  Accounting_book_definition_Templatetype;
	public WebElement  Accounting_book_definition_Templatetype() {
		return Accounting_book_definition_Templatetype;
	}
	
	@FindBy(xpath="//input[@name='langDtls']")
	private WebElement  Accounting_book_definition_BookName;
	public WebElement  Accounting_book_definition_BookName() {
		return Accounting_book_definition_BookName;
	}
	
	@FindBy(xpath="//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement  Accounting_book_definition_BookType;
	public WebElement  Accounting_book_definition_BookType() {
		return Accounting_book_definition_BookType;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[2]")
	private WebElement Accounting_book_definition_TableEdit;
	public WebElement Accounting_book_definition_TableEdit() {
		return Accounting_book_definition_TableEdit;
	}
	
	@FindBy(xpath="//input[@name='remarks']")
	private WebElement  Accounting_book_definition_Remarks;
	public WebElement  Accounting_book_definition_Remarks() {
		return Accounting_book_definition_Remarks;
	}
	
	@FindBy(xpath="//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement  Accounting_book_definition_Save;
	public WebElement  Accounting_book_definition_Save() {
		return Accounting_book_definition_Save;
	}
	
	@FindBy(xpath="//ion-icon[@name='add']")
	private WebElement  Accounting_book_definition_Add;
	public WebElement  Accounting_book_definition_Add() {
		return Accounting_book_definition_Add;
	}
	
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement  Accounting_book_definition_Notification;
	public WebElement  Accounting_book_definition_Notification() {
		return Accounting_book_definition_Notification;
	}
	
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
	private WebElement  Accounting_book_definition_Action;
	public WebElement  Accounting_book_definition_Action() {
		return Accounting_book_definition_Action;
	}
	
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	private WebElement  Accounting_book_definition_Submit;
	public WebElement  Accounting_book_definition_Submit() {
		return Accounting_book_definition_Submit;
	}
	
	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement Accounting_book_definition_Alertremark;
	public WebElement Accounting_book_definition_Alertremark() {
		return Accounting_book_definition_Alertremark;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement Accounting_book_definition_Alertsubmit;
	public WebElement Accounting_book_definition_Alertsubmit() {
		return Accounting_book_definition_Alertsubmit;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement Accounting_book_definition_reviewer_id;
	public WebElement Accounting_book_definition_reviewer_id() {
		return Accounting_book_definition_reviewer_id;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement Accounting_book_definition_notificationClose;
	public WebElement Accounting_book_definition_notificationClose() {
		return Accounting_book_definition_notificationClose;
	}
	
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement Accounting_book_definition_Date;
	public WebElement Accounting_book_definition_Date() {
		return Accounting_book_definition_Date;
	}


	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement Accounting_book_definition_NextMonth;
	public WebElement Accounting_book_definition_NextMonth() {
		return Accounting_book_definition_NextMonth;
	}
	
	@FindBy(xpath = "//ion-input[1]/input[@name='matCode']")
	private WebElement Accounting_book_definition_Code;
	public WebElement Accounting_book_definition_Code() {
		return Accounting_book_definition_Code;
	}
		
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[6]/div[1]/ion-input[1]/input[1]")
	private WebElement Accounting_book_definition_Templatesearch;
	public WebElement Accounting_book_definition_Templatesearch() {
		return Accounting_book_definition_Templatesearch;
	 }
	@FindBy(xpath="(//datatable-body-cell[3]/div[1]/span[1])[1]")
	private WebElement Accounting_book_definition_GetAccBook;
	public WebElement Accounting_book_definition_GetAccBook() {
		return Accounting_book_definition_GetAccBook;
	 }	
	// Accounting category
	 @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/149']")
	 private WebElement accountingCategoryEyeicon;
	 public WebElement accountingCategoryEyeicon() {
		 return accountingCategoryEyeicon;
	 }
	 
	 @FindBy(xpath="//ion-row[1]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	 private WebElement enterCategoryCode;
	 public WebElement enterCategoryCode() {
		 return enterCategoryCode;
	 }
	 
	 @FindBy(xpath="//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectAccountingBook;
	 public WebElement selectAccountingBook() {
		 return selectAccountingBook;
	 }
	 
	 @FindBy(xpath="//ion-row[2]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	 private WebElement enterAccountingCategory;
	 public WebElement enterAccountingCategory() {
		 return enterAccountingCategory;
	 }
	 
	 @FindBy(xpath="//ion-row[2]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectGlCodeGeneration;
	 public WebElement selectGlCodeGeneration() {
		 return selectGlCodeGeneration;
	 }
	
}
