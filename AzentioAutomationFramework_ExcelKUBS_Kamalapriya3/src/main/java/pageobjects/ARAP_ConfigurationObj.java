package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_ConfigurationObj {
	WebDriver driver;
    public ARAP_ConfigurationObj(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/156']")
    private WebElement ARAP_Configuration_viewButton;
    public WebElement ARAPConfigurationViewButton()
    {
    	return ARAP_Configuration_viewButton;
    }
    @FindBy(xpath="//span[contains(text(),'AP_001')]/ancestor::datatable-body-cell[1]/preceding-sibling::datatable-body-cell[3]//ion-button[2]")
    private WebElement arap_ARAPRecord;
    public WebElement arapARAPRecord()
    {
    	return arap_ARAPRecord;
    }
    @FindBy(xpath="//ion-col[7]//input")
    private WebElement arap_AutoPayoutInput;
    public WebElement arapAutoPayoutInput()
    {
    	return arap_AutoPayoutInput;
    }
    @FindBy(xpath="//page-ar-ap-configuration-update//ion-toolbar//ion-buttons[2]//ion-button")
    private WebElement araPConfiguration_SaveButton;
    public WebElement arapConfigurationSaveButton()
    {
    	return araPConfiguration_SaveButton;
    }
}
