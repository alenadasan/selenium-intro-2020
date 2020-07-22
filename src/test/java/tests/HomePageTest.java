package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomePageTest extends TestBase {

    @Test
    void canNavigateToSocialNetworkPages() {
        driver.get("https://demo.nopcommerce.com/");
        HomePage homePage = new HomePage(driver);

        List<String> expectedSocialLinks = Arrays.asList(
                "https://www.facebook.com/nopCommerce",
                "https://twitter.com/nopCommerce",
                "https://demo.nopcommerce.com/news/rss/1",
                "https://www.youtube.com/user/nopCommerce");

        for (int i = 0; i < 4; i++) {
            homePage.getFooterSection().clickOnSocialLinkWithIndex(i);

            assertThat(driver.getCurrentUrl(), is(expectedSocialLinks.get(i)));
            homePage.getFooterSection().closeCurrentSocialTab();
        }
    }
}
