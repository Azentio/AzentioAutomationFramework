package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dataProvider.ConfigFileReader;

public class BrowserLaunch  {
public static void main(String[] args) throws InterruptedException {
	//System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	ConfigFileReader config = new ConfigFileReader();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(options);
	driver.get(config.getCSMApplicationUrl());
	driver.manage().window().maximize();
	Thread.sleep(5000);
	driver.quit();
}
}
