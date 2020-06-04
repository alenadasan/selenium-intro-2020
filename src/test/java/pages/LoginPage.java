package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Password")
    private WebElement passwordInput;
    @FindBy(xpath = "//a[@href= '/passwordrecovery']")
    private WebElement passwordRecoveryLink;
    @FindBy(xpath = "//input[@class ='button-1 login-button']")
    private WebElement loginButton;

    @FindBy(id = "Email-error")
    private WebElement emailError;
    @FindBy(xpath = "//div[contains(@class, 'message-error')]")
    private WebElement messageError;

    private WebDriver driver;
    private HeaderSection header;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new HeaderSection(driver);
    }

    public void loginAs(String user, String password) {
        emailInput.clear();
        emailInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getEmailError() {
        return emailError.getText();
    }

    public HeaderSection getHeader() {
        return header;
    }
}
