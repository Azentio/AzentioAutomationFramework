package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSRECEIVABLE_AppropriationObj;
import resources.BaseClass;

public class ACCOUTSRECEIVABLE_Appropriation extends BaseClass{
	
	WebDriver driver=BaseClass.driver;
	Map<String,String> creditNote=new HashMap<>();
	ACCOUNTRECEIVABLE_CreditNoteObj creditNoteObj=new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSRECEIVABLE_AppropriationObj appropriationObj=new ACCOUNTSRECEIVABLE_AppropriationObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	JavascriptHelper javaScriptHelper =new JavascriptHelper();
	@And("^get the approved credit note reference number$")
    public void get_the_approved_credit_note_reference_number() throws Throwable {
		waitHelper.waitForElementVisible(creditNoteObj.approvedCreditNoteRecord(), 2000, 100);
		String approvedCreditNote=creditNoteObj.approvedCreditNoteRecord().getText();
		creditNote.put("approvedCreditNote", approvedCreditNote);
       
    }

    @And("^goto appropriation module$")
    public void goto_appropriation_module() throws Throwable {
    	waitHelper.waitForElementVisible(appropriationObj.accountsPayableViewButton(), 2000, 200);
    	appropriationObj.accountsPayableViewButton().click();
    	
    	
       
    }

    @And("^validate the credit note approved record is not available$")
    public void validate_the_credit_note_approved_record_is_not_available() throws Throwable {
    	javaScriptHelper.JavaScriptHelper(driver);
      //Thread.sleep(1000);
      for(int i=0;i<=20;i++)
      {
    	  if(i==20)
    	  {
    		  System.out.println("Credit note reference number is not availabe in therecord field");
    	  }
    	  try
    	  {
      driver.findElement(By.xpath("//div[contains(text(),'"+creditNote.get("approvedCreditNote")+"')]"));
      break;
    	  }
    	  catch(NoSuchElementException e)
    	  {
    		  
    		  
    		  javaScriptHelper.scrollIntoView(appropriationObj.accontsReceivableNextButton());
    		  //waitHelper.waitForElementVisible(appropriationObj.accontsReceivableNextButton(), 2000, 200);
    		  appropriationObj.accontsReceivableNextButton().click();
    	  }
    	  } 
    }
}
