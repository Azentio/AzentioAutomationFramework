package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Enquiry_Obj;
import pageobjects.Gl_Reports_Obj1;
import pageobjects.KUBS_LoginObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.Cancellationofcontractdatatype;
import testDataType.GL_ModuleTestData;


public class GL_Module1 extends BaseClass{
   WebDriver driver = BaseClass.driver;
   Gl_Reports_Obj1 glReportsObj = new Gl_Reports_Obj1(driver);
   Selenium_Actions seleniumactions = new Selenium_Actions(driver);
    KUBS_Login login;
	ConfigFileReader configreader = new ConfigFileReader();
	JsonConfig jsonconfig = new JsonConfig();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	GL_ModuleTestData glModuleData = jsonconfig.getGlmoduleTestDataByName("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	
	@Given("^Login as a Azentio Maker$")
    public void login_as_a_azentio_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);	
    }

    @When("^click the Direction icon$")
    public void click_the_direction_icon() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getOptionicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getOptionicon());
    }

    @Then("^verify that available balance should equal to closing net balance in Gl balance Report$")
    public void verify_that_available_balance_should_equal_to_closing_net_balance_in_gl_balance_report() throws Throwable {
        ////*[@id="__bookmark_1"]/tbody/tr[3]/td[15]/div
    	seleniumactions.getBrowserHelper().SwitchToWindow(1);
    	int i=3;
    	String xpath="//*[@id=\"__bookmark_1\"]/tbody/tr[3]/td["+i+"]/div";
    	while (true) {
    		i++;
			try {
				javascriphelper.JavaScriptHelper(driver);
				javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
				driver.findElement(By.xpath(xpath)).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				glReportsObj.nextPageInGlbalanceReport().click();
			}
		}
    	seleniumactions.getBrowserHelper().switchToParentWithChildClose();
    	
    	
    }

    @And("^click the Account Payable Main Module$")
    public void click_the_account_payable_main_module() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
    }

    @And("^click the Manual Payout Eye icon$")
    public void click_the_manual_payout_eye_icon() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(glReportsObj.manualPayoutEyeIcon());
        glReportsObj.manualPayoutEyeIcon().click();
    }

    @And("^click the Add icon in Manual Payout$")
    public void click_the_add_icon_in_manual_payout() throws Throwable {
        glReportsObj.manualPayoutAddIcon().click();
    }

    @And("^Select the entity branch$")
    public void select_the_entity_branch() throws Throwable {
    	glReportsObj.manualPayoutSelectEntityBranch().click();
        glReportsObj.manualPayoutSelectEntityBranch().sendKeys(glModuleData.branchCode);
        glReportsObj.manualPayoutSelectEntityBranch().sendKeys(Keys.ENTER);
    }

    @And("^Select the Buisness Partner Name$")
    public void select_the_buisness_partner_name() throws Throwable {
        glReportsObj.manualPayoutSelectBp().click();
        glReportsObj.manualPayoutSelectBp().sendKeys(Keys.ENTER);
        
    }

    @And("^Select the beneficiary name$")
    public void select_the_beneficiary_name() throws Throwable {
        glReportsObj.manualPayoutSelectBeneficiaryName().click();
    }

    @And("^Select the currency type$")
    public void select_the_currency_type() throws Throwable {
    	glReportsObj.manualPayoutSelectBeneficiaryName().click();
        glReportsObj.manualPayoutSelectBeneficiaryName().sendKeys(Keys.ENTER);
    }

    @And("^click the calender and select the valid date$")
    public void click_the_calender_and_select_the_valid_date() throws Throwable {
    	enquiryObj.calenderInContractReport().click();
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")) );
    	driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
		.click();  	
seleniumactions.getWaitHelper().waitForElement(driver,2000 , driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")));
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")).click();
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlToMonth + "']")).click();
seleniumactions.getWaitHelper().waitForElement(driver, 2000,
		driver.findElement(By.xpath("//tbody/tr[5]/td[@aria-label='"+glModuleData.GlFullMonth+" "+glModuleData.GlDay+", "+glModuleData.GlYear+"']")));
