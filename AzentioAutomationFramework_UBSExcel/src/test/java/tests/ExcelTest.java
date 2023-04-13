package tests;

import java.util.ArrayList;
import java.util.List;

import resources.ExcelReader;

public class ExcelTest {
	String path;
	String sheetName;
	String columnName;

	public ExcelTest(String path, String sheetName, String columnName) {
		this.path = path;
		this.sheetName = sheetName;
		this.columnName = columnName;
	}

	public  List<String> getTestCaseTagsfromExcel() {
		ExcelReader excelReader = new ExcelReader(path);
		List<String> li = new ArrayList<String>();
		
	
		for(int i=1;i>0;i++){
			String cellData = excelReader.getCellData(sheetName, 1,i);
			if (!(cellData.isBlank())) {
				li.add(cellData);
			}
			else if(cellData.isBlank())
			{
				break;
			}
			
		}
		return li;
	}

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
		ExcelTest excelTest = new ExcelTest(path, "TestExecution", "TestCaseID");
		List<String> testCaseTagsfromExcel = excelTest.getTestCaseTagsfromExcel();
		for (String string : testCaseTagsfromExcel) {
			System.out.println(string);
		}
	}

}
