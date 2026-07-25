package pkg_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

import java.util.List;

public class Page_Checkout extends GlobalObjects {

    private WebDriverWait localWait = null;
    private WebDriver localDriver = null;

    @FindBy(how = How.CSS, using = "tr[id*='product_']")
    private WebElement Element_OverallProductsCheckout;
    @FindBy(how = How.CSS, using = "a[title='Log me out']")
    private List<WebElement> lstBtn_SignOut;

    // page object pattern
    public Page_Checkout(WebDriver localDriverParam) {
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }
}
