package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    public WebDriver driver;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/Ale/workspace/geckodriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);


//        driver = new FirefoxDriver();

//        TODO:  33 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// 34 //copying the file into /screenshots directory
// 35 FileUtils.copyFile(scrFile, new File("output/screenshots/homepage.png"));
// 36
    }

    @AfterEach
    public void baseTearDown() {
        driver.quit();
    }
}
