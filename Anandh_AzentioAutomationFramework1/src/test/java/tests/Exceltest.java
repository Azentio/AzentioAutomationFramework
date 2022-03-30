package tests;

import resources.ExcelReader;

public class Exceltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExcelReader excelReader =new ExcelReader("C:\\Users\\inindc00076\\Downloads\\CICIbankLtd_HDFCBANK_2022-06-02_18-00-00.csv");
		String payoutReferenceNum=excelReader.getCellData("JAIPURBRANCH_HDFCBANK_2022-10-3", 8, 2);
	System.out.println("Payout Reference number"+payoutReferenceNum);
	}

}