driver.findElement(By.xpath("//tbody/tr[5]/td[@aria-label='"+glModuleData.GlFullMonth+" "+glModuleData.GlDay+", "+glModuleData.GlYear+"']")).click();
    }

    @And("^Select bank in manual payout$")
    public void select_bank_in_manual_payout() throws Throwable {
        glReportsObj.manualPayoutSelectBank().click();
        glReportsObj.manualPayoutSelectBank().sendKeys(glModuleData.PaymentBank);
        glReportsObj.manualPayoutSelectBank().sendKeys(Keys.ENTER);
    }

    @And("^Select the bank Account Number$")
    public void select_the_bank_account_number() throws Throwable {
        glReportsObj.manualPayoutSelectBankAccountNumber().click();
        glReportsObj.manualPayoutSelectBankAccountNumber().sendKeys(Keys.ENTER);
    }

    @And("^get the Available  balance and store$")
    public void get_the_available_balance_and_store() throws Throwable {
        javascriphelper.JavaScriptHelper(driver);
        String Availablebalance = (String) javascriphelper.executeScript("return document.getElementById('availableBalance').value");
        System.out.println(Availablebalance);
       String Balance = Availablebalance.substring(0, 9).trim();
       String AvailabeBalance= Balance.substring(0,1)+","+Balance.substring(1, 2)+Balance.substring(3, 5)+Balance.substring(5);
       testdata.put("AvailableBalance", AvailabeBalance);
       System.out.println(AvailabeBalance);
    }

    @And("^click the notes option$")
    public void click_the_notes_option() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(enquiryObj.inventoryReportIcon());
        enquiryObj.inventoryReportIcon().click();
        Thread.sleep(2000);
    }

    @And("^click the financial Report$")
    public void click_the_financial_report() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000, enquiryObj.financialReporting());
        enquiryObj.financialReporting().click();
    }

    @And("^click the Gl balance report edit icon$")
    public void click_the_gl_balance_report_edit_icon() throws Throwable {
        glReportsObj.FinancialTransactionIcon().click();;
    }

    @And("^select the branch$")
    public void select_the_branch() throws Throwable {
        glReportsObj.glBalanceReportSelectBranch().click();
        glReportsObj.glBalanceReportSelectBranch().sendKeys(glModuleData.branchCode);
        glReportsObj.glBalanceReportSelectBranch().sendKeys(Keys.ENTER);
    }

    @And("^select the Gl code$")
    public void select_the_gl_code() throws Throwable {
        glReportsObj.glBalanceReportSelectGlcode().click();
        glReportsObj.glBalanceReportSelectGlcode().sendKeys(glModuleData.gLCode);
        glReportsObj.glBalanceReportSelectGlcode().sendKeys(Keys.ENTER);
        
    }
    @And("^Select the Gl from date$")
    public void select_the_gl_from_date() throws Throwable {
    	enquiryObj.calenderInContractReport().click();
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")) );
    	driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
		.click();
    	
seleniumactions.getWaitHelper().waitForElement(driver,2000 , driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")));
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")).click();
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlMonth + "']")).click();
seleniumactions.getWaitHelper().waitForElement(driver, 2000,
		driver.findElement(By.xpath("//td[@aria-label='"+glModuleData.GlFullMonth+" "+glModuleData.GlDay+", "+glModuleData.GlYear+"']")));
driver.findElement(By.xpath("//td[@aria-label='"+glModuleData.GlFullMonth+" "+glModuleData.GlDay+", "+glModuleData.GlYear+"']")).click();
    }
    

    @And("^Select the Gl To date$")
    public void select_the_gl_to_date() throws Throwable {
    	enquiryObj.calenderInContractReport().click();
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")) );
    	driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
		.click();
    	
seleniumactions.getWaitHelper().waitForElement(driver,2000 , driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")));
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear  + "']")).click();
driver.findElement(By.xpath("//span[text()='" + glModuleData.GlToMonth + "']")).click();
seleniumactions.getWaitHelper().waitForElement(driver, 2000,
		driver.findElement(By.xpath("(//span[text()='" + glModuleData.GlToDate + "'])[1]")));
