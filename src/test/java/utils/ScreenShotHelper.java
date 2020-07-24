package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import tests.TestBase;

import java.io.File;
import java.io.IOException;

public class ScreenShotHelper extends TestBase {

    public ScreenShotHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(
                    "output/screenshots/screenshot" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
