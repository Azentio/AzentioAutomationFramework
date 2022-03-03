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
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_ManualPayoutTestDataType;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.AccountsReceivable_ReceiptsReversalsTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType;
import testDataType.FIXEDASSETS_AssetCreationTestDataType;
import testDataType.FIXEDASSETS_AssetImpairementTestDataType;
import testDataType.FIXEDASSETS_AssetRevaluationTestDataType;
import testDataType.FIXEDASSETS_AssetSaleTestDataType;
import testDataType.FIXEDASSETS_AssetUndertakingTestDataType;
import testDataType.INVENTORY_MAINTENANCE_DenominationMasterTestDataType;
import testDataType.INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.RegisterData;

public class JsonConfig {
	ConfigFileReader configFileReader = new ConfigFileReader();

	// Examples
	/*
	 * private final String RegisterFilePath = configFileReader.getJsonPath() +
	 * "RegisterJson.json"; private List<RegisterData> RegisterList;
	 * 
	 * private final String LoginFilePath = configFileReader.getJsonPath() +
	 * "LoginJson.json"; private List<Logindata> LoginList;
	 */

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
	private List<BUDGET_BudgetCreationTestDataType> BudgetCreationList;

	// Budget_SupplementaryBudget
	private final String BudgetFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;

	// Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;

	// ACCOUNTSPAYABLE_VendorContract
	private final String VendorContractsPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_VendorContractsJSON.json";
	private List<ACCOUNTSPAYABLE_VendorContractsTestDataType> VendorContractsList;
	
	// ACCOUNTSPAYABLE_InvoiceBooking
	private final String InvoiceBookingPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_InvoiceBookingJSON.json";
	private List<ACCOUNTSPAYABLE_InvoiceBookingTestDataType> InvoiceBookingList;
	
	// INVENTORY_MAINTENANCE_DenominationMaster
	private final String DenominationMasterPath = configFileReader.getJsonPath() + "INVENTORY_MAINTENANCE_DenominationMasterJSON.json";
	private List<INVENTORY_MAINTENANCE_DenominationMasterTestDataType> DenominationMasterList;
	
	// INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmation
	private final String PurchaseRequisitionConfirmationPath = configFileReader.getJsonPath() + "INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationJSON.json";
	private List<INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType> PurchaseRequisitionConfirmationList;
	
	// FIXEDASSETS_AssetSale
	private final String AssetSalePath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetSaleJSON.json";
	private List<FIXEDASSETS_AssetSaleTestDataType> AssetSaleList;
	
	// FIXEDASSETS_AssetUndertaking
	private final String AssetUndertakingPath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetUndertakingJSON.json";
	private List<FIXEDASSETS_AssetUndertakingTestDataType> AssetUndertakingList;
	
	// BUSINESS_PARTNER_SETUP_BusinessPartner
	private final String BusinessPartnerPath = configFileReader.getJsonPath() + "BUSINESS_PARTNER_SETUP_BusinessPartnerJSON.json";
	private List<BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType> BusinessPartnerList;
	
	// FIXEDASSETS_AssetCreation
	private final String AssetCreationPath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetCreationJSON.json";
	private List<FIXEDASSETS_AssetCreationTestDataType>  AssetCreationList;
	
	// FIXEDASSETS_AssetImpairement
	private final String AssetImpairementPath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetImpairementJSON.json";
	private List<FIXEDASSETS_AssetImpairementTestDataType>  AssetImpairementList;
	
	// FIXEDASSETS_AssetRevaluation
	private final String AssetRevaluationPath = configFileReader.getJsonPath() + "FIXEDASSETS_AssetRevaluationJSON.json";
	private List<FIXEDASSETS_AssetRevaluationTestDataType>  AssetRevaluationList;
	
	// ACCOUNTSPAYABLE_ManualPayout
	private final String ManualPayoutPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_ManualPayoutJSON.json";
	private List<ACCOUNTSPAYABLE_ManualPayoutTestDataType>  ManualPayoutList;
	
	// ACCOUNTSPAYABLE_PaymentSettlementCancellation
	private final String PaymentSettlementCancellationPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_PaymentSettlementCancellationJSON.json";
	private List<ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType>  PaymentSettlementCancellationList;
	
	// AccountsReceivable_ReceiptsReversals
	private final String ReceiptsReversalsPath = configFileReader.getJsonPath() + "AccountsReceivable_ReceiptsReversalsJSON.json";
	private List<AccountsReceivable_ReceiptsReversalsTestDataType>  ReceiptsReversalsList;

	
	public JsonConfig() {
		/*
		 * RegisterList = getRegisterData(); LoginList = getLoginList();
		 */
		AllocationList = getAllocationList();
		BudtypeList = getBudtypeList();
		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();
		SupplementaryBudgetList = getSupplementaryBudgetList();
		BudgetTransferList = getBudgetTransferData();
		VendorContractsList = getVendorContractList();
		InvoiceBookingList = getInvoiceBookingList();
		DenominationMasterList = getDenominationMasterList();
		PurchaseRequisitionConfirmationList = getPurchaseRequisitionConfirmationList();
		AssetSaleList = getAssetSaleList();
		AssetUndertakingList = getAssetUndertakingList();
		BusinessPartnerList = getBusinessPartnerList();
		 AssetCreationList = getAssetCreationList();
		 AssetImpairementList = getAssetImpairementList();
		 AssetRevaluationList = getAssetRevaluationList();
		 ManualPayoutList = getManualPayoutList();
		 PaymentSettlementCancellationList = getPaymentSettlementCancellationList();
		 ReceiptsReversalsList = getReceiptsReversalsList();
	}

