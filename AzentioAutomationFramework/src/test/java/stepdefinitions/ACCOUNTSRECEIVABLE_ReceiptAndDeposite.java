package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSRECEIVABLE_ReceiptObj;
import pageobjects.ACCOUTSRECEIVABLE_ChequeDepositeObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.ACCOUNTSRECEIVABLE_ReceiptTestData;

public class ACCOUNTSRECEIVABLE_ReceiptAndDeposite extends BaseClass {
    WebDriver driver=BaseClass.driver;
    KUBS_MakerObj makerObj=new KUBS_MakerObj(driver);
    JsonConfig jsonConfig=new JsonConfig();
    WaitHelper waitHelper=new WaitHelper(driver);
    ACCOUNTSRECEIVABLE_ReceiptObj receiptObj=new ACCOUNTSRECEIVABLE_ReceiptObj(driver);
    ACCOUTSRECEIVABLE_ChequeDepositeObj chequeDepositeObj=new ACCOUTSRECEIVABLE_ChequeDepositeObj(driver);
    Map<String,String> receiptTestData=new HashMap<>();
    JavascriptHelper javascriptHelper=new JavascriptHelper();
    ACCOUNTSRECEIVABLE_ReceiptTestData receipTTestData=jsonConfig.getAccountsReceivableReceiptTestDataByName("Maker");
    ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
    
    @And("^goto accouts Receivable module$")
    public void goto_accouts_receivable_module() throws Throwable {
    	makerObj.kubsDirectionIcon().click();
    	waitHelper.waitForElementVisible(makerObj.kubsAccountsReceivable(), 2000, 100);
    	makerObj.kubsAccountsReceivable().click();
    	

    }
    @And("^goto accouts receipt module$")
    public void goto_accouts_receipt_module() throws Throwable {
    	waitHelper.waitForElementVisible(receiptObj.accoutsReceivableReceiptViewButton(), 2000, 100);
    	receiptObj.accoutsReceivableReceiptViewButton().click();
    }
    @And("^fill the all receipt mendatory details$")
    public void fill_the_all_receipt_mendatory_details() throws Throwable {
    	waitHelper.waitForElementVisible(receiptObj.accoutsReceivableReceiptReceiptType(), 2000, 100);
    	receiptObj.accoutsReceivableReceiptReceiptType().click();
    	receiptObj.accoutsReceivableReceiptReceiptType().sendKeys(Keys.ENTER);
    	
    	receiptObj.accoutsReceivableReceiptReceiptReferenceNumber().click();
    	receiptObj.accoutsReceivableReceiptReceiptReferenceNumber().sendKeys(receipTTestData.ReceiptReferenceNumber);
    	
    	receiptObj.accoutsReceivableReceiptReceiptAmount().click();
    	receiptObj.accoutsReceivableReceiptReceiptAmount().sendKeys(receipTTestData.ReceiptAmount);
    	
    	receiptObj.accoutsReceivableReceiptBankAccount().click();
    	receiptObj.accoutsReceivableReceiptBankAccount().sendKeys(Keys.DOWN);
    	receiptObj.accoutsReceivableReceiptBankAccount().sendKeys(Keys.DOWN);
    	receiptObj.accoutsReceivableReceiptBankAccount().sendKeys(Keys.ENTER);
    	
    	receiptObj.accoutsReceivableReceiptPayerName().click();
    	receiptObj.accoutsReceivableReceiptPayerName().sendKeys(receipTTestData.ReceiptPayer);
    	
    	receiptObj.accoutsReceivableReceiptRemark().click();
    	receiptObj.accoutsReceivableReceiptRemark().sendKeys(receipTTestData.Remark);
    	
    	
    	
    }

