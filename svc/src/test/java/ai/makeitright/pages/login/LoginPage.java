package ai.makeitright.pages.login;

import ai.makeitright.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, String url) {
        super(driver,url);
    }

    @Override
    protected boolean isAt() {
        Assert.assertEquals("Current URL address '" + driver.getCurrentUrl() + "' is not like expected '" + url + "'",url,driver.getCurrentUrl());
        return true;
    }
}
