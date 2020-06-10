package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    @FindBy(id = "FirstName")
    WebElement firstNameInput;

    private WebDriver driver;
    private WebDriverWait wait;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlContains("customer/info"));
    }

    public String getFirstName() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(firstNameInput));
        return firstNameInput.getAttribute("value");
    }
}
