package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import pageobjects.KUBS_FixedAsssetTransferObj;
import resources.BaseClass;

public class KUBS_FixedAssetAssetTransferSteps extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_FixedAsssetTransferObj fixedAssetTransferObj = new KUBS_FixedAsssetTransferObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Map<String, String> assetTransferTestData = new HashMap<>();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);

	@And("^get the newly created asset reference number for asset tansfer$")
	public void get_the_newly_created_asset_reference_number_for_asset_tansfer() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetTransferObj.assetCreationNewAssetReferenceNumber());
		assetTransferTestData.put("NewAssetReferenceNumber",
				fixedAssetTransferObj.assetCreationNewAssetReferenceNumber().getText());
		System.out.println(
				"Asset Reference Number for asset Transfer " + assetTransferTestData.get("NewAssetReferenceNumber"));
	}

	@And("^click on view button in asset transfer module$")
	public void click_on_view_button_in_asset_transfer_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 50; i++) {
			try {
				javascriptHelper.scrollIntoView(fixedAssetTransferObj.fixedAssetAssetTransferViewIcon());
				fixedAssetTransferObj.fixedAssetAssetTransferViewIcon().click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}

	}

	@And("^click on add button in asset transfer module$")
	public void click_on_add_button_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetTransferObj.fixedAssetTransferAddButton());
		clicksAndActionsHelper.moveToElement(fixedAssetTransferObj.fixedAssetTransferAddButton());
		clicksAndActionsHelper.clickOnElement(fixedAssetTransferObj.fixedAssetTransferAddButton());
	}

	@And("^enter the asset reference number in asset transfer module$")
	public void enter_the_asset_reference_number_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetTransferObj.fixedAssetAssetTransferAssetReferenceNumber());
		fixedAssetTransferObj.fixedAssetAssetTransferAssetReferenceNumber().click();
		fixedAssetTransferObj.fixedAssetAssetTransferAssetReferenceNumber()
				.sendKeys(assetTransferTestData.get("NewAssetReferenceNumber"));
		fixedAssetTransferObj.fixedAssetAssetTransferAssetReferenceNumber().sendKeys(Keys.DOWN);
		fixedAssetTransferObj.fixedAssetAssetTransferAssetReferenceNumber().sendKeys(Keys.ENTER);
	}

	@And("^enter the new branch in asset transfer module$")
	public void enter_the_new_branch_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetTransferObj.fixedAssetAssetTransferNewBranch());
		fixedAssetTransferObj.fixedAssetAssetTransferNewBranch().click();
		fixedAssetTransferObj.fixedAssetAssetTransferNewBranch().sendKeys(Keys.DOWN);
		fixedAssetTransferObj.fixedAssetAssetTransferNewBranch().sendKeys(Keys.ENTER);
	}

	@And("^choose tarnsfer as yes in asset transfer module$")
	public void choose_tarnsfer_as_yes_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetTransferObj.fixedAssetAssetTransferTransDropdown());
		fixedAssetTransferObj.fixedAssetAssetTransferTransDropdown().click();
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetTransferObj.fixedAssetTransferYesOption());
		clicksAndActionsHelper.moveToElement(fixedAssetTransferObj.fixedAssetTransferYesOption());
		clicksAndActionsHelper.clickUsingActionClass(fixedAssetTransferObj.fixedAssetTransferYesOption(),
				fixedAssetTransferObj.fixedAssetTransferYesOption());
	}

	@And("^click on save button in asset transfer module$")
	public void click_on_save_button_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetTransferObj.assetTransferSaveButton());
		fixedAssetTransferObj.assetTransferSaveButton().click();
	}

	@And("^click on temp view in asset transfer module$")
	public void click_on_temp_view_in_asset_transfer_module() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetTransferObj.fixedAssetTransferTempView());
		for (int i = 0; i <= 50; i++) {
			try {
				fixedAssetTransferObj.fixedAssetTransferTempView().click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
}
