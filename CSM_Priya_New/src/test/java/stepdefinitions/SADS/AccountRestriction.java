package stepdefinitions.SADS;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.ExcelData;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.SADs.AccountRestrictionObject;
import resources.BaseClass;

public class AccountRestriction extends BaseClass{
	WebDriver driver =BaseClass.driver;
	ConfigFileReader configFileRead = new ConfigFileReader();
	AccountRestrictionObject accountResctrictionObj = new AccountRestrictionObject(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper =new JavascriptHelper();
	String sadsTestDataPath = System.getProperty("user.dir") + "\\TestData\\SADSTestData.xlsx";
	ExcelData excelData = new ExcelData(sadsTestDataPath, "Accounts Restriction", "Data Set ID");
		Map<String, String> testData ;
		DropDownHelper dropDownHelper = new DropDownHelper(driver);
		ExcelData testExecution = new ExcelData(sadsTestDataPath,"TestExecution","TestCaseID");
		Map<String, String> testExecutionData;
		
		@And("^Choose the test data for account resctriction$")
	    public void choose_the_test_data_for_account_resctriction() throws Throwable {
			 //testExecutionData = testExecution.getTestdata("SADS_AT_001");
				//testData = excelData.getTestdata(testExecutionData.get("Data Set ID"));
			testData = excelData.getTestdata("SADS_AT_001_D1");

		}

	 @Then("^Click the Parameter$")
	    public void click_the_parameter() throws Throwable {
		 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.menuOption_Parameter());
		 clickAndActionHelper.moveToElement(accountResctrictionObj.menuOption_Parameter());
		 accountResctrictionObj.menuOption_Parameter().click();
	 }
	  @And("^Click the Account Resctriction under parameter$")
	    public void click_the_account_resctriction_under_parameter() throws Throwable {
		  waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.accountRestrictions());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.accountRestrictions());
			 accountResctrictionObj.accountRestrictions().click();
	  }
	  @Then("^Click the Maintainance under Account Resctriction$")
	    public void click_the_maintainance_under_account_resctriction() throws Throwable {
		  waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.accountRestrictions_Maintenance());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.accountRestrictions_Maintenance());
			 accountResctrictionObj.accountRestrictions_Maintenance().click();
	  }
	  @And("^Enter the code in Account Resctriction$")
	    public void enter_the_code_in_account_resctriction() throws Throwable {
		  waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.code());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.code());
			 accountResctrictionObj.code().click();
			 accountResctrictionObj.code().sendKeys(testData.get("Code"));

	  }
	  @Then("^Enter the description in Account Resctriction$")
	    public void enter_the_description_in_account_resctriction() throws Throwable {
		  waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.description());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.description());
			 accountResctrictionObj.description().click();
			 accountResctrictionObj.description().sendKeys(testData.get("Description "));
	  }

	    @And("^Choose the resctriction as AND or OR$")
	    public void choose_the_resctriction_as_and_or_or() throws Throwable {
	    	 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.And_Or());
