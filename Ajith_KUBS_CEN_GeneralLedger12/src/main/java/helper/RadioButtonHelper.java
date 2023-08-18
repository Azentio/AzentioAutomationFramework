package helper;

import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RadioButtonHelper {
	private WebDriver driver;
	Logger Log = LogManager.getLogger(RadioButtonHelper.class.getName());

	// wait helper constrcutor
	public RadioButtonHelper(WebDriver driver) {
		this.driver = driver;
		
	}

	// RadioButton 
	public void radioButton(String element) {
		WaitHelper waithelper = new WaitHelper(driver);
		String beforexpath = "//ion-radio-group/ion-item[";
		String afterxpath = "]/ion-label";
		List<WebElement> radioitem= driver.findElements(By.xpath("//ion-radio-group/ion-item"));
		int size = radioitem.size();
//		System.out.println(size);
		for (int i = 1; i <= size ; i++) {
			if(driver.findElement(By.xpath(beforexpath+ i + afterxpath)).getText().equals(element))
			{
				String beforexpath1 = "//ion-item[";
				String afterxpath1 = "]/ion-radio";
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(beforexpath1 + i + afterxpath1)));
				driver.findElement(By.xpath(beforexpath1 + i + afterxpath1)).click();
				break;
			}
			else if(i==size){
					Assert.fail("The radio button is not present in the list.");
			}
		}
	}
      
}