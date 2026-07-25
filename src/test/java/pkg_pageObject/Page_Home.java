package pkg_pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

public class Page_Home extends GlobalObjects {

    private WebDriverWait localWait = null;
    private WebDriver localDriver = null;
    public boolean mainMenuItemsCheck = false;

    @FindBy(how = How.XPATH, using = "//*[text()='Solutions']")
    private WebElement Link_Solutions;
    @FindBy(how = How.XPATH, using = "//*[text()='About Us']")
    private WebElement Link_AboutUs;
    @FindBy(how = How.XPATH, using = "//*[text()='Services']")
    private WebElement Link_Services;
    @FindBy(how = How.XPATH, using = "//*[text()='Products']")
    private WebElement Link_Products;
    @FindBy(how = How.XPATH, using = "//*[text()='Locations']")
    private WebElement Link_Locations;
    @FindBy(how = How.CLASS_NAME, using = "home")
    private WebElement Icon_Home;
    @FindBy(how = How.CLASS_NAME, using = "aboutus")
    private WebElement Icon_AboutUs;
    @FindBy(how = How.CLASS_NAME, using = "contact")
    private WebElement Icon_Contact;
    @FindBy(how = How.NAME, using = "username")
    private WebElement Txtbx_User;
    @FindBy(how = How.NAME, using = "password")
    private WebElement Txtbx_Pwd;
    @FindBy(how = How.XPATH, using = "//input[@value='Log In']")
    private WebElement Btn_LogIn;
    @FindBy(how = How.XPATH, using = "//*[text()='Register']")
    private WebElement Lnk_Register;
    @FindBy(how = How.CSS, using = "input[value='Register']")
    private WebElement Btn_Register;

    // constructor
    // page object pattern
    public Page_Home(WebDriver localDriverParam) {
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }

    public void ValidateLoginElements() {
        localWait.until(ExpectedConditions.visibilityOf(Txtbx_User));
        localWait.until(ExpectedConditions.visibilityOf(Txtbx_Pwd));
        localWait.until(ExpectedConditions.visibilityOf(Btn_LogIn));
    }

    public void ValidateMainMenuItems() {
        localWait.until(ExpectedConditions.visibilityOf(Link_Solutions));
        localWait.until(ExpectedConditions.visibilityOf(Link_AboutUs));
        localWait.until(ExpectedConditions.visibilityOf(Link_Services));
        localWait.until(ExpectedConditions.visibilityOf(Link_Products));
        localWait.until(ExpectedConditions.visibilityOf(Link_Locations));
        mainMenuItemsCheck = true;
    }

    public void ValidateWelcomeSectionElements() {
        localWait.until(ExpectedConditions.visibilityOf(Icon_Home));
        localWait.until(ExpectedConditions.visibilityOf(Icon_AboutUs));
        localWait.until(ExpectedConditions.visibilityOf(Icon_Contact));
        mainMenuItemsCheck = true;
    }

    public void NavigateRegistration() {
        Lnk_Register.click();
        localWait.until(ExpectedConditions.visibilityOf(Btn_Register));
    }

    public void NavigateHome() {
        realDriver.get(sUrlHome);
    }
}
