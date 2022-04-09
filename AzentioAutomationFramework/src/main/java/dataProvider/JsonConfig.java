package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_ManualPayoutTestDataType;
import testDataType.ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_ReceiptTestData;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;
import testDataType.ARAP_ARandAPData;
import testDataType.ARAP_GRNCreationTestDataType;
import testDataType.AccountPayable_GrnTestDataType;
import testDataType.AccountPayable_InvoiceBookingTestDataType;
import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.AccountReceivable_AccountReceivableAdvancesTestDataType;
import testDataType.AccountReceivable_AppropriationTestDataType;
import testDataType.AccountReceivable_UpdateDepositedChequeTestDataType;
import testDataType.AccountingSetup_ChartOfAccountsDefinitionTestDataType;
import testDataType.AccountsPayable_ManualPayoutEmployeeTestDataType;
import testDataType.AccountsReceivable_AppropriationTestDataType;
import testDataType.AccountsReceivable_DebitNoteTestDataType;
import testDataType.AccountsReceivable_ReceiptsReversalsTestDataType;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;
import testDataType.ArAp_BalanceSheetReportTestDataType;
import testDataType.ArAp_EnquiryTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_CommentsFromApprover;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FIXEDASSETS_AssetRevaluationTestDataType;
import testDataType.FIXEDASSETS_AssetSaleTestDataType;
import testDataType.FIXEDASSETS_AssetUndertakingTestDataType;
import testDataType.FixedAssetTestDataType;

import testDataType.FixedAsset_AssetCategoryTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;
import testDataType.FixedAsset_AssetDeallocationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.Cancellationofcontractdatatype;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FIXEDASSET_AssetReturnTestData;
import testDataType.FinancialReporting_BalanceSheetReportTestDataType;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.FinancialReporting_TrialBalanceReportTestDataType;
import testDataType.GL1_Accounting_Setup_Data;
import testDataType.GL2_FinancialTransactionReportTestDataType;
import testDataType.GL2_JournalVoucherTestDataType;
import testDataType.GL2_JournalVoucher_AccountEntryReportTestDataType;
import testDataType.GL2_LegalEntityGLConfigTestDataType;
import testDataType.GL_ModuleTestData;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;
import testDataType.INVENTORY_EnquiryGlTestData;
import testDataType.INVENTORY_InventoryManagement_DataType;
import testDataType.INVENTORY_InventoryStockIssueTestData;
import testDataType.INVENTORY_MAINTENANCE_DenominationMasterTestDataType;
import testDataType.INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType;
import testDataType.InventoryMaintenanceTestDataType;
import testDataType.InventoryManagementTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;
import testDataType.JobScheduler_JobExecutionTestDataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.RegisterData;
import testDataType.Reports_AssetCreationCommonTestDataType;
import testDataType.Reports_PettyCashTestDataType;
import testDataType.PETTY_PettyCash_Data;
import testDataType.PettyCash_ReconciliationTestDataType;

//master
public class JsonConfig {
	ConfigFileReader configFileReader = new ConfigFileReader();

	// Users_Login
	private final String AzentioLoginDataPath = configFileReader.getJsonPath() + "KUBS_LoginDataJSON.json";
	private List<KUBS_LoginTestDataType> credentialslist;

	// Budget_RequestandAllocation
	private final String AllocationFilePath = configFileReader.getJsonPath() + "BUDGET_RequestAndAllocationJSON.json";
	private List<BUDGET_RequestAndAllocationTestDataType> AllocationList;

	private final String BudtypeFilepath = configFileReader.getJsonPath() + "BUDGET_RequestandallocationBUDTYPE.json";
	private List<BUDGET_RequestandallocationBUDTYPEDATA> BudtypeList;

	//Budget_BudgetCreation
	private final String BudgetCreationPath = configFileReader.getJsonPath() + "BUDGET_BudgetCreationJSON.json";
	private List<BUDGET_BudgetDefinitionTestDataType> BudgetCreationList;

	// UAT Budget Definition
	private final String BudgetDefinitionUATFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetDefinitionUATJSON.json";
	private List<BUDGET_BudgetDefinitionUATTestDataType> budgetDefinitionUATTestData;

	// Budget_SupplementaryBudget

	private final String BudgetFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;

	// Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;

	private final String BudgetReviewerCommentFilePath = configFileReader.getJsonPath() + "BUDGET_ReviewerRemarks.json";
	private List<BUDGET_CommentsFromApprover> reviewerCommentsList;

	// Inventory stock issue
	private final String InventoryStockIssueFilePath = configFileReader.getJsonPath() + "INVENTORY_InventoryStockIssue.json";
	private List<INVENTORY_InventoryStockIssueTestData> inventoryStockIssueTestData;

	// InventoryGL
	private final String InventoryGlFilePath = configFileReader.getJsonPath() + "INVENTORY_EnquiryGlJSON.json";
	private List<INVENTORY_EnquiryGlTestData> inventoryGlReportTestData;

	public final INVENTORY_EnquiryGlTestData getInventoryGlUATTestData(String username) {
		return inventoryGlReportTestData.stream().filter(x -> x.userType.equalsIgnoreCase(username)).findAny().get();
	}

	// Inventory_StockReturnBranch
	private final String StockReturnBranchFilePath = configFileReader.getJsonPath()
			+ "INVENTORY_InventoryManagement.json";
	private List<INVENTORY_InventoryManagement_DataType> StockReturnBranchList;

//AccountPayable_VendorPurchaseOrder
	private final String VendorPurchaseOrderFilePath = configFileReader.getJsonPath()
			+ "AccountPayable_VendorPurchaseOrderJson.json";
	private List<AccountPayable_VendorPurchaseOrderTestDataType> VendorPurchaseOrderList;

//InventoryMaintenance
	private final String InventoryMaintenanceFilePath = configFileReader.getJsonPath()
			+ "InventoryMaintenanceJson.json";
	private List<InventoryMaintenanceTestDataType> InventoryMaintenanceList;

//InventoryManagement_InventoryStockReceipt
	private final String InventoryStockReceiptFilePath = configFileReader.getJsonPath()
			+ "InventoryManagement_InventoryStockReceiptJSON.json";
	private List<InventoryManagement_InventoryStockReceiptTestDataType> InventoryStockReceiptList;

//InventoryManagement Tushar
	private final String InventoryManagementFilePath = configFileReader.getJsonPath() + "InventoryManagementJSON.json";
	private List<InventoryManagementTestDataType> InventoryManagementList;

// INVENTORY_MAINTENANCE_DenominationMaster
	private final String DenominationMasterPath = configFileReader.getJsonPath()
			+ "INVENTORY_MAINTENANCE_DenominationMasterJSON.json";
	private List<INVENTORY_MAINTENANCE_DenominationMasterTestDataType> DenominationMasterList;

// INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmation
	private final String PurchaseRequisitionConfirmationPath = configFileReader.getJsonPath()
			+ "INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationJSON.json";
	private List<INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType> PurchaseRequisitionConfirmationList;

	// ACCOUNTSPAYABLE_VendorContract
	private final String VendorContractsPath = configFileReader.getJsonPath()
			+ "ACCOUNTSPAYABLE_VendorContractsJSON.json";
	private List<ACCOUNTSPAYABLE_VendorContractsTestDataType> VendorContractsList;

	// ACCOUNTSPAYABLE_InvoiceBooking
	private final String InvoiceBookingPath = configFileReader.getJsonPath()
			+ "ACCOUNTSPAYABLE_InvoiceBookingJSON.json";
	private List<ACCOUNTSPAYABLE_InvoiceBookingTestDataType> InvoiceBookingList;

	// Fixed asset
	private final String FixedAssetFilePath = configFileReader.getJsonPath() + "FixedAssetJSON.json";
	private List<FixedAssetTestDataType> FixedAssetList;

	// FixedAsset_AssetCategory
	private final String AssetCategoryFilePath = configFileReader.getJsonPath() + "FixedAsset_AssetCategoryJSON.json";
	private List<FixedAsset_AssetCategoryTestDataType> AssetCategoryList;

	// FixedAsset_AssetDeallocation
	private final String AssetDeallocationFilePath = configFileReader.getJsonPath()
			+ "FixedAsset_AssetDeallocationJSON.json";
	private List<FixedAsset_AssetDeallocationTestDataType> AssetDeallocationList;

	// FixedAsset_AssetCreation
	private final String AssetCreationFilePath = configFileReader.getJsonPath() + "FixedAsset_AssetCreationJSON.json";
	private List<FixedAsset_AssetCreationTestDataType> AssetCreationList;

	// FIXEDASSETS_AssetSale
	private final String AssetSalePath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetSaleJSON.json";
	private List<FIXEDASSETS_AssetSaleTestDataType> AssetSaleList;

	// FIXEDASSETS_AssetUndertaking
	private final String AssetUndertakingPath = configFileReader.getJsonPath()
			+ "FIXEDASSETS_AssetUndertakingJSON.json";
	private List<FIXEDASSETS_AssetUndertakingTestDataType> AssetUndertakingList;

