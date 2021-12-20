package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.RegisterData;

public class JsonReader {
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	//Examples
	private final String RegisterFilePath = configFileReader.getJsonPath() + "RegisterJson.json";
	private List<RegisterData> RegisterList;

	private final String LoginFilePath = configFileReader.getJsonPath() + "LoginJson.json";
	private List<Logindata> LoginList;

	
	
	//Users_Login
	private final String AzentioLoginDataPath = configFileReader.getJsonPath() + "AzentioCredentials.json";
	private List<KUBS_LoginTestDataType> credentialslist;

	
	//Budget_RequestandAllocation
	private final String AllocationFilePath = configFileReader.getJsonPath() + "BUDGET_RequestAndAllocationJSON.json";
	private List<BUDGET_RequestAndAllocationTestDataType> AllocationList;

private final String BudtypeFilepath = configFileReader.getJsonPath() + "Budtype.json";
	private List<BUDGET_RequestAndAllocationTestDataType> BudtypeList;

	
	//Budget_BudgetCreation
	private final String BudgetCreationPath = configFileReader.getJsonPath() + "LoginJson.json";
	private List<BUDGET_BudgetCreationTestDataType> BudgetList;

	
	//Budget_SupplementaryBudget

	private final String BudgetFilePath = configFileReader.getJsonPath() + "BUDGET_SupplementaryBudgetJSON.json";
	private List<BUDGET_SupplementarybudgetTestDataType> SupplementaryBudgetList;
	
	//Budget_BudgetTransfer
	private final String BudgetTransferFilePath = configFileReader.getJsonPath() + "BudgetTransferJSON.json";
	private List<BUDGET_BudgetTransferTestDataType> BudgetTransferList;




	public JsonReader() {
		RegisterList = getRegisterData();
		LoginList = getLoginList();

		AllocationList = getAllocationList();		
		BudtypeList = getBudtypeList();

		BudgetList = getBudgetList();
		credentialslist = getAzentioCredentialsList();
		
		SupplementaryBudgetList = getSupplementaryBudgetList();
		
		BudgetTransferList=getBudgetTransferData();


	}

	private List<RegisterData> getRegisterData() {
		Gson gson = new Gson();
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
	}

	private List<BUDGET_RequestAndAllocationTestDataType> getAllocationList() {
		Gson gson = new Gson();
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


	private List<BUDGET_RequestAndAllocationTestDataType> getBudtypeList() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(BudtypeFilepath));
			BUDGET_RequestAndAllocationTestDataType[] type = gson.fromJson(bufferReader,
					BUDGET_RequestAndAllocationTestDataType[].class);
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



	public final RegisterData getRegisterByName(String customerName) {
		return RegisterList.stream().filter(x -> x.FirstName.equalsIgnoreCase(customerName)).findAny().get();
	}

	public final Logindata getLoginByName(String UserName) {
		return LoginList.stream().filter(x -> x.User.equalsIgnoreCase(UserName)).findAny().get();
	}

	public final BUDGET_RequestAndAllocationTestDataType getAllowcationByName(String Budgetallow) {
		return AllocationList.stream().filter(x -> x.BudgetCode.equalsIgnoreCase(Budgetallow)).findAny().get();
	}

	public final BUDGET_RequestAndAllocationTestDataType getBudtypeByName(String Budtype) {
		return BudtypeList.stream().filter(x -> x.Yearly.equalsIgnoreCase(Budtype)).findAny().get();
	}

	public final BUDGET_BudgetCreationTestDataType getBudgetdataByName(String UName) {
		return BudgetList.stream().filter(x -> x.UserName.equalsIgnoreCase(UName)).findAny().get();
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



}
