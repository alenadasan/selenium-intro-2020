package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.EmailPage;
import pages.ProductPage;

public class CookiesConsentTest extends TestBase {

    @Disabled("work in progress")
    @Test
    public void canSwitchToIFrameAndAcceptCookies() {
        driver.get("https://demo.nopcommerce.com/elegant-gemstone-necklace-rental");

        ProductPage productPage = new ProductPage(driver);
        EmailPage emailPage = productPage.clickEmailIconAndSwitchToEmailPage();

        emailPage.switchToCookiesConsent();
//        TODO: finish test
    }
}
