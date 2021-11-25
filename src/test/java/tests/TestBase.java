package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver;

    @BeforeEach
    public void baseSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterEach
    public void baseTearDown() {
        driver.quit();
    }
}
