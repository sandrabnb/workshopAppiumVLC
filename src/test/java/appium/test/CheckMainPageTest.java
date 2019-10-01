package appium.test;

import appium.pageobjects.FirstOnboardingPage;
import appium.pageobjects.MainPage;
import autovalue.shaded.com.google$.common.annotations.$VisibleForTesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class  CheckMainPageTest extends BaseTest {

    public CheckMainPageTest() throws MalformedURLException {
    }

    @Test
    public void checkMainPageTest() {

        MainPage mainPage = new FirstOnboardingPage(driver).tapSkipButton();

        Assert.assertTrue(mainPage.isSearchShowing(), "OOPS! Search is not showing on Main Page");
    }


}
