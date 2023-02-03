package stepdefinitions;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

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
	JobScheduler_JobExecutionTestDataType JobExecutionTestDataType = jsonReader.getJobExecutiondata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();


	@Then("^Selet configuration$")
	public void selet_configuration() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.maker_configuration_option(), 5, 500);
		clicksAndActionHelper.moveToElement(jobScheduler_JobExecutionObj.maker_configuration_option());
		jobScheduler_JobExecutionObj.maker_configuration_option().click();	
		waithelper.waitForElementToVisibleWithFluentWait(driver, jobScheduler_JobExecutionObj.configuration_option(), 10,
				500);
		clicksAndActionHelper.moveToElement(jobScheduler_JobExecutionObj.configuration_option());
			
		jobScheduler_JobExecutionObj.configuration_option().click();
	}

	@And("^user should navigate to job scheduler menu$")
	public void user_should_navigate_to_job_scheduler_menu() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, jobScheduler_JobExecutionObj.JobSchedulerMenu(), 5,
				500);
		jobScheduler_JobExecutionObj.JobSchedulerMenu().click();
	}

	@When("^click on temp grid button of job execution$")
	public void click_on_temp_grid_button_of_job_execution() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid().click();
	}
	 @Then("^User get the system for job execution$")
	    public void user_get_the_system_for_job_execution() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,jobScheduler_JobExecutionObj.systemDate(), 30, 2);
			String systemdate = jobScheduler_JobExecutionObj.systemDate().getText();
//			System.out.println(systemdate);
			String[] split = systemdate.split("-");
			int date = Integer.parseInt(split[0]);
//			System.out.println(date);
			String month = split[1];
//			System.out.println(month);
			int year = Integer.parseInt(split[2]);
//			System.out.println(year);
			int monthNum;
			switch (month) {
			case "Jan":
				monthNum = 1;
				break;
			case "Feb":
				monthNum = 2;
				break;
			case "Mar":
				monthNum = 3;
				break;
			case "Apr":
				monthNum = 4;
				break;
			case "May":
				monthNum = 5;
				break;
			case "Jun":
				monthNum = 6;
				break;
			case "Jul":
				monthNum = 7;
				break;
			case "Aug":
				monthNum = 8;
				break;
			case "Sep":
				monthNum = 9;
				break;
			case "Oct":
				monthNum = 10;
				break;
			case "Nov":
				monthNum = 11;
				break;
			case "Dec":
				monthNum = 12;
				break;
			default:
				monthNum = 0;
				break;
			}
//	        System.out.println(monthNum);

			LocalDate Date = LocalDate.of(year, monthNum, date);
			String JobExecutionDate = Date.plusDays(1).toString();