	// FIXEDASSETS_AssetImpairement
	private final String AssetImpairementPath = configFileReader.getJsonPath()
			+ "FIXEDASSETS_AssetImpairementJSON.json";
	private List<FIXEDASSET_AssetImpairementTestDataType> AssetImpairementList;

	// FIXEDASSETS_AssetRevaluation
	private final String AssetRevaluationPath = configFileReader.getJsonPath()
			+ "FIXEDASSETS_AssetRevaluationJSON.json";
	private List<FIXEDASSETS_AssetRevaluationTestDataType> AssetRevaluationList;

	// Reports_AssetCreationCommon
	private final String AssetCreationCommonPath = configFileReader.getJsonPath()
			+ "Reports_AssetCreationCommonJSON.json";
	private List<Reports_AssetCreationCommonTestDataType> AssetCreationCommonList;

	// BUSINESS_PARTNER_SETUP_BusinessPartner
	private final String BusinessPartnerPath = configFileReader.getJsonPath()
			+ "BUSINESS_PARTNER_SETUP_BusinessPartnerJSON.json";
	private List<BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType> BusinessPartnerList;

// FixedAsset_Amendment
	private final String AssetAmendmentFilePath = configFileReader.getJsonPath() + "FIXEDASSET_AssetAmendment.json";
	private List<FIXEDASSET_AssetAmendmentData> AssetAmendmentList;
	// assetImpairement
	private final String FixedAssetImpairementFilePath = configFileReader.getJsonPath()
			+ "FIXEDASSETS_AssetImpairementJSON.json";
	private List<FIXEDASSET_AssetImpairementTestDataType> fixedAssetAssetImpairementTestData;
	// assetReturn
	private final String fixedAssetReturnFilepath = configFileReader.getJsonPath() + "FIXEDASSET_AssetReturnJSON.json";
	private List<FIXEDASSET_AssetReturnTestData> assetReturnTestData;
	// ARAP_ARandAP
	private final String ARandAPFilePath = configFileReader.getJsonPath() + "ARAP_ARandAP.json";
	private List<ARAP_ARandAPData> ARAPList;

	private final String ARAPGRNCreationFilepath = configFileReader.getJsonPath() + "ARAP_GRNCreationJSON.json";
	private List<ARAP_GRNCreationTestDataType> arapGrnCreationDataist;
	// invoice bill booking
	private final String PaymentSettlementFilePath = configFileReader.getJsonPath()
			+ "ACCOUNTSPAYABLE_PayementSettlementJSON.json";
	private List<ACCOUNTSPAYABLE_PaymentSettlementTestDataType> payementSettlementTestData;
	// AccountsPayablle Advance
	private final String AccountsReceivableAdvanceFilePath = configFileReader.getJsonPath()
			+ "ACCOUNTSRECEIVABLE_AccountsReceivableTestDataJson.json";
	private List<ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType> accountsReceivableAdvanceTestData;

	private final String AccountsReceivablereceiptFilePath = configFileReader.getJsonPath()
			+ "ACCOUNTSRECEIVABLE_ReceiptJSON.json";
	private List<ACCOUNTSRECEIVABLE_ReceiptTestData> accountsReceivableReceiptTestData;
	// AutoPayout
	private final String AccountsPayableAutoPayoutFilePath = configFileReader.getJsonPath()
			+ "ACCOUTSPAYABLE_AutoPayoutJSON.json";
	private List<ACCOUTSAPAYBLE_AutoPayoutTestDataType> accountsAutoPayoutTestData;
	// ContractReport
	private final String AccountsPayableContractReportFilePath = configFileReader.getJsonPath()
			+ "ACCOUNTSPAYABLE_ReportDataJSON.json";
	private List<ACCOUNTSPAYABLE_ContractReportTestData> accountspayableContractReportTestData;

	private final String accountsPayablePaymentFileUploadDownloadFilePath = configFileReader.getJsonPath()
			+ "ACCOUNTSPAYABLE_PaymentFileUploadDownloadJSON.json";
	private List<ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData> PaymentFileUploadDwonloadTestData;
	// GL -Accounting setup
	private final String AccsetupFilePath = configFileReader.getJsonPath() + "GL1_Accounting_Setup.json";
	private List<GL1_Accounting_Setup_Data> AccsetupList;

	// GlModule - Anandh
	private final String glModuleFilePath = configFileReader.getJsonPath() + "GL_Module.json";
	private List<GL_ModuleTestData> glModuleTestData;

	private final String cancellationofcontractpath = configFileReader.getJsonPath() + "cancellationofcontract.json";
	private List<Cancellationofcontractdatatype> cancellationlist;

	// Petty Cash
	private final String PettycashFilePath = configFileReader.getJsonPath() + "PETTY_PettyCash.json";
	private List<PETTY_PettyCash_Data> PettycashList;
	
	//---Priyanka--//
	
	//AccountPayable_Grn
	private final String GrnFilePath = configFileReader.getJsonPath() + "AccountPayable_GrnJSON.json";
	private List<AccountPayable_GrnTestDataType> GrnList;
	
	//AccountPayable_InvoiceBooking
	private final String InvoiceBookingFilePath = configFileReader.getJsonPath() + "AccountPayable_InvoiceBookingJSON.json";
	private List<AccountPayable_InvoiceBookingTestDataType> AccountPayableInvoiceBookingList;
		
	//AccountReceivable_AccountReceivableAdvances
	private final String AccountReceivableAdvancesFilePath = configFileReader.getJsonPath() + "AccountReceivable_AccountReceivableAdvancesJSON.json";
	private List<AccountReceivable_AccountReceivableAdvancesTestDataType> AccountReceivableAdvancesList;
			
	//AccountReceivable_Appropriation
	private final String AppropriationFilePath = configFileReader.getJsonPath() + "AccountReceivable_AppropriationJSON.json";
	private List<AccountReceivable_AppropriationTestDataType>AppropriationList;
	
	//AccountReceivable_UpdateDepositedCheque
	private final String UpdateDepositedChequeFilePath = configFileReader.getJsonPath() + "AccountReceivable_UpdateDepositedChequeJSON.json";
	private List<AccountReceivable_UpdateDepositedChequeTestDataType>UpdateDepositedChequeList;
	
	//ArAp_BalanceSheetReport
	private final String BalanceSheetReportFilePath = configFileReader.getJsonPath() + "ArAp_BalanceSheetReportJSON.json";
	private List<ArAp_BalanceSheetReportTestDataType>BalanceSheetReportList;
	
	//ArAp_Enquiry
	private final String ArApEnquiryFilePath = configFileReader.getJsonPath() + "ArAp_EnquiryJSON.json";
	private List<ArAp_EnquiryTestDataType>ArApEnquiryList;
	
	//GL2_JournalVoucher
	private final String JournalVoucherFilePath = configFileReader.getJsonPath() + "GL2_JournalVoucherJSON.json";
	private List<GL2_JournalVoucherTestDataType>JournalVoucherList;
			
	//GL2_JournalVoucher_AccountEntryReport
	private final String JournalVoucherReportFilePath = configFileReader.getJsonPath() + "GL2_JournalVoucher_AccountEntryReportJSON.json";
    private List<GL2_JournalVoucher_AccountEntryReportTestDataType>JournalVoucherReportList;
			
	//GL2_FinancialTransactionReport
	private final String FinancialTransactionReportFilePath = configFileReader.getJsonPath() + "GL2_FinancialTransactionReportJSON.json";
	private List<GL2_FinancialTransactionReportTestDataType>FinancialTransactionReportList;
	
	//GL2_LegalEntityGLConfig
	private final String LegalEntityGLConfigFilePath = configFileReader.getJsonPath() + "GL2_LegalEntityGLConfigJSON.json";
	private List<GL2_LegalEntityGLConfigTestDataType>LegalEntityGLConfigList;
	
	//AccountsPayable_ManualPayoutEmployee
	private final String ManualPayoutEmployeeFilePath = configFileReader.getJsonPath() + "AccountsPayable_ManualPayoutEmployeeJSON.json";
	private List<AccountsPayable_ManualPayoutEmployeeTestDataType> ManualPayoutEmployeeList;
	
	//d--------------------
	// ACCOUNTSPAYABLE_ManualPayout
		private final String ManualPayoutPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_ManualPayoutJSON.json";
		private List<ACCOUNTSPAYABLE_ManualPayoutTestDataType>  ManualPayoutList;
		
		// ACCOUNTSPAYABLE_PaymentSettlementCancellation
		private final String PaymentSettlementCancellationPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_PaymentSettlementCancellationJSON.json";
		private List<ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType>  PaymentSettlementCancellationList;
		
		// AccountsReceivable_ReceiptsReversals
		private final String ReceiptsReversalsPath = configFileReader.getJsonPath() + "AccountsReceivable_ReceiptsReversalsJSON.json";
		private List<AccountsReceivable_ReceiptsReversalsTestDataType>  ReceiptsReversalsList;
		
