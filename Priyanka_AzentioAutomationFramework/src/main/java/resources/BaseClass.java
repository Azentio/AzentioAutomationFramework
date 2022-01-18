package resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.NgWebDriver;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static WebDriver driver;
	
	public WebDriver initializeDriver( )throws IOException {
	
	ConfigFileReader configFileReader=new ConfigFileReader();
	String browserName =configFileReader.getBrowser();
	
	if(browserName.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	
	
		
	}else if(browserName.equalsIgnoreCase("ie")) {
		
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
	}
	
	driver.manage().window().maximize();
	

	
	
	return driver;
}
	public NgWebDriver getNGDriver() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (new NgWebDriver(js));
		}
		public void waitForAngularRequestToFinish() {
		try{
		getNGDriver().waitForAngularRequestsToFinish();
		}
		catch(Exception e) {
		Assert.fail("Error whicle waiting for angular request to finish:"+e.getMessage());
		}
		}

}

