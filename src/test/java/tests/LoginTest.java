package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.RegistrationResultPage;
import utils.ScreenShotHelper;

import java.util.UUID;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static utils.Constants.*;

public class LoginTest extends TestBase {

    @BeforeEach
    public void setUp() {
        driver.manage().window().maximize();
    }

    @Test
    public void validUserCanLogin() {
        driver.get(HOME_PAGE_URL + "login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(TEST_EMAIL, TEST_PASSWORD);
        AccountPage accountPage = loginPage.getHeader().clickMyAccount();

        assertThat(accountPage.getFirstName(), is("Dummy"));
    }

    @Test
    public void newlyCreatedUserCanLogin() {
        String email = UUID.randomUUID().toString().substring(0, 16) + "@mailnesia.com";
        String password = "123456";

        driver.get(HOME_PAGE_URL + "register");

        RegisterPage registerPage = new RegisterPage(driver);
        RegistrationResultPage resultPage = registerPage.registerAs("male", "Dummy", "Johnson",
                "12", "January", "1989", email, "Food Inc.",
                password, password);

        assumeTrue(resultPage.getResult().equals("Your registration completed"));
        new ScreenShotHelper(driver).takeScreenshot();
        resultPage.getHeader().logOut();

        LoginPage loginPage = resultPage.getHeader().goToLogInPage();
        loginPage.loginAs(email, password);
        loginPage.getHeader().clickMyAccount();
        AccountPage account = new AccountPage(driver);

        assertThat(account.getFirstName(), is("Dummy"));
    }

    @Test
    public void newlyCreatedTestUserCanLogin() {
        driver.get(HOME_PAGE_URL + "register");

        RegisterPage registerPage = new RegisterPage(driver);
        RegistrationResultPage resultPage = registerPage.registerAs("male", "Dummy", "Johnson",
                "12", "January", "1989", TEST_EMAIL, "Food Inc.",
                TEST_PASSWORD, TEST_PASSWORD);

        assumeTrue(resultPage.getResult().equals("Your registration completed"));
        resultPage.getHeader().logOut();

        LoginPage loginPage = resultPage.getHeader().goToLogInPage();
        loginPage.loginAs(TEST_EMAIL, TEST_PASSWORD);
        loginPage.getHeader().clickMyAccount();
        AccountPage account = new AccountPage(driver);

        assertThat(account.getFirstName(), is("Dummy"));
    }

    @ParameterizedTest
    @MethodSource("credentialsAndErrorMessagesProvider")
    public void cannotLoginWithInvalidCredentials(String email, String pass, String expectedError) {
        driver.get(HOME_PAGE_URL + "login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, pass);

        assertThat(loginPage.getErrorMessage(), is(expectedError));
    }

    static Stream<Arguments> credentialsAndErrorMessagesProvider() {
        return Stream.of(
                arguments(TEST_EMAIL, "wrongPass", "Login was unsuccessful. Please correct the errors and try again." +
                        "\nThe credentials provided are incorrect"),
                arguments("wrongEmail@mailensia.com", "pass", "Login was unsuccessful. Please correct the errors and try again." +
                        "\nNo customer account found"),
                arguments(TEST_EMAIL, "", "Login was unsuccessful. Please correct the errors and try again." +
                        "\nThe credentials provided are incorrect")
        );
    }
}
