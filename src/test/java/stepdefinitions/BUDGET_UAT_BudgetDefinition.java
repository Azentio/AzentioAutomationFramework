package stepdefinitions;

import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;
import resources.BaseClass;

public class BUDGET_UAT_BudgetDefinition extends BaseClass {
	WebDriver driver=BaseClass.driver;
	KUBS_Login login=new KUBS_Login(driver);
	String user="Maker";
	ConfigFileReader config=new ConfigFileReader();
	@Given("^navigate to UAT environment and login as a maker and choose finance option$")
    public void navigate_to_uat_environment_and_login_as_a_maker_and_choose_finance_option() throws InterruptedException{
		driver.get(config.getApplicationUATUrl());
		login.loginToAzentioAppUAT(user);
    }


}
