package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationResultPage extends PageBase{

    @FindBy(className = "result")
    private WebElement resultMessage;

    private WebDriver driver;
    private HeaderSection header;

    public RegistrationResultPage(WebDriver driver) {
        super(driver);
        header = new HeaderSection(driver);
    }

    public String getResult() {
        return resultMessage.getText();
    }

    public HeaderSection getHeader() {
        return header;
    }
}
