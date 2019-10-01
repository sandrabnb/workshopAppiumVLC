package appium.helpers;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.net.UrlChecker;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServerChecker {
    public static AppiumDriverLocalService service = null;

    //Note: This is Android only
    public static void startAppiumServerWithEmulator(String emulator) {
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
        .withArgument(()-> "--avd", emulator));

        service.start();
    }

    public static void startAppiumServer(URL appiumServerURL) {
        try {
            if(!isAppiumRunning(appiumServerURL)) {
                service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
                service.start();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /*
        Problem with this: since Appium is running inside your code, the appium logs are
        going to be shown inside your code, and therefore it will all be mixed up and you don't
        know what's going on.
     */
    public static boolean isAppiumRunning(URL appiumServerURL) throws Exception {
        final URL url = new URL(appiumServerURL+"/sessions");
        try {
            new UrlChecker().waitUntilAvailable(300, TimeUnit.MILLISECONDS, url);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
