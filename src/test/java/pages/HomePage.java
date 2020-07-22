package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends PageBase {

    @FindBy(xpath = "//input[@value='Add to cart']")
    private List<WebElement> addToCartButtons;

    private HeaderSection headerSection;
    private FooterSection footerSection;

    public HomePage(WebDriver driver) {
        super(driver);
        headerSection = new HeaderSection(driver);
        footerSection = new FooterSection(driver);
    }

    public HeaderSection getHeaderSection() {
        return headerSection;
    }

    public FooterSection getFooterSection() {
        return footerSection;
    }

    public void addToCartProductWithIndex(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));
        addToCartButtons.get(index).click();
        headerSection.closeCartNotificationBar();
    }
}
