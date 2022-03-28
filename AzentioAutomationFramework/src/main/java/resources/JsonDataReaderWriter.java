package resources;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReaderWriter {
	String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Reader.json";
	String path2 = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Referance.json";
String inventoryRequestPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\InventoryRequestData.json";
	JSONObject jsonobject = new JSONObject();
	JSONObject inventoryRequestData= new JSONObject();
	
	FileWriter filewriter;

	public void addData(String revID) throws IOException {
		jsonobject.put("ReviewerID", revID);
		filewriter = new FileWriter(path);
		filewriter.write(jsonobject.toJSONString());
		filewriter.close();
	}
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