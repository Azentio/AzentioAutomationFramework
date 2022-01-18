package stepdefinitions;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;

import helper.DropDownHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;

import testDataType.BUDGET_SupplementarybudgetTestDataType;

public class BUDGET_SupplementaryBudget extends BaseClass {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	DropDownHelper dropDownHelper;
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj;
	KUBS_MakerObj bUDGET_MakerLandingPageObj;
	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;

	JsonConfig jsonReader=new JsonConfig();
	ConfigFileReader reader = new ConfigFileReader();

	@Given("^maker should navigate to the url and login with valid credentials$")
    public void maker_should_navigate_to_the_url_and_login_with_valid_credentials()  {
		
    }
	@And("^maker should navigate to the budget module$")
	public void maker_should_navigate_to_the_budget_module()  {
		
	}
	@When("^maker click on budget supplementary eye icon$")
	public void maker_click_on_budget_supplymentary_view_icon()  {
		bUDGET_MakerLandingPageObj.budget_SupplementaryBudget_SupplementaryBudgetEyeIcon().click();
	}
	@And("^click on add button on budget supplementary view page$")
	public void click_on_add_button_on_budget_supplementary_view_page()  {
		bUDGET_MakerLandingPageObj.budget_SupplementaryBudget_SupplementaryBudgetAddButton().click();
	}
	@Then("^maker should fill the required field$")
	public void maker_should_fill_the_required_field()  {
		
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetCode");
		dropDownHelper.SelectUsingVisibleText(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode(),bUDGET_SupplementaryBudgetTestDataType.BudgetCode);
		
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetYear");
		dropDownHelper.SelectUsingVisibleText(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear(),bUDGET_SupplementaryBudgetTestDataType.BudgetYear);
		
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetBranchName");
		dropDownHelper.SelectUsingVisibleText(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch(),bUDGET_SupplementaryBudgetTestDataType.BudgetBranchName);
		
		
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ExistingAmount().isDisplayed());
		
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_CurrencyDropdown().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
		
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetComments");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetComments);
		
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("BudgetApportionAmt");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount().sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt);
		
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NewAmount().click();
	}
	@Then("^maker should save the changed budget code details$")
	public void maker_should_save_the_changed_budget_code_details()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetSave().click();
	}
	
	@Then("^maker should click on note icon of the changed budget code$")
	public void maker_should_click_on_note_icon_of_the_changed_budget_code()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryBudgetEdit().click();
	}
	@And("^maker should submit the record$")
	public void maker_should_submit_the_record()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField().sendKeys("Submitted by maker");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
		
	}
	@Then("^maker should log out$")
	public void maker_should_log_out() {
		
	}

	
	
	
	@Given("^reviewer should navigate to the url and login with valid credentials$")
	public void reviewer_should_navigate_to_the_url_and_login_with_valid_credentials()  {
		
	}
	@When("^reviewer should click on notification$")
	public void reviewer_should_click_on_notification()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_NotificationButton().click();
		
	}
//	@And("^reviewer should click on edit option of changed budget code$")
//	public void reviewer_should_click_on_edit_option_of_changed_budget_code()  {
//		bUDGET_SupplementaryBudgetObj.editBudget().click();
//	}
	@Then("^reviewer should approve and submit the record$")
	public void reviewer_should_approve_and_submit_the_record()  {
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_ApproveByReviewer().click();
		
		bUDGET_SupplementaryBudgetTestDataType=jsonReader.getSupplementaryBudgetByName("ReviewerRemark");
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkByReviewer().sendKeys(bUDGET_SupplementaryBudgetTestDataType.ReviewerRemark);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByReviewer().click();
		
	}
	@Then("^reviewer should log out$")
	public void reviewer_should_log_out()  {
		
	}
}
