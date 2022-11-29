package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_ContractReportPageObj {
	WebDriver driver;
       public ACCOUNTSPAYABLE_ContractReportPageObj(WebDriver driver)
       {
    	   this.driver=driver;
    	   PageFactory.initElements(driver, this);
       }
       @FindBy(xpath="//ion-label[contains(text(),'Reports')]")
       private WebElement report_Report;
       public WebElement reportReortMainMenu()
       {
    	   return report_Report;
       }
       @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/contract-report']")
       private WebElement contractReport_tempView;
       public WebElement contractReportTempView()
       {
    	   return contractReport_tempView;
       }
       @FindBy(xpath="//ion-col[1]//input")
       private WebElement contractReport_BpName;
       public WebElement contraxctReportBpName()
       {
    	   return contractReport_BpName;
       }
       @FindBy(xpath="//span[@class='input-calendar']")
       private WebElement contractReport_inputCalendat;
       public WebElement contractReportCalendar()
       {
    	   return contractReport_inputCalendat;
       }
       @FindBy(xpath="//ion-col[3]//input")
       private WebElement contractReport_ContratSTatus;
       public WebElement contractReportContractStatus()
       {
    	   return contractReport_ContratSTatus;
       }
       @FindBy(xpath="//a[contains(text(),'View')]")
       private WebElement contractReport_ViewButton;
       public WebElement contractReportViewButton()
       {
    	   return contractReport_ViewButton;
       }
       @FindBy(xpath="//tbody/tr[2]/td[7]/input[1]")
       private WebElement contractReport_NextRecordButton;
       public WebElement contractReportNextButton()
       {
    	   return contractReport_NextRecordButton;
       }
       @FindBy(xpath="//button[@aria-label='Next month']")
       private WebElement contractReport_NextMonthButton;
       public WebElement contractReportNextMonthButton()
       {
    	   return contractReport_NextMonthButton;
       }
       @FindBy(xpath="//div[contains(text(),'Agency-8-52-28022022')]")
       private WebElement contractReport_verifyContractNumber;
       public WebElement verifyContractNumber()
       {
    	   return contractReport_verifyContractNumber;
       }
       
}
