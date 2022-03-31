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
import testDataType.ACCOUNTSPAYABLE_PaymentFileUploadDownloadTestData;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_AccountsReceivableAdvanceTestDataType;
import testDataType.ACCOUNTSRECEIVABLE_ReceiptTestData;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;
import testDataType.ARAP_GRNCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;
import testDataType.BUDGET_CommentsFromApprover;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.FIXEDASSET_AixedAssetDeAllocationTestData;
import testDataType.FIXEDASSET_AssetImpairementTestDataType;
import testDataType.FIXEDASSET_AssetReturnTestData;
import testDataType.GL_ModuleTestData;
import testDataType.INVENTORY_EnquiryGlTestData;
import testDataType.INVENTORY_InventoryStockIssueTestData;
import testDataType.KUBS_LoginTestDataType;

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

	private final String BudgetReviewerCommentFilePath = configFileReader.getJsonPath() + "BUDGET_ReviewerRemarks.json";
	private List<BUDGET_CommentsFromApprover> reviewerCommentsList;
	
	private final String BudgetDefinitionUATFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetDefinitionUATJSON.json";
	private List<BUDGET_BudgetDefinitionUATTestDataType> budgetDefinitionUATTestData;
	
	private final String InventoryGlFilePath = configFileReader.getJsonPath() + "INVENTORY_EnquiryGlJSON.json";
	private List<INVENTORY_EnquiryGlTestData> inventoryGlReportTestData;
    //Inventory stock issue
	private final String InventoryStockIssueFilePath = configFileReader.getJsonPath() + "INVENTORY_InventoryStockIssue.json";
	private List<INVENTORY_InventoryStockIssueTestData> inventoryStockIssueTestData;
	
	//assetImpairement
	private final String FixedAssetImpairementFilePath = configFileReader.getJsonPath() + "FIXEDASSET_AssetImpairementJSON.json";
	private List<FIXEDASSET_AssetImpairementTestDataType> fixedAssetAssetImpairementTestData;
	//assetReturn 
	private final String fixedAssetReturnFilepath = configFileReader.getJsonPath() + "FIXEDASSET_AssetReturnJSON.json";
	private List<FIXEDASSET_AssetReturnTestData> assetReturnTestData ;
	private final String fixedAssetDeAllocationFilepath = configFileReader.getJsonPath() + "FIXEDASSET_FixedAssetDeAllocationJSON.json";
	private List<FIXEDASSET_AixedAssetDeAllocationTestData> assetDeAllocationTestData ;
	//ArAP
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
	
	
	//GlModule
	private final String glModuleFilePath = configFileReader.getJsonPath() + "GL_Module.json";
	private List<GL_ModuleTestData> glModuleTestData;
	public JsonConfig() {

		AllocationList = getAllocationList();
		BudtypeList = getBudtypeList();
		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();
		reviewerCommentsList = getApproverCommentsData();
		budgetDefinitionUATTestData=getBudgetDefinitionUATTestData();
		inventoryGlReportTestData=getInventoryGlTestData();
		inventoryStockIssueTestData=getInventoryStockIssueTestData();
		fixedAssetAssetImpairementTestData=getFixedAssetImpairementTestData();
		assetReturnTestData=getFixedAssetReturnTestData();
		assetDeAllocationTestData=getFixedAssetDeAllocationTestData();
		arapGrnCreationDataist=getARAPGRNAndPoTestData();
		payementSettlementTestData=getPaymentSettlementTestData();
		accountsReceivableAdvanceTestData=getAccounteReceivableAdvanceTestData();
		accountsReceivableReceiptTestData=getAccounteReceivableReceiptTestData();
		accountsAutoPayoutTestData=getAccountsPayableAutoPayoutTestData();
		accountspayableContractReportTestData= getAccountsPayableContractReportTestData();
		PaymentFileUploadDwonloadTestData=getPaymentFileUploadDwonloadTestData();
		glModuleTestData= getGlModuleTestData();
		
	}
	//Gl module TestData
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
	
	//AssetDeAllocation
	private List<FIXEDASSET_AixedAssetDeAllocationTestData> getFixedAssetDeAllocationTestData() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(fixedAssetDeAllocationFilepath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(fixedAssetDeAllocationFilepath));
			FIXEDASSET_AixedAssetDeAllocationTestData[] assetDeAllocationTestData = gson.fromJson(bufferReader,
					FIXEDASSET_AixedAssetDeAllocationTestData[].class);
			return Arrays.asList(assetDeAllocationTestData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + fixedAssetDeAllocationFilepath);
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
	
			
		
	public final BUDGET_RequestAndAllocationTestDataType getAllowcationByName(String user) {
		return AllocationList.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}

	public final BUDGET_RequestandallocationBUDTYPEDATA getBudtypeByName(String Budtype) {
		return BudtypeList.stream().filter(x -> x.BudgetPeriod.equalsIgnoreCase(Budtype)).findAny().get();
	}

	public final BUDGET_BudgetDefinitionTestDataType getBudgetdataByName(String UName) {
		return BudgetCreationList.stream().filter(x -> x.userName.equalsIgnoreCase(UName)).findAny().get();

	}

	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}

	public final BUDGET_CommentsFromApprover getApproverData(String UserName) {
		return reviewerCommentsList.stream().filter(x -> x.UserType.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final BUDGET_BudgetDefinitionUATTestDataType getUATBudgetDefinitionTestData(String username) {
		return budgetDefinitionUATTestData.stream().filter(x ->x.usertType.equalsIgnoreCase(username)).findAny().get();
	}
	public final INVENTORY_EnquiryGlTestData getInventoryGlUATTestData(String username) {
		return inventoryGlReportTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	public final INVENTORY_InventoryStockIssueTestData getInventoryStockIssueUATTestData(String username) {
		return inventoryStockIssueTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	public final FIXEDASSET_AssetImpairementTestDataType getFixedAssetTestDataByName(String username) {
		return fixedAssetAssetImpairementTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	public final FIXEDASSET_AssetReturnTestData getFixedAssetReturnTestDataByUserName(String username) {
		return assetReturnTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
		
	}
	public final FIXEDASSET_AixedAssetDeAllocationTestData getAssetDeallocationByName(String UserName){
		return assetDeAllocationTestData.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
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
		//GL_ModuleTestData> getGlModuleTestData
		public final GL_ModuleTestData getGlmoduleTestDataByName(String user) {
			return glModuleTestData.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
		}
}
