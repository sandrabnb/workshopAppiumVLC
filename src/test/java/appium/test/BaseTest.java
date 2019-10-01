package appium.test;

import appium.helpers.AppiumServerChecker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AppiumDriver driver = null;
    private URL appiumServerURL = new URL ("http://localhost:4723/wd/hub");
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String runningPath = System.getProperty("user.dir");
    private String appPath = runningPath + "/apps/app-alpha-debug.apk";

    public BaseTest() throws MalformedURLException {
    }




    public void createDriver() {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "phone");
        capabilities.setCapability(MobileCapabilityType.APP, appPath);

        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wikipedia.onboarding.InitialOnboardingActivity");

        //Use this if you don't want to run Appium GUI (when this is on the server)
        //AppiumServerChecker.startAppiumServer(appiumServerURL);
        driver = new AndroidDriver(appiumServerURL, capabilities);
    }

    @BeforeMethod
    public void setup() {
        createDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}