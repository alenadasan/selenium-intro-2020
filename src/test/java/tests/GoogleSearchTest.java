package tests;

import org.junit.jupiter.api.Test;
import pages.GoogleSearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchTest extends TestBase {

    @Test
    public void canSearchForAValidKeyword() {
        driver.get("https://google.com/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);

        searchPage.searchFor("pinata");

        assertThat(driver.getTitle(), containsString("pinata"));
    }
}
