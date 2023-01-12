package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.WaitHelper;
import pageobjects.KUBS_LoginObj;
import pageobjects.KUBS_MakerObj;
import resources.ExcelData;
import testDataType.KUBS_LoginTestDataType;

public class KUBS_Login {

	WebDriver driver;
	WaitHelper waithelper;
	KUBS_MakerObj makerobj;
	DropDownHelper dropdownhelper;
	ClicksAndActionsHelper clicksAndActionsHelper;

	JsonConfig reader = new JsonConfig();
	KUBS_LoginObj login;
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	Map<String, String> ulsLoginTestData = new HashMap<>();
	ExcelData excelReader = new ExcelData(excelPath, "KUBS_LoginCredentials", "Stage");

	public KUBS_Login(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToAzentioAppByMaker() throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		ulsLoginTestData = excelReader.getTestdata("Maker1");
		clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
		makerobj = new KUBS_MakerObj(driver);
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
		login.ubsContinueButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, makerobj.kubsFinaceOption(), 60, 1);
		clicksAndActionsHelper.moveToElement(makerobj.kubsFinaceOption());
		clicksAndActionsHelper.clickOnElement(makerobj.kubsFinaceOption());
		for (int i = 0; i <= 600; i++) {
			try {
				if (i > 100) {
					clicksAndActionsHelper.moveToElement(makerobj.FinanceOption());
					clicksAndActionsHelper.clickOnElement(makerobj.FinanceOption());
					break;
				}
			} catch (Exception e) {
				if (i == 600) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	public void logintoAzentioappReviewer(String user, String id) {
		waithelper = new WaitHelper(driver);
		//KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);

		if (id.equals("12345")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer1");
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_userName(), 20, 1);
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else if (id.equals("1993")) {

			ulsLoginTestData = excelReader.getTestdata("Reviewer2");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			login.ubsContinueButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		} else if (id.equals("1992")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer3");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		} else if (id.equals("1002436")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer4");
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_userName(), 20, 1);
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElement(driver, 2000, login.Login_signIn());
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 60, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		} else if (id.equals("in00027")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer5");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else if (id.equals("1002439")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer5");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else if (id.equals("twin01")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer2");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}
		else if (id.equals("le4maker")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer7");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}else if (id.equals("le4checker")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer8");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}
		else if (id.equals("in100245")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer9");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(4));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		}
		else {
			System.out.println("User name not matching with json");
		}
	}

	public void loginToAzentioAppAsChecker(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new KUBS_MakerObj(driver);
		ulsLoginTestData = excelReader.getTestdata("Checker1");
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
		login.ubsContinueButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
		String otp = login.Login_getOtp().getText();
		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();

	}

	public void loginToAzentioAppAsChecker2(String user) throws InterruptedException {
		waithelper = new WaitHelper(driver);
		dropdownhelper = new DropDownHelper(driver);
		makerobj = new KUBS_MakerObj(driver);
		KUBS_LoginTestDataType logindata = reader.getLoginCredentialsByName(user);
		login = new KUBS_LoginObj(driver);
		login.Login_userName().sendKeys(logindata.UserName1);
		login.ubsContinueButton().click();
		waithelper.waitForElement(driver, 2000, login.Login_passWord());
		login.Login_passWord().sendKeys(logindata.PassWord1);
//		String otp = login.Login_getOtp().getText();
//		driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));
		login.Login_signIn().click();
//		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
//		Assert.assertTrue(login.Login_loginStatus().isDisplayed());	
	}

}
