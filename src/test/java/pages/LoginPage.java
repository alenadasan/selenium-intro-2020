package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {

    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Password")
    private WebElement passwordInput;
    @FindBy(xpath = "//a[@href= '/passwordrecovery']")
    private WebElement passwordRecoveryLink;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;
    @FindBy(id = "Email-error")
    private WebElement emailError;
    @FindBy(xpath = "//div[contains(@class, 'message-error')]")
    private WebElement messageError;

    private HeaderSection header;

    public LoginPage(WebDriver driver) {
        super(driver);
        header = new HeaderSection(driver);
        wait.until(ExpectedConditions.urlContains("login"));
    }

    public void loginAs(String user, String password) {
        waitForWebElementToBeVisible(emailInput);
        emailInput.clear();
        emailInput.sendKeys(user);
        passwordInput.sendKeys(password);

        waitForWebElementToBeEnabled(loginButton);
        loginButton.click();
    }

    public String getErrorMessage() {
        waitForWebElementToBeVisible(messageError);
        return messageError.getText();
    }

    public HeaderSection getHeader() {
        return header;
    }
}
