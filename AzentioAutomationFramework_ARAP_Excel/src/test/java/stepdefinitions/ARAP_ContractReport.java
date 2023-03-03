package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.Account_Receivable;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.InvoiceBookingObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;


public class ARAP_ContractReport {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper  browserHelper =  new BrowserHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver) ;
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	
	
	
	
	@And("^user click Vendor Contracts eye icon for contract report verification$")
    public void user_click_vendor_contracts_eye_icon_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApeyeicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApeyeicon());
    }
	
	@And("^click the first eye icon in the list for contract report verification$")
    public void click_the_first_eye_icon_in_the_list_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getClickFirstEyeiconInListView());
		seleniumactions.getClickAndActionsHelper()
				.clickOnElement(cancellationofcontract.getClickFirstEyeiconInListView());
    }

    @And("^get buisness partner name,get contract end date and get contract acccount code,get contract status$")
    public void get_buisness_partner_nameget_contract_end_date_and_get_contract_acccount_codeget_contract_status() throws Throwable {
    	Thread.sleep(2000);
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000,
				cancellationofcontract.getBuisnessPartnerNameinContract());
    	
		String buisnessPartnerName = cancellationofcontract.getBuisnessPartnerNameinContract()
				.getText();
		testdata.put("buisnessPartnerName", buisnessPartnerName);
		javascriphelper.JavaScriptHelper(driver);
		String contractacccountcode = (String) javascriphelper.executeScript(
				"return document.getElementsByName('contractCode')[1].value");
		System.out.println(contractacccountcode);
		testdata.put("contractacccountcode", contractacccountcode);
		String contractenddate = (String) javascriphelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
		System.out.println(contractenddate);
		String year = contractenddate.substring(7,11);
		testdata.put("year", year);
		String month = contractenddate.substring(3, 6);
		testdata.put("month", month);
		switch (month) {
		case "Dec":
			testdata.put("fullmonth","December");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jan":
			testdata.put("fullmonth","January");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Feb":
			testdata.put("fullmonth","Febuary");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Mar":
			testdata.put("fullmonth","March");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Apr":
			testdata.put("fullmonth","April");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "May":
			testdata.put("fullmonth","May");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jun":
			testdata.put("fullmonth","June");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Jul":
			testdata.put("fullmonth","July");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Aug":
			testdata.put("fullmonth","August");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Sep":
			testdata.put("fullmonth","September");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Oct":
			testdata.put("fullmonth","October");
			System.out.println(testdata.get("fullmonth"));
			break;
		case "Nov":
			testdata.put("fullmonth","November");
			System.out.println(testdata.get("fullmonth"));
			break;
		}
		if (Integer.parseInt(contractenddate.substring(0, 2))>9) {
			String day = contractenddate.substring(0,2);
			testdata.put("day", day);
		}
		else  {
			String day = contractenddate.substring(1, 2);
			testdata.put("day", day);
		}
		String contractStatus = driver.findElement(By.xpath("(//ion-col[15]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div)[2]")).getText();
		testdata.put("contractstatus", contractStatus);
    }
    
    @And("^click the notes option for contract report verification$")
    public void click_the_notes_option_for_contract_report_verification() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 2000, enquiryObj.inventoryReportIcon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.inventoryReportIcon());
    }
    
    @And("^click the Reports Sub Module$")
    public void click_the_reports_sub_module() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.reportMenu());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.reportMenu());
    }
    @And("^click the contract report edit icon$")
    public void click_the_contract_report_edit_icon() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.contractReportEditIcon());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.contractReportEditIcon());
    }
    
    @And("^select the vendor name according to contract$")
    public void select_the_vendor_name_according_to_contract() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectVendorName());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
       enquiryObj.selectVendorName().sendKeys(testdata.get("buisnessPartnerName"));
       enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
    }
    @And("^select the contract status based on we get from list$")
    public void select_the_contract_status_based_on_we_get_from_list() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectContractStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
        enquiryObj.selectContractStatus().sendKeys(testdata.get("contractstatus"));
        enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
    }
    
    @And("^select the date based on contract end date$")
    public void select_the_date_based_on_contract_end_date() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.calenderInContractReport());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.calenderInContractReport());
       Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + testdata.get("year")  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + testdata.get("month") + "']")).click();
		seleniumactions.getWaitHelper().waitForElement(driver, 2000,
 				driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("fullmonth")+" "
 						+testdata.get("day")+", "+testdata.get("year")+"']")));
 		driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("fullmonth")+" "
					+testdata.get("day")+", "+testdata.get("year")+"']")).click();
    }
    
    @And("^click the view icon$")
    public void click_the_view_icon() throws Throwable {
       seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.viewInContractReport());
       seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.viewInContractReport());
       Thread.sleep(2000);
    }
    @Then("^verify the contract code in contract report$")
    public void verify_the_contract_code_in_contract_report() throws Throwable {
    	//Set<String> windowHandles = seleniumactions.getBrowserHelper().getWindowHandles();
			seleniumactions.getBrowserHelper().SwitchToWindow(1);
		
			/*s*/
    	seleniumactions.getBrowserHelper().switchToParentWithChildClose();
       
    }

	
	

}
