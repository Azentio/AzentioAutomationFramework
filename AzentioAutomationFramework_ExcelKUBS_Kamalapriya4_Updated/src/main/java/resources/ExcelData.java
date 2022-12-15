package resources;

import java.util.LinkedHashMap;
import java.util.Map;

import resources.ExcelReader;

public class ExcelData {
	
	private String TestDataSheetName;
	private String TestDataColumnName;
	private ExcelReader reader;
	public ExcelData(String FileName,String TestDataSheetName,String TestDataColumnName) {
		
		this.TestDataSheetName=TestDataSheetName;
		this.TestDataColumnName=TestDataColumnName;
		reader= new ExcelReader(FileName);
	}
	
	public Map<String, String> getTestdata(String DataSetID) {
		Map<String,String> testdata = new LinkedHashMap<String,String>();
		// reader = new ExcelReader(FileName);
		//int rowCount = reader.getRowCount(TestDataSheetName);
		int columnCount = reader.getColumnCount(TestDataSheetName);
		
		int cellRowNum = reader.getCellRowNum(TestDataSheetName,TestDataColumnName,DataSetID);
		//System.out.println(cellRowNum);
		
			for (int j = 1; j <=columnCount; j++) {
				String key = reader.getCellData(TestDataSheetName,j,1);
				String value = reader.getCellData(TestDataSheetName,j, cellRowNum);
				if (value.contains(".0")) {
					String[] split = value.split("[.]");
					 value =split[0];
				}
				testdata.put(key, value);
				if (testdata.containsValue("")) {
					testdata.remove(reader.getCellData(TestDataSheetName,j,1));
				}			
			}
			return testdata;
		
	}
	
  public void updateTestData(String DataSetID,String ColumnName,String TestDataValue) {
	  //reader= new ExcelReader(FileName);
	  int cellRowNum = reader.getCellRowNum(TestDataSheetName,TestDataColumnName,DataSetID);
	  reader.setCellData(TestDataSheetName, ColumnName, cellRowNum, TestDataValue);

}
   public static void main(String[] args) {
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00482\\Downloads\\TESTDATASAMPLE.xlsx","ReportMasterTestData", "Data Set ID");
	Map<String, String> testdata = excelData.getTestdata("AT-RA-007_D1");
	System.out.println(testdata.get("ReportType"));
	excelData.updateTestData("AT-RA-007_D1","Reference ID","922");
	//data.reader.setCellData("AssetAutoMasterTestData","Reference ID",20,"920");
} 
}