		// AccountsReceivable_UpdateChequeStatus
		private final String UpdateChequeStatusPath = configFileReader.getJsonPath() + "AccountsReceivable_UpdateChequeStatusJSON.json";
		private List<AccountsReceivable_UpdateChequeStatusTestDataType>  UpdateChequeStatusList;
		
		// GeneralLedger2_JournalVoucher
		private final String JournalVoucherPath = configFileReader.getJsonPath() + "GeneralLedger2_JournalVoucherJSON.json";
		private List<GeneralLedger2_JournalVoucherTestDataType>  JournalVoucher1List;
		
		// FinancialReporting_GLBalancesReport
		private final String GLBalancesReportPath = configFileReader.getJsonPath() + "FinancialReporting_GLBalancesReportJSON.json";
		private List<FinancialReporting_GLBalancesReportTestDataType>  GLBalancesReportList;
		
		// FinancialReporting_BalanceSheetReport
		private final String BalanceSheetReportPath = configFileReader.getJsonPath() + "FinancialReporting_BalanceSheetReportJSON.json";
		private List<FinancialReporting_BalanceSheetReportTestDataType>  BalanceSheetReport1List;
		
		// FinancialReporting_TrialBalanceReport
		private final String TrialBalanceReportPath = configFileReader.getJsonPath() + "FinancialReporting_TrialBalanceReportJSON.json";
		private List<FinancialReporting_TrialBalanceReportTestDataType>  TrialBalanceReportList;

		// JobScheduler_JobExecution
		private final String JobExecutionPath = configFileReader.getJsonPath() + "JobScheduler_JobExecutionJSON.json";
		private List<JobScheduler_JobExecutionTestDataType> JobExecutionList;

		// AccountsReceivable_Appropriation
		private final String AppropriationPath = configFileReader.getJsonPath() + "AccountsReceivable_AppropriationJSON.json";
		private List<AccountsReceivable_AppropriationTestDataType>  Appropriation1List;
		
		//AccountingSetup_ChartOfAccountsDefinition
		private final String ChartOfAccountsDefinitionPath = configFileReader.getJsonPath() + "AccountingSetup_ChartOfAccountsDefinitionJSON.json";
		private List<AccountingSetup_ChartOfAccountsDefinitionTestDataType>  ChartOfAccountsDefinitionList;
		
		//AccountingSetup_ChartOfAccountsDefinition
		private final String ReconciliationPath = configFileReader.getJsonPath() + "PettyCash_ReconciliationJSON.json";
		private List<PettyCash_ReconciliationTestDataType>  ReconciliationList;
		
		// Reports_PettyCash
		private final String PettyCashPath = configFileReader.getJsonPath() + "Reports_PettyCashJSON.json";
		private List<Reports_PettyCashTestDataType> PettyCashList;
		
		// AccountsReceivable_DebitNote
		private final String DebitNotePath = configFileReader.getJsonPath() + "AccountsReceivable_DebitNoteJSON.json";
		private List<AccountsReceivable_DebitNoteTestDataType> DebitNoteList;
			
	public JsonConfig() {
		/*
		 * RegisterList = getRegisterData(); LoginList = getLoginList();
		 */

		budgetDefinitionUATTestData = getBudgetDefinitionUATTestData();
		AllocationList = getAllocationList();
		BudtypeList = getBudtypeList();
		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();
		SupplementaryBudgetList = getSupplementaryBudgetList();
		BudgetTransferList = getBudgetTransferData();
		reviewerCommentsList = getApproverCommentsData();

		BudgetTransferList = getBudgetTransferData();
		reviewerCommentsList = getApproverCommentsData();
		VendorPurchaseOrderList = getVendorPurchaseOrderData();
		InventoryMaintenanceList = getInventoryMaintenanceListData();
		InventoryStockReceiptList = getInventoryStockReceiptListData();
		inventoryGlReportTestData = getInventoryGlTestData();
		InventoryManagementList = getInventoryManagementList();
		InventoryManagementList = getInventoryManagementList();
		DenominationMasterList = getDenominationMasterList();
		PurchaseRequisitionConfirmationList = getPurchaseRequisitionConfirmationList();
		VendorContractsList = getVendorContractList();
		InvoiceBookingList = getInvoiceBookingList();
		AssetAmendmentList = getAssetAmendmentList();
		fixedAssetAssetImpairementTestData = getFixedAssetImpairementTestData();
		assetReturnTestData = getFixedAssetReturnTestData();
		// ARAP_ARandAP
		ARAPList = getARAPList();
		arapGrnCreationDataist = getARAPGRNAndPoTestData();
		payementSettlementTestData = getPaymentSettlementTestData();
		accountsReceivableAdvanceTestData = getAccounteReceivableAdvanceTestData();
		accountsReceivableReceiptTestData = getAccounteReceivableReceiptTestData();
		accountsAutoPayoutTestData = getAccountsPayableAutoPayoutTestData();
		accountspayableContractReportTestData = getAccountsPayableContractReportTestData();
		PaymentFileUploadDwonloadTestData = getPaymentFileUploadDwonloadTestData();
		// Accounting Setup
		AccsetupList = getAccsetupList();

		// GL module - Anandh
		glModuleTestData = getGlModuleTestData();
		cancellationlist = getCancellationlist();

		// Petty Cash
		PettycashList = getPettycashList();
		inventoryStockIssueTestData = getInventoryStockIssueTestData();
		FixedAssetList = getFixedAssetList();
		AssetCategoryList = getAssetCategoryListData();
		AssetDeallocationList = getAssetDeallocationListData();
		AssetCreationList = getAssetCreationListData();
		AssetSaleList = getAssetSaleList();
		//inventoryGlReportTestData = getGlAccountingTestData();
		AssetUndertakingList = getAssetUndertakingList();
		AssetImpairementList = getAssetImpairementList();
		AssetRevaluationList = getAssetRevaluationList();
		AssetCreationCommonList = getAssetCreationCommonList();
		BusinessPartnerList = getBusinessPartnerList();
		//Priyanka
		GrnList = getGrnData();
		AccountPayableInvoiceBookingList = getAccountPayableInvoiceBookingListData();
		AccountReceivableAdvancesList = getAccountReceivableAdvancesData();
		AppropriationList = getAppropriationListData();
		UpdateDepositedChequeList = getUpdateDepositedChequeListData();
		BalanceSheetReportList= getBalanceSheetReportListData();
		ArApEnquiryList = getArApEnquiryListData();
		JournalVoucherList = getJournalVoucherListData();
		JournalVoucherReportList = getJournalVoucherReportListData();
		FinancialTransactionReportList = getFinancialTransactionReportListData();
		LegalEntityGLConfigList = getLegalEntityGLConfigListData();
		ManualPayoutEmployeeList = getManualPayoutEmployeeData();
		
		//d------------------
		 ManualPayoutList = getManualPayoutList();
		 PaymentSettlementCancellationList = getPaymentSettlementCancellationList();
		 ReceiptsReversalsList = getReceiptsReversalsList();
		 UpdateChequeStatusList = getUpdateChequeStatusList();
		 JournalVoucher1List = getJournalVoucherList();
		 GLBalancesReportList = getGLBalancesReportList();
		 BalanceSheetReport1List = getBalanceSheetReportList();
		 TrialBalanceReportList = getTrialBalanceReportList();
		 JobExecutionList = getJobExecutionList();
		 Appropriation1List = getAppropriationList();
		 ChartOfAccountsDefinitionList = getChartOfAccountsDefinitionList();
		 ReconciliationList = getReconciliationList();
		 PettyCashList = getPettyCashList();
		 DebitNoteList = getDebitNoteList();
	}

