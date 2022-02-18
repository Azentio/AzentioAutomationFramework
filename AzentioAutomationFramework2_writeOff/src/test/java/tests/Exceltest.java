package tests;

import resources.ExcelReader;

public class Exceltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelReader excelReader =new ExcelReader("C:\\Users\\inindc00076\\git\\AzentioAutomationFramework2\\AzentioAutomationFramework\\Test-data\\TestData.xlsx");
		String cellData=excelReader.getCellData("Login",1,2);
		System.out.println("Cell Data is"+cellData);
	}

}
