package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import pageobjects.FIXEDASSET_AssetReplacementObj;
import resources.BaseClass;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;

public class FIXEDASSET_AssetReplacement extends BaseClass  {
	WebDriver driver=BaseClass.driver;
	FIXEDASSET_AssetReplacementObj assetReplacementObj=new FIXEDASSET_AssetReplacementObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	JavascriptHelper javascripthelper=new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	FIXEDASSET_AssetImpairementTestDataType fixedAssetImairementTestData = jsonConfig
			.getFixedAssetTestDataByName("Maker");
	@And("^click on view button in asset replacement module$")
    public void click_on_view_button_in_seet_replacement_module() throws Throwable {
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(assetReplacementObj.fixedAssetAAssetReplacementViewButton());
		//waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetAAssetReplacementViewButton(), 2000, 100);
		assetReplacementObj.fixedAssetAAssetReplacementViewButton().click();
    }

    @And("^fill the required details$")
    public void fill_the_required_details() throws Throwable {
        
        waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetReplacementReferenceNumber(), 2000, 100);
        assetReplacementObj.fixedAssetReplacementReferenceNumber().click();
        assetReplacementObj.fixedAssetReplacementReferenceNumber().sendKeys(fixedAssetImairementTestData.writeOffReplacementAssetReferenceNumber);
        assetReplacementObj.fixedAssetReplacementReferenceNumber().sendKeys(Keys.ENTER);
        assetReplacementObj.fixedAssetReplacementItemNumber().click();
        assetReplacementObj.fixedAssetReplacementItemNumber().sendKeys(Keys.ENTER);
        assetReplacementObj.fixedAssetReplacementNewItemNumber().click();
        assetReplacementObj.fixedAssetReplacementNewItemNumber().sendKeys(fixedAssetImairementTestData.WriteOffNewAssetItemNumber);
        assetReplacementObj.fixedAssetReplacementNewDescription().click();
        assetReplacementObj.fixedAssetReplacementNewDescription().sendKeys(fixedAssetImairementTestData.WriteOffNewAssetDescription);
        
    }

    @And("^save the replacement record$")
    public void save_the_replacement_record() throws Throwable {
    	waitHelper.waitForElementVisible(assetReplacementObj.fixedAssetReplacementSaveButton(), 2000, 100);
    	assetReplacementObj.fixedAssetReplacementSaveButton().click();
    }

}
