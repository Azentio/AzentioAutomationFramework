package stepdefinitions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.FixedAsset_ReportsObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_Reports {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	
	JavascriptHelper javascripthelper = new JavascriptHelper();
	AzentioLogin login;
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	BUDGET_BudgetCreationTestDataType budgetdata;
	
	FixedAsset_ReportsObj fixedAsset_ReportsObj = new FixedAsset_ReportsObj(driver);

	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	Map<String, String> testdata = new LinkedHashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForAssetReplacement = new ExcelData(path, "FixedAsset_AssetReplacement", "DataSet ID");
	Map<String, String> assetReplacementTestData = new HashMap<>();
	ExcelData excelDataForAssetReturn = new ExcelData(path, "FixedAsset_AssetReturn", "DataSet ID");
	Map<String, String> assetReturnTestdata = new HashMap<>();
	ExcelData excelDataForAssetAllocation = new ExcelData(path, "FixedAsset_AssetAllocation", "DataSet ID");
	Map<String, String> assetAllocationTestData = new HashMap<>();
	ExcelData excelDataForAssetAmmendment = new ExcelData(path, "FixedAsset_AssetAmmendment", "DataSet ID");
	Map<String, String> assetAmmendmentTestData = new HashMap<>();

	
	@Then("^Click on Transaction Reports tab$")
    public void click_on_transaction_reports_tab() throws Throwable {
	waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_TransactionReports());
	fixedAsset_ReportsObj.fixedAsset_TransactionReports().click();   
    }

    @Then("^Click on Asset replacement Report edit button$")
    public void click_on_asset_replacement_report_edit_button() throws Throwable {
    waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport());
    fixedAsset_ReportsObj.fixedAsset_ReplacementReport().click();   
    }
    @Then("^Choose the data set id for asset replacement report$")
    public void choose_the_data_set_id_for_asset_replacement_report() throws Throwable {
  		assetReplacementTestData = excelDataForAssetReplacement.getTestdata("KUBS_FAT_UAT_013_017_D1");
}
    @Then("^Fill details for report$")
    public void fill_details_for_report() throws Throwable {
     //Asset Code 	
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode());
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().click();
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().sendKeys(assetReplacementTestData.get("AssetReferenceNumber"));
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().sendKeys(Keys.ENTER);
  	 
  	  //Item Number
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber());
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber().click();
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber().sendKeys(assetReplacementTestData.get("AssetItemNumber"));
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber().sendKeys(Keys.ENTER);
  	    
    }

    @Then("^Select date from calendar$")
    public void select_date_from_calendar() throws Throwable {
      
   //select  date
   waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_ReplacementReport_Calendar());
   fixedAsset_ReportsObj.fixedAsset_ReplacementReport_Calendar().click();
    		
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
    	fixedAsset_ReportsObj.fixedAsset_ReplacementReport_NextMonth().click();
    }
    }
    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+", "+testdata.get("FullMonth")+", "+testdata.get("Date")+"']/span"));
    clicksAndActionHelper.doubleClick(FinalDay);
    }
    
    ///---impair----//
    
    
    @Then("^Click on Impairement Report edit button$")
    public void click_on_impairement_report_edit_button()  {
    waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ImpairementReport());
    fixedAsset_ReportsObj.fixedAsset_ImpairementReport().click();  	
       
    }
   
    @Then("^Select Impairement loss date in calendar$")
    public void select_impairement_loss_date_in_calendar()  {
    	
    	//select  date
    	   waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_ReplacementReport_Calendar());
    	   fixedAsset_ReportsObj.fixedAsset_ImpairementReport_Calendar().click();
    	    		
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
    	    	fixedAsset_ReportsObj.fixedAsset_ImpairementReport_NextMonth().click();
    	    }
    	    }
    	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
    	    clicksAndActionHelper.doubleClick(FinalDay);
    	    }
    
    
    //-----Revaluation-------//
    
    @Then("^Click on Revaluation Report edit button$")
    public void click_on_revaluation_report_edit_button() throws Throwable {
    	waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_RevaluationReport());
        fixedAsset_ReportsObj.fixedAsset_RevaluationReport().click(); 
    }

    @And("^Get the system data$")
    public void get_the_system_data() throws Throwable {
    waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_ReportsObj.systemDate(), 30, 2);
    String systemdate = fixedAsset_ReportsObj.systemDate().getText();
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
    @Then("^Select Revaluation date in calendar$")
    public void select_revaluation_date_in_calendar() throws Throwable {
    	//select  date
 	   waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_RevaluationReport_Calendar());
 	   fixedAsset_ReportsObj.fixedAsset_RevaluationReport_Calendar().click();
 	    		
 	   javascripthelper.JavaScriptHelper(driver);
 	   while(true)
 	    {
 	     try
 	     {
 	    	Thread.sleep(1500);	
 	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
 	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
 	      break;
 	    			
 	     }
 	    			
 	    catch(NoSuchElementException nosuchElement)
 	    {
 	    	fixedAsset_ReportsObj.fixedAsset_RevaluationReport_NextMonth().click();
 	    }
 	   }
	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
	    clicksAndActionHelper.doubleClick(FinalDay);
	    }
    
    //-----------------return---//
    @Then("^Click on return Report edit button$")
    public void click_on_return_report_edit_button() throws Throwable {
   waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport());
   fixedAsset_ReportsObj.fixedAsset_ReturnReport().click();   
    }
    @Then("^choose the data set for asset return report$")
    public void choose_the_data_set_for_asset_return_report() throws Throwable {
		assetReturnTestdata = excelDataForAssetReturn.getTestdata("KUBS_FAT_UAT_013_016_01_D1");
    }
    @Then("^Fill details for return report$")
    public void fill_details_for_return_report() throws Throwable {
    	 //Asset Code 	
    	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode());
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode().click();
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode().sendKeys(assetReturnTestdata.get("AssetReferenceNumber"));
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode().sendKeys(Keys.ENTER);
    	 
    	  //Item Number
    	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport_ItemNumber());
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_ItemNumber().click();
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_ItemNumber().sendKeys(Keys.DOWN);
    	 // fixedAsset_ReportsObj.fixedAsset_ReturnReport_ItemNumber().sendKeys(fixedAsset_AssetCategoryTestDataType.ReturnReportItemNumber);
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_ItemNumber().sendKeys(Keys.ENTER);
    	      
    }

    @Then("^Select return date in calendar$")
    public void select_return_date_in_calendar() throws Throwable {
       
    	 waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_ReturnReport_Calendar());
   	   fixedAsset_ReportsObj.fixedAsset_ReturnReport_Calendar().click();
   	    		
   	   javascripthelper.JavaScriptHelper(driver);
   	   while(true)
   	    {
   	     try
   	     {
   	    	Thread.sleep(1500);	
   	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
   	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
   	      break;
   	    			
   	     }
   	    			
   	    catch(NoSuchElementException nosuchElement)
   	    {
   	    	fixedAsset_ReportsObj.fixedAsset_ReturnReport_NextMonth().click();
   	    }
   	   }
  	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
  	    clicksAndActionHelper.doubleClick(FinalDay);
  	    }
    
    
    //-----Allocation Report----------//
    @Then("^Click on Allocation Report edit button$")
    public void click_on_allocation_report_edit_button() throws Throwable {
     waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport());
     fixedAsset_ReportsObj.fixedAsset_AllocationReport().click();    
    }
    @Then("^Choose the data set id for asset allocation report$")
    public void choose_the_data_set_id_for_asset_allocation_report() throws Throwable {
		assetAllocationTestData = excelDataForAssetAllocation.getTestdata("KUBS_FAT_UATD_013_014_D1");

    }
    @Then("^fill Allocation Report details$")
    public void fill_allocation_report_details() throws Throwable {
    	//Employee name 	
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId());
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().click();
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().sendKeys(assetAllocationTestData.get("EmployeeID"));
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().sendKeys(Keys.ENTER);
  	 
  	  //Item Number
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber());
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber().click();
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber().sendKeys(assetAllocationTestData.get("AssetItemNumber"));
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber().sendKeys(Keys.ENTER);   
    }

    @Then("^Select Allocation date in calendar$")
    public void select_allocation_date_in_calendar() throws Throwable {
    	 waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_AllocationReport_Calendar());
     	   fixedAsset_ReportsObj.fixedAsset_AllocationReport_Calendar().click();
     	    		
     	   javascripthelper.JavaScriptHelper(driver);
     	   while(true)
     	    {
     	     try
     	     {
     	    	Thread.sleep(1500);	
     	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
     	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
     	      break;
     	    			
     	     }
     	    			
     	    catch(NoSuchElementException nosuchElement)
     	    {
     	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
     	    }
     	   }
    	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
    	    
    	    clicksAndActionHelper.doubleClick(FinalDay);   
    }
    
    //Deallocation
    @Then("^Click on DeAllocation Report edit button$")
    public void click_on_deallocation_report_edit_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_ReportsObj.fixedAsset_DeAllocationReport());
        waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport());
        fixedAsset_ReportsObj.fixedAsset_DeAllocationReport().click();
    
    }

    @Then("^fill DeAllocation Report details$")
    public void fill_deallocation_report_details() throws Throwable {
    //Employee name 	
     waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_EmployeeId());
    fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_EmployeeId().click();
    fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_EmployeeId().sendKeys(assetAllocationTestData.get("EmployeeID"));
    fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_EmployeeId().sendKeys(Keys.ENTER);   
    }

    @Then("^Select DeAllocation from date in calendar$")
    public void select_deallocation_from_date_in_calendar() throws Throwable {
    	waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarDate());
  	   fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarDate().click();
  	    		
  	   javascripthelper.JavaScriptHelper(driver);
  	   while(true)
  	    {
  	     try
  	     {
  	    	Thread.sleep(1500);	
  	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
  	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
  	      break;
  	    			
  	     }
  	    			
  	    catch(NoSuchElementException nosuchElement)
  	    {
  	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
  	    }
  	   }
 	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
 	    clicksAndActionHelper.doubleClick(FinalDay);   
    }

    @Then("^Select DeAllocation to date in calendar$")
    public void select_deallocation_to_date_in_calendar() throws Throwable {
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarAsOnDate());
    	fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarAsOnDate().click();

    	
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
    			fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_NextMonth().click();
    		}
    		}
    		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
    		clicksAndActionHelper.doubleClick(FinalDay2);   
    }
    @Then("^Click on Amendment Report edit button$")
    public void click_on_amendment_report_edit_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        fixedAsset_ReportsObj.fixedAsset_AmendmentReport().click();    
    }
    @Then("^Choose the data set id for asset amenment report$")
    public void choose_the_data_set_id_for_asset_amenment_report() throws Throwable {
		assetAmmendmentTestData = excelDataForAssetAmmendment.getTestdata("KUBS_FAT_UAT_013_010_D1");

    }
    @Then("^Get the system date for asset ammenment report$")
    public void get_the_system_date_for_asset_ammenment_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_ReportsObj.systemDate(), 30, 2);
        String systemdate = fixedAsset_ReportsObj.systemDate().getText();
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
    

    @Then("^fill Amendment Report details$")
    public void fill_amendment_report_details() throws Throwable {
    	 //	Modification
        waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification());
       fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification().click();
       fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification().sendKeys(assetAmmendmentTestData.get("ModificationType"));
       fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification().sendKeys(Keys.ENTER);   
    }

    @Then("^Select Amendment from date in calendar$")
    public void select_amendment_from_date_in_calendar() throws Throwable {
    	waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarDate());
   	   fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarDate().click();
   	    		
   	   javascripthelper.JavaScriptHelper(driver);
   	   while(true)
   	    {
   	     try
   	     {
   	    	Thread.sleep(1500);	
   	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]")));
   	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("ToMonth")+" "+testdata.get("Year")+"')]"));
   	      break;
   	    			
   	     }
   	    			
   	    catch(NoSuchElementException nosuchElement)
   	    {
   	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
   	    }
   	   }
  	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
  	    clicksAndActionHelper.doubleClick(FinalDay);  
    }

    @Then("^Select Amendment to date in calendar$")
    public void select_amendment_to_date_in_calendar() throws Throwable {
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarAsOnDate());
    	fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_CalendarAsOnDate().click();

    	
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
    			fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_NextMonth().click();
    		}
    		}
    		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
    		clicksAndActionHelper.doubleClick(FinalDay2);    
    }
      
}
