package stepdefinitions.CSM;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.ExcelData;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CSM.ChargeWaiverObject;
import resources.BaseClass;

public class ChargeWaiver extends BaseClass  {
	WebDriver driver =BaseClass.driver;
	ConfigFileReader configFileRead = new ConfigFileReader();
	ChargeWaiverObject chargeWaiverObj = new ChargeWaiverObject(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper =new JavascriptHelper();
	String CSMTestDataPath = System.getProperty("user.dir") + "\\TestData\\CSMTestData.xlsx";
	ExcelData excelData = new ExcelData(CSMTestDataPath, "Charge Waiver", "Data Set ID");
		Map<String, String> testData ;
		DropDownHelper dropDownHelper = new DropDownHelper(driver);
		//ExcelData testExecution = new ExcelData(sadsTestDataPath,"TestExecution","TestCaseID");
		//Map<String, String> testExecutionData;
		

	    @And("^Get the data set id for FMA$")
	    public void get_the_data_set_id_for_fma() throws Throwable {
			testData = excelData.getTestdata("CW_008_D1");

	    }

		
		@And("^Click the accounts falg$")
		    public void click_the_accounts_falg() throws Throwable {
			waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_AccountsFlag());
			clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_AccountsFlag());
			chargeWaiverObj.chargeWaiver_AccountsFlag().click();
			
		}
	
	
	    @Then("^Click the Fixed Maturity Accounts under accounts$")
    public void click_the_fixed_maturity_accounts_under_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FixedMaturityAccount());
			clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FixedMaturityAccount());
			chargeWaiverObj.chargeWaiver_Accounts_FixedMaturityAccount().click(); 
			}
	    @And("^Click the openings under fixed maturity accounts$")
	    public void click_the_openings_under_fixed_maturity_accounts() throws Throwable {
	    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_Opening());
			clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_Opening());
			chargeWaiverObj.chargeWaiver_Accounts_FMA_Opening().click();	  
			
	    }
	   
    @Then("^Enter the currency code under FMA$")
    public void enter_the_currency_code_under_fma() throws Throwable {
    	Thread.sleep(2000);
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyCode());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyCode());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyCode().click();
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyCode().sendKeys(testData.get("Currency Code"));
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyClick().click();
		}

    @And("^Enter the GL Type under FMA$")
    public void enter_the_gl_type_under_fma() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_GLType());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_GLType());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_GLType().click();
		chargeWaiverObj.chargeWaiver_Accounts_FMA_GLType().sendKeys(testData.get("GL Type"));
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyClick().click();   
		}

    @Then("^Enter the CIF number under FMA$")
    public void enter_the_cif_number_under_fma() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_CIFNo());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_CIFNo());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CIFNo().click();
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CIFNo().sendKeys(testData.get("CIF No"));
		chargeWaiverObj.chargeWaiver_Accounts_FMA_CurrencyClick().click();    
		}
    @And("^Click the Instruction under FMA$")
    public void click_the_instruction_under_fma() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction().click();
    }

    @Then("^Enter the transfer amount under instruction$")
    public void enter_the_transfer_amount_under_instruction() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TransferAmount());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TransferAmount());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TransferAmount().click();
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TransferAmount().sendKeys(testData.get("TranferAmount"));
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType_Click().click();  
    }
  
    @And("^Enter the transaction type under instruction$")
    public void enter_the_transaction_type_under_instruction() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType().click();
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType().sendKeys(testData.get("Trx Type"));
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_TrxType_Click().click();  
    }   

    @Then("^Save the FMA record$")
    public void save_the_fma_record() throws Throwable {
    	waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_SaveButton());
		clickAndActionHelper.moveToElement(chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_SaveButton());
		chargeWaiverObj.chargeWaiver_Accounts_FMA_Instruction_SaveButton().click();
    }
  
       @And("^Validate the charges amount is waived$")
    public void validate_the_charges_amount_is_waived() throws Throwable {
    }
       
       
       
       ////********Checking on the waiver for the reversal trx charges*****************///
       @And("^Click the parameter under CSM param$")
       public void click_the_parameter_under_csm_param() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMParam_Parameter_Flag());
   		clickAndActionHelper.moveToElement(chargeWaiverObj.CSMParam_Parameter_Flag());
   		chargeWaiverObj.CSMParam_Parameter_Flag().click();
    	  
       }
       
       @Then("^Click the system parameter under parameter$")
       public void click_the_system_parameter_under_parameter() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMParam_System_Parameter_Flag());
      		clickAndActionHelper.moveToElement(chargeWaiverObj.CSMParam_System_Parameter_Flag());
      		chargeWaiverObj.CSMParam_System_Parameter_Flag().click();
      		}
       @And("^Click the reason under system parameter$")
       public void click_the_reason_under_system_parameter() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMParam_System_Parameter_Reason());
     		clickAndActionHelper.moveToElement(chargeWaiverObj.CSMParam_System_Parameter_Reason());
     		chargeWaiverObj.CSMParam_System_Parameter_Reason().click();
     		}

       @Then("^Click the update after approval under the reason$")
       public void click_the_update_after_approval_under_the_reason() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMParam_System_Parameter_Reason_UpdateAfterApproval());
    		clickAndActionHelper.moveToElement(chargeWaiverObj.CSMParam_System_Parameter_Reason_UpdateAfterApproval());
    		chargeWaiverObj.CSMParam_System_Parameter_Reason_UpdateAfterApproval().click();
    		}

       @And("^Enter the transaction code and select the record$")
       public void enter_the_transaction_code_and_select_the_record() throws Throwable {
    	  waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_Code());
    	  clickAndActionHelper.moveToElement(chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_Code());
    	  chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_Code().click();
    	  chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_Code().sendKeys(testData.get("Reason Code"),Keys.ENTER);
    	  for (int i = 0; i <200; i++) {
			
				try {
					
					WebElement reasonCode = driver.findElement(By.xpath("//td[text()= '" +testData.get("Reason Code")+ "']"));
					clickAndActionHelper.doubleClick(reasonCode);
					break;
					}
				
    	  catch (Exception e) {
    	  
       }}
       }

       @Then("^Change the reason type as reverse under reason$")
       public void change_the_reason_type_as_reverse_under_reason() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_ReasonType());
     	  clickAndActionHelper.moveToElement(chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_ReasonType());
     	  chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_ReasonType().click();
     	 dropDownHelper.SelectUsingVisibleText(chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_ReasonType(),testData.get("Reason Type"));
       }

       @Then("^Click the update after approve button$")
       public void click_the_update_after_approve_button() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_FinalSave());
      	  clickAndActionHelper.moveToElement(chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_FinalSave());
      	  chargeWaiverObj.System_Parameter_Reason_UpdateAfterApproval_FinalSave().click();
       }

       @And("^Click the transactions under CSM$")
       public void click_the_transactions_under_csm() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_TransactionFlag());
       	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_TransactionFlag());
       	  chargeWaiverObj.CSM_TransactionFlag().click();
       }
       @Then("^Click the reverse under transactions$")
       public void click_the_reverse_under_transactions() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_Transaction_Reverse());
        	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_Transaction_Reverse());
        	  chargeWaiverObj.CSM_Transaction_Reverse().click();
       }

       @And("^Enter the transaction number and select the record$")
       public void enter_the_transaction_number_and_select_the_record() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_Transaction_Reverse_TransactionNo());
     	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_Transaction_Reverse_TransactionNo());
     	  chargeWaiverObj.CSM_Transaction_Reverse_TransactionNo().click();
     	 chargeWaiverObj.CSM_Transaction_Reverse_TransactionNo().sendKeys(testData.get("Transaction No"));
     	for (int i = 0; i <200; i++) {
			
			try{
				
				WebElement TransactionNo = driver.findElement(By.xpath("//td[text()= '" +testData.get("Transaction No")+ "']"));
				clickAndActionHelper.doubleClick(TransactionNo);
				break;
				}
			
	  catch (Exception e) {
	  
   }}
       }

       @Then("^Verify the reason is in reverse or not$")
       public void verify_the_reason_is_in_reverse_or_not() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_Transaction_Reverse_ReverseValidation());
       	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_Transaction_Reverse_ReverseValidation());
       	  chargeWaiverObj.CSM_Transaction_Reverse_ReverseValidation().isDisplayed();
       	  //Need to do the asset
       }

       @And("^Click the to reverse button under reverse$")
       public void click_the_to_reverse_button_under_reverse() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_Transaction_Reverse_ToReverse());
      	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_Transaction_Reverse_ToReverse());
      	  chargeWaiverObj.CSM_Transaction_Reverse_ToReverse().click();
       }

       @Then("^Validate the pop message as charge is waived$")
       public void validate_the_pop_message_as_charge_is_waived() throws Throwable {
      //Once issue resolve ,step of validation
       }

