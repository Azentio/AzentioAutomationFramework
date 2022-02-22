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

import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.FixedAsset_AssetAllocationTestDataType;
import testDataType.FixedAsset_AssetCategoryTestDataType;
import testDataType.FixedAsset_AssetCreationTestDataType;
import testDataType.FixedAsset_AssetDeallocationTestDataType;
import testDataType.INVENTORY_EnquiryGLTestDataType;
import testDataType.InventoryMaintenanceTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;
import testDataType.KUBS_LoginTestDataType;

public class JsonConfig {
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	//Examples
/*	private final String RegisterFilePath = configFileReader.getJsonPath() + "RegisterJson.json";
	private List<RegisterData> RegisterList;

	private final String LoginFilePath = configFileReader.getJsonPath() + "LoginJson.json";
	private List<Logindata> LoginList;*/

	
	
	//Users_Login
	private final String AzentioLoginDataPath = configFileReader.getJsonPath() + "KUBS_LoginDataJSON.json";
	private List<KUBS_LoginTestDataType> credentialslist;

	
	//Budget_RequestandAllocation
	private final String AllocationFilePath = configFileReader.getJsonPath() + "BUDGET_RequestAndAllocationJSON.json";
	private List<BUDGET_RequestAndAllocationTestDataType> AllocationList;

private final String BudtypeFilepath = configFileReader.getJsonPath() + "BUDGET_RequestandallocationBUDTYPE.json";
	private List<BUDGET_RequestandallocationBUDTYPEDATA> BudtypeList;

	
	//Budget_BudgetCreation
	private final String BudgetCreationPath = configFileReader.getJsonPath() + "BUDGET_BudgetCreationJSON.json";
	private List<BUDGET_BudgetCreationTestDataType> BudgetCreationList;

	
	//Budget_SupplementaryBudget

	private final String BudgetSupplementaryFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;
	
	//Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;
	
	//AccountPayable_VendorPurchaseOrder
	private final String VendorPurchaseOrderFilePath = configFileReader.getJsonPath() + "AccountPayable_VendorPurchaseOrderJson.json";
	private List<AccountPayable_VendorPurchaseOrderTestDataType> VendorPurchaseOrderList;
	
	//InventoryMaintenance
	private final String InventoryMaintenanceFilePath = configFileReader.getJsonPath() + "InventoryMaintenanceJson.json";
	private List<InventoryMaintenanceTestDataType> InventoryMaintenanceList;


	//InventoryManagement_InventoryStockReceipt
	private final String InventoryStockReceiptFilePath = configFileReader.getJsonPath() + "InventoryManagement_InventoryStockReceiptJSON.json";
	private List<InventoryManagement_InventoryStockReceiptTestDataType> InventoryStockReceiptList;
	
	//Inventory_EnquiryGL
		private final String InventoryEnquiryGLFilePath = configFileReader.getJsonPath() + "INVENTORY_EnquiryGLJSON.json";
		private List<INVENTORY_EnquiryGLTestDataType> InventoryEnquiryGLList;
		
	//FixedAsset_AssetCategory
		private final String AssetCategoryFilePath = configFileReader.getJsonPath() + "FixedAsset_AssetCategoryJSON.json";
		private List<FixedAsset_AssetCategoryTestDataType> AssetCategoryList;
		
		// FixedAsset_AssetDeallocation
		private final String AssetDeallocationFilePath = configFileReader.getJsonPath()
				+ "FixedAsset_AssetDeallocationJSON.json";
		private List<FixedAsset_AssetDeallocationTestDataType> AssetDeallocationList;

		// FixedAsset_AssetAllocation
		private final String AssetAllocationFilePath = configFileReader.getJsonPath()
				+ "FixedAsset_AssetAllocationJSON.json";
		private List<FixedAsset_AssetAllocationTestDataType> AssetAllocationList;
		// FixedAsset_AssetCreation

		private final String AssetCreationFilePath = configFileReader.getJsonPath()
				+ "FixedAsset_AssetCreationJSON.json";
		private List<FixedAsset_AssetCreationTestDataType> AssetCreationList;

	public JsonConfig() {
		/*RegisterList = getRegisterData();
		LoginList = getLoginList();*/

		AllocationList = getAllocationList();		
		BudtypeList = getBudtypeList();

		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();
		
		SupplementaryBudgetList = getSupplementaryBudgetData();
		
		BudgetTransferList=getBudgetTransferData();
		
	    VendorPurchaseOrderList = getVendorPurchaseOrderData();
		
	    InventoryMaintenanceList =  getInventoryMaintenanceListData();
	    InventoryStockReceiptList = getInventoryStockReceiptListData();
	    InventoryEnquiryGLList = getInventoryEnquiryGLListData();
	    
	    AssetCategoryList = getAssetCategoryListData();
	    
	    AssetDeallocationList =  getAssetDeallocationListData();
	    AssetCreationList = getAssetCreationListData();
	    AssetAllocationList =  getAssetAllocationListData();
	}