	/*
	 * private List<RegisterData> getRegisterData() { Gson gson = new Gson();
	 * JsonReader reader = new JsonReader(new StringReader(RegisterFilePath));
	 * reader.setLenient(true);
	 * 
	 * 
	 * BufferedReader bufferReader = null; try { bufferReader = new
	 * BufferedReader(new FileReader(RegisterFilePath)); RegisterData[] registers =
	 * gson.fromJson(bufferReader, RegisterData[].class); return
	 * Arrays.asList(registers); } catch (FileNotFoundException e) { throw new
	 * RuntimeException("Json file not found at path : " + RegisterFilePath); }
	 * finally { try { if (bufferReader != null) bufferReader.close(); } catch
	 * (IOException ignore) { } } }
	 * 
	 * private List<Logindata> getLoginList() { Gson gson = new Gson(); JsonReader
	 * reader = new JsonReader(new StringReader(LoginFilePath));
	 * reader.setLenient(true); BufferedReader bufferReader = null; try {
	 * bufferReader = new BufferedReader(new FileReader(LoginFilePath)); Logindata[]
	 * login = gson.fromJson(bufferReader, Logindata[].class); return
	 * Arrays.asList(login); } catch (FileNotFoundException e) { throw new
	 * RuntimeException("Json file not found at path : " + RegisterFilePath); }
	 * finally { try { if (bufferReader != null) bufferReader.close(); } catch
	 * (IOException ignore) { } } }
	 */

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

	private List<BUDGET_BudgetCreationTestDataType> getBudgetList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(BudgetCreationPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetCreationPath));
			BUDGET_BudgetCreationTestDataType[] budget = gson.fromJson(bufferReader,
					BUDGET_BudgetCreationTestDataType[].class);
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
	
	private List<FIXEDASSETS_AssetCreationTestDataType> getAssetCreationList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AssetCreationPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader (AssetCreationPath));
			FIXEDASSETS_AssetCreationTestDataType[] login = gson.fromJson(bufferReader,
					FIXEDASSETS_AssetCreationTestDataType[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + AssetCreationPath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	private List<FIXEDASSETS_AssetImpairementTestDataType> getAssetImpairementList() {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(AssetImpairementPath));
		reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader (AssetImpairementPath));
			FIXEDASSETS_AssetImpairementTestDataType[] login = gson.fromJson(bufferReader,
					FIXEDASSETS_AssetImpairementTestDataType[].class);
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

	/*
	 * public final RegisterData getRegisterByName(String customerName) { return
	 * RegisterList.stream().filter(x ->
	 * x.FirstName.equalsIgnoreCase(customerName)).findAny().get(); }
	 * 
	 * public final Logindata getLoginByName(String UserName) { return
	 * LoginList.stream().filter(x ->
	 * x.User.equalsIgnoreCase(UserName)).findAny().get(); }
	 */
	public final BUDGET_RequestAndAllocationTestDataType getAllowcationByName(String user) {
		return AllocationList.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}

	public final BUDGET_RequestandallocationBUDTYPEDATA getBudtypeByName(String Budtype) {
		return BudtypeList.stream().filter(x -> x.BudgetPeriod.equalsIgnoreCase(Budtype)).findAny().get();
	}

	public final BUDGET_BudgetCreationTestDataType getBudgetdataByName(String UName) {
		return BudgetCreationList.stream().filter(x -> x.UserName.equalsIgnoreCase(UName)).findAny().get();
		// return RegisterList.stream().filter(x ->
		// x.FirstName.equalsIgnoreCase(customerName)).findAny().get();
	}

	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}

	public final BUDGET_SupplementarybudgetTestDataType getSupplementaryBudgetByName(String UserName) {
		return SupplementaryBudgetList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserName) {
		return BudgetTransferList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final ACCOUNTSPAYABLE_VendorContractsTestDataType getVendorContractdata(String UserName) {
		return VendorContractsList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final ACCOUNTSPAYABLE_InvoiceBookingTestDataType getInvoiceBookingdata(String UserName) {
		return InvoiceBookingList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final INVENTORY_MAINTENANCE_DenominationMasterTestDataType getDenominationMasterdata(String UserName) {
		return DenominationMasterList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType getPurchaseRequisitionConfirmationdata(String UserName) {
		return PurchaseRequisitionConfirmationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final FIXEDASSETS_AssetSaleTestDataType getAssetSaledata(String UserName) {
		return AssetSaleList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FIXEDASSETS_AssetUndertakingTestDataType getAssetUndertakingdata(String UserName) {
		return AssetUndertakingList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final BUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType getBusinessPartnerdata(String UserName) {
		return BusinessPartnerList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FIXEDASSETS_AssetCreationTestDataType getAssetCreationdata(String UserName) {
		return AssetCreationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FIXEDASSETS_AssetImpairementTestDataType getAssetImpairementdata(String UserName) {
		return AssetImpairementList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final FIXEDASSETS_AssetRevaluationTestDataType getAssetRevaluationdata(String UserName) {
		return AssetRevaluationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final ACCOUNTSPAYABLE_ManualPayoutTestDataType getManualPayoutdata(String UserName) {
		return ManualPayoutList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType getPaymentSettlementCancellationdata(String UserName) {
		return PaymentSettlementCancellationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final AccountsReceivable_ReceiptsReversalsTestDataType getReceiptsReversalsdata(String UserName) {
		return ReceiptsReversalsList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
}
