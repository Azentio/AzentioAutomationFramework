package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetGlConfigurationObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetSaleReport extends BaseClass  {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetGlConfigurationObj fixedAsset_AssetGlConfigurationObj = new FixedAsset_AssetGlConfigurationObj(driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	BrowserHelper browserHelper = new BrowserHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	Map<String, String> assetSaleTestData = new HashMap<>();
	String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDatForAssetSale = new ExcelData(path, "FixedAsset_AssetSale", "DataSet ID");
	Map<String, String> testdata = new LinkedHashMap<>();

	@Then("^click on Asset Sale Report$")
    public void click_on_asset_sale_report(){
	//Asset Code	
	 waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport());
	 fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport().click();
	  
    }
	@Then("^Select the Asset Sale Code$")
    public void select_the_asset_sale_code()  {
    //Asset sale Code	
     waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode());
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().click();
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().sendKeys(assetSaleTestData.get("AssetReferenceNumber"));
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().sendKeys(Keys.ENTER);
         
    }
	@And("^Choose the data set id for asset sale report$")
    public void choose_the_data_set_id_for_asset_sale_report() throws Throwable {
		assetSaleTestData = excelDatForAssetSale.getTestdata("KUBS_FAT_UATD_013_013_D1");

    }

    @And("^Get the system data for asset sale$")
    public void get_the_system_data_for_asset_sale() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetGlConfigurationObj.systemDate(), 30, 2);
        String systemdate = fixedAsset_AssetGlConfigurationObj.systemDate().getText();
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
    

    @Then("^Select the date Asset Sale$")
    public void select_the_date_asset_sale(){
    	//select Transaction from date
 		waithelper.waitForElement(driver, 3000, fixedAsset_AssetGlConfigurationObj.fixedAsset_CalendarFromDate());
 		fixedAsset_AssetGlConfigurationObj.fixedAsset_CalendarFromDate().click();
 	
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
 			fixedAsset_AssetGlConfigurationObj.fixedAsset_NextMonth().click();
 		}
 		}
 		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testdata.get("FullMonth")+" "+testdata.get("Date")+", "+testdata.get("Year")+"']/span"));
 		clicksAndActionHelper.doubleClick(FinalDay);	
    }
    @Then("^verify the Asset Sale report$")
    public void verify_the_asset_sale_report() throws InterruptedException{
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	Thread.sleep(2000);
    	browserHelper.switchToParentWithChildClose();   
    }
}
