package stepdefinitions.CSM;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.ExcelData;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CSM.AccountsObject;
import resources.BaseClass;

public class Accounts {
	WebDriver driver =BaseClass.driver;
	ConfigFileReader configFileRead = new ConfigFileReader();
	AccountsObject acccountsObj = new AccountsObject(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper =new JavascriptHelper();
	String sadsTestDataPath = System.getProperty("user.dir") + "\\TestData\\SADSTestData.xlsx";
	ExcelData excelData = new ExcelData(sadsTestDataPath, "Accounts Restriction", "Data Set ID");
		Map<String, String> testData ;
		DropDownHelper dropDownHelper = new DropDownHelper(driver);
		ExcelData testExecution = new ExcelData(sadsTestDataPath,"TestExecution","TestCaseID");
		Map<String, String> testExecutionData;
	
	
		@Then("^Click the accounts under CSM application$")
	    public void click_the_accounts_under_csm_application() throws Throwable {
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.accounts_Flag());
			clickAndActionHelper.moveToElement(acccountsObj.accounts_Flag());
			acccountsObj.accounts_Flag().click();
		}
		@And("^Click the Fixed maturity account flag under accounts$")
	    public void click_the_fixed_maturity_account_flag_under_accounts() throws Throwable {
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccount_Flag());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccount_Flag());
            acccountsObj.fixedMaturityAccount_Flag().click();
	    }
		@Then("^Click the opening under fixed maturity account$")
	    public void click_the_opening_under_fixed_maturity_account() throws Throwable {
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccounts_Openings());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccounts_Openings());
			acccountsObj.fixedMaturityAccounts_Openings().click();
	    }
		@And("^Enter the currency code and search it under fixed maturity account $")
	    public void enter_the_currency_code_and_search_it_under_fixed_maturity_account() throws Throwable {
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccountsCurrencyCode());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccountsCurrencyCode());
			acccountsObj.fixedMaturityAccountsCurrencyCode().click();
			acccountsObj.fixedMaturityAccountsCurrencyCode().sendKeys(testData.get("CurrencyCode"));
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccountsCurrencyCodeSearchButton());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccountsCurrencyCodeSearchButton());
			acccountsObj.fixedMaturityAccountsCurrencyCodeSearchButton().click();
		}

	    @Then("^Enter the type and it under fixed maturity account$")
	    public void enter_the_type_and_it_under_fixed_maturity_account() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccountsGLType());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccountsGLType());
			acccountsObj.fixedMaturityAccountsGLType().click();
			acccountsObj.fixedMaturityAccountsGLType().sendKeys(testData.get("GLType"));
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccountsGLTypeSearchButton());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccountsGLTypeSearchButton());
			acccountsObj.fixedMaturityAccountsGLTypeSearchButton().click();
			
			}
	    @And("^Enter the CIF type and search it under fixed maturity account$")
	    public void enter_the_cif_type_and_search_it_under_fixed_maturity_account() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.fixedMaturityAccountsOpenings_CIF());
			clickAndActionHelper.moveToElement(acccountsObj.fixedMaturityAccountsOpenings_CIF());
			acccountsObj.fixedMaturityAccountsOpenings_CIF().click();
			acccountsObj.fixedMaturityAccountsOpenings_CIF().sendKeys(testData.get("CIF No"));
	    }
	    @Then("^Validate the selected CIF and GL is resctricted under fixed maturity accounts$")
	    public void validate_the_selected_cif_and_gl_is_resctricted_under_fixed_maturity_accounts() throws Throwable {
	  
	    
	    
	    
	    
	    
	    
	    }
	    @And("^Navigate and click the General accounts flag$")
	    public void navigate_and_click_the_general_accounts_flag() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccount_Flag());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccount_Flag());
			acccountsObj.generalAccount_Flag().click();
	    }
	    @Then("^Click the openings under general accounts$")
	    public void click_the_openings_under_general_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccountsOpening());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccountsOpening());
			acccountsObj.generalAccountsOpening().click();
			}
	    @And("^Enter and search the currency code under general accounts$")
	    public void enter_and_search_the_currency_code_under_general_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccountsCurrencyCode());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccountsCurrencyCode());
			acccountsObj.generalAccountsCurrencyCode().click();
			acccountsObj.generalAccountsCurrencyCode().sendKeys(testData.get("CurrencyCode"));
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.genaralAccountsCurrencyCodeSearchButton());
			clickAndActionHelper.moveToElement(acccountsObj.genaralAccountsCurrencyCodeSearchButton());
			acccountsObj.genaralAccountsCurrencyCodeSearchButton().click();
			
	    }
	    @Then("^Enter and search the type under genearl accounts$")
	    public void enter_and_search_the_type_under_genearl_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccountsGLType());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccountsGLType());
			acccountsObj.generalAccountsGLType().click();
			acccountsObj.generalAccountsGLType().sendKeys(testData.get("GLType"));
			waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccountsGLTypeSearchButton());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccountsGLTypeSearchButton());
			acccountsObj.generalAccountsGLTypeSearchButton().click();

			}
	    @And("^Enter and search the  CIF under the general accounts$")
	    public void enter_and_search_the_cif_under_the_general_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.generalAccountsCIFNo());
			clickAndActionHelper.moveToElement(acccountsObj.generalAccountsCIFNo());
			acccountsObj.generalAccountsCIFNo().click();
		    acccountsObj.generalAccountsCIFNo().sendKeys(testData.get("CIF No"),Keys.ENTER);
		    
	    }


	    @Then("^Validate the CIF is resctricted under the general accounts$")
	    public void validate_the_cif_is_resctricted_under_the_general_accounts() throws Throwable {

	    
	    
	    
	    
	    
	    
	    
	    
	    }

	    @And("^Navigate and click the account query under accounts$")
	    public void navigate_and_click_the_account_query_under_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.account_Query());
			clickAndActionHelper.moveToElement(acccountsObj.account_Query());
			acccountsObj.account_Query().click();
	    }

	    @Then("^Click and enter the GL code under the account query$")
	    public void click_and_enter_the_gl_code_under_the_account_query() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.accountQuery_GLCode());
			clickAndActionHelper.moveToElement(acccountsObj.accountQuery_GLCode());
			acccountsObj.accountQuery_GLCode().sendKeys(testData.get("GLType"),Keys.ENTER);
	    }
	    @And("^Click and enter the CIF number under the account query$")
	    public void click_and_enter_the_cif_number_under_the_account_query() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.accountQuery_CIFNo());
			clickAndActionHelper.moveToElement(acccountsObj.accountQuery_CIFNo());
			acccountsObj.accountQuery_CIFNo().click();
			acccountsObj.accountQuery_CIFNo().sendKeys(testData.get("CIF No"));
			 for (int i = 0; i < 100; i++) {
					try {

						WebElement cifType = driver.findElement(By.xpath("//td[text()= '" +testData.get("CIF No")+ "']"));
						clickAndActionHelper.doubleClick(cifType);
						break;
					} catch (Exception e) {
					}
				}
			
	    }
	    @Then("^Validate the selected CIF and GL is resctricted under account query$")
	    public void validate_the_selected_cif_and_gl_is_resctricted_under_account_query() throws Throwable {

	    
	    
	    }
	    @And("^Navigate and click the closed dormant account flag under accounts$")
	    public void navigate_and_click_the_closed_dormant_account_flag_under_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.closedDormantAccount_Flag());
			clickAndActionHelper.moveToElement(acccountsObj.closedDormantAccount_Flag());
			acccountsObj.closedDormantAccount_Flag().click();
	    }

	    @Then("^Click the maintainance under the closed dormant account$")
	    public void click_the_maintainance_under_the_closed_dormant_account() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.closedDormantAccountsMaintenance());
			clickAndActionHelper.moveToElement(acccountsObj.closedDormantAccountsMaintenance());
			acccountsObj.closedDormantAccountsMaintenance().click();
	    }

	    @And("^Enter and search the the CIF code under the closed dormant account$")
	    public void enter_and_search_the_the_cif_code_under_the_closed_dormant_account() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, acccountsObj.closedDormantAccountsMaintenance());
			clickAndActionHelper.moveToElement(acccountsObj.closedDormantAccountsMaintenance());
	    }
	    @Then("^Validate the CIF is resctriced under the closed dormant account$")
	    public void validate_the_cif_is_resctriced_under_the_closed_dormant_account() throws Throwable {
	   
	    }

	   

	  
	    

	  

}
