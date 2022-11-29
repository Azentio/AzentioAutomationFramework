package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GL2_LegalEntityGLConfigObj {
	
	WebDriver driver;

	public GL2_LegalEntityGLConfigObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//ion-segment/ion-segment-button[1]")
	private WebElement gL2_LegalEntityGLConfig_ToolIcon;
	public WebElement gL2_LegalEntityGLConfig_ToolIcon() {
		return gL2_LegalEntityGLConfig_ToolIcon;
	}

	// General ledger configuration
	@FindBy(xpath = "//ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[2]/ion-icon[1]")
	private WebElement gL2_Generalledgerconfiguration;

	public WebElement gL2_Generalledgerconfiguration() {
		return gL2_Generalledgerconfiguration;
	}
	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/102']")
	private WebElement gL2_LegalEntityGLConfig_EyeIcon;
	public WebElement gL2_LegalEntityGLConfig_EyeIcon() {
		return gL2_LegalEntityGLConfig_EyeIcon;
	}
		
	//Add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement gL2_LegalEntityGLConfig_AddButton;
	public WebElement gL2_LegalEntityGLConfig_AddButton() {
		 return gL2_LegalEntityGLConfig_AddButton;
	}
	
	//CashGL
	@FindBy(xpath = "//ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_CashGL;

	public WebElement gL2_LegalEntityGLConfig_CashGL() {
		return gL2_LegalEntityGLConfig_CashGL;

	}
	
	//GLCheck
	@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_GLCheck;

	public WebElement gL2_LegalEntityGLConfig_GLCheck() {
		return gL2_LegalEntityGLConfig_GLCheck;

	}

	//InterBranchGL
	@FindBy(xpath = "//ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_InterBranchGL;

	public WebElement gL2_LegalEntityGLConfig_InterBranchGL() {
		return gL2_LegalEntityGLConfig_InterBranchGL;

	}

	//PositionGL
	@FindBy(xpath = "//ion-row[1]/ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_PositionGL;

	public WebElement gL2_LegalEntityGLConfig_PositionGL() {
		return gL2_LegalEntityGLConfig_PositionGL;

	}

	//PLExchangeGainGL
	@FindBy(xpath = "//ion-row[1]/ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_PLExchangeGainGL;

	public WebElement gL2_LegalEntityGLConfig_PLExchangeGainGL() {
		return gL2_LegalEntityGLConfig_PLExchangeGainGL;
	}

	//PLExchangeLossGL
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_PLExchangeLossGL;

	public WebElement gL2_LegalEntityGLConfig_PLExchangeLossGL() {
		return gL2_LegalEntityGLConfig_PLExchangeLossGL;
	}

	//RevaluationProfitGL
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_RevaluationProfitGL;

	public WebElement gL2_LegalEntityGLConfig_RevaluationProfitGL() {
		return gL2_LegalEntityGLConfig_RevaluationProfitGL;
	}

	//RevaluationLossGL
	@FindBy(xpath = "//ion-row[1]/ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_RevaluationLossGL;

	public WebElement gL2_LegalEntityGLConfig_RevaluationLossGL() {
		return gL2_LegalEntityGLConfig_RevaluationLossGL;
	}

	//RevaluationNotionalProfitGL
	@FindBy(xpath = "//ion-row[1]/ion-col[12]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL;

	public WebElement gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL() {
		return gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL;
	}

	//RevaluationNotionalLossGL
	@FindBy(xpath = "//ion-row[1]/ion-col[13]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_LegalEntityGLConfig_RevaluationNotionalLossGL;

	public WebElement gL2_LegalEntityGLConfig_RevaluationNotionalLossGL() {
		return gL2_LegalEntityGLConfig_RevaluationNotionalLossGL;
	}

	// Save
	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement gL2_LegalEntityGLConfig_Save;

	public WebElement gL2_LegalEntityGLConfig_Save() {
		return gL2_LegalEntityGLConfig_Save;
	}
}
