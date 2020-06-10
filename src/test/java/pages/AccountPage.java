package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends PageBase{

    @FindBy(id = "FirstName")
    WebElement firstNameInput;


    public AccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlContains("customer/info"));
    }

    public String getFirstName() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(firstNameInput));
        return firstNameInput.getAttribute("value");
    }
}
