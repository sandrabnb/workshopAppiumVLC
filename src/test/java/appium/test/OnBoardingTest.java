package appium.test;

import appium.helpers.Screenshooter;
import appium.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class OnBoardingTest extends BaseTest {

    public OnBoardingTest() throws MalformedURLException {

    }

    @Test
    public void fullOnboardingTest() {
        FirstOnboardingPage firstOnboardingPage = new FirstOnboardingPage(driver);
        Assert.assertTrue(firstOnboardingPage.isOnboardingImageShowing(), "OOPS! Image is not showing on first onboarding page");

        Assert.assertTrue(firstOnboardingPage.isTextShowing(), "OOPS! Text is not showing on first onboarding page");

        firstOnboardingPage.tapNextPageButton();

        SecondOnboardingPage secondOnboardingPage = new SecondOnboardingPage(driver);
        Assert.assertTrue(secondOnboardingPage.isOnboardingImageShowing(), "OOPS! Image is not showing on second onboarding page");
        Assert.assertTrue(secondOnboardingPage.isTextShowing(), "OOPS! Text is not showing on second onboarding page");

        secondOnboardingPage.tapNextPageButton();
        Screenshooter.takeScreenshot(driver);


        ThirdOnboardingPage thirdOnboardingPage = new ThirdOnboardingPage(driver);
        Assert.assertTrue(thirdOnboardingPage.isOnboardingImageShowing(), "OOPS! Text is not showing on third onboarding page");
        Assert.assertTrue(thirdOnboardingPage.isTextShowing(), "OOPS! Text is not showing on third onboarding page");

        thirdOnboardingPage.tapNextPageButton();

        FourthOnboardingPage fourthOnboardingPage = new FourthOnboardingPage(driver);
        Assert.assertTrue(fourthOnboardingPage.isOnboardingImageShowing(), "OOPS! Text is not showing on fourth onboarding page");
        Assert.assertTrue(fourthOnboardingPage.isTextShowing(), "OOPS! Text is not showing on fourth onboarding page");

        Assert.assertTrue(fourthOnboardingPage.isUsageButtonShowing());

        Screenshooter.takeScreenshot(driver);


    }
}
