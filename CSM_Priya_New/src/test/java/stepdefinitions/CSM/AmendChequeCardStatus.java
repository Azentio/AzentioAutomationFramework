package stepdefinitions.CSM;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.ExcelData;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CSM.AmendChequeCardStatusObject;
import resources.BaseClass;

public class AmendChequeCardStatus extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileRead = new ConfigFileReader();
	AmendChequeCardStatusObject amendCheckObject = new AmendChequeCardStatusObject(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper =new JavascriptHelper();
	String sadsTestDataPath = System.getProperty("user.dir") + "\\TestData\\CSMTestData.xlsx";
	ExcelData excelData = new ExcelData(sadsTestDataPath, "AmendChequeCard", "Data Set ID");
		Map<String, String> testData ;
		DropDownHelper dropDownHelper = new DropDownHelper(driver);
		//ExcelData testExecution = new ExcelData(sadsTestDataPath,"TestExecution","TestCaseID");
		//Map<String, String> testExecutionData;
	

	    @Then("^Click the Amend cheque card status flag$")
	    public void click_the_amend_cheque_card_status_flag() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCardStatus_Flag());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCardStatus_Flag());
	    	amendCheckObject.amendchequeCardStatus_Flag().click();
	    }
	    
	    @And("^Click the maintainance under amend cheque card status$")
	    public void click_the_maintainance_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCardStatus_Maintenance());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCardStatus_Maintenance());
	    	amendCheckObject.amendchequeCardStatus_Maintenance().click();
	    }
	    
	    @Then("^Choose the product type as chequebook in amend cheque card status$")
	    public void choose_the_product_type_as_chequebook_in_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ProductType());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ProductType());
	    	amendCheckObject.amendchequeCard_ProductType().click();
	    	dropDownHelper.SelectUsingVisibleValue(amendCheckObject.amendchequeCard_ProductType(), testData.get("Product Type"));
	    }

	    @And("^Enter the branch code in amend cheque card status$")
	    public void enter_the_branch_code_in_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ACNo_BranchCode());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ACNo_BranchCode());
	    	amendCheckObject.amendchequeCard_ACNo_BranchCode().click();
	    	amendCheckObject.amendchequeCard_ACNo_BranchCode().sendKeys(testData.get("Branch Code"));
	    }
	    
	    @Then("^Enter the currency code under amend cheque card status$")
	    public void enter_the_currency_code_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ACNo_CurrencyCode());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ACNo_CurrencyCode());
	    	amendCheckObject.amendchequeCard_ACNo_CurrencyCode().click();
	    	amendCheckObject.amendchequeCard_ACNo_CurrencyCode().sendKeys(testData.get("Currency Code"));
	    }
	    @And("^Enter the GL code under amend cheque card status$")
	    public void enter_the_gl_code_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ACNo_GLCode());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ACNo_GLCode());
	    	amendCheckObject.amendchequeCard_ACNo_GLCode().click();
	    	amendCheckObject.amendchequeCard_ACNo_GLCode().sendKeys(testData.get("GL Code"));
	    }

	    @Then("^Enter the CIF code under amend cheque card status$")
	    public void enter_the_cif_code_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ACNo_CIFCode());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ACNo_CIFCode());
	    	amendCheckObject.amendchequeCard_ACNo_CIFCode().click();
	    	amendCheckObject.amendchequeCard_ACNo_CIFCode().sendKeys(testData.get("CIF Number"));
	    }
	    @And("^Enter the serial number under amend cheque card status$")
	    public void enter_the_serial_number_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_ACNo_SerialNumber());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_ACNo_SerialNumber());
	    	amendCheckObject.amendchequeCard_ACNo_SerialNumber().click();
	    	amendCheckObject.amendchequeCard_ACNo_SerialNumber().sendKeys(testData.get("Serial Number"));
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendChequeCard_AccNoSearchButton());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendChequeCard_AccNoSearchButton());
	    	amendCheckObject.amendChequeCard_AccNoSearchButton().click();
	    }
	    @Then("^Enter the request number under amend cheque card status$")
	    public void enter_the_request_number_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendchequeCard_RequestNumber());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendchequeCard_RequestNumber());
	    	amendCheckObject.amendchequeCard_RequestNumber().click();
	    	amendCheckObject.amendchequeCard_RequestNumber().sendKeys(testData.get("Request Number"));
	    }
	    @And("^Change the status as cancelled under amend cheque card status$")
	    public void change_the_status_as_cancelled_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendChequeCard_StatusSelectButton());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendChequeCard_StatusSelectButton());
	    	amendCheckObject.amendChequeCard_StatusSelectButton().click();
	    	dropDownHelper.SelectUsingVisibleValue(amendCheckObject.amendChequeCard_StatusSelectButton(), testData.get("Status"));
	    }

	    @Then("^Click the retrive button under the amend cheque card status$")
	    public void click_the_retrive_button_under_the_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendChequeCard_RetrieveButton());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendChequeCard_RetrieveButton());
	    	amendCheckObject.amendChequeCard_RetrieveButton().click();
	    }

	    @And("^Click the equivalent code check box under amend cheque card status$")
	    public void click_the_equivalent_code_check_box_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendChequeCard_FirstRecordCheckBox());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendChequeCard_FirstRecordCheckBox());
	    	amendCheckObject.amendChequeCard_FirstRecordCheckBox().click();
	    }
	    @Then("^Click the update button and update the record under amend cheque card status$")
	    public void click_the_update_button_and_update_the_record_under_amend_cheque_card_status() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, amendCheckObject.amendChequeCard_FirstRecordCheckBox());
	    	clickAndActionHelper.moveToElement(amendCheckObject.amendChequeCard_FirstRecordCheckBox());
	    	amendCheckObject.amendChequeCard_FirstRecordCheckBox().click();
	    }

	    


	   

	    

	   

}
