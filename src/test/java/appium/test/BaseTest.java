package appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AppiumDriver driver = null;
    private URL appiumServerURL = new URL ("http://localhost:4723/wd/hub");
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String runningPath = System.getProperty("user.dir");
    private String appPathAndroid = runningPath + "/apps/app-alpha-debug.apk";
    private String appPathIOS = runningPath + "";

    public BaseTest() throws MalformedURLException {
    }




    public void createDriver(String platformName, String udid, String platformVersion) {
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability(MobileCapabilityType.APP, appPathAndroid);

        /* Note: Full reset forces app to uninstall and install again.
           By default, only clears cache, but it doesn't unisntall-intall the app.
           This might take longer.
         */
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);

        //Create driver depending on the platform
        if(platformName.equals("android")) {
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wikipedia.onboarding.InitialOnboardingActivity");
            driver = new AndroidDriver(appiumServerURL, capabilities);
            capabilities.setCapability(MobileCapabilityType.APP, appPathAndroid);
        }
        else if (platformName.equals("ios")) {
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);
            driver = new IOSDriver(appiumServerURL, capabilities);
            capabilities.setCapability(MobileCapabilityType.APP, appPathIOS);
        } else {
            System.out.println("OOOPS, something bad happened with the platform name");
        }
        //Timeout by default is 15sec, we lower it to 5 to not take so long to fail the tests
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Use this if you don't want to run Appium GUI (when this is on the server)
        //AppiumServerChecker.startAppiumServer(appiumServerURL);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters( {"platform", "udid", "platformVersion"} )
    public void setup(@Optional("android") String platformName,
                      @Optional("S9") String udid,
                      @Optional("9") String platformVersion) {
        createDriver(platformName, udid, platformVersion);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }



}
