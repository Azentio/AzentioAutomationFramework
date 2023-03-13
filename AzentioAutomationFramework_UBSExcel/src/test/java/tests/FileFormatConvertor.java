package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileFormatConvertor {

	public static void main(String[] args) throws IOException {
	
		FileInputStream fileInputStrea= new FileInputStream("C:\\Users\\ININDC00076\\Downloads\\KUBSTestData.ods");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStrea);

	}

}