driver.findElement(By.xpath("(//span[text()='" + glModuleData.GlToDate + "'])[1]")).click();
    }

    @And("^select the currency type in gl balance report$")
    public void select_the_currency_type_in_gl_balance_report() throws Throwable {
        glReportsObj.glBalanceReportCurrency().click();
        glReportsObj.glBalanceReportCurrency().sendKeys(glModuleData.CurrencyType);
    }

    @And("^click the View button$")
    public void click_the_view_button() throws Throwable {
        glReportsObj.glViewButton().click();
    }

    
    //************************************KUBS_GL_UAT_007_001**************************************************************************
    //Check the accounting mapping done for the accounting Scheme
    @When("^user click the Accounting setup$")
    public void user_click_the_accounting_setup() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportsObj.accountingSetup());
        glReportsObj.accountingSetup().click();
    }

    @Then("^verify the mapping of accounintg entries to be triggered$")
    public void verify_the_mapping_of_accounintg_entries_to_be_triggered() throws Throwable {
        String xpath ="//ul/li/span[contains(text(),'Cash Accounting Sceme')]";
        javascriphelper.JavaScriptHelper(driver);
        javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    @And("^click the accounting scheme definition eye icon$")
    public void click_the_accounting_scheme_definition_eye_icon() throws Throwable {
        glReportsObj.accountingSchemeDefinitionEyeIcon().click();
    }

    @And("^click the search icon$")
    public void click_the_search_icon() throws Throwable {
        glReportsObj.searchIcon().click();
    }

    @And("^search the active status in list view$")
    public void search_the_active_status_in_list_view() throws Throwable {
        glReportsObj.searchStatusInAccountingScheme().click();
        glReportsObj.searchStatusInAccountingScheme().sendKeys(glModuleData.statusactive);
        glReportsObj.searchStatusInAccountingScheme().sendKeys(Keys.ENTER);
    }

    @And("^get the accounting scheme name in first list view$")
    public void get_the_accounting_scheme_name_in_first_list_view() throws Throwable {
        String Xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/span[1]";
        String AccountingSchemeName = driver.findElement(By.xpath(Xpath)).getText();
        testdata.put("AccountingSchemeName", AccountingSchemeName);
    }

    @And("^click the Accounting Scheme Event Mapping Eye icon$")
    public void click_the_accounting_scheme_event_mapping_eye_icon() throws Throwable {
        glReportsObj.accountingSchemeEventMappingEyeIcon().click();
    }

//    @And("^click add icon in Gl$")
//    public void click_add_icon_in_gl() throws Throwable {
//        glReportsObj.addIcon().click();
//    }
    
    @And("^select the event$")
    public void select_the_event() throws Throwable {
        glReportsObj.selectEvent().click();
        glReportsObj.selectEvent().sendKeys(glModuleData.EventName);
        glReportsObj.selectEvent().sendKeys(Keys.ENTER);
    }

    @And("^click the Scheme$")
    public void click_the_scheme() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	String xpath1 ="//ul/li/span[contains(text(),'"+glModuleData.SchemeName1+"')]";
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath1)));
    	driver.findElement(By.xpath(xpath1)).click();
    	
    	
    }

    @And("^click Add button$")
    public void click_add_button() throws Throwable {
        glReportsObj.addSchemesButton().click();
    }

    @And("^click next Scheme$")
    public void click_next_scheme() throws Throwable {
    	String xpath2 ="//ul/li/span[contains(text(),'"+glModuleData.SchemeName2+"')]";
    	javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath2)));
    	driver.findElement(By.xpath(xpath2)).click();
    }

    @And("^click save button in event mapping$")
    public void click_save_button_in_event_mapping() throws Throwable {
        glReportsObj.saveButtonInEventMapping().click();
    }

