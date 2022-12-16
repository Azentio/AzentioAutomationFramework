package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.Reports_AssetCreationCommonObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.Reports_AssetCreationCommonTestDataType;

public class Reports_AssetCreationCommon {
	
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	Reports_AssetCreationCommonObj reports_AssetCreationCommonObj = new Reports_AssetCreationCommonObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	Reports_AssetCreationCommonTestDataType AssetCreationCommonTestDataType=jsonReader.getAssetCreationCommondata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	Map<String, String> asetTransferTestData = new HashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetTransfer = new ExcelData(path, "FixedAsset_AssetTransfer", "DataSet ID");
	Map<String, String> assetAmmendmentTestData = new HashMap<>();
	ExcelData excelDataForAssetAmmendment = new ExcelData(path, "FixedAsset_AssetAmmendment", "DataSet ID");
	Map<String, String> codeConfigData = new HashMap<>();
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "FixedAsset_AssetCodeConfig", "DataSet ID");
	Map<String, String> assetCodeConfigTestData = new HashMap<>();
	ExcelData excelAssetDepreciationTestData = new ExcelData(excelPath, "DepreciationReport", "DataSet ID");
	Map<String, String> assetDepreciationTestData = new HashMap<>();
	@And("^user should navigate to reports menu$")
	public void user_should_navigate_to_reports_menu()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon().click();
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportsMenu().click();
	}
	
	@Then("^click on temp grid button of asset creation common$")
	public void click_on_temp_grid_button_of_asset_creation_common()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationCommonTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationCommonTempView().click();
	}
	
	@Then("^click on temp grid button of asset creation item$")
	public void click_on_temp_grid_button_of_asset_creation_item()  {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView());
		//waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetCreationItemTempView().click();
	}

	@And("^select the asset life unit and date to check the asset codes are displaying$")
	public void select_the_asset_life_unit_and_date_to_check_the_asset_codes_are_displaying() throws InterruptedException  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetLifeUnit());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetLifeUnit().sendKeys(AssetCreationCommonTestDataType.AssetLifeUnit);
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetLifeUnit().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
		Thread.sleep(1000);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.ToFullMonth+" "+AssetCreationCommonTestDataType.ToDate+", "+AssetCreationCommonTestDataType.ToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
		
	}
	
	@Then("^click in the view button to check$")
    public void click_in_the_view_button_to_check()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton().click();
    }
	
//-------	Check Asset Category
	@And("^select the asset life unit and date to check the asset limit are displaying$")
	public void select_the_asset_life_unit_date_to_check_the_asset_limit_are_displaying() {
		
	}
	
	@And("^select the asset life unit and date to check the asset category are displaying$")
	public void select_the_asset_life_unit_date_to_check_the_asset_category_are_displaying() throws InterruptedException {
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationItem_AssetCapitalizationDate());
		reports_AssetCreationCommonObj.Report_AssetCreationItem_AssetCapitalizationDate().click();
		Thread.sleep(1000);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.ToFullMonth+" "+AssetCreationCommonTestDataType.ToDate+", "+AssetCreationCommonTestDataType.ToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationItem_AssetCreationAsOnDate());
		reports_AssetCreationCommonObj.Report_AssetCreationItem_AssetCreationAsOnDate().click();
		Thread.sleep(1000);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.ToMonth+" "+AssetCreationCommonTestDataType.ToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();
		}
		}
		WebElement FinalDay3=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.ToFullMonth+" "+AssetCreationCommonTestDataType.ToDate+", "+AssetCreationCommonTestDataType.ToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay3);
		
		
	}
	
