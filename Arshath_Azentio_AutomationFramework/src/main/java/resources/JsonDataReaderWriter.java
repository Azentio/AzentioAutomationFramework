package resources;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReaderWriter {
	String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Reader.json";
	String path2 = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Referance.json";
	String inventoryRequestPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\InventoryRequestData.json";
	String poNumber=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GrnPoNumber.json";
	String prNumber=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IndentRefNumber.json";
	String grnNumber=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GRNNumber.json";
	String reqRefNumber=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\RequestReferenceNumber.json";
	JSONObject jsonobject = new JSONObject();
	JSONObject inventoryRequestData= new JSONObject();
	
	FileWriter filewriter;

	public void addData(String revID) throws IOException {
		jsonobject.put("ReviewerID", revID);
		filewriter = new FileWriter(path);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
	public void addInventoryManagementPOnumber(String ponumber) throws IOException {
		
		jsonobject.put("GRNPoNumber", ponumber);
		filewriter = new FileWriter(poNumber);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
	public String readInventoryManagementPOnumber() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(poNumber);
        Object obj=jsonparser.parse(filereader);
        jsonobject=(JSONObject) obj;
       String ponumber= (String) jsonobject.get("GRNPoNumber");
	return ponumber;
    }
//-----
	public void addInventoryManagementPRnumber(String indentrefNumber) throws IOException {
		
		jsonobject.put("IndentRefNumber", indentrefNumber);
		filewriter = new FileWriter(prNumber);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
	public String readInventoryManagementPRnumber() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(prNumber);
        Object obj=jsonparser.parse(filereader);
        jsonobject=(JSONObject) obj;
       String indentrefNumber= (String) jsonobject.get("IndentRefNumber");
	return indentrefNumber;
    }
//-----

//-----
	public void addInventoryManagementGRNnumber(String grnnumber) throws IOException {
		
		jsonobject.put("GRNNumber", grnnumber);
		filewriter = new FileWriter(grnNumber);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
	public String readInventoryManagementGRNnumber() throws IOException, ParseException
	{
		JSONParser jsonparser=new JSONParser();
		FileReader filereader=new FileReader(grnNumber);
		Object obj=jsonparser.parse(filereader);
		jsonobject=(JSONObject) obj;
		String grnnumber= (String) jsonobject.get("GRNNumber");
		return grnnumber;
	}
//-----

//-----
	public void addInventoryManagementReqRefNumber(String reqRefnumber) throws IOException {
		
		jsonobject.put("RequestReferenceNumber", reqRefnumber);
		filewriter = new FileWriter(reqRefNumber);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
	public String readInventoryManagementReqRefNumber() throws IOException, ParseException
	{
		JSONParser jsonparser=new JSONParser();
		FileReader filereader=new FileReader(reqRefNumber);
		Object obj=jsonparser.parse(filereader);
		jsonobject=(JSONObject) obj;
		String reqRefnumber= (String) jsonobject.get("RequestReferenceNumber");
		return reqRefnumber;
	}
//-----
	public void addInventoryRequestedBranch(String inventoryRequestedBranch) throws IOException {
		inventoryRequestData.put("inventoryRequestData", inventoryRequestedBranch);
		filewriter = new FileWriter(inventoryRequestPath);
		filewriter.write(inventoryRequestData.toJSONString());
		filewriter.close();
	}
	public String readInventoryRequestedBranch() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(inventoryRequestPath);
        Object obj=jsonparser.parse(filereader);
        inventoryRequestData=(JSONObject) obj;
       String inventoryRequestedBranch= (String) inventoryRequestData.get("inventoryRequestData");
	return inventoryRequestedBranch;
    }
	
	public void addInventoryItem(String inventoryItem) throws IOException {
		inventoryRequestData.put("inventoryItem", inventoryItem);
		filewriter = new FileWriter(inventoryRequestPath);
		filewriter.write(inventoryRequestData.toJSONString());
		filewriter.close();
	}
	public String readInventoryItem() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(inventoryRequestPath);
        Object obj=jsonparser.parse(filereader);
        inventoryRequestData=(JSONObject) obj;
       String inventoryItem= (String) inventoryRequestData.get("inventoryItem");
	return inventoryItem;
    }
	
	public void addInventoryRequestReferenceNumber(String inventoryRequestReferenceNumber) throws IOException {
		inventoryRequestData.put("inventoryRequestReferenceNumber", inventoryRequestReferenceNumber);
		filewriter = new FileWriter(inventoryRequestPath);
		filewriter.write(inventoryRequestData.toJSONString());
		filewriter.close();
	}
	public String readInventoryRequestReferenceNumber() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(inventoryRequestPath);
        Object obj=jsonparser.parse(filereader);
        inventoryRequestData=(JSONObject) obj;
       String inventoryRequestReferenceNumber= (String) inventoryRequestData.get("inventoryRequestReferenceNumber");
	return inventoryRequestReferenceNumber;
    }
    public String readdata() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(path);
        Object obj=jsonparser.parse(filereader);
        jsonobject=(JSONObject) obj;
       String reviewerID= (String) jsonobject.get("ReviewerID");
	return reviewerID;
    }
	public void addReferanceData(String data) throws IOException {
		jsonobject.put("Referance", data);
		filewriter = new FileWriter(path2);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
    public String readReferancedata() throws IOException, ParseException
    {
    	JSONParser jsonparser=new JSONParser();
    	FileReader filereader=new FileReader(path2);
        Object obj=jsonparser.parse(filereader);
        jsonobject=(JSONObject) obj;
       String reviewerID= (String) jsonobject.get("Referance");
	return reviewerID;
    }
}