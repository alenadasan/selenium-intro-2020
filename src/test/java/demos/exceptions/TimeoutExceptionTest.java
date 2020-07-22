package demos.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import tests.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Ale on 07/08/17.
 */
@Disabled("just for demo purposes")
public class TimeoutExceptionTest extends TestBase {

    @Test
    public void canCheckErrorMessage()  {
        driver.get("https://demo.nopcommerce.com/login");
        LoginPage loginPage = new LoginPage(driver);

        assertThat(loginPage.getErrorMessage(), is("Doesn't matter, error message not displayed"));
    }
}