//----------	Check depreciation
	@Then("^click on temp grid button of depreciation$")
	public void click_on_temp_grid_button_of_depreciation()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_DepreciationTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_DepreciationTempView().click();
	}
	@And("^Choose the data set id for depreciation report$")
    public void choose_the_data_set_id_for_depreciation_report() throws Throwable {
		assetDepreciationTestData = excelData.getTestdata("KUBS_FAT_UAT_013_004_D1");
	
    }

    @And("^Get the system date for the depreciation report$")
    public void get_the_system_date_for_the_depreciation_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,reports_AssetCreationCommonObj.systemDate(), 30, 2);
        String systemdate = reports_AssetCreationCommonObj.systemDate().getText();
    System.out.println(systemdate);
    String[] split = systemdate.split("-");
    String date = split[0];
    testdata.put("Date", date);
    //  System.out.println(date);
    String month = split[1];
    testdata.put("ToMonth", month);
    //  System.out.println(month);
    String year = split[2];
    testdata.put("Year", year);
    //  System.out.println(year);
    String fullMonth;
    switch (month) {
    case "Jan":
    fullMonth = "January";
    break;
    case "Feb":
    fullMonth = "February";
    break;
    case "Mar":
    fullMonth = "March";
    break;
    case "Apr":
    fullMonth = "April";
    break;
    case "May":
    fullMonth = "May";
    break;
    case "Jun":
    fullMonth ="June";
    break;
    case "Jul":
    fullMonth = "July";
    break;
    case "Aug":
    fullMonth ="August";
    break;
    case "Sep":
    fullMonth = "September";
    break;
    case "Oct":
    fullMonth = "October";
    break;
    case "Nov":
    fullMonth = "November";
    break;
    case "Dec":
    fullMonth = "December";
    break;
    default:
     fullMonth = "InvalidMonth";
    break;
    }
    testdata.put("FullMonth", fullMonth);
    }


	@And("^select required fields to check the depreciation details are displaying$")
	public void select_required_fields_to_check_the_depreciation_details_are_displaying() throws InterruptedException  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_Depreciation_Branch());
		reports_AssetCreationCommonObj.Report_Depreciation_Branch().sendKeys(assetDepreciationTestData.get("DepreciationBranch"));
		reports_AssetCreationCommonObj.Report_Depreciation_Branch().sendKeys(Keys.ENTER);
		
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
		
//		Thread.sleep(2000);
//		while(true)
//		{
//			try 
//			{
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"')]")));
//				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"')]"));
////				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
//				break;
//			}catch(NoSuchElementException nosuchElement)
//			{
//				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
//				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
//				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
////				String tablehead="2016 ~ 2036";
//				String headyear=tablehead.replaceAll(" ~", "");
////				System.out.println(headyear);
//				String ar[] = headyear.split(" ");
//				int y1=Integer.parseInt(ar[0]);
//				int y2=Integer.parseInt(ar[1]);
//				int year=Integer.parseInt(AssetCreationCommonTestDataType.DepreciationYear);
//				if(year < y1 && year<y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement1) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]"));
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")).click();
//					
//				}
//				else if(year>y1 && year>y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement2) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.DepreciationYear+"')]"));
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")).click();
//					
//				}
//				else
//				{
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationYear+"']")));
//					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationYear+"']"));
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth+" "+AssetCreationCommonTestDataType.DepreciationYear+"']")).click();
//					
//				}
//			}
//		}
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth +" "+AssetCreationCommonTestDataType.DepreciationDate+", "+AssetCreationCommonTestDataType.DepreciationYear+"']/span")));	
//		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.DepreciationFullMonth +" "+AssetCreationCommonTestDataType.DepreciationDate+", "+AssetCreationCommonTestDataType.DepreciationYear+"']/span"));
//		clicksAndActionHelper.doubleClick(BirthDate);
//		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_Depreciation_DepreciationPeriod());
		reports_AssetCreationCommonObj.Report_Depreciation_DepreciationPeriod().sendKeys(assetDepreciationTestData.get("DepreciationYear"));
		reports_AssetCreationCommonObj.Report_Depreciation_DepreciationPeriod().sendKeys(Keys.DOWN,Keys.ENTER);
	}
	
	@Then("^the report is displaying all the asset depreciation details for a branch$")
    public void the_report_is_displaying_all_the_asset_depreciation_details_for_a_branch() throws InterruptedException  {
		Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_Depreciation_DepreciationReport());
		reports_AssetCreationCommonObj.Report_Depreciation_DepreciationReport().isDisplayed();
		browserHelper.switchToParentWithChildClose();
		
    }
