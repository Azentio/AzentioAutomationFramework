package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import resources.BaseClass;

public class ShadowDom extends BaseClass {
	WebDriver driver=BaseClass.driver;
	JavascriptHelper javascripthelper=new JavascriptHelper();
	WaitHelper waithelper=new WaitHelper(driver);
	BUDGET_BudgetCreationObj o=new BUDGET_BudgetCreationObj(driver);
	/*@Then("^check alert will came or not$")
    public void check_alert_will_came_or_not() throws Throwable {
		
		//String str=(String) javascripthelper.executeScript("document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div').innerHTML");
		//String str=element.getText();
		
		WebElement element=(WebElement) javascripthelper.executeScript("document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]')");
		//String str=element.getText();
		waithelper.waitForElement(driver, 3000, element);
		String str=element.getText();
		System.out.println("Message:"+str);
		System.out.println("Message is :"+element);
    }*/
	@And("^update the budget code shadow$")
    public void update_the_budget_code_shadow() throws Throwable {
		WebElement element;
		javascripthelper.JavaScriptHelper(driver);
		o.budgetCreation_BudgetCode().clear();
		Thread.sleep(2000);
		 // waithelper.waitForElement(driver, 2000, element);
		element=(WebElement) javascripthelper.executeScript("return document.querySelector('ion-toast').shadowRoot.querySelector('div>div>div>div')");
	  
		String str=element.getText();
	    System.out.println("String message is :"+str);
    }



}
