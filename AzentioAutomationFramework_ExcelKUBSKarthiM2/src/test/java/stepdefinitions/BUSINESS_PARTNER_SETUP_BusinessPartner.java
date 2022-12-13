package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Random;

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
import io.cucumber.java.en.When;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType;

public class BUSINESS_PARTNER_SETUP_BusinessPartner {
	
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType=jsonReader.getBusinessPartnerdata("Maker");
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@And("^user should navigate to business partner setup menu$")
	public void user_should_navigate_to_business_partner_setup_menu() {
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.bUSINESS_PARTNER_SETUP_BusinessPartner_Menu().click();
	}
	
	@When("^click on eye button of business partner$")
    public void click_on_eye_button_of_business_partner() {
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_EyeButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_EyeButton().click();;
    }
	
	@And("^click on add button of business partner$")
	public void click_on_add_button_of_business_partner() {
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();;
		
	}
	
	@And("^Fill the required fields to create a vendor$")
	public void fill_the_required_fields_to_create_a_vendor() throws InterruptedException{
		Random random = new Random();
		int randomNum=random.nextInt(1000-1)+1;
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BP_Type);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPType().sendKeys(Keys.ENTER);
		
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().click();
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BP_SubType);
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BPSubType().sendKeys(Keys.ENTER);;
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ReferenceType);;
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceType().sendKeys(Keys.ENTER);;
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumber());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumber().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ReferenceCodeNumber);;
		
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
//		String str = javascripthelper.executeScript(
//				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//				.toString();
//		System.out.println("Message:" + str);
		Thread.sleep(1000);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BirthDateCalender());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BirthDateCalender().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		driver.findElement(By.xpath("//span[text()='" + bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear  + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth + "']")).click();
		waithelper.waitForElement(driver, 2000,
 				driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "
 						+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthDate+", "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")));
 		driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "
					+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthDate+", "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")).click();
		javascripthelper.JavaScriptHelper(driver);
//		while(true)
//        {
//		try
//		{
//		
//			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
//			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
//		    break;
//		}
//		
//		catch(NoSuchElementException nosuchElement)
//		{
//			waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousMonth());
//			bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousMonth().click();
//		}
//		}
//		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth +" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthDate+", "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']/span"));
//		clicksAndActionHelper.doubleClick(BirthDate);
		
		//-------------Calender code--------------------------//
	/*	while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
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
				int year=Integer.parseInt(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"')]"));
//					clicksAndActionHelper.doubleClick(Year);
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']"));
//					clicksAndActionHelper.doubleClick(Year);
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']")).click();
					
				}
			}
		}
		
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth +" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthDate+", "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']/span")));	
		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthFullMonth +" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthDate+", "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear+"']/span"));
		clicksAndActionHelper.doubleClick(BirthDate);

*/
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Gender);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Gender().sendKeys(Keys.DOWN, Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_FirstName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_FirstName().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.FirstName+randomNum);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_MiddleName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_MiddleName().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.MiddleName);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_LastName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_LastName().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.LastName);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Profession);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Profession().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Blacklisted);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Blacklisted().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.KYC_Status);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_KYC_Status().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Remark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Remark().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Remarks);
		
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualSaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualSaveButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ID_Type);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Type().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Number());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ID_Number().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ID_Number);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountDetails());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountDetails().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BankName);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankName().sendKeys(Keys.ENTER);
		
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BranchName);
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BranchName().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AccountType);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountNumber());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountNumber().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AccountNumber);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AccountCurrency);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountCurrency().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.PaymentAccountIndicator);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartnerPaymentAccountIndicator().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AccountStatus);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AccountStatus().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountRemark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BankAccountRemark().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BankDetailRemark);
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CodeMappingDetails());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CodeMappingDetails().click();
		
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 4000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddButton().click();
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.HSN_Code);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_Code().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_CodeRemark());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HSN_CodeRemark().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.HSN_CodeRemark);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualDetails());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_IndividualDetails().click();
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Address());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Address().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().click();
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AddressType);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CorrenspondenceAddress());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CorrenspondenceAddress().click();
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine1().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AddressLine1);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine2());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine2().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AddressLine2);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine3());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_AddressLine3().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.AddressLine3);
		
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Country);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Country().sendKeys(Keys.ENTER);
		
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.State);
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_State().sendKeys(Keys.ENTER);
		
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().click();
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.City);
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_City().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ZipCode());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ZipCode().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Zipcode);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_PreviousButton());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_PreviousButton().click();
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Contact());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Contact().click();
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ContactType);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactPerson());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ContactPerson().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ContactPerson);
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CommunicationContact());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_CommunicationContact().click();
		
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Designation);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Designation().sendKeys(Keys.ENTER);
		
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile1().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Mobile1);
		
		
//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Mobile2();
		
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone1().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Phone1);
		
		
//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Phone2();
		
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email1());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email1().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.Email1);
		
		
//		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email2());
//		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Email2();
		
		
		waithelper.waitForElement(driver, 2000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton());
		Thread.sleep(1000);
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SaveButton().click();
		
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BusinessPartnerDetails());
		bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_BusinessPartnerDetails().click();
		Thread.sleep(1000);
	}

    @Then("^Save and submit the record to create vendor$")
    public void save_and_submit_the_record_to_create_vendor() throws InterruptedException, IOException, ParseException  {
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
    	
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId());
    	String id=fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId().getText();
    	jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton());
				fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_SubmitButton().click();
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	javascripthelper.JSEClick(fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RemarkField().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.RemarkByMaker);
    	
    	waithelper.waitForElement(driver, 4000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit());
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus());
    	WebElement recordstatus = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().getText();
    	System.out.println(message);
    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_RecordStatus().click();
    	String t = "";
		String ar[] = message.split(" ");
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
    }
    
    @Then("^click on search button$")
    public void click_on_search_button() {
    	waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Search());
    	bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_Search().click();
    }

    @Then("^search bp details by reference code number$")
    public void search_bp_details_by_reference_code_number()  {
    	waithelper.waitForElement(driver, 4000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumberSearch());
    	bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ReferenceCodeNumberSearch().sendKeys(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ReferenceCodeNumber);
    	
    }

    @And("^bp details should display on business partner list view$")
    public void bp_details_should_display_on_business_partner_list_view() {
    	waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails());
//    	boolean vendorDetails = bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails().isDisplayed();
    	boolean vendorDetails = bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_VendorDetails().equals(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.ReferenceCodeNumber);
    	System.out.println("Vendor details is displayed in BP Details list view - "+vendorDetails );
    }

}
