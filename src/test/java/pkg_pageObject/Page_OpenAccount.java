package pkg_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

public class Page_OpenAccount extends GlobalObjects {

    private WebDriverWait localWait    = null;
    private WebDriver localDriver     = null;
    public boolean accountOpenSuccess = false;

    @FindBy(how = How.XPATH, using = "//a[@href='openaccount.htm']")
    private WebElement Lnk_OpenNewAccount;
    @FindBy(how = How.XPATH, using = "//input[@value='Open New Account']")
    private WebElement Btn_OpenNewAccount;

    private final String AccountOpenSuccessXpath = "//*[text()='Account Opened!']";
    @FindBy(how = How.XPATH, using = AccountOpenSuccessXpath)
    private WebElement Labl_AccountOpenSuccess;
    @FindBy(how = How.ID, using = "newAccountId")
    private WebElement Labl_AccountId;

    @FindBy(how = How.XPATH, using =  "//*[text()='Transfer Funds']")
    private WebElement Btn_TransferFunds;
    @FindBy(how = How.ID, using = "amount")
    private WebElement Txtbx_TransferAmount;
    @FindBy(how = How.XPATH, using = "//*[text()='Transfer Complete!']")
    private WebElement Labl_TransferComplete;
    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    private WebElement Btn_Transfer;

    // page object pattern
    public Page_OpenAccount(WebDriver localDriverParam){
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }

    public void OpenNewAccount(){
        Lnk_OpenNewAccount.click();
        utilGeneral.MyThreadSleep(utilGeneral.sleepMilliSec);
        localWait.until(ExpectedConditions.elementToBeClickable(Btn_OpenNewAccount));
        Btn_OpenNewAccount.click();
    }
    public void NewAccountValidation(){
        localWait.until(ExpectedConditions.visibilityOf(Labl_AccountOpenSuccess));
        localWait.until(ExpectedConditions.visibilityOf(Labl_AccountId));
        System.out.println("Account number is " + Labl_AccountId.getText());
        accountOpenSuccess = true;
    }

    public void InitFundTransfer(String transferAmount){
        Btn_TransferFunds.click();
        localWait.until(ExpectedConditions.visibilityOf(Txtbx_TransferAmount));
        Txtbx_TransferAmount.sendKeys(transferAmount);
    }
    public void FundTransferValidation(){
        Btn_Transfer.click();
        localWait.until(ExpectedConditions.visibilityOf(Labl_TransferComplete));
    }
}
