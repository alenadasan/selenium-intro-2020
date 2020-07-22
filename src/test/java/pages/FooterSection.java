package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class FooterSection extends PageBase {

    @FindBy(xpath = "//*[@class='networks']//a")
    private List<WebElement> socialLinks;

    public FooterSection(WebDriver driver) {
        super(driver);
    }

    public void clickOnSocialLinkWithIndex(int index) {
        socialLinks.get(index).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
    }

    public void closeCurrentSocialTab() {
        driver.close();

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(0));
    }
}
