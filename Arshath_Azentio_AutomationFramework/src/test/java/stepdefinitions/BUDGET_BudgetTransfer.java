package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetTransferObj;
import resources.BaseClass;
import resources.ExcelReader;
import testDataType.BUDGET_BudgetTransferTestDataType;

public class BUDGET_BudgetTransfer {
	public Properties prop;
	WebDriver driver = BaseClass.driver;
	BUDGET_BudgetTransferObj budgetTransferobj;

	ExcelReader reader = new ExcelReader(System.getProperty("user.dir") + "\\Test-data\\TestData.xlsx");
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_BudgetTransferTestDataType budgetTransferData = jsonReader.getBudgetTransferdata("Maker");

	@When("^User click on Configuration to select Finance$")
	public void user_click_on_configuration_to_select_finance() throws Throwable {

		budgetTransferobj = new BUDGET_BudgetTransferObj(driver);

	}

	@Then("^User click on Segement second Button$")
	public void user_click_on_segement_second_button() throws Throwable {

	}

	@Then("^User click on Budget$")
	public void user_click_on_budget() throws Throwable {

	}

	@Then("^User click on Budget Transfer eye button$")
	public void user_click_on_budget_transfer_eye_button() throws Throwable {
		budgetTransferobj.budget_BudgetTransfer_EyeButton().click();
	}

	@Then("^User click on add button$")
	public void user_click_on_add_button() throws Throwable {
		budgetTransferobj.budget_BudgetTransfer_AddButton().click();

	}

	@And("^Fill the form$")
	public void fill_the_form() throws Throwable {
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().click();

		dropDownHelper.SelectUsingVisibleText(budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown(),
				budgetTransferData.BudgetCode);
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().click();
		budgetTransferobj.budget_BudgetTransfer_BudgetCodeDropDown().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		budgetTransferobj.budget_BudgetTransfer_Branch().click();

		dropDownHelper.SelectUsingVisibleText(budgetTransferobj.budget_BudgetTransfer_Branch(),
				budgetTransferData.Branch);
		budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode().click();

		dropDownHelper.SelectUsingVisibleText(budgetTransferobj.budget_BudgetTransfer_TransferToBudgetCode(),
				budgetTransferData.TransferToBudgetCode);
		budgetTransferobj.budget_BudgetTransfer_ApportionedAmountA().sendKeys(budgetTransferData.ApportionedAmountA);
		budgetTransferobj.budget_BudgetTransfer_fromNewAmountA().click();
		budgetTransferobj.budget_BudgetTransfer_ApportionedAmountB().sendKeys(budgetTransferData.ApportionedAmountB);
		budgetTransferobj.budget_BudgetTransfer_NewAmountB().click();
	}

	@Then("^User save the form$")
	public void user_save_the_form() throws Throwable {
		budgetTransferobj.budget_BudgetTransfer_SaveButton().click();
	}

}
