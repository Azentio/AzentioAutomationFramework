package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;

public class BUDGET_Test extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	KUBS_MakerObj maker = new KUBS_MakerObj(driver);
	BUDGET_BudgetCreationObj bugetcreationobj = new BUDGET_BudgetCreationObj(driver);
	JavascriptHelper javascripthelper=new JavascriptHelper();
	WaitHelper waithelper=new WaitHelper(driver);

	@And("^click on budgetConfiguration$")
	public void click_on_budgetconfiguration() throws Throwable {
		waithelper.waitForElement(driver, 3000, maker.kubsBudgetConfiguration());
		maker.kubsBudgetConfiguration().click();
	}

	@Then("^cick on action button$")
	public void cick_on_action_button() throws Throwable {
		bugetcreationobj.budgetCreation_ActionButton().click();
	}
	@And("^check the budget code$")
    public void check_the_budget_code() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);


		String script="return document.getElementsByClassName('native-input sc-ion-input-md')[1].value";
		String str=javascripthelper.executeScript(script).toString();
		
		System.out.println("Code is:"+str);
		String BudgetType=driver.findElement(By.xpath("//ion-col[3]//ng-select/div/div/div[2]/span[2]")).getText();
        System.out.println("Budget Type:"+BudgetType);
        Thread.sleep(3000);
    }


}
