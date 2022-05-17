package stepdefinitions;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ArApObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.GL1Obj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ArApTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.FixedAssetTestDataType;
import testDataType.GL1TestDataType;
import testDataType.InventoryManagementTestDataType;

public class GL1 {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	BUDGET_BudgetCreationTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	FixedAssetTestDataType fixedAssetTestDataType = new FixedAssetTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	String referance_id;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	ArApTestDataType arApTestDataType =  jsonReader.getArApByName("Maker");
	ArApObj arAPobj = new ArApObj(driver);
	GL1TestDataType gL1TestDataType =  jsonReader.getGL1ByName("Maker");
	GL1Obj gL1obj = new GL1Obj(driver);
	//----------------KUBS_GL_UAT_005_003---------------
	
	 @Then("^click on accounting setup$")
	    public void click_on_accounting_setup() throws Throwable {
			waithelper.waitForElement(driver, 2000, gL1obj.accountingSetup_Button());
			gL1obj.accountingSetup_Button().click();
			Thread.sleep(2000);
	    }

	    @Then("^Click on Chart of account definatation$")
	    public void click_on_chart_of_account_definatation() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.chartOfAccountsDefination_Button());
			gL1obj.chartOfAccountsDefination_Button().click(); 
	    }

	    @Then("^Click on COA add button$")
	    public void click_on_coa_add_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.chartOfAccountsDefination_AddButton());
			gL1obj.chartOfAccountsDefination_AddButton().click(); 
	    }

	    @Then("^FIll the form for COA$")
	    public void fill_the_form_for_coa() throws Throwable {
	    	Random random = new Random();
	    	int radom = random.nextInt(500-100)+100;
	    	waithelper.waitForElement(driver, 2000, gL1obj.accountingCategory_textBox());
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(gL1TestDataType.AccountingCategory);
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.cOAname_textBox());
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(gL1TestDataType.coaName+radom);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.parentGL_textBox());
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(gL1TestDataType.parentGL);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.gLType_textBox());
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(gL1TestDataType.gLType);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.decriptionOfGL_textBox());
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(gL1TestDataType.description+radom);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.balanceType_Textbox());
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(gL1TestDataType.balanceType);
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
			
			
	    }

	    @Then("^FIll the form for COA1$")
	    public void fill_the_form_for_coa1() throws Throwable {
	    	Random ran = new Random();
	    	int radom = ran.nextInt(500-100)+100;
	    	waithelper.waitForElement(driver, 2000, gL1obj.accountingCategory_textBox());
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(gL1TestDataType.AccountingCategory);
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.cOAname_textBox());
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(gL1TestDataType.coaName1+radom);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.parentGL_textBox());
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(gL1TestDataType.parentGL1);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.gLType_textBox());
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(gL1TestDataType.gLType1);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.decriptionOfGL_textBox());
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(gL1TestDataType.description1+radom);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.balanceType_Textbox());
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(gL1TestDataType.balanceType);
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
	    }
	    
	    @Then("^FIll the form for COA2$")
	    public void fill_the_form_for_coa2() throws Throwable {
	    	Random ran = new Random();
	    	int radom = ran.nextInt(500-100)+100;
	    	waithelper.waitForElement(driver, 2000, gL1obj.accountingCategory_textBox());
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(gL1TestDataType.AccountingCategory);
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.cOAname_textBox());
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(gL1TestDataType.coaName2+radom);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.parentGL_textBox());
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(gL1TestDataType.parentGL2);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.gLType_textBox());
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(gL1TestDataType.gLType2);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.decriptionOfGL_textBox());
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(gL1TestDataType.description2+radom);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.balanceType_Textbox());
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(gL1TestDataType.balanceType);
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
	    }
	    
	    @Then("^FIll the form for COA3$")
	    public void fill_the_form_for_coa3() throws Throwable {
	    	Random ran = new Random();
	    	int radom = ran.nextInt(500-100)+100;
	    	waithelper.waitForElement(driver, 2000, gL1obj.accountingCategory_textBox());
			gL1obj.accountingCategory_textBox().click(); 
			gL1obj.accountingCategory_textBox().sendKeys(gL1TestDataType.AccountingCategory);
			gL1obj.accountingCategory_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.cOAname_textBox());
			gL1obj.cOAname_textBox().click(); 
			gL1obj.cOAname_textBox().sendKeys(gL1TestDataType.coaName3+radom);
			gL1obj.cOAname_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.parentGL_textBox());
			gL1obj.parentGL_textBox().click(); 
			gL1obj.parentGL_textBox().sendKeys(gL1TestDataType.parentGL3);
			gL1obj.parentGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.gLType_textBox());
			gL1obj.gLType_textBox().click(); 
			gL1obj.gLType_textBox().sendKeys(gL1TestDataType.gLType3);
			gL1obj.gLType_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.decriptionOfGL_textBox());
			gL1obj.decriptionOfGL_textBox().click(); 
			gL1obj.decriptionOfGL_textBox().sendKeys(gL1TestDataType.description3+radom);
			gL1obj.decriptionOfGL_textBox().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 2000, gL1obj.balanceType_Textbox());
			gL1obj.balanceType_Textbox().click(); 
			gL1obj.balanceType_Textbox().sendKeys(gL1TestDataType.balanceType);
			gL1obj.balanceType_Textbox().sendKeys(Keys.ENTER);
	    }
	    
	    @Then("^Click on Save buttonT$")
	    public void click_on_save_buttonT() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.saveButtonForGeneralLedger());
			gL1obj.saveButtonForGeneralLedger().click(); 
	    }
	    
	    
	 //------------ KUBS_GL_UAT_005_004----------------  
	    
	    
	    @Then("^Click on add button of branch$")
	    public void click_on_add_button_of_branch() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.branch_AddButton());
			gL1obj.branch_AddButton().click(); 
	    }

	    @Then("^Fill the form for which branch we need to save$")
	    public void fill_the_form_for_which_branch_we_need_to_save() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.branch_TextBox());
			gL1obj.branch_TextBox().click(); 
			gL1obj.branch_TextBox().sendKeys(gL1TestDataType.branch);
			gL1obj.branch_TextBox().sendKeys(Keys.ENTER);
			
			
			waithelper.waitForElement(driver, 2000, gL1obj.department_TextBox());
			gL1obj.department_TextBox().click(); 
			gL1obj.department_TextBox().sendKeys(gL1TestDataType.department);
			gL1obj.department_TextBox().sendKeys(Keys.ENTER);
			
			
			waithelper.waitForElement(driver, 2000, gL1obj.costCentre_TextBox());
			gL1obj.costCentre_TextBox().click(); 
			gL1obj.costCentre_TextBox().sendKeys(gL1TestDataType.costCentre);
			gL1obj.costCentre_TextBox().sendKeys(Keys.ENTER);
			
	    }
	    

	    @Then("^Click on save button for saving branch$")
	    public void click_on_save_button_for_saving_branch() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.branch_SaveButton());
			gL1obj.branch_SaveButton().click(); 
	    }

	    @Then("^Click on save of General Ledger$")
	    public void click_on_save_of_general_ledger() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.gLbranch_SaveButton());
			gL1obj.gLbranch_SaveButton().click();
	    } 
	    
	  //---------------KUBS_GL_UAT_005_009---------------  
	    

	    @Then("^Click on search button to search COA$")
	    public void click_on_search_button_to_search_coa() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.search_Button());
			gL1obj.search_Button().click(); 
			
			waithelper.waitForElement(driver, 2000, gL1obj.cOANameSearch_Textbox());
			gL1obj.cOANameSearch_Textbox().click(); 
			gL1obj.cOANameSearch_Textbox().sendKeys(gL1TestDataType.COAnameToinactive);
			gL1obj.cOANameSearch_Textbox().sendKeys(Keys.ENTER);
			
	    }

	    @Then("^Click on Edit button to edit COA record$")
	    public void click_on_edit_button_to_edit_coa_record() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.editAction_Button());
			gL1obj.editAction_Button().click();
	    }

	    @Then("^Click on status to make it inactive$")
	    public void click_on_status_to_make_it_inactive() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.statusOfCOA_Textbox());
			gL1obj.statusOfCOA_Textbox().click(); 
			gL1obj.statusOfCOA_Textbox().sendKeys(gL1TestDataType.statusofCOA);
			gL1obj.statusOfCOA_Textbox().sendKeys(Keys.ENTER);
			Thread.sleep(5000);
	    }

	    @Then("^Click on save button to save record$")
	    public void click_on_save_button_to_save_record() throws Throwable {
	    	waithelper.waitForElement(driver, 2000, gL1obj.saveCOA_Button());
			gL1obj.saveCOA_Button().click();  
	    }

	    @Then("^Validation message should pop up$")
	    public void validation_message_should_pop_up() throws Throwable {
//	       System.out.println("Can not deactivate as COA is currently used");
	    	String Msg = gL1obj.budget_creation_Getalert().getText();
	    	System.out.println(Msg);
	    	Assert.assertEquals(Msg, "There are already active transcation for the COA, cannot be modified");
	    } 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
