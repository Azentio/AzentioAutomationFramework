package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobScheduler_JobExecutionObj {

	WebDriver driver;

	public JobScheduler_JobExecutionObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Job Scheduler Menu
	@FindBy(xpath = "//ion-label[text()=' Job scheduler ']")
	private WebElement JobSchedulerMenu;

	public WebElement JobSchedulerMenu() {
		return JobSchedulerMenu;
	}
	
	// Job execution submenu
	@FindBy(xpath = "//div[4]//ion-menu-toggle[2]//ion-item//ion-buttons//ion-button[1]")
	private WebElement JobScheduler_JobExecution_TempGrid;
	
	public WebElement JobScheduler_JobExecution_TempGrid() {
		return JobScheduler_JobExecution_TempGrid;
	}
	
	// calendar from date Batch job
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement JobScheduler_JobExecution_FromDate;
	
	public WebElement JobScheduler_JobExecution_FromDate() {
		return JobScheduler_JobExecution_FromDate;
	}
	
	// calendar job start to date
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement JobScheduler_JobExecution_ToDate;
	
	public WebElement JobScheduler_JobExecution_ToDate() {
		return JobScheduler_JobExecution_ToDate;
	}
	
	// Start job
	@FindBy(xpath = "//ion-col/ion-button")
	private WebElement JobScheduler_JobExecution_StartJobButton;
	
	public WebElement JobScheduler_JobExecution_StartJobButton() {
		return JobScheduler_JobExecution_StartJobButton;
	}
	
	// Search Batch job
	@FindBy(xpath = "//ion-col/ion-button")
	private WebElement JobScheduler_JobExecution_SearchJobButton;
	
	public WebElement JobScheduler_JobExecution_SearchJobButton() {
		return JobScheduler_JobExecution_SearchJobButton;
	}
	
	//configuration option
	@FindBy(xpath = "//custom-side-menu/ion-select")
	private WebElement maker_configuration_option;

	public WebElement maker_configuration_option() {
		return maker_configuration_option;
	}
	
	//configuration
	@FindBy(xpath = "//ion-label[text()='Configuration']/following-sibling::ion-radio")
	private WebElement configuration_option;

	public WebElement configuration_option() {
		return configuration_option;
	}
	
	//next month
	@FindBy(xpath="//owl-date-time-calendar/div/button[2]")
	private WebElement JobScheduler_JobExecution_NextMonth;
	public WebElement JobScheduler_JobExecution_NextMonth()
	{
		return JobScheduler_JobExecution_NextMonth;
	}
	
	
//------------------------------	JobDefinition-----------------------//
	

	// Job definition submenu
	@FindBy(xpath = "//div[4]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[1]")
	private WebElement JobScheduler_JobDefinition_TempGrid;
	
	public WebElement JobScheduler_JobDefinition_TempGrid() {
		return JobScheduler_JobDefinition_TempGrid;
	}
	
	//add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement JobScheduler_JobDefinition_AddButton;

	public WebElement JobScheduler_JobDefinition_AddButton() {
		return JobScheduler_JobDefinition_AddButton;

	}
	
	//job code
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_JobCode;
	
	public WebElement JobScheduler_JobDefinition_JobCode() {
		return JobScheduler_JobDefinition_JobCode;
		
	}
	
	//job name
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_JobName;
	
	public WebElement JobScheduler_JobDefinition_JobName() {
		return JobScheduler_JobDefinition_JobName;
		
	}
	
	//application name
	@FindBy(xpath = "//ion-row[1]/ion-col[3]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_ApplicationName;
	
	public WebElement JobScheduler_JobDefinition_ApplicationName() {
		return JobScheduler_JobDefinition_ApplicationName;
		
	}
	
	//module code
	@FindBy(xpath = "//ion-row[2]/ion-col[1]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_ModuleCode;
	
	public WebElement JobScheduler_JobDefinition_ModuleCode() {
		return JobScheduler_JobDefinition_ModuleCode;
		
	}
	
	//no. of threads 
	@FindBy(xpath = "//ion-row[3]/ion-col[3]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_NumberOfThreads;
	
	public WebElement JobScheduler_JobDefinition_NumberOfThreads() {
		return JobScheduler_JobDefinition_NumberOfThreads;
		
	}
	
	//Sequence number
	@FindBy(xpath = "//ion-row[4]/ion-col[1]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_SequenceNumber;
	
	public WebElement JobScheduler_JobDefinition_SequenceNumber() {
		return JobScheduler_JobDefinition_SequenceNumber;
		
	}
	
	//EOD Dependency
	@FindBy(xpath = "//ion-checkbox")
	private WebElement JobScheduler_JobDefinition_DependencyCheckBox;
	
	public WebElement JobScheduler_JobDefinition_DependencyCheckBox() {
		return JobScheduler_JobDefinition_DependencyCheckBox;
		
	}
	
	//Remarks 
	@FindBy(xpath = "//ion-row[4]/ion-col[2]/ion-item/ion-input/input")
	private WebElement JobScheduler_JobDefinition_Remarks;
	
	public WebElement JobScheduler_JobDefinition_Remarks() {
		return JobScheduler_JobDefinition_Remarks;
		
	}
	
	//JobType 
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement JobScheduler_JobDefinition_JobType;
	
	public WebElement JobScheduler_JobDefinition_JobType() {
		return JobScheduler_JobDefinition_JobType;
		
	}
	
	//ProcessName 
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement JobScheduler_JobDefinition_ProcessName;
	
	public WebElement JobScheduler_JobDefinition_ProcessName() {
		return JobScheduler_JobDefinition_ProcessName;
		
	}
	
	//Parent job 
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement JobScheduler_JobDefinition_ParentJob;
	
	public WebElement JobScheduler_JobDefinition_ParentJob() {
		return JobScheduler_JobDefinition_ParentJob;
		
	}
	
	//SaveButton
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement JobScheduler_JobDefinition_SaveButton;
	
	public WebElement JobScheduler_JobDefinition_SaveButton() {
		return JobScheduler_JobDefinition_SaveButton;
		
	}
	
	// RecordStatus
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement JobScheduler_JobDefinition_RecordStatus;

	public WebElement JobScheduler_JobDefinition_RecordStatus() {
		return JobScheduler_JobDefinition_RecordStatus;
	}

}
