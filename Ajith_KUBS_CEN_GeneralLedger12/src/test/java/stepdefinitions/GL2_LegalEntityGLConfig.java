package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.GL2_LegalEntityGLConfigObj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.GL2_LegalEntityGLConfigTestDataType;

public class GL2_LegalEntityGLConfig extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\GLTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"GL2TestData","Data Set ID");
	private Map<String, String> testData;
	GL2_LegalEntityGLConfigObj gL2_LegalEntityGLConfigObj = new GL2_LegalEntityGLConfigObj(driver);
	GL2_LegalEntityGLConfigTestDataType gL2_LegalEntityGLConfigTestDataType = jsonReader
			.getLegalEntityGLConfigByName("Maker");
	 @Given("^Navigate as a Reviewer for GL2$")
	    public void navigate_as_a_reviewer_for_gl2() throws Throwable {
		 kubsLogin = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer(testData.get("Reviewer ID"));
			//Thread.sleep(1000);
	    }
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
		for (int i = 0; i <30; i++) {
			try {
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_AddButton().click();
				break;
			} catch (Exception e) {
				if (i==29) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

	}
	 @And("^Click First record Action icon for GL2$")
	    public void click_first_record_action_icon_for_gl2() throws Throwable {
		 String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testData.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
	 @And("^Give Remark and Submit for GL2$")
	    public void give_remark_and_submit_for_gl2() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
			checkerObj.checkerRemarks().sendKeys(testData.get("Remark"));
			//waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
			for (int i = 0; i <200; i++) {
				try {
					checkerObj.checkersubmitButton().click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			
			waithelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
			String Text = checkerObj.Popup_status().getText();
			System.out.println("Checker status: " + Text);
			Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	    }
	 @And("^Claim the Record in Checker for GL2$")
	    public void claim_the_record_in_checker_for_gl2() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
					String before_xpath = "//span[contains(text(),'";
					String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
					for (int i = 0; i <200; i++) {
						try {
							
							driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath_claim)).click();
							break;
						} catch (Exception e) {
							if (i==199) {
								Assert.fail(e.getMessage());
							}
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.checker_alert_close(),30, 2);
					clickAndActionHelper.moveToElement(checkerObj.checker_alert_close());
					clickAndActionHelper.clickOnElement(checkerObj.checker_alert_close());
	    }
	@And("^User Update the test data set id to Create a Ledger at entity Level$")
    public void user_update_the_test_data_set_id_to_create_a_ledger_at_entity_level() throws Throwable {
         testData = excelData.getTestdata("KUBS_GL2_UAT_001_001_01_D1");
    }
	@And("^User Update the data set id to approve Ledger at entity level in Reviewer or Checker$")
    public void user_update_the_data_set_id_to_approve_ledger_at_entity_level_in_reviewer_or_checker() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_001_001_02_D1");
    }
	@And("^User select the cash GL$")
    public void user_select_the_cash_gl() throws Throwable {
		// CashGL
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL(), 5, 500);
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().click();
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL()
						.sendKeys(testData.get("CashGL"));
				for (int i = 0; i <300; i++) {
					try {
						driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("CashGL")+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==299) {
							Assert.fail(e.getMessage());
						}
					}
				}
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().sendKeys(Keys.ENTER);

    }

    @And("^User Select the Cheque GL$")
    public void user_select_the_cheque_gl() throws Throwable {
    	// GLCheck
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck()
    			.sendKeys(testData.get("GLCheque"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("GLCheque")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Inter branch GL$")
    public void user_select_the_inter_branch_gl() throws Throwable {
    	// InterBranchGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL()
    					.sendKeys(testData.get("InterBranch GL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("InterBranch GL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Position GL$")
    public void user_select_the_position_gl() throws Throwable {
    	// PositionGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL()
    					.sendKeys(testData.get("PositionGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PositionGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the PL Exchange Gain GL$")
    public void user_select_the_pl_exchange_gain_gl() throws Throwable {
    	// PLExchangeGainGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL()
    					.sendKeys(testData.get("PLExchangeGainGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PLExchangeGainGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the PL Exchange Loss GL$")
    public void user_select_the_pl_exchange_loss_gl() throws Throwable {
    	// PLExchangeLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL()
    					.sendKeys(testData.get("PLExchangeLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PLExchangeLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Profit GL$")
    public void user_select_the_revaluation_profit_gl() throws Throwable {
    	// RevaluationProfitGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL()
    					.sendKeys(testData.get("RevaluationProfitGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationProfitGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Loss GL$")
    public void user_select_the_revaluation_loss_gl() throws Throwable {
    	// RevaluationLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL()
    					.sendKeys(testData.get("RevaluationLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Notional Profit GL$")
    public void user_select_the_revaluation_notional_profit_gl() throws Throwable {
    	// RevaluationNotionalProfitGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL()
    					.sendKeys(testData.get("RevaluationNotionalProfitGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationNotionalProfitGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Notional Loss GL$")
    public void user_select_the_revaluation_notional_loss_gl() throws Throwable {
    	// RevaluationNotionalLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL()
    					.sendKeys(testData.get("RevaluationNotionalLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationNotionalLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().sendKeys(Keys.ENTER);

    }

	@Then("^save the Legal Entity GL Configuration record$")
	public void save_the_legal_entity_gl_configuration_record() {
		waithelper.waitForElement(driver, 2000, gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save());
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save().click();
	}
	@And("^Store the Referance Id and Open the Record for GL2 records$")
    public void store_the_referance_id_and_open_the_record_for_gl2_records() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2LegalEntity_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.GL2LegalEntity_ReferanceId().getText();
		excelData.updateTestData(testData.get("Data Set ID"),"Reference ID", Referance_id);
		System.out.println(Referance_id);
		waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2LegalEntity_ActionButton(), 30, 2);
		accSetupObj.GL2LegalEntity_ActionButton().click();
    }
	@Then("^Click submit button and Enter Remark submit it for GL2 Records$")
    public void click_submit_button_and_enter_remark_submit_it_for_gl2_records() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testData.get("Remark"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		
		for (int i = 0; i <200; i++) {
			try {
				
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30, 2);
		String reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData(testData.get("Data Set ID"),"Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }

	}
