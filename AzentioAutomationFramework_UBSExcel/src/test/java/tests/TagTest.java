package tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import resources.ExcelData;

public class TagTest {
@Test()
public void tagTest()
{
	String path="C:\\Users\\ININDC00076\\Documents\\KUBSTestDataExecutionTracker.xlsx";
	ExcelData excelData= new ExcelData(path,"TestExecution","Sequence");
	Map<String, String> testdata= new HashMap<>();
	 testdata = excelData.getTestdata("1");	
	
	System.out.println("TestCase ID is"+testdata.get("TestCaseID"));
}
}
