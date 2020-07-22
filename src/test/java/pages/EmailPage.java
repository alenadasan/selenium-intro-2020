package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

    @FindBy(partialLinkText = "I agree")
    private WebElement agreeButton;

    public EmailPage(WebDriver driver) {
        super(driver);
    }


    public void switchToCookiesConsent() {
//        waitForWebElementToBeVisible(driver.findElement(By.className("mainContent")));
        driver.switchTo().frame("defaultpreferencemanager");
        System.out.println(driver.getPageSource());

        waitForWebElementToBeVisible(agreeButton);
        agreeButton.click();

        System.out.println(driver.getPageSource());
    }
}
