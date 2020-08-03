package ai.makeitright.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected String url;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//        Main.report.logInfo("Checking if '" + this.getClass().getSimpleName() + " Page'  is open");
        Assert.assertTrue(isAt());
//        Main.report.logPass("'" + this.getClass().getSimpleName() + "' is open");
    }


    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        PageFactory.initElements(this.driver, this);
//        Main.report.logInfo("Checking if '" + this.getClass().getSimpleName() + " Page'  is open");
        Assert.assertTrue(isAt());
//        Main.report.logPass("'" + this.getClass().getSimpleName() + "' is open");
    }

    protected abstract boolean isAt();

    public void click(WebElement element, String elementDescription) {
//        Main.report.logInfo("Click "+elementDescription+"");
        element.click();
//        Main.report.logPass("Element was clicked");
    }

    public void sendText(WebElement element, String text, String elementDescription) {
//        Main.report.logInfo("Enter text '"+text+"' to "+elementDescription);
        element.sendKeys(text);
//        Main.report.logPass("Text was entered");
    }
}
