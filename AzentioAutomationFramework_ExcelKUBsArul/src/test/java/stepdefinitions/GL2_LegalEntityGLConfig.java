package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.GL2_LegalEntityGLConfigObj;
import resources.BaseClass;
import testDataType.GL2_LegalEntityGLConfigTestDataType;

public class GL2_LegalEntityGLConfig extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();

	GL2_LegalEntityGLConfigObj gL2_LegalEntityGLConfigObj = new GL2_LegalEntityGLConfigObj(driver);
	GL2_LegalEntityGLConfigTestDataType gL2_LegalEntityGLConfigTestDataType = jsonReader
			.getLegalEntityGLConfigByName("Maker");

	@Then("^Click on General ledger configuration$")
	public void click_on_general_ledger_configuration() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_Generalledgerconfiguration(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_Generalledgerconfiguration().click();

	}

	@Then("^Click on Legal Entity GL Configuration Eye Icon$")
	public void click_on_legal_entity_gl_configuration_eye_icon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_EyeIcon(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_EyeIcon().click();

	}

	@Then("^Click on Legal Entity GL Configuration Add button$")
	public void click_on_legal_entity_gl_configuration_add_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_AddButton(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_AddButton().click();

	}

	@Then("^Fill Legal Entity GL Configuration fields$")
	public void fill_legal_entity_gl_configuration_fields() {
		// CashGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.CashGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().sendKeys(Keys.ENTER);

		// GLCheck
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.GLCheck);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().sendKeys(Keys.ENTER);

		// InterBranchGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.InterBranchGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().sendKeys(Keys.ENTER);

		// PositionGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.PositionGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().sendKeys(Keys.ENTER);

		// PLExchangeGainGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.PLExchangeGainGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().sendKeys(Keys.ENTER);

		// PLExchangeLossGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.PLExchangeLossGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().sendKeys(Keys.ENTER);

		// RevaluationProfitGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.RevaluationProfitGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().sendKeys(Keys.ENTER);

		// RevaluationLossGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.RevaluationLossGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().sendKeys(Keys.ENTER);

		// RevaluationNotionalProfitGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.RevaluationNotionalProfitGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().sendKeys(Keys.ENTER);

		// RevaluationNotionalLossGL
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().click();
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL()
				.sendKeys(gL2_LegalEntityGLConfigTestDataType.RevaluationNotionalLossGL);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().sendKeys(Keys.ENTER);

	}

	@Then("^save the Legal Entity GL Configuration record$")
	public void save_the_legal_entity_gl_configuration_record() {
		waithelper.waitForElement(driver, 2000, gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save());
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save().click();
	}
}
