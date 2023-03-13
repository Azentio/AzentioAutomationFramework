package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
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
import testDataType.FIXEDASSETS_AssetRevaluationTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FIXEDASSETS_AssetRevaluation {
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
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@When("^click on eye button of asset revaluation$")
    public void click_on_eye_button_of_asset_revaluation() {
		//waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton());
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_EyeButton().click();
    }
	
	@And("^click on add button for asset revaluation$")
	public void click_on_add_button_for_asset_revaluation() {
		waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AddButton());
		fIXEDASSETS_AssetUndertakingObj.fixedAssets_AssetRevaluation_AddButton().click();
	}

}
