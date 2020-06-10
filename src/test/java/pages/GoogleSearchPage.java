package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends PageBase {

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


    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultsPage searchFor(String query) {
        searchInput.sendKeys(query);
        searchButton.click();

        return new ResultsPage(driver);
    }
}