	// PaymentFile Upload download
	private List<ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData> getPaymentFileUploadDwonloadTestData() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(accountsPayablePaymentFileUploadDownloadFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(accountsPayablePaymentFileUploadDownloadFilePath));
			ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData[] paymentFileUploadDownloadTestData = gson
					.fromJson(bufferReader, ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData[].class);
			return Arrays.asList(paymentFileUploadDownloadTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Json file not found at path : " + accountsPayablePaymentFileUploadDownloadFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	/*private List<INVENTORY_EnquiryGlTestData> getGlAccountingTestData() {
		Gson gson = new Gson();
		
	}*/

// PettyCash
	private List<PETTY_PettyCash_Data> getPettycashList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(PettycashFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(PettycashFilePath));
			PETTY_PettyCash_Data[] petty = gson.fromJson(bufferReader, PETTY_PettyCash_Data[].class);
			return Arrays.asList(petty);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + PettycashFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// inventiry Gl
	private List<INVENTORY_EnquiryGlTestData> getInventoryGlTestData() {
		Gson gson = new Gson();

		JsonReader reader = new JsonReader(new StringReader(InventoryGlFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryGlFilePath));
			INVENTORY_EnquiryGlTestData[] glAccountingTestData = gson.fromJson(bufferReader,
					INVENTORY_EnquiryGlTestData[].class);
			return Arrays.asList(glAccountingTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InventoryGlFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_RequestAndAllocationTestDataType> getAllocationList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AllocationFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AllocationFilePath));
			BUDGET_RequestAndAllocationTestDataType[] BUDGET_RequestAndAllocation = gson.fromJson(bufferReader,
					BUDGET_RequestAndAllocationTestDataType[].class);
			return Arrays.asList(BUDGET_RequestAndAllocation);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AllocationFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<Cancellationofcontractdatatype> getCancellationlist() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(cancellationofcontractpath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(cancellationofcontractpath));
			Cancellationofcontractdatatype[] cancellationlist = gson.fromJson(bufferReader,
					Cancellationofcontractdatatype[].class);
			return Arrays.asList(cancellationlist);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + cancellationofcontractpath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}

	}

	// ARAP_ARandAP
	private List<ARAP_ARandAPData> getARAPList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(ARandAPFilePath));
			ARAP_ARandAPData[] arap = gson.fromJson(bufferReader, ARAP_ARandAPData[].class);
			return Arrays.asList(arap);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + ARandAPFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_RequestandallocationBUDTYPEDATA> getBudtypeList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudtypeFilepath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudtypeFilepath));
			BUDGET_RequestandallocationBUDTYPEDATA[] type = gson.fromJson(bufferReader,
					BUDGET_RequestandallocationBUDTYPEDATA[].class);
			return Arrays.asList(type);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudtypeFilepath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_BudgetDefinitionTestDataType> getBudgetList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudgetCreationPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetCreationPath));
			BUDGET_BudgetDefinitionTestDataType[] budget = gson.fromJson(bufferReader,
					BUDGET_BudgetDefinitionTestDataType[].class);
			return Arrays.asList(budget);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetCreationPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// UAT budget definition test data Function
	private List<BUDGET_BudgetDefinitionUATTestDataType> getBudgetDefinitionUATTestData() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudgetDefinitionUATFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetDefinitionUATFilePath));
			BUDGET_BudgetDefinitionUATTestDataType[] budgetDefinitionUAtTestData = gson.fromJson(bufferReader,
					BUDGET_BudgetDefinitionUATTestDataType[].class);
			return Arrays.asList(budgetDefinitionUAtTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetDefinitionUATFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<KUBS_LoginTestDataType> getAzentioCredentialsList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AzentioLoginDataPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AzentioLoginDataPath));
			KUBS_LoginTestDataType[] credentials = gson.fromJson(bufferReader, KUBS_LoginTestDataType[].class);
			return Arrays.asList(credentials);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AzentioLoginDataPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_SupplementarybudgetTestDataType> getSupplementaryBudgetList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudgetFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetFilePath));
			BUDGET_SupplementarybudgetTestDataType[] login = gson.fromJson(bufferReader,
					BUDGET_SupplementarybudgetTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// Budget_BudgetTransferData
	private List<BUDGET_BudgetTransferTestDataType> getBudgetTransferData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetTransferFilePath));
			BUDGET_BudgetTransferTestDataType[] budgetTransfer = gson.fromJson(bufferReader,
					BUDGET_BudgetTransferTestDataType[].class);
			return Arrays.asList(budgetTransfer);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetTransferFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_CommentsFromApprover> getApproverCommentsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetReviewerCommentFilePath));
			BUDGET_CommentsFromApprover[] reviewercomments = gson.fromJson(bufferReader,
					BUDGET_CommentsFromApprover[].class);
			return Arrays.asList(reviewercomments);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetReviewerCommentFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// AccountPayable_VendorPurchaseOrder
	private List<AccountPayable_VendorPurchaseOrderTestDataType> getVendorPurchaseOrderData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(VendorPurchaseOrderFilePath));
			AccountPayable_VendorPurchaseOrderTestDataType[] VendorPurchaseOrder = gson.fromJson(bufferReader,
					AccountPayable_VendorPurchaseOrderTestDataType[].class);
			return Arrays.asList(VendorPurchaseOrder);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + VendorPurchaseOrderFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// InventoryMaintenance
	private List<InventoryMaintenanceTestDataType> getInventoryMaintenanceListData() {
				Gson gson = new Gson();
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(InventoryMaintenanceFilePath));
					InventoryMaintenanceTestDataType[] InventoryMaintenance = gson.fromJson(bufferReader, InventoryMaintenanceTestDataType[].class);
					return Arrays.asList(InventoryMaintenance);
					}catch(FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + InventoryMaintenanceFilePath );
					}finally {
						try { if(bufferReader != null) bufferReader.close();}
						catch (IOException ignore) {
							
						}
					}
	}

		//ContractReport
				private List<ACCOUNTSPAYABLE_ContractReportTestData> getAccountsPayableContractReportTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(AccountsPayableContractReportFilePath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(AccountsPayableContractReportFilePath));
						ACCOUNTSPAYABLE_ContractReportTestData[] accountsPayableContractReportTestData = gson.fromJson(bufferReader,
								ACCOUNTSPAYABLE_ContractReportTestData[].class);
						return Arrays.asList(accountsPayableContractReportTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + AccountsPayableContractReportFilePath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}
			

		//AutoPayout
				private List<ACCOUTSAPAYBLE_AutoPayoutTestDataType> getAccountsPayableAutoPayoutTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(AccountsPayableAutoPayoutFilePath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(AccountsPayableAutoPayoutFilePath));
						ACCOUTSAPAYBLE_AutoPayoutTestDataType[] accountsPayableAutoPayoutTestData = gson.fromJson(bufferReader,
								ACCOUTSAPAYBLE_AutoPayoutTestDataType[].class);
						return Arrays.asList(accountsPayableAutoPayoutTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + AccountsPayableAutoPayoutFilePath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}
	
				//receipt
				private List<ACCOUNTSRECEIVABLE_ReceiptTestData> getAccounteReceivableReceiptTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(AccountsReceivablereceiptFilePath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(AccountsReceivablereceiptFilePath));
						ACCOUNTSRECEIVABLE_ReceiptTestData[] accountsReceivableReceiptTestData = gson.fromJson(bufferReader,
								ACCOUNTSRECEIVABLE_ReceiptTestData[].class);
						return Arrays.asList(accountsReceivableReceiptTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + AccountsReceivablereceiptFilePath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}
				//AccountsReceivable Advance TestData
				private List<ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType> getAccounteReceivableAdvanceTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(AccountsReceivableAdvanceFilePath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(AccountsReceivableAdvanceFilePath));
						ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType[] accountsReceivableAdvanceTestData = gson.fromJson(bufferReader,
								ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType[].class);
						return Arrays.asList(accountsReceivableAdvanceTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + AccountsReceivableAdvanceFilePath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}
				//PaymentSettlement
				private List<ACCOUNTSPAYABLE_PaymentSettlementTestDataType> getPaymentSettlementTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(PaymentSettlementFilePath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(PaymentSettlementFilePath));
						ACCOUNTSPAYABLE_PaymentSettlementTestDataType[] payementSettlementTestData = gson.fromJson(bufferReader,
								ACCOUNTSPAYABLE_PaymentSettlementTestDataType[].class);
						return Arrays.asList(payementSettlementTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + PaymentSettlementFilePath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}

			//arapGRN
				private List<ARAP_GRNCreationTestDataType> getARAPGRNAndPoTestData() {
					Gson gson = new Gson();
					JsonReader reader = new JsonReader(new StringReader(ARAPGRNCreationFilepath));
					reader.setLenient(true);
					BufferedReader bufferReader = null;
					try {
						bufferReader = new BufferedReader(new FileReader(ARAPGRNCreationFilepath));
						ARAP_GRNCreationTestDataType[] arapGRNTestData = gson.fromJson(bufferReader,
								ARAP_GRNCreationTestDataType[].class);
						return Arrays.asList(arapGRNTestData);
					} catch (FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + ARAPGRNCreationFilepath);
					} finally {
						try {
							if (bufferReader != null)
								bufferReader.close();
						} catch (IOException ignore) {
						}
					}
				}
	
	//Gl module TestData - Anandh
	private List<GL_ModuleTestData> getGlModuleTestData()
	{
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(glModuleFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(glModuleFilePath));
			GL_ModuleTestData[] glmoduleTestData = gson.fromJson(bufferReader,
					GL_ModuleTestData[].class);
			return Arrays.asList(glmoduleTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + glModuleFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}	
	}
	
	// Accounting Setup
	private List<GL1_Accounting_Setup_Data> getAccsetupList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AccsetupFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AccsetupFilePath));
			GL1_Accounting_Setup_Data[] GlaccSetup = gson.fromJson(bufferReader, GL1_Accounting_Setup_Data[].class);
			return Arrays.asList(GlaccSetup);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AccsetupFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	

	

			private List<InventoryManagement_InventoryStockReceiptTestDataType> getInventoryStockReceiptListData() {
				Gson gson = new Gson();
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(InventoryStockReceiptFilePath));
					InventoryManagement_InventoryStockReceiptTestDataType[] InventoryStockReceipt = gson.fromJson(bufferReader, InventoryManagement_InventoryStockReceiptTestDataType[].class);
					return Arrays.asList(InventoryStockReceipt);
					}catch(FileNotFoundException e) {
						throw new RuntimeException("Json file not found at path : " + InventoryStockReceiptFilePath );
					}finally {
						try { if(bufferReader != null) bufferReader.close();}
						catch (IOException ignore) {}
					}
			}
			
			
		
				
			
			//InventoryManagement
			private List<InventoryManagementTestDataType> getInventoryManagementList() {
				Gson gson = new Gson();
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(InventoryManagementFilePath));
					InventoryManagementTestDataType[] InventoryManagement = gson.fromJson(bufferReader, InventoryManagementTestDataType[].class);
					return Arrays.asList(InventoryManagement);
				}catch(FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + InventoryManagementFilePath);
				}finally {
					try { if(bufferReader != null) bufferReader.close();}
					catch (IOException ignore) {}
				}
			}
			private List<INVENTORY_MAINTENANCE_DenominationMasterTestDataType> getDenominationMasterList() {
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new StringReader(DenominationMasterPath));
				reader.setLenient(true);
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(DenominationMasterPath));
					INVENTORY_MAINTENANCE_DenominationMasterTestDataType[] login = gson.fromJson(bufferReader,
							INVENTORY_MAINTENANCE_DenominationMasterTestDataType[].class);
					return Arrays.asList(login);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + DenominationMasterPath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}
			}
			
			private List<INVENTORY_InventoryStockIssueTestData> getInventoryStockIssueTestData() {
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new StringReader(InventoryStockIssueFilePath));
				reader.setLenient(true);
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(InventoryStockIssueFilePath));
					INVENTORY_InventoryStockIssueTestData[] inventoryStockIssueTestData = gson.fromJson(bufferReader,
							INVENTORY_InventoryStockIssueTestData[].class);
					return Arrays.asList(inventoryStockIssueTestData);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + InventoryStockIssueFilePath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}
			}
			
			private List<INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType> getPurchaseRequisitionConfirmationList() {
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new StringReader(PurchaseRequisitionConfirmationPath));
				reader.setLenient(true);
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(PurchaseRequisitionConfirmationPath));
					INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType[] login = gson.fromJson(bufferReader,
							INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType[].class);
					return Arrays.asList(login);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + PurchaseRequisitionConfirmationPath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}
			}
			
			private List<ACCOUNTSPAYABLE_VendorContractsTestDataType> getVendorContractList() {
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new StringReader(VendorContractsPath));
				reader.setLenient(true);
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(VendorContractsPath));
					ACCOUNTSPAYABLE_VendorContractsTestDataType[] login = gson.fromJson(bufferReader,
							ACCOUNTSPAYABLE_VendorContractsTestDataType[].class);
					return Arrays.asList(login);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + VendorContractsPath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}
			}
			
			private List<ACCOUNTSPAYABLE_InvoiceBookingTestDataType> getInvoiceBookingList() {
				Gson gson = new Gson();
				JsonReader reader = new JsonReader(new StringReader(InvoiceBookingPath));
				reader.setLenient(true);
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(InvoiceBookingPath));
					ACCOUNTSPAYABLE_InvoiceBookingTestDataType[] login = gson.fromJson(bufferReader,
							ACCOUNTSPAYABLE_InvoiceBookingTestDataType[].class);
					return Arrays.asList(login);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + InvoiceBookingPath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}
			}
			
			
	//Fixed Asset

