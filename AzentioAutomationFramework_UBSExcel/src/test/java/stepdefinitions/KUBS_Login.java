package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
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

	KUBS_LoginObj login;
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	Map<String, String> ulsLoginTestData = new HashMap<>();
	ExcelData excelReader = new ExcelData(excelPath, "KUBS_LoginCredentials", "Stage");
	ConfigFileReader configFileReader = new ConfigFileReader();

	public KUBS_Login(WebDriver driver) {
		this.driver = driver;
	}

	public void loginToAzentioAppByMaker() throws InterruptedException {
		for (int i = 0; i <= 8; i++) {
			try {
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
				driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
				login.Login_signIn().click();

				waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 15, 1);
				Assert.assertTrue(login.Login_loginStatus().isDisplayed());
				break;
			} catch (Exception e) {
				if (i != 8) {
					driver.get(configFileReader.getApplicationUrl());
				}
				if (i == 8) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, makerobj.kubsFinaceOption(), 60, 1);
		clicksAndActionsHelper.moveToElement(makerobj.kubsFinaceOption());
		clicksAndActionsHelper.clickOnElement(makerobj.kubsFinaceOption());
		for (int j = 0; j <= 300; j++) {
			try {
				if (j > 100) {
					clicksAndActionsHelper.moveToElement(makerobj.FinanceOption());
					clicksAndActionsHelper.clickOnElement(makerobj.FinanceOption());
					break;
				}
			} catch (Exception e) {
				if (j == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	public void logintoAzentioappReviewer(String user, String id) {
		waithelper = new WaitHelper(driver);

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
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
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
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());

		} else if (id.equals("1002436")) {
			for (int i = 0; i <= 8; i++) {
				try {
					ulsLoginTestData = excelReader.getTestdata("Reviewer4");
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_userName(), 20, 1);
					login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
					login.ubsContinueButton().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 60, 1);
					login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
					String otp = login.Login_getOtp().getText();
					driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
					waithelper.waitForElement(driver, 2000, login.Login_signIn());
					login.Login_signIn().click();

					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 15, 1);
					Assert.assertTrue(login.Login_loginStatus().isDisplayed());
					break;
				} catch (Exception e) {
					if (i != 8) {
						driver.get(configFileReader.getApplicationUrl());
					} else if (i == 8) {
						Assert.fail(e.getMessage());
					}

				}
			}
		} else if (id.equals("in00027")) {
			for (int i = 0; i <= 8; i++) {
				try {
					ulsLoginTestData = excelReader.getTestdata("Reviewer5");
					login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
					login.ubsContinueButton().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
					login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
					login.Login_signIn().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
					Assert.assertTrue(login.Login_loginStatus().isDisplayed());
					break;
				} catch (Exception e) {
					if (i != 8) {
						driver.get(configFileReader.getApplicationUrl());
					} else if (i == 8) {
						Assert.fail(e.getMessage());
					}

				}
			}
		} else if (id.equals("1002439")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer5");
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
		} else if (id.equals("twin01")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer2");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else if (id.equals("le4maker")) {
			for (int i = 0; i <= 8; i++) {
				try {
					ulsLoginTestData = excelReader.getTestdata("Reviewer7");
					login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 60, 1);
					login.ubsContinueButton().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 60, 1);
					login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
					String otp = login.Login_getOtp().getText();
					driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 60, 1);
					login.Login_signIn().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
					Assert.assertTrue(login.Login_loginStatus().isDisplayed());
					break;
				} catch (Exception e) {
					if (i != 8) {
						driver.get(configFileReader.getApplicationUrl());
					} else if (i == 8) {
						Assert.fail(e.getMessage());
					}

				}
			}
		} else if (id.equals("le4checker")) {
			for (int i = 0; i <= 8; i++) {
				try {
					ulsLoginTestData = excelReader.getTestdata("Reviewer8");
					login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 60, 1);
					login.ubsContinueButton().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 60, 1);
					login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
					String otp = login.Login_getOtp().getText();
					driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
					login.Login_signIn().click();
					waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 60, 1);
					Assert.assertTrue(login.Login_loginStatus().isDisplayed());
					break;
				} catch (Exception e) {
					if (i != 8) {
						driver.get(configFileReader.getApplicationUrl());
					} else if (i == 8) {
						Assert.fail(e.getMessage());
					}

				}
			}
		} else if (id.equals("in100245")) {
			ulsLoginTestData = excelReader.getTestdata("Reviewer9");
			login.Login_userName().sendKeys(ulsLoginTestData.get("UserID"));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.ubsContinueButton(), 20, 1);
			login.ubsContinueButton().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_passWord(), 20, 1);
			login.Login_passWord().sendKeys(ulsLoginTestData.get("Password"));
			String otp = login.Login_getOtp().getText();
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_signIn(), 20, 1);
			login.Login_signIn().click();
			waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 20, 1);
			Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else {
			System.out.println("User name not matching with json");
		}
	}

	public void loginToAzentioAppAsChecker(String user) throws InterruptedException {
		for (int i = 0; i <= 8; i++) {
			try {
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
				driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(3));
				login.Login_signIn().click();

				waithelper.waitForElementToVisibleWithFluentWait(driver, login.Login_loginStatus(), 15, 1);
				Assert.assertTrue(login.Login_loginStatus().isDisplayed());
				break;
			} catch (Exception e) {
				if (i != 8) {
					driver.get(configFileReader.getApplicationUrl());
				} else if (i == 8) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

}
