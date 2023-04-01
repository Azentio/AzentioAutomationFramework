package stepdefinitions;
import static org.testng.Assert.assertEquals;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BankReconciliation_ModuleObj;
import resources.BaseClass;
import resources.ExcelData;
import testDataType.BankReconciliationTestData;

public class Bank_ReconModule extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	AzentioLogin login;
	ConfigFileReader configreader = new ConfigFileReader();
	BankReconciliation_ModuleObj bankReconObj = new BankReconciliation_ModuleObj(driver);
	JsonConfig jsonconfig = new JsonConfig();
	BankReconciliationTestData bankReconData = jsonconfig.getBankReconlist("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Map<String,String> testdata = new LinkedHashMap<>();
	Map<String, String> bankReconTestData;	
	String path = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelDataForBankRecon = new ExcelData(path,"BankRecon","DataSet ID");
	
	
	
	}
