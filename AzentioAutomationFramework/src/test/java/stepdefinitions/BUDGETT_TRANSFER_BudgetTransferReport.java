package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;

public class BUDGETT_TRANSFER_BudgetTransferReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> budgetData = new HashMap<>();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	BUDGET_BudgetDefinitionUATTestDataType BudgetAndPlanningUATTestData= jsonConfig.getUATBudgetDefinitionTestData("Maker");
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	@And("^click on budget main menu$")
	public void click_on_budget_main_menu() throws Throwable {
		makerObj.kubsBudget().click();
		// budgetTransferObj
	}

	@And("^click on view button near by budget transfer menu$")
	public void click_on_view_button_near_by_budget_transfer_menu() throws Throwable {
		budgetTransferObj.budget_BudgetTransfer_EyeButton().click();
		budgetTransferObj.budgetTransferApprovedRecord().click();
	}

	@And("^get the Transfered from budget code$")
	public void get_the_transfered_from_budget_code() throws Throwable {
		System.out.println(budgetTransferObj.budgetTransferFromBudget().getText().substring(25).trim());
		String from_BudgetCode = budgetTransferObj.budgetTransferFromBudget().getText().substring(25).trim();
		budgetData.put("fromBudgetCode", from_BudgetCode);

	}

	@And("^get the Transfered to budget code$")
	public void get_the_transfered_to_budget_code() throws Throwable {
		System.out.println(budgetTransferObj.budgetTransferToBudget().getText().substring(24));
		String toBudget = budgetTransferObj.budgetTransferToBudget().getText().substring(24);
		budgetData.put("toBudget", toBudget);
	}

	@And("^get the Transfered budget amount$")
	public void get_the_transfered_budget_amount() throws Throwable {
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		String[] TransferedAmount = javascriptHelper.executeScript("return document.getElementById('trxAmt').value")
				.toString().split("[.]");
		String finalTransferedAmt = TransferedAmount[0].replace(",", "");
		System.out.println("Transfered amount is : " + finalTransferedAmt);

		budgetData.put("TransferedAmt", finalTransferedAmt);
	}
	@And("^click on report main menu$")
	public void click_on_report_main_menu() throws Throwable {
		waitHelper.waitForElementVisible(budgetTransferObj.reportReortMainMenu(), 2000, 200);
		budgetTransferObj.reportReortMainMenu().click();
	}
	@And("^click on Transfer of budget details list report$")
	public void click_on_transfer_of_budget_details_list_report() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(budgetTransferObj.transferbudgetDetailsReportTempView());
		budgetTransferObj.transferbudgetDetailsReportTempView().click();
	}
	@Then("^click on second Segment button$")
	public void click_on_second_segment_button() throws Throwable {
		kubsMakerObj.kubsDirectionIcon().click();
	}
	@And("^click on date icon$")
	public void click_on_date_icon() throws Throwable {
		budgetTransferObj.budgetTransferDateAsOn().click();
	}

	@And("^give date in report$")
	public void give_date_in_report() throws Throwable {
		while (true) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
						+ BudgetAndPlanningUATTestData.Month + " " + BudgetAndPlanningUATTestData.Year + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + BudgetAndPlanningUATTestData.Month + " "
						+ BudgetAndPlanningUATTestData.Year + "')]"));
				break;
			} catch (NoSuchElementException e) {
				budgetTransferObj.budgetTransferNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + BudgetAndPlanningUATTestData.FullMonth + " "
				+ BudgetAndPlanningUATTestData.Day + ", " + BudgetAndPlanningUATTestData.Year + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on the view button$")
	public void click_on_the_view_button() throws Throwable {
		budgetTransferObj.budgetTransferReportViewButton().click();
		Thread.sleep(1000);
	}
	@Then("^verify the transfered budget and amount is available in the transfered report$")
	public void verify_the_transfered_budget_and_amount_is_available_in_the_transfered_report() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(2000);
		int totalPage = Integer.parseInt(budgetTransferObj.budgetTransferTotalNumberofPage().getText());
		

		for (int i = 1; i <= totalPage; i++) {
			Thread.sleep(200);
			try {

				javascriptHelper.scrollIntoView(driver
						.findElement(By.xpath("//td[8]//div[text()='" + budgetData.get("fromBudgetCode") + "']")));
				driver.findElement(By.xpath("//td[8]//div[text()='" + budgetData.get("fromBudgetCode") + "']"))
						.isDisplayed();

				String[] transferedAmt = driver.findElement(By.xpath("//td[8]//div[contains(text(),'"
						+ budgetData.get("fromBudgetCode") + "')]//ancestor::td/following-sibling::td[2]//div"))
						.getText().split("[.]");

				String reportTransferAmt = transferedAmt[0].replace(",", "").trim();


				if (reportTransferAmt.equalsIgnoreCase(budgetData.get("TransferedAmt"))) {
					System.out.println("Transfer amount got matched with our report hence test case passed");
					break;
				}

			} catch (NoSuchElementException e) {
				budgetTransferObj.budgetTransferReportNextRecord().click();
			}

		}
		browserHelper.switchToParentWithChildClose();

	}
}
