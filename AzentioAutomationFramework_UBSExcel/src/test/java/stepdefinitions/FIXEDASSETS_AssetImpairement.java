package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetCreationObj;
import pageobjects.FIXEDASSETS_AssetSaleObj;
import pageobjects.FIXEDASSETS_AssetUndertakingObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSETS_AssetImpairement {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	FIXEDASSETS_AssetCreationObj fIXEDASSETS_AssetCreationObj = new FIXEDASSETS_AssetCreationObj(driver);
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
	FIXEDASSETS_AssetUndertakingObj fIXEDASSETS_AssetUndertakingObj = new FIXEDASSETS_AssetUndertakingObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	@When("^click on eye button of asset impairement$")
	public void click_on_eye_button_of_asset_impairement() {
		javascripthelper.JavaScriptHelper(driver);
//		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetImpairement_EyeButton());
		javascripthelper.scrollIntoView(fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetImpairement_BankRecon());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetImpairement_EyeButton().click();
	}

	@And("^click on add button for asset impairement$")
	public void click_on_add_button_for_asset_impairement() {
		// waithelper.waitForElement(driver, 3000,
		// fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetImpairement_AddButton());
		for (int i = 0; i < 30; i++) {
			try {
				fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetImpairement_AddButton().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@Then("^Save and submit the asset impairement$")
	public void save_and_submit_the_asset_creation_record() throws InterruptedException, IOException, ParseException {

		javascripthelper.JavaScriptHelper(driver);
		
		for (int i = 0; i < 30; i++) {
			try {
				driver.findElement(
						By.xpath("//page-fixed-asset-impairment-update//ion-toolbar//ion-buttons[2]//ion-button"))
						.click();
				break;
			} catch (Exception e) {

			}

		}

	}
	
}
