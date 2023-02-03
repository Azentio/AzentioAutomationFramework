package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_ReportsObj {
	WebDriver driver;

	public FixedAsset_ReportsObj(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	// Report Button
	@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/ion-segment[1]/ion-segment-button[3]")
	private WebElement fixedAsset_ReportButton;

	public WebElement fixedAsset_ReportButton() {
		return fixedAsset_ReportButton;
	}
	
	// Transaction reports Button
	@FindBy(xpath = "//ion-label[contains(text(),'Transaction reports')]")
	private WebElement fixedAsset_TransactionReports;

	public WebElement fixedAsset_TransactionReports() {
		return fixedAsset_TransactionReports;
	}
	
	// Replacement report Button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_ReplacementReport;

	public WebElement fixedAsset_ReplacementReport() {
		return fixedAsset_ReplacementReport;
	}
	// Replacement Asset Code
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_ReplacementReport_AssetCode;

	public WebElement fixedAsset_ReplacementReport_AssetCode() {
		return fixedAsset_ReplacementReport_AssetCode;
	}
	//Replacement Item Number
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_ReplacementReport_ItemNumber;

	public WebElement fixedAsset_ReplacementReport_ItemNumber() {
		return fixedAsset_ReplacementReport_ItemNumber;
	}

	// Calendar
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement fixedAsset_ReplacementReport_Calendar;

	public WebElement fixedAsset_ReplacementReport_Calendar() {
		return fixedAsset_ReplacementReport_Calendar;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement fixedAsset_ReplacementReport_NextMonth;

	public WebElement fixedAsset_ReplacementReport_NextMonth() {
		return fixedAsset_ReplacementReport_NextMonth;
	}
	
	
	// Impairement report Button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[2]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_ImpairementReport;

	public WebElement fixedAsset_ImpairementReport() {
		return fixedAsset_ImpairementReport;
	}
	
	// Calendar
		@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
		private WebElement fixedAsset_ImpairementReport_Calendar;

		public WebElement fixedAsset_ImpairementReport_Calendar() {
			return fixedAsset_ImpairementReport_Calendar;
		}

		// NextMonth
		@FindBy(xpath = "(//button[@type='button'])[3]")
		private WebElement fixedAsset_ImpairementReport_NextMonth;

		public WebElement fixedAsset_ImpairementReport_NextMonth() {
			return fixedAsset_ImpairementReport_NextMonth;
		}
	
	// Revaluation report Button
	@FindBy(xpath = "//ion-label[text()=' Assets re-valuation report ']//following-sibling::ion-buttons/ion-button")
	private WebElement fixedAsset_RevaluationReport;

	public WebElement fixedAsset_RevaluationReport() {
		return fixedAsset_RevaluationReport;
	}
			// Calendar
			@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
			private WebElement fixedAsset_RevaluationReport_Calendar;

			public WebElement fixedAsset_RevaluationReport_Calendar() {
				return fixedAsset_RevaluationReport_Calendar;
			}

			// NextMonth
			@FindBy(xpath = "(//button[@type='button'])[3]")
			private WebElement fixedAsset_RevaluationReport_NextMonth;

			public WebElement fixedAsset_RevaluationReport_NextMonth() {
				return fixedAsset_RevaluationReport_NextMonth;
			}
			// BeforeMonth
						@FindBy(xpath = "(//button[@type='button'])[1]")
						private WebElement fixedAsset_RevaluationReport_BeforeMonth;

						public WebElement fixedAsset_RevaluationReport_BeforeMonth() {
							return fixedAsset_RevaluationReport_BeforeMonth;
						}
		
	// Return report Button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[4]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_ReturnReport;

	public WebElement fixedAsset_ReturnReport() {
		return fixedAsset_ReturnReport;
	}
	// Return Asset Code
		@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_ReturnReport_AssetCode;

		public WebElement fixedAsset_ReturnReport_AssetCode() {
			return fixedAsset_ReturnReport_AssetCode;
		}
		//Return Item Number
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_ReturnReport_ItemNumber;

		public WebElement fixedAsset_ReturnReport_ItemNumber() {
			return fixedAsset_ReturnReport_ItemNumber;
		}

		// Calendar
		@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
		private WebElement fixedAsset_ReturnReport_Calendar;

		public WebElement fixedAsset_ReturnReport_Calendar() {
			return fixedAsset_ReturnReport_Calendar;
		}

		// NextMonth
		@FindBy(xpath = "(//button[@type='button'])[3]")
		private WebElement fixedAsset_ReturnReport_NextMonth;

		public WebElement fixedAsset_ReturnReport_NextMonth() {
			return fixedAsset_ReturnReport_NextMonth;
		}
		
	
	// Allocation report Button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[5]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_AllocationReport;

	public WebElement fixedAsset_AllocationReport() {
		return fixedAsset_AllocationReport;
	}
	//EmployeeId Allocation
			@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement fixedAsset_AllocationReport_EmployeeId;

			public WebElement fixedAsset_AllocationReport_EmployeeId() {
				return fixedAsset_AllocationReport_EmployeeId;
			}
			//AllocationReport Item Number
			@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement fixedAsset_AllocationReport_ItemNumber;

			public WebElement fixedAsset_AllocationReport_ItemNumber() {
				return fixedAsset_AllocationReport_ItemNumber;
			}

			// Calendar
			@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
			private WebElement fixedAsset_AllocationReport_Calendar;

			public WebElement fixedAsset_AllocationReport_Calendar() {
				return fixedAsset_AllocationReport_Calendar;
			}

			// NextMonth
			@FindBy(xpath = "(//button[@type='button'])[3]")
			private WebElement fixedAsset_AllocationReport_NextMonth;

			public WebElement fixedAsset_AllocationReport_NextMonth() {
				return fixedAsset_AllocationReport_NextMonth;
			}
	
	// DeAllocation report Button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[6]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_DeAllocationReport;

	public WebElement fixedAsset_DeAllocationReport() {
		return fixedAsset_DeAllocationReport;
	}
	//EmployeeId DeAllocation 
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_DeAllocationReport_EmployeeId;

	public WebElement fixedAsset_DeAllocationReport_EmployeeId() {
		return fixedAsset_DeAllocationReport_EmployeeId;
	}
	// CalendarFromDate
		@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
		private WebElement fixedAsset_DeAllocationReport_CalendarDate;

		public WebElement fixedAsset_DeAllocationReport_CalendarDate() {
			return fixedAsset_DeAllocationReport_CalendarDate;
		}

		// NextMonth
		@FindBy(xpath = "(//button[@type='button'])[3]")
		private WebElement fixedAsset_DeAllocationReport_NextMonth;

		public WebElement fixedAsset_DeAllocationReport_NextMonth() {
			return fixedAsset_DeAllocationReport_NextMonth;
		}

		// CalendarToDate
		@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
		private WebElement fixedAsset_DeAllocationReport_CalendarAsOnDate;

		public WebElement fixedAsset_DeAllocationReport_CalendarAsOnDate() {
			return fixedAsset_DeAllocationReport_CalendarAsOnDate;
		}
		//
		// Amendment
		@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[7]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement fixedAsset_AmendmentReport;

		public WebElement fixedAsset_AmendmentReport() {
			return fixedAsset_AmendmentReport;
		}
		//AmendmentModification
		@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AmendmentReport_Modification;

		public WebElement fixedAsset_AmendmentReport_Modification() {
			return fixedAsset_AmendmentReport_Modification;
		}
		//system Date
				@FindBy(xpath = "//span[@class='legal-entity'][1]")
				private WebElement systemDate;

				public WebElement systemDate() {
					return systemDate;
				}
		
}
