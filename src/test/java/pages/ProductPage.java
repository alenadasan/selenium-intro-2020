package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends PageBase{

    @FindBy(xpath = "//a[@title='Email']")
    private WebElement emailIcon;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage clickEmailIconAndSwitchToEmailPage() {
        waitForWebElementToBeVisible(emailIcon);
        emailIcon.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        return new EmailPage(driver);
    }
}