private List<FixedAssetTestDataType> getFixedAssetList() {
	 Gson gson = new Gson();
	 JsonReader reader = new JsonReader(new StringReader(FixedAssetFilePath));
	 reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(FixedAssetFilePath));
		FixedAssetTestDataType[] FixedAsset = gson.fromJson(bufferReader, FixedAssetTestDataType[].class);
		return Arrays.asList(FixedAsset);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + FixedAssetFilePath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
	
}
//AssetCategory
private List<FixedAsset_AssetCategoryTestDataType> getAssetCategoryListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(AssetCategoryFilePath));
		FixedAsset_AssetCategoryTestDataType[] AssetCategory = gson.fromJson(bufferReader, FixedAsset_AssetCategoryTestDataType[].class);
		return Arrays.asList(AssetCategory);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AssetCategoryFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	
}
//AssetDeallocation
private List<FixedAsset_AssetDeallocationTestDataType> getAssetDeallocationListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(AssetDeallocationFilePath));
		FixedAsset_AssetDeallocationTestDataType[] AssetDeallocation = gson.fromJson(bufferReader, FixedAsset_AssetDeallocationTestDataType[].class);
		return Arrays.asList(AssetDeallocation);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AssetDeallocationFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	
}


//AssetCreation
private List<FixedAsset_AssetCreationTestDataType> getAssetCreationListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(AssetCreationFilePath));
		FixedAsset_AssetCreationTestDataType[] AssetCreation = gson.fromJson(bufferReader, FixedAsset_AssetCreationTestDataType[].class);
		return Arrays.asList(AssetCreation);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AssetCreationFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	
}

		private List<FIXEDASSETS_AssetSaleTestDataType> getAssetSaleList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(AssetSalePath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader(AssetSalePath));
				FIXEDASSETS_AssetSaleTestDataType[] login = gson.fromJson(bufferReader,
						FIXEDASSETS_AssetSaleTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + AssetSalePath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		private List<BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType> getBusinessPartnerList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(BusinessPartnerPath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader (BusinessPartnerPath));
				BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType[] login = gson.fromJson(bufferReader,
						BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + BusinessPartnerPath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		private List<FIXEDASSETS_AssetUndertakingTestDataType> getAssetUndertakingList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(AssetUndertakingPath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader (AssetUndertakingPath));
				FIXEDASSETS_AssetUndertakingTestDataType[] login = gson.fromJson(bufferReader,
						FIXEDASSETS_AssetUndertakingTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + AssetUndertakingPath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		private List<FIXEDASSET_AssetImpairementTestDataType> getAssetImpairementList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(AssetImpairementPath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader (AssetImpairementPath));
				FIXEDASSET_AssetImpairementTestDataType[] login = gson.fromJson(bufferReader,
						FIXEDASSET_AssetImpairementTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + AssetImpairementPath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		private List<FIXEDASSETS_AssetRevaluationTestDataType> getAssetRevaluationList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(AssetRevaluationPath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader (AssetRevaluationPath));
				FIXEDASSETS_AssetRevaluationTestDataType[] login = gson.fromJson(bufferReader,
						FIXEDASSETS_AssetRevaluationTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + AssetRevaluationPath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		private List<Reports_AssetCreationCommonTestDataType> getAssetCreationCommonList() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(AssetCreationCommonPath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader (AssetCreationCommonPath));
				Reports_AssetCreationCommonTestDataType[] login = gson.fromJson(bufferReader,
						Reports_AssetCreationCommonTestDataType[].class);
				return Arrays.asList(login);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + AssetCreationCommonPath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}

public final FixedAssetTestDataType getFixedAssetByName(String UserName){
	 return FixedAssetList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();

}

	
	//FixedAssetReturnTestDAta
		private List<FIXEDASSET_AssetReturnTestData> getFixedAssetReturnTestData() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(fixedAssetReturnFilepath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader(fixedAssetReturnFilepath));
				FIXEDASSET_AssetReturnTestData[] assetReturnTestData = gson.fromJson(bufferReader,
						FIXEDASSET_AssetReturnTestData[].class);
				return Arrays.asList(assetReturnTestData);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + fixedAssetReturnFilepath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
				}
			}
		}
		
		//fixed Asset impairement 
		
		private List<FIXEDASSET_AssetImpairementTestDataType> getFixedAssetImpairementTestData() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(FixedAssetImpairementFilePath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader(FixedAssetImpairementFilePath));
				FIXEDASSET_AssetImpairementTestDataType[] fixedAssetImpairementTestData = gson.fromJson(bufferReader,
						FIXEDASSET_AssetImpairementTestDataType[].class);
					return Arrays.asList(fixedAssetImpairementTestData);
				} catch (FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + FixedAssetImpairementFilePath);
				} finally {
					try {
						if (bufferReader != null)
							bufferReader.close();
					} catch (IOException ignore) {
					}
				}

		}
	/*private List<KUBS_LoginTestDataType> getAzentioCredentialsList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AzentioLoginDataPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AzentioLoginDataPath));
			KUBS_LoginTestDataType[] credentials = gson.fromJson(bufferReader, KUBS_LoginTestDataType[].class);
			return Arrays.asList(credentials);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AzentioLoginDataPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_SupplementarybudgetTestDataType> getSupplementaryBudgetList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudgetFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetFilePath));
			BUDGET_SupplementarybudgetTestDataType[] login = gson.fromJson(bufferReader,
					BUDGET_SupplementarybudgetTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// Budget_BudgetTransferData
	private List<BUDGET_BudgetTransferTestDataType> getBudgetTransferData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetTransferFilePath));
			BUDGET_BudgetTransferTestDataType[] budgetTransfer = gson.fromJson(bufferReader,
					BUDGET_BudgetTransferTestDataType[].class);
			return Arrays.asList(budgetTransfer);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetTransferFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<BUDGET_CommentsFromApprover> getApproverCommentsData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetReviewerCommentFilePath));
			BUDGET_CommentsFromApprover[] reviewercomments = gson.fromJson(bufferReader,
					BUDGET_CommentsFromApprover[].class);
			return Arrays.asList(reviewercomments);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetReviewerCommentFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// AccountPayable_VendorPurchaseOrder
	private List<AccountPayable_VendorPurchaseOrderTestDataType> getVendorPurchaseOrderData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(VendorPurchaseOrderFilePath));
			AccountPayable_VendorPurchaseOrderTestDataType[] VendorPurchaseOrder = gson.fromJson(bufferReader,
					AccountPayable_VendorPurchaseOrderTestDataType[].class);
			return Arrays.asList(VendorPurchaseOrder);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + VendorPurchaseOrderFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// InventoryMaintenance
	private List<InventoryMaintenanceTestDataType> getInventoryMaintenanceListData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryMaintenanceFilePath));
			InventoryMaintenanceTestDataType[] InventoryMaintenance = gson.fromJson(bufferReader,
					InventoryMaintenanceTestDataType[].class);
			return Arrays.asList(InventoryMaintenance);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InventoryMaintenanceFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}

	}

	private List<InventoryManagement_InventoryStockReceiptTestDataType> getInventoryStockReceiptListData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryStockReceiptFilePath));
			InventoryManagement_InventoryStockReceiptTestDataType[] InventoryStockReceipt = gson.fromJson(bufferReader,
					InventoryManagement_InventoryStockReceiptTestDataType[].class);
			return Arrays.asList(InventoryStockReceipt);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InventoryStockReceiptFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// InventoryManagement
	private List<InventoryManagementTestDataType> getInventoryManagementList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryManagementFilePath));
			InventoryManagementTestDataType[] InventoryManagement = gson.fromJson(bufferReader,
					InventoryManagementTestDataType[].class);
			return Arrays.asList(InventoryManagement);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InventoryManagementFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<INVENTORY_MAINTENANCE_DenominationMasterTestDataType> getDenominationMasterList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(DenominationMasterPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(DenominationMasterPath));
			INVENTORY_MAINTENANCE_DenominationMasterTestDataType[] login = gson.fromJson(bufferReader,
					INVENTORY_MAINTENANCE_DenominationMasterTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + DenominationMasterPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<INVENTORY_InventoryStockIssueTestData> getInventoryStockIssueTestData() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(InventoryStockIssueFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryStockIssueFilePath));
			INVENTORY_InventoryStockIssueTestData[] inventoryStockIssueTestData = gson.fromJson(bufferReader,
					INVENTORY_InventoryStockIssueTestData[].class);
			return Arrays.asList(inventoryStockIssueTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InventoryStockIssueFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType> getPurchaseRequisitionConfirmationList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(PurchaseRequisitionConfirmationPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(PurchaseRequisitionConfirmationPath));
			INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType[] login = gson.fromJson(bufferReader,
					INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + PurchaseRequisitionConfirmationPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<ACCOUNTSPAYABLE_VendorContractsTestDataType> getVendorContractList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(VendorContractsPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(VendorContractsPath));
			ACCOUNTSPAYABLE_VendorContractsTestDataType[] login = gson.fromJson(bufferReader,
					ACCOUNTSPAYABLE_VendorContractsTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + VendorContractsPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<ACCOUNTSPAYABLE_InvoiceBookingTestDataType> getInvoiceBookingList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(InvoiceBookingPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InvoiceBookingPath));
			ACCOUNTSPAYABLE_InvoiceBookingTestDataType[] login = gson.fromJson(bufferReader,
					ACCOUNTSPAYABLE_InvoiceBookingTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + InvoiceBookingPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}*/

	private List<FIXEDASSET_AssetAmendmentData> getAssetAmendmentList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AssetAmendmentFilePath));
			FIXEDASSET_AssetAmendmentData[] fixedasset = gson.fromJson(bufferReader,
					FIXEDASSET_AssetAmendmentData[].class);
			return Arrays.asList(fixedasset);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AssetAmendmentFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
  //grn 
	private List<AccountPayable_GrnTestDataType> getGrnData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(GrnFilePath));
			AccountPayable_GrnTestDataType[] Grn = gson.fromJson(bufferReader, AccountPayable_GrnTestDataType[].class);
			return Arrays.asList(Grn);
			}catch(FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + GrnFilePath );
			}finally {
				try { if(bufferReader != null) bufferReader.close();}
				catch (IOException ignore) {}
			}
	}
