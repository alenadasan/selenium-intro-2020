package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.EmailPage;
import pages.ProductPage;

import static utils.Constants.HOME_PAGE_URL;

public class CookiesConsentTest extends TestBase {

    @Disabled("work in progress")
    @Test
    public void canSwitchToIFrameAndAcceptCookies() {
        driver.get(HOME_PAGE_URL + "elegant-gemstone-necklace-rental");

        ProductPage productPage = new ProductPage(driver);
        EmailPage emailPage = productPage.clickEmailIconAndSwitchToEmailPage();

        emailPage.switchToCookiesConsent();
//        TODO: finish test
    }
}
