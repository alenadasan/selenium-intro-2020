package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Constants.HOME_PAGE_URL;

public class MenuTest extends TestBase {

    @Test
    void canAccessSubMenuItems() {
        driver.get(HOME_PAGE_URL);
        HomePage homePage = new HomePage(driver);

        homePage.getHeaderSection().selectSubMenuItem("Electronics", "Cell phones");

        assertThat(driver.getCurrentUrl(), containsString("/cell-phones"));
    }
}
