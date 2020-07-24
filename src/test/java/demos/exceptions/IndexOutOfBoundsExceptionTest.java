package demos.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;
import static utils.Constants.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
@Disabled("just for demo purposes")
public class IndexOutOfBoundsExceptionTest extends TestBase {

    @Test
    public void canAccessThirdArrayElement() throws Exception {
        List<String> errorMessages = Arrays.asList("First error", "Second error");


        try {
            System.out.println(errorMessages.get(3));
        } catch (IndexOutOfBoundsException e) {
            fail("Expected this list to have 3 elements, but it only had 2");
        }
    }

    @Test
    public void canCheckSixthErrorMessage() throws Exception {
        driver.get(HOME_PAGE_URL);
        RegisterPage signUpPage = new RegisterPage(driver);
        signUpPage.selectGender("male");
        signUpPage.clickRegisterButton();

        assertThat(signUpPage.getAllErrorMessages().get(5), is("The Nickname field is required."));
    }
}
