package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArApObj {
	WebDriver driver;

	public ArApObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* InventoryManagament Button
		@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
		private WebElement inventoryManagament_button;

		public WebElement inventoryManagament_button() {
			return inventoryManagament_button;
	"*/
	//Report Button
	@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/ion-segment[1]/ion-segment-button[3]")
	private WebElement report_button;

	public WebElement report_button() {
		return report_button;
	}	
		
	//Financial reporting Button
		@FindBy(xpath = "//ion-label[contains(text(),'Financial reporting')]")
		private WebElement financial_Reporting;

		public WebElement financial_Reporting() {
			return financial_Reporting;
		}	
		//balanceSheetReport Button
		@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[6]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement balanceSheetReport_button;

		public WebElement balanceSheetReport_button() {
			return balanceSheetReport_button;
		}	
		
		//balanceSheetReport Button
				@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement balanceSheetReport_branch_textbox;

				public WebElement balanceSheetReport_branch_textbox() {
					return balanceSheetReport_branch_textbox;
				}		
		
				//Calendar Button
				@FindBy(xpath = "//span[@class='input-calendar']")
				private WebElement calendar_button;

				public WebElement calendar_button() {
					return calendar_button;
				}		
				
				//View Button
				@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
				private WebElement view_button;

				public WebElement view_button() {
					return view_button;
				}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
