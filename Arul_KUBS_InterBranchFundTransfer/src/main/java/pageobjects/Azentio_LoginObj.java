package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Azentio_LoginObj {

	WebDriver driver;

	public Azentio_LoginObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement user_name;

	public WebElement Login_userName() {
		return user_name;

	}

	@FindBy(xpath = "//button[contains(text(),'Go')]")
	private WebElement go_button;

	public WebElement Login_goButton() {
		return go_button;

	}

	@FindBy(xpath = "//input[@id='pwd1']")
	private WebElement password;

	public WebElement Login_passWord() {
		return password;
	}

	@FindBy(xpath = "//p[contains(text(),'Otp')]")
	private WebElement get_otp;

	public WebElement Login_getOtp() {
		return get_otp;
	}

	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement sign_in;

	public WebElement Login_signIn() {
		return sign_in;
	}

	@FindBy(xpath = "//ion-title[contains(text(),'Welcome,')]")
	private WebElement login_status;

	public WebElement Login_loginStatus() {
		return login_status;
	}

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	private WebElement Forgetpass;

	public WebElement Login_Forgetpass() {
		return Forgetpass;
	}

	@FindBy(xpath = "//a[contains(text(),\"Don't have an account?\")]")
	private WebElement Createacc;

	public WebElement Login_Createacc() {
		return Createacc;
	}

}