//-------------------	asset contract
	@Then("^click on temp grid button of asset contract$")
    public void click_on_temp_grid_button_of_asset_contract() {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetContractTempView());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetContractTempView().click();
    }
	 @Then("^Get the data set id for the report of asset contract$")
	    public void get_the_data_set_id_for_the_report_of_asset_contract() throws Throwable {
			asetTransferTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_013_009_D1");

	    }
	
	@And("^select the contract ref number and date to check asset contract details are displaying$")
	public void select_the_contract_ref_number_and_date_to_check_asset_contract_details_are_displaying() throws InterruptedException {
		asetTransferTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_013_009_D1");
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetContract_ContractReferenceNumber());
		reports_AssetCreationCommonObj.Report_AssetContract_ContractReferenceNumber().sendKeys(asetTransferTestData.get("AssetReferenceNumber"));
		reports_AssetCreationCommonObj.Report_AssetContract_ContractReferenceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
		javascripthelper.JavaScriptHelper(driver);
 		while(true)
         {
 		try
 		{
 		
 			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
 			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
 		    break;
 		}
 		
 		catch(NoSuchElementException nosuchElement)
 		{
 			reports_AssetCreationCommonObj.fixedAsset_NextMonth().click();
 		}
 		}
 		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
 		clicksAndActionHelper.doubleClick(FinalDay);	
    
//		Thread.sleep(2000);
//		while(true)
//		{
//			try 
//			{
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"')]")));
//				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"')]"));
////				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
//				break;
//			}catch(NoSuchElementException nosuchElement)
//			{
//				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
//				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
//				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
////				String tablehead="2016 ~ 2036";
//				String headyear=tablehead.replaceAll(" ~", "");
////				System.out.println(headyear);
//				String ar[] = headyear.split(" ");
//				int y1=Integer.parseInt(ar[0]);
//				int y2=Integer.parseInt(ar[1]);
//				int year=Integer.parseInt(AssetCreationCommonTestDataType.AssetContractYear);
//				if(year < y1 && year<y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement1) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]"));
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")).click();
//					
//				}
//				else if(year>y1 && year>y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement2) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetContractYear+"')]"));
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")).click();
//					
//				}
//				else
//				{
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractYear+"']")));
//					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractYear+"']"));
////					clicksAndActionHelper.doubleClick(Year);
//					Year.click();
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth+" "+AssetCreationCommonTestDataType.AssetContractYear+"']")).click();
//					
//				}
//			}
//		}
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth +" "+AssetCreationCommonTestDataType.AssetContractDate+", "+AssetCreationCommonTestDataType.AssetContractYear+"']/span")));	
//		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetContractFullMonth +" "+AssetCreationCommonTestDataType.AssetContractDate+", "+AssetCreationCommonTestDataType.AssetContractYear+"']/span"));
//		clicksAndActionHelper.doubleClick(BirthDate);
//		
	}

    @Then("^the report is displaying all the asset contract details for a branch$")
    public void the_report_is_displaying_all_the_asset_contract_details_for_a_branch() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetContract_AssetContractReport());
		reports_AssetCreationCommonObj.Report_AssetContract_AssetContractReport().isDisplayed();
		driver.close();
		browserHelper.SwitchToWindow(0);
    }
    
