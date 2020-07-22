package pages;

import builders.ContactInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContactPage extends PageBase {

    @FindBy(id = "FullName")
    private WebElement fullNameInput;
    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Enquiry")
    private WebElement enquiryInput;

    @FindBy(name = "send-email")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//span[contains(@id, \"-error\")]")
    private List<WebElement> errorMessages;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void fillContactUs(String name, String email, String enquiry) {
        fillInName(name);
        fillInEmail(email);
        fillInEnquiry(enquiry);
        clickSubmit();
    }

    public void fillContactUs(ContactInfo contactInfo) {
        fillInName(contactInfo.getName());
        fillInEmail(contactInfo.getEmail());
        fillInEnquiry(contactInfo.getEnquiry());

        clickSubmit();
    }

    public void fillInName(String newFullName) {
        fullNameInput.clear();
        fullNameInput.sendKeys(newFullName);
    }
    public void fillInEmail(String newEmail) {
        emailInput.clear();
        emailInput.sendKeys(newEmail);
    }
    public void fillInEnquiry(String newEnquiry) {
        enquiryInput.clear();
        enquiryInput.sendKeys(newEnquiry);
    }
    public void clickSubmit() {
        sendEmailButton.click();
    }

    public List<String> getErrorMessages() {
        List<String> messages = new ArrayList<String>();
        for (WebElement e : errorMessages) {
            messages.add(e.getText());
        }
        return messages;
    }
}
