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

import testDataType.ARAP_ARandAPData;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.FIXEDASSET_AssetAmendmentData;
import testDataType.GL1_Accounting_Setup_Data;
import testDataType.INVENTORY_InventoryManagement_DataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.PETTY_PettyCash_Data;
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

	// Inventory_StockReturnBranch
	private final String StockReturnBranchFilePath = configFileReader.getJsonPath()
			+ "INVENTORY_InventoryManagement.json";
	private List<INVENTORY_InventoryManagement_DataType> StockReturnBranchList;

	// FixedAsset_Amendment
	private final String AssetAmendmentFilePath = configFileReader.getJsonPath() + "FIXEDASSET_AssetAmendment.json";
	private List<FIXEDASSET_AssetAmendmentData> AssetAmendmentList;

	// ARAP_ARandAP
	private final String ARandAPFilePath = configFileReader.getJsonPath() + "ARAP_ARandAP.json";
	private List<ARAP_ARandAPData> ARAPList;

	// Accounting setup
	private final String AccsetupFilePath = configFileReader.getJsonPath() + "GL1_Accounting_Setup.json";
	private List<GL1_Accounting_Setup_Data> AccsetupList;

	// Petty Cash
	private final String PettycashFilePath = configFileReader.getJsonPath() + "PETTY_PettyCash.json";
	private List<PETTY_PettyCash_Data> PettycashList;

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

		// Inventory - StockReturn
		StockReturnBranchList = getStockReturnBranchList();

		// FixedAsset_Amendment
		AssetAmendmentList = getAssetAmendmentList();

		// ARAP_ARandAP
		ARAPList = getARAPList();

		// Accounting Setup
		AccsetupList = getAccsetupList();
		
		// Petty Cash
		PettycashList = getPettycashList();
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
	// Inventory - StockReturnBranch
	private List<INVENTORY_InventoryManagement_DataType> getStockReturnBranchList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(StockReturnBranchFilePath));
			INVENTORY_InventoryManagement_DataType[] StockReturn = gson.fromJson(bufferReader,
					INVENTORY_InventoryManagement_DataType[].class);
			return Arrays.asList(StockReturn);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + StockReturnBranchFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	// FixedAsset_Amendment
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

	// Inventory - StockReturnBranch
	public final INVENTORY_InventoryManagement_DataType getStockReturnBranchByName(String user) {
		return StockReturnBranchList.stream().filter(x -> x.Usertype.equalsIgnoreCase(user)).findAny().get();
	}

	// Fixed_Asset
	public final FIXEDASSET_AssetAmendmentData getAssetAmendmentByName(String Assetuser) {
		return AssetAmendmentList.stream().filter(x -> x.Usertype.equalsIgnoreCase(Assetuser)).findAny().get();
	}

	// ARAP_ARandAP
	public final ARAP_ARandAPData getARAPByName(String ARAP) {
		return ARAPList.stream().filter(x -> x.User.equalsIgnoreCase(ARAP)).findAny().get();
	}

	// Accounting Setup
	public final GL1_Accounting_Setup_Data getAccsetupByName(String Setup) {
		return AccsetupList.stream().filter(x -> x.User.equalsIgnoreCase(Setup)).findAny().get();
	}
	
	// Petty Cash
	public final PETTY_PettyCash_Data getPettycashByName(String Pettycash) {
		return PettycashList.stream().filter(x -> x.UserName.equalsIgnoreCase(Pettycash)).findAny().get();
	}
	
}