//-----------    Asset Transfer

    @And("^choose the data set id for asset undertaking report$")
    public void choose_the_data_set_id_for_asset_undertaking_report() throws Throwable {
		asetTransferTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_013_012_D1");

    }
    @Then("^click on temp grid button of asset transfer$")
    public void click_on_temp_grid_button_of_asset_transfer(){
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetTransferTempView());
    	reports_AssetCreationCommonObj.Report_AssetCreationCommon_AssetTransferTempView().click();
    }
    @And("^Get the system date for asset undertaking$")
    public void get_the_system_date_for_asset_undertaking() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,reports_AssetCreationCommonObj.systemDate(), 30, 2);
        String systemdate = reports_AssetCreationCommonObj.systemDate().getText();
    System.out.println(systemdate);
    String[] split = systemdate.split("-");
    String date = split[0];
    testdata.put("Date", date);
    //  System.out.println(date);
    String month = split[1];
    testdata.put("ToMonth", month);
    //  System.out.println(month);
    String year = split[2];
    testdata.put("Year", year);
    //  System.out.println(year);
    String fullMonth;
    switch (month) {
    case "Jan":
    fullMonth = "January";
    break;
    case "Feb":
    fullMonth = "February";
    break;
    case "Mar":
    fullMonth = "March";
    break;
    case "Apr":
    fullMonth = "April";
    break;
    case "May":
    fullMonth = "May";
    break;
    case "Jun":
    fullMonth ="June";
    break;
    case "Jul":
    fullMonth = "July";
    break;
    case "Aug":
    fullMonth ="August";
    break;
    case "Sep":
    fullMonth = "September";
    break;
    case "Oct":
    fullMonth = "October";
    break;
    case "Nov":
    fullMonth = "November";
    break;
    case "Dec":
    fullMonth = "December";
    break;
    default:
     fullMonth = "InvalidMonth";
    break;
    }
    testdata.put("FullMonth", fullMonth);

    }
    

    @Then("^choose the data set id for asset transfer report$")
    public void choose_the_data_set_id_for_asset_transfer_report() throws Throwable {
		asetTransferTestData = excelDataForAssetTransfer.getTestdata("KUBS_FAT_UAT_013_011_D1");

    }

    @And("^select the asset code and date to check the asset transfer details are displaying$")
    public void select_the_asset_code_and_date_to_check_the_asset_transfer_details_are_displaying() throws InterruptedException  {
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode());
    	reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode().sendKeys(asetTransferTestData.get("AssetReferenceNumber"));
    	reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());
    	reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
    	
//    	Thread.sleep(2000);
//		while(true)
//		{
//			try 
//			{
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"')]")));
//				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"')]"));
////				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
//				break;
//			}catch(NoSuchElementException nosuchElement)
//			{
//				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
//				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
//				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
////				String tablehead="2016 ~ 2036";
//				String headyear=tablehead.replaceAll(" ~", "");
////				System.out.println(headyear);
//				String ar[] = headyear.split(" ");
//				int y1=Integer.parseInt(ar[0]);
//				int y2=Integer.parseInt(ar[1]);
//				int year=Integer.parseInt(AssetCreationCommonTestDataType.DepreciationYear);
//				if(year < y1 && year<y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement1) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")).click();
//					
//				}
//				else if(year>y1 && year>y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement2) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetTransferYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")).click();
//					
//				}
//				else
//				{
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferYear+"']")));
//					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferYear+"']"));
////					clicksAndActionHelper.doubleClick(Year);
//					Year.click();
//					Thread.sleep(1000);
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth+" "+AssetCreationCommonTestDataType.AssetTransferYear+"']")).click();
//					
//				}
//			}
//		}
//		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth +" "+AssetCreationCommonTestDataType.AssetTransferDate+", "+AssetCreationCommonTestDataType.AssetTransferYear+"']/span")));	
//		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetTransferFullMonth +" "+AssetCreationCommonTestDataType.AssetTransferDate+", "+AssetCreationCommonTestDataType.AssetTransferYear+"']/span"));
//		clicksAndActionHelper.doubleClick(BirthDate);
//    		javascripthelper.JavaScriptHelper(driver);
 		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			reports_AssetCreationCommonObj.fixedAsset_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
