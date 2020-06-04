package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(xpath = "(//input[@name='btnK'])[2]")
    private WebElement searchButton;

    @FindBy(className = "Email")
    private WebElement emailInput;

    @FindBy(linkText = "Privacy")
    private WebElement privacyLink;
    @FindBy(partialLinkText = "How Search works")
    private WebElement howSearchWorksLink;

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultsPage searchFor(String query) {
        searchInput.sendKeys(query);
        searchButton.click();

        return new ResultsPage();
    }
}
