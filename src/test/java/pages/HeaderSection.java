package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderSection extends PageBase{

    @FindBy(xpath = "//*[@class='header-links']//a")
    private List<WebElement> headerLinks;

    public HeaderSection(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickMyAccount() {
        wait.until(ExpectedConditions.textToBePresentInElement(headerLinks.get(0), "My account"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", headerLinks.get(0));

        return new AccountPage(driver);
    }

    public LoginPage goToLogInPage() {
        wait.until(ExpectedConditions.textToBePresentInElement(headerLinks.get(1), "Log in"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", headerLinks.get(1));

        return new LoginPage(driver);
    }

    public void logOut() {
        wait.until(ExpectedConditions.textToBePresentInElement(headerLinks.get(1), "Log out"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", headerLinks.get(1));
    }

    public String getMessageFromAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
