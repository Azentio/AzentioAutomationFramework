package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.WaitHelper;
import pageobjects.KUBS_LoginObj;
import pageobjects.KUBS_MakerObj;
import testDataType.KUBS_LoginTestDataType;

public class KUBS_Login {

	WebDriver driver;
	WaitHelper waithelper;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	
	JsonConfig reader = new JsonConfig();
	KUBS_LoginObj login;

	public KUBS_Login(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToAzentioApp(String user) throws InterruptedException {
		waithelper=new WaitHelper(driver);
		dropdownhelper=new DropDownHelper(driver);
		makerobj=new KUBS_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(logindata.UserName);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.PassWord);
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElement(driver, 3000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());
	    waithelper.waitForElement(driver, 4000, makerobj.kubsFinaceOption());
	    makerobj.kubsFinaceOption().click();
	    Thread.sleep(2000);
	    waithelper.waitForElement(driver, 4000, makerobj.FinanceOption());
	    makerobj.FinanceOption().click();
		
	}
	public void  logintoAzentioappReviewer(String user,String id)
	{
		waithelper=new WaitHelper(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);
//		if(id.equals(logindata.UserName))
//		{
//			
//		login.Login_userName().sendKeys(logindata.UserName);
//		login.Login_goButton().click();
//		waithelper.waitForElement(driver, 2000, login.Login_passWord());
//		login.Login_passWord().sendKeys(logindata.PassWord);
//		waithelper.waitForElement(driver, 2000, login.Login_signIn());
//		login.Login_signIn().click();
//		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
//		Assert.assertTrue(login.Login_loginStatus().isDisplayed());
//		}
		if (id.equals("12345")) {

			login.Login_userName().sendKeys(logindata.UserName);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord);
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else if (id.equals("1993")) {
			System.out.println("Username : " + logindata.UserName2);

			login.Login_userName().sendKeys(logindata.UserName2);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord2);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		} else if (id.equals("1992")) {
			login.Login_userName().sendKeys(logindata.UserName1);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord1);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		}else if (id.equals("in001")) {
			login.Login_userName().sendKeys(logindata.UserName3);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord3);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		}else if (id.equals("1002436")) {
			login.Login_userName().sendKeys(logindata.UserName4);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord4);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
			
		} else if (id.equals("in00027")) {
			login.Login_userName().sendKeys(logindata.UserName5);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord5);
//			String otp = login.Login_getOtp().getText();
//			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
	}else
		{
			System.out.println("User name not matching with json");
		}
	}
	public void loginToAzentioAppAsChecker(String user) throws InterruptedException {
		waithelper=new WaitHelper(driver);
		dropdownhelper=new DropDownHelper(driver);
		makerobj=new KUBS_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(logindata.UserName);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.PassWord);
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());	
	}
	public void loginToAzentioAppAsChecker2(String user) throws InterruptedException {
		waithelper=new WaitHelper(driver);
		dropdownhelper=new DropDownHelper(driver);
		makerobj=new KUBS_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(logindata.UserName1);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.PassWord1);
//		String otp = login.Login_getOtp().getText();
//		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());	
	}
	
}
