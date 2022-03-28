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

import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_CommentsFromApprover;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.INVENTORY_EnquiryGLTestDataType;
import testDataType.INVENTORY_EnquiryGlTestData;
import testDataType.INVENTORY_InventoryManagement_DataType;
import testDataType.INVENTORY_InventoryStockIssueTestData;
import testDataType.INVENTORY_MAINTENANCE_DenominationMasterTestDataType;
import testDataType.INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType;
import testDataType.InventoryMaintenanceTestDataType;
import testDataType.InventoryManagementTestDataType;
import testDataType.InventoryManagement_InventoryStockReceiptTestDataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.RegisterData;


//master
public class JsonConfig {
	ConfigFileReader configFileReader = new ConfigFileReader();

	



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
	private List<BUDGET_BudgetDefinitionTestDataType> BudgetCreationList;
 
	//UAT Budget Definition 
	private final String BudgetDefinitionUATFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetDefinitionUATJSON.json";
	private List<BUDGET_BudgetDefinitionUATTestDataType> budgetDefinitionUATTestData;

	//Budget_SupplementaryBudget

	private final String BudgetFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;

	//Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;

	private final String BudgetReviewerCommentFilePath = configFileReader.getJsonPath() + "BUDGET_ReviewerRemarks.json";
	private List<BUDGET_CommentsFromApprover> reviewerCommentsList;

	//Inventory stock issue
		private final String InventoryStockIssueFilePath = configFileReader.getJsonPath() + "INVENTORY_InventoryStockIssue.json";
		private List<INVENTORY_InventoryStockIssueTestData> inventoryStockIssueTestData;
		
	//InventoryGL 
	private final String InventoryGlFilePath = configFileReader.getJsonPath() + "INVENTORY_EnquiryGlJSON.json";
	private List<INVENTORY_EnquiryGlTestData> inventoryGlReportTestData;
	
