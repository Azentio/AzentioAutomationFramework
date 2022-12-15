package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import pageobjects.Azentio_LoginObj;
import pageobjects.Azentio_MakerObj;
import pageobjects.KUBS_LoginObj;
import pageobjects.KUBS_MakerObj;
import testDataType.KUBS_LoginTestDataType;

public class KUBS_Login {

	WebDriver driver;
	WaitHelper waithelper;
	Azentio_MakerObj makerobj;
	DropDownHelper dropdownhelper;

	JsonConfig reader = new JsonConfig();
	Azentio_LoginObj login;

	public KUBS_Login(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToAzentioApp(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new Azentio_MakerObj(driver);
		JavascriptHelper javascriptHelper=new JavascriptHelper();
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);
		waithelper.waitForElement(driver, 2000, login.Login_userName());
		login.Login_userName().sendKeys(logindata.UserName);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.PassWord);
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		while(true)
		{
			try {
				waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 2, 1);
				Assert.assertTrue(login.Login_loginStatus().isDisplayed());
				break;
			}catch(Exception e) {
				waithelper.waitForElementwithFluentwait(driver, login.Login_userName());
				login.Login_userName().click();
				waithelper.waitForElementwithFluentwait(driver, login.Login_signIn());
				login.Login_signIn().click();
				waithelper.waitForElementwithFluentwait(driver, login.Login_goButton());
				login.Login_goButton().click();
				waithelper.waitForElementwithFluentwait(driver, login.Login_passWord());
				login.Login_passWord().sendKeys(logindata.PassWord);
				String newotp = login.Login_getOtp().getText();
				driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(newotp.substring(7));
				login.Login_signIn().click();
			}
		}
		waithelper.waitForElement(driver, makerobj.kubsFinaceOption(), 2000);
		makerobj.kubsFinaceOption().click();
		
		waithelper.waitForElementwithFluentwait(driver, makerobj.FinanceOption());
//		waithelper.waitForElementToVisibleWithFluentWait(driver, makerobj.FinanceOption(), 10, 2);
		makerobj.FinanceOption().click();
		

	}

	public void loginToAzentioAppUAT(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new Azentio_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);
		waithelper.waitForElement(driver, 2000, login.Login_userName());
		login.Login_userName().sendKeys(logindata.UserName);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.UATPassword);
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		waithelper.waitForElement(driver, 2000, makerobj.kubsFinaceOption());
		makerobj.kubsFinaceOption().click();
		waithelper.waitForElement(driver, 2000, makerobj.FinanceOption());
		makerobj.FinanceOption().click();

	}

	public void logintoAzentioappReviewer(String user, String id) {
		waithelper = new WaitHelper(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);

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

		}
		else if (id.equals("1002436")) {
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
		}
		else if (id.equals("in00027")) {
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
		}else if (id.equals("1002439")) {
			login.Login_userName().sendKeys(logindata.UserName6);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord6);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}
		else if (id.equals("le4checker")) {
			login.Login_userName().sendKeys(logindata.UserName7);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord7);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}else if (id.equals("twin01")) {
			login.Login_userName().sendKeys(logindata.UserName8);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(logindata.PassWord8);
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}
		else
		{
			System.out.println("User name not matching with json");
		}
	}

	public void loginToAzentioAppAsChecker(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new Azentio_MakerObj(driver);
		
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);
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

	public void loginToUATAzentioAppAsChecker(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new Azentio_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);
		login.Login_userName().sendKeys(logindata.UserName);
		login.Login_goButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.UATPassword);
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());
	}
	public void loginToAzentioAppAsChecker2(String user) throws InterruptedException {
		waithelper=new WaitHelper(driver);
		dropdownhelper=new DropDownHelper(driver);
		makerobj=new Azentio_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new Azentio_LoginObj(driver);
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