//AccountPayable_InvoiceBooking

private List<AccountPayable_InvoiceBookingTestDataType> getAccountPayableInvoiceBookingListData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InvoiceBookingFilePath));
			AccountPayable_InvoiceBookingTestDataType[] InvoiceBooking = gson.fromJson(bufferReader, AccountPayable_InvoiceBookingTestDataType[].class);
			return Arrays.asList(InvoiceBooking);
			}catch(FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + InvoiceBookingFilePath );
			}finally {
				try { if(bufferReader != null) bufferReader.close();}
				catch (IOException ignore) {}
			}
	}

//AccountReceivableAdvances
private List<AccountReceivable_AccountReceivableAdvancesTestDataType> getAccountReceivableAdvancesData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(AccountReceivableAdvancesFilePath));
		AccountReceivable_AccountReceivableAdvancesTestDataType[] AccountReceivableAdvances = gson.fromJson(bufferReader, AccountReceivable_AccountReceivableAdvancesTestDataType[].class);
		return Arrays.asList(AccountReceivableAdvances);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AccountReceivableAdvancesFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
//AccountReceivable_Appropriation

private List<AccountReceivable_AppropriationTestDataType> getAppropriationListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(AppropriationFilePath));
		AccountReceivable_AppropriationTestDataType[] appropriation = gson.fromJson(bufferReader, AccountReceivable_AppropriationTestDataType[].class);
		return Arrays.asList(appropriation);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AppropriationFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}	
}
//AccountReceivable_UpdateDepositedCheque
private List<AccountReceivable_UpdateDepositedChequeTestDataType> getUpdateDepositedChequeListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(UpdateDepositedChequeFilePath));
		AccountReceivable_UpdateDepositedChequeTestDataType[] UpdateDepositedCheque = gson.fromJson(bufferReader,AccountReceivable_UpdateDepositedChequeTestDataType[].class);
		return Arrays.asList(UpdateDepositedCheque);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + UpdateDepositedChequeFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
}
//ArAp_BalanceSheetReport
private List<ArAp_BalanceSheetReportTestDataType> getBalanceSheetReportListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(BalanceSheetReportFilePath));
		ArAp_BalanceSheetReportTestDataType[] balanceSheetReport = gson.fromJson(bufferReader, ArAp_BalanceSheetReportTestDataType[].class);
		return Arrays.asList(balanceSheetReport);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BalanceSheetReportFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}	
}
//ArAp_Enquiry
private List<ArAp_EnquiryTestDataType> getArApEnquiryListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(ArApEnquiryFilePath));
		ArAp_EnquiryTestDataType[] ArApEnquiry = gson.fromJson(bufferReader,ArAp_EnquiryTestDataType[].class);
		return Arrays.asList(ArApEnquiry);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + ArApEnquiryFilePath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

//GL2_JournalVoucher
private List<GL2_JournalVoucherTestDataType> getJournalVoucherListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(JournalVoucherFilePath));
		GL2_JournalVoucherTestDataType[] JournalVoucher = gson.fromJson(bufferReader, GL2_JournalVoucherTestDataType[].class);
		return Arrays.asList(JournalVoucher);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + JournalVoucherFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	
}

//GL2_JournalVoucher_AccountEntryReport
private List<GL2_JournalVoucher_AccountEntryReportTestDataType> getJournalVoucherReportListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(JournalVoucherReportFilePath));
		GL2_JournalVoucher_AccountEntryReportTestDataType[] JournalVoucherReport = gson.fromJson(bufferReader, GL2_JournalVoucher_AccountEntryReportTestDataType[].class);
		return Arrays.asList(JournalVoucherReport);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + JournalVoucherReportFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
}


//GL2_FinancialTransactionReport
private List<GL2_FinancialTransactionReportTestDataType> getFinancialTransactionReportListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(FinancialTransactionReportFilePath));
		GL2_FinancialTransactionReportTestDataType[] FinancialTransactionReport = gson.fromJson(bufferReader,GL2_FinancialTransactionReportTestDataType[].class);
		return Arrays.asList(FinancialTransactionReport);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + FinancialTransactionReportFilePath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}
