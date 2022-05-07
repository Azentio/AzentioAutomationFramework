package stepdefinitions;

import static org.testng.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.BankRecon_ReconFormatObj;
import resources.BaseClass;
import testDataType.BankRecon_ReconFormatTestDataType;

public class BankRecon_ReconFormat  extends BaseClass{
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BankRecon_ReconFormatObj bankRecon_ReconFormatObj = new BankRecon_ReconFormatObj(driver);
	BankRecon_ReconFormatTestDataType bankRecon_ReconFormatTestDataType = jsonReader.getBankReconByName("Maker");
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
		
	
	 	@Then("^Click on Bank Recon$")
	    public void click_on_bank_recon()  {
	 	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormatField());
		bankRecon_ReconFormatObj.bankRecon_ReconFormatField().click();
			       
	    }

	    @Then("^click on Bank Recon format eye button$")
	    public void click_on_bank_recon_format_eye_button()  {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_EyeButton().click();   
	    }

	    @Then("^select the active record$")
	    public void select_the_active_record()  {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord());
	 	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FirstRecord().click();   
	    }

	    @Then("^Inactivate the record$")
	    public void inactivate_the_record()  {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().click();  
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(bankRecon_ReconFormatTestDataType.FormatStatus);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FormatStatus().sendKeys(Keys.ENTER);
		   
	    }
	    //bankRecon_ReconFormat_Next()
	    @Then("^history must be correctly maintained on record$")
	    public void history_must_be_correctly_maintained_on_record() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Next().click(); 
			Thread.sleep(2000);
	    }

	    
	    
	  //---------------------KUBS_BRS_UAT_001_001_TC_001----------------------//

	    @Then("^fill the Bank Reconciliation Format$")
	    public void fill_the_bank_reconciliation_format() throws InterruptedException {
	    	
	 //BankName   	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(bankRecon_ReconFormatTestDataType.BankName);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_BankName().sendKeys(Keys.ENTER);
			   	
	 //ApplicableAccountType	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().click();  
    bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(bankRecon_ReconFormatTestDataType.ApplicableAccountType);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_ApplicableAccountType().sendKeys(Keys.ENTER);       
	   
	//UploadFileExtension
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(bankRecon_ReconFormatTestDataType.UploadFileExtension);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_UploadFileExtension().sendKeys(Keys.ENTER);       
	//Separator
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(bankRecon_ReconFormatTestDataType.Separator);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Seprator().sendKeys(Keys.ENTER);       
	//AllowUnadjusted
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(bankRecon_ReconFormatTestDataType.AllowUnadjusted);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowUnadjusted().sendKeys(Keys.ENTER);       
	//EffectiveDate
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDate().click();
	/*Thread.sleep(2000);
	WebElement date = driver.findElement(By.xpath("//ion-picker-column[1]"));
	WebElement day = driver.findElement(By.xpath("//ion-picker-column[1]/div/button[7]"));
	Actions a = new Actions(driver);
	a.moveToElement(date).clickAndHold().moveToElement(day).release().build().perform();

	
	Thread.sleep(2000);
	WebElement month = driver.findElement(By.xpath("//ion-picker-column[2]"));
	WebElement mon = driver.findElement(By.xpath("//ion-picker-column[2]/div/button[7]"));
	a.moveToElement(month).clickAndHold().moveToElement(mon).release().build().perform();
	*/
	/*
	 * Actions a = new Actions(driver); Thread.sleep(2000); WebElement year =
	 * driver.findElement(By.xpath("//ion-picker-column[3]")); WebElement yr =
	 * driver.findElement(By.xpath("//ion-picker-column[3]/div/button[3]"));
	 * a.moveToElement(year).clickAndHold().moveToElement(yr).release().build().
	 * perform();
	 */
	Thread.sleep(2000);
	 String year1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[3]")).getText().toString();
	int yr1=Integer.parseInt(year1);
  List<WebElement> size1 = driver.findElements(By.xpath("//ion-picker-column[3]/div/button"));
	int size = size1.size();
  System.out.println(size);
  
	for( int i=1;i<=size;i++)
	{
		if(yr1==2023)
		{	
		}
		else if(yr1>2023)	
			{
				while(true)
				{
					try{
						driver.findElement(By.xpath("//ion-picker-column[3]/div/button[@class='picker-opt picker-opt-selected' and @opt-index='9']"));
						break;
					}
					catch(NoSuchElementException nosuchElement1) {
					int newyear=yr1-1;
					System.out.println(newyear);
					String ny = Integer.toString(newyear);
					Thread.sleep(1000);
					WebElement click = driver.findElement(By.xpath("//button[contains(text(),'"+ny+"')]"));
					click.click();
					yr1--;
					}
				}
			}
	}
	
	Thread.sleep(2000);
	 String month1 = driver.findElement(By.xpath("(//button[@class='picker-opt picker-opt-selected'])[2]")).getText().toString();
//	int mo1=Integer.parseInt(month1);
 List<WebElement> monsize = driver.findElements(By.xpath("//ion-picker-column[2]/div/button"));
	int monthsize = monsize.size();
 System.out.println(monthsize);
 
	for( int i=1;i<=monthsize;i++)
	{
		if(month1.equals("Jun"))
		{	
		}
		else 	
			{
				while(true)
				{
					try{
						driver.findElement(By.xpath("//ion-picker-column[2]/div/button[@class='picker-opt picker-opt-selected' and @opt-index='5']"));
						break;
					}
					catch(NoSuchElementException nosuchElement1) {
					for(int j=4;j<=12;i++)
					{
						driver.findElement(By.xpath("//ion-picker-column[2]/div/button[@opt-index='"+j+"']")).click();
						
					}
					}
				}
			}
	}
	
	/*waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[3]/div/button[10]")));
	WebElement year = driver.findElement(By.xpath("//ion-picker-column[3]/div/button[10]"));
	javascripthelper.JavaScriptHelper(driver);
    //javascripthelper.
    //waithelper.waitForElement(driver, 2000, year);
   // year.click();
    
    waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[2]/div/button[4]")));
	WebElement month = driver.findElement(By.xpath("//ion-picker-column[2]/div/button[4]"));
	javascripthelper.scrollIntoView(month);
    waithelper.waitForElement(driver, 2000, month);
    month.click();
    
    waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//ion-picker-column[1]/div/button[20]")));
	WebElement day = driver.findElement(By.xpath("//ion-picker-column[1]/div/button[20]"));
	javascripthelper.scrollIntoView(day);
    waithelper.waitForElement(driver, 2000, day);
    day.click();
	*/
	//EffectiveDateDoneButton
	Thread.sleep(1500);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton());
	WebElement done = bankRecon_ReconFormatObj.bankRecon_ReconFormat_EffectiveDateDoneButton()  ;
	clicksAndActionHelper.clickOnElement(done);  
    Thread.sleep(2000);
    
	//AllowValueDate
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(bankRecon_ReconFormatTestDataType.AllowValueDate);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AllowValueDate().sendKeys(Keys.ENTER); 
	 Thread.sleep(1000);
	//SummaryLineToBeSkipped
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(bankRecon_ReconFormatTestDataType.SummaryLineToBeSkipped);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_SummaryLineToBeSkipped().sendKeys(Keys.ENTER);       
	//FileNamePrefix
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().click();  
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(bankRecon_ReconFormatTestDataType.FileNamePrefix);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileNamePrefix().sendKeys(Keys.ENTER);       
													 
   
	 }
	   

	 @Then("^fill the Bank Reconciliation PlaceHolder$")
	 public void fill_the_bank_reconciliation_placeholder() throws InterruptedException {
	 //PlaceHolderInFile
	 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder());
	 bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolder().click();  
	  
	//PlaceHolderInFile
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile().click();  
	
	//AccountNo
	Thread.sleep(1500);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AccountNo_RadioButton().click();
	
	//AddButton
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Action_AddButton().click(); 
	
	//PlaceHolderInFile second
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFilesecond().click();  
		
	
	

	//ClosingBalance__RadioButton
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_ClosingBalance_RadioButton().click(); 
		
	//AddButton
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton());
	bankRecon_ReconFormatObj.bankRecon_AsOnDateReconFormat_Action_AddButton().click(); 
	
	
	
	
	Thread.sleep(2000);
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoRow);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Row_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoColumn);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Column_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoLength);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_Length_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AccNoPosition);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_StartingPosition_TextBox().sendKeys(Keys.ENTER);
	
	
	
	
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateRow);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateRow_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateColumn);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateColumn_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDateLength);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateLength_TextBox().sendKeys(Keys.ENTER);
	
	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox());
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().click();
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.AsOnDatePosition);
	bankRecon_ReconFormatObj.bankRecon_ReconFormat_AsOnDateStartingPosition_TextBox().sendKeys(Keys.ENTER);	
	
	//PlaceHolderInFile Thrid
		javascripthelper.JavaScriptHelper(driver);
	    javascripthelper.scrollIntoView(bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
	    Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFileThird().click();  
			
		//AsOnDate_RadioButton
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_PlaceHolderInFile_AsOnDate_RadioButton().click(); 
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceRow);
		bankRecon_ReconFormatObj.bankRecon_ReconFormatAsOnDate_ClosingBalanceRow_TextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceColumn);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceColumn_TextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalanceLength);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceLength_TextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().sendKeys(bankRecon_ReconFormatTestDataType.ClosingBalancePosition);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_ClosingBalanceStartingPosition_TextBox().sendKeys(Keys.ENTER);	
 }  

	    @Then("^File Data matching rule$")
	    public void file_data_matching_rule() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileName);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
		
	 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPoint);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataType);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(bankRecon_ReconFormatTestDataType.DateFormate);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLength);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.Position);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
	    	
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePadding);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(bankRecon_ReconFormatTestDataType.MatchCondition);
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);
	    
	    
	 }
	    @Then("^click back button$")
	    public void click_back_button() throws Throwable {
	    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton());
		bankRecon_ReconFormatObj.bankRecon_ReconFormat_BackButton().click();    
	    }
	    
	    @Then("^File Transaction Data matching rule$")
	    public void file_transaction_data_matching_rule() throws Throwable {
		    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
			
		 waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(bankRecon_ReconFormatTestDataType.DateFormateTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DateFormate().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.Position);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
		    	
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePadding().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionTrans);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchCondition().sendKeys(Keys.ENTER);	
	      
	    }
	    @Then("^File Deposit Data matching rule$")
	    public void file_deposit_data_matching_rule() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
			
		    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.PositionDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionDepo);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(bankRecon_ReconFormatTestDataType.TranspositionCondition);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_TranspositionCondition().sendKeys(Keys.ENTER);
			   
	    }
	    @Then("^File Withdrawals Data matching rule$")
	    public void file_withdrawals_data_matching_rule() throws Throwable {
	    	waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(bankRecon_ReconFormatTestDataType.FileNameWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FileName().sendKeys(Keys.ENTER);
			
		    waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(bankRecon_ReconFormatTestDataType.SystemDataPointWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_SystemDataPoint().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(bankRecon_ReconFormatTestDataType.DataTypeWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_DataType().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(bankRecon_ReconFormatTestDataType.FixedLengthWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_FixedLength().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(bankRecon_ReconFormatTestDataType.PositionWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_Position().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(bankRecon_ReconFormatTestDataType.BlankSpacePaddingWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_BlankSpacePaddingNum().sendKeys(Keys.ENTER);
			
			waithelper.waitForElement(driver, 3000, bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum());
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().click();
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(bankRecon_ReconFormatTestDataType.MatchConditionWith);
			bankRecon_ReconFormatObj.bankRecon_ReconFormat_MatchConditionNum().sendKeys(Keys.ENTER);
			 
	    }
	    
}
