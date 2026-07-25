package pkg_pageObject;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

public class Page_Register extends GlobalObjects {

    private WebDriverWait localWait    = null;
    private WebDriver localDriver     = null;
    public boolean registerSuccess = false;

    @FindBy(how = How.ID, using = "customer.firstName")
    private WebElement Txtbx_FirstName;
    @FindBy(how = How.ID, using = "customer.lastName")
    private WebElement Txtbx_LastName;
    @FindBy(how = How.ID, using = "customer.address.street")
    private WebElement Txtbx_Address;
    @FindBy(how = How.ID, using = "customer.address.city")
    private WebElement Txtbx_City;
    @FindBy(how = How.ID, using = "customer.address.state")
    private WebElement Txtbx_State;
    @FindBy(how = How.ID, using = "customer.address.zipCode")
    private WebElement Txtbx_Zip;
    @FindBy(how = How.ID, using = "customer.phoneNumber")
    private WebElement Txtbx_Phone;
    @FindBy(how = How.ID, using = "customer.ssn")
    private WebElement Txtbx_SSN;
    @FindBy(how = How.ID, using = "customer.username")
    private WebElement Txtbx_UserName;
    @FindBy(how = How.ID, using = "customer.password")
    private WebElement Txtbx_Password;
    @FindBy(how = How.ID, using = "repeatedPassword")
    private WebElement Txtbx_PasswordAgain;
    @FindBy(how = How.CSS, using = "input[value='Register']")
    private WebElement Btn_Register;
    @FindBy(how = How.XPATH, using = "//*[text()='Log Out']")
    private WebElement Btn_LogOut;
    @FindBy(how = How.XPATH, using = "//*[text()='Your account was created successfully. You are now logged in.']")
    private WebElement Labl_Account;

    // page object pattern
    public Page_Register(WebDriver localDriverParam){
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }

    public void RegistrationInit(){
        // username to be random
        hmGlobalData.put("username",
                hmGlobalData.get("username") + String.valueOf(new Random().nextInt(8999) + 1000));
        System.out.println(hmGlobalData.get("username"));
        Txtbx_FirstName.sendKeys(hmGlobalData.get("name"));
        Txtbx_LastName.sendKeys(hmGlobalData.get("lastName"));
        Txtbx_Address.sendKeys(hmGlobalData.get("address"));
        Txtbx_City.sendKeys(hmGlobalData.get("city"));
        Txtbx_State.sendKeys(hmGlobalData.get("state"));
        Txtbx_Zip.sendKeys(hmGlobalData.get("zip"));
        Txtbx_Phone.sendKeys(hmGlobalData.get("phone"));
        Txtbx_SSN.sendKeys(hmGlobalData.get("ssn"));
        Txtbx_UserName.sendKeys(hmGlobalData.get("username"));
        Txtbx_Password.sendKeys(hmGlobalData.get("password"));
        Txtbx_PasswordAgain.sendKeys(hmGlobalData.get("password"));
        Btn_Register.click();
        localWait.until(ExpectedConditions.visibilityOf(Btn_LogOut));
        localWait.until(ExpectedConditions.visibilityOf(Labl_Account));
        localWait.until(ExpectedConditions.invisibilityOf(Btn_Register));
        registerSuccess = true;
    }

}
