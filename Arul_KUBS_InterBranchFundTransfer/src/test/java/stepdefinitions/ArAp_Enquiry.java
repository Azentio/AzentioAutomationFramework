package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ArAp_EnquiryObj;
import resources.BaseClass;
import testDataType.ArAp_EnquiryTestDataType;


public class ArAp_Enquiry extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	ArAp_EnquiryObj arAp_EnquiryObj=new ArAp_EnquiryObj(driver);
	ArAp_EnquiryTestDataType arAp_EnquiryTestDataType = jsonReader.getArApEnquirytByName("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();

	
	
	//-------------------KUBS_AR/AP_UAT_010_003_TC_02-------------------//
	
	
	
	@And("^fill the mandtory field for bounced cheques$")
	public void fill_the_mandtory_field_for_bounced_cheques()  {
	arAp_EnquiryObj.arAp_Enquiry_BranchCode().sendKeys(arAp_EnquiryTestDataType.BranchCode);
	arAp_EnquiryObj.arAp_Enquiry_BranchCode().sendKeys(Keys.ENTER);
		 
			
	arAp_EnquiryObj.arAp_Enquiry_GlCode().sendKeys(arAp_EnquiryTestDataType.GLCode);
	arAp_EnquiryObj.arAp_Enquiry_GlCode().sendKeys(Keys.ENTER);   
	    	
	}

	@Then("^select Transaction from date bounced cheques$")
    public void select_transaction_from_date_bounced_cheques()  {
		waithelper.waitForElement(driver, 3000, arAp_EnquiryObj.arAp_Enquiry_FromDate());
		arAp_EnquiryObj.arAp_Enquiry_FromDate().click();
	
		javascripthelper.JavaScriptHelper(driver);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.GLMonth+" "+arAp_EnquiryTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.GLMonth+" "+arAp_EnquiryTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			arAp_EnquiryObj.arAp_Enquiry_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arAp_EnquiryTestDataType.GLFullMonth+" "+arAp_EnquiryTestDataType.GLDay+", "+arAp_EnquiryTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);   
    }

    @Then("^select Transaction to date bounced cheques$")
    public void select_transaction_to_date_bounced_cheques() throws InterruptedException  {
    	Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, arAp_EnquiryObj.arAp_Enquiry_ToDate());
		arAp_EnquiryObj.arAp_Enquiry_ToDate().click();
	
	
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.GLToMonth+" "+arAp_EnquiryTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.GLToMonth+" "+arAp_EnquiryTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			arAp_EnquiryObj.arAp_Enquiry_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+arAp_EnquiryTestDataType.GLFullToMonth+" "+arAp_EnquiryTestDataType.GLToDate+", "+arAp_EnquiryTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);     
    }
    
    @Then("^validate bounced cheques vourcher number$")
    public void validate_bounced_cheques_vourcher_number() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(arAp_EnquiryObj.arAp_Enquiry_Total());
        	Thread.sleep(2000);
        	while(true)
            {
    		try
    		{
    			
    			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.BouncedVoucher+"')]")));
    			WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.BouncedVoucher+"')]"));
    			break;
    		}
    		
    		catch(NoSuchElementException nosuchElement)
    		{
    			
    			arAp_EnquiryObj.arAp_Enquiry_Next().click();
    		}	
    		
    		
          }
        System.out.println("Record is present in the list");
       }
          
    

//-------------------KUBS_AR/AP_UAT_010_004_TC_02-------------------//

    @Then("^validate cleared cheques vourcher number$")
    public void validate_cleared_cheques_vourcher_number() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(arAp_EnquiryObj.arAp_Enquiry_Total());
        	Thread.sleep(2000);
        	while(true)
            {
    		try
    		{
    			
    			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.ClearedVoucher+"')]")));
    			WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.ClearedVoucher+"')]"));
    			
    			driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.ClearedVoucher+"')]")).isDisplayed();
    			break;
    		}
    		
    		catch(NoSuchElementException nosuchElement)
    		{
    			
    			arAp_EnquiryObj.arAp_Enquiry_Next().click();
    		}	
    		
    		
          }
        System.out.println("Record is present in the list");
       }
    
  //-------------------KUBS_AR/AP_UAT_004_002_TC_02-------------------//
    @And("^fill the Branch detail$")
    public void fill_the_branch_detail() {
    	arAp_EnquiryObj.arAp_Enquiry_BranchCode().sendKeys(arAp_EnquiryTestDataType.BranchCode);
    	arAp_EnquiryObj.arAp_Enquiry_BranchCode().sendKeys(Keys.ENTER);   
    }

    @Then("^validate No accounting entries are posted$")
    public void validate_no_accounting_entries_are_posted() throws InterruptedException {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(arAp_EnquiryObj.arAp_Enquiry_Total());
        	Thread.sleep(2000);
        	for(int i =0; i<=310; i++)
        	
            {
    		try
    		{
waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.Voucher+"')]")));
WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.Voucher+"')]"));
    			
    			driver.findElement(By.xpath("//span[contains(text(),'"+arAp_EnquiryTestDataType.Voucher+"')]")).isDisplayed();
    			break;
    		}
    		
    		catch(NoSuchElementException nosuchElement)
    		{
    				arAp_EnquiryObj.arAp_Enquiry_Nextbutton().isEnabled();
    				arAp_EnquiryObj.arAp_Enquiry_Nextbutton().click();
    		}
		}
        System.out.println("Record is not present in the list");	

	}

}  
    
