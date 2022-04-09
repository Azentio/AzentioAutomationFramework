package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.JobScheduler_JobExecutionObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.JobScheduler_JobExecutionTestDataType;

public class JobScheduler_JobExecution {
	
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JobScheduler_JobExecutionObj jobScheduler_JobExecutionObj = new JobScheduler_JobExecutionObj(driver);
	JobScheduler_JobExecutionTestDataType JobExecutionTestDataType=jsonReader.getJobExecutiondata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@Then("^Selet configuration$")
	public void selet_configuration() {
		waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.maker_configuration_option());
		jobScheduler_JobExecutionObj.maker_configuration_option().click();
		waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.configuration_option());
		jobScheduler_JobExecutionObj.configuration_option().click();
	}
	
	@And("^user should navigate to job scheduler menu$")
	public void user_should_navigate_to_job_scheduler_menu() {
		waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobSchedulerMenu());
		jobScheduler_JobExecutionObj.JobSchedulerMenu().click();
	}
	
	@When("^click on temp grid button of job execution$")
    public void click_on_temp_grid_button_of_job_execution() throws Throwable {
		waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid());
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid().click();
    }
	
	@And("^select the date to start job$")
	public void select_the_date_to_start_job()  {
		
		waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate());
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate().click();
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+JobExecutionTestDataType.ToMonth+" "+JobExecutionTestDataType.ToYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+JobExecutionTestDataType.ToMonth+" "+JobExecutionTestDataType.ToYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			jobScheduler_JobExecutionObj.JobScheduler_JobExecution_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+JobExecutionTestDataType.ToFullMonth+" "+JobExecutionTestDataType.ToDate+", "+JobExecutionTestDataType.ToYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

    @Then("^Click on start job$")
    public void click_on_start_job(){
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton());
    	jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton().click();
    }
    
// --------   Job definition
    
    @When("^click on temp grid button of job definition$")
    public void click_on_temp_grid_button_of_job_definition()  {
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid());
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid().click();
    }

    @Then("^click on add button to config job$")
    public void click_on_add_button_to_config_job() {
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_AddButton());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_AddButton().click();
    }
    
    @And("^fill the required fields for day end activity$")
    public void fill_the_required_fields_for_day_end_activity() throws InterruptedException {
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode().sendKeys(JobExecutionTestDataType.JobCode);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName().sendKeys(JobExecutionTestDataType.JobName);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName().sendKeys(JobExecutionTestDataType.ApplicationName);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode().sendKeys(JobExecutionTestDataType.ModuleCode);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName().sendKeys(JobExecutionTestDataType.ProcessName);
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(JobExecutionTestDataType.JobType);
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads().sendKeys(JobExecutionTestDataType.NumberOfThreads);
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber().sendKeys(JobExecutionTestDataType.SequenceNumber);
    	
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks().sendKeys(JobExecutionTestDataType.Remarks);
    	
    }

    @Then("^click on save button1$")
    public void click_on_save_button1() throws InterruptedException {
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton());
    	jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton().click();
    	
    	Thread.sleep(1000);
		WebElement recordstatus = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().getText();
		System.out.println(message);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().click();
    }
}
