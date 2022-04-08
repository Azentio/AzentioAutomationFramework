package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.GL_REPORTS_Obj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.GL_ModuleTestData;

public class Gl_Module extends BaseClass{
	
	WebDriver driver=BaseClass.driver;
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	GL_REPORTS_Obj glObj = new GL_REPORTS_Obj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	GL_ModuleTestData glModuleTestdata = jsonConfig.getGlmoduleTestDataByName("Maker");
	JavascriptHelper javascriptHelper= new JavascriptHelper();
	Map<String,String> mapData= new HashMap<>();
	@When("^user click the Accounting setups$")
    public void user_click_the_accounting_setups() throws Throwable {
		kubsMakerObj.kubsAccountingSetup().click();
    }

    @And("^click accounting category eye icon$")
    public void click_accounting_category_eye_icon() throws Throwable {
    	
    	glObj.accountingCategoryEyeicon().click();
    }

    @And("^click add icon in Gl$")
    public void click_add_icon_in_gl() throws Throwable {
    	glObj.addIcon().click();
    }

    @And("^enter the category code$")
    public void enter_the_category_code() throws Throwable {
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(glModuleTestdata.Categorycode);
    }

    @And("^select the accounting book$")
    public void select_the_accounting_book() throws Throwable {
    	glObj.selectAccountingBook().click();
    	glObj.selectAccountingBook().sendKeys(glModuleTestdata.AccountingBookname);
    	glObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }

    @And("^enter the accounting categorys$")
    public void enter_the_accounting_categorys() throws Throwable {
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(glModuleTestdata.AccoutingCategory);
    }

    @And("^select Gl code generations$")
    public void select_gl_code_generations() throws Throwable {
    	glObj.selectGlCodeGeneration().click();
    	glObj.selectGlCodeGeneration().sendKeys(Keys.ENTER);
    }

    @And("^click on save the accounting record$")
    public void click_on_save_the_accounting_record() throws Throwable {
    	glObj.saveButton().click();
    }
    @Then("^verify the accounting category created$")
    public void verify_the_accounting_category_created() throws Throwable {
     
     if(driver.findElement(By.xpath("//datatable-body-cell[3]//span[contains(text(),'"+glModuleTestdata.AccoutingCategory+"')]")).isDisplayed())
     {
    	 System.out.println("Accounting catogory is visible ");
     }
     else
     {
    	 Assert.fail("Accounting setup is not visible in the approved record, hence test cas efailed");
     }
    }
    
    /**    **/
    @And("^enter the category code as Liability$")
    public void enter_the_category_code_as_liability() throws Throwable {
    	glObj.enterCategoryCode().click();
    	glObj.enterCategoryCode().sendKeys(glModuleTestdata.Categorycode2);
    }

    @And("^enter the accounting category as Liability$")
    public void enter_the_accounting_category_as_liability() throws Throwable {
    	glObj.enterAccountingCategory().click();
    	glObj.enterAccountingCategory().sendKeys(glModuleTestdata.AccoutingCategory2);
    }
    @Then("^verify the accounting category created for liability$")
    public void verify_the_accounting_category_created_for_liability() throws Throwable {
    	 if(driver.findElement(By.xpath("//datatable-body-cell[3]//span[contains(text(),'"+glModuleTestdata.AccoutingCategory2+"')]")).isDisplayed())
         {
        	 System.out.println("Accounting catogory is visible ");
         }
         else
         {
        	 Assert.fail("Accounting setup is not visible in the approved record, hence test cas efailed");
         }
    }
    /** **/
    
    @Then("^verify the system should through the validation message for the excisting code$")
    public void verify_the_system_should_through_the_validation_message_for_the_excisting_code() throws Throwable {
    	glObj.existingRecordToastMessage().getText();
    	Assert.assertEquals(glObj.existingRecordToastMessage().getText(), "Category Code already exists!!!");
    }
    /** **/
    @And("^click the accounting book eye icon$")
    public void click_the_accounting_book_eye_icon() throws Throwable {
    	glObj.accountingBookDefinitionEyeIcon().click();
    }
    @And("^seach the active status$")
    public void seach_the_active_status() throws Throwable {
  	javascriptHelper.JavaScriptHelper(driver);
//    	javascriptHelper.scrollIntoView(glObj.searchStatus());
//    	glObj.searchStatus().click();
//    	glObj.searchStatus().sendKeys(glModuleTestdata.statusactive);
    	
    	while(true)
    	{
    		try
    		{
    			javascriptHelper.JSEClick(glObj.AccountingSetUpActiveBookRecord());
    		//	glObj.AccountingSetUpActiveBookRecord().click();
    			break;
    		}
    		catch(NoSuchElementException e)
    		{
    			glObj.nextPageInListView().click();
    		}
    		}
    	
    	}

    @And("^click the first edit eye icon in list view$")
    public void click_the_first_edit_eye_icon_in_list_view() throws Throwable {
    javascriptHelper.JavaScriptHelper(driver);
    javascriptHelper.scrollIntoViewAndClick(glObj.clickFirstEditIconInListView());
    	
    }

    @And("^get the book name$")
    public void get_the_book_name() throws Throwable {
    	mapData.put("bookName", glObj.accountingSetupActiveBookName().getText());
    	System.out.println(mapData.get("bookName"));
    	
    }

    @And("^Click the status and select deactivate$")
    public void click_the_status_and_select_deactivate() throws Throwable {
    	glObj.selectStatus().click();
    	glObj.selectStatus().sendKeys(Keys.DOWN);
    	glObj.selectStatus().sendKeys(Keys.ENTER);
    }
    @Then("^save the Accounting book record$")
    public void save_the_accounting_book_record() throws Throwable {
    	glObj.saveButton().click();
    }
    @Then("^verify the bill is inavtive or not$")
    public void verify_the_bill_is_inavtive_or_not() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	glObj.accountingBookDefenitionSearchBookName().click();
    	glObj.accountingBookDefenitionSearchBookName().sendKeys(mapData.get("bookName"));
    	javascriptHelper.scrollIntoView(glObj.getAccountingBookNameStatus());
    	System.out.println(glObj.getAccountingBookNameStatus().getText());   	
    	Assert.assertEquals(glObj.getAccountingBookNameStatus().getText(), "In-Active");
    	
    }
}
