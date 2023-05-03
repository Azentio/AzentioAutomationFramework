package resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigFileReader;


public class BaseClass {
	Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static WebDriver driver;
	
	public WebDriver initializeDriver( )throws IOException {
	
	ConfigFileReader configFileReader=new ConfigFileReader();
	String browserName =configFileReader.getBrowser();
	
	if(browserName.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
	 
		driver = new FirefoxDriver();
	
	
		
	}else if(browserName.equalsIgnoreCase("ie")) {
		
		driver = new InternetExplorerDriver();
		
	}
else if(browserName.equalsIgnoreCase("edge")) {
		
		driver = new EdgeDriver();
		
	}
	
	driver.manage().window().maximize();
	

	
	
	return driver;
}


}

