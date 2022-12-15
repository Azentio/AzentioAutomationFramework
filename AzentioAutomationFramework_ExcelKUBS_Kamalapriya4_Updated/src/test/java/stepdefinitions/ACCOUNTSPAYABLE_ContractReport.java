package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_ContractReportPageObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class ACCOUNTSPAYABLE_ContractReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_ContractReportPageObj contractReportObj = new ACCOUNTSPAYABLE_ContractReportPageObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper=new BrowserHelper(driver);
	JsonConfig jsonConfig=new JsonConfig();
	ACCOUNTSPAYABLE_ContractReportTestData contractReportTestData=jsonConfig.getAccountsPayableContractReportTestDataByName("Maker");
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj=new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	Map<String,String> vendorContractData=new HashMap<>();
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	@And("^select the active contract number and business partner name from the approved grid view$")
    public void select_the_active_contract_number_and_business_partner_name_from_the_approved_grid_view() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractSearchContractStatus(), 2000, 100);
		vendorContractObj.vendorContractSearchContractStatus().click();
		vendorContractObj.vendorContractSearchContractStatus().sendKeys(contractReportTestData.VendorContractStatus);
		String contractNumber=vendorContractObj.vendorContractApprovedContractNumber().getText();
		vendorContractData.put("ContractNumber", contractNumber);
		String bpName=vendorContractObj.vendorContractApprovedBpName().getText();
		vendorContractData.put("bpName", bpName);
		System.out.println("Contract number is"+vendorContractData.get("ContractNumber")+" Bp name"+vendorContractData.get("bpName"));
		//vendorContractObj
    }
	/*@And("^click on report main menu$")
	public void click_on_report_main_menu() throws Throwable {
		waitHelper.waitForElementVisible(contractReportObj.reportReortMainMenu(), 2000, 200);
		contractReportObj.reportReortMainMenu().click();
	}*/
	@And("^click on view button for open the record$")
    public void clcik_on_view_button_for_open_the_record() throws Throwable {
		vendorContractObj.vendorContractApprovedViewButton().click();
		
    }

	@And("^click the temp near by contract report$")
	public void click_the_temp_near_by_contract_report() throws Throwable {
		waitHelper.waitForElementVisible(contractReportObj.contractReportTempView(), 2000, 100);
		contractReportObj.contractReportTempView().click();
	}
	@And("^get the contract amount$")
    public void get_the_contract_amount() throws Throwable {
		
	//Thread.sleep(1000);
	//String contractAmmount=driver.findElement(By.xpath("//input[@class='form__field ng-pristine ng-valid ng-touched']")).getText();
	javascriptHelper.JavaScriptHelper(driver);
	String contractAmmount=javascriptHelper.executeScript("return document.getElementById('totalValue').value").toString();
    String[] splitContractAmount=contractAmmount.split("[.]");
    String finalContractnum=splitContractAmount[0].replace(",", "");
    
	System.out.println("ContractAmmount : "+finalContractnum);
    
    vendorContractData.put("ContractAmmount", finalContractnum);
	}

    @And("^click on the item details$")
    public void click_on_the_item_details() throws Throwable {
      
    }

	@And("^enter bp Name$")
	public void enter_bp_name() throws Throwable {
		waitHelper.waitForElementVisible(contractReportObj.contraxctReportBpName(), 2000, 100);
		contractReportObj.contraxctReportBpName().click();
		contractReportObj.contraxctReportBpName().sendKeys(vendorContractData.get("bpName"));
		contractReportObj.contraxctReportBpName().sendKeys(Keys.ENTER);

	}

	@And("^click on calender$")
	public void click_on_calender() throws Throwable {
		contractReportObj.contractReportCalendar().click();
	}

	@And("^give date for the calendar$")
	public void give_date_for_the_calendar() throws Throwable {
		/*String month="Oct";
		String year="2022";
		String fullMonth="October";
		String day="22";*/
		while (true) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+contractReportTestData.Month+" "+contractReportTestData.Year+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+contractReportTestData.Month+" "+contractReportTestData.Year+"')]"));
			    break;
			} catch (NoSuchElementException e) {
				contractReportObj.contractReportNextMonthButton().click();
			}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+contractReportTestData.FullMonth+" "+contractReportTestData.Day+", "+contractReportTestData.Year+"']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^enter contract status$")
	public void enter_contract_status() throws Throwable {
		contractReportObj.contractReportContractStatus().click();
		contractReportObj.contractReportContractStatus().sendKeys(contractReportTestData.VendorContractStatus);
		contractReportObj.contractReportContractStatus().sendKeys(Keys.ENTER);
	}

	/*@And("^click on the view button$")
	public void click_on_the_view_button() throws Throwable {
	contractReportObj.contractReportViewButton().click();
	}*/
	@Then("^verify the contract reference number is available in the report content$")
    public void verify_the_contract_reference_number_is_available_in_the_report_content() throws Throwable {
		browserHelper.SwitchToWindow(1);
		//Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		
     while(true)
     {Thread.sleep(1000);
    	 try
    	 {
    		//div[contains(text(),'Agency-8-52-28022022')]
    		 javascriptHelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'"+vendorContractData.get("ContractNumber")+"')]")));
    		 driver.findElement(By.xpath("//div[contains(text(),'"+vendorContractData.get("ContractNumber")+"')]")).isDisplayed();
    		//div[contains(text(),'Agency-8-131-08032022')]//ancestor::tr/td[7]//div
    		String reportAmount= driver.findElement(By.xpath("//div[contains(text(),'"+vendorContractData.get("ContractNumber")+"')]//ancestor::tr/td[7]//div")).getText();
    		String[] splitAmount=reportAmount.split("[.]");
    		String finalReportConAmt=splitAmount[0].replace(",", "");
    		String finalReportContractAmountString=finalReportConAmt.replace("\\s", "");
    		System.out.println("Contract amount in report"+finalReportContractAmountString);
    		System.out.println("Contract amount is vendor contract"+vendorContractData.get("ContractAmmount"));
    		if(vendorContractData.get("ContractAmmount").equalsIgnoreCase(finalReportContractAmountString));
    		{
    			System.out.println("Condition matched");
    		}
    		
    		break;
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 contractReportObj.contractReportNextButton().click();
    	 }
    	 catch(StaleElementReferenceException e2)
    	 {
    		 
    	 }
     }
     browserHelper.switchToParentWithChildClose();
    }
	
}
