package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    @FindBy(name = "Gender")
    private List<WebElement> genderRadioButtons;
    @FindBy(id = "FirstName")
    private WebElement firstNameInput;
    @FindBy(id = "LastName")
    private WebElement lastNameInput;
    @FindBy(name = "DateOfBirthDay")
    private WebElement daySelector;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement monthSelector;
    @FindBy(name = "DateOfBirthYear")
    private WebElement yearSelector;

    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Company")
    private WebElement companyInput;
    @FindBy(id = "Newsletter")
    private WebElement newsletterBox;

    @FindBy(id = "Password")
    private WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "field-validation-error")
    private List<WebElement> listOfAllErrorMessages;

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationResultPage registerAs(String firstName, String lastName,
                                             String day, String month, String year,
                                             String email, String company,
                                             String password, String confirmPassword) {

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        selectOptionFromDropdownDay(day);
        selectOptionFromDropdownMonth(month);
        selectOptionFromDropdownYear(year);
        emailInput.sendKeys(email);
        companyInput.sendKeys(company);
        newsletterBox.click();
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        registerButton.click();

        return new RegistrationResultPage(driver);
    }

    public void selectGender(String gender) {

        if (gender.equals("male")) {
            genderRadioButtons.get(0).click();
        } else genderRadioButtons.get(1).click();
    }


    public void selectOptionFromDropdownDay(String option) {
        Select dateDaySelector = new Select(daySelector);
        dateDaySelector.selectByVisibleText(option);
    }

    public void selectOptionFromDropdownMonth(String option) {
        Select dateMonthSelector = new Select(monthSelector);
        dateMonthSelector.selectByVisibleText(option);
    }

    public void selectOptionFromDropdownYear(String option) {
        Select dateYearSelector = new Select(yearSelector);
        dateYearSelector.selectByVisibleText(option);
    }

    public List<String> getAllErrorMessages() {
        List<String> messages = new ArrayList<String>();
        for (WebElement e : listOfAllErrorMessages) {
            messages.add(e.getText());
        }
        return messages;
    }
}
