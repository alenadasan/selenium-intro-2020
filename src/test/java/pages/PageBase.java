package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 3);
    }

    public void waitForWebElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementToBeEnabled(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> strings = new ArrayList<>();

        for (WebElement webElement : elements) {
            strings.add(webElement.getText());
        }

        return strings;
    }
}
