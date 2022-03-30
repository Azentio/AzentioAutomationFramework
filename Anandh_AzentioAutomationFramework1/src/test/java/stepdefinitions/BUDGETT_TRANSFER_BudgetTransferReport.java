package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import helper.BrowserHelper;
import helper.JavascriptHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;

public class BUDGETT_TRANSFER_BudgetTransferReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	Map<String, String> budgetData = new HashMap<>();
	BrowserHelper browserHelper = new BrowserHelper(driver);

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

	@And("^click on Transfer of budget details list report$")
	public void click_on_transfer_of_budget_details_list_report() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		javascriptHelper.scrollIntoView(budgetTransferObj.transferbudgetDetailsReportTempView());
		budgetTransferObj.transferbudgetDetailsReportTempView().click();
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
