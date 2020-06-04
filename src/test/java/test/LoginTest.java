package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.RegistrationResultPage;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class LoginTest {

    @Test
    public void validUserCanLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ale/workspace/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("rali@mailnesia.com", "123456");
        AccountPage accountPage = loginPage.getHeader().clickMyAccount();

        assertThat(accountPage.getFirstName(), is("Rali"));

        driver.quit();
    }

    @Test
    public void newlyCreatedUserCanLogin() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ale/workspace/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/register");

        String email = UUID.randomUUID().toString() + "@mailnesia.com";
        String password = "123456";

        RegisterPage registerPage = new RegisterPage(driver);
        RegistrationResultPage resultPage = registerPage.registerAs("Dummy", "Johnson",
                "12", "January", "1989", email, "Food Inc.",
                password, password);

        assumeTrue(resultPage.getResult().equals("Your registration completed"));
        resultPage.getHeader().logOut();

        LoginPage loginPage = resultPage.getHeader().goToLogInPage();
        loginPage.loginAs(email, password);
        loginPage.getHeader().clickMyAccount();
        AccountPage account = new AccountPage(driver);

        assertThat(account.getFirstName(), is("Dummy"));

        driver.quit();
    }
}