//			System.out.println(JobExecutionDate);
			String[] split2 = JobExecutionDate.split("-");
			String yearExecution =split2[0];
			testdata.put("yearExecution", yearExecution);
			int jobExecutionMonth = Integer.parseInt(split2[1]);
			String jobDate=split2[2];
			testdata.put("jobDate", jobDate);
			String monthString;
	        switch (jobExecutionMonth) {
	            case 1:  monthString = "Jan";       break;
	            case 2:  monthString = "Feb";      break;
	            case 3:  monthString = "Mar";         break;
	            case 4:  monthString = "Apr";         break;
	            case 5:  monthString = "May";           break;
	            case 6:  monthString = "Jun";          break;
	            case 7:  monthString = "Jul";          break;
	            case 8:  monthString = "Aug";        break;
	            case 9:  monthString = "Sep";     break;
	            case 10: monthString = "Oct";       break;
	            case 11: monthString = "Nov";      break;
	            case 12: monthString = "Dec";      break;
	            default: monthString = "Invalid month"; break;
	        }
	        testdata.put("Tomonth", monthString);
	        int jobExecutionFullMonth = Integer.parseInt(split2[1]);
	        String fullMonthString;
	        switch (jobExecutionFullMonth) {
	            case 1:  fullMonthString = "January";       break;
	            case 2:  fullMonthString = "February";      break;
	            case 3:  fullMonthString = "March";         break;
	            case 4:  fullMonthString = "April";         break;
	            case 5:  fullMonthString = "May";           break;
	            case 6:  fullMonthString = "June";          break;
	            case 7:  fullMonthString = "July";          break;
	            case 8:  fullMonthString = "August";        break;
	            case 9:  fullMonthString = "September";     break;
	            case 10: fullMonthString = "October";       break;
	            case 11: fullMonthString = "November";      break;
	            case 12: fullMonthString = "December";      break;
	            default: fullMonthString = "Invalid month"; break;
	        }
	        testdata.put("FullMonth", fullMonthString);
			
		}
	 
	 @Then("^select the date to start jobs$")
	    public void select_the_date_to_start_jobs() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,
					jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate(), 5, 500);
			jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate().click();
			while (true) {
				try {

					waithelper.waitForElementToVisibleWithFluentWait(
							driver, driver.findElement(By.xpath("//span[contains(text(),'"
									+ testdata.get("Tomonth") + " " + testdata.get("yearExecution") + "')]")),
							5, 500);
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
//							+ JobExecutionTestDataType.ToMonth + " " + JobExecutionTestDataType.ToYear + "')]")));
					WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
							+ testdata.get("Tomonth") + " " + testdata.get("yearExecution") + "')]"));
					break;
				}

				catch (NoSuchElementException nosuchElement) {
					jobScheduler_JobExecutionObj.JobScheduler_JobExecution_NextMonth().click();
				}
			}
			WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
					+ " " + testdata.get("jobDate") + ", " + testdata.get("yearExecution") + "']/span"));
			clicksAndActionHelper.moveToElement(FinalDay2);
			clicksAndActionHelper.doubleClick(FinalDay2);
			}
	@And("^select the date to start job$")
	public void select_the_date_to_start_job() {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate().click();
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(
						driver, driver.findElement(By.xpath("//span[contains(text(),'"
								+ JobExecutionTestDataType.ToMonth + " " + JobExecutionTestDataType.ToYear + "')]")),
						5, 500);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
//						+ JobExecutionTestDataType.ToMonth + " " + JobExecutionTestDataType.ToYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ JobExecutionTestDataType.ToMonth + " " + JobExecutionTestDataType.ToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='" + JobExecutionTestDataType.ToFullMonth
				+ " " + JobExecutionTestDataType.ToDate + ", " + JobExecutionTestDataType.ToYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

	@Then("^Click on start job$")
	public void click_on_start_job() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton().click();
	}

// --------   Job definition

	@When("^click on temp grid button of job definition$")
	public void click_on_temp_grid_button_of_job_definition() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid().click();
	}

	@Then("^click on add button to config job$")
	public void click_on_add_button_to_config_job() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_AddButton(), 5, 500);		
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_AddButton().click();
	}

	@And("^fill the required fields for day end activity$")
	public void fill_the_required_fields_for_day_end_activity() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode(), 50, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode().sendKeys(JobExecutionTestDataType.JobCode);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName().sendKeys(JobExecutionTestDataType.JobName);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName()
				.sendKeys(JobExecutionTestDataType.ApplicationName);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode()
				.sendKeys(JobExecutionTestDataType.ModuleCode);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName()
				.sendKeys(JobExecutionTestDataType.ProcessName);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(JobExecutionTestDataType.JobType);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(Keys.ENTER);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads()
				.sendKeys(JobExecutionTestDataType.NumberOfThreads);

//		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber()
				.sendKeys(JobExecutionTestDataType.SequenceNumber);

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks().sendKeys(JobExecutionTestDataType.Remarks);

	}

	@Then("^click on save button1$")
	public void click_on_save_button1() throws InterruptedException {
//		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton().click();

//		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus(), 5, 500);
		WebElement recordstatus = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().getText();
		System.out.println(message);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().click();
	}
}
