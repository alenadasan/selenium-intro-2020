package demos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

public class CrossBrowserParametrizedTest {

    @ParameterizedTest
    @MethodSource("drivers")
    void crossBrowserTest(WebDriver driver) {
        System.out.println("Test with " + driver.getClass().getSimpleName());

        driver.quit();
    }

    public static Stream<WebDriver> drivers() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ale/workspace/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");

        return Stream.of(new ChromeDriver(), new FirefoxDriver());
    }
}
