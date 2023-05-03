package pageobjects.CSM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmendChequeCardStatusObject {
	WebDriver driver;

	public AmendChequeCardStatusObject(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//td[text()='Amend Cheque/Card status']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]/span[1]")
	private WebElement amendchequeCardStatusFlag;
	public WebElement amendchequeCardStatus_Flag() {
		return amendchequeCardStatusFlag;
	}
	@FindBy(xpath="//td[text()='Amend Cheque/Card status']//ancestor::h3//following-sibling::ul//span[text()='Maintenance']")
	private WebElement amendchequeCardStatusMaintenance;
	public WebElement amendchequeCardStatus_Maintenance() {
		return amendchequeCardStatusMaintenance;
	}
	@FindBy(xpath="//select[@id='product_type_QG001MT']")
	private WebElement amendchequeCardProductType;
	public WebElement amendchequeCard_ProductType() {
		return amendchequeCardProductType;
	}
	@FindBy(xpath="//input[@id='BR_CODE_QG001MT']")
	private WebElement amendchequeCardACNoBranchCode;
	public WebElement amendchequeCard_ACNo_BranchCode() {
		return amendchequeCardACNoBranchCode;
	}
	@FindBy(xpath="//input[@id='CY_CODE_QG001MT']")
	private WebElement amendchequeCardACNoCurrencyCode;
	public WebElement amendchequeCard_ACNo_CurrencyCode() {
		return amendchequeCardACNoCurrencyCode;
	}
	@FindBy(xpath="//input[@id='GL_CODE_QG001MT']")
	private WebElement amendchequeCardACNoGLCode;
	public WebElement amendchequeCard_ACNo_GLCode() {
		return amendchequeCardACNoGLCode;
	}
	@FindBy(xpath="//input[@id='CIF_SUB_NO_QG001MT']")
	private WebElement amendchequeCardACNoCIFCode;
	public WebElement amendchequeCard_ACNo_CIFCode() {
		return amendchequeCardACNoCIFCode;
	}
	@FindBy(xpath="//input[@id='lookuptxt_SL_NO_QG001MT']")
	private WebElement amendchequeCardACNoSerialNumber;
	public WebElement amendchequeCard_ACNo_SerialNumber() {
		return amendchequeCardACNoSerialNumber;
	}
	@FindBy(xpath="//input[@id='requestNo_QG001MT']")
	private WebElement amendchequeCardRequestNumber;
	public WebElement amendchequeCard_RequestNumber() {
		return amendchequeCardRequestNumber;
	}
	@FindBy(xpath="//label[text()='Update ']")
	private WebElement amendChequeCardUpdateButton;
	public WebElement amendChequeCard_UpdateButton() {
		return amendChequeCardUpdateButton;
	}
	@FindBy(xpath="//button[@id='retrieveBtn_QG001MT']")
	private WebElement amendChequeCardRetrieveButton;
	public WebElement amendChequeCard_RetrieveButton() {
		return amendChequeCardRetrieveButton;
	}
	@FindBy(xpath="//select[@id='check_status_type_QG001MT']")
	private WebElement amendChequeCardStatusSelectButton;
	public WebElement amendChequeCard_StatusSelectButton() {
		return amendChequeCardStatusSelectButton;
	}
	@FindBy(xpath="//input[@id='jqg_ammendChequeBookGridTbl_Id_QG001MT_1']")
	private WebElement amendChequeCardFirstRecordCheckBox;
	public WebElement amendChequeCard_FirstRecordCheckBox() {
		return amendChequeCardFirstRecordCheckBox;
	}
	@FindBy(xpath="//span[@id='spanLookup_SL_NO_QG001MT']")
	private WebElement amendChequeCardAccNoSearchButton;
	public WebElement amendChequeCard_AccNoSearchButton() {
		return amendChequeCardAccNoSearchButton;
	}
	@FindBy(xpath="//td[text()='Chequebook Request']//ancestor::h3/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement chequebookRequestFlag;
	public WebElement chequebookRequest_Flag() {
		return chequebookRequestFlag;
	}
	@FindBy(xpath="//span[text()='To Cancel']//ancestor::a")
	private WebElement chequebookRequestToCancel;
	public WebElement chequebookRequest_ToCancel() {
		return chequebookRequestToCancel;
	}
	@FindBy(xpath="//input[@id='chequeBookGridTbl_Id_Q000TC_gs_ctschqbookVO.CODE']")
	private WebElement chequebookRequestCheckBookCode;
	public WebElement chequebookRequest_CheckBookCode() {
		return chequebookRequestCheckBookCode;
	}
	@FindBy(xpath="//td[@id='td_chequeBookGridTbl_Id_Q000TC_1_ctschqbookVO.CODE']")
	private WebElement chequebookRequestFirstRecord;
	public WebElement chequebookRequest_FirstRecord() {
		return chequebookRequestFirstRecord;
	}
	@FindBy(xpath="//span[text()='close']")
	private WebElement chequebookRequesMemoCloseButton;
	public WebElement chequebookRequest_MemoCloseButton() {
		return chequebookRequesMemoCloseButton;
	}
	
	
}