    @And("^save the receipt record$")
    public void save_the_receipt_record() throws Throwable {
    	String bankAccountNumber=receiptObj.accoutsReceivableGetBankAccoutNumber().getText();
    	receiptTestData.put("bankAccountNumber", bankAccountNumber);
    	System.out.println("Bank account number is "+receiptTestData.get("bankAccountNumber"));
    	receiptObj.accoutsReceivableReceiptSaveButton().click();
        
    }
    
    
    @And("^goto cheque deposite module$")
    public void goto_cheque_deposite_module() throws Throwable {
    	//waitHelper.waitForElementVisible(chequeDepositeObj.AccountsReceivableChecqueDeposite(), 2000, 100);
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(chequeDepositeObj.AccountsReceivableChecqueDeposite());
    	chequeDepositeObj.AccountsReceivableChecqueDeposite().click();
        
    }

    @And("^enter the bank account number$")
    public void enter_the_bank_account_number() throws Throwable {
    	waitHelper.waitForElementVisible(chequeDepositeObj.AccountsReceivableBankAccount(), 2000, 100);
    	chequeDepositeObj.AccountsReceivableBankAccount().click();
    	chequeDepositeObj.AccountsReceivableBankAccount().sendKeys(receiptTestData.get("bankAccountNumber"));
    	chequeDepositeObj.AccountsReceivableBankAccount().sendKeys(Keys.ENTER);

    }
    
    @And("^give date of bill deposited date$")
    public void give_date_of_bill_deposited_date() throws Throwable {
    	waitHelper.waitForElementVisible(chequeDepositeObj.accountsPayableDepositeDate(), 2000, 100);
    	chequeDepositeObj.accountsPayableDepositeDate().click();
    	while(true)
    	{
    		try
    		{
    			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+receipTTestData.monthYear+"')]")));
    			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+receipTTestData.monthYear+"')]"));
    		    break;
    		}
    		catch(NoSuchElementException e)
    		{
    			chequeDepositeObj.accountsPayableDepositeNextMonth().click();	
    		}
    		
    	
    	}

		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//td[@aria-label='"+receipTTestData.month+" "+receipTTestData.day+", "+receipTTestData.year+"']/span")), 2000, 100);
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+receipTTestData.month+" "+receipTTestData.day+", "+receipTTestData.year+"']/span"));

		clickAndActionHelper.doubleClick(FinalDay);
    	
    	
    }

    @And("^click on deposite bill generation$")
    public void click_on_deposite_bill_generation() throws Throwable {
    
    	chequeDepositeObj.AccountsReceivableGenerateDepositeBill().click();
    }
    @Then("^check our bill is appeared in the list view$")
    public void check_our_bill_is_appeared_in_the_list_view() throws Throwable {
    	Thread.sleep(1000);
    	javascriptHelper.JavaScriptHelper(driver);
    	while(true)
    	{
    		try
    		{
    			 driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']"));
    		
    		break;
		}
		catch(NoSuchElementException e)
		{
			javascriptHelper.scrollIntoView(chequeDepositeObj.accountsPayableDepositeNextPage());
			javascriptHelper.JSEClick(chequeDepositeObj.accountsPayableDepositeNextPage());
			//chequeDepositeObj.accountsPayableDepositeNextPage().click();
		}
    	}
    }
    @And("^select our bill$")
    public void select_our_bill() throws Throwable {
    	Thread.sleep(1000);
    	javascriptHelper.JavaScriptHelper(driver);
    	while(true)
    	{
    		try
    		{
        driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[2]//ion-checkbox")).click();
       
    	
        String status=driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[8]/div")).getText();
        Assert.assertEquals(status, "Deposit");
        
    	break;
    		}
    		catch(NoSuchElementException e)
    		{
    			javascriptHelper.scrollIntoView(chequeDepositeObj.accountsPayableDepositeNextPage());
    			javascriptHelper.JSEClick(chequeDepositeObj.accountsPayableDepositeNextPage());
    			//chequeDepositeObj.accountsPayableDepositeNextPage().click();
    		}
	}
    	waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div")), 2000, 100);
        driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()=' "+receipTTestData.ReceiptReferenceNumber+" ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div/input")).sendKeys("Deposited");
    	}
    @And("^save the bill record$")
    public void save_the_bill_record() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(receiptObj.accoutsReceivableReceiptSaveButton());
    	receiptObj.accoutsReceivableReceiptSaveButton().click();
    	
    }
}
