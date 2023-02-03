package tests;

import resources.ExcelData;

public class test {
	public static void main(String args[])
	{
		String path = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
		ExcelData excelDataForAssetImpairment = new ExcelData(path, "FixedAsset_AssetReValuation", "DataSet ID");
		
		excelDataForAssetImpairment.updateTestData("KUBS_FAT_UAT_012_03_D1", "AlteredBookValue", "879876540");
		
		
		
		}

}
