package stepdefinitions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.DoubleStream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.MonthFinder;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;

public class FIXEDASSET_AssetImpairement extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	KUBS_MakerObj KubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	FIXEDASSET_fixedAssetObj fixedAssetObj = new FIXEDASSET_fixedAssetObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	Map<String, String> impairementData = new HashMap<String, String>();
	FIXEDASSET_AssetImpairementTestDataType fixedAssetImairementTestData = jsonConfig
			.getFixedAssetTestDataByName("Maker");
	public String assetLife;

	@Given("^Navigate to KUBS URL and login with maker credentials$")
	public void navigate_to_kubs_url_and_login_with_maker_credentials() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioApp("Maker");

	}

	@And("^click on fixed asset main module$")
	public synchronized void click_on_fixed_asset_main_module() throws Throwable {
		waitHelper.waitForElementVisible(KubsMakerObj.kubsDirectionIcon(), 1000, 100);
		KubsMakerObj.kubsDirectionIcon().click();
		// waitHelper.waitForElementVisible(KubsMakerObj.kubsFixedAssets(), 1000, 100);
		while (true) {
			try {
				KubsMakerObj.kubsFixedAssets().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}

    @And("^goto asset creation module$")
    public void goto_asset_creation_module() throws Throwable {
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetAssetCreationViewButton(),1000, 100);
    	fixedAssetObj.fixedAssetAssetCreationViewButton().click();
    	
    }
    @Then("^search the asset reference number in asset Creation$")
    public void search_the_asset_reference_number_in_asset_creation() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
    	//ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
    	driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetImairementTestData.writeOffAssetRefNo+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);
    	
        assetLife=fixedAssetObj.fixedAssetLife().getText();
    	System.out.println("Asset Life Is"+assetLife);
    	
    	
    	
}
	@Then("^check if the asset life is exhausted$")
    public void check_if_the_asset_life_is_exhausted() throws Throwable {

		MonthFinder monthFinder=new MonthFinder();
		for(int i=0;i<3;i++)
		{
			try
			{
		fixedAssetObj.fixedAssetFixedAssetItem().click();
		break;
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println(e.getMessage());
			}
		}
		fixedAssetObj.fixedAssetItemRecord().click();
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		String capitalizationDatedate=javascriptHelper.executeScript("return document.getElementsByClassName('form-control p-0')[1].value").toString();
		String assetLifePeriod=javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[8].value").toString();
		int assetLifePeriodIntegerValue=Integer.parseInt(assetLifePeriod);
		int finalAssetLife=assetLifePeriodIntegerValue*365;
		int finalAssetLifeMonth=assetLifePeriodIntegerValue*30;
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSystemDate(), 1000, 100);
		String systemDate=fixedAssetObj.fixedAssetSystemDate().getText();
		System.out.println("Date is"+capitalizationDatedate);
		System.out.println("System date is"+systemDate);
		System.out.println("AssetLife is"+assetLife);
		LocalDate fromDate = null;
		LocalDate toDate = null;
		String[] capitalizationdate=capitalizationDatedate.split("-");
		String[] systemdate=systemDate.split("-");
		int day=Integer.parseInt(capitalizationdate[0]);
		int year=Integer.parseInt(capitalizationdate[2]);
		//Month capitalizationMonth = null;
		String month=capitalizationdate[1];
		int SystemDay=Integer.parseInt(systemdate[0]);
		int systemYear=Integer.parseInt(systemdate[2]);
		String SystemMonth=systemdate[1];
		Month capitalizationFromMonth=monthFinder.monthFinder(month);
		Month SystemToMonth=monthFinder.monthFinder(SystemMonth);
		LocalDate capDate=fromDate.of(year, capitalizationFromMonth, day);
		LocalDate sysDate=toDate.of(systemYear, SystemToMonth, day);
		long noOfDaysBetween = ChronoUnit.DAYS.between(capDate, sysDate);
		System.out.println(noOfDaysBetween);
		if(assetLife.equalsIgnoreCase("Month"))
		{
			if(finalAssetLifeMonth==noOfDaysBetween||finalAssetLifeMonth<=noOfDaysBetween)
			{
				System.out.println("Condition satisfied");
			}
			else
			{
				Assert.fail(" Monthly Asset is not expired ");
			}
		}
		else if(assetLife.equalsIgnoreCase("Year"))
		{
			if(finalAssetLife==noOfDaysBetween||finalAssetLife>=noOfDaysBetween)
			{
				System.out.println("Condition satisfied");
			}
			else
			{
				Assert.fail("Yearly Asset is not expired");
			}
		}
		
		
		
    }



	@And("^go to asset allocation module$")
	public void go_to_asset_allocation_module() throws Throwable {
		fixedAssetObj.fixedAssetAssetAllocationViewButton().click();
	}
	@And("^go to asset de allocation module$")
    public void go_to_asset_de_allocation_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetDeallocation());
    	fixedAssetObj.fixedAssetAssetDeallocation().click();
    }
	@And("^go to revalued asset module$")
    public void go_to_revalued_asset_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetRevaluation());
    	fixedAssetObj.fixedAssetRevaluation().click();   
    }
    @And("^goto asset ammendent module$")
    public void goto_asset_ammendent_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetAmmendent());
    	fixedAssetObj.fixedAssetAssetAmmendent().click();
    }
    @And("^goto asset replacement module$")
    public void goto_asset_replacement_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetReplacement());
    	fixedAssetObj.fixedAssetAssetReplacement().click();
    }
    @And("^goto asset return module and choose the edit icon$")
    public void goto_asset_return_module() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetReturnActionIcon());
    	fixedAssetObj.fixedAssetAssetReturnActionIcon().click();
    }
    @And("^goto asset sale module and choose the edit icon$")
    public void goto_asset_sale_module_and_choose_the_edit_icon() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetSale());
    	fixedAssetObj.fixedAssetAssetSale().click();
    }
    @And("^goto asset transfer module and choose the edit icon$")
    public void goto_asset_transfer_module_and_choose_the_edit_icon() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetTransferEditIcon());
    	fixedAssetObj.fixedAssetAssetTransferEditIcon().click();
    }
   
	@Then("^check asset reference number is availabe in the list view$")
	public void check_asset_reference_number_is_availabe_in_the_list_view() throws Throwable {
		// span[contains(text(),'01-ASTSBCTGRY001-Lockers_AZENTMAIN_10')]
		while (true) {
			try {
				driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNo + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}
    @Then("^check asset reference number of de allocated asset is availabe in the list view$")
    public void check_asset_reference_number_of_de_allocated_asset_is_availabe_in_the_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate + "')]")).isDisplayed();
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    	
		
    }

    
    @Then("^search the asset reference number of revalued is availabe in list view$")
    public void search_the_asset_code_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefRevalued);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefRevalued + "')]")).isDisplayed();
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}


    }

    
    @Then("^search the asset reference number of ammendent asset is availabe in list view$")
    public void search_the_asset_reference_number_of_ammendent_asset_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoAmmendent);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoAmmendent + "')]")).isDisplayed();
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    }
    @Then("^search the asset reference number of replacement asset is availabe in list view$")
    public void search_the_asset_reference_number_of_replacement_asset_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReplacement);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoReplacement + "')]")).isDisplayed();
    		break;
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    }
    @Then("^search the asset reference number of returned asset is availabe in list view$")
    public void search_the_asset_reference_number_of_returned_asset_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReturn);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoReturn + "')]")).isDisplayed();
    		break;
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    }
    @Then("^search the asset reference number of sale asset is availabe in list view$")
    public void search_the_asset_reference_number_of_sale_asset_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoSale);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoSale + "')]")).isDisplayed();
    		break;
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		} 
    }
    @Then("^search the asset reference number of transfered asset is availabe in list view$")
    public void search_the_asset_reference_number_of_transfered_asset_is_availabe_in_list_view() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.AssetReplacementAssetRefNoSearch(), 1000, 100);
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().click();
    	fixedAssetObj.AssetReplacementAssetRefNoSearch().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoTransfer);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + fixedAssetImairementTestData.allocatedAssetRefNoTransfer + "')]")).isDisplayed();
    		break;
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		} 
    }

   
   	@And("^click on view button near by asset impairement module$")
	public void click_on_view_button_near_by_asset_impairement_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		// waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetViewIcon(),
		// 1000, 100);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(assetImpairementObj.fixedAssetViewIcon());
				assetImpairementObj.fixedAssetViewIcon().click();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@And("^click on Add Icon$")
	public void click_on_Add_Icon() throws Throwable {
		assetImpairementObj.fixedAssetAddButton().click();

	}

	@Then("^Check System shuld display the input fields$")
	public void check_system_shuld_display_the_input_fields() throws Throwable {
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetReferenceNumber(), 1000, 100);
		Assert.assertTrue(assetImpairementObj.fixedAssetReferenceNumber().isDisplayed());
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetAssetItemNo(), 1000, 100);
		Assert.assertTrue(assetImpairementObj.fixedAssetAssetItemNo().isDisplayed());

	}
	@And("^select asset reference number of ammendent assset in write off$")
    public void select_asset_reference_number_of_ammendent_assset_in_write_off() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAmmendentAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }

	@And("^select asset reference number$")
	public void select_asset_reference_number() throws Throwable {

		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);

	}

	@And("^select the asset reference number of allocated asset$")
	public void select_the_asset_reference_number_of_allocated_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNo);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	}
	@And("^select the asset reference number of deallocated asset$")
    public void select_the_asset_reference_number_of_deallocated_asset() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoDeAllocate);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^choose the asset reference number of revalued asset$")
    public void choose_the_asset_reference_number_of_revalued_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefRevalued);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^choose the asset reference number of ammendent asset$")
    public void choose_the_asset_reference_number_of_ammendent_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoAmmendent);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^choose the asset reference number of replaced asset$")
    public void choose_the_asset_reference_number_of_replaced_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReplacement);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^choose the asset reference number of returned asset$")
    public void choose_the_asset_reference_number_of_returned_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoReturn);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^choose the asset reference number of sold asset$")
    public void choose_the_asset_reference_number_of_sold_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoSale);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^select asset reference number for write Off$")
    public void select_asset_reference_number_for_write_off() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @Then("^search the asset reference number which we going to do impairement$")
    public void search_the_asset_reference_number_which_we_going_to_do_impairement() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber);
    	//ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
    	driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);
    	
        assetLife=fixedAssetObj.fixedAssetLife().getText();
    	System.out.println("Asset Life Is"+assetLife);
    }
    @Then("^search the asset reference number which we going to do revaluation$")
    public void search_the_asset_reference_number_which_we_going_to_do_revaluation() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.writeOffRevaluedAssetReferenceNumber);
    	//ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
    	driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetImairementTestData.writeOffRevaluedAssetReferenceNumber+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);
    	
        assetLife=fixedAssetObj.fixedAssetLife().getText();
    	System.out.println("Asset Life Is"+assetLife);
    }
    @Then("^search the asset reference number which we going to do ammendent$")
    public void search_the_asset_reference_number_which_we_going_to_do_ammendent() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(fixedAssetImairementTestData.writeOffAmmendentAssetReferenceNumber);
    	//ELECTRONICS-LAP001-Apple_Mac_Book_HO0001_128979
    	driver.findElement(By.xpath("//span[contains(text(),'"+fixedAssetImairementTestData.writeOffAmmendentAssetReferenceNumber+"')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[5]//ion-button[1]"))