	/*private List<RegisterData> getRegisterData() {
		 Gson gson = new Gson();
		 JsonReader reader = new JsonReader(new StringReader(RegisterFilePath));
		 reader.setLenient(true);


		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(RegisterFilePath));
			RegisterData[] registers = gson.fromJson(bufferReader, RegisterData[].class);
			return Arrays.asList(registers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + RegisterFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	private List<Logindata> getLoginList() {
		 Gson gson = new Gson();
		 JsonReader reader = new JsonReader(new StringReader(LoginFilePath));
		 reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(LoginFilePath));
			Logindata[] login = gson.fromJson(bufferReader, Logindata[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + RegisterFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}*/

private List<BUDGET_RequestAndAllocationTestDataType> getAllocationList() {
		 Gson gson = new Gson();
		 JsonReader reader = new JsonReader(new StringReader(AllocationFilePath));
		 reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(AllocationFilePath));
			BUDGET_RequestAndAllocationTestDataType[] BUDGET_RequestAndAllocation = gson.fromJson(bufferReader, BUDGET_RequestAndAllocationTestDataType[].class);
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
	
	private List<BUDGET_SupplementarybudgetTestDataType>getSupplementaryBudgetData() {
		 Gson gson = new Gson();
		 JsonReader reader = new JsonReader(new StringReader(BudgetSupplementaryFilePath));
		 reader.setLenient(true);
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudgetSupplementaryFilePath));
			BUDGET_SupplementarybudgetTestDataType[] budgetSupplementary = gson.fromJson(bufferReader, BUDGET_SupplementarybudgetTestDataType[].class);
			return Arrays.asList(budgetSupplementary);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + BudgetSupplementaryFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	//Budget_BudgetTransferData
			private List<BUDGET_BudgetTransferTestDataType> getBudgetTransferData() {
				Gson gson = new Gson();
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(BudgetTransferFilePath));
					BUDGET_BudgetTransferTestDataType[] budgetTransfer = gson.fromJson(bufferReader, BUDGET_BudgetTransferTestDataType[].class);
					return Arrays.asList(budgetTransfer);
				}catch(FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + BudgetTransferFilePath);
				}finally {
					try { if(bufferReader != null) bufferReader.close();}
					catch (IOException ignore) {}
				}
			}
			
	//AccountPayable_VendorPurchaseOrder		
	private List<AccountPayable_VendorPurchaseOrderTestDataType> getVendorPurchaseOrderData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(VendorPurchaseOrderFilePath));
			AccountPayable_VendorPurchaseOrderTestDataType[] VendorPurchaseOrder = gson.fromJson(bufferReader, AccountPayable_VendorPurchaseOrderTestDataType[].class);
			return Arrays.asList(VendorPurchaseOrder);
			}catch(FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + VendorPurchaseOrderFilePath );
			}finally {
				try { if(bufferReader != null) bufferReader.close();}
				catch (IOException ignore) {}
			}
		}
	//InventoryMaintenance
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
				catch (IOException ignore) {}
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
	
	
	private List<INVENTORY_EnquiryGLTestDataType> getInventoryEnquiryGLListData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(InventoryEnquiryGLFilePath));
			INVENTORY_EnquiryGLTestDataType[] InventoryEnquiryGL = gson.fromJson(bufferReader, INVENTORY_EnquiryGLTestDataType[].class);
			return Arrays.asList(InventoryEnquiryGL);
			}catch(FileNotFoundException e) {
				throw new RuntimeException("Json file not found at path : " + InventoryEnquiryGLFilePath );
			}finally {
				try { if(bufferReader != null) bufferReader.close();}
				catch (IOException ignore) {}
			}
		
	}
	
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
	

	private List<FixedAsset_AssetAllocationTestDataType> getAssetAllocationListData() {
			Gson gson = new Gson();
			BufferedReader bufferReader = null;
			try {
				bufferReader = new BufferedReader(new FileReader(AssetAllocationFilePath));
				FixedAsset_AssetAllocationTestDataType[] AssetAllocation = gson.fromJson(bufferReader, FixedAsset_AssetAllocationTestDataType[].class);
				return Arrays.asList(AssetAllocation);
				}catch(FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + AssetAllocationFilePath );
				}finally {
					try { if(bufferReader != null) bufferReader.close();}
					catch (IOException ignore) {}
				}
			
	}



	/*public final RegisterData getRegisterByName(String customerName) {
		return RegisterList.stream().filter(x -> x.FirstName.equalsIgnoreCase(customerName)).findAny().get();
	}

	public final Logindata getLoginByName(String UserName) {
		return LoginList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
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


	public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserName){
		 return BudgetTransferList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
	//AccountPayable_VendorPurchaseOrder
	public final AccountPayable_VendorPurchaseOrderTestDataType getVendorPurchaseOrderyByName(String UserName){
		 return VendorPurchaseOrderList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}

	//InventoryMaintenance
	public final InventoryMaintenanceTestDataType getInventoryMaintenanceByName(String UserName){
		 return InventoryMaintenanceList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
	//InventoryManagement
		public final InventoryManagement_InventoryStockReceiptTestDataType getInventoryStockReceiptByName(String UserName){
			 return InventoryStockReceiptList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
		
 //InventoryManagement
public final INVENTORY_EnquiryGLTestDataType getInventoryEnquiryGLByName(String UserName){
	return InventoryEnquiryGLList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
		
//FixedAsset_AssetCategory   
public final FixedAsset_AssetCategoryTestDataType getAssetCategoryByName(String UserName){
	return AssetCategoryList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
		
//FixedAsset_AssetDeallocation  
public final FixedAsset_AssetDeallocationTestDataType getAssetDeallocationByName(String UserName){
	return AssetDeallocationList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
//FixedAsset_AssetCreation	

public final FixedAsset_AssetCreationTestDataType getAssetCreationByName(String UserName){
	return AssetCreationList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}

//FixedAsset_AssetAllocation  
public final FixedAsset_AssetAllocationTestDataType getAssetAllocationByName(String UserName){
	return AssetAllocationList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
}