///**********************************CW_28**********************************************///
       @And("^Click the control record under system parametee$")
       public void click_the_control_record_under_system_parametee() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.SystemParam_ControlRecord_Flag());
       	  clickAndActionHelper.moveToElement(chargeWaiverObj.SystemParam_ControlRecord_Flag());
       	  chargeWaiverObj.SystemParam_ControlRecord_Flag().click();
       }
       

       @Then("^Click the update after approval under control record$")
       public void click_the_update_after_approval_under_control_record() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval());
        	  clickAndActionHelper.moveToElement(chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval());
        	  chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval().click();
       }

       @And("^Click the other information tab under control record$")
       public void click_the_other_information_tab_under_control_record() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.SystemParam_ControlRecord_OtherInformation());
     	  clickAndActionHelper.moveToElement(chargeWaiverObj.SystemParam_ControlRecord_OtherInformation());
     	  chargeWaiverObj.SystemParam_ControlRecord_OtherInformation().click();
       }


       @Then("^Uncheck the checkbox of apply charges waiver for specific period$")
       public void uncheck_the_checkbox_of_apply_charges_waiver_for_specific_period() throws Throwable {
    	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.SystemParam_ControlRecord_ApplyChargesWaiverSpecificPeriod_Uncheck());
      	  clickAndActionHelper.moveToElement(chargeWaiverObj.SystemParam_ControlRecord_ApplyChargesWaiverSpecificPeriod_Uncheck());
      	  chargeWaiverObj.SystemParam_ControlRecord_ApplyChargesWaiverSpecificPeriod_Uncheck().click();      
      	  
       }

           @And("^Approve the record and click update after approval$")
       public void approve_the_record_and_click_update_after_approval() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval_Save());
           	  clickAndActionHelper.moveToElement(chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval_Save());
           	  chargeWaiverObj.SystemParam_ControlRecord_UpdateAfterApproval_Save().click();   
           	  }
           
           //****************CSM**********CW_28_1*****************************************************//
           @Then("^Click Chequebook request$")
           public void click_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMChequebook_Request_Flag());
            	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSMChequebook_Request_Flag());
            	  chargeWaiverObj.CSMChequebook_Request_Flag().click();
           }

           @And("^Click the maintanence under chequebook request$")
           public void click_the_maintanence_under_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMChequebook_Request_Maintenace());
         	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSMChequebook_Request_Maintenace());
         	  chargeWaiverObj.CSMChequebook_Request_Maintenace().click();
           }

           @Then("^Choose the Cheque code under chequebook request$")
           public void choose_the_cheque_code_under_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSMChequebook_Request_ChqCode());
         	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSMChequebook_Request_ChqCode());
         	  chargeWaiverObj.CSMChequebook_Request_ChqCode().click();
         	 chargeWaiverObj.CSMChequebook_Request_ChqCode().sendKeys(testData.get("ChequeCode"));
         	  }

           @And("^Enter the branch code under accounts in chequebook request$")
           public void enter_the_branch_code_under_accounts_in_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_BranchCode());
          	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_BranchCode());
          	  chargeWaiverObj.CSM_ChequebookRequest_Account_BranchCode().click();
          	 chargeWaiverObj.CSM_ChequebookRequest_Account_BranchCode().sendKeys(testData.get("Branch Code"));
           }

           @Then("^Enter the Currency code under accounts in chequebook request$")
           public void enter_the_currency_code_under_accounts_in_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_CurrencyCode());
          	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_CurrencyCode());
          	  chargeWaiverObj.CSM_ChequebookRequest_Account_CurrencyCode().click();
          	chargeWaiverObj.CSM_ChequebookRequest_Account_CurrencyCode().sendKeys(testData.get("Currency Code"),Keys.ENTER);
           }


           @And("^Enter the GL Code under accounts in chequebook request$")
           public void enter_the_gl_code_under_accounts_in_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_CurrencyCode());
           	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_GLCode());
           	  chargeWaiverObj.CSM_ChequebookRequest_Account_GLCode().click();
           	chargeWaiverObj.CSM_ChequebookRequest_Account_GLCode().sendKeys(testData.get("GL Type"),Keys.ENTER);           }

           @Then("^Enter the CIF number under accounts in chequebook request$")
           public void enter_the_cif_number_under_accounts_in_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_CIFNumber());
           	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_CIFNumber());
           	  chargeWaiverObj.CSM_ChequebookRequest_Account_CIFNumber().click();
           	chargeWaiverObj.CSM_ChequebookRequest_Account_CIFNumber().sendKeys(testData.get("CIF No"),Keys.ENTER);         
           	}

           @And("^Enter the serial number under accounts in chequebook request$")
           public void enter_the_serial_number_under_accounts_in_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_SerialNumber());
            	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_SerialNumber());
            	  chargeWaiverObj.CSM_ChequebookRequest_Account_SerialNumber().click();
            	chargeWaiverObj.CSM_ChequebookRequest_Account_SerialNumber().sendKeys(testData.get("Serial No"),Keys.ENTER); 
           }
           @Then("^Click the charges under chequebook request$")
           public void click_the_charges_under_chequebook_request() throws Throwable {
        	   waitHelper.waitForElementwithFluentwait(driver, chargeWaiverObj.CSM_ChequebookRequest_Account_ChargesDrop());
            	  clickAndActionHelper.moveToElement(chargeWaiverObj.CSM_ChequebookRequest_Account_ChargesDrop());
            	  chargeWaiverObj.CSM_ChequebookRequest_Account_ChargesDrop().click();
           }
           //Need to do the validation
           
           /////***************************************CW_29********************************************************//
     
   }
