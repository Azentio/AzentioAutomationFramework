package pageobjects.CSM_Param;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChequebookObject {
	WebDriver driver;
	public ChequebookObject(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//td[text()='Cheques']")
	private WebElement CSMParam_chequesFlag;
	public WebElement CSMParam_cheques_Flag() {
		return CSMParam_chequesFlag;
	}
	@FindBy(xpath="//td[text()='ChequeBook']")
	private WebElement CSMParam_ChequeBookFlag;
	public WebElement CSMParam_ChequeBook_Flag() {
		return CSMParam_ChequeBookFlag;
	}
	@FindBy(xpath="//span[text()='Update After Approve']")
	private WebElement CSMParam_ChequeBookUpdateAfterApproval;
	public WebElement CSMParam_ChequeBook_UpdateAfterApproval() {
		return CSMParam_ChequeBookUpdateAfterApproval;
	}
	@FindBy(xpath="//input[@id='chequesBookList_GridTbl_Id_P029MA_gs_ctschequesVO.CODE']")
	private WebElement CSMParam_ChequeBookCodeValue;
	public WebElement CSMParam_ChequeBook_CodeValue() {
		return CSMParam_ChequeBookCodeValue;
	}
	//@FindBy(xpath="//input[@id='chequesBookList_GridTbl_Id_P029MA_gs_ctschequesVO.CODE']")
	//private WebElement CSMParam_ChequeBookCodeValue;
//	public WebElement CSMParam_ChequeBook_CodeValue() {
	//	return CSMParam_ChequeBookCodeValue;
	}
	

