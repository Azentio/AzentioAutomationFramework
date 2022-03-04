package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_VendorContractCreationObj {
	WebDriver driver;

	public ACCOUNTSPAYABLE_VendorContractCreationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
