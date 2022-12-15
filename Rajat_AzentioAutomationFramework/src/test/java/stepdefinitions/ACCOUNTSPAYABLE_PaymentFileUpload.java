package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PaymentFileUploadObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;

public class ACCOUNTSPAYABLE_PaymentFileUpload extends BaseClass {

	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_PaymentFileUploadObj paymentFileUploadObj = new ACCOUNTSPAYABLE_PaymentFileUploadObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter jsonReaderWriter= new JsonDataReaderWriter();

	@And("^click on view button near by payment file upload module$")
	public void click_on_view_button_near_by_payment_file_upload_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoViewAndClick(paymentFileUploadObj.accountsPayablePaymentFileUploadViewButton());
		// paymentFileUploadObj.accountsPayablePaymentFileUploadViewButton().click();
	}

	@And("^upload the downloaded Payment file$")
	public void upload_the_downloaded_payment_file() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		
		clickAndActionHelper.clickOnElement(paymentFileUploadObj.accountsPayableChooseFile());
		
		Thread.sleep(2000);
		String autoITPath=System.getProperty("user.dir") + "\\AutoITCodes\\FileUpload.exe";
         Runtime.getRuntime().exec(autoITPath);
      Thread.sleep(1000);
	}
	@And("^click on upload button$")
    public void click_on_upload_button() throws Throwable {
		paymentFileUploadObj.accountsPayableUploadButton().click();
    }
    @Then("^verify the reference number and payout status unsuccessfull reason is visible in screen$")
    public void verify_the_reference_number_and_payout_status_unsuccessfull_reason_is_visible_in_screen() throws Throwable {
    	//datatable-row-wrapper[1]//datatable-body-cell[9]//div
    	for(int i=1;i<=5;i++)
    	{
    		try
    		{
    	   String referenceNumber=driver.findElement(By.xpath("//datatable-row-wrapper["+i+"]//datatable-body-cell[9]//div")).getText();
    	   System.out.println("reference number is"+referenceNumber);
    	}
    		catch(NoSuchElementException e)
    		{
    			break;
    		}
    	}
    }
	@And("^save the upload file record$")
    public void save_the_upload_file_record() throws Throwable {
		paymentFileUploadObj.accountsPayablePaymentUploadSaveButton().click();
    }
	@Then("^select our record in notification records by the help of reference ID to approve the payment file in checker stage$")
	public void select_our_record_in_notification_Records_by_the_help_of_reference_id_to_approved_the_payment_file_in_checker_stage() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */
		while (true) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
				//waitHelper.waitForElement(driver, 1000, driver
					//	.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
			//	driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)).click();
			//clickAndActionHelper.clickOnElement(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				javascriptHelper.JSEClick(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				break;
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
				
				
			}
		}

}
	
}
