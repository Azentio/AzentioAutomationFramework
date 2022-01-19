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

import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;
import testDataType.BUDGET_CommentsFromApprover;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
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
	private List<BUDGET_BudgetDefinitionTestDataType> BudgetCreationList;


	//Budget_SupplementaryBudget

	private final String BudgetFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;

	//Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BUDGET_BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;

	private final String BudgetReviewerCommentFilePath = configFileReader.getJsonPath() + "BUDGET_ReviewerRemarks.json";
	private List<BUDGET_CommentsFromApprover> reviewerCommentsList;



	public JsonConfig() {
		/*RegisterList = getRegisterData();
		LoginList = getLoginList();*/

		AllocationList = getAllocationList();
		BudtypeList = getBudtypeList();

		BudgetCreationList = getBudgetList();
		credentialslist = getAzentioCredentialsList();

		SupplementaryBudgetList = getSupplementaryBudgetList();

		BudgetTransferList=getBudgetTransferData();
		reviewerCommentsList=getApproverCommentsData();


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

	public final BUDGET_BudgetDefinitionTestDataType getBudgetdataByName(String UName) {
		return BudgetCreationList.stream().filter(x->x.userName.equalsIgnoreCase(UName)).findAny().get();
		
	}

	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}


	public final BUDGET_SupplementarybudgetTestDataType getSupplementaryBudgetByName(String UserName) {
		return SupplementaryBudgetList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}


	public final BUDGET_BudgetTransferTestDataType getBudgetTransferdata(String UserType){
		 return BudgetTransferList.stream().filter(x->x.User.equalsIgnoreCase(UserType)).findAny().get();
}

	public final BUDGET_CommentsFromApprover getApproverData(String UserName){
		 return reviewerCommentsList.stream().filter(x->x.UserType.equalsIgnoreCase(UserName)).findAny().get();
}

}