//			 clickAndActionHelper.moveToElement(accountResctrictionObj.And_Or());
//			 accountResctrictionObj.And_Or().click();
	    	dropDownHelper.SelectUsingVisibleText(accountResctrictionObj.And_Or(), testData.get("AND/OR"));
	    }
	    @And("^Click the Root under ApplicationOTPs$")
	    public void click_the_root_under_applicationotps() throws Throwable {
	    	 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.applicationOTPs_Root());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.applicationOTPs_Root());
			 accountResctrictionObj.applicationOTPs_Root().click();
	    }
	    @Then("^Click the RET under Root$")
	    public void click_the_ret_under_root() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.RET_Flag());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.RET_Flag());
			 accountResctrictionObj.RET_Flag().click();
	    }
	    @And("^Click the Transaction Flag and select all transaction$")
	    public void click_the_transaction_flag_and_select_all_transaction() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.Transaction_Flag());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.Transaction_Flag());
			 accountResctrictionObj.Transaction_Flag().click();
			 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.transactiopn_Checkbox());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.transactiopn_Checkbox());
			 accountResctrictionObj.transactiopn_Checkbox().click();
	    }
	    @Then("^Click the Root under CompaniesBranches$")
	    public void click_the_root_under_companiesbranches() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.companiesBranches_RootFlag());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.companiesBranches_RootFlag());
			 accountResctrictionObj.companiesBranches_RootFlag().click();
	    }
	    @Then("^Select the Branch under Root$")
	    public void select_the_branch_under_root() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.branch1_Flag());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.branch1_Flag());
			 accountResctrictionObj.branch1_Flag().click();
			 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.branch1_CheckBox());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.branch1_CheckBox());
			 accountResctrictionObj.branch1_CheckBox().click();
	    }
	    @And("^Search the UserID$")
	    public void search_the_userid() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.userID_SearchField());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.userID_SearchField());
			 accountResctrictionObj.userID_SearchField().click();
			 accountResctrictionObj.userID_SearchField().sendKeys(testData.get("User ID"));
			 for (int i = 0; i <200; i++) {
				
					
					try {
						accountResctrictionObj.userID_SearchField().sendKeys(Keys.ENTER);
						if (driver.findElement(By.xpath("//td[text()='1234']/preceding-sibling::td[@id='td_userGridId_UR00M_0_cb']//input")).isDisplayed()) {
							break;
						}
					} catch (Exception e) {
						if (i==199) {
							Assert.fail(e.getMessage());
						}
					}
					
				
			}
			 
	
			
	    }
	    @Then("^Click the checkbox of the searched user ID$")
	    public void click_the_checkbox_of_the_seached_user_id() throws Throwable {
//    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.userID_FirstCheckBox());
//			 clickAndActionHelper.moveToElement(accountResctrictionObj.userID_FirstCheckBox());
//			 accountResctrictionObj.userID_FirstCheckBox().click();
	    	for (int i = 0; i < 100; i++) {
				try {
					driver.findElement(By.xpath("//td[text()='1234']/preceding-sibling::td[@id='td_userGridId_UR00M_0_cb']//input")).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
			}
			}
	    }
	    @And("^Click the Add button in the resctriction type$")
	    public void click_the_add_button_in_the_resctriction_type() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.restrictionType_GL_Addbutton());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.restrictionType_GL_Addbutton());
			 accountResctrictionObj.restrictionType_GL_Addbutton().click();
	    }
	    @Then("^Click the search button to choose the GL code$")
	    public void click_the_search_button_to_choose_the_gl_code() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.glCode_SearchButton());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.glCode_SearchButton());
			 accountResctrictionObj.glCode_SearchButton().click();
		}
	    @And("^Enter the GL code input value and choose it$")
	    public void enter_the_gl_code_input_value_and_choose_it() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.glCode_InputField());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.glCode_InputField());
			 accountResctrictionObj.glCode_InputField().click();
			 accountResctrictionObj.glCode_InputField().sendKeys(testData.get("GL Code"));
			 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.glCode_InputValue_Click());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.glCode_InputValue_Click());
			 clickAndActionHelper.doubleClick(accountResctrictionObj.glCode_InputValue_Click());
				 
	    }
	    @Then("^Click the add button in the resctriction type and select the CIF Type$")
	    public void click_the_add_button_in_the_resctriction_type_and_select_the_cif_type() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.restrictionType_GL_Addbutton());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.restrictionType_GL_Addbutton());
			 accountResctrictionObj.restrictionType_GL_Addbutton().click();	   
		}
	    @And("^Click the add button in CIF Type$")
	    public void click_the_add_button_in_cif_type() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.CIFType_AddButton());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.CIFType_AddButton());
			 accountResctrictionObj.CIFType_AddButton().click();
	    }
	    @Then("^Click the search button in CIF Type$")
	    public void click_the_search_button_in_cif_type() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.CIFType_SearchButton());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.CIFType_SearchButton());
			 accountResctrictionObj.CIFType_SearchButton().click();
	    }

	    @And("^Enter the CIF Type input value and select the value$")
	    public void enter_the_cif_type_input_value_and_select_the_value() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.CIFTypeCode_InputField());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.CIFTypeCode_InputField());
			 accountResctrictionObj.CIFTypeCode_InputField().click();
			 accountResctrictionObj.CIFTypeCode_InputField().sendKeys(testData.get("CIF Type"));
			 for (int i = 0; i < 100; i++) {
					try {

						WebElement cifType = driver.findElement(By.xpath("//td[text()= '" +testData.get("CIF Type")+ "']"));
						clickAndActionHelper.doubleClick(cifType);
						break;
					} catch (Exception e) {
					}
				}
		}

	    @Then("^Save the record in account resctriction$")
	    public void save_the_record_in_account_resctriction() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.save_Button());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.save_Button());
			 accountResctrictionObj.save_Button().click();
//			 waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.saveSucess_OK_Button());
//			 clickAndActionHelper.moveToElement(accountResctrictionObj.saveSucess_OK_Button());
//			 accountResctrictionObj.saveSucess_OK_Button().click();
			 
	    }
	    @And("^Navigate to Approval in account resctriction$")
	    public void navigate_to_approval_in_account_resctriction() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.accountRestrictions_Approve());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.accountRestrictions_Approve());
			 accountResctrictionObj.accountRestrictions_Approve().click();
	    }
	    @Then("^Enter the code input value and select it$")
	    public void enter_the_code_input_value_and_select_it() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.approval_Code_InputValue());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.approval_Code_InputValue());
			 accountResctrictionObj.approval_Code_InputValue().click();
			 accountResctrictionObj.approval_Code_InputValue().sendKeys(testData.get("Code"),Keys.ENTER);
			 for (int i = 0; i < 100; i++) {
					try {

						WebElement code = driver.findElement(By.xpath("//td[text()= '" +testData.get("Code")+ "']"));
						clickAndActionHelper.doubleClick(code);
						break;
					} catch (Exception e) {
					}
	    }
	    }
	    @And("^Approve the rescticted record$")
	    public void approve_the_rescticted_record() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, accountResctrictionObj.approval_Button());
	    	javaScriptHelper.scrollIntoViewAndClick(accountResctrictionObj.approval_Button());
			 clickAndActionHelper.moveToElement(accountResctrictionObj.approval_Button());
			 accountResctrictionObj.approval_Button().click();
			}
}



