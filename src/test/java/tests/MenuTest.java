package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class MenuTest extends TestBase {

    @Test
    void canAccessSubMenuItems() {
        driver.get("https://demo.nopcommerce.com/");
        HomePage homePage = new HomePage(driver);

        homePage.getHeaderSection().selectSubMenuItem("Electronics", "Cell phones");

        assertThat(driver.getCurrentUrl(), containsString("/cell-phones"));
    }
}