//GL2_LegalEntityGLConfig
private List<GL2_LegalEntityGLConfigTestDataType> getLegalEntityGLConfigListData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(LegalEntityGLConfigFilePath));
		GL2_LegalEntityGLConfigTestDataType[] LegalEntityGLConfig = gson.fromJson(bufferReader,GL2_LegalEntityGLConfigTestDataType[].class);
		return Arrays.asList(LegalEntityGLConfig);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + LegalEntityGLConfigFilePath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {}
	}	
}
//AccountsPayable_ManualPayoutEmployee

private List<AccountsPayable_ManualPayoutEmployeeTestDataType> getManualPayoutEmployeeData() {
	Gson gson = new Gson();
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader(ManualPayoutEmployeeFilePath));
		AccountsPayable_ManualPayoutEmployeeTestDataType[] ManualPayoutEmployee = gson.fromJson(bufferReader,AccountsPayable_ManualPayoutEmployeeTestDataType[].class);
		return Arrays.asList(ManualPayoutEmployee);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + ManualPayoutEmployeeFilePath );
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	
}

	//d-------------------------
private List<ACCOUNTSPAYABLE_ManualPayoutTestDataType> getManualPayoutList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(ManualPayoutPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (ManualPayoutPath));
		ACCOUNTSPAYABLE_ManualPayoutTestDataType[] login = gson.fromJson(bufferReader,
				ACCOUNTSPAYABLE_ManualPayoutTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + ManualPayoutPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType> getPaymentSettlementCancellationList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(PaymentSettlementCancellationPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (PaymentSettlementCancellationPath));
		ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType[] login = gson.fromJson(bufferReader,
				ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + PaymentSettlementCancellationPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<AccountsReceivable_ReceiptsReversalsTestDataType> getReceiptsReversalsList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(ReceiptsReversalsPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (ReceiptsReversalsPath));
		AccountsReceivable_ReceiptsReversalsTestDataType[] login = gson.fromJson(bufferReader,
				AccountsReceivable_ReceiptsReversalsTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + ReceiptsReversalsPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<AccountsReceivable_UpdateChequeStatusTestDataType> getUpdateChequeStatusList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(UpdateChequeStatusPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (UpdateChequeStatusPath));
		AccountsReceivable_UpdateChequeStatusTestDataType[] login = gson.fromJson(bufferReader,
				AccountsReceivable_UpdateChequeStatusTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + UpdateChequeStatusPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<GeneralLedger2_JournalVoucherTestDataType> getJournalVoucherList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(JournalVoucherPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (JournalVoucherPath));
		GeneralLedger2_JournalVoucherTestDataType[] login = gson.fromJson(bufferReader,
				GeneralLedger2_JournalVoucherTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + JournalVoucherPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<FinancialReporting_GLBalancesReportTestDataType> getGLBalancesReportList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(GLBalancesReportPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (GLBalancesReportPath));
		FinancialReporting_GLBalancesReportTestDataType[] login = gson.fromJson(bufferReader,
				FinancialReporting_GLBalancesReportTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + GLBalancesReportPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<FinancialReporting_BalanceSheetReportTestDataType> getBalanceSheetReportList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(BalanceSheetReportPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (BalanceSheetReportPath));
		FinancialReporting_BalanceSheetReportTestDataType[] login = gson.fromJson(bufferReader,
				FinancialReporting_BalanceSheetReportTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + BalanceSheetReportPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<FinancialReporting_TrialBalanceReportTestDataType> getTrialBalanceReportList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(TrialBalanceReportPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (TrialBalanceReportPath));
		FinancialReporting_TrialBalanceReportTestDataType[] login = gson.fromJson(bufferReader,
				FinancialReporting_TrialBalanceReportTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + TrialBalanceReportPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<JobScheduler_JobExecutionTestDataType> getJobExecutionList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(JobExecutionPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (JobExecutionPath));
		JobScheduler_JobExecutionTestDataType[] login = gson.fromJson(bufferReader,
				JobScheduler_JobExecutionTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + JobExecutionPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<AccountsReceivable_AppropriationTestDataType> getAppropriationList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(AppropriationPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (AppropriationPath));
		AccountsReceivable_AppropriationTestDataType[] login = gson.fromJson(bufferReader,
				AccountsReceivable_AppropriationTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + AppropriationPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<AccountingSetup_ChartOfAccountsDefinitionTestDataType> getChartOfAccountsDefinitionList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(ChartOfAccountsDefinitionPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (ChartOfAccountsDefinitionPath));
		AccountingSetup_ChartOfAccountsDefinitionTestDataType[] login = gson.fromJson(bufferReader,
				AccountingSetup_ChartOfAccountsDefinitionTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + ChartOfAccountsDefinitionPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<PettyCash_ReconciliationTestDataType> getReconciliationList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(ReconciliationPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (ReconciliationPath));
		PettyCash_ReconciliationTestDataType[] login = gson.fromJson(bufferReader,
				PettyCash_ReconciliationTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + ReconciliationPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<Reports_PettyCashTestDataType> getPettyCashList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(PettyCashPath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (PettyCashPath));
		Reports_PettyCashTestDataType[] login = gson.fromJson(bufferReader,
				Reports_PettyCashTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + PettyCashPath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

private List<AccountsReceivable_DebitNoteTestDataType> getDebitNoteList() {
	Gson gson = new Gson();
	JsonReader reader = new JsonReader(new StringReader(DebitNotePath));
	reader.setLenient(true);
	BufferedReader bufferReader = null;
	try {
		bufferReader = new BufferedReader(new FileReader (DebitNotePath));
		AccountsReceivable_DebitNoteTestDataType[] login = gson.fromJson(bufferReader,
				AccountsReceivable_DebitNoteTestDataType[].class);
		return Arrays.asList(login);
	} catch (FileNotFoundException e) {
		throw new RuntimeException("Json file not found at path : " + DebitNotePath);
	} finally {
		try {
			if (bufferReader != null)
				bufferReader.close();
		} catch (IOException ignore) {
		}
	}
}

	public final BUDGET_RequestAndAllocationTestDataType getAllowcationByName(String user) {
		return AllocationList.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}

	public final BUDGET_RequestandallocationBUDTYPEDATA getBudtypeByName(String Budtype) {
		return BudtypeList.stream().filter(x -> x.BudgetPeriod.equalsIgnoreCase(Budtype)).findAny().get();
	}

	public final BUDGET_BudgetDefinitionTestDataType getBudgetdataByName(String UName) {
		return BudgetCreationList.stream().filter(x -> x.userName.equalsIgnoreCase(UName)).findAny().get();

	}

	// UAT Budget Definition test data main function
	public final BUDGET_BudgetDefinitionUATTestDataType getUATBudgetDefinitionTestData(String username) {
		return budgetDefinitionUATTestData.stream().filter(x -> x.usertType.equalsIgnoreCase(username)).findAny().get();
	}

	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}

	public final BUDGET_SupplementarybudgetTestDataType getSupplementaryBudgetByName(String UserName) {
		return SupplementaryBudgetList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	/*
	 * public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String
	 * UserType){ return
	 * BudgetTransferList.stream().filter(x->x.User.equalsIgnoreCase(UserType)).
	 * findAny().get(); }
	 */

	public final BUDGET_CommentsFromApprover getApproverData(String UserName) {
		return reviewerCommentsList.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserName) {
		return BudgetTransferList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// AccountPayable_VendorPurchaseOrder
	public final AccountPayable_VendorPurchaseOrderTestDataType getVendorPurchaseOrderyByName(String UserName) {
		return VendorPurchaseOrderList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// InventoryMaintenance
	public final InventoryMaintenanceTestDataType getInventoryMaintenanceByName(String UserName) {
		return InventoryMaintenanceList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// InventoryManagement
	public final InventoryManagement_InventoryStockReceiptTestDataType getInventoryStockReceiptByName(String UserName) {
		return InventoryStockReceiptList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// InventoryManagement Tushar
	public final InventoryManagementTestDataType getInventoryManagementByName(String UserName) {
		return InventoryManagementList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final INVENTORY_MAINTENANCE_DenominationMasterTestDataType getDenominationMasterdata(String UserName) {
		return DenominationMasterList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType getPurchaseRequisitionConfirmationdata(
			String UserName) {
		return PurchaseRequisitionConfirmationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny()
				.get();
	}

	public final INVENTORY_InventoryStockIssueTestData getInventoryStockIssueUATTestData(String username) {
		return inventoryStockIssueTestData.stream().filter(x -> x.userType.equalsIgnoreCase(username)).findAny().get();
	}

	// Inventory - StockReturnBranch
	public final INVENTORY_InventoryManagement_DataType getStockReturnBranchByName(String user) {
		return StockReturnBranchList.stream().filter(x -> x.Usertype.equalsIgnoreCase(user)).findAny().get();
	}

	public final ACCOUNTSPAYABLE_VendorContractsTestDataType getVendorContractdata(String UserName) {
		return VendorContractsList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final ACCOUNTSPAYABLE_InvoiceBookingTestDataType getInvoiceBookingdata(String UserName) {
		return InvoiceBookingList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// FixedAsset_AssetCategory
	public final FixedAsset_AssetCategoryTestDataType getAssetCategoryByName(String UserName) {
		return AssetCategoryList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// FixedAsset_AssetDeallocation
	public final FixedAsset_AssetDeallocationTestDataType getAssetDeallocationByName(String UserName) {
		return AssetDeallocationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSET_AssetAmendmentData getAssetAmendmentByName(String Assetuser) {
		return AssetAmendmentList.stream().filter(x -> x.Usertype.equalsIgnoreCase(Assetuser)).findAny().get();
	}

	public final FIXEDASSET_AssetImpairementTestDataType getFixedAssetTestDataByName(String username) {
		return fixedAssetAssetImpairementTestData.stream().filter(x -> x.userType.equalsIgnoreCase(username)).findAny()
				.get();
	}

	public final FIXEDASSET_AssetReturnTestData getFixedAssetReturnTestDataByUserName(String username) {
		return assetReturnTestData.stream().filter(x -> x.userType.equalsIgnoreCase(username)).findAny().get();

	}

	// FixedAsset_AssetCreation
	public final FixedAsset_AssetCreationTestDataType getAssetCreationByName(String UserName) {
		return AssetCreationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSETS_AssetSaleTestDataType getAssetSaledata(String UserName) {
		return AssetSaleList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSETS_AssetUndertakingTestDataType getAssetUndertakingdata(String UserName) {
		return AssetUndertakingList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSET_AssetImpairementTestDataType getAssetImpairementdata(String UserName) {
		return AssetImpairementList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSETS_AssetRevaluationTestDataType getAssetRevaluationdata(String UserName) {
		return AssetRevaluationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final Reports_AssetCreationCommonTestDataType getAssetCreationCommondata(String UserName) {
		return AssetCreationCommonList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType getBusinessPartnerdata(String UserName) {
		return BusinessPartnerList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	// ARAP_ARandAP
	public final ARAP_ARandAPData getARAPByName(String ARAP) {
		return ARAPList.stream().filter(x -> x.User.equalsIgnoreCase(ARAP)).findAny().get();
	}

	public final ARAP_GRNCreationTestDataType getARAPGRNTestDataByName(String UserName) {
		return arapGrnCreationDataist.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final ACCOUNTSPAYABLE_PaymentSettlementTestDataType getPayementSettlementTestDataByName(String UserName) {
		return payementSettlementTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny().get();
	}

	// accountsReceivable Advance TestData
	// private List<ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType>
	// accountsReceivableAdvanceTestData ;
	public final ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType getAccountsReceivableAdvanceTestDataByName(
			String UserName) {
		return accountsReceivableAdvanceTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny()
				.get();

	}
	// ACCOUNTSRECEIVABLE_ReceiptTestData> accountsReceivableReceiptTestData

	public final ACCOUNTSRECEIVABLE_ReceiptTestData getAccountsReceivableReceiptTestDataByName(String UserName) {
		return accountsReceivableReceiptTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny()
				.get();
	}

	// AutoPayout
	// ACCOUTSAPAYBLE_AutoPayoutTestDataType> accountsAutoPayoutTestData
	public final ACCOUTSAPAYBLE_AutoPayoutTestDataType getAccountsPayableAutoPayoutTestDataByName(String UserName) {
		return accountsAutoPayoutTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny().get();
	}

	// ACCOUNTSPAYABLE_ContractReportTestData> accountspayableContractReportTestData
	public final ACCOUNTSPAYABLE_ContractReportTestData getAccountsPayableContractReportTestDataByName(
			String UserName) {
		return accountspayableContractReportTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName))
				.findAny().get();
	}

	// ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData>
	// PaymentFileUploadDwonloadTestData
	public final ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData getPaymentFileUploadDownloadTesData(String user) {
		return PaymentFileUploadDwonloadTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny()
				.get();
	}

	// Accounting Setup
	public final GL1_Accounting_Setup_Data getAccsetupByName(String Setup) {
		return AccsetupList.stream().filter(x -> x.User.equalsIgnoreCase(Setup)).findAny().get();
	}

	public final Cancellationofcontractdatatype getCancelcontractByName(String contractstatus) {
		return cancellationlist.stream().filter(x -> x.UserType.equalsIgnoreCase(contractstatus)).findAny().get();
	}

	// GL_ModuleTestData> getGlModuleTestData - ANANDH
	public final GL_ModuleTestData getGlmoduleTestDataByName(String user) {
		return glModuleTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}

	// Petty Cash
	public final PETTY_PettyCash_Data getPettycashByName(String Pettycash) {
		return PettycashList.stream().filter(x -> x.UserName.equalsIgnoreCase(Pettycash)).findAny().get();
	}

	//AccountPayable_Grn
	public final AccountPayable_GrnTestDataType getGrnByName(String UserName){
		return GrnList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	//AccountsPayable_InvoiceBooking
	public final AccountPayable_InvoiceBookingTestDataType getInvoiceBookingByName(String UserName){
		return AccountPayableInvoiceBookingList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//AccountReceivable_AccountReceivableAdvances
	public final AccountReceivable_AccountReceivableAdvancesTestDataType getAccountReceivableAdvancesByName(String UserName){
		return AccountReceivableAdvancesList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//AccountReceivable_Appropriation
	public final AccountReceivable_AppropriationTestDataType getAppropriationByName(String UserName){
		return AppropriationList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	//AccountReceivable_UpdateDepositedCheque
	public final AccountReceivable_UpdateDepositedChequeTestDataType getUpdateDepositedChequeByName(String UserName){
		return UpdateDepositedChequeList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	//ArAp_BalanceSheetReport
	public final ArAp_BalanceSheetReportTestDataType getBalanceSheetReportByName(String UserName){
		return BalanceSheetReportList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//ArAp_Enquiry
	public final ArAp_EnquiryTestDataType getArApEnquirytByName(String UserName){
		return ArApEnquiryList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//GL2_JournalVoucher
	public final GL2_JournalVoucherTestDataType getJournalVoucherByName(String UserName){
		return JournalVoucherList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//GL2_JournalVoucher_AccountEntryReport
	public final GL2_JournalVoucher_AccountEntryReportTestDataType getJournalVoucherReportByName(String UserName){
		return JournalVoucherReportList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	//GL2_FinancialTransactionReport
	public final GL2_FinancialTransactionReportTestDataType getFinancialTransactionReportByName(String UserName){
		return FinancialTransactionReportList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	//GL2_LegalEntityGLConfig
	public final GL2_LegalEntityGLConfigTestDataType getLegalEntityGLConfigByName(String UserName){
		return LegalEntityGLConfigList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	//AccountsPayable_ManualPayoutEmployee
	public final AccountsPayable_ManualPayoutEmployeeTestDataType getManualPayoutByName(String UserName){
		return ManualPayoutEmployeeList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	//d-------------
	public final ACCOUNTSPAYABLE_ManualPayoutTestDataType getManualPayoutdata(String UserName) {
		return ManualPayoutList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType getPaymentSettlementCancellationdata(String UserName) {
		return PaymentSettlementCancellationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final AccountsReceivable_ReceiptsReversalsTestDataType getReceiptsReversalsdata(String UserName) {
		return ReceiptsReversalsList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final AccountsReceivable_UpdateChequeStatusTestDataType getUpdateChequeStatusdata(String UserName) {
		return UpdateChequeStatusList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final GeneralLedger2_JournalVoucherTestDataType getJournalVoucherdata(String UserName) {
		return JournalVoucher1List.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FinancialReporting_GLBalancesReportTestDataType getGLBalancesReportdata(String UserName) {
		return GLBalancesReportList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FinancialReporting_BalanceSheetReportTestDataType getBalanceSheetReportdata(String UserName) {
		return BalanceSheetReport1List.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FinancialReporting_TrialBalanceReportTestDataType getTrialBalanceReportdata(String UserName) {
		return TrialBalanceReportList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final JobScheduler_JobExecutionTestDataType getJobExecutiondata(String UserName) {
		return JobExecutionList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final AccountsReceivable_AppropriationTestDataType getAppropriationdata(String UserName) {
		return Appropriation1List.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final AccountingSetup_ChartOfAccountsDefinitionTestDataType getChartOfAccountsDefinitiondata(String UserName) {
		return ChartOfAccountsDefinitionList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final PettyCash_ReconciliationTestDataType getReconciliationdata(String UserName) {
		return ReconciliationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final Reports_PettyCashTestDataType getPettyCashdata(String UserName) {
		return PettyCashList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final AccountsReceivable_DebitNoteTestDataType getDebitNotedata(String UserName) {
		return DebitNoteList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
}