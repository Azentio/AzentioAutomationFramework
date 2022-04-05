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
import testDataType.ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_ReceiptTestData;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;
import testDataType.ARAP_ARandAPData;
import testDataType.ARAP_GRNCreationTestDataType;
import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_CommentsFromApprover;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.Cancellationofcontractdatatype;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FIXEDASSET_AssetReturnTestData;
import testDataType.GL1_Accounting_Setup_Data;
import testDataType.GL_ModuleTestData;
import testDataType.INVENTORY_EnquiryGlTestData;
import testDataType.INVENTORY_InventoryManagement_DataType;
import testDataType.INVENTORY_InventoryStockIssueTestData;
import testDataType.INVENTORY_MAINTENANCE_DenominationMasterTestDataType;
import testDataType.INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType;
import testDataType.InventoryMaintenanceTestDataType;
import testDataType.InventoryManagementTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.PETTY_PettyCash_Data;

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

	// Budget_BudgetCreation
	private final String BudgetCreationPath = configFileReader.getJsonPath() + "BUDGET_BudgetCreationJSON.json";
	private List<BUDGET_BudgetDefinitionTestDataType> BudgetCreationList;

	// UAT Budget Definition
	private final String BudgetDefinitionUATFilePath = configFileReader.getJsonPath()
			+ "BUDGET_BudgetDefinitionUATJSON.json";
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
	private final String InventoryStockIssueFilePath = configFileReader.getJsonPath()
			+ "INVENTORY_InventoryStockIssue.json";
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
	
	// FixedAsset_Amendment
	private final String AssetAmendmentFilePath = configFileReader.getJsonPath() + "FIXEDASSET_AssetAmendment.json";
	private List<FIXEDASSET_AssetAmendmentData> AssetAmendmentList;
	// assetImpairement
	private final String FixedAssetImpairementFilePath = configFileReader.getJsonPath()
			+ "FIXEDASSET_AssetImpairementJSON.json";
	private List<FIXEDASSET_AssetImpairementTestDataType> fixedAssetAssetImpairementTestData;
	// assetReturn
	private final String fixedAssetReturnFilepath = configFileReader.getJsonPath() + "FIXEDASSET_AssetReturnJSON.json";
	private List<FIXEDASSET_AssetReturnTestData> assetReturnTestData;
	// ARAP_ARandAP
		private final String ARandAPFilePath = configFileReader.getJsonPath() + "ARAP_ARandAP.json";
		private List<ARAP_ARandAPData> ARAPList;
		
		private final String ARAPGRNCreationFilepath = configFileReader.getJsonPath() + "ARAP_GRNCreationJSON.json";
		private List<ARAP_GRNCreationTestDataType> arapGrnCreationDataist ;
		//invoice bill booking
		private final String PaymentSettlementFilePath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_PayementSettlementJSON.json";
		private List<ACCOUNTSPAYABLE_PaymentSettlementTestDataType> payementSettlementTestData ;
		//AccountsPayablle Advance
		private final String AccountsReceivableAdvanceFilePath = configFileReader.getJsonPath() + "ACCOUNTSRECEIVABLE_AccountsReceivableTestDataJson.json";
		private List<ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType> accountsReceivableAdvanceTestData ;
		
		private final String AccountsReceivablereceiptFilePath = configFileReader.getJsonPath() + "ACCOUNTSRECEIVABLE_ReceiptJSON.json";
		private List<ACCOUNTSRECEIVABLE_ReceiptTestData> accountsReceivableReceiptTestData ;
		//AutoPayout
		private final String AccountsPayableAutoPayoutFilePath = configFileReader.getJsonPath() + "ACCOUTSPAYABLE_AutoPayoutJSON.json";
		private List<ACCOUTSAPAYBLE_AutoPayoutTestDataType> accountsAutoPayoutTestData ;
		//ContractReport
		private final String AccountsPayableContractReportFilePath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_ReportDataJSON.json";
		private List<ACCOUNTSPAYABLE_ContractReportTestData> accountspayableContractReportTestData;
		
		private final String accountsPayablePaymentFileUploadDownloadFilePath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_PaymentFileUploadDownloadJSON.json";
		private List<ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData> PaymentFileUploadDwonloadTestData;
	// GL -Accounting setup
	private final String AccsetupFilePath = configFileReader.getJsonPath() + "GL1_Accounting_Setup.json";
	private List<GL1_Accounting_Setup_Data> AccsetupList;

	//GlModule - Anandh
	private final String glModuleFilePath = configFileReader.getJsonPath() + "GL_Module.json";
	private List<GL_ModuleTestData> glModuleTestData;
	
	private final String cancellationofcontractpath = configFileReader.getJsonPath() + "cancellationofcontract.json";
	private List<Cancellationofcontractdatatype> cancellationlist;
	
	// Petty Cash
	private final String PettycashFilePath = configFileReader.getJsonPath() + "PETTY_PettyCash.json";
	private List<PETTY_PettyCash_Data> PettycashList;

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
		VendorPurchaseOrderList = getVendorPurchaseOrderData();
		InventoryMaintenanceList = getInventoryMaintenanceListData();
		InventoryStockReceiptList = getInventoryStockReceiptListData();
		inventoryGlReportTestData=getInventoryGlTestData();
		InventoryManagementList = getInventoryManagementList();
		DenominationMasterList = getDenominationMasterList();
		PurchaseRequisitionConfirmationList = getPurchaseRequisitionConfirmationList();
		VendorContractsList = getVendorContractList();
		InvoiceBookingList = getInvoiceBookingList();
		AssetAmendmentList = getAssetAmendmentList();
		fixedAssetAssetImpairementTestData=getFixedAssetImpairementTestData();
		assetReturnTestData=getFixedAssetReturnTestData();
		// ARAP_ARandAP
				ARAPList = getARAPList();
				arapGrnCreationDataist=getARAPGRNAndPoTestData();
				payementSettlementTestData=getPaymentSettlementTestData();
				accountsReceivableAdvanceTestData=getAccounteReceivableAdvanceTestData();
				accountsReceivableReceiptTestData=getAccounteReceivableReceiptTestData();
				accountsAutoPayoutTestData=getAccountsPayableAutoPayoutTestData();
				accountspayableContractReportTestData= getAccountsPayableContractReportTestData();
				PaymentFileUploadDwonloadTestData=getPaymentFileUploadDwonloadTestData();
		// Accounting Setup
		AccsetupList = getAccsetupList();
	
		// GL module - Anandh
		glModuleTestData= getGlModuleTestData();
		cancellationlist = getCancellationlist();
		
		// Petty Cash
		PettycashList = getPettycashList();
		inventoryStockIssueTestData=getInventoryStockIssueTestData();
		
	}
	
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
	//inventiry Gl
	private List<INVENTORY_EnquiryGlTestData> getInventoryGlTestData() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(InventoryGlFilePath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryGlFilePath));
			INVENTORY_EnquiryGlTestData[] inventoryGlReportTestData = gson.fromJson(bufferReader,
					INVENTORY_EnquiryGlTestData[].class);
			return Arrays.asList(inventoryGlReportTestData);
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

		//PaymentFile Upload download 
		private List<ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData> getPaymentFileUploadDwonloadTestData() {
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(accountsPayablePaymentFileUploadDownloadFilePath));
			reader.setLenient(true);
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader(accountsPayablePaymentFileUploadDownloadFilePath));
				ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData[] paymentFileUploadDownloadTestData = gson.fromJson(bufferReader,
						ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData[].class);
				return Arrays.asList(paymentFileUploadDownloadTestData);
			} catch (FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + accountsPayablePaymentFileUploadDownloadFilePath);
			} finally {
				try {
					if (bufferReader != null)
						bufferReader.close();
				} catch (IOException ignore) {
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
	}

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

	public final FIXEDASSET_AssetAmendmentData getAssetAmendmentByName(String Assetuser) {
		return AssetAmendmentList.stream().filter(x -> x.Usertype.equalsIgnoreCase(Assetuser)).findAny().get();
	}
	
	public final FIXEDASSET_AssetImpairementTestDataType getFixedAssetTestDataByName(String username) {
		return fixedAssetAssetImpairementTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	public final FIXEDASSET_AssetReturnTestData getFixedAssetReturnTestDataByUserName(String username) {
		return assetReturnTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
		
	}
	// ARAP_ARandAP
		public final ARAP_ARandAPData getARAPByName(String ARAP) {
			return ARAPList.stream().filter(x -> x.User.equalsIgnoreCase(ARAP)).findAny().get();
		}
		public final ARAP_GRNCreationTestDataType getARAPGRNTestDataByName(String UserName){
			return arapGrnCreationDataist.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
		}
		public final ACCOUNTSPAYABLE_PaymentSettlementTestDataType getPayementSettlementTestDataByName(String UserName){
			return payementSettlementTestData.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
		}
	//accountsReceivable Advance TestData
		//private List<ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType> accountsReceivableAdvanceTestData ;
		public final ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType getAccountsReceivableAdvanceTestDataByName(String UserName){
			return accountsReceivableAdvanceTestData.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
			
		}
			//ACCOUNTSRECEIVABLE_ReceiptTestData> accountsReceivableReceiptTestData
			
			public final ACCOUNTSRECEIVABLE_ReceiptTestData getAccountsReceivableReceiptTestDataByName(String UserName){
				return accountsReceivableReceiptTestData.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
		}
			
			//AutoPayout
			//ACCOUTSAPAYBLE_AutoPayoutTestDataType> accountsAutoPayoutTestData
			public final ACCOUTSAPAYBLE_AutoPayoutTestDataType getAccountsPayableAutoPayoutTestDataByName(String UserName){
				return accountsAutoPayoutTestData.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
		}
		//ACCOUNTSPAYABLE_ContractReportTestData> accountspayableContractReportTestData
			public final ACCOUNTSPAYABLE_ContractReportTestData getAccountsPayableContractReportTestDataByName(String UserName){
				return accountspayableContractReportTestData.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
		}
			//ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData> PaymentFileUploadDwonloadTestData
			public final ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData getPaymentFileUploadDownloadTesData(String user) {
				return PaymentFileUploadDwonloadTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
			}
	

	// Accounting Setup
	public final GL1_Accounting_Setup_Data getAccsetupByName(String Setup) {
		return AccsetupList.stream().filter(x -> x.User.equalsIgnoreCase(Setup)).findAny().get();
	}
	public final Cancellationofcontractdatatype getCancelcontractByName(String contractstatus) {
		return cancellationlist.stream().filter(x -> x.UserType.equalsIgnoreCase(contractstatus)).findAny().get();
	}
	
	//GL_ModuleTestData> getGlModuleTestData - ANANDH
	public final GL_ModuleTestData getGlmoduleTestDataByName(String user) {
		return glModuleTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}
	
	// Petty Cash
	public final PETTY_PettyCash_Data getPettycashByName(String Pettycash) {
		return PettycashList.stream().filter(x -> x.UserName.equalsIgnoreCase(Pettycash)).findAny().get();
	}
	
}