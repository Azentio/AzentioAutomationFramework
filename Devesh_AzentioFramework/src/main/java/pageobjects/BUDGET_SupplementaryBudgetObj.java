package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_SupplementaryBudgetObj {
	WebDriver driver;

	public BUDGET_SupplementaryBudgetObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//---------------------------------Maker------------------------------------------------//

	// Click on direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement budget_SupplementaryBudget_DirectionIcon;

	public WebElement budget_SupplementaryBudget_DirectionIcon() {
		return budget_SupplementaryBudget_DirectionIcon;
	}

	// click on budget
	@FindBy(xpath = "//ion-label[text()=' Budget ']")
	private WebElement budget_SupplementaryBudget_BudgetField;

	public WebElement budget_SupplementaryBudget_BudgetField() {
		return budget_SupplementaryBudget_BudgetField;
	}

	// click on eye button
	@FindBy(xpath = "//ion-list//div[2]//ion-menu-toggle[2]//ion-item//ion-buttons//ion-button[2]")
	private WebElement budget_SupplementaryBudget_EyeButton;

	public WebElement budget_SupplementaryBudget_EyeButton() {
		return budget_SupplementaryBudget_EyeButton;

	}

	// click on add button
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']")
	private WebElement budget_SupplementaryBudget_AddButton;

	public WebElement budget_SupplementaryBudget_AddButton() {
		return budget_SupplementaryBudget_AddButton;

	}

	// Select existing budget code
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement budget_SupplementaryBudget_BudgetCode;

	public WebElement budget_SupplementaryBudget_BudgetCode() {
		return budget_SupplementaryBudget_BudgetCode;
	}

	// Select budget year
	@FindBy(xpath = "(//input[@type='text'])[4]")
	private WebElement budget_SupplementaryBudget_BudgetYear;

	public WebElement budget_SupplementaryBudget_BudgetYear() {
		return budget_SupplementaryBudget_BudgetYear;
	}

	// Select branch name
	@FindBy(xpath = "(//input[@type='text'])[5]")
	private WebElement budget_SupplementaryBudget_BudgetBranch;

	public WebElement budget_SupplementaryBudget_BudgetBranch() {
		return budget_SupplementaryBudget_BudgetBranch;
	}

	// to verify existing amount will show when valid branch selected.
	@FindBy(xpath = "//input[@id='2021-2022']")
	private WebElement budget_SupplementaryBudget_ExistingAmount;

	public WebElement budget_SupplementaryBudget_ExistingAmount() {
		return budget_SupplementaryBudget_ExistingAmount;
	}

	// currency dropdown
	@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[5]")
	private WebElement budget_SupplementaryBudget_CurrencyDropdown;

	public WebElement budget_SupplementaryBudget_CurrencyDropdown() {
		return budget_SupplementaryBudget_CurrencyDropdown;
	}

	// Select Currency
	@FindBy(xpath = "(//div[@role='combobox'])[5]//input")
	private WebElement budget_SupplementaryBudget_Currency;

	public WebElement budget_SupplementaryBudget_Currency() {
		return budget_SupplementaryBudget_Currency;
	}

	// giving comments
	@FindBy(xpath = "(//input[@class='native-input sc-ion-input-md'])[4]")
	private WebElement budget_SupplementaryBudget_Comments;

	public WebElement budget_SupplementaryBudget_Comments() {
		return budget_SupplementaryBudget_Comments;
	}

	// Enter supplymentary_apportion_amount
	@FindBy(xpath = "//ion-row//datatable-row-wrapper//datatable-body-row//div[2]//datatable-body-cell[3]//div//app-kub-currency//input")
	private WebElement budget_SupplementaryBudget_SupplementaryApportionAmount;

	public WebElement budget_SupplementaryBudget_SupplementaryApportionAmount() {
		return budget_SupplementaryBudget_SupplementaryApportionAmount;
	}

	// Click on new amount
	@FindBy(xpath = "//input[@class='datatable ng-pristine ng-valid ng-touched']")
	private WebElement budget_SupplementaryBudget_NewAmount;

	public WebElement budget_SupplementaryBudget_NewAmount() {
		return budget_SupplementaryBudget_NewAmount;
	}

	// Save supplementary budget
	@FindBy(xpath = "//ion-icon[@name='save']")
	private WebElement budget_SupplementaryBudget_SupplementaryBudgetSave;

	public WebElement budget_SupplementaryBudget_SupplementaryBudgetSave() {
		return budget_SupplementaryBudget_SupplementaryBudgetSave;
	}

	// Supplementary Budget action edit
	@FindBy(xpath = "//span[contains(text(),' AR12345 ')]/../../../datatable-body-cell/div/ion-buttons/ion-button")
	private WebElement budget_SupplementaryBudget_SupplementaryBudgetEdit;

	public WebElement budget_SupplementaryBudget_SupplementaryBudgetEdit() {
		return budget_SupplementaryBudget_SupplementaryBudgetEdit;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement budget_SupplementaryBudget_SubmitButton;

	public WebElement budget_SupplementaryBudget_SubmitButton() {
		return budget_SupplementaryBudget_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement budget_SupplementaryBudget_RemarkField;

	public WebElement budget_SupplementaryBudget_RemarkField() {
		return budget_SupplementaryBudget_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-row/ion-col/ion-button")
	private WebElement budget_SupplementaryBudget_SubmitByMaker;

	public WebElement budget_SupplementaryBudget_SubmitByMaker() {
		return budget_SupplementaryBudget_SubmitByMaker;
	}

	// notification in maker
	@FindBy(xpath = "//ion-buttons[2]/ion-button[2]")
	private WebElement budget_SupplementaryBudget_MakerNotificationButton;

	public WebElement budget_SupplementaryBudget_MakerNotificationButton() {
		return budget_SupplementaryBudget_MakerNotificationButton;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")
	private WebElement budget_SupplementaryBudget_FirstPencilButton;

	public WebElement budget_SupplementaryBudget_FirstPencilButton() {
		return budget_SupplementaryBudget_FirstPencilButton;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
	private WebElement budget_SupplementaryBudget_FirstReferenceId;

	public WebElement budget_SupplementaryBudget_FirstReferenceId() {
		return budget_SupplementaryBudget_FirstReferenceId;
	}

	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement budget_SupplementaryBudget_RecordStatus;

	public WebElement budget_SupplementaryBudget_RecordStatus() {
		return budget_SupplementaryBudget_RecordStatus;
	}

	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement maker_notification_next_button;

	public WebElement maker_notification_next_button() {
		return maker_notification_next_button;
	}

//-------------------------------------------Reviewer---------------------------------------------//

	// notification in reviewer
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement budget_SupplementaryBudget_NotificationButton;

	public WebElement budget_SupplementaryBudget_NotificationButton() {
		return budget_SupplementaryBudget_NotificationButton;
	}

	// approve
	@FindBy(xpath = "//span[contains(text(),'Approve')]")
	private WebElement budget_SupplementaryBudget_ApproveByReviewer;

	public WebElement budget_SupplementaryBudget_ApproveByReviewer() {
		return budget_SupplementaryBudget_ApproveByReviewer;
	}

	// remark by reviewer
	@FindBy(xpath = "//textarea[@class='native-textarea sc-ion-textarea-ios']")
	private WebElement budget_SupplementaryBudget_RemarkByReviewer;

	public WebElement budget_SupplementaryBudget_RemarkByReviewer() {
		return budget_SupplementaryBudget_RemarkByReviewer;
	}

	// submit by reviewer
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement budget_SupplementaryBudget_SubmitByReviewer;

	public WebElement budget_SupplementaryBudget_SubmitByReviewer() {
		return budget_SupplementaryBudget_SubmitByReviewer;
	}

	@FindBy(xpath = "//ion-col[2]//app-kub-lov//span//ng-select")
	private WebElement budget_SupplementaryBudget_BudgetCodeVerify;

	public WebElement budget_SupplementaryBudget_BudgetCodeVerify() {
		return budget_SupplementaryBudget_BudgetCodeVerify;
	}

	@FindBy(xpath = "//ion-col[4]//span[2]")
	private WebElement budget_SupplementaryBudget_BudgetTypeVerify;

	public WebElement budget_SupplementaryBudget_BudgetTypeVerify() {
		return budget_SupplementaryBudget_BudgetTypeVerify;
	}

	@FindBy(xpath = "//ion-col[5]//ion-item//select//option[2]")
	private WebElement budget_SupplementaryBudget_BudgetYearVerify;

	public WebElement budget_SupplementaryBudget_BudgetYearVerify() {
		return budget_SupplementaryBudget_BudgetYearVerify;
	}

	// @FindBy(xpath="//ion-col[6]//ion-item//ion-select")
	@FindBy(xpath = "//ion-col[6]//app-kub-lov//span//ng-select//div//div//div[2]//span[2]")
	private WebElement budget_SupplementaryBudget_BudgetBranchVerify;

	public WebElement budget_SupplementaryBudget_BudgetBranchVerify() {
		return budget_SupplementaryBudget_BudgetBranchVerify;
	}

	@FindBy(xpath = "//ion-col[10]//app-kub-lov//span//ng-select//div//div//div[2]//span[2]")
	private WebElement budget_SupplementaryBudget_BudgetCurrencyVerify;

	public WebElement budget_SupplementaryBudget_BudgetCurrencyVerify() {
		return budget_SupplementaryBudget_BudgetCurrencyVerify;
	}

	// ------------------------TESTCASE (BP_SB_01_01)-----------------//
	@FindBy(xpath = "//datatable-header-cell[2]//label")
	private WebElement budget_SupplementaryBudget_VerifyBudgetCodeField;

	public WebElement budget_SupplementaryBudget_VerifyBudgetCodeField() {
		return budget_SupplementaryBudget_VerifyBudgetCodeField;
	}

	@FindBy(xpath = "//datatable-header-cell[3]//label")
	private WebElement budget_SupplementaryBudget_VerifyBudgetNameField;

	public WebElement budget_SupplementaryBudget_VerifyBudgetNameField() {
		return budget_SupplementaryBudget_VerifyBudgetNameField;
	}

	@FindBy(xpath = "//datatable-header-cell[4]//label")
	private WebElement budget_SupplementaryBudget_VerifyBudgetYearField;

	public WebElement budget_SupplementaryBudget_VerifyBudgetYearField() {
		return budget_SupplementaryBudget_VerifyBudgetYearField;
	}

	@FindBy(xpath = "//datatable-header-cell[5]//label")
	private WebElement budget_SupplementaryBudget_VerifyBudgetTypeField;

	public WebElement budget_SupplementaryBudget_VerifyBudgetTypeField() {
		return budget_SupplementaryBudget_VerifyBudgetTypeField;
	}

	@FindBy(xpath = "//datatable-header-cell[6]//label")
	private WebElement budget_SupplementaryBudget_VerifyTotalAmountField;

	public WebElement budget_SupplementaryBudget_VerifyTotalAmountField() {
		return budget_SupplementaryBudget_VerifyTotalAmountField;
	}

	@FindBy(xpath = "//datatable-header-cell[7]//label")
	private WebElement budget_SupplementaryBudget_VerifyStatusField;

	public WebElement budget_SupplementaryBudget_VerifyStatusField() {
		return budget_SupplementaryBudget_VerifyStatusField;
	}

	@FindBy(xpath = "//datatable-header-cell[8]//label")
	private WebElement budget_SupplementaryBudget_VerifyCreatedByField;

	public WebElement budget_SupplementaryBudget_VerifyCreatedByField() {
		return budget_SupplementaryBudget_VerifyCreatedByField;
	}

	@FindBy(xpath = "//datatable-header-cell[9]//label")
	private WebElement budget_SupplementaryBudget_VerifyCreateDateField;

	public WebElement budget_SupplementaryBudget_VerifyCreateDateField() {
		return budget_SupplementaryBudget_VerifyCreateDateField;
	}

	@FindBy(xpath = "//datatable-header-cell[10]//label")
	private WebElement budget_SupplementaryBudget_VerifyModifiedByField;

	public WebElement budget_SupplementaryBudget_VerifyModifiedByField() {
		return budget_SupplementaryBudget_VerifyModifiedByField;
	}

	@FindBy(xpath = "//datatable-header-cell[11]//label")
	private WebElement budget_SupplementaryBudget_VerifyModifiedDateField;

	public WebElement budget_SupplementaryBudget_VerifyModifiedDateField() {
		return budget_SupplementaryBudget_VerifyModifiedDateField;
	}

	@FindBy(xpath = "//datatable-header-cell[12]//label")
	private WebElement budget_SupplementaryBudget_VerifyAuthorizedByField;

	public WebElement budget_SupplementaryBudget_VerifyAuthorizedByField() {
		return budget_SupplementaryBudget_VerifyAuthorizedByField;
	}

	@FindBy(xpath = "//datatable-header-cell[13]//label")
	private WebElement budget_SupplementaryBudget_VerifyAuthorizedDateField;

	public WebElement budget_SupplementaryBudget_VerifyAuthorizedDateField() {
		return budget_SupplementaryBudget_VerifyAuthorizedDateField;
	}

	@FindBy(xpath = "//datatable-header-cell[14]//label")
	private WebElement budget_SupplementaryBudget_VerifyAuthStatusField;

	public WebElement budget_SupplementaryBudget_VerifyAuthStatusField() {
		return budget_SupplementaryBudget_VerifyAuthStatusField;
	}
	// --------------------------- TESTCASE (BP_SB_09_01)
	// ----------------------------//

	@FindBy(xpath = "//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[1]//div")
	private WebElement budget_SupplementaryBudget_ValidateQuarter1Period;

	public WebElement budget_SupplementaryBudget_ValidateQuarter1Period() {
		return budget_SupplementaryBudget_ValidateQuarter1Period;
	}

	@FindBy(xpath = "//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[3]//div")
	private WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;

	public WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1() {
		return budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
	}

//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[1]//div")
//	private WebElement budget_SupplementaryBudget_ValidateQuarter1Period;
//	public WebElement budget_SupplementaryBudget_ValidateQuarter1Period()
//	{
//		return budget_SupplementaryBudget_ValidateQuarter1Period;
//	}
//	
//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[3]//div")
//	private WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	public WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1()
//	{
//		return budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	}
//	
//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[1]//div")
//	private WebElement budget_SupplementaryBudget_ValidateQuarter1Period;
//	public WebElement budget_SupplementaryBudget_ValidateQuarter1Period()
//	{
//		return budget_SupplementaryBudget_ValidateQuarter1Period;
//	}
//	
//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[3]//div")
//	private WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	public WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1()
//	{
//		return budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	}
//	
//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[1]//div")
//	private WebElement budget_SupplementaryBudget_ValidateQuarter1Period;
//	public WebElement budget_SupplementaryBudget_ValidateQuarter1Period()
//	{
//		return budget_SupplementaryBudget_ValidateQuarter1Period;
//	}
//	
//	@FindBy(xpath="//ion-row//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[3]//div")
//	private WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	public WebElement budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1()
//	{
//		return budget_SupplementaryBudget_ApportionedAmountFieldForQuarter1;
//	}

	// Click on profile name for logout
	@FindBy(xpath = "//ion-buttons[2]//ion-button[4]")
	private WebElement budget_profilename;

	public WebElement budget_ProfileName() {
		return budget_profilename;
	}

	// click to logout
	@FindBy(xpath = "//ion-icon[@name='log-out']")
	private WebElement budget_Logout;

	public WebElement budget_Logout() {
		return budget_Logout;
	}

	// ---------Test case BP_SB_09_02--------//

	@FindBy(xpath = "//ion-row//datatable-row-wrapper[3]//datatable-body-row//datatable-body-cell[3]//div//app-kub-currency//input")
	private WebElement budget_QuarterlyApportionedAmountQ3;

	public WebElement budget_QuarterlyApportionedAmountQ3() {
		return budget_QuarterlyApportionedAmountQ3;
	}

	@FindBy(xpath = "//datatable-row-wrapper[3]//datatable-body-row//datatable-body-cell[4]//div//app-kub-currency//input")
	private WebElement budget_NewQuarter3Amount;

	public WebElement budget_NewQuarter3Amount() {
		return budget_NewQuarter3Amount;
	}

	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement budget_ValidationMessageForPastMonth;

	public WebElement budget_ValidationMessageForPastMonth() {
		return budget_ValidationMessageForPastMonth;
	}

	// ---------Test case BP_SB_10_01--------//

	@FindBy(xpath = "//datatable-row-wrapper[1]//datatable-body-row//div[2]/datatable-body-cell[3]//div//app-kub-currency//input")
	private WebElement budget_ApportionedAmountForHalfYear1;

	public WebElement budget_ApportionedAmountForHalfYear1() {
		return budget_ApportionedAmountForHalfYear1;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//datatable-body-row//div[2]/datatable-body-cell[4]//div//app-kub-currency//input")
	private WebElement budget_NewAmountForHalfYear1;

	public WebElement budget_NewAmountForHalfYear1() {
		return budget_NewAmountForHalfYear1;
	}

	@FindBy(xpath = "//datatable-row-wrapper[2]//datatable-body-row//div[2]/datatable-body-cell[3]//div//app-kub-currency//input")
	private WebElement budget_ApportionedAmountForHalfYear2;

	public WebElement budget_ApportionedAmountForHalfYear2() {
		return budget_ApportionedAmountForHalfYear2;
	}

	@FindBy(xpath = "//datatable-row-wrapper[2]//datatable-body-row//div[2]/datatable-body-cell[4]//div//app-kub-currency//input")
	private WebElement budget_NewAmountForHalfYear2;

	public WebElement budget_NewAmountForHalfYear2() {
		return budget_NewAmountForHalfYear2;
	}

}
