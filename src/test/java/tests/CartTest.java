package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTest extends TestBase {

    @Test
    void canAddAProductToCart() {
        driver.get("https://demo.nopcommerce.com/");
        HomePage homePage = new HomePage(driver);

        homePage.addToCartProductWithIndex(2);

        assertThat(homePage.getHeaderSection().getCartCounterMessage(), is("There are 1 item(s) in your cart."));
    }
}