//    	
    }

    @Then("^the report is displaying all the asset transfer details for a branch$")
    public void the_report_is_displaying_all_the_asset_transfer_details_for_a_branch() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport());
		boolean reports = reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport().isDisplayed();
		System.out.println("The report is displaying all the asset transfer details for a branch - " + reports);
		browserHelper.switchToParentWithChildClose();
		//---report fetching code---//
    }
    
//-------------------    Asset Undertaking
    @And("^select the asset code and date to check the asset undertaking details are displaying$")
    public void select_the_asset_code_and_date_to_check_the_asset_undertaking_details_are_displaying() throws InterruptedException  {
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode());
    	reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode().sendKeys(asetTransferTestData.get("AssetReferenceNumber"));
    	reports_AssetCreationCommonObj.Report_AssetTransfer_AssetCode().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());
    	reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
    	
//    	Thread.sleep(2000);
//		while(true)
//		{
//			try 
//			{
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]")));
//				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]"));
////				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
//				break;
//			}catch(NoSuchElementException nosuchElement)
//			{
//				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
//				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
//				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
////				String tablehead="2016 ~ 2036";
//				String headyear=tablehead.replaceAll(" ~", "");
////				System.out.println(headyear);
//				String ar[] = headyear.split(" ");
//				int y1=Integer.parseInt(ar[0]);
//				int y2=Integer.parseInt(ar[1]);
//				int year=Integer.parseInt(AssetCreationCommonTestDataType.AssetUndertakingYear);
//				if(year < y1 && year<y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement1) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")).click();
//					
//				}
//				else if(year>y1 && year>y2)
//				{
//					while(true)
//					{
//						try {
//							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]")));
//							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]"));
//						    break;
//						}
//						catch(NoSuchElementException nosuchElement2) {
//							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
//							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
//						}
//					}
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]")));
//					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AssetUndertakingYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
//					
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")).click();
//					
//				}
//				else
//				{
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")));
//					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingYear+"']"));
////					clicksAndActionHelper.doubleClick(Year);
//					Year.click();
//					Thread.sleep(1000);
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")));
//					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth+" "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']")).click();
//					
//				}
//			}
	//	}
	//	waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth +" "+AssetCreationCommonTestDataType.AssetUndertakingDate+", "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']/span")));	
	//	WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AssetUndertakingFullMonth +" "+AssetCreationCommonTestDataType.AssetUndertakingDate+", "+AssetCreationCommonTestDataType.AssetUndertakingYear+"']/span"));
	//	clicksAndActionHelper.doubleClick(BirthDate);
    	javascripthelper.JavaScriptHelper(driver);
 		while(true)
         {
 		try
 		{
 		
 			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
 			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
 		    break;
 		}
 		
 		catch(NoSuchElementException nosuchElement)
 		{
 			reports_AssetCreationCommonObj.fixedAsset_NextMonth().click();
 		}
 		}
 		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
 		clicksAndActionHelper.doubleClick(FinalDay);	
    }
    
    
    @Then("^the report is displaying all the asset undertaking details for a branch$")
    public void the_report_is_displaying_all_the_asset_undertaking_details_for_a_branch() throws InterruptedException {
    	Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport());
		boolean reports = reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport().isDisplayed();
		System.out.println("The report is displaying all the asset undertaking details for a branch - " + reports);
		browserHelper.switchToParentWithChildClose();
		//---report fetching code---//
    }
    
    
//----------------    Account payable report
    @Then("^click on temp grid button of account payable report$")
	public void click_on_temp_grid_button_of_account_payable_report() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
    	Thread.sleep(1000);