	public final INVENTORY_EnquiryGlTestData getInventoryGlUATTestData(String username) {
		return inventoryGlReportTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	
	// Inventory_StockReturnBranch
			private final String StockReturnBranchFilePath = configFileReader.getJsonPath() + "INVENTORY_InventoryManagement.json";
			private List<INVENTORY_InventoryManagement_DataType> StockReturnBranchList;
	
//InventoryMaintenance
	private final String InventoryMaintenanceFilePath = configFileReader.getJsonPath() + "InventoryMaintenanceJson.json";
	private List<InventoryMaintenanceTestDataType> InventoryMaintenanceList;


//InventoryManagement_InventoryStockReceipt
	private final String InventoryStockReceiptFilePath = configFileReader.getJsonPath() + "InventoryManagement_InventoryStockReceiptJSON.json";
	private List<InventoryManagement_InventoryStockReceiptTestDataType> InventoryStockReceiptList;
		
//Inventory_EnquiryGL
	private final String InventoryEnquiryGLFilePath = configFileReader.getJsonPath() + "INVENTORY_EnquiryGLJSON.json";
	private List<INVENTORY_EnquiryGLTestDataType> InventoryEnquiryGLList;
//InventoryManagement Tushar
	private final String InventoryManagementFilePath = configFileReader.getJsonPath() + "InventoryManagementJSON.json";
	private List<InventoryManagementTestDataType>InventoryManagementList;
			
// INVENTORY_MAINTENANCE_DenominationMaster
	private final String DenominationMasterPath = configFileReader.getJsonPath() + "INVENTORY_MAINTENANCE_DenominationMasterJSON.json";
	private List<INVENTORY_MAINTENANCE_DenominationMasterTestDataType> DenominationMasterList;
		
// INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmation
	private final String PurchaseRequisitionConfirmationPath = configFileReader.getJsonPath() + "INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationJSON.json";
	private List<INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType> PurchaseRequisitionConfirmationList;
		
	public JsonConfig() {
		/*RegisterList = getRegisterData();
		LoginList = getLoginList();*/

		budgetDefinitionUATTestData=getBudgetDefinitionUATTestData();
		
		AllocationList = getAllocationList();
		BudtypeList = getBudtypeList();

		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();

		SupplementaryBudgetList = getSupplementaryBudgetList();

		BudgetTransferList=getBudgetTransferData();
		reviewerCommentsList=getApproverCommentsData();
		InventoryMaintenanceList = getInventoryMaintenanceListData();
		InventoryStockReceiptList = getInventoryStockReceiptListData();
		InventoryEnquiryGLList = getInventoryEnquiryGLListData();
		InventoryManagementList =getInventoryManagementList();
		DenominationMasterList = getDenominationMasterList();
		PurchaseRequisitionConfirmationList = getPurchaseRequisitionConfirmationList();
		

	}



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
			BUDGET_SupplementarybudgetTestDataType[] login = gson.fromJson(bufferReader, BUDGET_SupplementarybudgetTestDataType[].class);
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
			private List<BUDGET_CommentsFromApprover> getApproverCommentsData() {
				Gson gson = new Gson();
				BufferedReader bufferReader = null;
				try {
					bufferReader = new BufferedReader(new FileReader(BudgetReviewerCommentFilePath));
					BUDGET_CommentsFromApprover[] reviewercomments = gson.fromJson(bufferReader, BUDGET_CommentsFromApprover[].class);
					return Arrays.asList(reviewercomments);
				}catch(FileNotFoundException e) {
					throw new RuntimeException("Json file not found at path : " + BudgetReviewerCommentFilePath);
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
			
	
	public final BUDGET_RequestAndAllocationTestDataType getAllowcationByName(String user) {
		return AllocationList.stream().filter(x -> x.UserType.equalsIgnoreCase(user)).findAny().get();
	}

	public final BUDGET_RequestandallocationBUDTYPEDATA getBudtypeByName(String Budtype) {
		return BudtypeList.stream().filter(x -> x.BudgetPeriod.equalsIgnoreCase(Budtype)).findAny().get();
	}

	public final BUDGET_BudgetDefinitionTestDataType getBudgetdataByName(String UName) {
		return BudgetCreationList.stream().filter(x->x.userName.equalsIgnoreCase(UName)).findAny().get();
		
	}
	
	//UAT Budget Definition test data main function 
	public final BUDGET_BudgetDefinitionUATTestDataType getUATBudgetDefinitionTestData(String username) {
		return budgetDefinitionUATTestData.stream().filter(x ->x.usertType.equalsIgnoreCase(username)).findAny().get();
	}

	
	
	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}


	public final BUDGET_SupplementarybudgetTestDataType getSupplementaryBudgetByName(String UserName) {
		return SupplementaryBudgetList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}


	/*public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserType){
		 return BudgetTransferList.stream().filter(x->x.User.equalsIgnoreCase(UserType)).findAny().get();
}*/

	public final BUDGET_CommentsFromApprover getApproverData(String UserName){
	return reviewerCommentsList.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
}
    public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserName) {
	return BudgetTransferList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
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
   //InventoryManagement Tushar
   public final InventoryManagementTestDataType getInventoryManagementByName(String UserName){
		 return InventoryManagementList.stream().filter(x->x.User.equalsIgnoreCase(UserName)).findAny().get();
}
   public final INVENTORY_MAINTENANCE_DenominationMasterTestDataType getDenominationMasterdata(String UserName) {
		return DenominationMasterList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final INVENTORY_MANAGEMENT_PurchaseRequisitionConfirmationTestDataType getPurchaseRequisitionConfirmationdata(String UserName) {
		return PurchaseRequisitionConfirmationList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}
	
	public final INVENTORY_InventoryStockIssueTestData getInventoryStockIssueUATTestData(String username) {
		return inventoryStockIssueTestData.stream().filter(x->x.userType.equalsIgnoreCase(username)).findAny().get();
	}
	
	//Inventory - StockReturnBranch
			public final INVENTORY_InventoryManagement_DataType getStockReturnBranchByName(String user) {
				return StockReturnBranchList.stream().filter(x -> x.Usertype.equalsIgnoreCase(user)).findAny().get();
			}
		
	public final ACCOUNTSPAYABLE_VendorContractsTestDataType getVendorContractdata(String UserName) {
	return VendorContractsList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
			}
	
	// ACCOUNTSPAYABLE_VendorContract
		private final String VendorContractsPath = configFileReader.getJsonPath() + "ACCOUNTSPAYABLE_VendorContractsJSON.json";
		private List<ACCOUNTSPAYABLE_VendorContractsTestDataType> VendorContractsList;
}