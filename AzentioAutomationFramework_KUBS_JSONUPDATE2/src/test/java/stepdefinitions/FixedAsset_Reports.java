package stepdefinitions;

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
import io.cucumber.java.en.Then;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.FixedAsset_ReportsObj;
import resources.BaseClass;
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

    @Then("^Fill details for report$")
    public void fill_details_for_report() throws Throwable {
     //Asset Code 	
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode());
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().click();
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.ReplacementReportAssetCode);
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_AssetCode().sendKeys(Keys.ENTER);
  	 
  	  //Item Number
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber());
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber().click();
  	  fixedAsset_ReportsObj.fixedAsset_ReplacementReport_ItemNumber().sendKeys(fixedAsset_AssetCategoryTestDataType.ReplacementReportItemNumber);
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
    			
      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ReplacementFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ReplacementYear+"')]")));
      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ReplacementFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ReplacementYear+"')]"));
      break;
    			
     }
    			
    catch(NoSuchElementException nosuchElement)
    {
    	fixedAsset_ReportsObj.fixedAsset_ReplacementReport_NextMonth().click();
    }
    }
    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.ReplacementFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.ReplacementFromDay+", "+fixedAsset_AssetCategoryTestDataType.ReplacementYear+"']/span"));
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
    	    			
    	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ImpairmentFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ImpairmentYear+"')]")));
    	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ImpairmentFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ImpairmentYear+"')]"));
    	      break;
    	    			
    	     }
    	    			
    	    catch(NoSuchElementException nosuchElement)
    	    {
    	    	fixedAsset_ReportsObj.fixedAsset_ImpairementReport_NextMonth().click();
    	    }
    	    }
    	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.ImpairmentFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.ImpairmentFromDay+", "+fixedAsset_AssetCategoryTestDataType.ImpairmentYear+"']/span"));
    	    clicksAndActionHelper.doubleClick(FinalDay);
    	    }
    
    
    //-----Revaluation-------//
    
    @Then("^Click on Revaluation Report edit button$")
    public void click_on_revaluation_report_edit_button() throws Throwable {
    	waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_RevaluationReport());
        fixedAsset_ReportsObj.fixedAsset_RevaluationReport().click(); 
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
 	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.RevaluationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.RevaluationYear+"')]")));
 	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.RevaluationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.RevaluationYear+"')]"));
 	      break;
 	    			
 	     }
 	    			
 	    catch(NoSuchElementException nosuchElement)
 	    {
 	    	fixedAsset_ReportsObj.fixedAsset_RevaluationReport_NextMonth().click();
 	    }
 	   }
	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.RevaluationFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.RevaluationFromDay+", "+fixedAsset_AssetCategoryTestDataType.RevaluationYear+"']/span"));
	    clicksAndActionHelper.doubleClick(FinalDay);
	    }
    
    //-----------------return---//
    @Then("^Click on return Report edit button$")
    public void click_on_return_report_edit_button() throws Throwable {
   waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport());
   fixedAsset_ReportsObj.fixedAsset_ReturnReport().click();   
    }

    @Then("^Fill details for return report$")
    public void fill_details_for_return_report() throws Throwable {
    	 //Asset Code 	
    	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode());
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode().click();
    	  fixedAsset_ReportsObj.fixedAsset_ReturnReport_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.ReturnReportAssetCode);
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
   	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ReturnFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ReturnYear+"')]")));
   	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.ReturnFromMonth+" "+fixedAsset_AssetCategoryTestDataType.ReturnYear+"')]"));
   	      break;
   	    			
   	     }
   	    			
   	    catch(NoSuchElementException nosuchElement)
   	    {
   	    	fixedAsset_ReportsObj.fixedAsset_ReturnReport_NextMonth().click();
   	    }
   	   }
  	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.ReturnFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.ReturnFromDay+", "+fixedAsset_AssetCategoryTestDataType.ReturnYear+"']/span"));
  	    clicksAndActionHelper.doubleClick(FinalDay);
  	    }
    
    
    //-----Allocation Report----------//
    @Then("^Click on Allocation Report edit button$")
    public void click_on_allocation_report_edit_button() throws Throwable {
     waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport());
     fixedAsset_ReportsObj.fixedAsset_AllocationReport().click();    
    }

    @Then("^fill Allocation Report details$")
    public void fill_allocation_report_details() throws Throwable {
    	//Employee name 	
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId());
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().click();
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().sendKeys(fixedAsset_AssetCategoryTestDataType.AllocationReportEmployeeID);
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_EmployeeId().sendKeys(Keys.ENTER);
  	 
  	  //Item Number
  	  waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber());
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber().click();
  	  fixedAsset_ReportsObj.fixedAsset_AllocationReport_ItemNumber().sendKeys(fixedAsset_AssetCategoryTestDataType.AllocationReportItemNumber);
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
     	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.AllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.AllocationYear+"')]")));
     	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.AllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.AllocationYear+"')]"));
     	      break;
     	    			
     	     }
     	    			
     	    catch(NoSuchElementException nosuchElement)
     	    {
     	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
     	    }
     	   }
    	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.AllocationFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.AllocationFromDay+", "+fixedAsset_AssetCategoryTestDataType.AllocationYear+"']/span"));
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
    fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_EmployeeId().sendKeys(fixedAsset_AssetCategoryTestDataType.DeAllocationReportEmployeeID);
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
  	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"')]")));
  	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"')]"));
  	      break;
  	    			
  	     }
  	    			
  	    catch(NoSuchElementException nosuchElement)
  	    {
  	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
  	    }
  	   }
 	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationFromDay+", "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"']/span"));
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
    		
    			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationToMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"')]")));
    			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationToMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"')]"));
    		    break;
    		}
    		
    		catch(NoSuchElementException nosuchElement)
    		{
    			fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_NextMonth().click();
    		}
    		}
    		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.DeAllocationToFullMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToDate+", "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"']/span"));
    		clicksAndActionHelper.doubleClick(FinalDay2);   
    }
    @Then("^Click on Amendment Report edit button$")
    public void click_on_amendment_report_edit_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        waithelper.waitForElement(driver, 3000, fixedAsset_ReportsObj.fixedAsset_AmendmentReport());
        fixedAsset_ReportsObj.fixedAsset_AmendmentReport().click();    
    }

    @Then("^fill Amendment Report details$")
    public void fill_amendment_report_details() throws Throwable {
    	 //	Modification
        waithelper.waitForElement(driver, 4000,  fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification());
       fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification().click();
       fixedAsset_ReportsObj.fixedAsset_AmendmentReport_Modification().sendKeys(fixedAsset_AssetCategoryTestDataType.AmendmentModification);
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
   	      waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"')]")));
   	      WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"')]"));
   	      break;
   	    			
   	     }
   	    			
   	    catch(NoSuchElementException nosuchElement)
   	    {
   	    	fixedAsset_ReportsObj.fixedAsset_AllocationReport_NextMonth().click();
   	    }
   	   }
  	    WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.DeAllocationFromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationFromDay+", "+fixedAsset_AssetCategoryTestDataType.DeAllocationYear+"']/span"));
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
    		
    			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationToMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"')]")));
    			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.DeAllocationToMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"')]"));
    		    break;
    		}
    		
    		catch(NoSuchElementException nosuchElement)
    		{
    			fixedAsset_ReportsObj.fixedAsset_DeAllocationReport_NextMonth().click();
    		}
    		}
    		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.DeAllocationToFullMonth+" "+fixedAsset_AssetCategoryTestDataType.DeAllocationToDate+", "+fixedAsset_AssetCategoryTestDataType.DeAllocationToYear+"']/span"));
    		clicksAndActionHelper.doubleClick(FinalDay2);    
    }
      
}