//		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_FinancialReportingMenu());
//		javascripthelper.scrollIntoViewAndClick(reports_AssetCreationCommonObj.Report_AssetCreationCommon_FinancialReportingMenu());
		javascripthelper.scrollIntoView(reports_AssetCreationCommonObj.Report_AssetCreationCommon_FinancialReportingMenu());
		reports_AssetCreationCommonObj.Report_AccountPayableReport_AccountPayableReportTempView().click();
	}
    
    @And("^Fill the required fill to check the accounts payable report must display$")
    public void fill_the_required_fill_to_check_the_accounts_payable_report_must_display() throws InterruptedException  {
    	waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AccountPayableReport_VendorName());
		reports_AssetCreationCommonObj.Report_AccountPayableReport_VendorName().sendKeys(AssetCreationCommonTestDataType.AccountPayableVendorName);
		reports_AssetCreationCommonObj.Report_AccountPayableReport_VendorName().sendKeys(Keys.ENTER);
		
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();
		
		Thread.sleep(2000);
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(AssetCreationCommonTestDataType.AccountPayableYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]"));
					clicksAndActionHelper.doubleClick(Year);
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+AssetCreationCommonTestDataType.AccountPayableYear+"')]"));
					clicksAndActionHelper.doubleClick(Year);
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableYear+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth+" "+AssetCreationCommonTestDataType.AccountPayableYear+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth +" "+AssetCreationCommonTestDataType.AccountPayableDate+", "+AssetCreationCommonTestDataType.AccountPayableYear+"']/span")));	
		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+AssetCreationCommonTestDataType.AccountPayableFullMonth +" "+AssetCreationCommonTestDataType.AccountPayableDate+", "+AssetCreationCommonTestDataType.AccountPayableYear+"']/span"));
		clicksAndActionHelper.doubleClick(BirthDate);
		
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AccountPayableReport_PayableStatus());
		reports_AssetCreationCommonObj.Report_AccountPayableReport_PayableStatus().sendKeys(AssetCreationCommonTestDataType.AccountPayablePayableStatus);
		reports_AssetCreationCommonObj.Report_AccountPayableReport_PayableStatus().sendKeys(Keys.DOWN,Keys.ENTER);
    }

    @Then("^verify the accounts payable report must correctly displayed$")
    public void verify_the_accounts_payable_report_must_correctly_displayed() throws InterruptedException, IOException, ParseException {
    	Thread.sleep(1000);
    	browserHelper.SwitchToWindow(1);
    	for(int i=0;i<5;i++)
    	{
    		try {
    			javascripthelper.JavaScriptHelper(driver);
        		javascripthelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'"+jsonWriter.readdata()+")]")));
        		boolean result = driver.findElement(By.xpath("//div[contains(text(),'"+jsonWriter.readdata()+")]")).isDisplayed();
        		System.out.println(result);
    		}
    		catch(NoSuchElementException e)
    		{
    			waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AccountPayableReport_NextPage());
    			reports_AssetCreationCommonObj.Report_AccountPayableReport_NextPage().click();
    		}
//    		catch(IndexOutOfBoundsException b) {
//    			break;
//    		}
    		
    	}
