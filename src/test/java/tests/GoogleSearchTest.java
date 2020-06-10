package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchTest {

    @Test
    public void canSearchForAValidKeyword() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ale/workspace/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);

        searchPage.searchFor("pinata");

        assertThat(driver.getTitle(), containsString("pinata"));

        driver.quit();
    }
}
