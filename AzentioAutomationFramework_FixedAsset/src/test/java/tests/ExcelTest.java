package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import resources.ExcelData;
import resources.ExcelReader;

public class ExcelTest {
	String path;
	String sheetName;
	String columnName;
	public ExcelTest(String path,String sheetName,String columnName)
	{
		this.path=path;
		this.sheetName=sheetName;
		this.columnName=columnName;
	}
	
	public List<String> getTestCaseTagsfromExcel() {
		ExcelReader excelReader= new ExcelReader(path);
		ExcelData excelData = new ExcelData(path,sheetName,columnName);
		int rowCount=0;
		List<String> Testcasetoexecute = new ArrayList<String>();
		ArrayList<String> valueList;
		List<String> rowvalues = new ArrayList<String>();
		List<String> testcaseid = new ArrayList<String>();
		rowCount=excelReader.getRowCount(sheetName);
		for (int i =2; i <= rowCount; i++) {
			//System.out.println(excelReader.getCellData("TestExecution", "Sequence", i).isEmpty());
			if (excelReader.getCellData(sheetName, columnName, i).isEmpty()==false) {
			testcaseid.add(excelReader.getCellData(sheetName,columnName, i));
			}
			
		}
		for (String string : testcaseid) {
			//System.out.println(string);
			Map<String, String> testdata = excelData.getTestdata(string);
			valueList = new ArrayList<String>(testdata.values());
			
			for (int i = 0; i <valueList.size(); i++) {
				rowvalues.add(valueList.get(i));
			}
		}
		for (int i = 0; i <rowvalues.size(); i++) {
			//System.out.println(rowvalues.get(i));
			if (rowvalues.get(i).contains("Yes")) {
				Testcasetoexecute.add(rowvalues.get(i-2));
			}
					
			
		}
//		for (String string : Testcasetoexecute) {
//			System.out.println(string); 
//		}
	
		return Testcasetoexecute;
	}

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	 	ExcelTest excelTest = new ExcelTest(path,"TestExecution", "Sequence");
	 	List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
	 	for (String string : testCaseTagsfromExcel) {
			System.out.println(string);
		}
	}

}
