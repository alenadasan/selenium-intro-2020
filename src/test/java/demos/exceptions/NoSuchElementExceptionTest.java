package demos.exceptions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Ale on 07/08/17.
 */
@Disabled("just for demo purposes")
public class NoSuchElementExceptionTest extends TestBase {

    @Test
    public void canFillInPasswordField() throws Exception {
        driver.get("http://demo.nopcommerce.com");

        assertThat(driver.findElement(By.id("fakeID")).isDisplayed(), is(true));
    }
}
