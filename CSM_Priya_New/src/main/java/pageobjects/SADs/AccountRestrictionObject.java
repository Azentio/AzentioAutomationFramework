package pageobjects.SADs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRestrictionObject {
	
   WebDriver driver;
 public AccountRestrictionObject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}
 @FindBy(xpath="//td[text()='Parameters']")
 private WebElement menuOptionParameter;
 public WebElement menuOption_Parameter() {
	 return menuOptionParameter;
 }
 @FindBy(xpath="//td[text()='Account Restrictions']")
 private WebElement accountRestrictions;
 public WebElement accountRestrictions() {
	 return accountRestrictions;
 }
 @FindBy(xpath="//span[text()='Maintenance']")
 private WebElement accountRestrictionsMaintenance;
 public WebElement accountRestrictions_Maintenance() {
	 return accountRestrictionsMaintenance;
	  }
 @FindBy(xpath="//span[text()='Approve']")
 private WebElement accountRestrictionsApprove;
 public WebElement accountRestrictions_Approve() {
	 return accountRestrictionsApprove;
 }
 @FindBy(xpath="//span[text()='Update After Approve']")
 private WebElement accountRestrictionsUpdateAfterApprove;
 public WebElement accountRestrictions_UpdateAfterApprove() {
	 return accountRestrictionsUpdateAfterApprove;
 }
 @FindBy(xpath="//span[text()='List of Restriction']")
 private WebElement accountRestrictionsListOfRestriction;
 public WebElement accountRestrictions_ListOfRestriction() {
	 return accountRestrictionsListOfRestriction;
 }
@FindBy(xpath="//input[@id='code_UR00M']")
private WebElement code;
public WebElement code() {
	return code;
}
@FindBy(xpath="//input[@id='description_UR00M']")
private WebElement description;
public WebElement description() {
	return description;
}
@FindBy(xpath="//select[@id='and_or_UR00M']")
private WebElement And_Or;
public WebElement And_Or() {
	return And_Or;
}
@FindBy(xpath="//tbody/tr[@id='ROOT__ROOT']/td[@id='td_ctsRestOptTreeGridTbl_Id_UR00M_1_progDesc']/div[1]/div[1]")
private WebElement applicationOTPsRoot;
public WebElement applicationOTPs_Root() {
	return applicationOTPsRoot;
}
@FindBy(xpath="//tbody/tr[@id='RET__RET']/td/div[1]/div[1]")
private WebElement RETFlag;
public WebElement RET_Flag() {
	return RETFlag;
}
@FindBy(xpath=" //span[text()='Transactions']//ancestor::td[1]/div/div")
private WebElement TransactionFlag;
public WebElement Transaction_Flag() {
	return TransactionFlag;
}
@FindBy(xpath="//span[text()='Transactions']//parent::td/preceding-sibling::td[@id='td_ctsRestOptTreeGridTbl_Id_UR00M_1_hasRestrictionYN']/input")
private WebElement transactionCheckbox;
public WebElement transactiopn_Checkbox() {
	return transactionCheckbox;
}
@FindBy(xpath="//tbody/tr[@id='ROOT__ROOT__branchGrid']/td[@id='td_ctsRestBranchesTreeGridTbl_Id_UR00M_1_progDesc']/div[1]/div[1]")
private WebElement companiesBranchesRootFlag;
public WebElement companiesBranches_RootFlag() {
	return companiesBranchesRootFlag;
}
@FindBy(xpath="//span[text()='1 - BAJ']//ancestor::td[1]/div/div")
private WebElement branch1Flag;
public WebElement branch1_Flag() {
	return branch1Flag;
}
@FindBy(xpath="//span[text()='1 - BAJ']//parent::td//preceding-sibling::td[2]/input")
private WebElement branch1CheckBox;
public WebElement branch1_CheckBox() {
	return branch1CheckBox;
}
@FindBy(xpath="//input[@id='userGridId_UR00M_gs_usrVO.USER_ID']")
private WebElement userIDSearchField;
public WebElement userID_SearchField() {
	return userIDSearchField;
}
@FindBy(xpath="//input[@id='jqg_userGridId_UR00M_1']")
private WebElement userIDFirstCheckBox;
public WebElement userID_FirstCheckBox() {
	return userIDFirstCheckBox;
}
@FindBy(xpath="//td[@id='restrictionsGridTbl_Id_UR00M_pager_left']//table//td/div/span[@class='ui-icon ui-icon-plus']")
private WebElement restrictionTypeGLAddbutton;
public WebElement restrictionType_GL_Addbutton() {
	return restrictionTypeGLAddbutton;
}
@FindBy(xpath="//div[@id='lookupid_glCode_no_UR00M']//span[@id='spanLookup_glCode_no_UR00M']")
private WebElement glCodeSearchButton;
public WebElement glCode_SearchButton() {
	return glCodeSearchButton;
}
@FindBy(xpath="//input[@id='gridtab_glCode_no_UR00M_gs_GL_CODE']")
private WebElement glCodeInputField;
public WebElement glCode_InputField() {
	return glCodeInputField;
}
@FindBy(xpath="//td[@id='td_gridtab_glCode_no_UR00M_1_GL_CODE']")
private WebElement glCodeInputValueClick;
public WebElement glCode_InputValue_Click() {
return glCodeInputValueClick;
}
@FindBy(xpath="//td[@id='cifTypeGridId_UR00M_pager_left']//table//td/div/span[@class='ui-icon ui-icon-plus']")
private WebElement CIFTypeAddButton;
public WebElement CIFType_AddButton() {
	return CIFTypeAddButton;
}
@FindBy(xpath="(//table[@name='CIF_TYPE']//td//span)[1]")
private WebElement CIFTypeSearchButton;
public WebElement CIFType_SearchButton() {
	return CIFTypeSearchButton;
}
@FindBy(xpath="//input[@name='TYPE_CODE']")
private WebElement CIFTypeCodeInputField;
public WebElement CIFTypeCode_InputField() {
return CIFTypeCodeInputField;
}
@FindBy(xpath="//label[text()='Save ']")
private WebElement saveButton;
public WebElement save_Button() {
return saveButton;
}
@FindBy(xpath="//input[@id='ctsRestrictionsListGridTbl_Id_UR00P_gs_code']")
private WebElement approvalCodeInputValue;
public WebElement approval_Code_InputValue() {
	return approvalCodeInputValue;
}
@FindBy(xpath="//td[@id='td_ctsRestrictionsListGridTbl_Id_UR00P_1_code']")
private WebElement clickApprovalCodeInputValue;
public WebElement click_Approval_Code_InputValue() {
	return clickApprovalCodeInputValue; 
}
@FindBy(xpath="//label[@id='ctsRestrictionsFormId_UR00P_Approve_key']")
private WebElement approvalButton;
public WebElement approval_Button() {
	return approvalButton;
}
@FindBy(xpath="//input[@id='_popup_path_sol_ok']")
private WebElement saveSucessOKButton;
public WebElement saveSucess_OK_Button() {
	return saveSucessOKButton; 
}

}