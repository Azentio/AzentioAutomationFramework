package pageobjects.CSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChargeWaiverObject {
	WebDriver driver;
	public ChargeWaiverObject(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//td[text()='Accounts']")
	private WebElement chargeWaiverAccountsFlag;
	public WebElement chargeWaiver_AccountsFlag() {
		return chargeWaiverAccountsFlag;
	}
	@FindBy(xpath="//td[text()='Fixed Maturity Accounts']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement chargeWaiverAccountsFixedMaturityAccount;
	public WebElement chargeWaiver_Accounts_FixedMaturityAccount() {
		return chargeWaiverAccountsFixedMaturityAccount;
	}
	@FindBy(xpath="//span[text()='Opening']")
	private WebElement chargeWaiverAccountsFMAOpening;
	public WebElement chargeWaiver_Accounts_FMA_Opening() {
		return chargeWaiverAccountsFMAOpening;
	}
	@FindBy(xpath="//input[@id='lookuptxt_currencyCode_A001MT']")
	private WebElement chargeWaiverAccountsFMACurrencyCode;
	public WebElement chargeWaiver_Accounts_FMA_CurrencyCode() {
		return chargeWaiverAccountsFMACurrencyCode;
	}
	@FindBy(xpath="//input[@id='lookuptxt_glType_A001MT']")
	private WebElement chargeWaiverAccountsFMAGLType;
	public WebElement chargeWaiver_Accounts_FMA_GLType() {
		return chargeWaiverAccountsFMAGLType;
	}
	@FindBy(xpath="//input[@id='lookuptxt_cifNo_A001MT']")
	private WebElement chargeWaiverAccountsFMACIFNo;
	public WebElement chargeWaiver_Accounts_FMA_CIFNo() {
		return chargeWaiverAccountsFMACIFNo;
	}
	@FindBy(xpath="//span[text()='View Memo']//following-sibling::a")
	private WebElement chargeWaiverAccountsFMAViewMemoCloseButton;
	public WebElement chargeWaiver_Accounts_FMA_ViewMemoCloseButton() {
		return chargeWaiverAccountsFMAViewMemoCloseButton;
	}
	@FindBy(xpath="//span[text()='Instructions']")
	private WebElement chargeWaiverAccountsFMAInstruction;
	public WebElement chargeWaiver_Accounts_FMA_Instruction() {
		return chargeWaiverAccountsFMAInstruction;
	}
	@FindBy(xpath="//label[text()='Amount ']//parent::td[1]//following-sibling::td[1]//input[@id='amount_A001MT']")
	private WebElement chargeWaiverAccountsFMAInstructionTransferAmount;
	public WebElement chargeWaiver_Accounts_FMA_Instruction_TransferAmount() {
		return chargeWaiverAccountsFMAInstructionTransferAmount;
	}
	@FindBy(xpath="//input[@id='lookuptxt_openDepTrxType_A001MT']")
	private WebElement chargeWaiverAccountsFMAInstructionTrxType;
	public WebElement chargeWaiver_Accounts_FMA_Instruction_TrxType() {
		return chargeWaiverAccountsFMAInstructionTrxType;
	}
	@FindBy(xpath="//label[text()='Trx Type ']")
	private WebElement chargeWaiverAccountsFMAInstructionTrxTypeClick;
	public WebElement chargeWaiver_Accounts_FMA_Instruction_TrxType_Click() {
		return chargeWaiverAccountsFMAInstructionTrxTypeClick;
	}
	@FindBy(xpath="//button[@id='fmaSave_A001MT']")
	private WebElement chargeWaiverAccountsFMAInstructionSaveButton;
	public WebElement chargeWaiver_Accounts_FMA_Instruction_SaveButton() {
		return chargeWaiverAccountsFMAInstructionSaveButton;
	}
	@FindBy(xpath="//label[text()='Currency']")
	private WebElement chargeWaiverAccountsFMACurrencyClick;
	public WebElement chargeWaiver_Accounts_FMA_CurrencyClick() {
		return chargeWaiverAccountsFMACurrencyClick;
	}
	
	//General Accounts//
	
	@FindBy(xpath="//td[text()='General Accounts']")
	private WebElement chargeWaiverAccountsGeneralAccount;
	public WebElement chargeWaiver_Accounts_GeneralAccount() {
		return chargeWaiverAccountsGeneralAccount;
	}
	@FindBy(xpath="//span[text()='Close With Transfer']")
	private WebElement chargeWaiverAccountsGACloseWithTransfer;
	public WebElement chargeWaiver_Accounts_GA_CloseWithTransfer() {
		return chargeWaiverAccountsGACloseWithTransfer;
	}
	@FindBy(xpath="//input[@name='GL_CODE']")
	private WebElement chargeWaiverAccountsGAGLCode;
	public WebElement chargeWaiver_Accounts_GA_GLCode() {
		return chargeWaiverAccountsGAGLCode;
	}
//	@FindBy(xpath="//input[@name='CIF_SUB_NO']")
//	private WebElement chargeWaiverAccountsGACIFNo;
//	public WebElement chargeWaiver_Accounts_GA_CIFNo() {
//		return chargeWaiverAccountsGACIFNo;
//	}
//	@FindBy(xpath="//input[@name='CIF_SUB_NO']")
//	private WebElement chargeWaiverAccountsGACIFNo;
//	public WebElement chargeWaiver_Accounts_GA_CIFNo() {
//		return chargeWaiverAccountsGACIFNo;
//	}
	
	
	
	
	///////*******************************************CW_024******************************************************************////
	//CSM Param///
	
	@FindBy(xpath="//td[text()='Parameters']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement CSMParamParameterFlag;
	public WebElement CSMParam_Parameter_Flag() {
		return CSMParamParameterFlag;
	}
	@FindBy(xpath="//td[text()='System Parameters']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement CSMParamSystemParameterFlag;
	public WebElement CSMParam_System_Parameter_Flag() {
		return CSMParamSystemParameterFlag;
	}
	@FindBy(xpath="//td[text()='Reasons']//ancestor::a/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement CSMParamSystemParameterReason;
	public WebElement CSMParam_System_Parameter_Reason() {
		return CSMParamSystemParameterReason;
	}
	@FindBy(xpath="//span[text()='Update After Approve']//ancestor::a[@id='P0032MA']")
	private WebElement CSMParamSystemParameterReasonUpdateAfterApproval;
	public WebElement CSMParam_System_Parameter_Reason_UpdateAfterApproval() {
		return CSMParamSystemParameterReasonUpdateAfterApproval;
	}
	@FindBy(xpath="//input[@id='reasonsList_GridTbl_Id_P0032MA_gs_ctsreasonsVO.CODE']")
	private WebElement SystemParameterReasonUpdateAfterApprovalCode;
	public WebElement System_Parameter_Reason_UpdateAfterApproval_Code() {
		return SystemParameterReasonUpdateAfterApprovalCode;
	}
	@FindBy(xpath="//select[@id='reason_type_P0032MA']")
	private WebElement SystemParameterReasonUpdateAfterApprovalReasonType;
	public WebElement System_Parameter_Reason_UpdateAfterApproval_ReasonType() {
		return SystemParameterReasonUpdateAfterApprovalReasonType;
	}
	@FindBy(xpath="//label[text()='Update After Approve ']")
	private WebElement SystemParameterReasonUpdateAfterApprovalFinalSave;
	public WebElement System_Parameter_Reason_UpdateAfterApproval_FinalSave() {
		return SystemParameterReasonUpdateAfterApprovalFinalSave;
	}
	@FindBy(xpath="//td[text()='Transactions']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement CSMTransactionFlag;
	public WebElement CSM_TransactionFlag() {
		return CSMTransactionFlag;
	}
	@FindBy(xpath="//span[text()='Reverse']")
	private WebElement CSMTransactionReverse;
	public WebElement CSM_Transaction_Reverse() {
		return CSMTransactionReverse;
	}
	@FindBy(xpath="//input[@id='trxMgntGridTbl_Id_D001WV_gs_ctstrsVO.TRS_NO']")
	private WebElement CSMTransactionReverseTransactionNo;
	public WebElement CSM_Transaction_Reverse_TransactionNo() {
		return CSMTransactionReverseTransactionNo;
	}
	@FindBy(xpath="//select[@id='holdReason_D001WV']")
	private WebElement CSMTransactionReverseReverseValidation;
	public WebElement CSM_Transaction_Reverse_ReverseValidation() {
		return CSMTransactionReverseReverseValidation;
	}
	@FindBy(xpath="//button[@id='trxMgntToReverseBtn_D001WV']//span")
	private WebElement CSMTransactionReverseToReverse;
	public WebElement CSM_Transaction_Reverse_ToReverse() {
		return CSMTransactionReverseToReverse;
	}
	
	
	//***********************CW_028****************************************************************//
	//Checking the no waiver when New flag not checked/ Backward compatibility
	//CSM_Param
	
	
	@FindBy(xpath="//td[text()='Control Record']//ancestor::div[@id='_selenuimO001']/li/a[1]/table[1]/tbody[1]/tr[1]/td[1]/span[1]")
	private WebElement SystemParamControlRecordFlag;
	public WebElement SystemParam_ControlRecord_Flag() {
		return SystemParamControlRecordFlag;
	}
	@FindBy(xpath="//span[text()='Update After Approve']")
	private WebElement SystemParamControlRecordUpdateAfterApproval;
	public WebElement SystemParam_ControlRecord_UpdateAfterApproval() {
		return SystemParamControlRecordUpdateAfterApproval;
	}
	@FindBy(xpath="//a[text()=' Other Information ']")
	private WebElement SystemParamControlRecordOtherInformation;
	public WebElement SystemParam_ControlRecord_OtherInformation() {
		return SystemParamControlRecordOtherInformation;
	}
	@FindBy(xpath="//label[text()='Apply charges waiver for specific period ']/parent::td//preceding-sibling::td[1]")
	private WebElement SystemParamControlRecordApplyChargesWaiverSpecificPeriod_Uncheck;
	public WebElement SystemParam_ControlRecord_ApplyChargesWaiverSpecificPeriod_Uncheck() {
		return SystemParamControlRecordApplyChargesWaiverSpecificPeriod_Uncheck;
	}
	@FindBy(xpath="//label[text()='Update After Approve ']")
	private WebElement SystemParamControlRecordUpdateAfterApprovalSave;
	public WebElement SystemParam_ControlRecord_UpdateAfterApproval_Save() {
		return SystemParamControlRecordUpdateAfterApprovalSave;
	}
	//CSM
	@FindBy(xpath="//td[text()='Chequebook Request']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement CSMChequebookRequestFlag;
	public WebElement CSMChequebook_Request_Flag() {
		return CSMChequebookRequestFlag;
	}
		@FindBy(xpath="//span[text()='Maintenance']")
		private WebElement CSMChequebookRequestMaintenace;
		public WebElement CSMChequebook_Request_Maintenace() {
			return CSMChequebookRequestMaintenace;
		}
		@FindBy(xpath="//input[@id='num_of_chqbooks_Q000MT']")
		private WebElement CSMChequebookRequestNoOfChqBook;
		public WebElement CSMChequebook_Request_NoOfChqBook() {
			return CSMChequebookRequestNoOfChqBook;
		}
		@FindBy(xpath="//input[@id='lookuptxt_CHEQUE_CODE_Q000MT']")
		private WebElement CSMChequebookRequestChqCode;
		public WebElement CSMChequebook_Request_ChqCode() {
			return CSMChequebookRequestChqCode;
		}
		@FindBy(xpath="//label[text()='Design ']")
		private WebElement CSMChequebookRequestDesign;
		public WebElement CSMChequebook_Request_Design() {
			return CSMChequebookRequestDesign;
		}
		@FindBy(xpath="//input[@id='number_of_cheques_Q000MT']")
		private WebElement CSMChequebookRequestNoOfPaper;
		public WebElement CSMChequebookRequest_NoOfPaper() {
			return CSMChequebookRequestNoOfPaper;
		}
		@FindBy(xpath="////input[@id='acc_br_Q000MT']")
		private WebElement CSMChequebookRequestAccountBranchCode;
		public WebElement CSM_ChequebookRequest_Account_BranchCode() {
			return CSMChequebookRequestAccountBranchCode;
		}
		@FindBy(xpath="//input[@id='acc_cy_Q000MT']")
		private WebElement CSMChequebookRequestAccountCurrencyCode;
		public WebElement CSM_ChequebookRequest_Account_CurrencyCode() {
			return CSMChequebookRequestAccountCurrencyCode;
		}
		@FindBy(xpath="//input[@id='acc_gl_Q000MT']")
		private WebElement CSMChequebookRequestAccountGLCode;
		public WebElement CSM_ChequebookRequest_Account_GLCode() {
			return CSMChequebookRequestAccountGLCode;
		}
		@FindBy(xpath="//input[@id='acc_cif_Q000MT']")
		private WebElement CSMChequebookRequestAccountCIFNumber;
		public WebElement CSM_ChequebookRequest_Account_CIFNumber() {
			return CSMChequebookRequestAccountCIFNumber;
		}
		@FindBy(xpath="//input[@id='lookuptxt_acc_sl_Q000MT']")
		private WebElement CSMChequebookRequestAccountSerialNumber;
		public WebElement CSM_ChequebookRequest_Account_SerialNumber() {
			return CSMChequebookRequestAccountSerialNumber;
		}
		@FindBy(xpath="//span[text()='Charges']//following-sibling::span")
		private WebElement CSMChequebookRequestChargesDrop;
		public WebElement CSM_ChequebookRequest_Account_ChargesDrop() {
			return CSMChequebookRequestChargesDrop;
		}
		
		
	
}

