package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.JsonConfig;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_LoginObj;
import resources.BaseClass;
import testDataType.KUBS_LoginTestDataType;

public class LoginTest extends BaseClass {
	WebDriver driver=BaseClass.driver;
	KUBS_LoginObj login;
	WaitHelper waithelper;
	JsonConfig json;

	@Given("^Launch the Azentio Url$")
	public void launch_the_azentio_url() throws Throwable {
		//driver = initializeDriver();
		driver.get("http://10.1.56.122:8680/kubs");
	}

	@And("^Enter the login creditintials$")
	public void enter_the_login_creditintials() throws Throwable {
		login = new KUBS_LoginObj(driver);
		waithelper = new WaitHelper(driver);
		json=new JsonConfig();
		KUBS_LoginTestDataType kubslogindata=json.getLoginCredentialsByName("Maker");
		//String userName = "1002435";
		//String PassWord = "Admin@@11";
		if (kubslogindata.UserName.equals("12345")) {
			login.Login_userName().sendKeys(kubslogindata.UserName);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(kubslogindata.PassWord);
			// login.Login_signIn().click();
			// waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
			// Assert.assertTrue(login.Login_loginStatus().isDisplayed());
		} else {
			login.Login_userName().sendKeys(kubslogindata.UserName);
			login.Login_goButton().click();
			waithelper.waitForElement(driver, 2000, login.Login_passWord());
			login.Login_passWord().sendKeys(kubslogindata.PassWord);
			String otp = login.Login_getOtp().getText();
			System.out.println(otp.substring(7));
			driver.findElement(By.xpath("//ng-otp-input/div/input[1]")).sendKeys(otp.substring(7));

		}
	}

	@Then("^Click the Signup$")
	public void click_the_signup() throws Throwable {
		login.Login_signIn().click();
	}

	@And("^Capture the Login status$")
	public void capture_the_login_status() throws Throwable {
		waithelper.waitForElement(driver, 2000, login.Login_loginStatus());
		Assert.assertTrue(login.Login_loginStatus().isDisplayed());
	}

}