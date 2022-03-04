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

import testDataType.Cancellationofcontractdatatype;
import testDataType.KUBS_LoginTestDataType;
import testDataType.Logindata;
import testDataType.RegisterData;

public class JsonConfig {
	ConfigFileReader configFileReader = new ConfigFileReader();
	// Users_Login
	private final String AzentioLoginDataPath = configFileReader.getJsonPath() + "KUBS_LoginDataJSON.json";
	private List<KUBS_LoginTestDataType> credentialslist;
	private final String cancellationofcontractpath = configFileReader.getJsonPath() + "cancellationofcontract.json";
	private List<Cancellationofcontractdatatype> cancellationlist;

	public JsonConfig() {

		credentialslist = getAzentioCredentialsList();
		cancellationlist = getCancellationlist();

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

	public final KUBS_LoginTestDataType getLoginCredentialsByName(String Username) {
		return credentialslist.stream().filter(x -> x.UserType.equalsIgnoreCase(Username)).findAny().get();
	}
	public final Cancellationofcontractdatatype getCancelcontractByName(String contractstatus) {
		return cancellationlist.stream().filter(x -> x.UserType.equalsIgnoreCase(contractstatus)).findAny().get();
	}

}
