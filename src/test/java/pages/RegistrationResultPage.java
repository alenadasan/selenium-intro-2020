package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationResultPage {

    @FindBy(className = "result")
    private WebElement resultMessage;

    private WebDriver driver;
    private HeaderSection header;

    public RegistrationResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new HeaderSection(driver);
    }

    public String getResult() {
        return resultMessage.getText();
    }

    public HeaderSection getHeader() {
        return header;
    }
}
