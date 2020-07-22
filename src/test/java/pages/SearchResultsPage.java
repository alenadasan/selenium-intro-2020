package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageBase {

    @FindBy(xpath = "//*[@class='product-title']/a")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//div[@class='warning' or @class='no-result']")
    private WebElement warningMessage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getSearchResults() {
        List<String> text = new ArrayList<String>();
        for (WebElement e: searchResults) {
            text.add(e.getText().toLowerCase());
        }
        return text;
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }
}
