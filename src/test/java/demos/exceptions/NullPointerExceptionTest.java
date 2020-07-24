package demos.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static utils.Constants.HOME_PAGE_URL;

/**
 * Created by Ale on 07/08/17.
 */
@Disabled("just for demo purposes")
public class NullPointerExceptionTest {


    private WebDriver driver;
    private String str;
    private String str2;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Ale/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void canNavigateToLoginPage() {
        driver.get(HOME_PAGE_URL + "login/");
    }

    @Test
    public void canCallSubstringOnAString() throws Exception {
        System.out.println(str.substring(0, 1) + str2);
    }
}
