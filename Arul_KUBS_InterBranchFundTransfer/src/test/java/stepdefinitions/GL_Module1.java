package stepdefinitions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Enquiry_Obj;
import pageobjects.Gl_Reports_Obj1;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.GL_ModuleTestData;

public class GL_Module1 extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Gl_Reports_Obj1 glReportsObj = new Gl_Reports_Obj1(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	KUBS_Login login;
	ConfigFileReader configreader = new ConfigFileReader();
	JsonConfig jsonconfig = new JsonConfig();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	GL_ModuleTestData glModuleData = jsonconfig.getGlmoduleTestDataByName("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();

	}
