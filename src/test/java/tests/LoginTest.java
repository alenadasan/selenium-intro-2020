package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.RegistrationResultPage;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class LoginTest extends TestBase {

    @BeforeEach
    public void setUp() {
        driver.manage().window().maximize();
    }

    @Test
    public void validUserCanLogin() {
        driver.get("https://demo.nopcommerce.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("rali@mailnesia.com", "123456");
        AccountPage accountPage = loginPage.getHeader().clickMyAccount();

        assertThat(accountPage.getFirstName(), is("Rali"));
    }

    @Test
    public void newlyCreatedUserCanLogin() {
        String email = UUID.randomUUID().toString().substring(0, 16) + "@mailnesia.com";
        System.out.println(email);
        String password = "123456";

        driver.get("https://demo.nopcommerce.com/register");

        RegisterPage registerPage = new RegisterPage(driver);
        RegistrationResultPage resultPage = registerPage.registerAs("male", "Dummy", "Johnson",
                "12", "January", "1989", email, "Food Inc.",
                password, password);

        assumeTrue(resultPage.getResult().equals("Your registration completed"));
        resultPage.getHeader().logOut();

        LoginPage loginPage = resultPage.getHeader().goToLogInPage();
        loginPage.loginAs(email, password);
        loginPage.getHeader().clickMyAccount();
        AccountPage account = new AccountPage(driver);

        assertThat(account.getFirstName(), is("Dummy"));
    }
}
