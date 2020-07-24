package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HomePageTest extends TestBase {

    private HomePage homePage;

    @BeforeEach
    void setUp() {
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }

    @Test
    void canNavigateToNOPCommerceFacebookPage() {
        homePage.getFooterSection().clickOnSocialLinkWithIndex(0);
        assertThat(driver.getCurrentUrl(), containsString("facebook"));

        homePage.getFooterSection().closeCurrentSocialTab();
        assertThat(driver.getCurrentUrl(), containsString("https://demo.nopcommerce.com/"));
    }

    @Test
    void canNavigateToSocialNetworkPages() {
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