.click();
		waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetLife(), 1000, 100);
    	
        assetLife=fixedAssetObj.fixedAssetLife().getText();
    	System.out.println("Asset Life Is"+assetLife);
    }
    @And("^choose the asset reference number of transfered asset$")
    public void choose_the_asset_reference_number_of_transfered_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.allocatedAssetRefNoTransfer);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^select asset reference number of expaired asset$")
    public void select_asset_reference_number_of_expaired_asset() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffImpairedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    @And("^select asset reference number for revalued assset in write off$")
    public void select_asset_reference_number_for_revalued_assset_in_write_off() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffRevaluedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
	@And("^choose the asset Item no$")
	public void choose_the_asset_no() throws Throwable {
		assetImpairementObj.fixedAssetAssetItemNo().click();
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.DOWN);
		assetImpairementObj.fixedAssetAssetItemNo().sendKeys(Keys.ENTER);

	}
    @Then("^Give Asset Referance Number of revaluation$")
    public void give_asset_referance_number_of_revaluation() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffRevaluedAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
    
    @Then("^Enter Asset Referance Number in ammendent asset for doing write off$")
    public void enter_asset_referance_number_in_ammendent_asset_for_doing_write_off() throws Throwable {
    	assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAmmendentAssetReferenceNumber);
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
    }
	

	@And("^choose the transcation type as impairment$")
	public void choose_the_transcation_type_as_impairment() throws Throwable {
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetTransTypeImpairement(), 1000, 100);
		assetImpairementObj.fixedAssetTransTypeImpairement().click();
		String assetReferenceNumber = assetImpairementObj.fixedAssetGetReferenceNo().getText();
		impairementData.put("AssetReferenceNo", assetReferenceNumber);

	}
	@And("^choose the transcation type as writeOff$")
    public void choose_the_transcation_type_as_writeoff() throws Throwable {
		assetImpairementObj.fixedAssetAssetTransactionType().click();
		waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetTransTypeWriteOff(), 1000, 100);
		assetImpairementObj.fixedAssetTransTypeWriteOff().click();
		String assetReferenceNumber = assetImpairementObj.fixedAssetGetReferenceNo().getText();
		impairementData.put("AssetReferenceNo", assetReferenceNumber);
    }
	@And("^check the book value of asset$")
    public void check_the_book_value_of_asset() throws Throwable {
		assetImpairementObj.fixedAssetBookValue().clear();
		assetImpairementObj.fixedAssetBookValue().sendKeys(fixedAssetImairementTestData.bookValue);
		
    }

	@Then("^click on Save Button$")
	public void click_on_save_button() throws Throwable {

		for (int i = 0; i < 5; i++) {
			try {
				if(i==4)
				{
				Assert.fail("Save button not able to click");	
				}
				waitHelper.waitForElementVisible(assetImpairementObj.fixedAssetSaveButton(), 1000, 100);
				assetImpairementObj.fixedAssetSaveButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@And("^login with Maker ID$")
	public void login_with_maker_id() throws Throwable {
		Thread.sleep(1000);
		kubsLogin.loginToAzentioApp("Maker");
	}

	@Then("^check the approved record is displayed in appeared in maker list view stage$")
	public void check_the_approved_record_is_displayed_in_appeared_in_maker_list_view_stage() throws Throwable {
		System.out.println(impairementData.get("AssetReferenceNo"));

		String beforeXpath = "//span[contains(text(),'";
		String afterXpath = "')]";
		while (true) {
			try {
				driver.findElement(By.xpath(beforeXpath + impairementData.get("AssetReferenceNo") + afterXpath))
						.isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				assetImpairementObj.fixedAssetNextButton().click();
			}
		}
	}
	@Then("^Validate whether the reference number is visible in dropdown$")
    public void validate_whether_the_reference_number_is_visible_in_dropdown() throws Throwable {
		assetImpairementObj.fixedAssetReferenceNumber().click();
		assetImpairementObj.fixedAssetReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffAssetRefNo);
		boolean result=assetImpairementObj.fixedAssetNoList().isDisplayed();
		Assert.assertTrue(result);
    }

}