//    	waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport());
//    	reports_AssetCreationCommonObj.Report_AssetTransfer_AssetTransferReport().isDisplayed();
//    	driver.close();
    	browserHelper.switchToParentWithChildClose();
    	//---report fetching code---//
    }
    
	@And("^user should navigate to master reports menu$")

	public void user_should_navigate_to_master_reports_menu() {

//    		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon()); 

//    		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon().click(); 

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_MasterReportsMenu());

		reports_AssetCreationCommonObj.Report_MasterReportsMenu().click();

	}

	@Then("^click on temp grid button of asset code$")

	public void click_on_temp_grid_button_of_asset_code() {

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCodeReport_TempView());

		reports_AssetCreationCommonObj.Report_AssetCodeReport_TempView().click();

	}

    @Then("^Choose the data set for asset code report$")
    public void choose_the_data_set_for_asset_code_report() throws Throwable {
		assetCodeConfigTestData = excelData.getTestdata("KUBS_FAT_UAT_013_003_D1");

    }

    @Then("^Get the system date for asset code report$")
    public void get_the_system_date_for_asset_code_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,reports_AssetCreationCommonObj.systemDate(), 30, 2);
        String systemdate = reports_AssetCreationCommonObj.systemDate().getText();
    System.out.println(systemdate);
    String[] split = systemdate.split("-");
    String date = split[0];
    testdata.put("Date", date);
    //  System.out.println(date);
    String month = split[1];
    testdata.put("ToMonth", month);
    //  System.out.println(month);
    String year = split[2];
    testdata.put("Year", year);
    //  System.out.println(year);
    String fullMonth;
    switch (month) {
    case "Jan":
    fullMonth = "January";
    break;
    case "Feb":
    fullMonth = "February";
    break;
    case "Mar":
    fullMonth = "March";
    break;
    case "Apr":
    fullMonth = "April";
    break;
    case "May":
    fullMonth = "May";
    break;
    case "Jun":
    fullMonth ="June";
    break;
    case "Jul":
    fullMonth = "July";
    break;
    case "Aug":
    fullMonth ="August";
    break;
    case "Sep":
    fullMonth = "September";
    break;
    case "Oct":
    fullMonth = "October";
    break;
    case "Nov":
    fullMonth = "November";
    break;
    case "Dec":
    fullMonth = "December";
    break;
    default:
     fullMonth = "InvalidMonth";
    break;
    }
    testdata.put("FullMonth", fullMonth);


    }
	@And("^select the depreciation method and date to check the asset codes are displaying$")

	public void select_the_depreciation_method_and_date_to_check_the_asset_codes_are_displaying()
			throws InterruptedException {

		waithelper.waitForElement(driver, 3000,
				reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(assetCodeConfigTestData.get("DepriciationMethod"));

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();

		Thread.sleep(1000);

		while (true)

		{

			try

			{

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetCodeToMonth
										+ " " + AssetCreationCommonTestDataType.AssetCodeToYear + "')]")));

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetCodeToMonth + " "
								+ AssetCreationCommonTestDataType.AssetCodeToYear + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver
				.findElement(By.xpath("//td[@aria-label='" + AssetCreationCommonTestDataType.AssetCodeToFullMonth + " "
						+ AssetCreationCommonTestDataType.AssetCodeToDate + ", "
						+ AssetCreationCommonTestDataType.AssetCodeToYear + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@Then("^click on temp grid button of asset category$")

	public void click_on_temp_grid_button_of_asset_category() {

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCategoryReport_TempView());

		reports_AssetCreationCommonObj.Report_AssetCategoryReport_TempView().click();

	}

	@Then("^click on temp grid button of asset limit configuration$")

	public void click_on_temp_grid_button_of_asset_limit_configuration() {

		javascripthelper.JavaScriptHelper(driver);

		javascripthelper
				.scrollIntoViewAndClick(reports_AssetCreationCommonObj.Report_AssetLimitConfiguration_TempView());

	}

	@Then("^click on temp grid button of asset serial number$")

	public void click_on_temp_grid_button_of_asset_serial_number() {

		javascripthelper.JavaScriptHelper(driver);

		javascripthelper.scrollIntoViewAndClick(reports_AssetCreationCommonObj.Report_AssetSerialNumber_TempView());

	}

	// ------- Check Asset Serial number

	@And("^select the asset code and serial number and date to check the asset serial number are displaying$")

	public void select_the_asset_code_and_serial_number_and_date_to_check_the_asset_serial_number_are_displaying()
			throws InterruptedException {

		waithelper.waitForElement(driver, 3000,
				reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(AssetCreationCommonTestDataType.AssetSerialAssetCode);

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetLimit_StartSerialNumber());

		reports_AssetCreationCommonObj.Report_AssetLimit_StartSerialNumber()
				.sendKeys(AssetCreationCommonTestDataType.AssetStartSerialNumber);

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();

		Thread.sleep(1000);

		while (true)

		{

			try

			{

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetSerialToMonth
										+ " " + AssetCreationCommonTestDataType.AssetSerialToYear + "')]")));

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetSerialToMonth + " "
								+ AssetCreationCommonTestDataType.AssetSerialToYear + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver
				.findElement(By.xpath("//td[@aria-label='" + AssetCreationCommonTestDataType.AssetSerialToFullMonth
						+ " " + AssetCreationCommonTestDataType.AssetSerialToDate + ", "
						+ AssetCreationCommonTestDataType.AssetSerialToYear + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	// ------- Check Asset limit configuration

	@And("^select the accounting standards and date to check the asset limit are displaying$")

	public void select_the_accounting_standards_date_to_check_the_asset_limit_are_displaying()
			throws InterruptedException {

		waithelper.waitForElement(driver, 3000,
				reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(AssetCreationCommonTestDataType.AccountingStandards);

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();

		Thread.sleep(1000);

		while (true)

		{

			try

			{

				waithelper
						.waitForElement(driver, 3000,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ AssetCreationCommonTestDataType.AssetCategoryToMonth + " "
										+ AssetCreationCommonTestDataType.AssetCategoryToYear + "')]")));

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetCategoryToMonth + " "
								+ AssetCreationCommonTestDataType.AssetCategoryToYear + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver
				.findElement(By.xpath("//td[@aria-label='" + AssetCreationCommonTestDataType.AssetCategoryToFullMonth
						+ " " + AssetCreationCommonTestDataType.AssetCategoryToDate + ", "
						+ AssetCreationCommonTestDataType.AssetCategoryToYear + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	// ------- Check Asset Category

	@And("^select the asset category and date to check the asset category are displaying$")

	public void select_the_asset_category_and_date_to_check_the_asset_category_are_displaying()
			throws InterruptedException {

		waithelper.waitForElement(driver, 3000,
				reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod());

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod()
				.sendKeys(AssetCreationCommonTestDataType.AssetCategory);

		reports_AssetCreationCommonObj.Report_MasterReports_DepreciationMethod().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date());

		reports_AssetCreationCommonObj.Report_AssetCreationCommon_Date().click();

		Thread.sleep(1000);

		while (true)

		{

			try

			{

				waithelper
						.waitForElement(driver, 3000,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ AssetCreationCommonTestDataType.AssetCategoryToMonth + " "
										+ AssetCreationCommonTestDataType.AssetCategoryToYear + "')]")));

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + AssetCreationCommonTestDataType.AssetCategoryToMonth + " "
								+ AssetCreationCommonTestDataType.AssetCategoryToYear + "')]"));

				break;

			}

			catch (NoSuchElementException nosuchElement)

			{

				reports_AssetCreationCommonObj.Report_AssetCreationCommon_NextMonth().click();

			}

		}

		WebElement FinalDay2 = driver
				.findElement(By.xpath("//td[@aria-label='" + AssetCreationCommonTestDataType.AssetCategoryToFullMonth
						+ " " + AssetCreationCommonTestDataType.AssetCategoryToDate + ", "
						+ AssetCreationCommonTestDataType.AssetCategoryToYear + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@Then("^the report is displaying all the asset codes details for a branch$")

	public void the_report_is_displaying_all_the_asset_codes_details_for_a_branch() throws InterruptedException {

		Thread.sleep(1000);

		browserHelper.SwitchToWindow(1);

		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetCodesReport());

		boolean result = reports_AssetCreationCommonObj.Report_AssetCodesReport().isDisplayed();

		System.out.println(result);

		browserHelper.switchToParentWithChildClose();

	}

	@Then("^the report is displaying all the asset category details for a branch$")

	public void the_report_is_displaying_all_the_asset_category_details_for_a_branch() throws InterruptedException {

		Thread.sleep(1000);

		browserHelper.SwitchToWindow(1);

		waithelper.waitForElement(driver, 10000, reports_AssetCreationCommonObj.Report_AssetCodesReport());

		boolean result = reports_AssetCreationCommonObj.Report_AssetCodesReport().isDisplayed();

		System.out.println(result);

		browserHelper.switchToParentWithChildClose();

	}
	

}
