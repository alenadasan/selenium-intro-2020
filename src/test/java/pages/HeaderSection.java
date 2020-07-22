package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderSection extends PageBase {

    @FindBy(id = "small-searchterms")
    private WebElement searchInput;
    @FindBy(xpath = "//input[contains(@class, 'search-box-button')]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='header-links']//a")
    private List<WebElement> headerLinks;
    @FindBy(xpath = "//*[@class='top-menu notmobile']/li/a")
    private List<WebElement> menuItems;
    @FindBy(xpath = "//*[@class='top-menu notmobile']//ul[contains(@class, 'first-level')]/li/a")
    private List<WebElement> subMenuItems;

    @FindBy(className = "close")
    private WebElement notificationBarCloseButton;

    @FindBy(className = "count")
    private WebElement cartCounterMessage;

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

    public void selectMenuItem(String menuItem) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                item.click();
                break;
            }
        }
    }

    public void selectSubMenuItem(String menuItem, String submenuItem) {
        for (WebElement item : menuItems) {
            if(item.getText().equalsIgnoreCase(menuItem)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(item).perform();

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(submenuItem)));
                driver.findElement(By.partialLinkText(submenuItem)).click();

                break;
            }
        }
    }

    public void closeCartNotificationBar() {
        waitForWebElementToBeVisible(notificationBarCloseButton);
        notificationBarCloseButton.click();
//        wait.until(ExpectedConditions.invisibilityOf(notificationBarCloseButton));
    }

    public String getCartCounterMessage() {
        openCartMenu();
        waitForWebElementToBeVisible(cartCounterMessage);
        return cartCounterMessage.getText();
    }

    public void openCartMenu() {
        waitForWebElementToBeVisible(headerLinks.get(3));
        Actions actions = new Actions(driver);
        actions.moveToElement(headerLinks.get(3)).perform();
    }

    public SearchResultsPage searchFor(String query) {
        searchInput.sendKeys(query);
        searchButton.click();

        return new SearchResultsPage(driver);
    }
}
