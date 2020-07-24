package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");

        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
    }

    @AfterEach
    public void baseTearDown() {
        driver.quit();
    }
}
