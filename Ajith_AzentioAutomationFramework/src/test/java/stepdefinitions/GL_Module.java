package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.Gl_Reports_Obj;
import resources.BaseClass;
import testDataType.GlModuleDataType;

public class GL_Module {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	Gl_Reports_Obj glReportObj = new Gl_Reports_Obj(driver);
	JsonConfig jsonconfig = new JsonConfig();
	GlModuleDataType glModuleDataType = jsonconfig.getGlModulelist("maker");
	Map<String, String> testdata = new LinkedHashMap<>();
	JavascriptHelper javascriphelper = new JavascriptHelper();
	@Given("^Login as a Azentio Maker$")
    public void login_as_a_azentio_maker() throws Throwable {
        login = new AzentioLogin(driver);
        driver.get(configreader.getApplicationUrl());
        login.loginToAzentioApp("Maker");
        Thread.sleep(1000); 
	}

    @And("^click the Direction icon$")
    public void click_the_direction_icon() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.directionIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.directionIcon());
        
    }

    @And("^click the Account Payable Main Module$")
    public void click_the_account_payable_main_module() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.accountPayable());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.accountPayable());
        
    }

    @And("^click the Manual Payout Eye icon$")
    public void click_the_manual_payout_eye_icon() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(glReportObj.manualPayoutEyeIcon());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutEyeIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutEyeIcon());
    }

    @And("^click the Add icon in Manual Payout$")
    public void click_the_add_icon_in_manual_payout() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutAddIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutAddIcon());
    }

    @And("^Select the entity branch$")
    public void select_the_entity_branch() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectEntityBranch());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectEntityBranch());
        glReportObj.manualPayoutSelectEntityBranch().sendKeys(glModuleDataType.branchCode);
        glReportObj.manualPayoutSelectEntityBranch().sendKeys(Keys.ENTER);
    }

    @And("^Select the Buisness Partner Name$")
    public void select_the_buisness_partner_name() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectBp());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectBp());
        glReportObj.manualPayoutSelectBp().sendKeys(Keys.ENTER);
       
    }

    @And("^Select the beneficiary name$")
    public void select_the_beneficiary_name() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectBeneficiaryName);
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectBeneficiaryName);
        glReportObj.manualPayoutSelectBeneficiaryName.sendKeys(Keys.ENTER);
    }
    @And("^Select the currency type$")
    public void select_the_currency_type() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectCurrency());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectCurrency());
        glReportObj.manualPayoutSelectCurrency().sendKeys(glModuleDataType.CurrencyType);
        glReportObj.manualPayoutSelectCurrency().sendKeys(Keys.ENTER);
    }


    @And("^click the calender and select the valid date$")
    public void click_the_calender_and_select_the_valid_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,glReportObj.manualPayoutCalender());
		seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutCalender());
		Thread.sleep(2000);
		javascriphelper.JavaScriptHelper(driver);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + glModuleDataType.GlYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + glModuleDataType.GlMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + glModuleDataType.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" +glModuleDataType.GlDay + "'])[1]")).click();
    }

    @And("^Select bank in manual payout$")
    public void select_bank_in_manual_payout() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectBank());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectBank());
        glReportObj.manualPayoutSelectBank().sendKeys(glModuleDataType.PaymentBank);
        glReportObj.manualPayoutSelectBank().sendKeys(Keys.ENTER);
    }
    

    @And("^Select the bank Account Number$")
    public void select_the_bank_account_number() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.manualPayoutSelectBankAccountNumber());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutSelectBankAccountNumber());
        glReportObj.manualPayoutSelectBankAccountNumber().sendKeys("123");
        glReportObj.manualPayoutSelectBankAccountNumber().sendKeys(Keys.ENTER);
    }

    @And("^get the Available  balance and store$")
    public void get_the_available_balance_and_store() throws Throwable {
        String AvailableBalance = (String) javascriphelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[1].value");
        testdata.put("AvailableBalance", AvailableBalance);
    }

    @And("^click the notes option$")
    public void click_the_notes_option() throws Throwable {
    	javascriphelper.JavaScriptHelper(driver);
    	javascriphelper.scrollIntoView(glReportObj.ReportIcon());
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.ReportIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.ReportIcon());
    }

    @And("^click the financial Report$")
    public void click_the_financial_report() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.financialReporting());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.financialReporting());
    }

    @And("^click the Gl balance report edit icon$")
    public void click_the_gl_balance_report_edit_icon() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.FinancialTransactionIcon());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.FinancialTransactionIcon());
    }

    @And("^select the branch$")
    public void select_the_branch() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.glBalanceReportSelectBranch());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.glBalanceReportSelectBranch());
        glReportObj.glBalanceReportSelectBranch().sendKeys(glModuleDataType.branchCode);
        glReportObj.glBalanceReportSelectBranch().sendKeys(Keys.ENTER); 
    }

    @And("^select the Gl code$")
    public void select_the_gl_code() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.glBalanceReportSelectGlcode());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.glBalanceReportSelectGlcode());
        glReportObj.manualPayoutSelectBank().sendKeys(glModuleDataType.gLCode);
        glReportObj.glBalanceReportSelectGlcode().sendKeys(Keys.ENTER);
    }

    @And("^Select the Gl from date$")
    public void select_the_gl_from_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,glReportObj.manualPayoutCalender());
		seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutCalender());
		Thread.sleep(1000);
		javascriphelper.JavaScriptHelper(driver);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + glModuleDataType.GlYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + glModuleDataType.GlMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + glModuleDataType.GlDay + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" +glModuleDataType.GlDay + "'])[1]")).click();
    }

    @And("^Select the Gl To date$")
    public void select_the_gl_to_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,glReportObj.manualPayoutCalender());
		seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.manualPayoutCalender());
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + glModuleDataType.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" +glModuleDataType.GlToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				driver.findElement(By.xpath("(//span[text()='" + glModuleDataType.GlToDate + "'])[1]")));
		driver.findElement(By.xpath("(//span[text()='" + glModuleDataType.GlToDate + "'])[1]")).click();

    }
    @And("^select the currency type in gl balance report$")
    public void select_the_currency_type_in_gl_balance_report() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.glBalanceReportCurrency());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.glBalanceReportCurrency());
    }

    @And("^click the View button$")
    public void click_the_view_button() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,glReportObj.glViewButton());
        seleniumactions.getClickAndActionsHelper().clickOnElement(glReportObj.glViewButton());
    }

    @And("^get the closing net balance from the report$")
    public void get_the_closing_net_balance_from_the_report() throws Throwable {
        
    }
    @Then("^verify that available balance should equal to closing net balance$")
    public void verify_that_available_balance_should_equal_to_closing_net_balance() throws Throwable {
        
    }

}
