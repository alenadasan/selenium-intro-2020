package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class SearchTest extends TestBase{

    @Test
    void canSearchForAValidProduct() {
        driver.get("https://demo.nopcommerce.com/");
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.getHeaderSection().searchFor("dtdsad");

        assertThat(resultsPage.getWarningMessage(), is("No products were found that matched your criteria."));
    }

    @Test
    void canSearchForAValidProductName() {
        driver.get("https://demo.nopcommerce.com/");
        HomePage homePage = new HomePage(driver);
        SearchResultsPage resultsPage = homePage.getHeaderSection().searchFor("book");

        assertThat(resultsPage.getSearchResults().size(), greaterThan(0));
    }

    @Test
    void whenEnteringAnEmptyQuery_anAlertIsDisplayed() {
//    setup
//    go to HomePage
//    hp.getHeader().searchFor("")
//    assert hp.getHeader().getMessageFromAlert(), is("Please enter...")
//    teardown

    }

}
