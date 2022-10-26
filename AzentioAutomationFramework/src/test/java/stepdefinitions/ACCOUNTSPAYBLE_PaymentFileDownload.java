package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentFileDownloadObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelReader;
import testDataType.ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData;

public class ACCOUNTSPAYBLE_PaymentFileDownload extends BaseClass{
	WebDriver driver=BaseClass.driver;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj=new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLE_PaymentFileDownloadObj paymentFileDownloadObj = new ACCOUNTSPAYABLE_PaymentFileDownloadObj(driver);
	Map<String,String> testData= new HashMap<>();
	WaitHelper waitHelper=new WaitHelper(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData paymentFileDownloadUploadTestData= jsonConfig.getPaymentFileUploadDownloadTesData("Maker");
	String excelFilePath="C:\\Users\\inindc00076\\Downloads\\JAIPURBRANCH_HDFCBANK_2022-10-31_13-31-00(11).csv";
	ExcelReader excelReader ;
	
	@And("^click on arap configuration main menu$")
    public void click_on_arap_configuration_main_menu() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsArApExpenseConfiguration(), 2000, 200);
		makerObj.kubsArApExpenseConfiguration().click();
		
    }

    @And("^click on payment file generation setup sub menu$")
    public void click_on_payment_file_generation_setup_sub_menu() throws Throwable {
    	makerObj.arapExpenceConfiguration().click();
    }
    @And("^configure the file format as Bank & Account Number Wise$")
    public void configure_the_file_format_as_bank_account_number_wise() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.arapConfigBranchRecord(), 2000, 200);
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(paymentFileDownloadUploadTestData.PaymentFileAsBankAndBankAccountWise);
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.DOWN);  
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);  
    }

    @And("^verify payment file download format is in bank and accont number wise$")
    public void verify_payment_file_download_format_is_in_bank_and_accont_number_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	Assert.assertEquals("Bank & Acount Number Wise",makerObj.arapCreateFileBasis().getText() );
    }
    @And("^verify payment file download format is in Bank wise wise$")
    public void verify_payment_file_download_format_is_in_bank_wise_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	Assert.assertEquals("Bank Wise",makerObj.arapCreateFileBasis().getText() );
    }
    @And("^verify payment file download format is in Payout wise$")
    public void verify_payment_file_download_format_is_in_payout_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapCreateFileBasis(), 2000, 200);
    	//.arapCreateFileBasis().getText();
    	Assert.assertEquals("Payout Wise",makerObj.arapCreateFileBasis().getText() );
    }
    @And("^configure the file format as Bank Wise$")
    public void configure_the_file_format_as_bank_wise() throws Throwable {
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(paymentFileDownloadUploadTestData.PaymentFileAs);
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);
    	
    }
    @And("^configure the file format as Payout wise$")
    public void configure_the_file_format_as_payout_wise() throws Throwable {
    	waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.arapConfigBranchRecord(), 20, 1);
    	makerObj.arapConfigBranchRecord().click();
    	waitHelper.waitForElementVisible(makerObj.arapConfigCreateFileBasisInputBox(), 2000, 200);
    	makerObj.arapConfigCreateFileBasisInputBox().click();
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(paymentFileDownloadUploadTestData.PaymentFileAsPayoutWise);
    	makerObj.arapConfigCreateFileBasisInputBox().sendKeys(Keys.ENTER);
    }
    @And("^save the arap configure record$")
    public void save_the_arap_configure_record() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.arapConfigPaymentFileConfigSaveButton(), 2000, 200);
    	makerObj.arapConfigPaymentFileConfigSaveButton().click();
    	Thread.sleep(5000);
    }
	@And("^search the transfer as payment mode$")
    public void search_the_transfer_as_payment_mode() throws Throwable {
		manualPayoutObj.accountsPayableManualPayoutSearchPaymentMode().click();
		manualPayoutObj.accountsPayableManualPayoutSearchPaymentMode().sendKeys(paymentFileDownloadUploadTestData.PaymentMode);
		//testData.put("branchName", manualPayoutObj.accountsPayableManualPayoutBranchName().getText());
		String[] branchName=manualPayoutObj.accountsPayableManualPayoutBranchName().getText().split("-");
		testData.put("branchName", branchName[1].trim());
		System.out.println(manualPayoutObj.accountsPayableManualPayoutPayoutDate().getText());
		String[] paymentDate=manualPayoutObj.accountsPayableManualPayoutPayoutDate().getText().split("T");
		
				System.out.println(paymentDate[0]);
			String[] seperateDate=paymentDate[0].split("-");
			String year=seperateDate[0];
			testData.put("year", year);
			int day=Integer.parseInt(seperateDate[2]);

			if(day<9)
			{
				String Day=seperateDate[2].substring(1,2);
				testData.put("Day", Day);
				System.out.println(testData.get("Day"));
				
			}
			else
			{
				String Day=seperateDate[2].substring(0,2);
				testData.put("Day", Day);
				System.out.println(testData.get("Day"));
			}
			
			String month;
			switch(seperateDate[1])
			{
			
			case "01":
				month="Jan";
				testData.put("month", month);
				break;
			case "02":
				month="Feb";
				testData.put("month", month);
				break;
			case "03":
				month="Mar";
				testData.put("month", month);
				break;
			case "04":
				month="Apr";
				testData.put("month", month);
				break;
			case "05":
				month="May";
				testData.put("month", month);
				break;
			case "06":
				month="Jun";
				testData.put("month", month);
				break;
			case "07":
				month="Jul";
				testData.put("month", month);
				break;
			case "08":
				month="Aug";
				testData.put("month", month);
				break;
			case "09":
				month="Sep";
				testData.put("month", month);
				break;
			case "10":
				month="Oct";
				testData.put("month", month);
				break;
			case "11":
				month="Nov";
				testData.put("month", month);
				break;
			case "12":
				month="Dec";
				testData.put("month", month);
				break;	
			}
			System.out.println(testData.get("month"));
	}
	@And("^goto payment file download module$")
    public void goto_payment_file_download_module() throws Throwable {
		paymentFileDownloadObj.paymentFileDownloadVTempiewButton().click();
    }

    @And("^enter branch name$")
    public void enter_branch_name() throws Throwable {
    	paymentFileDownloadObj.paymentFileDownloadBranchName().click();
    	paymentFileDownloadObj.paymentFileDownloadBranchName().sendKeys(testData.get("branchName"));
    	paymentFileDownloadObj.paymentFileDownloadBranchName().sendKeys(Keys.ENTER);
    }

    @And("^click on calendar in the payment file download module$")
    public void click_on_calendar_in_the_payment_file_download_module() throws Throwable {
    	paymentFileDownloadObj.PaymentFileDownloadCalendarButton().click();
    }

    @And("^enter the payout date$")
    public void enter_the_payout_date() throws Throwable {
    	paymentFileDownloadObj.paymentFileDownloadChooseMonthAndYear().click();
    	driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("year")+"')]")).click();
    	
    	driver.findElement(By.xpath("//tr//span[contains(text(),'"+testData.get("month")+"')]")).click();
    	
    	driver.findElement(By.xpath("//tr//span[text()='"+testData.get("Day")+"']")).click();
    	
    	
     
    }
    @And("^click on go button$")
    public void click_on_go_button() throws Throwable {
    	paymentFileDownloadObj.PaymentFileDownloadGoButton().click();
    }

    @And("^download the payment file$")
    public void download_the_payment_file() throws Throwable {
    	
    	waitHelper.waitForElementVisible(paymentFileDownloadObj.paymentFileDownloadDownloadButton(), 2000, 200);
    	paymentFileDownloadObj.paymentFileDownloadDownloadButton().click();
    	Thread.sleep(2000);
    	
    }
    @And("^verify Where payment mode is Wire Transfer$")
    public void verify_where_payment_mode_is_wire_transfer() throws Throwable {
    	//CSVReader csvReader= new CSVReader();
    	String payoutReferenceNumber=excelReader.getCellData("ICICIbankLtd_HDFCBANK_2022-06-0", 7, 2);
    	System.out.println("Payout Reference number"+payoutReferenceNumber);
     
    }
    
    
}
