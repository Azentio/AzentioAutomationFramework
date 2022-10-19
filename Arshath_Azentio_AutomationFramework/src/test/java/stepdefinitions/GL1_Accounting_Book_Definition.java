package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.GL1_Accounting_Setup_Data;

public class GL1_Accounting_Book_Definition extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	JsonConfig jsonConfig = new JsonConfig();
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String Book;
	Map<String, String> Getdata = new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();	
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	GL1_Accounting_Setup_Data acc_Setup_Data = jsonConfig.getAccsetupByName("Setup");
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	// ******************************@KUBS_GL_UAT_001_001*************************//

	@Given("^Navigate to Azentio Kubs$")
	public void navigate_to_azentio_kubs() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");
		
	}

	@And("^Click on Accounting Setup module$")
	public void click_on_accounting_setup_module() throws Throwable {
		// ----------ACCOUNTING SETUP---------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.accounting_setup(), 60, 500);
		accSetupObj.accounting_setup().click();
		
	}

	@Then("^Click sub module Accounting book definition$")
	public void click_sub_module_accounting_book_definition() throws Throwable {
		// ----------ACCOUNTING SUB MODULE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Eye(), 60, 500);
		accSetupObj.Accounting_book_definition_Eye().click();
	}

	@And("^Click on Add icon$")
	public void click_on_add_icon() throws Throwable {
		// ---------ADD ICON---------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Add(), 60, 500);
		accSetupObj.Accounting_book_definition_Add().click();
	}

	@Then("^Choose the Template Type of Base Template$")
	public void choose_the_template_type_of_base_template() throws Throwable {
		// --------TEMPLATE TYPE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Templatetype(), 60, 500);
		accSetupObj.Accounting_book_definition_Templatetype().click();
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(acc_Setup_Data.Template);
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(Keys.ENTER);
	}

	@And("^Enter Book Name$")
	public void enter_book_name() throws Throwable {
		// ------BOOK NAME-------//
		Random random = new Random();
	    int RanNo = random.nextInt(5000-10)+10;
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(acc_Setup_Data.BookName+RanNo);
	}

	@Then("^Select system date as Effective date$")
	public void select_system_date_as_effective_date() throws Throwable {
		// ------EFFECTIVE DATE------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_Date(), 60, 500);
		accSetupObj.Accounting_book_definition_Date().click();
		
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")), 60, 500);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//span[text()='" + acc_Setup_Data.Year + "']")), 60, 500);
		driver.findElement(By.xpath("//span[text()='" + acc_Setup_Data.Year + "']")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,driver.findElement(By.xpath("//span[text()='" + acc_Setup_Data.Month + "']")), 60, 500);
		driver.findElement(By.xpath("//span[text()='" + acc_Setup_Data.Month + "']")).click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  driver.findElement(By.xpath("(//span[text()='" + acc_Setup_Data.Day + "'])[1]")), 60, 500);
		driver.findElement(By.xpath("(//span[text()='" + acc_Setup_Data.Day + "'])[1]")).click();
	}

	@And("^Choose the Book Type what you Need$")
	public void choose_the_book_type_what_you_need() throws Throwable {
		//------Book type-----------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookType(), 60, 500);
		accSetupObj.Accounting_book_definition_BookType().click();
		accSetupObj.Accounting_book_definition_BookType().sendKeys(acc_Setup_Data.BookType);
		accSetupObj.Accounting_book_definition_BookType().sendKeys(Keys.ENTER);
	}

	@Then("^Enter the Remark$")
	public void enter_the_remark() throws Throwable {
		//--------REMARK------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Remarks(), 60, 500);
		accSetupObj.Accounting_book_definition_Remarks().click();
		accSetupObj.Accounting_book_definition_Remarks().sendKeys(acc_Setup_Data.Remark);
	}

	@And("^Save the Record$")
	public void save_the_record() throws Throwable {
		//---------SAVE THE RECORD------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Save(), 60, 500);
		accSetupObj.Accounting_book_definition_Save().click();

		for (int i = 0; i < 50; i++) {			
		try {
			//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Notification_Close(), 60, 2);
			clickAndActionHelper.clickOnElement(arapObj.ARAP_Notification_Close());
			arapObj.ARAP_Notification_Close().click();
			break;
		} 

		catch (Exception e) {
			if (i==50) {
				Assert.fail();
			}
		}
		}
		Thread.sleep(1000);
	}
	
    @And("^System should Generate unique code$")
    public void system_should_generate_unique_code() throws Throwable {
       //---------validate the unique code------------//
    	for (int i = 0; i < 10; i++) {
		try {	
		
    	javaScriptHelper.JavaScriptHelper(driver);
    	String uniquecode = (String) javaScriptHelper.executeScript("return document.getElementsByName('matCode')[1].value");
    	System.out.println("System Generated unique code: " +uniquecode);
    }
		catch(JavascriptException e) {
			e.getMessage();
		}
    	}
    }
    
	// ******************************@KUBS_GL_UAT_002_001*************************//	

    @And("^Enter Another Book Name$")
    public void enter_another_book_name() throws Throwable {
		// ------BOOK NAME-------//
//    	Random random = new Random();
//    	int r = random.nextInt(100-50)+50;
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(acc_Setup_Data.Default);
    }
    
    @Then("^Choose the Template Type of Custom Template$")
    public void choose_the_template_type_of_custom_template() throws Throwable {
		// --------TEMPLATE TYPE--------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_Templatetype(), 60, 500);
		accSetupObj.Accounting_book_definition_Templatetype().click();
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(acc_Setup_Data.Template1);
		accSetupObj.Accounting_book_definition_Templatetype().sendKeys(Keys.ENTER);
    }
	
    
	// ******************************@KUBS_GL_UAT_002_002*************************//
	
    @Then("^Validate the Message we get$")
    public void validate_the_message_we_get() throws Throwable {
        //--------VALIDATE THE MESSAGE-----------//    	
    	javaScriptHelper.JavaScriptHelper(driver);
    	WebElement getMsg = (WebElement) javaScriptHelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
    	System.out.println("System Not Allow to create same Book Name : " +getMsg.getText());
    	Assert.assertEquals("BookName already exists!!!",getMsg.getText());
    }
	
    
	// ******************************@KUBS_GL_UAT_002_004*************************//
	
	@Then("^Click on Table Row First Edit Icons$")
	public void click_on_table_row_first_edit_icon() throws Throwable {
		// -----------TABLE ROW FIRST EDIT ICON--------------------//
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_TableEdit(), 60, 500);
		accSetupObj.Accounting_book_definition_TableEdit().click();
		
	}
	
    @And("^Enter Modify Book Name$")
    public void enter_modify_book_name() throws Throwable {
		// ------BOOK NAME-------//
    	Random r = new Random();
    	int add = r.nextInt(1000-500)+500;
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  accSetupObj.Accounting_book_definition_BookName(), 60, 500);
		accSetupObj.Accounting_book_definition_BookName().click();
		accSetupObj.Accounting_book_definition_BookName().clear();
		accSetupObj.Accounting_book_definition_BookName().sendKeys(acc_Setup_Data.Modify+add);
		
    }
	
    
	// ******************************@KUBS_GL_UAT_003_003*************************//	
	
    @Then("^click sub module Accounting Category$")
    public void click_sub_module_accounting_category() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.accountingCategoryEyeicon(), 60, 500);
    	accSetupObj.accountingCategoryEyeicon().click();
    }
   
    @And("^enter the category code as Income$")
    public void enter_the_category_code_as_income() throws Throwable {
    	Random rand = new Random();
    	int randm = rand.nextInt(100-50)+50;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterCategoryCode(), 60, 500);
        accSetupObj.enterCategoryCode().click();
        accSetupObj.enterCategoryCode().sendKeys(acc_Setup_Data.CategoryBook+randm);
    }
    
    @And("^select the accounting book for Income$")
    public void select_the_accounting_book_for_income() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.selectAccountingBook(), 60, 500);
        accSetupObj.selectAccountingBook().click();
        accSetupObj.selectAccountingBook().sendKeys(Book);
        accSetupObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }
    
    @And("^enter the accounting category$")
    public void enter_the_accounting_category() throws Throwable {
    	Random rand = new Random();
    	int randm = rand.nextInt(100-50)+50;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterAccountingCategory(), 60, 500);
        accSetupObj.enterAccountingCategory().click();
        accSetupObj.enterAccountingCategory().sendKeys(acc_Setup_Data.CategoryCode+randm);
    }
    
    @And("^select Gl code generation$")
    public void select_gl_code_generation() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.selectGlCodeGeneration(), 60, 500);    	
        accSetupObj.selectGlCodeGeneration().sendKeys(acc_Setup_Data.GlGeneration);
        accSetupObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }
	
	
    
	// ******************************@KUBS_GL_UAT_003_004*************************//	

    @When("^Give the type as Base Template$")
    public void give_the_type_as_base_template() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.Accounting_book_definition_Templatesearch(), 60, 500);
    	accSetupObj.Accounting_book_definition_Templatesearch().click();
    	accSetupObj.Accounting_book_definition_Templatesearch().sendKeys(acc_Setup_Data.Template);
    }
    
    @And("^Get the Account Book Name$")
    public void get_the_account_book_name() throws Throwable {
    	Book = accSetupObj.Accounting_book_definition_GetAccBook().getText();
    	System.out.println(Book);
    }
    
    @And("^enter the category code as Expenditure$")
    public void enter_the_category_code_as_expenditure() throws Throwable {
    	Random rand= new Random();
    	int ranm = rand.nextInt(100-50)+50;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterCategoryCode(), 60, 500);
        accSetupObj.enterCategoryCode().click();
        accSetupObj.enterCategoryCode().sendKeys(acc_Setup_Data.CategoryBook1+ranm);
    }
	
    @And("^select the accounting book for Expenditure$")
    public void select_the_accounting_book_for_expenditure() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.selectAccountingBook(), 60, 500);
        accSetupObj.selectAccountingBook().click();
        accSetupObj.selectAccountingBook().sendKeys(Book);
        accSetupObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }

    @And("^enter the accounting category for Expenditure$")
    public void enter_the_accounting_category_for_expenditure() throws Throwable {
    	Random rand= new Random();
    	int ranm = rand.nextInt(100-50)+50;
    	waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterAccountingCategory(), 60, 500);
        accSetupObj.enterAccountingCategory().click();
        accSetupObj.enterAccountingCategory().sendKeys(acc_Setup_Data.CategoryCode1+ranm);
        waitHelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.enterAccountingCategory(), 60, 500);
        String Exp =accSetupObj.enterAccountingCategory().getText();
        Getdata.put("Exp", Exp);
    }
	
}
