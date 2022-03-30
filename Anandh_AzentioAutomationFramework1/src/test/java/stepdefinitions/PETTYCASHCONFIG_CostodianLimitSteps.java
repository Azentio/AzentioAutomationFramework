package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.KUBS_MakerObj;
import pageobjects.PETTYCASHCONFIG_CostodianLimitObj;
import resources.BaseClass;

public class PETTYCASHCONFIG_CostodianLimitSteps extends BaseClass{
	WebDriver driver= BaseClass.driver;
	PETTYCASHCONFIG_CostodianLimitObj costodianLimitObj = new PETTYCASHCONFIG_CostodianLimitObj(driver);
    KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	@Then("^click on petty cash configuration module$")
    public void click_on_petty_cash_configuration_module() throws Throwable {
		makerObj.kubsPettyCashConfiguration().click();
    }

    @And("^click on costodian limit module$")
    public void click_on_costodian_limit_module() throws Throwable {
    	costodianLimitObj.pettyCashConfigCostodianLimitViewButton().click();
    }
    @And("^Enter user name in the costodian limit$")
    public void enter_user_name_in_the_costodian_limit() throws Throwable {
    	costodianLimitObj.costodianLimitUserName().click();
    	costodianLimitObj.costodianLimitUserName().sendKeys("Vikash Mhatre");
    	costodianLimitObj.costodianLimitUserName().sendKeys(Keys.ENTER);
    }

    @And("^give maximum limit$")
    public void give_maximum_limit() throws Throwable {
    	costodianLimitObj.costodianLimitMaxLimit().click();
    	costodianLimitObj.costodianLimitMaxLimit().sendKeys("0");
    	costodianLimitObj.costodianLimitMaxLimit().sendKeys(Keys.LEFT);
    	costodianLimitObj.costodianLimitMaxLimit().sendKeys(Keys.LEFT);
    	costodianLimitObj.costodianLimitMaxLimit().sendKeys("80000");

    }

    @And("^give replenish limit$")
    public void give_replenish_limit() throws Throwable {
    	costodianLimitObj.costodianLimitReplenishLimit().click();
    	costodianLimitObj.costodianLimitReplenishLimit().sendKeys("0");
    	costodianLimitObj.costodianLimitReplenishLimit().sendKeys(Keys.LEFT);
    	costodianLimitObj.costodianLimitReplenishLimit().sendKeys(Keys.LEFT);
    	costodianLimitObj.costodianLimitReplenishLimit().sendKeys("20000");
    }

    @And("^enter the currency type$")
    public void enter_the_currency_type() throws Throwable {
    	for(int i=1;i<5;i++)
    	{
    	costodianLimitObj.costodianLimitCurrencyLimit().sendKeys(Keys.DOWN);
    	}
    	costodianLimitObj.costodianLimitCurrencyLimit().sendKeys(Keys.ENTER);
    
    	
    	}

    @And("^save the petty case costodian record$")
    public void save_the_petty_case_costodian_record() throws Throwable {
    	costodianLimitObj.costodianLimitSaveButton().click();
    }

}