//    @And("^Click on notification icon$")
//    public void click_on_notification_icon() throws Throwable {
//    	Thread.sleep(1000);
//        glReportsObj.makerNotificationIcon().click();
//    }

    @And("^select the first records$")
    public void select_the_first_records() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 3000, glReportsObj.firstReferenceId());
		String firtsReferenceID = glReportsObj.firstReferenceId().getText();
		// Geting reference ID
		jsonWriter.addReferanceData(firtsReferenceID);
		glReportsObj.FirstRecordEditIcon().click();
		
    }
    @And("^click on submits$")
    public void click_on_submits() throws Throwable {
    	glReportsObj.submitRemark().click();
         Thread.sleep(2000);
         Thread.sleep(2000);
         seleniumactions.getWaitHelper().waitForElement(driver, 2000,glReportsObj.budgetCreation_ReviewerId());
 		String reviwerId = glReportsObj.budgetCreation_ReviewerId().getText();
 		String trimmerReviewerID = reviwerId.substring(85);
 		StringBuffer sb = new StringBuffer(trimmerReviewerID);
 		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
 		String revID = finalReviewerID.toString();
 		// System.out.println("String buffer reviewer ID is"+finalReviewerID);
 		// System.out.println("Reviewer ID is"+revID);
 		jsonWriter.addData(revID);
    }

    @And("^click on submit buttons$")
    public void click_on_submit_buttons() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportsObj.submit());
        glReportsObj.submit().click();
    }

