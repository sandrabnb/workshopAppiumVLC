package appium.helpers;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class Screenshooter {
    public static void takeScreenshot(AppiumDriver driver) {
        File file = driver.getScreenshotAs(OutputType.FILE);
        String timestamp = String.valueOf(System.currentTimeMillis());
        try {
            FileUtils.copyFile(file,
                    new File("screenshots/screenshot"+timestamp+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}