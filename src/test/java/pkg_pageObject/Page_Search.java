package pkg_pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

public class Page_Search extends GlobalObjects {

    private WebDriverWait localWait    = null;
    private WebDriver localDriver     = null;

    // page object pattern
    public Page_Search(WebDriver localDriverParam){
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }
}