//    @And("^enter remark in alert tab$")
//    public void enter_remark_in_alert_tab() throws Throwable {
//    	Thread.sleep(2000);
//        glReportsObj.enterRemarkInMaker().click();
//        glReportsObj.enterRemarkInMaker().sendKeys("ok");
//        
//    }

    @Then("^verify System should allow to map to the transaction event more than one Accounting Scheme$")
    public void verify_system_should_allow_to_map_to_the_transaction_event_more_than_one_accounting_scheme() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//span[contains(text(),'"+glModuleData.SchemeName1+"')]")));
        driver.findElement(By.xpath("//span[contains(text(),'"+glModuleData.SchemeName1+"')]")).isDisplayed();
        seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("//span[contains(text(),'"+glModuleData.SchemeName2+"')]")));
        driver.findElement(By.xpath("//span[contains(text(),'"+glModuleData.SchemeName2+"')]")).isDisplayed();
    }

    @And("^search Event name based on which we created$")
    public void search_event_name_based_on_which_we_created() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportsObj.searchEventName());
        glReportsObj.searchEventName().click();
        glReportsObj.searchEventName().sendKeys(glModuleData.EventName);
    }

    @And("^clck the first edit icon in list view$")
    public void clck_the_first_edit_icon_in_list_view() throws Throwable {
        glReportsObj.clickFirstEditIconInListView().click();
    }
    @And("^select the Status for EventMapping$")
    public void select_the_status_for_eventmapping() throws Throwable {
        glReportsObj.selectStatusInEventMapping().click();
        glReportsObj.selectStatusInEventMapping().sendKeys(Keys.DOWN);
        glReportsObj.selectStatusInEventMapping().sendKeys(Keys.ENTER);
    }

    
    
    
    @And("^select accounting book name$")
    public void select_accounting_book_name() throws Throwable {
        glReportsObj.selectAccountingBook().click();
        glReportsObj.selectAccountingBook().sendKeys(glModuleData.AccountingBookname);
        glReportsObj.selectAccountingBook().sendKeys(Keys.ENTER);
    }

    @And("^enter the Accounting Scheme Code$")
    public void enter_the_accounting_scheme_code() throws Throwable {
        glReportsObj.enterAccountingSchemeCode().click();
        glReportsObj.enterAccountingSchemeCode().sendKeys(glModuleData.AccountingSchemeCode);
        glReportsObj.enterAccountingSchemeCode().sendKeys(Keys.ENTER);
    }

    @And("^enter the Accounting Scheme name$")
    public void enter_the_accounting_scheme_name() throws Throwable {
        glReportsObj.enterAccountingSchemeName().click();
        glReportsObj.enterAccountingSchemeName().sendKeys(glModuleData.AccountingSchemeName);
        glReportsObj.enterAccountingSchemeName().sendKeys(Keys.ENTER);
        
    }

    @And("^select expand indicator$")
    public void select_expand_indicator() throws Throwable {
        glReportsObj.selectExpandIndicator().click();
        glReportsObj.selectExpandIndicator().sendKeys(glModuleData.ExpandIndicator);
        glReportsObj.selectExpandIndicator().sendKeys(Keys.ENTER);
    }

    @And("^select Transaction Type$")
    public void select_transaction_type() throws Throwable {
        glReportsObj.selectTransactionType().click();
        glReportsObj.selectTransactionType().sendKeys(glModuleData.TransactionType);
        glReportsObj.selectTransactionType().sendKeys(Keys.ENTER);
        
    }

    @And("^click save buttons$")
    public void click_save_buttons() throws Throwable {
        glReportsObj.saveButton().click();
        
    }
    
    @And("^click add icon in accounting scheme details$")
    public void click_add_icon_in_accounting_scheme_details() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportsObj.addAccountingSchemesDetail());
        glReportsObj.addAccountingSchemesDetail().click();
    }

    @And("^select GL resource$")
    public void select_gl_resource() throws Throwable {
        glReportsObj.selectGlSource().click();
        glReportsObj.selectGlSource().sendKeys(glModuleData.selectGlSource);
        glReportsObj.selectGlSource().sendKeys(Keys.ENTER);
    }

    @And("^select CrDr flag$")
    public void select_crdr_flag() throws Throwable {
        glReportsObj.selectCrDrFlag().click();
        glReportsObj.selectCrDrFlag().sendKeys(glModuleData.DrFlag);
        glReportsObj.selectCrDrFlag().sendKeys(Keys.ENTER);
    }

    @And("^select parameter String$")
    public void select_parameter_string() throws Throwable {
        glReportsObj.selectParameterType().click();
        glReportsObj.selectParameterType().sendKeys(glModuleData.ParameterType);
        glReportsObj.selectParameterType().sendKeys(Keys.ENTER);
        
        
    }

    @And("^select expand indicator in accounting Scheme details$")
    public void select_expand_indicator_in_accounting_scheme_details() throws Throwable {
        glReportsObj.selectExpandIndicatorInSchemeDetail().click();
        glReportsObj.selectExpandIndicatorInSchemeDetail().sendKeys(glModuleData.ExpandIndicator);
        glReportsObj.selectExpandIndicatorInSchemeDetail().sendKeys(Keys.ENTER);
    }
    @And("^select parameter$")
    public void select_parameter() throws Throwable {
    	glReportsObj.selectParameterInAccountingSchemeDetails().click();
        glReportsObj.selectParameterInAccountingSchemeDetails().sendKeys(glModuleData.ParameterInAccountingSchemeDetails);
        glReportsObj.selectParameterInAccountingSchemeDetails().sendKeys(Keys.ENTER);
    }

    @And("^click add icon in table$")
    public void click_add_icon_in_table() throws Throwable {
        glReportsObj.addIconinAccountingSchemeDetails().click();
    }

    @And("^click save button in accounting scheme$")
    public void click_save_button_in_accounting_scheme() throws Throwable {
        glReportsObj.saveButtonInAccountingSchemeDetails().click();
        
    }

    @And("^click edit icon in accounting schemes$")
    public void click_edit_icon_in_accounting_schemes() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(glReportsObj.editIconInAccountingSchemeDetails());
       // seleniumactions.getWaitHelper().waitForElement(driver,2000, glReportsObj.editIconInAccountingSchemeDetails());
    	glReportsObj.editIconInAccountingSchemeDetails().click();
    }

    @And("^select the status in accounting Scheme details$")
    public void select_the_status_in_accounting_scheme_details() throws Throwable {
        glReportsObj.selectStatusInAccountingSchemes().click();
        glReportsObj.selectStatusInAccountingSchemes().sendKeys(Keys.DOWN);
        glReportsObj.selectStatusInAccountingSchemes().sendKeys(Keys.ENTER);
    }

    @And("^select Cr flag$")
    public void select_cr_flag() throws Throwable {
        glReportsObj.selectCrDrFlag().click();
        glReportsObj.selectCrDrFlag().sendKeys(glModuleData.CrFlag);
        glReportsObj.selectCrDrFlag().sendKeys(Keys.ENTER);
    }
    @Then("^verify System should triggered the applied rule for the accounting scheme$")
    public void verify_system_should_triggered_the_applied_rule_for_the_accounting_scheme() throws Throwable {
    	String xpath ="//ul/li/span[contains(text(),'"+glModuleData.AccountingSchemeName+"')]";
        javascriphelper.JavaScriptHelper(driver);
        javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).isDisplayed();
    }
    
    
    
    
}
